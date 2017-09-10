/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author arch
 */
public class Conexion {

    private static Connection conexion = null;
    private String url = "jdbc:mysql://localhost/bdAlquiler";
    //private String url = "jdbc:mysql://localhost:3306/bdAlquiler";
    //private String pass = "ServifiestasEstuardO";
 //   private String pass = "Daniel16";
    //private String usr = "root";
    private String pass = "123";
    private String usr = "root";
    private Statement sentencia;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = (Connection) DriverManager.getConnection(url, usr, pass);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return this.conexion;
    }
    
    public boolean verificar(){                           
        if (this.conexion()!=null){
            System.out.println("se ha conectado");
            return true;
            
        }else{
            System.out.println("se ha desconectado");
            return false;
        }                
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void transaccion(){
       try{
        this.sentencia = this.conexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        this.enTransaccion("start transaction;");        
        }catch(SQLException e){
            
        }
    }
    
    public void rollback(){
        try{        
        this.enTransaccion("rollback");      
        this.sentencia.close();
        }catch(SQLException e){            
        }
        
    }
    
    public void commit(){
        try{        
        this.enTransaccion("commit");      
        this.sentencia.close();
        }catch(SQLException e){
            
        }
    }
    
    public boolean enTransaccion(String sql){
        try{            
            this.sentencia.executeUpdate(sql);                    
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    

    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = this.conexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet consulta(String sql) {
        ResultSet resultado = null;
        try {
            Statement sentencia = this.getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultado;
    }
}
