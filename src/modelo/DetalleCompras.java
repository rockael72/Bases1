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
public class DetalleCompras {
    private Conexion conexion;
    
    public DetalleCompras(){
        this.conexion = new Conexion();
        this.conexion.conexion();
    }
    
    public void insertar(int idm, int idc, int cantidad, float precio){
        this.conexion.ejecutar("insert into tblDetalleCompra (tblMercaderia_id,tblCompras_id,Cantidad,PrecioCompra) "
                + "values ("+idm+","+idc+","+cantidad+","+precio+")");
    }
}
