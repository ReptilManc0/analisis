package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetallesVentasProductos extends FuncionesGenerales{
    public int idProducto;
    public int idVenta;
    
    public void ActualizarCantidadStockProductos() {
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;

        try {
            String consulta = "UPDATE productos p " +
                              "INNER JOIN `detalles ventas con productos` vp ON p.IDproducto = vp.IDproducto " +
                              "SET p.CantidadStock = p.CantidadStock - 1 " +
                              "WHERE vp.IDventa = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idVenta);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad en stock de productos: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                Conexion.cerrarConexion(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public int ObtenerCantidadStockProducto(String nombreProducto) {
    int cantidadStock = 0;
    Connection conexion = Conexion.obtenerConexion();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        String consulta = "SELECT CantidadStock FROM productos WHERE Nombre = ?";
        statement = conexion.prepareStatement(consulta);
        statement.setString(1, nombreProducto);
        resultSet = statement.executeQuery();

        if (resultSet.next()) {
            cantidadStock = resultSet.getInt("CantidadStock");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener la cantidad en stock del producto: " + e.getMessage());
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

    return cantidadStock;
}
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
    public int ObtenerUltimoIdventa() {
        idVenta = -1;
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String consulta = "SELECT MAX(IDventa) AS UltimoID FROM ventas";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
            idVenta = resultSet.getInt("UltimoID");
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
        return idVenta;
    }
    public void AgregarProductoCombo(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        try {
            String consulta = "INSERT INTO `giraldo`.`detalles ventas con productos` (`IDventa`, `IDproducto`) VALUES (?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);
            statement.setObject(1, idVenta);
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
