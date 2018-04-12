package com.dinner.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Intent intent = new Intent(this, GroceryPage.class);
        startActivity(intent);
    }

    public void onFaqClick(View view) {
        Intent intent = new Intent(this, FaqUserPage.class);
        startActivity(intent);
    }

    public void onDeleteClick(View view) {
        addGroceryItemPage.AddedGroceries.clear();
        String msg = "Deleted";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }


    public void onAddGroceryClick(View view) {
        Intent intent = new Intent(this, addGroceryItemPage.class);
        startActivity(intent);
    }
}


