package com.prog04_ejerc04;
import java.util.Scanner;


/**
 * Juego que permite al usuario adivinar un número oculto (aleatorio).
 * @author David
 */
public class PROG04_Ejerc04 {
    private static Scanner sc = new Scanner(System.in);
    private static int numInt = 0;
    private static int numMax = 0;
      
    /**
     * Método principal que lanza el juego
     * @param args  Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
      game(); //Lanza el menú del juego
    }
    
    
    /**
     * Método con el menú del juego. 
     * Muestra el menú y permite al usuario seleccionar una de las tres opciones.
     * Además comprueba que el número introducido por teclado esté entre las opciones predefinidas.
     */
    public static void game(){
      
      System.out.println(" --------------------");
      System.out.println("|   MENU DE JUEGO:   |");
      System.out.println("|    1: Configurar.  |");
      System.out.println("|    2: Jugar.       |");
      System.out.println("|    3: Salir.       |");
      System.out.println(" --------------------\n\n");
      
      System.out.print("Selecciona: ");
      int userOption = sc.nextInt();
      
      if(userOption < 1 || userOption > 3){
        System.out.println("\nERROR!! Elige una de las opciones. \n");
        game();
      }
     
      switch(userOption){
        case 1: //Configurar
          configure();
          break;
          
        case 2: //Jugar
          play();
          break;          
          
        case 3: //Salir
          System.out.println("\nVuelve pronto! \n");
          break;
      }
    }
    
    
    /**
     * Método que permite al usuario seleccionar el número de intentos y el numero máximo con el que jugar. 
     */
    public static void configure(){
      System.out.print("Inserta el número de intentos: ");
      numInt = sc.nextInt();
          
      System.out.print("Inserta el número máximo generado: ");
      numMax = sc.nextInt();
      
      System.out.println ("\n\nPartida configurada correctamente. \n");
      
      game(); //Vuelve al menú
    };
    
    
    /**
     * Método con la funcionalidad del juego.
     * Comprueba si se ha configurado una partida, o si es una por defecto.
     * Solicita al usuario números dentro del rango definido mientras queden intentos, mostrando en cada intento una pista y los intentos restantes.
     * Si el usuario gana muestra un mensaje con el número de intentos utilizados.
     * Si el usuario pierde muestra un mensaje y muestra el número que había que encontrar.
     */
    public static void play(){
      //Comprueba que se haya configurado una partida, y sino utiliza unos valores por defecto
      if(numMax == 0 || numInt == 0){
        numMax = 10;
        numInt = 5;
        System.out.println("No has configurado partida. Se aplicarán valores por defecto.");
        System.out.println("Nº de intentos: " + numInt + "\nNº máximo generado: " + numMax + "\n");
      }
      
      int secretNum = (int)Math.floor(Math.random()*numMax+1); //genera un número aleatorio entre 0 y numMax, ambos incluidos.
      int attemptCounter = 0; //Contador de intentos
            
      //Bucle que se repite tantas veces como intentos haya hasta que se acierte el número o el jugador pierda.
      for (int i = numInt-1; i >= 0 ; i--) {
        System.out.print("Prueba con un numero: \n");
        int num = sc.nextInt();
        
        if(num == secretNum){
          System.out.println("\nENHORABUENA!! \nGANASTE!! \nNecesitaste " + attemptCounter + " intentos. \nBIEN JUGADO!! \n");
          
          //Reseteo de valores
          numMax = 0;
          numInt = 0;
          game(); //Vuelve al menú
          return; //Finaliza el método
        }
        
        if(i != 0){
          if(secretNum < num){
            System.out.println("Número incorrecto. \nEl número oculto es menor. \nSigue intentándolo!!");
            
          } else {
            System.out.println("Número incorrecto. \nEl número oculto es mayor. \nSigue intentándolo!!");
          }
          
          System.out.println("Intentos restantes: " + i + "\n\n");
          attemptCounter++;
        }
      }
      
      System.out.println("\nPerdiste! \nIntentos consumidos.\nEl número era "+ secretNum +".\n:(\n");

      //Reseteo de valores
      numMax = 0;
      numInt = 0;
      game(); //Vuelve al menú
    };
}
