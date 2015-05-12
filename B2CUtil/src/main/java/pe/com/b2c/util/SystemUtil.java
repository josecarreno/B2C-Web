package pe.com.b2c.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class SystemUtil {
    
    //Constructor privado para que nadie pueda instanciar la clase
    private SystemUtil(){
        
    }
    //Metodo para obtener informacion de un archivo .properties
    public static String obtenerPropiedad(String archivo, String clave){
        ResourceBundle rb = ResourceBundle.getBundle(archivo);
        return rb.getString(clave);
    }
    
    //Metodo para formatear fechas
    public static String convertirDate(Date fecha, String formato){
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(fecha);
    }
    
    public static String idError(){
        return convertirDate(new Date(), "ddMMyyyyhhmmss");
    }
    
    //Metodo para obtener una variable del sistema
    public static String obtenerVariableSistema(String clave){
        return System.getProperty(clave);
    }
    
    public static String validaNulo(String texto){
        return texto == null ? "" : texto;
    }
    
    
}
