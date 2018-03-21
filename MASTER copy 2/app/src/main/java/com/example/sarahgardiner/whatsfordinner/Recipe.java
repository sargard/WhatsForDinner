package com.example.sarahgardiner.whatsfordinner;

import java.util.ArrayList;

/**
 * Created by sarahgardiner on 3/11/18.
 */

public class Recipe {


    private String name;
    private String instructions;
    private String category;
<<<<<<< HEAD
    private ArrayList<Ingredient> ingredients;
    private int servings;

    public Recipe( String name, String instructions, String category, int servings, ArrayList<Ingredient> i){
=======
    private ArrayList ingredients;
    private int servings;

    public Recipe(String name, String instructions, String category,
                  int servings, ArrayList<Ingredient> i){
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
        this.name = name;
        this.instructions = instructions;
        this.category = category;
        this.servings = servings;
        this.ingredients = i;
<<<<<<< HEAD
=======
    }

    public Recipe(){
        name = null;
        instructions = null;
        category = null;
        servings = 0;
        ingredients = null;
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
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
<<<<<<< HEAD
        return this.ingredients;
=======
         return this.ingredients;
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
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
<<<<<<< HEAD

    public void addIngredients(Ingredient i){


    }
=======
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63

    public void setIngredients(ArrayList<Ingredient> i){
        ingredients = i;
    }

    public void addRecipeToFile(Recipe r) {

    }
}
