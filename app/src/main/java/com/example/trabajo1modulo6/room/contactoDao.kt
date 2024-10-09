package com.example.trabajo1modulo6.room

import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.trabajo1modulo6.models.Contacto

@Dao
interface contactoDao {
    @Query("SELECT * FROM contactos")
    fun getAll(): Flow<List<Contacto>>

    @Query("SELECT * FROM contactos WHERE contactoId = :contactoId")
     fun getContactWithId(contactoId: Int):Flow<Contacto>

    @Query("SELECT * FROM contactos WHERE contactoId = :contactoId")
     fun getContactById(contactoId: Int):Contacto
    @Delete
    suspend fun delete(contacto: Contacto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contacto: Contacto)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(contacto: Contacto)

}