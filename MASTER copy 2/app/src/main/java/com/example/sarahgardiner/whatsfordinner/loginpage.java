package com.example.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
    }

    public void onadminClick(View view) throws PackageManager.NameNotFoundException {
       // String packageName = this.getPackageName();
        //String path = getFilesDir().getAbsolutePath()+ packageName;
       // String FILENAME = "Recipes.ser";
        try {
            String fn = "/data/data/com.example.sarahgardiner.whatsfordinner/files/Recipes.ser";
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
        Intent intent = new Intent(this, UserMenu.class);
        startActivity(intent);
    }
}
//      /data/data/com.example.sarahgardiner.whatsfordinner

//      /data/data/com.example.sarahgardiner.whatsfordinner/files/Recipes.ser

