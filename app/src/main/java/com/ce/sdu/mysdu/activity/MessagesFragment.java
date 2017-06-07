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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ce.sdu.mysdu.API.API;
import com.ce.sdu.mysdu.API.APIClient;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.adapter.GradesAdapter;
import com.ce.sdu.mysdu.adapter.MessagesAdapter;
import com.ce.sdu.mysdu.data.Grades;
import com.ce.sdu.mysdu.model.GradesModel;
import com.ce.sdu.mysdu.model.Message;
import com.ce.sdu.mysdu.model.Timetable;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;
import static android.support.v7.recyclerview.R.attr.layoutManager;

/**
 * Created by Rauan on 07/02/17.
 */
public class MessagesFragment extends Fragment {
    TextView message_text;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<Message> data;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public MessagesFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_messages, container, false);
        return rootView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        message_text = (TextView) getActivity().findViewById(R.id.message_text);
        SharedPreferences prefs = getActivity().getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        int stud_id = prefs.getInt("login",0);
        String stud_pass = prefs.getString("password","empty");
        String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", stud_id, stud_pass).getBytes(), Base64.NO_WRAP);
        API api = APIClient.getClient().create(API.class);
        Call<Message> call = api.getMessagesData(basicAuth);
        if (isNetworkConnected()) {
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    Message message = (Message) response.body();
                    Toast.makeText(getActivity().getApplicationContext(), message.getSubject(),Toast.LENGTH_LONG).show();
                    message_text.setText(message.getSubject());
                }
                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(getActivity().getApplicationContext(), "Failed to load data!!!", Toast.LENGTH_LONG).show();
                    call.cancel();
                }
            });
        }else{
            Toast.makeText(getContext(), "You need internet conncetion",Toast.LENGTH_LONG).show();
        }

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<Message>();
//        for (int i = 0; i < Grades.nameArray.length; i++) {
//            data.add(new Message(
//                    Grades.nameArray[i],
//                    Grades.versionArray[i],
//                    Grades.id_[i]
//            ));
//        }
        adapter = new MessagesAdapter(data);
        recyclerView.setAdapter(adapter);

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
}
