package com.test.firebase.daynighttheme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    SharedPreferences sp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getApplicationContext().getSharedPreferences("theme_pref", 0);
        SecondActivity.this.setTheme(sp.getBoolean("night", false) ? R.style.NightTheme : R.style.DayTheme);
        setContentView(R.layout.activity_second);
    }
}
