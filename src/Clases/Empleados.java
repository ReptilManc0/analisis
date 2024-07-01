package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
public class Empleados extends FuncionesGenerales{
    //Atributos de la clase empleados
    public Object nombre;
    public Object dni;
    public Object cargo;
    public Date fechaNacimiento;
    public Object telefono;
    public Object correo;
    public Object direccion;
    // Método para agregar empleados
    public void AgregarEmpleado(){
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        // Inserción de un nuevo empleado en la BD
        try {
            String consultaObtenerIDCargo = "SELECT IDcargo FROM cargos WHERE Nombre = ?";
            PreparedStatement statementObtenerIDCargo = conexion.prepareStatement(consultaObtenerIDCargo);
            statementObtenerIDCargo.setObject(1, cargo);
            ResultSet resultSetIDCargo = statementObtenerIDCargo.executeQuery();
            // Verificar si se encontró el cargo y obtener su ID
            if (resultSetIDCargo.next()) {
                int idCargo = resultSetIDCargo.getInt("IDcargo");
                String consulta = "INSERT INTO `giraldo`.`empleados` (`Nombre`, `DNI`, `IDcargo`, `FechaNacimiento`, `Telefono`, `CorreoElectronico`, `Direccion`) VALUES (?,?,?,?,?,?,?);";
                // Preparar la consulta
                statement = conexion.prepareStatement(consulta);
                // Preparación de los parámetros
                statement.setObject(1, nombre);
                statement.setObject(2, dni);
                statement.setInt(3, idCargo);  // Insertar el ID del cargo obtenido
                statement.setObject(4, fechaNacimiento);
                statement.setObject(5, telefono);
                statement.setObject(6, correo);
                statement.setObject(7, direccion);
                // Ejecutar la consulta
                int filasAfectadas = statement.executeUpdate();
                statement.close();
                Conexion.cerrarConexion(conexion);
                JOptionPane.showMessageDialog(null, "Registro de empleado exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede agregar Empleado");
            }

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
    }
    public int ObtenerIDCargo(String nombreCargo) {
        int idCargo = 0;
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // Consultar para obtener el ID del cargo por su nombre
            String consulta = "SELECT IDcargo FROM cargos WHERE Nombre = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreCargo);
            resultSet = statement.executeQuery();
            // Verificar si se encontró el cargo y obtener su ID
            if (resultSet.next()) {
                idCargo = resultSet.getInt("IDcargo");
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
        return idCargo;
    }  
}
