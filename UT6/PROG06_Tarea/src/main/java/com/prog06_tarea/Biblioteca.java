package com.prog06_tarea;
import com.prog06_tarea.Libro;
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


    // protected String buscaLibro(long isbn){

    // }


    // protected void listaLibros(){
    //     for (int i = 0; i < librosBiblioteca.length; i++) {

    //     }
    // }
    
    // protected boolean actualizaEdiciones(){

    // }
}