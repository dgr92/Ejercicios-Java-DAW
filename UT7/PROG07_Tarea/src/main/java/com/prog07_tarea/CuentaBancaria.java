package com.prog07_tarea;

/**
 * Clase abstracta CuentaBancaria que tiene como atributos un titular, un saldo y un IBAN.
 * Implementa la interfaz Imprimible.
 * Las clases hijas de CuentaBancaria son CuentaAhorro y CuentaCorriente.
 * @author David Graciá
 */
public abstract class CuentaBancaria implements Imprimible{
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

  // Método obtener el IBAN
  protected String getIban(){
    return iban;
  };
}
