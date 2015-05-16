package pe.com.b2c.service.impl;

import java.util.List;
import pe.com.b2c.dao.TipoInmuebleDao;
import pe.com.b2c.dao.hibernate.entity.TipoInmueble;
import pe.com.b2c.service.TipoInmuebleService;
import pe.com.b2c.service.util.ServiceUtil;
import pe.com.b2c.util.SystemException;

public class TipoInmuebleServiceImpl implements TipoInmuebleService {

    //Inicio Singleton
    private static final TipoInmuebleServiceImpl TIPO_INMUEBLE_SERVICE_IMPL;
    private TipoInmuebleDao tipoInmuebleDao;

    static {
        TIPO_INMUEBLE_SERVICE_IMPL = new TipoInmuebleServiceImpl();
    }

    private TipoInmuebleServiceImpl() {
        tipoInmuebleDao = (TipoInmuebleDao) ServiceUtil.obtenerDao("TipoInmueble");
    }

    public static TipoInmuebleServiceImpl obtenerInstancia() {
        return TIPO_INMUEBLE_SERVICE_IMPL;
    }
    //Fin Singleton

    @Override
    public void insertar(TipoInmueble e) throws SystemException {
        tipoInmuebleDao.insertar(e);
    }

    @Override
    public void actualizar(TipoInmueble e) throws SystemException {
        tipoInmuebleDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        tipoInmuebleDao.eliminar(id);
    }

    @Override
    public TipoInmueble obtener(Integer id) throws SystemException {
        return tipoInmuebleDao.obtener(id);
    }

    @Override
    public List<TipoInmueble> listar() throws SystemException {
        return tipoInmuebleDao.listar();
    }

}
