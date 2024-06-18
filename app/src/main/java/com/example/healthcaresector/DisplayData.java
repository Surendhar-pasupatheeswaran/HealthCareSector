package com.example.healthcaresector;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class DisplayData extends AppCompatActivity {
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    Spinner spinner;
    String []item;
    int []id;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        dbHelper=new DBHelper(DisplayData.this);
        findid();
        displayData();
    }
    private void displayData(){
        sqLiteDatabase=dbHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("Select *from admin",null);
        if(cursor.getCount()>0){
            id=new int [cursor.getCount()];
            item=new String[cursor.getCount()];
            int i=0;
            while(cursor.moveToNext()){
                id[i]=cursor.getInt(0);
                item[i]=cursor.getString(1);
                i++;
            }
            Custom custom=new Custom();
            listView.setAdapter(custom);
        }
    }
    private void findid(){

        listView=(ListView)findViewById(R.id.olist);
        Intent intent=new Intent(DisplayData.this,privatehealth.class);
        startActivity(intent);
    }
    private  class Custom extends BaseAdapter{
        @Override
        public int getCount(){
            return item.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position){
            return 0;
        }
        @Override
        public View getView(int position, View convertView , ViewGroup parent){
            TextView textView;
            convertView= LayoutInflater.from(DisplayData.this).inflate(R.layout.singledata,parent,false);
            textView=convertView.findViewById(R.id.viewText);
            textView.setText(item[position]);
            return  convertView;
        }
    }

}