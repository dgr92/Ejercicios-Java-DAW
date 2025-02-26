package com.prog07_tarea;

public abstract class CuentaBancaria implements Imprimible{
  // Atributos de la cuenta bancaria
  protected Persona titular; 
  protected double saldo; 
  protected String iban;
  
  // Constructor por defecto
  protected CuentaBancaria(Persona titular, double saldo, String iban){
    this.titular = titular;
    this.saldo = saldo;
    this.iban = iban;
  };

  protected String getIban(){
    return iban;
  };
}
