/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusquedaEmpleo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jesus
 */
public class Candidato implements Serializable,Comparable<Candidato>{
    private String NIF;
    private String nombre;
    private long telefono;
    private Direccion direccion;
    private String ocupaciones;
    private String rangoSalarial;
    private String listaClave;
    private String foto;

    public Candidato(){
    }

    public Candidato(String NIF, String nombre, long telefono, Direccion direccion, String ocupaciones, String rangoSalarial, String listaClave, String foto) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ocupaciones = ocupaciones;
        this.rangoSalarial = rangoSalarial;
        this.listaClave = listaClave;
        this.foto = foto;
    }
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getNIF() {
        return NIF;
    }
    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getTelefono() {
        return telefono;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public Direccion getDireccion() {
        return direccion;
    }
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public String getOcupaciones() {
        return ocupaciones;
    }
    public void setOcupaciones(String ocupaciones) {
        this.ocupaciones = ocupaciones;
    }
    public String getRangoSalarial() {
        return rangoSalarial;
    }
    public void setRangoSalarial(String rangoSalarial) {
        this.rangoSalarial = rangoSalarial;
    }
    public String getListaClave() {
        return listaClave;
    }
    public void setListaClave(String listaClave) {
        this.listaClave = listaClave;
    }

    @Override
    public int compareTo(Candidato o) {
        return this.NIF.compareTo(o.getNIF());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candidato other = (Candidato) obj;
        if ((this.NIF == null) ? (other.NIF != null) : !this.NIF.equals(other.NIF)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.NIF);
        return hash;
    }
}
