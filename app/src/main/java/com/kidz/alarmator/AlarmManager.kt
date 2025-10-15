package com.kidz.alarmator

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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kidz.alarmator.AlarmReceiver

import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

class AlarmManager (private val context: Context) {
    fun scheduleAlarm(entity: Alarm) {
        val alarmType = entity.alarmType
        val isEnabled = entity.isEnabled
        val hour = entity.hour
        val minute = entity.minute
        val days = entity.days

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AndroidAlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)
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