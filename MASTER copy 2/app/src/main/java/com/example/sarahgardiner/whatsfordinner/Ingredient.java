package com.example.sarahgardiner.whatsfordinner;

import java.util.ArrayList;

/**
 * Created by sarahgardiner on 3/11/18.
 */

public class Ingredient {

    private String name;
    private String type;
    private String measurment;
    private double amount;

    public Ingredient(String n, String t, String m, String a, int b){
        name = n;
        type = t;
        measurment = m;
        double temp = 0;
        if(a.equals("0")){
            temp = 0;
        }
        else if(a.equals("1/4")){
            temp = .24;
        }
        else if(a.equals("1/16")){
            temp = .0625;
        }
        else if(a.equals("1/8")){
            temp = .125;
        }
        else if(a.equals("1/3")){
            temp = .333;
        }
        else if(a.equals("1/2")){
            temp = .5;
        }
        else if(a.equals("1/2")){
            temp = .5;
         }
        else if(a.equals("2/3")){
            temp = .666;
        }
        else {
            temp = .75;
        }
        amount = temp + b;
    }

    public Ingredient(){
        name = null;
        type = null;
        amount = 0;
        measurment = null;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getMeasurement(){ return this.measurment;}

    public String getMeasurment() { return this.measurment; }

    public String  getStringIngredient(){
        String answer = "";
        answer = amount + " "+ measurment +" "+ name;
        return answer;
    }

    public void setName(String n){
        name = n;
    }

    public void setType(String t){
        type = t;
    }

    public void setAmount(String a, double b){
        double temp = 0;
        if(a.equals("0")){
            temp = 0;
        }
        else if(a.equals("1/4")){
            temp = .24;
        }
        else if(a.equals("1/16")){
            temp = .0625;
        }
        else if(a.equals("1/8")){
            temp = .125;
        }
        else if(a.equals("1/3")){
            temp = .333;
        }
        else if(a.equals("1/2")){
            temp = .5;
        }
        else if(a.equals("2/3")){
            temp = .666;
        }
        else {
            temp = .75;
        }

        amount = temp + b;

    }

    public void setMeasurement(String a){ measurment = a; }
}
