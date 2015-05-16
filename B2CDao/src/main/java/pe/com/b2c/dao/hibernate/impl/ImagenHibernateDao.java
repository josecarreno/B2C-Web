/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.ImagenDao;
import pe.com.b2c.dao.hibernate.entity.Imagen;
import pe.com.b2c.dao.hibernate.base.BaseHibernateDao;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */
public class ImagenHibernateDao extends BaseHibernateDao implements ImagenDao{

    //Inicio Singleton
    private static final ImagenHibernateDao IMAGEN_HIBERNATE_DAO;

    static {
        IMAGEN_HIBERNATE_DAO = new ImagenHibernateDao();
    }

    private ImagenHibernateDao() {

    }

    public static ImagenHibernateDao obtenerInstancia() {
        return IMAGEN_HIBERNATE_DAO;
    }
    //Fin Singleton
    
    @Override
    public void insertar(Imagen e) throws SystemException {
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
    public void actualizar(Imagen e) throws SystemException {
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
            Imagen imagen = (Imagen) session.get(Imagen.class, id);
            imagen.setEliminado(Boolean.TRUE);
            session.update(imagen);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
    }

    @Override
    public Imagen obtener(Integer id) throws SystemException {
        Session session = null;
        Imagen imagen = null;
        try {
            session = obtenerSesion();
            imagen = (Imagen) session.get(Imagen.class, id);
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
        return imagen;
    }

    @Override
    public List<Imagen> listar() throws SystemException {
        Session session = null;
        List<Imagen> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT im FROM Imagen im WHERE im.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
    
}
