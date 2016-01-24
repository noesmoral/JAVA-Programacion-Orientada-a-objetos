/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

/**
 *
 * @author pedro.barquin
 */
//clase automovil que herada de vehiculo y es padre a su vez de turismo y todoterreno
public abstract class Automovil extends Vehiculo {          //extiende de vehiculo y es abstract por que tiene un metodo abstract para sus hijos

    //atributos
    private String combustible = "";
    private String cambio = "";
    private int plazas = 0;

    //contructor con los atributos heredados y los suyos
    public Automovil(String matricula, String marca, String modelo, double potencia, String color, int anofabricacion, int kilometros, double precio, String combustible, String cambio, int plazas) {
        super(matricula, marca, modelo, potencia, color, anofabricacion, kilometros, precio);       //heredado
        this.combustible = combustible;                                                               //suyos propios
        this.cambio = cambio;
        this.plazas = plazas;
    }

    //metodo para pbtener el tipo de combustible
    public String getcombustible() {
        return combustible;                 //retorna el combustible
    }

    //metodo para obener el cambio
    public String getcambio() {
        return cambio;                      //retorna el cambio
    }

    //metodo para obtener las plazas
    public String getplazas() {
        return Integer.toString(plazas);    //pasa a string las plazas y lo retorna     
    }

    //metodo abstracto de vehiculo
    public abstract String tipoVehiculo();
}
