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
public class Tamanio {
  private Conexion conexion;
    
    public Tamanio(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public void setTamanio(String tamanio){
         conexion.ejecutar("insert into tblTamanio (Tamanio) "+
                     "values ('"+tamanio+"')");
    }
    
    public ResultSet getTamanio(int id){
         ResultSet tipo = this.conexion.consulta("select Tamanio from tblTamanio "
                + "where id="+id+")");
         return tipo;
    }
    
    public int getId(String Tamanio){
         ResultSet id = this.conexion.consulta("select id from tblTamanio "
                + "where Tamanio='"+Tamanio+"'");
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
    
    public ResultSet getTblTamanio(){
        ResultSet tblCategoria = this.conexion.consulta("select * from tblTamanio");
         return tblCategoria;
    }
       
}
