package com.prog05_ejerc1;
import java.util.Calendar;

/**
 * Clase Libro que contiene los atributos y métodos de un libro.
 * @author David Graciá Requena
 */
public class Libro {
  // Atributos del libro
  private String titulo;
  private String autor;
  private long isbn;
  private int numPags;
  private String descripcion;  
  private int anioPublicacion;
  private int numEdicion;
 

  // Constructor por defecto
  protected Libro(){};
  
  // Constructor con valores
  protected Libro(String titulo, String autor, long isbn, int numPags, String descripcion, int anioPublicacion, int numEdicion){
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.numPags = numPags;
    this.descripcion = descripcion;
    this.anioPublicacion = anioPublicacion;    
    this.numEdicion = numEdicion;
  };
  
  
  // Getters
  protected String getTitulo(){
    return titulo;
  };
  
  protected String getAutor(){
    return autor;
  };
  
  protected long getIsbn(){
    return isbn;
  };
  
  protected int getNumPags(){
    return numPags;
  }
  
  protected String getDescripcion(){
    return descripcion;
  }
  
  protected int getNumEdicion(){
    return numEdicion;
  };
  
  protected int getAnioPublicacion(){
    return anioPublicacion;
  };
  
  /**
   * Método que devuelve los años de antigüedad del libro
   * @param anioPublicacion Año de publicación del libro
   * @return int Años de antigüedad
   */
  protected int getAntiguedad(int anioPublicacion){ 
    int anioActual = Calendar.getInstance().get(Calendar.YEAR);
    return anioActual - anioPublicacion;
  }
  
  
  // Setters 
  protected void setTitulo(String titulo){
    this.titulo = titulo;
  };
  
  protected void setAutor(String autor){
    this.autor = autor;
  };
  
  protected void setIsbn(long isbn){
    this.isbn = isbn;
  };
  
  protected void setNumPags(int numPags){
    this.numPags = numPags;
  }
  
  protected void setDescripcion(String descripcion){
    this.descripcion = descripcion;
  }
  
  protected void setNumEdicion(int numEdicion){
     this.numEdicion = numEdicion;
  };
  
  protected void setAnioPublicacion(int anioPublicacion){
    this.anioPublicacion = anioPublicacion;
  };
}
