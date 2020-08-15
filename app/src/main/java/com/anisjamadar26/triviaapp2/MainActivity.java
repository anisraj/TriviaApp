package com.anisjamadar26.triviaapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * here is main launch activity, here i just show splash screen for
 * two seconds, but in real app we can show splash screen until our data loads from server.
 * After two seconds it goes to Trivia Activity
 * */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * hiding action bar to get full screen view
         */

        getSupportActionBar().hide();

        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2*1000);
                    Intent intent = new Intent(MainActivity.this, TriviaActivity.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}