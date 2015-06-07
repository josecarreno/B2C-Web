package pe.com.b2c.ws.wrapper;

import pe.com.b2c.dao.entity.TipoTransaccion;

public class TipoTransaccionWrapper {
    Integer idTipoTransaccion;
    String descripcion;

    public TipoTransaccionWrapper(TipoTransaccion tt) {
        this.idTipoTransaccion = tt.getIdtipotransaccion();
        this.descripcion = tt.getDescripcion();
    }

    public Integer getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(Integer idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
