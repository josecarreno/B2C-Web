
package pe.com.b2c.ws.util;

import pe.com.b2c.service.base.BaseService;
import pe.com.b2c.service.impl.FavoritosServiceImpl;
import pe.com.b2c.service.impl.ImagenServiceImpl;
import pe.com.b2c.service.impl.InmuebleServiceImpl;
import pe.com.b2c.service.impl.TipoInmuebleServiceImpl;
import pe.com.b2c.service.impl.TipoTransaccionServiceImpl;
import pe.com.b2c.service.impl.TipoUsuarioServiceImpl;
import pe.com.b2c.service.impl.UsuarioServiceImpl;

public class WSUtil {
    
    public static BaseService obtenerService(String clase){
        BaseService baseService = null;
        if (("FAVORITOS").equalsIgnoreCase(clase)) {
            baseService = FavoritosServiceImpl.obtenerInstancia();
        } else if(("IMAGEN").equalsIgnoreCase(clase)) {
            baseService = ImagenServiceImpl.obtenerInstancia();
        } else if(("INMUEBLE").equalsIgnoreCase(clase)) {
            baseService = InmuebleServiceImpl.obtenerInstancia();
        } else if(("TIPO_INMUEBLE").equalsIgnoreCase(clase)) {
            baseService = TipoInmuebleServiceImpl.obtenerInstancia();
        } else if(("TIPO_TRANSACCION").equalsIgnoreCase(clase)) {
            baseService = TipoTransaccionServiceImpl.obtenerInstancia();
        } else if(("TIPO_USUARIO").equalsIgnoreCase(clase)) {
            baseService = TipoUsuarioServiceImpl.obtenerInstancia();
        } else if(("USUARIO").equalsIgnoreCase(clase)) {
            baseService = UsuarioServiceImpl.obtenerInstancia();
        }
        return baseService;
    }
    
}
