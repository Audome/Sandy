/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandy;

import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Audome
 */
public class Ventana extends JPanel {

  JButton b1, b2;
  JTextArea resultArea;
  JComboBox comboTypesList, comboTypesList1, comboTypesList2, comboTypesList3, comboTypesList4;

  public Ventana() {
    crear();
  }

  public void crear() {
    JPanel a = new JPanel();
    JPanel b = new JPanel();
    JPanel c = new JPanel();
    JPanel d = new JPanel();
    JPanel e = new JPanel();
    JPanel f = new JPanel();
    JPanel g = new JPanel();
    JLabel jlb = new JLabel("Tipo Cuerpo");
    String[] comboTypes = {"Seleccionar opción", "Reloj", "Pera"};
    comboTypesList = new JComboBox(comboTypes);
    comboTypesList.setSelectedIndex(0);
    a.add(jlb);
    a.add(comboTypesList);

    jlb = new JLabel("Tiempo");
    String[] comboTypes1 = {"Seleccionar opción", "Día", "Noche"};
    comboTypesList1 = new JComboBox(comboTypes1);
    comboTypesList1.setSelectedIndex(0);
    b.add(jlb);
    b.add(comboTypesList1);

    jlb = new JLabel("Evento");
    String[] comboTypes2 = {"Seleccionar opción", "Boda", "XV"};
    comboTypesList2 = new JComboBox(comboTypes2);
    comboTypesList2.setSelectedIndex(0);
    c.add(jlb);
    c.add(comboTypesList2);

    jlb = new JLabel("Lugar");
    String[] comboTypes3 = {"Seleccionar opción", "Salón", "Playa"};
    comboTypesList3 = new JComboBox(comboTypes3);
    comboTypesList3.setSelectedIndex(0);
    d.add(jlb);
    d.add(comboTypesList3);

    jlb = new JLabel("Color");
    String[] comboTypes4 = {"Seleccionar opción", "Blanco", "Negro", "Rojo",
      "Rosa", "Azul", "Verde", "Amarillo"};
    comboTypesList4 = new JComboBox(comboTypes4);
    comboTypesList4.setSelectedIndex(0);
    e.add(jlb);
    e.add(comboTypesList4);

    resultArea = new JTextArea(20, 25);
    JScrollPane scrollingArea = new JScrollPane(resultArea);
    b1 = new JButton("Crear");
    b2 = new JButton("Reintentar");
    f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
    g.setLayout(new BoxLayout(g, BoxLayout.X_AXIS));
    f.add(a);
    f.add(b);
    f.add(c);
    f.add(d);
    f.add(e);
    g.add(f);
    g.add(scrollingArea);
    add(g);
    add(b1);
    add(b2);
  }

  public void escuchaBotonP1(ActionListener ae) {
    b1.setActionCommand("Crear");
    b1.addActionListener(ae);
  }

  public void escuchaBotonP2(ActionListener ae) {
    b2.setActionCommand("Reintentar");
    b2.addActionListener(ae);
  }
}
