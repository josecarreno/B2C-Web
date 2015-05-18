
package pe.com.b2c.dao;

import pe.com.b2c.dao.entity.Favoritos;
import pe.com.b2c.dao.base.EntityDao;
import pe.com.b2c.util.SystemException;


public interface FavoritosDao extends EntityDao<Favoritos, Integer>{
    
    void agregarInmuebleAFavoritos(Favoritos f, int idUsuario, int idInmueble) throws SystemException;
    
}
