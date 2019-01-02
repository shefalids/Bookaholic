package com.example.admin.bookaholicfam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View v){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);

    }

    public void login2(View v)
    {
        Intent i = new Intent(this, LoginAuthentication.class);
        startActivity(i);
    }

    public void register(View v)
    {
        Intent i = new Intent(this, Registration.class);
        startActivity(i);
    }
}
