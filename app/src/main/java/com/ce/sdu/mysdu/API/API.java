package com.ce.sdu.mysdu.API;

import com.ce.sdu.mysdu.model.Courses;
import com.ce.sdu.mysdu.model.Grades;
import com.ce.sdu.mysdu.model.Message;
import com.ce.sdu.mysdu.model.Student;
import com.ce.sdu.mysdu.model.Timetable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by yeldar on 4/22/17.
 */

public interface API {
    @GET("myapi/v1/index.php/students")
    Call<Student> getStudentData(@Header("Authorization") String basicAuthorization);
    @GET("myapi/v1/index.php/messages")
    Call<List<Message>> getMessagesData(@Header("Authorization") String basicAuthorization);

    @GET("myapi/v1/index.php/courses/{year}/{term}")
    Call<List<Courses>>  getCoursesData(
            @Header("Authorization") String basicAuthorization,
            @Path("year") String year,
            @Path("term") String term
    );

    @GET("myapi/v1/index.php/grades/{year}/{term}")
    Call<Timetable> getTimeTableData(
            @Header("Authorization") String basicAuthorization,
            @Path("year") String year,
            @Path("term") String term
    );




}
