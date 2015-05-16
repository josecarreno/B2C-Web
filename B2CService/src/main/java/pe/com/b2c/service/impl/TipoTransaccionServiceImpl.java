package pe.com.b2c.service.impl;
import java.util.List;
import pe.com.b2c.dao.TipoTransaccionDao;
import pe.com.b2c.dao.entity.TipoTransaccion;
import pe.com.b2c.service.TipoTransaccionService;
import pe.com.b2c.service.util.ServiceUtil;
import pe.com.b2c.util.SystemException;

public class TipoTransaccionServiceImpl implements TipoTransaccionService{

    //Inicio Singleton
    private static final TipoTransaccionServiceImpl TIPO_TRANSACCION_SERVICE_IMPL;
    private TipoTransaccionDao tipoTransaccionDao;
    
    static{
        TIPO_TRANSACCION_SERVICE_IMPL = new TipoTransaccionServiceImpl();
    }
    
    private TipoTransaccionServiceImpl(){
        tipoTransaccionDao = (TipoTransaccionDao)ServiceUtil.obtenerDao("TipoTransaccion");
    }
    
    public static TipoTransaccionServiceImpl obtenerInstancia(){
        return TIPO_TRANSACCION_SERVICE_IMPL;
    }
    //Fin Singleton
    
    @Override
    public void insertar(TipoTransaccion e) throws SystemException {
        tipoTransaccionDao.insertar(e);
    }

    @Override
    public void actualizar(TipoTransaccion e) throws SystemException {
        tipoTransaccionDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        tipoTransaccionDao.eliminar(id);
    }

    @Override
    public TipoTransaccion obtener(Integer id) throws SystemException {
        return tipoTransaccionDao.obtener(id);
    }

    @Override
    public List<TipoTransaccion> listar() throws SystemException {
        return tipoTransaccionDao.listar();
    }
    
}
