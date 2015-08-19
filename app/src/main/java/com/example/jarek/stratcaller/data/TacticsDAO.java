package com.example.jarek.stratcaller.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class TacticsDAO extends SQLiteOpenHelper {

    public final static String DB_NAME="tactics.db";                            //Database name
    public final static String TAC_TABLE="Tactics";                             //Table name

    public TacticsDAO(Context context) {
        super(context, DB_NAME, null, 1);
    }

    //Tactics table columns
    public final static String TAC_ID = "id";                                   //Record ID
    public final static String TAC_NAME = "name";                               //Tactic name
    public final static String TAC_DESCRIPTION = "description";                 //Tactic description
    public final static String TAC_CATEGORY = "category";                       //Tactic category
    public final static String TAC_MINIMAP = "minimap";                         //Tactic minimap
    public final static String TAC_LEVEL = "level";                             //Map in game
    public final static String TAC_SIDE = "side";                               //Side in game
    public final static String TAC_DIFFICULTY = "difficulty";                   //Difficulty (1-5)
    public final static String TAC_AUTHOR = "author";                           //Author of tactic

    private static final String[] COLUMNS = {TAC_ID,TAC_NAME,TAC_DESCRIPTION,TAC_CATEGORY,TAC_MINIMAP,TAC_LEVEL,TAC_SIDE,TAC_DIFFICULTY,TAC_AUTHOR};

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL statement to create tactics table
        String CREATE_TACTICS_TABLE = "CREATE TABLE " + TAC_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DESCRIPTION TEXT, CATEGORY TEXT, MINIMAP TEXT, LEVEL TEXT, SIDE TEXT, DIFFICULTY INTEGER, AUTHOR TEXT)";
        //Create tactics table
        db.execSQL(CREATE_TACTICS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older tactics table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TAC_TABLE);
        //Create fresh tactics table
        this.onCreate(db);
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

    //Get requested data by level and side
    public List<TacticsEntity> getData(String level, String side){

        List<TacticsEntity> tacticsEntityByLevelSide = new LinkedList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        //Database query (table, column names, selections, selections args, group by, having, order by, limit)
        Cursor cursor = db.query(TAC_TABLE, COLUMNS, " level = ? AND side = ?", new String[] { String.valueOf(level), String.valueOf(side) }, null, null, null, null);

        //Build list of tactics objects
        TacticsEntity tacticsEntity;
        if (cursor.moveToFirst()) {
            do {
                tacticsEntity = new TacticsEntity();
                tacticsEntity.setId(Integer.parseInt(cursor.getString(0)));
                tacticsEntity.setName(cursor.getString(1));
                tacticsEntity.setDescription(cursor.getString(2));
                tacticsEntity.setCategory(cursor.getString(3));
                tacticsEntity.setMinimap(cursor.getString(4));
                tacticsEntity.setLevel(cursor.getString(5));
                tacticsEntity.setSide(cursor.getString(6));
                tacticsEntity.setDifficulty(Integer.parseInt(cursor.getString(7)));
                tacticsEntity.setAuthor(cursor.getString(8));

                tacticsEntityByLevelSide.add(tacticsEntity);

            } while (cursor.moveToNext());
        }

        Log.d("getData("+level+","+side+")", tacticsEntityByLevelSide.toString());
        return tacticsEntityByLevelSide;
    }

    //Get all data
    public List<TacticsEntity> getAllData() {

        List<TacticsEntity> allTacticsEntity = new LinkedList<>();

        String query = "SELECT * FROM " + TAC_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //Build list of tactics objects
        TacticsEntity tacticsEntity;
        if (cursor.moveToFirst()) {
            do {
                tacticsEntity = new TacticsEntity();
                tacticsEntity.setId(Integer.parseInt(cursor.getString(0)));
                tacticsEntity.setName(cursor.getString(1));
                tacticsEntity.setDescription(cursor.getString(2));
                tacticsEntity.setCategory(cursor.getString(3));
                tacticsEntity.setMinimap(cursor.getString(4));
                tacticsEntity.setLevel(cursor.getString(5));
                tacticsEntity.setSide(cursor.getString(6));
                tacticsEntity.setDifficulty(Integer.parseInt(cursor.getString(7)));
                tacticsEntity.setAuthor(cursor.getString(8));

                allTacticsEntity.add(tacticsEntity);

            } while (cursor.moveToNext());
        }

        Log.d("getAllData()", allTacticsEntity.toString());
        return allTacticsEntity;
    }
}
