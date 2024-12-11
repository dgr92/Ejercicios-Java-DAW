package com.mycompany.prog02_ejerc5;
import java.util.Scanner;

/**
 * @author David
 */

public class PROG02_Ejerc5 {

    // Función que imprime por pantalla cuantos días, horas y minutos hay en un determinado nº de segundos
    static void secondsCounter(long seconds){   
      long days = seconds/86400;
      long daysRest = seconds%86400;
      
      int hours = (int)(daysRest/3600);
      int hoursRest = (int)(daysRest%3600);
      
      int minutes = hoursRest/60;
      
      System.out.println(seconds + " segundos son: " + days + " días, " + hours + " horas y " + minutes + " minutos." );
     }
  
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
   
      long seconds = sc.nextLong();
      
      secondsCounter(seconds);
    }
}
