package Ventanas;

import Clases.Conexion;
import Clases.ConsumiblesEnCombo;
import Clases.ProductosEnCombo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerDetallesCombo extends javax.swing.JFrame {
    private int idCombo;
    public VerDetallesCombo(int idCombo) {
        initComponents();
        this.idCombo=idCombo;
        CargarProductosCombo();
        CargarConsumiblesCombo();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Detalles de Combo");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private void CargarProductosCombo() {
        ProductosEnCombo Prod = new ProductosEnCombo();
        DefaultTableModel  tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Producto(s) en combo"});
        // Obtiene la conexión a la base de datos
        Connection conexion = Conexion.obtenerConexion();
        String consulta = "SELECT p.Nombre FROM `productos en combos` pc INNER JOIN productos p ON p.IDproducto= pc.IDproducto WHERE IDcombo= " + idCombo;
        ResultSet rs = Prod.Consultar(consulta);
        // Ejecuta la consulta y llena el modelo con los resultados
        try {
            while (rs.next()) {
                tabla.addRow(new Object[] {(rs.getString("Nombre"))});
                jTableProductos.setModel(tabla);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e);
        } finally {
            // Cierra la conexión después de usarla
            Conexion.cerrarConexion(conexion);
        }
    }
    private void CargarConsumiblesCombo() {
        ConsumiblesEnCombo Cons = new ConsumiblesEnCombo();
        DefaultTableModel  tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"Consumible(s) en combo"});
        // Obtiene la conexión a la base de datos
        Connection conexion = Conexion.obtenerConexion();
        String consulta = "SELECT c.Nombre FROM `consumibles en combos` pc INNER JOIN consumibles c ON c.IDconsumible= pc.IDconsumible WHERE IDcombo= " + idCombo;
        ResultSet rs = Cons.Consultar(consulta);
        // Ejecuta la consulta y llena el modelo con los resultados
        try {
            boolean tieneConsumibles = false;
            while (rs.next()) {
                tieneConsumibles = true;
                tabla.addRow(new Object[] {(rs.getString("Nombre"))});
                jTableConsumibles.setModel(tabla);
            }
            if (!tieneConsumibles) {
            // Si no tiene consumibles, mostrar el mensaje en el jLabel
            jLabelConsumible.setText("Este combo no presenta algún consumible");
            } else {
            // Si tiene consumibles, asegurarse de que el jLabel muestre el texto vacío
            jLabelConsumible.setText("");
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
        jTableConsumibles = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabelConsumible = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Detalles de Combo");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Combo.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 50, 50));

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto en Combo"
            }
        ));
        jScrollPane4.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, 120));

        jTableConsumibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Consumible en Combo"
            }
        ));
        jScrollPane5.setViewportView(jTableConsumibles);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 300, 120));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Combo.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 50, 50));

        jLabelConsumible.setFont(new java.awt.Font("Bookman Old Style", 2, 12)); // NOI18N
        jLabelConsumible.setText(".");
        jPanel1.add(jLabelConsumible, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(VerDetallesCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDetallesCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDetallesCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDetallesCombo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int idCombo = 0;
                VerDetallesCombo ventanaDetalleCombo = new VerDetallesCombo(idCombo);
                ventanaDetalleCombo.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelConsumible;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableConsumibles;
    private javax.swing.JTable jTableProductos;
    // End of variables declaration//GEN-END:variables
}
