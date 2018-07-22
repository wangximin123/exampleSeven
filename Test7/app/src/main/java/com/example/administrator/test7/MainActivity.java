package com.example.administrator.test7;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyHelper myHelper=new MyHelper(this,"BookShore",null,2);
        SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put("author","wang");
//        values.put("price",23.5);
//        values.put("page",100);
//        values.put("name","AGookBook");
//        Uri newUri=null;
//        long l=sqLiteDatabase.insert("Book",null,values);
//        newUri=Uri.parse("content://com.example.administrator.test7.provider/Book/"+l);
//        Log.d("result","newUri:"+newUri);
//        Cursor cursor=sqLiteDatabase.query("Book",null ,null,null,null,null,null);
//        while (cursor.moveToNext()){
//            String id=cursor.getString(cursor.getColumnIndex("id"));
//            String author=cursor.getString(cursor.getColumnIndex("author"));
//            float price=cursor.getFloat(cursor.getColumnIndex("price"));
//            int page=cursor.getInt(cursor.getColumnIndex("page"));
//            String name=cursor.getString(cursor.getColumnIndex("name"));
//            Log.d("result",id+"--"+author+"--"+price+"--"+page+"--"+name);
//        }
    }



}

