package com.example.my1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class practice_engine_page extends AppCompatActivity {

    private ImageButton imageButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_engine_page);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imageButton1=findViewById(R.id.imageButton1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, home_page.class);
        startActivity(intent);
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

    public void openActivity4(View v){
        Toast.makeText(this, "Opening Tables Practice Engine", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, multiplication_tables_practice_engine.class);
        startActivity(intent);
    }

    public void open_squares_and_cubes_practice_engine(View v){
        Toast.makeText(this, "Opening SQUARES and CUBES Practice Engine", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, squares_and_cubes_practice_engine.class);
        startActivity(intent);
    }

    public void open_addition_learn(View v){
        Toast.makeText(this, "Opening ADDITION practice engine", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, addition_pi.class);
        startActivity(intent);
    }

    public void open_subtraction_pi(View v){
        Toast.makeText(this, "Opening SUBTRACTION Practice Engine", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, subtraction_pi.class);
        startActivity(intent);
    }

    public void open_division_pi(View v){
        Toast.makeText(this, "Opening DIVISION Practice Engine", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, division_pi.class);
        startActivity(intent);
    }

    public void open_more_page(View v){
//        Toast.makeText(this, "Opening DIVISION Practice Engine", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, practice_engine_page.class);
        startActivity(intent);
    }

    public void open_quantitative_average_aptitude(View v){
        Toast.makeText(this, "Opening DIVISION Practice Engine", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, quantitative_average_aptitude.class);
        startActivity(intent);
    }

}