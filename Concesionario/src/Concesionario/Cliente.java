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
//clase cliente
public class Cliente implements Serializable {                   //implementa Serializable ya que sus objetos son los que se guardan en el programa

    //atributos
    private String nombreApellido = "";
    private String dni = "";
    private String relacionConcesionario = "";
    private String codigoUsuario = "";
    private int codigo = 0000;

    //constructor
    public Cliente(String nombreApellido, String dni, String relacionConcesionario, String codigoUsuario, int codigo) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.relacionConcesionario = relacionConcesionario;
        this.codigoUsuario = codigoUsuario;
        this.codigo = codigo;
    }

    //metodo para obtener el nombre y apellido del cliente
    public String getnombreApellido() {
        return nombreApellido;              //retorna el nombre y apellido
    }

    //metodo para obtener el dni
    public String getdni() {
        return dni;                         //retorna el dni
    }

    //metodo para obtener la relaccion del cliente
    public String getrelacionConcesionario() {
        return relacionConcesionario;       //retorna la relacicon
    }

    //metodo para obtener el nombre de usuario
    public String getcodigoUsuario() {
        return codigoUsuario;               //retorna el username
    }

    //metodo para obtener para obtener la contraseña
    public int getcodigo() {
        return codigo;                      //retorna el password
    }
}
