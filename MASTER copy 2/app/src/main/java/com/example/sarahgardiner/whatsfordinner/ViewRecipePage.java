package com.example.sarahgardiner.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ViewRecipePage extends AppCompatActivity {

    private String rName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe_page);

        rName = getIntent().getStringExtra("RecipeName");

        Recipe r = new Recipe();
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
        String Ingredients = r.getstrIngredients();
        Log.d("myTag", "RecipeIngredients: "+ Ingredients);

        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setText(rName);

        TextView textView10 = (TextView)findViewById(R.id.textView10);
        textView10.setText("" + ser);

        TextView textView13 = (TextView)findViewById(R.id.textView13);
        textView13.setText(instruct);

        TextView textView12 = (TextView)findViewById(R.id.textView12);
        textView12.setText(r.getstrIngredients());

    }


}
