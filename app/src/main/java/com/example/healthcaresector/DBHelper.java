package com.example.healthcaresector;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Login.db";
    private static final int DATABASE_VERSION=2;

    public DBHelper( Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table patient(id Integer primary key autoincrement,username Text(20) not null,password Text(8) not null)");
        db.execSQL("create Table sponsor(Id Integer primary key autoincrement,name text(20) not null,username text(20) not null,password text(10) not null,city text(12) not null,address text(30) not null,account text(11),amount integer not null,phone integer(10) not null)");
        db.execSQL("create Table hospital(id Integer primary key autoincrement,bed integer(3) not null,oxygen integer(3) not null,doctor integer(3) not null)");
        db.execSQL("create Table admin(id Integer primary key autoincrement,hospital text(15) not null,location text(10) not null )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists patient");
        db.execSQL("drop table if exists sponsor");
        db.execSQL("drop table if exists hospital");
        db.execSQL("drop table if exists admin");
    }
    public Boolean insertData(String username,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result=myDB.insert("patient",null,contentValues);

        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Boolean insertData1(String name,String username,String password,String account,String amount,String phone,String city,String address){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("amount", amount);
        contentValues.put("Phone", phone);
        contentValues.put("city",city);
        contentValues.put("account",account);
        contentValues.put("address",address);
        long result1=myDB.insert("sponsor",null,contentValues);

        if(result1==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public Boolean insertData3(String hospital,String location){
        SQLiteDatabase myDB1=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("hospital",hospital);
        contentValues.put("location",location);
        long result2=myDB1.insert("admin", null, contentValues);
        if(result2==-1){
            return false;
        }
        else
            return true;
    }


    public Boolean insertData2(String bed,String oxygen,String doctor){
        SQLiteDatabase myDB1=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("bed",bed);
        contentValues.put("oxygen",oxygen);
        contentValues.put("doctor", doctor);
        long result2=myDB1.insert("hospital", null, contentValues);
        if(result2==-1){
            return false;
        }
        else
            return true;
    }

    public Boolean updateuserdata (String bed, String oxygen, String doctor) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("bed",bed);
        contentValues.put("oxygen", oxygen);
        contentValues.put("doctor",doctor);
        Cursor cursor = DB.rawQuery("Select * from hospital where  bed=?and oxygen=? and doctor=?", new String[]{bed,oxygen,doctor});
        if (cursor.getCount() > 0) {

            long result = DB.update("hospital", contentValues, "bed=? and oxygen=? and doctor=?", new String[]{bed,oxygen,doctor});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
        {
            return false;
        }

    }

    public Boolean deletedata (String bed,String oxygen,String doctor) {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from hospital where bed=? and oxygen=? and doctor=?", new String[]{bed,oxygen,doctor});
        if (cursor.getCount() > 0) {

            long result = DB.delete("hospital", "bed=? and oxygen=? and doctor=?", new String[]{bed,oxygen,doctor});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public Cursor getdata()
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("Select * from hospital", null);
        return cursor;
    }




    public  Boolean checkusername(String username){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from patient where username=?",new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }

    }
    public Boolean checkusenamepassword(String username,String password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor=myDB.rawQuery("select * from patient where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0){
            return  true;
        }
        else{
            return false;
        }
    }


}
