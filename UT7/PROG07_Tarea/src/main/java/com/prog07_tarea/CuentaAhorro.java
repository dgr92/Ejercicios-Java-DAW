package com.prog07_tarea;

public class CuentaAhorro extends CuentaBancaria {
  protected float tipoInteresAnual;

  protected CuentaAhorro(Persona titular, double saldo, String iban, float tipoInteresAnual){
    super(titular, saldo, iban);
    this.tipoInteresAnual = tipoInteresAnual;
  };

  public String devolverInfoString(){
    return "Cuenta de ahorro de: " + titular.nombre + " " + titular.apellidos + " con DNI: " + titular.dni + " con IBAN: " + iban + " y saldo: " + saldo + "€";
  }; 
}
