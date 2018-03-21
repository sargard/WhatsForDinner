package com.example.sarahgardiner.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewRecipePage extends AppCompatActivity {

    private String rName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe_page);

        rName = getIntent().getStringExtra("EXTRA_SESSION_ID");

        Recipe r = new Recipe();
        for(int i = 0; i < CreateRecipePage.RecipeList.size(); i++){
            Recipe temp = CreateRecipePage.RecipeList.get(i);
            if(temp.getName().equals(rName)){
                r.setName(rName);
                r = temp;
            }
        }

        

    }


}
