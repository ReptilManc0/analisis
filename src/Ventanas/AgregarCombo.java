package Ventanas;

import Clases.Combos;
import Clases.ProductosEnCombo;

public class AgregarCombo extends javax.swing.JFrame {
    public AgregarCombo() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agregar Combo");
        Continuar.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    public void Limpiar(){
        jTextNombre.setText(" ");
        jTextDescripcion.setText(" ");
        jTextPrecio.setText(" ");
        jTextTemp.setText(" ");
    }
    public void Validar(){
        
        //Validacion de nombre
        if(jTextNombre.getText().isEmpty()){
            jLabelNom.setText("*");
        }else{
            jLabelNom.setText("");
        }
        
        //Validacion de descripcion
        if(jTextDescripcion.getText().isEmpty()){
            jLabelDescripcion.setText("*");
        }else{
            jLabelDescripcion.setText("");
        }
        
       
        //Validacion de precio
        if(jTextPrecio.getText().isEmpty()){
            jLabelPrecio.setText("*");
        }else{
            jLabelPrecio.setText("");
        }
        
        //Validacion de temporada
        if(jTextTemp.getText().isEmpty()){
            jLabelTemp.setText("*");
        }else{
            jLabelTemp.setText("");
        }
       //Validacion general
        if(jTextNombre.getText().isEmpty()||jTextDescripcion.getText().isEmpty()||jTextPrecio.getText().isEmpty()
           ||jTextTemp.getText().isEmpty()){
            Continuar.setEnabled(false);
        }else{
            Continuar.setEnabled(true);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        Continuar = new javax.swing.JButton();
        jLabelNom = new javax.swing.JLabel();
        jTextDescripcion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jTextPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelPrecio = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextTemp = new javax.swing.JTextField();
        jLabelTemp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 63, -1, -1));

        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });
        jPanel1.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 57, 211, -1));

        Continuar.setBackground(new java.awt.Color(0, 51, 51));
        Continuar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Continuar.setForeground(new java.awt.Color(255, 255, 255));
        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        jLabelNom.setForeground(new java.awt.Color(153, 0, 0));
        jLabelNom.setText("*");
        jPanel1.add(jLabelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jTextDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDescripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 103, 464, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Nuevo Combo");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 15, -1, -1));

        jLabelDescripcion.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDescripcion.setText("*");
        jPanel1.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, -1, -1));

        jTextPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPrecioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioKeyTyped(evt);
            }
        });
        jPanel1.add(jTextPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 57, 167, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Precio:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 63, -1, -1));

        jButtonSalir.setBackground(new java.awt.Color(0, 51, 51));
        jButtonSalir.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jLabelPrecio.setForeground(new java.awt.Color(153, 0, 0));
        jLabelPrecio.setText("*");
        jPanel1.add(jLabelPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, -1, -1));

        jLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel.setText("Descripción:");
        jPanel1.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 109, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Temporada:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 156, -1, -1));

        jTextTemp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTempKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTempKeyTyped(evt);
            }
        });
        jPanel1.add(jTextTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 150, 211, -1));

        jLabelTemp.setForeground(new java.awt.Color(153, 0, 0));
        jLabelTemp.setText("*");
        jPanel1.add(jLabelTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 156, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Combo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -2, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyReleased
        Validar();
    }//GEN-LAST:event_jTextNombreKeyReleased

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped

    }//GEN-LAST:event_jTextNombreKeyTyped

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        Combos com = new Combos();     
        ProductosEnCombo pc= new ProductosEnCombo();
        //Asignacion de las variables
        com.nombre=jTextNombre.getText();
        com.descripcion=jTextDescripcion.getText();
        com.precio=jTextPrecio.getText();
        com.temporada=jTextTemp.getText();
        //Agregar cargo
        com.AgregarCombos();
        Limpiar();
        int idCombo= pc.ObtenerUltimoIdCombo();
        AgregarEnCombo agr =new AgregarEnCombo(idCombo);
        agr.setVisible(true);
        this.dispose();         
    }//GEN-LAST:event_ContinuarActionPerformed

    private void jTextDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDescripcionKeyReleased
        Validar();
    }//GEN-LAST:event_jTextDescripcionKeyReleased

    private void jTextDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDescripcionKeyTyped

    }//GEN-LAST:event_jTextDescripcionKeyTyped

    private void jTextPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioKeyReleased
        Validar();
    }//GEN-LAST:event_jTextPrecioKeyReleased

    private void jTextPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextPrecioKeyTyped

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jTextTempKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTempKeyReleased
        Validar();
    }//GEN-LAST:event_jTextTempKeyReleased

    private void jTextTempKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTempKeyTyped
        char validar = evt.getKeyChar();

        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextTempKeyTyped

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
            java.util.logging.Logger.getLogger(AgregarCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCombo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTemp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextDescripcion;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextPrecio;
    private javax.swing.JTextField jTextTemp;
    // End of variables declaration//GEN-END:variables
}
