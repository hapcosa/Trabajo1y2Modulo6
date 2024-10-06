package com.example.trabajo1modulo6.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trabajo1modulo6.models.Contacto
import com.example.trabajo1modulo6.repository.contactoRepository
import com.example.trabajo1modulo6.state.ContactoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class contactoViewModel @Inject constructor(private val contactoRepository: contactoRepository): ViewModel() {
    private val _contactos = MutableStateFlow(ContactoState())
    val contactos = _contactos.asStateFlow()
    init {
        viewModelScope.launch(Dispatchers.IO) {
            contactoRepository.getAllContactos().collect {
                if (it.isNullOrEmpty()) {
                    _contactos.value = _contactos.value.copy(isLoading = true, contactos = emptyList())
                }else
                _contactos.value = _contactos.value.copy(contactos = it)
            }
        }
    }
    fun addContacto(contacto: Contacto) = viewModelScope.launch { contactoRepository.addContacto(contacto) }
    fun EditContacto(contacto: Contacto) = viewModelScope.launch { contactoRepository.editContacto(contacto) }
    fun deleteContacto(contacto: Contacto) = viewModelScope.launch { contactoRepository.deleteContacto(contacto) }
    fun getContactWithId(contactoId: Int) = viewModelScope.launch { contactoRepository.getContactWithId(contactoId) }
}