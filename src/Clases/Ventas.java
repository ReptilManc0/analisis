package Clases ;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
public class Ventas extends FuncionesGenerales{
    //Atributos de la clase ventas
    public Date fecha;
    public String cliente;
    public String cantidad;
    public String montoTotal;
    public String metodoPago;
    public int ObtenerIDCliente(String nombreCliente) {
        int idCliente = 0;
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // Consultar para obtener el ID del cliente por su nombre
            String consulta = "SELECT `ID cliente` FROM clientes WHERE Nombre = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreCliente);
            resultSet = statement.executeQuery();
            // Verificar si se encontró el cliente y obtener su ID
            if (resultSet.next()) {
                idCliente = resultSet.getInt("ID cliente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de ObtenerID: " + e.getMessage());
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
        return idCliente;
    }
    public void AgregarVenta(){
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        // Inserción de una nueva venta en la BD
        try {
            String consultaObtenerIDCliente = "SELECT `ID cliente` FROM clientes WHERE Nombre = ?";
            PreparedStatement statementObtenerIDCliente = conexion.prepareStatement(consultaObtenerIDCliente);
            statementObtenerIDCliente.setObject(1, cliente);
            ResultSet resultSetIDcliente = statementObtenerIDCliente.executeQuery();
            
            // Verificar si se encontró el cliente y obtener su ID
            if (resultSetIDcliente.next()) {
                int idCliente = resultSetIDcliente.getInt("ID cliente");
                String consulta = "INSERT INTO `giraldo`.`ventas` (`fecha`, `ID cliente`, `cantidad`, `MontoTotal`, `MetodoPago`) VALUES (?,?,?,?,?);";
                // Preparar la consulta
                statement = conexion.prepareStatement(consulta);
                // Preparación de los parámetros
                statement.setObject(1, fecha);
                statement.setObject(2, idCliente);
                statement.setObject(3, cantidad);
                statement.setObject(4, montoTotal);
                statement.setObject(5, metodoPago);
                // Ejecutar la consulta
                int filasAfectadas = statement.executeUpdate();
                statement.close();
                Conexion.cerrarConexion(conexion);
                JOptionPane.showMessageDialog(null, "Registro de venta exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede agregar Venta");
            }

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta"+e.toString());
        }
    }
}
