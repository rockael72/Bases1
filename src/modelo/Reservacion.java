/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arch
 */
public class Reservacion {
     private Conexion conexion;
    
    public Reservacion(){
        this.conexion=new Conexion();
        this.conexion.conexion();
    }
    
    public void insertar(String fechaR, String direccion, int idc, int idciu, int idusr){
        this.conexion.ejecutar("insert into tblReservacion(FechaR, Direccion, tblCliente_id, tblCiudad_id, tblUsuario_id) "
                + "values ('"+fechaR+"', '"+direccion+"',"+idc+","+idciu+","+idusr+")");
    }
    
    public int getMaxid(){
        ResultSet max=this.conexion.consulta("select max(id) as max from tblReservacion");
        int id=-1;
        try{
        while(max.next()){
            id = Integer.valueOf(max.getString("max"));
        }
        }catch(SQLException e){
            
        }
        return id;
    }
}
