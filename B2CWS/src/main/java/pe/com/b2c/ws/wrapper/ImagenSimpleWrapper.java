/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.b2c.ws.wrapper;

/**
 *
 * @author jose
 */
public class ImagenSimpleWrapper {
    private byte[] imagenBlob;

    public ImagenSimpleWrapper() {
    }

    public ImagenSimpleWrapper(byte[] imagenBlob) {
        this.imagenBlob = imagenBlob;
    }

    
    public byte[] getImagenBlob() {
        return imagenBlob;
    }

    public void setImagenBlob(byte[] imagenBlob) {
        this.imagenBlob = imagenBlob;
    }
    
}
