package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Selection extends AppCompatActivity {
    private TextView back;
    private Button doctorReg,patientReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        doctorReg=findViewById(R.id.doctorReg);
        patientReg=findViewById(R.id.patientReg);
        patientReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Selection.this,hospitalActivity.class);
                startActivity(intent);
            }
        });
        doctorReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Selection.this,Sponsor.class);
                startActivity(intent);
            }
        });
    }
}



