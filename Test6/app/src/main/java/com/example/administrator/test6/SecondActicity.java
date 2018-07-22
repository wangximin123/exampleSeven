package com.example.administrator.test6;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondActicity extends AppCompatActivity {
    TextView showText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acticity);
        showText=findViewById(R.id.showText);
        SharedPreferences sharedPreferences=getSharedPreferences("MyData1",MODE_PRIVATE);
        String s=sharedPreferences.getString("aa","0");
        showText.setText(s);
    }
}
