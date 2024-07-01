package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsumiblesEnCombo extends FuncionesGenerales{
    public int idCombo;
    public int idConsumible;
    public List<String> ObtenerNombresConsumibles() {
        List<String> nombresConsumibles = new ArrayList<>();
        Connection conexion = Conexion.obtenerConexion();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String consulta = "SELECT Nombre FROM Consumibles";
            statement = conexion.createStatement();
            resultSet = statement.executeQuery(consulta);
            while (resultSet.next()) {
                String nombreConsumible = resultSet.getString("Nombre");
                nombresConsumibles .add(nombreConsumible);
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
        return nombresConsumibles;
    }
    public int ObtenerIdConsumible(String nombreConsumible) {
        idConsumible = 0;
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String consulta = "SELECT IDConsumible FROM Consumibles WHERE Nombre = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombreConsumible);
            resultSet = statement.executeQuery();
            // Obtener el ID del producto
            if (resultSet.next()) {
                idConsumible = resultSet.getInt("IDConsumible");
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
        return idConsumible;
    }
    public int ObtenerUltimoIdCombo() {
        idCombo = -1;
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
             String consulta = "SELECT MAX(IDCombo) AS UltimoID FROM Combos";
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
    public void AgregarConsumibleCombo(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        try {
            String consulta = "INSERT INTO `giraldo`.`consumibles en combos` (`IDcombo`, `IDconsumible`) VALUES (?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);
            statement.setObject(1, idCombo);
            statement.setObject(2, idConsumible);
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Consumible agregado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Debe seleccionar un consumible para agregar en el combo");
        }  
    }
}
