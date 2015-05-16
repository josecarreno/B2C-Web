package pe.com.b2c.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.dao.base.BaseJdbcDao;
import pe.com.b2c.dao.entity.TipoInmueble;
import pe.com.b2c.dao.entity.TipoTransaccion;
import pe.com.b2c.dao.entity.TipoUsuario;
import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.dao.InmuebleDao;
import pe.com.b2c.util.SystemException;

public class InmuebleJdbcDao extends BaseJdbcDao implements InmuebleDao {

    private static final InmuebleJdbcDao INMUEBLE_DAO_IMPL;

    static {
        INMUEBLE_DAO_IMPL = new InmuebleJdbcDao();
    }

    private InmuebleJdbcDao() {

    }

    public static InmuebleJdbcDao obtenerInstancia() {
        return INMUEBLE_DAO_IMPL;
    }

    @Override
    public void insertar(Inmueble e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO inmueble(");
            sb.append("titulo, ");
            sb.append("direccion, ");
            sb.append("distrito, ");
            sb.append("latitud, ");
            sb.append("longitud, ");
            sb.append("descripcion, ");
            sb.append("precio, ");
            sb.append("idUsuario, ");
            sb.append("idTipoTransaccion, ");
            sb.append("cantidadFavoritos, ");
            sb.append("fechaCreacion, ");
            sb.append("eliminado, ");
            sb.append("idTipoInmueble)");
            sb.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            pr = cn.prepareStatement(sb.toString(),
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setString(1, e.getTitulo());
            pr.setString(2, e.getDireccion());
            pr.setString(3, e.getDistrito());
            pr.setFloat(4, e.getLatitud().floatValue());
            pr.setFloat(5, e.getLongitud().floatValue());
            pr.setString(6, e.getDescripcion());
            pr.setFloat(7, e.getPrecio().floatValue());
            pr.setInt(8, e.getIdUsuario().getIdUsuario());
            pr.setInt(9, e.getIdTipoTransaccion().getIdtipotransaccion());
            pr.setInt(10, e.getCantidadFavoritos().intValue());
            java.sql.Date fecha;
            Date actual = new Date();
            fecha = new java.sql.Date(actual.getTime());
            pr.setDate(11, fecha);
            pr.setBoolean(12, false);
            pr.setInt(13, e.getIdTipoTransaccion().getIdtipotransaccion());
            //TODO Insertar Imagenes
            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdInmueble(rs.getInt(1));
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr);
        }
    }

    @Override
    public void actualizar(Inmueble e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE inmueble SET ");
            sb.append("titulo = ?, ");
            sb.append("direccion = ?, ");
            sb.append("distrito = ?, ");
            sb.append("latitud = ?, ");
            sb.append("longitud = ?, ");
            sb.append("descripcion = ?, ");
            sb.append("precio = ?, ");
            sb.append("idUsuario = ?, ");
            sb.append("idTipoTransaccion = ?, ");
            sb.append("cantidadFavoritos = ?, ");
            sb.append("eliminado = ?, ");
            sb.append("idTipoInmueble = ? ");
            sb.append("WHERE ");
            sb.append("idInmueble = ?");

            pr = cn.prepareStatement(sb.toString());
            pr.setString(1, e.getTitulo());
            pr.setString(2, e.getDireccion());
            pr.setString(3, e.getDistrito());
            pr.setFloat(4, e.getLatitud().floatValue());
            pr.setFloat(5, e.getLongitud().floatValue());
            pr.setString(6, e.getDescripcion());
            pr.setFloat(7, e.getPrecio().floatValue());
            pr.setInt(8, e.getIdUsuario().getIdUsuario());
            pr.setInt(9, e.getIdTipoTransaccion().getIdtipotransaccion());
            pr.setInt(10, e.getCantidadFavoritos().intValue());
            pr.setBoolean(11, false);
            pr.setInt(12, e.getIdTipoTransaccion().getIdtipotransaccion());
            pr.setInt(13, e.getIdInmueble());
            pr.executeUpdate();
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr);
        }
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE inmueble SET ");
            sb.append("eliminado = ? ");
            sb.append("WHERE ");
            sb.append("idInmueble = ?");

            pr = cn.prepareStatement(sb.toString());
            pr.setBoolean(1, Boolean.TRUE);
            pr.setInt(2, id);
            pr.executeUpdate();

        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr);
        }
    }

    @Override
    public Inmueble obtener(Integer id) throws SystemException {
        Inmueble i = null;
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT i.*, u.*, tu.*, tt.*, ti.* ");
            sb.append("FROM ");
            sb.append("inmueble i, usuario u, tipousuario tu, ");
            sb.append("tipotransaccion tt, tipoinmueble ti ");
            sb.append("WHERE ");
            sb.append("i.idInmueble = ? AND ");
            sb.append("i.idUsuario = u.idUsuario AND ");
            sb.append("u.idTipoUsuario = tu.idTipoUsuario AND ");
            sb.append("i.idTipoTransaccion = tt.idTipoTransaccion AND ");
            sb.append("i.idTipoInmueble = ti.idTipoInmueble");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();
            while (rs.next()) {
                i = new Inmueble();
                i.setIdInmueble(rs.getInt(1));
                i.setTitulo(rs.getString(2));
                i.setDireccion(rs.getString(3));
                i.setDistrito(rs.getString(4));
                i.setLatitud(rs.getBigDecimal(5));
                i.setLongitud(rs.getBigDecimal(6));
                i.setDescripcion(rs.getString(7));
                i.setPrecio(rs.getBigDecimal(8));

                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt(15));
                u.setUsuario(rs.getString(16));
                u.setPassword(rs.getString(17));
                u.setNombre(rs.getString(18));
                u.setEmail(rs.getString(19));
                u.setRuc(rs.getString(20));
                u.setDireccion(rs.getString(21));
                u.setWeb(rs.getString(22));
                u.setTelefono(rs.getString(23));

                TipoUsuario tu = new TipoUsuario();
                tu.setIdTipoUsuario(rs.getInt(26));
                tu.setDescripcion(rs.getString(27));
                tu.setEliminado(rs.getBoolean(28));

                u.setIdTipoUsuario(tu);
                u.setEliminado(rs.getBoolean(25));

                i.setIdUsuario(u);

                TipoTransaccion tt = new TipoTransaccion();
                tt.setIdtipotransaccion(rs.getInt(29));
                tt.setDescripcion(rs.getString(30));
                tt.setEliminado(rs.getBoolean(31));
                
                i.setIdTipoTransaccion(tt);
                
                TipoInmueble ti = new TipoInmueble();
                ti.setIdTipoInmueble(rs.getInt(32));
                ti.setDescripcion(rs.getString(33));
                ti.setEliminado(rs.getBoolean(34));

                i.setIdTipoInmueble(ti);
            }
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr, rs);
        }
        return i;
    }

    @Override
    public List<Inmueble> listar() throws SystemException {
        List<Inmueble> lista = new ArrayList<>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT i.*, u.*, tu.*, tt.*, ti.* ");
            sb.append("FROM ");
            sb.append("inmueble i, usuario u, tipousuario tu, ");
            sb.append("tipotransaccion tt, tipoinmueble ti ");
            sb.append("WHERE ");
            sb.append("i.idUsuario = u.idUsuario AND ");
            sb.append("u.idTipoUsuario = tu.idTipoUsuario AND ");
            sb.append("i.idTipoTransaccion = tt.idTipoTransaccion AND ");
            sb.append("i.idTipoInmueble = ti.idTipoInmueble");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while (rs.next()) {
                Inmueble i = new Inmueble();
                i.setIdInmueble(rs.getInt(1));
                i.setTitulo(rs.getString(2));
                i.setDireccion(rs.getString(3));
                i.setDistrito(rs.getString(4));
                i.setLatitud(rs.getBigDecimal(5));
                i.setLongitud(rs.getBigDecimal(6));
                i.setDescripcion(rs.getString(7));
                i.setPrecio(rs.getBigDecimal(8));

                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt(15));
                u.setUsuario(rs.getString(16));
                u.setPassword(rs.getString(17));
                u.setNombre(rs.getString(18));
                u.setEmail(rs.getString(19));
                u.setRuc(rs.getString(20));
                u.setDireccion(rs.getString(21));
                u.setWeb(rs.getString(22));
                u.setTelefono(rs.getString(23));

                TipoUsuario tu = new TipoUsuario();
                tu.setIdTipoUsuario(rs.getInt(26));
                tu.setDescripcion(rs.getString(27));
                tu.setEliminado(rs.getBoolean(28));

                u.setIdTipoUsuario(tu);
                u.setEliminado(rs.getBoolean(25));

                i.setIdUsuario(u);

                TipoTransaccion tt = new TipoTransaccion();
                tt.setIdtipotransaccion(rs.getInt(29));
                tt.setDescripcion(rs.getString(30));
                tt.setEliminado(rs.getBoolean(31));
                
                i.setIdTipoTransaccion(tt);
                
                TipoInmueble ti = new TipoInmueble();
                ti.setIdTipoInmueble(rs.getInt(32));
                ti.setDescripcion(rs.getString(33));
                ti.setEliminado(rs.getBoolean(34));

                i.setIdTipoInmueble(ti);
                
                lista.add(i);
            }
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr, rs);
        }
        return lista;
    }

}
