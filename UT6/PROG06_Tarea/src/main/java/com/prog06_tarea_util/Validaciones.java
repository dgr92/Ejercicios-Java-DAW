package com.prog06_tarea_util;
import java.util.Calendar;


/**
 * Clase Validaciones que contiene los métodos de validación para los atributos de la clase Libro.
 * @author David Graciá Requena
 */
public class Validaciones {

  /**
   * Método que comprueba si existe un libro, devuelve false si no existe y muestra un mensaje de error.
   * Devuelve true si existe.
   * @param titulo Título del libro
   * @return boolean
   */
  public static boolean existeLibro(String titulo){
    if(titulo == null){
      System.out.println("--------------------------------");
      System.out.println("ERROR!! No existe ningún libro.");
      System.out.println("Por favor, Crea un libro primero.");
      System.out.println("--------------------------------");
      return false;
    } 

    return true;
  };

  /**
   * Método que comprueba si el título del libro es válido.
   * Devuelve false si es menor o igual que cero y muestra un mensaje de error.
   * Devuelve true si es válido.
   * @param numEdicion Número de edición del libro
   * @return boolean
   */
  public static boolean validarNumEdiciones (int numEdicion){
    if(numEdicion <= 0){
      System.out.println("---------------------------------------------------");
      System.out.println("ERROR!! Introduce un Número de Edición mayor que 0.");
      System.out.println("Por favor. Introduce un Número de Edición válido.");
      System.out.println("---------------------------------------------------");
      return false;
    } 

    return true;
  };

  /**
   * Método que comprueba si el ISBN del libro es válido.
   * Devuelve false si tiene menos de 13 dígitos y muestra un mensaje de error.
   * Devuelve true si es válido.
   * @param isbn ISBN del libro
   * @return boolean
   */
  public static boolean validarIsbn(long isbn){
    String isbnString = String.valueOf(isbn);
    if(isbnString.length() != 13){
      System.out.println("--------------------------------------");
      System.out.println("ERROR!! El ISBN debe tener 13 dígitos.");
      System.out.println("Por favor. Introduce un ISBN válido.");
      System.out.println("--------------------------------------");
      return false;
    } 

    return true;
  };

  /**
   * Método que comprueba si el año de publicación del libro es válido.
   * Devuelve false si el año de publicación es mayor que el año actual y muestra un mensaje de error.
   * Devuelve true si es válido.
   * @param anioPublicacion Año de publicación del libro
   * @return boolean
   */
  public static boolean validarAnioPublicacion(int anioPublicacion){
    int actualYear = Calendar.getInstance().get(Calendar.YEAR);
    if(anioPublicacion > actualYear){
      System.out.println("-------------------------------------------------------------");
      System.out.println("ERROR!! El Año de Publicacióndebe de ser menor al año actual.");
      System.out.println("Por favor. Introduce un Año de Publicación válido.");
      System.out.println("-------------------------------------------------------------");
      return false;
    } 

    return true;
  };

  /**
   * Método que al actualizar el número de edición del libro comprueba si el número es válido.
   * Devuelve false si el número de edición es menor o igual al que tenía previamente y muestra un mensaje de error.
   * Devuelve true si es válido.
   * @param numEdicion Número de edición previo del libro
   * @param nuevoNumEdicion Nuevo número de edición del libro
   * @return boolean
   */
  public static boolean actualizarNumEdicion(int numEdicion, int nuevoNumEdicion){
    if(nuevoNumEdicion <= numEdicion){
      System.out.println("----------------------------------------------------------------------");
      System.out.println("ERROR!! El nuevo número de edición tiene que ser mayor que el antiguo.");
      System.out.println("Por favor. Introduce un nuevo número de edición válido.");
      System.out.println("----------------------------------------------------------------------");
      return false;
    } 
    
    return true;
  };  
}
