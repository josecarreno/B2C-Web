package pe.com.b2c.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.UsuarioDao;
import pe.com.b2c.dao.entity.Usuario;
import pe.com.b2c.dao.base.BaseHibernateDao;
import pe.com.b2c.util.SystemException;

public class UsuarioHibernateDao extends BaseHibernateDao implements UsuarioDao{

    //Inicio Singleton
    private static final UsuarioHibernateDao USUARIO_HIBERNATE_DAO;

    static {
        USUARIO_HIBERNATE_DAO = new UsuarioHibernateDao();
    }

    private UsuarioHibernateDao() {

    }

    public static UsuarioHibernateDao obtenerInstancia() {
        return USUARIO_HIBERNATE_DAO;
    }
    //Fin Singleton
    
    @Override
    public void insertar(Usuario e) throws SystemException {
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
    public void actualizar(Usuario e) throws SystemException {
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
            Usuario usuario = (Usuario) session.get(Usuario.class, id);
            usuario.setEliminado(Boolean.TRUE);
            session.update(usuario);
            session.getTransaction().commit();
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
    }

    @Override
    public Usuario obtener(Integer id) throws SystemException {
        Session session = null;
        Usuario usuario = null;
        try {
            session = obtenerSesion();
            usuario = (Usuario) session.get(Usuario.class, id);
        } finally {
            if(session!=null && session.isOpen()){
                cerrar(session);
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> listar() throws SystemException {
        Session session = null;
        List<Usuario> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT u FROM Usuario u WHERE u.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }

    @Override
    public Usuario validarUsuario(String usuario, String password) throws SystemException {
        Session session = null;
        List<Usuario> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT u FROM Usuario u "
                    + "WHERE u.eliminado = 0 AND "
                    + "u.usuario = :usuario AND "
                    + "u.password = :password";
            Query query = session.createQuery(hql)
                    .setString("usuario", usuario)
                    .setString("password", password);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista.get(0);
    }
    
}
