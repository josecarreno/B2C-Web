package pe.com.b2c.dao;

import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.dao.base.EntityDao;
import pe.com.b2c.util.SystemException;


public interface UsuarioDao extends EntityDao<Usuario, Integer>{
    
    Usuario validarUsuario(String usuario, String password) throws SystemException;
    
}
