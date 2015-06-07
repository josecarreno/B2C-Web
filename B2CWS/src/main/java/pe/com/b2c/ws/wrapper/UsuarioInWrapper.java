package pe.com.b2c.ws.wrapper;

import pe.com.b2c.dao.entity.TipoUsuario;
import pe.com.b2c.dao.entity.Usuario;

public class UsuarioInWrapper {

    private Integer idUsuario;
    private String usuario;
    private String password;
    private String nombre;
    private String email;
    private String ruc;
    private String direccion;
    private String web;
    private String telefono;
    private Integer idTipoUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }
 
    public Usuario getEntity() {
        Usuario u = new Usuario();
        u.setIdUsuario(idUsuario);
        u.setDireccion(direccion);
        u.setEliminado(Boolean.FALSE);
        u.setEmail(email);
        
        TipoUsuario tu = new TipoUsuario();
        tu.setIdTipoUsuario(idTipoUsuario);
        u.setIdTipoUsuario(tu);
        
        u.setNombre(nombre);
        u.setPassword(password);
        u.setRuc(ruc);
        u.setTelefono(telefono);
        u.setUsuario(usuario);
        u.setWeb(web);
        
        return u;
    }
}
