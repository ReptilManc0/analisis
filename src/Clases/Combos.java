package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Combos extends FuncionesGenerales{
    //Atributos de la clase combos
    public Object nombre;
    public Object descripcion;
    public Object precio;
    public Object temporada;
    //Método para agregar combos
    public void AgregarCombos(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        //Insercion de un nuevo combo en la BD
        try {
            String consulta = "INSERT INTO `giraldo`.`combos` (`Nombre`, `Descripcion`, `Precio`, `Temporada`) VALUES (?,?,?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);  
            //Preparacion de los parametros
            statement.setObject(1, nombre);
            statement.setObject(2, descripcion);
            statement.setObject(3, precio);
            statement.setObject(4, temporada);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro de combo exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }  
    }
}
