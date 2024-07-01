/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Clases.Proveedores;
import Clases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Usuario
 */
public class AgregarProveedor extends javax.swing.JFrame {

    /**
     * Creates new form AgregarCliente
     */
    public AgregarProveedor() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Agregar Proveedor");
        Aceptar.setEnabled(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }
    public void Limpiar(){
        jTextNombre.setText(" ");
        jTextRUC.setText(" ");
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
        
        //Validacion de direccion
        if(jTextDireccion.getText().isEmpty()){
            JlabelDireccion.setText("*");
        }else{
            JlabelDireccion.setText("");
        }
        
        //Validacion de RUC
        if(jTextRUC.getText().isEmpty()||jTextRUC.getText().length()<11){
            jLabelRUC.setText("*");
        }else{
            jLabelRUC.setText("");
        }
        
        //Validacion de Telefono
        if(jTextTelefono.getText().isEmpty()||jTextTelefono.getText().length()<9){
            jLabelTelefono.setText("*");
        }else{
            jLabelTelefono.setText("");
        }
        
        // Validacion de Categoria
        if (jComboCategoria.getSelectedItem().toString().equals("Seleccione")) {
            jLabelCateg.setText("*");
        } else {
            jLabelCateg.setText("");
        }

        // Validacion de Tipo
        if (jComboTipo.getSelectedItem().toString().equals("Seleccione")) {
            jLabelTipo.setText("*");
        } else {
            jLabelTipo.setText("");
        }
        
        //Validacion de Correo
        if(jTextCorreo.getText().isEmpty()){
            JlabelCorreo.setText("*");
        }else if (!jTextCorreo.getText().contains("@")||!jTextCorreo.getText().contains(".")){
            JlabelCorreo.setText("Correo invalido");
        }else{
            JlabelCorreo.setText("");
        }
        
        if(jTextNombre.getText().isEmpty()||jTextDireccion.getText().isEmpty()||jTextDireccion.getText().isEmpty()||jTextRUC.getText().isEmpty()||jTextRUC.getText().length()<11||jTextTelefono.getText().isEmpty()||jTextTelefono.getText().length()<9||jTextCorreo.getText().isEmpty()
                ||jComboCategoria.getSelectedIndex()== 0||jComboTipo.getSelectedIndex()== 0){
            Aceptar.setEnabled(false);
        }else{
            Aceptar.setEnabled(true);
        }       
    }

    /**
     * This method is called from within the constructor o initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextNombre = new javax.swing.JTextField();
        jTextCorreo = new javax.swing.JTextField();
        jTextDireccion = new javax.swing.JTextField();
        jTextTelefono = new javax.swing.JTextField();
        jLabelNom = new javax.swing.JLabel();
        JlabelCorreo = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelRUC = new javax.swing.JLabel();
        jLabelCateg = new javax.swing.JLabel();
        Aceptar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextRUC = new javax.swing.JTextField();
        jComboCategoria = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboTipo = new javax.swing.JComboBox<>();
        jLabelTipo = new javax.swing.JLabel();
        JlabelDireccion = new javax.swing.JLabel();

        jLabel5.setText("Fecha de nacimiento:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setText("Tipo de proveedor");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setText("Telefono:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setText("Correo");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setText("Direccion");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setText("RUC");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");

        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreKeyTyped(evt);
            }
        });

        jTextCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCorreoKeyReleased(evt);
            }
        });

        jTextDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyTyped(evt);
            }
        });

        jTextTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoKeyTyped(evt);
            }
        });

        jLabelNom.setForeground(new java.awt.Color(153, 0, 0));
        jLabelNom.setText("*");

        JlabelCorreo.setForeground(new java.awt.Color(153, 0, 0));
        JlabelCorreo.setText("*");

        jLabelTelefono.setForeground(new java.awt.Color(153, 0, 0));
        jLabelTelefono.setText("*");

        jLabelRUC.setForeground(new java.awt.Color(153, 0, 0));
        jLabelRUC.setText("*");

        jLabelCateg.setForeground(new java.awt.Color(153, 0, 0));
        jLabelCateg.setText("*");

        Aceptar.setBackground(new java.awt.Color(0, 51, 51));
        Aceptar.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel13.setText("Nuevo Proveedor");

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Berlin Sans FB", 0, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/personal.png"))); // NOI18N

        jTextRUC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextRUCActionPerformed(evt);
            }
        });
        jTextRUC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextRUCKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRUCKeyTyped(evt);
            }
        });

        jComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Papelería", "Artículos", "Jardinería", "Madera" }));
        jComboCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboCategoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboCategoriaKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel9.setText("Categoria");

        jComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Ocasional", "Fijo" }));
        jComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoActionPerformed(evt);
            }
        });
        jComboTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboTipoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboTipoKeyTyped(evt);
            }
        });

        jLabelTipo.setForeground(new java.awt.Color(153, 0, 0));
        jLabelTipo.setText("*");

        JlabelDireccion.setForeground(new java.awt.Color(153, 0, 0));
        JlabelDireccion.setText("*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)
                            .addComponent(Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(170, 170, 170))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(314, 314, 314)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabelTipo))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNom)
                                        .addComponent(JlabelDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4))
                                    .addGap(39, 39, 39)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                        .addComponent(jTextRUC))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(JlabelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelRUC))))
                            .addContainerGap(52, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel9))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboCategoria, 0, 205, Short.MAX_VALUE)
                        .addComponent(jTextTelefono))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelTelefono)
                        .addComponent(jLabelCateg, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(32, 32, 32)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNom)
                    .addComponent(jLabel1)
                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRUC))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlabelCorreo)
                    .addComponent(jTextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlabelDireccion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabel7)
                            .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTipo))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCateg))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(Aceptar))
                .addGap(35, 35, 35))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
    //Asignacion de las variables
        Proveedores prov = new Proveedores();
        prov.nombre=jTextNombre.getText();
        prov.ruc=jTextRUC.getText();
        prov.direccion=jTextDireccion.getText();
        prov.correoElectronico=jTextCorreo.getText();
        prov.telefono=jTextTelefono.getText();
        prov.categoria=jComboCategoria.getSelectedItem();
        prov.tipo=jComboTipo.getSelectedItem();
        
    //Agregar proveedor
    
    prov.AgregarProveedor(); 
    Limpiar();
    this.dispose();
        
    }//GEN-LAST:event_AceptarActionPerformed

    private void jTextNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyReleased
        Validar();
    }//GEN-LAST:event_jTextNombreKeyReleased

    private void jTextCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoKeyReleased
        Validar();
    }//GEN-LAST:event_jTextCorreoKeyReleased

    private void jTextDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyReleased
        Validar();
    }//GEN-LAST:event_jTextDireccionKeyReleased

    private void jTextTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyReleased
        Validar();
    }//GEN-LAST:event_jTextTelefonoKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyTyped
char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextDireccionKeyTyped

    private void jTextTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoKeyTyped
        if(jTextTelefono.getText().length()>=9){
            evt.consume();
        }
    
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextTelefonoKeyTyped

    private void jTextRUCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRUCKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
        if(jTextRUC.getText().length()>=11){
        evt.consume();
    }
    }//GEN-LAST:event_jTextRUCKeyTyped

    private void jTextRUCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRUCKeyReleased
     Validar();
    }//GEN-LAST:event_jTextRUCKeyReleased

    private void jTextNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyTyped
       char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextNombreKeyTyped

    private void jComboCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCategoriaKeyTyped

    private void jComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTipoActionPerformed

    private void jComboTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboTipoKeyTyped
       
    }//GEN-LAST:event_jComboTipoKeyTyped

    private void jTextRUCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextRUCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRUCActionPerformed

    private void jComboTipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboTipoKeyReleased
       Validar();
    }//GEN-LAST:event_jComboTipoKeyReleased

    private void jComboCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCategoriaKeyReleased
        Validar();
    }//GEN-LAST:event_jComboCategoriaKeyReleased

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
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JLabel JlabelCorreo;
    private javax.swing.JLabel JlabelDireccion;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboCategoria;
    private javax.swing.JComboBox<String> jComboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCateg;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelRUC;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextRUC;
    private javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables
}