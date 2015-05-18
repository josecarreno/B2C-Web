
package pe.com.b2c.dao;

import java.util.List;
import pe.com.b2c.dao.entity.Favoritos;
import pe.com.b2c.dao.base.EntityDao;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.util.SystemException;


public interface FavoritosDao extends EntityDao<Favoritos, Integer>{
    
    void agregarInmuebleAFavoritos(Integer idUsuario, Integer idInmueble) throws SystemException;
    List<Inmueble> listarFavoritosUsuario(Integer idUsuario) throws SystemException;
    void eliminarFavorito(Integer idUsuario, Integer idInmueble) throws SystemException;
    
    
    
    
}
