package Ventanas;
import Clases.Productos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;

public class AgregarProducto extends javax.swing.JFrame {
    Productos prod= new Productos();
    public AgregarProducto() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agregar Producto");
        Aceptar.setEnabled(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        CargarNombresCategorias();
        CargarNombresProveedores();
    }
    public void Limpiar(){
        jTextNombre.setText(" ");
        jTextDescripcion.setText(" ");
        jTextCantidadStock.setText(" ");
        jTextPrecioUnitario.setText(" ");
    }
    public void Validar(){
        
        //Validacion de Nombre
        if(jTextNombre.getText().isEmpty()){
            jLabelNombre.setText("*");
        }else{
            jLabelNombre.setText("");
        }
        
        //Validacion de Fecha
        //if(jDateChooser1.getDate()==null){
        //     jfecha.setText("*");
        //}else{
        //    jfecha.setText("");
        //}
        
        //Validacion de Descripcion
        if(jTextDescripcion.getText().isEmpty()){
            jLabelDescripcion.setText("*");
        }else{
            jLabelDescripcion.setText("");
        }
        
        //Validacion de Cantidad en Stock
        if(jTextCantidadStock.getText().isEmpty()){
            jLabelCantidadStock.setText("*");
        }else{
            jLabelCantidadStock.setText("");
        }
        
        //Validacion de PrecioUnitario
        if(jTextPrecioUnitario.getText().isEmpty()){
            jLabelPrecioUnitario.setText("*");
        }else{
            jLabelPrecioUnitario.setText("");
        }
        // Validacion de Categoria
        if (jComboCategoriaProducto.getSelectedItem().toString().isEmpty()) {
            jLabelCategoriaProducto.setText("*");
        } else {
            jLabelCategoriaProducto.setText("");
        }
        // Validacion de Proveedor
        if (jComboProveedorProducto.getSelectedItem().toString().isEmpty()) {
            jLabelProveedorProducto.setText("*");
        } else {
            jLabelProveedorProducto.setText("");
        }
        //Validacion general
        if(jTextNombre.getText().isEmpty()||jTextDescripcion.getText().isEmpty()||jTextCantidadStock.getText().isEmpty()||jTextPrecioUnitario.getText().isEmpty()
                ||jComboCategoriaProducto.getSelectedItem().toString().isEmpty()||jComboProveedorProducto.getSelectedItem().toString().isEmpty()){
            Aceptar.setEnabled(false);
        }else{
            Aceptar.setEnabled(true);
        }
    }
    private void CargarNombresCategorias() {
        // Obtener los nombres de las categorias
        ResultSet resultSetCategorias = prod.Consultar("SELECT Nombre FROM categorias");
        try {
            // Crear un modelo para el JComboBox
            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

            // Agregar los nombres de las categorias al modelo
            while (resultSetCategorias.next()) {
                String nombreCategoria = resultSetCategorias.getString("Nombre");
                modeloCombo.addElement(nombreCategoria);
            }

            // Asignar el modelo al JComboBox
            jComboCategoriaProducto.setModel(modeloCombo);
        } catch (SQLException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }
    private void CargarNombresProveedores() {
        // Obtener los nombres de los proveedores
        ResultSet resultSetProveedores = prod.Consultar("SELECT Nombre FROM proveedores");
        try {
            // Crear un modelo para el JComboBox
            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

            // Agregar los nombres de los proveedores al modelo
            while (resultSetProveedores.next()) {
                String nombreProveedor = resultSetProveedores.getString("Nombre");
                modeloCombo.addElement(nombreProveedor);
            }

            // Asignar el modelo al JComboBox
            jComboProveedorProducto.setModel(modeloCombo);
        } catch (SQLException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabelCategoriaProducto = new javax.swing.JLabel();
        jComboCategoriaProducto = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        Salir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextCantidadStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jfecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextDescripcion = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        jLabelCantidadStock = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboProveedorProducto = new javax.swing.JComboBox<>();
        jLabelProveedorProducto = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextPrecioUnitario = new javax.swing.JTextField();
        jLabelPrecioUnitario = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel12.setText("Categoría:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 66, -1, -1));

        jLabelCategoriaProducto.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCategoriaProducto.setText("*");
        jPanel1.add(jLabelCategoriaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 66, -1, -1));

        jComboCategoriaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboCategoriaProductoMouseClicked(evt);
            }
        });
        jComboCategoriaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCategoriaProductoActionPerformed(evt);
            }
        });
        jComboCategoriaProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboCategoriaProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboCategoriaProductoKeyTyped(evt);
            }
        });
        jPanel1.add(jComboCategoriaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 61, 192, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Nuevo Producto");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 17, -1, -1));

        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });
        jPanel1.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 59, 193, -1));

        Salir.setBackground(new java.awt.Color(0, 51, 51));
        Salir.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 234, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Fecha de agregación:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 148, -1, -1));

        jDateChooser1.setDateFormatString("dd-MM-y");
        jDateChooser1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooser1KeyTyped(evt);
            }
        });
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 142, 137, -1));

        jTextCantidadStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCantidadStockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCantidadStockKeyTyped(evt);
            }
        });
        jPanel1.add(jTextCantidadStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 142, 158, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Descripción:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 111, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad en Stock:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 148, -1, -1));

        jfecha.setForeground(new java.awt.Color(204, 51, 0));
        jfecha.setText("*");
        jPanel1.add(jfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 142, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 65, -1, -1));

        jTextDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDescripcionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(jTextDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 102, 498, -1));

        jLabelNombre.setForeground(new java.awt.Color(153, 0, 0));
        jLabelNombre.setText("*");
        jPanel1.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 65, -1, -1));

        Aceptar.setBackground(new java.awt.Color(0, 51, 51));
        Aceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        jPanel1.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 234, -1, -1));

        jLabelCantidadStock.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCantidadStock.setText("*");
        jPanel1.add(jLabelCantidadStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 148, -1, -1));

        jLabelDescripcion.setForeground(new java.awt.Color(153, 0, 0));
        jLabelDescripcion.setText("*");
        jPanel1.add(jLabelDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 108, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setText("Proveedor:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 194, -1, -1));

        jComboProveedorProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboProveedorProductoMouseClicked(evt);
            }
        });
        jComboProveedorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProveedorProductoActionPerformed(evt);
            }
        });
        jComboProveedorProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboProveedorProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboProveedorProductoKeyTyped(evt);
            }
        });
        jPanel1.add(jComboProveedorProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 189, 198, -1));

        jLabelProveedorProducto.setForeground(new java.awt.Color(153, 0, 0));
        jLabelProveedorProducto.setText("*");
        jPanel1.add(jLabelProveedorProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(308, 194, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Precio unitario:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 194, -1, -1));

        jTextPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPrecioUnitarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioUnitarioKeyTyped(evt);
            }
        });
        jPanel1.add(jTextPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 188, 158, -1));

        jLabelPrecioUnitario.setForeground(new java.awt.Color(153, 0, 0));
        jLabelPrecioUnitario.setText("*");
        jPanel1.add(jLabelPrecioUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 194, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Producto.png"))); // NOI18N
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 9, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_SalirActionPerformed

    private void jDateChooser1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyReleased

    private void jDateChooser1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooser1KeyTyped

    private void jTextDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDescripcionKeyReleased
        Validar();
    }//GEN-LAST:event_jTextDescripcionKeyReleased

    private void jTextDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDescripcionKeyTyped

    }//GEN-LAST:event_jTextDescripcionKeyTyped

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        //Asignacion de las variables
        prod.nombre=jTextNombre.getText();
        prod.cantidadStock=jTextCantidadStock.getText();
        prod.categoria=jComboCategoriaProducto.getSelectedItem().toString();
        prod.fechaAgregacion=jDateChooser1.getDate();
        prod.precioUnitario= jTextPrecioUnitario.getText();
        prod.proveedor=jComboProveedorProducto.getSelectedItem().toString();
        prod.descripcion=jTextDescripcion.getText();

        //Conversion de la fecha para mySql
        long d =prod.fechaAgregacion.getTime();
        Date fecha = new Date(d);
        prod.fechaAgregacion=fecha;

        //Agregar producto
        prod.AgregarProducto();
        Limpiar();
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void jComboCategoriaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboCategoriaProductoMouseClicked

    }//GEN-LAST:event_jComboCategoriaProductoMouseClicked

    private void jComboCategoriaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCategoriaProductoActionPerformed

    }//GEN-LAST:event_jComboCategoriaProductoActionPerformed

    private void jComboCategoriaProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCategoriaProductoKeyReleased
        Validar();
    }//GEN-LAST:event_jComboCategoriaProductoKeyReleased

    private void jComboCategoriaProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCategoriaProductoKeyTyped

    }//GEN-LAST:event_jComboCategoriaProductoKeyTyped

    private void jTextNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyReleased
        Validar();
    }//GEN-LAST:event_jTextNombreKeyReleased

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
        char validar = evt.getKeyChar();

        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jTextCantidadStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadStockKeyReleased
        Validar();
    }//GEN-LAST:event_jTextCantidadStockKeyReleased

    private void jTextCantidadStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadStockKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextCantidadStockKeyTyped

    private void jComboProveedorProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboProveedorProductoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProveedorProductoMouseClicked

    private void jComboProveedorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProveedorProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProveedorProductoActionPerformed

    private void jComboProveedorProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboProveedorProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProveedorProductoKeyReleased

    private void jComboProveedorProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboProveedorProductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProveedorProductoKeyTyped

    private void jTextPrecioUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioUnitarioKeyReleased
        Validar();
    }//GEN-LAST:event_jTextPrecioUnitarioKeyReleased

    private void jTextPrecioUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioUnitarioKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextPrecioUnitarioKeyTyped

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
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Salir;
    private javax.swing.JComboBox<String> jComboCategoriaProducto;
    private javax.swing.JComboBox<String> jComboProveedorProducto;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCantidadStock;
    private javax.swing.JLabel jLabelCategoriaProducto;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecioUnitario;
    private javax.swing.JLabel jLabelProveedorProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCantidadStock;
    private javax.swing.JTextField jTextDescripcion;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextPrecioUnitario;
    private javax.swing.JLabel jfecha;
    // End of variables declaration//GEN-END:variables
}
