package com.example.asus_desktop.remaskguru.Model;

/**
 * Created by Asus-Desktop on 5/26/2018.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDaftarGroup {

    @SerializedName("namagroup")
    @Expose
    private String namagroup;

    public String getNamagroup() {
        return namagroup;
    }

    public void setNamagroup(String namagroup) {
        this.namagroup = namagroup;
    }

}