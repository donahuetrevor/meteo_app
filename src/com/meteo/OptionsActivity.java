package com.meteo;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.meteo.R;


public class OptionsActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.options);
    }
}
