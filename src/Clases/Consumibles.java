package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Consumibles extends FuncionesGenerales{
    //Atributos de la clase consumible
    public Object nombre;
    public Object descripcion;
    public Object tipo;
    public Object precio;
    public Object modoDeAdquisicion;
    public Object tiempoDePreparacion;
    //Método para agregar consumibles
    public void AgregarConsumibles(){
        //Variables para la conexion
        Connection  conexion = Conexion.obtenerConexion();
        PreparedStatement statement = null;
        //Insercion de un nuevo consumible en la BD
        try {
            String consulta = "INSERT INTO `giraldo`.`consumibles` (`Nombre`, `Descripcion`, `Tipo`, `Precio`, `ModoDeAdquisicion`, `TiempoDePreparacion`) VALUES (?,?,?,?,?,?);";
            // Preparar la consulta
            statement = conexion.prepareStatement(consulta);
            //Preparacion de los parametros
            statement.setObject(1, nombre);
            statement.setObject(2, descripcion);
            statement.setObject(3, tipo);
            statement.setObject(4, precio);
            statement.setObject(5, modoDeAdquisicion);
            statement.setObject(6, tiempoDePreparacion);
            // Ejecutar la consulta
            int filasAfectadas = statement.executeUpdate();
            statement.close();
            Conexion.cerrarConexion(conexion);
            JOptionPane.showMessageDialog(null,"Registro de consumible exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }  
    }
}
