package Sandy;

import java.io.*;
import java.util.ArrayList;

public class Sandy {

  static Model m;

  public Sandy() {
    m = new Model();
  }

  public static void main(String[] args) {
    ArrayList<Vestido>  lista;
    Vestido v; Diseño d;
    int calif = 0;
     //aquí pondremos los valores de las etiquetas
        String tc = "", t = "", ev = "", l = "", cc = "";
        //los porcentajes van de 0, 25, 50, 75 y 100
        int porOriginal = 65, porCoincidencia = 50;
        
        //aquí empieza la ejecución de Sandy
        Etiqueta e = new Etiqueta(tc, t, ev, l, cc);
        //primero llama a buscar
        //System.out.println("Buscando coincidencias");
        lista = m.buscar(e, porCoincidencia);
        //luego reusar. Reusar elige el vestido Base y le hace las modificaciones necesarias
        v = m.reusar(e, lista);
        //luego llama evaluar
        calif = m.evaluar(v);
        //finalmente llama guardar. Guardar decide si lo guarda o no
        m.guardar(d);

  }

}
