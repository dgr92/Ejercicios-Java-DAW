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



  protected boolean abrirCuenta(CuentaBancaria cuenta){
    if(cuentasBanco.size() == MAX_CUENTAS){ // Si el banco está lleno, se devuelve false.
      return false;
    }

    for(int i = 0; i < cuentasBanco.size(); i++){
      if(cuentasBanco.get(i).iban == cuenta.iban){ // Si la cuenta ya existe, se devuelve false.
        return false;
      }
    }

    // Si todo es correcto, se añade la cuenta al ArrayList de cuentas y se devuelve true.
    cuentasBanco.add(cuenta);
    return true;
  };



  protected ArrayList<String> listadoCuentas(){
    ArrayList<String> listado = new ArrayList<>();

    cuentasBanco.forEach((cuenta) -> {
      if(cuenta instanceof CuentaAhorro){
        CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta;
        listado.add("\n--------------------------------------" + 
                    "\nIBAN: " + cuentaAhorro.iban +
                    "\nNombre del titular: " + cuentaAhorro.titular.nombre +
                    "\nApellidos del titular: " + cuentaAhorro.titular.apellidos +
                    "\nDNI del titular: " + cuentaAhorro.titular.dni +
                    "\nSaldo: " + cuentaAhorro.saldo +
                    "\n--------------------------------------");
      }

      if(cuenta instanceof CuentaCorrientePersonal){
        CuentaCorrientePersonal cuentaCorrientePersonal = (CuentaCorrientePersonal) cuenta;
        listado.add("\n--------------------------------------" + 
                    "\nIBAN: " + cuentaCorrientePersonal.iban +
                    "\nNombre del titular: " + cuentaCorrientePersonal.titular.nombre +
                    "\nApellidos del titular: " + cuentaCorrientePersonal.titular.apellidos +
                    "\nDNI del titular: " + cuentaCorrientePersonal.titular.dni +
                    "\nSaldo: " + cuentaCorrientePersonal.saldo +
                    "\n--------------------------------------");
      }
      

      if(cuenta instanceof CuentaCorrienteEmpresa){
        CuentaCorrienteEmpresa cuentaCorrienteEmpresa = (CuentaCorrienteEmpresa) cuenta;
        listado.add("\n--------------------------------------" + 
                    "\nIBAN: " + cuentaCorrienteEmpresa.iban +
                    "\nNombre del titular: " + cuentaCorrienteEmpresa.titular.nombre +
                    "\nApellidos del titular: " + cuentaCorrienteEmpresa.titular.apellidos +
                    "\nDNI del titular: " + cuentaCorrienteEmpresa.titular.dni +
                    "\nSaldo: " + cuentaCorrienteEmpresa.saldo +
                    "\n--------------------------------------");
      }
    });  
    
    return listado;
  };


  
  protected String informacionCuenta(String iban){    
    for(int i = 0; i <cuentasBanco.size(); i++){
      if(cuentasBanco.get(i).getIban().equals(iban)){
        if(cuentasBanco.get(i) instanceof CuentaAhorro){
          CuentaAhorro cuentaAhorro = (CuentaAhorro) cuentasBanco.get(i);
          return "\n--------------------------------------" + 
                 "\nNombre del titular: " + cuentaAhorro.titular.nombre +
                 "\nApellidos del titular: " + cuentaAhorro.titular.apellidos +
                 "\nDNI del titular: " + cuentaAhorro.titular.dni +
                 "\nTipo de cuenta: Cuenta de ahorro" +
                 "\nIBAN: " + cuentaAhorro.iban +
                 "\nSaldo: " + cuentaAhorro.saldo +
                 "\nTipo de interés: " + cuentaAhorro.tipoInteresAnual + 
                 "\n--------------------------------------";
        }

        if(cuentasBanco.get(i) instanceof CuentaCorrientePersonal){
          CuentaCorrientePersonal cuentaCorrientePersonal = (CuentaCorrientePersonal) cuentasBanco.get(i);
          return "\n--------------------------------------" + 
                 "\nNombre del titular: " + cuentaCorrientePersonal.titular.nombre +
                 "\nApellidos del titular: " + cuentaCorrientePersonal.titular.apellidos +
                 "\nDNI del titular: " + cuentaCorrientePersonal.titular.dni +
                 "\nTipo de cuenta: Cuenta corriente personal" +
                 "\nIBAN: " + cuentaCorrientePersonal.iban +
                 "\nSaldo: " + cuentaCorrientePersonal.saldo +
                 "\nComisión de mantenimiento: " + cuentaCorrientePersonal.comisionMantenimiento + 
                 "\n--------------------------------------";
        }
        

        if(cuentasBanco.get(i) instanceof CuentaCorrienteEmpresa){
          CuentaCorrienteEmpresa cuentaCorrienteEmpresa = (CuentaCorrienteEmpresa) cuentasBanco.get(i);
          return "\n--------------------------------------" + 
                 "\nNombre del titular: " + cuentaCorrienteEmpresa.titular.nombre +
                 "\nApellidos del titular: " + cuentaCorrienteEmpresa.titular.apellidos +
                 "\nDNI del titular: " + cuentaCorrienteEmpresa.titular.dni +
                 "\nTipo de cuenta: Cuenta corriente de empresa" +
                 "\nIBAN: " + cuentaCorrienteEmpresa.iban +
                 "\nSaldo: " + cuentaCorrienteEmpresa.saldo +
                 "\nMáximo descubierto permitido: " + cuentaCorrienteEmpresa.maxDescubierto + 
                 "\nTipo de interés por descubierto: " + cuentaCorrienteEmpresa.tipoInteresDescubierto +
                 "\nComisión por descubierto: " + cuentaCorrienteEmpresa.comisionDescubierto +
                 "\n--------------------------------------";
        }
      };  
    }
    return null;
  }
  

  protected boolean ingresoCuenta(String iban, double cantidad){
    for(int i = 0; i <cuentasBanco.size(); i++){
      if(cuentasBanco.get(i).getIban().equals(iban)){
        cuentasBanco.get(i).saldo += cantidad;
        return true;
      }
    }
    return false;
  };

  protected boolean retiradaCuenta(String iban, double cantidad){
    for(int i = 0; i <cuentasBanco.size(); i++){
      if(cuentasBanco.get(i).getIban().equals(iban) && (cuentasBanco.get(i).saldo - cantidad) > 0){
        cuentasBanco.get(i).saldo -= cantidad;
        return true;
      }
    }
    return false;
  };


  protected double obtenerSaldo(String iban){
    for(int i = 0; i <cuentasBanco.size(); i++){
      if(cuentasBanco.get(i).getIban().equals(iban)){
        return cuentasBanco.get(i).saldo;
      }
    }
    return -1;
  };

}
