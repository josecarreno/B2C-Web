package pe.com.b2c.service.impl;

import java.util.List;
import pe.com.b2c.dao.InmuebleDao;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.service.InmuebleService;
import pe.com.b2c.service.util.ServiceUtil;
import pe.com.b2c.util.SystemException;

public class InmuebleServiceImpl implements InmuebleService{

    //Inicio Singleton
    private static final InmuebleServiceImpl INMUEBLE_SERVICE_IMPL;
    private InmuebleDao inmuebleDao;
    
    static{
        INMUEBLE_SERVICE_IMPL = new InmuebleServiceImpl();
    }
    
    private InmuebleServiceImpl(){
        inmuebleDao = (InmuebleDao)ServiceUtil.obtenerDao("Inmueble");
    }
    
    public static InmuebleServiceImpl obtenerInstancia(){
        return INMUEBLE_SERVICE_IMPL;
    }
    //Fin Singleton
    
    @Override
    public void insertar(Inmueble e) throws SystemException {
        inmuebleDao.insertar(e);
    }

    @Override
    public void actualizar(Inmueble e) throws SystemException {
        inmuebleDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        inmuebleDao.eliminar(id);
    }

    @Override
    public Inmueble obtener(Integer id) throws SystemException {
        return inmuebleDao.obtener(id);
    }

    @Override
    public List<Inmueble> listar() throws SystemException {
        return inmuebleDao.listar();
    }
    
}
