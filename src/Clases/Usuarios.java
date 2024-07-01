
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Usuarios extends Fecha {
    public String IdUsuario;
    public String nombre;
    public String apellidos;
    public String username;
    public String password;
    public String contraconfi;
    public String createdate;
    
    public void ObtenerFecha() {   
        // Creación del objeto de la clase Calendar
        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1; // Sumar 1 ya que los meses en Calendar empiezan desde 0
        int day = cal.get(Calendar.DAY_OF_MONTH);

        // Generación de la fecha en formato YYYY-MM-DD
        createdate = String.format("%d-%02d-%02d", year, month, day);   
    }
    
    public void AgregarUsuario(){    
//Variables para la conexion
    Connection  conexion = Conexion.obtenerConexion();
    PreparedStatement statement = null;
        
        try {
            // Preparar la consulta
            String consulta = "INSERT INTO `giraldo`.`usuarios` (`Usuario`, `Contraseña`, `Nombres`, `Apellidos`, `Fecha de creacion`) VALUES (?,?,?,?,?);";
            statement = conexion.prepareStatement(consulta);            
            
            // Preparación de los parámetros
            statement.setObject(1, username);
            statement.setObject(2, password);
            statement.setObject(3, nombre);
            statement.setObject(4, apellidos);
            statement.setObject(5, createdate);

            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null,"Registro de usuario exitoso");
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo registrar el usuario");
            }  
            
            } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } 
}

    public ResultSet RecuperarDatoUsuario(){
    
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            
            // Preparar la consulta
            String consulta = "SELECT * FROM usuarios WHERE Usuario = ? AND Contraseña = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setString(1, username);
            statement.setString(2, password);

            // Ejecutar la consulta
            resultSet = statement.executeQuery();
            
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } 
            return resultSet;
        }
           
            
            
        
        

}



