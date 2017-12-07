package Sandy;

import java.io.*;
import java.util.ArrayList;

public class Sandy {

  static Controlador c;
  
  public Sirve(){
    c = new Model();
  }
  public static void main(String[] args) throws IOException {
      ArrayList<Vestido>  lista;
      Vestido v; Diseño d;
      double calif = 0;
     //aquí pondremos los valores de las etiquetas
      String tc = "Pera", t = "Dia", ev = "Boda", l = "Salon", cc = "Azul";
        //los porcentajes van de 0, 25, 50, 75 y 100
      int porOriginal = 65, porCoincidencia = 0;
      
      System.out.println("Comenzando la ejecución");
        //aquí empieza la ejecución de Sandy
      Etiqueta e = new Etiqueta(tc, t, ev, l, cc);
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
