package com.example.jarek.stratcaller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class LocalTacticsEntity extends SQLiteOpenHelper {

    public final static String DB_NAME="tactics.db";                            //Database name
    public final static String TAC_TABLE="Tactics";                             //Table name

    public final static String TAC_ID = "id";                                   //Record ID
    public final static String TAC_NAME = "name";                               //Tactic name
    public final static String TAC_DESCRIPTION = "description";                 //Tactic description
    public final static String TAC_CATEGORY = "category";                       //Tactic category
    public final static String TAC_MINIMAP = "minimap";                         //Tactic minimap
    public final static String TAC_LEVEL = "level";                             //Map in game
    public final static String TAC_SIDE = "side";                               //Side in game
    public final static String TAC_DIFFICULTY = "difficulty";                   //Difficulty (1-5)
    public final static String TAC_AUTHOR = "author";                           //Author of tactic

    public LocalTacticsEntity(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TAC_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, CATEGORY TEXT, MINIMAP TEXT, LEVEL TEXT, SIDE TEXT, DIFFICULTY INTEGER, AUTHOR TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(LocalTacticsEntity.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("drop table if exists " + TAC_TABLE);
        onCreate(db);
    }

    //Insert data into database
    public boolean insertData(String name, String description, String category, String minimap, String level, String side, int difficulty, String author) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAC_NAME, name);
        contentValues.put(TAC_DESCRIPTION, description);
        contentValues.put(TAC_CATEGORY, category);
        contentValues.put(TAC_MINIMAP, minimap);
        contentValues.put(TAC_LEVEL, level);
        contentValues.put(TAC_SIDE, side);
        contentValues.put(TAC_DIFFICULTY, difficulty);
        contentValues.put(TAC_AUTHOR, author);
        long result = db.insert(TAC_TABLE, null, contentValues);
        return result != -1;
    }

    //Get all data from database
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TAC_TABLE, null);
        return res;
    }

    //Get requested data from database
    public Cursor getData(String level){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TAC_TABLE + " where TAC_LEVEL=" + level, null);
        return res;
    }
}

