package com.jc.android.plantdairy.notif

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*


object AlarmScheduler {

    fun scheduleAlarmsForReminder(context: Context) {
        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = createPendingIntent(context)
        scheduleAlarm(alarmIntent, alarmMgr)
    }

    private fun scheduleAlarm(alarmIntent: PendingIntent?, alarmMgr: AlarmManager) {
        val datetimeToAlarm = Calendar.getInstance(Locale.getDefault())
        datetimeToAlarm.timeInMillis = System.currentTimeMillis()
        alarmMgr.set(AlarmManager.RTC_WAKEUP, datetimeToAlarm.timeInMillis + (1000 * 3), alarmIntent)
    }

    private fun createPendingIntent(context: Context): PendingIntent? {
        val intent = Intent(context.applicationContext, AlarmReceiver::class.java)
        return PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    }
}