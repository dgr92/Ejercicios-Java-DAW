package com.prog04_ejerc02;
import java.util.Scanner;

/**
 * Esta clase implementa un programa que pide por teclado 5 números y para cada uno de ellos:
 *  Comprueba si es negativo, y si lo es, muestra un mensaje por pantalla.
 *  Si es positivo deberá mostrar por pantalla si el número es primo o no.
 *  Finaliza una vez procesados los 5 números
 * @author David Graciá Requena
 */
public class PROG04_Ejerc02 {

    /**
     * Método principal, que solicita al usuario 5 números y comprueba si estos son primos.
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      System.out.println("Escribe 5 números: \n");
      
      // Bucle que pide 5 números distintos.
      for (int i = 1; i < 6; i++) {
        System.out.print("Número "+ i + ": ");
        
        // Pasámos al método el número introducido por teclado.
        esPrimo(sc.nextInt());
      }
    }
    
    
    /**
     * Método que recibe cada uno de los números, comprueba si los números son menores que 2 (no pueden ser primos), y en caso de ser mayores, 
     * imprime por consola si son primos o no.
     * @param num El número que se va a comprobar.
     */
    public static void esPrimo(int num){
          
      // Los números menores o iguales a 1 no son primos.
      if(num <= 1){
        System.out.println("Es menor que 2.\n");
        return;
      }
      
      // Caso especial: el 2 es un número primo
      if(num == 2){
        System.out.println("Es primo.\n");
        return;
      }
      
      // Itera los números entre 2 y el número previo al número a comprobar y comprueba que no sea divisible por ninguno de ellos (no sería primo).
      for (int i = 2; i < num; i++){
        if(num % i == 0){
          System.out.println("No es primo\n");
          return;
        } 
      }

      System.out.println("Es primo.\n");
    }
}
