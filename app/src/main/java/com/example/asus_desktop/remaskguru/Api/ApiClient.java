package com.example.asus_desktop.remaskguru.Api;


import com.example.asus_desktop.remaskguru.Model.ModelBuatGroup;
import com.example.asus_desktop.remaskguru.Model.ModelDaftarGroup;
import com.example.asus_desktop.remaskguru.Model.ModelDelete;
import com.example.asus_desktop.remaskguru.Model.ModelGrafik;
import com.example.asus_desktop.remaskguru.Model.ModelGuruProfile;
import com.example.asus_desktop.remaskguru.Model.ModelLoginUser;
import com.example.asus_desktop.remaskguru.Model.ModelProfilSiswa;
import com.example.asus_desktop.remaskguru.Model.ModelRegister;
import com.example.asus_desktop.remaskguru.Model.ModelRegisterNext;
import com.example.asus_desktop.remaskguru.Model.ModelSiswaGrupJoin;
import com.example.asus_desktop.remaskguru.Model.ModelSiswaMasuk;

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
    public static GetNamaSiswa services_get_nama_siswa = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(GetNamaSiswa.class);
    public static GetGrafikProgress services_get_grafik_progress = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetGrafikProgress.class);
    public static GetGrafikProgressBelum services_get_grafik_progress_belum = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetGrafikProgressBelum.class);
    public static GetSiswaGrupJoin services_get_siswa_grup_join = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetSiswaGrupJoin.class);
    public static GetProfile services_get_profile_guru = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetProfile.class);
    public static GetSiswaYangMasuk services_get_siswa_masuk = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetSiswaYangMasuk.class);
    public static GetServicesProfil services_get_profil_siswa= new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetServicesProfil.class);
    public static GetKeluarGroup services_get_keluar_grup = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetKeluarGroup.class);




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
        Call<ModelBuatGroup> getBuat(@Path("id") String id);
    }

    public interface GetNamaSiswa{
        @GET("gurugroup/detailgrup")
        Call<ModelBuatGroup> getNamaSiswa(@Query("id") String id);
    }

    public interface GetGrafikProgress {
        @GET("gurugrafik/grafikprogress/{id}")
        Call<ModelGrafik> getGrafikProgress(@Path("id") String id);
    }

    public interface GetGrafikProgressBelum {
        @GET("gurugrafik/grafikprogressbelum/{id}")
        Call<ModelGrafik> getGrafikProgressBelum(@Path("id") String id);
    }
    public interface GetSiswaGrupJoin {
        @GET("gurugroup/detailgrupsiswa")
        Call<ModelSiswaGrupJoin> getSiswaGrupJoin(@Query("id") String id);
    }

    public interface GetSiswaYangMasuk{
        @GET("gurugroup/detailgrupsiswa")
        Call<ModelSiswaMasuk> getSiswaMasuk(@Query("id") String id);
    }

    public interface GetProfile {
        @GET("profilguru/index/{id}")
        Call<ModelGuruProfile> getProfile(@Path("id") String id);
    }

    public interface GetServicesProfil {
        @GET("profilsiswa/{id}")
        Call<ModelProfilSiswa> getProfileSiswa(@Path("id") String id);
    }

    public interface GetKeluarGroup{
        @GET("gurugroup/keluargrup/{id}")
        Call<ModelDelete> getKeluarGroup(@Path("id") String id);
    }


}

