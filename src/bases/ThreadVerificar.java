/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bases;

import hilos.Conexion;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.PanelProducto;
import vista.Principal;
import vista.Reconectando;

/**
 *
 * @author rocka
 */
public class ThreadVerificar implements Runnable {    
   private final PanelProducto pProducto;
   private boolean detener =true;
   private boolean r;      
   private boolean ventana =true;
   
   public void detener(){
       this.detener=false;
       this.r=false;
   }
   
        //public ThreadEnvia(Socket conexion, final PrincipalChat main){
    @SuppressWarnings("Convert2Lambda")
	     public ThreadVerificar(final PanelProducto pProducto){
              this.pProducto=pProducto;                    
   
             }
    
    @Override       
    public void run() {
        while(detener){
        Conexion c= new Conexion();        
        if (c.conexion() != false){
            if(this.r==true){                
                this.pProducto.enviarRollback();
                this.r=false;                            
            }
            if(this.ventana==false){
           this.pProducto.cerrarPanelError();
            this.ventana=true;
            }
            System.out.println("se ha conectado");              
                     
        }else{     
            if(this.pProducto.getActivo()){
                System.out.println("habia una transaccin");                                
                this.r=true;
                this.pProducto.cambiar();
                if (ventana ==true){
                this.pProducto.mostrarPanelError();
                ventana = false;
                }
                System.out.println("se ha desconectado");            
            }
              System.out.println("se ha desconectado");            
            
        }          
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadVerificar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
