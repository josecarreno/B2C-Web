/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.TipoUsuarioDao;
import pe.com.b2c.dao.hibernate.entity.TipoUsuario;
import pe.com.b2c.dao.hibernate.base.BaseHibernateDao;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */
public class TipoUsuarioHibernateDao extends BaseHibernateDao implements TipoUsuarioDao{

    //Inicio Singleton
    private static final TipoUsuarioHibernateDao TIPOUSUARIO_HIBERNATE_DAO;

    static {
        TIPOUSUARIO_HIBERNATE_DAO = new TipoUsuarioHibernateDao();
    }

    private TipoUsuarioHibernateDao() {

    }

    public static TipoUsuarioHibernateDao obtenerInstancia() {
        return TIPOUSUARIO_HIBERNATE_DAO;
    }
    //Fin Singleton
    
    @Override
    public void insertar(TipoUsuario e) throws SystemException {
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
    public void actualizar(TipoUsuario e) throws SystemException {
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
            TipoUsuario tipoUsuario = (TipoUsuario) session.get(TipoUsuario.class, id);
            tipoUsuario.setEliminado(Boolean.TRUE);
            session.update(tipoUsuario);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
    }

    @Override
    public TipoUsuario obtener(Integer id) throws SystemException {
        Session session = null;
        TipoUsuario tipoUsuario = null;
        try {
            session = obtenerSesion();
            tipoUsuario = (TipoUsuario) session.get(TipoUsuario.class, id);
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
        return tipoUsuario;
    }

    @Override
    public List<TipoUsuario> listar() throws SystemException {
         Session session = null;
        List<TipoUsuario> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT tu FROM TipoUsuario tu WHERE tu.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
    
}
