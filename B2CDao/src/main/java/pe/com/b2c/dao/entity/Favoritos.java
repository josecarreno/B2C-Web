/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "favoritos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favoritos.findAll", query = "SELECT f FROM Favoritos f"),
    @NamedQuery(name = "Favoritos.findByIdFavoritos", query = "SELECT f FROM Favoritos f WHERE f.idFavoritos = :idFavoritos"),
    @NamedQuery(name = "Favoritos.findByFechaCreacion", query = "SELECT f FROM Favoritos f WHERE f.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Favoritos.findByEliminado", query = "SELECT f FROM Favoritos f WHERE f.eliminado = :eliminado")})
public class Favoritos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFavoritos")
    private Integer idFavoritos;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "eliminado")
    @JsonIgnore
    private Boolean eliminado;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "idInmueble", referencedColumnName = "idInmueble")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
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
