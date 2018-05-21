package com.example.asus_desktop.remaskguru;

/**
 * Created by Asus-Desktop on 4/17/2018.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;



//import android.view.WindowManager;



public class Login extends AppCompatActivity {



    //public static ApiInterface apiInterface;

    //private ModelLoginUser modelLogin;
    private EditText inputEmail, inputPassword;
    private ProgressBar progressBar;
    private Button btnLogin ;
    private TextView txtViewSingUp;
    private  SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private ProgressDialog progressDialog;
    private SessionManager sessionManager;

    /*OnLoginFormActivityListener loginFormActivityListener;
    public interface OnLoginFormActivityListener{
        public void performLogin(String Username);
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("Remask", MODE_PRIVATE);
        edit =sharedPreferences.edit();
        edit.clear();
        edit.apply();

        //prefConfig = new PrefConfig(this);
        //apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnLogin = (Button) findViewById(R.id.btn_login);
        txtViewSingUp = (TextView) findViewById(R.id.txtViewSingUp);
        txtViewSingUp.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

       /* if (findViewById(R.id.constraintContainer)!=null)
        {
            if(savedInstanceState!=null){
                return;
            }

            if(prefConfig.readLoginStatus())
            {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(Login.this, Login.class);
                startActivity(intent);
            }
        }
        */
        sessionManager = new SessionManager(getApplicationContext());
        if (sessionManager.isLogin()) {
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            finish();
        }



        btnLogin.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            progressDialog = new ProgressDialog(Login.this);
                                            progressDialog.setMessage("Please wait...");
                                            progressDialog.show();

            txtViewSingUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, Register.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    });


        }
    }
