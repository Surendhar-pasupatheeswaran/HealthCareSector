package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class privatehealth extends AppCompatActivity {
Button gmeet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privatehealth);
        gmeet=findViewById(R.id.button4);
        gmeet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golink("https://meet.google.com/koe-zsun-sre");
            }
        });
    }
    private void golink(String s){
        Uri uri= Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}