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
public class Ciudad {
    private Conexion conexion;
    
    public Ciudad(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public ResultSet getAll(){
        ResultSet todo = this.conexion.consulta("select * from tblCiudad order by Ciudad");
        return todo;
    }
    
    public void setCuidad(String ciudad){
        this.conexion.ejecutar("insert into tblCiudad (Ciudad) values ('"+ciudad+"')");
    }
    
    public int getId(String ciudad){
        ResultSet vid=this.conexion.consulta("select id from tblCiudad where Ciudad = '"+ciudad+"'");
        int id = -1;
        try{
            while(vid.next()){
               id  = Integer.valueOf(vid.getString("id"));
        }
        }catch(SQLException e){
            
        }
        return id;
    }
}
