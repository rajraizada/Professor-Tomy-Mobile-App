package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit_name extends AppCompatActivity {

    private Button button12;
    private EditText editTextText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_name);

        button12=findViewById(R.id.button12);
        editTextText3=findViewById(R.id.editTextText3);

        SharedPreferences share=getSharedPreferences("register",MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newName=editTextText3.getText().toString();

                if(newName.length()>0){
                    editor.putString("name",newName);
                    editor.apply();
                    open_profile();
                }
            }
        });

    }

    public void open_profile(){
        Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,profile.class);
        startActivity(intent);
    }
}