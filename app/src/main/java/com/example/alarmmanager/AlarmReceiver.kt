package com.example.alarmmanager

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val intent = Intent(context,DestinationActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context,0,intent,0)

        val  builder = NotificationCompat.Builder(context!!,"AlarmManager")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Alarm Manager")
            .setContentText("Demo Alarm Manager By Satya")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(123,builder.build())

// test
        
    }
}