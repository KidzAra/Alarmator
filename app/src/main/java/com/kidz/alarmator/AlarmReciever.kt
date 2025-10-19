package com.kidz.alarmator

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val label = intent.getStringExtra("label") ?: "no label"
        val id = intent.getIntExtra("id", -1)
        val alarmType = intent.getStringExtra("alarmType") ?: "standart"
        //TODO: добавить функционал
        Toast.makeText(context, "Будильник #$id: $label, $alarmType", Toast.LENGTH_LONG).show()
        //* Тут будет вызываться активити будильника

        val alarmIntent = Intent(context, AlarmActivity::class.java).apply {
            putExtra("label", label)
            putExtra("id", id)
            putExtra("alarmType", alarmType)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }

        context.startActivity(alarmIntent)


    }
}