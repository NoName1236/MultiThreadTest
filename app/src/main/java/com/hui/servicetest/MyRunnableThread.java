package com.hui.servicetest;

import android.util.Log;

public class MyRunnableThread implements Runnable{
    private static final String TAG = "MyRunnableThread";
    @Override
    public void run() {
        Log.e(TAG, "run: MyRunnableThread");
    }
}
