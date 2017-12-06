/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandy;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author ADRIANA
 */
public class Sandy {

  static Model m;

  private static void guardar(Vestido v, Etiqueta e) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public Sandy() {
    m = new Model();
  }

  public static void main(String[] args) {
    ArrayList lista;
    Vestido v;
    int calif = 0;
    //aquí pondremos los valores de las etiquetas
    String tc = "", t = "", ev = "", l = "";
    //van de 1 a 100
    int porOriginal = 65, porCoincidencia = 50;

    //aquí empieza la ejecución de Sandy
    Etiqueta e = new Etiqueta(tc, t, ev, l);
    //primero llama a buscar
    //System.out.println("Buscando coincidencias");
    lista = m.buscar(e);
    //luego reusar
    v = m.reusar(e, lista);
    //luego llama evaluar
    calif = m.evaluar(v);
    //finalmente llama guardar. Guardar decide si lo guarda o no
    guardar(v, e);

  }

}
