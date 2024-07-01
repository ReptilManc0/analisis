package Clases;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductosEnCombo extends FuncionesGenerales {
    public int idCombo;
    public int idProducto;
    
    public List<String> ObtenerNombresProductos() {
        List<String> nombresProductos = new ArrayList<>();
        Connection conexion = Conexion.obtenerConexion();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String consulta = "SELECT Nombre FROM Productos";
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String nombreProducto = resultSet.getString("Nombre");
                nombresProductos.add(nombreProducto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                Conexion.cerrarConexion(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nombresProductos;
    }
    public int ObtenerIdProducto(String nombreProducto) {
        idProducto = 0;
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String consulta = "SELECT IDProducto FROM Productos WHERE Nombre = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreProducto);
            resultSet = statement.executeQuery();
            // Obtener el ID del producto
            if (resultSet.next()) {
                idProducto = resultSet.getInt("IDProducto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                Conexion.cerrarConexion(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idProducto;
    }
    public int ObtenerUltimoIdCombo() {
        idCombo = -1;
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
             String consulta = "SELECT MAX(IDcombo) AS UltimoID FROM Combos";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
            idCombo = resultSet.getInt("UltimoID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                Conexion.cerrarConexion(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return idCombo;
    }
    public void AgregarProductoCombo(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        try {
            String consulta = "INSERT INTO `giraldo`.`productos en combos` (`IDcombo`, `IDproducto`) VALUES (?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);
            statement.setObject(1, idCombo);
            statement.setObject(2, idProducto);
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Producto agregado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un producto para agregar en el combo");
        }  
    }
}