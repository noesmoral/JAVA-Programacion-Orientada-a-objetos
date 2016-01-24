/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazAgencia;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Jesus
 */
public class BusquedaPorCandidato extends javax.swing.JFrame {

    private JFrame principal;
    
    public BusquedaPorCandidato(JFrame ventana) {
        initComponents();
        principal = ventana;
        ImageIcon imagen= new ImageIcon("src/fondo.jpg");
        jAgencia.setIcon(imagen);
        principal.setVisible(false);        
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jClave = new javax.swing.JButton();
        jOcupacion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jAgencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscador");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Palabra a buscar");

        jClave.setText("Busqueda por palabra clave");
        jClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClaveActionPerformed(evt);
            }
        });

        jOcupacion.setText("Busqueda por ocupacion");
        jOcupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOcupacionActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Buscador de candidatos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jClave)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jOcupacion)
                    .addComponent(jBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 85, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jClave)
                    .addComponent(jOcupacion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-431)/2, (screenSize.height-208)/2, 431, 208);
    }// </editor-fold>//GEN-END:initComponents

    private void jClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClaveActionPerformed
        // Busqueda por clave
        BusquedaCandidato a = new BusquedaCandidato(this,true,jBusqueda.getText());
    }//GEN-LAST:event_jClaveActionPerformed

    private void jOcupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOcupacionActionPerformed
        // Busqueda por ocupacion
        BusquedaCandidato a = new BusquedaCandidato(this,false,jBusqueda.getText());
    }//GEN-LAST:event_jOcupacionActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAgencia;
    private javax.swing.JTextField jBusqueda;
    private javax.swing.JButton jClave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jOcupacion;
    // End of variables declaration//GEN-END:variables
}
