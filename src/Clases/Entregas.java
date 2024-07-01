
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Entregas extends FuncionesGenerales{
    public Date fecha;
    public Object estado;
    public Object direccion;
    public Object provincia;
    public Object empleado;
    public Object idVenta;
    public void AgregarEntrega(){
        // Variables para la conexión
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        // Inserción de una nueva entrega en la BD
        try {
            String consultaObtenerIDEmpleado = "SELECT `IDempleado` FROM empleados WHERE Nombre = ?";
            PreparedStatement statementObtenerIDEmpleado= conexion.prepareStatement(consultaObtenerIDEmpleado);
            statementObtenerIDEmpleado.setObject(1, empleado);
            ResultSet resultSetIDempleado = statementObtenerIDEmpleado.executeQuery();
            
            // Verificar si se encontró el empleado y obtener su ID
            if (resultSetIDempleado.next()) {
                int idEmpleado = resultSetIDempleado.getInt("IDempleado");
                String consulta = "INSERT INTO `giraldo`.`entregas` (`Fecha`, `IDempleado`, `Estado de entrega`, `Direccion`, `Provincia`, `IDventa`) VALUES (?,?,?,?,?,?);";
                // Preparar la consulta
                statement = conexion.prepareStatement(consulta);
                // Preparación de los parámetros
                statement.setObject(1, fecha);
                statement.setObject(2, idEmpleado);
                statement.setObject(3, estado);
                statement.setObject(4, direccion);
                statement.setObject(5, provincia);
                statement.setObject(6, idVenta);
                // Ejecutar la consulta
                int filasAfectadas = statement.executeUpdate();
                statement.close();
                Conexion.cerrarConexion(conexion);
                JOptionPane.showMessageDialog(null, "Registro de entrega exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "No se puede agregar Entrega");
            }

        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta "+e.toString());
        }
    }
          
}
