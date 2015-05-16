/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.TipoTransaccionDao;
import pe.com.b2c.dao.hibernate.entity.TipoTransaccion;
import pe.com.b2c.dao.hibernate.base.BaseHibernateDao;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */
public class TipoTransaccionHibernateDao extends BaseHibernateDao implements TipoTransaccionDao{

    //Inicio Singleton
    private static final TipoTransaccionHibernateDao TIPOTRANSACCION_HIBERNATE_DAO;

    static {
        TIPOTRANSACCION_HIBERNATE_DAO = new TipoTransaccionHibernateDao();
    }

    private TipoTransaccionHibernateDao() {

    }

    public static TipoTransaccionHibernateDao obtenerInstancia() {
        return TIPOTRANSACCION_HIBERNATE_DAO;
    }
    //Fin Singleton

    @Override
    public void insertar(TipoTransaccion e) throws SystemException {
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
    public void actualizar(TipoTransaccion e) throws SystemException {
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
            TipoTransaccion tipoTransaccion = (TipoTransaccion) session.get(TipoTransaccion.class, id);
            tipoTransaccion.setEliminado(Boolean.TRUE);
            session.update(tipoTransaccion);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
    }

    @Override
    public TipoTransaccion obtener(Integer id) throws SystemException {
        Session session = null;
        TipoTransaccion tipoTransaccion = null;
        try {
            session = obtenerSesion();
            tipoTransaccion = (TipoTransaccion) session.get(TipoTransaccion.class, id);
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
        return tipoTransaccion;
    }

    @Override
    public List<TipoTransaccion> listar() throws SystemException {
        Session session = null;
        List<TipoTransaccion> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT tt FROM TipoTransaccion tt WHERE tt.eliminado=0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
    
   
    
}
