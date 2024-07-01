package Ventanas;

import Clases.Conexion;
import Clases.ConsumiblesEnCombo;
import Clases.ProductosEnCombo;
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

public class AgregarEnCombo extends javax.swing.JFrame {
    private int idCombo;
    ProductosEnCombo pc = new ProductosEnCombo();
    ConsumiblesEnCombo cc = new ConsumiblesEnCombo();
    
    public AgregarEnCombo(int idCombo) {
        initComponents();
        this.idCombo=idCombo;
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agregar en Combo");
        Finalizar.setEnabled(false);
        AgregarConsumible.setEnabled(false);
        jCheckBoxProductos.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        MostrarNombresProductos();
        SeleccionarConsumible();
        MostrarIDProducto();
        MostrarIDConsumible();
    }
    private void SeleccionarConsumible(){
        MostrarNombresConsumibles();
        jListConsumibles.setEnabled(false);
        jCheckBoxConsumibles.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jListConsumibles.setEnabled(true);
                    AgregarConsumible.setEnabled(true);
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    jListConsumibles.clearSelection();
                    jListConsumibles.setEnabled(false);
                }
            }
        });
    }

    private void MostrarNombresProductos(){
        List<String> nombresProductos = pc.ObtenerNombresProductos();
        // Crear un modelo de lista
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        // Agregar los nombres de productos al modelo de lista
        for (String nombreProducto : nombresProductos) {
            modeloLista.addElement(nombreProducto);
        }
        jListProductos.setModel(modeloLista);
    }
    private void MostrarNombresConsumibles(){
        List<String> nombresConsumibles = cc.ObtenerNombresConsumibles();
        // Crear un modelo de lista
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        // Agregar los nombres de consumibles al modelo de lista
        for (String nombresConsumible : nombresConsumibles) {
            modeloLista.addElement(nombresConsumible);
        }
        jListConsumibles.setModel(modeloLista);
    }
    
    private void MostrarIDProducto(){
        jListProductos.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            String nombreProducto = jListProductos.getSelectedValue();
            int idProducto = pc.ObtenerIdProducto(nombreProducto);
            jTextIDProducto.setText(String.valueOf(idProducto));
        }
        });
    }
    private void MostrarIDConsumible(){
        jListConsumibles.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            String nombreConsumible = jListConsumibles.getSelectedValue();
            int idConsumible = cc.ObtenerIdConsumible(nombreConsumible);
            jTextIDConsumible.setText(String.valueOf(idConsumible));
        }
        });
    }
    
    public void MostrarProductos(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Producto Agregado"});
        pc.idCombo = idCombo;
        String idProductoStr = jTextIDProducto.getText();
        pc.AgregarProductoCombo();

        try (Connection conexion = Conexion.obtenerConexion();
            PreparedStatement statement = conexion.prepareStatement("SELECT p.Nombre FROM `productos en combos` pc INNER JOIN productos p ON p.IDproducto=pc.IDproducto WHERE IDcombo = ?")) {
            int idProducto = Integer.parseInt(idProductoStr);
            pc.idProducto = idProducto;
            // Establecer el valor del parámetro antes de ejecutar la consulta
            statement.setInt(1, pc.idCombo);
            // Ejecutar la consulta y obtener el resultado
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    tabla.addRow(new Object[]{resultSet.getString("Nombre")});
                }
            }
            jTableProductos.setModel(tabla);
            Finalizar.setEnabled(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e.getMessage());
        }
    } 
    public void MostrarConsumibles(){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Consumible Agregado"});
        cc.idCombo = idCombo;
        String idConsumibleStr = jTextIDConsumible.getText();
        cc.AgregarConsumibleCombo();

        try (Connection conexion = Conexion.obtenerConexion();
            PreparedStatement statement = conexion.prepareStatement("SELECT c.Nombre FROM `consumibles en combos` cc INNER JOIN consumibles c ON c.IDconsumible=cc.IDconsumible WHERE IDcombo = ?")) {
            int idConsumible = Integer.parseInt(idConsumibleStr);
            cc.idConsumible = idConsumible;
            // Establecer el valor del parámetro antes de ejecutar la consulta
            statement.setInt(1, cc.idCombo);
            // Ejecutar la consulta y obtener el resultado
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    tabla.addRow(new Object[]{resultSet.getString("Nombre")});
                }
            }
            jTableConsumibles.setModel(tabla);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e.getMessage());
        }
    } 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Finalizar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListConsumibles = new javax.swing.JList<>();
        jCheckBoxConsumibles = new javax.swing.JCheckBox();
        jCheckBoxProductos = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListProductos = new javax.swing.JList<>();
        jTextIDProducto = new javax.swing.JTextField();
        jTextIDConsumible = new javax.swing.JTextField();
        AgregarProducto = new javax.swing.JButton();
        AgregarConsumible = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableConsumibles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Finalizar.setBackground(new java.awt.Color(0, 51, 51));
        Finalizar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Finalizar.setForeground(new java.awt.Color(255, 255, 255));
        Finalizar.setText("Finalizar");
        Finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(Finalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Agregar en combo");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 15, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Combo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 50, 50));

        jListConsumibles.setBackground(new java.awt.Color(255, 204, 204));
        jListConsumibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListConsumiblesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListConsumibles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 240, 180));

        jCheckBoxConsumibles.setText("Seleccionar Consumibles");
        jCheckBoxConsumibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxConsumiblesActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxConsumibles, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, 20));
        jCheckBoxConsumibles.getAccessibleContext().setAccessibleName("jCheckBoxProductos");

        jCheckBoxProductos.setSelected(true);
        jCheckBoxProductos.setText("Seleccionar Productos");
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
        jPanel1.add(jTextIDConsumible, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 40, -1));

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

        AgregarConsumible.setBackground(new java.awt.Color(0, 51, 51));
        AgregarConsumible.setFont(new java.awt.Font("Britannic Bold", 0, 12)); // NOI18N
        AgregarConsumible.setForeground(new java.awt.Color(255, 255, 255));
        AgregarConsumible.setText("Agregar Consumible");
        AgregarConsumible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarConsumibleActionPerformed(evt);
            }
        });
        jPanel1.add(AgregarConsumible, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 140, -1));

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

        jTableConsumibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Consumible"
            }
        ));
        jScrollPane5.setViewportView(jTableConsumibles);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 250, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalizarActionPerformed
        dispose();
    }//GEN-LAST:event_FinalizarActionPerformed

    private void jCheckBoxConsumiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxConsumiblesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxConsumiblesActionPerformed

    private void jListProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProductosMouseClicked
 
    }//GEN-LAST:event_jListProductosMouseClicked

    private void jListConsumiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListConsumiblesMouseClicked
    
    }//GEN-LAST:event_jListConsumiblesMouseClicked

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProductoActionPerformed
        MostrarProductos();    
    }//GEN-LAST:event_AgregarProductoActionPerformed

    private void AgregarConsumibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarConsumibleActionPerformed
        MostrarConsumibles(); 
    }//GEN-LAST:event_AgregarConsumibleActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarEnCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEnCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEnCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEnCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int idCombo = 0;
                AgregarEnCombo ventanaAgregarEnCombo = new AgregarEnCombo(idCombo);
                ventanaAgregarEnCombo.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarConsumible;
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JButton Finalizar;
    private javax.swing.JCheckBox jCheckBoxConsumibles;
    private javax.swing.JCheckBox jCheckBoxProductos;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListConsumibles;
    private javax.swing.JList<String> jListProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableConsumibles;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTextIDConsumible;
    private javax.swing.JTextField jTextIDProducto;
    // End of variables declaration//GEN-END:variables
}
