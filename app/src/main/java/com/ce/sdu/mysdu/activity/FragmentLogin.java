package com.ce.sdu.mysdu.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ce.sdu.mysdu.R;

/**
 * Created by rauan on 11.04.2017.
 */



public class FragmentLogin extends Fragment {
    String login = "130107035";
    String password = "asabaev123";

    EditText loginForm,passwordForm;
    Button signInButton;
    View.OnClickListener singin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(),loginForm.getText().toString()+"-"+passwordForm.getText().toString(),Toast.LENGTH_SHORT).show();
            if((loginForm.getText().toString().equals(login)) && (passwordForm.getText().toString().equals(password))){
                Toast.makeText(getContext(),"second",Toast.LENGTH_SHORT).show();
                Fragment fragment = new TimeTableFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_body, fragment);
                fragmentTransaction.commit();
            }
        }
    };
    public FragmentLogin() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_form, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        signInButton = (Button)   view.findViewById(R.id.signInButtton);
        loginForm    = (EditText) view.findViewById(R.id.sduIdInput);
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