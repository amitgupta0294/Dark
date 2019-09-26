package com.test.firebase.daynighttheme;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatDelegate;

public class BaseApplication extends Application {

    boolean x = true;
    SharedPreferences sp;

    @Override
    public void onCreate() {
        sp = getApplicationContext().getSharedPreferences("theme_pref", 0);
        getApplicationContext().setTheme(sp.getBoolean("night", false) ? R.style.NightTheme : R.style.DayTheme);
        super.onCreate();
    }
}
