package pe.com.b2c.service.impl;

import java.util.List;
import pe.com.b2c.dao.UsuarioDao;
import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.service.UsuarioService;
import pe.com.b2c.service.util.ServiceUtil;
import pe.com.b2c.util.SystemException;

public class UsuarioServiceImpl implements UsuarioService{

    //Inicio Singleton
    private static final UsuarioServiceImpl USUARIO_SERVICE_IMPL;
    private UsuarioDao usuarioDao;
    
    static{
        USUARIO_SERVICE_IMPL = new UsuarioServiceImpl();
    }
    
    private UsuarioServiceImpl(){
        usuarioDao = (UsuarioDao)ServiceUtil.obtenerDao("Usuario");
    }
    
    public static UsuarioServiceImpl obtenerInstancia(){
        return USUARIO_SERVICE_IMPL;
    }
    //Fin Singleton
    
    @Override
    public void insertar(Usuario e) throws SystemException {
        usuarioDao.insertar(e);
    }

    @Override
    public void actualizar(Usuario e) throws SystemException {
        usuarioDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        usuarioDao.eliminar(id);
    }

    @Override
    public Usuario obtener(Integer id) throws SystemException {
        return usuarioDao.obtener(id);
    }

    @Override
    public List<Usuario> listar() throws SystemException {
        return usuarioDao.listar();
    }
    
}
