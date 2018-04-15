package com.dinner.sarahgardiner.whatsfordinner;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Base64;

public class CreateRecipePage extends AppCompatActivity {

    private static final String TAG = CreateRecipePage.class.getSimpleName();
    public static ArrayList<Recipe> RecipeList = new ArrayList<Recipe>();
    String jsonString;
    String serialized_input;
    ProgressDialog pDialog;
    boolean goodRecipeAdminSent = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe_page);
    }


    public void onSubmitClick(View view) throws PackageManager.NameNotFoundException, IOException {
        //-------------- get recipe name ---------------------------------
        EditText mEdit   = (EditText)findViewById(R.id.recipeName);
        String rName = mEdit.getText().toString().toLowerCase();
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
            finish();

        }
        else {
            Recipe r = new Recipe(rName, rInstructions, rCategory,
                    rServing);//, AddIngredientPage.IngredientList);
            //add recipe to arraylist thing
            for(int i = 0; i < AddIngredientPage.IngredientList.size(); i++){
                Ingredient in = AddIngredientPage.IngredientList.get(i);
                r.addIngredient(in);
            }
            String ingred = r.getstrIngredients();
            Log.d("myTag", "ingred (create): "+ ingred);
            RecipeList.add(r);

        }

        AddIngredientPage.IngredientList.clear();

        //-------------save recipe list to phone -----------------------
        String fn = "RecipesAdmin.ser";

        /*try {
            FileOutputStream f = this.openFileOutput(fn, Context.MODE_PRIVATE);
            ObjectOutputStream o = new ObjectOutputStream (f);
            o.writeObject (RecipeList);
            o.close ();
            Log.d("myTag", "File writing: "+ true);
        }
        catch ( Exception ex ) {
            Log.d("myTag", "File writing: "+ false);
            ex.printStackTrace ();
        }*/
        LoginHandler lh = new LoginHandler();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(RecipeList);
        serialized_input = Base64.getEncoder().encodeToString(bos.toByteArray()); //bos.toString();
        os.close();

        new CreateRecipeExecute().execute();

    }

    public void onIngredientClick(View view) {
        Intent intent = new Intent(this, AddIngredientPage.class);
        startActivity(intent);
    }


    private class CreateRecipeExecute extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(CreateRecipePage.this);
            pDialog.setMessage("Uploading Recipe...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            LoginHandler lh = new LoginHandler();
            jsonString = lh.makeServiceCall("https://cpsc-350-psethr.c9users.io:8082/add-recipe-admin?object="+serialized_input);
            Log.d(TAG,"\n\n\n\n\n"+jsonString+"\n\n\n\n\n");

            if(jsonString != null)
            {
                try {
                    JSONObject ob = new JSONObject(jsonString);
                    if(ob.get("status").equals("updated admin recipes"))
                    {
                        Log.d(TAG,"\n\n\n\n\n"+"Inside"+"\n\n\n\n\n");
                        goodRecipeAdminSent = true;
                        Log.d(TAG,"\n\n\n\n\n"+"goodUserLogin"+goodRecipeAdminSent+"\n\n\n\n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(pDialog.isShowing())
            {
                pDialog.dismiss();
            }
            if(goodRecipeAdminSent)
            {
                goodRecipeAdminSent = false;
                Log.d(TAG,"\n\n\n\n\n"+"          3            "+"\n\n\n\n\n");
                Toast.makeText(CreateRecipePage.this, "Recipe Uploaded", Toast.LENGTH_SHORT).show();
                Log.d(TAG,"\n\n\n\n\n"+"          4            "+"\n\n\n\n\n");
                finish();
            }
            else
            {
                Toast.makeText(CreateRecipePage.this, "Error: Recipe Wasn't Uploaded", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

