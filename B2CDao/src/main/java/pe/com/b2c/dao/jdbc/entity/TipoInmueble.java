/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.entity;

import java.util.List;

public class TipoInmueble{
    
   
    private Integer idTipoInmueble;
    private String descripcion;
    private Boolean eliminado;
    private List<Inmueble> inmuebleList;

    public TipoInmueble() {
    }

    public TipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    public Integer getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(Integer idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
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
        hash += (idTipoInmueble != null ? idTipoInmueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoInmueble)) {
            return false;
        }
        TipoInmueble other = (TipoInmueble) object;
        if ((this.idTipoInmueble == null && other.idTipoInmueble != null) || (this.idTipoInmueble != null && !this.idTipoInmueble.equals(other.idTipoInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.b2c.dao.entity.TipoInmueble[ idTipoInmueble=" + idTipoInmueble + " ]";
    }
    
}
