package com.lanlengran.eventbus10test;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * @des:
 * @author: 芮勤
 * @date: 2019/4/22 17:45
 * @see {@link }
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    public void onEvent(SecEventType event) {
        Log.d(TAG, "onEvent: 我是父类我收到消息的线程"+Thread.currentThread().getName());
        Log.d(TAG, "onEvent: 我是父类我收到消息"+event.getText());
    }
}
