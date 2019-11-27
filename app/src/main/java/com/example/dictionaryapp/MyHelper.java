package com.example.dictionaryapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {

    private static final String databaseName = "DictionaryDB.db";
    private static final int dbVersion = 1;

    private static final String tblWord = "tblWord";
    private static final String WordId = "WordId";
    private static final String Word = "Word";
    private static final String Meaning = "Meaning";


    public MyHelper (Context context){
        super(context, databaseName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ tblWord + "(" + WordId + "INTEGER PRIMARY KEY AUTOINCREMENT," + Word + "TEXT," + Meaning + "TEXT" + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    public static boolean InsertData(String word, String meaning, SQLiteDatabase db){
//        try {
//            String query = "insert into Words(Word, Meaning) values ('" + word + "', '" + meaning + "')";
//            db.execSQL(query);
//            return true;
//        }
//        catch (Exception e){
//            Log.d("Error : ", e.toString());
//            return false;
//        }
//    }

//    OR (Another Method)

    public static long InsertData(String word, String meaning, SQLiteDatabase db){
        long id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(Meaning, meaning);
        contentValues.put(Word, word);
        id = db.insert(tblWord, null, contentValues);
        return id;
    }

    public modelDictionary getWordId(int id){
        modelDictionary meaning = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from tblWord where WordId = " + id;
        Cursor cursor =  db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            do{
                Integer wordId = cursor.getInt(cursor.getColumnIndexOrThrow("WordId"));
                String word = cursor.getString(cursor.getColumnIndexOrThrow("Word"));
                String mean = cursor.getString(cursor.getColumnIndexOrThrow("Meaning"));
                meaning = new modelDictionary(word, wordId, mean);
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return meaning;
    }
}
