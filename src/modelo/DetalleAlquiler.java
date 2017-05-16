/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;

/**
 *
 * @author arch
 */
public class DetalleAlquiler {
    private Conexion conexion;
    
    public DetalleAlquiler(){
        this.conexion = new Conexion();
        this.conexion.conexion();
    }
    
    public void insertar(int idr, int idm, float precio, int cantidad){
        this.conexion.ejecutar("insert into tblDetalle (tblReservacion_id,tblMercaderia_id,Precio,Cantidad) "
                + "values ("+idr+","+idm+","+precio+","+cantidad+")");
    }
    
    public void eliminar(int idr, int idm, float precio, int cantidad){
        this.conexion.ejecutar("delete from tblDetalle where "
                + "tblReservacion_id="+idr+" and tblMercaderia_id="+idm+" and precio="+precio+" and cantidad="+cantidad+"");
        
    }
    
    
}