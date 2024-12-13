package com.prog03.figuras;

/**
 * @author David
 */
public class Rectangulo {
  private float base;
  private float altura;
  
  // Constructor que inicializa atributos a 0
  public Rectangulo(){
    this.base = 0;
    this.altura = 0;
  }
  
  //Constructor que inicializa valores
  public Rectangulo(float base, float altura){
    this.base = base;
    this.altura = altura;
  };
  
  
  //Getters
  public float getBase(){
    return this.base;
  };

  public float getAltura(){
    return this.altura;
  };
    
    
  //Setters
  public void setBase(float base){
    this.base = base;
  };
  
  public void setAltura(float altura){
    this.altura = altura;
  };
  
  
  //Método que devuelve el area del rectángulo.   
  public float getArea(){
    float areaRectangulo = base*altura;
    return areaRectangulo;
  };
  
  
  //Método que devuelve una cadena conteniendo su base y altura
  public String toString(){
    return ("El rectángulo tiene una base de: " + this.base + " y una altura de: " + this.altura);
  };
  
  
  //Método que devuelve un booleano indicando si el rectángulo es cuadrado.
  public boolean esCuadrado(){
    if(this.base == this.altura){
      return true;
    }else{
      return false;
    }
  };
}
