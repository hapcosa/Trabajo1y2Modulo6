package com.example.trabajo1modulo6.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "contactos")
public class Contacto {
    @PrimaryKey(autoGenerate = true)
    private int contactoId;
    private String nombre;
    private String telefono;
    private String correo;
    private String imagenRuta;
    private String fechaCreacion;

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getImagenRuta() {
        return imagenRuta;
    }

    public void setImagenRuta(String imagenRuta) {
        this.imagenRuta = imagenRuta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContactoId() {
        return contactoId;
    }
    public void setContactoId(int contactoId) {
        this.contactoId = contactoId;
    }

    public Contacto(String fechaCreacion, String imagenRuta, String correo, String telefono, String nombre) {
        this.fechaCreacion = fechaCreacion;
        this.imagenRuta = imagenRuta;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
    }
    public Contacto(){

    }
}
