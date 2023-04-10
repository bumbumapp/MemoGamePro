package org.secuso.privacyfriendlymemory.common;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {
    private SharedPreferences sharedPreferences;

    public Preference(Context context) {
        sharedPreferences = context.getSharedPreferences("name", Context.MODE_PRIVATE);
    }

    public void putInteger(String key,int value) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInteger(String key) {
        return sharedPreferences.getInt(key, 1);
    }

   public void putIntegerHigh(String key,int value) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntegerHigh(String key) {
        return sharedPreferences.getInt(key, 0);
    }


}
