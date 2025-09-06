package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class launcher_page extends AppCompatActivity {

    TextToSpeech t1;
    private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_page);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button8=findViewById(R.id.button8);

        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);

                }
            }
        });

        button8.setEnabled(true);

    }

    public void open_home_page(View v){
        SharedPreferences share=getSharedPreferences("register",MODE_PRIVATE);
        String name=share.getString("name","");

        Toast.makeText(this, "GET STARTED", Toast.LENGTH_SHORT).show();
        String s="Hello "+name;
        t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }

    public void open_name_page(View v){
        Intent intent = new Intent(this, enter_name.class);
        startActivity(intent);
    }

}