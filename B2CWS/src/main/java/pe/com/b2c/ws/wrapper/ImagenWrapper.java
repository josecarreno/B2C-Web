package pe.com.b2c.ws.wrapper;

import pe.com.b2c.dao.entity.Imagen;

public class ImagenWrapper {
    private Integer idImagen;
    private byte[] imgBlob;
    private Integer idInmueble;

    public ImagenWrapper(Imagen i) {
        this.idImagen = i.getIdImagen();
        this.imgBlob = i.getImgBlob();
        this.idInmueble = i.getIdInmueble().getIdInmueble();
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public byte[] getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(byte[] imgBlob) {
        this.imgBlob = imgBlob;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }
    
}
