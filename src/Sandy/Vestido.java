package Sandy;

public class Vestido {

  String tiro, falda, escote, mangas, largoF, decoracion;

  public Vestido(String tiro, String falda, String escote, String mangas, String largoF, String decoracion) {
    this.tiro = tiro;
    this.falda = falda;
    this.escote = escote;
    this.mangas = mangas;
    this.largoF = largoF;
    this.decoracion = decoracion;
  }

  public Vestido(Vestido base) {
    tiro = base.getTiro();
    falda = base.getFalda();
    largoF = base.getLargoF();
    escote = base.getEscote();
    mangas = base.getMangas();
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

  public String getTiro() {
    return tiro;
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

  public void setTiro(String tiro) {
    this.tiro = tiro;
  }

  @Override
  public String toString() {
    return "Escote: " + getEscote() + "\n" +
        "Mangas: " + getMangas() + "\n" +
        "Falda: " + getFalda() + "\n" +
        "Tiro: " + getTiro() + "\n" +
        "Largo Falda: " + getLargoF() + "\n" +
        "Decoración: " + getDecoracion() + 
        "--------------------------------------"; //To change body of generated methods, choose Tools | Templates.
  }
}
