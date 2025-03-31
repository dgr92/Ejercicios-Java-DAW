package com.prog09_tarea1y2;

/**
 * Clase CuentaCorrientePersonal que hereda de CuentaCorriente y que tiene un atributo comisionMantenimiento.
 * Implementa la interfaz Imprimible desde la herencia de CuentaBancaria.
 * @author David Graciá Requena
 */
public class CuentaCorrientePersonal extends CuentaCorriente {
  // Atributo de la cuenta corriente personal
  protected double comisionMantenimiento;

  // Constructor de la cuenta corriente personal
  protected CuentaCorrientePersonal(Persona titular, double saldo, String iban, double comisionMantenimiento){
    super(titular, saldo, iban);
    this.comisionMantenimiento = comisionMantenimiento;
  };

  // Método heredado de la interfaz Imprimible desde de la clase CuentaBancaria
  public String devolverInfoString(){
    return titular.devolverInfoString() + "\n" +
           "IBAN: " + iban + "\n" +
           "Saldo: " + saldo + "\n" +
           "Comisión de mantenimiento: " + comisionMantenimiento + "\n" + 
           "Lista de entidades: " + listaEntidades + "\n" +
           "--------------------------------------";
  };
}
