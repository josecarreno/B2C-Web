package pe.com.b2c.ws.wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import pe.com.b2c.dao.entity.Usuario;

@JsonAutoDetect
public class UsuarioOutWrapper {
    
    private Integer idUsuario;
    private String usuario;
    private String nombre;
    private String email;
    private String ruc;
    private String direccion;
    private String web;
    private String telefono;
    private Integer idTipoUsuario;
    private String tipoUsuario;

    public UsuarioOutWrapper(Usuario u) {
        this.idUsuario = u.getIdUsuario();
        this.usuario = u.getUsuario();
        this.nombre = u.getNombre();
        this.email = u.getEmail();
        this.ruc = u.getRuc();
        this.direccion = u.getDireccion();
        this.web = u.getWeb();
        this.telefono = u.getTelefono();
        this.idTipoUsuario = u.getIdTipoUsuario().getIdTipoUsuario();
        this.tipoUsuario = u.getIdTipoUsuario().getDescripcion();
    }

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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
   
}
