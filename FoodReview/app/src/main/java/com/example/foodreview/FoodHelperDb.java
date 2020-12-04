package com.example.foodreview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class FoodHelperDb extends SQLiteOpenHelper {
    private static final String Dbname="FoodDb.db";
    private static final String Dbtable="fdtable";
    private static final String District="district";
    private static final String FoodName="Foodname";
    private static final String Foodimg="FoodImage";
    private static final String FoodRate="Foodrating";
    private static final String Discription="FoodDiscription";
    private static final String Link="Foodlink";

    private  Context context;
    public FoodHelperDb(@Nullable Context context) {
        super(context,Dbname, null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="Create table "+Dbtable+"("+District+" Text, "+FoodName+" Text, "+Foodimg+" Text, "+FoodRate+" Double, "+Discription+" Text, "+Link+" Text );";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("Drop table If exists "+Dbtable);
        onCreate(db);
    }

    public void addingitem(String district,String foodname,String foodImage,double foodrate,String discription,String linkit){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(District,district);
        values.put(FoodName,foodname);
        values.put(Foodimg,foodImage);
        values.put(FoodRate,foodrate);
        values.put(Discription,discription);
        values.put(Link,linkit);
        long val =database.insert(Dbtable,null,values);
        if(val !=-1){
            Log.d("added","content added");
        }else{
            Log.d("notadded","failed to add");
        }
    }

    public Cursor cur(String obj){
        String sql = "Select * from "+Dbtable+" where "+District +" = '"+obj+"'";
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor=null;
        if(database!=null){
            cursor = database.rawQuery(sql,null);
        }
        return cursor;
    }

    public Cursor cur(){
        String sql = "Select * from "+Dbtable;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor=null;
        if(database!=null){
            cursor = database.rawQuery(sql,null);
        }
        return cursor;
    }
}
