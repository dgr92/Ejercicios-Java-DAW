package com.prog07_tarea;
import java.util.ArrayList;

public class Banco {
  // Atributos de la clase banco
  private ArrayList<CuentaBancaria> cuentasBanco; // ArrayList de cuentas que contiene el banco.
  private static final int MAX_CUENTAS = 100; // Número máximo de cuentas que puede contener el banco.

  // Constructor por defecto de la clase banco que inicializa el ArrayList de cuentas.
  protected Banco(){
    this.cuentasBanco = new ArrayList<>();
  }


// protected boolean abrirCuenta(cuentaBancaria cuenta){};

// protected ArrayList<CuentaBancaria> listadoCuentas(){};

// protected String informacionCuenta(String iban){};

// protected boolean ingresoCuenta(String iban, double cantidad){};

// protected boolean retiradaCuenta(String iban, double cantidad){};

// protected double obtenerSaldo(String iban){};


}
