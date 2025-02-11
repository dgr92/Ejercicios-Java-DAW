package com.prog06_tarea;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> librosBiblioteca;
    private static final int MAX_LIBROS = 100;

    protected Biblioteca(){
      this.librosBiblioteca = new ArrayList<>();
    }

    protected int insertarLibro(String titulo, String autor, long isbn, int numPags, String descripcion, int anioPublicacion, int numEdicion){
        if(librosBiblioteca.size() == MAX_LIBROS){
          return -1;
        } 

        for (int i = 0; i < librosBiblioteca.size(); i++) {
          if(librosBiblioteca.get(i).getIsbn() == isbn){
            return -2;
          }
        }

        Libro libro = new Libro(titulo, autor, isbn, numPags, descripcion, anioPublicacion, numEdicion); 
        librosBiblioteca.add(libro);
        return 0;
    }


    protected String buscaLibro(long isbn){
      for(int i= 0; i < librosBiblioteca.size(); i++){
        if(librosBiblioteca.get(i).getIsbn() == isbn){
          return "Título: " + librosBiblioteca.get(i).getTitulo() + "\n" +
                 "Autor: " + librosBiblioteca.get(i).getAutor() + "\n" +
                 "ISBN: " + librosBiblioteca.get(i).getIsbn() + "\n" +
                 "Descripción: " + librosBiblioteca.get(i).getDescripcion() + "\n" +
                 "Número de páginas: " + librosBiblioteca.get(i).getNumPags() + "\n" +
                 "Año de publicación: " + librosBiblioteca.get(i).getAnioPublicacion() + "\n" +
                 "Número de edición: " + librosBiblioteca.get(i).getNumEdicion() + "\n";
        }
      } 
      return "----------------------------------------\n" + 
             "No existe libro con el ISBN introducido.\n" + 
             "----------------------------------------";
    }


    protected void listaLibros(){
      if(librosBiblioteca.size() == 0){
        System.out.println("No hay libros en la biblioteca.");
        System.out.println("-------------------------------");

      }

      for (int i = 0; i < librosBiblioteca.size(); i++) {
        System.out.println("Libro nº" + (i+1) + "\n");
        System.out.println("Titulo: \n" + librosBiblioteca.get(i).getTitulo() + "\n");
        System.out.println("Autor: \n" + librosBiblioteca.get(i).getAutor() + "\n");
        System.out.println("ISBN: \n" + librosBiblioteca.get(i).getIsbn() + "\n");
        System.out.println("Descripcion: \n" + librosBiblioteca.get(i).getDescripcion() + "\n");
        System.out.println("Numero de paginas: \n" + librosBiblioteca.get(i).getNumPags() + " páginas.\n");
        System.out.println("Año de publicacion: \n" + librosBiblioteca.get(i).getAnioPublicacion() + "\n");
        System.out.println("Numero de edicion: \n" + librosBiblioteca.get(i).getNumEdicion() + "\n");
        System.out.println("-------------------------------------------------");
      }
    }
    
    
    protected boolean actualizaEdiciones(long isbn, int numEdicion){
      for (int i = 0; i < librosBiblioteca.size(); i++) {
        if(librosBiblioteca.get(i).getIsbn() == isbn){
          librosBiblioteca.get(i).setNumEdicion(numEdicion);
          return true;
        }
      }
      return false;
    }

    protected boolean eliminarLibro(long isbn){
      for (int i = 0; i < librosBiblioteca.size(); i++) {
        if(librosBiblioteca.get(i).getIsbn() == isbn){
          librosBiblioteca.remove(i);
          return true;
        }
      }
      return false;
    }
}