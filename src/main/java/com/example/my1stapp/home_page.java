package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class home_page extends AppCompatActivity {

    private TextView textView18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView18=findViewById(R.id.textView18);

        SharedPreferences share=getSharedPreferences("register",MODE_PRIVATE);
        String name=share.getString("name","there");

        textView18.setText("Hello "+name+"!");

    }

    @Override
    public void onBackPressed() {

    }

    public void open_learn_concepts(View v){
//        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, learn_concepts.class);
        startActivity(intent);
    }
    public void open_about_us(View v){
//        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, about_us.class);
        startActivity(intent);
    }

    public void open_developers_info(View v){
//        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, developers_info.class);
        startActivity(intent);
    }

    public void open_profile(View v){
//        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,profile.class);
        startActivity(intent);
    }

    public void open_test(View v){
//        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,test.class);
        startActivity(intent);
    }

    public void open_practice_engine_page(View v){
//        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, practice_engine_page.class);
        startActivity(intent);
    }


}