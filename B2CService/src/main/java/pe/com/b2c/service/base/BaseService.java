package pe.com.b2c.service.base;

import java.util.List;
import pe.com.b2c.util.SystemException;

/**
 * @param <E> clase de objeto
 * @param <J> clase de PK
 **/
public interface BaseService <E, J> {
    
    void insertar(E e) throws SystemException;

    void actualizar(E e) throws SystemException;

    void eliminar(J id) throws SystemException;

    E obtener(J id) throws SystemException;

    List<E> listar() throws SystemException;
}
