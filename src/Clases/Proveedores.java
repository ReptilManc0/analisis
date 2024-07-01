package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Proveedores extends FuncionesGenerales{
    //Atributos de la clase proveedores
    public Object ruc;
    public Object nombre;
    public Object direccion;
    public Object tipo;
    public Object telefono;
    public Object correoElectronico;
    public Object categoria;
   //Método para agregar proveedores
    public void AgregarProveedor(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        //Insercion de un nuevo proveedor en la BD
        try {
            String consulta = "INSERT INTO `giraldo`.`proveedores` (`Nombre`, `RUC`, `Direccion`, `CorreoElectronico`, `Telefono`,`TipoProveedor`, `Categoria`) VALUES (?,?,?,?,?,?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);  
            //Preparacion de los parametros
            statement.setObject(1, nombre);
            statement.setObject(2, ruc);
            statement.setObject(3, direccion);
            statement.setObject(4, correoElectronico);
            statement.setObject(5, telefono);
            statement.setObject(6, tipo);
            statement.setObject(7, categoria);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro de proveedor exitoso");
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "El RUC ingresado ya se encuentra registrado en la base de datos");
        }  
    }
}
