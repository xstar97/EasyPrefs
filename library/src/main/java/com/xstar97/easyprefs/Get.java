package com.xstar97.easyprefs;

import android.content.SharedPreferences;
import java.util.Set;

class Get
{
    private SharedPreferences prefs;
    private String PREF_KEY = null;
    private Object PREF_VALUE = null;

    Get(SharedPreferences prefs, String key, Object value) {
        this.prefs = prefs;
        this.PREF_KEY = key;
        this.PREF_VALUE = value;
    }

    Get(SharedPreferences prefs){
        this.prefs = prefs;
    }

    Object getString(){
        return prefs.getString(PREF_KEY, (String) PREF_VALUE);
    }
    Object getBoolean(){
        return prefs.getBoolean(PREF_KEY, (Boolean) PREF_VALUE);
    }
    Object getStringSet(){
        return prefs.getStringSet(PREF_KEY, (Set<String>) PREF_VALUE);
    }
    Object getInt(){
        return prefs.getInt(PREF_KEY, (Integer) PREF_VALUE);
    }
    Object getFloat(){
        return prefs.getFloat(PREF_KEY, (Float) PREF_VALUE);
    }
    Object getLong(){
        return prefs.getLong(PREF_KEY, (Long) PREF_VALUE);
    }
    Object getAll(){
        return prefs.getAll();
    }
}
