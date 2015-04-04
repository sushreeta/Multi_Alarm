package com.main.alarmmusic.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.main.alarmmusic.Injector;

public class DaybreakBaseActivity extends ActionBarActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((Injector) getApplication()).inject(this);
    }
}
