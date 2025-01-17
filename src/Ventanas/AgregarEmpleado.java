package Ventanas;
import Clases.Empleados;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
public class AgregarEmpleado extends javax.swing.JFrame {
    Empleados emp = new Empleados();
    public AgregarEmpleado() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agregar Empleado");
        Aceptar.setEnabled(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        CargarNombresCargos();
    }
    public void Limpiar(){
        jTextNombre.setText(" ");
        jTextDNI.setText(" ");
        jTextDireccion.setText(" ");
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
        // Validacion de Cargo
        if (jComboCargoEmpleado.getSelectedItem().toString().isEmpty()) {
            jLabelCargo.setText("*");
        } else {
            jLabelCargo.setText("");
        }
        //Validacion general
        if(jTextNombre.getText().isEmpty()||jTextDNI.getText().isEmpty()||jTextDNI.getText().length()<8||jTextTelefono.getText().isEmpty()||jTextCorreo.getText().isEmpty()
                ||!jTextCorreo.getText().contains("@")||!jTextCorreo.getText().contains(".")||jTextDireccion.getText().isEmpty()||jComboCargoEmpleado.getSelectedItem().toString().isEmpty()){
            Aceptar.setEnabled(false);
        }else{
            Aceptar.setEnabled(true);
        }
    }
    // Método para cargar los nombres de los cargos en el JComboBox
    private void CargarNombresCargos() {
        // Obtener los nombres de los cargos
        ResultSet resultSetCargos = emp.Consultar("SELECT Nombre FROM cargos");
        try {
            // Crear un modelo para el JComboBox
            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

            // Agregar los nombres de los cargos al modelo
            while (resultSetCargos.next()) {
                String nombreCargo = resultSetCargos.getString("Nombre");
                modeloCombo.addElement(nombreCargo);
            }

            // Asignar el modelo al JComboBox
            jComboCargoEmpleado.setModel(modeloCombo);
        } catch (SQLException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabelCorreo = new javax.swing.JLabel();
        jTextDireccion = new javax.swing.JTextField();
        Aceptar = new javax.swing.JButton();
        jLabelDireccion = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelCargo = new javax.swing.JLabel();
        jComboCargoEmpleado = new javax.swing.JComboBox<>();
        jTextNombre = new javax.swing.JTextField();
        jTextDNI = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextTelefono = new javax.swing.JTextField();
        jTextCorreo = new javax.swing.JTextField();
        jLabelNom = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelTele = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jfecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel11.setText("Direccion:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 224, -1, -1));

        jLabelCorreo.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCorreo.setText("*");
        jPanel1.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 178, -1, -1));

        jTextDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 218, 207, -1));

        Aceptar.setBackground(new java.awt.Color(0, 51, 51));
        Aceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        jPanel1.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        jLabelDireccion.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDireccion.setText("*");
        jPanel1.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 218, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("Cargo:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 225, -1, -1));

        jLabelCargo.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCargo.setText("*");
        jPanel1.add(jLabelCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 220, -1, -1));

        jComboCargoEmpleado.setModel(jComboCargoEmpleado.getModel());
        jComboCargoEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboCargoEmpleadoMouseClicked(evt);
            }
        });
        jComboCargoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCargoEmpleadoActionPerformed(evt);
            }
        });
        jComboCargoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboCargoEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboCargoEmpleadoKeyTyped(evt);
            }
        });
        jPanel1.add(jComboCargoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 220, 193, -1));

        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });
        jPanel1.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 80, 211, -1));

        jTextDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDNIKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 126, 211, -1));

        jDateChooser1.setDateFormatString("dd-MM-y");
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyTyped(evt);
            }
        });
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(486, 126, 137, -1));

        jTextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(418, 80, 205, -1));

        jTextCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCorreoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(jTextCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 172, 478, -1));

        jLabelNom.setForeground(new java.awt.Color(153, 0, 0));
        jLabelNom.setText("*");
        jPanel1.add(jLabelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 80, -1, -1));

        jLabelDNI.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDNI.setText("*");
        jPanel1.add(jLabelDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 126, -1, -1));

        jLabelTele.setForeground(new java.awt.Color(153, 0, 0));
        jLabelTele.setText("*");
        jPanel1.add(jLabelTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 86, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Correo electronico:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 178, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Telefono:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 86, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Nuevo Empleado");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 21, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Fecha de nacimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 126, -1, -1));

        Salir.setBackground(new java.awt.Color(0, 51, 51));
        Salir.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("DNI:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 132, -1, -1));

        jfecha.setForeground(new java.awt.Color(204, 51, 0));
        jfecha.setText("*");
        jPanel1.add(jfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 126, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 86, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Empleados.png"))); // NOI18N
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 70, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void jTextDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyReleased
      Validar();
    }//GEN-LAST:event_jTextDireccionKeyReleased

    private void jTextDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyTyped
        char validar = evt.getKeyChar();

        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextDireccionKeyTyped

    private void jTextNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyReleased
        Validar();
    }//GEN-LAST:event_jTextNombreKeyReleased

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
        char validar = evt.getKeyChar();

        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jTextDNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIKeyReleased
        Validar();
    }//GEN-LAST:event_jTextDNIKeyReleased

    private void jTextDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
        if(jTextDNI.getText().length()>=8){
            evt.consume();
        }
    }//GEN-LAST:event_jTextDNIKeyTyped

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void jDateChooser1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyTyped

    private void jTextTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyReleased
        Validar();
    }//GEN-LAST:event_jTextTelefonoKeyReleased

    private void jTextTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyTyped
        if(jTextTelefono.getText().length()>=9){
            evt.consume();
        }

        char validar = evt.getKeyChar();

        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextTelefonoKeyTyped

    private void jTextCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoKeyReleased
        Validar();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoKeyReleased

    private void jTextCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoKeyTyped

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        //Asignacion de las variables
        emp.nombre=jTextNombre.getText();
        emp.dni=jTextDNI.getText();
        emp.cargo=jComboCargoEmpleado.getSelectedItem().toString();
        emp.fechaNacimiento=jDateChooser1.getDate();
        emp.telefono= jTextTelefono.getText();
        emp.correo=jTextCorreo.getText();
        emp.direccion=jTextDireccion.getText();

        //Conversion de la fecha para mySql
        long d =emp.fechaNacimiento.getTime();
        Date fecha = new Date(d);
        emp.fechaNacimiento=fecha;

        //Agregar empleado
        emp.AgregarEmpleado();
        Limpiar();
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void jComboCargoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoActionPerformed
        
    }//GEN-LAST:event_jComboCargoEmpleadoActionPerformed

    private void jComboCargoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoKeyReleased
        Validar();
    }//GEN-LAST:event_jComboCargoEmpleadoKeyReleased

    private void jComboCargoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoKeyTyped

    }//GEN-LAST:event_jComboCargoEmpleadoKeyTyped

    private void jComboCargoEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoMouseClicked
        
    }//GEN-LAST:event_jComboCargoEmpleadoMouseClicked

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
            java.util.logging.Logger.getLogger(AgregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Salir;
    private javax.swing.JComboBox<String> jComboCargoEmpleado;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCargo;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelTele;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    private javax.swing.JLabel jfecha;
    // End of variables declaration//GEN-END:variables
}
