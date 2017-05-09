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
public class Categoria {
    private Conexion conexion;
    
    public Categoria(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public void setCategoria(String categoria){
         conexion.ejecutar("insert into tblCategoria (Categoria) "+
                     "values ('"+categoria+"')");
    }
    
    public ResultSet getCategoria(int id){
         ResultSet categoria = this.conexion.consulta("select Categoria from tblCategoria "
                + "where id='"+id+"')");
         return categoria;
    }
    
    public int getId(String categoria){
         ResultSet id = this.conexion.consulta("select id from tblCategoria "
                + "where Categoria='"+categoria+"'");
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
    
    public ResultSet getTblCategoria(){
        ResultSet tblCategoria = this.conexion.consulta("select * from tblCategoria");
         return tblCategoria;
    }
    
    
}
