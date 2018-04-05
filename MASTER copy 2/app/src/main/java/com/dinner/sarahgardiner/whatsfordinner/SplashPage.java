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
        // String packageName = this.getPackageName();
        //String path = getFilesDir().getAbsolutePath()+ packageName;
        // String FILENAME = "Recipes.ser";
        try {
            String fn = "/data/data/com.dinner.sarahgardiner.whatsfordinner/files/Recipes.ser";
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
        Intent intent = new Intent(this, loginpage.class);
        startActivity(intent);

        //splash page
    }
}
