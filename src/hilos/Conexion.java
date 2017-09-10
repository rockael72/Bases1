/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author rocka
 */
public class Conexion { 
    private static Connection conexion = null;
    private String url="jdbc:mysql://localhost/bdAlquiler";
    private String pass="123";
    private String usr="root";
    
    public boolean conexion(){
        boolean activo=true;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = (Connection) DriverManager.getConnection(url, usr, pass);
            this.conexion.close();
        }catch(ClassNotFoundException ex){
            //System.out.println(ex.getMessage());            
          activo=false;
        }catch(SQLException sqle){
            //System.out.println(sqle.getMessage());                        
            activo=false;
        }
        return activo;
    

    }
    }
