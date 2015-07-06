package pe.com.b2c.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.dao.base.EntityDao;

public interface InmuebleDao extends EntityDao<Inmueble, Integer>{
    List<Inmueble> buscarInmueble(String sort, String search);
    List<Inmueble> inmueblesPropios(Integer idUsuario);
    List<Inmueble> inmueblesEnRadio(BigDecimal lat, 
            BigDecimal lon, BigDecimal radio);
}
