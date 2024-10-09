package com.example.trabajo1modulo6.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.trabajo1modulo6.models.Contacto
import com.example.trabajo1modulo6.utils.Converters

@Database(entities = [Contacto::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class DatabaseContactos: RoomDatabase() {
    abstract fun contactoDao(): contactoDao
}