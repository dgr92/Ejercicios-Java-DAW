package com.mycompany.prog02_ejerc4;
import java.util.Scanner;

/**
 * @author David
 */
public class PROG02_Ejerc4 {
 
    private static boolean EsMayorDeEdad(int edad){ 
      return edad >= 18;
     };
    
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int edad = sc.nextInt();
      
      boolean mayorDeEdad = EsMayorDeEdad(edad);
      
      System.out.println((mayorDeEdad) ? "Es mayor de edad." : "Es menor de edad.");
    };
};
