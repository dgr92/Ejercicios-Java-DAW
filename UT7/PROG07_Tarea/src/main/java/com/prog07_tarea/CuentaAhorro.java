package com.prog07_tarea;

public class CuentaAhorro extends CuentaBancaria {
  protected float tipoInteresAnual;

  protected CuentaAhorro(Persona titular, double saldo, String iban, float tipoInteresAnual){
    super(titular, saldo, iban);
    this.tipoInteresAnual = tipoInteresAnual;
  };

  public String devolverInfoString(){
    return titular.devolverInfoString() + "\n" +
           "IBAN: " + iban + "\n" +
           "Saldo: " + saldo + "\n" +
           "Tipo de interés anual: " + tipoInteresAnual + "\n" +
           "--------------------------------------";
  }
}
