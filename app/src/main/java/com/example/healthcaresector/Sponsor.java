package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sponsor extends AppCompatActivity {
    EditText name,username,password,city,account,amount,phone,address;
    TextView signup;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);
    DBHelper myDb1=new DBHelper(this);
    name=findViewById(R.id.RegisterFullName1);
    username=findViewById(R.id.loginEmail1);
    password=findViewById(R.id.loginPassword1);
    city=findViewById(R.id.city1);
    amount=findViewById(R.id.amount);
    account=findViewById(R.id.account);
    address=findViewById(R.id.editTextTextPostalAddress1);
    phone=findViewById(R.id.registrationIDPhoneNumber1);
    signup=findViewById(R.id.regPageQuestion);
    signin=findViewById(R.id.regButton);
        if(TextUtils.isEmpty(name.getText().toString())){
            name.setError(("Name is compulsory"));
        }
        if(TextUtils.isEmpty(username.getText().toString())) {
            username.setError("Username is compulsory");

        }
        if(TextUtils.isEmpty(password.getText().toString())){
            password.setError("Password is compulsory");
        }
        if(TextUtils.isEmpty(city.getText().toString()))
            city.setError("City is compulsory");
        if(TextUtils.isEmpty(amount.getText().toString()))
            amount.setError("Amount is compulsory");
        if(TextUtils.isEmpty(address.getText().toString()))
            address.setError("Address is compulsory");
        if(TextUtils.isEmpty(phone.getText().toString()))
            phone.setError("Phonenumber is compulsory");
        if(TextUtils.isEmpty((account.getText().toString())))
            account.setError("Account Number is compulsory");

        signin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String emailPattern1="^[a-zA-Z0-9]{1,20}@[a-z0-9]{1,20}.[a-zA-Z]{2,3}$";

               String name1 =name.getText().toString();
               String user = username.getText().toString();
               String pass1 = password.getText().toString();
               String city2 = city.getText().toString();
               String phone1 = phone.getText().toString();
               String address1 = address.getText().toString();
               String account1=account.getText().toString();
               String amount1 = amount.getText().toString();
               if(!phone1.isEmpty()&&Patterns.PHONE.matcher(phone1).matches()&&user.matches(emailPattern1)){
                  Toast.makeText(Sponsor.this,"number verified", Toast.LENGTH_SHORT).show();
                   Toast.makeText(Sponsor.this, "email verified", Toast.LENGTH_SHORT).show();

               }


               if (name1.isEmpty() || user.isEmpty() || pass1.isEmpty() || city2.isEmpty() || amount1.isEmpty() || phone1.isEmpty() || address1.isEmpty()) {
                   Toast.makeText(Sponsor.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
               }
               Boolean regResult = myDb1.insertData1(name1, user, pass1, city2,account1, phone1, address1, amount1);

               if (regResult == true ) {
                   Toast.makeText(Sponsor.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(Sponsor.this, Login.class);
                   startActivity(intent);

               }
              else {
                   Toast.makeText(Sponsor.this, "Registration Failed", Toast.LENGTH_SHORT).show();
               }
           }


         });
}
}


