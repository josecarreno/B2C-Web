/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;
import pe.com.b2c.dao.FavoritosDao;
import pe.com.b2c.dao.base.BaseJdbcDao;
import pe.com.b2c.dao.entity.Favoritos;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void agregarInmuebleAFavoritos(Favoritos f, int idUsuario, int idInmueble) throws SystemException {

        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO favoritos(idInmueble, idUsuario, fechaCreacion, eliminado) VALUES(?,?,?,?)");
            pr = cn.prepareStatement(sb.toString(),
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            pr.setInt(1, idInmueble);
            pr.setInt(2, idUsuario);
            
            
            java.sql.Date fecha;
            Date actual = new Date();
            fecha = new java.sql.Date(actual.getTime());
            
            pr.setDate(3, fecha);
            pr.setBoolean(4, false);
            
            pr.executeUpdate();
            rs = pr.getGeneratedKeys();
            rs.next();
            f.setIdFavoritos(rs.getInt(1));
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
      
    }
    
}
