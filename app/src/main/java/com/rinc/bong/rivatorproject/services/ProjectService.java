package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Project;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectListGet;
import com.rinc.bong.rivatorproject.retrofitBean.ProjectManagerListGet;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by baehy on 2017. 9. 24..
 */

public interface ProjectService {
    @POST("/projects")
    @Multipart
    Call<Status> addProjectWithImage(@Part("data") Project project, @Part MultipartBody.Part file);

    @GET("/projects")
    Call<ProjectListGet> getProjectListWithUserName(@Query("offset") int offset, @Query("limit") int limit, @Query("userId") String userId);

    @GET("/projects")
    Call<ProjectListGet> getProjectList(@Query("offset") int offset, @Query("limit") int limit);

    @GET("/project-manager")
    Call<ProjectManagerListGet> getProjectMangerList(@Query("offset") int offset, @Query("limit") int limit, @Query("userId") String userId);

}
