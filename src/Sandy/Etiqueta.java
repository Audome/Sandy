/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sandy;

/**
 *
 * @author Audome
 */
class Etiqueta {

  String tipoC;
  String tiempo;
  String evento;
  String lugar;
  String color;

  public Etiqueta(String tc, String t, String ev, String l,String c) {
    this.tipoC = tc;
    this.tiempo = t;
    this.evento = ev;
    this.lugar = l;
    this.color = c;
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

  public String getColor() {
    return color;
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
  
  public void setColor(String color) {
    this.color = color;
  }
  
}
