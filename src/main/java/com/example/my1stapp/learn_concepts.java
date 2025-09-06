package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

public class learn_concepts extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_concepts);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imageButton=findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    public void openActivity(View v){
        Toast.makeText(this, "Opening Tables", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, multiplication_tables_learn.class);
        startActivity(intent);
    }

    public void openActivity3(View v){
        Toast.makeText(this, "Opening Squares and Cubes", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, squares_and_cubes_learn.class);
        startActivity(intent);
    }
}