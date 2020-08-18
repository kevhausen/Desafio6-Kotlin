package com.example.roomdbejercico.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true) @NonNull val idTask:Int,
    val task:String,
    val creationDate:String,
    val finishDate:String) {
}