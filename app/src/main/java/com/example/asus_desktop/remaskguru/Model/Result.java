package com.example.asus_desktop.remaskguru.Model;

/**
 * Created by Asus-Desktop on 5/23/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
    @SerializedName("password_hash")
    @Expose
    private String passwordHash;
    @SerializedName("password_reset_token")
    @Expose
    private Object passwordResetToken;
    @SerializedName("guru_id")
    @Expose
    private Integer guruId;
    @SerializedName("orangtua_id")
    @Expose
    private Object orangtuaId;
    @SerializedName("siswa_id")
    @Expose
    private String siswaId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("updated_at")
    @Expose
    private Integer updatedAt;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("id_guru")
    @Expose
    private String idGuru;
    @SerializedName("nama_guru")
    @Expose
    private String namaGuru;
    @SerializedName("sekolah")
    @Expose
    private String sekolah;
    @SerializedName("nama_matpel")
    @Expose
    private String namaMatpel;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("namagroup")
    @Expose
    private String namagroup;
    @SerializedName("nama_tugas")
    @Expose
    private String namaTugas;
    @SerializedName("status_tugas")
    @Expose
    private String statusTugas;
    @SerializedName("id_tugas")
    @Expose
    private String idTugas;
    @SerializedName("id_group")
    @Expose
    private String idgroup;

    public String getIdGroup() {
        return idgroup;
    }


    public String getIdTugas() {
        return idTugas;
    }

    public void setIdTugas(String idTugas) {
        this.idTugas = idTugas;
    }


    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }


    public String getStatusTugas() {
        return statusTugas;
    }
    public void setNamaTugas(String nama_tugas) {
        this.namaTugas = nama_tugas;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public String getNamalengkap() {
        return namaLengkap;
    }

    public String getNamagroup() {
        return namagroup;
    }

    public void setNamagroup(String namagroup) {
        this.namagroup = namagroup;
    }

    public String getIdGuru() {
        return idGuru;
    }

    public void setIdGuru(String idGuru) {
        this.idGuru = idGuru;
    }

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

    public String getNamaMatpel() {
        return namaMatpel;
    }

    public void setNamaMatpel(String namaMatpel) {
        this.namaMatpel = namaMatpel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Object getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(Object passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public Integer getGuruId() {
        return guruId;
    }

    public void setGuruId(Integer guruId) {
        this.guruId = guruId;
    }

    public Object getOrangtuaId() {
        return orangtuaId;
    }

    public void setOrangtuaId(Object orangtuaId) {
        this.orangtuaId = orangtuaId;
    }

    public String getSiswaId() {
        return siswaId;
    }

    public void setSiswaId(String siswaId) {
        this.siswaId = siswaId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
