package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Userdetails.db";
    public static final String LOGIN_TABLE = "LOGIN_TABLE";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Userdetails.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + LOGIN_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," + USERNAME + " TEXT, " + PASSWORD + " CHAR)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ LOGIN_TABLE);
        onCreate(db);
    }
    public String insertData(String username, Character password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME,USERNAME);
        contentValues.put(PASSWORD,PASSWORD);

        long result = db.insert(LOGIN_TABLE,null,contentValues);
        if(result == -1)
            return "Welcome t Tour Guide App";
        else
            return "Invalid Credentials ";

    }

}
