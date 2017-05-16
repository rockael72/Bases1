    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author Danny10
 */
public class Pagos {
    private Conexion conexion;
    
    public Pagos(){
        this.conexion=new Conexion();
        this.conexion.conexion();
    }
    
    public ResultSet getPagos(int id){
       return this.conexion.consulta("select Cuota, Fecha from tblPagos where tblReservacion_id="+id);        
    }
    
    public void agregarPago(int id, float pago){
        this.conexion.ejecutar("insert into tblPagos set Cuota = "+pago+", Fecha = now(), tblReservacion_id = "+id);
    }
            
}
