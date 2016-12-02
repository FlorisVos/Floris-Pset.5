package com.example.floris.floris_pset_4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Floris on 11/23/2016.
 */

// Might need a cursoradapter, see tutorial

public class DBManager {

    private DataBaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String item) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DataBaseHelper.ITEM, item);
        database.insert(DataBaseHelper.TABLE_NAME, null, contentValue);
    }

    // previously this formula had databasehelper.desc in it
    public Cursor fetch() {
        String[] columns = new String[] { DataBaseHelper._ID, DataBaseHelper.ITEM };
        Cursor cursor = database.query(DataBaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    // previously this formula had databasehelper.desc in it
    public int update(long _id, String item) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.ITEM, item);
//        contentValues.put(DatabaseHelper.DESC, desc);
        int i = database.update(DataBaseHelper.TABLE_NAME, contentValues, DataBaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DataBaseHelper.TABLE_NAME, DataBaseHelper._ID + "=" + _id, null);
    }

}