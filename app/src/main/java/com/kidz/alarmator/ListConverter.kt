package com.kidz.alarmator

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun fromDaysList(days: List<Int>): String{
        return days.joinToString(",")
    }

    @TypeConverter
    fun toDaysList(data: String): List<Int>{
        return if (data.isEmpty()) emptyList() else data.split(",").map { it.toInt() }
    }
}