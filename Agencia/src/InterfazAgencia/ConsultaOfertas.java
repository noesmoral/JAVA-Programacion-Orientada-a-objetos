/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazAgencia;

import BusquedaEmpleo.Agencia;
import BusquedaEmpleo.Oferta;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class ConsultaOfertas extends javax.swing.JFrame {

    private JFrame principal;
    private ArrayList<Oferta> oftaux;
    private ListIterator li;
    private Oferta objoft;
    
    public ConsultaOfertas(JFrame ventana) {
        initComponents();
        principal = ventana;
        principal.setVisible(false);
        panelOferta1.desactivar();
        ImageIcon imagen= new ImageIcon("src/fondo.jpg");
        jAgencia.setIcon(imagen);
        consultarTodo();        
        this.setVisible(true);
    }
    
     /** Consulta las ofertas del ArrayList para su presentación */
    private void consultarTodo() {
        try {
            //referenciamos al ArrayList de Agencia
               oftaux= Agencia.getOfertas();        
            //creamos el iterador sobre el ArrayList
            li = oftaux.listIterator();
            //si no hay ofertas...
            if (oftaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                jSig.setEnabled(false);
                jAnt.setEnabled(false);
                jBorrar.setEnabled(false);
                return;
            } else {
                jSig.setEnabled(true);
                jAnt.setEnabled(true);
                jBorrar.setEnabled(true);
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

        panelOferta1 = new InterfazAgencia.PanelOferta();
        jAnt = new javax.swing.JButton();
        jSig = new javax.swing.JButton();
        jBorrar = new javax.swing.JButton();
        jAgencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Ofertas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jAnt.setText("Anterior");
        jAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAntActionPerformed(evt);
            }
        });

        jSig.setText("Siguiente");
        jSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSigActionPerformed(evt);
            }
        });

        jBorrar.setText("BORRAR");
        jBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelOferta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jAnt)
                        .addGap(50, 50, 50)
                        .addComponent(jBorrar)
                        .addGap(45, 45, 45)
                        .addComponent(jSig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBorrar)
                        .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSig)
                            .addComponent(jAnt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOferta1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-485)/2, (screenSize.height-727)/2, 485, 727);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void jSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSigActionPerformed
        // TODO add your handling code here:
        try{
            if (li.hasNext()) {
               objoft = (Oferta) li.next();//se obtiene la oferta siguiente
               if (objoft != null) {
                    presenta(objoft);// si hay datos en ese objeto oferta se muestran en la pantalla
               }  
           } else {
              JOptionPane.showMessageDialog(this, "No hay mas ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            
        }
    }//GEN-LAST:event_jSigActionPerformed

    private void jAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAntActionPerformed
        // TODO add your handling code here:
        try{
            if (li.hasPrevious()) {
               objoft = (Oferta) li.previous();//se obtiene la oferta anterior
               if (objoft != null) {
                    presenta(objoft);// si hay datos en ese objeto oferta se muestran en la pantalla
               }  
           } else {
              JOptionPane.showMessageDialog(this, "No hay mas candidatos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            
        }
    }//GEN-LAST:event_jAntActionPerformed

    private void jBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBorrarActionPerformed
        // TODO add your handling code here:
    if(Agencia.borraOferta(objoft)){
            li.remove();
            JOptionPane.showMessageDialog(this, "Oferta borrada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, " Error: - Oferta no encontrada - ", "Mensaje", JOptionPane.ERROR_MESSAGE);
    }
    //mostramos el elemento siguiente o anterior
    if (li.hasNext()) {
        objoft = (Oferta) li.next();
        if (objoft != null) {
            presenta(objoft);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    } else if (li.hasPrevious()) {
        objoft = (Oferta) li.previous();
        if (objoft != null) {
            presenta(objoft);
        } else {
            JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }else {
        JOptionPane.showMessageDialog(this, "No hay ofertas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        this.formWindowClosed(null);
        this.setVisible(!true);
    }
        Agencia.guardarOfertas();       
    }//GEN-LAST:event_jBorrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAgencia;
    private javax.swing.JButton jAnt;
    private javax.swing.JButton jBorrar;
    private javax.swing.JButton jSig;
    private InterfazAgencia.PanelOferta panelOferta1;
    // End of variables declaration//GEN-END:variables
}
