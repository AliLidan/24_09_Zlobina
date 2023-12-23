package com.example.zlobina_09_24;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_helper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Users.db";
    private static final int SCHEMA = 1;
    static final String TABLE = "User";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";

    public DB_helper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NAME + " TEXT NOT NULL" + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
