package com.xstar97.easyprefs;

import android.content.SharedPreferences;

import java.util.Set;

class Put
{
    private SharedPreferences.Editor editor;
    private String PREF_KEY = null;
    private Object PREF_VALUE = null;

    Put(SharedPreferences.Editor editor, String key, Object value){
        this.editor = editor;
        this.PREF_KEY = key;
        this.PREF_VALUE = value;
    }
    Put(SharedPreferences.Editor editor, String key){
        this.editor = editor;
        this.PREF_KEY = key;
    }
    Put(SharedPreferences.Editor  editor){
        this.editor = editor;
    }

    void putString(){
        editor.putString(PREF_KEY, (String) PREF_VALUE);
        editor.apply();
    }
    void putBoolean(){
        editor.putBoolean(PREF_KEY, (Boolean) PREF_VALUE);
        editor.apply();
    }
    void putStringSet(){
        editor.putStringSet(PREF_KEY, (Set<String>) PREF_VALUE);
        editor.apply();
    }
    void putInt(){
        editor.putInt(PREF_KEY, (Integer) PREF_VALUE);
        editor.apply();
    }
    void putFloat(){
        editor.putFloat(PREF_KEY, (Float) PREF_VALUE);
        editor.apply();
    }
    void putLong(){
        editor.putLong(PREF_KEY, (Long) PREF_VALUE);
        editor.apply();
    }
    void clearValue(){
        editor.remove(PREF_KEY);
        editor.apply();
    }
    void clearAll(){
        editor.clear();
        editor.apply();
    }
}