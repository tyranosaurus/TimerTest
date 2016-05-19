package com.estsoft.timertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
private Timer timer = new Timer();

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //(클래스이름,1초후 시작, 1초가 지날때마다 앞에쓴 클래스를 실행)
        timer.schedule(new MyTimerTask(), 1000, 1000);
        }
나는 최영진이다
//내부클래스
private class MyTimerTask extends TimerTask {

    private int seconds = 0;

    @Override
    public void run(){
        if (++seconds > 10){
            Log.d("------->", "Timer Cancel");
            timer.cancel();

            //startActivity();
            finish();
            return;
        }

        //UI변경
        // Log.d("------->", ""+seconds);
        runOnUiThread(new Runnable() {
            @Override
            public void run(){
                TextView tv = (TextView) findViewById(R.id.textview);
                tv.setText(""+seconds);
            }
        });
    }
}

}