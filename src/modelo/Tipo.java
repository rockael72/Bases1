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
public class Tipo {
    private Conexion conexion;
    
    public Tipo(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public void setTipo(String tipo){
         conexion.ejecutar("insert into tblTipo (Tipo) "+
                     "values ('"+tipo+"')");
    }
    
    public ResultSet getTipo(int id){
         ResultSet tipo = this.conexion.consulta("select Categoria from tblTipo "
                + "where id="+id+")");
         return tipo;
    }
    
    public int getId(String tipo){
         ResultSet id = this.conexion.consulta("select id from tblTipo "
                + "where Tipo='"+tipo+"'");
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
    
    public ResultSet getAllTipo(){
        ResultSet tblCategoria = this.conexion.consulta("select * from tblTipo");
         return tblCategoria;
    }
    
    
}
