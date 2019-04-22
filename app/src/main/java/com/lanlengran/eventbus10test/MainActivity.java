package com.lanlengran.eventbus10test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
    }
    public void onEvent(AnyEventType event) {
        Log.d(TAG, "onEvent: 我收到消息的线程"+Thread.currentThread().getName());
        Log.d(TAG, "onEvent: 收到消息"+event.getText());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void click(View view){
        startActivity(new Intent(this,SecondActivity.class));
    }
}
