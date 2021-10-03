package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class LengthConverter extends AppCompatActivity {

    RadioButton Cm1, inch1, feet1, Cm2, inch2, feet2;
    Button btnConvert;
    EditText input_text;
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_converter);
        setTitle("Length Converter");
        Cm1 = findViewById(R.id.btnCm1);
        inch1 = findViewById(R.id.btnInch1);
        feet1 = findViewById(R.id.btnFeet1);
        Cm2 = findViewById(R.id.btnCm2);
        inch2 = findViewById(R.id.btnInch2);
        feet2 = findViewById(R.id.btnFeet2);
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
        if(Cm1.isChecked() && Cm2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scale", Toast.LENGTH_SHORT).show();
        }
        else if(Cm1.isChecked() && inch2.isChecked()){
            inp = inp / 2.54;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "cm = " + df.format(inp) + "in");
        }
        else if(Cm1.isChecked() && feet2.isChecked()){
            inp = inp / 30.48;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "cm = " + df.format(inp) + "ft");
        }
        else if(inch1.isChecked() && inch2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scale", Toast.LENGTH_SHORT).show();
        }
        else if(inch1.isChecked() && Cm2.isChecked()){
            inp = inp * 2.54;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "in = " + df.format(inp) + "cm");
        }
        else if(inch1.isChecked() && feet2.isChecked()){
            inp = inp / 12;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "in = " + df.format(inp) + "ft");
        }
        else if(feet1.isChecked() && feet2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scales", Toast.LENGTH_SHORT).show();
        }
        else if(feet1.isChecked() && Cm2.isChecked()){
            inp = inp * 30.48;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "ft = " + df.format(inp) + "cm");
        }
        else if(feet1.isChecked() && inch2.isChecked()){
            inp = inp * 12;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "ft = " + df.format(inp) + "in");
        }
        else{
            Toast.makeText(getApplicationContext(), "Please make both selection", Toast.LENGTH_SHORT).show();
        }
    }
}