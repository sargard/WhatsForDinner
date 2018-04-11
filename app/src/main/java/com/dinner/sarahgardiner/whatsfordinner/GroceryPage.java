package com.dinner.sarahgardiner.whatsfordinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.util.ArrayList;

public class GroceryPage extends AppCompatActivity {

    private static  ArrayList<Ingredient> GroceryListObj = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> GL = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Produce = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Dairy = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Meat = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Frozen = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Bakery = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> CannedDryGoods = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Spices = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> PastaRice = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Oilsauces = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> SnacksCrackers = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> Drinks = new ArrayList<Ingredient>();
    private static ArrayList<Ingredient> GLsorted = new ArrayList<Ingredient>();



    public static void combine(){
        for (int i = 0; i < GroceryListObj.size(); i++) {
            Ingredient one = GroceryListObj.get(i);
            for (int j = 1+i; j < GroceryListObj.size(); j++){
                Ingredient two = GroceryListObj.get(j);
                if(one.getName().equals(two.getName())){
                    double totAmount = one.toTsp() + two.toTsp();
                    one.setAmount(totAmount);
                    if(!one.getMeasurment().equals("Item"))
                        one.setMeasurement("Tsp");
                    GroceryListObj.remove(j);
                    if(!GL.contains(one)){
                        GL.add(one);
                    }
                    else{
                        for(int k = 0; k < GL.size(); k++){
                            if(GL.get(k).getName().equals(one.getName())){
                                double amount = GL.get(k).toTsp() + one.toTsp();
                                GL.get(k).setAmount(amount);
                                if(!one.getMeasurment().equals("Item"))
                                    GL.get(k).setMeasurement("Tsp");
                            }
                        }
                    }
                }
            }
            if(!GL.contains(one)){
                GL.add(one);
            }
        }
    }

    public static void sort(){
        for(int i = 0; i < GL.size(); i++){
            Ingredient a = GL.get(i);
            if(a.getType().equals("Produce")){
                System.out.println("Ingrdient: "+ a.getStringIngredient());
                Produce.add(a);
            }
            else if(a.getType().equals("Dairy")){
                Dairy.add(a);
            }
            else if(a.getType().equals("Meat")){
                Meat.add(a);
            }
            else if(a.getType().equals("Frozen")){
                Frozen.add(a);
            }
            else if(a.getType().equals("Bakery")){
                Bakery.add(a);
            }
            else if(a.getType().equals("Canned and Dry Goods")){
                CannedDryGoods.add(a);
            }
            else if(a.getType().equals("Spices")){
                Spices.add(a);
            }
            else if(a.getType().equals("Pasta and Rice")){
                PastaRice.add(a);
            }
            else if(a.getType().equals("Oils and Sauces")){
                Oilsauces.add(a);
            }
            else if(a.getType().equals("Snacks and Crackers")){
                SnacksCrackers.add(a);
            }
            else if(a.getType().equals("Drinks")){
                Drinks.add(a);
            }
        }
        GLsorted.addAll(Produce);
        GLsorted.addAll(Dairy);
        GLsorted.addAll(Meat);
        GLsorted.addAll(Frozen);
        GLsorted.addAll(Bakery);
        GLsorted.addAll(CannedDryGoods);
        GLsorted.addAll(Spices);
        GLsorted.addAll(PastaRice);
        GLsorted.addAll(Oilsauces);
        GLsorted.addAll(SnacksCrackers);
        GLsorted.addAll(Drinks);
    }

    public static void condense(){
        for(int i = 0; i < GLsorted.size(); i++){
            Ingredient g = GLsorted.get(i);
            if(g.getMeasurment().equals("Tsp")){
                double amount = g.getAmount();
                if(amount <= 9){
                    g.setAmount((double)Math.round(amount * 100d) / 100d);
                    g.setMeasurement("Tsp");
                }
                else{
                    double Cup = amount/48.6922;
                    if(Cup <= .2){
                        double Tbsp = amount/.33;
                        g.setAmount((double)Math.round(Tbsp * 100d) / 100d);
                        g.setMeasurement("Tbsp");
                    }
                    else{
                        g.setAmount((double)Math.round(Cup * 100d) / 100d);
                        g.setMeasurement("Cup");
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_page);

        for(int i = 0; i < MyWeekPage.WeekRecipes.size(); i++){
            Recipe r = MyWeekPage.WeekRecipes.get(i);
            //Log.d("myTag", "rIngredient size: "+ rIngredients.size());
            for(int k = 0; k < r.getIngredients().size(); k++){
                GroceryListObj.add((Ingredient) r.getIngredientsOneAtATime(k));
            }
        }

        combine();
        sort();
        condense();


        //tiffany below here please :) please generate check boxes instead of buttons
        //the sorted and condensed array list to use is Glsorted
        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        Button btn[] = new Button[GLsorted.size()];
        for(int i = 0; i < GLsorted.size(); i++) {
            Ingredient g = GLsorted.get(i);
            Log.d("myTag", "Ingredient2: "+ g.getName());
            final String n = g.getStringIngredient();
            Log.d("myTag", "Ingredient2: "+ g.getStringIngredient());
            btn[i] = new Button(this);
            btn[i].setText(n);
            btn[i].setTextSize(20);
            btn[i].setGravity(Gravity.CENTER);
            linearLayout.addView(btn[i]);
        }
        scrollView.addView(linearLayout);

        this.setContentView(scrollView);
       //this.setContentView(linearLayout, new LinearLayout.LayoutParams(
         //       LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));

        GroceryListObj.clear();
        GL.clear();
        Produce.clear();
        Dairy.clear();
        Meat.clear();
        Bakery.clear();
        CannedDryGoods.clear();
        Spices.clear();
        PastaRice.clear();
        Oilsauces.clear();
        SnacksCrackers.clear();
        Drinks.clear();
        GLsorted.clear();

    }
}
