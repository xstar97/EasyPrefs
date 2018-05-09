package com.xstar97.easyprefs.ui.fragments;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.xstar97.easyprefs.EasyPrefs;
import com.xstar97.easyprefs.R;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("FieldCanBeLocal")
//do not use this as an example...use 'PreferenceFragment' instead!
public class MainActivityFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
    private int PREF_STRING = 0;
    private int PREF_BOOLEAN = 1;
    private int PREF_SET = 2;
    private int PREF_INT = 3;
    private int PREF_FLOAT = 4;
    private int PREF_LONG = 5;

    private Spinner spinner;
    private TextView data;
    private EditText editText;
    private Button api_get, api_put;

    private boolean data_boolean = true;
    private Set<String> data_set = null;
    private int data_int = 100;
    private float data_float = 1.0f;
    private long data_long = 1000L;

    private static final String[] paths = {"String", "Boolean", "Set<String>", "int", "Float", "Long"};

    private String KEY_STRING = "key1";
    private String KEY_BOOLEAN = "key2";
    private String KEY_SET = "key3";
    private String KEY_INT = "key4";
    private String KEY_FLOAT = "key5";
    private String KEY_LONG = "key6";


    public MainActivityFragment() {
    }

    @Override public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
    @Override public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepareData(view);

    }

    private void put_api(Object object){
        int position = spinner.getSelectedItemPosition();

        EasyPrefs prefs = new EasyPrefs(getActivity());
        prefs.setPreference();
        if(position == PREF_BOOLEAN){
            prefs.setKey(KEY_BOOLEAN);
        } else if(position == PREF_SET){
            prefs.setKey(KEY_SET);
        } else if(position == PREF_INT){
            prefs.setKey(KEY_INT);
        } else if(position == PREF_FLOAT){
            prefs.setKey(KEY_FLOAT);
        } else if(position == PREF_LONG){
            prefs.setKey(KEY_LONG);
        }
        else {
            prefs.setKey(KEY_STRING);
        }
        prefs.setValue(object);
        prefs.put();
    }
    private Object get_api(){

        Set<String> set = new HashSet<>();
        set.add("s");
        set.add("h");
        set.add("i");
        set.add("t");

        long position = spinner.getSelectedItemPosition();

        EasyPrefs prefs = new EasyPrefs(getActivity());
        prefs.setPreference();

        if(position == PREF_BOOLEAN){
            prefs.setKey(KEY_BOOLEAN);
            prefs.setValue(false);//default to the same type value for "error" handling...
        } else if(position == PREF_SET){
            prefs.setKey(KEY_SET);
            prefs.setValue(set);//default to the same type value for "error" handling...
        } else if(position == PREF_INT){
            prefs.setKey(KEY_INT);
            prefs.setValue(10);//default to the same type value for "error" handling...
        } else if(position == PREF_FLOAT){
            prefs.setKey(KEY_FLOAT);
            prefs.setValue(12.5F);//default to the same type value for "error" handling...
        } else if(position == PREF_LONG){
            prefs.setKey(KEY_LONG);
            prefs.setValue(10000000L);//default to the same type value for "error" handling...
        }
        else {
            prefs.setKey(KEY_STRING);
            prefs.setValue("shiiiiitttttt");//default to the same type value for "error" handling...
        }
        return prefs.get();
    }

    private Set<String> data_set(){
        data_set = new HashSet<>();
        data_set.add("A");
        data_set.add("B");
        data_set.add("C");
        data_set.add("D");
        data_set.add("E");
        data_set.add("F");
        return data_set;
    }

    @SuppressWarnings("ConstantConditions")
    private void prepareData(View view){
        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        editText = view.findViewById(R.id.api_data);
        api_put = view.findViewById(R.id.api_put);
        api_get = view.findViewById(R.id.api_get);
        data = view.findViewById(R.id.load_api_data);

        api_put.setOnClickListener(this);
        api_get.setOnClickListener(this);
    }

    @Override public void onResume() {
        super.onResume();
    }
    @Override public void onStart() {
        super.onStart();
    }
    @Override public void onStop() {
        super.onStop();
    }
    @Override public void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.api_get:
                // Whatever you want to happen when the first item gets selected
                data.setText("data: " + get_api());
                break;
            case R.id.api_put:
                // Whatever you want to happen when the second item gets selected
                Object myData = editText.getText().toString();

                long position = spinner.getSelectedItemPosition();

                if(position == PREF_BOOLEAN){
                    put_api(data_boolean);
                } else if(position == PREF_SET){
                    put_api(data_set());
                } else if(position == PREF_INT){
                    put_api(data_int);
                } else if(position == PREF_FLOAT){
                    put_api(data_float);
                } else if(position == PREF_LONG){
                    put_api(data_long);
                }
                else {
                    put_api(myData);
                }
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position == PREF_STRING){
            editText.setEnabled(true);
            editText.setText("");
        } else if(id == PREF_BOOLEAN){
            editText.setEnabled(false);
            editText.setText("" + data_boolean);
        } else if(id == PREF_SET){
            editText.setEnabled(false);
            editText.setText("" + data_set());
        } else if(id == PREF_INT){
            editText.setEnabled(false);
            editText.setText("" + data_int);
        } else if(id == PREF_FLOAT){
            editText.setEnabled(false);
            editText.setText("" + data_float);
        } else if(id == PREF_LONG){
            editText.setEnabled(false);
            editText.setText("" + data_long);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}