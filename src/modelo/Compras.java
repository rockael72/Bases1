/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arch
 */
public class Compras {
    private Conexion conexion;
    
    public Compras(){
        this.conexion=new Conexion();
        this.conexion.conexion();
    }
    
    public void insertar(int idproveedor, int idusuario){
        this.conexion.ejecutar("insert into tblCompras(tblProveedores_id, tblUsuario_id) "
                + "values ("+idproveedor+", "+idusuario+")");
    }
    
    public int getMaxid(){
        ResultSet max=this.conexion.consulta("select max(id) as max from tblCompras");
        int id=-1;
        try{
        while(max.next()){
            id = Integer.valueOf(max.getString("max"));
        }
        }catch(SQLException e){
            
        }
        return id;
    }
}
