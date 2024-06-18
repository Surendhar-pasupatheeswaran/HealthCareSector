package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
public class KG extends AppCompatActivity {
    EditText Name, Location;
    Button btninsert, btnupdate, btnview, btndelete, medicine;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kg);

        Name = findViewById(R.id.editTextTextPersonName7);
        Location = findViewById(R.id.editTextTextPersonName6);
        DB = new DBHelper(this);
        btninsert = findViewById(R.id.insert);


        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String location = Location.getText().toString();

                if (name.isEmpty() || location.isEmpty()) {
                    Toast.makeText(KG.this, "Enter the credentials", Toast.LENGTH_SHORT).show();
                }
                Boolean checkinsertdata1 = DB.insertData3(name,location);

                if (checkinsertdata1 == true)
                    Toast.makeText(KG.this, "New Entry Made", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(KG.this, "New Entry Not Made", Toast.LENGTH_SHORT).show();
            }
        });


    }
}


