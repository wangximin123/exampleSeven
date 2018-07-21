package com.example.administrator.test5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BasicActicity {

    private MyReceiver1 myReceiver1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void send(View view){
        Intent intent=new Intent("com.a.MY_BROADCAST");
        sendBroadcast(intent);
    }
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.a.MY_BROADCAST");
        myReceiver1 = new MyReceiver1();
        registerReceiver(myReceiver1,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver1);
    }

    class MyReceiver1 extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"haha111",Toast.LENGTH_SHORT).show();
            Log.d("result","hahaha111");
        }
    }


}
