package com.alisha.tasbeeh;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class SplashActivity extends Activity {

    MediaPlayer startingTone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startingTone = MediaPlayer.create(SplashActivity.this, R.raw.bismillah);
        startingTone.start();

        Thread timer = new Thread(){
            public void run(){
                try
                {
                    sleep(4000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    Intent openStartingPoint = new Intent("com.alisha.tasbeeh.STARTINGPOINT");
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        startingTone.release();
        finish();
    }
}
