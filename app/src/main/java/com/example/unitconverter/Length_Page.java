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

public class Length_Page extends AppCompatActivity {

    private EditText editTextInput;
    private Spinner spinnerFrom, spinnerTo;
    private TextView textViewResult;
    private Button buttonConvert;

    ImageView imageview;
    private String[] units = { "Millimeter","Centimeter","Decimeter","Meter","Decameter","Hectometer","Kilometer"};

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

        if (fromUnit.equals("Millimeter") && toUnit.equals("Millimeter")) {
            result = input ;
        }
        else if (fromUnit.equals("Millimeter") && toUnit.equals("Centimeter")) {
            result = input * 10;
        }
        else if (fromUnit.equals("Millimeter") && toUnit.equals("Decimeter")) {
            result = input * 100;
        }
        else if (fromUnit.equals("Millimeter") && toUnit.equals("Meter")) {
            result = input * 1000;
        }
        else if (fromUnit.equals("Millimeter") && toUnit.equals("Decameter")) {
            result = input * 10000;
        }
        else if (fromUnit.equals("Millimeter") && toUnit.equals("Hectometer")) {
            result = input * 100000;
        }
        else if (fromUnit.equals("Millimeter") && toUnit.equals("Kilometer")) {
            result = input * 1000000;
        }

            else if (fromUnit.equals("Centimeter") && toUnit.equals("Millimeter")) {
            result = input / 10;
        }  else if (fromUnit.equals("Centimeter") && toUnit.equals("Centimeter")) {
            result = input ;
        }
            else if (fromUnit.equals("Centimeter") && toUnit.equals("Decimeter")) {
            result = input * 10;
        }
            else if (fromUnit.equals("Centimeter") && toUnit.equals("Meter")) {
            result = input * 100;
        }
            else if (fromUnit.equals("Centimeter") && toUnit.equals("Decameter")) {
            result = input * 1000;
        }
            else if (fromUnit.equals("Centimeter") && toUnit.equals("HectoMeter")) {
            result = input * 10000;
        }
            else if (fromUnit.equals("Centimeter") && toUnit.equals("Kilometer")) {
            result = input * 100000;
        }

            else if (fromUnit.equals("Decimeter") && toUnit.equals("Millimeter")) {
            result = input / 10;
        }
            else if (fromUnit.equals("Decimeter") && toUnit.equals("Centimeter")) {
            result = input / 100;
        }
        else if (fromUnit.equals("Decimeter") && toUnit.equals("Decimeter")) {
            result = input ;
        }
        else if (fromUnit.equals("Decimeter") && toUnit.equals("Meter")) {
            result = input * 10;
        }
        else if (fromUnit.equals("Decimeter") && toUnit.equals("Decameter")) {
            result = input * 100;
        }
        else if (fromUnit.equals("Decimeter") && toUnit.equals("HectoMeter")) {
            result = input * 1000;
        }
        else if (fromUnit.equals("Decimeter") && toUnit.equals("Kilometer")) {
            result = input * 10000;
        }

        else if (fromUnit.equals("Meter") && toUnit.equals("Millimeter")) {
            result = input / 10;
        }
        else if (fromUnit.equals("Meter") && toUnit.equals("Centimeter")) {
            result = input / 100;
        }
        else if (fromUnit.equals("Meter") && toUnit.equals("Decimeter")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Meter") && toUnit.equals("Meter")) {
            result = input ;
        }
        else if (fromUnit.equals("Meter") && toUnit.equals("Decameter")) {
            result = input * 10;
        }
        else if (fromUnit.equals("Meter") && toUnit.equals("HectoMeter")) {
            result = input * 100;
        }
        else if (fromUnit.equals("Meter") && toUnit.equals("Kilometer")) {
            result = input * 1000;
        }

        else if (fromUnit.equals("Decameter") && toUnit.equals("Millimeter")) {
            result = input / 10;
        }
        else if (fromUnit.equals("Decameter") && toUnit.equals("Centimeter")) {
            result = input / 100;
        }
        else if (fromUnit.equals("Decameter") && toUnit.equals("Decimeter")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Decameter") && toUnit.equals("Meter")) {
            result = input /10000 ;
        }
        else if (fromUnit.equals("Decameter") && toUnit.equals("Decameter")) {
            result = input ;
        }
        else if (fromUnit.equals("Decameter") && toUnit.equals("HectoMeter")) {
            result = input * 10;
        }
        else if (fromUnit.equals("Decameter") && toUnit.equals("Kilometer")) {
            result = input * 100;
        }

        else if (fromUnit.equals("Hectometer") && toUnit.equals("Millimeter")) {
            result = input / 10;
        }
        else if (fromUnit.equals("Hectometer") && toUnit.equals("Centimeter")) {
            result = input / 100;
        }
        else if (fromUnit.equals("Hectometer") && toUnit.equals("Decimeter")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Hectometer") && toUnit.equals("Meter")) {
            result = input /10000 ;
        }
        else if (fromUnit.equals("Hectometer") && toUnit.equals("Decameter")) {
            result = input / 100000;
        }
        else if (fromUnit.equals("Hectometer") && toUnit.equals("HectoMeter")) {
            result = input ;
        }
        else if (fromUnit.equals("Hectometer") && toUnit.equals("Kilometer")) {
            result = input * 10;
        }

        else if (fromUnit.equals("Kilometer") && toUnit.equals("Millimeter")) {
            result = input / 10;
        }
        else if (fromUnit.equals("Kilometer") && toUnit.equals("Centimeter")) {
            result = input / 100;
        }
        else if (fromUnit.equals("Kilometer") && toUnit.equals("Decimeter")) {
            result = input / 1000;
        }
        else if (fromUnit.equals("Kilometer") && toUnit.equals("Meter")) {
            result = input /10000 ;
        }
        else if (fromUnit.equals("Kilometer") && toUnit.equals("Decameter")) {
            result = input / 100000;
        }
        else if (fromUnit.equals("Kilometer") && toUnit.equals("HectoMeter")) {
            result = input / 1000000;
        }
        else if (fromUnit.equals("Kilometer") && toUnit.equals("Kilometer")) {
            result = input ;
        }

        else {
            result = input;
        }

        textViewResult.setText(String.format("Result: %.2f %s", result, toUnit));
    }

    public void open(View view){
        Intent intent = new Intent(Length_Page.this, Home_Page.class);
        startActivity(intent);
    }
}