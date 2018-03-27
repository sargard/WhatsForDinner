package com.example.sarahgardiner.whatsfordinner;

import java.util.ArrayList;

/**
 * Created by sarahgardiner on 3/11/18.
 */

public class Recipe {


    private String name;
    private String instructions;
    private String category;
    private ArrayList<Ingredient> ingredients;
    private int servings;
    private String IList;

    public Recipe(String name, String instructions, String category,
                  int servings, ArrayList<Ingredient> i, String a){
        this.name = name;
        this.instructions = instructions;
        this.category = category;
        this.servings = servings;
        this.ingredients = i;
        this.IList = a;
    }

    public Recipe(){
        name = null;
        instructions = null;
        category = null;
        servings = 0;
        ingredients = null;
        IList = null;
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

    public String getstrIngredients(){
        String answer = "";
        for (int i = 0; i < AddIngredientPage.IngredientList.size(); i++){
            Ingredient temp = AddIngredientPage.IngredientList.get(i);
            String a = temp.getStringIngredient();
            answer = answer + a + " \n";
        }
        IList = answer;
        return answer;
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

    public void addIngredients(Ingredient i){


    }

    public void setIngredients(ArrayList<Ingredient> i){
        ingredients = i;
    }

    public void addRecipeToFile(Recipe r) {

    }
}
