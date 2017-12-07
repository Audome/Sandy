package Sandy;

import java.io.*;
import java.util.ArrayList;

public class Sandy {
  public static String tipoCuerpo;
  public static String tiempo;
  public static String evento;
  public static String lugar;
  public static double calif;
  static Model c;
  
  public Sandy(){
    c = new Model();
  }
  public static void main(String[] args) throws IOException {
      Interfaz f = new Interfaz(); 
      f.setVisible (true); 
      ArrayList<Vestido>  lista;
      Vestido v; Diseño d;
      calif = 0;
     //aquí pondremos los valores de las etiquetas
      String tc = "Pera", t = "Dia", ev = "Boda", l = "Salon", cc = "Azul";
        //los porcentajes van de 0, 25, 50, 75 y 100
      int porOriginal = 65, porCoincidencia = 0;
      
      System.out.println("Comenzando la ejecución");
        //aquí empieza la ejecución de Sandy
      Etiqueta e = new Etiqueta(tipoCuerpo, tiempo, evento, lugar, cc);
        //primero llama a buscar
        //System.out.println("Buscando coincidencias");
      lista = c.buscar(e, porCoincidencia);      
        //luego reusar. Reusar elige el vestido Base y le hace las modificaciones necesarias
      d = c.reusar(e, lista);
        //luego llama evaluar
      //System.out.println(d.vestido.toString());
      calif = c.evaluar(d);
      System.out.println("Final: " + calif);
        //finalmente llama guardar. Guardar decide si lo guarda o no
        //c.guardar(d);
  }

}
