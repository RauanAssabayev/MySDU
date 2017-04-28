package com.ce.sdu.mysdu.API;

import com.ce.sdu.mysdu.model.Student;

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
}
