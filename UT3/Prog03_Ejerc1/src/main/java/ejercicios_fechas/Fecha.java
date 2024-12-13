package ejercicios_fechas;

/**
 * @author David
 */
public class Fecha {
  enum enumMes {
    ENERO,
    FEBRERO,
    MARZO,
    ABRIL,
    MAYO,
    JUNIO,
    JULIO,
    AGOSTO,
    SEPTIEMBRE,
    OCTUBRE,
    NOVIEMBRE,
    DICIEMBRE;
  };
  
  private int dia;
  private enumMes mes;
  private int anio;
  
  
  // Constructor que inicializa mes al valor introducido y día y año a 0
  Fecha(enumMes mes){
    this.mes = mes;
    this.dia = 0;
    this.anio = 0;
  };
  
  
  // Constructor que inicializa dia, mes y año a los valores introducidos
  Fecha(int dia, enumMes mes, int anio){
    this.dia = dia;
    this.mes = mes;
    this.anio = anio;
  };
  
    
  // Getters
  public int getDia(){
    return this.dia;
  };
  
  public enumMes getMes(){
    return this.mes;
  };
    
  public int getAnio(){
    return this.anio;
  };
  
  
  // Setters
  public void setDia(int dia){
    this.dia = dia;
  };
  
  public void setMes(enumMes mes){
    this.mes = mes;
  };
    
  public void setAnio(int anio){
    this.anio = anio;
  };
  
  
  // Método que devuelve true si el valor contenido en la fecha es verano y false en caso contrario
  public boolean isSummer(){
    if((this.dia > 20 && this.mes == enumMes.JUNIO) || 
       (this.mes == enumMes.JULIO) || 
       (this.mes == enumMes.AGOSTO) || 
       (this.dia < 23 && this.mes == enumMes.SEPTIEMBRE))
    {
      return true;
    }else{
      return false;
    }
  };
  
 
  // Método que devuelve una cadena con la fecha en formato largo-
  public String toString(){
    String fechaString = this.dia + " de " + this.mes + " de " + this.anio;
    
    return fechaString.toLowerCase();
  }
}
