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
public class Cliente {
    private Conexion conexion;
    
    public Cliente (){
        this.conexion = new Conexion();
        this.conexion.conexion();
    }
    
    public void crearCliente(int nit, String nombre, String apellido,
                            String direccion, int dpi, String correo){
        conexion.ejecutar("insert into tblCliente (Nit, Nombre, Apellido, "
                + "Direccion, DPI, correo)"
                + "values ("+nit+",\""+nombre+"\",\""+apellido+"\","
                +"\""+direccion+"\","+dpi+",\""+nombre+"\")");
       
    }
    
    public int clienteMID(){
        ResultSet max= this.conexion.consulta("select max(id) as idmax from tblCliente");
        try{
            while(max.next()){
                return Integer.valueOf(max.getString("idmax"));
            }
        }catch(SQLException ex){
            
        }
        return  0;
    }
    
    public void modificarCliente(int id, int nit, String nombre, String apellido,
                            String direccion, int dpi, String correo){
        conexion.ejecutar("update tblCliente " +
    "set Nit= "+nit+",Nombre = '"+nombre+"', Apellido= '"+apellido+"', Direccion = '"+direccion+"', DPI = "+dpi+", correo= '"+correo+"'" +
    "where id = "+id+"");               
    }
    
    public ResultSet bdpi(int dpi){
        ResultSet busqueda = this.conexion.consulta("select Nombre,Apellido,Direccion,DPI from tblCliente where DPI="+dpi+"");
        return busqueda;
    }
    
    public ResultSet bid(int id){
        ResultSet busqueda = this.conexion.consulta("select Nombre,Apellido,Direccion,DPI from tblCliente where id="+id+"");
        return busqueda;
    }
    
    public int getId(int DPI){
        ResultSet busqueda = this.conexion.consulta("select id from tblCliente where DPI="+DPI+"");
        int id =-1;
        try{
            while(busqueda.next()){
                id = Integer.valueOf(busqueda.getString("id"));
            }
        }catch(SQLException e){
            
        }
        return id;
        
    }
}
