package pe.com.b2c.service.util;

import pe.com.b2c.dao.hibernate.base.EntityDao;
import pe.com.b2c.dao.hibernate.impl.FavoritosHibernateDao;
import pe.com.b2c.dao.hibernate.impl.ImagenHibernateDao;
import pe.com.b2c.dao.hibernate.impl.InmuebleHibernateDao;
import pe.com.b2c.dao.hibernate.impl.TipoInmuebleHibernateDao;
import pe.com.b2c.dao.hibernate.impl.TipoTransaccionHibernateDao;
import pe.com.b2c.dao.hibernate.impl.TipoUsuarioHibernateDao;
import pe.com.b2c.dao.hibernate.impl.UsuarioHibernateDao;

public final class ServiceUtil {

    private static final String FAVORITOS = "Favoritos";
    private static final String IMAGEN = "Imagen";
    private static final String INMUEBLE = "Inmueble";
    private static final String TIPO_INMUEBLE = "TipoInmueble";
    private static final String TIPO_TRANSACCION = "TipoTransaccion";
    private static final String TIPO_USUARIO = "TipoUsuario";
    private static final String USUARIO = "Usuario";

    private ServiceUtil() {

    }

    public static EntityDao obtenerDao(String tabla) {

        EntityDao entityDao = null;
        String tipoConexion = "HIBERNATE"; //cambiar segun sea necesario

        if (tabla.equalsIgnoreCase(FAVORITOS)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = FavoritosHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = FavoritosHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(IMAGEN)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = ImagenHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = ImagenHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(INMUEBLE)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = InmuebleHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = InmuebleHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(TIPO_INMUEBLE)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = TipoInmuebleHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = TipoInmuebleHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(TIPO_TRANSACCION)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = TipoTransaccionHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = TipoTransaccionHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(TIPO_USUARIO)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = TipoUsuarioHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = TipoUsuarioHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(USUARIO)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = UsuarioHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = UsuarioHibernateDao.obtenerInstancia();
                    break;
            }
        }
        return entityDao;
    }
}
