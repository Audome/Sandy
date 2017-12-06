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

   public Diseño reusar(Etiqueta l, ArrayList<Vestido>  lista){
        Diseño d;
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
        v = coordinar(v,l);
        if(l.getTiempo() == "dia"){
            v = dia(v,l);
        }
        else{
            v = noche(v,l);
        }
        d = new Diseño(v, l);
        return d;
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
            case 5:
                vB.setTiro(r.getTiro());
                break;
                //Tiro
        }
        
        return vB;
    }
  
  public Vestido dia(Vestido v, Etiqueta e){
    int a;
    //preguntar si falda es larga
    if(checarEstilo(0,v) == 1)
        v = cambiarEstilo(0,v,0);
    //preguntar si manga es larga
    if(checarEstilo(2,v) == 1)
        v = cambiarEstilo(2,v,0);
    //preguntar si escote es cerrado
    if(checarEstilo(1,v) == 1)
        v = cambiarEstilo(1,v,0);
    //tono = 1; <- es claro
    switch(e.getEvento()){
        case "Boda":            
            if(checarEstilo(0,v) != 0)
                v = cambiarEstilo(0,v,0);
            if(!v.getDecoracion().equals("Encaje")||!v.getDecoracion().equals("Sin")){
                a = (int) (Math.random() * 2);
                if(a == 1) v.setDecoracion("Encaje");
                else v.setDecoracion("Sin");
            }
            if(!v.getLargoF().equals("Rodilla")||v.getLargoF().equals("Tobillo")){
                a = (int) (Math.random() * 2);
                if(a == 1) v.setLargoF("Rodilla");
                else v.setLargoF("Tobillo");
            }
            break;
        case "XV":
            if(checarEstilo(0,v) != 1)
                v = cambiarEstilo(0,v,1);
            if(!v.getLargoF().equals("Rodilla")||v.getLargoF().equals("ARodilla")){
                a = (int) (Math.random() * 2);
                if(a == 1) v.setLargoF("Rodilla");
                else v.setLargoF("ARodilla");
            }
            break;
    }
      return v;
  }
  
  public Vestido noche(Vestido v, Etiqueta e){
    int a;
    //preguntar si falda es corta
    if(checarEstilo(3,v) == 0)
        v = cambiarEstilo(3,v,1);
    //tono = 0; <- es oscuro
    switch(e.getEvento()){
        case "Boda":            
            if(!v.getDecoracion().equals("Aplicaciones")||!v.getDecoracion().equals("Sin")||!v.getDecoracion().equals("AberturaP")){
                a = (int) (Math.random() * 3);
                switch(a){
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
            switch(e.getLugar()){
                case "Salon":
                    if(!v.getLargoF().equals("Largo")||v.getLargoF().equals("Tobillo")){
                        a = (int) (Math.random() * 2);
                        if(a == 1) v.setLargoF("Largo");
                        else v.setLargoF("Tobillo");
                    }
                    break;
                case "Playa":
                    v.setDecoracion("Tobillo");
                    break;
            }
            break;
        case "XV":
            if(!v.getDecoracion().equals("Aplicaciones")||!v.getDecoracion().equals("Sin")||!v.getDecoracion().equals("Moño")){
                a = (int) (Math.random() * 3);
                switch(a){
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
                switch(e.getLugar()){
                case "Salon":
                    if(!v.getLargoF().equals("Largo")||!v.getLargoF().equals("Tobillo")||!v.getLargoF().equals("Rodilla")){
                         a = (int) (Math.random() * 3);
                        switch(a){
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
                    if(!v.getLargoF().equals("Tobillo")||!v.getLargoF().equals("Rodilla")){
                         a = (int) (Math.random() * 2);
                        switch(a){
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
            
            if(checarEstilo(0,v) != 1)
                v = cambiarEstilo(0,v,1);
            if(!v.getLargoF().equals("Rodilla")||v.getLargoF().equals("ARodilla")){
                a = (int) (Math.random() * 2);
                if(a == 1) v.setLargoF("Rodilla");
                else v.setLargoF("ARodilla");
            }
            break;
        }
    }
      return v;
  }
  

  public double evaluar(Diseño vestidoBase) throws IOException{
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

  public double diseño(Diseño vB) {
    double diseño = 0;
    
    return diseño;
  }
  
  private Vestido coordinar(Vestido vB, Etiqueta e) {
        Vestido v = vB;
        int valor;
        if(e.getTipoC() == "Pera"){
            //menos en falda, checa si falda es -
            valor = checarEstilo(0, v);
            //si no, cambia estilo
            if(valor != 0){
                v.setFalda(cambiarEstilo(0,v,0).getFalda());
            }
        }
        else{
            //Sólo si es ++
            if(checarEstilo(0,v) == 1 && checarEstilo(2,v) == 1){
                int a = (int) (Math.random() * 2);
                //si es 0 cambia falda, si es 1, cambia mangas
                if(a == 0)
                    v.setFalda(cambiarEstilo(0,v,0).getFalda());
                else
                    v.setMangas(cambiarEstilo(2,v,1).getMangas());             
            }
        }        
        return v;
    
  }
  
  private int checarEstilo(int p, Vestido vB){
          int e = 0;
          switch(p){
            case 0:
                //falda amplia?
                if(vB.getFalda().equals("Circular")||vB.getFalda().equals("Doble circular")||vB.getFalda().equals("Godette")
                        ||vB.getFalda().equals("Plisada")||vB.getFalda().equals("Tableada")||vB.getFalda().equals("Sirena"))
                    e = 1;
                else
                    e = 0;
                break;          
            case 1:
                //escote abierto?
                if(vB.getEscote().equals("V")||vB.getEscote().equals("Redondo")||vB.getEscote().equals("Corazon")||
                        vB.getEscote().equals("Recto")||vB.getEscote().equals("HCaidos"))
                    e = 1;
                else
                    e = 0;
                break;            
            case 2:
                if(vB.getMangas().equals("Strapless")||vB.getMangas().equals("Tirantes")||vB.getMangas().equals("Sin"))
                    e = 0;
                else
                    e = 1;
                break;
            //sin manga?
            case 3:
                if(vB.getLargoF().equals("Largo")||vB.getLargoF().equals("Tobillo"))
                    e = 1;
                else
                    e = 0;
                break;
            //falda larga?
            case 4:
                break;
            //Decoración
            case 5:
                if(vB.getTiro().equals("Alto"))
                    e = 0;
                else if(vB.getTiro().equals("Medio"))
                    e = 1;
                else if(vB.getTiro().equals("Bajo"))
                    e =2;
                break;
                //Tiro
          }
          return e;
    }
  
    private Vestido cambiarEstilo(int parte, Vestido vB, int estilo){
          
          return vB;
    }


  public double originalidad(Diseño vestidoBase) throws IOException {
    double originalidad = 0;
    FileInputStream fin = new FileInputStream("Vestidos.txt");
    ObjectInputStream ois = new ObjectInputStream(fin);
    try {
      Object aux = ois.readObject();
      Vestido vB = vestidoBase.getVestido();
      while (aux != null) {
        double suma = 0;
        Diseño temp = (Diseño) aux;
        Vestido vestido = temp.getVestido();
        if (vB.tiro == vestido.getTiro()) {
          suma = suma + 0.8;
        }
        if (vB.escote == vestido.getEscote()) {
          suma = suma + 0.8;
        }
        if (vB.mangas == vestido.getMangas()) {
          suma = suma + 0.8;
        }
        if (vB.falda == vestido.getFalda()) {
          suma = suma + 0.8;
        }
        if (vB.largoF == vestido.getLargoF()) {
          suma = suma + 0.8;
        }
        if (vB.decoracion == vestido.getDecoracion()) {
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
