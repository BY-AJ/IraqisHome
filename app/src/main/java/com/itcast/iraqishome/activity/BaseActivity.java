package com.itcast.iraqishome.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.itcast.iraqishome.utills.yb.ActivityCollector;
import com.orhanobut.logger.Logger;

/**
 * Created by yb on 2017/11/14.
 */

public class BaseActivity extends AppCompatActivity{
    private ActivityCollector collector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        collector = ActivityCollector.getActivityCollector();
        collector.addActivity(this);

        Logger.init("YB");
        Logger.t(getClass().getSimpleName()).d(getClass().getSimpleName());

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        collector.removeActivity(this);
    }
}
