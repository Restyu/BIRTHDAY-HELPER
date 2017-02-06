package com.example.javi.birthday;


public class Contacto {

    private int imagen, id;
    private String nombre, telefono, tipoNoficacion, fechaNacimiento, mensage;

    public Contacto() {
        super();
    }

    public Contacto(int imagen, int id, String nombre, String telefono, String tipoNotificacion, String fechaNacimiento, String mensage) {
        this.imagen = imagen;
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoNoficacion = tipoNotificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.mensage = mensage;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoNotificacion() {
        return tipoNoficacion;
    }

    public void setTipoNoficacion(String tipoNoficacion) {
        this.tipoNoficacion =tipoNoficacion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getMensage() {
        return  mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
}
