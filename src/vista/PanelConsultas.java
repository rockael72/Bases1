/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author arch
 */
public class PanelConsultas extends javax.swing.JPanel {

    /**
     * Creates new form Consultas
     */
    public PanelConsultas() {
     initComponents();
     
    }
    
    public void tamanio(Dimension d){
        this.setSize(d);
    }
    
    public int getCantidadFilas(){
        return this.jTable1.getRowCount();
    }
    
    public int getCantidadColumnas(){
        return this.jTable1.getColumnCount();
    }
    public Object getFila(int fila, int columna){
        Object datos=jTable1.getValueAt(fila, columna);
        return datos;
    }
    
    public void generarTabla(ResultSet consulta){
        try{
        if(consulta.isBeforeFirst()==true){        
        this.generarColumna(consulta);
        this.insertarDatosSql(consulta);
        }else{
            String nl= System.getProperty("line.separator");
            String msj="No se encontraron datos almacenados";
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);  
        }
        }catch(SQLException ex){
            
        }
        
    }
    
    private void generarColumna(ResultSet consulta){        
        try{
        ResultSetMetaData meta = consulta.getMetaData();
        String columnas[] = new String[meta.getColumnCount()+1];
        columnas[0] = "#";
        for (int i= 1; i<meta.getColumnCount()+1; i++){
            columnas[i]=meta.getColumnName(i);
        }
        this.crearColumnas(columnas);
        }catch(SQLException ex){
            System.err.println("conslta mal construida");
        }
        
    }
    
    
    private void insertarDatosSql(ResultSet consulta){
        try{        
        ResultSetMetaData rsmd = consulta.getMetaData();
        int nColumnas = rsmd.getColumnCount();
        Object datos[] = new Object[nColumnas+1];
        int cont =1;
        while (consulta.next()){
            datos[0]=cont;
            for (int i=0; i<nColumnas ;i++){
                datos[i+1] = consulta.getObject(i+1);
            }
            this.insertarDatos(datos);
            cont++;
        }
        
        }catch(SQLException ex){
            System.out.println("error: "+ex);
        }        
    }
    
    public void eliminar(){
        DefaultTableModel model = (DefaultTableModel) this.jTable1.getModel();
        int[] rows = jTable1.getSelectedRows();
   for(int i=0;i<rows.length;i++){
     model.removeRow(rows[i]-i);
   }
    }
    
    public void insertarDatos(Object[] fila){
        for(int i = 0; i<fila.length;i++){
        }
        DefaultTableModel miTableModel = (DefaultTableModel)jTable1.getModel();
          miTableModel.addRow(fila);
          this.resizeColumnWidth(this.jTable1);
    }
    
    public void crearColumnas(Object[] columna){
        DefaultTableModel dtm= new DefaultTableModel(null, columna){        
    @Override
    public boolean isCellEditable (int fila, int columna) {
        return false;
    }
    };
      this.jTable1.setModel(dtm);    
      this.jTable1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF ); 
      this.jTable1.setLayout(new BorderLayout()); 
    }
    
    private void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    int width; // Min width
    for (int column = 0; column < table.getColumnCount(); column++) { 
        width = table.getColumnName(column).length()*7;
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
            
        }                                      
        columnModel.getColumn(column).setPreferredWidth(width + 25);
    }
   
}
    
    public void deshabilitar(){
        this.jTable1.setEnabled(false);
    }

    public Object[] getSelect(){
        int row = this.jTable1.getSelectedRow();
        Object datos[]=null;
        if(row != -1){
         datos= new Object[this.jTable1.getColumnCount()];
            for (int i = 0; i < jTable1.getColumnCount(); i++) {
                datos[i]=jTable1.getValueAt(row, i);                
            }
        }
            return datos;            
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(205, 205, 205));
        setAutoscrolls(true);
        setMaximumSize(new java.awt.Dimension(0, 0));

        jTable1.setBackground(new java.awt.Color(254, 254, 254));
        jTable1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
    }// </editor-fold>//GEN-END:initComponents
                                    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
