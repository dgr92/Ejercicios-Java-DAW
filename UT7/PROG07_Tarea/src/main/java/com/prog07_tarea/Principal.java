package com.prog07_tarea;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David Graciá Requena
 */
public class Principal {

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Banco banco = new Banco();
      boolean exit = false; // Variable de control para manejar la interrupción del bucle del menú, en el que estaremos hasta seleccionar la opción 6.
      
    // Inicialización de las variables de cuenta bancaria, algunas necesitan ser puestas a 0 (o 1) para el correcto funcionamiento.
      int tipoCuenta = 0;
      double saldo = 0.0;

      String dniTitular = "";
      String regexDni = "(\\d{8})([-]?)([A-Z]{1})"; // Patrón regex para el DNI de 8 dígitos y una letra mayúscula, podrá ir o no separado por un guión
      Pattern patternDni = Pattern.compile(regexDni); 
      Matcher matcherDni;

      String iban = "";
      String regexIban = "^ES\\d{20}$"; // Patrón regex para el IBAN
      Pattern patternIban = Pattern.compile(regexIban);
      Matcher matcherIban = patternIban.matcher(iban);

      while(!exit){
        System.out.println("\n------------------------------------");
        System.out.println("Selecciona que hacer:\n");

        System.out.println("1. Abrir una nueva cuenta.");
        System.out.println("2. Ver un listado de las cuentas disponibles.");
        System.out.println("3. Obtener los datos de una cuenta concreta.");
        System.out.println("4. Realizar un ingreso en una cuenta.");
        System.out.println("5. Retirar efectivo de una cuenta.");
        System.out.println("6. Consultar el saldo actual de una cuenta.");
        System.out.println("7. Salir de la aplicación.");
        System.out.println("------------------------------------\n\n");

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
            System.out.println("\nTipo de cuenta que desea abrir:");
            System.out.println("  1. Cuenta de ahorro.");
            System.out.println("  2. Cuenta corriente personal.");
            System.out.println("  3. Cuenta corriente de empresa.");

            tipoCuenta = sc.nextInt();
          }while(tipoCuenta < 1 || tipoCuenta > 3);


          do {
            System.out.print("\nSaldo inicial: ");
            try {
              saldo = sc.nextDouble();
              sc.nextLine(); // Limpia el buffer
  
            } catch (InputMismatchException e) {
              System.out.println("-----------------------------------------------------");
              System.out.println("ERROR!! El saldo introducido no es un número válido.");
              System.out.println("-----------------------------------------------------");
            }
          } while (saldo < 0);


          System.out.print("\nIBAN: ");
          do { // Bucle que se repite mientras que el IBAN introducido no sea válido
              iban = sc.nextLine();
              matcherIban = patternIban.matcher(iban); // Comprueba que el IBAN introducido sea válido

              if(!matcherIban.matches()){ // Controla que el IBAN introducido sea válido
                System.out.println("--------------------------------------------------------");
                System.out.println("ERROR!! El IBAN introducido no tiene un formato válido. ");
                System.out.println("Debe ser un formato ESNNNNNNNNNNNNNNNNNNNN. (20 dígitos)");
                System.out.println("--------------------------------------------------------");
              }              
          } while (!matcherIban.matches());


          switch(tipoCuenta){
              case 1: // Cuenta de ahorro
                System.out.print("\nTipo de interés: ");
                float tipoInteresAnual = sc.nextFloat();
                sc.nextLine(); // Limpia el buffer de entrada

                CuentaAhorro cuentaAhorro = new CuentaAhorro(titular, saldo, iban, tipoInteresAnual);
                banco.abrirCuenta(cuentaAhorro);
                break;

              case 2: // Cuenta corriente personal
                System.out.print("\nComisión por mantenimiento: ");
                double comisionMantenimiento = sc.nextDouble();
                sc.nextLine(); // Limpia el buffer de entrada

                CuentaCorrientePersonal cuentaCorrientePersonal = new CuentaCorrientePersonal(titular, saldo, iban, comisionMantenimiento);
                banco.abrirCuenta(cuentaCorrientePersonal);
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

                CuentaCorrienteEmpresa cuentaCorrienteEmpresa = new CuentaCorrienteEmpresa(titular, saldo, iban, tipoInteresDescubierto, maxDescubierto, comisionDescubierto);
                banco.abrirCuenta(cuentaCorrienteEmpresa);
                break;

              default:
                System.out.println("-----------------------------------------------------");
                System.out.println("ERROR!! Debes seleccionar una tipo de cuenta válida.");
                System.out.println("-----------------------------------------------------");
            }
          break;
      
        case 2: // Muestra un listado de las cuentas disponibles
          banco.listadoCuentas(); //todo: IMPLEMENTEAR IMPRESION
          break;
        
        case 3: // Muestra los datos de una cuenta concreta
          break;
        
        case 4: // Realiza un ingreso en una cuenta
          break;
        
        case 5: // Retira efectivo de una cuenta
          break;

        case 6: // Consulta el saldo actual de una cuenta
          break;

        case 7: // Sale del programa
          exit = true; // Cambia el valor de la variable de control para salir del bucle del menú
          sc.close(); // Cierra el Scanner
          System.out.println("-----------------------");
          System.out.println(" Finalizando programa.");
          System.out.println("-----------------------\n");
          break;
      };

    };
  };
};
