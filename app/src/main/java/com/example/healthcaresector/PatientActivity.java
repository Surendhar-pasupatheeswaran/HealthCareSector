package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PatientActivity extends AppCompatActivity {
    EditText username,password,repassword;

    Button  signin,signup;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        signin=findViewById(R.id.Signin);
        username=findViewById(R.id.RegisterFullName);
        password=findViewById(R.id.loginPassword);
        repassword=findViewById(R.id.ConfirmPassword);

        if(TextUtils.isEmpty(username.getText().toString())) {
            username.setError("Username is compulsory");

        }


        if(TextUtils.isEmpty(password.getText().toString())){
            password.setError("Password is compulsory");
        }
        if(TextUtils.isEmpty(repassword.getText().toString()))
            repassword.setError("Password  is compulsory");


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(PatientActivity.this,Login.class);
                startActivity(intent);
            }
        });

        signup=findViewById(R.id.Signup);
        myDB=new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailPattern1="^[a-zA-Z0-9]{1,20}@[a-z0-9]{1,20}.[a-zA-Z]{2,3}$";

                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                {
                    Toast.makeText(PatientActivity.this,"Fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pass.equals(repass))
                    {
                        Boolean userCheckResult=myDB.checkusername(user);
                        if(userCheckResult==false){
                         Boolean regResult=myDB.insertData(user,pass);
                         if (regResult==true&&user.matches(emailPattern1)){

                                 Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                                 Toast.makeText(PatientActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                 Intent intent=new Intent(PatientActivity.this,Login.class);
                                 startActivity(intent);
                         }

                        }
                        else{
                            Toast.makeText(PatientActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(PatientActivity.this,"Password  not matching", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

    }
}