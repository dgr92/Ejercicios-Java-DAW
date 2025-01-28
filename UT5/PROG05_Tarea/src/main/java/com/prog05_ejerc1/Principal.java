package com.prog05_ejerc1;
import java.util.Scanner;
import com.prog05_ejerc1.Libro;

/**
 * @author David
 */
public class Principal {

  public static void main(String[] args) {
    boolean exit = false;
    Libro libro = new Libro();
    
    String nuevoTitulo;
    String nuevoAutor;
    long nuevoIsbn;
    int nuevoNumPags;
    String nuevoDescripcion;  
    int nuevoAnioPublicacion;
    int nuevoNumEdicion;

    Scanner sc = new Scanner(System.in);

    while (!exit) {        
      System.out.println("\n------------------------------------");
      System.out.println("Selecciona que hacer:\n");

      System.out.println("1. Nuevo Libro.");
      System.out.println("2. Ver Título.");
      System.out.println("3. Ver Autor.");
      System.out.println("4. Ver ISBN.");
      System.out.println("5. Mostrar número de edición.");
      System.out.println("6. Actualizar número de edición.");
      System.out.println("7. Mostrar Fecha de Publicación.");
      System.out.println("8. Mostrar Descripción.");
      System.out.println("9. Mostrar Antigüedad.");
      System.out.println("10. Salir.");
      System.out.println("------------------------------------\n\n");
      
      
      switch (sc.nextInt()) {
        case 1:
          System.out.println("1. Nuevo Libro.");
          System.out.println("Por favor inserta los siguientes datos: ");
          
          System.out.print("Título: ");
          nuevoTitulo = sc.nextLine();
          sc.next();
          
          System.out.print("Autor: ");
          nuevoAutor = sc.nextLine();
          sc.next();

          System.out.print("ISBN: ");
          nuevoIsbn = sc.nextLong();
          
          System.out.print("Número de Páginas: ");
          nuevoNumPags = sc.nextInt();
          
          System.out.print("Descripción: ");
          nuevoDescripcion = sc.next(); 
          
          System.out.print("Año de Publicación: ");
          nuevoAnioPublicacion = sc.nextInt();
          
          System.out.print("Número de Edición: ");
          nuevoNumEdicion = sc.nextInt();
          
          libro = new Libro(nuevoTitulo, nuevoAutor, nuevoIsbn, nuevoNumPags, nuevoDescripcion, nuevoAnioPublicacion, nuevoNumEdicion);
          
          break;
        
        case 2:
          System.out.println("2. Ver Título.");
          System.out.println(libro.getTitulo());
          
          break;
        
        case 3:
          System.out.println("3. Ver Autor.");
          System.out.println(libro.getAutor());

          break;
        
        case 4:
          System.out.println("4. Ver ISBN.");
          System.out.println(libro.getIsbn());
          break;
        
        case 5:
          System.out.println("5. Mostrar número de ediciones");
          System.out.println(libro.getNumEdicion());
          break;
        
        case 6:
          System.out.println("6. Actualizar número de ediciones.");
          libro.setNumEdicion(sc.nextInt());
          break;
        
        case 7:
          System.out.println("7. Mostrar Fecha de Publicación.");
          System.out.println(libro.getAnioPublicacion());
          break;
        
        case 8:
          System.out.println("8. Mostrar Descripción.");
          System.out.println("Libro: " + libro.getTitulo());
          System.out.println("Autor: " + libro.getAutor());
          System.out.println("ISBN: " + libro.getIsbn());
          System.out.println("Nº Páginas: " + libro.getNumPags());
          System.out.println("Descripción: \n" + libro.getDescripcion());          
          break;
        
        case 9:
          System.out.println("9. Mostrar Antigüedad.");
          System.out.println("El libro fue publicado hace " + libro.getAntiguedad(libro.getAnioPublicacion()) + " años.");
          break;
        
        case 10:
          exit = true;
          System.out.println("Finalizando programa.");
          break;
          
        default:
          throw new AssertionError();
      }
    }
  }
}
