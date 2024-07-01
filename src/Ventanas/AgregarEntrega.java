package Ventanas;

import Clases.Empleados;
import Clases.Entregas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

public class AgregarEntrega extends javax.swing.JFrame {
    private int idVenta;
    public AgregarEntrega(int idVenta) {
        initComponents();
        this.idVenta=idVenta;
        setTitle("Agregar Entrega");
        setResizable(false);
        setLocationRelativeTo(null);
        Finalizar.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        CargarNombresEmpleados();
    }
    private void CargarNombresEmpleados() {
        Empleados nombreEmpleados = new Empleados();
        // Obtener los nombres de los empleados
        ResultSet resultSetEmpleados = nombreEmpleados.Consultar("SELECT Nombre FROM empleados");
        try {
            // Crear un modelo para el JComboBox
            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

            // Agregar los nombres de los empleados al modelo
            while (resultSetEmpleados.next()) {
                String nombreEmpleado = resultSetEmpleados.getString("Nombre");
                modeloCombo.addElement(nombreEmpleado);
            }

            // Asignar el modelo al JComboBox
            jComboEmpleadoEntrega.setModel(modeloCombo);
        } catch (SQLException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }
    
    public void Limpiar(){
        jTextProvincia.setText(" ");
        jTextDireccion.setText(" ");
    }
    public void Validar(){
       
        //Validacion de Fecha
        if(jDateVenta.getDate()==null){
            jfecha.setText("*");
        }else{
            jfecha.setText("");
        }
        
        //Validacion de Provincia
        if(jTextProvincia.getText().isEmpty()){
            jLabelProvincia.setText("*");
        }else{
            jLabelProvincia.setText("");
        }
        
        //Validacion de Cantidad en Stock
        if(jTextDireccion.getText().isEmpty()){
            jLabelDireccion.setText("*");
        }else{
            jLabelDireccion.setText("");
        }
      
        
        //Validacion general
        if(jDateVenta.getDate()==null||jTextProvincia.getText().isEmpty()||jTextDireccion.getText().isEmpty()){
            Finalizar.setEnabled(false);
        }else{
            Finalizar.setEnabled(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Finalizar = new javax.swing.JButton();
        jTextDireccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jTextProvincia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabelProvincia = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateVenta = new com.toedter.calendar.JDateChooser();
        jfecha = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboEmpleadoEntrega = new javax.swing.JComboBox<>();
        jComboEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Fecha:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        Finalizar.setBackground(new java.awt.Color(0, 51, 51));
        Finalizar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Finalizar.setForeground(new java.awt.Color(255, 255, 255));
        Finalizar.setText("Finalizar");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(Finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jTextDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 107, 360, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Entrega de la venta");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabelDireccion.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDireccion.setText("*");
        jPanel1.add(jLabelDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, -1, -1));

        jTextProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextProvinciaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextProvinciaKeyTyped(evt);
            }
        });
        jPanel1.add(jTextProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 126, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Provincia:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, -1));

        jLabelProvincia.setForeground(new java.awt.Color(153, 0, 0));
        jLabelProvincia.setText("*");
        jPanel1.add(jLabelProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel.setText("Dirección:");
        jPanel1.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 113, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Estado:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Entrega.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, -20, 50, 80));

        jDateVenta.setDateFormatString("dd-MM-y");
        jDateVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateVentaKeyTyped(evt);
            }
        });
        jPanel1.add(jDateVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 137, -1));

        jfecha.setForeground(new java.awt.Color(204, 51, 0));
        jfecha.setText("*");
        jPanel1.add(jfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("Empleado:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 169, -1, -1));

        jComboEmpleadoEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboEmpleadoEntregaMouseClicked(evt);
            }
        });
        jComboEmpleadoEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleadoEntregaActionPerformed(evt);
            }
        });
        jComboEmpleadoEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboEmpleadoEntregaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboEmpleadoEntregaKeyTyped(evt);
            }
        });
        jPanel1.add(jComboEmpleadoEntrega, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 164, 120, -1));

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entregado", "En Proceso" }));
        jComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEstadoActionPerformed(evt);
            }
        });
        jComboEstado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboEstadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboEstadoKeyTyped(evt);
            }
        });
        jPanel1.add(jComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 130, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
        Entregas ent = new Entregas();
        //Asignacion de las variables
        ent.fecha=jDateVenta.getDate();
        ent.direccion=jTextDireccion.getText();
        ent.provincia=jTextProvincia.getText();
        ent.empleado =jComboEmpleadoEntrega.getSelectedItem().toString();
        ent.estado=jComboEstado.getSelectedItem().toString();
        ent.idVenta=idVenta;

        //Parseo de fecha
        long d = ent.fecha.getTime();
        Date fecha = new Date(d);
        ent.fecha=fecha;

        //Agregar cargo
        ent.AgregarEntrega();
        Limpiar();

        this.dispose();
    }//GEN-LAST:event_FinalizarActionPerformed

    private void jTextDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyReleased
        Validar();
    }//GEN-LAST:event_jTextDireccionKeyReleased

    private void jTextDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyTyped

    }//GEN-LAST:event_jTextDireccionKeyTyped

    private void jTextProvinciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextProvinciaKeyReleased
        Validar();
    }//GEN-LAST:event_jTextProvinciaKeyReleased

    private void jTextProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextProvinciaKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }   
    }//GEN-LAST:event_jTextProvinciaKeyTyped

    private void jDateVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateVentaKeyReleased
        Validar();        // TODO add your handling code here:
    }//GEN-LAST:event_jDateVentaKeyReleased

    private void jDateVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateVentaKeyTyped

    private void jComboEmpleadoEntregaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboEmpleadoEntregaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEmpleadoEntregaMouseClicked

    private void jComboEmpleadoEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadoEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEmpleadoEntregaActionPerformed

    private void jComboEmpleadoEntregaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboEmpleadoEntregaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEmpleadoEntregaKeyReleased

    private void jComboEmpleadoEntregaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboEmpleadoEntregaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEmpleadoEntregaKeyTyped

    private void jComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEstadoActionPerformed

    private void jComboEstadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboEstadoKeyReleased
        Validar();
    }//GEN-LAST:event_jComboEstadoKeyReleased

    private void jComboEstadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboEstadoKeyTyped

    }//GEN-LAST:event_jComboEstadoKeyTyped

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
            java.util.logging.Logger.getLogger(AgregarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int idVenta = 0;
                AgregarEntrega ventanaAgregarEntrega = new AgregarEntrega(idVenta);
                ventanaAgregarEntrega.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Finalizar;
    private javax.swing.JComboBox<String> jComboEmpleadoEntrega;
    private javax.swing.JComboBox<String> jComboEstado;
    private com.toedter.calendar.JDateChooser jDateVenta;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelProvincia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextProvincia;
    private javax.swing.JLabel jfecha;
    // End of variables declaration//GEN-END:variables
}
