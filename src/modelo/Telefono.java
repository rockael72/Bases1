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
            this.conexion.ejecutar("insert into tblTelefono(Telefono, tblProveedore_id, tblEtiqueta_id)"
                    + "values (\""+telefono+"\","+proveedor+","+etiqueta+")");
        }
    }
    
    public ResultSet getTelefono(int cliente, int proveedor){
        if (cliente==-1){
            ResultSet provTel=this.conexion.consulta("select tblTelefono.Telefono, tblEtiqueta.Etiqueta from tblTelefono "
                    + "inner join tblEtiqueta"
                    + "on tblEtiqueta.id=tblTelefono.tblEtiqueta.id"
                    + "where tblTelefono.tblCliente_id = "+proveedor+")");
            return provTel;
        }
        if (proveedor == -1){
            System.out.println("entro aca");
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
}
