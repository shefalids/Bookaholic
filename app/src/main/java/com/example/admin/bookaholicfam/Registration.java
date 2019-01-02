package com.example.admin.bookaholicfam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    DatabaseHelper mydb;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Log.i("before creating object","ok");
        mydb=new DatabaseHelper(this);
        //db=openOrCreateDatabase("Repository", MODE_PRIVATE, null);
        Log.i("After creating object","ok");

    }
    public void validate(View v)
    {
        EditText ed1=(EditText)findViewById(R.id.ed1);
        EditText ed2=(EditText)findViewById(R.id.ed2);
        EditText ed3=(EditText)findViewById(R.id.ed3);
        EditText lc=(EditText)findViewById(R.id.lc);
        EditText mb=(EditText)findViewById(R.id.mb);
        EditText p1=(EditText)findViewById(R.id.p1);
        EditText p2=(EditText)findViewById(R.id.p2);
        String ed1s=ed1.getText().toString();
        String ed2s=ed2.getText().toString();
        String ed3s=ed3.getText().toString();
        String lcs=lc.getText().toString();
        String mbs=mb.getText().toString();
        String p1s=p1.getText().toString();
        String p2s=p2.getText().toString();
        if(ed1s.length()<1)
            Toast.makeText(this,"Enter First Name",Toast.LENGTH_SHORT).show();
        else if(ed2s.equals(""))
            Toast.makeText(this,"Enter Last Name",Toast.LENGTH_SHORT).show();
        else if(ed3s.length()<3)
            Toast.makeText(this,"Username has to be min 3 characters",Toast.LENGTH_SHORT).show();
        else if(lcs.length()<3)
            Toast.makeText(this,"Location has to be min 3 characters",Toast.LENGTH_SHORT).show();
        else if(mbs.matches("[0-9]+")!=true)
            Toast.makeText(this,"Mobile no should contain only numbers",Toast.LENGTH_SHORT).show();
        else if(mbs.length()<10)
            Toast.makeText(this,"Mobile no has to be min 10 characters",Toast.LENGTH_SHORT).show();
        else if(p1s.length()<8)
            Toast.makeText(this,"Password has to be min 8 characters",Toast.LENGTH_SHORT).show();
        else if(p2s.length()<8)
            Toast.makeText(this,"Password has to be min 8 characters",Toast.LENGTH_SHORT).show();
        else if(!p1s.equals(p2s))
            Toast.makeText(this,"Passwords do not match",Toast.LENGTH_SHORT).show();
        else {
                Log.i("Before insert","ok");
            //db=mydb.getWritableDatabase();
            //db.execSQL("CREATE TABLE user_details(MBNO TEXT PRIMARY KEY,FNAME TEXT,LNAME TEXT,UNAME TEXT ,LOC TEXT,PASS TEXT)");
            //mydb.onCreate(db);
             Boolean result=   mydb.insertData(mbs,ed1s,ed2s,ed3s,lcs,p2s);
             Log.i("After insert","ok");
             if(result==true)
             {
                 Toast.makeText(this,"Account successfully created",Toast.LENGTH_LONG).show();
             }
             else
             {
                 Toast.makeText(this,"Account not created",Toast.LENGTH_LONG).show();
             }
            /*try {
                    SQLiteDatabase myDatabase = openOrCreateDatabase("Repository", MODE_PRIVATE, null);
                    Log.i("Before database", "ok");
                    myDatabase.execSQL("CREATE TABLE IF NOT EXISTS UserDetails(fname VARCHAR(20),lname VARCHAR(20),uname VARCHAR(20),loc TEXT,mb VARCHAR(10) PRIMARY KEY, pass VARCHAR(20));");
                    Log.i("Afer create query", "ok");
                    Log.i("Before insert", "ok");
                    myDatabase.execSQL("INSERT INTO UserDetails(fname,lname,uname,loc,mb,pass) VALUES(?,?,?,?,?)", (ed1s, ed2s, ed3s, mbs, p1s));
                    //myDatabase.execSQL("INSERT INTO UserDetails(fname,lname,uname,loc,mb,pass) VALUES(\"'\"+ed1s+\"'\",\"'\"+ed2s+\"'\", \"'\"+ed3s+\"'\",\"'\"+mbs+\"'\", \"'\"+p1s+\"'\")");
                    Log.i("Insertion", "ok");
                    Toast.makeText(this, "Account creation successful", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();

                }*/
        }
    }

}
