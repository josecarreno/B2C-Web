package pe.com.b2c.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.com.b2c.dao.base.BaseJdbcDao;
import pe.com.b2c.dao.entity.TipoTransaccion;
import pe.com.b2c.dao.TipoTransaccionDao;
import pe.com.b2c.util.SystemException;

public class TipoTransaccionJdbcDao extends BaseJdbcDao implements TipoTransaccionDao{

    
    //Inicio Singleton
    private static final TipoTransaccionJdbcDao TIPOTRANSACCION_JDBC_DAO;
    
    static {
        TIPOTRANSACCION_JDBC_DAO = new TipoTransaccionJdbcDao();
    }
    
    
    private TipoTransaccionJdbcDao(){
        
    }
    
    public static TipoTransaccionJdbcDao obtenerInstancia(){
        return TIPOTRANSACCION_JDBC_DAO;
    }
    //Fin Singleton
    
    @Override
    public void insertar(TipoTransaccion e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO tipotransaccion(descripcion, eliminado) VALUES(?,?)");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getDescripcion().trim().toUpperCase());
            pr.setBoolean(2, false);
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdtipotransaccion(rs.getInt(1));
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
    }

    @Override
    public void actualizar(TipoTransaccion e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE tipotransaccion SET ");
            sb.append("descripcion = ? ");
            sb.append("WHERE ");
            sb.append("idTipoTransaccion = ? ");
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getDescripcion().trim().toUpperCase());
            pr.setInt(2, e.getIdtipotransaccion());
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
            
            sb.append("UPDATE tipotransaccion SET ");
            sb.append("eliminado = ? ");
            sb.append("WHERE ");
            sb.append("idTipoTransaccion = ? ");
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
    public TipoTransaccion obtener(Integer id) throws SystemException {
        TipoTransaccion tipoTransaccion = null;
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM tipotransaccion WHERE idTipotransaccion = ? AND eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while(rs.next()){
                tipoTransaccion = new TipoTransaccion();
                tipoTransaccion.setIdtipotransaccion(rs.getInt("idTipoUsuario"));
                tipoTransaccion.setDescripcion(rs.getString("descripcion"));
            }
        }catch(Exception ex){
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
        return tipoTransaccion;
    }

    @Override
    public List<TipoTransaccion> listar() throws SystemException {
        List<TipoTransaccion> listaTransacciones = new ArrayList<TipoTransaccion>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM tipotransaccion WHERE eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                TipoTransaccion c = new TipoTransaccion();
                c.setIdtipotransaccion(rs.getInt("idTipoUsuario"));
                c.setDescripcion(rs.getString("descripcion"));
                listaTransacciones.add(c);
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        return listaTransacciones;
    }
    
}
