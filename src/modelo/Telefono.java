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
public class Telefono {
    private Conexion conexion;
    
    public Telefono(){
     this.conexion = new Conexion();
     this.conexion.conexion();
    }
    
    public void setTelefono(String telefono, int cliente, int proveedor, int etiqueta){
        // inserta telefono para clientes
        if (proveedor==-1){
            this.conexion.ejecutar("insert into tblTelefono(Telefono, tblCliente_id, tblEtiqueta_id)"
                    + "values ('"+telefono+"',"+cliente+","+etiqueta+")");
        }
        // inserta telefonno para proveedore
        if (cliente==-1){
            this.conexion.ejecutar("insert into tblTelefono(Telefono, tblProveedores_id, tblEtiqueta_id)"
                    + "values (\""+telefono+"\","+proveedor+","+etiqueta+")");
        }
    }
    
    public ResultSet getTelefono(int cliente, int proveedor){
        if (cliente==-1){
            ResultSet provTel=this.conexion.consulta("select Telefono, Etiqueta from tblProveedores\n" +
            "left join tblTelefono\n" +
            "on tblProveedores.id=tblTelefono.tblProveedores_id\n" +
            "left join tblEtiqueta\n" +
            "on tblEtiqueta.id=tblTelefono.tblEtiqueta_id\n" +
            "where tblProveedores.id="+proveedor+"");
            return provTel;
        }
        if (proveedor == -1){
            ResultSet provTel=this.conexion.consulta("select Telefono, Etiqueta from tblCliente\n" +
            "left join tblTelefono\n" +
            "on tblCliente.id= tblTelefono.tblCliente_id\n" +
            "left join tblEtiqueta\n" +
            "on tblEtiqueta.id=tblTelefono.tblEtiqueta_id\n" +
            "where tblCliente.id = "+cliente+"");
            return provTel;
        }
        return null;
    }
    
    public void getColumnas(){
        ResultSet columnas= this.conexion.consulta("select * from tblTelefono");
         try{
        while(columnas.next()){
            System.out.println(columnas.getArray(0));
        }
        }catch(SQLException e){
            System.out.println("Error en consulta " +e.getMessage());
        }
    } 
    
    public void eliminarC(int id, String telefono){
        this.conexion.ejecutar("delete from tblTelefono "
                + "where tblCliente_id="+id+" and Telefono = '"+telefono+"'");        
    }
    
    public void eliminarP(int id, String telefono){
     this.conexion.ejecutar("delete from tblTelefono "
                + "where tblProveedores_id="+id+" and Telefono = '"+telefono+"'");
}
    public void modificarC(int id, String telefono, String modificado, int etiqueta){
        this.conexion.ejecutar("update tblTelefono set Telefono='"+modificado+"', tblEtiqueta_id="+etiqueta+" "
                + "where tblCliente_id="+id+" and Telefono ='"+telefono+"'");
    }
    
    public void modificarP(int id, String telefono, String modificado,int etiqueta){
        this.conexion.ejecutar("update tblTelefono set Telefono='"+modificado+"', tblEtiqueta_id="+etiqueta+" "
                + "where tblProveedores_id="+id+" and Telefono = '"+telefono+"'");
    }
    
    public String buscar(String telefono){
        ResultSet con=this.conexion.consulta("select Telefono from tblTelefono where Telefono="+telefono+"");
        String tel="";
        try{
            while(con.next()){
                tel=con.getString("Telefono");
            }
        }catch(Exception e){
            
        }
        return tel;
    }
}
