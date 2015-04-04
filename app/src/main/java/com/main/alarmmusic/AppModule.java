package com.main.alarmmusic;

import com.main.alarmmusic.helpers.AlarmHelper;
import com.main.alarmmusic.receivers.AlarmReceiver;
import com.main.alarmmusic.receivers.BootCompletedReceiver;
import com.main.alarmmusic.ui.AlarmActivity;
import com.main.alarmmusic.ui.AlarmListActivity;
import com.main.alarmmusic.ui.EditAlarmActivity;

import dagger.Module;

@Module(
        injects = {
                EditAlarmActivity.class,
                AlarmListActivity.class,
                AlarmActivity.class,
                AlarmHelper.class,
                AlarmReceiver.class,
                BootCompletedReceiver.class
        },
        complete = false
)
public class AppModule {
}