package com.prog04_ejerc05b;
import java.util.Scanner;

/**
 * Programa Java que calcula la división de dos números solicitados por teclado.
 * Se controla el error de la división entre 0 mediante aserciones.
 * @author David
 */
public class PROG04_Ejerc05b {

  /**
   * Método principal que solicita dos números al usuario (dividendo y divisor) indefinidamente hasta que ambos sean -1.
   * Se controlará mediante aserciones que el divisor no sea 0, y, en caso de serlo, se mostrará un mensaje en pantalla.
   * También muestra por pantalla el número de divisiones calculadas.
   * @param args Argumentos de línea de comandos (no utilizados).
   */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num1 = 0;
      int num2 = 0;
      int totalDiv = 0;
      
      while(!(num1 == -1 && num2 == -1)){ //Bucle que, mientras que los dos numeros no sean -1, se repite indefinidamente
        System.out.println("Inserta un número a dividir: ");
        num1 = sc.nextInt();
      
        System.out.println("Inserta el número por el que se dividirá: ");
        num2 = sc.nextInt();
        
        assert num2 != 0: "ERROR!! No se puede dividir entre 0. Inserta un divisor mayor.";
      
        int result = num1 / num2;
        totalDiv++; //Variable contador que lleva la cuenta de las divisiones realizadas
                  
        System.out.println(num1 + "/" + num2 + "=" + result);
        System.out.println(totalDiv + " division(es) calculadas.\n\n");
        
      };
    } 
}
