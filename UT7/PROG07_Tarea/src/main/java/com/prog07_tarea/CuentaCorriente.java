package com.prog07_tarea;


public abstract class CuentaCorriente extends CuentaBancaria {
  protected String listaEntidades = "Caixa Bank, BBVA, N26, Santander, Sabadell";

  protected CuentaCorriente(Persona titular, double saldo, String iban){
    super(titular, saldo, iban);
  };
}
