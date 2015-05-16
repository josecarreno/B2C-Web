/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Renato
 */
public class Inmueble{
   
    private Integer idInmueble;
    private String titulo;
    private String direccion;
    private String distrito;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private String descripcion;
    private BigDecimal precio;
    private BigInteger cantidadFavoritos;
    private Date fechaCreacion;
    private Boolean eliminado;
    private List<Imagen> imagenList;
    private Usuario idUsuario;
    private TipoTransaccion idTipoTransaccion;
    private TipoInmueble idTipoInmueble;
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
