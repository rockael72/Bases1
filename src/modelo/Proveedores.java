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
public class Proveedores {
    private Conexion conexion;
    
    public Proveedores(){
        this.conexion=new Conexion();
        this.conexion.conexion();
    }
    
    public void insertar(String nombre, String direccion, String correo){
        this.conexion.ejecutar("insert into tblProveedores (Nombre, Direccion, Correo)"
                + "values ('"+nombre+"','"+direccion+"','"+correo+"')");
    }
    
    public int maxId(){
        ResultSet max=this.conexion.consulta("select max(id) idmax from tblProveedores");
        try{
            while(max.next()){
                return Integer.valueOf(max.getString("idmax"));
            }
        }catch(SQLException ex){
            
        }
        return 0;
    }
    
    public void modificar(int id, String nombre, String direccion, String correo){
        this.conexion.ejecutar("update tblProveedores "
                + "set Nombre = '"+nombre+"', Direccion = '"+direccion+"', Correo = '"+correo+"' "
                + "where id = "+id+"");                        
    }
    
    public ResultSet getProveedorCod(int cod){
        ResultSet proveedor = this.conexion.consulta("select Nombre, Direccion, Correo from tblProveedores where id = "+cod);
        return proveedor;
    }
    
    public ResultSet getAll(){
        ResultSet proveedor = this.conexion.consulta("select Nombre, Direccion, Correo from tblProveedores");
        return proveedor;
    }
    
    public int getId(String nombre, String direccion, String correo){
        ResultSet max=this.conexion.consulta("select id \n" +
        "from tblProveedores \n" +
        "where Nombre = '"+nombre+"'and Direccion ='"+direccion+"' and Correo = '"+correo+"'");
        try{
            while(max.next()){
                return Integer.valueOf(max.getString("id"));
            }
        }catch(SQLException ex){
            
        }
        return 0;
    }
    }
