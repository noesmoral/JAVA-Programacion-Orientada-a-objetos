package aparcamiento;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Aparcamiento {

    private static int capacidad = 10;
    private String nombre = "";
    private Vehiculo camion;
    private String matricula = "";
    private Vehiculo transporte;
    private Vehiculo coche;
    private double precio = 0.0;
    public HashMap<String, Vehiculo> matri = new HashMap<String, Vehiculo>();

    public Aparcamiento(String nombre) {
        this.nombre = nombre;
    }

    
     public double sacarVehículo(String matricula) throws IOException, AparcamientoException {
        precio = 0.0;
        if (capacidad < 10) {
            if (matri.containsKey(matricula)) {
                transporte = matri.get(matricula);
                matri.remove(matricula);
                capacidad = capacidad + 1;
                return precio;
            } else {
                throw new AparcamientoException(AparcamientoException.VEHICULO_FUERA);
            }
        } else {
            throw new AparcamientoException();
        }

    }
     
     
    public void intoducirVehiculo(Vehiculo v) throws AparcamientoException {
        if (capacidad >= 1) {
            if (!matri.containsKey(v.matricula())) {
                matri.put(v.matricula(), v);
                capacidad = capacidad - 1;
            } else {
                throw new AparcamientoException(AparcamientoException.VEHICULO_DENTRO);
            }
        } else {
            throw new AparcamientoException(AparcamientoException.APARCAMIENTO_LLENO);
        }
    }

   
}
