/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusquedaEmpleo;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Jesus
 */
public class Agencia {
    private static ArrayList<Oferta> ofertas=new ArrayList<>();
    private static ArrayList<Candidato> candidatos=new ArrayList<>();
    
    public Agencia(){
    }
    
    public static void setCandidatos(ArrayList<Candidato> c) {
        candidatos = c;
    }
    
    public static void setOfertas(ArrayList<Oferta> p) {
        ofertas = p;
    }
    
    /** Da de alta una oferta */
    public static boolean altaOferta(Oferta objoft) {        
        ofertas.add(objoft);
        if (ofertas.contains(objoft)) {             
            return true;
        } else {
            return false;
        }
    }
    
    /** Da de alta un candidato */
    public static boolean altaCandidato(Candidato objcand) {        
        if (!candidatos.contains(objcand)) {
            candidatos.add(objcand);
            return true;
        } else {
            return false;
        }
    }
    
    /** Devuelve el ArrayList de ofertas ordenadas por nombre*/
    public static ArrayList<Oferta> getOfertas() {
        //Comparador para ordenar las ofertas por su nombre
        Comparator OftCompNom = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Oferta p1 = (Oferta) o1;
                Oferta p2 = (Oferta) o2;
                return p1.getNombre().compareTo(p2.getNombre());
            }
        };
        //Ordenamos el array
        Collections.sort(ofertas,OftCompNom);
        return ofertas;
    }
    
        /** Borra una persona */
    public static boolean borraCandidato(Candidato objcand) {
        if (candidatos.contains(objcand)) {
            candidatos.remove(objcand);
            return true;
        } else {
            return false;
        }
    }
    
        /** Borra una oferta */
    public static boolean borraOferta(Oferta objoft) {
        if (ofertas.contains(objoft)) {
            ofertas.remove(objoft);
            return true;
        } else {
            return false;
        }
    }
    
     /** Devuelve el ArrayList de candidatos ordenados por nombre*/
    public static ArrayList<Candidato> getCandidatos() {
        //Comparador para ordenar los candidatos por su nombre
        Comparator NomCandComp = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Candidato c1 = (Candidato) o1;
                Candidato c2 = (Candidato) o2;
                return c1.getNombre().compareTo(c2.getNombre());
            }
        };
        //Ordenamos el array
        Collections.sort(candidatos, NomCandComp);
        return candidatos;
    }
    
    /** Devuelve un ArrayList de ofertas las cuales contienen el string de entada */
    public static ArrayList<Oferta> buscarOfertaPorPalabraClave(String clave){
       ArrayList<Oferta> oftFiltrada=new ArrayList<>();
       for(int i=0;i<ofertas.size();i++){//Recorre el array y añade las coincidencias al nuevo array
           if(ofertas.get(i).getListaClave().contains(clave)){
               oftFiltrada.add(ofertas.get(i));
           }
       }
       return oftFiltrada;
    }
    
    /** Devuelve un ArrayList de candidatos los cuales contienen el string de entada */
    public static ArrayList<Candidato> buscarCandidatoPorPalabraClave(String clave){
       ArrayList<Candidato> candFiltrada=new ArrayList<>();
       for(int i=0;i<candidatos.size();i++){//Recorre el array y añade las coincidencias al nuevo array
           if(candidatos.get(i).getListaClave().contains(clave)){
               candFiltrada.add(candidatos.get(i));
           }
       }
       return candFiltrada;
    }
    
     /** Devuelve un ArrayList de ofertas las cuales contienen el string de entada */
    public static ArrayList<Oferta> buscarOfertaPorOcupacion(String ocupacion){
       ArrayList<Oferta> oftFiltrada=new ArrayList<>();
       for(int i=0;i<ofertas.size();i++){//Recorre el array y añade las coincidencias al nuevo array
           if(ofertas.get(i).getOcupacion().contains(ocupacion)){
               oftFiltrada.add(ofertas.get(i));
           }
       }
       return oftFiltrada;
    }
    
    /** Devuelve un ArrayList de candidatos los cuales contienen el string de entada */
    public static ArrayList<Candidato> buscarCandidatoPorOcupacion(String ocupacion){
       ArrayList<Candidato> candFiltrada=new ArrayList<>();
       for(int i=0;i<candidatos.size();i++){//Recorre el array y añade las coincidencias al nuevo array
           if(candidatos.get(i).getOcupaciones().contains(ocupacion)){             
                 candFiltrada.add(candidatos.get(i));
           }          
       }
       return candFiltrada;
    }
    
    /** Recibe un candidato y compara las ofertas para ver que contienen la misma ocupacion
     Y devuelve un ArrayList con las coincidencias*/
    public static ArrayList<Oferta> compararOfertaPorOcupacionYRango(Candidato cand){
       ArrayList<Oferta> oftComparada=new ArrayList<>();
       for(int i=0;i<ofertas.size();i++){//Recorre el array y añade las coincidencias al nuevo array
           if(cand.getOcupaciones().contains(ofertas.get(i).getOcupacion())){
               if(comparaRangos(cand,ofertas.get(i))){//Usa el metodo comopara rangos para comprobar que pertenecen
                    oftComparada.add(ofertas.get(i));// al mismo rango de salario
               }
           }
       }
       return oftComparada;
    }
    
    /** Recibe una oferta y compara los candidatos para ver que contienen la misma ocupacion
     Y devuelve un ArrayList con las coincidencias*/
    public static ArrayList<Candidato> compararCandidatoPorOcupacionYRango(Oferta oft){
       ArrayList<Candidato> candComparada=new ArrayList<>();
       for(int i=0;i<candidatos.size();i++){
           /**Tranforma el String de ocupaciones del candidato a un Array y compara cada una
            * de las ocupaciones que contiene con las ocupaciones de las ofertas
            */
           String[] ocupacionesArray = candidatos.get(i).getOcupaciones().split(",\\s*");
           dos:for (String o : ocupacionesArray){//REcorre el array de ocupaciones
               if(o.contains(oft.getOcupacion())){//Si contiene la misma ocupacion pasa a comprobar los rangos
                   if(comparaRangos(candidatos.get(i),oft)){
                       candComparada.add(candidatos.get(i));//Y los añade al ArrayList que devuelve el metodo
                       break dos;
                   }
               }
           }         
       }
       return candComparada;
    }
    
    /** Compara los rangos de un candidato y una oferta
     Basandose en los rangos anuales que establecen el porcentaje de impuestos
     se han predeterminado los rangos salariales deseados por los candidatos
     -Un salario menos de 1275€
     -Un salario entre 1275 y 1450€
     -Un salario mayor de 1450€
     Con esto se simplifica la aplicacion a la hora de comparar las ofertas con los candidatos
     */
    public static boolean comparaRangos(Candidato c,Oferta o){
        boolean a=false;
        switch(c.getRangoSalarial()){
            case "-1275":
                if(o.getRangoSalarial().equals("-18000")){
                a= true;                
                }break;
            case "1275-1450":
                if(o.getRangoSalarial().equals("18000-30000")){
                a= true;                
                }break;
            case "+1450":
                if(o.getRangoSalarial().equals("+30000")){
                a= true;               
                }break;
            
        }
        return a;
        
 
}
    
    /** Carga los datos de ofertas y candidatos del fichero */
    public static void cargarDatos() {
        try {
            //Lectura de los objetos de tipo oferta
            FileInputStream istreamOft = new FileInputStream("copiasegOft.dat");
            ObjectInputStream oisOft = new ObjectInputStream(istreamOft);
            ofertas = (ArrayList) oisOft.readObject();
            istreamOft.close();
            //Lectura de los datos tipo candidato
            FileInputStream istreamCand = new FileInputStream("copiasegCand.dat");
            ObjectInputStream oisCand = new ObjectInputStream(istreamCand);
            candidatos = (ArrayList) oisCand.readObject();
            istreamCand.close();
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos ofertas y candidatos

    /** Guarda los datos de ofertas en el fichero */
    public static void guardarOfertas() {
        try {
            //Si hay datos los guardamos...           
            if (!ofertas.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de las ofertas
                FileOutputStream ostreamOft = new FileOutputStream("copiasegOft.dat");
                ObjectOutputStream oosOft = new ObjectOutputStream(ostreamOft);
                //guardamos el array de ofertas
                oosOft.writeObject(ofertas);
                ostreamOft.close();
            } else {
                System.out.println("Error: No hay ofertas...");
            }

        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin guardarOfertas
    
    /** Guarda los datos de candidatos en el fichero */
    public static void guardarCandidatos(){
       try{
        if (!candidatos.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de los candidatos
                FileOutputStream ostreamCand = new FileOutputStream("copiasegCand.dat");
                ObjectOutputStream oosCand = new ObjectOutputStream(ostreamCand);
                //guardamos el array de candidatos
                oosCand.writeObject(candidatos);
                ostreamCand.close();
            } else {
                System.out.println("Error: No hay candidatos...");
            }
    } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /** Crea un fichero de texto con los datos de una oferta
     Utiliza el nombre de la oferta y de la oficina para asignar el nombre al archivo*/
    public static void imprimirOferta(Oferta oft) throws IOException {
        PrintWriter salida = new PrintWriter(new BufferedWriter(new FileWriter(oft.getNombre()+oft.getOficina().getNombre() + ".txt")));
        long a = oft.getFechaApertura().getTime();
        long f = oft.getFechaCaducidad().getTime();
        String ap = DateFormat.getDateInstance(DateFormat.SHORT).format(a);
        String cad = DateFormat.getDateInstance(DateFormat.SHORT).format(f);

        salida.println("-------------------------------- Oferta ------------------------------------");
        salida.println("\n");
        salida.println("Nombre: " + oft.getNombre());
        salida.println("\n");
        salida.println("Oficina: Nombre: " + oft.getOficina().getNombre());
        salida.println("\n");
        salida.println("         Telefono: "+oft.getOficina().getTelefono());
        salida.println("\n");
        salida.println("         Direccion: Via: "+oft.getOficina().getDireccion().getNombreVia());
        salida.println("                    Numero: " +oft.getOficina().getDireccion().getNumero());
        salida.println("                    Piso y letra: "+oft.getOficina().getDireccion().getPisoLetra());
        salida.println("                    Localidad: "+oft.getOficina().getDireccion().getLocalidad());
        salida.println("                    Codigo Postal: "+oft.getOficina().getDireccion().getCodigoPostal());
        salida.println("\n");
        salida.println("Ocupacion: " + oft.getOcupacion());
        salida.println("\n");
        salida.println("Lista Clave: " + oft.getListaClave());
        salida.println("\n");
        salida.println("Fecha de apertura: " + ap);
        salida.println("\n");
        salida.println("Fecha de caducidad: " + cad);
        salida.println("\n");
        salida.println("Rango salarial: " + oft.getRangoSalarial()+"€");
        salida.println("\n");
        salida.println("-------------------------------------------------------------------------------");
        salida.close();
    }

}
