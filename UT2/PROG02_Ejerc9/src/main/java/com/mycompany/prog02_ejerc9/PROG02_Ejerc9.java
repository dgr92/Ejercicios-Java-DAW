package com.mycompany.prog02_ejerc9;
import java.util.Scanner;

/**
 * @author David
 */
public class PROG02_Ejerc9 {
  
    // Función que devuelve true si un año es bisiesto y false si no lo es
    public static boolean isLeapYear(int year){
      
      // Será bisiesto si es divisible por 4 y no lo es por 100, a no ser que lo sea por 400
      if(year%4 == 0 && year%100 != 0 || year%400 == 0){
        return true;
      }
      
      return false;
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int year = sc.nextInt();
      boolean leapYear = isLeapYear(year);
      
      //En función de lo que devuleva la función, mediante un ternario imprime por consola si el año es o no bisiesto.
      System.out.println( leapYear ? year + " SÍ es bisiesto." : year + " NO es bisiesto.");
    }
}
