package Sandy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Audome
 */
public class Vestido {

  String top, falda, escote, mangas, largoF, tela, decoracion;

  public Vestido(Vestido base) {
    top = base.getTop();
    falda = base.getFalda();
    largoF = base.getLargoF();
    escote = base.getEscote();
    mangas = base.getMangas();
    tela = base.getTela();
    decoracion = base.getDecoracion();
  }

  public String getEscote() {
    return escote;
  }

  public String getDecoracion() {
    return decoracion;
  }

  public String getFalda() {
    return falda;
  }

  public String getLargoF() {
    return largoF;
  }

  public String getMangas() {
    return mangas;
  }

  public String getTela() {
    return tela;
  }

  public String getTop() {
    return top;
  }

  public void setEscote(String escote) {
    this.escote = escote;
  }

  public void setDecoracion(String decoracion) {
    this.decoracion = decoracion;
  }

  public void setFalda(String falda) {
    this.falda = falda;
  }

  public void setLargoF(String largoF) {
    this.largoF = largoF;
  }

  public void setMangas(String mangas) {
    this.mangas = mangas;
  }

  public void setTela(String tela) {
    this.tela = tela;
  }

  public void setTop(String top) {
    this.top = top;
  }

  @Override
  public String toString() {
    return super.toString(); //To change body of generated methods, choose Tools | Templates.
  }
}
