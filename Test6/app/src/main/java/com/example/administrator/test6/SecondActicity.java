package com.example.administrator.test6;

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
    FileInputStream fileInputStream;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acticity);
        showText=findViewById(R.id.showText);
        try {
            fileInputStream=openFileInput("MyData");
            bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
            stringBuilder=new StringBuilder();
            String s=null;
            while((s=bufferedReader.readLine())!=null){
                stringBuilder.append(s);
            }
            showText.setText(stringBuilder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
