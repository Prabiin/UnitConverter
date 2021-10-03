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

public class WeightConverter extends AppCompatActivity {

    RadioButton kg1, pound1, ounce1, kg2, pound2, ounce2;
    Button btnConvert;
    EditText input_text;
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);
        setTitle("Weight Converter");
        kg1 = findViewById(R.id.btnKg1);
        pound1 = findViewById(R.id.btnPound1);
        ounce1 = findViewById(R.id.btnOunce1);
        kg2 = findViewById(R.id.btnKg2);
        pound2 = findViewById(R.id.btnPound2);
        ounce2 = findViewById(R.id.btnOunce2);
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
        if(kg1.isChecked() && kg2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scale", Toast.LENGTH_SHORT).show();
        }
        else if(kg1.isChecked() && pound2.isChecked()){
            inp = inp * 2.205;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "Kg = " + df.format(inp) + "lbs");
        }
        else if(kg1.isChecked() && ounce2.isChecked()){
            inp = inp * 35.274;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "Kg = " + df.format(inp) + "oz");
        }
        else if(pound1.isChecked() && pound2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scale", Toast.LENGTH_SHORT).show();
        }
        else if(pound1.isChecked() && kg2.isChecked()){
            inp = inp / 2.205;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "lbs = " + df.format(inp) + "Kg");
        }
        else if(pound1.isChecked() && ounce2.isChecked()){
            inp = inp * 16;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "lbs = " + df.format(inp) + "oz");
        }
        else if(ounce1.isChecked() && ounce2.isChecked()){
            result.setText("");
            Toast.makeText(getApplicationContext(), "Please select different scales", Toast.LENGTH_SHORT).show();
        }
        else if(ounce1.isChecked() && kg2.isChecked()){
            inp = inp / 35.274;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "oz = " + df.format(inp) + "Kg");
        }
        else if(ounce1.isChecked() && pound2.isChecked()){
            inp = inp / 16;
            DecimalFormat df = new DecimalFormat(".##");
            result.setText(input + "oz = " + df.format(inp) + "lbs");
        }
        else{
            Toast.makeText(getApplicationContext(), "Please make both selection", Toast.LENGTH_SHORT).show();
        }
    }
}