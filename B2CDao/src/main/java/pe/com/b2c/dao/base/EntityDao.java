/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.dao.base;

import java.util.List;
import pe.com.b2c.util.SystemException;

/**
 *
 * @author Renato
 */
public interface EntityDao<E,J> {
    
    void insertar(E e) throws SystemException;

    void actualizar(E e) throws SystemException;

    void eliminar(J id) throws SystemException;

    E obtener(J id) throws SystemException;

    List<E> listar() throws SystemException;
    
}
