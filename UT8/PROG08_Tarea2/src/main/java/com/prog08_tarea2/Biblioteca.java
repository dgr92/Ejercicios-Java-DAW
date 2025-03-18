package com.prog08_tarea2;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * Clase Biblioteca que contiene los métodos para insertar, buscar, listar, actualizar y eliminar libros.
 * @author David Graciá Requena
 */
public class Biblioteca {
    // Atributos de la biblioteca
    // Creo que la mejor y única opción en este caso, dado que se necesitan ordenados por ISBN, es un TreeSet.
    // Ya que ordena "automáticamente" y no permite duplicados.
    // Por ello se ha creado además, una clase comparadora de libros que implementa la interfaz Comparator.
    // Para permitir la ordenación por ISBN.
    private TreeSet<Libro> librosBiblioteca; // TreeSet de libros que contiene la biblioteca.
    private Iterator<Libro> it; // Iterador para recorrer el TreeSet de la biblioteca.
    private static final int MAX_LIBROS = 100; // Número máximo de libros que puede contener la biblioteca.

    
    // Constructor por defecto de la biblioteca que inicializa el Treeset de libros.
    protected Biblioteca(){
      this.librosBiblioteca = new TreeSet<Libro>(new ComparadorDeLibros()); // Se inicializa el TreeSet de libros pasándole el comparador de libros para que ordene por ISBN.
    }


    /**
     * Método que inserta un libro en la biblioteca.
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param isbn ISBN del libro.
     * @param numPags Número de páginas del libro.
     * @param descripcion Descripción del libro.
     * @param anioPublicacion Año de publicación del libro.
     * @param numEdicion Número de edición del libro.
     * @return 0 si se ha insertado correctamente, -1 si la biblioteca está llena y -2 si el libro ya existe.
     */ 
    protected int insertarLibro(String titulo, String autor, long isbn, int numPags, String descripcion, int anioPublicacion, int numEdicion){
      if(librosBiblioteca.size() == MAX_LIBROS){ // Si la biblioteca está llena, se devuelve -1.
        return -1;
      } 
      
      it =librosBiblioteca.iterator(); // Se inicializa el iterador para recorrer el TreeSet de libros.

      // Se recorre el TreeSet de la biblioteca para comprobar si el libro ya existe.
      while(it.hasNext()){
        Libro libro = it.next(); // Se obtiene el siguiente libro del TreeSet.
        if(libro.getIsbn() == isbn){ // Si el libro ya existe, se devuelve -2.
          return -2;
        }
      };

      // Si todo es correcto, se crea un nuevo libro y se añade al TreeSet de libros.
      Libro nuevoLibro = new Libro(titulo, autor, isbn, numPags, descripcion, anioPublicacion, numEdicion);
      librosBiblioteca.add(nuevoLibro); 
      return 0; // Se devuelve 0 si se ha insertado correctamente.
    }


    /**
     * Método que busca un libro por su ISBN.
     * @param isbn ISBN del libro a buscar.
     * @return Información del libro si se encuentra, mensaje de error si no se encuentra.
     */
    protected String buscaLibro(long isbn){ 
      it =librosBiblioteca.iterator(); // Se inicializa el iterador para recorrer el TreeSet de libros.
      while(it.hasNext()){ // Se recorre el TreeSet de la biblioteca para comprobar si el libro ya existe.
        Libro libro = it.next();
        if(libro.getIsbn() == isbn){ // Si se encuentra el libro, se devuelve la información del libro.
          return "Título: \n" + libro.getTitulo() + "\n\n" +
                 "Autor: \n" + libro.getAutor() + "\n\n" +
                 "ISBN: \n" + libro.getIsbn() + "\n\n" +
                 "Descripción: \n" + libro.getDescripcion() + "\n\n" +
                 "Número de páginas: \n" + libro.getNumPags() + "\n\n" +
                 "Año de publicación: \n" + libro.getAnioPublicacion() + "\n\n" +
                 "Número de edición: \n" + libro.getNumEdicion();
        }
      }

      return "----------------------------------------\n" + 
             "No existe libro con el ISBN introducido.\n" + 
             "----------------------------------------";
    }
    

    /**
     * Método que lista todos los libros de la biblioteca.
     * Si hay libros, se muestra la información de cada libro, sino, se muestra un mensaje de error.
     */
    protected void listaLibros(){ 
      int numLibro = 1; // Número de libro que se muestra en la lista de libros.

      if(librosBiblioteca.size() == 0){ // Si no hay libros en la biblioteca, se muestra un mensaje de error.
        System.out.println("No hay libros en la biblioteca.");
        System.out.println("-------------------------------");

      }

      this.it =librosBiblioteca.iterator(); // Se inicializa el iterador para recorrer el TreeSet de libros.
      while (it.hasNext()) { // Si hay libros en la biblioteca, se muestra la información de cada libro.
        Libro libro = it.next();
        System.out.println("Libro nº: " + numLibro + "\n");
        System.out.println("Titulo: \n" + libro.getTitulo() + "\n");
        System.out.println("Autor: \n" + libro.getAutor() + "\n");
        System.out.println("ISBN: \n" + libro.getIsbn() + "\n");
        System.out.println("Descripcion: \n" + libro.getDescripcion() + "\n");
        System.out.println("Numero de paginas: \n" + libro.getNumPags() + " páginas.\n");
        System.out.println("Año de publicacion: \n" + libro.getAnioPublicacion() + "\n");
        System.out.println("Numero de edicion: \n" + libro.getNumEdicion() + "\n");
        System.out.println("-----------------------------------");
        numLibro++;
      }
    }

    
    /**
     * Método que actualiza la descripción de un libro.
     * @param isbn ISBN del libro a actualizar.
     * @param numEdicion Número de edición del libro.
     * @return true si se ha actualizado correctamente, false si no se ha podido actualizar.
     */
    protected boolean actualizaEdiciones(long isbn, int numEdicion){
      it =librosBiblioteca.iterator(); // Se inicializa el iterador para recorrer el TreeSet de libros.
      while(it.hasNext()){ // Se recorre el TreeSet de libros.
        Libro libro = it.next();
        if(libro.getIsbn() == isbn){ // Si se encuentra el libro, se actualiza el número de edición.
          libro.setNumEdicion(numEdicion);
          return true;
        };
      }
      return false;
    }


    /**
     * Método que elimina un libro de la biblioteca.
     * @param isbn ISBN del libro a eliminar.
     * @return true si se ha eliminado correctamente, false si no se ha podido eliminar.
     */
    protected boolean eliminarLibro(long isbn){
      it =librosBiblioteca.iterator(); // Se inicializa el iterador para recorrer el TreeSet de libros.
      while(it.hasNext()){ // Se recorre el TreeSet de libros.
        Libro libro = it.next();
        if(libro.getIsbn() == isbn){ // Si se encuentra el libro, se elimina
          librosBiblioteca.remove(libro);
          return true;
        };
      };
      return false;
    }
}