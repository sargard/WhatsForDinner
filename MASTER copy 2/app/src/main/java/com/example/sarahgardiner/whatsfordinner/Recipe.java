package com.example.sarahgardiner.whatsfordinner;

import java.util.ArrayList;

/**
 * Created by sarahgardiner on 3/11/18.
 */

public class Recipe {
    private String name;
    private String instructions;
    private String category;
    private ArrayList ingredients;
    private int servings;

    public Recipe(String name, String instructions, String category,
                  int servings, ArrayList<Ingredient> i){
        this.name = name;
        this.instructions = instructions;
        this.category = category;
        this.servings = servings;
        this.ingredients = i;
    }

    public String getName(){
        return this.name;
    }

    public String getInstructions(){
        return this.instructions;
    }

    public String getCategory(){
        return this.category;
    }

    public int getServings(){
        return this.servings;
    }

    public ArrayList getIngredients(){
         return this.ingredients;
    }

    public void setName(String n){
        name = n;
    }

    public void setInstructions(String i){
        instructions = i;
    }

    public void setCategory(String c){
        category = c;
    }

    public void setServings(int s){
        servings = s;
    }

    public void setIngredients(ArrayList<Ingredient> i){
        ingredients = i;
    }

    public void addRecipeToFile(Recipe r) {

    }
}
