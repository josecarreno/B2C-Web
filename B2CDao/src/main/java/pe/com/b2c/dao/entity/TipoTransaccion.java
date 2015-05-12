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
@Table(name = "tipotransaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotransaccion.findAll", query = "SELECT t FROM Tipotransaccion t"),
    @NamedQuery(name = "Tipotransaccion.findByIdtipotransaccion", query = "SELECT t FROM Tipotransaccion t WHERE t.idtipotransaccion = :idtipotransaccion"),
    @NamedQuery(name = "Tipotransaccion.findByDescripcion", query = "SELECT t FROM Tipotransaccion t WHERE t.descripcion = :descripcion")})
public class TipoTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtipotransaccion")
    private Integer idtipotransaccion;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransaccion", fetch = FetchType.EAGER)
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
        return "pe.com.b2c.dao.entity.Tipotransaccion[ idtipotransaccion=" + idtipotransaccion + " ]";
    }
    
}
