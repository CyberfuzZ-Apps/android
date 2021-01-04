package com.hfad.odometer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private OdometerService odometer;
    private boolean bound = false;

    //Создание объекта ServiceConnection
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder binder) {

            //Код, выполняемый при связывании со службой
            OdometerService.OdometerBinder odometerBinder =
                    (OdometerService.OdometerBinder) binder;
            odometer = odometerBinder.getOdometer();
            bound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            //Код, выполняемый при разрыве связи со службой
            bound = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayDistance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, OdometerService.class);
        //Связывание службы выполняется при запуске активности
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bound) {
            //Связывание отменяется при остановке активности
            unbindService(connection);
            bound = false;
        }
    }

    private void displayDistance() {
        final TextView distanceView = (TextView) findViewById(R.id.distance);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                double distance = 0.0;
                if (bound && odometer != null) {
                    distance = odometer.getDistance();
                }
                String distanceStr = String.format(Locale.getDefault(),
                        "%1$,.2f miles", distance);
                distanceView.setText(distanceStr);
                handler.postDelayed(this, 1000);
            }
        });
    }
}