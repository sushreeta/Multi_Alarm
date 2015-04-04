package com.main.alarmmusic.ui;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.main.alarmmusic.R;

import java.util.ArrayList;

public class MusicActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private MediaPlayer mp;
    public static ArrayList<String> items = new ArrayList<String>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        listView = (ListView) findViewById(R.id.listView);

        items.add("Om");
        items.add("Om Sai");
        items.add("Gaytri Mantra");
        items.add("Ganesh Mantra");
        items.add("Hare Krishna");
        items.add("Om Jai Jagdish");
        items.add("Hanuman Mantra");


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        String currentItem = listView.getItemAtPosition(position).toString();
        int resId = 0;
        if(currentItem=="Om"){
            resId = R.raw.a;
        }
        if(currentItem=="Om Sai"){
            resId = R.raw.b;
        }
        if(currentItem=="Gaytri Mantra"){
            resId = R.raw.c;
        }
        if(currentItem=="Ganesh Mantra"){
            resId = R.raw.d;
        }
        if(currentItem=="Hare Krishna"){
            resId = R.raw.e;
        }
        if(currentItem=="Om Jai Jagdish"){
            resId = R.raw.f;
        }
        if(currentItem=="Hanuman Mantra"){
            resId = R.raw.g;
        }


        if (mp !=null){
            mp.release();
        }
        mp = MediaPlayer.create(this, resId);
        mp.start();
        Context context = getApplicationContext();
        CharSequence text = "Press BACK To Exit!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }



    @Override
    protected void onDestroy() {
        if(null!=mp){
            mp.release();
        }
        super.onDestroy();
    }
}
