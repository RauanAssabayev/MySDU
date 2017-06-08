package com.ce.sdu.mysdu.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.ce.sdu.mysdu.API.API;
import com.ce.sdu.mysdu.API.APIClient;
import com.ce.sdu.mysdu.Extra.CircleTransform;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.model.Student;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by rauan on 11.04.2017.
 */

public class LoginFragment extends Fragment {
    EditText loginForm, passwordForm;
    Button signInButton;
    private FragmentDrawer drawerFragment;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String name = "name";
    public static final String surname = "surname";
    public static final String login = "login";
    public static final String sclass = "class";
    public static final String password = "password";
    SharedPreferences sharedpreferences;
    View.OnClickListener singin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String stud_id = loginForm.getText().toString();
            final String stud_pass = md5(passwordForm.getText().toString());
            final String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", stud_id, stud_pass).getBytes(), Base64.NO_WRAP);
            API api = APIClient.getClient().create(API.class);

            Call<Student> call = api.getStudentData(basicAuth);
            if (isNetworkConnected()) {
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        final Student student = (Student) response.body();
                        sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, getContext().MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(name, student.getmName());
                        editor.putString(surname, student.getmSurname());
                        editor.putInt(sclass, student.getmClass());
                        editor.putInt(login, student.getmStudentID());
                        editor.putString(password, student.getmPassword());
                        editor.commit();
                        drawerFragment = (FragmentDrawer)getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
                        TextView tvfio    = (TextView)drawerFragment.getActivity().findViewById(R.id.fio);
                        TextView tvsclass = (TextView)drawerFragment.getActivity().findViewById(R.id.group);
                        ImageView prof = (ImageView)drawerFragment.getActivity().findViewById(R.id.prof);
                        String fullname = student.getmName() + " " + student.getmSurname();
                        int studnent_class = student.getmClass();
                        tvfio.setText(fullname);
                        tvsclass.setText(studnent_class+" class");
                        Picasso.with(drawerFragment.getActivity().getApplicationContext()).load("http://10.100.1.132/myapi/v1/index.php/profilephoto/"+stud_id).transform(new CircleTransform()).into(prof);
                        Fragment fragment = new TimeTableFragment();
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_body, fragment);
                        fragmentTransaction.commit();

                    }
                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(getActivity().getApplicationContext(), "Connection error ", Toast.LENGTH_LONG).show();
                        call.cancel();
                    }
                });
            }else{
                Toast.makeText(getContext(), "You need internet conncetion",Toast.LENGTH_LONG).show();
            }
        }
    };
    public LoginFragment() {}

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

    public String md5(String s) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(s.getBytes(Charset.forName("US-ASCII")), 0, s.length());
            byte[] magnitude = digest.digest();
            BigInteger bi = new BigInteger(1, magnitude);
            String hash = String.format("%0" + (magnitude.length << 1) + "x", bi);
            return hash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}