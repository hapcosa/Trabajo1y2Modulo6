package com.example.trabajo1modulo6.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trabajo1modulo6.models.Contacto

@Database(entities = [Contacto::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {
    abstract fun contactoDao(): contactoDao
}