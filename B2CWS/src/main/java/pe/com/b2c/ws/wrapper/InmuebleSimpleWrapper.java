package pe.com.b2c.ws.wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.math.BigDecimal;
import pe.com.b2c.dao.entity.Inmueble;

@JsonAutoDetect
public class InmuebleSimpleWrapper {
    private Integer id;
    private String titulo;
    private String direccion;
    private BigDecimal precio;
    private byte[] imagen;
    private String tipoTransaccion;

    public InmuebleSimpleWrapper(Inmueble i) {
        this.id = i.getIdInmueble();
        this.titulo = i.getTitulo();
        this.direccion = i.getDireccion();
        this.precio = i.getPrecio();
        this.imagen = i.getImagenList().get(0).getImgBlob();
        this.tipoTransaccion = i.getIdTipoTransaccion().getDescripcion();
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
    
}
