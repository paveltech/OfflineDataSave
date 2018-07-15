package com.databse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.pojo.DataItem;

import java.util.ArrayList;

/**
 * Created by android on 4/25/2017.
 */

public class DatabaseManager {

    public SQLiteDatabase sqLiteDatabase;
    public DatabaseHelper databaseHelper;
    public DataItem dataItem;


    public static final String id = "id";
    public DatabaseManager(Context context){
        databaseHelper = new DatabaseHelper(context);
        dataItem = new DataItem();

    }


    public void open() throws SQLException{
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }


    public DataItem createData(final DataItem dataItem){
        open();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("title" , dataItem.title);
        contentValues.put("data" , dataItem.data);
        final long id = sqLiteDatabase.insert(DatabaseHelper.TABLE_TODO_LIST , null , contentValues);
        dataItem.id = id;
        return dataItem;
    }

    public void createCheckList(String title , String details){
        dataItem.data =details;
        dataItem.title = title;
        createData(dataItem);
    }

    public ArrayList<DataItem> getCheckList(){
        open();
        final ArrayList<DataItem> arrayList = new ArrayList<>();
        final Cursor cursor = sqLiteDatabase.rawQuery("select * from " + DatabaseHelper.TABLE_TODO_LIST , null);
        cursor.moveToLast();
        while (!cursor.isBeforeFirst()) {
            final DataItem number = new DataItem();
            // Fetch the desired value from the Cursor by column index
            number.id = cursor.getLong(0);
            number.title = cursor.getString(1);
            number.data = cursor.getString(2);
            // Add the object filled with appropriate data into the list
            arrayList.add(number);
            // Move the Cursor pointer to next for the next record to fetch
            cursor.moveToPrevious();
        }

        return arrayList;
    }




}
