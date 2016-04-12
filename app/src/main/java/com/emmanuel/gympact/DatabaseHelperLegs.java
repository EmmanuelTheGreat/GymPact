package com.emmanuel.gympact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 11/04/2016.
 */
public class DatabaseHelperLegs extends SQLiteOpenHelper {
    //constructor

    public static final String DATABASE_NAME = "Legs.database";
    public static final String TABLE_NAME ="Legs";
    public static final String COL1 = "date";
    public static final String COL2 = "exercise";
    public static final String COL3 = "weight";
    public static final String COL4 = "reps";


    public DatabaseHelperLegs(Context context) {
        //creates database
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase database = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        // whenever this oncreate method is called, a table is created
        //exec SQL executes the query between the ""
        database.execSQL("create table " + TABLE_NAME + " (date INTEGER PRIMARY KEY AUTOINCREMENT, exercise TEXT, weight INTEGER, reps INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(database);

    }

    public boolean insertData(String exercise, String  weight, String reps){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL2, exercise);
        contentValues.put(COL3, weight);
        contentValues.put(COL4, reps);

        //using database instance to insert data

        long result = database.insert(TABLE_NAME, null, contentValues);

        if(result == -1)
            return  false;

        else
            return  true;
    }

    //Cursor class to provide random read-write access to the data set queried
    public Cursor retrieveData(){

        SQLiteDatabase database = this.getWritableDatabase();
        //creating an instance of the cursor class

        Cursor result = database.rawQuery("select * from " + TABLE_NAME, null);

        return result;
    }

    public boolean EditUpdateData(String date, String exercise, String weight, String reps){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL1, date);
        contentValues.put(COL2, exercise);
        contentValues.put(COL3, weight);
        contentValues.put(COL4, reps);

        database.update(TABLE_NAME, contentValues, "date = ?" ,new String[] { date });

        return true;
    }

    public Integer delete(String date){

        SQLiteDatabase database = this.getWritableDatabase();

        return database.delete(TABLE_NAME, "date = ?", new String[] {date});
    }

}


