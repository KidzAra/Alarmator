package com.kidz.alarmator

import android.app.AlarmManager as AndroidAlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.Calendar

class AlarmManager (private val context: Context) {
    fun scheduleAlarm(entity: Alarm) {
        val alarmType = entity.alarmType
        val isEnabled = entity.isEnabled
        val hour = entity.hour
        val minute = entity.minute
        val days = entity.days

        val androidAlarmManager = context.getSystemService(Context.ALARM_SERVICE) as AndroidAlarmManager
        //! Зафиксить и разробраться
        val intent = Intent(context, AlarmManager::class.java).apply {
            putExtra("alarmId", entity.id)
            putExtra("alarmType", entity.alarmType)
        }

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            entity.id,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    fun cancelAlarm() {
        /*
        Тут будет метод по отмене будильника
         */
    }

    fun SyncAllAlarms() {
        /*
        Тут будет прогонять синхронзация
         */
    }
}