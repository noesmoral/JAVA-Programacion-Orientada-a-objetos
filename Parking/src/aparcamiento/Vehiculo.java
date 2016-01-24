package aparcamiento;

import java.util.Calendar;



public abstract class Vehiculo {
    

        public String matricula="";
        public Calendar fecha;
        public Calendar fechaa;
        public boolean abono=false;

        
        

        public Vehiculo(String matricula, Calendar fecha, boolean  abono){
            this.matricula=matricula;
            this.fecha=fecha;
            this.abono=abono;
        }
        
        public String matricula(){
            return matricula;
        }
        
         public boolean abonado(){
            return abono;
        }
        
        public Calendar getFecha(){
            return fecha;
        }
        
        public String fechadia(){
           String  a=fecha.getTime().toString();
            return a;
        }
        
         @Override
        public abstract String toString();
        
        public abstract double calcularImporte(Calendar fecha);
        
       
}
