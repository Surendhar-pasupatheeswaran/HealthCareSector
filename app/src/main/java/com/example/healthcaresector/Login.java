package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    private TextView loginPageQuestion,admin;
    EditText username, password;
    Button register;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        loginPageQuestion = findViewById(R.id.loginPageQuestion);
        db = new DBHelper(this);
        register = findViewById(R.id.loginButton);
        admin=findViewById(R.id.admin);
        if(TextUtils.isEmpty(username.getText().toString())){
            username.setError(("Name is compulsory"));
        }

        if(TextUtils.isEmpty(password.getText().toString())){
            password.setError("Password is compulsory");
        }

        else
        {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, "Please Enter the Credential", Toast.LENGTH_SHORT).show();
                }
                else
                {
                Boolean result=  db.checkusenamepassword(user,pass);
                 if(result){
                     Toast.makeText(Login.this,"Logged in successful", Toast.LENGTH_SHORT).show();
                     Intent intent=new Intent(Login.this,Selection.class);
                     startActivity(intent);

                 }
                 else{
                     Toast.makeText(Login.this, "Invalid Credential", Toast.LENGTH_SHORT).show();
                 }

                }
            }
        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Login.this,admin.class);
                startActivity(intent);
            }
        });
        loginPageQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,PatientActivity.class);
                startActivity(intent);
            }
        });


    }
}


