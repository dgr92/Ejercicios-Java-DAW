package com.prog05_ejerc1_util;
import java.time.Year;

/**
 * @author David
 */
public class Validaciones {
  public static boolean validarNumEdiciones (int numEdicion){
    if(numEdicion <= 0){
        System.out.println("ERROR!! Introduce un Número de Edición mayor que 0.");
        System.out.println("Por favor. Introduce un Número de Edición válido.");
        return false;

    } else {
        return true;
    }
  };

  
  public static boolean validarIsbn(long isbn){
    String isbnString = String.valueOf(isbn);
    if(isbnString.length() != 13){
      System.out.println("ERROR!! El ISBN debe tener 13 dígitos.");
      System.out.println("Por favor. Introduce un ISBN válido.");
      return false;
    }

    return true;
  };


  public static boolean validarAnioPublicacion(int anioPublicacion){
    Year actualYear = Year.now();
    if(anioPublicacion > Integer.parseInt(actualYear.toString())){
      System.out.println("ERROR!! El Año de Publicacióndebe de ser menor al año actual.");
      System.out.println("Por favor. Introduce un Año de Publicación válido.");
        return false;

    } else {
        return true;
    }
  };


  public static boolean validarNuevoNumEdicion(int numEdicion, int nuevoNumEdicion){
    if(nuevoNumEdicion < numEdicion){
      System.out.println("ERROR!! El nuevo número de edición tiene que ser mayor que el antiguo.");
      System.out.println("Por favor. Introduce un nuevo número de edición válido.");
      return false;

    } else {
      return true;
    }

  };  
}
