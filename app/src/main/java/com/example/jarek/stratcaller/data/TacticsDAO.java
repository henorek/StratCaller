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

    private final static String DB_NAME="tactics.db";                            //Database name
    private final static String TAC_TABLE="Tactics";                             //Table name

    public TacticsDAO(Context context) {
        super(context, DB_NAME, null, 1);
    }

    //Tactics table columns
    private final static String TAC_ID = "_id";                                  //Record ID
    private final static String TAC_ICON = "ICON";                               //Tactic icon
    private final static String TAC_NAME = "NAME";                               //Tactic name
    private final static String TAC_DESCRIPTION = "DESCRIPTION";                 //Tactic description
    private final static String TAC_CATEGORY = "CATEGORY";                       //Tactic category
    private final static String TAC_MINIMAP = "MINIMAP";                         //Tactic minimap
    private final static String TAC_LEVEL = "LEVEL";                             //Map in game
    private final static String TAC_SIDE = "SIDE";                               //Side in game
    private final static String TAC_DIFFICULTY = "DIFFICULTY";                   //Difficulty (1-5)
    private final static String TAC_GRANADES = "GRANADES";                       //Amount of necessary granades (0-5)
    private final static String TAC_FLASHES = "FLASHES";                         //Amount of necessary flashes (0-5)
    private final static String TAC_SMOKES = "SMOKES";                           //Amount of necessary smokes (0-5)
    private final static String TAC_MOLOTOVS = "MOLOTOVS";                       //Amount of necessary molotovs (0-5)
    private final static String TAC_DECOYS = "DECOYS";                           //Amount of necessary decoys (0-5)
    private final static String TAC_AUTHOR = "AUTHOR";                           //Author of tactic

    private static final String[] COLUMNS = {TAC_ID,TAC_ICON,TAC_NAME,TAC_DESCRIPTION,TAC_CATEGORY,TAC_MINIMAP,TAC_LEVEL,TAC_SIDE,TAC_DIFFICULTY,TAC_GRANADES,TAC_FLASHES,TAC_SMOKES,TAC_MOLOTOVS,TAC_DECOYS,TAC_AUTHOR};
    private static final String[] COLUMNS_SHORT = {TAC_NAME,TAC_GRANADES,TAC_FLASHES,TAC_SMOKES,TAC_MOLOTOVS,TAC_DECOYS};

    public static String[] getCOLUMNS_SHORT() {
        return COLUMNS_SHORT;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL statement to create tactics table
        String CREATE_TACTICS_TABLE = "CREATE TABLE " + TAC_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, ICON TEXT, NAME TEXT, DESCRIPTION TEXT, CATEGORY TEXT, MINIMAP TEXT, LEVEL TEXT, SIDE TEXT, DIFFICULTY INTEGER, GRANADES INTEGER, FLASHES INTEGER, SMOKES INTEGER, MOLOTOVS INTEGER, DECOYS INTEGER, AUTHOR TEXT, UNIQUE (NAME))";
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
    public boolean insertData(String icon, String name, String description, String category, String minimap, String level, String side, int difficulty, int granades, int flashes, int smokes, int molotovs, int decoys, String author) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TAC_ICON, icon);
        contentValues.put(TAC_NAME, name);
        contentValues.put(TAC_DESCRIPTION, description);
        contentValues.put(TAC_CATEGORY, category);
        contentValues.put(TAC_MINIMAP, minimap);
        contentValues.put(TAC_LEVEL, level);
        contentValues.put(TAC_SIDE, side);
        contentValues.put(TAC_DIFFICULTY, difficulty);
        contentValues.put(TAC_GRANADES, decoys);
        contentValues.put(TAC_FLASHES, granades);
        contentValues.put(TAC_SMOKES, flashes);
        contentValues.put(TAC_MOLOTOVS, smokes);
        contentValues.put(TAC_DECOYS, molotovs);
        contentValues.put(TAC_AUTHOR, author);
        long result = db.insert(TAC_TABLE, null, contentValues);
        db.close();
        if (result != -1) return true;
        else return false;
    }

    //Get requested data by id
    public TacticsEntity getDataById(Long id){

        SQLiteDatabase db = this.getReadableDatabase();

        //Database query (table, column names, selections, selections args, group by, having, order by, limit)
        Cursor cursor = db.query(TAC_TABLE, COLUMNS, " _id = ?", new String[] { String.valueOf(id) }, null, null, null, null);

        //Build tactic object
        TacticsEntity tacticsEntity;
        if (cursor.moveToFirst()) {
            do {
                tacticsEntity = new TacticsEntity();
                tacticsEntity.setId(Integer.parseInt(cursor.getString(0)));
                tacticsEntity.setIcon(cursor.getString(1));
                tacticsEntity.setName(cursor.getString(2));
                tacticsEntity.setDescription(cursor.getString(3));
                tacticsEntity.setCategory(cursor.getString(4));
                tacticsEntity.setMinimap(cursor.getString(5));
                tacticsEntity.setLevel(cursor.getString(6));
                tacticsEntity.setSide(cursor.getString(7));
                tacticsEntity.setDifficulty(Integer.parseInt(cursor.getString(8)));
                tacticsEntity.setGranades(Integer.parseInt(cursor.getString(9)));
                tacticsEntity.setFlashes(Integer.parseInt(cursor.getString(10)));
                tacticsEntity.setSmokes(Integer.parseInt(cursor.getString(11)));
                tacticsEntity.setMolotovs(Integer.parseInt(cursor.getString(12)));
                tacticsEntity.setDecoys(Integer.parseInt(cursor.getString(13)));
                tacticsEntity.setAuthor(cursor.getString(14));

            } while (cursor.moveToNext());
        }

        tacticsEntity = new TacticsEntity();

        return tacticsEntity;

    }

    //Get requested data by level and side
    public List<TacticsEntity> getDataByLevelSide(String level, String side){

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
                tacticsEntity.setIcon(cursor.getString(1));
                tacticsEntity.setName(cursor.getString(2));
                tacticsEntity.setDescription(cursor.getString(3));
                tacticsEntity.setCategory(cursor.getString(4));
                tacticsEntity.setMinimap(cursor.getString(5));
                tacticsEntity.setLevel(cursor.getString(6));
                tacticsEntity.setSide(cursor.getString(7));
                tacticsEntity.setDifficulty(Integer.parseInt(cursor.getString(8)));
                tacticsEntity.setGranades(Integer.parseInt(cursor.getString(9)));
                tacticsEntity.setFlashes(Integer.parseInt(cursor.getString(10)));
                tacticsEntity.setSmokes(Integer.parseInt(cursor.getString(11)));
                tacticsEntity.setMolotovs(Integer.parseInt(cursor.getString(12)));
                tacticsEntity.setDecoys(Integer.parseInt(cursor.getString(13)));
                tacticsEntity.setAuthor(cursor.getString(14));

                tacticsEntityByLevelSide.add(tacticsEntity);

            } while (cursor.moveToNext());
        }

        Log.d("getData(" + level + "," + side + ")", tacticsEntityByLevelSide.toString());
        return tacticsEntityByLevelSide;
    }

    public Cursor getAllDataCursor() {

        String query = "SELECT _id,* FROM " + TAC_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
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
                tacticsEntity.setIcon(cursor.getString(1));
                tacticsEntity.setName(cursor.getString(2));
                tacticsEntity.setDescription(cursor.getString(3));
                tacticsEntity.setCategory(cursor.getString(4));
                tacticsEntity.setMinimap(cursor.getString(5));
                tacticsEntity.setLevel(cursor.getString(6));
                tacticsEntity.setSide(cursor.getString(7));
                tacticsEntity.setDifficulty(Integer.parseInt(cursor.getString(8)));
                tacticsEntity.setGranades(Integer.parseInt(cursor.getString(9)));
                tacticsEntity.setFlashes(Integer.parseInt(cursor.getString(10)));
                tacticsEntity.setSmokes(Integer.parseInt(cursor.getString(11)));
                tacticsEntity.setMolotovs(Integer.parseInt(cursor.getString(12)));
                tacticsEntity.setDecoys(Integer.parseInt(cursor.getString(13)));
                tacticsEntity.setAuthor(cursor.getString(14));

                allTacticsEntity.add(tacticsEntity);

            } while (cursor.moveToNext());
        }

        Log.d("getAllData()", allTacticsEntity.toString());
        return allTacticsEntity;
    }
}
