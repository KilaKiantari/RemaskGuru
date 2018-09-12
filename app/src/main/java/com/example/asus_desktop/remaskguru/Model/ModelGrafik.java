package com.example.asus_desktop.remaskguru.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus-Desktop on 7/10/2018.
 */

public class ModelGrafik {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jmlbelum")
    @Expose
    private Integer jmlbelum;
    @SerializedName("jml")
    @Expose
    private Integer jml;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getJmlbelum() {
        return jmlbelum;
    }

    public void setJmlbelum(Integer jmlbelum) {
        this.jmlbelum = jmlbelum;
    }
    public Integer getJml() {
        return jml;
    }

    public void setJml(Integer jml) {
        this.jml = jml;
    }


}

