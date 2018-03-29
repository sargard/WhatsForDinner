package com.example.sarahgardiner.whatsfordinner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ViewRecipePage extends AppCompatActivity {

    private String rName;
    private Recipe r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe_page);

        rName = getIntent().getStringExtra("RecipeName");

        r = new Recipe();
        for(int i = 0; i < CreateRecipePage.RecipeList.size(); i++){
            Recipe temp = CreateRecipePage.RecipeList.get(i);
            if(temp.getName().equals(rName)){
                r.setName(rName);
                r.setServings(temp.getServings());
                r.setCategory(temp.getCategory());
                r.setIngredients(temp.getIngredients());
                r.setInstructions(temp.getInstructions());
            }
        }

        int ser = r.getServings();
        String instruct = r.getInstructions();

        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setText(rName);

        TextView textView10 = (TextView)findViewById(R.id.textView10);
        textView10.setText("" + ser);

        TextView textView13 = (TextView)findViewById(R.id.textView13);
        textView13.setText(instruct);

        TextView textView12 = (TextView)findViewById(R.id.textView12);
        textView12.setText(r.getstrIngredients());

    }


    public void TakeOffMyWeekClick(View view) {
        for(int i = 0; i < MyWeekPage.WeekRecipes.size(); i++){
            Recipe temp = MyWeekPage.WeekRecipes.get(i);
            if(temp.getName().equals(rName)){
                MyWeekPage.WeekRecipes.remove(i);
            }
        }

        Log.d("myTag", "arraylist size: "+ MyWeekPage.WeekRecipes.size());
        String msg = "Recipe Removed from Your Week";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, adminMenu.class);
        startActivity(intent);
    }

    public void AddToMyWeekClick(View view) {
        MyWeekPage.WeekRecipes.add(r);
        String msg = "Recipe Added to Your Week";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, adminMenu.class);
        startActivity(intent);
    }

    public void DeleteRecipeClick(View view) {
        for(int i = 0; i < CreateRecipePage.RecipeList.size(); i++){
            Recipe temp = CreateRecipePage.RecipeList.get(i);
            if(temp.getName().equals(rName)){
                CreateRecipePage.RecipeList.remove(i);
            }
        }

        //-------------save recipe list to phone -----------------------

        String fn = "Recipes.ser";
        //boolean test = new File("/data/data/com.example.sarahgardiner.whatsfordinner/Recipes.ser").createNewFile();

        try {
            FileOutputStream f = this.openFileOutput(fn, Context.MODE_PRIVATE);
            ObjectOutputStream o = new ObjectOutputStream (f);
            o.writeObject (CreateRecipePage.RecipeList);
            o.close ();
            Log.d("myTag", "File writing: "+ true);
        }
        catch ( Exception ex ) {
            Log.d("myTag", "File writing: "+ false);
            ex.printStackTrace ();
        }

        String msg = "Recipe Deleted";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, adminMenu.class);
        startActivity(intent);

    }
}
