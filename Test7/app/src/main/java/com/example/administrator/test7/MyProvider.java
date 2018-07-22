package com.example.administrator.test7;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MyProvider extends ContentProvider {
    public static final int BOOK_DIR=2;
    public static final int BOOK_ITEM=3;
    public static final String AUTHORITY="com.example.administrator.test7.provider";
    private MyHelper myHelper;
    public static UriMatcher uriMatcher;
    static {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"Book",BOOK_DIR);
        uriMatcher.addURI(AUTHORITY,"Book/#",BOOK_ITEM);
    }
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase sqLiteDatabase=myHelper.getReadableDatabase();
        Cursor cursor=null;
        Log.d("result",uri.toString());
        Log.d("result","-----"+uriMatcher.match(uri));
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                cursor=sqLiteDatabase.query("Book",projection,selection,selectionArgs,null,null,sortOrder);
                break;
            case BOOK_ITEM:
                String bookId=uri.getPathSegments().get(1);
                cursor=sqLiteDatabase.query("Book",projection,"id=?",new String[]{bookId},null,null,sortOrder);
                break;
        }
        return cursor;
    }
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();
        int deleteRow=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                deleteRow=sqLiteDatabase.delete("Book",selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String id=uri.getPathSegments().get(1);
                deleteRow=sqLiteDatabase.delete("Book","id=?",new String[]{id});

        }
        return deleteRow;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                return "vnd.android.cursor.dir/com.example.app.provider.Book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/com.example.app.provider.Book";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();
        Uri newUri=null;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                Log.d("result","1212121");
                long bookid=sqLiteDatabase.insert("Book",null,values);
                newUri=Uri.parse("content://"+AUTHORITY+"/Book/"+bookid);
                        //content://com.example.administrator.test7.provider/Book
                break;
        }

        return newUri;
    }

    @Override
    public boolean onCreate() {
        myHelper=new MyHelper(getContext(),"BookShore",null,2);
        return true;
    }



    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();
        int updateRow=0;
        switch (uriMatcher.match(uri)){
            case BOOK_DIR:
                updateRow=sqLiteDatabase.update("Book",values,selection,selectionArgs);
                break;
            case BOOK_ITEM:
                String id=uri.getPathSegments().get(1);
                updateRow=sqLiteDatabase.update("Book",values,"id=?",new String[]{id});
                break;
        }

        return updateRow;
    }
}
