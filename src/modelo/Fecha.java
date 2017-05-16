/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Principal;

/**
 *
 * @author Danny10
 */
public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    private String actual;
    private String guardarFecha;
    
    public Fecha(String actual){
        this.actual=actual;
        this.guardarFecha=actual;
        this.fechaActual(actual);        
    }
    
    public void setActual(){
        this.actual=this.guardarFecha;
    }
    
    public String getActual(){
        return this.guardarFecha;
    }
    
    public void setFecha(String fecha){
        this.actual=fecha;
    }
    
     public String girarFecha(String fecha) {
        String[] fecha2 = {"", "", ""};
        int cont = 0;
        for (int i = 0; i < fecha.length(); i++) {

            if (fecha.charAt(i) != '/') {
                fecha2[cont] += fecha.charAt(i);
            } else {
                cont++;
            }
        }
        fecha = fecha2[2] + "/" + fecha2[1] + "/" + fecha2[0];
        return fecha;
    }
    
    private void fechaActual(String fecha) {
        String[] fecha2 = {"", "", ""};
        int cont = 0;
        for (int i = 0; i < fecha.length(); i++) {

            if (fecha.charAt(i) != '/') {
                fecha2[cont] += fecha.charAt(i);
            } else {
                cont++;
            }
        }        
        this.anio=Integer.valueOf(fecha2[2].toString());
        this.mes=Integer.valueOf(fecha2[1].toString());
        this.dia=Integer.valueOf(fecha2[0].toString());
    }
    
    public String fechaMenos(){
        String fecha="";        
        switch (mes) {
            case 1:  mes=1;
                     if(dia-1==0){
                         dia=31;
                         mes=12;                         
                         anio--;
                     }else{
                         dia--;
                     }
                     
                     break;
            case 2:  mes=2;
                    if(dia-1==0){
                         dia=31;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 3:  mes=3;
                    if(dia-1==0){
                         dia=28;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 4:  mes=4;
                    if(dia-1==0){
                         dia=31;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 5:  mes=5;
                    if(dia-1==0){
                         dia=30;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 6:  mes=6;
                    if(dia-1==0){
                         dia=31;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 7:  mes=7;
                    if(dia-1==0){
                         dia=30;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 8:  mes=8;
                    if(dia-1==0){
                         dia=31;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 9:  mes=9;
                    if(dia-1==0){
                         dia=31;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 10: mes=10;
                    if(dia-1==0){
                         dia=30;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 11: mes=11;
                    if(dia-1==0){
                         dia=31;
                         mes--;                         
                     }else{
                         dia--;
                     }
                     break;
            case 12: mes=12;
                    if(dia-1==0){
                         dia=30;
                         mes--;                                                  
                     }else{
                         dia--;
                     }
                     break;
            
        }       
       fecha= dia+"/"+mes+"/"+anio;
    return fecha;
    }
    
    public String fechaMas(){
        String fecha="";        
        switch (mes) {
            case 1:  mes=1;
                     if(dia+1==32){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     
                     break;
            case 2:  mes=2;
                    if(dia+1==29){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 3:  mes=3;
                    if(dia+1==32){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 4:  mes=4;
                    if(dia+1==31){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 5:  mes=5;
                    if(dia+1==32){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 6:  mes=6;
                    if(dia+1==31){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 7:  mes=7;
                    if(dia+1==32){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 8:  mes=8;
                    if(dia+1==32){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 9:  mes=9;
                    if(dia+1==31){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 10: mes=10;
                    if(dia+1==32){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 11: mes=11;
                    if(dia+1==31){
                         dia=1;
                         mes++;                         
                     }else{
                         dia++;
                     }
                     break;
            case 12: mes=12;
                    if(dia+1==32){
                         dia=1;
                         mes=1;                         
                         anio++;
                     }else{
                         dia++;
                     }
                     break;
            
        }       
       fecha= dia+"/"+mes+"/"+anio;
    return fecha;
    }
    
    public String mesMas(){
        if(this.mes+1==13){
            this.mes=1;
            this.anio++;
        }else
        this.mes++;
        
       String fecha= dia+"/"+mes+"/"+anio;
    return fecha;
    }
    
    public String mesMenos(){
        if(this.mes-1==0){
            this.mes=12;
            this.anio--;
        }else
        this.mes--;
        
       String fecha= dia+"/"+mes+"/"+anio;
    return fecha;
    }
    
    public String anioMas(){
        this.anio++;
        String fecha= dia+"/"+mes+"/"+anio;
    return fecha;
    }
    
    public String anioMenos(){
        this.anio--;
        String fecha= dia+"/"+mes+"/"+anio;
    return fecha;
    }
    
    
    public Date retornaDate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = (Date) formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    public Calendar retornaCalendar(String fecha){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            cal.setTime(sdf.parse(fecha));
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cal;
    }
    
    
}
