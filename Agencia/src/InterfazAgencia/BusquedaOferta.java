/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazAgencia;

import BusquedaEmpleo.Agencia;
import BusquedaEmpleo.Candidato;
import BusquedaEmpleo.Oferta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class BusquedaOferta extends javax.swing.JFrame {

    private JFrame principal;
    private ArrayList<Oferta> oftaux;
    private ListIterator li;
    private Oferta objoft;
    private boolean a;//Cambia el ArrayList referenciado
    private String busqueda;// Busqueda realizada
    private Candidato objcand;

    /** Creates new form Consultas */
    public BusquedaOferta(JFrame ventana,boolean b,String s) {
        initComponents();
        principal = ventana;
        principal.setVisible(false);
        a=b;
        busqueda=s;
        ImageIcon imagen= new ImageIcon("src/fondo.jpg");
        jAgencia.setIcon(imagen);
        panelOferta1.desactivar();
        consultarTodo();        
        this.setVisible(true);       
    }
    public BusquedaOferta(JFrame ventana,boolean n,Candidato c,String b) {
        initComponents();
        principal = ventana;
        principal.setVisible(false);
        a=n;
        busqueda=b;
        ImageIcon imagen= new ImageIcon("src/fondo.jpg");
        jAgencia.setIcon(imagen);
        objcand=c;
        panelOferta1.desactivar();
        consultarTodo2();        
        this.setVisible(true);       
    }

    /** Consulta las ofertas del ArrayList para su presentación */
    private void consultarTodo() {
        try {
            //referenciamos al ArrayList de Agencia
            if(a){
               oftaux= Agencia.buscarOfertaPorPalabraClave(busqueda);
            }else{
               oftaux= Agencia.buscarOfertaPorOcupacion(busqueda);
            }          
            //creamos el iterador sobre el ArrayList
            li = oftaux.listIterator();
            //si no hay ofertas...
            if (oftaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                jButtonSig.setEnabled(false);
                jButtonAnt.setEnabled(false);
                jImprimir.setEnabled(false);
                jCasen.setEnabled(false);
                return;
            } else {
                jButtonSig.setEnabled(true);
                jButtonAnt.setEnabled(true);
                jImprimir.setEnabled(true);
                jCasen.setEnabled(true);
            }
            //presentamos la primera oferta
            if (li.hasNext()) {
                objoft = (Oferta) li.next();
            }
            if (objoft != null) {
                presenta(objoft);
            } else {
                JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            return;
        }
    }//fin consultarTodo
    
    
    /** Consulta las ofertas del ArrayList para su presentación comparadas con el candidato que lo llama */
    private void consultarTodo2() {
        try {
            //referenciamos al ArrayList de Agencia
            if(a){
               oftaux= Agencia.buscarOfertaPorPalabraClave(busqueda);
            }else{
               oftaux= Agencia.compararOfertaPorOcupacionYRango(objcand);
            }          
            //creamos el iterador sobre el ArrayList
            li = oftaux.listIterator();
            //si no hay ofertas...
            if (oftaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                jButtonSig.setEnabled(false);
                jButtonAnt.setEnabled(false);
                jImprimir.setEnabled(false);
                jCasen.setEnabled(false);
                return;
            } else {
                jButtonSig.setEnabled(true);
                jButtonAnt.setEnabled(true);
                jImprimir.setEnabled(true);
                jCasen.setEnabled(true);
            }
            //presentamos la primera oferta
            if (li.hasNext()) {
                objoft = (Oferta) li.next();
            }
            if (objoft != null) {
                presenta(objoft);
            } else {
                JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            return;
        }
    }//fin consultarTodo2
    
    
    /** Presenta los datos de una oferta en el panel de datos */
    private void presenta(Oferta oft) {
        panelOferta1.setjNombre(oft.getNombre());
        panelOferta1.setjApertura(oft.getFechaApertura());
        panelOferta1.setjCaducidad(oft.getFechaCaducidad());
        panelOferta1.setjListaClave(oft.getListaClave());
        panelOferta1.setjOcupacion(oft.getOcupacion());
        panelOferta1.setjRango(oft.getRangoSalarial());
        panelOferta1.getPanelOficina1().setjNombre(oft.getOficina().getNombre());
        panelOferta1.getPanelOficina1().setjTelefono(oft.getOficina().getTelefono());
        panelOferta1.getPanelOficina1().getPanelDireccion1().setjCP(oft.getOficina().getDireccion().getCodigoPostal());
        panelOferta1.getPanelOficina1().getPanelDireccion1().setjLocalidad(oft.getOficina().getDireccion().getLocalidad());
        panelOferta1.getPanelOficina1().getPanelDireccion1().setjNumero(oft.getOficina().getDireccion().getNumero());
        panelOferta1.getPanelOficina1().getPanelDireccion1().setjPisoLetra(oft.getOficina().getDireccion().getPisoLetra());
        panelOferta1.getPanelOficina1().getPanelDireccion1().setjVia(oft.getOficina().getDireccion().getNombreVia());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSig = new javax.swing.JButton();
        jButtonAnt = new javax.swing.JButton();
        jImprimir = new javax.swing.JButton();
        jCasen = new javax.swing.JButton();
        panelOferta1 = new InterfazAgencia.PanelOferta();
        jAgencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar oferta");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonSig.setText("Siguiente");
        jButtonSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSigActionPerformed(evt);
            }
        });

        jButtonAnt.setText("Anterior");
        jButtonAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAntActionPerformed(evt);
            }
        });

        jImprimir.setText("Imprimir");
        jImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jImprimirActionPerformed(evt);
            }
        });

        jCasen.setText("Candidatos que casen");
        jCasen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCasenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCasen)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSig))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jImprimir)
                            .addComponent(panelOferta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCasen)
                    .addComponent(jButtonAnt)
                    .addComponent(jButtonSig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelOferta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-444)/2, (screenSize.height-718)/2, 444, 718);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAntActionPerformed
        // Anterior
        if (li.hasPrevious()) {
        objoft = (Oferta) li.previous();
        if (objoft != null) {
            presenta(objoft);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButtonAntActionPerformed

    private void jButtonSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSigActionPerformed
        // Siguiente
        if (li.hasNext()) {
        objoft = (Oferta) li.next();
        if (objoft != null) {
            presenta(objoft);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButtonSigActionPerformed

    private void jCasenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCasenActionPerformed
        BusquedaCandidato b=new BusquedaCandidato(this,this.a,objoft,busqueda);
    }//GEN-LAST:event_jCasenActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jImprimirActionPerformed
        try {
            // TODO add your handling code here:
            Agencia.imprimirOferta(objoft);
        } catch (IOException ex) {
            Logger.getLogger(BusquedaOferta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Se ha producido un error al imprimir la oferta.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }//GEN-LAST:event_jImprimirActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAgencia;
    private javax.swing.JButton jButtonAnt;
    private javax.swing.JButton jButtonSig;
    private javax.swing.JButton jCasen;
    private javax.swing.JButton jImprimir;
    private InterfazAgencia.PanelOferta panelOferta1;
    // End of variables declaration//GEN-END:variables
}
