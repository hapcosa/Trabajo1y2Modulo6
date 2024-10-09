package com.example.trabajo1modulo6.di

import android.content.Context
import androidx.room.Room
import com.example.trabajo1modulo6.room.DatabaseContactos
import com.example.trabajo1modulo6.room.contactoDao
import com.example.trabajo1modulo6.utils.dateFunc
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule{
    @Singleton
    @Provides
    fun providesDataBaseDao(database: DatabaseContactos): contactoDao {
        return database.contactoDao()

    }
    @Singleton
    @Provides
    fun providesContactoDatabase(@ApplicationContext context: Context): DatabaseContactos {
        return Room.databaseBuilder(
            context,
            DatabaseContactos::class.java,
            "contactos_db"
        ).allowMainThreadQueries().build()
    }
}