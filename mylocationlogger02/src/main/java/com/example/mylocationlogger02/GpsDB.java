package com.example.mylocationlogger02;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Oh on 2016-11-19.
 */

public class GpsDB extends SQLiteOpenHelper
{
    public GpsDB(Context context) {
        super(context,"LOGGER",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블을 생성한다.
        // create table 테이블명 (컬럼명 타입 옵션);
        //DB명령어 수행
        String createTable="CREATE TABLE database (_id INTEGER PRIMARY KEY AUTOINCREMENT, latitude REAL , longitude REAL , type INTEGER ,  content TEXT);";
        db.execSQL(createTable);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS LOGGER");
        onCreate(db);
    }
    public void insert (Double latitude, Double longitude, int type, String content) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO database VALUES(NULL, " + latitude + ", " + longitude + ", " + type + ", '" + content + "');");
        db.close();
    }
    public void getResult (ArrayList<MyInfo> myInfo) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM database", null);

        while (cursor.moveToNext()) {
            Double latitude = cursor.getDouble(cursor.getColumnIndex("latitude"));
            Double longitude = cursor.getDouble(cursor.getColumnIndex("longitude"));
            int type = cursor.getInt(cursor.getColumnIndex("type"));
            String content = cursor.getString(cursor.getColumnIndex("content"));

            MyInfo myInfo1 = new MyInfo();
            myInfo1.latitude = latitude ;
            myInfo1.longitude = longitude ;
            myInfo1.type = type ;
            myInfo1.content = content ;

            myInfo.add(myInfo1) ;
        }
        cursor.close();
        db.close();
    }
}

