package pe.com.b2c.ws.wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class ValidaUsuario {
    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
