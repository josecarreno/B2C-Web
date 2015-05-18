/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.impl;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.com.b2c.dao.FavoritosDao;
import pe.com.b2c.dao.base.BaseJdbcDao;
import pe.com.b2c.dao.entity.Favoritos;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.dao.entity.TipoInmueble;
import pe.com.b2c.dao.entity.TipoTransaccion;
import pe.com.b2c.dao.entity.TipoUsuario;
import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */
public class FavoritosJdbcDao extends BaseJdbcDao implements FavoritosDao{

    @Override
    public void insertar(Favoritos e) throws SystemException {
        
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO favoritos(idInmueble, idUsuario, fechaCreacion, eliminado) VALUES(?,?,?,?)");
            pr = cn.prepareStatement(sb.toString(),
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            pr.setInt(1, e.getIdInmueble().getIdInmueble());
            pr.setInt(2, e.getIdUsuario().getIdUsuario());
            
            
            java.sql.Date fecha;
            Date actual = new Date();
            fecha = new java.sql.Date(actual.getTime());
            
            pr.setDate(3, fecha);
            pr.setBoolean(4, false);
            
            pr.executeUpdate();
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdFavoritos(rs.getInt(1));
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
    }

    @Override
    public void actualizar(Favoritos e) throws SystemException {
        
         try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE favoritos SET ");
            sb.append("idInmueble = ? , idUsuario = ? , fechaCreacion = ? ");
            sb.append("WHERE ");
            sb.append("idFavoritos = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, e.getIdInmueble().getIdInmueble());
            pr.setInt(2, e.getIdUsuario().getIdUsuario());
            
            java.sql.Date fecha;
            Date actual = new Date();
            fecha = new java.sql.Date(actual.getTime());
            
            pr.setDate(3,fecha);
            pr.setInt(4, e.getIdFavoritos());
            
            pr.executeUpdate();
        }catch(Exception ex){
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr);
        }
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Favoritos obtener(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Favoritos> listar() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarInmuebleAFavoritos(Integer idUsuario, Integer idInmueble) throws SystemException {

        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO favoritos(idInmueble, idUsuario, fechaCreacion, eliminado) VALUES(?,?,?,?)");
            pr = cn.prepareStatement(sb.toString());
            
            pr.setInt(1, idInmueble);
            pr.setInt(2, idUsuario);
            
            
            java.sql.Date fecha;
            Date actual = new Date();
            fecha = new java.sql.Date(actual.getTime());
            
            pr.setDate(3, fecha);
            pr.setBoolean(4, false);
            
            pr.executeUpdate();
        
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
      
    }

    @Override
    public List<Inmueble> listarFavoritosUsuario(Integer idUsuario) throws SystemException {
        
        List<Inmueble> lista = new ArrayList<Inmueble>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM favoritos f JOIN inmueble i ON f.idInmueble = i.idInmueble WHERE f.idUsuario = ?");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            
            while(rs.next()){
                
                Inmueble i = new Inmueble();
                
                i.setIdInmueble(rs.getInt("idInmueble"));
                i.setTitulo(rs.getString("titulo"));
                i.setDireccion(rs.getString("direccion"));
                i.setDistrito(rs.getString("distrito"));
                i.setLatitud(rs.getBigDecimal("latitud"));
                i.setLongitud(rs.getBigDecimal("longitud"));
                i.setDescripcion(rs.getString("descripcion"));
                i.setPrecio(rs.getBigDecimal("precio"));
                
                i.setIdUsuario(new Usuario());
                i.getIdUsuario().setIdUsuario(rs.getInt("idUsuario"));
                i.getIdUsuario().setUsuario(rs.getString("usuario"));
                i.getIdUsuario().setPassword(rs.getString("password"));
                i.getIdUsuario().setNombre(rs.getString("nombre"));
                i.getIdUsuario().setEmail(rs.getString("email"));
                i.getIdUsuario().setRuc(rs.getString("ruc"));
                i.getIdUsuario().setDireccion(rs.getString("direccion"));
                i.getIdUsuario().setWeb(rs.getString("web"));
                i.getIdUsuario().setTelefono(rs.getString("telofono"));
                
                i.getIdUsuario().setIdTipoUsuario(new TipoUsuario());
                i.getIdUsuario().getIdTipoUsuario().setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                i.getIdUsuario().getIdTipoUsuario().setDescripcion(rs.getString("descripcion"));
                i.getIdUsuario().getIdTipoUsuario().setEliminado(rs.getBoolean("eliminado"));
                
                i.setIdTipoTransaccion(new TipoTransaccion());
                i.getIdTipoTransaccion().setIdtipotransaccion(rs.getInt("idTipoTransaccion"));
                i.getIdTipoTransaccion().setDescripcion(rs.getString("descripcion"));
                i.getIdTipoTransaccion().setEliminado(rs.getBoolean("eliminado"));
                
                BigInteger bi = BigInteger.valueOf(rs.getLong("cantidadFavoritos"));
                i.setCantidadFavoritos(bi);
                
                i.setFechaCreacion(rs.getDate("fechaCreacion"));
                i.setEliminado(rs.getBoolean("eliminado"));
                
                i.setIdTipoInmueble(new TipoInmueble());
                i.getIdTipoInmueble().setIdTipoInmueble(rs.getInt("idTipoInmueble"));
                i.getIdTipoInmueble().setDescripcion(rs.getString("descripcion"));
                i.getIdTipoInmueble().setEliminado(rs.getBoolean("eliminado"));
                
                i.setEliminado(rs.getBoolean("eliminado"));
                
                lista.add(i);
                
                
            }
            
        } catch (Exception e) {
        }finally{
            cerrar(cn, pr, rs);
        }
        return lista;
    }

    @Override
    public void eliminarFavorito(Integer idUsuario, Integer idInmueble) throws SystemException {
        
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE b2cdb.favoritos f SET f.eliminado = 1 WHERE f.idUsuario = ? AND f.idInmueble = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, idUsuario);
            pr.setInt(2, idInmueble);
            
            pr.executeUpdate();
            
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
    }
    
}
