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
    private String url = "jdbc:mysql://localhost:3306/bdAlquiler";
    //private String pass = "ServifiestasEstuardO";
    private String pass = "Daniel16";
    private String usr = "root";
    //private String usr = "Alquiler";

    public Connection conexion() {
        System.out.println("hola");
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

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
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
