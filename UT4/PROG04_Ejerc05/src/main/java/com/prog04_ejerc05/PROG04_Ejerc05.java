package com.prog04_ejerc05;
import java.util.Scanner;

/**
 * Programa Java que calcula la división de dos números solicitados por teclado.
 * @author David
 */
public class PROG04_Ejerc05 {

  /**
   * Método principal que solicita dos números al usuario (dividendo y divisor) indefinidamente hasta que ambos sean -1.
   * Se controlará mediante excepciones que el divisor no sea 0, y, en caso de serlo, se mostrará un mensaje en pantalla.
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
      
        try{          
          int result = num1 / num2;
          totalDiv++; //Variable contador que lleva la cuenta de las divisiones realizadas
        
          result = num1/num2;
          
          System.out.println(num1 + "/" + num2 + "=" + result);
          System.out.println(totalDiv + " division(es) calculadas.\n\n");
        
        }catch(Exception exc){
          System.out.println("ERROR!! No puedes dividir entre cero.\n\n");
        }
    };
  } 
      
}
