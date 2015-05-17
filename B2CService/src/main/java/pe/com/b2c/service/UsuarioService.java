package pe.com.b2c.service;

import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.service.base.BaseService;
import pe.com.b2c.util.SystemException;

public interface UsuarioService extends BaseService<Usuario, Integer> {
    
    Usuario validarUsuario(String usuario, String password) 
            throws SystemException;
    
}
