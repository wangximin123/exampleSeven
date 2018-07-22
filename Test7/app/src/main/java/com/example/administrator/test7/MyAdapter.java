package com.example.administrator.test7;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {
    private int resource;
    List<String> list;
    public MyAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.resource=resource;
        list=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=null;
        MyHolder myHolder;
        if (convertView!=null){
            view=convertView;
            myHolder= (MyHolder) convertView.getTag();
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
            myHolder=new MyHolder(view);
            view.setTag(myHolder);
        }
        String s=list.get(position);
        myHolder.textView.setText(s);
        return view;
    }
    class MyHolder{
        TextView textView;
        public MyHolder(View view){
            textView=view.findViewById(R.id.listItem);
        }
    }
}
