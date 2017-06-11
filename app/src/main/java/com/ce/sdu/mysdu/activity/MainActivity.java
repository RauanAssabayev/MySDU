package com.ce.sdu.mysdu.activity;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ce.sdu.mysdu.API.API;
import com.ce.sdu.mysdu.API.APIClient;
import com.ce.sdu.mysdu.Extra.CircleTransform;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.model.Student;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {
    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String name = "name";
    public static final String surname = "surname";
    public static final String login = "login";
    public static final String sclass = "class";
    public static final String password = "password";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (FragmentDrawer)getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        int stud_id = prefs.getInt("login",0);
        String stud_pass = prefs.getString("password","empty");
        if(stud_id == 0){
            displayView(15);
        }else {
            final String basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", stud_id, stud_pass).getBytes(), Base64.NO_WRAP);
            API api = APIClient.getClient().create(API.class);
            Call<Student> call = api.getStudentData(basicAuth);

            if (isNetworkConnected()) {
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        final Student student = (Student) response.body();
                        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
                        TextView tvfio = (TextView) drawerFragment.getActivity().findViewById(R.id.fio);
                        TextView tvsclass = (TextView) drawerFragment.getActivity().findViewById(R.id.group);
                        ImageView prof = (ImageView) drawerFragment.getActivity().findViewById(R.id.prof);
                        String fullname = student.getmName() + " " + student.getmSurname();
                        int studnent_class = student.getmClass();
                        tvfio.setText(fullname);
                        tvsclass.setText(studnent_class + " class");
                        Picasso.with(drawerFragment.getActivity().getApplicationContext()).load("http://10.100.1.132/myapi/v1/index.php/profilephoto/" + student.getmStudentID()).transform(new CircleTransform()).into(prof);
                        Fragment fragment = new TimeTableFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container_body, fragment);
                        fragmentTransaction.commit();
                    }
                    @Override
                    public void onFailure(Call call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Connection error ", Toast.LENGTH_LONG).show();
                        call.cancel();
                    }
                });
            }
        }
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }
    public void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new TimeTableFragment();
                title = getString(R.string.title_timetable);
                break;
            case 1:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 2:
                fragment = new GradesFragment();
                title = getString(R.string.title_grades);
                break;
            case 3:
                fragment = new MessagesFragment();
                title = getString(R.string.title_messages);
                break;
            case 4:
                fragment = new LoginFragment();
                title = getString(R.string.title_login);
                break;
            case 15:
                fragment = new LoginFragment();
                title = getString(R.string.title_login);
                break;
            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }
    }
}