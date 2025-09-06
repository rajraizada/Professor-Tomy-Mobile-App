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

public class addition_pi extends AppCompatActivity {

    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private ImageButton imageButton;
    private TextView textview13;
    private EditText editTextNumber3;
    private EditText editTextNumber;
    private EditText editTextNumber2;
    private int level;

    TextToSpeech t1;
    int a=0;
    int b=0;
    int ans=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addition_pi);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        imageButton=findViewById(R.id.imageButton);
        textview13=findViewById(R.id.textview13);
        editTextNumber=findViewById(R.id.editTextNumber);
        editTextNumber2=findViewById(R.id.editTextNumber2);
        editTextNumber3=findViewById(R.id.editTextNumber3);

        level=0;

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
                addition();

                textview13.setText("On this easy level you'll get\nnumbers in the range of 1 to 50.\nGood luck, you'll do great.");
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="Time to polish your skills.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);

                level=1;
                addition();

                textview13.setText("On this medium level you'll get\nnumbers in the range of 50 to 100.\nGood luck, you'll do great.");
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="I am sure your are done with previous levels. Now its time to master the game.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);

                level=2;
                addition();

                textview13.setText("On this hard level you'll get\nnumbers in the range of 100 to 1000.\nGood luck, you'll do great.");
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);
            }
        });

    }

    public void addition(){

            editTextNumber3.setText("");

        Random r = new Random();

        if(level==0){
            a=r.nextInt(50)+1;
            b=r.nextInt(50)+1;
            ans=a+b;
        }
        else if(level==1){
            a=r.nextInt(51)+50;
            b=r.nextInt(51)+50;
            ans=a+b;
        }
        else if(level==2){
            a=r.nextInt(900)+100;
            b=r.nextInt(900)+100;
            ans=a+b;
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
                        textview13.setText("Right Answer. your are doing good 👍🏻\nNext one.");

                        addition();
                    }
                    else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                        String s="Oops! Wrong Answer. Correct answer was " + a + " + " + b +  " = " + ans + ". Don't worry, practice makes a kid perfect. Try this one.";
                        t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                        textview13.setText("Oops! Wrong Answer.\nCorrect answer was " + a + " + " + b + " = "+ ans + "\nDon't worry, practice makes a kid perfect.\nTry this one.");
                        addition();
                    }

                }
            });

        }
    }

