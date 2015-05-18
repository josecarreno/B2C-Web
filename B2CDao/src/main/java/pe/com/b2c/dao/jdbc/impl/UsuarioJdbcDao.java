package pe.com.b2c.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.com.b2c.dao.base.BaseJdbcDao;
import pe.com.b2c.dao.entity.TipoUsuario;
import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.dao.UsuarioDao;
import pe.com.b2c.util.SystemException;

public class UsuarioJdbcDao extends BaseJdbcDao implements UsuarioDao{

    
    //Inicio Singleton
    private static final UsuarioJdbcDao USUARIO_JDBC_DAO;
    
    static {
        USUARIO_JDBC_DAO = new UsuarioJdbcDao();
    }
    
    
    private UsuarioJdbcDao(){
        
    }
    
    public static UsuarioJdbcDao obtenerInstancia(){
        return USUARIO_JDBC_DAO;
    }
    //Fin Singleton
    
    
    @Override
    public void insertar(Usuario e) throws SystemException {
         try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO usuario(usuario, password, nombre, email, ruc, direccion, web, telefono, idTipoUsuario, eliminado) VALUES(?,?,?,?,?,?,?,?,?,?)");
            pr = cn.prepareStatement(sb.toString(), 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getUsuario().trim().toUpperCase());
            pr.setString(2, e.getPassword().trim().toUpperCase());
            pr.setString(3, e.getNombre().trim().toUpperCase());
            pr.setString(4, e.getEmail().trim().toUpperCase());
            pr.setString(5, e.getRuc().trim().toUpperCase());
            pr.setString(6, e.getDireccion().trim().toUpperCase());
            pr.setString(7, e.getWeb().trim().toUpperCase());
            pr.setString(8, e.getTelefono().trim().toUpperCase());
            pr.setInt(9, e.getIdTipoUsuario().getIdTipoUsuario());
            pr.setBoolean(10, false);
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdUsuario(rs.getInt(1));
            
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
    }

    @Override
    public void actualizar(Usuario e) throws SystemException {
        try{
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE usuario SET ");
            sb.append("nombre = ? , email = ? , idTipoUsuario = ? ");
            sb.append("WHERE ");
            sb.append("idUsuario = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getNombre().trim());
            pr.setString(2, e.getEmail().trim());
            pr.setInt(3, e.getIdTipoUsuario().getIdTipoUsuario());
            pr.setInt(4, e.getIdUsuario());
            
            pr.executeUpdate();
        }catch(Exception ex){
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
            
            sb.append("UPDATE usuario SET ");
            sb.append("eliminado = ? ");
            sb.append("WHERE ");
            sb.append("idUsuario = ? ");
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
    public Usuario obtener(Integer id) throws SystemException {
        Usuario usuario = null;
        try{
           cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM b2cdb.usuario u JOIN b2cdb.tipousuario tu ON u.idTipoUsuario = tu.idTipoUsuario WHERE u.idUsuario = ? AND u.eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setEliminado(rs.getBoolean("eliminado"));
                usuario.setEmail(rs.getString("email"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setRuc(rs.getString("ruc"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setWeb(rs.getString("web"));
                
                usuario.setIdTipoUsuario(new TipoUsuario());
                usuario.getIdTipoUsuario().setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                usuario.getIdTipoUsuario().setDescripcion(rs.getString("descripcion"));
                usuario.getIdTipoUsuario().setEliminado(rs.getBoolean("eliminado"));
                
                usuario.setEliminado(rs.getBoolean("eliminado"));
                
            }
        }catch(Exception ex){
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar() throws SystemException {
        
        List<Usuario> lista = new ArrayList<Usuario>();
      try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT u.*, tu.descripcion FROM usuario u JOIN tipousuario tu ON u.idTipoUsuario = tu.idTipoUsuario WHERE u.eliminado = 0"); 
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setUsuario(rs.getString("usuario"));
                u.setPassword(rs.getString("password"));
                u.setNombre(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setRuc(rs.getString("ruc"));
                u.setDireccion(rs.getString("direccion"));
                u.setWeb(rs.getString("web"));
                u.setTelefono(rs.getString("telefono"));
                
                u.setIdTipoUsuario(new TipoUsuario());
                u.getIdTipoUsuario().setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                u.getIdTipoUsuario().setDescripcion(rs.getString("descripcion"));
                u.getIdTipoUsuario().setEliminado(rs.getBoolean("eliminado"));
                
                u.setEliminado(rs.getBoolean("eliminado"));
                lista.add(u);
                
            }
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally{
            cerrar(cn, pr, rs);
        }
        return lista;
    }

    @Override
    public Usuario validarUsuario(String usuario, String password) 
            throws SystemException {
        Usuario u = null;
        try{
           cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM b2cdb.usuario u ");
            sb.append("JOIN b2cdb.tipousuario tu ");
            sb.append("ON u.idTipoUsuario = tu.idTipoUsuario ");
            sb.append("WHERE u.usuario = ? ");
            sb.append("AND u.password = ? ");
            sb.append("AND u.eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, usuario);
            pr.setString(2, password);
            rs = pr.executeQuery();
            while(rs.next()){
                u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setDireccion(rs.getString("direccion"));
                u.setEliminado(rs.getBoolean("eliminado"));
                u.setEmail(rs.getString("email"));
                u.setNombre(rs.getString("nombre"));
                u.setPassword(rs.getString("password"));
                u.setRuc(rs.getString("ruc"));
                u.setTelefono(rs.getString("telefono"));
                u.setUsuario(rs.getString("usuario"));
                u.setWeb(rs.getString("web"));
                
                u.setIdTipoUsuario(new TipoUsuario());
                u.getIdTipoUsuario().setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                u.getIdTipoUsuario().setDescripcion(rs.getString("descripcion"));
                u.getIdTipoUsuario().setEliminado(rs.getBoolean("eliminado"));
                
                u.setEliminado(rs.getBoolean("eliminado"));
                
            }
        }catch(Exception ex){
            throw new SystemException(ex);
        }finally{
            cerrar(cn, pr, rs);
        }
        return u;
    }
    
}
