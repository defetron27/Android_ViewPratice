package com.max.def.viewtutorials;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.View;

import com.afollestad.appthemeengine.Config;
import com.afollestad.appthemeengine.prefs.ATEColorPreference;

public class SettingsActivity extends BaseThemedActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null)
        {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new SettingsFragment()).commit();
        }
        else
        {
            SettingsFragment fragment = (SettingsFragment) getFragmentManager().findFragmentById(R.id.content_frame);
            if (fragment != null)
            {
                fragment.invalidateSettings();
            }
        }
    }

    public static class SettingsFragment extends PreferenceFragment
    {
        @Override
        public void onCreate( Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState)
        {
            super.onViewCreated(view, savedInstanceState);

            invalidateSettings();
        }

        public void invalidateSettings()
        {
            String ateKey= ((SettingsActivity)getActivity()).getATEKey();

            ATEColorPreference primaryColorPreference = (ATEColorPreference) findPreference("primary_color");
            primaryColorPreference.setColor(Config.primaryColor(getActivity(),ateKey),Color.BLACK);
            primaryColorPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener()
            {
                @Override
                public boolean onPreferenceClick(Preference preference)
                {
                    new ColorChooser
                    return false;
                }
            });
        }
    }
}
