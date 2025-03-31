package com.prog09_tarea1y2;
import java.io.Serializable;

/**
 * Clase abstracta CuentaBancaria que tiene como atributos un titular, un saldo y un IBAN.
 * Implementa la interfaz Imprimible.
 * Implementa la interfaz Serializable para poder serializar objetos de esta clase.
 * Las clases hijas de CuentaBancaria son CuentaAhorro y CuentaCorriente.
 * @author David Graciá
 */
public abstract class CuentaBancaria implements Imprimible, Serializable{
  // Atributos de la cuenta bancaria
  protected Persona titular; 
  protected double saldo; 
  protected String iban;
  
  // Constructor de la cuenta bancaria
  protected CuentaBancaria(Persona titular, double saldo, String iban){
    this.titular = titular;
    this.saldo = saldo;
    this.iban = iban;
  };

  //Método para obtener el nombre
  protected String getNombre(){
    return titular.nombre;
  }
  
  //Método para obtener el apellido
  protected String getApellidos(){
    return titular.apellidos;
  }
  
  // Método obtener el IBAN
  protected String getIban(){
    return iban;
  };

}
