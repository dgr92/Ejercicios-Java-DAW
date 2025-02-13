package com.prog06_tarea;
import java.util.ArrayList;


/**
 * Clase Biblioteca que contiene los métodos para insertar, buscar, listar, actualizar y eliminar libros.
 * @author David Graciá Requena
 */
public class Biblioteca {
    // Atributos de la biblioteca
    private ArrayList<Libro> librosBiblioteca; // ArrayList de libros que contiene la biblioteca.
    private static final int MAX_LIBROS = 100; // Número máximo de libros que puede contener la biblioteca.

    
    // Constructor por defecto de la biblioteca que inicializa el ArrayList de libros.
    protected Biblioteca(){
      this.librosBiblioteca = new ArrayList<>();
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

        for (int i = 0; i < librosBiblioteca.size(); i++) {
          if(librosBiblioteca.get(i).getIsbn() == isbn){ // Si el libro ya existe, se devuelve -2.
            return -2;
          }
        }

        // Si todo es correcto, se crea un nuevo libro y se añade al ArrayList de libros.
        Libro libro = new Libro(titulo, autor, isbn, numPags, descripcion, anioPublicacion, numEdicion);
        librosBiblioteca.add(libro); 
        return 0; // Se devuelve 0 si se ha insertado correctamente.
    }


    /**
     * Método que busca un libro por su ISBN.
     * @param isbn ISBN del libro a buscar.
     * @return Información del libro si se encuentra, mensaje de error si no se encuentra.
     */
    protected String buscaLibro(long isbn){ 
      for(int i= 0; i < librosBiblioteca.size(); i++){ // Se recorre el ArrayList de libros.
        if(librosBiblioteca.get(i).getIsbn() == isbn){ // Si se encuentra el libro, se devuelve la información del libro.
          return "Título: \n" + librosBiblioteca.get(i).getTitulo() + "\n\n" +
                 "Autor: \n" + librosBiblioteca.get(i).getAutor() + "\n\n" +
                 "ISBN: \n" + librosBiblioteca.get(i).getIsbn() + "\n\n" +
                 "Descripción: \n" + librosBiblioteca.get(i).getDescripcion() + "\n\n" +
                 "Número de páginas: \n" + librosBiblioteca.get(i).getNumPags() + "\n\n" +
                 "Año de publicación: \n" + librosBiblioteca.get(i).getAnioPublicacion() + "\n\n" +
                 "Número de edición: \n" + librosBiblioteca.get(i).getNumEdicion();
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
      if(librosBiblioteca.size() == 0){ // Si no hay libros en la biblioteca, se muestra un mensaje de error.
        System.out.println("No hay libros en la biblioteca.");
        System.out.println("-------------------------------");

      }

      for (int i = 0; i < librosBiblioteca.size(); i++) { // Si hay libros en la biblioteca, se muestra la información de cada libro.
        System.out.println("Libro nº" + (i+1) + "\n");
        System.out.println("Titulo: \n" + librosBiblioteca.get(i).getTitulo() + "\n");
        System.out.println("Autor: \n" + librosBiblioteca.get(i).getAutor() + "\n");
        System.out.println("ISBN: \n" + librosBiblioteca.get(i).getIsbn() + "\n");
        System.out.println("Descripcion: \n" + librosBiblioteca.get(i).getDescripcion() + "\n");
        System.out.println("Numero de paginas: \n" + librosBiblioteca.get(i).getNumPags() + " páginas.\n");
        System.out.println("Año de publicacion: \n" + librosBiblioteca.get(i).getAnioPublicacion() + "\n");
        System.out.println("Numero de edicion: \n" + librosBiblioteca.get(i).getNumEdicion() + "\n");
        System.out.println("-----------------------------------");
      }
    }

    
    /**
     * Método que actualiza la descripción de un libro.
     * @param isbn ISBN del libro a actualizar.
     * @param numEdicion Número de edición del libro.
     * @return true si se ha actualizado correctamente, false si no se ha podido actualizar.
     */
    protected boolean actualizaEdiciones(long isbn, int numEdicion){
      for (int i = 0; i < librosBiblioteca.size(); i++) { // Se recorre el ArrayList de libros.
        if(librosBiblioteca.get(i).getIsbn() == isbn){ // Si se encuentra el libro, se actualiza el número de edición.
          librosBiblioteca.get(i).setNumEdicion(numEdicion); 
          return true;
        }
      }

      return false;
    }


    /**
     * Método que elimina un libro de la biblioteca.
     * @param isbn ISBN del libro a eliminar.
     * @return true si se ha eliminado correctamente, false si no se ha podido eliminar.
     */
    protected boolean eliminarLibro(long isbn){
      for (int i = 0; i < librosBiblioteca.size(); i++) { // Se recorre el ArrayList de libros.
        if(librosBiblioteca.get(i).getIsbn() == isbn){ // Si se encuentra el libro, se elimina del ArrayList de libros.
          librosBiblioteca.remove(i);
          return true;
        }
      }

      return false;
    }
}