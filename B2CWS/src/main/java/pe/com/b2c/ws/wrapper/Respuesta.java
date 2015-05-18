
package pe.com.b2c.ws.wrapper;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Respuesta {
    private String mensaje;

    public Respuesta(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
