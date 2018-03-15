package com.example.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }

    public void onadminClick(View view) {
        Intent intent = new Intent(this, adminMenu.class);
        startActivity(intent);
    }

    public void onUserClick(View view) {
        Intent intent = new Intent(this, UserMenu.class);
        startActivity(intent);
    }
}
