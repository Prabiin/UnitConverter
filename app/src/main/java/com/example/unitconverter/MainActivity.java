package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button length;
    private Button weight;
    private Button temp;
    private Button about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        length = findViewById(R.id.btnLength);
        weight = findViewById(R.id.btnWeight);
        temp = findViewById(R.id.btnTemp);
        about = findViewById(R.id.btnAbout);

        length.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLengthConverter();
            }
        });
        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeightConverter();
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTempConverter();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAbout();
            }
        });
    }
    public void openLengthConverter(){
        Intent intent = new Intent(this, LengthConverter.class);
        startActivity(intent);
    }
    public void openWeightConverter(){
        Intent intent = new Intent(this, WeightConverter.class);
        startActivity(intent);
    }
    public void openTempConverter(){
        Intent intent = new Intent(this, TemperatureConverter.class);
        startActivity(intent);
    }
    public void openAbout(){
        Intent intent =  new Intent(this, About.class);
        startActivity(intent);
    }
}