/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author pedro.barquin
 */
//clase venta
public class Venta implements Serializable {                    //implementa Serializable ya que sus objetos son los que se guardan en el programa

    //atributos que tiene que terner la factura
    private String nombre = "";
    private String codigonombre = "";
    private String dni = "";
    private String relacionConcesionario = "";
    private String matricula = "";
    private String marca = "";
    private String modelo = "";
    private String color = "";
    private String año = "";
    private String kilometros = "";
    private double precio = 0;
    private String tipoVehiculo = "";
    private Calendar fecha;
    private String potencia;

    //contructor para todos los atributos
    public Venta(String nombre, String codigonombre, String dni, String relacionConcesionario, String matricula, String marca, String modelo, String color, String año, String kilometros, double precio, String tipoVehiculo, String potencia) {
        this.nombre = nombre;
        this.codigonombre = codigonombre;
        this.dni = dni;
        this.relacionConcesionario = relacionConcesionario;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.año = año;
        this.kilometros = kilometros;
        this.precio = precio;
        this.tipoVehiculo = tipoVehiculo;
        this.potencia = potencia;
        this.fecha = GregorianCalendar.getInstance();             //se guarda la fecha de creacion de la venta para futuras consultas

    }

    //metodo para obtener el nombre
    public String getnombre() {
        return nombre;                          //retorna el nombre
    }

    //metodo para obtener username
    public String getcodigonombre() {
        return codigonombre;                    //retorna el username
    }

    //metodo para obtener dni
    public String getdni() {
        return dni;                             //retorna el dni
    }

    //metodo para obtener la relaccion con el concesionario
    public String getrelacionConcesionario() {
        return relacionConcesionario;           //retorna la relaccion con el concesionario
    }

    //metodo para obtener matricula
    public String getmatricula() {
        return matricula;                       //retorna la matricula
    }

    //metodo para obtener marca
    public String getmarca() {
        return marca;                           //retorna la marca
    }

    //metodo para obtener modelo
    public String getmodelo() {
        return modelo;                          //retorna el modelo
    }

    //metodo para obtener color
    public String getcolor() {
        return color;                           //retorna el color
    }

    //metodo para obtener año de fabricacion
    public String getaño() {
        return año;                             //retorna el año de fabricacion
    }

    //metodo para obtener kilometros
    public String getkilometros() {
        return kilometros;                     //retorna los kilometros 
    }

    //metodo para obtener el pricio final ya que se crea con el descuento si lo hay
    public double getprecio() {
        return precio;                          //retorna el pricio final ya que se crea con el descuento si lo hay
    }

    //metodo para obtener tipo de vehiculo que es la informacion especial de cada uno de los tipos
    public String gettipoVehiculo() {
        return tipoVehiculo;                    //retorna el tipo de vehiculo que es la informacion especial de cada uno de los tipos
    }

    //metodo para obtener fecha de la venta
    public Calendar getfecha() {
        return fecha;                           //retorna la fecha de la venta
    }

    //metodo para obtener  potencia del vehiculo
    public String getpotencia() {
        return potencia;                        //retorna la potencia del vehiculo
    }
}
