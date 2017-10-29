package com.example.administrator.Retrofit;

import com.example.administrator.model.RegisterModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by zzc on 2017/10/15.
 */

public interface UserService {
    @POST("elegant/greeting")
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    Call<ResponseBody> login(@Body RequestBody requestBody);

    @POST("user/register")
    @Headers({"Content-Type: application/json","Accept: application/json"})//需要添加头
    Call<ResponseBody> signUp(@Body RegisterModel registerModel);

    @POST("fileUpload")
    @Multipart
    Call<ResponseBody> upLoadCertificateId(@Part List<MultipartBody.Part> partList);

}
