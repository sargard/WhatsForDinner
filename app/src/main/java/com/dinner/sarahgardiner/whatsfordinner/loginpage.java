package com.dinner.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class loginpage extends AppCompatActivity {
    public static String uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }

    public void onadminClick(View view) throws PackageManager.NameNotFoundException {
        EditText mEdit   = (EditText)findViewById(R.id.username);
        uname = mEdit.getText().toString().toLowerCase();
        Log.d("myTag", "username: "+ uname);
        String filename = uname + "Week.ser";
        Log.d("myTag", "filename: "+ filename);
        try {
            String fn = "/data/data/com.dinner.sarahgardiner.whatsfordinner/files/" + filename;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fn));
            ArrayList<Recipe> RecipesFile = (ArrayList<Recipe>) input.readObject();
            input.close();
            MyWeekPage.WeekRecipes = RecipesFile;
            Log.d("myTag", "File writing: "+ true);
        }
        catch (Exception e) {
            Log.d("myTag", "File writing: " + false);
            e.printStackTrace();
        }

        try {
            String fn = "/data/data/com.dinner.sarahgardiner.whatsfordinner/files/RecipesAdmin.ser";
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fn));
            ArrayList<Recipe> RecipesFile = (ArrayList<Recipe>) input.readObject();
            input.close();
            CreateRecipePage.RecipeList = RecipesFile;
            Log.d("myTag", "File writing: "+ true);
        }
        catch (Exception e) {
            Log.d("myTag", "File writing: "+ false);
            e.printStackTrace();
        }

        try {
            String fn = "/data/data/com.dinner.sarahgardiner.whatsfordinner/files/UserRecipes.ser";
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fn));
            ArrayList<Recipe> RecipesFile = (ArrayList<Recipe>) input.readObject();
            input.close();
            CreateRecipePage.RecipeList = RecipesFile;
            Log.d("myTag", "File writing: "+ true);
        }
        catch (Exception e) {
            Log.d("myTag", "File writing: "+ false);
            e.printStackTrace();
        }
        Intent intent = new Intent(this, adminMenu.class);
        startActivity(intent);

    }

    public void onUserClick(View view) {
        EditText mEdit   = (EditText)findViewById(R.id.username);
        uname = mEdit.getText().toString();
        Log.d("myTag", "username: "+ uname);
        String filename = uname + "Week.ser";
        Log.d("myTag", "filename: "+ filename);
        try {
            String fn = "/data/data/com.dinner.sarahgardiner.whatsfordinner/files/" + filename;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fn));
            ArrayList<Recipe> RecipesFile = (ArrayList<Recipe>) input.readObject();
            input.close();
            MyWeekPage.WeekRecipes = RecipesFile;
            Log.d("myTag", "File writing: "+ true);
        }
        catch (Exception e) {
            Log.d("myTag", "File writing: " + false);
            e.printStackTrace();
        }

        try {
            String fn = "/data/data/com.dinner.sarahgardiner.whatsfordinner/files/RecipesUser.ser";
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fn));
            ArrayList<Recipe> RecipesFile = (ArrayList<Recipe>) input.readObject();
            input.close();
            CreateRecipePage.RecipeList = RecipesFile;
            Log.d("myTag", "File writing: "+ true);
        }
        catch (Exception e) {
            Log.d("myTag", "File writing: "+ false);
            e.printStackTrace();
        }

        Intent intent = new Intent(this, UserMenu.class);
        startActivity(intent);
    }
}
//      /data/data/com.example.sarahgardiner.whatsfordinner

//      /data/data/com.example.sarahgardiner.whatsfordinner/files/Recipes.ser

