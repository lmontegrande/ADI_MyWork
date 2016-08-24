package com.example.lmont.sqlliteopenhelperdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by lmont on 8/23/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;

    public static final String DATABASE_NAMES = "games.db";
    public static final String
            GAME_TABLE_NAME = "games",
            GAME_COLUMN_ID = "_id",
            GAME_COLUMN_NAME = "name",
            GAME_COLUMN_YEAR = "year";

    public static final String SQL_CREATE_GAME_TABLE =
            "CREATE TABLE " +
            GAME_TABLE_NAME + "(" +
            GAME_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GAME_COLUMN_NAME + " TEXT, " +
            GAME_COLUMN_YEAR + " TEXT)";

    public static final String SQL_DROP_GAME_TABLE =
            "DROP TABLE IF EXISTS " + GAME_TABLE_NAME;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_GAME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_GAME_TABLE);
        onCreate(sqLiteDatabase);
    }

    public int insert(String name, String year) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GAME_COLUMN_NAME, name);
        values.put(GAME_COLUMN_YEAR, year);
        return (int) db.insert(GAME_TABLE_NAME, null, values);
    }

    public Game get(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = new String[] {GAME_COLUMN_ID, GAME_COLUMN_NAME, GAME_COLUMN_YEAR};
        String selection = GAME_COLUMN_ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = db.query(GAME_TABLE_NAME, projection, selection, selectionArgs, null, null, null);

        cursor.moveToFirst();
        String name = cursor.getString(cursor.getColumnIndex(GAME_COLUMN_NAME));
        String year = cursor.getString(cursor.getColumnIndex(GAME_COLUMN_YEAR));

        return new Game(id, name, year);
    }

    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();

        String selection = GAME_COLUMN_ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete(GAME_TABLE_NAME, selection, selectionArgs);
    }

    public Cursor getExampleList() {
        return getReadableDatabase().rawQuery("SELECT * FROM " + GAME_TABLE_NAME, null);
    }
}
