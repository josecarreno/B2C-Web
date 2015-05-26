package pe.com.b2c.ws.util;

import java.util.ArrayList;
import java.util.List;
import pe.com.b2c.dao.entity.Inmueble;
import pe.com.b2c.ws.wrapper.InmuebleSimpleWrapper;

public class ListUtil {

    public static List<InmuebleSimpleWrapper> getSimpleInmueble(List<Inmueble> listInmueble) {
        List<InmuebleSimpleWrapper> lstOut
                = new ArrayList<InmuebleSimpleWrapper>();
        for (Inmueble i : listInmueble) {
            lstOut.add(new InmuebleSimpleWrapper(i));
        }
        return lstOut;
    }
}
