package com.prog05_ejerc1;
import java.util.Date;
import java.time.Year;

/**
 * @author David
 */
public class Libro {
  private String titulo;
  private String autor;
  private long isbn;
  private int numPags;
  private String descripcion;  
  private Date anioPublicacion;
  private int numEdicion;
  
  
  // Constructor por defecto
  protected Libro(){};
  
  // Constructor con valores
  protected Libro(String titulo, String autor, long isbn, int numPags, String descripcion, Date anioPublicacion, int numEdicion){
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
  
  protected Date getFechaPublicacion(){
    return anioPublicacion;
  };
  
  protected Year getAntiguedad(){
    Year anioActual = Year.now();
    System.out.println(anioActual);
    return anioActual;
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
  
  protected void setAnioPublicacion(Date anioPublicacion){
    this.anioPublicacion = anioPublicacion;
  };
}
