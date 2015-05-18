/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * @author jose
 */
@Entity
@Table(name = "tipotransaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTransaccion.findAll", query = "SELECT t FROM TipoTransaccion t"),
    @NamedQuery(name = "TipoTransaccion.findByIdtipotransaccion", query = "SELECT t FROM TipoTransaccion t WHERE t.idtipotransaccion = :idtipotransaccion"),
    @NamedQuery(name = "TipoTransaccion.findByDescripcion", query = "SELECT t FROM TipoTransaccion t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoTransaccion.findByEliminado", query = "SELECT t FROM TipoTransaccion t WHERE t.eliminado = :eliminado")})
public class TipoTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipotransaccion")
    private Integer idtipotransaccion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "eliminado")
    @JsonIgnore
    private Boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransaccion", fetch = FetchType.LAZY)
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
