package com.ce.sdu.mysdu.API;

import com.ce.sdu.mysdu.model.Grades;
import com.ce.sdu.mysdu.model.Message;
import com.ce.sdu.mysdu.model.Student;
import com.ce.sdu.mysdu.model.Timetable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by yeldar on 4/22/17.
 */

public interface API {
    @GET("myapi/v1/index.php/students")
    Call<Student> getStudentData(
            @Header("Authorization") String basicAuthorization
    );

    @GET("myapi/v1/index.php/courses/{year}/{term}")
    Call<Grades> getGradesData(
            @Header("Authorization") String basicAuthorization
    );

    @GET("myapi/v1/index.php/grades/{}/{}")
    Call<Timetable> getTimeTableData(
            @Header("Authorization") String basicAuthorization
    );

    @GET("myapi/v1/index.php/messages/last")
    Call<Message> getMessagesData(
            @Header("Authorization") String basicAuthorization
    );
}
