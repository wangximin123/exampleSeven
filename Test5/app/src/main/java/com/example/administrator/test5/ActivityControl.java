package com.example.administrator.test5;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityControl {
    public static List<Activity> list=new ArrayList<Activity>();
    public static void addActivity(Activity activity){
        list.add(activity);
    }
    public static void removeActivity(Activity activity){
        list.remove(activity);
    }
    public static void closeAll(){
        for (Activity activity:list){
            if (activity!=null)
                activity.finish();
        }
    }
}
