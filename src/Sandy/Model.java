package Sandy;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Model {

  public Model() { }

  public ArrayList buscar(Etiqueta e, int coin) throws Exception {
    ArrayList<Vestido> lista = new ArrayList();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader("Vestidos.txt"));
      String line = "";
      while ((line = br.readLine()) != null) {
        int total = 0;
        String[] partes = line.split(",");
        //System.out.println(partes.length);
        //System.out.println(partes[i]);
        if (partes.length > 1) {
          if (e.tipoC.equals(partes[0])) {
            total = total + 30;
          }
          if (e.evento.equals(partes[1])) {
            total = total + 20;
          }
          if (e.lugar.equals(partes[2])) {
            total = total + 20;
          }
          if (e.tiempo.equals(partes[3])) {
            total = total + 20;
          }
          if (e.color.equals(partes[4])) {
            total = total + 10;
          }
          if (total >= coin) {
            Vestido v = new Vestido(partes[5], partes[6], partes[7], partes[8], partes[9], partes[10]);
            lista.add(v);
            //System.out.print(v.toString());
          }
        }
      }
      br.close();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,"Error al leer BD");
    } 
    return lista;
  }

  public Diseño reusar(Etiqueta l, ArrayList<Vestido> lista, JTextArea resultArea) {
    Diseño d;
    //elige vestido base
    int a = (int) (Math.random() * lista.size());
    Vestido v = lista.get(a);
    resultArea.append("Primer vestido: \n" + v.toString());
    //elige la parte esencial del vestido
    if ("Reloj".equals(l.getTipoC())) {
      //a = (int) (Math.random() * 2);
      v = cambiarPieza(v, 1, lista);
    } else {
      v = cambiarPieza(v, 2, lista);
    }
    //modifica ligeramente el vestido
    for (int i = 0; i < 4; i++) {
      a = ((int) (Math.random() * 3)) + 2;
      //a = ((int) (Math.random() * 5)) + 1;
      v = cambiarPieza(v, a, lista);
      // System.out.println(i+" \n" + v.toString());
    }
    //realiza readaptación             
    if (l.getTiempo() == "dia") {
      v = dia(v, l);
    } else {
      v = noche(v, l);
    }
    v = coordinar(v, l);
    resultArea.append(v.toString());
    d = new Diseño(v, l);
    return d;
  }

  public static Vestido cambiarPieza(Vestido vB, int num, ArrayList<Vestido> lista) {
    int a = (int) (Math.random() * lista.size());
    Vestido r = lista.get(a);
    //System.out.println("Tam: " + lista.size() + " Num:"+num + "\nVestidoAzar"+ r.toString()+"\nVestidoOriginal: " + vB.toString());

    switch (num) {
      case 0:
        vB.setFalda(r.getFalda());
        break;
      //falda
      case 1:
        vB.setEscote(r.getEscote());
        break;
      //escote
      case 2:
        vB.setMangas(r.getMangas());
        break;
      //manga
      case 3:
        vB.setLargoF(r.getLargoF());
        break;
      //largo falda
      case 4:
        vB.setDecoracion(r.getDecoracion());
        break;
      //Decoración
      case 5:
        vB.setTiro(r.getTiro());
        break;
      //Tiro
    }
    return vB;
  }

  private static Vestido coordinar(Vestido vB, Etiqueta e) {
    Vestido v = vB;
    int valor;
    if (e.getTipoC().equals("Pera")) {
      //menos en falda, checa si falda es -
      valor = checarEstilo(0, v);
      //si no, cambia estilo
      if (valor != 0) {
        v.setFalda(cambiarEstilo(0, v, 0).getFalda());
      }
    } else//Sólo si es ++
     if (checarEstilo(0, v) == 1 && checarEstilo(2, v) == 1) {
        int a = (int) (Math.random() * 2);
        //si es 0 cambia falda, si es 1, cambia mangas
        if (a == 0) {
          v.setFalda(cambiarEstilo(0, v, 0).getFalda());
        } else {
          v.setMangas(cambiarEstilo(2, v, 1).getMangas());
        }
      }
    return v;
  }

  public static Vestido dia(Vestido v, Etiqueta e) {
    int a;
    //preguntar si falda es larga
    if (checarEstilo(0, v) == 1) {
      v = cambiarEstilo(0, v, 0);
    }
    //preguntar si manga es larga
    if (checarEstilo(2, v) == 1) {
      v = cambiarEstilo(2, v, 0);
    }
    //preguntar si escote es cerrado
    if (checarEstilo(1, v) == 1) {
      v = cambiarEstilo(1, v, 0);
    }
    //tono = 1; <- es claro
    switch (e.getEvento()) {
      case "Boda":
        if (checarEstilo(0, v) != 0) {
          v = cambiarEstilo(0, v, 0);
        }
        if (!v.getDecoracion().equals("Encaje") || !v.getDecoracion().equals("Sin")) {
          a = (int) (Math.random() * 2);
          if (a == 1) {
            v.setDecoracion("Encaje");
          } else {
            v.setDecoracion("Sin");
          }
        }
        if (!v.getLargoF().equals("Rodilla") || v.getLargoF().equals("Tobillo")) {
          a = (int) (Math.random() * 2);
          if (a == 1) {
            v.setLargoF("Rodilla");
          } else {
            v.setLargoF("Tobillo");
          }
        }
        break;
      case "XV":
        if (checarEstilo(0, v) != 1) {
          v = cambiarEstilo(0, v, 1);
        }
        if (!v.getLargoF().equals("Rodilla") || v.getLargoF().equals("ARodilla")) {
          a = (int) (Math.random() * 2);
          if (a == 1) {
            v.setLargoF("Rodilla");
          } else {
            v.setLargoF("ARodilla");
          }
        }
        break;
    }
    return v;
  }

  public static Vestido noche(Vestido v, Etiqueta e) {
    int a;
    //preguntar si falda es corta
    if (checarEstilo(3, v) == 0) {
      v = cambiarEstilo(3, v, 1);
    }
    //tono = 0; <- es oscuro
    switch (e.getEvento()) {
      case "Boda":
        if (!v.getDecoracion().equals("Aplicaciones") || !v.getDecoracion().equals("Sin") || !v.getDecoracion().equals("AberturaP")) {
          a = (int) (Math.random() * 3);
          switch (a) {
            case 0:
              v.setDecoracion("Sin");
              break;
            case 1:
              v.setDecoracion("Aplicaciones");
              break;
            case 2:
              v.setDecoracion("AberturaP");
              break;
          }
        }
        switch (e.getLugar()) {
          case "Salon":
            if (!v.getLargoF().equals("Largo") || v.getLargoF().equals("Tobillo")) {
              a = (int) (Math.random() * 2);
              if (a == 1) {
                v.setLargoF("Largo");
              } else {
                v.setLargoF("Tobillo");
              }
            }
            break;
          case "Playa":
            v.setDecoracion("Tobillo");
            break;
        }
        break;
      case "XV":
        if (!v.getDecoracion().equals("Aplicaciones") || !v.getDecoracion().equals("Sin") || !v.getDecoracion().equals("Moño")) {
          a = (int) (Math.random() * 3);
          switch (a) {
            case 0:
              v.setDecoracion("Sin");
              break;
            case 1:
              v.setDecoracion("Aplicaciones");
              break;
            case 2:
              v.setDecoracion("Moño");
              break;
          }
          switch (e.getLugar()) {
            case "Salon":
              if (!v.getLargoF().equals("Largo") || !v.getLargoF().equals("Tobillo") || !v.getLargoF().equals("Rodilla")) {
                a = (int) (Math.random() * 3);
                switch (a) {
                  case 0:
                    v.setLargoF("Largo");
                    break;
                  case 1:
                    v.setLargoF("Tobillo");
                    break;
                  case 2:
                    v.setLargoF("Rodilla");
                    break;
                }
              }
              break;
            case "Playa":
              if (!v.getLargoF().equals("Tobillo") || !v.getLargoF().equals("Rodilla")) {
                a = (int) (Math.random() * 2);
                switch (a) {
                  case 0:
                    v.setLargoF("Tobillo");
                    break;
                  case 1:
                    v.setLargoF("Rodilla");
                    break;
                }
              }
              break;
          }

          if (checarEstilo(0, v) != 1) {
            v = cambiarEstilo(0, v, 1);
          }
          if (!v.getLargoF().equals("Rodilla") || v.getLargoF().equals("ARodilla")) {
            a = (int) (Math.random() * 2);
            if (a == 1) {
              v.setLargoF("Rodilla");
            } else {
              v.setLargoF("ARodilla");
            }
          }
          break;
        }
    }
    return v;
  }

  private static int checarEstilo(int p, Vestido vB) {
    int e = 0;
    switch (p) {
      case 0:
        //falda amplia?
        if (vB.getFalda().equals("Circular") || vB.getFalda().equals("Doble circular") || vB.getFalda().equals("Godette")
            || vB.getFalda().equals("Plisada") || vB.getFalda().equals("Tableada") || vB.getFalda().equals("Sirena")) {
          e = 1;
        }
        break;
      case 1:
        //escote abierto?
        if (vB.getEscote().equals("V") || vB.getEscote().equals("Redondo") || vB.getEscote().equals("Corazon")
            || vB.getEscote().equals("Recto") || vB.getEscote().equals("HCaidos")) {
          e = 1;
        }
        break;
      case 2:
        if (!(vB.getMangas().equals("Strapless") || vB.getMangas().equals("Tirantes") || vB.getMangas().equals("Sin"))) {
          e = 1;
        }
        break;
      //sin manga?
      case 3:
        if (vB.getLargoF().equals("Largo") || vB.getLargoF().equals("Tobillo")) {
          e = 1;
        }
        break;
      //falda larga?
      case 4:
        break;
      //Decoración
      case 5:
        if (vB.getTiro().equals("Medio")) {
          e = 1;
        }
        break;
    }
    return e;
  }

  private static Vestido cambiarEstilo(int parte, Vestido v, int estilo) {
    int a;
    switch (parte) {
      case 0:
        //falda 
        if (estilo == 0) {
          a = (int) (Math.random() * 4);
          switch (a) {
            case 0:
              v.setFalda("Recta");
              break;
            case 1:
              v.setFalda("Lapiz");
              break;
            case 2:
              v.setFalda("A");
              break;
            case 3:
              v.setFalda("Tulipan");
              break;
          }
        } else {
          a = (int) (Math.random() * 6);
          switch (a) {
            case 0:
              v.setFalda("Circular");
              break;
            case 1:
              v.setFalda("DCircular");
              break;
            case 2:
              v.setFalda("Godette");
              break;
            case 3:
              v.setFalda("Plisada");
              break;
            case 4:
              v.setFalda("Tableada");
              break;
            case 5:
              v.setFalda("Sirena");
              break;
          }
        }
        break;
      case 1:
        //escote abierto
        if (estilo == 0) {
          a = (int) (Math.random() * 6);
          switch (a) {
            case 0:
              v.setEscote("V");
              break;
            case 1:
              v.setEscote("Redondo");
              break;
            case 2:
              v.setEscote("Corazon");
              break;
            case 3:
              v.setEscote("Recto");
              break;
            case 4:
              v.setEscote("HCaidos");
              break;
          }
        } else {
          a = (int) (Math.random() * 6);
          switch (a) {
            case 0:
              v.setEscote("Halter");
              break;
            case 1:
              v.setEscote("Asimetrico");
              break;
            case 2:
              v.setEscote("Ilusion");
              break;
            case 3:
              v.setEscote("Alto");
              break;
            case 4:
              v.setEscote("Jewel");
              break;
          }
        }
        break;
      case 2:
        //manga sin
        if (estilo == 0) {
          a = (int) (Math.random() * 3);
          switch (a) {
            case 0:
              v.setMangas("Sin");
              break;
            case 1:
              v.setMangas("Tirantes");
              break;
            case 2:
              v.setMangas("Strapless");
              break;
          }
        } else {
          a = (int) (Math.random() * 4);
          switch (a) {
            case 0:
              v.setMangas("Cap");
              break;
            case 1:
              v.setMangas("Codo");
              break;
            case 2:
              v.setMangas("3/4");
              break;
            case 3:
              v.setMangas("Larga");
              break;
          }
        }
        break;
      case 3:
        //largo f
        if (estilo == 0) {
          a = (int) (Math.random() * 2);
          switch (a) {
            case 0:
              v.setLargoF("ARodilla");
              break;
            case 1:
              v.setLargoF("Rodilla");
              break;
          }
        } else {
          a = (int) (Math.random() * 2);
          switch (a) {
            case 0:
              v.setLargoF("Tobillo");
              break;
            case 1:
              v.setLargoF("Largo");
              break;
          }
        }
        break;
      case 4:
        //Decoración
        a = (int) (Math.random() * 10);
        switch (a) {
          case 0:
            v.setDecoracion("Aplicacion_escote");
            break;
          case 1:
            v.setDecoracion("Aplicacion_cintura");
            break;
          case 2:
            v.setDecoracion("Aplicacion_falda");
            break;
          case 3:
            v.setDecoracion("Encaje_escote");
            break;
          case 4:
            v.setDecoracion("Encaje_mangas");
            break;
          case 5:
            v.setDecoracion("Encaje_blusa");
            break;
          case 6:
            v.setDecoracion("Encaje_falda");
            break;
          case 7:
            v.setDecoracion("Moño_cintura");
            break;
          case 8:
            v.setDecoracion("Sin");
            break;
          case 9:
            v.setDecoracion("Abertura");
            break;
        }
        break;
      case 5:
        //Tiro
        a = (int) (Math.random() * 2);
        switch (a) {
          case 0:
            v.setTiro("Alto");
            break;
          case 1:
            v.setTiro("Medio");
            break;
        }
        break;
    }
    return v;
  }

  public double evaluar(Diseño vestidoBase, JTextArea resultArea) throws IOException {
    double coincidenciaActual = 0;
    coincidenciaActual = coincidenciaActual + diseño(vestidoBase, resultArea);
    coincidenciaActual = coincidenciaActual + originalidad(vestidoBase, resultArea);
    return coincidenciaActual;
  }

  public static double diseño(Diseño vB, JTextArea resultArea) {
    double total = 0;
    if (vB.etiqueta.tipoC.equals("Pera")) {
      if (vB.vestido.escote.equals("HCaido") || vB.vestido.escote.equals("Asimetrico")
          || vB.vestido.escote.equals("Ilusion") || vB.vestido.escote.equals("Jewel")) {
        total++;

      }
      if (checarEstilo(2, vB.vestido) == 1) {
        total++;
      }
      if (checarEstilo(0, vB.vestido) == 0) {
        total++;
      }
      if (vB.vestido.decoracion.equals("Aplicacion_escote") || vB.vestido.decoracion.equals("Encaje_escote")
          || vB.vestido.decoracion.equals("Emcaje_mangas") || vB.vestido.decoracion.equals("Encaje_top")) {
        total++;
      }
    } else {
      if (checarEstilo(5, vB.vestido) == 0) {
        total++;
      }
      if (vB.vestido.falda.equals("Lapiz") || vB.vestido.falda.equals("Tubo")) {
        total++;
      }
      if ((checarEstilo(0, vB.vestido) == 1 && (checarEstilo(2, vB.vestido) == 0))
          || (checarEstilo(0, vB.vestido) == 0 && (checarEstilo(2, vB.vestido) == 1))
          || (checarEstilo(0, vB.vestido) == 0 && (checarEstilo(2, vB.vestido) == 0))) {
        total++;
      }
    }
    resultArea.append("Diseño: " + total + "\n");
    return total;
  }

  public static double originalidad(Diseño vestidoBase, JTextArea resultArea) throws IOException {
    double originalidad = 0;
    BufferedReader br = new BufferedReader(new FileReader("Vestidos.txt"));
    Vestido vestido = vestidoBase.getVestido();
    try {
      String line = "";
      while ((line = br.readLine()) != null) {
        String[] partes = line.split(",");
        if (partes.length > 1) {
          Vestido vB = new Vestido(partes[5], partes[6], partes[7], partes[8], partes[9], partes[10]);
          double suma = 0;

          if (vB.tiro.equals(vestido.getTiro())) {
            suma++;
          }
          if (vB.escote.equals(vestido.getEscote())) {
            suma++;
          }
          if (vB.mangas.equals(vestido.getMangas())) {
            suma++;
          }
          if (vB.falda.equals(vestido.getFalda())) {
            suma++;
          }
          if (vB.largoF.equals(vestido.getLargoF())) {
            suma++;
          }
          if (vB.decoracion.equals(vestido.getDecoracion())) {
            suma++;
          }
          if (suma > originalidad) {
            originalidad = suma;
          }
        }
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,"Error");
    } finally {
      br.close();
    }
    originalidad = 6 - originalidad;
    resultArea.append("Originalidad: " + originalidad + "\n");
    return originalidad;
  }

  public void guardar(Diseño e) throws IOException {
    BufferedWriter bw;
    try {
      bw = new BufferedWriter(new FileWriter("Vestidos.txt", true));
      String diseño = e.toString();
      //System.out.print(diseño);
      bw.append(diseño + "\n");
      bw.close();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,"No se pudo guardar");
    }
  }
}
