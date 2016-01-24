/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusquedaEmpleo;

import java.io.Serializable;

/**
 *
 * @author Jesus
 */
public class Direccion implements Serializable{
    private String nombreVia;
    private int numero;
    private String pisoLetra;
    private String localidad;
    private String codigoPostal;

    public Direccion(String nombreVia, int numero, String pisoLetra, String localidad, String codigoPostal) {
        this.nombreVia = nombreVia;
        this.numero = numero;
        this.pisoLetra = pisoLetra;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }
    public String getNombreVia() {
        return nombreVia;
    }
    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getPisoLetra() {
        return pisoLetra;
    }
    public void setPisoLetra(String pisoLetra) {
        this.pisoLetra = pisoLetra;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Direccion{" + "nombreVia=" + nombreVia + ", numero=" + numero + ", pisoLetra=" + pisoLetra + ", localidad=" + localidad + ", codigoPostal=" + codigoPostal + '}';
    }
}
