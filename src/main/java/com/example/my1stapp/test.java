package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class test extends AppCompatActivity {
    private ImageButton imageButton;
    TextToSpeech t1;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private TextView textView10;
    private TextView textview13;
    private TextView textView14;
    private TextView textView24;
    private ImageView imageView3;
    private EditText editTextNumber3;
    private EditText editTextNumber;
    private EditText editTextNumber2;
    CountDownTimer timer;

    private int score=0;
    private int fullScore=0;
    private int qCount=0;
    private int level;
    private int a=0;
    private int b=0;
    private int ans=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imageButton=findViewById(R.id.imageButton);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        textView10=findViewById(R.id.textView10);
        textview13=findViewById(R.id.textview13);
        textView14=findViewById(R.id.textView14);
        textView24=findViewById(R.id.textView24);
        imageView3=findViewById(R.id.imageView3);
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
                    textview13.setText("Please select a difficulty level.");
                }
            }
        });

        editTextNumber.setVisibility(View.INVISIBLE);
        editTextNumber2.setVisibility(View.INVISIBLE);
        editTextNumber3.setVisibility(View.INVISIBLE);
        button7.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView14.setVisibility(View.INVISIBLE);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startTimer();

                level=0;
                fullScore=5;
                generateQuestion();

                button4.setClickable(false);
                button5.setEnabled(false);
                button6.setEnabled(false);
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);

                imageView3.setVisibility(View.VISIBLE);
                textView24.setVisibility(View.VISIBLE);
                editTextNumber.setVisibility(View.VISIBLE);
                editTextNumber2.setVisibility(View.VISIBLE);
                editTextNumber3.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);
                textView14.setVisibility(View.VISIBLE);

                String s="Good luck.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startTimer();

                level=1;
                fullScore=10;
                generateQuestion();

                button5.setClickable(false);
                button4.setEnabled(false);
                button6.setEnabled(false);
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);

                imageView3.setVisibility(View.VISIBLE);
                textView24.setVisibility(View.VISIBLE);
                editTextNumber.setVisibility(View.VISIBLE);
                editTextNumber2.setVisibility(View.VISIBLE);
                editTextNumber3.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);
                textView14.setVisibility(View.VISIBLE);

                String s="Good luck.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startTimer();

                level=2;
                fullScore=20;
                generateQuestion();

                button6.setClickable(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                editTextNumber3.setEnabled(true);
                button7.setEnabled(true);

                imageView3.setVisibility(View.VISIBLE);
                textView24.setVisibility(View.VISIBLE);
                editTextNumber.setVisibility(View.VISIBLE);
                editTextNumber2.setVisibility(View.VISIBLE);
                editTextNumber3.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
                textView10.setVisibility(View.VISIBLE);
                textView14.setVisibility(View.VISIBLE);

                String s="Good luck.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void startTimer(){

        timer=new CountDownTimer(300000,1000) {
            @Override
            public void onTick(long l) {

                long hours=(l/1000)/3600;
                long minutes=((l/1000)%3600)/60;
                long seconds=(l/1000)%60;
                String timeFormatted=String.format(Locale.getDefault(),"%02d:%02d:%02d",hours,minutes,seconds);
                textView24.setText(timeFormatted);
            }

            @Override
            public void onFinish() {
                textView24.setText("00:00:00");
                Toast.makeText(test.this, "Time's up", Toast.LENGTH_SHORT).show();

                String s="Time's up.";
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);

                SharedPreferences share=getSharedPreferences("register",MODE_PRIVATE);
                int a=share.getInt("points",0);
                a+=score;

                SharedPreferences.Editor editor=share.edit();
                editor.putInt("points",a);
                editor.apply();

                textview13.setText("Your score is "+score+"/"+fullScore);
                String s2="Your score is "+score+" out of "+fullScore;
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                if(score==5){
                    String s1="Well done";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                } else if (score==3 || score==4) {
                    String s1="Good, you can do better with practice.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                }
                else if (score<=2) {
                    String s1="It's okay. You just need to learn basics and practice more, then you'll be unstoppable.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                }


                imageView3.setVisibility(View.INVISIBLE);
                textView24.setVisibility(View.INVISIBLE);
                qCount=0;
                score=0;

                editTextNumber.setVisibility(View.INVISIBLE);
                editTextNumber2.setVisibility(View.INVISIBLE);
                editTextNumber3.setVisibility(View.INVISIBLE);
                button7.setVisibility(View.INVISIBLE);
                textView10.setVisibility(View.INVISIBLE);
                textView14.setVisibility(View.INVISIBLE);

                button4.setClickable(true);
                button5.setClickable(true);
                button6.setClickable(true);

                button4.setEnabled(true);
                button5.setEnabled(true);
                button6.setEnabled(true);

            }
        }.start();

    }

    public void generateQuestion(){

       if(qCount<5){

           qCount++;
           textview13.setText("Question. "+qCount);

           Random run = new Random();
           int runTest=run.nextInt(4);

           if(runTest==0){
               addition();
           }
           else if (runTest==1) {
               subtraction();
           }
           else if (runTest==2) {
               tables();
           }
           else if (runTest==3) {
               division();
           }
       }
       else{

           SharedPreferences share=getSharedPreferences("register",MODE_PRIVATE);
           int a=share.getInt("points",0);
           a+=score;

           SharedPreferences.Editor editor=share.edit();
           editor.putInt("points",a);
           editor.apply();

           textview13.setText("Your score is "+score+"/"+fullScore);

           if(score==fullScore){
               String s1="Your score is "+score+" out of "+fullScore+". Well done, you are doing great.";
               t1.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
           } else if (score>fullScore/2) {
                   String s1="Your score is "+score+" out of "+fullScore+". Good, you can do better with practice.";
                   t1.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
           }
           else if (score<=fullScore/2) {
               String s1="Your score is "+score+" out of "+fullScore+". It's okay. You just need to learn basics and practice more, then you'll be unstoppable.";
               t1.speak(s1,TextToSpeech.QUEUE_FLUSH,null);
           }

           imageView3.setVisibility(View.INVISIBLE);
          textView24.setVisibility(View.INVISIBLE);
           qCount=0;
           score=0;

           timer.cancel();

           editTextNumber.setVisibility(View.INVISIBLE);
           editTextNumber2.setVisibility(View.INVISIBLE);
           editTextNumber3.setVisibility(View.INVISIBLE);
           button7.setVisibility(View.INVISIBLE);
           textView10.setVisibility(View.INVISIBLE);
           textView14.setVisibility(View.INVISIBLE);

           button4.setClickable(true);
           button5.setClickable(true);
           button6.setClickable(true);

           button4.setEnabled(true);
           button5.setEnabled(true);
           button6.setEnabled(true);

       }

    }
//==================================================================================================
    public void addition(){

        textView10.setText("+");
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
                    textview13.setText("Please enter your answer.");
                    String s="Please enter your answer.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())==ans){

                    if(level==0){
                       score+=1;
                    }
                    else if(level==1){
                        score+=2;
                    }
                    else if(level==2){
                        score+=4;
                    }

                    generateQuestion();
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    generateQuestion();
                }

            }
        });


    }

    public void subtraction(){

        textView10.setText("-");
        editTextNumber3.setText("");

        Random r = new Random();

        if(level==0){
            a=r.nextInt(50)+1;
            b=r.nextInt(50)+1;
            ans=a-b;
        }
        else if(level==1){
            a=r.nextInt(51)+50;
            b=r.nextInt(51)+50;
            ans=a-b;
        }
        else if(level==2){
            a=r.nextInt(900)+100;
            b=r.nextInt(900)+100;
            ans=a-b;
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

                    if(level==0){
                        score+=1;
                    }
                    else if(level==1){
                        score+=2;
                    }
                    else if(level==2){
                        score+=4;
                    }

                    generateQuestion();
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    generateQuestion();
                }

            }
        });
    }

    public void tables(){

        textView10.setText("x");
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

                    if(level==0){
                        score+=1;
                    }
                    else if(level==1){
                        score+=2;
                    }
                    else if(level==2){
                        score+=4;
                    }

                    generateQuestion();
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    generateQuestion();

                }

            }
        });

    }

    public void division(){

        textView10.setText("/");
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

                    if(level==0){
                        score+=1;
                    }
                    else if(level==1){
                        score+=2;
                    }
                    else if(level==2){
                        score+=4;
                    }

                    generateQuestion();
                }
                else if(Integer.parseInt(editTextNumber3.getText().toString())!=ans) {
                    generateQuestion();
                }

            }
        });

    }
//==================================================================================================

}