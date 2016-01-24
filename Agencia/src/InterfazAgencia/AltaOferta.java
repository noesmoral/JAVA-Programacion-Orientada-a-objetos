/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazAgencia;

import BusquedaEmpleo.Agencia;
import BusquedaEmpleo.Direccion;
import BusquedaEmpleo.Oferta;
import BusquedaEmpleo.Oficina;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class AltaOferta extends javax.swing.JFrame {

    private JFrame principal;
    private Oferta oft = null;

    /** Creates new form Altas */
    public AltaOferta(JFrame ventana) {
        initComponents();
        principal = ventana;
        principal.setVisible(false);
        ImageIcon imagen= new ImageIcon("src/fondo.jpg");
        jAgencia.setIcon(imagen);
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

        jButton1 = new javax.swing.JButton();
        panelOferta1 = new InterfazAgencia.PanelOferta();
        jAgencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva oferta");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setText("Alta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelOferta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jAgencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(438, 438, 438)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelOferta1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-452)/2, (screenSize.height-630)/2, 452, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Boton de alta
        try {
        String nombreO=panelOferta1.getjNombre();
        String nombreOf=panelOferta1.getPanelOficina1().getjNombre();
        long telefono=panelOferta1.getPanelOficina1().getjTelefono();
        String via=panelOferta1.getPanelOficina1().getPanelDireccion1().getjVia();
        String piso=panelOferta1.getPanelOficina1().getPanelDireccion1().getjPisoLetra();
        String localidad=panelOferta1.getPanelOficina1().getPanelDireccion1().getjLocalidad();
        String CP=panelOferta1.getPanelOficina1().getPanelDireccion1().getjCP();
        int numero=panelOferta1.getPanelOficina1().getPanelDireccion1().getjNumero();
        String ocupacion=panelOferta1.getjOcupacion();
        String lista=panelOferta1.getjListaClave();
        Date ap=panelOferta1.getjApertura();
        Date cad=panelOferta1.getjCaducidad();
        String rango=panelOferta1.getjRango();
        //lo insertamos en el array
        Direccion d=new Direccion(via,numero,piso,localidad,CP);
        Oficina of=new Oficina(nombreOf,telefono,d);
        oft= new Oferta(nombreO,of,ocupacion,lista,ap,cad,rango);
        if (Agencia.altaOferta(oft)) {
            JOptionPane.showMessageDialog(this, "Oferta dada de alta.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            Agencia.guardarOfertas();
        } else {
            JOptionPane.showMessageDialog(this, "Error al dar de alta.", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Excepción al dar de alta.", "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        principal.setVisible(true);
        Agencia.guardarOfertas();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAgencia;
    private javax.swing.JButton jButton1;
    private InterfazAgencia.PanelOferta panelOferta1;
    // End of variables declaration//GEN-END:variables
}