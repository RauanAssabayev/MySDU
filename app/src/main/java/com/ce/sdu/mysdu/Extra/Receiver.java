package com.ce.sdu.mysdu.Extra;

/**
 * Created by rauan on 08.06.2017.
 */

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.ce.sdu.mysdu.activity.MainActivity;

import java.util.Random;

public class Receiver extends BroadcastReceiver {
    NotificationManager nm;
    Random rn = new Random();
    @Override
    public void onReceive(Context cnt, Intent inte) {
        nm = (NotificationManager) cnt.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(cnt);
        Intent intent = new Intent(cnt, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(cnt, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pIntent);
        //builder.setSmallIcon(R.drawable.alarm);
        //builder.setLargeIcon(BitmapFactory.decodeResource(cnt.getResources(), R.mipmap.ico));
        String title = inte.getStringExtra("extra");
        builder.setTicker(title);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle(title);
        long[] pattern = {500,500,500,500,500,500,500,500,500};
        builder.setVibrate(pattern);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        builder.setSound(alarmSound);
        String note = inte.getStringExtra("desc");
        builder.setContentText(note);
        //Notification notification = builder.build();
        int id = rn.nextInt(10000);
        Log.i("id", id+"");
        //nm.notify(id, notification);
    }
}