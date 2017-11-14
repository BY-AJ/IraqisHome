package com.itcast.iraqishome;

import android.os.Bundle;

import com.itcast.iraqishome.activity.BaseActivity;

public class MainActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
