package com.test.firebase.daynighttheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonNext;
    TextView textNext;

    SharedPreferences sp ;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getApplicationContext().getSharedPreferences("theme_pref", 0);
        MainActivity.this.setTheme(sp.getBoolean("night", false) ? R.style.NightTheme : R.style.DayTheme);
        setContentView(R.layout.activity_main);

        editor = sp.edit();
        buttonNext = findViewById(R.id.button_next);
        textNext = findViewById(R.id.text_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (sp.getBoolean("night", false)) {
                    editor.putBoolean("night", false).apply();
                } else {
                    editor.putBoolean("night", true).apply();
                }

                recreate();
            }
        });

        textNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}
