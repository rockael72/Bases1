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
public class Material {
     private Conexion conexion;
    
    public Material(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public void setMaterial(String material){
         conexion.ejecutar("insert into tblMaterial (Material) "+
                     "values ('"+material+"')");
    }
    
    public ResultSet getMaterial(int id){
         ResultSet material = this.conexion.consulta("select Material from tblMaterial "
                + "where id="+id+")");
         return material;
    }
    
    public int getId(String material){
         ResultSet id = this.conexion.consulta("select id from tblMaterial "
                + "where Material='"+material+"'");
         int idc = -1;
         try{
        while(id.next()){
            idc=Integer.valueOf(id.getString("id"));
        }
        }catch(SQLException e){
            System.out.println("Error en consulta " +e.getMessage());
        }
         return idc;
    }
    
    public ResultSet getAllMaterial(){
        ResultSet tblMaterial = this.conexion.consulta("select * from tblMaterial");
         return tblMaterial;
    }
    
    
    
    
}
