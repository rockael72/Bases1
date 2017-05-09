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
public class Usuario {
    
    private Conexion conexion;
    
    public Usuario( ){
        this.conexion = new Conexion();
        this.conexion.conexion();
    }
    
    public void setUsuario(String nombre,String usuario, String contrasenia, boolean administrador){            
            conexion.ejecutar("insert into tblUsuario (Nombre,Usuario,Contrasenia,Administrador) "+
                     "values ('"+nombre+"','"+usuario+"','"+contrasenia.hashCode()+"',"+administrador+")");
    }
    
    public boolean getSesion(String usrio, String pss){
        boolean existe = false;
        ResultSet usr = this.conexion.consulta("select * from tblUsuario "
                + "where Usuario=\""+usrio+"\" and Contrasenia=\""+pss.hashCode()+"\"");
        try{
            while(usr.next()){
                int pssH = Integer.valueOf(usr.getString("Contrasenia"));
                int pssH2 = pss.hashCode();
                String usr3= usr.getString("Usuario");
               if((usr3.equals(usrio)&&(pssH==pssH2))){
                existe=true;
                }
        }
        }catch(SQLException e){
            System.out.println("error");
        }
        System.out.println(existe);
        return existe;
    }
    
    public String getUsuario(String Usuario){
        ResultSet usr = this.conexion.consulta("select * from tblUsuario where Contrasenia=\""+Usuario+"\"");
        try{
            while(usr.next()){
            return usr.getString("Usuario");
        }
        }catch(SQLException e){
            System.out.println("error");
        }
        return "";
    }
    
    public String getContrasenia(String contrasenia){
        ResultSet usr = this.conexion.consulta("select * from tblUsuario where Contrasenia=\""+contrasenia.hashCode()+"\"");
        try{
            while(usr.next()){
            return usr.getString("Contrasenia");
        }
        }catch(SQLException e){
            System.out.println("error");
        }
        return "";
    }    
    
    public void setHistorial(int id){
        conexion.ejecutar("insert into tblHistorial (fecha,tblUsuario_id) "+
                     "values (now(),"+id+")");
    }
    
    public int getId(String usrio, String pss){
         ResultSet usr = this.conexion.consulta("select id from tblUsuario where Usuario='"+usrio+"' and Contrasenia = '"+pss.hashCode()+"' ");  
         int id=-1;
        try{
            while(usr.next()){
                id = Integer.valueOf(usr.getString("id"));
                System.out.println(id);
        }
        }catch(SQLException e){
            System.out.println("error");
        }
        return id;
    }
    
    public ResultSet usuario(){
       ResultSet usr = this.conexion.consulta("select * from tblUsuario");
       return usr;
    }
    
    

    
}
