package com.junaidsarwar.todo.data.repository

import androidx.lifecycle.LiveData
import com.junaidsarwar.todo.data.ToDoDao
import com.junaidsarwar.todo.data.models.ToDoData

class ToDoRepository(private val toDoDao: ToDoDao) {
    val getAllData: LiveData<List<ToDoData>> = toDoDao.getAllData()
    suspend fun insert(toDoData: ToDoData) {
        toDoDao.insertData(toDoData)
    }

    suspend fun update(toDoData: ToDoData) {
        toDoDao.updateData(toDoData)
    }
}