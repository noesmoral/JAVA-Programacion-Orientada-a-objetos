/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

import java.io.Serializable;

/**
 *
 * @author pedro.barquin
 */
//clase vehiculo la cual es la padre de motocicleta y automovil y es abstract ya que contiene un metodo absatract
public abstract class Vehiculo implements Serializable {                 //implementa Serializable ya que sus objetos son los que se guardan en el programa

    //atributos
    private String matricula = "";
    private String marca = "";
    private String modelo = "";
    private String color = "";
    private double potencia = 0.0;
    private int anofabricacion = 0;
    private int kilometros = 0;
    private double precio = 0;

    //constructo de dicha clase
    public Vehiculo(String matricula, String marca, String modelo, double potencia, String color, int anofabricacion, int kilometros, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.color = color;
        this.anofabricacion = anofabricacion;
        this.kilometros = kilometros;
        this.precio = precio;
    }

    //metodo para obtener la matricula
    public String getmatricula() {
        return matricula;               //retorna la matricula
    }

    //metodo para obtener marca
    public String getmarca() {
        return marca;                   //retorna la marca
    }

    //metodo para obtener modelo
    public String getmodelo() {
        return modelo;                  //retorna el modelo
    }

    //metodo para obtener potencia
    public double getpotencia() {
        return potencia;                //retorna la potencia
    }

    //metodo para obtener color
    public String getcolor() {
        return color;                   //retorna el color del vehiculo
    }

    //metodo para obtener año de fabricacion
    public int getanofabricacion() {
        return anofabricacion;          //retorna el año
    }

    //metodo para obtener los kilometros
    public int getkilometros() {
        return kilometros;              //retorna los kilometros
    }

    //metodo para obtener el precio inicial
    public double getprecio() {
        return precio;                  //retorna el precio del anuncio o inicial
    }

    //metodo abstract 
    public abstract String tipoVehiculo();
}
