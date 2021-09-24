package com.max.def.viewtutorials;

import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.afollestad.appthemeengine.ATEActivity;

public class BaseThemedActivity extends ATEActivity
{
    @Nullable
    @Override
    public String getATEKey()
    {

        return PreferenceManager.getDefaultSharedPreferences(this).getBoolean("dark_theme",false) ? "dark_theme" : "light_theme";
    }
}
