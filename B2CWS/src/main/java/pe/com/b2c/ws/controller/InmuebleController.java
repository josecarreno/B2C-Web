package pe.com.b2c.ws.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.b2c.dao.entity.Imagen;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.service.ImagenService;
import pe.com.b2c.service.InmuebleService;
import pe.com.b2c.util.SystemException;
import pe.com.b2c.ws.constants.InmuebleURIConstants;
import pe.com.b2c.ws.util.ListUtil;
import pe.com.b2c.ws.util.WSUtil;
import pe.com.b2c.ws.wrapper.InmuebleInWrapper;
import pe.com.b2c.ws.wrapper.InmuebleOutWrapper;
import pe.com.b2c.ws.wrapper.InmuebleSimpleWrapper;
import pe.com.b2c.ws.wrapper.Respuesta;

@RestController
public class InmuebleController {

    private final InmuebleService is
            = (InmuebleService) WSUtil.obtenerService("INMUEBLE");
    private final ImagenService imgs
            = (ImagenService) WSUtil.obtenerService("IMAGEN");

    @RequestMapping(value = InmuebleURIConstants.GET_INMUEBLE,
            method = RequestMethod.GET,
            produces = "Application/json")
    public @ResponseBody
    InmuebleOutWrapper getInmueble(@PathVariable("idInmueble") Integer id)
            throws SystemException {
        InmuebleOutWrapper i = new InmuebleOutWrapper(is.obtener(id));
        return i;
    }

    @RequestMapping(value = InmuebleURIConstants.GET_ALL_INMUEBLE,
            method = RequestMethod.GET,
            produces = "Application/json")
    public @ResponseBody
    List<InmuebleSimpleWrapper> getAllInmuebles() throws SystemException {
        List<InmuebleSimpleWrapper> inmuebles
                = ListUtil.getListSimpleInmueble(is.listar());
        return inmuebles;
    }

    @RequestMapping(value = InmuebleURIConstants.CREATE_INMUEBLE,
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    Respuesta createInmueble(@RequestBody InmuebleInWrapper i) throws SystemException {
        Inmueble in = i.getEntity();
        List<Imagen> imgIn = in.getImagenList();
        in.setImagenList(null);
        is.insertar(in);
        for (Imagen img : imgIn) {
            img.setIdInmueble(in);
            imgs.insertar(img);
        }
        Respuesta r = new Respuesta("Inmueble creado correctamente");
        return r;
    }

    @RequestMapping(value = InmuebleURIConstants.UPDATE_INMUEBLE,
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    Respuesta updateInmueble(@RequestBody InmuebleInWrapper i) throws SystemException {
        is.actualizar(i.getEntity());
        return (new Respuesta("Se actualizo el inmueble correctamente"));
    }

    @RequestMapping(value = InmuebleURIConstants.DELETE_INMUEBLE,
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    Respuesta deleteInmueble(@PathVariable("idInmueble") Integer id) throws SystemException {
        is.eliminar(id);
        return (new Respuesta("Se elimino el inmueble correctamente"));
    }

    @RequestMapping(value = InmuebleURIConstants.BUSCAR_INMUEBLES,
            method = RequestMethod.GET,
            produces = "Application/json")
    public @ResponseBody
    List<InmuebleSimpleWrapper>
            buscarInmueble(
                    @RequestParam(value = "sort") String sort,
                    @RequestParam(value = "search") String search)
            throws SystemException {
        List<InmuebleSimpleWrapper> inmuebles
                = ListUtil.getListSimpleInmueble(is.buscarInmueble(sort, search));
        return inmuebles;
    }

    @RequestMapping(value = InmuebleURIConstants.INMUEBLES_PROPIOS,
            method = RequestMethod.GET,
            produces = "Application/json")
    public @ResponseBody
    List<InmuebleSimpleWrapper> getInmueblesPropios(@PathVariable("idUsuario") Integer idUsuario)
            throws SystemException {
        List<InmuebleSimpleWrapper> inmuebles
                = ListUtil.getListSimpleInmueble(is.inmueblesPropios(idUsuario));
        return inmuebles;
    }
    
    @RequestMapping(value = InmuebleURIConstants.INMUEBLE_RADIO,
            method = RequestMethod.GET,
            produces = "Application/json")
    public @ResponseBody
    List<InmuebleSimpleWrapper>
            inmueblesEnRadio(
                    @RequestParam(value = "lat") BigDecimal lat,
                    @RequestParam(value = "lon") BigDecimal lon,
                    @RequestParam(value = "radio") BigDecimal radio)
            throws SystemException {
        List<InmuebleSimpleWrapper> inmuebles
                = ListUtil.getListSimpleInmueble(
                        is.inmueblesEnRadio(lat, lon, radio));
        return inmuebles;
    }

}
