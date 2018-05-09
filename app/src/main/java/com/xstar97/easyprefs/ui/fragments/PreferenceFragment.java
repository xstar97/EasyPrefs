package com.xstar97.easyprefs.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xstar97.easyprefs.EasyPrefs;
import com.xstar97.easyprefs.R;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.xstar97.easyprefs.EasyPrefs.MODE_PRIVATE;

@SuppressWarnings("unused")
public class PreferenceFragment extends Fragment
{
    public PreferenceFragment() {
    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_preference, container, false);
    }
    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    //DEFAULT PUT METHODS
    private void putString(){
        new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key1")
                .setValue("hello")
                .put();
    }
    private void putBoolean(){
        new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key2")
                .setValue(true)
                .put();
    }
    private void putSet(){
        HashSet<String> data_set = new HashSet<>();
        data_set.add("A");
        data_set.add("B");
        data_set.add("C");
        data_set.add("D");
        data_set.add("E");
        data_set.add("F");

        new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .put();
    }
    private void putInt(){
        new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key4")
                .setValue(100)
                .put();
    }
    private void putFloat(){
        new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key5")
                .setValue(100.0F)
                .put();
    }
    private void putLong(){
        new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key6")
                .setValue(10L)
                .put();
    }

    //DEFAULT GET METHODS
    private String getString(){
        return (String) new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key1")
                .setValue("noo....")
                .get();
    }
    private boolean getBoolean(){
        return (boolean) new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key2")
                .setValue(false)
                .get();
    }
    @SuppressWarnings("unchecked")
    private Set<String> getSet(){
        HashSet<String> data_set = new HashSet<>();
        data_set.add("S");
        data_set.add("H");
        data_set.add("I");
        data_set.add("T");
        return (Set<String>) new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .get();
    }
    private Integer getInt(){
        return (Integer) new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key4")
                .setValue(-1)
                .get();
    }
    private Float getFloat(){
        HashMap map = new HashMap();
        return (Float) new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key5")
                .setValue(1.0F)
                .get();
    }
    private Long getLong(){
        return (Long) new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key6")
                .setValue(100L)
                .get();
    }

    //CUSTOM PUT METHODS
    private void putString2(){
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key1")
                .setValue("hello")
                .put();
    }
    private void putBoolean2(){
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key2")
                .setValue(true)
                .put();
    }
    private void putSet2(){
        HashSet<String> data_set = new HashSet<>();
        data_set.add("A");
        data_set.add("B");
        data_set.add("C");
        data_set.add("D");
        data_set.add("E");
        data_set.add("F");

        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .put();
    }
    private void putInt2(){
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key4")
                .setValue(100)
                .put();
    }
    private void putFloat2(){
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key5")
                .setValue(100.0F)
                .put();
    }
    private void putLong2(){
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key6")
                .setValue(10L)
                .put();
    }

    //CUSTOM GTT METHODS
    private String getString2(){
        return (String) new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key1")
                .setValue("noo....")
                .get();
    }
    private boolean getBoolean2(){
        return (boolean) new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key2")
                .setValue(false)
                .get();
    }
    @SuppressWarnings("unchecked")
    private Set<String> getSet2(){
        HashSet<String> data_set = new HashSet<>();
        data_set.add("S");
        data_set.add("H");
        data_set.add("I");
        data_set.add("T");

        return (Set<String>) new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key3")
                .setValue(data_set)
                .get();
    }
    private Integer getInt2(){
        return (Integer) new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key4")
                .setValue(-1)
                .get();
    }
    private Float getFloat2(){
        HashMap map = new HashMap();
        return (Float) new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key5")
                .setValue(1.0F)
                .get();
    }
    private Long getLong2(){
        return (Long) new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key6")
                .setValue(100L)
                .get();
    }

    //DEFAULT GET ALL METHOD
    private Map<String, Object> getAll(){
        return new EasyPrefs(getActivity())
                .setPreference()
                .getAll();
    }

    //CUSTOM GET ALL METHOD
    private Map<String, Object> getAll2(){
        return new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .getAll();
    }

    //DEFAULT CLEAR METHODS
    private void clearValue(){
        new EasyPrefs(getActivity())
                .setPreference()
                .setKey("key1")
                .clearValue();
    }
    private void clearAll(){
        new EasyPrefs(getActivity())
                .setPreference()
                .clearAll();
    }

    //CUSTOM CLEAR METHODS
    private void clearValue2(){
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .setKey("key1")
                .clearValue();
    }
    private void clearAll2(){
        new EasyPrefs(getActivity())
                .setPreferenceName("test")
                .setMode(MODE_PRIVATE)
                .setPreference()
                .clearAll();
    }
}