package pe.com.b2c.dao.hibernate.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import pe.com.b2c.dao.FavoritosDao;
import pe.com.b2c.dao.entity.Favoritos;
import pe.com.b2c.dao.base.BaseHibernateDao;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.util.SystemException;

public class FavoritosHibernateDao extends BaseHibernateDao implements FavoritosDao {

    //Inicio Singleton
    private static final FavoritosHibernateDao FAVORITOS_HIBERNATE_DAO;

    static {
        FAVORITOS_HIBERNATE_DAO = new FavoritosHibernateDao();
    }

    private FavoritosHibernateDao() {

    }

    public static FavoritosHibernateDao obtenerInstancia() {
        return FAVORITOS_HIBERNATE_DAO;
    }
    //Fin Singleton

    @Override
    public void insertar(Favoritos e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            e.setEliminado(Boolean.FALSE);
            session.save(e);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
    }

    @Override
    public void actualizar(Favoritos e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            session.update(e);
            e.setEliminado(Boolean.FALSE);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            Favoritos favoritos = (Favoritos) session.get(Favoritos.class, id);
            favoritos.setEliminado(Boolean.TRUE);
            session.update(favoritos);
            session.getTransaction().commit();
        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
    }

    @Override
    public Favoritos obtener(Integer id) throws SystemException {
        Session session = null;
        Favoritos favoritos = null;
        try {
            session = obtenerSesion();
            favoritos = (Favoritos) session.get(Favoritos.class, id);
        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
        return favoritos;
    }

    @Override
    public List<Favoritos> listar() throws SystemException {
        Session session = null;
        List<Favoritos> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT f FROM Favoritos f WHERE f.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }

    @Override
    public void agregarInmuebleAFavoritos(Integer idUsuario, Integer idInmueble) throws SystemException {
        Session session = null;
        List<Favoritos> listaFavoritos = null;
        List<Inmueble> listaInmuebles = null;
        try {
            session = obtenerSesion();
            String hqlFavoritos = "SELECT f FROM Favoritos f "
                    + "WHERE f.idUsuario.idUsuario = :idUsuario "
                    + "AND f.idInmueble.idInmueble = :idInmueble";
            Query queryFavoritos = session.createQuery(hqlFavoritos)
                    .setInteger("idUsuario", idUsuario)
                    .setInteger("idInmueble", idInmueble);
            listaFavoritos = queryFavoritos.list();
            if (listaFavoritos.size() > 0) {
                Favoritos f = listaFavoritos.get(0);
                f.setEliminado(Boolean.FALSE);
                f.setFechaCreacion(new Date());
                session.update(f);
            } else {
                Favoritos f = new Favoritos();
                f.setEliminado(Boolean.FALSE);

                Usuario u = new Usuario();
                u.setIdUsuario(idUsuario);

                Inmueble i = new Inmueble();
                i.setIdInmueble(idInmueble);

                f.setIdUsuario(u);
                f.setIdInmueble(i);
                f.setFechaCreacion(new Date());

                session.save(f);
            }

            String hqlInmuebles = "SELECT i FROM Inmueble i "
                    + "WHERE i.idInmueble = :idInmueble";
            Query queryInmuebles = session.createQuery(hqlInmuebles)
                    .setInteger("idInmueble", idInmueble);
            listaInmuebles = queryInmuebles.list();
            Inmueble i = listaInmuebles.get(0);
            i.setCantidadFavoritos(i.getCantidadFavoritos()
                    .add(BigInteger.ONE));
            session.update(i);
            session.save(i);
            
            session.getTransaction().commit();

            /*
             session = obtenerSesion();
             Favoritos f = new Favoritos();
             f.setEliminado(Boolean.FALSE);

             Usuario u = new Usuario();
             u.setIdUsuario(idUsuario);

             Inmueble i = new Inmueble();
             i.setIdInmueble(idInmueble);

             f.setIdUsuario(u);
             f.setIdInmueble(i);
             f.setFechaCreacion(new Date());

             session.save(f);

             Inmueble inmuebleAActualizar
             = (Inmueble) session.get(Inmueble.class, idInmueble);
             inmuebleAActualizar.setCantidadFavoritos(
             inmuebleAActualizar
             .getCantidadFavoritos()
             .add(BigInteger.ONE));
             session.update(inmuebleAActualizar);

             session.getTransaction().commit();
             */
        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
    }

    @Override
    public List<Inmueble> listarFavoritosUsuario(Integer idUsuario) throws SystemException {
        Session session = null;
        List<Inmueble> lista = null;
        Usuario usuario = null;
        try {
            session = obtenerSesion();
            usuario = (Usuario) session.get(Usuario.class, idUsuario);
            lista = new ArrayList<>();
            for (Favoritos f : usuario.getFavoritosList()) {
                if (!lista.contains(f.getIdInmueble()) && !f.getEliminado()) {
                    lista.add(f.getIdInmueble());
                }
            }

        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
        return lista;
    }

    @Override
    public void eliminarFavorito(Integer idUsuario, Integer idInmueble) throws SystemException {
        Session session = null;
        List<Favoritos> listaFavoritos = null;
        List<Inmueble> listaInmuebles = null;
        try {
            session = obtenerSesion();
            String hqlFavoritos = "SELECT f FROM Favoritos f "
                    + "WHERE f.idUsuario.idUsuario = :idUsuario "
                    + "AND f.idInmueble.idInmueble = :idInmueble";
            Query queryFavoritos = session.createQuery(hqlFavoritos)
                    .setInteger("idUsuario", idUsuario)
                    .setInteger("idInmueble", idInmueble);
            listaFavoritos = queryFavoritos.list();
            Favoritos f = listaFavoritos.get(0);
            f.setEliminado(Boolean.TRUE);
            session.save(f);

            String hqlInmuebles = "SELECT i FROM Inmueble i "
                    + "WHERE i.idInmueble = :idInmueble";
            Query queryInmuebles = session.createQuery(hqlInmuebles)
                    .setInteger("idInmueble", idInmueble);
            listaInmuebles = queryInmuebles.list();
            Inmueble i = listaInmuebles.get(0);
            i.setCantidadFavoritos(i.getCantidadFavoritos()
                    .subtract(BigInteger.ONE));
            session.update(i);
            session.save(i);
            session.getTransaction().commit();

        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
    }

    @Override
    public Boolean estaEnFavoritos(Integer idUsuario, Integer idInmueble) throws SystemException {
        Session session = null;
        List<Favoritos> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT f FROM Favoritos f WHERE f.eliminado = 0 "
                    + "AND f.idUsuario = :idUsuario "
                    + "AND f.idInmueble = :idInmueble";
            Query query = session.createQuery(hql)
                    .setInteger("idUsuario", idUsuario)
                    .setInteger("idInmueble", idInmueble);
            lista = query.list();
            if (!lista.isEmpty()) {
                return true;
            }
        } finally {
            if (session != null && session.isOpen()) {
                cerrar(session);
            }
        }
        return false;
    }

}
