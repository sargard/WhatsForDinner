package com.dinner.sarahgardiner.whatsfordinner;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class loginpage extends AppCompatActivity {

    private static final String TAG = LoginHandler.class.getSimpleName();
    public static String uname;
    boolean goodUserLogin = false;
    boolean goodAdminLogin = false;
    boolean userClick = false;
    boolean adminClick = false;
    ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        //Intent intent = new Intent(this, UserMenu.class);
    }

    public void onadminClick(View view) throws PackageManager.NameNotFoundException {
        EditText mEdit   = (EditText)findViewById(R.id.username);
        uname = mEdit.getText().toString().toLowerCase();
        Log.d("myTag", "username: "+ uname);
        String filename = uname + "Week.ser";
        adminClick = true;
        new LoginExecute().execute();
    }
    public void onUserClick(View view) {
        Log.d(TAG,"\n\n\n\n\n"+"          1            "+"\n\n\n\n\n");
        userClick = true;
        new LoginExecute().execute();
        Log.d(TAG,"\n\n\n\n\n"+"          2            "+"\n\n\n\n\n");
        Log.d(TAG,"\n\n\n\n\n"+"          5            "+"\n\n\n\n\n");
    }

    private class LoginExecute extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(loginpage.this);
            pDialog.setMessage("logging in...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            LoginHandler lh = new LoginHandler();
            String username;
            String password;
            EditText uEdit = (EditText)findViewById(R.id.username);
            username = uEdit.getText().toString().toLowerCase();
            EditText pEdit = (EditText)findViewById(R.id.password);
            password = pEdit.getText().toString();
            Log.d(TAG,"\n\n\n\n\n"+username+"\n\n\n\n\n");
            Log.d(TAG,"\n\n\n\n\n"+password+"\n\n\n\n\n");
            String jsonString = null;
            jsonString = lh.makeServiceCall("https://cpsc-350-psethr.c9users.io:8082/login?username="+username+"&password="+password);
            Log.d(TAG,"\n\n\n\n\n"+jsonString+"\n\n\n\n\n");

            if(jsonString != null)
            {
                try {
                    JSONObject ob = new JSONObject(jsonString);
                    Log.d(TAG,"\n\n\n\n\n"+ob.get("status")+"\n\n\n\n\n");
                    if(userClick && ob.get("status").equals("user login pass") && ob.get("admin").equals("no"))
                    {
                        Log.d(TAG,"\n\n\n\n\n"+"Inside"+"\n\n\n\n\n");
                        goodUserLogin = true;
                        Log.d(TAG,"\n\n\n\n\n"+"goodUserLogin"+goodUserLogin+"\n\n\n\n\n");
                    }
                    else if(adminClick && ob.get("status").equals("user login pass") && ob.get("admin").equals("yes"))
                    {
                        goodAdminLogin = true;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            userClick = false;
            adminClick = false;
            if(pDialog.isShowing())
            {
                pDialog.dismiss();
            }
            if(goodUserLogin)
            {
                goodUserLogin = false;
                Log.d(TAG,"\n\n\n\n\n"+"          3            "+"\n\n\n\n\n");
                Intent intent2 = new Intent(loginpage.this, UserMenu.class);
                startActivity(intent2);
                Log.d(TAG,"\n\n\n\n\n"+"          4            "+"\n\n\n\n\n");
            }
            else if(goodAdminLogin)
            {
                goodAdminLogin = false;
                Intent intent3 = new Intent(loginpage.this, adminMenu.class);
                startActivity(intent3);
            }
            else
            {
                Toast.makeText(loginpage.this, "Incorrect Login", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
//      /data/data/com.example.sarahgardiner.whatsfordinner

//      /data/data/com.example.sarahgardiner.whatsfordinner/files/Recipes.ser

