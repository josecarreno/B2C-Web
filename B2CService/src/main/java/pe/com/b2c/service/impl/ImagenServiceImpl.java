package pe.com.b2c.service.impl;

import java.util.List;
import pe.com.b2c.dao.ImagenDao;
import pe.com.b2c.dao.entity.Imagen;
import pe.com.b2c.service.ImagenService;
import pe.com.b2c.service.util.ServiceUtil;
import pe.com.b2c.util.SystemException;

public class ImagenServiceImpl implements ImagenService{

    //Inicio Singleton
    private static final ImagenServiceImpl IMAGEN_SERVICE_IMPL;
    private ImagenDao imagenDao;
    
    static{
        IMAGEN_SERVICE_IMPL = new ImagenServiceImpl();
    }
    
    private ImagenServiceImpl(){
        imagenDao = (ImagenDao)ServiceUtil.obtenerDao("Imagen");
    }
    
    public static ImagenServiceImpl obtenerInstancia(){
        return IMAGEN_SERVICE_IMPL;
    }
    //Fin Singleton
    
    @Override
    public void insertar(Imagen e) throws SystemException {
        imagenDao.insertar(e);
    }

    @Override
    public void actualizar(Imagen e) throws SystemException {
        imagenDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        imagenDao.eliminar(id);
    }

    @Override
    public Imagen obtener(Integer id) throws SystemException {
        return imagenDao.obtener(id);
    }

    @Override
    public List<Imagen> listar() throws SystemException {
        return imagenDao.listar();
    }
    
}
