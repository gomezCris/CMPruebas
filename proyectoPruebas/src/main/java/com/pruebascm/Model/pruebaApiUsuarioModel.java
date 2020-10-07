
package com.pruebascm.Model;


public class pruebaApiUsuarioModel {
    //Definición de atributos según tabla en base de datos
    int id;
    String nombre;
    String apellido;
    int edad;
    String telefono;
    
    //Definición de constructores
    public pruebaApiUsuarioModel(int id, String nombre, String apellido, int edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    //Definición de constructor vacío para la reflexión de la clase
    /*
        Reflexión: Es decir que el programa tiene la capacidad de observar 
        y modificar su estructura de manera dinámica.
    */
    public pruebaApiUsuarioModel() {
    }
    
    
    //Definición de getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Definición de método toString
    @Override
    public String toString() {
        return "pruebaApiUsuarioModel{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", telefono=" + telefono + '}';
    }
    
}
