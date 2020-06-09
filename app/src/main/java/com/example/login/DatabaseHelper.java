package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper  extends SQLiteOpenHelper {

    public static final String LOGIN_TABLE = "LOGIN_TABLE";
    public static final String Column_USERNAME = "username";
    public static final String Column_PASSWORD = "password";
    public static final String Column_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "UserDetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtableStatement = "CREATE TABLE " + LOGIN_TABLE + " (" + Column_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Column_USERNAME + " TEXT, " + Column_PASSWORD + " INT)";

        db.execSQL(createtableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Column_USERNAME, userModel.getUsername());
        cv.put(Column_PASSWORD, userModel.getPassword());

        long insert = db.insert(LOGIN_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
}
