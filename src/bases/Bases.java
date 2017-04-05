/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bases;

import com.sun.javafx.tk.Toolkit;
import controlador.Conexion;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Login;
/**
 *
 * @author arch
 */
public class Bases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
/*        Conexion c= new Conexion();
        c.conexion();
       // c.ejecutar("insert into MyGuests (firstname,lastname) values ('orejas','lobo')");
        ResultSet resultado=c.consulta("select * from MyGuests");
        try{
        while(resultado.next()){
            System.out.println("Nombre: "+resultado.getString("firstname")+" Apellido: "+resultado.getString("lastname"));
        }
        }catch(SQLException e){
            System.out.println("Error en consulta " +e.getMessage());
        }*/
    
     Login p= new Login();
     p.setVisible(true);  
     p.setLocationRelativeTo(null);
    
     //Hola mundo
     

    }
    
}

