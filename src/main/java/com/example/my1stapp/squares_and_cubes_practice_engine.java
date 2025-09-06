package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class squares_and_cubes_practice_engine extends AppCompatActivity {

    private EditText editTextNumber;
    private EditText editTextNumber2;
    private EditText editTextNumber3;
    private TextView textview13;
    private Button button4;
    private Button button7;
    private Button button6;
    private ImageButton imageButton;

    TextToSpeech t1;

    private int level=0;
    private int a=0;
    private int ansSquare=0;
    private int ansCube=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.squares_and_cubes_practice_engine);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        editTextNumber=findViewById(R.id.editTextNumber);
        editTextNumber2=findViewById(R.id.editTextNumber2);
        editTextNumber3=findViewById(R.id.editTextNumber3);
        textview13=findViewById(R.id.textView13);
        button7=findViewById(R.id.button7);
        button4=findViewById(R.id.button4);
        button6=findViewById(R.id.button6);
        imageButton=findViewById(R.id.imageButton);

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

                level=0;
                squareCubePractice();
                textview13.setText("On this easy level,\nyou'll get numbers from 2 to 10.\nAll the best.");
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="I am sure your are done with previous levels. Now its time to master the game.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);

                level=1;
                squareCubePractice();
                textview13.setText("On this hard level,\nyou'll get numbers from 11 to 20.\nAll the best.");
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);
            }
        });

    }

    public void squareCubePractice(){

        editTextNumber2.setText("");
        editTextNumber3.setText("");

        Random r = new Random();

        if(level==0){
            a=r.nextInt(9)+2;
            ansSquare=a*a;
            ansCube=a*a*a;
        }
        else if(level==1){
            a = r.nextInt(10) + 11;
            ansSquare = a * a;
            ansCube = a * a * a;
        }

        editTextNumber.setText(Integer.toString(a));

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(editTextNumber2.getText().toString().length()==0 && editTextNumber3.getText().toString().length()==0){
                    String s="Please enter your answer.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Please enter your answer.");
                }
                else if(editTextNumber2.getText().toString().length()!=0 && editTextNumber3.getText().toString().length()==0){
                    String s="Please write the cube also.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Please write the value of cube also.\nThink about it, your are too close.");
                }
                else if(editTextNumber2.getText().toString().length()==0 && editTextNumber3.getText().toString().length()!=0){
                    String s="Please write the square also.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Please write the value of square also.\nThink about it, your are too close.");
                }
                else if(Integer.parseInt(editTextNumber2.getText().toString())==ansSquare && Integer.parseInt(editTextNumber3.getText().toString())==ansCube){
                    String s="Correct answer. Good! Next question.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Right Answer. your are doing good, 👍🏻\nNext one.");

                    squareCubePractice();
                }
                else if(Integer.parseInt(editTextNumber2.getText().toString())==ansSquare && Integer.parseInt(editTextNumber3.getText().toString())!=ansCube ) {
                    String s="Right answer for square, but wrong for cube. Cube of "+a+" is "+ansCube+". Don't worry, practice makes a kid perfect. Try this one.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Right answer for square,\nbut wrong for cube.\nCube of "+a+" is "+ansCube+". Don't worry,\npractice makes a kid perfect.\nTry this one.");

                    squareCubePractice();
                }
                else if(Integer.parseInt(editTextNumber2.getText().toString())!=ansSquare && Integer.parseInt(editTextNumber3.getText().toString())==ansCube ) {
                    String s="Right answer for cube, but wrong for square. Square of "+a+" is "+ansSquare+". Don't worry, practice makes a kid perfect. Try this one.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Right answer for cube,\nbut wrong for square.\nSquare of "+a+" is "+ansSquare+". Don't worry,\npractice makes a kid perfect.\nTry this one.");

                    squareCubePractice();
                }
                else if(Integer.parseInt(editTextNumber2.getText().toString())!=ansSquare && Integer.parseInt(editTextNumber3.getText().toString())!=ansCube ) {
                    String s="Opps! Wrong answer. Square of "+a+" is "+ansSquare+" and cube of "+a+" is "+ansCube+" Don't worry, practice makes a kid perfect. Try this one.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Opps! Wrong answer.\nSquare of "+a+" is "+ansSquare+"\nand cube of "+a+" is "+ansCube+"\nDon't worry, practice makes a kid perfect.\nTry this one.");
                    squareCubePractice();
                }

            }
        });

    }

//    public void hardSquareCubePractice() {
//
//        editTextNumber2.setText("");
//        editTextNumber3.setText("");
//
//        Random r = new Random();
//
//        int a = r.nextInt(10) + 11;
//        int ansSquare = a * a;
//        int ansCube = a * a * a;
////
//        editTextNumber.setText(Integer.toString(a));
////
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (editTextNumber2.getText().toString().length() == 0 && editTextNumber3.getText().toString().length() == 0) {
//                    String s="Please enter your answer.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Please enter your answer.");
//                } else if (editTextNumber2.getText().toString().length() != 0 && editTextNumber3.getText().toString().length() == 0) {
//                    String s="Please write the cube also.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Please write the value of cube also.\nThink about it, your are too close.");
//                } else if (editTextNumber2.getText().toString().length() == 0 && editTextNumber3.getText().toString().length() != 0) {
//                    String s="Please write the square also.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Please write the value of square also.\nThink about it, your are too close.");
//                } else if (Integer.parseInt(editTextNumber2.getText().toString()) == ansSquare && Integer.parseInt(editTextNumber3.getText().toString()) == ansCube) {
//                    String s="Correct answer. Good! Next question.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Right Answer. your are doing good, 👍🏻\nTry this one.");
//
//                    easySquareCubePractice();
//                }
//                else if (Integer.parseInt(editTextNumber2.getText().toString()) == ansSquare && Integer.parseInt(editTextNumber3.getText().toString()) != ansCube) {
//                    String s="Oops! it was close.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Right answer for square,\nbut wrong for cube.\nCube of " + a + " is " + ansCube + ". Don't worry,\npractice makes a kid perfect.\nTry this one.");
//
//                    easySquareCubePractice();
//                }
//                else if (Integer.parseInt(editTextNumber2.getText().toString()) != ansSquare && Integer.parseInt(editTextNumber3.getText().toString()) == ansCube) {
//                    String s="Oops! it was close.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Right answer for cube,\nbut wrong for square.\nSquare of " + a + " is " + ansSquare + ". Don't worry,\npractice makes a kid perfect.\nTry this one.");
//
//                    easySquareCubePractice();
//                }
//                else if (Integer.parseInt(editTextNumber2.getText().toString()) != ansSquare && Integer.parseInt(editTextNumber3.getText().toString()) != ansCube) {
//                    String s="Oops! no worries, it happenes sometime.";
//                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
//                    textview13.setText("Opps! Wrong answer.\nSquare of " + a + " is " + ansSquare + "\nand cube of " + a + " is " + ansCube + "\nDon't worry, practice makes a kid perfect.\nTry this one.");
//                    easySquareCubePractice();
//                }
//
//            }
//        });
//    }


    }