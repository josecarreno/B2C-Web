/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.FavoritosDao;
import pe.com.b2c.dao.entity.Favoritos;
import pe.com.b2c.dao.hibernate.base.BaseHibernateDao;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */
public class FavoritosHibernateDao extends BaseHibernateDao implements FavoritosDao{

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
            if(session!=null && session.isOpen()){
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
            Favoritos favoritos = (Favoritos) session.get(Favoritos.class, id);
            favoritos.setEliminado(Boolean.TRUE);
            session.update(favoritos);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
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
            if(session!=null && session.isOpen()){
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
            String hql = "SELECT f FROM favoritos WHERE f.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
    
}
