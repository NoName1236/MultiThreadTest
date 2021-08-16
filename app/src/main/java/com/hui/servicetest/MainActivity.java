package com.hui.servicetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button btn_change;
    private TextView tv_show;
    public static final int UPDATE_TEXT = 1;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    tv_show.setText("蜜雪冰城甜蜜蜜！");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show = findViewById(R.id.main_tv_text_change);
        btn_change = findViewById(R.id.main_btn_click_to_change);
        btn_change.setOnClickListener(this);

//        new MyThread().start();//继承自Thread的线程的用法
//
//        MyRunnableThread myRunnableThread = new MyRunnableThread();
//        new Thread(myRunnableThread).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.e(TAG, "run: NoNameMethod");
//            }
//        }).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_btn_click_to_change:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        tv_show.setText("很有精神!");
                        Message msg = new Message();
                        msg.what = UPDATE_TEXT;
                        handler.sendMessage(msg);//将Message对象送出去
                    }
                }).start();

//                new DownloadTask().execute();

                break;
            default:
                break;
        }
    }
}