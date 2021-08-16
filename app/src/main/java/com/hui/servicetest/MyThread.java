package com.hui.servicetest;

import android.util.Log;

public class MyThread extends Thread{
    private static final String TAG = "MyThread";
    @Override
    public void run() {
        super.run();
        Log.e(TAG, "run: MyThread's run method");
    }
}
