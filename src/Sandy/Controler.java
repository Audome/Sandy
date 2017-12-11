/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Audome
 */
public class Controler implements ActionListener {

  public Ventana ver;
  public Model c;

  public Controler(Ventana v1) {
    c = new Model();
    ver = v1;
    ver.escuchaBotonP1(this);
    ver.escuchaBotonP2(this);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    Etiqueta e;
    ArrayList<Vestido> lista;
    Vestido v;
    Diseño d;
    double calif = 0;
    //los porcentajes van de 0, 25, 50, 75 y 100
    int porOriginal = 65, porCoincidencia = 0;
    String tc, t, ev, l, co;
    switch (ae.getActionCommand()) {
      case "Crear":
        if ((ver.comboTypesList.getSelectedIndex() != 0) && (ver.comboTypesList2.getSelectedIndex() != 0)
                && (ver.comboTypesList3.getSelectedIndex() != 0) && (ver.comboTypesList4.getSelectedIndex() != 0)) {
          tc = (String) ver.comboTypesList.getSelectedItem();
          t = (String) ver.comboTypesList1.getSelectedItem();
          ev = (String) ver.comboTypesList2.getSelectedItem();
          l = (String) ver.comboTypesList3.getSelectedItem();
          co = (String) ver.comboTypesList4.getSelectedItem();
          //aquí empieza la ejecución de Sandy
          e = new Etiqueta(tc, t, ev, l, co);
          try {
            ver.resultArea.append("Comenzando la ejecución\n");
            //primero llama a buscar
            //System.out.println("Buscando coincidencias");
            lista = c.buscar(e, porCoincidencia);
            //luego reusar. Reusar elige el vestido Base y le hace las modificaciones necesarias
            d = c.reusar(e, lista, ver.resultArea);
            //luego llama evaluar
            //System.out.println(d.vestido.toString());
            calif = c.evaluar(d, ver.resultArea);
            ver.resultArea.append("Final: " + calif + "\n\n");
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error");
          }
          //System.out.println("Final: " + calif);
          //finalmente llama guardar. Guardar decide si lo guarda o no
          //c.guardar(d);
        } else {
          JOptionPane.showMessageDialog(null, "Campos sin seleccionar");
        }
        break;
      case "Reintentar":
        if ((ver.comboTypesList.getSelectedIndex() != 0) && (ver.comboTypesList2.getSelectedIndex() != 0)
                && (ver.comboTypesList3.getSelectedIndex() != 0) && (ver.comboTypesList4.getSelectedIndex() != 0)) {
          tc = (String) ver.comboTypesList.getSelectedItem();
          t = (String) ver.comboTypesList1.getSelectedItem();
          ev = (String) ver.comboTypesList2.getSelectedItem();
          l = (String) ver.comboTypesList3.getSelectedItem();
          co = (String) ver.comboTypesList4.getSelectedItem();
          //aquí empieza la ejecución de Sandy
          e = new Etiqueta(tc, t, ev, l, co);
          ver.resultArea.append("+++++++++++++++++++++++++++\n");
          ver.resultArea.append("Comenzando de nuevo\n");
          try {
            //primero llama a buscar
            //System.out.println("Buscando coincidencias");
            lista = c.buscar(e, porCoincidencia);
            //luego reusar. Reusar elige el vestido Base y le hace las modificaciones necesarias
            d = c.reusar(e, lista, ver.resultArea);
            //luego llama evaluar
            //System.out.println(d.vestido.toString());
            calif = c.evaluar(d, ver.resultArea);
            ver.resultArea.append("Final: " + calif + "\n\n");
          } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error");
          }
          //finalmente llama guardar. Guardar decide si lo guarda o no
          //c.guardar(d);
        }else {
          JOptionPane.showMessageDialog(null, "Campos sin seleccionar");
        }
        break;
    }
  }
}
