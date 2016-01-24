package aparcamiento;


import java.util.Calendar;



public class Coche extends Vehiculo{

    private double alto=0.0;
    private double ancho=0.0;
    private double importe=0;
    
    //constructor
    public Coche(String matricula, Calendar fecha, boolean  abono, double alto, double ancho){
        super(matricula, fecha, abono);
        this.alto=alto;
        this.ancho=ancho;
    }
    
    
    public double anCho(){
        return ancho;
    }
    
    public double alTo(){
        return alto;
    }
    
    
     public String toString(){
        return "Volumen del coche: "+alto*ancho;
    }
    
    public double calcularImporte(Calendar fechaa){
        //codigo
        if(abono==true){    //con abono
            if(ancho*alto>8){    //mas de 8 el volumen
               //importe=((diffMinutes*3.5)/60); 
               importe=importe-(importe*0.4);
            }
            else{   //menos de 8 el volumen
                
            } 
        }
        else{       //sin abono
            if(ancho*alto>8){    //mas de 8 el volumen
                          
            }
            else{   //menos de 8 el volumen
                //importe=((diffMinutes*2.5)/60);
            }             
        }
        System.out.println(importe);
        return importe;
    }
}
