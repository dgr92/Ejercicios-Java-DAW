package com.mycompany.prog02_ejerc1;

/**
 * @author David
 */
public class PROG02_Ejerc1 {

  public static void main(String[] args) {
    final short MAX_VALUE = 5000; 
    // "final" hace que la variable sea constante y para almacenar un valor constante de 5000 con "short" es más que suficiente (rango -32.768, 32.767)

    boolean hasDrivingLicense = true;
    // "boolean" para valores binarios de tipo S/N, true/false

    byte monthNumber = 11;
    // "byte" es suficiente para el valor numérico de un mes (rango -128, 127)

    String monthName = "November";        
    String name = "David Graciá Requena";
    // "String" es adecuado para el nombre del mes y de la persona ya que permite almacenar cadenas de caracteres

    char gender = 'V';
    // "char" para almacenar un único carácter

    long milisecondsSince1970 = System.currentTimeMillis();
    /* "long" es perfecto para almacenar los milisegundos desde el 01/01/1970 ya que permite rangos numéricos de -2e63 a 2e63-1 
    así que no se nos quedará pequeño aunque pasen los años */

    float bankBalance = 16254.25F;
    // "double"

    int kmsToJupiter = 587000000;
    // "int" sería suficiente en este caso ya que permite valores de –2,147,483,648 a 2,147,483,647 

    System.out.printf(
      "Max. value: " + MAX_VALUE + 
      "\nHas driving license? " + hasDrivingLicense + 
      "\nMonth number: " + monthNumber + 
      "\nMonth name: " + monthName +
      "\nName: " + name + 
      "\nGender: " + gender +
      "\nMiliseconds since 01/01/1970: " + milisecondsSince1970 + 
      "\nBank balance: " + bankBalance +
      "\nKms to Jupiter: " + kmsToJupiter
    );
  }
}
