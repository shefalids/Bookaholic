package com.example.admin.bookaholicfam;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.provider.Telephony.Carriers.PASSWORD;
import static java.util.jar.Pack200.Packer.PASS;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Library.db";
  //  public static final String TABLE_NAME="USERDETAILS";
    public static final String TABLE_NAME="user_details";
    public static final String COL_1="MBNO";
    public static final String COL_2="FNAME";
    public static final String COL_3="LNAME";
    public static final String COL_4="UNAME";
    public static final String COL_5="LOC";
    public static final String COL_6="PASS";
    //CREATE TABLE IF NOT EXISTS UserDetails(fname VARCHAR(20),lname VARCHAR(20),uname VARCHAR(20),loc TEXT,mb VARCHAR(10) PRIMARY KEY, pass VARCHAR(20)

    //SELECT count(*) FROM sqlite_master WHERE type='table' AND name='table_name';

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       // SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("inoncreate","ok");
        db.execSQL("CREATE TABLE user_details(MBNO TEXT PRIMARY KEY,FNAME TEXT,LNAME TEXT,UNAME TEXT ,LOC TEXT,PASS TEXT);");
        Log.i("acreate","ok");
        try {

            Log.i("beforet","ok");
            db.execSQL("SELECT count(*) FROM user_details");
            Log.i("table","ok");
        }
        catch (Exception e)
        {
            Log.i("error","error");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS "+"user_details");
        //onCreate(db);
        db.execSQL("CREATE TABLE user_details(MBNO TEXT PRIMARY KEY,FNAME TEXT,LNAME TEXT,UNAME TEXT ,LOC TEXT,PASS TEXT)");
    }
    public boolean insertData(String mbno,String fname,String  lname,String uname,String loc,String pass)
    {
        //Boolean result=   mydb.insertData(mbs,ed1s,ed2s,ed3s,lcs,p2s);
        Log.i("in insert","ok");
        SQLiteDatabase db=this.getWritableDatabase();
        Log.i("Before content values","ok");
        ContentValues contentValues=new ContentValues();
        Log.i("Before col1","ok");
        contentValues.put(COL_1,mbno);
        Log.i("Before col2","ok");
        contentValues.put(COL_2,fname);
        Log.i("Before col3","ok");
        contentValues.put(COL_3,lname);
        Log.i("Before col4","ok");
        contentValues.put(COL_4,uname);
        Log.i("Before col5","ok");
        contentValues.put(COL_5,loc);
        Log.i("Before col6","ok");
        contentValues.put(COL_6,pass);
        Log.i("Before database insert22","ok");
        long result=db.insert("user_details",null,contentValues);
        Log.i("After database insert22","ok");
        if(result==-1) {
            Log.i("failinsert","ok");
            return false;
        }
        else
            Log.i("successinsert","ok");
            return true;

    }
}
