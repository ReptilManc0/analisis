package Ventanas;

import Clases.Conexion;
import Clases.ConsumiblesEnCombo;
import Clases.DetallesVentasProductos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerDetallesVenta extends javax.swing.JFrame {
    private int idVenta;
    public VerDetallesVenta(int idVenta) {
        initComponents();
        this.idVenta=idVenta;
        CargarProductosVenta();
        CargarCombosVenta();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Detalles de Venta");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    private void CargarProductosVenta() {
        DetallesVentasProductos Prod = new DetallesVentasProductos();
        DefaultTableModel  tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Producto(s) vendido(s)"});
        // Obtiene la conexión a la base de datos
        Connection conexion = Conexion.obtenerConexion();
        String consulta = "SELECT p.Nombre FROM `detalles ventas con productos` pv INNER JOIN productos p ON p.IDproducto= pv.IDproducto WHERE IDventa= " + idVenta;
        ResultSet rs = Prod.Consultar(consulta);
        // Ejecuta la consulta y llena el modelo con los resultados
        try {
            boolean tieneProductos = false;
            while (rs.next()) {
                tieneProductos = true;
                tabla.addRow(new Object[] {(rs.getString("Nombre"))});
                jTableProductos.setModel(tabla);
            }
            if (!tieneProductos) {
            // Si no tiene productos, mostrar el mensaje en el jLabel
            jLabelProducto.setText("En esta venta no se vendió ningún producto");
            } else {
            // Si tiene productos, asegurarse de que el jLabel muestre el texto vacío
            jLabelProducto.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        } finally {
            // Cierra la conexión después de usarla
            Conexion.cerrarConexion(conexion);
        }
    }
    private void CargarCombosVenta(){
        ConsumiblesEnCombo Cons = new ConsumiblesEnCombo();
        DefaultTableModel  tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Combo(s) vendido(s)"});
        // Obtiene la conexión a la base de datos
        Connection conexion = Conexion.obtenerConexion();
        String consulta = "SELECT c.Nombre FROM `detalles ventas con combos` cv INNER JOIN combos c ON c.IDcombo= cv.IDcombo WHERE IDventa= " + idVenta;
        ResultSet rs = Cons.Consultar(consulta);
        // Ejecuta la consulta y llena el modelo con los resultados
        try {
            boolean tieneCombos = false;
            while (rs.next()) {
                tieneCombos = true;
                tabla.addRow(new Object[] {(rs.getString("Nombre"))});
                jTableCombos.setModel(tabla);
            }
            if (!tieneCombos) {
            // Si no tiene combos, mostrar el mensaje en el jLabel
            jLabelCombo.setText("En esta venta no se vendió ningún combo");
            } else {
            // Si tiene combos, asegurarse de que el jLabel muestre el texto vacío
            jLabelCombo.setText("");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        } finally {
            // Cierra la conexión después de usarla
            Conexion.cerrarConexion(conexion);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCombos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabelProducto = new javax.swing.JLabel();
        jLabelCombo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Detalles de Venta");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Venta.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 50, 50));

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto Vendido"
            }
        ));
        jScrollPane4.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, 120));

        jTableCombos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Combo vendido"
            }
        ));
        jScrollPane5.setViewportView(jTableCombos);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 300, 120));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Venta.png"))); // NOI18N
        jLabel10.setToolTipText("");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 60, 50));

        jLabelProducto.setFont(new java.awt.Font("Bookman Old Style", 2, 12)); // NOI18N
        jLabelProducto.setText(".");
        jPanel1.add(jLabelProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabelCombo.setFont(new java.awt.Font("Bookman Old Style", 2, 12)); // NOI18N
        jLabelCombo.setText(".");
        jPanel1.add(jLabelCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VerDetallesVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDetallesVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDetallesVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDetallesVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int idVenta = 0;
                VerDetallesVenta ventanaDetalleVenta = new VerDetallesVenta(idVenta);
                ventanaDetalleVenta.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCombo;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableCombos;
    private javax.swing.JTable jTableProductos;
    // End of variables declaration//GEN-END:variables
}
