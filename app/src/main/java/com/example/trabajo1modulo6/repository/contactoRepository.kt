package com.example.trabajo1modulo6.repository
import com.example.trabajo1modulo6.models.Contacto
import com.example.trabajo1modulo6.room.contactoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class contactoRepository @Inject constructor(private val contactoDao: contactoDao) {

    suspend fun addContacto(contacto: Contacto) =contactoDao.insert(contacto)
    suspend fun editContacto(contacto:Contacto) =contactoDao.update(contacto)
    suspend fun deleteContacto(contacto:Contacto) =contactoDao.delete(contacto)
    fun getAllContactos(): Flow<List<Contacto>> = contactoDao.getAll().flowOn(Dispatchers.IO).conflate()
    fun getContactWithId(contactoId: Int): Flow<Contacto> = contactoDao.getContactWithId(contactoId).flowOn(Dispatchers.IO).conflate()
    fun getContactById(contactoId: Int): Contacto = contactoDao.getContactById(contactoId)
}