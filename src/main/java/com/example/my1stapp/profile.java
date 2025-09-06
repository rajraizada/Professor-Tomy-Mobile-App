package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    private TextView textView1;
    private TextView textView20;
    private TextView textView21;
    private ImageButton imageButton;

    private Button button11;
    private ImageView imageView4;
    private ImageView imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView1=findViewById(R.id.textView17);
        textView20=findViewById(R.id.textView20);
        textView21=findViewById(R.id.textView21);
        imageButton=findViewById(R.id.imageButton);
        button11=findViewById(R.id.button11);
        imageView4=findViewById(R.id.imageView4);
        imageView6=findViewById(R.id.imageView6);

        SharedPreferences get=getSharedPreferences("register",MODE_PRIVATE);
        String name=get.getString("name","USER");
        textView1.setText(name);

        int a=get.getInt("points",0);
        String b=Integer.toString(a);
        textView20.setText(b);

        textView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(profile.this, "SCORE 2000+ points to get this badge,", Toast.LENGTH_SHORT).show();
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(profile.this, "SCORE 1000+ points to get this badge,", Toast.LENGTH_SHORT).show();
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(profile.this, "SCORE 500+ points to get this badge,", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_home_page();
            }
        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open_edit_name_page();
            }
        });

    }
    public void open_edit_name_page(){
//        Toast.makeText(this, "GET STARTED", Toast.LENGTH_SHORT).show();
//        String s="Let's start.";
//        t1.speak(s, TextToSpeech.QUEUE_FLUSH,null);
        Intent intent = new Intent(this, edit_name.class);
        startActivity(intent);
    }

    public void open_home_page(){
        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,home_page.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        open_home_page();
    }
}