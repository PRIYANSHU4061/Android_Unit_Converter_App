package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Weight_Page extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerFrom, spinnerTo;
    private TextView textViewResult;
    private Button buttonConvert;

    ImageView imageview;
    private String[] units = { "Milligram","Gram","Kilogram","Tonne","Pound"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_length_page);

        editTextInput = findViewById(R.id.editTextInput);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        textViewResult = findViewById(R.id.textViewResult);
        buttonConvert = findViewById(R.id.buttonConvert);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        String inputStr = editTextInput.getText().toString();
        if (inputStr.isEmpty()) {
            textViewResult.setText("Please enter a value.");
            return;
        }

        double input = Double.parseDouble(inputStr);
        String fromUnit = spinnerFrom.getSelectedItem().toString();
        String toUnit = spinnerTo.getSelectedItem().toString();

        double result = 0;

        if (fromUnit.equals("Milligram") && toUnit.equals("Milligram")) {
            result = input ;
        }
        else if (fromUnit.equals("Milligram") && toUnit.equals("Gram")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Milligram") && toUnit.equals("Kilogram")) {
            result = input / 1000000;
        }
        else if (fromUnit.equals("Milligram") && toUnit.equals("Tonne")) {
            result = input * 1000000000;
        }
        else if (fromUnit.equals("Milligram") && toUnit.equals("Pound")) {
            result = input / 4535925;
        }

        else if (fromUnit.equals("Gram") && toUnit.equals("Milligram")) {
            result = input * 1000;
        }
        else if (fromUnit.equals("Gram") && toUnit.equals("Gram")) {
            result = input ;
        }
        else if (fromUnit.equals("Gram") && toUnit.equals("Kilogram")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Gram") && toUnit.equals("Tonne")) {
            result = input * 1000000;
        }
        else if (fromUnit.equals("Gram") && toUnit.equals("Pound")) {
            result = input / 453.5925;
        }

        else if (fromUnit.equals("Kilogram") && toUnit.equals("Milligram")) {
            result = input * 1000000;
        }
        else if (fromUnit.equals("Kilogram") && toUnit.equals("Gram")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Kilogram") && toUnit.equals("Kilogram")) {
            result = input ;
        }
        else if (fromUnit.equals("Kilogram") && toUnit.equals("Tonne")) {
            result = input * 1000;
        }
        else if (fromUnit.equals("Kilogram") && toUnit.equals("Pound")) {
            result = input / 0.4535925;
        }


        else if (fromUnit.equals("Tonne") && toUnit.equals("Milligram")) {
            result = input * 1000000000;
        }
        else if (fromUnit.equals("Tonne") && toUnit.equals("Gram")) {
            result = input * 1000000;
        }
        else if (fromUnit.equals("Tonne") && toUnit.equals("Kilogram")) {
            result = input * 1000;
        }
        else if (fromUnit.equals("Tonne") && toUnit.equals("Tonne")) {
            result = input ;
        }
        else if (fromUnit.equals("Tonne") && toUnit.equals("Pound")) {
            result = input * 2000;
        }


        else if (fromUnit.equals("Pound") && toUnit.equals("Milligram")) {
            result = input * 4535925;
        }
        else if (fromUnit.equals("Pound") && toUnit.equals("Gram")) {
            result = input * 453.59;
        }
        else if (fromUnit.equals("Pound") && toUnit.equals("Kilogram")) {
            result = input * 0.45359;
        }
        else if (fromUnit.equals("Pound") && toUnit.equals("Tonne")) {
            result = input / 2000 ;
        }
        else if (fromUnit.equals("Pound") && toUnit.equals("Pound")) {
            result = input ;
        }

        else {
            result = input;
        }

        textViewResult.setText(String.format("Result: %.2f %s", result, toUnit));
    }

    public void open(View view){
        Intent intent = new Intent(Weight_Page.this, Home_Page.class);
        startActivity(intent);
    }
}