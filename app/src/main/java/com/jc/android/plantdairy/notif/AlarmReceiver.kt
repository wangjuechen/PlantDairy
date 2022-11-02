package com.jc.android.plantdairy.notif

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context != null && intent != null) {
            if (intent.extras != null) {
                NotificationHelper.createSampleDataNotification(context, "Plant Dairy", "one plant need to water", "", true)
            }
        }
    }
}