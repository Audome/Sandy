package Sandy;

import java.io.*;
import java.util.ArrayList;

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

   public Vestido reusar(Etiqueta l, ArrayList<Vestido>  lista){
        //elige vestido base
        int a = (int) (Math.random() * lista.size());
        Vestido v = lista.get(a);        
        //elige la parte esencial del vestido
        if("Reloj".equals(l.getTipoC())){
            a = (int) (Math.random() * 2);
            cambiarPieza(v, a, lista);
        }
        else{
            cambiarPieza(v, 1, lista);
        }
        //modifica ligeramente el vestido
        for(int i = 0; i < 1; i++){
            a = (int) (Math.random() * 3) + 2;
            cambiarPieza(v, a, lista);
        }
        //realiza readaptación
        return v;
    }

  public Vestido cambiarPieza(Vestido vB, int num,ArrayList<Vestido> lista){        
        int a = (int) (Math.random() * lista.size());
        Vestido r = lista.get(a);
        switch(num){
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
        }
        
        return vB;
    }
  
  

  public double evaluar(Vestido vestidoBase) throws IOException{
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
