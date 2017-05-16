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
 * @author Danny10
 */
public class Consultas {
    private Conexion conexion;
    
    public Consultas(){
        this.conexion= new Conexion();
        this.conexion.conexion();
    }
    
    public ResultSet rxEntregar(String fecha){
        ResultSet rxE=this.conexion.consulta("select tblUsuario.Nombre, tblCliente.Nombre, tblCliente.Apellido,\n" +
"tblCliente.DPI, tblTelefono.Telefono,\n" +
"tblReservacion.Direccion, tblReservacion.FechaR\n" +
"from tblCliente\n" +
"inner join tblReservacion\n" +
"on tblCliente.id = tblReservacion.tblCliente_id\n" +
"inner join tblUsuario\n" +
"on tblUsuario.id=tblReservacion.tblUsuario_id\n" +
"inner join tblTelefono\n" +
"on tblCliente.id=tblTelefono.tblCliente_id\n" +
"where tblReservacion.Activo=true and FechaR > '"+fecha+"' and FechaF is null  and Anulado=false \n" +
"group by tblReservacion.id\n" +
"order by tblReservacion.FechaR;");
        return rxE;
        
    }
    
    public ResultSet tMercaderia(){
        return this.conexion.consulta("select Nombre,Categoria,Tipo,Material,Color,Tamanio as Tamaño, Cantidad, Reservados, Disponibles, Precio from tblMercaderia\n" +
"inner join tblCategoria\n" +
"on tblMercaderia.tblCategoria_id = tblCategoria.id\n" +
"inner join tblTipo\n" +
"on tblMercaderia.tblTipo_id = tblTipo.id\n" +
"inner join tblMaterial\n" +
"on tblMaterial_id=tblMaterial.id\n" +
"inner join tblColor\n" +
"on tblColor_id=tblColor.id\n" +
"inner join tblTamanio\n" +
"on tblTamanio_id=tblTamanio.id");
    }
    
    
    public ResultSet tCobrar(){
        return this.conexion.consulta("select tblUsuario.Nombre, tblCliente.Nombre, tblCliente.Apellido,\n" +
"tblCliente.DPI, tblTelefono.Telefono,\n" +
"tblReservacion.Direccion, tblReservacion.FechaR, Saldo, Total\n" +
"from tblCliente\n" +
"inner join tblReservacion\n" +
"on tblCliente.id = tblReservacion.tblCliente_id\n" +
"inner join tblUsuario\n" +
"on tblUsuario.id=tblReservacion.tblUsuario_id\n" +
"inner join tblTelefono\n" +
"on tblCliente.id=tblTelefono.tblCliente_id\n" +
"where Total>Saldo and tblReservacion.Anulado = false;");
    }
}
