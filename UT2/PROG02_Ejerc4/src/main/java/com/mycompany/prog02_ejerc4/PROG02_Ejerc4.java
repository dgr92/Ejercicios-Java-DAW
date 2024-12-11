package com.mycompany.prog02_ejerc4;
import java.util.Scanner;

/**
 * @author David
 */
public class PROG02_Ejerc4 {
 
    // Función que devuelve true si la edad es mayor o igual a 18 y false si es menor de 18
    private static boolean EsMayorDeEdad(int edad){ 
      return edad >= 18;
     };
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int edad = sc.nextInt();
      
      // Variable que almacena el booleano devuelto pror la función al pasarle el parámetro edad (nº entero que introducimos por teclado)
      boolean mayorDeEdad = EsMayorDeEdad(edad);
      
      // Mediante un operador ternario se imprime que es mayor o menor de edad en función del true o false devuelto por la función.
      System.out.println((mayorDeEdad) ? "Es mayor de edad." : "Es menor de edad.");
    };
};
