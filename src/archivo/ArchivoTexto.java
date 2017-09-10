/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author rocka
 */
public class  ArchivoTexto {
    
    private final String dir = "Bitacora.txt";
    //private final File Ffichero=new File("C:/users/rocka/Documents/Netbeas/Bases/" +dir);
    private final File Ffichero=new File(dir);
    
    public ArchivoTexto(){           
       
    }
    
    public void crear() {
        String ruta =dir;        
        File archivo = new File(ruta);        
        try{
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        }catch(IOException e){
            
        }
    }
    /***
     * 
     * @param estadoV recibe estado actual
     * @param estadoN recibe estado nuevo
     * @param transaccion recibe la transaccion que se va a modificar Ej: Transaccion 1
     */
    public void mod (String estadoV, String estadoN, int t){        
        this.modificar(Ffichero, "Estado: "+estadoV, "Estado: "+estadoN, "TRANSACCION-"+String.valueOf(t-1));
    }
    
    public void modificar(File FficheroAntiguo,String Satigualinea,String Snuevalinea, String transaccion) {  
        boolean mod= false;
        //String SnombFichNuev=FficheroAntiguo.getParent()+"/"+String.valueOf(1)+".txt";        
        String SnombFichNuev="1.txt";        
        File FficheroNuevo=new File(SnombFichNuev);
        try {            
            if(FficheroAntiguo.exists()){             
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;                
                while((Slinea=Flee.readLine())!=null) { 
                    if(Slinea.toUpperCase().trim().equals(transaccion.toUpperCase().trim())){                        
                        mod=true;
                    }
                    if ((Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())&&(mod==true))) {                       
                        EcribirFichero(FficheroNuevo,Snuevalinea);
                        mod=false;
                    }else{                        
                         EcribirFichero(FficheroNuevo,Slinea);
                    }             
                }                
                String SnomAntiguo=FficheroAntiguo.getName();                
                FficheroNuevo.renameTo(FficheroAntiguo);                
                Flee.close();
                 this.renombrar();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {            
             System.out.println(ex.getMessage());
        }
    }
    
    
    public static void EcribirFichero(File Ffichero,String SCadena){
  try {
          //Si no Existe el fichero lo crea
           if(!Ffichero.exists()){
               Ffichero.createNewFile();
           }
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));
          Fescribe.write(SCadena + "\r\n");
          Fescribe.close();
       } catch (Exception ex) {          
          System.out.println(ex.getMessage());
       } 
    }
        
    public void insertar(String dato){
      EcribirFichero(this.Ffichero,dato);
    }
    
    private void renombrar(){
        /*File fichero = new File(this.Ffichero.getParent()+File.separator+this.dir);
        fichero.delete();   
        File f1 = new File(this.Ffichero.getParent()+File.separator+"1.txt");        
        File f2 = new File(this.Ffichero.getParent()+File.separator+this.dir);        
        f1.renameTo(f2);*/
        
        File fichero = new File(this.dir);
        fichero.delete();   
        File f1 = new File("1.txt");        
        File f2 = new File(this.dir);        
        f1.renameTo(f2);
    }
    

/*public void leer(){
     File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (dir);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }*/
}
