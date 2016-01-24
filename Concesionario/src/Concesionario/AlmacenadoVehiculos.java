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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author pedro.barquin
 */
public class AlmacenadoVehiculos {

    //atributos
    private HashMap<String, Vehiculo> vehiculo = new HashMap<String, Vehiculo>();       //hashmap deonde se almacenan los vehiculos con el key matricula
    private String nombre = "";

    //constructor del alamcen de vehiculos registrados
    public AlmacenadoVehiculos(String nombre) {
        this.nombre = nombre;
        try {
            //Lectura de los objetos de vehiculos se realiza al crear el objeo al iniciar
            FileInputStream istreamveh = new FileInputStream("Registrovehiculos.dat");  //se garga el archivo a leer con el nombre dado
            ObjectInputStream oisOft = new ObjectInputStream(istreamveh);               //con el fileInputestream anterior se crea el objeto para la lectura de los datos referenciando el creado antes que es donde esta la informacion
            vehiculo = (HashMap) oisOft.readObject();                                   //se vuelca la informacion pasandola al tipo de dato del destino
            istreamveh.close();                                                         //se cierra el flujo
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());                     //mensajes de errores varios
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error vehiculo no encontrado: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //llamada a insertar un vehiculo
    public boolean insertarVehiculo(Vehiculo v) {           //se recibe un objeto del tipo vehiculo que es el que vamos a guardar
        if (!vehiculo.containsKey(v.getmatricula())) {      //se verifica que no esta en la lista con su matricula 
            vehiculo.put(v.getmatricula(), v);              //en caso de que no este se almacena
            guardar();                                      //se llama a guardar la informacion
            return true;                                    //si a funcionado el gardar el vehiculo se retorna true
        } else {
            return false;                                   //si falla se retorna false
        }
    }

    //llamada a borrar el vehiculo
    public boolean bajaVehiculo(String matri) {             //se envia la matricula del coche a eliminar
        if (vehiculo.containsKey(matri)) {                  //si la lista contiene la matricula=a esta el vehiculo
            vehiculo.remove(matri);                         //se elimina el vehiculo de la lista
            guardar();                                      //se llama a guarda la informacion
            return true;                                    //si a funcionado el gardar el vehiculo se retorna true
        } else {
            return false;                                   //si falla se retorna false
        }
    }

    //funcion que retorna el tamano de la lista hashmap
    public int tamano() {
        return vehiculo.size();                              //retorna el tamaño del hashmap
    }

    ////funcion que verifica que el vehiculo esta dentro de la lista
    public boolean comprobarvehiculo(String matriculado) {   //se pasa como dato la matricula
        if (vehiculo.containsKey(matriculado)) {              //se la lista contiene a la matricula esta
            return true;                                    //si esta se retorna true
        } else {
            return false;                                 //si no false
        }
    }

    //funcion para obtener un vehiculo en concreto de la lista
    public Vehiculo obtenervehiculo(String matriculado) {    //se envia la matricula
        return vehiculo.get(matriculado);                  //retorna el vehiculo encuestion del hashmap
    }

    //funcion para obetener un arraylist con los vehiculos 
    public ArrayList<Vehiculo> obtenervehiculo() {
        ArrayList<Vehiculo> vehi = new ArrayList<Vehiculo>(vehiculo.values());      //vuelca el hashmap completo al arraylist
        return vehi;                                       //retorna el arraylist
    }

    //funcion que guarda la informacion del hashmap para proximas ejecuciones del programa
    public void guardar() {
        try {
            if (!vehiculo.isEmpty()) {                                                          //si el hashmap no esta vacion continua
                /**
                 * **** Serialización de los objetos *****
                 */
                //Serialización de los vehiculos
                FileOutputStream ostreamveh = new FileOutputStream("Registrovehiculos.dat");    //asigna el archivo a guardar y donde
                ObjectOutputStream oosCand = new ObjectOutputStream(ostreamveh);                //crea un objeto con el                
                oosCand.writeObject(vehiculo);                                                  //guardamos el hashmap de vehiculos
                ostreamveh.close();                                                             //se cierra el fujo
            } else {
                System.out.println("Error: No hay vehiculos...");                               //mesnaje si no hay nada que guadar
            }
        } catch (Exception e) {
        }
    }
}