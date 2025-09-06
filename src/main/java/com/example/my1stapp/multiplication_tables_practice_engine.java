package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class multiplication_tables_practice_engine extends AppCompatActivity {

    private EditText editTextNumber;
    private EditText editTextNumber2;
    private EditText editTextNumber3;
    private Button button4;
    private Button button7;
    private Button button5;
    private Button button6;
    private ImageButton imageButton;
    private TextView textview13;
    private TextView textView10;
    private TextView textView14;

    TextToSpeech t1;

    public int count=0;
    private int level;
    private int a=0;
    private int b=0;
    private int ans=0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplication_tables_practice_engine);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        editTextNumber=findViewById(R.id.editTextNumber);
        editTextNumber2=findViewById(R.id.editTextNumber2);
        editTextNumber3=findViewById(R.id.editTextNumber3);
        button4=findViewById(R.id.button4);
        button7=findViewById(R.id.button7);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        imageButton=findViewById(R.id.imageButton);
        textview13=findViewById(R.id.textView13);
        textView10=findViewById(R.id.textView10);
        textView14=findViewById(R.id.textView14);

        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);

                    String s="Please select a difficulty level.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="See you again. bye.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                onBackPressed();
            }
        });

        textview13.setText("Please select a difficulty level\nto start the practice. You can\nchange this difficulty level anytime\nduring the practice");

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="I am sure you are done with basic learning. Lets start the practice.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);

                level=0;
                tables();
                textview13.setText("In easy mode,\nyou'll get tables from 2 to 5.\nAll the best.");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="Time to polish your skills.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);

                level=1;
                tables();
                textview13.setText("In medium mode,\nyou'll get tables from 5 to 10.\nAll the best.");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="I am sure your are done with previous levels. Now its time to master the game.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);

                level=2;
                tables();
                textview13.setText("In hard mode,\nyou'll get tables from 11 to 20.\nAll the best.");
            }
        });

    }

    public void tables(){

        button7.setVisibility(View.VISIBLE);
        editTextNumber.setVisibility(View.VISIBLE);
        editTextNumber2.setVisibility(View.VISIBLE);
        editTextNumber3.setVisibility(View.VISIBLE);
        textView10.setVisibility(View.VISIBLE);
        textView14.setVisibility(View.VISIBLE);

        editTextNumber3.setText("");

        Random r = new Random();

        if(level==0){
            a=r.nextInt(5)+1;
            b=r.nextInt(10)+1;
            ans=a*b;
        }
        else if(level==1){
            a=r.nextInt(6)+5;
            b=r.nextInt(10)+1;
            ans=a*b;
        }
        else if(level==2){
            a=r.nextInt(10)+10;
            b=r.nextInt(10)+1;
            ans=a*b;
        }

            editTextNumber.setText(Integer.toString(a));
            editTextNumber2.setText(Integer.toString(b));

            button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(editTextNumber3.getText().toString().length()==0){
                        String s="Please enter your answer.";
                        t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                        textview13.setText("Please enter your answer.");
                    }
                    else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
                        String s="Correct answer. Good! Next question.";
                        t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                        textview13.setText("Right Answer. Good 👍🏻\nNext one.");

                        tables();
                    }
                    else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                        String s="Oops! Wrong Answer. Correct answer was " + a + " multiplied by " + b +  " = " + ans + ". Don't worry, practice makes a kid perfect. Try this one.";
                        t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                        textview13.setText("Oops! Wrong Answer. Correct answer was\n" + a + " x " + b +  " = " + ans + ". Don't worry, practice\nmakes a kid perfect. Try this one.");
                        tables();

                    }

                }
            });

    }

//    public void mediumTableTest(){
//
//        button7.setVisibility(View.VISIBLE);
//        editTextNumber.setVisibility(View.VISIBLE);
//        editTextNumber2.setVisibility(View.VISIBLE);
//        editTextNumber3.setVisibility(View.VISIBLE);
//        textView10.setVisibility(View.VISIBLE);
//        textView14.setVisibility(View.VISIBLE);
//
//        editTextNumber3.setText("");
//
//        Random r = new Random();
//
//        int a=r.nextInt(6)+5;
//        int b=r.nextInt(10)+1;
//        int ans=a*b;
//
//        editTextNumber.setText(Integer.toString(a));
//        editTextNumber2.setText(Integer.toString(b));
//
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(editTextNumber3.getText().toString().length()==0){
//                    String s="Please enter your answer.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Please enter your answer.");
//                }
//                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
//                    String s="Correct answer. Good! Next question.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Right Answer. Good 👍🏻\nTry this one.");
//
//                    mediumTableTest();
//                }
//                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
//                    String s="Oops! no worries, better luck next time.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Opps! Wrong Answer.\nDon't worry, practice makes a kid perfect.\nTry this one.");
//                    mediumTableTest();
//                }
//
//            }
//        });
//
//    }
//
//    public void hardTableTest(){
//
//        button7.setVisibility(View.VISIBLE);
//        editTextNumber.setVisibility(View.VISIBLE);
//        editTextNumber2.setVisibility(View.VISIBLE);
//        editTextNumber3.setVisibility(View.VISIBLE);
//        textView10.setVisibility(View.VISIBLE);
//        textView14.setVisibility(View.VISIBLE);
//
//        editTextNumber3.setText("");
//
//        Random r = new Random();
//
//        int a=r.nextInt(10)+10;
//        int b=r.nextInt(10)+1;
//        int ans=a*b;
//
//        editTextNumber.setText(Integer.toString(a));
//        editTextNumber2.setText(Integer.toString(b));
//
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(editTextNumber3.getText().toString().length()==0){
//                    String s="Please enter your answer.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Please enter your answer.");
//                }
//                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){
//                    String s="Correct answer. Good! Next question.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Right Answer. Good 👍🏻\nTry this one.");
//
//                    hardTableTest();
//                }
//                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
//                    String s="Oops! no worries, better luck next time.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Opps! Wrong Answer. Correct answer\nfor"+a+" x "+b+" is "+ans+". Don't worry,\npractice makes a kid perfect.\nTry this one.");
//                    hardTableTest();
//                }
//            }
//        });
//
//    }

    }
