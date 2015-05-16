/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.ws.app;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.b2c.dao.hibernate.entity.Usuario;
import pe.com.b2c.service.impl.UsuarioServiceImpl;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */

@RestController
public class Juanito {
    
    @RequestMapping("/listarUsuarios")
    public List<Usuario> listar() throws SystemException{
        
        
        return  UsuarioServiceImpl.obtenerInstancia().listar();
    }
    
}
