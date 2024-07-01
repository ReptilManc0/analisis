package Ventanas;

import Clases.Conexion;
import Clases.DetallesVentasCombos;
import Clases.DetallesVentasProductos;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class AgregarEnVenta extends javax.swing.JFrame {
    private int idVenta;
    Ventana_Principal ventanaPrincipal= new Ventana_Principal();
    DetallesVentasProductos vp = new DetallesVentasProductos();
    DetallesVentasCombos vc = new DetallesVentasCombos();
    public AgregarEnVenta(int idVenta) {
        initComponents();
        this.idVenta=idVenta;
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agregar en Venta");
        Continuar.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        SeleccionarCombo();
        SeleccionarProducto();
        MostrarIDProducto();
        MostrarIDCombo();
    }
    private void SeleccionarCombo(){
        MostrarNombresCombos();
        jListCombos.setEnabled(false);
        jCheckBoxCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jListCombos.setEnabled(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    jListCombos.clearSelection();
                    jListCombos.setEnabled(false);
                }
            }
        });
    }
    private void MostrarNombresCombos(){
        List<String> nombresCombos = vc.ObtenerNombresCombos();
        // Crear un modelo de lista
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        // Agregar los nombres de combos al modelo de lista
        for (String nombresCombo : nombresCombos) {
            modeloLista.addElement(nombresCombo);
        }
        jListCombos.setModel(modeloLista);
    }
    
    private void SeleccionarProducto(){
        MostrarNombresProductos();
        jListProductos.setEnabled(false);
        jCheckBoxProductos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jListProductos.setEnabled(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    jListProductos.clearSelection();
                    jListProductos.setEnabled(false);
                }
            }
        });
    }
    private void MostrarNombresProductos(){
        List<String> nombresProductos = vp.ObtenerNombresProductos();
        // Crear un modelo de lista
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        // Agregar los nombres de productos al modelo de lista
        for (String nombreProducto : nombresProductos) {
            modeloLista.addElement(nombreProducto);
        }      
        jListProductos.setModel(modeloLista);
    }
    
    private void MostrarIDProducto(){
        jListProductos.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            String nombreProducto = jListProductos.getSelectedValue();
            int idProducto = vp.ObtenerIdProducto(nombreProducto);
            jTextIDProducto.setText(String.valueOf(idProducto));
        }
        });
    }
    private void MostrarIDCombo(){
        jListCombos.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            String nombreCombo = jListCombos.getSelectedValue();
            int idCombo = vc.ObtenerIdCombo(nombreCombo);
            jTextIDCombo.setText(String.valueOf(idCombo));
        }
        });
    }
    
    public void MostrarProductos(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Producto Vendido"});
        vp.idVenta = idVenta;
        String idProductoStr = jTextIDProducto.getText();
        vp.AgregarProductoCombo();

        try (Connection conexion = Conexion.obtenerConexion();
            PreparedStatement statement = conexion.prepareStatement("SELECT p.Nombre FROM `detalles ventas con productos` vp INNER JOIN productos p ON p.IDproducto=vp.IDproducto WHERE IDventa = ?")) {
            int idProducto = Integer.parseInt(idProductoStr);
            vp.idProducto = idProducto;
            // Establecer el valor del parámetro antes de ejecutar la consulta
            statement.setInt(1, vp.idVenta);
            // Ejecutar la consulta y obtener el resultado
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    tabla.addRow(new Object[]{resultSet.getString("Nombre")});
                }
                jTableProductos.setModel(tabla);
                Continuar.setEnabled(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e.getMessage());
        }
    } 
    public void MostrarCombos(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Combo Vendido"});
        vc.idVenta = idVenta;
        String idComboStr = jTextIDCombo.getText();
        vc.AgregarComboVenta();

        try (Connection conexion = Conexion.obtenerConexion();
            PreparedStatement statement = conexion.prepareStatement("SELECT c.Nombre FROM `detalles ventas con combos` vc INNER JOIN combos c ON c.IDcombo=vc.IDcombo WHERE IDventa= ?")) {
            int idCombo = Integer.parseInt(idComboStr);
            vc.idCombo = idCombo;
            // Establecer el valor del parámetro antes de ejecutar la consulta
            statement.setInt(1, vc.idVenta);
            // Ejecutar la consulta y obtener el resultado
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    tabla.addRow(new Object[]{resultSet.getString("Nombre")});
                    
                }
            }
            jTableCombos.setModel(tabla);
            Continuar.setEnabled(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e.getMessage());
        }
    } 
    
    private void AdvertirCantidadStockProducto() {
        List<String> nombresProductos = vp.ObtenerNombresProductos();
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (String nombreProducto : nombresProductos) {
            modeloLista.addElement(nombreProducto);
        }
        jListProductos.setModel(modeloLista);

        // Mostrar mensaje sobre productos con stock igual o menor a 2
        String mensaje = "Es necesario adquirir de proveedores los siguientes productos(tienen en stock menos de 2 elementos):\n";
        for (String nombreProducto : nombresProductos) {
            int cantidadStock = vp.ObtenerCantidadStockProducto(nombreProducto);
            if (cantidadStock <= 2) {
                mensaje += "- " + nombreProducto + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Continuar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListCombos = new javax.swing.JList<>();
        jCheckBoxCombo = new javax.swing.JCheckBox();
        jCheckBoxProductos = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListProductos = new javax.swing.JList<>();
        jTextIDProducto = new javax.swing.JTextField();
        jTextIDCombo = new javax.swing.JTextField();
        AgregarProducto = new javax.swing.JButton();
        AgregarCombo = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCombos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Continuar.setBackground(new java.awt.Color(0, 51, 51));
        Continuar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Continuar.setForeground(new java.awt.Color(255, 255, 255));
        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });
        jPanel1.add(Continuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Agregar en venta");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 15, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Combo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 50, 50));

        jListCombos.setBackground(new java.awt.Color(255, 204, 204));
        jListCombos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListCombosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListCombos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 240, 180));

        jCheckBoxCombo.setText("Seleccionar Combo(s)");
        jCheckBoxCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxComboActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 20));

        jCheckBoxProductos.setText("Seleccionar Producto(s)");
        jCheckBoxProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProductosActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jListProductos.setBackground(new java.awt.Color(255, 204, 204));
        jListProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListProductos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, 180));
        jPanel1.add(jTextIDProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 40, -1));
        jPanel1.add(jTextIDCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 40, -1));

        AgregarProducto.setBackground(new java.awt.Color(0, 51, 51));
        AgregarProducto.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        AgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        AgregarProducto.setText("Agregar Producto");
        AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 140, -1));

        AgregarCombo.setBackground(new java.awt.Color(0, 51, 51));
        AgregarCombo.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        AgregarCombo.setForeground(new java.awt.Color(255, 255, 255));
        AgregarCombo.setText("Agregar Combo");
        AgregarCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarComboActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 140, -1));

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Producto Agregado"
            }
        ));
        jScrollPane4.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 250, 100));

        jTableCombos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Combo Agregado"
            }
        ));
        jScrollPane5.setViewportView(jTableCombos);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 250, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        vp.idVenta = idVenta;
        vc.idVenta = idVenta;
        vp.ActualizarCantidadStockProductos();
        vc.ActualizarCantidadStockCombos();
        AdvertirCantidadStockProducto();
        AgregarEntrega agr =new AgregarEntrega(idVenta);
        agr.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_ContinuarActionPerformed

    private void jListCombosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListCombosMouseClicked

    }//GEN-LAST:event_jListCombosMouseClicked

    private void jCheckBoxComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxComboActionPerformed

    private void jListProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProductosMouseClicked

    }//GEN-LAST:event_jListProductosMouseClicked

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoActionPerformed
        MostrarProductos();
    }//GEN-LAST:event_AgregarProductoActionPerformed

    private void AgregarComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarComboActionPerformed
        MostrarCombos();
    }//GEN-LAST:event_AgregarComboActionPerformed

    private void jCheckBoxProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxProductosActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarEnVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEnVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEnVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEnVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int idVenta = 0;
                AgregarEnVenta ventanaAgregarEnVenta = new AgregarEnVenta(idVenta);
                ventanaAgregarEnVenta.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCombo;
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JButton Continuar;
    private javax.swing.JCheckBox jCheckBoxCombo;
    private javax.swing.JCheckBox jCheckBoxProductos;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListCombos;
    private javax.swing.JList<String> jListProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableCombos;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextIDCombo;
    private javax.swing.JTextField jTextIDProducto;
    // End of variables declaration//GEN-END:variables
}
