/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.entity;

import java.util.Date;



/**
 *
 * @author Renato
 */

public class Favoritos{
    
    private Integer idFavoritos;
    private Date fechaCreacion;
    private Boolean eliminado;
    private Usuario idUsuario;
    private Inmueble idInmueble;

    public Favoritos() {
    }

    public Favoritos(Integer idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public Integer getIdFavoritos() {
        return idFavoritos;
    }

    public void setIdFavoritos(Integer idFavoritos) {
        this.idFavoritos = idFavoritos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Inmueble getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Inmueble idInmueble) {
        this.idInmueble = idInmueble;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFavoritos != null ? idFavoritos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favoritos)) {
            return false;
        }
        Favoritos other = (Favoritos) object;
        if ((this.idFavoritos == null && other.idFavoritos != null) || (this.idFavoritos != null && !this.idFavoritos.equals(other.idFavoritos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.b2c.dao.entity.Favoritos[ idFavoritos=" + idFavoritos + " ]";
    }
    
}
