package com.example.trabajo1modulo6.state

import com.example.trabajo1modulo6.models.Contacto

data class ContactoState(val contactos: List<Contacto> = emptyList(), val isLoading: Boolean = false)

