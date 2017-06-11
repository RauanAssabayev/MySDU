package com.ce.sdu.mysdu.activity;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.ce.sdu.mysdu.API.API;
import com.ce.sdu.mysdu.API.APIClient;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.adapter.CoursesAdapter;
import com.ce.sdu.mysdu.adapter.TimeTableAdapter;
import com.ce.sdu.mysdu.data.Courses;
import com.ce.sdu.mysdu.model.DataModel;
import com.ce.sdu.mysdu.model.Timetable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static android.content.Context.MODE_PRIVATE;
public class TimeTableFragment extends Fragment {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    FloatingActionButton addbtn;
    private static ArrayList<Integer> removedItems;
    public static final String MyPREFERENCES = "MyPrefs" ;
    private static ArrayList<com.ce.sdu.mysdu.model.RegCourses> data;
    private int week [] = {R.id.mo,R.id.tu,R.id.we,R.id.th,R.id.fr};
    private String weekdays [] = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
    public TimeTableFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_timetable, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addbtn = (FloatingActionButton) getActivity().findViewById(R.id.addbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"BTN",Toast.LENGTH_LONG).show();
            }
        });
        getCurData();
        TextView curday = (TextView) getActivity().findViewById(week[getCurData()-1]);
        TextView curdayTtitle = (TextView) getActivity().findViewById(R.id.weekday);
        curdayTtitle.setText(weekdays[getCurData()-1]);
        curday.setTextColor(Color.rgb(38,38,38));
        addCourse();
    }

    public void addCourse() {
        SharedPreferences prefs = getActivity().getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        int stud_id = prefs.getInt("login", 0);
        String stud_pass = prefs.getString("password", "empty");
        String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", stud_id, stud_pass).getBytes(), Base64.NO_WRAP);
        API api = APIClient.getClient().create(API.class);
        if (isNetworkConnected()) {
            Call<List<com.ce.sdu.mysdu.model.RegCourses>> call = api.getRegCoursesData(basicAuth, 2016 + "", 2 + "");
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    List<com.ce.sdu.mysdu.model.RegCourses> courses = (List<com.ce.sdu.mysdu.model.RegCourses>) response.body();
                    recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
                    recyclerView.setHasFixedSize(true);
                    layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    data = new ArrayList<com.ce.sdu.mysdu.model.RegCourses>();
                    for (int i = 0; i < courses.size(); i++) {
                        data.add(courses.get(i));
                        adapter = new TimeTableAdapter(data);
                        recyclerView.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.d("KEYY", "onFailure: " + t.toString());
                    call.cancel();
                }
            });
        } else {
            Toast.makeText(getContext(), "You need internet conncetion", Toast.LENGTH_LONG).show();
        }
    }

    public void saveCourses(){
        SharedPreferences prefs = getActivity().getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        int stud_id = prefs.getInt("login",0);
        String stud_pass = prefs.getString("password","empty");
        String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", stud_id, stud_pass).getBytes(), Base64.NO_WRAP);
        API api = APIClient.getClient().create(API.class);
        if (isNetworkConnected()) {
            Call<List<com.ce.sdu.mysdu.model.RegCourses>> call = api.getRegCoursesData(basicAuth,2016+"",2+"");
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    List<com.ce.sdu.mysdu.model.RegCourses> courses = (List<com.ce.sdu.mysdu.model.RegCourses>) response.body();
                    recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
                    recyclerView.setHasFixedSize(true);
                    layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    data = new ArrayList<com.ce.sdu.mysdu.model.RegCourses>();
                    for (int i = 0; i < courses.size(); i++) {
                        data.add(courses.get(i));
                        adapter = new TimeTableAdapter(data);
                        recyclerView.setAdapter(adapter);

                    }
                }
                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.d("KEYY", "onFailure: "+t.toString());
                    call.cancel();
                }
            });
        }else{
            Toast.makeText(getContext(), "You need internet conncetion",Toast.LENGTH_LONG).show();
        }

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

    public int getCurData(){
        Date date=new Date();
        String data=date.toString();
        switch (data.substring(0,3))
        {
            case "Mon":return 1;
            case "Tue":return 2;
            case "Wed":return 3;
            case "Thu":return 4;
            case "Fri":return 5;
            case "Sat":return 1;
            case "Sun":return 1;
            default:return 1;
        }
    }
}