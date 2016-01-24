/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

/**
 *
 * @author pedro.barquin
 */
//clase hija de automovil
public class Turismo extends Automovil {     //hereda de automovil

    //atributos
    private int puertas = 0;

    //constructo con toda la informacion heredada y la suya
    public Turismo(String matricula, String marca, String modelo, double potencia, String color, int anofabricacion, int kilometros, double precio, String combustible, String cambio, int plazas, int puertas) {
        super(matricula, marca, modelo, potencia, color, anofabricacion, kilometros, precio, combustible, cambio, plazas);     //hereado
        this.puertas = puertas;                                                                                                  // su informacion especial
    }

    //metodo que da el umero de puestas
    public int getpuertas() {
        return puertas;             //retorna el numero de puertas
    }

    //metodo abstract el cual da la informacion especial de cada una de las clases segun el que lo utilize
    public String tipoVehiculo() {
        return "turismo:" + " Puertas:" + getpuertas() + " Combustible:" + super.getcombustible() + " Plazas:" + super.getplazas() + " Cambio:" + super.getcambio();        //retorna el numero de  puertas el combustuble las plazas y el tipo de cambio las que tienen super vienen de la clase padre
    }
}
