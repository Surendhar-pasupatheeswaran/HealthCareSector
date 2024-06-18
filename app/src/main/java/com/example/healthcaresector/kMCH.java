package com.example.healthcaresector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kMCH extends AppCompatActivity {
    EditText id,bed,oxygen,doctor;
    Button btninsert, btnupdate, btnview, btndelete,medicine ;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kmch);
        bed=findViewById(R.id.editTextTextPersonName);
        oxygen=findViewById(R.id.editTextTextPersonName2);
        doctor=findViewById(R.id.editTextTextPersonName3);
        DB= new DBHelper(this);
        btninsert=findViewById(R.id.insert);
        btndelete=findViewById(R.id.delete);

        btnupdate=findViewById(R.id.update);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idTXT=id.getText().toString();
                String nameTXT=bed.getText().toString();
                String dobTXT=oxygen.getText().toString();
                String contactTXT=doctor.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata( nameTXT, dobTXT,contactTXT);
                if (checkupdatedata==true)
                    Toast.makeText(kMCH.this, " Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(kMCH.this, " Entry Not Updated", Toast.LENGTH_SHORT).show();
            }
        });
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=bed.getText().toString();
                String dobTXT=oxygen.getText().toString();
                String contactTXT=doctor.getText().toString();
                if (nameTXT.isEmpty()|| dobTXT.isEmpty()||contactTXT.isEmpty()){
                    Toast.makeText(kMCH.this,"Enter the credentials",Toast.LENGTH_SHORT).show();
                }
                Boolean checkinsertdata1 = DB.insertData2(nameTXT, dobTXT,contactTXT);

                if (checkinsertdata1==true)
                    Toast.makeText(kMCH.this, "New Entry Made", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(kMCH.this, "New Entry Not Made", Toast.LENGTH_SHORT).show();
            }
        });



        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=bed.getText().toString();
                String oxygen1=oxygen.getText().toString();
                String doctor1=doctor.getText().toString();
                Boolean checkdeletedata = DB.deletedata(nameTXT,oxygen1,doctor1);

                if (checkdeletedata==true)
                    Toast.makeText(kMCH.this, " Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(kMCH.this, " Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}




