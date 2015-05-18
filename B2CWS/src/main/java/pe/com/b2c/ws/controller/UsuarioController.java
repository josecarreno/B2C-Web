package pe.com.b2c.ws.controller;

import java.util.List;
import pe.com.b2c.ws.constants.UsuarioURIConstants;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.service.UsuarioService;
import pe.com.b2c.util.SystemException;
import pe.com.b2c.ws.util.WSUtil;
import pe.com.b2c.ws.wrapper.Respuesta;
import pe.com.b2c.ws.wrapper.ValidaUsuario;

@RestController
public class UsuarioController {

    private UsuarioService us = (UsuarioService) WSUtil.obtenerService("USUARIO");
    
    @RequestMapping(value = UsuarioURIConstants.GET_USER, 
            method = RequestMethod.GET, 
            produces = "Application/json")
    public @ResponseBody
    Usuario getUsuario(@PathVariable("idUsuario") Integer id) throws SystemException {
        Usuario u = us.obtener(id);
        return u;
    }
    
    @RequestMapping(value = UsuarioURIConstants.GET_ALL_USER, 
            method = RequestMethod.GET, 
            produces = "Application/json")
    public @ResponseBody
    List<Usuario> getAllUsuarios() throws SystemException{
        List<Usuario> users = us.listar();
        return users;
    }

    @RequestMapping(value = UsuarioURIConstants.CREATE_USER, 
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    void createUsuario(@RequestBody Usuario u) throws SystemException{
        us.insertar(u);
    }
    
    @RequestMapping(value = UsuarioURIConstants.UPDATE_USER, 
            method = RequestMethod.POST,
            produces = "Application/json")
    public @ResponseBody
    Respuesta updateUsuario(@RequestBody Usuario u) throws SystemException{
        us.actualizar(u);
        return (new Respuesta("Se actualizo el usuario correctamente"));
    }

    @RequestMapping(value = UsuarioURIConstants.LOGIN_USER, 
            method = RequestMethod.POST,
            consumes = "Application/json",
            produces = "Application/json")
    public @ResponseBody
    Usuario loginUsuario(@RequestBody ValidaUsuario vu)
            throws SystemException{
        return us.validarUsuario(vu.getUsuario(), vu.getPassword());
    }
    
}
