/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

/**
 *
 * @author pedro.barquin
 */
//clase motocicleta hija de vehiculo
public class Motocicleta extends Vehiculo {          //hereda de vehiculo

    //atributos
    private String tipo = "";
    private int cilindrada = 0;

    //costructor con los atributos heredados y los suyos
    public Motocicleta(String matricula, String marca, String modelo, double potencia, String color, int anofabricacion, int kilometros, double precio, String tipo, int cilindrada) {
        super(matricula, marca, modelo, potencia, color, anofabricacion, kilometros, precio);           //heredado
        this.tipo = tipo;                                                                                 //suyos propios
        this.cilindrada = cilindrada;
    }

    //metodo para obtener la cilindrada
    public int getcilindrada() {
        return cilindrada;              //retorna la cilindrada
    }

    //metodo que da el tipo de moto
    public String gettipo() {
        return tipo;                    //retorna el tipo de moto en cuestion
    }

    //metodo abstract el cual da la informacion especial de cada una de las clases segun el que lo utilize
    public String tipoVehiculo() {
        return "motocicleta: " + " Cilindrada:" + getcilindrada() + " Tipo:" + gettipo();           //retorna el tipo de moto y la cilindrada
    }
}
