package com.mycompany.prog02_ejerc7;
import java.util.Scanner;

/**
 * @author David
 */
public class PROG02_Ejerc7 {
  
  // Función que resuelve -> C1x + C2 = 0
  public static float solveEquation(float c1, float c2){  
    float x;
    x = -c2 / c1;
     
    return x;
   };
   
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    float c1 = sc.nextFloat();
    float c2 = sc.nextFloat();
    float result = solveEquation(c1, c2);

    System.out.println( "El resultado de \"" + c1 + "x + " + c2 + " = 0\" es: " + 
                        String.format("%.4f", result)
    );      
  }
}
