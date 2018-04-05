package com.dinner.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SearchResultsPage extends AppCompatActivity {
    //testing tiffany pls work IT WORKED!!!!! -SARAH

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results_page);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Button btn[] = new Button[SearchPage.searchArray.size()];
        for(int i = 0; i < SearchPage.searchArray.size(); i++) {
            Recipe r = SearchPage.searchArray.get(i);
            Log.d("myTag", "rName1: "+ r.getName());
            final String n = r.getName();
            btn[i] = new Button(this);
            btn[i].setText(n);
            btn[i].setTextSize(20);
            btn[i].setGravity(Gravity.CENTER);

            btn[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Log.d("myTag", "hello 2: "+ "hi");

                    Intent intent = new Intent(getBaseContext(), ViewRecipePage.class);
                    intent.putExtra("RecipeName", n);
                    startActivity(intent);
                    //startActivity(new Intent(SearchResultsPage.this, ViewRecipePage.class));
                }
            });

            linearLayout.addView(btn[i]);
        }

        SearchPage.searchArray.clear();

        this.setContentView(linearLayout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

    }
}
