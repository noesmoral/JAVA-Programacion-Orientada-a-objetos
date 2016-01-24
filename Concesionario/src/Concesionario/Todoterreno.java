/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

/**
 *
 * @author pedro.barquin
 */
//clase todoterreno hija de automovil
public class Todoterreno extends Automovil {         //hereda de automovil

    //atributo
    private String traccion = "";

    //constructo con los atributos de los padre y el suyo
    public Todoterreno(String matricula, String marca, String modelo, double potencia, String color, int anofabricacion, int kilometros, double precio, String combustible, String cambio, int plazas, String traccion) {
        super(matricula, marca, modelo, potencia, color, anofabricacion, kilometros, precio, combustible, cambio, plazas);      //heredados
        this.traccion = traccion;                                                                                                 //suyos propios
    }

    //metodo que da el tipo de traccion
    public String gettraccion() {
        return traccion;                //retorna la traccion
    }

    //metodo abstract el cual da la informacion especial de cada una de las clases segun el que lo utilize
    public String tipoVehiculo() {
        return "todoterreno: " + " Traccion:" + gettraccion() + " Combustible:" + super.getcombustible() + " Plazas:" + super.getplazas() + " Cambio:" + super.getcambio();     //retorna la traccion el combustible las plazas y el tipo de cambio las que tiene super vienen de la clase padre
    }
}
