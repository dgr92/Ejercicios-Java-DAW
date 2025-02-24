package com.prog07_tarea;
import java.util.Scanner;

/**
 *
 * @author David Graciá Requena
 */
public class Principal {

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Banco banco = new Banco();
      boolean exit = false; // Variable de control para manejar la interrupción del bucle del menú, en el que estaremos hasta seleccionar la opción 6.

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
          break;
      
        case 2: // Muestra un listado de las cuentas disponibles
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
