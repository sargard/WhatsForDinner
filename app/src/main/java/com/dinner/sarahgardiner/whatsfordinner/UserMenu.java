package com.dinner.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UserMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
    }

    public void onBrowseClick(View view) {
        Intent intent = new Intent(this, BrowseRecipesPage.class);
        startActivity(intent);
    }

    public void onWeekClick(View view) {
        Intent intent = new Intent(this, MyWeekPage.class);
        startActivity(intent);
    }

    public void onSearchClick(View view) {
        Intent intent = new Intent(this, SearchPage.class);
        startActivity(intent);
    }

    public void onGroceryClick(View view) {
        Intent intent = new Intent(this, GroceryListPage.class);
        startActivity(intent);
    }
}
