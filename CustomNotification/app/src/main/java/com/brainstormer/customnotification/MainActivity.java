package com.brainstormer.customnotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "Massage Channel";

    private static final int NOTIFICATION_ID = 100;
    private static final int REQ_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.hosting,null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeIcon = bitmapDrawable.getBitmap();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;

        Intent iNotify = new Intent(getApplicationContext(),MainActivity.class);
        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi = PendingIntent.getActivity(this, REQ_CODE,iNotify,PendingIntent.FLAG_UPDATE_CURRENT);

        //big picture style
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) (ResourcesCompat.getDrawable(getResources(), R.drawable.thumb,null))).getBitmap())
                .bigLargeIcon(largeIcon)
                .setBigContentTitle("Image sent by CEO")
                .setSummaryText("Image massage");

        //inbox style

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("R")
                .addLine("A")
                .addLine("K")
                .addLine("I")
                .addLine("B")
                .addLine("U")
                .addLine("L")
                .addLine(" ")
                .addLine("H")
                .addLine("A")
                .addLine("S")
                .addLine("S")
                .addLine("A")
                .addLine("N")
                .setBigContentTitle("Full Massage")
                .setSummaryText("Massage from Alamin");


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.servers)
                    .setContentText("New massage")
                    .setSubText("New massage from Soyad")
                    .setStyle(inboxStyle)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .setChannelId(CHANNEL_ID)
                    .setContentIntent(pi)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel",NotificationManager.IMPORTANCE_HIGH));
        } else{
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.servers)
                    .setContentText("New massage")
                    .setSubText("New massage from Soyad")
                    .setStyle(inboxStyle)
                    .setAutoCancel(false)
                    .setOngoing(true)
                    .setContentIntent(pi)
                    .build();
        }

        nm.notify(NOTIFICATION_ID,notification);
    }
}