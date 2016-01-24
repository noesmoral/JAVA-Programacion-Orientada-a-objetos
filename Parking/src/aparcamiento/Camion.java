package aparcamiento;

import java.text.DateFormat;
import java.util.Calendar;


public class Camion extends Vehiculo{
    

    private int numruedas=0;
    private double importe=0;
     private Calendar fechaa;
    
    //constructor
    public Camion(String matricula, Calendar fecha, boolean  abono, int numruedas){
        super(matricula, fecha, abono);
        this.numruedas=numruedas;
    }
    
    public int numRuedas(){
        return numruedas;
    }
    
    @Override
    public String toString(){
        return "Numero de ruedas: "+numruedas;
    }
    
    public double calcularImporte(Calendar fechaa){
        //codigo
        if(abono==true){    //con abono
            if(numruedas>6){    //mas de 6 ruedas
               
            }
            else{   //menos de 6 ruedas
                
            } 
        }
        else{       //sin abono
            if(numruedas>6){    //mas de 6 ruedas
                              
            }
            else{   //menos de 6 ruedas
                
            }             
        }       
        System.out.println(importe);
        return importe;
        
    }
}
