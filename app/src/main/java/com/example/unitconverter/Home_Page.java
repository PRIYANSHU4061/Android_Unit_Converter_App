package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Home_Page extends AppCompatActivity {

    ImageView i1,i2,i3,i4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        i1 = findViewById(R.id.image1);
        i2 = findViewById(R.id.image2);
        i3 = findViewById(R.id.image3);
        i4 = findViewById(R.id.image4);
    }
    public  void open1(View view){
        Intent intent = new Intent(Home_Page.this, Weight_Page.class);
        startActivity(intent);
    }
    public  void open2(View view){
        Intent intent = new Intent(Home_Page.this, Liter_Page.class);
        startActivity(intent);
    }
    public  void open3(View view){
        Intent intent = new Intent(Home_Page.this, Length_Page.class);
        startActivity(intent);
    }
    public  void open4(View view){
        Intent intent = new Intent(Home_Page.this, Temp_Page.class);
        startActivity(intent);
    }
}