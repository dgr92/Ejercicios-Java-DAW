package ejercicios_fechas;
import ejercicios_fechas.Fecha;

/**
 * @author David
 */
public class Prog03_Ejerc1 {

    public static void main(String[] args) {
      
      Fecha objFecha1 = new Fecha(Fecha.enumMes.JUNIO);
      
      objFecha1.setDia(19);
      objFecha1.setAnio(2024);

      System.out.println( "La fecha 1 es: " + objFecha1.toString() );
      System.out.println( (objFecha1.isSummer()) ? "SI es verano" : "NO es verano");
      
      
      System.out.println("-------------------");

      
      Fecha objFecha2 = new Fecha(31, Fecha.enumMes.OCTUBRE, 2020);
      
      System.out.println( "La fecha 2 contiene el año: " + objFecha2.anio );
      System.out.println( "La fecha 2 es: " + objFecha2.toString() );
      System.out.println( (objFecha2.isSummer()) ? "SI es verano" : "NO es verano");
    };
    
}
