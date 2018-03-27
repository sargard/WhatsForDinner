package com.example.sarahgardiner.whatsfordinner;

import java.util.ArrayList;

/**
 * Created by sarahgardiner on 3/11/18.
 */

public class Ingredient {

    private String name;
    private String type;
<<<<<<< HEAD
    private String measurement;
=======
    private String measurment;
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
    private double amount;

    public Ingredient(String n, String t, String m, String a, int b){
        name = n;
        type = t;
<<<<<<< HEAD
        measurement = m;
=======
        measurment = m;
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
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
<<<<<<< HEAD
        else if(a.equals("1/8")){
=======
        else if(a.equals("1/8")) {
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
            temp = .125;
        }
        else if(a.equals("1/3")){
            temp = .333;
<<<<<<< HEAD
        }
        else if(a.equals("1/2")){
            temp = .5;
        }
=======
         }
        else if(a.equals("1/2")){
            temp = .5;
         }
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
        else if(a.equals("2/3")){
            temp = .666;
        }
        else {
            temp = .75;
        }
<<<<<<< HEAD

        amount = temp + b;
    }

    public Ingredient(){
        name = null;
        type = null;
        amount = 0;
        measurement = null;
=======
        amount = temp + b;
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
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

<<<<<<< HEAD
    public String getMeasurement(){ return this.measurement;}
=======
    public String getMeasurment() { return this.measurment; }
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63

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

    public void setMeasurement(String a){ measurement = a; }
}
