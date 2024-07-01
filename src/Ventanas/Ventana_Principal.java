package Ventanas;
import Clases.Categorias;
import Clases.Cargos;
import Clases.Clientes;
import Clases.Combos;
import Clases.Conexion;
import Clases.Proveedores;
import Clases.Consumibles;
import Clases.Empleados;
import Clases.Productos;
import Clases.RedesSociales;
import Clases.Ventas;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Ventana_Principal extends javax.swing.JFrame {
    
    
    public Ventana_Principal() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Gestor de inventario");
        
        BotonActualizarCliente.setEnabled(false);
        BotonActualizarProveedor.setEnabled(false);
        BotonActualizarCargo.setEnabled(false);
        BotonActualizarCategoria.setEnabled(false);
        BotonActualizarCombo.setEnabled(false);
        BotonActualizarEmpleado.setEnabled(false);
        BotonActualizarProducto.setEnabled(false);
        BotonActualizarCombo.setEnabled(false);
        BotonActualizarConsumible.setEnabled(false);
        BotonActualizarVentas.setEnabled(false);
        jButtonVerRed.setEnabled(false);
        jButtonVerEntrega.setEnabled(false);
        jButtonVerDetallesCombos.setEnabled(false);
        jButtonVerDetallesVentas.setEnabled(false);
         
        Font font = new Font("Georgia",Font.ITALIC, 14);
        UIManager.put("OptionPane.messageFont", font);
        CargarNombresCargos();
        CargarNombresProveedores();
        CargarNombresCategorias();
        CargarNombresClientes();

    }
    private void CargarNombresCargos() {
        Cargos nombreCargos = new Cargos();
        // Obtener los nombres de los cargos
        ResultSet resultSetCargos = nombreCargos.Consultar("SELECT Nombre FROM cargos");
        try {
            // Crea un modelo para el JComboBox
            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

            // Agrega los nombres de los cargos al modelo
            while (resultSetCargos.next()) {
                String nombreCargo = resultSetCargos.getString("Nombre");
                modeloCombo.addElement(nombreCargo);
            }

            // Asigna el modelo al JComboBox
            jComboCargoEmpleado.setModel(modeloCombo);
        } catch (SQLException e) {
            // Maneja cualquier excepción
            e.printStackTrace();
        }
    }
    private void CargarNombresCategorias() {
        // Obtener los nombres de las categorias
        Categorias nombreCategorias = new Categorias();
        ResultSet resultSetCategorias = nombreCategorias.Consultar("SELECT Nombre FROM categorias");
        try {
            // Crea un modelo para el JComboBox
            DefaultComboBoxModel<String> modeloCombo = new DefaultComboBoxModel<>();

            // Agrega los nombres de las categorias al modelo
            while (resultSetCategorias.next()) {
                String nombreCategoria = resultSetCategorias.getString("Nombre");
                modeloCombo.addElement(nombreCategoria);
            }

            // Asigna el modelo al JComboBox
            jComboCategoriaProducto.setModel(modeloCombo);
        } catch (SQLException e) {
            // Maneja cualquier excepción
            e.printStackTrace();
        }
    }
    private void CargarNombresProveedores() {
        Proveedores nombreProveedores = new Proveedores();
        // Obtener los nombres de los proveedores
        ResultSet resultSetProveedores = nombreProveedores.Consultar("SELECT Nombre FROM proveedores");
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
            jComboClienteVentas.setModel(modeloCombo);
        } catch (SQLException e) {
            // Manejar cualquier excepción
            e.printStackTrace();
        }
    }
    
    public void ValidarDatosCliente(){
        
        //Validacion de Correo
        if(jTextCorreoCliente.getText().isEmpty()){
            jLabelcorreoCliente.setText("*");
        }else if (!jTextCorreoCliente.getText().contains("@")||!jTextCorreoCliente.getText().contains(".")){
            jLabelcorreoCliente.setText("Correo invalido");
        }else{
            jLabelcorreoCliente.setText("");
        }
        
        //Validacion de Telefono
        if(jTelefonoCliente.getText().isEmpty()||jTelefonoCliente.getText().length()<9){
            jLabelTelefonoCliente.setText("*");
        }else{
            jLabelTelefonoCliente.setText("");
        }
        //Validacion de nombre
        if(JtextNombreCliente.getText().isEmpty()){
            jLabelnombreCliente.setText("*");
        }else{
            jLabelnombreCliente.setText("");
        }
        
        //Validacion de apellidos
        if(jtextApellidoCliente.getText().isEmpty()){
            jLabelApellidoCliente.setText("*");
        }else{
            jLabelApellidoCliente.setText("");
        }
        //Validacion general
        if(jTextCorreoCliente.getText().isEmpty()||jTextCorreoCliente.getText().isEmpty()||!jTextCorreoCliente.getText().contains("@")||!jTextCorreoCliente.getText().contains(".")||
                jTelefonoCliente.getText().isEmpty()||jTelefonoCliente.getText().length()<9||JtextNombreCliente.getText().isEmpty()||jtextApellidoCliente.getText().isEmpty()){
            BotonActualizarCliente.setEnabled(false);
        }else{
            BotonActualizarCliente.setEnabled(true);
        }
    }
    public void ValidarDatosCargos(){
        
        //Validacion de nombre
        if(JtextNombreCargo.getText().isEmpty()){
            jLabelnombreCargo.setText("*");
        }else{
            jLabelnombreCargo.setText("");
        }
        
        //Validacion de descripcion
        if(jtextDescripcionCargo.getText().isEmpty()){
            jLabelDescripcionCargo.setText("*");
        }else{
            jLabelDescripcionCargo.setText("");
        }
        
        //Validacion de sueldo
        if(jTextSueldoCargo.getText().isEmpty()){
            jLabelSueldoCargo.setText("*");
        }else{
            jLabelSueldoCargo.setText("");
        }
        //Validacion general
        if(JtextNombreCargo.getText().isEmpty()||jtextDescripcionCargo.getText().isEmpty()||jTextSueldoCargo.getText().isEmpty()){
            BotonActualizarCargo.setEnabled(false);
        }else{
            BotonActualizarCargo.setEnabled(true);
        }
    }
    public void ValidarDatosProveedor(){
        
        //Validacion de nombre
        if(jTextNombreProvee.getText().isEmpty()){
            jLabelNombreProve.setText("*");
        }else{
            jLabelNombreProve.setText("");
        }
        
        //Validacion El RUC
        if(jTextRUCProve.getText().isEmpty()||jTextRUCProve.getText().length()<11 ){
            jLabelRUCProve.setText("*");
        }else{
            jLabelRUCProve.setText("");
        }
        
        //Validacion de Telefono
        if(jTextTelfProvee.getText().isEmpty()|| jTextTelfProvee.getText().length()<9){
            JLabelTelefonoProve.setText("*");
        }else{
            JLabelTelefonoProve.setText("");
        }
        //Validacion de Correo
        if(jTextCorreoProvee.getText().isEmpty()){
            jLabelCorreoProvee.setText("*");
        }else if (!jTextCorreoProvee.getText().contains("@")||!jTextCorreoProvee.getText().contains(".")){
            jLabelCorreoProvee.setText("Correo invalido");
        }else{
            jLabelCorreoProvee.setText("");
        }
        
        
        //Validacion general
        if(jTextNombreProvee.getText().isEmpty()||jTextRUCProve.getText().isEmpty()||jTextRUCProve.getText().length()<11 
                ||jTextTelfProvee.getText().isEmpty()|| jTextTelfProvee.getText().length()<9||jTextCorreoProvee.getText().isEmpty()
                ||!jTextCorreoProvee.getText().contains("@")||!jTextCorreoProvee.getText().contains(".")){
            BotonActualizarProveedor.setEnabled(false);
        }else{
            BotonActualizarProveedor.setEnabled(true);
        }
    }
    public void ValidarDatosCategoria(){
        
        //Validacion de nombre
        if(JtextNombreCategoria.getText().isEmpty()){
            jLabelNombreCate.setText("*");
        }else{
            jLabelNombreCate.setText("");
        }
        
        //Validacion de descripcion
        if(jtextDescripcionCategoria.getText().isEmpty()){
            jLabelDescripCate.setText("*");
        }else{
            jLabelDescripCate.setText("");
        }
        
        
        //Validacion general
        if(JtextNombreCategoria.getText().isEmpty()||jtextDescripcionCategoria.getText().isEmpty()){
            BotonActualizarCategoria.setEnabled(false);
        }else{
            BotonActualizarCategoria.setEnabled(true);
        }
    }
    public void ValidarDatosEmpleado(){
        
        //Validacion de nombre
        if(jTextNombreEmpleado.getText().isEmpty()){
            jLabelNombreEmple.setText("*");
        }else{
            jLabelNombreEmple.setText("");
        }
        //Validacion telefono
         if(jTextTelefonoEmpleado.getText().isEmpty()||jTextTelefonoEmpleado.getText().length()<9){
            jLabelTelefonoEmple.setText("*");
        }else{
            jLabelTelefonoEmple.setText("");
        }
        //Validacion de Correo
        if(jTextCorreoEmpleado.getText().isEmpty()){
            jLabelCorreoEmple.setText("*");
        }else if (!jTextCorreoEmpleado.getText().contains("@")||!jTextCorreoEmpleado.getText().contains(".")){
            jLabelCorreoEmple.setText("Correo invalido");
        }else{
            jLabelCorreoEmple.setText("");
        }
        //Validacion de Direccion
        if(jTextDireccionEmpleados.getText().isEmpty()){
            jLabelDireccionEmple.setText("*");
        }else{
            jLabelDireccionEmple.setText("");
        }

        
        
        //Validacion general
        if(jTextNombreEmpleado.getText().isEmpty()||jTextTelefonoEmpleado.getText().isEmpty()||jTextTelefonoEmpleado.getText().length()<9
                ||jTextCorreoEmpleado.getText().isEmpty()||!jTextCorreoEmpleado.getText().contains("@")||!jTextCorreoEmpleado.getText().contains(".")||jTextDireccionEmpleados.getText().isEmpty()){
            BotonActualizarEmpleado.setEnabled(false);
        }else{
            BotonActualizarEmpleado.setEnabled(true);
        }
    }
    public void ValidarDatosProductos(){
        
        //Validacion de nombre
        if(jTextNombreProducto.getText().isEmpty()){
            jLabelNombreProduc.setText("*");
        }else{
            jLabelNombreProduc.setText("");
        }
        
        //Validacion de descripcion
        if(jTextDescripcionProducto.getText().isEmpty()){
            jLabelDescripProduc.setText("*");
        }else{
            jLabelDescripProduc.setText("");
        }
        //Validacion de Precio Unitario
        if(jTextPrecioUnitario.getText().isEmpty()){
            jLabelPrecioProduc.setText("*");
        }else{
            jLabelPrecioProduc.setText("");
        }
        
        //Validacion de Cantidad
        if(jTextCantidadStock.getText().isEmpty()){
            jLabelCantidadProduct.setText("*");
        }else{
            jLabelCantidadProduct.setText("");
        }
        
        
        //Validacion general
        if(jTextNombreProducto.getText().isEmpty()||jTextDescripcionProducto.getText().isEmpty()
                ||jTextPrecioUnitario.getText().isEmpty()||jTextCantidadStock.getText().isEmpty()){
            BotonActualizarProducto.setEnabled(false);
        }else{
            BotonActualizarProducto.setEnabled(true);
        }
    }
    public void ValidarDatosConsumibles(){
        
        //Validacion de nombre
        if(jtextNombreConsumible.getText().isEmpty()){
            jLabelNombreConsumible.setText("*");
        }else{
            jLabelNombreConsumible.setText("");
        }
        //Validacion Descripcion
         if(jtextDescripcionConsumible.getText().isEmpty()){
            jLabelDescripConsu.setText("*");
        }else{
            jLabelDescripConsu.setText("");
        }
        //Validacion de tipo
        if(jTextTipoConsumible.getText().isEmpty()){
            jLabelTipoConsum.setText("*");
        }else{
            jLabelTipoConsum.setText("");
        }
        //Validacion de Precio
        if(jTextPrecioConsumible.getText().isEmpty()){
            jLabelPrecioConsum.setText("*");
        }else{
            jLabelPrecioConsum.setText("");
        }
        //Validacion de Adquisicion
        if(jTextModoAd.getText().isEmpty()){
            jLabelAdquisicionConsum.setText("*");
        }else{
            jLabelAdquisicionConsum.setText("");
        }

        //Validacion general
        if(jtextNombreConsumible.getText().isEmpty()||jtextDescripcionConsumible.getText().isEmpty()||jTextTipoConsumible.getText().isEmpty()
                ||jTextPrecioConsumible.getText().isEmpty()||jTextModoAd.getText().isEmpty()){
            BotonActualizarConsumible.setEnabled(false);
        }else{
            BotonActualizarConsumible.setEnabled(true);
        }
    }
    public void ValidarDatosVenta(){
        
        //Validacion de Cantidad
        if(jTextCantidadVentas.getText().isEmpty()){
            JLabelCantidadVenta.setText("*");
        }else{
            JLabelCantidadVenta.setText("");
        }
        
        //Validacion El Monto Total
        if(jTextMontoTotalVentas.getText().isEmpty() ){
            jLabelMontoVenta.setText("*");
        }else{
            jLabelMontoVenta.setText("");
        }
        
        //Validacion general
        if(jTextCantidadVentas.getText().isEmpty()||jTextMontoTotalVentas.getText().isEmpty()){
            BotonActualizarVentas.setEnabled(false);
        }else{
            BotonActualizarVentas.setEnabled(true);
        }
    }
    public void ValidarDatosCombo(){
        //Validacion de Nombre
        if(jTextNombreCombo.getText().isEmpty()){
            jLabelNombreCombo.setText("*");
        }else{
            jLabelNombreCombo.setText("");
        }
        
        //Validacion de Descripcion
        if(jTextDescripcionCombo.getText().isEmpty()){
            jLabelDescrip.setText("*");
        }else{
            jLabelDescrip.setText("");
        }
        
        //Validacion Precio
        if(jTextPrecioCombo.getText().isEmpty() ){
            jLabelPrecioCombo.setText("*");
        }else{
            jLabelPrecioCombo.setText("");
        }
        
        //Validacion Monto total
        if(jTextTemporadaCombo.getText().isEmpty() ){
           jLabelTemporadaCombo.setText("*");
        }else{
            jLabelTemporadaCombo.setText("");
        }
        
        //Validacion general
        if(jTextNombreCombo.getText().isEmpty()||jTextDescripcionCombo.getText().isEmpty()||jTextPrecioCombo.getText().isEmpty()||jTextTemporadaCombo.getText().isEmpty()){
            BotonActualizarCombo.setEnabled(false);
        }else{
            BotonActualizarCombo.setEnabled(true);
        }
        
    }
    
    public void LimpiarClientes(){
        JtextNombreCliente.setText("");
        jTextDNICliente.setText("");
        jtextApellidoCliente.setText("");
        jTextCorreoCliente.setText("");
        jTelefonoCliente.setText("");
    }
    public void LimpiarCargos(){
        JtextNombreCargo.setText("");
        jTextIDCargo.setText("");
        jtextDescripcionCargo.setText("");
        jTextSueldoCargo.setText("");
    }
    public void LimpiarProveedor(){
        jTextNombreProvee.setText("");
        jTextRUCProve.setText("");
        jTextTelfProvee.setText("");
        jTextCorreoEmpleado.setText("");
        jTextDireccionProve.setText("");
    }
    public void LimpiarCategoria(){
        jTextIDCategoria.setText("");
        JtextNombreCategoria.setText("");
        jtextDescripcionCategoria.setText("");
    }
    public void LimpiarEmpleado(){
        jTextNombreEmpleado.setText("");
        jTextDNIEmpleados.setText("");
        jTextTelefonoEmpleado.setText("");
        jTextCorreoEmpleado.setText("");
        jTextDireccionEmpleados.setText("");
    }
    public void LimpiarProductos(){
        jTextIDProducto.setText("");
        jTextNombreProducto.setText("");
        jTextDescripcionProducto.setText("");
        jTextPrecioUnitario.setText("");
        jTextCantidadStock.setText("");
    }
    public void LimpiarConsumibles(){
        JtextIDconsumible.setText("");
        jtextNombreConsumible.setText("");
        jtextDescripcionConsumible.setText("");
        jTextPrecioConsumible.setText("");
        jTextTipoConsumible.setText("");
        jTextTiempoPreparacionConsumible.setText("");
        jTextModoAd.setText("");
    }
    public void LimpiarVenta(){
        jTextIDVentas.setText("");
        jTextFieldFechaVenta.setText("");
        jTextCantidadVentas.setText("");
        jTextMontoTotalVentas.setText("");
    }
    
    public void MostrarCargos(){
        DefaultTableModel tabla = new DefaultTableModel();
        Cargos car = new Cargos();
        ResultSet rs = car.Consultar("select * from cargos order by IDcargo asc;");
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Descripción","Sueldo"});
        try{
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("IDcargo")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("Sueldo"))});
                jTableCargo.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
         }
    public void MostrarCategorias(){
        DefaultTableModel tabla = new DefaultTableModel();
        Categorias cat = new Categorias();
        ResultSet rs = cat.Consultar("select * from categorias order by IDcategoria asc;");
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Descripción"});
        try{
            while(rs.next()){                
                tabla.addRow(new Object[] {(rs.getString("IDcategoria")),(rs.getString("Nombre")),(rs.getString("Descripcion"))});
                jTableCategorias.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    }    
    public void MostrarCombos(){
        DefaultTableModel tabla = new DefaultTableModel();
        Combos comb = new Combos();
        ResultSet rs = comb.Consultar("select * from combos order by IDcombo asc;");
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Descripción", "Precio", "Temporada"});
        try{
            while(rs.next()){
                tabla.addRow(new Object[] {(rs.getString("IDcombo")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("Precio")),(rs.getString("Temporada"))});
                jTableCombos.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    }  
    public void MostrarEmpleados(){
        DefaultTableModel tabla = new DefaultTableModel();
        Empleados emp = new Empleados();
        ResultSet rs = emp.Consultar("SELECT e.Nombre, e.DNI, c.Nombre AS NombreCargo, e.FechaNacimiento, e.Telefono, e.CorreoElectronico, e.Direccion FROM empleados e INNER JOIN cargos c ON e.IDcargo = c.IDcargo ORDER BY e.Nombre ASC;");
        tabla.setColumnIdentifiers(new Object[] {"Nombre","DNI","Cargo", "Fecha de Nacimiento","Teléfono","Correo Electrónico", "Dirección"});
        try{
            while(rs.next()){                
                tabla.addRow(new Object[] {(rs.getString("Nombre")),(rs.getString("DNI")),(rs.getString("NombreCargo")),(rs.getString("FechaNacimiento")),(rs.getString("Telefono")),(rs.getString("CorreoElectronico")),(rs.getString("Direccion"))});
                jTableEmpleados.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    }
    public void MostrarClientes(){
        DefaultTableModel tabla = new DefaultTableModel();
        Clientes cl = new Clientes();
        ResultSet rs = cl.Consultar("select * from clientes order by Nombre asc;");
        tabla.setColumnIdentifiers(new Object[] {"Nombre","Apellidos","DNI","Fecha de Nacimiento","Teléfono","Correo Electrónico", "Distrito", "Dirección"});
        try{
            while(rs.next()){                
                tabla.addRow(new Object[] {(rs.getString("Nombre")),(rs.getString("Apellidos")),(rs.getString("DNI")),(rs.getString("FechaNacimiento")),(rs.getString("Telefono")),(rs.getString("CorreoElectronico")), (rs.getString("Distrito")),(rs.getString("Direccion"))});
                jTableCliente.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
         }  
    public void MostrarConsumibles(){
        DefaultTableModel tabla = new DefaultTableModel();
        Consumibles con = new Consumibles();
        ResultSet rs = con.Consultar("select * from consumibles order by IDconsumible asc;");
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Descripción","Tipo","Precio","Modo de Adquisición","Tiempo de preparación"});
        try{
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("IDconsumible")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("Tipo")),(rs.getString("Precio")),(rs.getString("ModoDeAdquisicion")),(rs.getString("TiempoDePreparacion"))});
                jTableConsumible.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    
    }
    public void MostrarProductos(){
        DefaultTableModel tabla = new DefaultTableModel();
        Productos prod = new Productos();
        ResultSet rs = prod.Consultar("SELECT p.IDproducto, p.Nombre, p.Descripcion, c.Nombre AS NombreCategoria, p.PrecioUnitario, p.FechaAgregacion, p.CantidadStock, prov.Nombre AS NombreProveedor FROM productos p INNER JOIN categorias c ON p.IDcategoria = c.IDcategoria INNER JOIN proveedores prov ON p.IDproveedor = prov.IDproveedor ORDER BY p.IDproducto ASC;");
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Descripción","Categoría", "Precio Unitario","Fecha de Agregación","Cantidad en Stock","Proveedor"});
        try{
            while(rs.next()){                
                tabla.addRow(new Object[] {(rs.getString("IDproducto")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("NombreCategoria")),(rs.getString("PrecioUnitario")),(rs.getString("FechaAgregacion")),(rs.getString("CantidadStock")),(rs.getString("NombreProveedor"))});
                jTableProductos.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
        
    } 
    public void MostrarProveedores(){
        DefaultTableModel tabla = new DefaultTableModel();
        Proveedores prov = new Proveedores();
        ResultSet rs = prov.Consultar("select * from proveedores order by Nombre asc;");
        tabla.setColumnIdentifiers(new Object[] {"Nombre","RUC","Dirección","Correo Electrónico","Teléfono","Tipo", "Categoría"});
        try{
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("Nombre")),(rs.getString("RUC")),(rs.getString("Direccion")),(rs.getString("CorreoElectronico")),(rs.getString("Telefono")), (rs.getString("TipoProveedor")),(rs.getString("Categoria"))});
                jTableProveedor.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
         }
    public void MostrarVentas(){
        DefaultTableModel tabla = new DefaultTableModel();
        Ventas ven = new Ventas();
        ResultSet rs = ven.Consultar("SELECT v.IDventa, v.Fecha, c.Nombre AS NombreCliente, v.Cantidad, v.MontoTotal, v.MetodoPago FROM ventas v INNER JOIN clientes c ON v.`ID cliente` = c.`ID cliente` ORDER BY v.IDventa ASC;");
        tabla.setColumnIdentifiers(new Object[] {"ID","Fecha","Cliente","Cantidad","Monto Total","Método de Pago"});
        try{
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("IDventa")),(rs.getString("Fecha")),(rs.getString("NombreCliente")),(rs.getString("Cantidad")),(rs.getString("MontoTotal")),(rs.getString("MetodoPago"))});
                jTableVentas.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }
    
    }

    public void FiltrarDatosCargos(){
        Cargos car = new Cargos();
        DefaultTableModel tabla = new DefaultTableModel(); 
        
        String consulta = "SELECT * FROM cargos WHERE "+jComboBusqCargo.getSelectedItem().toString()+" like '%"+JtextValorCargo.getText()+"%';";
        ResultSet rs = car.Consultar(consulta);
        
        tabla.setColumnIdentifiers(new Object[] {"ID", "Nombre","Descripción","Sueldo"});
        try{
            
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("IDcargo")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("Sueldo"))});
                jTableCargo.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta, no existen datos con dichos criterios");
        }
    }
    public void FiltrarDatosCategorias(){
        Categorias cat = new Categorias();
        DefaultTableModel tabla = new DefaultTableModel(); 
        
        String consulta = "SELECT * FROM categorias WHERE "+jComboBusqCategoria.getSelectedItem().toString()+" like '%"+JtextValorCategoria.getText()+"%';";
        ResultSet rs = cat.Consultar(consulta);
        
        tabla.setColumnIdentifiers(new Object[] {"ID", "Nombre","Descripción"});
        try{
            
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("IDcategoria")),(rs.getString("Nombre")),(rs.getString("Descripcion"))});
                jTableCategorias.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta, no existen datos con dichos criterios");
        }
    }    
    public void FiltrarDatosClientes(){
        
        Clientes cli = new Clientes();
        DefaultTableModel tabla = new DefaultTableModel(); 
        
        String consulta = "SELECT * FROM clientes WHERE "+jComboBusqCliente.getSelectedItem().toString()+" like '%"+JtextValorCliente.getText()+"%';";
        ResultSet rs = cli.Consultar(consulta);
        
        tabla.setColumnIdentifiers(new Object[] {"Nombre","Apellidos","DNI","Fecha de Nacimiento","Teléfono","Correo Electrónico","Distrito","Dirección"});
        try{
            
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("Nombre")),(rs.getString("Apellidos")),
                    (rs.getString("DNI")),(rs.getString("FechaNacimiento")),(rs.getString("Telefono")),(rs.getString("CorreoElectronico")),(rs.getString("Distrito")),(rs.getString("Direccion"))});
                jTableCliente.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta, no existen datos con dichos criterios");
        }
    }
    public void FiltrarDatosConsumibles(){
        Consumibles con = new Consumibles();
        DefaultTableModel tabla = new DefaultTableModel(); 
        
        String consulta = "SELECT * FROM consumibles WHERE "+jComboBusqConsumibles1.getSelectedItem().toString()+" like '%"+JtextValorConsumibles1.getText()+"%';";
        ResultSet rs = con.Consultar(consulta);
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Descripción","Tipo","Precio","Modo de Adquisición","Tiempo de Preparación"});
        try{
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("IDConsumible")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("Tipo")),(rs.getString("Precio")),(rs.getString("ModoDeAdquisicion")),(rs.getString("TiempoDePreparacion"))});
                jTableConsumible.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }   
    }
    public void FiltrarDatosCombos(){
        Combos comb = new Combos();
        DefaultTableModel tabla = new DefaultTableModel(); 
        
        String consulta = "SELECT * FROM combos WHERE "+jComboBusqCombos.getSelectedItem().toString()+" like '%"+JtextValorCombos.getText()+"%';";
        ResultSet rs = comb.Consultar(consulta);
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre","Descripción","Precio","Temporada"});
        try{
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("IDCombo")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("Precio")),(rs.getString("Temporada"))});
                jTableCombos.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e);
        }   
    }
    public void FiltrarDatosEmpleados() {
        Empleados emp = new Empleados();
        DefaultTableModel tabla = new DefaultTableModel(); 
        tabla.setColumnIdentifiers(new Object[] {"Nombre", "DNI", "Cargo", "Fecha de Nacimiento", "Teléfono", "Correo Electrónico", "Dirección"});
        String columnaConsulta=null;
        switch (jComboBusqEmpleado.getSelectedItem().toString()) {    
            case "Nombre":
                columnaConsulta = "empleados.Nombre";
                break;
            case "Cargo":
                columnaConsulta = "cargos.Nombre";
                break;
        }
        try {
            String consulta = "SELECT empleados.Nombre, empleados.DNI, cargos.Nombre AS Cargo, empleados.FechaNacimiento, empleados.Telefono, empleados.CorreoElectronico, empleados.Direccion " +
                              "FROM empleados " +
                              "INNER JOIN cargos ON empleados.IDcargo = cargos.IDcargo " +
                    "WHERE ";
                    if (columnaConsulta != null) {
                        consulta += columnaConsulta;
                    } else {
                        consulta += jComboBusqEmpleado.getSelectedItem().toString();
                    }
                    consulta += " LIKE '%" + JtextValorEmpleado.getText() + "%';";
            ResultSet rs = emp.Consultar(consulta);
            while(rs.next()){                
                tabla.addRow(new Object[] {(rs.getString("Nombre")),(rs.getString("DNI")),(rs.getString("Cargo")),(rs.getString("FechaNacimiento")),(rs.getString("Telefono")),(rs.getString("CorreoElectronico")),(rs.getString("Direccion"))});
                jTableEmpleados.setModel(tabla);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta, no existen datos con dichos criterios");
        }
    }
    public void FiltrarDatosProductos() {
        Productos prod = new Productos();
        DefaultTableModel tabla = new DefaultTableModel(); 
        tabla.setColumnIdentifiers(new Object[] {"ID","Nombre", "Descripción", "Categoría", "Precio Unitario", "Fecha de Agregación", "Cantidad en Stock", "Proveedor"});
        String columnaConsulta=null;
            switch (jComboBusqProductos.getSelectedItem().toString()){    
                case "Nombre":
                    columnaConsulta = "productos.Nombre";
                    break;
                case "Categoria":
                    columnaConsulta = "categorias.Nombre";
                    break;
                case "Proveedor":
                    columnaConsulta = "proveedores.Nombre";
                    break;
                case "Descripcion":
                    columnaConsulta = "productos.Descripcion";
                    break;
            }
        try {
            String consulta = "SELECT productos.IDproducto, productos.Nombre, productos.Descripcion, categorias.Nombre AS Categoria, productos.PrecioUnitario, productos.FechaAgregacion,  productos.CantidadStock, Proveedores.Nombre AS Proveedor " +
                              "FROM productos " +
                              "INNER JOIN categorias ON productos.IDcategoria = categorias.IDcategoria " +
                              "INNER JOIN proveedores ON productos.IDproveedor = proveedores.IDproveedor " +
                              "WHERE ";
                            if (columnaConsulta != null) {
                                consulta += columnaConsulta;
                            } else {
                                consulta += jComboBusqProductos.getSelectedItem().toString();
                            }
                             consulta += " LIKE '%" + JtextValorProductos.getText() + "%';";

            ResultSet rs = prod.Consultar(consulta);

            while(rs.next()){                
                    tabla.addRow(new Object[] {(rs.getString("IDproducto")),(rs.getString("Nombre")),(rs.getString("Descripcion")),(rs.getString("Categoria")),(rs.getString("PrecioUnitario")),(rs.getString("FechaAgregacion")),(rs.getString("CantidadStock")),(rs.getString("Proveedor"))});
                    jTableProductos.setModel(tabla);
                }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta, no existen datos con dichos criterios");
        }
    }
    public void FiltrarDatosProveedores(){
        Proveedores prov = new Proveedores();
        DefaultTableModel tabla = new DefaultTableModel(); 
        
        String consulta = "SELECT * FROM proveedores WHERE "+jComboBusqProveedor.getSelectedItem().toString()+" like '%"+JtextValorProveedor.getText()+"%';";
        ResultSet rs = prov.Consultar(consulta);
        
        tabla.setColumnIdentifiers(new Object[] {"Nombre","RUC","Dirección","Correo Electrónico","Teléfono","Tipo","Categoría"});
        try{
            
            while(rs.next()){
                
                tabla.addRow(new Object[] {(rs.getString("Nombre")),(rs.getString("RUC")),(rs.getString("Direccion")),(rs.getString("CorreoElectronico")),(rs.getString("Telefono")), (rs.getString("TipoProveedor")),(rs.getString("Categoria"))});
                jTableProveedor.setModel(tabla);
            }
                
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta, no existen datos con dichos criterios");
        }
    }
    public void FiltrarDatosVentas() {
        Ventas vent = new Ventas();
        DefaultTableModel tabla = new DefaultTableModel(); 
        tabla.setColumnIdentifiers(new Object[] {"ID","Fecha","Cliente","Cantidad","Monto Total","Método de Pago"});
        String columnaConsulta=null;
            switch (jComboBusqVentas.getSelectedItem().toString()){    
                case "Cliente":
                    columnaConsulta = "clientes.Nombre";
                    break;                
            }
        try {
            String consulta = "SELECT ventas.IDventa, ventas.Fecha, clientes.Nombre AS NombreCliente, ventas.Cantidad, ventas.MontoTotal,  ventas.MetodoPago " +
                          "FROM ventas " +
                          "INNER JOIN clientes ON ventas.`ID cliente` = clientes.`ID cliente` " +
                          "WHERE ";

                if (columnaConsulta != null) {
                    consulta += columnaConsulta;
                } else {
                    consulta += jComboBusqVentas.getSelectedItem().toString();
                }
                consulta += " LIKE '%" + JtextValorVentas.getText() + "%';";

                ResultSet rs = vent.Consultar(consulta);

            while (rs.next()) {                
                tabla.addRow(new Object[] {(rs.getString("IDventa")),(rs.getString("Fecha")),(rs.getString("NombreCliente")),(rs.getString("Cantidad")),(rs.getString("MontoTotal")),(rs.getString("MetodoPago"))});
                jTableVentas.setModel(tabla);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta, no existen datos con dichos criterios"+e);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        Pestañas = new javax.swing.JTabbedPane();
        Proveedores = new javax.swing.JPanel();
        jTextNombreProvee = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButtonAgregarProveedor = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableProveedor = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jTextTelfProvee = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextCorreoProvee = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jButtonEliminarProveedor = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        jComboBusqProveedor = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        JtextValorProveedor = new javax.swing.JTextField();
        BotonActualizarProveedor = new javax.swing.JButton();
        jTextRUCProve = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jTextDireccionProve = new javax.swing.JTextField();
        jComboCategoria = new javax.swing.JComboBox<>();
        jLabel54 = new javax.swing.JLabel();
        jComboTipo = new javax.swing.JComboBox<>();
        jLabelNombreProve = new javax.swing.JLabel();
        jLabelRUCProve = new javax.swing.JLabel();
        JLabelTelefonoProve = new javax.swing.JLabel();
        jLabelCorreoProvee = new javax.swing.JLabel();
        Categoria = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCategorias = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jComboBusqCategoria = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        JtextValorCategoria = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        JtextNombreCategoria = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jtextDescripcionCategoria = new javax.swing.JTextField();
        jLabelIDCargo1 = new javax.swing.JLabel();
        jTextIDCategoria = new javax.swing.JTextField();
        jButton39 = new javax.swing.JButton();
        BotonActualizarCategoria = new javax.swing.JButton();
        EliminarCategoria = new javax.swing.JButton();
        jLabelNombreCate = new javax.swing.JLabel();
        jLabelDescripCate = new javax.swing.JLabel();
        Empleados = new javax.swing.JPanel();
        jTextDireccionEmpleados = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextNombreEmpleado = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextTelefonoEmpleado = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextCorreoEmpleado = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        BotonActualizarEmpleado = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBusqEmpleado = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        JtextValorEmpleado = new javax.swing.JTextField();
        jTextDNIEmpleados = new javax.swing.JTextField();
        jComboCargoEmpleado = new javax.swing.JComboBox<>();
        jButtonVerRed = new javax.swing.JButton();
        jLabelNombreEmple = new javax.swing.JLabel();
        jLabelTelefonoEmple = new javax.swing.JLabel();
        jLabelCorreoEmple = new javax.swing.JLabel();
        jLabelDireccionEmple = new javax.swing.JLabel();
        Cargos = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableCargo = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        BotonActualizarCargo = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jComboBusqCargo = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        JtextValorCargo = new javax.swing.JTextField();
        JtextNombreCargo = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabelnombreCargo = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jtextDescripcionCargo = new javax.swing.JTextField();
        jLabelDescripcionCargo = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextSueldoCargo = new javax.swing.JTextField();
        jLabelSueldoCargo = new javax.swing.JLabel();
        jLabelIDCargo = new javax.swing.JLabel();
        jTextIDCargo = new javax.swing.JTextField();
        Consumibles = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableConsumible = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBusqConsumibles1 = new javax.swing.JComboBox<>();
        JtextValorConsumibles1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        JtextIDconsumible = new javax.swing.JTextField();
        jtextNombreConsumible = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jTextTipoConsumible = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jTextModoAd = new javax.swing.JTextField();
        jButton34 = new javax.swing.JButton();
        BotonActualizarConsumible = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jTextPrecioConsumible = new javax.swing.JTextField();
        jtextDescripcionConsumible = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTextTiempoPreparacionConsumible = new javax.swing.JTextField();
        jLabelNombreConsumible = new javax.swing.JLabel();
        jLabelDescripConsu = new javax.swing.JLabel();
        jLabelTipoConsum = new javax.swing.JLabel();
        jLabelPrecioConsum = new javax.swing.JLabel();
        jLabelAdquisicionConsum = new javax.swing.JLabel();
        Productos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextNombreProducto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextDescripcionProducto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jTextCantidadStock = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jComboCategoriaProducto = new javax.swing.JComboBox<>();
        jLabel61 = new javax.swing.JLabel();
        jComboBusqProductos = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        JtextValorProductos = new javax.swing.JTextField();
        BotonActualizarProducto = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jTextIDProducto = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jTextPrecioUnitario = new javax.swing.JTextField();
        jComboProveedorProducto = new javax.swing.JComboBox<>();
        jLabelNombreProduc = new javax.swing.JLabel();
        jLabelPrecioProduc = new javax.swing.JLabel();
        jLabelCantidadProduct = new javax.swing.JLabel();
        jLabelDescripProduc = new javax.swing.JLabel();
        Combos = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableCombos = new javax.swing.JTable();
        jLabel66 = new javax.swing.JLabel();
        jComboBusqCombos = new javax.swing.JComboBox<>();
        jLabel67 = new javax.swing.JLabel();
        JtextValorCombos = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        BotonActualizarCombo = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jTextTemporadaCombo = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jTextIDCombo = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jTextNombreCombo = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jTextPrecioCombo = new javax.swing.JTextField();
        jTextDescripcionCombo = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jButtonVerDetallesCombos = new javax.swing.JButton();
        jLabelNombreCombo = new javax.swing.JLabel();
        jLabelDescrip = new javax.swing.JLabel();
        jLabelPrecioCombo = new javax.swing.JLabel();
        jLabelTemporadaCombo = new javax.swing.JLabel();
        Clientes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        JtextValorCliente = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jComboBusqCliente = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        JtextNombreCliente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtextApellidoCliente = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextDNICliente = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTelefonoCliente = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextCorreoCliente = new javax.swing.JTextField();
        BotonActualizarCliente = new javax.swing.JButton();
        jLabelcorreoCliente = new javax.swing.JLabel();
        jLabelTelefonoCliente = new javax.swing.JLabel();
        jLabelnombreCliente = new javax.swing.JLabel();
        jLabelApellidoCliente = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        Ventas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextCantidadVentas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVentas = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextMontoTotalVentas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboMetodoPagoVentas = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboClienteVentas = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        JtextValorVentas = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jComboBusqVentas = new javax.swing.JComboBox<>();
        BotonActualizarVentas = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jTextIDVentas = new javax.swing.JTextField();
        jButton33 = new javax.swing.JButton();
        jButtonVerEntrega = new javax.swing.JButton();
        jButtonVerDetallesVentas = new javax.swing.JButton();
        jTextFieldFechaVenta = new javax.swing.JTextField();
        JLabelCantidadVenta = new javax.swing.JLabel();
        jLabelMontoVenta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton1.setText("Proveedores");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 153, 0));
        jButton2.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton2.setText("Categorías");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 153, 0));
        jButton3.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton3.setText("Consumibles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 153, 0));
        jButton4.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton4.setText("Empleados");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 153, 0));
        jButton5.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton5.setText("Cargos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 153, 0));
        jButton7.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton7.setText("Cerrar sesión");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(204, 153, 0));
        jButton24.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton24.setText("Productos");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(204, 153, 0));
        jButton25.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton25.setText("Clientes");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setBackground(new java.awt.Color(204, 153, 0));
        jButton26.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton26.setText("Combos");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton37.setBackground(new java.awt.Color(204, 153, 0));
        jButton37.setFont(new java.awt.Font("Book Antiqua", 0, 14)); // NOI18N
        jButton37.setText("Ventas");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButton37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 200, 780));

        Pestañas.setBackground(new java.awt.Color(153, 153, 153));
        Pestañas.setEnabled(false);
        Pestañas.setFont(new java.awt.Font("Gadugi", 0, 14)); // NOI18N

        jTextNombreProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreProveeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreProveeKeyTyped(evt);
            }
        });

        jLabel13.setText("Nombre");

        jLabel14.setText("RUC");

        jButtonAgregarProveedor.setBackground(new java.awt.Color(0, 51, 51));
        jButtonAgregarProveedor.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButtonAgregarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarProveedor.setText("Agregar");
        jButtonAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProveedorActionPerformed(evt);
            }
        });

        jTableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "RUC", "Dirección", "Correo Electrónico", "Teléfono", "Tipo", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableProveedor);
        if (jTableProveedor.getColumnModel().getColumnCount() > 0) {
            jTableProveedor.getColumnModel().getColumn(0).setResizable(false);
            jTableProveedor.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableProveedor.getColumnModel().getColumn(1).setResizable(false);
            jTableProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableProveedor.getColumnModel().getColumn(2).setResizable(false);
            jTableProveedor.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTableProveedor.getColumnModel().getColumn(3).setResizable(false);
            jTableProveedor.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTableProveedor.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTableProveedor.getColumnModel().getColumn(5).setResizable(false);
        }
        jTableProveedor.getAccessibleContext().setAccessibleName("");

        jLabel28.setText("Teléfono");

        jTextTelfProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTelfProveeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelfProveeKeyTyped(evt);
            }
        });

        jLabel29.setText("Correo Electrónico");

        jTextCorreoProvee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCorreoProveeKeyReleased(evt);
            }
        });

        jLabel30.setText("Categoría");

        jButtonEliminarProveedor.setBackground(new java.awt.Color(0, 51, 51));
        jButtonEliminarProveedor.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButtonEliminarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminarProveedor.setText("Eliminar");
        jButtonEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProveedorActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(0, 51, 51));
        jButton19.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Mostrar todo");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel46.setText("Realizar Busqueda por:");

        jComboBusqProveedor.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqProveedor.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "RUC", "Direccion", "CorreoElectronico", "Telefono", "TipoProveedor", "Categoría", " " }));
        jComboBusqProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqProveedorActionPerformed(evt);
            }
        });

        jLabel47.setText("Valor");

        JtextValorProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorProveedorActionPerformed(evt);
            }
        });
        JtextValorProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorProveedorKeyReleased(evt);
            }
        });

        BotonActualizarProveedor.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarProveedor.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarProveedor.setText("Actualizar");
        BotonActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarProveedorActionPerformed(evt);
            }
        });

        jTextRUCProve.setEnabled(false);
        jTextRUCProve.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextRUCProveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextRUCProveKeyTyped(evt);
            }
        });

        jLabel53.setText("Dirección");

        jComboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Papelería", "Artículos", "Jardinería", "Madera" }));
        jComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCategoriaActionPerformed(evt);
            }
        });
        jComboCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboCategoriaKeyTyped(evt);
            }
        });

        jLabel54.setText("Tipo");

        jComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ocasional", "Fijo" }));
        jComboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoActionPerformed(evt);
            }
        });
        jComboTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboTipoKeyTyped(evt);
            }
        });

        jLabelNombreProve.setBackground(new java.awt.Color(153, 51, 0));
        jLabelNombreProve.setForeground(new java.awt.Color(153, 51, 0));
        jLabelNombreProve.setText("*");

        jLabelRUCProve.setForeground(new java.awt.Color(153, 51, 0));
        jLabelRUCProve.setText("*");

        JLabelTelefonoProve.setForeground(new java.awt.Color(153, 0, 51));
        JLabelTelefonoProve.setText("*");

        jLabelCorreoProvee.setForeground(new java.awt.Color(153, 51, 0));
        jLabelCorreoProvee.setText("*");

        javax.swing.GroupLayout ProveedoresLayout = new javax.swing.GroupLayout(Proveedores);
        Proveedores.setLayout(ProveedoresLayout);
        ProveedoresLayout.setHorizontalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jComboBusqProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(JtextValorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextNombreProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNombreProve)))
                                .addGap(17, 17, 17)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelRUCProve))
                                    .addComponent(jTextRUCProve, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextTelfProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JLabelTelefonoProve)))
                                .addGap(17, 17, 17)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel53)
                                    .addComponent(jTextDireccionProve, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextCorreoProvee, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabelCorreoProvee)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel54))
                                    .addGroup(ProveedoresLayout.createSequentialGroup()
                                        .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addComponent(jButtonAgregarProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonActualizarProveedor)
                                .addGap(12, 12, 12)
                                .addComponent(jButtonEliminarProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton19))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        ProveedoresLayout.setVerticalGroup(
            ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtextValorProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBusqProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabelNombreProve)
                                    .addComponent(jLabelRUCProve)
                                    .addComponent(JLabelTelefonoProve))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextNombreProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextTelfProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextRUCProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ProveedoresLayout.createSequentialGroup()
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabelCorreoProvee))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextDireccionProve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextCorreoProvee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(ProveedoresLayout.createSequentialGroup()
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ProveedoresLayout.createSequentialGroup()
                            .addGroup(ProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonEliminarProveedor)
                                .addComponent(BotonActualizarProveedor))
                            .addGap(14, 14, 14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                            .addComponent(jButtonAgregarProveedor)
                            .addGap(20, 20, 20)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProveedoresLayout.createSequentialGroup()
                        .addComponent(jButton19)
                        .addGap(21, 21, 21))))
        );

        Pestañas.addTab("Proveedores", Proveedores);

        jTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción"
            }
        ));
        jTableCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCategoriasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableCategorias);

        jButton12.setBackground(new java.awt.Color(0, 51, 51));
        jButton12.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Mostrar todo");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel55.setText("Realizar Busqueda por:");

        jComboBusqCategoria.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqCategoria.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", " " }));
        jComboBusqCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqCategoriaActionPerformed(evt);
            }
        });

        jLabel56.setText("Valor");

        JtextValorCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorCategoriaActionPerformed(evt);
            }
        });
        JtextValorCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorCategoriaKeyReleased(evt);
            }
        });

        jLabel57.setText("Nombre");

        JtextNombreCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextNombreCategoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextNombreCategoriaKeyTyped(evt);
            }
        });

        jLabel58.setText("Descripción");

        jtextDescripcionCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextDescripcionCategoriaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextDescripcionCategoriaKeyTyped(evt);
            }
        });

        jLabelIDCargo1.setText("ID");

        jTextIDCategoria.setEnabled(false);
        jTextIDCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDCategoriaActionPerformed(evt);
            }
        });

        jButton39.setBackground(new java.awt.Color(0, 51, 51));
        jButton39.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton39.setForeground(new java.awt.Color(255, 255, 255));
        jButton39.setText("Agregar");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        BotonActualizarCategoria.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarCategoria.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarCategoria.setText("Actualizar");
        BotonActualizarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarCategoriaActionPerformed(evt);
            }
        });

        EliminarCategoria.setBackground(new java.awt.Color(0, 51, 51));
        EliminarCategoria.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        EliminarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        EliminarCategoria.setText("Eliminar");
        EliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCategoriaActionPerformed(evt);
            }
        });

        jLabelNombreCate.setForeground(new java.awt.Color(153, 51, 0));
        jLabelNombreCate.setText("*");

        jLabelDescripCate.setForeground(new java.awt.Color(153, 51, 0));
        jLabelDescripCate.setText("*");

        javax.swing.GroupLayout CategoriaLayout = new javax.swing.GroupLayout(Categoria);
        Categoria.setLayout(CategoriaLayout);
        CategoriaLayout.setHorizontalGroup(
            CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CategoriaLayout.createSequentialGroup()
                        .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jComboBusqCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel56)
                            .addComponent(JtextValorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CategoriaLayout.createSequentialGroup()
                        .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CategoriaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelIDCargo1))
                            .addComponent(jTextIDCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CategoriaLayout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNombreCate))
                            .addComponent(JtextNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CategoriaLayout.createSequentialGroup()
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDescripCate))
                            .addComponent(jtextDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(CategoriaLayout.createSequentialGroup()
                            .addComponent(jButton39)
                            .addGap(12, 12, 12)
                            .addComponent(BotonActualizarCategoria)
                            .addGap(12, 12, 12)
                            .addComponent(EliminarCategoria)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton12))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        CategoriaLayout.setVerticalGroup(
            CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoriaLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel55)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CategoriaLayout.createSequentialGroup()
                        .addComponent(jLabelIDCargo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextIDCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CategoriaLayout.createSequentialGroup()
                        .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabelNombreCate)
                            .addComponent(jLabelDescripCate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JtextNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextDescripcionCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(CategoriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(EliminarCategoria)
                    .addComponent(BotonActualizarCategoria)
                    .addComponent(jButton39))
                .addGap(16, 16, 16))
        );

        Pestañas.addTab("Categorias", Categoria);

        jTextDireccionEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDireccionEmpleadosActionPerformed(evt);
            }
        });
        jTextDireccionEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDireccionEmpleadosKeyReleased(evt);
            }
        });

        jLabel31.setText("Dirección");

        jLabel11.setText("Nombre");

        jTextNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreEmpleadoKeyTyped(evt);
            }
        });

        jLabel33.setText("DNI");

        jLabel34.setText("Cargo");

        jTextTelefonoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTelefonoEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTelefonoEmpleadoKeyTyped(evt);
            }
        });

        jLabel35.setText("Teléfono");

        jLabel36.setText("Correo Electrónico");

        jTextCorreoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCorreoEmpleadoKeyReleased(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(0, 51, 51));
        jButton10.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Agregar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "DNI", "Cargo", "Fecha de Nacimiento", "Teléfono", "Coreo Electrónico", "Dirección"
            }
        ));
        jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(jTableEmpleados);

        jButton21.setBackground(new java.awt.Color(0, 51, 51));
        jButton21.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("Eliminar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(0, 51, 51));
        jButton22.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("Mostrar todo");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        BotonActualizarEmpleado.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarEmpleado.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarEmpleado.setText("Actualizar");
        BotonActualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarEmpleadoActionPerformed(evt);
            }
        });

        jLabel12.setText("Realizar Busqueda por:");

        jComboBusqEmpleado.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqEmpleado.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "DNI", "Cargo", "FechaNacimiento", "Telefono", "CorreoElectronico", "Direccion" }));
        jComboBusqEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqEmpleadoActionPerformed(evt);
            }
        });

        jLabel32.setText("Valor");

        JtextValorEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtextValorEmpleadoMouseClicked(evt);
            }
        });
        JtextValorEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorEmpleadoActionPerformed(evt);
            }
        });
        JtextValorEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorEmpleadoKeyReleased(evt);
            }
        });

        jTextDNIEmpleados.setEnabled(false);
        jTextDNIEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDNIEmpleadosKeyTyped(evt);
            }
        });

        jComboCargoEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboCargoEmpleadoMouseClicked(evt);
            }
        });
        jComboCargoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCargoEmpleadoActionPerformed(evt);
            }
        });
        jComboCargoEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jComboCargoEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jComboCargoEmpleadoKeyTyped(evt);
            }
        });

        jButtonVerRed.setBackground(new java.awt.Color(0, 51, 51));
        jButtonVerRed.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButtonVerRed.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerRed.setText("Ver red social que administra");
        jButtonVerRed.setActionCommand("Ver Red Social que administra");
        jButtonVerRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerRedActionPerformed(evt);
            }
        });

        jLabelNombreEmple.setForeground(new java.awt.Color(153, 51, 0));
        jLabelNombreEmple.setText("*");

        jLabelTelefonoEmple.setForeground(new java.awt.Color(153, 51, 0));
        jLabelTelefonoEmple.setText("*");

        jLabelCorreoEmple.setForeground(new java.awt.Color(153, 51, 0));
        jLabelCorreoEmple.setText("*");

        jLabelDireccionEmple.setForeground(new java.awt.Color(153, 51, 0));
        jLabelDireccionEmple.setText("*");

        javax.swing.GroupLayout EmpleadosLayout = new javax.swing.GroupLayout(Empleados);
        Empleados.setLayout(EmpleadosLayout);
        EmpleadosLayout.setHorizontalGroup(
            EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmpleadosLayout.createSequentialGroup()
                        .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EmpleadosLayout.createSequentialGroup()
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(EmpleadosLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelNombreEmple)))
                                .addGap(12, 12, 12)
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33)
                                    .addComponent(jTextDNIEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EmpleadosLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel34))
                                    .addGroup(EmpleadosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jComboCargoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EmpleadosLayout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelTelefonoEmple))
                                    .addComponent(jTextTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EmpleadosLayout.createSequentialGroup()
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelCorreoEmple))
                                    .addComponent(jTextCorreoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EmpleadosLayout.createSequentialGroup()
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelDireccionEmple))
                                    .addComponent(jTextDireccionEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(EmpleadosLayout.createSequentialGroup()
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jComboBusqEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(JtextValorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(EmpleadosLayout.createSequentialGroup()
                        .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(EmpleadosLayout.createSequentialGroup()
                                .addComponent(jButton10)
                                .addGap(12, 12, 12)
                                .addComponent(BotonActualizarEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton21)
                                .addGap(185, 185, 185)
                                .addComponent(jButtonVerRed)
                                .addGap(263, 263, 263)
                                .addComponent(jButton22))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 31, Short.MAX_VALUE))))
        );
        EmpleadosLayout.setVerticalGroup(
            EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmpleadosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmpleadosLayout.createSequentialGroup()
                        .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(jLabelNombreEmple))
                            .addGroup(EmpleadosLayout.createSequentialGroup()
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel33))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextDNIEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboCargoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonVerRed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton22))
                            .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton10)
                                .addComponent(BotonActualizarEmpleado)
                                .addComponent(jButton21))))
                    .addGroup(EmpleadosLayout.createSequentialGroup()
                        .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(jLabel35)
                            .addComponent(jLabel31)
                            .addComponent(jLabelTelefonoEmple)
                            .addComponent(jLabelCorreoEmple)
                            .addComponent(jLabelDireccionEmple))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EmpleadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextTelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCorreoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDireccionEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Pestañas.addTab("Empleados", Empleados);

        jTableCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción", "Sueldo"
            }
        ));
        jTableCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCargoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableCargo);

        jButton27.setBackground(new java.awt.Color(0, 51, 51));
        jButton27.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Agregar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setBackground(new java.awt.Color(0, 51, 51));
        jButton28.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton28.setForeground(new java.awt.Color(255, 255, 255));
        jButton28.setText("Mostrar todo");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setBackground(new java.awt.Color(0, 51, 51));
        jButton29.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("Eliminar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        BotonActualizarCargo.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarCargo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarCargo.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarCargo.setText("Actualizar");
        BotonActualizarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarCargoActionPerformed(evt);
            }
        });

        jLabel48.setText("Realizar Busqueda por:");

        jComboBusqCargo.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqCargo.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Sueldo" }));
        jComboBusqCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqCargoActionPerformed(evt);
            }
        });

        jLabel49.setText("Valor");

        JtextValorCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorCargoActionPerformed(evt);
            }
        });
        JtextValorCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorCargoKeyReleased(evt);
            }
        });

        JtextNombreCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextNombreCargoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextNombreCargoKeyTyped(evt);
            }
        });

        jLabel50.setText("Nombre");

        jLabelnombreCargo.setForeground(new java.awt.Color(153, 0, 0));
        jLabelnombreCargo.setText("*");

        jLabel51.setText("Descripción");

        jtextDescripcionCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextDescripcionCargoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextDescripcionCargoKeyTyped(evt);
            }
        });

        jLabelDescripcionCargo.setForeground(new java.awt.Color(204, 0, 0));
        jLabelDescripcionCargo.setText("*");

        jLabel52.setText("Sueldo");

        jTextSueldoCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextSueldoCargoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextSueldoCargoKeyTyped(evt);
            }
        });

        jLabelSueldoCargo.setForeground(new java.awt.Color(153, 51, 0));
        jLabelSueldoCargo.setText("*");

        jLabelIDCargo.setText("ID");

        jTextIDCargo.setEnabled(false);
        jTextIDCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDCargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CargosLayout = new javax.swing.GroupLayout(Cargos);
        Cargos.setLayout(CargosLayout);
        CargosLayout.setHorizontalGroup(
            CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CargosLayout.createSequentialGroup()
                        .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jComboBusqCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(JtextValorCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CargosLayout.createSequentialGroup()
                        .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CargosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelIDCargo))
                            .addComponent(jTextIDCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CargosLayout.createSequentialGroup()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelnombreCargo))
                            .addComponent(JtextNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CargosLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDescripcionCargo))
                            .addComponent(jtextDescripcionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CargosLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelSueldoCargo))
                            .addComponent(jTextSueldoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CargosLayout.createSequentialGroup()
                        .addComponent(jButton27)
                        .addGap(12, 12, 12)
                        .addComponent(BotonActualizarCargo)
                        .addGap(12, 12, 12)
                        .addComponent(jButton29)
                        .addGap(651, 651, 651)
                        .addComponent(jButton28))
                    .addComponent(jScrollPane7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CargosLayout.setVerticalGroup(
            CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CargosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CargosLayout.createSequentialGroup()
                        .addComponent(jLabelIDCargo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextIDCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CargosLayout.createSequentialGroup()
                            .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel50)
                                .addComponent(jLabel51)
                                .addComponent(jLabelnombreCargo)
                                .addComponent(jLabelDescripcionCargo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(JtextNombreCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextDescripcionCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(CargosLayout.createSequentialGroup()
                            .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel52)
                                .addComponent(jLabelSueldoCargo))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextSueldoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(CargosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton27)
                    .addComponent(jButton29)
                    .addComponent(BotonActualizarCargo)
                    .addComponent(jButton28))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Pestañas.addTab("Cargos", Cargos);

        jTableConsumible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Nombre", "Descripción", "Tipo", "Precio", "Modo de Adquisición", "Tiempo de Preparación"
            }
        ));
        jTableConsumible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsumibleMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableConsumible);

        jLabel26.setText("Realizar Busqueda por:");

        jLabel27.setText("Valor");

        jComboBusqConsumibles1.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqConsumibles1.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqConsumibles1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Tipo", "Precio", "ModoDeAdquisicion", "TiempoDePreparacion" }));

        JtextValorConsumibles1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorConsumibles1ActionPerformed(evt);
            }
        });
        JtextValorConsumibles1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorConsumibles1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextValorConsumibles1KeyTyped(evt);
            }
        });

        jLabel39.setText("ID");

        jLabel40.setText("Nombre");

        JtextIDconsumible.setEnabled(false);
        JtextIDconsumible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextIDconsumibleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextIDconsumibleKeyTyped(evt);
            }
        });

        jtextNombreConsumible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextNombreConsumibleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextNombreConsumibleKeyTyped(evt);
            }
        });

        jLabel41.setText("Descripción");

        jLabel42.setText("Tipo");

        jLabel43.setText("Precio");

        jTextTipoConsumible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTipoConsumibleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTipoConsumibleKeyTyped(evt);
            }
        });

        jLabel44.setText("Modo de Adquisición");

        jTextModoAd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextModoAdKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextModoAdKeyTyped(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(0, 51, 51));
        jButton34.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Agregar");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        BotonActualizarConsumible.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarConsumible.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarConsumible.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarConsumible.setText("Actualizar");
        BotonActualizarConsumible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarConsumibleActionPerformed(evt);
            }
        });

        jButton35.setBackground(new java.awt.Color(0, 51, 51));
        jButton35.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton35.setForeground(new java.awt.Color(255, 255, 255));
        jButton35.setText("Eliminar");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setBackground(new java.awt.Color(0, 51, 51));
        jButton36.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton36.setForeground(new java.awt.Color(255, 255, 255));
        jButton36.setText("Mostrar todo");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        jTextPrecioConsumible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPrecioConsumibleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioConsumibleKeyTyped(evt);
            }
        });

        jtextDescripcionConsumible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextDescripcionConsumibleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextDescripcionConsumibleKeyTyped(evt);
            }
        });

        jLabel45.setText("Tiempo de Preparación");

        jTextTiempoPreparacionConsumible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTiempoPreparacionConsumibleKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTiempoPreparacionConsumibleKeyTyped(evt);
            }
        });

        jLabelNombreConsumible.setForeground(new java.awt.Color(153, 51, 0));
        jLabelNombreConsumible.setText("*");

        jLabelDescripConsu.setForeground(new java.awt.Color(153, 51, 0));
        jLabelDescripConsu.setText("*");

        jLabelTipoConsum.setForeground(new java.awt.Color(153, 51, 0));
        jLabelTipoConsum.setText("*");

        jLabelPrecioConsum.setForeground(new java.awt.Color(153, 51, 0));
        jLabelPrecioConsum.setText("*");

        jLabelAdquisicionConsum.setForeground(new java.awt.Color(153, 51, 0));
        jLabelAdquisicionConsum.setText("*");

        javax.swing.GroupLayout ConsumiblesLayout = new javax.swing.GroupLayout(Consumibles);
        Consumibles.setLayout(ConsumiblesLayout);
        ConsumiblesLayout.setHorizontalGroup(
            ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsumiblesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                        .addComponent(jButton34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotonActualizarConsumible)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton36)
                        .addGap(31, 31, 31))
                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                        .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ConsumiblesLayout.createSequentialGroup()
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel39))
                                    .addComponent(JtextIDconsumible, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtextNombreConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNombreConsumible)))
                                .addGap(17, 17, 17)
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtextDescripcionConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelDescripConsu)))
                                .addGap(17, 17, 17)
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelTipoConsum))
                                    .addComponent(jTextTipoConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextPrecioConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelPrecioConsum)))
                                .addGap(17, 17, 17)
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextModoAd, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelAdquisicionConsum)))
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jTextTiempoPreparacionConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ConsumiblesLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel45))))
                            .addGroup(ConsumiblesLayout.createSequentialGroup()
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jComboBusqConsumibles1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(JtextValorConsumibles1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        ConsumiblesLayout.setVerticalGroup(
            ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConsumiblesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqConsumibles1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorConsumibles1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabelNombreConsumible)
                    .addComponent(jLabelDescripConsu)
                    .addComponent(jLabelTipoConsum)
                    .addComponent(jLabelPrecioConsum)
                    .addComponent(jLabelAdquisicionConsum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JtextIDconsumible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextNombreConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTipoConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextPrecioConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtextDescripcionConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextModoAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextTiempoPreparacionConsumible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ConsumiblesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34)
                    .addComponent(BotonActualizarConsumible)
                    .addComponent(jButton35)
                    .addComponent(jButton36))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        Pestañas.addTab("Consumibles", Consumibles);

        jLabel21.setText("ID");

        jTextNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreProductoKeyTyped(evt);
            }
        });

        jLabel22.setText("Nombre");

        jTextDescripcionProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDescripcionProductoKeyReleased(evt);
            }
        });

        jLabel23.setText("Descripción");

        jLabel24.setText("Categoría");

        jButton11.setBackground(new java.awt.Color(0, 51, 51));
        jButton11.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Agregar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción", "Categoría", "Precio Unitario", "Fecha de Agregación", "Cantidad en Stock", "Proveedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableProductos);
        if (jTableProductos.getColumnModel().getColumnCount() > 0) {
            jTableProductos.getColumnModel().getColumn(0).setResizable(false);
            jTableProductos.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableProductos.getColumnModel().getColumn(1).setResizable(false);
            jTableProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableProductos.getColumnModel().getColumn(2).setResizable(false);
            jTableProductos.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTableProductos.getColumnModel().getColumn(3).setResizable(false);
            jTableProductos.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTableProductos.getColumnModel().getColumn(4).setResizable(false);
            jTableProductos.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jTextCantidadStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCantidadStockActionPerformed(evt);
            }
        });
        jTextCantidadStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCantidadStockKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextCantidadStockKeyTyped(evt);
            }
        });

        jLabel38.setText("Precio Unitario");

        jButton20.setBackground(new java.awt.Color(0, 51, 51));
        jButton20.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("Eliminar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jComboCategoriaProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboCategoriaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCategoriaProductoActionPerformed(evt);
            }
        });

        jLabel61.setText("Realizar Busqueda por:");

        jComboBusqProductos.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqProductos.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Categoria", "PrecioUnitario", "FechaAgregacion", "CantidadStock", "Proveedor" }));
        jComboBusqProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqProductosActionPerformed(evt);
            }
        });

        jLabel62.setText("Valor");

        JtextValorProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtextValorProductosMouseClicked(evt);
            }
        });
        JtextValorProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorProductosActionPerformed(evt);
            }
        });
        JtextValorProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorProductosKeyReleased(evt);
            }
        });

        BotonActualizarProducto.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarProducto.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarProducto.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarProducto.setText("Actualizar");
        BotonActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarProductoActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(0, 51, 51));
        jButton30.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setText("Mostrar todo");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jTextIDProducto.setEnabled(false);
        jTextIDProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDProductoActionPerformed(evt);
            }
        });

        jLabel64.setText("Cantidad en Stock");

        jLabel65.setText("Proveedor");

        jTextPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecioUnitarioActionPerformed(evt);
            }
        });
        jTextPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPrecioUnitarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioUnitarioKeyTyped(evt);
            }
        });

        jComboProveedorProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboProveedorProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboProveedorProductoActionPerformed(evt);
            }
        });

        jLabelNombreProduc.setForeground(new java.awt.Color(204, 51, 0));
        jLabelNombreProduc.setText("*");

        jLabelPrecioProduc.setForeground(new java.awt.Color(153, 51, 0));
        jLabelPrecioProduc.setText("*");

        jLabelCantidadProduct.setForeground(new java.awt.Color(153, 51, 0));
        jLabelCantidadProduct.setText("*");

        jLabelDescripProduc.setForeground(new java.awt.Color(204, 51, 0));
        jLabelDescripProduc.setText("*");

        javax.swing.GroupLayout ProductosLayout = new javax.swing.GroupLayout(Productos);
        Productos.setLayout(ProductosLayout);
        ProductosLayout.setHorizontalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jComboBusqProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel62)
                            .addComponent(JtextValorProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProductosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel21))
                            .addComponent(jTextIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProductosLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNombreProduc)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProductosLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelDescripProduc)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProductosLayout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPrecioProduc)))
                        .addGap(12, 12, 12)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCantidadStock, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ProductosLayout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelCantidadProduct)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboProveedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65)))
                    .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ProductosLayout.createSequentialGroup()
                            .addComponent(jButton11)
                            .addGap(12, 12, 12)
                            .addComponent(BotonActualizarProducto)
                            .addGap(12, 12, 12)
                            .addComponent(jButton20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton30))
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        ProductosLayout.setVerticalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel62)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabelNombreProduc)
                            .addComponent(jLabelDescripProduc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrecioProduc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboCategoriaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProductosLayout.createSequentialGroup()
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCantidadProduct))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextCantidadStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboProveedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton20)
                    .addComponent(BotonActualizarProducto)
                    .addComponent(jButton30))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Pestañas.addTab("Productos", Productos);

        jTableCombos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripción", "Precio", "Temporada"
            }
        ));
        jTableCombos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCombosMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTableCombos);

        jLabel66.setText("Realizar Busqueda por:");

        jComboBusqCombos.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqCombos.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqCombos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Precio", "Temporada" }));
        jComboBusqCombos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqCombosActionPerformed(evt);
            }
        });

        jLabel67.setText("Valor");

        JtextValorCombos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtextValorCombosMouseClicked(evt);
            }
        });
        JtextValorCombos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorCombosActionPerformed(evt);
            }
        });
        JtextValorCombos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorCombosKeyReleased(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(0, 51, 51));
        jButton31.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setText("Eliminar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        BotonActualizarCombo.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarCombo.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarCombo.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarCombo.setText("Actualizar");
        BotonActualizarCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarComboActionPerformed(evt);
            }
        });

        jButton32.setBackground(new java.awt.Color(0, 51, 51));
        jButton32.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton32.setForeground(new java.awt.Color(255, 255, 255));
        jButton32.setText("Mostrar todo");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(0, 51, 51));
        jButton15.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Agregar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTextTemporadaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTemporadaComboActionPerformed(evt);
            }
        });
        jTextTemporadaCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextTemporadaComboKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextTemporadaComboKeyTyped(evt);
            }
        });

        jLabel68.setText("Precio");

        jTextIDCombo.setEnabled(false);
        jTextIDCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDComboActionPerformed(evt);
            }
        });

        jLabel70.setText("ID");

        jLabel71.setText("Temporada");

        jTextNombreCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNombreComboKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNombreComboKeyTyped(evt);
            }
        });

        jLabel72.setText("Nombre");

        jTextPrecioCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecioComboActionPerformed(evt);
            }
        });
        jTextPrecioCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPrecioComboKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextPrecioComboKeyTyped(evt);
            }
        });

        jTextDescripcionCombo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextDescripcionComboKeyReleased(evt);
            }
        });

        jLabel73.setText("Descripción");

        jButtonVerDetallesCombos.setBackground(new java.awt.Color(0, 51, 51));
        jButtonVerDetallesCombos.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButtonVerDetallesCombos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerDetallesCombos.setText("Ver Detalles del Combo");
        jButtonVerDetallesCombos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDetallesCombosActionPerformed(evt);
            }
        });

        jLabelNombreCombo.setForeground(new java.awt.Color(153, 51, 0));
        jLabelNombreCombo.setText("*");

        jLabelDescrip.setForeground(new java.awt.Color(153, 51, 0));
        jLabelDescrip.setText("*");

        jLabelPrecioCombo.setForeground(new java.awt.Color(153, 51, 0));
        jLabelPrecioCombo.setText("*");

        jLabelTemporadaCombo.setForeground(new java.awt.Color(153, 51, 0));
        jLabelTemporadaCombo.setText("*");

        javax.swing.GroupLayout CombosLayout = new javax.swing.GroupLayout(Combos);
        Combos.setLayout(CombosLayout);
        CombosLayout.setHorizontalGroup(
            CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CombosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CombosLayout.createSequentialGroup()
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66)
                            .addComponent(jComboBusqCombos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(JtextValorCombos, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CombosLayout.createSequentialGroup()
                            .addComponent(jButton15)
                            .addGap(12, 12, 12)
                            .addComponent(BotonActualizarCombo)
                            .addGap(12, 12, 12)
                            .addComponent(jButton31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonVerDetallesCombos)
                            .addGap(249, 249, 249)
                            .addComponent(jButton32))
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CombosLayout.createSequentialGroup()
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CombosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel70))
                            .addComponent(jTextIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNombreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CombosLayout.createSequentialGroup()
                                .addComponent(jLabel72)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNombreCombo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextDescripcionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CombosLayout.createSequentialGroup()
                                .addComponent(jLabel73)
                                .addGap(8, 8, 8)
                                .addComponent(jLabelDescrip)))
                        .addGap(18, 18, 18)
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextPrecioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CombosLayout.createSequentialGroup()
                                .addComponent(jLabel68)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPrecioCombo)))
                        .addGap(18, 18, 18)
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextTemporadaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CombosLayout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTemporadaCombo)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        CombosLayout.setVerticalGroup(
            CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CombosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqCombos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorCombos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CombosLayout.createSequentialGroup()
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(jLabel72)
                            .addComponent(jLabel73)
                            .addComponent(jLabelNombreCombo)
                            .addComponent(jLabelDescrip))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextIDCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNombreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDescripcionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPrecioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTemporadaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPrecioCombo)
                        .addComponent(jLabelTemporadaCombo)))
                .addGap(18, 18, 18)
                .addGroup(CombosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(jButton31)
                    .addComponent(BotonActualizarCombo)
                    .addComponent(jButton32)
                    .addComponent(jButtonVerDetallesCombos))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Pestañas.addTab("Combos", Combos);

        jLabel10.setText("Realizar Busqueda por:");

        jButton8.setBackground(new java.awt.Color(0, 51, 51));
        jButton8.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Agregar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        JtextValorCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtextValorClienteMouseClicked(evt);
            }
        });
        JtextValorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorClienteActionPerformed(evt);
            }
        });
        JtextValorCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorClienteKeyReleased(evt);
            }
        });

        jLabel19.setText("Valor");

        jButton14.setBackground(new java.awt.Color(0, 51, 51));
        jButton14.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Eliminar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(0, 51, 51));
        jButton16.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Mostrar todo");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jComboBusqCliente.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqCliente.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Apellidos", "DNI", "Telefono", "Correo", "Distrito", "Direccion" }));
        jComboBusqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre");

        JtextNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextNombreClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JtextNombreClienteKeyTyped(evt);
            }
        });

        jLabel16.setText("Apellidos");

        jtextApellidoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextApellidoClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtextApellidoClienteKeyTyped(evt);
            }
        });

        jLabel17.setText("DNI");

        jTextDNICliente.setEnabled(false);
        jTextDNICliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDNIClienteKeyTyped(evt);
            }
        });

        jLabel20.setText("Teléfono");

        jTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTelefonoClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTelefonoClienteKeyTyped(evt);
            }
        });

        jLabel25.setText("Correo Electrónico");

        jTextCorreoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCorreoClienteKeyReleased(evt);
            }
        });

        BotonActualizarCliente.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarCliente.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarCliente.setText("Actualizar");
        BotonActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarClienteActionPerformed(evt);
            }
        });

        jLabelcorreoCliente.setForeground(new java.awt.Color(153, 51, 0));
        jLabelcorreoCliente.setText("*");

        jLabelTelefonoCliente.setForeground(new java.awt.Color(153, 51, 0));
        jLabelTelefonoCliente.setText("*");

        jLabelnombreCliente.setForeground(new java.awt.Color(153, 0, 0));
        jLabelnombreCliente.setText("*");

        jLabelApellidoCliente.setForeground(new java.awt.Color(204, 0, 0));
        jLabelApellidoCliente.setText("*");

        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "DNI", "Fecha de Nacimiento", "Teléfono", "Correo Electrónico", "Distrito", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCliente.setCellSelectionEnabled(true);
        jTableCliente.getTableHeader().setReorderingAllowed(false);
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTableCliente);
        jTableCliente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTableCliente.getColumnModel().getColumnCount() > 0) {
            jTableCliente.getColumnModel().getColumn(1).setResizable(false);
            jTableCliente.getColumnModel().getColumn(2).setResizable(false);
            jTableCliente.getColumnModel().getColumn(3).setResizable(false);
            jTableCliente.getColumnModel().getColumn(4).setResizable(false);
            jTableCliente.getColumnModel().getColumn(5).setResizable(false);
            jTableCliente.getColumnModel().getColumn(6).setResizable(false);
            jTableCliente.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout ClientesLayout = new javax.swing.GroupLayout(Clientes);
        Clientes.setLayout(ClientesLayout);
        ClientesLayout.setHorizontalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientesLayout.createSequentialGroup()
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JtextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ClientesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelnombreCliente)))
                        .addGap(17, 17, 17)
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtextApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ClientesLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelApellidoCliente)))
                        .addGap(17, 17, 17)
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(12, 12, 12)
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ClientesLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ClientesLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelcorreoCliente))
                            .addComponent(jTextCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ClientesLayout.createSequentialGroup()
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jComboBusqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(JtextValorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(ClientesLayout.createSequentialGroup()
                            .addComponent(jButton8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BotonActualizarCliente)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton16))
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        ClientesLayout.setVerticalGroup(
            ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClientesLayout.createSequentialGroup()
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientesLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(jLabel25)
                    .addComponent(jLabelnombreCliente)
                    .addComponent(jLabelApellidoCliente)
                    .addComponent(jLabelTelefonoCliente)
                    .addComponent(jLabelcorreoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JtextNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtextApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(BotonActualizarCliente)
                    .addComponent(jButton14)
                    .addComponent(jButton16))
                .addGap(55, 55, 55))
        );

        Pestañas.addTab("Clientes", Clientes);

        jLabel3.setText("Fecha");

        jLabel4.setText("Cantidad");

        jTextCantidadVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextCantidadVentasKeyReleased(evt);
            }
        });

        jTableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Cliente", "Cantidad", "Monto Total", "Método de Pago"
            }
        ));
        jTableVentas.setCellSelectionEnabled(true);
        jTableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVentas);
        if (jTableVentas.getColumnModel().getColumnCount() > 0) {
            jTableVentas.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTableVentas.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTableVentas.getColumnModel().getColumn(2).setPreferredWidth(30);
            jTableVentas.getColumnModel().getColumn(3).setPreferredWidth(30);
            jTableVentas.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jButton6.setBackground(new java.awt.Color(0, 51, 51));
        jButton6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Agregar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 51, 51));
        jButton13.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Eliminar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setText("Monto Total");

        jTextMontoTotalVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextMontoTotalVentasKeyReleased(evt);
            }
        });

        jLabel9.setText("Método de Pago");

        jComboMetodoPagoVentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Transferencia bancaria" }));
        jComboMetodoPagoVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMetodoPagoVentasActionPerformed(evt);
            }
        });

        jLabel15.setText("Cliente");

        jLabel59.setText("Realizar Busqueda por:");

        JtextValorVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtextValorVentasMouseClicked(evt);
            }
        });
        JtextValorVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtextValorVentasActionPerformed(evt);
            }
        });
        JtextValorVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtextValorVentasKeyReleased(evt);
            }
        });

        jLabel60.setText("Valor");

        jComboBusqVentas.setBackground(new java.awt.Color(102, 102, 255));
        jComboBusqVentas.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jComboBusqVentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fecha", "Cliente", "Cantidad", "MontoTotal", "MetodoPago" }));
        jComboBusqVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBusqVentasActionPerformed(evt);
            }
        });

        BotonActualizarVentas.setBackground(new java.awt.Color(0, 51, 51));
        BotonActualizarVentas.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotonActualizarVentas.setForeground(new java.awt.Color(255, 255, 255));
        BotonActualizarVentas.setText("Actualizar");
        BotonActualizarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonActualizarVentasActionPerformed(evt);
            }
        });

        jLabel74.setText("ID");

        jTextIDVentas.setEnabled(false);
        jTextIDVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDVentasActionPerformed(evt);
            }
        });

        jButton33.setBackground(new java.awt.Color(0, 51, 51));
        jButton33.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButton33.setForeground(new java.awt.Color(255, 255, 255));
        jButton33.setText("Mostrar todo");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jButtonVerEntrega.setBackground(new java.awt.Color(0, 51, 51));
        jButtonVerEntrega.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButtonVerEntrega.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerEntrega.setLabel("Ver Entrega");
        jButtonVerEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerEntregaActionPerformed(evt);
            }
        });

        jButtonVerDetallesVentas.setBackground(new java.awt.Color(0, 51, 51));
        jButtonVerDetallesVentas.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jButtonVerDetallesVentas.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVerDetallesVentas.setText("Ver Detalles de Venta");
        jButtonVerDetallesVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerDetallesVentasActionPerformed(evt);
            }
        });

        JLabelCantidadVenta.setForeground(new java.awt.Color(153, 51, 0));
        JLabelCantidadVenta.setText("*");

        jLabelMontoVenta.setForeground(new java.awt.Color(153, 51, 0));
        jLabelMontoVenta.setText("*");

        javax.swing.GroupLayout VentasLayout = new javax.swing.GroupLayout(Ventas);
        Ventas.setLayout(VentasLayout);
        VentasLayout.setHorizontalGroup(
            VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentasLayout.createSequentialGroup()
                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VentasLayout.createSequentialGroup()
                                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(VentasLayout.createSequentialGroup()
                                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(VentasLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel74))
                                            .addComponent(jTextIDVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextCantidadVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(VentasLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(JLabelCantidadVenta)))
                                        .addGap(17, 17, 17)
                                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextMontoTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(VentasLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelMontoVenta)))
                                        .addGap(17, 17, 17)
                                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboMetodoPagoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VentasLayout.createSequentialGroup()
                                        .addComponent(jButtonVerDetallesVentas)
                                        .addGap(33, 33, 33)))
                                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15)
                                    .addComponent(jComboClienteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonVerEntrega, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(VentasLayout.createSequentialGroup()
                                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jComboBusqVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel60)
                                    .addComponent(JtextValorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(323, Short.MAX_VALUE))
                    .addGroup(VentasLayout.createSequentialGroup()
                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(VentasLayout.createSequentialGroup()
                                .addComponent(jButton6)
                                .addGap(12, 12, 12)
                                .addComponent(BotonActualizarVentas)
                                .addGap(12, 12, 12)
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton33))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 31, Short.MAX_VALUE))))
        );
        VentasLayout.setVerticalGroup(
            VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentasLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBusqVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JtextValorVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(VentasLayout.createSequentialGroup()
                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextIDVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(VentasLayout.createSequentialGroup()
                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(VentasLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboClienteVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(VentasLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboMetodoPagoVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2))
                    .addGroup(VentasLayout.createSequentialGroup()
                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(JLabelCantidadVenta)
                            .addComponent(jLabelMontoVenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextCantidadVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextMontoTotalVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(VentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton13)
                    .addComponent(BotonActualizarVentas)
                    .addComponent(jButton33)
                    .addComponent(jButtonVerEntrega)
                    .addComponent(jButtonVerDetallesVentas))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        Pestañas.addTab("Ventas", Ventas);

        getContentPane().add(Pestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 1060, 610));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Giraldos.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1080, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       Pestañas.setSelectedIndex(2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    this.dispose();
    InicioDeSesion ini = new InicioDeSesion();
    ini.setVisible(true);       
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        AgregarEmpleado agr = new AgregarEmpleado();
        agr.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            MostrarEmpleados();
        }
        });
        agr.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextCantidadStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCantidadStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadStockActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Pestañas.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Pestañas.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      Pestañas.setSelectedIndex(4);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      Pestañas.setSelectedIndex(3);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Ventas vent = new Ventas(); 
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar esta venta?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        String consulta = "DELETE FROM `giraldo`.`ventas` WHERE (`IDventa` = "+jTextIDVentas.getText()+");" ;
        if (confirm == JOptionPane.YES_OPTION) {
             vent.Eliminar(consulta);
        }
        MostrarVentas();
        LimpiarVenta();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        AgregarVenta agr = new AgregarVenta();
        agr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                MostrarVentas();
            }
            });
        agr.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
    MostrarClientes();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
    MostrarProveedores();
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
    Pestañas.setSelectedIndex(5);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
    Pestañas.setSelectedIndex(6);   // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
    Pestañas.setSelectedIndex(7);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    AgregarCliente agr = new AgregarCliente();
    agr.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            MostrarClientes();
        }
        });
    agr.setVisible(true);
    LimpiarClientes();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        MostrarEmpleados();
        jButtonVerRed.setEnabled(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
    MostrarCargos();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
    MostrarCategorias();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButtonAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProveedorActionPerformed
    AgregarProveedor agr = new AgregarProveedor();
    agr.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            MostrarProveedores();
        }
        });
    agr.setVisible(true);
    }//GEN-LAST:event_jButtonAgregarProveedorActionPerformed

    private void BotonActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarClienteActionPerformed
    Clientes cl = new Clientes(); 
    
    String consulta = "UPDATE `giraldo`.`clientes` SET `Nombre` = '"+JtextNombreCliente.getText()+"', `Apellidos` = '"+jtextApellidoCliente.getText()+"', `Telefono` = '"+jTelefonoCliente.getText()
            +"', `CorreoElectronico` = '"+jTextCorreoCliente.getText()+"' WHERE (`DNI` = "+jTextDNICliente.getText()+" );" ;
    cl.Actualizar(consulta);
    MostrarClientes();
    LimpiarClientes();
    }//GEN-LAST:event_BotonActualizarClienteActionPerformed

    private void jTableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProveedorMouseClicked
            
     int filaSeleccionada = jTableProveedor.rowAtPoint(evt.getPoint());   
     
    //evento para seleccionar una fila
        
        jTextNombreProvee.setText(jTableProveedor.getValueAt(filaSeleccionada,0).toString());
        jTextRUCProve.setText(jTableProveedor.getValueAt(filaSeleccionada,1).toString());
        jTextDireccionProve.setText(jTableProveedor.getValueAt(filaSeleccionada,2).toString());
        jTextCorreoProvee.setText(jTableProveedor.getValueAt(filaSeleccionada,3).toString());
        jTextTelfProvee.setText(jTableProveedor.getValueAt(filaSeleccionada,4).toString());
        jComboTipo.setSelectedItem(jTableProveedor.getValueAt(filaSeleccionada,5).toString());
        jComboCategoria.setSelectedItem(jTableProveedor.getValueAt(filaSeleccionada,6).toString());
    }//GEN-LAST:event_jTableProveedorMouseClicked

    private void jTextDNIClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIClienteKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }
        if(jTextDNICliente.getText().length()>=8){
        evt.consume();
    }
    }//GEN-LAST:event_jTextDNIClienteKeyTyped

    private void jTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTelefonoClienteKeyTyped
        if(jTelefonoCliente.getText().length()>=9){
            evt.consume();
        }
    
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTelefonoClienteKeyTyped

    private void JtextNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextNombreClienteKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_JtextNombreClienteKeyTyped

    private void jtextApellidoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextApellidoClienteKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_jtextApellidoClienteKeyTyped

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
    Clientes cl = new Clientes(); 
    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    String consulta = "DELETE FROM `giraldo`.`clientes` WHERE (`DNI` = "+jTextDNICliente.getText()+");" ;
    if (confirm == JOptionPane.YES_OPTION) {
             cl.Eliminar(consulta);
        }    
    MostrarClientes();  
    LimpiarClientes();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jTextCorreoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoClienteKeyReleased
    ValidarDatosCliente();
    }//GEN-LAST:event_jTextCorreoClienteKeyReleased

    private void JtextNombreClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextNombreClienteKeyReleased
    ValidarDatosCliente();
    }//GEN-LAST:event_JtextNombreClienteKeyReleased

    private void jtextApellidoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextApellidoClienteKeyReleased
    ValidarDatosCliente();        
    }//GEN-LAST:event_jtextApellidoClienteKeyReleased

    private void jTelefonoClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTelefonoClienteKeyReleased
    ValidarDatosCliente();        
    }//GEN-LAST:event_jTelefonoClienteKeyReleased

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
     int filaSeleccionada = jTableCliente.rowAtPoint(evt.getPoint());   
         //evento para seleccionar una fila        
        JtextNombreCliente.setText(jTableCliente.getValueAt(filaSeleccionada,0).toString());
        jtextApellidoCliente.setText(jTableCliente.getValueAt(filaSeleccionada,1).toString());
        jTextDNICliente.setText(jTableCliente.getValueAt(filaSeleccionada,2).toString());
        jTelefonoCliente.setText(jTableCliente.getValueAt(filaSeleccionada,4).toString());
        jTextCorreoCliente.setText(jTableCliente.getValueAt(filaSeleccionada,5).toString());
    }//GEN-LAST:event_jTableClienteMouseClicked

    private void JtextValorClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorClienteKeyReleased
    FiltrarDatosClientes();        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorClienteKeyReleased

    private void jComboCategoriaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCategoriaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCategoriaProductoActionPerformed

    private void JtextValorConsumibles1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorConsumibles1KeyReleased
    FiltrarDatosConsumibles();
    }//GEN-LAST:event_JtextValorConsumibles1KeyReleased

    private void JtextIDconsumibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextIDconsumibleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextIDconsumibleKeyReleased

    private void JtextIDconsumibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextIDconsumibleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextIDconsumibleKeyTyped

    private void jtextNombreConsumibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNombreConsumibleKeyReleased
    ValidarDatosConsumibles();    // TODO add your handling code here:
    }//GEN-LAST:event_jtextNombreConsumibleKeyReleased

    private void jtextNombreConsumibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextNombreConsumibleKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jtextNombreConsumibleKeyTyped

    private void jTextTipoConsumibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTipoConsumibleKeyReleased
    ValidarDatosConsumibles();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTipoConsumibleKeyReleased

    private void jTextTipoConsumibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTipoConsumibleKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextTipoConsumibleKeyTyped

    private void jTextModoAdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextModoAdKeyReleased
    ValidarDatosConsumibles();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextModoAdKeyReleased

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        AgregarConsumible agr = new AgregarConsumible();
        agr.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            MostrarConsumibles();
        }
        });
        agr.setVisible(true);        
    }//GEN-LAST:event_jButton34ActionPerformed

    private void BotonActualizarConsumibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarConsumibleActionPerformed
        Consumibles cons = new Consumibles(); 
    
        String consulta = "UPDATE `giraldo`.`consumibles` SET `Nombre` = '"+jtextNombreConsumible.getText()+"', `Descripcion` = '"+jtextDescripcionConsumible.getText()+"', `Tipo` = '"+jTextTipoConsumible.getText()
                +"', `Precio` = '"+jTextPrecioConsumible.getText()+"',`ModoDeAdquisicion` = '"+jTextModoAd.getText()+"', `TiempoDePreparacion` = '"+jTextTiempoPreparacionConsumible.getText()+"' WHERE (`IDconsumible` = "+JtextIDconsumible.getText()+");";
        cons.Actualizar(consulta);
        MostrarConsumibles();
        LimpiarConsumibles();
    }//GEN-LAST:event_BotonActualizarConsumibleActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        Consumibles cons= new Consumibles(); 
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este consumible?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        String consulta = "DELETE FROM `giraldo`.`consumibles` WHERE (`IDconsumible` = "+JtextIDconsumible.getText()+");" ;
        if (confirm == JOptionPane.YES_OPTION) {
             cons.Eliminar(consulta);
        }
        MostrarConsumibles();
        LimpiarConsumibles();
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        MostrarConsumibles();   
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jTextPrecioConsumibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioConsumibleKeyReleased
    ValidarDatosConsumibles();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioConsumibleKeyReleased

    private void jTextPrecioConsumibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioConsumibleKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }    
    }//GEN-LAST:event_jTextPrecioConsumibleKeyTyped

    private void jtextDescripcionConsumibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextDescripcionConsumibleKeyReleased
    ValidarDatosConsumibles();        // TODO add your handling code here:
    }//GEN-LAST:event_jtextDescripcionConsumibleKeyReleased

    private void jtextDescripcionConsumibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextDescripcionConsumibleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextDescripcionConsumibleKeyTyped

    private void jTextTiempoPreparacionConsumibleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTiempoPreparacionConsumibleKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTiempoPreparacionConsumibleKeyReleased

    private void jTextTiempoPreparacionConsumibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTiempoPreparacionConsumibleKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTiempoPreparacionConsumibleKeyTyped

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        Pestañas.setSelectedIndex(8);
    }//GEN-LAST:event_jButton37ActionPerformed

    private void JtextValorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorClienteActionPerformed

    private void JtextValorConsumibles1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorConsumibles1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorConsumibles1ActionPerformed

    private void JtextValorConsumibles1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorConsumibles1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorConsumibles1KeyTyped

    private void jComboBusqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqClienteActionPerformed

    private void jComboBusqProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqProveedorActionPerformed

    private void JtextValorProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorProveedorActionPerformed

    private void JtextValorProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorProveedorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorProveedorKeyReleased

    private void BotonActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarProveedorActionPerformed
    Proveedores prov = new Proveedores(); 
    
    String consulta = "UPDATE `giraldo`.`proveedores` SET `Nombre` = '"+jTextNombreProvee.getText()+"', `Direccion` = '"+jTextDireccionProve.getText()
            +"', `CorreoElectronico` = '"+jTextCorreoProvee.getText()+"',`Telefono` = '"+jTextTelfProvee.getText()+"', `TipoProveedor` = '"+jComboTipo.getSelectedItem().toString()+"', `Categoria` = '"+jComboCategoria.getSelectedItem().toString()+"' WHERE (`RUC` = "+jTextRUCProve.getText()+" );" ;
    prov.Actualizar(consulta);
    MostrarProveedores();
    LimpiarProveedor();
    }//GEN-LAST:event_BotonActualizarProveedorActionPerformed

    private void jComboBusqCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqCargoActionPerformed

    private void JtextValorCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorCargoActionPerformed

    private void JtextValorCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorCargoKeyReleased
        FiltrarDatosCargos();
    }//GEN-LAST:event_JtextValorCargoKeyReleased

    private void JtextNombreCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextNombreCargoKeyReleased
    ValidarDatosCargos();    // TODO add your handling code here:
    }//GEN-LAST:event_JtextNombreCargoKeyReleased

    private void JtextNombreCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextNombreCargoKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_JtextNombreCargoKeyTyped

    private void jtextDescripcionCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextDescripcionCargoKeyReleased
    ValidarDatosCargos();        // TODO add your handling code here:
    }//GEN-LAST:event_jtextDescripcionCargoKeyReleased

    private void jtextDescripcionCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextDescripcionCargoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextDescripcionCargoKeyTyped

    private void jTextSueldoCargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSueldoCargoKeyReleased
    ValidarDatosCargos();         // TODO add your handling code here:
    }//GEN-LAST:event_jTextSueldoCargoKeyReleased

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        AgregarCargo agr = new AgregarCargo();
        agr.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            MostrarCargos();
        }
        });
        agr.setVisible(true);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void BotonActualizarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarCargoActionPerformed
    Cargos car = new Cargos(); 
    
    String consulta = "UPDATE `giraldo`.`cargos` SET `Nombre` = '"+JtextNombreCargo.getText()+"', `Descripcion` = '"+jtextDescripcionCargo.getText()+"', `Sueldo` = '"+jTextSueldoCargo.getText()
            +"' WHERE (`IDcargo` = "+jTextIDCargo.getText()+" );" ;
    car.Actualizar(consulta);
    MostrarCargos();
    LimpiarCargos();
    }//GEN-LAST:event_BotonActualizarCargoActionPerformed

    private void jTableCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCargoMouseClicked
        int filaSeleccionada = jTableCargo.rowAtPoint(evt.getPoint());   
     
    //evento para seleccionar una fila
        jTextIDCargo.setText(jTableCargo.getValueAt(filaSeleccionada,0).toString());
        JtextNombreCargo.setText(jTableCargo.getValueAt(filaSeleccionada,1).toString());
        jtextDescripcionCargo.setText(jTableCargo.getValueAt(filaSeleccionada,2).toString());
        jTextSueldoCargo.setText(jTableCargo.getValueAt(filaSeleccionada,3).toString());
    }//GEN-LAST:event_jTableCargoMouseClicked

    private void jTextIDCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDCargoActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        Cargos car = new Cargos(); 
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este cargo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        String consulta = "DELETE FROM `giraldo`.`cargos` WHERE (`IDcargo` = "+jTextIDCargo.getText()+");" ;
        if (confirm == JOptionPane.YES_OPTION) {
             car.Eliminar(consulta);
        }
        MostrarCargos();
        LimpiarCargos();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jComboCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCategoriaKeyTyped

    private void jComboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTipoActionPerformed

    private void jComboTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboTipoKeyTyped

    }//GEN-LAST:event_jComboTipoKeyTyped

    private void jButtonEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProveedorActionPerformed
        Proveedores prov = new Proveedores(); 
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este proveedor?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        String consulta = "DELETE FROM `giraldo`.`proveedores` WHERE (`RUC` = "+jTextRUCProve.getText()+");" ;
        if (confirm == JOptionPane.YES_OPTION) {
             prov.Eliminar(consulta);
        }   
        MostrarProveedores();
        LimpiarProveedor();
    }//GEN-LAST:event_jButtonEliminarProveedorActionPerformed

    private void jComboBusqCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqCategoriaActionPerformed

    private void JtextValorCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorCategoriaActionPerformed

    private void JtextValorCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorCategoriaKeyReleased
        FiltrarDatosCategorias();
    }//GEN-LAST:event_JtextValorCategoriaKeyReleased

    private void JtextNombreCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextNombreCategoriaKeyReleased
    ValidarDatosCategoria();        // TODO add your handling code here:
    }//GEN-LAST:event_JtextNombreCategoriaKeyReleased

    private void JtextNombreCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextNombreCategoriaKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_JtextNombreCategoriaKeyTyped

    private void jtextDescripcionCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextDescripcionCategoriaKeyReleased
    ValidarDatosCategoria();             // TODO add your handling code here:
    }//GEN-LAST:event_jtextDescripcionCategoriaKeyReleased

    private void jtextDescripcionCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextDescripcionCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextDescripcionCategoriaKeyTyped

    private void jTextIDCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDCategoriaActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        AgregarCategoría agr = new AgregarCategoría();
        agr.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            MostrarCategorias();
        }
        });
        agr.setVisible(true);
    }//GEN-LAST:event_jButton39ActionPerformed

    private void BotonActualizarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarCategoriaActionPerformed
        Categorias cat = new Categorias(); 
    
        String consulta = "UPDATE `giraldo`.`categorias` SET `Nombre` = '"+JtextNombreCategoria.getText()+"', `Descripcion` = '"+jtextDescripcionCategoria.getText()
                +"' WHERE (`IDcategoria` = "+jTextIDCategoria.getText()+" );" ;
        cat.Actualizar(consulta);
        MostrarCategorias();   
        LimpiarCategoria();
    }//GEN-LAST:event_BotonActualizarCategoriaActionPerformed

    private void EliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCategoriaActionPerformed
        Categorias cat = new Categorias(); 
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar esta categoría?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        String consulta = "DELETE FROM `giraldo`.`categorias` WHERE (`IDcategoria` = "+jTextIDCategoria.getText()+");" ;
        if (confirm == JOptionPane.YES_OPTION) {
             cat.Eliminar(consulta);
        }
        MostrarCategorias();
        LimpiarCategoria();
    }//GEN-LAST:event_EliminarCategoriaActionPerformed

    private void JtextValorClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtextValorClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorClienteMouseClicked

    private void jTableConsumibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsumibleMouseClicked
        int filaSeleccionada = jTableConsumible.rowAtPoint(evt.getPoint());   
     
    //evento para seleccionar una fila
        
        JtextIDconsumible.setText(jTableConsumible.getValueAt(filaSeleccionada,0).toString());
        jtextNombreConsumible.setText(jTableConsumible.getValueAt(filaSeleccionada,1).toString());
        jtextDescripcionConsumible.setText(jTableConsumible.getValueAt(filaSeleccionada,2).toString());
        jTextTipoConsumible.setText(jTableConsumible.getValueAt(filaSeleccionada,3).toString());
        jTextPrecioConsumible.setText(jTableConsumible.getValueAt(filaSeleccionada,4).toString());
        jTextModoAd.setText(jTableConsumible.getValueAt(filaSeleccionada,5).toString());
        Object tiempoPreparacion = jTableConsumible.getValueAt(filaSeleccionada, 6);
        if (tiempoPreparacion != null) {
            jTextTiempoPreparacionConsumible.setText(tiempoPreparacion.toString());
        } else {
            jTextTiempoPreparacionConsumible.setText("");
        }
    }//GEN-LAST:event_jTableConsumibleMouseClicked

    private void jTableCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCategoriasMouseClicked
        int filaSeleccionada = jTableCategorias.rowAtPoint(evt.getPoint());   
     
    //evento para seleccionar una fila
        jTextIDCategoria.setText(jTableCategorias.getValueAt(filaSeleccionada,0).toString());
        JtextNombreCategoria.setText(jTableCategorias.getValueAt(filaSeleccionada,1).toString());
        jtextDescripcionCategoria.setText(jTableCategorias.getValueAt(filaSeleccionada,2).toString());
    }//GEN-LAST:event_jTableCategoriasMouseClicked

    private void BotonActualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarEmpleadoActionPerformed
    Empleados emp = new Empleados(); 
    String nombreCargo = jComboCargoEmpleado.getSelectedItem().toString(); 
    int IDcargo = emp.ObtenerIDCargo(nombreCargo);
    String consulta = "UPDATE `giraldo`.`empleados` SET `Nombre` = '"+jTextNombreEmpleado.getText()+"', `IDcargo` = '"+IDcargo+"', `Telefono` = '"+jTextTelefonoEmpleado.getText()+
            "', `CorreoElectronico` = '"+jTextCorreoEmpleado.getText()+"', `Direccion` = '"+jTextDireccionEmpleados.getText()+"'WHERE (`DNI` = "+jTextDNIEmpleados.getText()+" );" ;
    emp.Actualizar(consulta);
    MostrarEmpleados();
    LimpiarEmpleado();
    }//GEN-LAST:event_BotonActualizarEmpleadoActionPerformed

    private void jComboBusqEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqEmpleadoActionPerformed

    private void JtextValorEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtextValorEmpleadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorEmpleadoMouseClicked

    private void JtextValorEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorEmpleadoActionPerformed

    private void JtextValorEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorEmpleadoKeyReleased
    FiltrarDatosEmpleados(); 
    }//GEN-LAST:event_JtextValorEmpleadoKeyReleased

    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosMouseClicked
        int filaSeleccionada = jTableEmpleados.rowAtPoint(evt.getPoint());   
     
    //evento para seleccionar una fila
        
        jTextNombreEmpleado.setText(jTableEmpleados.getValueAt(filaSeleccionada,0).toString());
        jTextDNIEmpleados.setText(jTableEmpleados.getValueAt(filaSeleccionada,1).toString());
        jComboCargoEmpleado.setSelectedItem(jTableEmpleados.getValueAt(filaSeleccionada,2).toString());
        jTextTelefonoEmpleado.setText(jTableEmpleados.getValueAt(filaSeleccionada,4).toString());
        jTextCorreoEmpleado.setText(jTableEmpleados.getValueAt(filaSeleccionada,5).toString());
        jTextDireccionEmpleados.setText(jTableEmpleados.getValueAt(filaSeleccionada,6).toString());
        
    }//GEN-LAST:event_jTableEmpleadosMouseClicked

    private void jTextDNIEmpleadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIEmpleadosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDNIEmpleadosKeyTyped

    private void jComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCategoriaActionPerformed

    private void jComboCargoEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoMouseClicked

    }//GEN-LAST:event_jComboCargoEmpleadoMouseClicked

    private void jComboCargoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoActionPerformed

    }//GEN-LAST:event_jComboCargoEmpleadoActionPerformed

    private void jComboCargoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoKeyReleased
    }//GEN-LAST:event_jComboCargoEmpleadoKeyReleased

    private void jComboCargoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboCargoEmpleadoKeyTyped

    }//GEN-LAST:event_jComboCargoEmpleadoKeyTyped

    private void jTableEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableEmpleadosMouseEntered

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
    Empleados emp = new Empleados(); 
    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este empleado?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    String consulta = "DELETE FROM `giraldo`.`empleados` WHERE (`DNI` = "+jTextDNIEmpleados.getText()+");" ;
    if (confirm == JOptionPane.YES_OPTION) {
             emp.Eliminar(consulta);
        }    
    MostrarEmpleados();
    LimpiarEmpleado();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void JtextValorVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtextValorVentasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorVentasMouseClicked

    private void JtextValorVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorVentasActionPerformed

    private void JtextValorVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorVentasKeyReleased
        FiltrarDatosVentas();
    }//GEN-LAST:event_JtextValorVentasKeyReleased

    private void jComboBusqVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqVentasActionPerformed

    private void BotonActualizarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarVentasActionPerformed
        Ventas vent = new Ventas(); 
        String nombreCliente = jComboClienteVentas.getSelectedItem().toString(); 
        int IDcliente = vent.ObtenerIDCliente(nombreCliente);        
        String consulta = "UPDATE `giraldo`.`ventas` SET `Cantidad` = '"+jTextCantidadVentas.getText()+"', `MontoTotal` = '"+jTextMontoTotalVentas.getText()
                +"', `MetodoPago` = '"+jComboMetodoPagoVentas.getSelectedItem().toString()+"', `ID cliente` = '"+IDcliente+"' WHERE (`IDventa` = "+jTextIDVentas.getText()+" );";
        vent.Actualizar(consulta);
        MostrarVentas();
        LimpiarVenta();
    }//GEN-LAST:event_BotonActualizarVentasActionPerformed

    private void jComboBusqProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqProductosActionPerformed

    private void JtextValorProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtextValorProductosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorProductosMouseClicked

    private void JtextValorProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorProductosActionPerformed

    private void JtextValorProductosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorProductosKeyReleased
        FiltrarDatosProductos();
    }//GEN-LAST:event_JtextValorProductosKeyReleased

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        Productos prod = new Productos(); 
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        String consulta = "DELETE FROM `giraldo`.`productos` WHERE (`IDproducto` = "+jTextIDProducto.getText()+");" ;
        if (confirm == JOptionPane.YES_OPTION) {
             prod.Eliminar(consulta);
        }
        MostrarProductos();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void BotonActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarProductoActionPerformed
        Productos prod = new Productos(); 
        String nombreCategoria = jComboCategoriaProducto.getSelectedItem().toString(); 
        String nombreProveedor = jComboProveedorProducto.getSelectedItem().toString(); 
        int IDcategoria = prod.ObtenerIDCategoria(nombreCategoria);
        int IDproveedor = prod.ObtenerIDProveedor(nombreProveedor);
        String consulta = "UPDATE `giraldo`.`productos` SET `Nombre` = '"+jTextNombreProducto.getText()+"', `Descripcion` = '"+jTextDescripcionProducto.getText()+"', `IDcategoria` = '"+IDcategoria+"', `PrecioUnitario` = '"+jTextPrecioUnitario.getText()
                +"', `CantidadStock` = '"+jTextCantidadStock.getText()+"', `IDproveedor` = '"+IDproveedor+"' WHERE (`IDproducto` = "+jTextIDProducto.getText()+" );" ;
        prod.Actualizar(consulta);
        MostrarProductos();
    }//GEN-LAST:event_BotonActualizarProductoActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        MostrarProductos();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jTextNombreEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreEmpleadoKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreEmpleadoKeyTyped

    private void jTextTelefonoEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoEmpleadoKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoEmpleadoKeyTyped

    private void jTextNombreProveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreProveeKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreProveeKeyTyped

    private void jTextTelfProveeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelfProveeKeyTyped
        if(jTextTelfProvee.getText().length()>=9){
            evt.consume();
        }
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelfProveeKeyTyped

    private void jButtonVerRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerRedActionPerformed
        RedesSociales Redes= new RedesSociales();
        int filaSeleccionada = jTableEmpleados.getSelectedRow();
        if (filaSeleccionada != -1) {
            String dniEmpleadoSeleccionado = (String) jTableEmpleados.getValueAt(filaSeleccionada, 1);
            // Realizar una consulta para verificar si el empleado tiene una red social
            int idEmpleado= Redes.ObtenerIDEmpleado(dniEmpleadoSeleccionado);
            String consulta = "SELECT IDredsocial FROM `redes sociales` WHERE idEmpleado = ?";
            Connection conexion = Conexion.obtenerConexion();
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            try {
                statement = conexion.prepareStatement(consulta);
                statement.setInt(1, idEmpleado);
                resultSet = statement.executeQuery();

                // Si el resultado tiene al menos un registro, significa que el empleado tiene red social
                if (resultSet.next()) {
                    VerRedEmpleado Red = new VerRedEmpleado(dniEmpleadoSeleccionado);
                    Red.setVisible(true);
                } else {
                    // Aquí puedes mostrar un mensaje indicando que el empleado no tiene red social asociada
                    JOptionPane.showMessageDialog(null, "El empleado seleccionado no administra ninguna red social", "Sin Red Social", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
            } finally {
                // Cerrar los recursos de la base de datos
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conexion != null) {
                    try {
                        conexion.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonVerRedActionPerformed

    private void jTextIDProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDProductoActionPerformed

    private void jTextPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecioUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioUnitarioActionPerformed

    private void jComboProveedorProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProveedorProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboProveedorProductoActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        int filaSeleccionada = jTableProductos.rowAtPoint(evt.getPoint());   
     
        //evento para seleccionar una fila
        
        jTextIDProducto.setText(jTableProductos.getValueAt(filaSeleccionada,0).toString());
        jTextNombreProducto.setText(jTableProductos.getValueAt(filaSeleccionada,1).toString());
        jTextDescripcionProducto.setText(jTableProductos.getValueAt(filaSeleccionada,2).toString());
        jComboCategoriaProducto.setSelectedItem(jTableProductos.getValueAt(filaSeleccionada,3).toString());
        jTextPrecioUnitario.setText(jTableProductos.getValueAt(filaSeleccionada,4).toString());
        jTextCantidadStock.setText(jTableProductos.getValueAt(filaSeleccionada,6).toString());
        jComboProveedorProducto.setSelectedItem(jTableProductos.getValueAt(filaSeleccionada,7).toString());
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        AgregarProducto agr = new AgregarProducto();
        agr.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            MostrarProductos();
        }
        });
        agr.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextDireccionEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDireccionEmpleadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDireccionEmpleadosActionPerformed

    private void jComboBusqCombosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBusqCombosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBusqCombosActionPerformed

    private void JtextValorCombosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtextValorCombosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorCombosMouseClicked

    private void JtextValorCombosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtextValorCombosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtextValorCombosActionPerformed

    private void JtextValorCombosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtextValorCombosKeyReleased
        FiltrarDatosCombos();
    }//GEN-LAST:event_JtextValorCombosKeyReleased

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        Combos comb = new Combos(); 
        int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este combo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        String consulta = "DELETE FROM `giraldo`.`combos` WHERE (`IDcombo` = "+jTextIDCombo.getText()+");" ;
        if (confirm == JOptionPane.YES_OPTION) {
            comb.Eliminar(consulta);
        }    
        MostrarCombos();  
    }//GEN-LAST:event_jButton31ActionPerformed

    private void BotonActualizarComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonActualizarComboActionPerformed
        Combos comb = new Combos(); 
        String consulta = "UPDATE `giraldo`.`combos` SET `Nombre` = '"+jTextNombreCombo.getText()+"', `Descripcion` = '"+jTextDescripcionCombo.getText()+"', `Precio` = '"+jTextPrecioCombo.getText()
                +"', `Temporada` = '"+jTextTemporadaCombo.getText()+"' WHERE (`IDcombo` = "+jTextIDCombo.getText()+" );";
        comb.Actualizar(consulta);
        MostrarCombos();
    }//GEN-LAST:event_BotonActualizarComboActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        MostrarCombos();
        jButtonVerDetallesCombos.setEnabled(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        AgregarCombo agr = new AgregarCombo();
        agr.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                MostrarCombos();
            }
            });
        agr.setVisible(true);
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTextTemporadaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTemporadaComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTemporadaComboActionPerformed

    private void jTextIDComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDComboActionPerformed

    private void jTextPrecioComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecioComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioComboActionPerformed

    private void jTextIDVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDVentasActionPerformed

    private void jComboMetodoPagoVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMetodoPagoVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboMetodoPagoVentasActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        MostrarVentas();
        jButtonVerEntrega.setEnabled(true);
        jButtonVerDetallesVentas.setEnabled(true);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButtonVerEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerEntregaActionPerformed
        int filaSeleccionada = jTableVentas.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idVentaString = (String) jTableVentas.getValueAt(filaSeleccionada, 0);
            int idVenta = Integer.parseInt(idVentaString);

            VerEntrega Ent = new VerEntrega(idVenta);
            Ent.setVisible(true);               
        }
    }//GEN-LAST:event_jButtonVerEntregaActionPerformed

    private void jButtonVerDetallesVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDetallesVentasActionPerformed
        int filaSeleccionada = jTableVentas.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idVentaString = (String) jTableVentas.getValueAt(filaSeleccionada, 0);
            int idVenta = Integer.parseInt(idVentaString);

            VerDetallesVenta Det = new VerDetallesVenta(idVenta);
            Det.setVisible(true);               
        }
    }//GEN-LAST:event_jButtonVerDetallesVentasActionPerformed

    private void jButtonVerDetallesCombosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerDetallesCombosActionPerformed
        int filaSeleccionada = jTableCombos.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idComboString = (String) jTableCombos.getValueAt(filaSeleccionada, 0);
            int idCombo = Integer.parseInt(idComboString);

            VerDetallesCombo Det = new VerDetallesCombo(idCombo);
            Det.setVisible(true);               
        }
    }//GEN-LAST:event_jButtonVerDetallesCombosActionPerformed

    private void jTableCombosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCombosMouseClicked
        int filaSeleccionada = jTableCombos.rowAtPoint(evt.getPoint());   
     
        //evento para seleccionar una fila
        
        jTextIDCombo.setText(jTableCombos.getValueAt(filaSeleccionada,0).toString());
        jTextNombreCombo.setText(jTableCombos.getValueAt(filaSeleccionada,1).toString());
        jTextDescripcionCombo.setText(jTableCombos.getValueAt(filaSeleccionada,2).toString());
        jTextPrecioCombo.setText(jTableCombos.getValueAt(filaSeleccionada,3).toString());
        jTextTemporadaCombo.setText(jTableCombos.getValueAt(filaSeleccionada,4).toString());
    }//GEN-LAST:event_jTableCombosMouseClicked

    private void jTableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVentasMouseClicked

        int filaSeleccionada = jTableVentas.rowAtPoint(evt.getPoint());
        //evento para seleccionar una fila
        jTextIDVentas.setText(jTableVentas.getValueAt(filaSeleccionada,0).toString());
        jComboClienteVentas.setSelectedItem(jTableVentas.getValueAt(filaSeleccionada,2).toString());
        jTextFieldFechaVenta.setText(jTableVentas.getValueAt(filaSeleccionada,1).toString());
        jTextCantidadVentas.setText(jTableVentas.getValueAt(filaSeleccionada,3).toString());
        jTextMontoTotalVentas.setText(jTableVentas.getValueAt(filaSeleccionada,4).toString());
        jComboMetodoPagoVentas.setSelectedItem(jTableVentas.getValueAt(filaSeleccionada,5).toString());
    }//GEN-LAST:event_jTableVentasMouseClicked

    private void jTextSueldoCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSueldoCargoKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextSueldoCargoKeyTyped

    private void jTextModoAdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextModoAdKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextModoAdKeyTyped

    private void jTextNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreProductoKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreProductoKeyTyped

    private void jTextPrecioUnitarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioUnitarioKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioUnitarioKeyTyped

    private void jTextCantidadStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadStockKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadStockKeyTyped

    private void jTextNombreComboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreComboKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreComboKeyTyped

    private void jTextTemporadaComboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTemporadaComboKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isDigit(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextTemporadaComboKeyTyped

    private void jTextPrecioComboKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioComboKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioComboKeyTyped

    private void jTextNombreProveeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreProveeKeyReleased
    ValidarDatosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreProveeKeyReleased

    private void jTextRUCProveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRUCProveKeyReleased
    ValidarDatosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextRUCProveKeyReleased

    private void jTextRUCProveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextRUCProveKeyTyped
        char validar = evt.getKeyChar();
    
        if(Character.isLetter(validar)){
            evt.consume();
        }    
    }//GEN-LAST:event_jTextRUCProveKeyTyped

    private void jTextTelfProveeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelfProveeKeyReleased
    ValidarDatosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelfProveeKeyReleased

    private void jTextCorreoProveeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoProveeKeyReleased
    ValidarDatosProveedor();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoProveeKeyReleased

    private void jTextNombreEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreEmpleadoKeyReleased
    ValidarDatosEmpleado();      // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreEmpleadoKeyReleased

    private void jTextTelefonoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTelefonoEmpleadoKeyReleased
    ValidarDatosEmpleado();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoEmpleadoKeyReleased

    private void jTextCorreoEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCorreoEmpleadoKeyReleased
    ValidarDatosEmpleado();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextCorreoEmpleadoKeyReleased

    private void jTextDireccionEmpleadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionEmpleadosKeyReleased
    ValidarDatosEmpleado();          // TODO add your handling code here:
    }//GEN-LAST:event_jTextDireccionEmpleadosKeyReleased

    private void jTextNombreProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreProductoKeyReleased
    ValidarDatosProductos();   // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreProductoKeyReleased

    private void jTextDescripcionProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDescripcionProductoKeyReleased
    ValidarDatosProductos();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDescripcionProductoKeyReleased

    private void jTextPrecioUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioUnitarioKeyReleased
    ValidarDatosProductos();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioUnitarioKeyReleased

    private void jTextCantidadStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadStockKeyReleased
    ValidarDatosProductos();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadStockKeyReleased

    private void jTextCantidadVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCantidadVentasKeyReleased
    ValidarDatosVenta();    // TODO add your handling code here:
    }//GEN-LAST:event_jTextCantidadVentasKeyReleased

    private void jTextMontoTotalVentasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMontoTotalVentasKeyReleased
    ValidarDatosVenta();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMontoTotalVentasKeyReleased

    private void jTextNombreComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreComboKeyReleased
    ValidarDatosCombo();    // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreComboKeyReleased

    private void jTextDescripcionComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDescripcionComboKeyReleased
    ValidarDatosCombo();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextDescripcionComboKeyReleased

    private void jTextPrecioComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPrecioComboKeyReleased
    ValidarDatosCombo();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecioComboKeyReleased

    private void jTextTemporadaComboKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextTemporadaComboKeyReleased
    ValidarDatosCombo();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTemporadaComboKeyReleased

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
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonActualizarCargo;
    private javax.swing.JButton BotonActualizarCategoria;
    private javax.swing.JButton BotonActualizarCliente;
    private javax.swing.JButton BotonActualizarCombo;
    private javax.swing.JButton BotonActualizarConsumible;
    private javax.swing.JButton BotonActualizarEmpleado;
    private javax.swing.JButton BotonActualizarProducto;
    private javax.swing.JButton BotonActualizarProveedor;
    private javax.swing.JButton BotonActualizarVentas;
    private javax.swing.JPanel Cargos;
    private javax.swing.JPanel Categoria;
    private javax.swing.JPanel Clientes;
    private javax.swing.JPanel Combos;
    private javax.swing.JPanel Consumibles;
    private javax.swing.JButton EliminarCategoria;
    private javax.swing.JPanel Empleados;
    private javax.swing.JLabel JLabelCantidadVenta;
    private javax.swing.JLabel JLabelTelefonoProve;
    private javax.swing.JTextField JtextIDconsumible;
    private javax.swing.JTextField JtextNombreCargo;
    private javax.swing.JTextField JtextNombreCategoria;
    private javax.swing.JTextField JtextNombreCliente;
    private javax.swing.JTextField JtextValorCargo;
    private javax.swing.JTextField JtextValorCategoria;
    private javax.swing.JTextField JtextValorCliente;
    private javax.swing.JTextField JtextValorCombos;
    private javax.swing.JTextField JtextValorConsumibles1;
    private javax.swing.JTextField JtextValorEmpleado;
    private javax.swing.JTextField JtextValorProductos;
    private javax.swing.JTextField JtextValorProveedor;
    private javax.swing.JTextField JtextValorVentas;
    public javax.swing.JTabbedPane Pestañas;
    private javax.swing.JPanel Productos;
    private javax.swing.JPanel Proveedores;
    private javax.swing.JPanel Ventas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonAgregarProveedor;
    private javax.swing.JButton jButtonEliminarProveedor;
    private javax.swing.JButton jButtonVerDetallesCombos;
    private javax.swing.JButton jButtonVerDetallesVentas;
    private javax.swing.JButton jButtonVerEntrega;
    private javax.swing.JButton jButtonVerRed;
    private javax.swing.JComboBox<String> jComboBusqCargo;
    private javax.swing.JComboBox<String> jComboBusqCategoria;
    private javax.swing.JComboBox<String> jComboBusqCliente;
    private javax.swing.JComboBox<String> jComboBusqCombos;
    private javax.swing.JComboBox<String> jComboBusqConsumibles1;
    private javax.swing.JComboBox<String> jComboBusqEmpleado;
    private javax.swing.JComboBox<String> jComboBusqProductos;
    private javax.swing.JComboBox<String> jComboBusqProveedor;
    private javax.swing.JComboBox<String> jComboBusqVentas;
    private javax.swing.JComboBox<String> jComboCargoEmpleado;
    private javax.swing.JComboBox<String> jComboCategoria;
    private javax.swing.JComboBox<String> jComboCategoriaProducto;
    private javax.swing.JComboBox<String> jComboClienteVentas;
    private javax.swing.JComboBox<String> jComboMetodoPagoVentas;
    private javax.swing.JComboBox<String> jComboProveedorProducto;
    private javax.swing.JComboBox<String> jComboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAdquisicionConsum;
    private javax.swing.JLabel jLabelApellidoCliente;
    private javax.swing.JLabel jLabelCantidadProduct;
    private javax.swing.JLabel jLabelCorreoEmple;
    private javax.swing.JLabel jLabelCorreoProvee;
    private javax.swing.JLabel jLabelDescrip;
    private javax.swing.JLabel jLabelDescripCate;
    private javax.swing.JLabel jLabelDescripConsu;
    private javax.swing.JLabel jLabelDescripProduc;
    private javax.swing.JLabel jLabelDescripcionCargo;
    private javax.swing.JLabel jLabelDireccionEmple;
    private javax.swing.JLabel jLabelIDCargo;
    private javax.swing.JLabel jLabelIDCargo1;
    private javax.swing.JLabel jLabelMontoVenta;
    private javax.swing.JLabel jLabelNombreCate;
    private javax.swing.JLabel jLabelNombreCombo;
    private javax.swing.JLabel jLabelNombreConsumible;
    private javax.swing.JLabel jLabelNombreEmple;
    private javax.swing.JLabel jLabelNombreProduc;
    private javax.swing.JLabel jLabelNombreProve;
    private javax.swing.JLabel jLabelPrecioCombo;
    private javax.swing.JLabel jLabelPrecioConsum;
    private javax.swing.JLabel jLabelPrecioProduc;
    private javax.swing.JLabel jLabelRUCProve;
    private javax.swing.JLabel jLabelSueldoCargo;
    private javax.swing.JLabel jLabelTelefonoCliente;
    private javax.swing.JLabel jLabelTelefonoEmple;
    private javax.swing.JLabel jLabelTemporadaCombo;
    private javax.swing.JLabel jLabelTipoConsum;
    private javax.swing.JLabel jLabelcorreoCliente;
    private javax.swing.JLabel jLabelnombreCargo;
    private javax.swing.JLabel jLabelnombreCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableCargo;
    private javax.swing.JTable jTableCategorias;
    private javax.swing.JTable jTableCliente;
    private javax.swing.JTable jTableCombos;
    private javax.swing.JTable jTableConsumible;
    private javax.swing.JTable jTableEmpleados;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTable jTableProveedor;
    private javax.swing.JTable jTableVentas;
    private javax.swing.JTextField jTelefonoCliente;
    private javax.swing.JTextField jTextCantidadStock;
    private javax.swing.JTextField jTextCantidadVentas;
    private javax.swing.JTextField jTextCorreoCliente;
    private javax.swing.JTextField jTextCorreoEmpleado;
    private javax.swing.JTextField jTextCorreoProvee;
    private javax.swing.JTextField jTextDNICliente;
    private javax.swing.JTextField jTextDNIEmpleados;
    private javax.swing.JTextField jTextDescripcionCombo;
    private javax.swing.JTextField jTextDescripcionProducto;
    private javax.swing.JTextField jTextDireccionEmpleados;
    private javax.swing.JTextField jTextDireccionProve;
    private javax.swing.JTextField jTextFieldFechaVenta;
    private javax.swing.JTextField jTextIDCargo;
    private javax.swing.JTextField jTextIDCategoria;
    private javax.swing.JTextField jTextIDCombo;
    private javax.swing.JTextField jTextIDProducto;
    private javax.swing.JTextField jTextIDVentas;
    private javax.swing.JTextField jTextModoAd;
    private javax.swing.JTextField jTextMontoTotalVentas;
    private javax.swing.JTextField jTextNombreCombo;
    private javax.swing.JTextField jTextNombreEmpleado;
    private javax.swing.JTextField jTextNombreProducto;
    private javax.swing.JTextField jTextNombreProvee;
    private javax.swing.JTextField jTextPrecioCombo;
    private javax.swing.JTextField jTextPrecioConsumible;
    private javax.swing.JTextField jTextPrecioUnitario;
    private javax.swing.JTextField jTextRUCProve;
    private javax.swing.JTextField jTextSueldoCargo;
    private javax.swing.JTextField jTextTelefonoEmpleado;
    private javax.swing.JTextField jTextTelfProvee;
    private javax.swing.JTextField jTextTemporadaCombo;
    private javax.swing.JTextField jTextTiempoPreparacionConsumible;
    private javax.swing.JTextField jTextTipoConsumible;
    private javax.swing.JTextField jtextApellidoCliente;
    private javax.swing.JTextField jtextDescripcionCargo;
    private javax.swing.JTextField jtextDescripcionCategoria;
    private javax.swing.JTextField jtextDescripcionConsumible;
    private javax.swing.JTextField jtextNombreConsumible;
    // End of variables declaration//GEN-END:variables
}
