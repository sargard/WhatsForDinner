package com.dinner.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SplashPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
    }

    public void onSplashPageClick(View view) {
        Intent intent = new Intent(this, loginpage.class);
        startActivity(intent);
        finish();


    }
}
