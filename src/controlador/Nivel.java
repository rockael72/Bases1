/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author rocka
 */
public class Nivel {
    private Conexion conexion;
    
    public Nivel(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
       public void cambiar(int op){
        switch  (op){
            case 1:
        conexion.ejecutar("set global transaction isolation level read uncommitted");
        break;
        case 2:
        conexion.ejecutar("set global transaction isolation level read committed");
        break;
        case 3:
        conexion.ejecutar("set global transaction isolation level repeatable read");
        break;
        case 4:
        conexion.ejecutar("set global transaction isolation level serializable");
        break;        
        }
    }

    
}
