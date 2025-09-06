package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class multiplication_tables_learn extends AppCompatActivity {
    private Button button2;
    private ImageButton imageButton;
    private TextView textView;
    private EditText editText;

    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplication_tables_learn);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // FIX APP ON PORTRAIT

        button2 = findViewById(R.id.button2);
        imageButton=findViewById(R.id.imageButton);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editTextText);

        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);

                    String s="Enter a number, and I will write its multiplication table for you.";
                    t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if(editText.getText().toString().length() < 1){
                        textView.setText("Enter a number and I will\nwrite its multiplication table for you.");
                    } else {

                        int a= Integer.parseInt(editText.getText().toString());

                        String s="Here is the multiplication table of "+ a + " for you";
                        t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);

                        textView.setText("Here is the multiplication table of "+ a + " for you\n\n" +
                                a + " x "+1+ " = "+a + "\n" +
                                a + " x "+2+ " = "+a*2 + "\n" +
                                a + " x "+3+ " = "+a*3 + "\n" +
                                a + " x "+4+ " = "+a*4 + "\n" +
                                a + " x "+5+ " = "+a*5 + "\n" +
                                a + " x "+6+ " = "+a*6 + "\n" +
                                a + " x "+7+ " = "+a*7 + "\n" +
                                a + " x "+8+ " = "+a*8 + "\n" +
                                a + " x "+9+ " = "+a*9 + "\n" +
                                a + " x "+10+ " = "+a*10);
                    }

            }
        });
    }
    public void homePage(View v){
//        Toast.makeText(this, "Opening Tables", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
    }
}