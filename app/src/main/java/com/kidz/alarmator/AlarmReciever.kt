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


    }
}