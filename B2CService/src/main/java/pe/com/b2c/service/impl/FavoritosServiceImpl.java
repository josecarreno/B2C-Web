package pe.com.b2c.service.impl;

import java.util.List;
import pe.com.b2c.dao.FavoritosDao;
import pe.com.b2c.dao.entity.Favoritos;
import pe.com.b2c.service.FavoritosService;
import pe.com.b2c.service.util.ServiceUtil;
import pe.com.b2c.util.SystemException;

public class FavoritosServiceImpl implements FavoritosService{

    //Inicio Singleton
    private static final FavoritosServiceImpl FAVORITOS_SERVICE_IMPL;
    private FavoritosDao favoritosDao;
    
    static{
        FAVORITOS_SERVICE_IMPL = new FavoritosServiceImpl();
    }
    
    private FavoritosServiceImpl(){
        favoritosDao = (FavoritosDao)ServiceUtil.obtenerDao("Favoritos");
    }
    
    public static FavoritosServiceImpl obtenerInstancia(){
        return FAVORITOS_SERVICE_IMPL;
    }
    //Fin Singleton
    
    @Override
    public void insertar(Favoritos e) throws SystemException {
        favoritosDao.insertar(e);
    }

    @Override
    public void actualizar(Favoritos e) throws SystemException {
        favoritosDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        favoritosDao.eliminar(id);
    }

    @Override
    public Favoritos obtener(Integer id) throws SystemException {
        return favoritosDao.obtener(id);
    }

    @Override
    public List<Favoritos> listar() throws SystemException {
        return favoritosDao.listar();
    }
    
}
