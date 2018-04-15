package com.dinner.sarahgardiner.whatsfordinner;

import android.util.Log;

import java.net.*;
import java.io.*;
import java.lang.String;

public class LoginHandler {

    private static final String TAG = LoginHandler.class.getSimpleName();

    public LoginHandler(){

    }
    public String makeServiceCall(String inputURL){
        String response = null;
        try{
            URL url = new URL(inputURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = convertToString(in);
        }
        catch (MalformedURLException error){
            Log.e(TAG, "MalformedURLException: "+error.getMessage());
        }
        catch (ProtocolException error){
            Log.e(TAG, "ProtocolException: "+error.getMessage());
        }
        catch (IOException error) {
            Log.e(TAG, "IOException: " + error.getMessage());
        }
        /*catch (Exception error) {
            Log.e(TAG, "1Exception: " + error.getMessage());
        }*/
        return response;
    }
    private String convertToString(InputStream in){
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        String line;
        try{
            while((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        catch (IOException error) {
            error.printStackTrace();
        }
        finally {
            try{
                in.close();
            } catch (IOException error) {
                error.printStackTrace();
            }
        }
        return sb.toString();
    }
}
