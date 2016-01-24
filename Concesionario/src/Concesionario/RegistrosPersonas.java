/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author pedro.barquin
 */
//clase que registra y almacena los usuarios
public class RegistrosPersonas {

    //atributos
    private HashMap<String, Cliente> personas = new HashMap<String, Cliente>();             //hashmap deonde se almacenan los clientes con el key username
    private String nombre = "";

    //constructor
    public RegistrosPersonas(String nombre) {
        this.nombre = nombre;
        try {
            //Lectura de los objetos de cliente
            FileInputStream istreamcli = new FileInputStream("Registroclientes.dat");       //se garga el archivo a leer con el nombre dado    
            ObjectInputStream oisOft = new ObjectInputStream(istreamcli);                   //con el fileInputestream anterior se crea el objeto para la lectura de los datos referenciando el creado antes que es donde esta la informacion
            personas = (HashMap) oisOft.readObject();                                       //se vuelca la informacion pasandola al tipo de dato del destino
            istreamcli.close();                                                             //se cierra el fujo
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());                         //mensajes de error varios
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error cliente no encontrado: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //metodo para dar de alta usuarios
    public boolean altausuario(Cliente cliente) {                           //se recibe un objeto del tipo cliente que es el que vamos a guardar
        if (!personas.containsKey(cliente.getcodigoUsuario())) {            //se verifica que no esta en la lista con su username
            personas.put(cliente.getcodigoUsuario(), cliente);              //en caso de que no este se almacena
            guardar();                                                      //se llama a guardar la informacion
            return true;                                                    //si a funcionado el gardar el vehiculo se retorna true
        } else {
            return false;                                                   //si falla se retorna false
        }
    }

    //metodo comprueba que esta el cliente
    public boolean contiene(String codename) {                               //se pasa el username
        if (personas.containsKey(codename)) {                                 //se verifica que esta
            return true;                                                    //se manda un true
        } else {
            return false;                                                 //se retorna false
        }
    }

    //metodo para obetener un cliente concreto
    public Cliente obtenerpersona(String person) {                          //se envia el username
        return personas.get(person);                                       //se retorna el cliente en cuestion
    }

    //metoso para obeter la contraseña
    public int pw(String code) {                                             //se pasa el username
        Cliente a = personas.get(code);                                       //se obtiene el pcliente en cuestion del que necesitamos el pw
        int b = a.getcodigo();                                                //se ontiene el pw
        return b;                                                           //se retorna el pw
    }

    //metodo que guarda la informacion de los clientes registrados
    public void guardar() {
        try {
            if (!personas.isEmpty()) {                                     //si el hashmap no esta vacia continua   
                /**
                 * **** Serialización de los objetos *****
                 */
                //Serialización de los clientes
                FileOutputStream ostreamcli = new FileOutputStream("Registroclientes.dat");     //asigna el archivo a guardar y donde
                ObjectOutputStream oosCand = new ObjectOutputStream(ostreamcli);                //crea un objeto con el  
                oosCand.writeObject(personas);                                                  //guardamos el hashmap de clientes
                ostreamcli.close();                                                             //se cierra el fujo
            } else {
                System.out.println("Error: No hay clientes...");                                //mesnaje si no hay nada que guadar
            }
        } catch (Exception e) {
        }
    }
}
