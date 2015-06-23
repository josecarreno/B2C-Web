package pe.com.b2c.ws.wrapper;

import pe.com.b2c.dao.entity.Imagen;

public class ImagenWrapper {
    private Integer idImagen;
    private String imgBlob;
    private Integer idInmueble;
    
    public ImagenWrapper(){

    }

    public ImagenWrapper(Imagen i) {
        this.idImagen = i.getIdImagen();
        this.imgBlob = new String(i.getImgBlob());
        this.idInmueble = i.getIdInmueble().getIdInmueble();
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getImgBlob() {
        return imgBlob;
    }

    public void setImgBlob(String imgBlob) {
        this.imgBlob = imgBlob;
    }

    public Integer getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Integer idInmueble) {
        this.idInmueble = idInmueble;
    }
    
}
