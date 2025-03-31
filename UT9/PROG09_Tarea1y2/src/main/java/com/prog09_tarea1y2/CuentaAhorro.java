package com.prog09_tarea1y2;

/**
 * Clase CuentaAhorro que hereda de CuentaBancaria y que tiene un atributo tipoInteresAnual.
 * Implementa la interfaz Imprimible mediante la herencia de CuentaBancaria.
 * @author David Graciá Requena
 */
public class CuentaAhorro extends CuentaBancaria {
  // Atributos de la cuenta de ahorro
  protected float tipoInteresAnual;

  // Constructor de la cuenta de ahorro
  protected CuentaAhorro(Persona titular, double saldo, String iban, float tipoInteresAnual){
    super(titular, saldo, iban); // Llamada al constructor de la clase padre CuentaBancaria
    this.tipoInteresAnual = tipoInteresAnual;
  };

  // Método heredado de la interfaz Imprimible a través de la clase CuentaBancaria
  @Override
  public String devolverInfoString(){
    return titular.devolverInfoString() + "\n" +
           "IBAN: " + iban + "\n" +
           "Saldo: " + saldo + "\n" +
           "Tipo de interés anual: " + tipoInteresAnual + "\n" +
           "--------------------------------------";
  }
}
