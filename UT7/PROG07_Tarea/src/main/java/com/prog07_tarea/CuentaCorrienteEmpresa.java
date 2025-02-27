package com.prog07_tarea;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
  protected float tipoInteresDescubierto;
  protected double maxDescubierto;
  protected double comisionDescubierto;

  protected CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, float tipoInteresDescubierto, double maxDescubierto, double comisionDescubierto){
    super(titular, saldo, iban);
    this.tipoInteresDescubierto = tipoInteresDescubierto;
    this.maxDescubierto = maxDescubierto;
    this.comisionDescubierto = comisionDescubierto;
  };

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
