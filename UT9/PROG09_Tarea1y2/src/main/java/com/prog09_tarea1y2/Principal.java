package com.prog09_tarea1y2;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Programa Java que permite gestionar varios tipos de cuentas bancarias.
 * @author David Graciá Requena
 */
public class Principal {

  /**
   * Método principal que muestra el menú por pantalla. 
   * Dependiendo de la opción seleccionada podremos realizar cada una de las acciones.
   * @param args Argumentos de línea de comandos (no utilizados).
   */
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Banco banco = new Banco(); // Instancia el objeto banco vacío.
    boolean exit = false; // Variable de control para manejar la interrupción del bucle del menú, en el que estaremos hasta seleccionar la opción 6.
      
    // Inicialización de las variables de cuenta bancaria, algunas necesitan ser puestas a 0 (o 1) para el correcto funcionamiento.
    int tipoCuenta = 0;
    double saldo = -1;

    // Variables para la validación de los datos introducidos por el usuario mediante patrones regex
    String dniTitular = "";
    String regexDni = "(\\d{8})([-]?)([A-Z]{1})"; // Patrón regex para el DNI
    Pattern patternDni = Pattern.compile(regexDni); 
    Matcher matcherDni;

    String iban = "";
    String regexIban = "^ES\\d{20}$"; // Patrón regex para el IBAN
    Pattern patternIban = Pattern.compile(regexIban);
    Matcher matcherIban = patternIban.matcher(iban);

    banco.cargarCuentas(); // Carga las cuentas del fichero.dat si existe

    while(!exit){ // Bucle que nos hará elegir opciones indefinidamente hasta que seleccionemos la opción 9
      System.out.println("\n------------------------------------");
      System.out.println("Selecciona que hacer:\n");

      System.out.println("1. Abrir una nueva cuenta.");
      System.out.println("2. Ver un listado de las cuentas disponibles.");
      System.out.println("3. Obtener los datos de una cuenta concreta.");
      System.out.println("4. Realizar un ingreso en una cuenta.");
      System.out.println("5. Retirar efectivo de una cuenta.");
      System.out.println("6. Consultar el saldo actual de una cuenta.");
      System.out.println("7. Eliminar cuenta.");
      System.out.println("8. Guardar relación de clientes y cuentas en archivo de texto.");
      System.out.println("9. Salir de la aplicación.");
      System.out.println("------------------------------------\n\n");

      
      // Switch que controla las opciones del menú
      switch (sc.nextInt()) {
        case 1: // Abre una nueva cuenta
          System.out.println("1. Abrir una nueva cuenta.\n");
          System.out.println("Por favor inserta los siguientes datos:");
          sc.nextLine(); // Limpia el buffer de entrada para evitar errores en la lectura de datos 


          System.out.print("\nNombre del titular: ");
          String nombre = sc.nextLine();


          System.out.print("\nApellidos del titular: ");
          String apellidos = sc.nextLine();


          do { // Bucle que se repite mientras que el DNI introducido no sea válido
            System.out.print("\nDNI del titular: "); 
            dniTitular = sc.nextLine(); 
            matcherDni = patternDni.matcher(dniTitular); // Comprueba que el DNI introducido sea válido
            
            if (!matcherDni.matches()) { // Controla que el DNI introducido sea válido
              System.out.println("----------------------------------------");
              System.out.println("ERROR!! El DNI introducido no es válido.");
              System.out.println("----------------------------------------");
            }
          } while (!matcherDni.matches());

          // Crea un nuevo objeto de la clase Persona con los datos introducidos
          Persona titular = new Persona(nombre, apellidos, dniTitular); // Crea un nuevo objeto de la clase Persona con los datos introducidos
          
          
          do{ // Bucle que se repite mientras que el tipo de cuenta introducido no sea válido
            try {
              System.out.println("\nTipo de cuenta que desea abrir:");
              System.out.println("  1. Cuenta de ahorro.");
              System.out.println("  2. Cuenta corriente personal.");
              System.out.println("  3. Cuenta corriente de empresa.");
              tipoCuenta = sc.nextInt();
              sc.nextLine(); // Limpia el buffer

              if (tipoCuenta < 1 || tipoCuenta > 3) { // Controla que el el tipo de cuenta sea uno de los 3 disponibles
                System.out.println("-------------------------------------");
                System.out.println("ERROR!! selecciona una opción válida.");
                System.out.println("-------------------------------------");
              }

            } catch (InputMismatchException e) { // Controla que el el tipo de cuenta sea un número
              System.out.println("------------------------------------");
              System.out.println("ERROR!! Introduce una opción válida.");
              System.out.println("------------------------------------");    
              sc.nextLine(); // Limpia el buffer
            }
          } while (tipoCuenta < 1 || tipoCuenta > 3);
          
          
          do { // Bucle que se repite mientras el saldo inicial no sea válido
            try {
              System.out.print("\nSaldo inicial: ");
              saldo = sc.nextDouble();
              sc.nextLine(); // Limpia el buffer
              
              if (saldo < 0) { // Controla que el saldo introducido sea mayor que cero
                System.out.println("-----------------------------------------------------");
                System.out.println("ERROR!! El saldo introducido no puede ser negativo.");
                System.out.println("-----------------------------------------------------");
              }
              
            } catch (InputMismatchException e) { // Controla que el el tipo de cuenta sea un número
              System.out.println("------------------------------------------");
              System.out.println("ERROR!! El saldo introducido no es válido.");
              System.out.println("------------------------------------------");
              sc.nextLine(); // Limpia el buffer
            }
          } while (saldo < 0); 
          
          
          do { // Bucle que se repite mientras que el IBAN introducido no sea válido
            System.out.print("\nIBAN: ");
            iban = sc.nextLine();
            matcherIban = patternIban.matcher(iban); // Comprueba que el IBAN introducido sea válido
            
            if (!matcherIban.matches()) { // Controla que el IBAN introducido sea válido
              System.out.println("--------------------------------------------------------");
              System.out.println("ERROR!! El IBAN introducido no tiene un formato válido. ");
              System.out.println("Debe ser un formato ESNNNNNNNNNNNNNNNNNNNN. (20 dígitos)");
              System.out.println("--------------------------------------------------------");
            }              
          } while (!matcherIban.matches());
          
          
          switch (tipoCuenta) { // Switch que gestiona la continuación del programa en base al tipo de cuenta seleccionado
            case 1: // Cuenta de ahorro
              System.out.print("\nTipo de interés: ");
              float tipoInteresAnual = sc.nextFloat();
              sc.nextLine(); // Limpia el buffer de entrada
              
              // Si todo esá correcto se crea la nueva cuenta de ahorro
              CuentaAhorro cuentaAhorro = new CuentaAhorro(titular, saldo, iban, tipoInteresAnual);

              // Se guarda la cuenta en el banco
              if (banco.abrirCuenta(cuentaAhorro)) {
                System.out.println("\nLa cuenta con IBAN " + cuentaAhorro.getIban() + " ha sido creada correctamente.");

              } else {
                System.out.println("-------------------------------------");
                System.out.println("ERROR!! No se pudo crear la cuenta.");
                System.out.println("-------------------------------------");
              }
              break;
                
            case 2: // Cuenta corriente personal
              System.out.print("\nComisión por mantenimiento: ");
              double comisionMantenimiento = sc.nextDouble();
              sc.nextLine(); // Limpia el buffer de entrada

              // Si todo esá correcto se crea la nueva cuenta corriente personal
              CuentaCorrientePersonal cuentaCorrientePersonal = new CuentaCorrientePersonal(titular, saldo, iban, comisionMantenimiento);
              
              // Se guarda la cuenta en el banco
              if (banco.abrirCuenta(cuentaCorrientePersonal)) {
                System.out.println("\nLa cuenta con IBAN " + cuentaCorrientePersonal.getIban() + " ha sido creada correctamente.");
                
              } else {
                System.out.println("-------------------------------------");
                System.out.println("ERROR!! No se pudo crear la cuenta.");
                System.out.println("-------------------------------------");
              }
              break;

            case 3: // Cuenta corriente de empresa
              System.out.print("\nMáximo descubierto permitido: ");
              double maxDescubierto = sc.nextDouble();
              sc.nextLine(); // Limpia el buffer de entrada

              System.out.print("\nTipo de interés por descubierto: ");
              float tipoInteresDescubierto = sc.nextFloat();
              sc.nextLine(); // Limpia el buffer de entrada

              System.out.print("\nComisión por descubierto: ");
              double comisionDescubierto = sc.nextDouble();
              sc.nextLine(); // Limpia el buffer de entrada+

              // Si todo esá correcto se crea la nueva cuenta corriente personal
              CuentaCorrienteEmpresa cuentaCorrienteEmpresa = new CuentaCorrienteEmpresa(titular, saldo, iban, tipoInteresDescubierto, maxDescubierto, comisionDescubierto);

              // Se guarda la cuenta en el banco
              if (banco.abrirCuenta(cuentaCorrienteEmpresa)) {
                System.out.println("\nLa cuenta con IBAN " + cuentaCorrienteEmpresa.getIban() + " ha sido creada correctamente.");
                
              } else {
                System.out.println("-------------------------------------");
                System.out.println("ERROR!! No se pudo crear la cuenta.");
                System.out.println("-------------------------------------");
              }
              break;              
          }
          break;


        case 2: // Muestra un listado de las cuentas disponibles
          // Bucle que itera el ArrayList de cuentas mostrando la información de cada una
          for (int i = 0; i < banco.listadoCuentas().size(); i++) {
            System.out.println(banco.listadoCuentas().get(i));
          }
          break;

          
        case 3: // Muestra los datos de una cuenta concreta
          do { // Bucle que se repite mientras que el IBAN introducido no sea válido
            System.out.print("Introduce el IBAN de la cuenta que deseas consultar: ");
            sc.nextLine(); // Limpia el buffer de entrada
            iban = sc.nextLine();
            matcherIban = patternIban.matcher(iban);

            if (!matcherIban.matches() ){ // Controla que el IBAN introducido sea válido
              System.out.println("--------------------------------------------------------");
              System.out.println("ERROR!! El IBAN introducido no tiene un formato válido. ");
              System.out.println("Debe ser un formato ESNNNNNNNNNNNNNNNNNNNN. (20 dígitos)");
              System.out.println("--------------------------------------------------------");
            }        
          } while (!matcherIban.matches());

          if (banco.informacionCuenta(iban) != null) { // Si existe el IBAN, mostrará la información de la cuenta
            System.out.println(banco.informacionCuenta(iban));

          } else {
            System.out.println("------------------------------------------");
            System.out.println("ERROR!! El IBAN introducido no existe.");
            System.out.println("------------------------------------------");
          }
          break;
        
        case 4: // Realiza un ingreso en una cuenta
          do{ // Bucle que se repite mientras el IBAN no sea válido
            System.out.print("Introduce el IBAN de la cuenta en la que deseas realizar el ingreso: ");
            sc.nextLine(); // Limpia el buffer de entrada
            iban = sc.nextLine();
            matcherIban = patternIban.matcher(iban);

            if (!matcherIban.matches()) { // Controla que el IBAN introducido sea válido
              System.out.println("--------------------------------------------------------");
              System.out.println("ERROR!! El IBAN introducido no tiene un formato válido. ");
              System.out.println("Debe ser un formato ESNNNNNNNNNNNNNNNNNNNN. (20 dígitos)");
              System.out.println("--------------------------------------------------------");
            }        
          } while (!matcherIban.matches());

          do { // Bucle que se repite mientras el saldo a ingresar no sea un valor válido
            System.out.print("\nSaldo a ingresar: ");
            saldo = sc.nextDouble();
            sc.nextLine(); // Limpia el buffer

            if (saldo < 0) { // Controla que el saldo introducido sea mayor que cero
              System.out.println("---------------------------------------------------");
              System.out.println("ERROR!! El saldo introducido no puede ser negativo.");
              System.out.println("---------------------------------------------------");
            }
          } while (saldo < 0D);

          // Si todo está bien y es posible, ingresa la cantidad indicada en el IBAN indicado.
          if (banco.ingresoCuenta(iban, saldo)) {
            System.out.println("Ingreso realizado correctamente.");
            
          } else {
            System.out.println("--------------------------------------------");
            System.out.println("ERROR!! No se ha podido realizar el ingreso.");
            System.out.println("--------------------------------------------");
          }
          break;
        
        case 5: // Retira efectivo de una cuenta
          do{ // Bucle que se repite mientras el IBAN no sea válido
            System.out.print("Introduce el IBAN de la cuenta en la que deseas realizar el retiro: ");
            sc.nextLine(); // Limpia el buffer de entrada
            iban = sc.nextLine();
            matcherIban = patternIban.matcher(iban);

            if (!matcherIban.matches()) { // Controla que el IBAN introducido sea válido
              System.out.println("--------------------------------------------------------");
              System.out.println("ERROR!! El IBAN introducido no tiene un formato válido. ");
              System.out.println("Debe ser un formato ESNNNNNNNNNNNNNNNNNNNN. (20 dígitos)");
              System.out.println("--------------------------------------------------------");
            }        
          }while(!matcherIban.matches());

          do { // Bucle que se repite mientras el saldo a ingresar no sea un valor válido
            System.out.print("\nSaldo a retirar: ");
            saldo = sc.nextDouble();
            sc.nextLine(); // Limpia el buffer

            if (saldo < 0) { // Controla que el saldo introducido sea mayor que cero
              System.out.println("---------------------------------------------------");
              System.out.println("ERROR!! El saldo introducido no puede ser negativo.");
              System.out.println("---------------------------------------------------");
            }
          } while (saldo < 0D);

          // Si todo está bien y es posible, ingresa la cantidad indicada en el IBAN indicado.
          if (banco.retiradaCuenta(iban, saldo)) {
            System.out.println("Retiro realizado correctamente.");

          } else {
            System.out.println("-------------------------------------------");
            System.out.println("ERROR!! No se ha podido realizar el retiro.");
            System.out.println("-------------------------------------------");
          }
          break;

        case 6: // Consulta el saldo actual de una cuenta
          do { // Bucle que se repite mientras el IBAN no sea válido
            System.out.print("Introduce el IBAN de la cuenta de la que deseas comprobar el saldo: ");
            sc.nextLine(); // Limpia el buffer de entrada
            iban = sc.nextLine();
            matcherIban = patternIban.matcher(iban);

            if (!matcherIban.matches()) { // Controla que el IBAN introducido sea válido
              System.out.println("--------------------------------------------------------");
              System.out.println("ERROR!! El IBAN introducido no tiene un formato válido. ");
              System.out.println("Debe ser un formato ESNNNNNNNNNNNNNNNNNNNN. (20 dígitos)");
              System.out.println("--------------------------------------------------------");
            }        
          } while (!matcherIban.matches());

          // Si el IBAN existe, muestra el saldo de la cuenta.
          if (banco.obtenerSaldo(iban) == -1) {
            System.out.println("--------------------------------------");
            System.out.println("ERROR!! El IBAN introducido no existe.");
            System.out.println("--------------------------------------");

          } else {
            System.out.println("\nEl saldo actual de la cuenta es de: " + banco.obtenerSaldo(iban) + " euros.");
          }
          break;

        case 7: // Elimina una cuenta
          do { // Bucle que se repite mientras el IBAN no sea válido
            System.out.println("Introduce el IBAN de la cuenta que deseas eliminar: ");
            sc.nextLine(); // Limpia el buffer de entrada
            iban = sc.nextLine();
            matcherIban = patternIban.matcher(iban);

            if (!matcherIban.matches()) { // Controla que el IBAN introducido sea válido
              System.out.println("--------------------------------------------------------");
              System.out.println("ERROR!! El IBAN introducido no tiene un formato válido. ");
              System.out.println("Debe ser un formato ESNNNNNNNNNNNNNNNNNNNN. (20 dígitos)");
              System.out.println("--------------------------------------------------------");
            }        
          } while (!matcherIban.matches());

          // Si el IBAN existe y el saldo es 0, elimina la cuenta
          if(banco.eliminarCuenta(iban)){
            System.out.println("Cuenta eliminada correctamente.");
          } else {
            System.out.println("-------------------------------------------");
            System.out.println("ERROR!! No se ha podido eliminar la cuenta.");
            System.out.println("-------------------------------------------");
          }
          break;
        
        case 8: // Guardar listado clientes
          banco.listarClientes(); // Crea un archivo .txt con el listado de clientes
          break;

        case 9: // Sale del programa
          System.out.println("-------------------");
          System.out.println(" Guardando datos...");
          System.out.println("-------------------");
          banco.serializarCuentas(); // Serializa las cuentas en un archivo.dat
          exit = true; // Cambia el valor de la variable de control para salir del bucle del menú
          sc.close(); // Cierra el Scanner
          System.out.println("-----------------------");
          System.out.println(" Programa finalizado.");
          System.out.println("-----------------------\n");
          break;
      };
    };
  };
};
