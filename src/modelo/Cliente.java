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
    
    public int getNitC(int id){
        ResultSet busqueda = this.conexion.consulta("select Nit from tblCliente where id="+id+"");
        int n =-1;
        try{
            while(busqueda.next()){
                n = Integer.valueOf(busqueda.getString("Nit"));
            }
        }catch(SQLException e){
            
        }
        return n;
        
    }
    
    public String getNombreC(int id){
         ResultSet busqueda = this.conexion.consulta("select Nombre from tblCliente where id="+id+"");
        String n ="";
        try{
            while(busqueda.next()){
                n = busqueda.getString("Nombre");
            }
        }catch(SQLException e){
            
        }
        return n;
    }
    
    public String getApellidoC(int id){
         ResultSet busqueda = this.conexion.consulta("select Apellido from tblCliente where id="+id+"");
        String n ="";
        try{
            while(busqueda.next()){
                n = busqueda.getString("Apellido");
            }
        }catch(SQLException e){
            
        }
        return n;
    }
    
    public String getDireccionC(int id){
         ResultSet busqueda = this.conexion.consulta("select Direccion from tblCliente where id="+id+"");
        String n ="";
        try{
            while(busqueda.next()){
                n = busqueda.getString("Direccion");
            }
        }catch(SQLException e){
            
        }
        return n;
    }
    
    public String getCorreoC(int id){
         ResultSet busqueda = this.conexion.consulta("select correo from tblCliente where id="+id+"");
        String n ="";
        try{
            while(busqueda.next()){
                n = busqueda.getString("correo");
            }
        }catch(SQLException e){
            
        }
        return n;
    }
    
        
    public int getDPIC(int id){
        ResultSet busqueda = this.conexion.consulta("select DPI from tblCliente where id="+id+"");
        int n =-1;
        try{
            while(busqueda.next()){
                n = Integer.valueOf(busqueda.getString("DPI"));
            }
        }catch(SQLException e){
            
        }
        return n;
        
    }
    
    public int total(){
        ResultSet total=this.conexion.consulta("select count(*) as t from tblCliente");
        int t = 0;
          try{
             while(total.next())
            t = Integer.valueOf(total.getString("t"));
        }catch(SQLException e){
            
        }
        return t;        
    }
}
