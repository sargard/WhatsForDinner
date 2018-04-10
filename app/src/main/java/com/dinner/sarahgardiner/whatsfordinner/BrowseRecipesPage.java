package com.dinner.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class BrowseRecipesPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // change this to only show admin pushed recipes NOT DONE YET

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_recipes_page);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Button btn[] = new Button[ViewRecipeAdminPage.UserRecipes.size()];
        for(int i = 0; i < ViewRecipeAdminPage.UserRecipes.size(); i++) {
            Recipe r = ViewRecipeAdminPage.UserRecipes.get(i);
            final String n = r.getName();
            btn[i] = new Button(this);
            btn[i].setText(n);
            btn[i].setTextSize(20);
            btn[i].setGravity(Gravity.CENTER);
            btn[i].setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), ViewRecipePage.class);
                    intent.putExtra("RecipeName", n);
                    startActivity(intent);
                    //startActivity(new Intent(BrowseRecipesPage.this, ViewRecipePage.class));
                }
            });
                    linearLayout.addView(btn[i]);
        }

        this.setContentView(linearLayout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

    }

}
