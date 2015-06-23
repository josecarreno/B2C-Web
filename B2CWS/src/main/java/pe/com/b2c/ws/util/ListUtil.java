package pe.com.b2c.ws.util;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import pe.com.b2c.dao.entity.Imagen;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.ws.wrapper.ImagenSimpleWrapper;
import pe.com.b2c.ws.wrapper.ImagenWrapper;
import pe.com.b2c.ws.wrapper.InmuebleSimpleWrapper;

public class ListUtil {

    public static List<InmuebleSimpleWrapper> getListSimpleInmueble(List<Inmueble> listInmueble) {
        List<InmuebleSimpleWrapper> lstOut
                = new ArrayList<InmuebleSimpleWrapper>();
        for (Inmueble i : listInmueble) {
            lstOut.add(new InmuebleSimpleWrapper(i));
        }
        return lstOut;
    }
    
    public static List<ImagenWrapper> getListImagenWrapper(List<Imagen> listImagen) {
        List<ImagenWrapper> lstOut
                = new ArrayList<ImagenWrapper>();
        for (Imagen i : listImagen) {
            lstOut.add(new ImagenWrapper(i));
        }
        return lstOut;
    }
    
    public static List<ImagenSimpleWrapper> getListImagenSimpleWrapper(List<Imagen> listImagen) {
        List<ImagenSimpleWrapper> lstOut
                = new ArrayList<ImagenSimpleWrapper>();
        for (Imagen i : listImagen) {
            
            lstOut.add(new ImagenSimpleWrapper(i.getImgBlob()));
        }
        return lstOut;
    }
    
    public static List<Imagen> 
        getListImagen(List<ImagenWrapper> listImagenWrapper) {
        List<Imagen> lstOut
                = new ArrayList<Imagen>();
        for (ImagenWrapper i : listImagenWrapper) {
            Imagen img = new Imagen();
            img.setEliminado(Boolean.FALSE);
            img.setImgBlob(i.getImgBlob().getBytes(Charset.forName("UTF-8")));
            lstOut.add(img);
        }
        return lstOut;
    }
}
