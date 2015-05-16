package pe.com.b2c.service.impl;

import java.util.List;
import pe.com.b2c.dao.TipoUsuarioDao;
import pe.com.b2c.dao.entity.TipoUsuario;
import pe.com.b2c.service.TipoUsuarioService;
import pe.com.b2c.service.util.ServiceUtil;
import pe.com.b2c.util.SystemException;

public class TipoUsuarioServiceImpl implements TipoUsuarioService{

    //Inicio Singleton
    private static final TipoUsuarioServiceImpl TIPO_USUARIO_SERVICE_IMPL;
    private TipoUsuarioDao tipoUsuarioDao;
    
    static{
        TIPO_USUARIO_SERVICE_IMPL = new TipoUsuarioServiceImpl();
    }
    
    private TipoUsuarioServiceImpl(){
        tipoUsuarioDao = (TipoUsuarioDao)ServiceUtil.obtenerDao("ImagenService");
    }
    
    public static TipoUsuarioServiceImpl obtenerInstancia(){
        return TIPO_USUARIO_SERVICE_IMPL;
    } 
    //Fin Singleton
    
    @Override
    public void insertar(TipoUsuario e) throws SystemException {
        tipoUsuarioDao.insertar(e);
    }

    @Override
    public void actualizar(TipoUsuario e) throws SystemException {
        tipoUsuarioDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        tipoUsuarioDao.eliminar(id);
    }

    @Override
    public TipoUsuario obtener(Integer id) throws SystemException {
        return tipoUsuarioDao.obtener(id);
    }

    @Override
    public List<TipoUsuario> listar() throws SystemException {
        return tipoUsuarioDao.listar();
    }
    
}
