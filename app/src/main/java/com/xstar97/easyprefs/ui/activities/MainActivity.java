package com.xstar97.easyprefs.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.xstar97.easyprefs.EasyPrefs;
import com.xstar97.easyprefs.R;

import java.util.Random;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity {

    private String KEY_STRING = "key1";
    private String KEY_BOOLEAN = "key2";
    private String KEY_SET = "key3";
    private String KEY_INT = "key4";
    private String KEY_FLOAT = "key5";
    private String KEY_LONG = "key6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Snackbar.make(view, "hello world: " + randomNumber(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
            }
        });

    }
    private int randomNumber(){
        Random random = new Random();
        return random.nextInt(5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        } else if (id == R.id.action_api_clear) {
            if(randomNumber() == 0){
                new EasyPrefs(MainActivity.this)
                        .setPreference()
                        .setKey(KEY_STRING)
                        .clearValue();
            } else if(randomNumber() == 1){
                new EasyPrefs(MainActivity.this)
                        .setPreference()
                        .setKey(KEY_BOOLEAN)
                        .clearValue();
            } else if(randomNumber() == 2){
                new EasyPrefs(MainActivity.this)
                        .setPreference()
                        .setKey(KEY_SET)
                        .clearValue();
            } else if(randomNumber() == 3){
                new EasyPrefs(MainActivity.this).
                        setPreference()
                        .setKey(KEY_INT)
                        .clearValue();
            } else if(randomNumber() == 4){
                new EasyPrefs(MainActivity.this)
                        .setPreference()
                        .setKey(KEY_FLOAT)
                        .clearValue();
            } else if(randomNumber() == 5){
                new EasyPrefs(MainActivity.this)
                        .setPreference()
                        .setKey(KEY_LONG)
                        .clearValue();
            }
            return true;
        } else if (id == R.id.action_api_clear_all) {
            new EasyPrefs(MainActivity.this)
                    .setPreference()
                    .clearAll();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
