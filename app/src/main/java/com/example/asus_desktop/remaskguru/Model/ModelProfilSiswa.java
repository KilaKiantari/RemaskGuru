package com.example.asus_desktop.remaskguru.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus-Desktop on 7/25/2018.
 */

public class ModelProfilSiswa {
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("sekolah")
    @Expose
    private String sekolah;
    @SerializedName("nama_orangtua")
    @Expose
    private String namaOrangtua;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("email")
    @Expose
    private String email;

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getSekolah() {
        return sekolah;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public String getNamaOrangtua() {
        return namaOrangtua;
    }

    public void setNamaOrangtua(String namaOrangtua) {
        this.namaOrangtua = namaOrangtua;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
