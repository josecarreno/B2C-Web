/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Renato
 */
@Entity
@Table(name = "tipoinmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoInmueble.findAll", query = "SELECT t FROM TipoInmueble t"),
    @NamedQuery(name = "TipoInmueble.findByIdTipoInmueble", query = "SELECT t FROM TipoInmueble t WHERE t.idTipoInmueble = :idTipoInmueble"),
    @NamedQuery(name = "TipoInmueble.findByDescripcion", query = "SELECT t FROM TipoInmueble t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoInmueble.findByEliminado", query = "SELECT t FROM TipoInmueble t WHERE t.eliminado = :eliminado")})
public class TipoInmueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoInmueble")
    private Integer idTipoInmueble;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoInmueble", fetch = FetchType.EAGER)
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

    @XmlTransient
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
