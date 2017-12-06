/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Audome
 */
public class Model {

  public Model() {

  }

  public ArrayList buscar(Etiqueta e, int coin) throws IOException {
    ArrayList<Vestido> lista = new ArrayList();
    FileInputStream fin = new FileInputStream("Vestidos.txt");
    ObjectInputStream ois = new ObjectInputStream(fin);
    try {
      Object aux = ois.readObject();
      while (aux != null) {
        int total = 0;
        Diseño temp = (Diseño) aux;
        Etiqueta etiqueta = temp.getEtiqueta();
        if (e.tipoC == etiqueta.getTipoC()) {
          total = total + 30;
        }
        if (e.evento == etiqueta.getEvento()) {
          total = total + 20;
        }
        if (e.lugar == etiqueta.getLugar()) {
          total = total + 20;
        }
        if (e.tiempo == etiqueta.getTiempo()) {
          total = total + 20;
        }
        if (e.color == etiqueta.getColor()) {
          total = total + 10;
        }
        if (total >= coin) {
          lista.add(temp.getVestido());
        }
        aux = ois.readObject();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }finally{
      ois.close();
    }
    return lista;
  }

  public Vestido reusar(Etiqueta l, ArrayList lista) {
    Vestido v = new Vestido();

    return v;
  }

  public Vestido cambiarPieza(Vestido vB, int num, ArrayList lista) {
    Vestido v = new Vestido();
    int tam = lista.size();
    int a = (int) (Math.random() * tam) + 1;
    switch (num) {
      //top
      case 0:
        break;
      //falda
      case 1:
        break;
      //escote
      case 2:
        break;
      //manga
      case 3:
        break;
      //falda
      case 4:
        break;
      //largo falda
      case 5:
        break;
      //Tela
      case 6:
        break;
      //Decoración
      case 7:
        break;
    }

    return v;
  }

  int evaluar(Vestido v) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public double revisar(Vestido vestidoBase) throws IOException{
    boolean flag = true;
    double coincidenciaActual = 0;
    coincidenciaActual = coincidenciaActual + diseño(vestidoBase);
    coincidenciaActual = coincidenciaActual + originalidad(vestidoBase);
    return coincidenciaActual;
  }

  public void guardar(Diseño e) {
    try {
      FileOutputStream fileout = new FileOutputStream("Vestidos.txt", true);
      ObjectOutputStream oos = new ObjectOutputStream(fileout);
      oos.writeObject(e);
      oos.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public double diseño(Vestido vestidoBase) {
    double diseño = 0;

    return diseño;
  }

  public double originalidad(Vestido vestidoBase) throws IOException {
    double originalidad = 0;
    FileInputStream fin = new FileInputStream("Vestidos.txt");
    ObjectInputStream ois = new ObjectInputStream(fin);
    try {
      Object aux = ois.readObject();
      while (aux != null) {
        double suma = 0;
        Diseño temp = (Diseño) aux;
        Vestido vestido = temp.getVestido();
        if (vestidoBase.tiro == vestido.getTiro()) {
          suma = suma + 0.8;
        }
        if (vestidoBase.escote == vestido.getEscote()) {
          suma = suma + 0.8;
        }
        if (vestidoBase.mangas == vestido.getMangas()) {
          suma = suma + 0.8;
        }
        if (vestidoBase.falda == vestido.getFalda()) {
          suma = suma + 0.8;
        }
        if (vestidoBase.largoF == vestido.getLargoF()) {
          suma = suma + 0.8;
        }
        if (vestidoBase.decoracion == vestido.getDecoracion()) {
          suma = suma + 0.8;
        }
        if (suma > originalidad) {
          originalidad = suma;
        }
        aux = ois.readObject();
      }

      ois.close();

    } catch (Exception ex) {
      ex.printStackTrace();
    }

    return originalidad;
  }
}
