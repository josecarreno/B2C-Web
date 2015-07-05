package pe.com.b2c.dao.hibernate.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.b2c.dao.InmuebleDao;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.dao.base.BaseHibernateDao;
import pe.com.b2c.dao.entity.Imagen;
import pe.com.b2c.util.SystemException;

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
            e.setFechaCreacion(new Date());
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
            List<Imagen> aux = new ArrayList<>();
            for(Imagen i: inmueble.getImagenList()){
                 if (!aux.contains(i))
                    aux.add(i);
            }
            inmueble.setImagenList(aux);
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
            String hql = "SELECT i FROM Inmueble i WHERE i.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }

    @Override
    public List<Inmueble> buscarInmueble(String sort, String search) {
        Session session = null;
        List<Inmueble> lista = null;
        StringBuilder sb = new StringBuilder();
        if (null == sort || ("").equals(sort)) {
            sort = "fechaCreacion";
        } else if ("departamento".equalsIgnoreCase(sort)) {
            sort = "idDepartamento.nombre";
        }
        try {
            session = obtenerSesion();
            sb.append("SELECT i FROM Inmueble i WHERE ");
            sb.append("(i.eliminado = 0)");
            sb.append(" AND (:search is null");
            sb.append(" OR ( CONCAT(titulo, ' ', direccion, ' ', distrito, ' ', descripcion )"); 
            sb.append(" LIKE '%' || :search || '%')");
            sb.append(")");
            sb.append(" ORDER BY i.");
            sb.append(sort);
            sb.append(" ");
            sb.append("DESC");
            String hql = sb.toString();
            Query query = session.createQuery(hql)
                    .setParameter("search", search);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }

    @Override
    public List<Inmueble> inmueblesPropios(Integer idUsuario) {
        Session session = null;
        List<Inmueble> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT i FROM Inmueble i WHERE i.eliminado = 0 "
                    + "AND i.idUsuario.idUsuario = :idUsuario";
            Query query = session.createQuery(hql).setInteger("idUsuario", idUsuario);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
   
}
