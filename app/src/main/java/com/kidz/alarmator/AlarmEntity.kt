package com.kidz.alarmator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alarms")
data class Alarm(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val alarmType: String,
    val isEnabled: Boolean,
    val hour: Int,
    val minute: Int,
    val days: List<Int>,
    val label: String = ""
    
    ) {init {
        if (hour !in 0..23) {
            throw IllegalArgumentException("Hour must be between 0 and 23")
        }
        if (minute !in 0..59) {
            throw IllegalArgumentException("Minute must be between 0 and 59")
        }
        for (day in days) {
            if (day !in 1..7) {
                throw IllegalArgumentException("Days must be between 1 (Monday) and 7 (Sunday)")
            }
        }
    }}