package Ventanas;

import Clases.Conexion;
import Clases.Entregas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerEntrega extends javax.swing.JFrame {
    private int idVenta;
    public VerEntrega(int idVenta) {
        initComponents();
        this.idVenta=idVenta;
        CargarEntregaVenta();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Consulta de Entrega");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    private void CargarEntregaVenta() {
        Entregas Ent = new Entregas();
        DefaultTableModel  tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"ID","Fecha","Estado", "Direccion","Provincia","Empleado"});
        // Obtiene la conexión a la base de datos
        Connection conexion = Conexion.obtenerConexion();
        String consulta = "SELECT e.IDentrega, e.Fecha, e.`Estado de entrega`, e.Direccion, e.Provincia, em.Nombre AS Empleado FROM entregas e INNER JOIN empleados em ON e.IDempleado= em.IDempleado WHERE idVenta= " + idVenta;
        ResultSet rs = Ent.Consultar(consulta);
        // Ejecuta la consulta y llena el modelo con los resultados
        try {
            while (rs.next()) {
                tabla.addRow(new Object[] {(rs.getString("IDentrega")),(rs.getString("Fecha")),(rs.getString("Estado de entrega")),(rs.getString("Direccion")),(rs.getString("Provincia")),(rs.getString("Empleado"))});
                jTableEntrega.setModel(tabla);
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableEntrega = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableEntrega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Estado", "Direccion", "Provincia", "Empleado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEntrega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEntregaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableEntrega);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, 781, 50));

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel46.setText("Consulta de Entrega");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Entrega.png"))); // NOI18N
        jLabel8.setToolTipText("");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 50, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Entrega.png"))); // NOI18N
        jLabel9.setToolTipText("");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableEntregaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEntregaMouseClicked

    }//GEN-LAST:event_jTableEntregaMouseClicked

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
            java.util.logging.Logger.getLogger(VerEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerEntrega.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int idVenta = 0;
                VerEntrega ventanaRedEmpleado = new VerEntrega(idVenta);
                ventanaRedEmpleado.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableEntrega;
    // End of variables declaration//GEN-END:variables
}
