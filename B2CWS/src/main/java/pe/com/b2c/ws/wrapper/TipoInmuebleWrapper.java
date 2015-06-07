package pe.com.b2c.ws.wrapper;

import pe.com.b2c.dao.entity.TipoInmueble;

public class TipoInmuebleWrapper {
    Integer idInmueble;
    String descripcion;

    public TipoInmuebleWrapper(TipoInmueble ti) {
        this.idInmueble = ti.getIdTipoInmueble();
        this.descripcion = ti.getDescripcion();
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
