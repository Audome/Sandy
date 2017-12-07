package Sandy;

import static Sandy.Sandy.c;
import static Sandy.Sandy.calif;
import static Sandy.Sandy.evento;
import static Sandy.Sandy.lugar;
import static Sandy.Sandy.tiempo;
import static Sandy.Sandy.tipoCuerpo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form AgregarMedidas
     */
    public Interfaz() {
        initComponents();
        this.setTitle("Proyecto Sandy");
        this.CBoxEvento.removeAllItems();
        CBoxEvento.addItem("Boda");
        CBoxEvento.addItem("XV Años");
        this.CBoxLugar.removeAllItems();
        CBoxLugar.addItem("Salón");
        CBoxLugar.addItem("Playa");
        this.CBoxTcuerpo.removeAllItems();
        CBoxTcuerpo.addItem("Reloj de Arena");
        CBoxTcuerpo.addItem("Pera");
        this.CBoxTiempo.removeAllItems();
        CBoxTiempo.addItem("Día");
        CBoxTiempo.addItem("Noche");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    static Model c = c = new Model();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBoxTcuerpo = new javax.swing.JComboBox<>();
        CBoxTiempo = new javax.swing.JComboBox<>();
        CBoxEvento = new javax.swing.JComboBox<>();
        CBoxLugar = new javax.swing.JComboBox<>();
        bCrear = new javax.swing.JButton();
        bReintentar = new javax.swing.JButton();
        lTipodeCuerpo = new javax.swing.JLabel();
        lTiempo = new javax.swing.JLabel();
        lEvento = new javax.swing.JLabel();
        lLugar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CBoxTcuerpo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBoxTiempo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBoxEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CBoxLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bCrear.setText("Crear");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        bReintentar.setText("Reintentar");

        lTipodeCuerpo.setText("Tipo de Cuerpo:");

        lTiempo.setText("Tiempo:");

        lEvento.setText("Evento:");

        lLugar.setText("Lugar:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lTipodeCuerpo)
                            .addComponent(lTiempo)
                            .addComponent(lEvento)
                            .addComponent(lLugar))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(CBoxEvento, javax.swing.GroupLayout.Alignment.LEADING, 0, 119, Short.MAX_VALUE)
                                .addComponent(CBoxTiempo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CBoxTcuerpo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(CBoxLugar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(bReintentar)
                        .addGap(94, 94, 94))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBoxTcuerpo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lTipodeCuerpo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBoxTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lTiempo))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBoxEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lEvento))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CBoxLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lLugar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(bCrear)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bReintentar)
                        .addGap(45, 45, 45))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        // TODO add your handling code here:
        Sandy.evento = (String) CBoxEvento.getSelectedItem();
        Sandy.lugar = (String) CBoxLugar.getSelectedItem();
        Sandy.tiempo = (String) CBoxTiempo.getSelectedItem();
        Sandy.tipoCuerpo = (String) CBoxTcuerpo.getSelectedItem();
        String strCadena = null;
        String strCadena2 = null;
        ArrayList<Vestido>  lista;
        Vestido v; Diseño d;
        calif = 0;
        //los porcentajes van de 0, 25, 50, 75 y 100
        int porOriginal = 65;
        int porCoincidencia = 0;
        String cc = "Azul";
        //aquí pondremos los valores de las etiquetas
        Etiqueta e = new Etiqueta(tipoCuerpo, tiempo, evento, lugar, cc);
        try {
            lista = c.buscar(e, porCoincidencia);
            d = c.reusar(e, lista);
            calif = c.evaluar(d);
            String Cadena=d.vestido.toString()+" \nCalif:" +calif;
            jTextArea1.setText(Cadena);
        } catch (IOException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String uno, dos, tres, cuatro;
        uno = (String) CBoxEvento.getSelectedItem();
        dos = (String) CBoxLugar.getSelectedItem();
        tres = (String) CBoxTiempo.getSelectedItem();
        cuatro = (String) CBoxTcuerpo.getSelectedItem();
        
        strCadena = uno+" "+dos+" "+" "+tres+" "+cuatro;
        //jTextArea1.setText(strCadena);
        
        
        
    }//GEN-LAST:event_bCrearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarMedidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBoxEvento;
    private javax.swing.JComboBox<String> CBoxLugar;
    private javax.swing.JComboBox<String> CBoxTcuerpo;
    private javax.swing.JComboBox<String> CBoxTiempo;
    private javax.swing.JButton bCrear;
    private javax.swing.JButton bReintentar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lEvento;
    private javax.swing.JLabel lLugar;
    private javax.swing.JLabel lTiempo;
    private javax.swing.JLabel lTipodeCuerpo;
    // End of variables declaration//GEN-END:variables
}
