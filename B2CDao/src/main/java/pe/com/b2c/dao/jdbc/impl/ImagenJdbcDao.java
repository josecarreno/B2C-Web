/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.jdbc.impl;

import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import pe.com.b2c.dao.ImagenDao;
import pe.com.b2c.dao.base.BaseJdbcDao;
import pe.com.b2c.dao.entity.Imagen;
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
public class ImagenJdbcDao extends BaseJdbcDao implements ImagenDao {

    private static final ImagenJdbcDao IMAGEN_DAO_IMPL;

    static {
        IMAGEN_DAO_IMPL = new ImagenJdbcDao();
    }

    private ImagenJdbcDao() {

    }

    public static ImagenJdbcDao obtenerInstancia() {
        return IMAGEN_DAO_IMPL;
    }

    @Override
    public void insertar(Imagen e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO imagen(imgBlob, idInmueble, eliminado) VALUES(?,?,?)");
            pr = cn.prepareStatement(sb.toString(),
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pr.setBytes(1, e.getImgBlob());
            pr.setInt(2, e.getIdInmueble().getIdInmueble());
            pr.setBoolean(3, false);

            pr.executeUpdate();
            //Obtener las claves autogeneradas
            rs = pr.getGeneratedKeys();
            rs.next();
            e.setIdImagen(rs.getInt(1));

        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr, rs);
        }
    }

    @Override
    public void actualizar(Imagen e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE imagen SET ");
            sb.append("imgBlob = ? ");
            sb.append("WHERE ");
            sb.append("idImagen = ?");
            pr = cn.prepareStatement(sb.toString());
            pr.setBytes(1, e.getImgBlob());
            pr.setInt(2, e.getIdImagen());

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

            sb.append("UPDATE imagen SET ");
            sb.append("eliminado = ? ");
            sb.append("WHERE ");
            sb.append("idImagen = ? ");
            pr = cn.prepareStatement(sb.toString());
            pr.setBoolean(1, true);
            pr.setInt(2, id);
            pr.executeUpdate();
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            cerrar(cn, pr);
        }
    }

    @Override
    public Imagen obtener(Integer id) throws SystemException {
        Imagen imagen = null;

        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM imagen i JOIN inmueble inm ON i.idInmueble = inm.idInmueble WHERE i.idImagen = ? AND i.eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            pr.setInt(1, id);
            rs = pr.executeQuery();

            while (rs.next()) {
                Imagen u = new Imagen();
                u.setIdImagen(rs.getInt("idImagen"));
                u.setImgBlob(rs.getBytes("imgBlob"));

                u.setIdInmueble(new Inmueble());
                u.getIdInmueble().setIdInmueble(rs.getInt("idInmueble"));

                u.setIdInmueble(new Inmueble());
                u.getIdInmueble().setIdInmueble(rs.getInt("idInmueble"));
                u.getIdInmueble().setTitulo(rs.getString("titulo"));
                u.getIdInmueble().setDireccion(rs.getString("direccion"));
                u.getIdInmueble().setDistrito(rs.getString("distrito"));
                u.getIdInmueble().setLatitud(rs.getBigDecimal("latitud"));
                u.getIdInmueble().setLongitud(rs.getBigDecimal("longitud"));
                u.getIdInmueble().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().setPrecio(rs.getBigDecimal("precio"));

                //Parametros del usuario
                u.getIdInmueble().setIdUsuario(new Usuario());
                u.getIdInmueble().getIdUsuario().setIdUsuario(rs.getInt("idUsuario"));
                u.getIdInmueble().getIdUsuario().setUsuario(rs.getString("usuario"));
                u.getIdInmueble().getIdUsuario().setPassword(rs.getString("password"));
                u.getIdInmueble().getIdUsuario().setNombre(rs.getString("nombre"));
                u.getIdInmueble().getIdUsuario().setEmail(rs.getString("email"));
                u.getIdInmueble().getIdUsuario().setRuc(rs.getString("ruc"));
                u.getIdInmueble().getIdUsuario().setDireccion(rs.getString("direccion"));
                u.getIdInmueble().getIdUsuario().setWeb(rs.getString("web"));
                u.getIdInmueble().getIdUsuario().setTelefono(rs.getString("telefono"));

                //Parametros tipo usuario para el usuario
                u.getIdInmueble().getIdUsuario().setIdTipoUsuario(new TipoUsuario());;
                u.getIdInmueble().getIdUsuario().getIdTipoUsuario().setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                u.getIdInmueble().getIdUsuario().getIdTipoUsuario().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().getIdUsuario().getIdTipoUsuario().setEliminado(rs.getBoolean("eliminado"));

                //Sigue Parametros Inmueble
                u.getIdInmueble().setIdTipoTransaccion(new TipoTransaccion());
                u.getIdInmueble().getIdTipoTransaccion().setIdtipotransaccion(rs.getInt("idTipoTransaccion"));
                u.getIdInmueble().getIdTipoTransaccion().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().getIdTipoTransaccion().setEliminado(rs.getBoolean("eliminado"));

                BigInteger bi = BigInteger.valueOf(rs.getLong("cantidadFavoritos"));

                u.getIdInmueble().setCantidadFavoritos(bi);
                u.getIdInmueble().setFechaCreacion(rs.getDate("fechaCreacion"));
                u.getIdInmueble().setEliminado(rs.getBoolean("eliminado"));

                //Tipo Inmueble
                u.getIdInmueble().setIdTipoInmueble(new TipoInmueble());
                u.getIdInmueble().getIdTipoInmueble().setIdTipoInmueble(rs.getInt("idTipoInmueble"));
                u.getIdInmueble().getIdTipoInmueble().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().getIdTipoInmueble().setEliminado(rs.getBoolean("eliminado"));

                u.setEliminado(rs.getBoolean("eliminado"));

            }

        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            cerrar(cn, pr, rs);
        }

        return imagen;
    }

    @Override
    public List<Imagen> listar() throws SystemException {
        List<Imagen> lista = new ArrayList<Imagen>();
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM imagen i JOIN inmueble inm ON i.idInmueble = inm.idInmueble WHERE i.eliminado = 0");
            pr = cn.prepareStatement(sb.toString());
            rs = pr.executeQuery();
            while (rs.next()) {
                Imagen u = new Imagen();
                u.setIdImagen(rs.getInt("idImagen"));
                u.setImgBlob(rs.getBytes("imgBlob"));

                u.setIdInmueble(new Inmueble());
                u.getIdInmueble().setIdInmueble(rs.getInt("idInmueble"));

                u.setIdInmueble(new Inmueble());
                u.getIdInmueble().setIdInmueble(rs.getInt("idInmueble"));
                u.getIdInmueble().setTitulo(rs.getString("titulo"));
                u.getIdInmueble().setDireccion(rs.getString("direccion"));
                u.getIdInmueble().setDistrito(rs.getString("distrito"));
                u.getIdInmueble().setLatitud(rs.getBigDecimal("latitud"));
                u.getIdInmueble().setLongitud(rs.getBigDecimal("longitud"));
                u.getIdInmueble().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().setPrecio(rs.getBigDecimal("precio"));

                //Parametros del usuario
                u.getIdInmueble().setIdUsuario(new Usuario());
                u.getIdInmueble().getIdUsuario().setIdUsuario(rs.getInt("idUsuario"));
                u.getIdInmueble().getIdUsuario().setUsuario(rs.getString("usuario"));
                u.getIdInmueble().getIdUsuario().setPassword(rs.getString("password"));
                u.getIdInmueble().getIdUsuario().setNombre(rs.getString("nombre"));
                u.getIdInmueble().getIdUsuario().setEmail(rs.getString("email"));
                u.getIdInmueble().getIdUsuario().setRuc(rs.getString("ruc"));
                u.getIdInmueble().getIdUsuario().setDireccion(rs.getString("direccion"));
                u.getIdInmueble().getIdUsuario().setWeb(rs.getString("web"));
                u.getIdInmueble().getIdUsuario().setTelefono(rs.getString("telefono"));

                //Parametros tipo usuario para el usuario
                u.getIdInmueble().getIdUsuario().setIdTipoUsuario(new TipoUsuario());;
                u.getIdInmueble().getIdUsuario().getIdTipoUsuario().setIdTipoUsuario(rs.getInt("idTipoUsuario"));
                u.getIdInmueble().getIdUsuario().getIdTipoUsuario().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().getIdUsuario().getIdTipoUsuario().setEliminado(rs.getBoolean("eliminado"));

                //Sigue Parametros Inmueble
                u.getIdInmueble().setIdTipoTransaccion(new TipoTransaccion());
                u.getIdInmueble().getIdTipoTransaccion().setIdtipotransaccion(rs.getInt("idTipoTransaccion"));
                u.getIdInmueble().getIdTipoTransaccion().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().getIdTipoTransaccion().setEliminado(rs.getBoolean("eliminado"));

                BigInteger bi = BigInteger.valueOf(rs.getLong("cantidadFavoritos"));
                u.getIdInmueble().setCantidadFavoritos(bi);

                u.getIdInmueble().setFechaCreacion(rs.getDate("fechaCreacion"));
                u.getIdInmueble().setEliminado(rs.getBoolean("eliminado"));

                //Tipo Inmueble
                u.getIdInmueble().setIdTipoInmueble(new TipoInmueble());
                u.getIdInmueble().getIdTipoInmueble().setIdTipoInmueble(rs.getInt("idTipoInmueble"));
                u.getIdInmueble().getIdTipoInmueble().setDescripcion(rs.getString("descripcion"));
                u.getIdInmueble().getIdTipoInmueble().setEliminado(rs.getBoolean("eliminado"));

                u.setEliminado(rs.getBoolean("eliminado"));
                lista.add(u);

            }
        } catch (Exception ex) {
            throw new SystemException(ex);
        } finally {
            cerrar(cn, pr, rs);
        }
        return lista;
    }

}
