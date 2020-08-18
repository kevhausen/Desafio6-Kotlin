package com.example.roomdbejercico.database

import androidx.room.*
import com.example.roomdbejercico.entities.Task

@Dao
interface TaskDao {
    //aca van todos los metodos para crud la base de datos (create,remove,update,delete)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(task: Task)

    @Insert
    fun insertMultipleTask(list:List<Task>)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteOneTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY idTask ASC")
    fun getAllTask():List<Task>


}