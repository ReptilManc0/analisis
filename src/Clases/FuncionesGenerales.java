package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class FuncionesGenerales {
    public ResultSet Consultar(String consulta){
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement;
        ResultSet resultSet=null;
        try {
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);
            // Ejecutar la consulta
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } 
        return resultSet;
    }
    public void Actualizar(String Consulta){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        try {
            // Preparar la consulta
            statement = conexion.prepareStatement(Consulta);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro Editado exitosamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar el registro: " + e.getMessage());
            e.printStackTrace();  
        }
    }
    public void Eliminar(String Consulta){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            // Preparar la consulta
            statement = conexion.prepareStatement(Consulta);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro"+ e.getMessage());
        }
    }
}
