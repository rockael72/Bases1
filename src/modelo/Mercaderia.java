/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import archivo.ArchivoTexto;
import controlador.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arch
 */
public class Mercaderia {
    private ArchivoTexto archivo;
    private Conexion conexion;
    
    public Mercaderia(){
        this.archivo= new ArchivoTexto();
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public void iniciarTransaccion(){        
        this.conexion.transaccion();
    }
    
    public void verificar(int idT){
        this.conexion.verificar();
    }
    
    public void commit(){
        this.conexion.commit();
    }
    
    public void rollback(){
        this.conexion.rollback();
    }
    
    public void insertar(String nombre, float precio, int categoria, int tipo, int material, int color, int tamanio){
        this.conexion.ejecutar("insert into tblMercaderia(Nombre,Precio, tblCategoria_id, tblTipo_id, tblMaterial_id, tblColor_id, tblTamanio_id)"
                + "values "
                + "('"+nombre+"','"+precio+"',"+categoria+","+tipo+","+material+","+color+","+tamanio+")");        
    }
    
    public void insertarT(String nombre, float precio, int categoria, int tipo, int material, int color, int tamanio){
        String insertar ="insert into tblMercaderia(Nombre,Precio, tblCategoria_id, tblTipo_id, tblMaterial_id, tblColor_id, tblTamanio_id)"
                + "values "
                + "('"+nombre+"','"+precio+"',"+categoria+","+tipo+","+material+","+color+","+tamanio+")";
            this.conexion.enTransaccion(insertar);                             
            this.archivo.insertar("    "+insertar);
            
    }
    
    public void terminarT(){
        this.conexion.ejecutar("rollback");
    }
    
    
    
    public ResultSet getMercaderia(String nombre){
        ResultSet mercaderia = this.conexion.consulta("call producto('"+nombre+"')");
        return mercaderia;
    }
    
    public ResultSet getMercadriaP(String nombre){
        ResultSet mercaderia = this.conexion.consulta("call productoPrecio('"+nombre+"')");
        return mercaderia;
    }
    
    public int getId(String nombre, int cat, int tip, int mat, int col, int tam){
        ResultSet mercaderia = this.conexion.consulta("select id from tblMercaderia "
                + "where Nombre='"+nombre+"' and tblCategoria_id="+cat+" and tblTipo_id="+tip+" "
                + "and tblMaterial_id = "+mat+" and tblColor_id="+col+" and tblTamanio_id = "+tam+ "");
        int id =-1;
        try{
             while(mercaderia.next()){
                 id = Integer.valueOf(mercaderia.getString("id"));
             }
        }catch(SQLException ex){
            
        }
        return id;
    }
    
     public void cambiar(int op){
        switch  (op){
            case 1:
        conexion.ejecutar("set global transaction isolation level read uncommitted");
        break;
        case 2:
        conexion.ejecutar("set global transaction isolation level read committed");
        break;
        case 3:
        conexion.ejecutar("set global transaction isolation level repeatable read");
        break;
        case 4:
        conexion.ejecutar("set global transaction isolation level serializable");
        break;        
        }
    }

}
