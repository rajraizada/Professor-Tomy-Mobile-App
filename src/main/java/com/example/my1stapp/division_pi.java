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

public class division_pi extends AppCompatActivity {

    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private ImageButton imageButton;
    private TextView textview13;
    private EditText editTextNumber3;
    private EditText editTextNumber;
    private EditText editTextNumber2;
    TextToSpeech t1;

    private int level;
    private int a=0;
    private int b=0;
    private int ans=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.division_pi);

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
                division();
                textview13.setText("This is the easy level.\nGood luck, you'll do great.");
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
                division();
                textview13.setText("This is medium level.\nGood luck, you'll do great.");
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
                division();
                textview13.setText("This is hard level. It is\nrecommended to practice on previous\nlevels before attempting it. Good luck.");
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);
            }
        });

    }

    public void division(){

        editTextNumber3.setText("");

        Random r = new Random();

        if(level==0){
            b=r.nextInt(4)+2;
            ans=r.nextInt(9)+2;
            a=b*ans;
        }
        else if(level==1){
            b=r.nextInt(9)+2;
            ans=r.nextInt(16)+5;
            a=b*ans;
        }
        else if(level==2){
            b=r.nextInt(10)+11;
            ans=r.nextInt(10)+11;
            a=b*ans;
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

                    division();
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    String s="Oops! Wrong Answer. Correct answer was " + a + " divided by " + b +  " = " + ans + ". Don't worry, practice makes a kid perfect. Try this one.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                    textview13.setText("Opps! Wrong Answer.\nCorrect answer was " + a + " / " + b + " = "+ ans + "\nDon't worry, practice makes a kid perfect.\nTry this one.");
                    division();
                }

            }
        });

    }

}