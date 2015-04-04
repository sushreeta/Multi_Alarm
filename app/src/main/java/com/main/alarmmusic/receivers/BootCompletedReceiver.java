package com.main.alarmmusic.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.main.alarmmusic.Injector;
import com.main.alarmmusic.helpers.AlarmHelper;
import com.main.alarmmusic.models.Alarm;

import javax.inject.Inject;

public class BootCompletedReceiver extends BroadcastReceiver {
    @Inject AlarmHelper alarmHelper;

    @Override public void onReceive(Context context, Intent intent) {
        Log.d("BootCompletedReceiver", "Resetting all alarms");
        ((Injector) context.getApplicationContext()).inject(this);

        for (Alarm alarm : alarmHelper.getAll()) {
            Log.d("BootCompletedReceiver", "Setting alarm " + alarm.getId());
            alarmHelper.set(alarm);
        }
    }
}
