package com.ce.sdu.mysdu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ce.sdu.mysdu.API.API;
import com.ce.sdu.mysdu.API.APIClient;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.model.Student;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rauan on 11.04.2017.
 */

public class FragmentLogin extends Fragment {
    EditText loginForm, passwordForm;
    Button signInButton;

    View.OnClickListener singin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", loginForm.getText().toString(), passwordForm.getText().toString()).getBytes(), Base64.NO_WRAP);
            API api = APIClient.getClient().create(API.class);
            Call<Student> call = api.getStudentData(basicAuth);
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    Student student = (Student) response.body();
                    Toast.makeText(getActivity().getApplicationContext(), student.getmName() + "-" + student.getmSurname(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity().getApplicationContext(), student.getmDEP_ID_QEYD() + "-" + student.getmSurname(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity().getApplicationContext(), student.getmNameNative() + "-" + student.getmPatronymic(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getContext(), "second", Toast.LENGTH_SHORT).show();
                    Fragment fragment = new TimeTableFragment();
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, fragment);
                    fragmentTransaction.commit();
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(getActivity().getApplicationContext(), "Login or password incorrect ", Toast.LENGTH_LONG).show();
                    call.cancel();
                }
            });
        }
    };

    public FragmentLogin() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_form, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signInButton = (Button) view.findViewById(R.id.signInButtton);
        loginForm = (EditText) view.findViewById(R.id.sduIdInput);
        passwordForm = (EditText) view.findViewById(R.id.passwordinput);
        signInButton.setOnClickListener(singin);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}