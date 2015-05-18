/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "inmueble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inmueble.findAll", query = "SELECT i FROM Inmueble i"),
    @NamedQuery(name = "Inmueble.findByIdInmueble", query = "SELECT i FROM Inmueble i WHERE i.idInmueble = :idInmueble"),
    @NamedQuery(name = "Inmueble.findByTitulo", query = "SELECT i FROM Inmueble i WHERE i.titulo = :titulo"),
    @NamedQuery(name = "Inmueble.findByDireccion", query = "SELECT i FROM Inmueble i WHERE i.direccion = :direccion"),
    @NamedQuery(name = "Inmueble.findByDistrito", query = "SELECT i FROM Inmueble i WHERE i.distrito = :distrito"),
    @NamedQuery(name = "Inmueble.findByLatitud", query = "SELECT i FROM Inmueble i WHERE i.latitud = :latitud"),
    @NamedQuery(name = "Inmueble.findByLongitud", query = "SELECT i FROM Inmueble i WHERE i.longitud = :longitud"),
    @NamedQuery(name = "Inmueble.findByDescripcion", query = "SELECT i FROM Inmueble i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Inmueble.findByPrecio", query = "SELECT i FROM Inmueble i WHERE i.precio = :precio"),
    @NamedQuery(name = "Inmueble.findByCantidadFavoritos", query = "SELECT i FROM Inmueble i WHERE i.cantidadFavoritos = :cantidadFavoritos"),
    @NamedQuery(name = "Inmueble.findByFechaCreacion", query = "SELECT i FROM Inmueble i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Inmueble.findByEliminado", query = "SELECT i FROM Inmueble i WHERE i.eliminado = :eliminado")})
public class Inmueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInmueble")
    private Integer idInmueble;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "distrito")
    private String distrito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitud")
    private BigDecimal latitud;
    @Column(name = "longitud")
    private BigDecimal longitud;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private BigDecimal precio;
    @Column(name = "cantidadFavoritos")
    private BigInteger cantidadFavoritos;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "eliminado")
    @JsonIgnore
    private Boolean eliminado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInmueble", fetch = FetchType.LAZY)
    private List<Imagen> imagenList;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "idTipoTransaccion", referencedColumnName = "idtipotransaccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoTransaccion idTipoTransaccion;
    @JoinColumn(name = "idTipoInmueble", referencedColumnName = "idTipoInmueble")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoInmueble idTipoInmueble;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInmueble", fetch = FetchType.LAZY)
    private List<Favoritos> favoritosList;

    public Inmueble() {
    }

    public Inmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
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

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigInteger getCantidadFavoritos() {
        return cantidadFavoritos;
    }

    public void setCantidadFavoritos(BigInteger cantidadFavoritos) {
        this.cantidadFavoritos = cantidadFavoritos;
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

    @XmlTransient
    public List<Imagen> getImagenList() {
        return imagenList;
    }

    public void setImagenList(List<Imagen> imagenList) {
        this.imagenList = imagenList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public TipoTransaccion getIdTipoTransaccion() {
        return idTipoTransaccion;
    }

    public void setIdTipoTransaccion(TipoTransaccion idTipoTransaccion) {
        this.idTipoTransaccion = idTipoTransaccion;
    }

    public TipoInmueble getIdTipoInmueble() {
        return idTipoInmueble;
    }

    public void setIdTipoInmueble(TipoInmueble idTipoInmueble) {
        this.idTipoInmueble = idTipoInmueble;
    }

    @XmlTransient
    public List<Favoritos> getFavoritosList() {
        return favoritosList;
    }

    public void setFavoritosList(List<Favoritos> favoritosList) {
        this.favoritosList = favoritosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInmueble != null ? idInmueble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmueble)) {
            return false;
        }
        Inmueble other = (Inmueble) object;
        if ((this.idInmueble == null && other.idInmueble != null) || (this.idInmueble != null && !this.idInmueble.equals(other.idInmueble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pe.com.b2c.dao.entity.Inmueble[ idInmueble=" + idInmueble + " ]";
    }
    
}
