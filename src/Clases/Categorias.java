package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Categorias extends FuncionesGenerales{
    //Atributos de la clase categorías
    public Object nombre;
    public Object descripcion;
    //Método para agregar Categoría
    public void AgregarCategoria(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        //Insercion de una nueva categoria en la BD
        try {
            String consulta = "INSERT INTO `giraldo`.`categorias` (`Nombre`, `Descripcion`) VALUES (?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);
            //Preparacion de los parametros
            statement.setObject(1, nombre);
            statement.setObject(2, descripcion);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro de categoría exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }  
    }
}
