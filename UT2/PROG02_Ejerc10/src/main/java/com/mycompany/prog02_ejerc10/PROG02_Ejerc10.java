package com.mycompany.prog02_ejerc10;

/**
 * @author David
 */
public class PROG02_Ejerc10 {

    public static void main(String[] args) {
      
      float x = 4.5f; 
      float y = 3.0f;
      int i = 2;
      int j = (int)(i * x);
      double dx = 2.0d;
      double dz = dx * y;
      
      System.out.println("------- Conversiones entre enteros y coma flotante -------");
      System.out.println("Producto de int por float: j= i*x = " + j + 
                       "\nProducto de float por double: dz= dx*y = " + dz);
      
      
      byte bx = 5;
      byte by = 2;
      byte bz = (byte)(bx - by);
      
      System.out.println("\n------- Operaciones con byte -------");
      System.out.println("byte: " + bx + " - " + by + " = " + bz);
      
      bx = -128;
      by = 1;
      bz = (byte)(bx - by);
      int resultadoBzInt = bx - by; 
      /* en byte solo se puede almacenar desde -128 hasta 127, y por desbordamiento de datos,
      si los resto en vez de dar -129 me da 127, así que opté por crear variable int nueva.*/

      System.out.println("byte " + bx + " - " + by + " = " + bz);
      System.out.println("(int)(" + bx + " - " + by + ") = " + resultadoBzInt);

      
      short sx = 5;
      short sy = 2;
      short sz = (short)(sx-sy);
      
      System.out.println("\n------- Operaciones con short -------");
      System.out.println(sx + " - " + sy + " = " + sz);
      
      
      sx = 32767;
      sy = 1;
      sz = (short)(sx + sy);
      // En este caso el desbordamiento si que muestra el número correctamente aunque esté fuera del rango del tipo de dato.
      
      System.out.println(sx + " - " + sy + " = " + sz);

          
      char cx = '\u000F';
      char cy = '\u0001';
      int z = cx - cy;  
      
      System.out.println("\n------- Operaciones con char -------");
      System.out.println("char: " + cx +" + "+ cy + " = " + z );
      
      
      z = cx -1;
      
      System.out.println("char(0x000F) - 1 = " + z );
      
      
      cx = '\uFFFF';
      z = cx;
     
      System.out.println("(int)(" + cx + ") - 1 = " + z );
      
      
      sx = (short)cx;
      
      System.out.println("(short)(" + cx + ") = " + sx );

      
      sx = -32768;
      cx = (char)sx;
      z = (int)cx;
      
      System.out.println(sx + " short-char-int = " + z);


      sx = -1;
      cx = (char)sx;
      z = (int)cx;
      
      System.out.println(sx + " short-char-int = " + z);
    }
}
