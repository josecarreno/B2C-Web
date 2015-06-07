package pe.com.b2c.ws.wrapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.dao.entity.TipoInmueble;
import pe.com.b2c.dao.entity.TipoTransaccion;
import pe.com.b2c.dao.entity.Usuario;

public class InmuebleInWrapper {

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }
    
    private Integer idInmueble;

    private String titulo;

    private String direccion;

    private String distrito;

    private BigDecimal latitud;

    private BigDecimal longitud;

    private String descripcion;

    private BigDecimal precio;

    private BigInteger cantidadFavoritos;

    private Date fechaCreacion;

    private Integer idUsuario;

    private Integer idTipoTransaccion;

    private Integer idTipoInmueble;

    private List<ImagenWrapper> imagenList;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigInteger getCantidadFavoritos() {
        return cantidadFavoritos;
    }

    public void setCantidadFavoritos(BigInteger cantidadFavoritos) {
        this.cantidadFavoritos = cantidadFavoritos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public Integer getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public List<ImagenWrapper> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<ImagenWrapper> imagenList) {
        this.imagenList = imagenList;
    }

    
    public Inmueble getEntity() {
        Inmueble i = new Inmueble();
        i.setIdInmueble(idInmueble);
        i.setCantidadFavoritos(cantidadFavoritos);
        i.setDescripcion(descripcion);
        i.setDireccion(direccion);
        i.setDistrito(distrito);
        i.setEliminado(Boolean.FALSE);
        i.setFechaCreacion(fechaCreacion);
        
        TipoInmueble ti = new TipoInmueble();
        ti.setIdTipoInmueble(idTipoInmueble);
        i.setIdTipoInmueble(ti);
        
        TipoTransaccion tt = new TipoTransaccion();
        tt.setIdtipotransaccion(idTipoTransaccion);
        i.setIdTipoTransaccion(tt);
        
        Usuario u = new Usuario();
        u.setIdUsuario(idUsuario);
        i.setIdUsuario(u);
        
        i.setImagenList(null);
        
        return i;
    }
}
