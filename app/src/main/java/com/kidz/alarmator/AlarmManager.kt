package com.kidz.alarmator

import android.Manifest
import android.app.AlarmManager as AndroidAlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kidz.alarmator.AlarmReceiver

import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class AlarmManager (private val context: Context) {
    @RequiresPermission(Manifest.permission.SCHEDULE_EXACT_ALARM)
    fun scheduleAlarm(entity: Alarm) {
        val alarmType = entity.alarmType
        val isEnabled = entity.isEnabled
        val hour = entity.hour
        val minute = entity.minute
        val days = entity.days

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AndroidAlarmManager

        // интенты
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("id", entity.id)
            putExtra("label", entity.label)
            putExtra("type", entity.alarmType)
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            101,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            if (before(Calendar.getInstance())) add(Calendar.DAY_OF_YEAR, 1)
        }

        alarmManager.setExactAndAllowWhileIdle(
            AndroidAlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )

        Toast.makeText(context, "Будильник установлен на %02d:%02d".format(hour, minute), Toast.LENGTH_SHORT).show()
    }

    fun cancelAlarm() {
        /*
        ут будет метод по отмене будильника
         */
    }

    fun SyncAllAlarms() {
        /*
        Тут будет прогонять синхронзация
         */
    }
}