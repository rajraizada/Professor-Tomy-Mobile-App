package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class enter_name extends AppCompatActivity {

    public String name;
    private EditText editTextText2;
    private Button button8;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_name);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });

        SharedPreferences get=getSharedPreferences("register",MODE_PRIVATE);
        int nameSaved=get.getInt("nameSaved",0);

       if(nameSaved==0){
           editTextText2=findViewById(R.id.editTextText2);
           button8=findViewById(R.id.button8);

           button8.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

                   String name=editTextText2.getText().toString();

                   SharedPreferences shp = getSharedPreferences("register",MODE_PRIVATE);
                   SharedPreferences.Editor editor=shp.edit();

                   editor.putString("name",name);
                   editor.putInt("nameSaved",1);
                   editor.apply();

                   open_home_page();
               }
           });
       } else{
           open_home_page();
       }

    }

    public void open_home_page(){
        SharedPreferences share=getSharedPreferences("register",MODE_PRIVATE);
        String name=share.getString("name","Friend");

        int countSpace=0;

        for (int i = 0; i < name.length(); i++) {
            countSpace++;
            if(name.charAt(i)==' '){
                break;
            }
        }

        String s="Hello"+name.substring(0,countSpace)+",come on let's study together.";

        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }

}