package Sandy;

class Etiqueta {

  String tipoC;
  String tiempo;
  String evento;
  String lugar;

  public Etiqueta(String tc, String t, String ev, String l) {
    this.tipoC = tc;
    this.tiempo = t;
    this.evento = ev;
    this.lugar = l;
  }

  public String getTipoC() {
    return this.tipoC;
  }

  public String getTiempo() {
    return this.tiempo;
  }

  public String getEvento() {
    return this.evento;
  }

  public String getLugar() {
    return this.lugar;
  }

  public void setTipoC(String d) {
    this.tipoC = d;
  }

  public void setEvento(String d) {
    this.evento = d;
  }

  public void setLugar(String d) {
    this.lugar = d;
  }

  public void setTiempo(String d) {
    this.tiempo = d;
  }
}
