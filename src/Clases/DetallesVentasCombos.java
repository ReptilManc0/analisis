package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DetallesVentasCombos extends FuncionesGenerales{
    public int idCombo;
    public int idVenta;
    
    public void ActualizarCantidadStockCombos() {
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;

        try {
            String consulta = "UPDATE combos c " +
                              "INNER JOIN `detalles ventas con combos` vc ON c.IDcombo = vc.IDcombo " +
                              "INNER JOIN `productos en combos` pc ON c.IDcombo = pc.IDcombo " +
                              "INNER JOIN productos p ON pc.IDproducto = p.IDproducto " +
                              "SET p.CantidadStock = p.CantidadStock - 1 " +
                              "WHERE vc.IDventa = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idVenta);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la cantidad en stock de combos: " + e.getMessage());
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
    public List<String> ObtenerNombresCombos() {
        List<String> nombresCombos = new ArrayList<>();
        Connection conexion = Conexion.obtenerConexion();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String consulta = "SELECT Nombre FROM Combos";
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String nombreCombo = resultSet.getString("Nombre");
                nombresCombos.add(nombreCombo);
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
        return nombresCombos;
    }
    public int ObtenerIdCombo(String nombreCombo) {
        idCombo = 0;
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String consulta = "SELECT IDcombo FROM combos WHERE Nombre = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreCombo);
            resultSet = statement.executeQuery();
            // Obtener el ID del producto
            if (resultSet.next()) {
                idCombo = resultSet.getInt("IDcombo");
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
    public void AgregarComboVenta(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        try {
            String consulta = "INSERT INTO `giraldo`.`detalles ventas con combos` (`IDventa`, `IDcombo`) VALUES (?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);
            statement.setObject(1, idVenta);
            statement.setObject(2, idCombo);
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Combo agregado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un combo para agregar en la venta");
        }  
    }
}
