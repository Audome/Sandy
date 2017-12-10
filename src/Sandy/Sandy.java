package Sandy;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Sandy {

  public void ventana(Ventana pm1, Container c) {
    c.setLayout(new GridLayout());
    c.add(pm1);
  }

  public static void main(String[] args) {
    Sandy sandy = new Sandy();
    Ventana pm1 = new Ventana();
    Controler controla = new Controler(pm1);
    JFrame frame = new JFrame("Sandy");
    sandy.ventana(pm1, frame);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(550, 400);
    frame.setVisible(true);
  }
}