package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hospitalActivity extends AppCompatActivity {
    TextView appolo,kg,kmch,ganga,psg;
    Button Update,button,butt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        button=findViewById(R.id.button7);

        butt=findViewById(R.id.button3);
        Update=findViewById(R.id.button2);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hospitalActivity.this,Apolo.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hospitalActivity.this,DisplayData.class);
                startActivity(intent);
            }
        });

    }
}