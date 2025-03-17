package com.prog08_tarea1;

/**
 * Clase abstracta CuentaCorriente que hereda de CuentaBancaria y que tiene un atributo listaEntidades.
 * Las clases hijas de CuentaCorriente son CuentaCorrientePersonal y CuentaCorrienteEmpresa.
 * Implementa la interfaz Imprimible mediante la herencia de CuentaBancaria.
 */
public abstract class CuentaCorriente extends CuentaBancaria {
  // Atributo de la cuenta corrienteq
  protected String listaEntidades = "Caixa Bank, BBVA, N26, Santander, Sabadell";

  // Constructor de la cuenta corriente
  protected CuentaCorriente(Persona titular, double saldo, String iban){
    super(titular, saldo, iban); // Llamada al constructor de la clase padre CuentaBancaria
  };
}
