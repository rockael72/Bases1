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
public class CColor {
     private Conexion conexion;
    
    public CColor(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public void setColor(String Color){
         conexion.ejecutar("insert into tblColor (Color) "+
                     "values ('"+Color+"')");
    }
    
    public ResultSet getColor(int id){
         ResultSet tipo = this.conexion.consulta("select Color from tblColor "
                + "where id="+id+")");
         return tipo;
    }
    
    public int getId(String color){
         ResultSet id = this.conexion.consulta("select id from tblColor "
                + "where Color='"+color+"'");
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
    
    public ResultSet getTblColor(){
        ResultSet tblColor = this.conexion.consulta("select * from tblColor");
         return tblColor;
    }
    
    
}
