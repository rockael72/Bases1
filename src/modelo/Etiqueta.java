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
public class Etiqueta {
    private Conexion conexion;
    
    public Etiqueta(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public void setEtiqueta(String etiqueta){
        conexion.ejecutar("insert into tblEtiqueta (Etiqueta) "+
                     "values ('"+etiqueta+"')");
    }
    
    public int getId(String etiqueta){
        ResultSet categoria = this.conexion.consulta("select id from tblEtiqueta "
                + "where Etiqueta=\""+etiqueta+"\"");
        int id = -1;
         try{
        while(categoria.next()){
            id=Integer.valueOf(categoria.getString("id"));
        }
        }catch(SQLException e){
            System.out.println("Error en consulta " +e.getMessage());
        }
         return id;
    }
    
    public ResultSet getAllEtiqueta(){
        return this.conexion.consulta("select Etiqueta from tblEtiqueta");
    }
    
}
