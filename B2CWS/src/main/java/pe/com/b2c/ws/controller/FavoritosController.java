package pe.com.b2c.ws.controller;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.service.FavoritosService;
import pe.com.b2c.util.SystemException;
import pe.com.b2c.ws.constants.FavoritosURIConstants;
import pe.com.b2c.ws.util.ListUtil;
import pe.com.b2c.ws.util.WSUtil;
import pe.com.b2c.ws.wrapper.EstaEnFavoritosWrapper;
import pe.com.b2c.ws.wrapper.FavoritosWrapper;
import pe.com.b2c.ws.wrapper.InmuebleSimpleWrapper;
import pe.com.b2c.ws.wrapper.Respuesta;

@RestController
public class FavoritosController {
    private FavoritosService fs = (FavoritosService) WSUtil.obtenerService("FAVORITOS");
    
    @RequestMapping(value = FavoritosURIConstants.ADD_FAVORITO, 
            method = RequestMethod.POST, 
            produces = "Application/json")
    public @ResponseBody
    Respuesta addFavorito(@RequestBody FavoritosWrapper f) throws SystemException {
        fs.agregarInmuebleAFavoritos(f.getIdUsuario(), f.getIdInmueble());
        return new Respuesta("Inmueble agregado a favoritos correctamente");
    }
    
    @RequestMapping(value = FavoritosURIConstants.DELETE_FAVORITO, 
            method = RequestMethod.POST, 
            produces = "Application/json")
    public @ResponseBody
    Respuesta deleteFavorito(@RequestBody FavoritosWrapper f) throws SystemException {
        fs.eliminarFavorito(f.getIdUsuario(), f.getIdInmueble());
        return new Respuesta("Inmueble eliminado de favoritos correctamente");
    }
    
    @RequestMapping(value =FavoritosURIConstants.GET_FAVORITOS, 
            method = RequestMethod.GET, 
            produces = "Application/json")
    public @ResponseBody
    List<InmuebleSimpleWrapper> getFavoritos(@PathVariable("idUsuario") Integer id) throws SystemException{
        List<Inmueble> inmuebles = fs.listarFavoritosUsuario(id);
        return ListUtil.getListSimpleInmueble(inmuebles);
    }
    
    @RequestMapping(value = FavoritosURIConstants.ES_FAVORITO,
            method = RequestMethod.GET,
            produces = "Application/json")
    public @ResponseBody
    EstaEnFavoritosWrapper
            esFavorito(
                    @RequestParam(value = "idUsuario") Integer idUsuario,
                    @RequestParam(value = "idInmueble") Integer idInmueble)
            throws SystemException {
        EstaEnFavoritosWrapper ef = new EstaEnFavoritosWrapper();
        ef.setValor(fs.estaEnFavoritos(idUsuario, idInmueble));
        return ef;
    }
}
