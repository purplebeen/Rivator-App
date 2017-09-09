package com.rinc.bong.rivatorproject.services;

import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.Status;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.beans.UserLogin;
import com.rinc.bong.rivatorproject.beans.UserRegister;


import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by baehyeonbin on 2017. 9. 3..
 */

public interface UserService {
    @Multipart
    @POST("/users")
    Call<UserRegister> register(@Part("data") User user, @Part MultipartBody.Part profileImage);

    @FormUrlEncoded
    @POST("/sign/login")
    Call<UserLogin> login(@Field("userId") String userId, @Field("userPw") String userPw);


    @GET("/sign/logout")
    Call<Status> logout();

}
