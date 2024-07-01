package Ventanas;

import Clases.Clientes;
import Clases.DetallesVentasProductos;
import Clases.Ventas;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class AgregarVenta extends javax.swing.JFrame {
    public AgregarVenta() {
        initComponents();
        setTitle("Agregar Venta");
        setResizable(false);
        setLocationRelativeTo(null);
        Continuar.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        CargarNombresClientes();
        
    }
    private void CargarNombresClientes() {
        Clientes nombreClientes = new Clientes();
        // Obtener los nombres de los clientes
        ResultSet resultSetClientes = nombreClientes.Consultar("SELECT Nombre FROM clientes");
        try {
            // Crear un modelo para el JComboBox
            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

            // Agregar los nombres de los clientes al modelo
            while (resultSetClientes.next()) {
                String nombreCliente = resultSetClientes.getString("Nombre");
                modeloCombo.addElement(nombreCliente);
            }

            // Asignar el modelo al JComboBox
            jComboClienteVenta.setModel(modeloCombo);
        } catch (SQLException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }
    
    public void Limpiar(){
        jTextCantidad.setText(" ");
        jTextMontoTotal.setText(" ");
    }
    public void Validar(){
       
        //Validacion de Fecha
        if(jDateVenta.getDate()==null){
            jfecha.setText("*");
        }else{
            jfecha.setText("");
        }
        
        //Validacion de MontoTotal
        if(jTextMontoTotal.getText().isEmpty()){
            jLabelMontoTotal.setText("*");
        }else{
            jLabelMontoTotal.setText("");
        }
        
        //Validacion de Cantidad
        if(jTextCantidad.getText().isEmpty()){
            jLabelCantidad.setText("*");
        }else{
            jLabelCantidad.setText("");
        }
      
        
        //Validacion general
        if(jDateVenta.getDate()==null||jTextMontoTotal.getText().isEmpty()||jTextCantidad.getText().isEmpty()){
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
        Continuar = new javax.swing.JButton();
        jTextCantidad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jTextMontoTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelMontoTotal = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateVenta = new com.toedter.calendar.JDateChooser();
        jfecha = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboClienteVenta = new javax.swing.JComboBox<>();
        jComboMetodoPago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Fecha:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 62, -1, -1));

        Continuar.setBackground(new java.awt.Color(0, 51, 51));
        Continuar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Continuar.setForeground(new java.awt.Color(255, 255, 255));
        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 221, -1, -1));

        jTextCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(jTextCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 107, 122, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Nueva Venta");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 17, -1, -1));

        jLabelCantidad.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCantidad.setText("*");
        jPanel1.add(jLabelCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 113, -1, -1));

        jTextMontoTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextMontoTotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextMontoTotalKeyTyped(evt);
            }
        });
        jPanel1.add(jTextMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 50, 126, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Monto Total:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 56, -1, -1));

        jButtonSalir.setBackground(new java.awt.Color(0, 51, 51));
        jButtonSalir.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 221, -1, -1));

        jLabelMontoTotal.setForeground(new java.awt.Color(153, 0, 0));
        jLabelMontoTotal.setText("*");
        jPanel1.add(jLabelMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel.setText("Cantidad:");
        jPanel1.add(jLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 113, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("Método de Pago:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 112, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Venta.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 60, 60));

        jDateVenta.setDateFormatString("dd-MM-y");
        jDateVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateVentaKeyTyped(evt);
            }
        });
        jPanel1.add(jDateVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 53, 137, -1));

        jfecha.setForeground(new java.awt.Color(204, 51, 0));
        jfecha.setText("*");
        jPanel1.add(jfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 56, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("Cliente:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 169, -1, -1));

        jComboClienteVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboClienteVentaMouseClicked(evt);
            }
        });
        jComboClienteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClienteVentaActionPerformed(evt);
            }
        });
        jComboClienteVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboClienteVentaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboClienteVentaKeyTyped(evt);
            }
        });
        jPanel1.add(jComboClienteVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 164, 132, -1));

        jComboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Transferencia bancaria" }));
        jComboMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMetodoPagoActionPerformed(evt);
            }
        });
        jComboMetodoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboMetodoPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboMetodoPagoKeyTyped(evt);
            }
        });
        jPanel1.add(jComboMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 107, 101, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboMetodoPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboMetodoPagoKeyTyped
    
    }//GEN-LAST:event_jComboMetodoPagoKeyTyped

    private void jComboMetodoPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboMetodoPagoKeyReleased
        Validar();
    }//GEN-LAST:event_jComboMetodoPagoKeyReleased

    private void jComboMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMetodoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboMetodoPagoActionPerformed

    private void jComboClienteVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboClienteVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboClienteVentaKeyTyped

    private void jComboClienteVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboClienteVentaKeyReleased
    // TODO add your handling code here:
    }//GEN-LAST:event_jComboClienteVentaKeyReleased

    private void jComboClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboClienteVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboClienteVentaActionPerformed

    private void jComboClienteVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboClienteVentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboClienteVentaMouseClicked

    private void jDateVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateVentaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateVentaKeyTyped

    private void jDateVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateVentaKeyReleased
        Validar();        // TODO add your handling code here:
    }//GEN-LAST:event_jDateVentaKeyReleased

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jTextMontoTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMontoTotalKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextMontoTotalKeyTyped

    private void jTextMontoTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMontoTotalKeyReleased
        Validar();
    }//GEN-LAST:event_jTextMontoTotalKeyReleased

    private void jTextCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextCantidadKeyTyped

    private void jTextCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadKeyReleased
        Validar();
    }//GEN-LAST:event_jTextCantidadKeyReleased

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        Ventas vent = new Ventas();
        DetallesVentasProductos DVP = new DetallesVentasProductos();
        //Asignacion de las variables
        vent.fecha=jDateVenta.getDate();
        vent.cantidad=jTextCantidad.getText();
        vent.montoTotal=jTextMontoTotal.getText();
        vent.cliente =jComboClienteVenta.getSelectedItem().toString();
        vent.metodoPago=jComboMetodoPago.getSelectedItem().toString();

        //Parseo de fecha
        long d = vent.fecha.getTime();
        Date fecha = new Date(d);
        vent.fecha=fecha;
        
        //Agregar venta
        vent.AgregarVenta();
        Limpiar();   
        
        int idVenta= DVP.ObtenerUltimoIdventa();
        AgregarEnVenta agr =new AgregarEnVenta(idVenta);
        agr.setVisible(true);
        this.dispose();         
    }//GEN-LAST:event_ContinuarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboClienteVenta;
    private javax.swing.JComboBox<String> jComboMetodoPago;
    private com.toedter.calendar.JDateChooser jDateVenta;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelMontoTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCantidad;
    private javax.swing.JTextField jTextMontoTotal;
    private javax.swing.JLabel jfecha;
    // End of variables declaration//GEN-END:variables
}
