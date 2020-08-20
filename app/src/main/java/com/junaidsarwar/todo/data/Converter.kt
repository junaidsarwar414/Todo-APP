package com.junaidsarwar.todo.data

import androidx.room.TypeConverter
import com.junaidsarwar.todo.data.models.Priority

class Converter {
    @TypeConverter
    fun fromPriority(inst: Priority): String {
        return inst.name
    }

    @TypeConverter
    fun toPriority(inst: String): Priority {
        return Priority.valueOf(inst)
    }

}