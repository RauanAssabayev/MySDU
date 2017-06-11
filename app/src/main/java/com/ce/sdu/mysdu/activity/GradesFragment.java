package com.ce.sdu.mysdu.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.ce.sdu.mysdu.API.API;
import com.ce.sdu.mysdu.API.APIClient;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.adapter.CoursesAdapter;
import com.ce.sdu.mysdu.adapter.MessagesAdapter;
import com.ce.sdu.mysdu.model.Courses;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static android.content.Context.MODE_PRIVATE;

public class GradesFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Courses> data;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String login = "login";
    public static final String sclass = "class";
    public static final String password = "password";
    SharedPreferences prefs;
    public GradesFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grades, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prefs = getActivity().getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinnerTerm);
        spinner.setOnItemSelectedListener(this);
        int studClass = prefs.getInt(sclass,0);
        List<String> categories = new ArrayList<String>();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for(int i = studClass; i>0; i--){
            year = year - 1;
            categories.add(year+"|"+2);
            categories.add(year+"|"+1);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.spinner_row, R.id.weekofday, categories);
        spinner.setAdapter(dataAdapter);
        setGrades(year+studClass-1,2);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }
    @Override
    public void onDetach() {
        super.onDetach();
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int term = 1;
        if(position%2 == 0){
            term = 2;
        }
        year = year - 1;
        position = position/2;
        setGrades(year-position,term);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void setGrades(int pyear,int pterm){
        int stud_id = prefs.getInt("login",0);
        String stud_pass = prefs.getString("password","empty");
        String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", stud_id, stud_pass).getBytes(), Base64.NO_WRAP);
        API api = APIClient.getClient().create(API.class);
        if (isNetworkConnected()) {
            Call<List<Courses>> call = api.getCoursesData(basicAuth,pyear+"",pterm+"");
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    List<Courses> courses = (List<Courses>) response.body();
                    recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
                    recyclerView.setHasFixedSize(true);
                    layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    data = new ArrayList<Courses>();
                    for (int i = 0; i < courses.size(); i++) {
                        data.add(courses.get(i));
                        adapter = new CoursesAdapter(data);
                        recyclerView.setAdapter(adapter);
                    }
                }
                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(getActivity().getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity().getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                    Log.d("KEYY", "onFailure: "+t.toString());
                    call.cancel();
                }
            });
        }else{
            Toast.makeText(getContext(), "You need internet conncetion",Toast.LENGTH_LONG).show();
        }
    }
}