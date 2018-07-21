package com.example.administrator.test5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BasicActicity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
    }
    public void login(View view){
        String user=username.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if (user!=null&&pass!=null&&user.equals("admin")&&pass.equals("admin")){
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
