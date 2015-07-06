package pe.com.b2c.service;

import java.util.List;
import pe.com.b2c.dao.entity.Favoritos;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.service.base.BaseService;
import pe.com.b2c.util.SystemException;

public interface FavoritosService extends BaseService<Favoritos, Integer>{
    public void agregarInmuebleAFavoritos(Integer idUsuario, Integer idInmueble) throws SystemException;
    public void eliminarFavorito(Integer idUsuario, Integer idInmueble) throws SystemException;
    public List<Inmueble> listarFavoritosUsuario(Integer idUsuario) throws SystemException;
    public Boolean estaEnFavoritos(Integer idUsuario, Integer idInmueble) throws SystemException;
}
