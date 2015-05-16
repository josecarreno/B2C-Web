/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.com.b2c.dao.jdbc.base.BaseJdbcDao;
import pe.com.b2c.dao.jdbc.entity.TipoUsuario;
import pe.com.b2c.jdc.dao.TipoUsuarioDao;
import pe.com.b2c.util.SystemException;


/**
 *
 * @author Renato
 */
public class TipoUsuarioJdbcDao extends BaseJdbcDao implements TipoUsuarioDao{

    
    //Inicio Singleton
    private static final TipoUsuarioJdbcDao TIPOUSUARIO_JDBC_DAO;
    
    static {
        TIPOUSUARIO_JDBC_DAO = new TipoUsuarioJdbcDao();
    }
    
    
    private TipoUsuarioJdbcDao(){
        
    }
    
    public static TipoUsuarioJdbcDao obtenerInstancia(){
        return TIPOUSUARIO_JDBC_DAO;
    }
    //Fin Singleton
    
    @Override
    public void insertar(TipoUsuario e) throws SystemException {
        
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO tipousuario(descripcion, eliminado) VALUES(?,?)");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getDescripcion().trim().toUpperCase());
            pr.setBoolean(2, false);
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdTipoUsuario(rs.getInt(1));
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
    }

    @Override
    public void actualizar(TipoUsuario e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE tipousuario SET ");
            sb.append("descripcion = ? ");
            sb.append("WHERE ");
            sb.append("idTipoUsuario = ? ");
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getDescripcion().trim().toUpperCase());
            pr.setInt(2, e.getIdTipoUsuario());
            pr.executeUpdate(); 
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr);                                                                                                              
        }
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            
            sb.append("UPDATE tipousuario SET ");
            sb.append("eliminado = ? ");
            sb.append("WHERE ");
            sb.append("idTipoUsuario = ? ");
            pr = cn.prepareStatement(sb.toString());
            pr.setBoolean(1, true);
            pr.setInt(2, id);
            pr.executeUpdate();
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr);
        }
    }

    @Override
    public TipoUsuario obtener(Integer id) throws SystemException {
        TipoUsuario tipoUsuario = null;
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM tipousuario WHERE idTipoUsuario = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while(rs.next()){
                tipoUsuario = new TipoUsuario();
                tipoUsuario.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                tipoUsuario.setDescripcion(rs.getString("descripcion"));
            }
        }catch(Exception ex){
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
        return tipoUsuario;
    }

    @Override
    public List<TipoUsuario> listar() throws SystemException {
        
        List<TipoUsuario> listaUsuarios = new ArrayList<TipoUsuario>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM tipousuario ORDER BY descripcion");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                TipoUsuario c = new TipoUsuario();
                c.setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                c.setDescripcion(rs.getString("descripcion"));
                listaUsuarios.add(c);
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        return listaUsuarios;
    }


   
}
