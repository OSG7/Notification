package com.studio.ligament.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.media.audiofx.BassBoost;
import android.provider.Settings;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch sw1, sw2, sw3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw1 = (Switch)findViewById(R.id.switch1);
        sw2 = (Switch)findViewById(R.id.switch2);
        sw3 = (Switch)findViewById(R.id.switch3);

        btn = (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNotification();
            }
        });
    }

    private void setNotification()
    {
        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setContentTitle("Andriod Studio Tutorial")
                .setContentText("การแจ้งแตือน")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true);

        if (sw1.isChecked())
            builder.setVibrate(new long[]{750,750,750,750});
        if (sw2.isChecked())
            builder.setLights(Color.WHITE,1500,1500);
        if (sw3.isChecked())
            builder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1000, notification);
    }
}
