package com.yo.imranariffin.subalarm;

import android.app.Application;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

public class SubAlarm extends Application {

    public static MySQLiteHelper dbHelper;
    public static SQLiteDatabase db;
    public static SharedPreferences sp;

    @Override
    public void onCreate () {
        super.onCreate();

//        PreferenceManager.setDefaultValues(this, R.xml.settings, false);
    }
}