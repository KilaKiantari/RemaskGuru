package com.example.asus_desktop.remaskguru.Model;

/**
 * Created by Asus-Desktop on 5/11/2018.
 */


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.asus_desktop.remaskguru.Login;

public class SessionManager {
    private static String TAG = SessionManager.class.getSimpleName();

    //Shared Preferences
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    Context _context;

    //Shared Preferences mode
    int PRIVATE_MODE = 0;

    //shared pref file name
    private static final String PREF_NAME = "session";

    private static final String KEY_IS_UID = "uid";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_IS_USERTYPE = "usertype";
    private static final String KEY_IS_NAMAGURU = "nama_guru";
    private static final String KEY_IS_SEKOLAH = "sekolah";
    private static final String KEY_IS_MATPEL = "nama_matpel";
    private static final String KEY_IS_USERNAME = "username";
    private static final String KEY_IS_EMAIL = "email";
    private static final String KEY_IS_CURRENT_LOC= "current_loc";
    private static final String KEY_IS_LOCATION_NAME= "location_name";
    //private static final String KEY_IS_checkinID= "checkin_id";
    private static final String KEY_IS_LASTLOGIN= "lastlogin";
    private static final String KEY_IS_SESSION_TIMEOUT= "timeout";
    private static final String FBASE_TOKEN= "fbase_token";

    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setUid(int uid){
        editor.putInt(KEY_IS_UID, uid);
        editor.commit();
    }

    public void setLogin(boolean isLoggedIn){
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        editor.commit();
    }

    public void setUsertype(String usertype){
        editor.putString(KEY_IS_USERTYPE, usertype);
        editor.commit();
    }

    public void setUsername(String username){
        editor.putString(KEY_IS_USERNAME, username);
        editor.commit();
    }

    public void setEmail(String email){
        editor.putString(KEY_IS_EMAIL, email);
        editor.commit();
    }

    public void setNamaGuru(String namaGuru){
        editor.putString(KEY_IS_NAMAGURU, namaGuru);
        editor.commit();
    }

    public void setNamaMatpel(String namaMatpel){
        editor.putString(KEY_IS_MATPEL, namaMatpel);
        editor.commit();
    }

    public void setSekolah(String sekolah){
        editor.putString(KEY_IS_SEKOLAH, sekolah);
        editor.commit();
    }

    public void setLoc(String location){
        editor.putString(KEY_IS_CURRENT_LOC, location);
        editor.commit();
    }

    public void setLocName(String locName){
        editor.putString(KEY_IS_LOCATION_NAME, locName);
        editor.commit();
    }

    /*public void setCheckin(String id){
        editor.putString(KEY_IS_checkinID, id);
        editor.commit();
    }*/

    public void setSessionTimeout(long timeout){
        editor.putLong(KEY_IS_SESSION_TIMEOUT, timeout);
        editor.commit();
    }

    public void setFirebaseToken(String token) {

        editor.putString(FBASE_TOKEN, token);
        editor.commit();
    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);
    }


    /*public int getCheckin(){
        return pref.getInt(KEY_IS_CHECKIN,0);
    }

    public String getCheckinID(){
        return pref.getString(KEY_IS_checkinID,null);
    }
*/
    public int getId(){
        return pref.getInt(KEY_IS_UID,0);
    }

    public boolean isLogin(){
        return pref.getBoolean(KEY_IS_LOGGEDIN,false);
    }

    public String getFirebaseToken(){
        return pref.getString(FBASE_TOKEN,null);
    }

    public String getUsername(){
        return pref.getString(KEY_IS_USERNAME,null);
    }

    public String getUserType(){
        return pref.getString(KEY_IS_USERTYPE,null);
    }

    public String getEmail(){
        return pref.getString(KEY_IS_EMAIL,null);
    }

    public String getNamaGuru(){
        return pref.getString(KEY_IS_NAMAGURU,null);
    }

    public String getNamaMatpel(){
        return pref.getString(KEY_IS_MATPEL,null);
    }

    public String getSekolah(){
        return pref.getString(KEY_IS_SEKOLAH,null);
    }





    public String getLoc(){
        return pref.getString(KEY_IS_CURRENT_LOC,null);
    }

    public Long getSessionTImeout(){
        return pref.getLong(KEY_IS_SESSION_TIMEOUT,0);
    }

    public String getLocName(){
        return pref.getString(KEY_IS_LOCATION_NAME,null);
    }
}
