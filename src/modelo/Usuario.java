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
        ResultSet usr = this.conexion.consulta("select * from tblUsuario where Usuario=\""+Usuario+"\"");
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
    
    public String getNombre(int id){
        ResultSet nombre= this.conexion.consulta("select Nombre from tblUsuario where id = "+id+"");
        String nmbr="";
        try{
            while(nombre.next()){
            nmbr = nombre.getString("Nombre");
            }
        }catch(SQLException e){
            
        }
        return nmbr;
    }
    
    public String getUsuario(int id){
        ResultSet nombre= this.conexion.consulta("select Usuario from tblUsuario where id = "+id+"");
        String nmbr="";
        try{
            while(nombre.next())
                nmbr = nombre.getString("Usuario");
        }catch(SQLException e){
            
        }
        return nmbr;
        
    }
    
    public int getIdUsr(String usr){
        ResultSet nombre= this.conexion.consulta("select id from tblUsuario where Usuario = '"+usr+"'");
        int nmbr=0;
        try{
             while(nombre.next())
            nmbr = Integer.valueOf(nombre.getString("id"));
        }catch(SQLException e){
            
        }
        return nmbr;
    }
    
    public String getTipo(int id ){
        ResultSet nombre= this.conexion.consulta("select Administrador from tblUsuario where id = '"+id+"'");
        String nmbr="";
        try{
             while(nombre.next())
            nmbr = nombre.getString("Administrador");
        }catch(SQLException e){
            
        }
        return nmbr;
    }
    
    public void actualizar(int id, boolean tipo){
        this.conexion.ejecutar("update tblUsuario set Administrador = "+tipo+" where id = "+id+"");        
    }

    public int total(){
        ResultSet total=this.conexion.consulta("select count(*) as t from tblUsuario");
        int t = 0;
          try{
             while(total.next())
            t = Integer.valueOf(total.getString("t"));
        }catch(SQLException e){
            
        }
        return t;        
    }
    
}
