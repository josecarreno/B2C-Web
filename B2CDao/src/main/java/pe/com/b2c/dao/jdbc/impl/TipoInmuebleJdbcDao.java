package pe.com.b2c.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.com.b2c.dao.base.BaseJdbcDao;
import pe.com.b2c.dao.entity.TipoInmueble;
import pe.com.b2c.dao.TipoInmuebleDao;
import pe.com.b2c.util.SystemException;

public class TipoInmuebleJdbcDao extends BaseJdbcDao implements TipoInmuebleDao{

     //Inicio Singleton
    private static final TipoInmuebleJdbcDao TIPOINMUEBLE_JDBC_DAO;
    
    static {
        TIPOINMUEBLE_JDBC_DAO = new TipoInmuebleJdbcDao();
    }
    
    
    private TipoInmuebleJdbcDao(){
        
    }
    
    public static TipoInmuebleJdbcDao obtenerInstancia(){
        return TIPOINMUEBLE_JDBC_DAO;
    }
    //Fin Singleton
    
    @Override
    public void insertar(TipoInmueble e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO tipoinmueble(descripcion, eliminado) VALUES(?,?)");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getDescripcion().trim().toUpperCase());
            pr.setBoolean(2, false);
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdTipoInmueble(rs.getInt(1));
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
    }

    @Override
    public void actualizar(TipoInmueble e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE tipoinmueble SET ");
            sb.append("descripcion = ? ");
            sb.append("WHERE ");
            sb.append("idTipoInmueble = ? ");
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getDescripcion().trim().toUpperCase());
            pr.setInt(2, e.getIdTipoInmueble());
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
            
            sb.append("UPDATE tipoinmueble SET ");
            sb.append("eliminado = ? ");
            sb.append("WHERE ");
            sb.append("idTipoInmueble = ? ");
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
    public TipoInmueble obtener(Integer id) throws SystemException {
        TipoInmueble tipoInmueble = null;
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM tipoinmueble WHERE idTipoInmueble = ? AND eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while(rs.next()){
                tipoInmueble = new TipoInmueble();
                tipoInmueble.setIdTipoInmueble(rs.getInt("idTipoInmueble"));
                tipoInmueble.setDescripcion(rs.getString("descripcion"));
            }
        }catch(Exception ex){
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
        return tipoInmueble;
    }

    @Override
    public List<TipoInmueble> listar() throws SystemException {
        List<TipoInmueble> listaInmuebles = new ArrayList<TipoInmueble>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM tipoinmueble WHERE eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                TipoInmueble c = new TipoInmueble();
                c.setIdTipoInmueble(rs.getInt("idTipoInmueble"));
                c.setDescripcion(rs.getString("descripcion"));
                listaInmuebles.add(c);
            }
        } catch (Exception e) {
            throw new SystemException(e);
        }finally{
            cerrar(cn, pr, rs);
        }
        return listaInmuebles;
    }
    
}
