package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
public class Productos extends FuncionesGenerales{
    //Atributos de la clase productos
    public Object nombre;
    public Object descripcion;
    public Object categoria;
    public Object precioUnitario;
    public Date fechaAgregacion;
    public Object cantidadStock;
    public Object proveedor;
     // Método para agregar productos
    public void AgregarProducto(){
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        // Inserción de un nuevo producto en la BD
        try {
            String consultaObtenerIDCategoria = "SELECT IDcategoria FROM categorias WHERE Nombre = ?";
            PreparedStatement statementObtenerIDCategoria = conexion.prepareStatement(consultaObtenerIDCategoria);
            statementObtenerIDCategoria.setObject(1, categoria);
            ResultSet resultSetIDCategoria = statementObtenerIDCategoria.executeQuery();
            
            String consultaObtenerIDProveedor = "SELECT IDproveedor FROM proveedores WHERE Nombre = ?";
            PreparedStatement statementObtenerIDProveedor = conexion.prepareStatement(consultaObtenerIDProveedor);
            statementObtenerIDProveedor.setObject(1, proveedor);
            ResultSet resultSetIDProveedor = statementObtenerIDProveedor.executeQuery();
            // Verificar si se encontró la categoria y obtener su ID
            if (resultSetIDCategoria.next() && resultSetIDProveedor.next()) {
                int idCategoria = resultSetIDCategoria.getInt("IDcategoria");
                int idProveedor = resultSetIDProveedor.getInt("IDproveedor");
                String consulta = "INSERT INTO `giraldo`.`productos` (`Nombre`, `descripcion`, `IDcategoria`, `PrecioUnitario`, `FechaAgregacion`, `CantidadStock`, `IDproveedor`) VALUES (?,?,?,?,?,?,?);";
                // Preparar la consulta
                statement = conexion.prepareStatement(consulta);
                // Preparación de los parámetros
                statement.setObject(1, nombre);
                statement.setObject(2, descripcion);
                statement.setInt(3, idCategoria);
                statement.setObject(4, precioUnitario);
                statement.setObject(5, fechaAgregacion);
                statement.setObject(6, cantidadStock);
                statement.setObject(7, idProveedor);
                // Ejecutar la consulta
                int filasAfectadas = statement.executeUpdate();
                statement.close();
                Conexion.cerrarConexion(conexion);
                JOptionPane.showMessageDialog(null, "Registro de producto exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede agregar producto");
            }

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
    }
    public int ObtenerIDCategoria(String nombreCategoria) {
        int idCategoria = 0;
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // Consultar para obtener el ID de la categoria por su nombre
            String consulta = "SELECT IDcategoria FROM categorias WHERE Nombre = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreCategoria);
            resultSet = statement.executeQuery();
            // Verificar si se encontró la categoría y obtener su ID
            if (resultSet.next()) {
                idCategoria = resultSet.getInt("IDcategoria");
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
        return idCategoria;
    }
    public int ObtenerIDProveedor(String nombreProveedor) {
        int idProveedor = 0;
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // Consultar para obtener el ID del proveedor por su nombre
            String consulta = "SELECT IDproveedor FROM proveedores WHERE Nombre = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreProveedor);
            resultSet = statement.executeQuery();
            // Verificar si se encontró el proveedor y obtener su ID
            if (resultSet.next()) {
                idProveedor = resultSet.getInt("IDproveedor");
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
        return idProveedor;
    }
    
}
