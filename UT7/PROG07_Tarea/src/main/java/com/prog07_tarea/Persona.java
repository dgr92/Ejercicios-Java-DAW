package com.prog07_tarea;

public class Persona implements Imprimible{
    protected String nombre;
    protected String apellidos;
    protected String dni;

    protected Persona(String nombre, String apellidos, String dni){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
    };

    public String devolverInfoString(){
        return "Cliente: " + this.nombre + " " + this.apellidos + " con DNI: " + this.dni;
    };
}
