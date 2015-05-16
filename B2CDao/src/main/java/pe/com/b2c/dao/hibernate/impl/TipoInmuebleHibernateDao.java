package pe.com.b2c.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.TipoInmuebleDao;
import pe.com.b2c.dao.entity.TipoInmueble;
import pe.com.b2c.dao.base.BaseHibernateDao;
import pe.com.b2c.util.SystemException;

public class TipoInmuebleHibernateDao extends BaseHibernateDao implements TipoInmuebleDao{

    //Inicio Singleton
    private static final TipoInmuebleHibernateDao TIPOINMUEBLE_HIBERNATE_DAO;

    static {
        TIPOINMUEBLE_HIBERNATE_DAO = new TipoInmuebleHibernateDao();
    }

    private TipoInmuebleHibernateDao() {

    }

    public static TipoInmuebleHibernateDao obtenerInstancia() {
        return TIPOINMUEBLE_HIBERNATE_DAO;
    }
    //Fin Singleton

    @Override
    public void insertar(TipoInmueble e) throws SystemException {
        Session session = null;
        try {
            e.setEliminado(Boolean.FALSE);
            session = obtenerSesion();
            session.save(e);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }

        }
    }

    @Override
    public void actualizar(TipoInmueble e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            session.update(e);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            TipoInmueble tipoInmueble = (TipoInmueble) session.get(TipoInmueble.class, id);
            tipoInmueble.setEliminado(Boolean.TRUE);
            session.update(tipoInmueble);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
    }

    @Override
    public TipoInmueble obtener(Integer id) throws SystemException {
        Session session = null;
        TipoInmueble tipoInmueble = null;
        try {
            session = obtenerSesion();
            tipoInmueble = (TipoInmueble) session.get(TipoInmueble.class, id);
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
        return tipoInmueble;
    }

    @Override
    public List<TipoInmueble> listar() throws SystemException {
        Session session = null;
        List<TipoInmueble> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT ti FROM TipoInmueble ti WHERE ti.eliminado=0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
    
    
    
}
