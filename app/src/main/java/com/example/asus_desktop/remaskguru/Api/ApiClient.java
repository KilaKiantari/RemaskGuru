package com.example.asus_desktop.remaskguru.Api;


import com.example.asus_desktop.remaskguru.Model.ModelBuatGroup;
import com.example.asus_desktop.remaskguru.Model.ModelDaftarGroup;
import com.example.asus_desktop.remaskguru.Model.ModelLoginUser;
import com.example.asus_desktop.remaskguru.Model.ModelRegister;
import com.example.asus_desktop.remaskguru.Model.ModelRegisterNext;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public class ApiClient {
    public static final String BASE_URL = "http://kila.jagopesan.com/Remask/belakang/api/";

    public static PostServices services_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(PostServices.class);
    public static GetServicesDaftar services_get_daftar_group = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(GetServicesDaftar.class);
    public static GetServicesBuat services_get_buat = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(GetServicesBuat.class);



    public interface PostServices {
        @FormUrlEncoded
        @POST("login/login")
        Call<ModelLoginUser> login(
                @Field("username") String username,
                @Field("password") String password
        );
        @FormUrlEncoded
        @POST("signupguru/signup")
        Call<ModelRegister> register(
                @Field("nama_guru") String nama_guru,
                @Field("sekolah") String sekolah,
                @Field("nama_matpel") String nama_matpel
        );
        @FormUrlEncoded
        @POST("signupguru/signupnext")
        Call<ModelRegisterNext> registernext(
                @Field("username") String username,
                @Field("email") String email,
                @Field("password") String password,
                @Query("id") String id

        );

        @FormUrlEncoded
        @POST("gurugroup/create")
        Call<String> creategroup(
                @Field("guru_id") String guru_id,
                @Field("namagroup") String namagroup
        );

    }

    public interface GetServicesDaftar{
        @GET("gurugroup/index/{id}")
        Call<ModelDaftarGroup> getDaftar(@Path("id") String id);
    }

    public interface GetServicesBuat{
        @GET("gurugroup/buat/{id}")
        Call<ModelBuatGroup> getBuat(@Path("id") int id);
    }

}

