package com.prog08_tarea1;
import java.util.ArrayList;

/**
 * Clase Banco que contiene los métodos para abrir cuenta, listar cuentas, buscar información de cuentas, 
 * ingresar y retirar dinero y consultar el saldo.
 * @author David Graciá Requena
 */
public class Banco {
  // Atributos de la clase banco
  private ArrayList<CuentaBancaria> cuentasBanco; // ArrayList de cuentas que contiene el banco.
  private static final int MAX_CUENTAS = 100; // Número máximo de cuentas que puede contener el banco.

  // Constructor por defecto de la clase banco que inicializa el ArrayList de cuentas.
  protected Banco(){
    this.cuentasBanco = new ArrayList<>();
  }

  /**
   * Método que crea una nueva cuenta
   * @param cuenta objeto del tipo CuentaBancaria con todos los datos de la nueva cuenta
   * @return false si no se ha creado la nueva cuenta, true si se ha creado
   */
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
    return true; // Si se ha creado la cuenta, se devuelve true
  };


  /**
   * Método que muestra un listado con los datos de todas las cuentas
   * @return devuelve un ArrayList de String, donde cada String contendrá los datos de una cuenta
   */
  protected ArrayList<String> listadoCuentas(){
    ArrayList<String> listado = new ArrayList<>(); 

    cuentasBanco.forEach((cuenta) -> { // Método que ejecuta las siguientes instrucciones para cada cuenta:
      if(cuenta instanceof CuentaAhorro){ // Comprueba si la cuenta es una instancia de CuentaAhorro
        CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta; // Se hace casting de cuenta para convertirla en tipo CuentaAhorro y poder acceder a sus métodos ya que originalmente era del tipo CuentaBancaria
        listado.add(cuentaAhorro.devolverInfoString()); // Se añade al listado el String con los datos de la cuenta
      }

      if(cuenta instanceof CuentaCorrientePersonal){ // Comprueba si la cuenta es una instancia de CuentaCorrientePersonal
        CuentaCorrientePersonal cuentaCorrientePersonal = (CuentaCorrientePersonal) cuenta;  // Se hace casting de cuenta para convertirla en tipo CuentaCorrientePersonal y poder acceder a sus métodos ya que originalmente era del tipo CuentaBancaria
        listado.add(cuentaCorrientePersonal.devolverInfoString()); // Se añade al listado el String con los datos de la cuenta
      }
      

      if(cuenta instanceof CuentaCorrienteEmpresa){ // Comprueba si la cuenta es una instancia de CuentaCorrienteEmpresa
        CuentaCorrienteEmpresa cuentaCorrienteEmpresa = (CuentaCorrienteEmpresa) cuenta;  // Se hace casting de cuenta para convertirla en tipo CuentaCorrienteEmpresa y poder acceder a sus métodos ya que originalmente era del tipo CuentaBancaria
        listado.add(cuentaCorrienteEmpresa.devolverInfoString()); // Se añade al listado el String con los datos de la cuenta
      }
    });  
    
    return listado;
  };


  /**
   * Método que a partir de un IBAN, devuelve los datos de una cuenta
   * @param iban IBAN de la cuenta
   * @return String con los datos de la cuenta, o null si la cuenta no existe.
   */
  protected String informacionCuenta(String iban){    
    for(int i = 0; i <cuentasBanco.size(); i++){ // Bucle que itera la lista de cuentas hasta encontrar el IBAN coincidente 
      if(cuentasBanco.get(i).getIban().equals(iban)){ 
        if(cuentasBanco.get(i) instanceof CuentaAhorro){ // Comprueba si la cuenta es Instancia de CuentaAhorro
          CuentaAhorro cuentaAhorro = (CuentaAhorro) cuentasBanco.get(i); // Se hace casting a CuentaAhorro para poder usar sus métodos
          return cuentaAhorro.devolverInfoString(); // Devuelve el String con toda la información de la cuenta
        }

        if(cuentasBanco.get(i) instanceof CuentaCorrientePersonal){ // Comprueba si la cuenta es Instancia de CuentaCorrientePersonal
          CuentaCorrientePersonal cuentaCorrientePersonal = (CuentaCorrientePersonal) cuentasBanco.get(i); // Se hace casting a CuentaCorrientePersonal para poder usar sus métodos
          return cuentaCorrientePersonal.devolverInfoString(); // Devuelve el String con toda la información de la cuenta
        }
        

        if(cuentasBanco.get(i) instanceof CuentaCorrienteEmpresa){ // Comprueba si la cuenta es Instancia de CuentaCorrienteEmpresa
          CuentaCorrienteEmpresa cuentaCorrienteEmpresa = (CuentaCorrienteEmpresa) cuentasBanco.get(i); // Se hace casting a CuentaCorrienteEmpresa para poder usar sus métodos
          return cuentaCorrienteEmpresa.devolverInfoString(); // Devuelve el String con toda la información de la cuenta
        }
      };  
    }
    return null; // SI la cuenta no existe devuelve null
  }
  

  /**
   * Método que recibe un IBAN y una cantidad, y si existe la cuenta, ingresa dicha cantidad
   * @param iban IBAN de la cuenta
   * @param cantidad Cantidad a ingresar
   * @return Se devuelve true si se ingresa exitosamente y false si no lo hace.
   */
  protected boolean ingresoCuenta(String iban, double cantidad){
    for(int i = 0; i <cuentasBanco.size(); i++){ // Bucle que itera la lista de cuentas buscando un IBAN igual al introducido
      if(cuentasBanco.get(i).getIban().equals(iban)){
        cuentasBanco.get(i).saldo += cantidad; // Se suma la cantidad introducida
        return true; // Devuelve true si se ingresó correctamente
      }
    }
    return false; // Devuelve false si la operación no se completó
  };


  /**
   * Método que recibe un IBAN y una cantidad, y si existe la cuenta, retira dicha cantidad
   * @param iban IBAN de la cuenta
   * @param cantidad Cantidad a ingresar
   * @return Se devuelve true si se ingresa exitosamente y false si no lo hace.
   */
  protected boolean retiradaCuenta(String iban, double cantidad){
    for(int i = 0; i <cuentasBanco.size(); i++){ // Bucle que itera la lista de cuentas
      if(cuentasBanco.get(i).getIban().equals(iban) && (cuentasBanco.get(i).saldo - cantidad) > 0){ // Comprueba si el IBAN existe y hay más dinero en la cuenta del que se quiere retirar
        cuentasBanco.get(i).saldo -= cantidad; // Retira la cantidad solicitada
        return true; // Devuelve true si se realizó correctamente
      }
    }
    return false; // Devuelve false si no se completó
  };


  /**
   * Método que recibe un IBAN y si existe, devuelve el saldo que tiene la cuenta
   * @param iban IBAN de la cuenta
   * @return saldo de la cuenta si esta existe, -1 si no existe
   */
  protected double obtenerSaldo(String iban){
    for(int i = 0; i <cuentasBanco.size(); i++){
      if(cuentasBanco.get(i).getIban().equals(iban)){
        return cuentasBanco.get(i).saldo;
      }
    }
    return -1;
  };

}
