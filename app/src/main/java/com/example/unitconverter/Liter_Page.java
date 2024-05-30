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

import com.example.unitconverter.Home_Page;
import com.example.unitconverter.R;

public class Liter_Page extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerFrom, spinnerTo;
    private TextView textViewResult;
    private Button buttonConvert;

    ImageView imageview;
    private String[] units = { "Milliliter","Liter","Kiloliter","Megaliter"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_liter_page);

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

        if (fromUnit.equals("Milliliter") && toUnit.equals("Milliliter")) {
            result = input ;
        }
        else if (fromUnit.equals("Milliliter") && toUnit.equals("Liter")) {
            result = input / 10000;
        }
        else if (fromUnit.equals("Milliliter") && toUnit.equals("Kiloliter")) {
            result = input / 1000000;
        }
        else if (fromUnit.equals("Milliliter") && toUnit.equals("Megaliter")) {
            result = input / 1000000000;
        }



        else if (fromUnit.equals("Liter") && toUnit.equals("Millimeter")) {
            result = input * 1000;
        }  else if (fromUnit.equals("Liter") && toUnit.equals("Liter")) {
            result = input ;
        }
        else if (fromUnit.equals("Liter") && toUnit.equals("Kiloliter")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Liter") && toUnit.equals("Megaliter")) {
            result = input / 1000000;
        }


        else if (fromUnit.equals("Kiloliter") && toUnit.equals("Millimeter")) {
            result = input * 1000000;
        }
        else if (fromUnit.equals("Kiloliter") && toUnit.equals("Liter")) {
            result = input * 1000;
        }
        else if (fromUnit.equals("Kiloliter") && toUnit.equals("Kiloliter")) {
            result = input ;
        }
        else if (fromUnit.equals("Kiloliter") && toUnit.equals("Megaliter")) {
            result = input / 1000;
        }


        else if (fromUnit.equals("Megaliter") && toUnit.equals("Millimeter")) {
            result = input  * 1000000000;
        }
        else if (fromUnit.equals("Megaliter") && toUnit.equals("Liter")) {
            result = input * 1000000;
        }
        else if (fromUnit.equals("Megaliter") && toUnit.equals("Kiloliter")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Megaliter") && toUnit.equals("Megaliter")) {
            result = input ;
        }


        else {
            result = input;
        }

        textViewResult.setText(String.format("Result: %.10f %s", result, toUnit));
    }

    public void open(View view){
        Intent intent = new Intent(com.example.unitconverter.Liter_Page.this, Home_Page.class);
        startActivity(intent);
    }
}