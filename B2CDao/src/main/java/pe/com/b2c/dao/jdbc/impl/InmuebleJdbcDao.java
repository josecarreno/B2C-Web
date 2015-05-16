package pe.com.b2c.dao.jdbc.impl;

import java.util.List;
import pe.com.b2c.dao.jdbc.entity.Inmueble;
import pe.com.b2c.dao.jdbc.base.BaseJdbcDao;
import pe.com.b2c.jdc.dao.InmuebleDao;
import pe.com.b2c.util.SystemException;

public class InmuebleJdbcDao extends BaseJdbcDao implements InmuebleDao{
    
    private static final InmuebleJdbcDao INMUEBLE_DAO_IMPL;

    static {
        INMUEBLE_DAO_IMPL = new InmuebleJdbcDao();
    }

    private InmuebleJdbcDao() {

    }

    public static InmuebleJdbcDao obtenerInstancia() {
        return INMUEBLE_DAO_IMPL;
    }

    @Override
    public void insertar(Inmueble e) throws SystemException {
        try {
            cn = obtenerConexion();
            StringBuilder sb = new StringBuilder();
        } catch (Exception ex) {
            throw new SystemException(ex);
        }
    }

    @Override
    public void actualizar(Inmueble e) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inmueble obtener(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inmueble> listar() throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
