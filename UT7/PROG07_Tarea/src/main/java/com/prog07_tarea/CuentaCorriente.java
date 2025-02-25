package com.prog07_tarea;
import java.util.ArrayList;

public abstract class CuentaCorriente extends CuentaBancaria {
  protected ArrayList<String> listaEntidades;

  protected CuentaCorriente(Persona titular, double saldo, String iban){
    super(titular, saldo, iban);
  };
}
