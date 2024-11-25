package com.mycompany.prog02_ejerc6;

/**
 * @author David
 */
public class PROG02_Ejerc6 {
  
    public static void main(String[] args) {
      enum Breed {MASTIN, TERRIER, BULLDOG, PEKINES, CANICHE, GALGO};
      
      Breed var1 = Breed.BULLDOG;
      Breed var2 = Breed.BULLDOG;
      
      System.out.println(var1 == var2); // Si elegimos el mismo valor, dará True
      
      
      var1 = Breed.CANICHE;
      var2 = Breed.MASTIN;
      
      System.out.println(var1 == var2); //Si es distinto, False 
      
      
      // Para mostrar la cantidad de valores que contiene el enum, primero lo convertimos a array con values() y con .length obtenemos su longitud.
      System.out.println("El enum Breed contiene " + Breed.values().length + " valores"); 
      
      // Con .ordinal() podemos obtener el índice de cada constante del enum.
      System.out.println("La raza CANICHE está en el índice " + Breed.CANICHE.ordinal());
      System.out.println("La raza MASTIN está en el índice " + Breed.MASTIN.ordinal());
    }
}
