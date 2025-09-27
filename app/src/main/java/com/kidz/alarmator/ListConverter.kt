package com.kidz.alarmator

import androidx.room.TypeConverter

class ListConverter {

    //Конвертирует список целых чисел в строку, разделенную запятыми

    @TypeConverter
    fun fromDaysList(days: List<Int>): String{
        return days.joinToString(",")
    }


    //Конвертирует строку обратно в список целых чисел

    @TypeConverter
    fun toDaysList(data: String): List<Int>{
        return if (data.isEmpty()) emptyList() else data.split(",").map { it.toInt() }
    }
}