package pe.com.b2c.service.util;

import pe.com.b2c.dao.hibernate.base.EntityDao;
import pe.com.b2c.dao.hibernate.impl.FavoritosHibernateDao;
import pe.com.b2c.dao.hibernate.impl.ImagenHibernateDao;

public final class ServiceUtil {

    private static final String FAVORITOS = "Favoritos";
    private static final String IMAGEN = "Imagen";

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
        }
        return entityDao;
    }
}
