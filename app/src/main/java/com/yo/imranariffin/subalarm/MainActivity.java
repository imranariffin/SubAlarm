package com.yo.imranariffin.subalarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
    public void goToNewActivity(View view) {
        Intent nActivityIntent = new Intent(this, NewActivity.class);
        startActivity(nActivityIntent);
    }
    public void goToAlarm(View view) {

        setContentView(R.layout.activity_main);
        Calendar t = Calendar.getInstance();
        t.add(Calendar.SECOND, 2);

        Intent aRingIntent = new Intent(this, AlarmRing.class);
        PendingIntent pending = PendingIntent.getActivity(
                this,
                1235,
                aRingIntent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );

        AlarmManager alarm = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
        alarm.set(
                AlarmManager.RTC_WAKEUP,
                t.getTimeInMillis(),
                pending
        );
    }
}
