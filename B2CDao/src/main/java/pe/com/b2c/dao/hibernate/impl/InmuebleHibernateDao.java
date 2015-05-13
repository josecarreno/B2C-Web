/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.InmuebleDao;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.dao.hibernate.base.BaseHibernateDao;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */
public class InmuebleHibernateDao extends BaseHibernateDao implements InmuebleDao{

    //Inicio Singleton
    private static final InmuebleHibernateDao INMUEBLE_HIBERNATE_DAO;

    static {
        INMUEBLE_HIBERNATE_DAO = new InmuebleHibernateDao();
    }

    private InmuebleHibernateDao() {

    }

    public static InmuebleHibernateDao obtenerInstancia() {
        return INMUEBLE_HIBERNATE_DAO;
    }
    //Fin Singleton
    
    @Override
    public void insertar(pe.com.b2c.dao.entity.Inmueble e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            e.setEliminado(Boolean.FALSE);
            session.save(e);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }

        }
    }

    @Override
    public void actualizar(pe.com.b2c.dao.entity.Inmueble e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            session.update(e);
            e.setEliminado(Boolean.FALSE);
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
            Inmueble inmueble = (Inmueble) session.get(Inmueble.class, id);
            inmueble.setEliminado(Boolean.TRUE);
            session.update(inmueble);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
    }

    @Override
    public Inmueble obtener(Integer id) throws SystemException {
        Session session = null;
        Inmueble inmueble = null;
        try {
            session = obtenerSesion();
            inmueble = (Inmueble) session.get(Inmueble.class, id);
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
        return inmueble;
    }

    @Override
    public List<Inmueble> listar() throws SystemException {
        Session session = null;
        List<Inmueble> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT i FROM inmueble WHERE i.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
    
}
