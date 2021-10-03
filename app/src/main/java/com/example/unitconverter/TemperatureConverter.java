package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TemperatureConverter extends AppCompatActivity {

    RadioButton celsius1;
    RadioButton fahrenheit1;
    RadioButton kelvin1;
    RadioButton celsius2;
    RadioButton fahrenheit2;
    RadioButton kelvin2;
    Button btnConvert;
    EditText input_text;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        setTitle("Temperature Converter");
        celsius1 = findViewById(R.id.btnCelcius1);
        fahrenheit1 = findViewById(R.id.btnFahrenheit1);
        kelvin1 = findViewById(R.id.btnKelvin1);
        celsius2 = findViewById(R.id.btnCelcius2);
        fahrenheit2 = findViewById(R.id.btnFahrenheit2);
        kelvin2 = findViewById(R.id.btnKelvin2);
        btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input_text = findViewById(R.id.txtField);
                input = input_text.getText().toString();
                if(input.equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter a value in the field", Toast.LENGTH_SHORT).show();
                else
                    openCalculate();
            }
        });
    }
    public void openCalculate(){
        input_text = findViewById(R.id.txtField);
        input = input_text.getText().toString();
        double inp = Double.parseDouble(input);
        TextView result = findViewById(R.id.textView2);
        if(celsius1.isChecked() && celsius2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scale", Toast.LENGTH_SHORT).show();
        }
        else if(celsius1.isChecked() && fahrenheit2.isChecked()){
            inp = (inp * 9) / 5 + 32;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "°C = " + df.format(inp) + "°F");
        }
        else if(celsius1.isChecked() && kelvin2.isChecked()){
            inp = inp + 273.15;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "°C = " + df.format(inp) + "K");
        }
        else if(fahrenheit1.isChecked() && fahrenheit2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scale", Toast.LENGTH_SHORT).show();
        }
        else if(fahrenheit1.isChecked() && celsius2.isChecked()){
            inp = (inp - 32) * 5 / 9;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "°F = " + df.format(inp) + "°C");
        }
        else if(fahrenheit1.isChecked() && kelvin2.isChecked()){
            inp = ((inp - 32) * 5 / 9) + 273.15;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "°F = " + df.format(inp) + "K");
        }
        else if(kelvin1.isChecked() && kelvin2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scales", Toast.LENGTH_SHORT).show();
        }
        else if(kelvin1.isChecked() && celsius2.isChecked()){
            inp = inp - 273.15;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "K = " + df.format(inp) + "°C");
        }
        else if(kelvin1.isChecked() && fahrenheit2.isChecked()){
            inp = ((inp - 273.15) * 9 / 5) + 32;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "K = " + df.format(inp) + "°F");
        }
        else{
            Toast.makeText(getApplicationContext(), "Please make both selection", Toast.LENGTH_SHORT).show();
        }
    }
}