package com.prog07_tarea;

import java.util.ArrayList;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
  protected float tipoInteresDescubierto;
  protected double maxInteresDescubierto;
  protected double comisionDescubierto;

  protected CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, ArrayList<String> listaEntidades, float tipoInteresDescubierto, double maxInteresDescubierto, double comisionDescubierto){
    super(titular, saldo, iban, listaEntidades);
    this.tipoInteresDescubierto = tipoInteresDescubierto;
    this.maxInteresDescubierto = maxInteresDescubierto;
    this.comisionDescubierto = comisionDescubierto;
  };

  public String devolverInfoString(){
    return "Titular: " + titular.nombre + " " + titular.apellidos + "\n" +
            "Saldo: " + saldo + "\n" +
            "IBAN: " + iban + "\n" +
            "Máximo interés por descubierto: " + maxInteresDescubierto + "\n" + 
            "Tipo de interés por descubierto: " + tipoInteresDescubierto + "\n" + 
            "Comisión por descubierto: " + comisionDescubierto + "\n" + 
            "Lista de entidades: " + listaEntidades + "\n";
 }
}
