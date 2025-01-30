package com.prog05_ejerc1;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.prog05_ejerc1_util.Validaciones;

/**
 * Programa Java que, utilizando las clases "Libro" y "Validaciones", permite gestionar un libro mediante un menú que aparece en pantalla
 * @author David Graciá Requena
 */
public class Principal {
  /**
   * Método principal que muestra el menú por pantalla. 
   * Dependiendo de la opción seleccionada podremos realizar cada una de las acciones.
   * @param args Argumentos de línea de comandos (no utilizados).
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Libro libro = new Libro(); // Instancia un objeto Libro vacío.
    boolean exit = false; // Variable de control para manejar la interrupción del bucle del menú, en el que estaremos hasta seleccionar la opción 10 .
    
    // Inicialización de las variables del objeto libro, algunas necesitan ser puestas a 0 (o 1) para el correcto funcionamiento.
    String titulo;
    String autor;
    long isbn = 0;
    int numPags = 0;
    String descripcion;  
    int anioPublicacion = 0;
    int numEdicion = 1;
    int nuevoNumEdicion;


    while (!exit) { // Bucle que nos hará elegir opciones indefinidamente hasta que seleccionemos la 10
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
      
      
      // Switch que controla las opciones del menú
      switch (sc.nextInt()) {
        case 1: // Creación de nuevo libro, se piden los datos necesarios para crear un objeto Libro.
          System.out.println("1. Nuevo Libro.\n");
          System.out.println("Por favor inserta los siguientes datos: ");
          sc.nextLine(); // Limpia el buffer de entrada para evitar errores en la lectura de datos 
          

          System.out.print("\nTítulo: "); 
          titulo = sc.nextLine(); 
          

          System.out.print("\nAutor: ");
          autor = sc.nextLine(); 

          
          do { // Bucle que se repite mientras que el ISBN introducido no sea válido
            System.out.print("\nISBN: ");
            try {
              isbn = sc.nextLong();
              sc.nextLine(); // Limpia el buffer

            } catch (InputMismatchException e) { // Controla que el ISBN sea un número
              System.out.println("---------------------------------------------------------------");
              System.out.println("ERROR!! El ISBN debe de estar formado por 13 valores numéricos.");
              System.out.println("---------------------------------------------------------------");
              sc.nextLine(); // Limpia el buffer
            }
          } while (!Validaciones.validarIsbn(isbn)); // Llama al método de Validaciones para comprobar que el ISBN es válido


          do { // Bucle que se repite mientras que el número de páginas introducido no sea válido
            System.out.print("\nNúmero de Páginas: ");
            try {
              numPags = sc.nextInt(); 
              sc.nextLine(); // Limpia el buffer 
              if(numPags <= 0){ // Controla que el número de páginas sea mayor que 0
                System.out.println("-------------------------------------------------");
                System.out.println("ERROR!! El Número de paginas debe ser mayor que 0.");
                System.out.println("-------------------------------------------------");
              }
            } catch (InputMismatchException e) { // Controla que el número de páginas sea un número
              System.out.println("-------------------------------------------------");
              System.out.println("ERROR!! El Número de paginas debe ser un número.");
              System.out.println("-------------------------------------------------");
              sc.nextLine(); // Limpia el buffer
            }
          } while (numPags <= 0); 


          System.out.print("\nDescripción: ");
          descripcion = sc.nextLine(); 
          

          do { // Bucle que se repite mientras que el año de publicación introducido no sea válido
            System.out.print("\nAño de Publicación: ");
            try {
              anioPublicacion = sc.nextInt();
              sc.nextLine(); // Limpia el buffer

            } catch (InputMismatchException e) { // Controla que el año de publicación sea un número
              System.out.println("-------------------------------------------------");
              System.out.println("ERROR!! El Año de publicación debe ser numérico."); 
              System.out.println("-------------------------------------------------");
              sc.nextLine(); // Limpia el buffer
            }
          } while (!Validaciones.validarAnioPublicacion(anioPublicacion)); // Llama al método de Validaciones para comprobar que el año de publicación es válido


          do { // Bucle que se repite mientras que el número de ediciones introducido no sea válido
            System.out.print("\nNúmero de Edición: ");
            numEdicion = sc.nextInt();
            sc.nextLine(); // Limpia el buffer
          } while (!Validaciones.validarNumEdiciones(numEdicion)); // Llama al método de Validaciones para comprobar que el número de ediciones es válido


          libro = new Libro(titulo, autor, isbn, numPags, descripcion, anioPublicacion, numEdicion); // Una vez que todos los datos son válidos, se crea el objeto Libro

          System.out.println("\n-------------------------");
          System.out.println("Libro creado con éxito.");
          System.out.println("-------------------------");
          break;
        

          case 2: // Muestra el título del libro
          // Se comprueba que el libro existe, si no existe, muestra un mensaje de error y vuelve al menú, ésto se repite en todas las opciones salvo la 1.
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("2. Ver Título.");
          System.out.println("--------------\n");
          System.out.println("El título es: " + libro.getTitulo());
          break;
        

        case 3: // Muestra el autor del libro
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("3. Ver Autor.");
          System.out.println("-------------\n");
          System.out.println("El autor es: " + libro.getAutor());
          break;
        

        case 4: // Muestra el ISBN del libro
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("4. Ver ISBN.");
          System.out.println("------------\n");
          System.out.println("El ISBN es: " + libro.getIsbn());
          break;
        

        case 5: // Muestra el número de ediciones del libro
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("5. Mostrar número de ediciones.");
          System.out.println("------------------------------\n");
          System.out.println("Edición número: " + libro.getNumEdicion());
          break;
        

        case 6: // Actualiza el número de ediciones del libro
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("6. Actualizar número de ediciones.");
          System.out.println("---------------------------------\n");
          do { // Bucle que, si el número introducido no es válido, se repite hasta que lo sea
            System.out.print("Introduce el nuevo Número de Edición: ");
            nuevoNumEdicion = sc.nextInt();
          } while (!Validaciones.actualizarNumEdicion(numEdicion, nuevoNumEdicion)); // Llama al método de Validaciones para comprobar que el nuevo número de edicion es válido

          libro.setNumEdicion(nuevoNumEdicion);
          System.out.println("\nEdición cambiada de la " + numEdicion + " a la " + libro.getNumEdicion());
          break;
        

        case 7: // Muestra el año de publicación del libro
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("7. Mostrar Fecha de Publicación.");
          System.out.println("--------------------------------\n");
          System.out.println("El libro fue publicado en el año: " + libro.getAnioPublicacion());
          break;
        

        case 8: // Muestra la descripción del libro
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("8. Mostrar Descripción.");
          System.out.println("-----------------------\n");
          System.out.println("Libro: " + libro.getTitulo());
          System.out.println("Autor: " + libro.getAutor());
          System.out.println("ISBN: " + libro.getIsbn());
          System.out.println("Nº Páginas: " + libro.getNumPags() + "pags.");
          System.out.println("Descripción: \n" + libro.getDescripcion());          
          break;
        

        case 9: // Muestra los años de antigüedad del libro
          if(!Validaciones.existeLibro(libro.getTitulo())){
            break;
          }
          System.out.println("9. Mostrar Antigüedad.");
          System.out.println("----------------------\n");
          System.out.println("El libro fue publicado hace " + libro.getAntiguedad(libro.getAnioPublicacion()) + " años."); // Llama al método de Libro para calcular la antigüedad
          break;
        
          
        case 10: // Sale del programa
          exit = true; // Cambia el valor de la variable de control para salir del bucle del menú
          sc.close(); // Cierra el Scanner
          System.out.println("\n---------------------");
          System.out.println("Finalizando programa.");
          System.out.println("---------------------\n");
          break;
      }
    }
  }
}
