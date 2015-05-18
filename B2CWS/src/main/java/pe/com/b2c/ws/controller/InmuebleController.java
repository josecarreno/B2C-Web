
package pe.com.b2c.ws.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.service.InmuebleService;
import pe.com.b2c.util.SystemException;
import pe.com.b2c.ws.constants.InmuebleURIConstants;
import pe.com.b2c.ws.util.WSUtil;
import pe.com.b2c.ws.wrapper.Respuesta;

@RestController
public class InmuebleController {
    private InmuebleService is = 
            (InmuebleService) WSUtil.obtenerService("INMUEBLE");
    
    @RequestMapping(value = InmuebleURIConstants.GET_INMUEBLE, 
            method = RequestMethod.GET, 
            produces = "Application/json")
    public @ResponseBody
    Inmueble getInmueble(@PathVariable("idInmueble") Integer id) throws SystemException {
        Inmueble i = is.obtener(id);
        return i;
    }
    
    @RequestMapping(value =InmuebleURIConstants.GET_ALL_INMUEBLE, 
            method = RequestMethod.GET, 
            produces = "Application/json")
    public @ResponseBody
    List<Inmueble> getAllInmuebles() throws SystemException{
        List<Inmueble> inmuebles = is.listar();
        return inmuebles;
    }

    @RequestMapping(value = InmuebleURIConstants.CREATE_INMUEBLE, 
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    Respuesta createInmueble(@RequestBody Inmueble i) throws SystemException{
        is.insertar(i);
        return new Respuesta("Inmueble creado correctamente");
    }
    
    @RequestMapping(value = InmuebleURIConstants.UPDATE_INMUEBLE, 
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    Respuesta updateInmueble(@RequestBody Inmueble i) throws SystemException{
        is.actualizar(i);
        return (new Respuesta("Se actualizo el inmueble correctamente"));
    }
    
    @RequestMapping(value = InmuebleURIConstants.DELETE_INMUEBLE, 
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    Respuesta deleteInmueble(@PathVariable("idInmueble") Integer id) throws SystemException{
        is.eliminar(id);
        return (new Respuesta("Se elimino el inmueble correctamente"));
    }
}
