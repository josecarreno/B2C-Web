package pe.com.b2c.ws.wrapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.ws.util.ListUtil;

public class InmuebleOutWrapper {

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

    private String usuario;

    private TipoTransaccionWrapper tipoTransaccion;

    private TipoInmuebleWrapper tipoInmueble;

    private List<ImagenWrapper> imagenList;

    public InmuebleOutWrapper(Inmueble i) {
        
        this.cantidadFavoritos = i.getCantidadFavoritos();
        this.descripcion = i.getDescripcion();
        this.direccion = i.getDireccion();
        this.distrito = i.getDistrito();
        this.fechaCreacion = i.getFechaCreacion();
        this.idInmueble = i.getIdInmueble();
        this.idUsuario = i.getIdUsuario().getIdUsuario();
        this.imagenList = ListUtil.getListImagenWrapper(i.getImagenList());
        this.latitud = i.getLatitud();
        this.longitud = i.getLongitud();
        this.precio = i.getPrecio();
        this.tipoInmueble = new TipoInmuebleWrapper(i.getIdTipoInmueble());
        this.tipoTransaccion = new TipoTransaccionWrapper(i.getIdTipoTransaccion());
        this.titulo = i.getTitulo();
        this.usuario = i.getIdUsuario().getUsuario();
        
    }
    
    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

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

    public String getNombreUsuario() {
        return usuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.usuario = nombreUsuario;
    }

    public TipoTransaccionWrapper getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccionWrapper tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public TipoInmuebleWrapper getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmuebleWrapper tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public List<ImagenWrapper> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<ImagenWrapper> imagenList) {
        this.imagenList = imagenList;
    }
    
}
