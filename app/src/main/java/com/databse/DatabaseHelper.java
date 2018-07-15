package com.databse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by android on 4/25/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "todo_aslist_updated.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_TODO_LIST = "todo_hasome";


    public static final String TABLE_CREATE_TODO_1 = "create table "  + TABLE_TODO_LIST + "( id "
            + " integer primary key autoincrement, title  text not null , data  text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_TODO_1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO_LIST);
    }
}
