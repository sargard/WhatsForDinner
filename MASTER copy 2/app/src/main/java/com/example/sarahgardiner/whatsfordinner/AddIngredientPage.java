package com.example.sarahgardiner.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddIngredientPage extends AppCompatActivity {

<<<<<<< HEAD
    public static ArrayList<Ingredient> IngredientList;
=======
    public static ArrayList<Ingredient> IngredientList = new ArrayList<Ingredient>();
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient_page);
    }

    public void addIngredientPageButton(View view) {
<<<<<<< HEAD
        //kinda copy what was done in the create recipe page
=======
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
        EditText mEdit   = findViewById(R.id.iName);
        String IngredientName = mEdit.getText().toString();
        Log.d("myTag", "IngredientName: "+ IngredientName);

        Spinner Measurement = findViewById(R.id.iMeasurement);
        String IngredientMeasurement = Measurement.getSelectedItem().toString();

        Spinner fractions = findViewById(R.id.iFractions);
        String IngredientFractions = fractions.getSelectedItem().toString();
        //int F = Integer.parseInt(IngredientFractions);
        Log.d("myTag", "Fractions: "+ IngredientFractions);

        Spinner digits = findViewById(R.id.iDigits);
        String IngredientDigits = digits.getSelectedItem().toString();
        int D = Integer.parseInt(IngredientDigits);
        Log.d("myTag", "Fractions: "+ D);

        Spinner type = findViewById(R.id.iType);
        String IngredientType = type.getSelectedItem().toString();

        Log.d("myTag", "IngredientType: "+ IngredientType);

        Ingredient I = new Ingredient(IngredientName, IngredientType, IngredientMeasurement,
                IngredientFractions, D);
        //I.setAmount(IngredientFractions, D);
        //I.setName(IngredientName);
        //I.setType(IngredientType);
<<<<<<< HEAD
       // I.setMeasurement(IngredientMeasurement);

        //IngredientList.add(I);

        String msg5 = "Ingredient Added";
        Toast toast5 = Toast.makeText(this, msg5, Toast.LENGTH_LONG);
        toast5.show();
=======
        // I.setMeasurement(IngredientMeasurement);

        AddIngredientPage.IngredientList.add(I);


        String msg = "Ingredient Added";
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
>>>>>>> c144b7b144cee96ce15dad3cc6bc1731054c8d63
        finish();
    }


}
