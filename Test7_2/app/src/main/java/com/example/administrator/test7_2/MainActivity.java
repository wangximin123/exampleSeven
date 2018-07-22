package com.example.administrator.test7_2;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);

    }
    public void updateDatabase(View view){
        Uri uri=Uri.parse("content://com.example.administrator.test7.provider/Book/13");
        ContentValues values=new ContentValues();
        values.put("name","ababa");
        int updateRow=getContentResolver().update(uri,values,null,null);
        Log.d("result","updateRow:"+updateRow);
    }
    public void insertDatabase(View view){
        Uri uri=Uri.parse("content://com.example.administrator.test7.provider/Book");
        ContentValues values=new ContentValues();
        values.put("author","wang");
        values.put("price",23.5);
        values.put("page",100);
        values.put("name","AGookBook");
        Uri newUri=getContentResolver().insert(uri,values);
        Log.d("result","newUri:"+newUri);
    }
    public void deleteDatabase(View view){
        Uri uri=Uri.parse("content://com.example.administrator.test7.provider/Book");
        int deleteRow=getContentResolver().delete(uri,null,null);
        Log.d("result","deleteRow:"+deleteRow);
    }
    public void queryDatabase(View view){

        Uri uri=Uri.parse("content://com.example.administrator.test7.provider/Book");
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        if (cursor!=null){
            Log.d("result",cursor.getCount()+"");
            while (cursor.moveToNext()){
                String id=cursor.getString(cursor.getColumnIndex("id"));
                String author=cursor.getString(cursor.getColumnIndex("author"));
                float price=cursor.getFloat(cursor.getColumnIndex("price"));
                int page=cursor.getInt(cursor.getColumnIndex("page"));
                String name=cursor.getString(cursor.getColumnIndex("name"));
                Log.d("result",id+"--"+author+"--"+price+"--"+page+"--"+name);
            }
        }else {
            Log.d("result","haha");
        }
    }

}
