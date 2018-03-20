package com.example.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateRecipePage extends AppCompatActivity {

    public static ArrayList<Recipe> Recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe_page);
    }


    public void onSubmitClick(View view) {
        //-------------- get recipe name ---------------------------------
        EditText mEdit   = (EditText)findViewById(R.id.recipeName);
        String rName = mEdit.getText().toString();
        Log.d("myTag", "RecipeName: "+ rName);

        //-------------- get serving size ---------------------------------
        EditText mEdit2   = (EditText)findViewById(R.id.recipeServings);
        String ser = mEdit2.getText().toString();
        int rServing = Integer.parseInt(ser);
        Log.d("myTag", "Recipe serving: "+ rServing);

        //-------------- get recipe instructions ----------------------------
        EditText mEdit3   = (EditText)findViewById(R.id.recipeInstuctions);
        String rInstructions = mEdit3.getText().toString();
        Log.d("myTag", "rInstructions: "+ rInstructions);

        //---------------- get category ------------------------------------
        Spinner cat = (Spinner)findViewById(R.id.Category);
        String rCategory = cat.getSelectedItem().toString();
        Log.d("myTag", "rCategory: "+ rCategory);

        //--------------- recipe object created ----------------------------
        if(rName.trim().length() == 0 || ser.trim().length() == 0 || rInstructions.trim().length() == 0 || rCategory.trim().length() == 0){
            Recipe r = new Recipe(rName, rInstructions, rCategory, rServing, AddIngredientPage.IngredientList);
            //add recipe to arraylist thing
            Recipes.add(r);

        }
        else {
            finish();
        }

        AddIngredientPage.IngredientList.clear();

        String msg = "Recipe Added";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
        finish();
    }

    public void onIngredientClick(View view) {
        Intent intent = new Intent(this, AddIngredientPage.class);
        startActivity(intent);
    }
}
