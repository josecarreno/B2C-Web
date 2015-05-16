/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.entity;

import java.util.List;


/**
 *
 * @author Renato
 */

public class TipoTransaccion{
    
    private Integer idtipotransaccion;
    private String descripcion;
    private Boolean eliminado;
    private List<Inmueble> inmuebleList;

    public TipoTransaccion() {
    }

    public TipoTransaccion(Integer idtipotransaccion) {
        this.idtipotransaccion = idtipotransaccion;
    }

    public Integer getIdtipotransaccion() {
        return idtipotransaccion;
    }

    public void setIdtipotransaccion(Integer idtipotransaccion) {
        this.idtipotransaccion = idtipotransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public List<Inmueble> getInmuebleList() {
        return inmuebleList;
    }

    public void setInmuebleList(List<Inmueble> inmuebleList) {
        this.inmuebleList = inmuebleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipotransaccion != null ? idtipotransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTransaccion)) {
            return false;
        }
        TipoTransaccion other = (TipoTransaccion) object;
        if ((this.idtipotransaccion == null && other.idtipotransaccion != null) || (this.idtipotransaccion != null && !this.idtipotransaccion.equals(other.idtipotransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.b2c.dao.entity.TipoTransaccion[ idtipotransaccion=" + idtipotransaccion + " ]";
    }
    
}
