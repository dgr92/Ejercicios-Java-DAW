package com.prog08_tarea1;

/**
 * Clase Persona
 * Implementa la interfaz Imprimible para devolver los datos de una persona
 * @author David Graciá Requena
 */
public class Persona implements Imprimible{
  // Atributos de la clase persona
  protected String nombre;
  protected String apellidos;
  protected String dni;

  /**
   * Constructor que recibe los datos necesarios e instancia un objeto de la clase Persona
   * @param nombre Nombre del titular
   * @param apellidos Apellidos del titular
   * @param dni DNI del titular
   */
  protected Persona(String nombre, String apellidos, String dni){
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dni = dni;
  };

  /**
   * Método implementado desde la Interfaz Imprimible que devuelve un String con los datos del objeto de tipo Persona
   * @return String con los datos del objeto de tipo Persona
   */
  public String devolverInfoString(){
    return "\n--------------------------------------" + 
           "\nNombre del titular: " + nombre +
           "\nApellidos del titular: " + apellidos +
           "\nDNI del titular: " + dni;
  };
}
