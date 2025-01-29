package com.prog05_ejerc1;
import java.util.Scanner;
import com.prog05_ejerc1.Libro;
import com.prog05_ejerc1_util.Validaciones;

/**
 * @author David
 */
public class Principal {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Libro libro = new Libro();
    boolean exit = false;
    
    String titulo;
    String autor;
    long isbn;
    int numPags;
    String descripcion;  
    int anioPublicacion;
    int numEdicion = 0;
    int nuevoNumEdicion;


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
          sc.nextLine(); // Limpia el buffer
          

          System.out.print("Título: ");
          titulo = sc.nextLine();
          

          System.out.print("Autor: ");
          autor = sc.nextLine();


          System.out.print("ISBN: ");
          isbn = sc.nextLong();
          if (!Validaciones.validarIsbn(isbn)) {
            break;
          }
          sc.nextLine(); // Limpia el buffer
          

          System.out.print("Número de Páginas: ");
          numPags = sc.nextInt();
          sc.nextLine(); // Limpia el buffer
          

          System.out.print("Descripción: ");
          descripcion = sc.nextLine(); 
          

          System.out.print("Año de Publicación: ");
          anioPublicacion = sc.nextInt();
          if(!Validaciones.validarAnioPublicacion(anioPublicacion)){
            break;
          }
          sc.nextLine(); // Limpia el buffer
          

          System.out.print("Número de Edición: ");
          numEdicion = sc.nextInt();
          if (!Validaciones.validarNumEdiciones(numEdicion)) {
            break;
          }
          sc.nextLine(); // Limpia el buffer

          
          libro = new Libro(titulo, autor, isbn, numPags, descripcion, anioPublicacion, numEdicion);
          
          System.out.println("\n-------------------------");
          System.out.println("Libro creado con éxito.");
          System.out.println("-------------------------\n");

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
          System.out.print("Introduce el nuevo Número de Edición:");
          nuevoNumEdicion = sc.nextInt();
          while(!Validaciones.validarNuevoNumEdicion(numEdicion, nuevoNumEdicion)){
            nuevoNumEdicion = sc.nextInt();
          }

          libro.setNumEdicion(nuevoNumEdicion);
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
          sc.close();
          System.out.println("Finalizando programa.");
          break;
      }
    }
  }
}
