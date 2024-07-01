package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Giraldo";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "Dayana/18";
    // Método para obtener la conexión a la base de datos
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");  
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al establecer la conexión: " + e.getMessage());
        }
        return conexion;
    }
    // Método para cerrar la conexión a la base de datos
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
