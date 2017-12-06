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
public class Diseño {
  Vestido vestido;
  Etiqueta etiqueta;

  public Diseño(Vestido vestido, Etiqueta etiqueta) {
    this.vestido = vestido;
    this.etiqueta = etiqueta;
  }

  public Etiqueta getEtiqueta() {
    return etiqueta;
  }

  public Vestido getVestido() {
    return vestido;
  }

  public void setEtiqueta(Etiqueta etiqueta) {
    this.etiqueta = etiqueta;
  }

  public void setVestido(Vestido vestido) {
    this.vestido = vestido;
  }
  
}
