package com.example.asus_desktop.remaskguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelProfilSiswa;
import com.example.asus_desktop.remaskguru.Model.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 7/25/2018.
 */

public class ProfilSiswa extends AppCompatActivity {


    RelativeLayout view;
    private ModelProfilSiswa modelProfilSiswa;
    private EditText inputEmail, inputPassword;
    private ProgressBar progressBar;
    private Button btnLogin ;
    private TextView NamaSiswa,Status,Sekolah,Email,tanggal;
    //  private UserProfilSiswa modelUserProfile;
    private String guru_id;
    private TextView Tentang;
    private TextView Logout;
    SessionManager session;
    String id_siswa;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihat_profil_siswa);

      //  View view = inflater.inflate(R.layout.activity_profile, container, false);


        ProfilSiswa.this.setTitle("Profil Siswa");

        NamaSiswa = (TextView)findViewById(R.id.tvNamaLengkap);
        Status = (TextView) findViewById(R.id.tvStatus);
        Sekolah = (TextView) findViewById(R.id.tvSekolah);
        Email = (TextView) findViewById(R.id.tvEmail);

        Intent grup = getIntent();
        id_siswa = grup.getStringExtra("id_siswa");

        ApiClient.services_get_profil_siswa.getProfileSiswa(id_siswa).enqueue(new Callback<ModelProfilSiswa>() {
            @Override
            public void onResponse(Call<ModelProfilSiswa> call, Response<ModelProfilSiswa> response) {
                if(response.isSuccessful()) {
                    modelProfilSiswa = response.body();
                    NamaSiswa.setText(modelProfilSiswa.getNamaLengkap());
                    Status.setText(modelProfilSiswa.getLevel());
                    Sekolah.setText(modelProfilSiswa.getSekolah());
                    Email.setText(modelProfilSiswa.getEmail());
                    switch (modelProfilSiswa.getLevel()) {
                        case "1":
                            Status.setText("Siswa");
                            break;
                        case "2":
                            Status.setText("Guru");
                            break;
                        case "3":
                            Status.setText("Orangtua");
                            break;
                    }
                }else {
                    Toast.makeText(ProfilSiswa.this, "SALAH", Toast.LENGTH_SHORT).show();
                }
            }
            public void onFailure(Call<ModelProfilSiswa> call, Throwable t) {

            }


        });

    }
}