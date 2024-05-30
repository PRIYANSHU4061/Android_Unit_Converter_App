package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Temp_Page extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerFrom, spinnerTo;
    private TextView textViewResult;
    private Button buttonConvert;
    private String[] units = {"Celcius", "Farenheit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_temp_page);

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
        if (fromUnit.equals("Celcius") && toUnit.equals("Farenheit")) {
            result = (input * 9/5) + 32 ;
        } else if (fromUnit.equals("Farenheit") && toUnit.equals("Celcius")) {
            result = (input - 32 ) * 5/9 ;
        } else {
            result = input;
        }

        textViewResult.setText(String.format("Result: %.2f %s", result, toUnit));
    }

    public void open(View view){
        Intent intent = new Intent(Temp_Page.this, Home_Page.class);
        startActivity(intent);
    }


}