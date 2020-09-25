package com.aripratom.frontendcodingtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.aripratom.frontendcodingtest.model.Token;
import com.aripratom.frontendcodingtest.remote.APICall;
import com.aripratom.frontendcodingtest.remote.RetroClass;
import com.aripratom.frontendcodingtest.tokenmanager.TokenManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText email, username, password;
    private Button btn_register;
    private TextView login_disini;
    private TokenManager tokenManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        username = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        btn_register = findViewById(R.id.btn_register);
        login_disini = findViewById(R.id.tv_loginDisini);

        login_disini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final APICall apiCall = RetroClass.getAPICall();
                final String emailVal = email.getText().toString();
                final String userNameVal = username.getText().toString();
                final String passVal = password.getText().toString();

                Call<Token> jwtTokenCall = apiCall.register(emailVal, userNameVal, passVal);
                jwtTokenCall.enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        Token jwtToken = response.body();
                        tokenManager.createSession(emailVal, userNameVal, passVal);

                        Toast.makeText(getApplicationContext(), "" + response.body(), Toast.LENGTH_SHORT);
                        Log.d(jwtToken.getToken(), "AAAAAA");

                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT);
                        Log.d(t.getMessage(), "AAAAAA");
                    }
                });
            }
        });
    }


}