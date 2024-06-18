package com.example.healthcaresector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Apolo extends AppCompatActivity {
    DBHelper DB;
    EditText bed,oxygen,doctor;

    Button btnview,medicine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apolo);

        bed=findViewById(R.id.editTextTextPersonName);
        oxygen=findViewById(R.id.editTextTextPersonName2);
        doctor=findViewById(R.id.editTextTextPersonName3);
        DB= new DBHelper(this);
        btnview=findViewById(R.id.view);
        medicine=findViewById(R.id.medicine);
        btnview.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           Cursor res= DB.getdata();
                                           if (res.getCount()==0)
                                               Toast.makeText(Apolo.this, "No Entry Found", Toast.LENGTH_SHORT).show();

                                           StringBuffer buffer= new StringBuffer();
                                           while(res.moveToNext()){
                                               buffer.append("BED:" + res.getString(1)+ "\n");
                                               buffer.append("OXYGEN:" + res.getString(2)+ "\n");
                                               buffer.append("DOCTOR:" + res.getString(3)+ "\n");
                                           }

                                           AlertDialog.Builder builder=new AlertDialog.Builder(Apolo.this);
                                           builder.setCancelable(true);
                                           builder.setTitle("AVAILABLE FACILITIES");
                                           builder.setMessage(buffer.toString());
                                           builder.show();



    }
                                   });
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Apolo.this,PSG.class);
                startActivity(intent);
            }
        });

    }
}