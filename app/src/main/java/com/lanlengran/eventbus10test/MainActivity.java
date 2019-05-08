package com.lanlengran.eventbus10test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lanlengran.eventbus10test.MyEventBus.MyEventBus;

import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyEventBus.getDefault().register(this);

        Glide.load("https://ss0.baidu.com/73x1bjeh1BF3odCf/it/u=3439398034,3720723064&fm=85&s=27D13DC8C6209F4D0E5C7810030090D8")
                .into((ImageView)findViewById(R.id.imageview));
      //  MyEventBus.getDefault().register(this, "OnEventTest", EventBus.ThreadMode.PostThread);
    }

    public void onEvent(AnyEventType event) {
        Log.d(TAG, "onEvent: 我收到消息的线程" + Thread.currentThread().getName());
        Log.d(TAG, "onEvent: 收到消息" + event.getText());
    }

    public void OnEventTest(String event) {
        Log.d(TAG, "OnEventTest: 我收到消息的线程" + Thread.currentThread().getName());
        Log.d(TAG, "OnEventTest: 收到消息" + event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
      //  EventBus.getDefault().unregister(this);
    }

    public void click(View view) {
        if (view.getId()==R.id.btn1){
            startActivity(new Intent(this, SecondActivity.class));
        }else if (view.getId()==R.id.btn2){
            MyEventBus.getDefault().unregister(this);
        }

    }
}
