/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazAgencia;

import BusquedaEmpleo.Agencia;
import BusquedaEmpleo.Candidato;
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
public class BusquedaCandidato extends javax.swing.JFrame {

        private JFrame principal;
        private ArrayList<Candidato> candaux;
        private ListIterator li;
        private Candidato objcand;
        private boolean a;//Cambia el ArrayList referenciado
        private String busqueda;// Busqueda realizada
        private Oferta objoft;
    
    public BusquedaCandidato(JFrame ventana,boolean b,String s) {
        initComponents();
        principal = ventana;
        principal.setVisible(false);
        a=b;
        busqueda=s;
        ImageIcon imagen= new ImageIcon("src/fondo.jpg");
        jAgencia.setIcon(imagen);
        panelCandidato1.desactivar();
        consultarTodo();        
        this.setVisible(true);
    }
    public BusquedaCandidato(JFrame ventana,boolean b,Oferta o,String s) {
        initComponents();
        principal = ventana;
        principal.setVisible(false);
        a=b;
        busqueda=s;
        ImageIcon imagen= new ImageIcon("src/fondo.jpg");
        jAgencia.setIcon(imagen);
        objoft=o;
        panelCandidato1.desactivar();
        consultarTodo2();        
        this.setVisible(true);
    }
    /** Consulta los candidatos del ArrayList para su presentación */
    private void consultarTodo() {
        try {
            //referenciamos al ArrayList de Agencia
            if(a){
               candaux= Agencia.buscarCandidatoPorPalabraClave(busqueda);
            }else{
               candaux= Agencia.buscarCandidatoPorOcupacion(busqueda);
            }          
            //creamos el iterador sobre el ArrayList
            li = candaux.listIterator();
            //si no hay candidatos...
            if (candaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No hay candidatos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                jButtonSig.setEnabled(false);
                jButtonAnt.setEnabled(false);
                jButton1.setEnabled(false);
                return;
            } else {
                jButtonSig.setEnabled(true);
                jButtonAnt.setEnabled(true);
                jButton1.setEnabled(true);
            }
            //presentamos la primera oferta
            if (li.hasNext()) {
                objcand = (Candidato) li.next();
            }
            if (objcand != null) {
                presenta(objcand);
            } else {
                JOptionPane.showMessageDialog(this, "No hay candidatos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            return;
        }
    }//fin consultarTodo
    
    /** Consulta los candidatos del ArrayList para su presentación comparados por la oferta*/
    private void consultarTodo2() {
        try {
            //referenciamos al ArrayList de Agencia
            if(a){
               candaux= Agencia.buscarCandidatoPorPalabraClave(busqueda);
            }else{
               candaux= Agencia.compararCandidatoPorOcupacionYRango(objoft);
            }          
            //creamos el iterador sobre el ArrayList
            li = candaux.listIterator();
            //si no hay candidatos...
            if (candaux.size() < 1) {
                JOptionPane.showMessageDialog(this, "No hay candidatos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                jButtonSig.setEnabled(false);
                jButtonAnt.setEnabled(false);
                jButton1.setEnabled(false);
                return;
            } else {
                jButtonSig.setEnabled(true);
                jButtonAnt.setEnabled(true);
                jButton1.setEnabled(true);
            }
            //presentamos la primera oferta
            if (li.hasNext()) {
                objcand = (Candidato) li.next();
            }
            if (objcand != null) {
                presenta(objcand);
            } else {
                JOptionPane.showMessageDialog(this, "No hay candidatos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            return;
        }
    }//fin consultarTodo2

    /** Presenta los datos de un candidato en el panel de datos */
    private void presenta(Candidato cand) {
        panelCandidato1.setjNombre(cand.getNombre());
        panelCandidato1.setjListaClave(cand.getListaClave());
        panelCandidato1.setjOcupaciones(cand.getOcupaciones());
        panelCandidato1.setjRango(cand.getRangoSalarial());
        panelCandidato1.setjTelefono(cand.getTelefono());
        panelCandidato1.setjNIF(cand.getNIF());
        panelCandidato1.getPanelDireccion1().setjCP(cand.getDireccion().getCodigoPostal());
        panelCandidato1.getPanelDireccion1().setjLocalidad(cand.getDireccion().getLocalidad());
        panelCandidato1.getPanelDireccion1().setjNumero(cand.getDireccion().getNumero());
        panelCandidato1.getPanelDireccion1().setjPisoLetra(cand.getDireccion().getPisoLetra());
        panelCandidato1.getPanelDireccion1().setjVia(cand.getDireccion().getNombreVia());
        ImageIcon imagenes= new ImageIcon(cand.getFoto());
        jFoto.setIcon(imagenes);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCandidato1 = new InterfazAgencia.PanelCandidato();
        jButtonAnt = new javax.swing.JButton();
        jButtonSig = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jFoto = new javax.swing.JLabel();
        jAgencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar candidato");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButtonAnt.setText("Anterior");
        jButtonAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAntActionPerformed(evt);
            }
        });

        jButtonSig.setText("Siguiente");
        jButtonSig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSigActionPerformed(evt);
            }
        });

        jButton1.setText("Ofertas que casen");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAnt)
                        .addGap(60, 60, 60)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44)
                        .addComponent(jButtonSig))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCandidato1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addComponent(jAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(297, 297, 297))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSig)
                            .addComponent(jButtonAnt))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCandidato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-547)/2, (screenSize.height-646)/2, 547, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAntActionPerformed
        // Anterior
        try{
            if (li.hasPrevious()) {
               objcand = (Candidato) li.previous();//se obtiene el candidato anterior
               if (objcand != null) {
                    presenta(objcand);// si hay datos en ese objeto candidato se muestran en la pantalla
               }  
           } else {
              JOptionPane.showMessageDialog(this, "No hay mas candidatos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            
        }
    }//GEN-LAST:event_jButtonAntActionPerformed

    private void jButtonSigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSigActionPerformed
        // Siguiente
        try{
            if (li.hasNext()) {
               objcand = (Candidato) li.next();//se obtiene el candidato siguiente
               if (objcand != null) {
                    presenta(objcand);// si hay datos en ese objeto candidato se muestran en la pantalla
               }  
           } else {
              JOptionPane.showMessageDialog(this, "No hay mas candidatos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Mensaje", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error: " + e.toString());
            
        }
    }//GEN-LAST:event_jButtonSigActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BusquedaOferta b=new BusquedaOferta(this,this.a,objcand,busqueda);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        principal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAgencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAnt;
    private javax.swing.JButton jButtonSig;
    private javax.swing.JLabel jFoto;
    private InterfazAgencia.PanelCandidato panelCandidato1;
    // End of variables declaration//GEN-END:variables
}
