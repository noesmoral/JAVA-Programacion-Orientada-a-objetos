/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusquedaEmpleo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Jesus
 */
public class Oferta implements Serializable,Comparable<Oferta>{
    private String nombre;
    private Oficina oficina;
    private String ocupacion;
    private String listaClave;
    private Date fechaApertura;
    private Date fechaCaducidad;
    private String rangoSalarial;
    
    public Oferta(){
    }

    public Oferta(String nombre, Oficina oficina, String ocupacion, String listaClave, Date fechaApertura, Date fechaCaducidad, String rangoSalarial) {
        this.nombre = nombre;
        this.oficina = oficina;
        this.ocupacion = ocupacion;
        this.listaClave = listaClave;
        this.fechaApertura = fechaApertura;
        this.fechaCaducidad = fechaCaducidad;
        this.rangoSalarial = rangoSalarial;
    }
    public String getRangoSalarial() {
        return rangoSalarial;
    }
    public void setRangoSalarial(String rangoSalarial) {       
        this.rangoSalarial = rangoSalarial;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Oficina getOficina() {
        return oficina;
    }
    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
    public String getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getListaClave() {
        return listaClave;
    }
    public void setListaClave(String listaClave) {
        this.listaClave = listaClave;
    }
    public Date getFechaApertura() {
        return fechaApertura;
    }
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }
    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Oferta{" + "nombre=" + nombre + ", oficina=" + oficina.toString() + ", ocupacion=" + ocupacion + ", listaClave=" + listaClave + ", fechaApertura=" + fechaApertura + ", fechaCaducidad=" + fechaCaducidad + ", rangoSalarial=" + rangoSalarial + '}';
    }

    @Override
    public int compareTo(Oferta o) {
        return this.ocupacion.compareTo(o.getOcupacion());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oferta other = (Oferta) obj;
        if ((this.ocupacion == null) ? (other.ocupacion != null) : !this.ocupacion.equals(other.ocupacion)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.ocupacion);
        return hash;
    }
}
