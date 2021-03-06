package com.example.asus_desktop.remaskguru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelRegister;
import com.example.asus_desktop.remaskguru.Model.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 4/18/2018.
 */

public class Register extends AppCompatActivity {
    private Button btnRegister ;
    private ProgressDialog progressDialog;
    private EditText input_name;
    private EditText sekolah;
    private EditText nama_matpel;
    private EditText input_email;
    private EditText input_password;
    private EditText username;
    private SessionManager sessionManager;
    private Integer id_guru;
    private String guru_id;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getSharedPreferences("Remask", MODE_PRIVATE);
        guru_id = sharedPreferences.getString("guru_id","");

        btnRegister = (Button) findViewById(R.id.btn_register);
        input_name = (EditText) findViewById(R.id.input_name);
        sekolah = (EditText) findViewById(R.id.sekolah);
        nama_matpel = (EditText) findViewById(R.id.nama_matpel);
        input_email = (EditText) findViewById(R.id.input_email);
        input_password = (EditText) findViewById(R.id.input_password);
        username = (EditText) findViewById(R.id.username);

        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.isLogin()) {
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
        }


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d("nama_guru",input_name.getText().toString());
                Log.d("sekolah",sekolah.getText().toString());
                Log.d("nama_matpel",nama_matpel.getText().toString());

                //Log.d("username",username.getText().toString());
                //Log.d("email",input_email.getText().toString());
               // Log.d("password",input_password.getText().toString());
               // Log.d("guru_id",username.getText().toString());
//                progressDialog = new ProgressDialog(Register.this);
//                progressDialog.setMessage("Please wait...");
//                progressDialog.show();


                ApiClient.services_post.register(
                        input_name.getText().toString(),
                        sekolah.getText().toString(),
                        nama_matpel.getText().toString()).enqueue(new Callback<ModelRegister>() {

                    @Override
                    public void onResponse(Call<ModelRegister> call, Response<ModelRegister> response) {
                        //response.body();
                        //Log.d("RSP",response.body());
                        if(response.isSuccessful()) {
                            id_guru = response.body().getIdGuru();
                            Toast.makeText(Register.this, ""+id_guru, Toast.LENGTH_SHORT).show();

                            // finish();
                            //progressDialog.dismiss();
                            Intent intent = new Intent(Register.this, RegisterNext.class);
                            intent.putExtra("id_guru",id_guru);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(Register.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                        }


                    }
                    @Override
                    public void onFailure(Call<ModelRegister> call, Throwable t) {
                        Toast.makeText(Register.this, ""+t, Toast.LENGTH_LONG).show();

                        //progressDialog.dismiss();
                    }


                });
    /*           ApiClient.services_post.registernext(
                        username.getText().toString(),
                        input_email.getText().toString(),
                        input_password.getText().toString(),
                        "")
                      .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        response.body();
                        Toast.makeText(Register.this, "Akun anda berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, Login.class);
                        startActivity(intent);
                        finish();
                        progressDialog.dismiss();
                        //return true;
                    }
                          public void onFailure(Call<String> call, Throwable t) {

                              Toast.makeText(Register.this, "Akun anda gagal registrasi", Toast.LENGTH_SHORT).show();
                              progressDialog.dismiss();
                          }


                      });


*/


            }


        });



    }
}