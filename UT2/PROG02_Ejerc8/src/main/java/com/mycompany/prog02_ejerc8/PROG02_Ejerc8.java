package com.mycompany.prog02_ejerc8;

/**
 * @author David
 */
public class PROG02_Ejerc8 {
  
    public static void main(String[] args) {
      
      // Alumnos matriculados en cada asignatura
      int alumnsProg = 695;
      int alumnsDBase = 659;
      int alumnsDEnv = 2;
      
      // Nº total de alumnos
      float alumnsTotal = alumnsProg + alumnsDBase + alumnsDEnv;
      
      // Porcentaje de alumnos en cada asignatura
      float percentProg = (alumnsProg *100) / alumnsTotal;
      float percentDBase = (alumnsDBase *100) / alumnsTotal;
      float percentDEnv = (alumnsDEnv *100) / alumnsTotal;
      
      // Se imprime mostrando un solo decimal.
      System.out.println("En total hay " + (int)alumnsTotal + " alumnos.");
      System.out.println("El " + String.format("%.1f",  + percentProg)+ "% asiste a Programación.");
      System.out.println("El " + String.format("%.1f",  + percentDBase)+ "% asiste a Bases de Datos.");
      System.out.println("El " + String.format("%.1f",  + percentDEnv)+ "% asiste a Entornos de Desarrollo.");
    }
}
