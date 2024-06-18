package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class medicine extends AppCompatActivity {
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        DB= new DBHelper(this);

    }
    public void GetDataToText(View v){
        TextView txv1=(TextView) findViewById(R.id.textView2);
        TextView txv2=(TextView) findViewById(R.id.textView3);
        TextView txv3=(TextView) findViewById(R.id.textView5);
        Cursor res= DB.getdata();
        if (res.getCount()==0)
            Toast.makeText(medicine.this, "No Entry Found", Toast.LENGTH_SHORT).show();

        StringBuffer buffer= new StringBuffer();
        while(res.moveToNext()){
            txv1.setText(res.getString(1)+ "\n");
            txv2.setText( res.getString(2)+ "\n");
            txv3.setText( res.getString(3)+ "\n");
        }



    }
}