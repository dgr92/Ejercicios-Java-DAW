package com.prog03.Principal;
import com.prog03.figuras.Rectangulo;

/**
 * @author David
 */
public class Principal {
  public static void main(String args[]){
    //Instanciamos dos objetos, uno con cada constructor
    Rectangulo rect1 = new Rectangulo();
    Rectangulo rect2 = new Rectangulo(5,7);
    
    //Inicializamos los valores del primer objeto mediante los setters
    rect1.setAltura(12);
    rect1.setBase(12);
    
    //Obtenemos el área de los rectángulos
    System.out.println("El área del rectángulo 1 es: " + rect1.getArea());
    System.out.println("El área del rectángulo 2 es: " + rect2.getArea());
    System.out.println("--------------------------------");
    
    //Obtenemos una cadena con la base y altura de cada rectángulo
    System.out.println(rect1.toString());
    System.out.println(rect2.toString());
    System.out.println("--------------------------------");
    
    //Comprobamos si alguno de los rectángulos es cuadrado
    System.out.println((rect1.esCuadrado()) ? "El rectángulo 1 es cuadrado" : "El rectángulo 1 NO es cuadrado" );
    System.out.println((rect2.esCuadrado()) ? "El rectángulo 2 es cuadrado" : "El rectángulo 2 NO es cuadrado" );
  };
}
