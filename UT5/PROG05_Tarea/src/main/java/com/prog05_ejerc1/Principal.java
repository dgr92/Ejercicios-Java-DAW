package com.prog05_ejerc1;
import java.util.Scanner;
import com.prog05_ejerc1.Libro;

/**
 * @author David
 */
public class Principal {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      System.out.println("\n------------------------------------");
      System.out.println("Selecciona que hacer:\n");
      
      System.out.println("1. Nuevo Libro.");
      System.out.println("2. Ver Título.");
      System.out.println("3. Ver Autor.");
      System.out.println("4. Ver ISBN.");
      System.out.println("5. Mostrar número de ediciones");
      System.out.println("6. Actualizar número de ediciones.");
      System.out.println("7. Mostrar Fecha de Publicación.");
      System.out.println("8. Mostrar Descripción.");
      System.out.println("9. Mostrar Antigüedad.");
      System.out.println("10. Salir.");
      System.out.println("------------------------------------\n\n");
      
      switch (sc.nextInt()) {
        case 1:
          System.out.println(1);
          break;
        
        case 2:
          System.out.println(2);
          break;
        
        case 3:
          System.out.println(3);
          break;
        
        case 4:
          System.out.println(4);
          break;
        
        case 5:
          System.out.println(5);
          break;
        
        case 6:
          System.out.println(6);
          break;
        
        case 7:
          System.out.println(7);
          break;
        
        case 8:
          System.out.println(8);
          break;
        
        case 9:
          System.out.println(9);
          break;
        
        case 10:
          System.out.println(10);
          break;
          
        default:
          throw new AssertionError();
      }
    }
}
