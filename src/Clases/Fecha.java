package Clases;
import java.util.Calendar;
public class Fecha {
    Calendar cal = Calendar.getInstance();
    public String createdate;
    public int year = cal.get(Calendar.YEAR);
    public int month;
    public int day;
    public void obtenerFecha(){
        month++;
        //Generacion de la fecha
        createdate = year+"-"+month+"-"+day;   
    } 
}
