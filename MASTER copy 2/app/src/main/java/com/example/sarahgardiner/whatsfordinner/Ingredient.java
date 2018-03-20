package com.example.sarahgardiner.whatsfordinner;

/**
 * Created by sarahgardiner on 3/11/18.
 */

public class Ingredient {
    private String name;
    private String type;
    private int amount;

    public Ingredient(String n, String t, int a){
        name = n;
        type = t;
        amount = a;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public int getAmount(){
        return this.amount;
    }

    public void setName(String n){
        name = n;
    }

    public void setType(String t){
        type = t;
    }

    public void setAmount(int a){
        amount = a;
    }
}
