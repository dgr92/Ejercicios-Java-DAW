package com.prog04_ejerc01;
import java.util.Scanner;

/** 
 * Esta clase implementa un programa que muestra la tabla de multiplicar de un número leido desde teclado utilizando tres bucles diferentes:
 * for, while y do-while. El número leído desde teclado debe ser menor que 30. 
 * En caso contrario se mostrará un mensaje por pantalla y el programa finalizará.
 * @author David Graciá
 */
public class PROG04_Ejerc01 {
  
    /**
     * Método principal que solicita al usuario un número y muestra su tabla de multiplicar mediante tres bucles diferentes.
     * Comprueba que esté entre 0 y 30 (ambos inclusive), y si no lo está muestra un mensaje de error.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      System.out.printf("Escribe número para mostrar su tabla de multiplicar: ");
      int number = sc.nextInt();
      
      if(number < 0 || number > 30){
        System.out.println("ERROR!! Introduce un número entre 0 y 30.");
        
      } else {
        mostrarTablaMultiplicarFor(number); 
        mostrarTablaMultiplicarWhile(number);
        mostrarTablaMultiplicarDoWhile(number);
      }    
    }
    
    /**
     * Muestra la tabla de multiplicar del número solicitado al usuario mediante el bucle 'for'.
     * @param number El número del cual se va a mostrar la tabla de multiplicar.
     */
    public static void mostrarTablaMultiplicarFor(int number){
      //Bucle for
      System.out.println("\nCon bucle For:\n");

      
      for (int i = 0; i <= 10; i++) {
        System.out.println(number + " x " + i + " = " + number*i);
      }
      System.out.println("\n-----------------------\n");
    }
    
    /**
     * Muestra la tabla de multiplicar del número solicitado al usuario mediante el bucle 'while'.
     * @param number El número del cual se va a mostrar la tabla de multiplicar.
     */
    public static void mostrarTablaMultiplicarWhile(int number){
      // Bucle while
      System.out.println("\nCon bucle While:\n");

      int i = 0;
      
      while(i <= 10){
        System.out.println(number + " x " + i + " = " + number*i);
        i++;
      }
      
      System.out.println("\n-----------------------\n");

    }
    
    /**
     * Muestra la tabla de multiplicar del número solicitado al usuario mediante el bucle 'do-while'.
     * @param number El número del cual se va a mostrar la tabla de multiplicar.
     */
    public static void mostrarTablaMultiplicarDoWhile(int number){
      // Bucle do-while
      System.out.println("\nCon bucle Do While:\n");
      int i = 0;
      
      do{
        System.out.println(number + " x " + i + " = " + number*i);
        i++;
      }while(i <= 10);
      
      System.out.println("\n-----------------------\n");

    }
}

    
    
