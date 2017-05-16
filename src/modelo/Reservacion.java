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
    
    public void tota(int id, float total){
        this.conexion.ejecutar("update tblReservacion set Total="+total+" where id="+id+"");
    }
    
    public float getTotal(int id){
        ResultSet total=this.conexion.consulta("select Total from tblReservacion where id ="+id+"");
        float t=0;
        try{
            while(total.next()){
                t=Float.valueOf(total.getString("Total"));
            }
        }catch(SQLException e){
            
        }
        return t;
    }
    
    public float getSaldo(int id){
        ResultSet total=this.conexion.consulta("select Saldo from tblReservacion where id ="+id+"");
        float t=0;
        try{
            while(total.next()){
                t=Float.valueOf(total.getString("Saldo"));
            }
        }catch(SQLException e){
            
        }
        return t;
    }
    
    
    
    public void cancelar(int id){
        this.conexion.ejecutar("update tblReservacion set Anulado=true where id="+id+"");
    }
    
    public void finalizar(int id){
        this.conexion.ejecutar("update tblReservacion set Activo=0 where id="+id+"");
    }
    
    public void fechaFinal(int id){
        this.conexion.ejecutar("update tblReservacion set FechaF=now() where id="+id+"");
    }
    
    public void eliminar(int id){
        this.conexion.ejecutar("delete from tblReservacion where id = "+id+"");
    }
    
    public ResultSet getReservacion(int id){
        return this.conexion.consulta("select Direccion, FechaR as FechaReservacion, Saldo, Total  from tblReservacion "
                + "where tblCliente_id = "+id+" and Anulado = false and Activo = 1 and FechaF is null");
    }
    
    public ResultSet getPCobrar(int id){
        return this.conexion.consulta("select Direccion, FechaR as FechaReservacion, Saldo, Total  from tblReservacion "
                + "where tblCliente_id = "+id+" and Anulado = false and Total > Saldo");
    }
    
    public ResultSet getFinalizado(int id){
        return this.conexion.consulta("select Direccion, FechaR as FechaReservacion, Saldo, Total  from tblReservacion "
                + "where tblCliente_id = "+id+" and Anulado = false and Activo=false");
    }
    
    public ResultSet getAnulado(int id){
        return this.conexion.consulta("select Direccion, FechaR as FechaReservacion, Saldo, Total  from tblReservacion "
                + "where tblCliente_id = "+id+" and Anulado = true");
    }
    
    
    public int getIdR(String direccion, String f, int idC){
        ResultSet vid=this.conexion.consulta("select id from tblReservacion "
                + "where Direccion ='"+direccion+"' and FechaR = '"+f+"' "
                + "and tblCliente_id= "+idC+"" );
        int id=-1;
        try{
            while (vid.next()){
                id = Integer.valueOf(vid.getString("id"));
            }
        }catch(SQLException e){
            
        }
        return id;
    }
    
    public int getIdUsr(int idC){
         ResultSet vid=this.conexion.consulta("select tblUsuario_id from tblReservacion "
                + "where id= "+idC+"" );
        int id=-1;
        try{
            while (vid.next()){
                id = Integer.valueOf(vid.getString("tblUsuario_id"));
            }
        }catch(SQLException e){
            
        }
        return id;
    
    }
    
    public String getDir(int idC){
        ResultSet vid=this.conexion.consulta("select Direccion from tblReservacion "
                + "where id= "+idC+"" );
        String d="";
        try{
            while (vid.next()){
                d = vid.getString("Direccion");
            }
        }catch(SQLException e){
            
        }
        return d;
    }
    
    public String getFechaF(int idC){
        ResultSet vid=this.conexion.consulta("select FechaF from tblReservacion "
                + "where id= "+idC+"" );
        String d="";
        try{
            while (vid.next()){
                d = vid.getString("FechaF");
            }
        }catch(SQLException e){
            
        }
        return d;
    }
        
}
