package com.prog06_tarea;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.*;

/** 
 * Programa Java que, utilizando las clases Principal, Biblioteca y Libro, simula una biblioteca mediante un menú que aparece por pantalla.
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
    Biblioteca biblioteca = new Biblioteca(); // Instancia el objeto biblioteca vacío.
    boolean exit = false; // Variable de control para manejar la interrupción del bucle del menú, en el que estaremos hasta seleccionar la opción 6.
    
    // Inicialización de las variables del objeto libro, algunas necesitan ser puestas a 0 (o 1) para el correcto funcionamiento.
    long isbn = 0;
    int numPags = 0;
    int anioPublicacion = 0;
    int numEdicion = 1;

    // Variables para la validación de los datos introducidos por el usuario mediante patrones regex
    String isbnString = "";
    String regexIsbn = "(\\d{13})"; // Patrón regex para el ISBN de 13 dígitos
    Pattern patternIsbn = Pattern.compile(regexIsbn);
    Matcher matcherIsbn = patternIsbn.matcher(isbnString);

    String dniBibliotecario = "";
    String regexDni = "(\\d{8})([-]?)([A-Z]{1})"; // Patrón regex para el DNI de 8 dígitos y una letra mayúscula, podrá ir o no separado por un guión
    Pattern patternDni = Pattern.compile(regexDni); 
    Matcher matcherDni;



    while (!exit) { // Bucle que nos hará elegir opciones indefinidamente hasta que seleccionemos la 6
      System.out.println("\n------------------------------------");
      System.out.println("Selecciona que hacer:\n");

      System.out.println("1. Nuevo Libro.");
      System.out.println("2. Listar Libros.");
      System.out.println("3. Buscar Libro.");
      System.out.println("4. Modificar ediciones Libro.");
      System.out.println("5. Eliminar Libro.");
      System.out.println("6. Salir.");
      System.out.println("------------------------------------\n\n");
      
      
      // Switch que controla las opciones del menú
      switch (sc.nextInt()) {
        case 1: // Creación de nuevo libro, se piden los datos necesarios para crear un objeto Libro.
          System.out.println("1. Nuevo Libro.\n");
          System.out.println("Por favor inserta los siguientes datos: ");
          sc.nextLine(); // Limpia el buffer de entrada para evitar errores en la lectura de datos 
          

          do { // Bucle que se repite mientras que el DNI introducido no sea válido
            System.out.print("\nDNI Bibliotecario: "); 
            dniBibliotecario = sc.nextLine(); 
            matcherDni = patternDni.matcher(dniBibliotecario); // Comprueba que el DNI introducido sea válido
            
            if (!matcherDni.matches()) { // Controla que el DNI introducido sea válido
              System.out.println("----------------------------------------");
              System.out.println("ERROR!! El DNI introducido no es válido.");
              System.out.println("----------------------------------------");
            }
          } while (!matcherDni.matches());


          System.out.print("\nTítulo: "); 
          String titulo = sc.nextLine(); 

          while(titulo.length() == 0 || titulo.length() > 40){ // Bucle que se repite mientras que el título introducido no sea válido
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("ERROR!! El título no puede estar vacío o contener más de 40 caracteres.");
            System.out.println("-----------------------------------------------------------------------");
            
            System.out.print("\nTítulo: "); 
            titulo = sc.nextLine(); 
          }
          

          System.out.print("\nAutor: ");
          String autor = sc.nextLine(); 


          System.out.print("\nISBN: ");
          do { // Bucle que se repite mientras que el ISBN introducido no sea válido
            try { 
              isbn = sc.nextLong();
              sc.nextLine(); // Limpia el buffer
              isbnString = Long.toString(isbn);
              matcherIsbn = patternIsbn.matcher(isbnString); // Comprueba que el ISBN introducido sea válido

              if(!matcherIsbn.matches()){ // Controla que el ISBN introducido sea válido
                System.out.println("-----------------------------------------");
                System.out.println("ERROR!! El ISBN introducido no es válido.");
                System.out.println("-----------------------------------------");
              }
              
            } catch (InputMismatchException e) { // Controla que el ISBN sea un número
              System.out.println("-----------------------------------");
              System.out.println("ERROR!! El ISBN debe ser un número.");
              System.out.println("-----------------------------------");   
              sc.next(); // Limpia el buffer
            }
          } while (!matcherIsbn.matches());

          
          do { // Bucle que se repite mientras que el número de páginas introducido no sea válido
            System.out.print("\nNúmero de Páginas: ");
            try {
              numPags = sc.nextInt(); 
              sc.nextLine(); // Limpia el buffer 
              if(numPags <= 0){ // Controla que el número de páginas sea mayor que 0
                System.out.println("--------------------------------------------------");
                System.out.println("ERROR!! El Número de paginas debe ser mayor que 0.");
                System.out.println("--------------------------------------------------");
              }
            } catch (InputMismatchException e) { // Controla que el número de páginas sea un número
              System.out.println("------------------------------------------------");
              System.out.println("ERROR!! El Número de paginas debe ser un número.");
              System.out.println("------------------------------------------------");
              sc.nextLine(); // Limpia el buffer
            }
          } while (numPags <= 0); 


          System.out.print("\nDescripción: ");
          String descripcion = sc.nextLine(); 
          

          do { // Bucle que se repite mientras que el año de publicación introducido no sea válido
            System.out.print("\nAño de Publicación: ");
            try {
              anioPublicacion = sc.nextInt();
              sc.nextLine(); // Limpia el buffer

              if (anioPublicacion > Calendar.getInstance().get(Calendar.YEAR)) { // Controla que el año de publicación sea menor o igual que el actual
                System.out.println("------------------------------------------------------------------");
                System.out.println("ERROR!! El Año de publicación debe ser menor o igual que el actual.");
                System.out.println("------------------------------------------------------------------");
              }

            } catch (InputMismatchException e) { // Controla que el año de publicación sea un número
              System.out.println("------------------------------------------------");
              System.out.println("ERROR!! El Año de publicación debe ser numérico."); 
              System.out.println("------------------------------------------------");
              sc.nextLine(); // Limpia el buffer
            }
          } while (anioPublicacion > Calendar.getInstance().get(Calendar.YEAR));


          do { // Bucle que se repite mientras que el número de edición introducido no sea válido
            try {
              System.out.print("\nNúmero de Edición: "); 
              numEdicion = sc.nextInt();
              sc.nextLine(); // Limpia el buffer
            
              if (numEdicion <= 0) { // Controla que el número de edición sea mayor que 0
                System.out.println("--------------------------------------------------");
                System.out.println("ERROR!! El Número de edición debe ser mayor que 0.");
                System.out.println("--------------------------------------------------");
              }
           } catch (InputMismatchException e) {
              System.out.println("-----------------------------------------------");
              System.out.println("ERROR!! El Número de edición debe ser numérico."); 
              System.out.println("-----------------------------------------------");
              sc.nextLine(); // Limpia el buffer
           }
          } while (numEdicion <= 0);
          
          // Si todo está correcto, se inserta el libro en la biblioteca
          int estadoNuevoLibro = biblioteca.insertarLibro(titulo, autor, isbn, numPags, descripcion, anioPublicacion, numEdicion);

          if(estadoNuevoLibro == -1){ // Controla si la biblioteca está llena
            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("ERROR!! La biblioteca está llena, no se pueden añadir más libros.");
            System.out.println("-----------------------------------------------------------------");
          
          } else if(estadoNuevoLibro == -2){ // Controla si el ISBN introducido ya existe en la biblioteca
            System.out.println("\n-------------------------------------------------------");
            System.out.println("ERROR!! El ISBN introducido ya existe en la biblioteca.");
            System.out.println("-------------------------------------------------------");
          
          } else if(estadoNuevoLibro == 0){ // Controla si el libro se ha creado con éxito
            System.out.println("\n--------------------------------");
            System.out.println("El libro se ha creado con éxito.");
            System.out.println("--------------------------------");
          }
          break;

        case 2: // Mostrar listado de libros
          System.out.println("2. Listar Libros.");
          System.out.println("-------------------------------");
          biblioteca.listaLibros(); // Muestra los libros de la biblioteca
          break;
              

        case 3: // Busca libro por su ISBN
          System.out.println("3. Buscar Libro.");
          System.out.println("----------------------------------------");
          System.out.print("Introduce el ISBN: ");
          System.out.println(biblioteca.buscaLibro(sc.nextLong()) + "\n"); // Muestra el libro con el ISBN introducido
          sc.nextLine(); // Limpia el buffer
          break;
        

        case 4: // Actualiza el número de ediciones del libro
          System.out.println("4. Modificar ediciones Libro.");
          System.out.println("---------------------------------\n");

          System.out.print("Introduce el ISBN del libro: ");
          isbn = sc.nextLong();
          sc.nextLine(); // Limpia el buffer de entrada

          
          System.out.print("Introduce el nuevo número de ediciones: ");
          int nuevoNumEdicion = sc.nextInt();
          sc.nextLine(); // Limpia el buffer de entrada

          if(biblioteca.actualizaEdiciones(isbn, nuevoNumEdicion)){ // Actualiza el número de ediciones del libro
            System.out.println("\n-------------------------------------------------------");
            System.out.println("El número de ediciones se ha actualizado correctamente.");
            System.out.println("-------------------------------------------------------\n");

          } else {
            System.out.println("\n---------------------------------------------------");
            System.out.println("ERROR!! No se ha encontrado el libro con ese ISBN.");
            System.out.println("---------------------------------------------------\n");
          }
          break;
        

        case 5: // Eliminar libro
          System.out.println("5. Eliminar libro.");
          System.out.println("---------------------------------\n");

          System.out.print("Introduce el ISBN del libro a eliminar: ");
          isbn = sc.nextLong();
          sc.nextLine(); // Limpia el buffer de entrada
          
          if (biblioteca.eliminarLibro(isbn)) { // Elimina el libro con el ISBN introducido
            System.out.println("\n---------------------------------");
            System.out.println("El libro se ha eliminado con éxito.");
            System.out.println("---------------------------------\n");

          } else {
            System.out.println("\n-------------------------------------");
            System.out.println("ERROR!! No se ha encontrado el libro.");
            System.out.println("-------------------------------------\n");
          }
        break;


        case 6: // Sale del programa
          exit = true; // Cambia el valor de la variable de control para salir del bucle del menú
          sc.close(); // Cierra el Scanner
          System.out.println("-----------------------");
          System.out.println(" Finalizando programa.");
          System.out.println("-----------------------\n");
          break;
      }
    }
  }
}