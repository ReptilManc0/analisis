package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
public class RedesSociales extends FuncionesGenerales{
    //Atributos de la clase redes sociales
    public Object idRedSocial;
    public Object nombre;
    public Object tipo;
    public Date fechaCreacion;
    public Object usuario;
    public Object seguidores;
    public Object enlace;
    public Object empleado;
    
    public int ObtenerIDEmpleado(String dniEmpleado) {
        int idEmpleado = 0;

        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Consulta para obtener el ID del empleado por su DNI
            String consulta = "SELECT IDempleado FROM empleados WHERE DNI = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, dniEmpleado);

            resultSet = statement.executeQuery();

            // Verificar si se encontró el empleado y obtener su ID
            if (resultSet.next()) {
                idEmpleado = resultSet.getInt("IDempleado");
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

        return idEmpleado;
    }
}
