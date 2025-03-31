package com.prog09_tarea1y2;
import java.util.ArrayList;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Clase Banco que contiene los métodos para abrir cuenta, listar cuentas, buscar información de cuentas, 
 * ingresar y retirar dinero y consultar el saldo.
 * @author David Graciá Requena
 */
public class Banco {
  // Atributos de la clase banco
  /**
   * Utilicé ArrayList en lugar de Array, porque no tiene un tamaño fijo y se pueden añadir o eliminar elementos de forma dinámica. 
   * Además, ArrayList tiene métodos que facilitan la manipulación de los elementos, como add, remove, get, etc.
   */
  private ArrayList<CuentaBancaria> cuentasBanco; // ArrayList de cuentas que contiene el banco.

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
      if(cuentasBanco.get(i).getIban().equals(iban) && (cuentasBanco.get(i).saldo - cantidad) >= 0){ // Comprueba si el IBAN existe y hay más dinero en la cuenta del que se quiere retirar
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


  /**
   * Método que recibe un IBAN y, si existe y la cuenta está a cero, la elimina
   * @param iban IBAN de la cuenta
   * @return true si se ha eliminado, false si no se ha eliminado
   */
  protected boolean eliminarCuenta(String iban){
    for(int i = 0; i < cuentasBanco.size(); i++){
      if(cuentasBanco.get(i).getIban().equals(iban) && cuentasBanco.get(i).saldo == 0){
        cuentasBanco.remove(i);
        return true;
      }
    }
    return false;
  }



  /**
   * Método que guarda todas las cuentas bancarias en un archivo.dat
   * @exception FileNotFoundException si no se encuentra el archivo
   * @exception IOException si hay un error de entrada/salida 
   * @exception Exception si hay un error inesperado
   * @return void
   */
  protected void serializarCuentas(){
    File directorio = new File("ficheros");
    FileOutputStream fos = null; // Se inicializa el flujo de salida a null para evitar errores 
    ObjectOutputStream salida = null; // Se inicializa el objeto de salida a null para evitar errores
    try {
      if(!directorio.exists()){
        directorio.mkdirs(); // Se crea el directorio si no existe
      }

      fos = new FileOutputStream(".\\ficheros\\datoscuentasbancarias.dat"); // Se crea el flujo de salida para el archivo
      salida = new ObjectOutputStream(fos); // Se crea el objeto de salida para serializar los objetos 

      for(CuentaBancaria cuenta: cuentasBanco){
        salida.writeObject(cuenta); // Se escribe cada cuenta en el archivo
      }

    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el archivo.");

    } catch (IOException e) {
      System.out.println("Error de entrada/salida.");

    } catch (Exception e) {
      System.out.println(e.getMessage());

    } finally {
      try {
        if (fos != null) {
          fos.close(); // Se cierra el flujo de salida
        }

        if(salida != null){
          salida.close(); // Se cierra el objeto de salida
        }

      } catch (IOException e) {
        System.out.println("Error al cerrar el flujo de salida.");
      }
    }
  }

  

  /**
   * Método que carga las cuentas bancarias desde un archivo.dat
   * @exception FileNotFoundException si no se encuentra el archivo
   * @exception IOException si hay un error de entrada/salida
   * @exception Exception si hay un error inesperado
   * @return void
   */
  protected void cargarCuentas(){
    FileInputStream fis = null; // Se inicializa el flujo de entrada a null para evitar errores
    ObjectInputStream entrada = null; // Se inicializa el objeto de entrada a null para evitar errores
    CuentaBancaria cuenta;

    try {
      fis = new FileInputStream(".\\ficheros\\datoscuentasbancarias.dat"); // Se crea el flujo de entrada para el archivo
      entrada = new ObjectInputStream(fis); // Se crea el objeto de entrada para deserializar los objetos

      while(true){
        try {
          cuentasBanco.add((CuentaBancaria)entrada.readObject()); // Se lee y añade la cuenta al ArrayList de cuentas

        } catch (EOFException e) {
          break;
        }
      }
      cuenta = (CuentaBancaria)entrada.readObject(); // Se lee la cuenta del archivo
      System.out.println(cuenta.iban);


    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el archivo.");

    } catch (IOException e) {
      System.out.println("Error de entrada/salida.");

    } catch (Exception e) {
      e.getMessage();

    } finally {
      try {
        if (fis != null) {
          fis.close(); // Se cierra el flujo de entrada
        }

        if(entrada != null){
          entrada.close(); // Se cierra el objeto de entrada
        }

      } catch (IOException e) {
        System.out.println("Error al cerrar el flujo de salida.");
      }
    }

  }



  /**
   * Método que lista los clientes del banco y sus cuentas en un archivo .txt
   * @exception IOException si hay un error de entrada/salida
   * @exception Exception si hay un error inesperado
   * @return void
   */
  protected void listarClientes(){
    FileWriter fich = null; // Se inicializa el flujo de salida a null para evitar errores
    PrintWriter pw = null; // Se inicializa el objeto de salida a null para evitar errores
    int numCuentas = 0; // Se inicializa el número de cuentas a 0

    try {
      fich = new FileWriter(".\\ficheros\\listadoClientesCuentas.txt"); // Se crea el flujo de salida para el archivo
      pw = new PrintWriter(fich); // Se crea el objeto de salida para escribir en el archivo

      for(CuentaBancaria cuenta: cuentasBanco){ 
        pw.println("Cliente: " + cuenta.getApellidos() + " " + cuenta.getNombre() + " - IBAN: " + cuenta.getIban()); // Se escribe el nombre y apellidos del cliente junto con el IBAN de la cuenta
        numCuentas++; // Se incrementa el número de cuentas
      }
      pw.println("\nNº total de cuentas: " + numCuentas); // Se escribe el número total de cuentas en el archivo

    } catch (IOException e) {
      System.out.println("Error de entrada/salida.");
    
    }catch (Exception e){
      System.out.println(e.getMessage());
    
    } finally {
      try {
        if (fich != null) {
          fich.close(); // Se cierra el flujo de salida
        }

        if(pw != null){
          pw.close(); // Se cierra el objeto de salida
        }

      } catch (IOException e) {
        System.out.println("Error al cerrar el flujo de salida.");
      }
    }
  }

}