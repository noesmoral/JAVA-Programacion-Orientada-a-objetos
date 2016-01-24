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
public class Oficina implements Serializable{
    private String nombre;
    private long telefono;
    private Direccion direccion;

    public Oficina(String nombre, long telefono, Direccion direccion) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
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

    @Override
    public String toString() {
        return "Oficina{" + "nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion.toString() + '}';
    }
}
