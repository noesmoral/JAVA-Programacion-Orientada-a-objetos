/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Concesionario;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author pedro.barquin
 */
//clase donde se almacenan las ventas
public class RegistroVentas {

    //atributos
    private ArrayList<Venta> ventas = new ArrayList();               //Arrylist deonde se almacenan los ventas
    private String nombre = "";

    //constructor
    public RegistroVentas(String nombre) {
        this.nombre = nombre;
        try {
            //Lectura de los objetos de ventas
            FileInputStream istreamven = new FileInputStream("Registroventas.dat");         //se garga el archivo a leer con el nombre dado 
            ObjectInputStream oisOft = new ObjectInputStream(istreamven);                   //con el fileInputestream anterior se crea el objeto para la lectura de los datos referenciando el creado antes que es donde esta la informacion
            ventas = (ArrayList) oisOft.readObject();                                       //se vuelca la informacion pasandola al tipo de dato del destino
            istreamven.close();                                                             //se cierra el fujo
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());                         //mensaje de error varios
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error Ventas no encontrado: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //metodo para insertar las ventas
    public void insertarventa(Venta v) throws IOException {                 //se recibe un obejeto venta
            ventas.add(v);                                                  //se registra en el arraylist la venta
            guardar();                                                      //se llama a guardar la informacion
            print(v);                                                       //se imprime la factura
    }

    //metodo que guarda la informacion de las ventas
    public void guardar() {
        try {
            if (!ventas.isEmpty()) {                                                        //si el arraylist no esta vacia continua   
                /**
                 * **** Serialización de los objetos *****
                 */
                //Serialización de las ventas
                FileOutputStream ostreamven = new FileOutputStream("Registroventas.dat");   //asigna el archivo a guardar y donde
                ObjectOutputStream oosCand = new ObjectOutputStream(ostreamven);            //crea un objeto con el 
                oosCand.writeObject(ventas);                                                //guardamos el arraylist de ventas
                ostreamven.close();                                                         //se cierra el flujo
            } else {
                System.out.println("Error: No hay ventas...");                           //mesnaje de error son no hay ventas
            }
        } catch (Exception e) {
        }
    }

    //metodo para guardar la informacion de la venta
    public void print(Venta v) throws IOException {
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(v.getmatricula() + " " + v.getnombre() + ".txt")));         //crea documento factura y rellena con datos  tendra como nombre la matricula y el nombre del cliente                 
        //se obtienen todos los datos para que se muestren en la factura
        salida.println("Factura");
        salida.println("\n" + "*********************************");
        salida.println("\n" + "Datos Comprador");
        salida.println("\n" + "Nombre y apellido: " + v.getnombre());
        salida.println("\n" + "usuario : " + v.getcodigonombre());
        salida.println("\n" + "DNI : " + v.getdni());
        salida.println("\n" + "relacion con el concesionario : " + v.getrelacionConcesionario());
        salida.println("\n" + "fecha de compra : " + v.getfecha().getTime().toString());
        salida.println("\n" + "*********************************");
        salida.println("\n" + "Datos vehiculo");
        salida.println("\n" + "Matricula: " + v.getmatricula());
        salida.println("\n" + "marca: " + v.getmarca());
        salida.println("\n" + "potencia: " + v.getpotencia());
        salida.println("\n" + "modelo: " + v.getmodelo());
        salida.println("\n" + "color: " + v.getcolor());
        salida.println("\n" + "año de fabricacion: " + v.getaño());
        salida.println("\n" + "kilometros: " + v.getkilometros());
        salida.println("\n" + "Precio con descuento si lo ubiera: " + v.getprecio() + "€");
        salida.println("\n" + "Otros: " + v.gettipoVehiculo());
        salida.close();
        //cierra el documento
    }

    //metodo para obetener un arraylist con las ventas 
    public ArrayList<Venta> obtenerventas() {
        return ventas;                                                        //retorna el arraylist
    }
}