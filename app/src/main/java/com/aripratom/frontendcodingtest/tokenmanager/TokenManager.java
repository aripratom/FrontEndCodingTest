package com.aripratom.frontendcodingtest.tokenmanager;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int Mode = 0;
    private static final String REFNAME="JWTTOKEN";
    private static final String KEY_EMAIL="email";
    private static final String KEY_USER_NAME="username";
    private static final String KEY_PASS="password";
    private static final String KEY_JWT_TOKEN="jwttoken";
    private Context context;

    public TokenManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(REFNAME,Mode);
        editor = sharedPreferences.edit();
    }

    public void createSession(String email, String username, String password){
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_USER_NAME,username);
        editor.putString(KEY_PASS, password);
        //editor.putString(KEY_JWT_TOKEN,jwtvalue);
        editor.commit();
    }

}
