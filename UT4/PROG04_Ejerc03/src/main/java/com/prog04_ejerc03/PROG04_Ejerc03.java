package com.prog04_ejerc03;
import java.util.Scanner;

/**
 * Esta clase implementa un programa que pide dos números por teclado, comprueba que son positivos y calcula su MCM. 
 * En caso de no ser ambos números positivos, el programa mostrará un mensaje por pantalla y finalizará.
 * @author David
 */
public class PROG04_Ejerc03 {

  /**
   * Método principal que solicita al usuario dos números, comprueba que ambos sean positivos y calcula el mcm de ambos.
   * @param args Argumentos de línea de comandos (no utilizados).
   */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      System.out.print("Inserta primer número: ");
      int num1 = sc.nextInt();
      
      System.out.print("Inserta segundo número: ");
      int num2 = sc.nextInt();
      
      if(num1 < 1 || num2 < 1){
        System.out.println("ERROR!! Ambos números deben de ser mayores que cero.");
        return;
      }
      
      System.out.println("El mcm de " + num1 + " y " + num2 + " es " + minimoComunMultiplo(num1, num2) );
      
    }
    
    
    /**
     * Recibe dos números y prueba si el mayor de ellos es divisible entre los dos, si lo es, sera el mcm, sino, lo incremeneta en 1 y vuelve a 
     * comprobar si es divisible entre los dos números originales, hasta que lo sea. Ese será el mcm.
     * @param num1 Primer número para calcular el mcm
     * @param num2 Segundo número para calcular el mcm
     * @return mcm Variable en la que se almacenará el número mayor, y que en caso de no ser divisible entre los dos, irá incrementarlo hasta que lo sea. Cuando lo sea será el mcm.
     */
    public static int minimoComunMultiplo(int num1, int num2){
      int mcm;
      
      if(num1>num2){
        mcm = num1;
      
      }else{
        mcm = num2;
      }
      
      if( (mcm%num1 == 0) && (mcm%num2 == 0) ){
        return mcm;
        
      } else {
        do{
          mcm++;
          
        }while( (mcm%num1 != 0) || (mcm%num2 != 0) );
        
        return mcm;
      }
    }
}
