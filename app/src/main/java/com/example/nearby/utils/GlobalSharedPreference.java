package com.example.nearby.utils;


import android.content.Context;
import android.content.SharedPreferences;

public class GlobalSharedPreference {

    private  static GlobalSharedPreference instance;
    private static final String MY_PREFS_NAME = "MyPrefsWayyak";


    private GlobalSharedPreference() {

    }

    public static GlobalSharedPreference getInstance(){
        if(instance == null)
            instance= new GlobalSharedPreference();

        return instance;

    }

    public String getSavedString(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);

        return sharedPref.getString(key, "");
    }

    public void setSavedString(Context context, String key, String value) {
        SharedPreferences sharedPref = context.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void removeSavedString(Context context, String key) {
        SharedPreferences sharedPref = context.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove(key);
        editor.commit();
    }
}
