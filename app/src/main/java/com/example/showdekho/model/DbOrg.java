package com.example.showdekho.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOrg extends SQLiteOpenHelper {
    public DbOrg(Context context) {
        super(context, "movielist.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table MovieList (MovieName text primary key,Time text,Location text,Price int,Language text,Genre text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists MovieList");
    }

    public boolean insertmovie(String MovieName, String time, String loc, String price, String lang, String genre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MovieName", MovieName);
        contentValues.put("Time", time);
        contentValues.put("Location", loc);
        contentValues.put("Price", price);
        contentValues.put("Language", lang);
        contentValues.put("Genre", genre);

        long result = db.insert("MovieList", null, contentValues);
        return result != -1;
    }

    public boolean checkmoviename(String moviename) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from MovieList where moviename = ? ", new String[]{moviename});
        return cursor.getCount() > 0;
    }

    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from MovieList ", null);
        return cursor;
    }
}

