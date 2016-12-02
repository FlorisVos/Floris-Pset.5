package com.example.floris.floris_pset_4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Floris on 11/23/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "TO_DO_LIST";

    // Table columns
    public static final String _ID = "_id";
    public static final String ITEM = "item";
//    public static final String DESC = "description";

    // Database Information
    static final String DB_NAME = "ToDoList.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ITEM + " TEXT);";

//    + " TEXT NOT NULL, " + DESC - was previously between ITEM and "TEXT);"

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // onCreate creates a new table

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    // onUpgrade will add new information to table

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
