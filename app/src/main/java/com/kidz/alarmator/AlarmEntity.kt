package com.kidz.alarmator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Entity
import androidx.room.PrimaryKey

class AlarmEntity {
    @Entity(tableName = "alarms")
    data class Alarm(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val alarmType: String,
        val isEnabled: Boolean,
        val hour: Int,
        val minute: Int,
        val days: List<Int>
    )

    //TODO добавить отработку неправльно переданных значений

}