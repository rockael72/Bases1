/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author arch
 */
public class Procedimientos {
    private Conexion conexion;
    
    public Procedimientos(){
        this.conexion = new Conexion();
        this.conexion.conexion();
    }
    
    public ResultSet getProcedimiento(String nombreProcedimiento){
         ResultSet procedimiento = this.conexion.consulta
                            ("call "+ nombreProcedimiento+"()");
         return procedimiento;
    }
    
    
}
