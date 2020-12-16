package com.radchenko.lab5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MySqlHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "usersDB";
    public static final String TABLE_CONTACTS = "users";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_SURNAME = "surname";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_ADDRESS = "address";

    private static final String SQL_CREATE_ENTRIES =
            "create table " + TABLE_CONTACTS +
                    "( " + KEY_ID + " integer primary key autoincrement, " +
                        KEY_NAME + " text, " +
                        KEY_SURNAME + " text, " +
                        KEY_EMAIL + " text, " +
                        KEY_ADDRESS + " text )";
    private static final String SQL_DELETE_ENTRIES = "drop table if exists " + TABLE_CONTACTS + ";";

    public MySqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("Radchenko", SQL_CREATE_ENTRIES);
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
