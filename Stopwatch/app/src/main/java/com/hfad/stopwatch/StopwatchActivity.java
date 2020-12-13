package com.hfad.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class StopwatchActivity extends Activity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
    }

    //Старт секундомера, когда нажата кнопка Start
    public void onClickStart(View view) {
        running = true;
    }

    //Остановка секундомера при нажатии кнопки Stop
    public void onClickStop(View view) {
        running = false;
    }

    //Сброс секундомера при нажатии кнопки Reset
    public void onClickReset(View view) {
        running = false;
        seconds = 0;
    }
}