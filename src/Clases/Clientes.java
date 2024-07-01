package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
public class Clientes extends FuncionesGenerales{
    //Atributos de la clase clientes
    public Object dni;
    public Object nombres;
    public Object apellidos;
    public Date fechaNacimiento = null ;
    public Object telefono;
    public Object correoElectronico;
    public Object distrito;
    public Object direccion;
    //Método para agregar clientes
    public void AgregarCliente(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        //Insercion de un nuevo cliente en la BD
        try {
            String consulta = "INSERT INTO `giraldo`.`clientes` (`Nombre`, `Apellidos`, `DNI`, `FechaNacimiento`, `Telefono`, `CorreoElectronico`, `Distrito`, `Direccion`) VALUES (?,?,?,?,?,?,?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);  
            //Preparacion de los parametros
            statement.setObject(1, nombres);
            statement.setObject(2, apellidos);
            statement.setObject(3, dni);
            statement.setObject(4, fechaNacimiento);
            statement.setObject(5, telefono);
            statement.setObject(6, correoElectronico);
            statement.setObject(7, distrito);
            statement.setObject(8, direccion);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro de cliente exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "El DNI ingresado ya se encuentra registrado en la base de datos");
        }  
    }
}


