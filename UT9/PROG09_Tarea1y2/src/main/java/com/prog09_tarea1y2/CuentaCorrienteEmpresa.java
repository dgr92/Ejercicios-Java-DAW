package com.prog09_tarea1y2;

/**
 * Clase CuentaCorrienteEmpresa que hereda de CuentaCorriente y que tiene un atributo tipoInteresDescubierto, maxDescubierto y comisionDescubierto.
 * Implementa la interfaz Imprimible desde la herencia de CuentaBancaria.
 * @author David Graciá Requena
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {
  // Atributos de la cuenta corriente de empresa
  protected float tipoInteresDescubierto;
  protected double maxDescubierto;
  protected double comisionDescubierto;

  // Constructor de la cuenta corriente de empresa
  protected CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, float tipoInteresDescubierto, double maxDescubierto, double comisionDescubierto){
    super(titular, saldo, iban); // Llamada al constructor de la clase padre CuentaCorriente
    this.tipoInteresDescubierto = tipoInteresDescubierto;
    this.maxDescubierto = maxDescubierto;
    this.comisionDescubierto = comisionDescubierto;
  };

  // Método heredado de la interfaz Imprimible desde de la clase CuentaBancaria
  public String devolverInfoString(){
    return titular.devolverInfoString() + "\n" +
           "IBAN: " + iban + "\n" +
           "Saldo: " + saldo + "\n" +
           "Máximo descubierto permitido: " + maxDescubierto + "\n" + 
           "Tipo de interés por descubierto: " + tipoInteresDescubierto + "\n" + 
           "Comisión por descubierto: " + comisionDescubierto + "\n" + 
           "Lista de entidades: " + listaEntidades + "\n" +
           "--------------------------------------";
 }
}
