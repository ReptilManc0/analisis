package Ventanas;
import Clases.Clientes;
import java.sql.Date;
public class AgregarCliente extends javax.swing.JFrame {
    public AgregarCliente() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agregar Cliente");
        Aceptar.setEnabled(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    public void Limpiar(){
        jTextNombre.setText(" ");
        jTextDNI.setText(" ");
        jTextApellido.setText(" ");
        jTextCorreo.setText(" ");
        jTextTelefono.setText(" ");
    }
    public void Validar(){
        
        //Validacion de nombre
        if(jTextNombre.getText().isEmpty()){
            jLabelNom.setText("*");
        }else{
            jLabelNom.setText("");
        }
        
        //Validacion de apellidos
        if(jTextApellido.getText().isEmpty()){
            jLabelApelli.setText("*");
        }else{
            jLabelApelli.setText("");
        }
        
        //Validacion de Fecha
        //if(jDateChooser1.getDate()==null){
        //     jfecha.setText("*");
        //}else{
        //    jfecha.setText("");
        //}
        
        //Validacion de DNI
        if(jTextDNI.getText().isEmpty()||jTextDNI.getText().length()<8){
            jLabelDNI.setText("*");
        }else{
            jLabelDNI.setText("");
        }
        
        //Validacion de Telefono
        if(jTextTelefono.getText().isEmpty()||jTextTelefono.getText().length()<9){
            jLabelTele.setText("*");
        }else{
            jLabelTele.setText("");
        }
        
        //Validacion de Correo
        if(jTextCorreo.getText().isEmpty()){
            jLabelCorreo.setText("*");
        }else if (!jTextCorreo.getText().contains("@")||!jTextCorreo.getText().contains(".")){
            jLabelCorreo.setText("...");
        }else{
            jLabelCorreo.setText("");
        }
        //Validacion de direccion
        if(jTextDireccion.getText().isEmpty()){
            jLabelDireccion.setText("*");
        }else{
            jLabelDireccion.setText("");
        }
        //Validacion de distrito
        if(jTextDistrito.getText().isEmpty()){
            jLabelDistrito.setText("*");
        }else{
            jLabelDistrito.setText("");
        }
        //Validacion general
        if(jTextNombre.getText().isEmpty()||jTextApellido.getText().isEmpty()||jTextDNI.getText().isEmpty()||jTextDNI.getText().length()<8||jTextTelefono.getText().isEmpty()||jTextCorreo.getText().isEmpty()
                ||!jTextCorreo.getText().contains("@")||!jTextCorreo.getText().contains(".")||jTextDireccion.getText().isEmpty()||jTextDistrito.getText().isEmpty()){
            Aceptar.setEnabled(false);
        }else{
            Aceptar.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextTelefono1 = new javax.swing.JTextField();
        jLabelTele1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JTextCorreo1 = new javax.swing.JTextField();
        jLabelCorreo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jTextApellido = new javax.swing.JTextField();
        jTextDNI = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextTelefono = new javax.swing.JTextField();
        jTextCorreo = new javax.swing.JTextField();
        jLabelNom = new javax.swing.JLabel();
        jLabelApelli = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelTele = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jfecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextDireccion = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextDistrito = new javax.swing.JTextField();
        jLabelDistrito = new javax.swing.JLabel();

        jLabel5.setText("Fecha de nacimiento:");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Telefono:");

        jLabelTele1.setForeground(new java.awt.Color(153, 0, 0));
        jLabelTele1.setText("*");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setText("Correo electronico:");

        jLabelCorreo1.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCorreo1.setText("*");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Correo electrónico:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 169, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Teléfono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 169, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 117, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 123, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Apellidos:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 77, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 77, -1, -1));

        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });
        jPanel1.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 71, 211, -1));

        jTextApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextApellidoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 71, 202, -1));

        jTextDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDNIKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 117, 235, -1));

        jDateChooser1.setDateFormatString("dd-MM-y");
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyTyped(evt);
            }
        });
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 117, 137, -1));

        jTextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 163, 205, -1));

        jTextCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCorreoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 163, 148, -1));

        jLabelNom.setForeground(new java.awt.Color(153, 0, 0));
        jLabelNom.setText("*");
        jPanel1.add(jLabelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 77, -1, -1));

        jLabelApelli.setForeground(new java.awt.Color(153, 0, 0));
        jLabelApelli.setText("*");
        jPanel1.add(jLabelApelli, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 77, -1, -1));

        jLabelDNI.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDNI.setText("*");
        jPanel1.add(jLabelDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 117, -1, -1));

        jLabelTele.setForeground(new java.awt.Color(153, 0, 0));
        jLabelTele.setText("*");
        jPanel1.add(jLabelTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 169, -1, -1));

        jLabelCorreo.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCorreo.setText("*");
        jPanel1.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 169, -1, -1));

        Aceptar.setBackground(new java.awt.Color(0, 51, 51));
        Aceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        jPanel1.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Nuevo Cliente");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 21, -1, -1));

        Salir.setBackground(new java.awt.Color(0, 51, 51));
        Salir.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 80, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 13, -1, -1));

        jfecha.setForeground(new java.awt.Color(204, 51, 0));
        jfecha.setText("*");
        jPanel1.add(jfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(627, 117, -1, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Dirección:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 215, -1, -1));

        jTextDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 209, 205, -1));

        jLabelDireccion.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDireccion.setText("*");
        jPanel1.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 215, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("Distrito:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 215, -1, -1));

        jTextDistrito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDistritoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDistritoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 209, 214, -1));

        jLabelDistrito.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDistrito.setText("*");
        jPanel1.add(jLabelDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(628, 215, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
    
        Clientes cl = new Clientes();
    //Asignacion de las variables    
        cl.nombres=jTextNombre.getText();
        cl.apellidos=jTextApellido.getText();
        cl.dni=jTextDNI.getText();
        cl.fechaNacimiento=jDateChooser1.getDate();
        cl.telefono= jTextTelefono.getText();
        cl.correoElectronico=jTextCorreo.getText();
        cl.distrito=jTextDistrito.getText();
        cl.direccion=jTextDireccion.getText();

    //Conversion de la fecha para mySql
        long d =cl.fechaNacimiento.getTime();
        Date fecha = new Date(d);
        cl.fechaNacimiento=fecha;
        
    //Agregar cliente
        cl.AgregarCliente();
        Limpiar();
        this.dispose();
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void jTextNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyReleased
        Validar();
    }//GEN-LAST:event_jTextNombreKeyReleased

    private void jTextApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoKeyReleased
        Validar();
    }//GEN-LAST:event_jTextApellidoKeyReleased

    private void jTextDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIKeyReleased
        Validar();
    }//GEN-LAST:event_jTextDNIKeyReleased

    private void jTextTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyReleased
        Validar();
    }//GEN-LAST:event_jTextTelefonoKeyReleased

    private void jTextCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoKeyReleased
        Validar();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoKeyReleased

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void jTextDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
        if(jTextDNI.getText().length()>=8){
        evt.consume();
    }
    }//GEN-LAST:event_jTextDNIKeyTyped

    private void jTextTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyTyped
        if(jTextTelefono.getText().length()>=9){
            evt.consume();
        }
    
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextTelefonoKeyTyped

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
            char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }        
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jTextApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextApellidoKeyTyped
            char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }        
    }//GEN-LAST:event_jTextApellidoKeyTyped

    private void jTextCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoKeyTyped

    private void jDateChooser1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyTyped

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void jTextDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyReleased
    Validar();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDireccionKeyReleased

    private void jTextDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyTyped
           
    }//GEN-LAST:event_jTextDireccionKeyTyped

    private void jTextDistritoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDistritoKeyReleased
    Validar();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDistritoKeyReleased

    private void jTextDistritoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDistritoKeyTyped
       char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }      
    }//GEN-LAST:event_jTextDistritoKeyTyped

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
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JTextField JTextCorreo1;
    private javax.swing.JButton Salir;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelApelli;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelCorreo1;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelDistrito;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelTele;
    private javax.swing.JLabel jLabelTele1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextDistrito;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    private javax.swing.JTextField jTextTelefono1;
    private javax.swing.JLabel jfecha;
    // End of variables declaration//GEN-END:variables
}
