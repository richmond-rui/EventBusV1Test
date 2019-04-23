package com.lanlengran.eventbus10test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import de.greenrobot.event.EventBus;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void click(View view){
        new Thread(){
            @Override
            public void run() {
                super.run();
                senMsg();
            }
        }.start();

    }

    private void senMsg() {
        Log.d("MainActivity", "run: 我运行在线程"+Thread.currentThread().getName());
        EventBus.getDefault().post(new AnyEventType("这是第二个页面传递过来的"));
        EventBus.getDefault().post(new SecEventType("这是第二个页面传递过来的"));
        EventBus.getDefault().post("233333");
    }
}
