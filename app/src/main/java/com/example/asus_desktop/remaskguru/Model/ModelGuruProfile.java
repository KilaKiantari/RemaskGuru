package com.example.asus_desktop.remaskguru.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Asus-Desktop on 7/24/2018.
 */

public class ModelGuruProfile{
        @SerializedName("nama_guru")
        @Expose
        private String namaGuru;
        @SerializedName("sekolah")
        @Expose
        private String sekolah;
        @SerializedName("tgl_lahir")
        @Expose
        private String tglLahir;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("level")
        @Expose
        private String level;
        @SerializedName("email")
        @Expose
        private String email;

        public String getNamaGuru() {
            return namaGuru;
        }

        public void setNamaGuru(String namaGuru) {
            this.namaGuru = namaGuru;
        }

        public String getSekolah() {
            return sekolah;
        }

        public void setSekolah(String sekolah) {
            this.sekolah = sekolah;
        }

        public String getTglLahir() {
            return tglLahir;
        }

        public void setTglLahir(String tglLahir) {
            this.tglLahir = tglLahir;
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