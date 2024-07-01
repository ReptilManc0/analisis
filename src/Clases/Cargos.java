package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Cargos extends FuncionesGenerales{
    //Atributos de la clase cargos
    public Object nombre;
    public Object descripcion;
    public Object sueldo;
    //Método para agregar cargos
    public void AgregarCargo(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        //Insercion de un nuevo cargo en la BD
        try {
            String consulta = "INSERT INTO `giraldo`.`cargos` (`Nombre`, `Descripcion`, `Sueldo`) VALUES (?,?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);  
            //Preparacion de los parametros
            statement.setObject(1, nombre);
            statement.setObject(2, descripcion);
            statement.setObject(3, sueldo);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro de cargo exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }  
    }
}
