/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author rocka
 */
public class Verificar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int cont =0;
         
        while(cont<1000){
        Conexion c= new Conexion();        
        if (c.conexion() != false){
            System.out.println("se ha conectado");           
        }else{           
            System.out.println("se ha desconectado");            
        }        
        TimeUnit.SECONDS.sleep(5);
        }
        
    }
    
}
