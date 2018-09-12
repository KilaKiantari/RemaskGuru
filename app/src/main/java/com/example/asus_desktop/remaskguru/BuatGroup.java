package com.example.asus_desktop.remaskguru;

/**
 * Created by Asus-Desktop on 5/27/2018.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.asus_desktop.remaskguru.Api.ApiClient;
import com.example.asus_desktop.remaskguru.Model.ModelBuatGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 4/12/2018.
 */


public class BuatGroup extends AppCompatActivity {
    Toolbar toolbar;
    SQLiteDatabase db;
    //DbHelper mDbHelper;
    EditText mTitleText;
    EditText mNamaGuru;
    EditText mNamaMatpel;
    ModelBuatGroup modelBuatGroup;
    Spinner mSpinner;
    TimePicker pickerTime;
    TextView time;
    private String guru_id;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buat_group);
        SharedPreferences sharedPreferences = getSharedPreferences("Remask", MODE_PRIVATE);
        guru_id = sharedPreferences.getString("guru_id","");
        edit =sharedPreferences.edit();


        //Log.d("AppCompatActivity","BuatGroup");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        mTitleText = (EditText) findViewById(R.id.txttitle);
        mNamaGuru = (EditText) findViewById(R.id.txtnamaguru);
        mNamaMatpel = (EditText) findViewById(R.id.txtmatpel);

        ApiClient.services_get_buat.getBuat(guru_id).enqueue(new Callback<ModelBuatGroup>() {
            @Override
            public void onResponse(Call<ModelBuatGroup> call, Response<ModelBuatGroup> response) {
                modelBuatGroup = response.body();
                Log.d("nama_guru",modelBuatGroup.getResults().get(0).getNamaGuru());
                Log.d("nama_matpel",modelBuatGroup.getResults().get(0).getNamaMatpel());
                mNamaGuru.setText(modelBuatGroup.getResults().get(0).getNamaGuru());
                // mNamaGuru.setText(modelBuatGroup.getResults().getNamaGuru());
                mNamaMatpel.setText(modelBuatGroup.getResults().get(0).getNamaMatpel());
                //Log.d("getSekolah", modelUserProfile.getSekolah());
            }
            public void onFailure(Call<ModelBuatGroup> call, Throwable t) {
               // Log.d("services_get_buat",t.getMessage());
            }
        });

        BuatGroup.this.setTitle("Buat Group");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

    }

    @Override
    public void onBackPressed() {
        Intent setIntent = new Intent(this, MainActivity.class);
        startActivity(setIntent);
    }

    void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_buat_catatan, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.action_settings:
                Intent ab = new Intent(BuatGroup.this, MainActivity.class);
                ab.putExtra("Extra","Tools");
                startActivity(ab);
                return true;
            case R.id.action_save:
                Log.d("id","1");
                Log.d("namagroup",mTitleText.getText().toString());
                Log.d("nama_guru",mNamaGuru.getText().toString());
                Log.d("nama_matpel",mNamaMatpel.getText().toString());

                ApiClient.services_post.creategroup(
                        guru_id,
                        mTitleText.getText().toString()).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        response.body();
                        Toast.makeText(BuatGroup.this, "Group telah ditambahkan", Toast.LENGTH_SHORT).show();

                        //return true;
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }

                });

                Intent intent = new Intent(BuatGroup.this, MainActivity.class);
                startActivity(intent);
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
