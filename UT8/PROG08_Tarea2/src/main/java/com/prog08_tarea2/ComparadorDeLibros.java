package com.prog08_tarea2;
import java.util.Comparator;

/**
 * Clase ComparadorDeLibros que implementa la interfaz Comparator para comparar libros por su ISBN.
 * @author David Graciá Requena
 */
public class ComparadorDeLibros implements Comparator<Libro>{
    /**
     * Método que compara dos libros por su ISBN.
     * @param libro1 Libro 1 a comparar.
     * @param libro2 Libro 2 a comparar.
     * @return 1 si el ISBN del libro1 es menor que el ISBN del libro2, -1 si el ISBN del libro1 es mayor que el ISBN del libro2, 0 si los ISBN son iguales.
     */
  @Override
  public int compare(Libro libro1, Libro libro2){ // Método que compara dos libros por su ISBN.
    if(libro1.getIsbn() < libro2.getIsbn()){ 
      return -1;
      
    } else if(libro1.getIsbn() > libro2.getIsbn()){ 
      return 1;

    }else{ 
      return 0;
    }
  };
};
