package pe.com.b2c.ws.wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import pe.com.b2c.dao.entity.Inmueble;

@JsonAutoDetect
public class InmuebleSimpleWrapper {
    private Integer id;
    private String titulo;
    private String direccion;
    private BigDecimal precio;
    private byte[] imagen;
    private String tipoTransaccion;
    private Date fecha;
    private BigInteger favoritos;
    private BigDecimal latidud;
    private BigDecimal longitud;

    public InmuebleSimpleWrapper() {
    }

    public InmuebleSimpleWrapper(Inmueble i) {
        this.id = i.getIdInmueble();
        this.titulo = i.getTitulo();
        this.direccion = i.getDireccion();
        this.precio = i.getPrecio();
        this.imagen = i.getImagenList().get(0).getImgBlob();
        this.tipoTransaccion = i.getIdTipoTransaccion().getDescripcion();
        this.fecha = i.getFechaCreacion();
        this.favoritos = i.getCantidadFavoritos();
        this.latidud = i.getLatitud();
        this.longitud = i.getLongitud();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(BigInteger favoritos) {
        this.favoritos = favoritos;
    }

    public BigDecimal getLatidud() {
        return latidud;
    }

    public void setLatidud(BigDecimal latidud) {
        this.latidud = latidud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
    
}
