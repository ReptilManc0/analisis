package Ventanas;

import Clases.Conexion;
import Clases.RedesSociales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VerRedEmpleado extends javax.swing.JFrame {
    private String dniEmpleado;
    public VerRedEmpleado(String dniEmpleado) {
        initComponents();
        this.dniEmpleado=dniEmpleado;
        CargarRedesSocialesEmpleado();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Consulta de Red");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    private void CargarRedesSocialesEmpleado() {
        RedesSociales Red = new RedesSociales();
        DefaultTableModel  tabla = new DefaultTableModel();
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Tipo", "Fecha de Creación","Usuario","Seguidores","Enlace"});
        // Obtiene la conexión a la base de datos
        Connection conexion = Conexion.obtenerConexion();
        int idEmpleado = Red.ObtenerIDEmpleado(dniEmpleado);
        String consulta = "SELECT * FROM `redes sociales` WHERE idEmpleado = " + idEmpleado;
        ResultSet rs = Red.Consultar(consulta);
        // Ejecuta la consulta y llena el modelo con los resultados
        try {
            while (rs.next()) {
                tabla.addRow(new Object[] {(rs.getString("IDredsocial")),(rs.getString("Nombre")),(rs.getString("Tipo")),(rs.getString("FechaCreacion")),(rs.getString("Usuario")),(rs.getString("Seguidores")),(rs.getString("Enlace"))});
                jTableRedSocial.setModel(tabla);
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
        jTableRedSocial = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRedSocial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo", "Fecha de Creación", "Usuario", "Seguidores", "Enlace"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRedSocial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRedSocialMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableRedSocial);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 562, 91));

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel46.setText("Consulta de Red");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 20, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RedSocial.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RedSocial.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 40, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableRedSocialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRedSocialMouseClicked
    }//GEN-LAST:event_jTableRedSocialMouseClicked

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
            java.util.logging.Logger.getLogger(VerRedEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerRedEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerRedEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerRedEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String dniEmpleadoSeleccionado = null;
                VerRedEmpleado ventanaRedEmpleado = new VerRedEmpleado(dniEmpleadoSeleccionado);
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
    private javax.swing.JTable jTableRedSocial;
    // End of variables declaration//GEN-END:variables
}
