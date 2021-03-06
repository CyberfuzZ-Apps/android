package com.hfad.joke;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat;


public class DelayedMessageService extends IntentService {

    public static final String EXTRA_MESSAGE = "message";
    public static final int NOTIFICATION_ID = 5453; //произвольное значение

    public DelayedMessageService() {
        super("DelayedMessageService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        synchronized (this) {
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        String text = intent.getStringExtra(EXTRA_MESSAGE);
        showText(text);

    }

    private void showText(final String text) {

        //Создание построителя уведомлений
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle(getString(R.string.question))
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVibrate(new long[] {0, 1000})
                .setAutoCancel(true);

        //Создание действия:

        //Создание интента
        Intent actionIntent = new Intent(this, MainActivity.class);

        //Создание отложенного интента
        PendingIntent actionPendingIntent = PendingIntent.getActivity(
                this,
                0,
                actionIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //Отложенный интент добавляется к уведомлению
        builder.setContentIntent(actionPendingIntent);

        //Выдача уведомления
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}