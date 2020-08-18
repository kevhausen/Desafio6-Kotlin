package com.example.roomdbejercico.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdbejercico.entities.Task

@Database(entities= arrayOf(Task::class),version=1,exportSchema = false)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object{
        @Volatile
        private var INSTANCE: TaskDataBase?=null
        fun getDataBase(context:Context): TaskDataBase { //este metodo devuelve la database si es que ya esta creada, o la crea si no esta creada.
            val tempinstance= INSTANCE
            if(tempinstance!=null){
                return tempinstance
            }
            synchronized(this){ //aca es donde se crea si es que no existe
                val instance = Room.databaseBuilder(context.applicationContext,
                    TaskDataBase::class.java,"task_database").build() //aca se crea con nombre "task_database"
                INSTANCE =instance
                return instance //se devuelve la database recien horneada
            }
        }
    }

}