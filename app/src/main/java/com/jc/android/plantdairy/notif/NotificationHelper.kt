package com.jc.android.plantdairy.notif

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.jc.android.plantdairy.R
import com.jc.android.plantdairy.ui.MainActivity

object NotificationHelper {

    fun createNotificationChannel(context: Context, importance: Int, showBadge: Boolean, name: String, description: String) {
        // 1. Safety checked the OS version for API 26 and greater.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // 2. Created a unique name for the notification channel.
            //    The name and description are displayed in the application’s Notification settings.
            val channelId = "${context.packageName}-$name"
            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description
            channel.setShowBadge(showBadge)

            // 3. Created the channel using the NotificationManager.
            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun createSampleDataNotification(context: Context, title: String, message: String,
                                     bigText: String, autoCancel: Boolean) {
        // Create the unique channelId for this app using the package name and app name.
        val channelId = "${context.packageName}-${context.getString(R.string.app_name)}"
        // Use NotificationCompat.Builder to begin building the notification.
        val notificationBuilder = NotificationCompat.Builder(context, channelId).apply {
            // Set a small icon to be display in the notification shade. This is the only required attribute.
            setSmallIcon(R.drawable.ic_launcher_foreground)
            setContentTitle(title) // Set a title for the notification.
            setContentText(message) // Set content for the notification.
            setStyle(NotificationCompat.BigTextStyle().bigText(bigText)) // 6
            priority = NotificationCompat.PRIORITY_DEFAULT // 7
            setAutoCancel(autoCancel) // 8

            // Created an Intent to launch the MainActivity.
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            // Wrapped the Intent in a PendingIntent, created through the getActivity() method
            // which returns a description of an Activity to be launched.
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
            // Called setContentIntent() to attach it to the NotificationCompat.Builder.
            setContentIntent(pendingIntent)
        }
        // Used the app’s Context to get a reference to NotificationManagerCompat.
        val notificationManager = NotificationManagerCompat.from(context)
        // Called notify() on the NotificationManager passing in an identifier and the notification.
        notificationManager.notify(1001, notificationBuilder.build())
    }







}