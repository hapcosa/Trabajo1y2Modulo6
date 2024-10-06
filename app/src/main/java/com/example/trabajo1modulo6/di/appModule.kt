package com.example.trabajo1modulo6.di

import android.content.Context
import androidx.room.Room
import com.example.trabajo1modulo6.room.Database
import com.example.trabajo1modulo6.room.contactoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object appModule{
    @Singleton
    @Provides
    fun providesDataBaseDao(database: Database): contactoDao {
        return database.contactoDao()

    }
    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            "contactos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}