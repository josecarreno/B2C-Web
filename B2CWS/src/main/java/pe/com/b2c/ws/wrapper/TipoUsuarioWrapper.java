/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.ws.wrapper;

import pe.com.b2c.dao.entity.TipoUsuario;

/**
 *
 * @author Jose
 */
public class TipoUsuarioWrapper {
    Integer idTipoUsuario;
    String descripcion;

    public TipoUsuarioWrapper(TipoUsuario tu) {
        this.idTipoUsuario = tu.getIdTipoUsuario();
        this.descripcion = tu.getDescripcion();
    }
    
}
