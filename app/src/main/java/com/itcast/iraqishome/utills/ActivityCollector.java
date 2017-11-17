package com.itcast.iraqishome.utills;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by yb on 2017/10/27.
 */

public class ActivityCollector {
    private static Stack<Activity> stack = new Stack<>();

    private static ActivityCollector instance;
    private ActivityCollector(){
    }

    public static ActivityCollector getActivityCollector() {
        if(instance == null) {
            instance = new ActivityCollector();
        }
        return instance;
    }


    public void addActivity(Activity activity) {
        stack.add(activity);
    }

    public void removeActivity(Activity activity) {
        if(activity != null) {
            stack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void finishAll() {
        for (int i=0;i<stack.size();i++) {
            if(null != stack.get(i)) {
                stack.get(i).finish();
            }
        }
        stack.clear();
    }

}
