package pe.com.b2c.service;

import java.math.BigDecimal;
import java.util.List;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.service.base.BaseService;

public interface InmuebleService extends BaseService<Inmueble, Integer>{
    List<Inmueble> buscarInmueble(String sort, String search);
    List<Inmueble> inmueblesPropios(Integer idUsuario);
    List<Inmueble> inmueblesEnRadio(BigDecimal lat, 
            BigDecimal lon, BigDecimal radio);
}
