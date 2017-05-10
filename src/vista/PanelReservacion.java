/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.CColor;
import modelo.Categoria;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.DetalleAlquiler;
import modelo.Material;
import modelo.Mercaderia;
import modelo.Tamanio;
import modelo.Proveedores;
import modelo.Reservacion;
import modelo.Tipo;


/**
 *
 * @author arch
 */
public class PanelReservacion extends javax.swing.JDialog {

    /**
     * Creates new form PanelReservacion
     */
    private Categoria c;
private        Tipo t;
private        Material m ;
private        CColor co ;
private        Tamanio tm;
private DetalleAlquiler dc;
    private Cliente cliente;
    private Mercaderia mercaderia;
    private Ciudad ciudad;
    private Reservacion reservacion;
    private PanelConsultas pcliente; // panel para mostrar al cliente
    private PanelConsultas preservacion; // panel para mostrar reservacion
    private PanelConsultas pmercaderia;  // panel consulta de mercaderia 
    private java.awt.Frame parent;
    private Object datos[];
    private Object total2[];
    private int cont;
    private int usr;
    private int existencia;
    public PanelReservacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.dc= new DetalleAlquiler();
        this.c= new Categoria(); 
        this.t = new Tipo();
        this.m = new Material();
        this.co = new CColor();
        this.tm= new Tamanio();
        this.existencia=0;
        this.cliente= new Cliente();
        this.ciudad= new Ciudad();
        this.mercaderia=new Mercaderia();
        this.setLocationRelativeTo(null);
        this.reservacion= new Reservacion();
        this.parent=parent;
        this.pcliente= new PanelConsultas();
        this.preservacion=new PanelConsultas();
        this.pmercaderia= new PanelConsultas();
        this.jPanel2.setLayout(new BorderLayout());
       this.jPanel2.add(this.pcliente);
       this.jPanel4.setLayout(new BorderLayout());
       this.jPanel4.add(this.pmercaderia);
       this.jPanel5.setLayout(new BorderLayout());
       this.jPanel5.add(this.preservacion);
       this.boxCiudad();
       this.detalleReservacion();
       this.cont=1;
       this.usr=0;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "DPI" }));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1)
                .addComponent(jButton2))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Cliente"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Reservación"));

        jLabel1.setText("Fecha R");

        jLabel2.setText("Direccion");

        jComboBox2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBox2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ciudad");

        dateChooserCombo1.setAutoScroll(false);
        dateChooserCombo1.setCalendarBackground(new java.awt.Color(254, 254, 254));
        dateChooserCombo1.setFormat(2);
        dateChooserCombo1.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        try {
            dateChooserCombo1.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2017, 4, 4),
                new java.util.GregorianCalendar(2017, 4, 4))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    dateChooserCombo1.setFieldFont(new java.awt.Font("Comic Sans MS", java.awt.Font.PLAIN, 14));

    jButton6.setText("Aceptar");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2)
                .addComponent(jLabel3)
                .addComponent(jLabel1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton6))
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(18, 18, 18))
    );

    jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Mercaderia"));

    jLabel4.setText("Buscar");

    jButton3.setText("Buscar");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    jButton7.setText("Agregar");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton7ActionPerformed(evt);
        }
    });

    jLabel5.setText("Cantidad");

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jLabel4)
                    .addGap(31, 31, 31))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGap(39, 39, 39))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addComponent(jButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton7)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda"));
    jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
        public void mouseMoved(java.awt.event.MouseEvent evt) {
            jPanel4MouseMoved(evt);
        }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 389, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Reservación"));

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 116, Short.MAX_VALUE)
    );

    jButton8.setText("Eliminar");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton8ActionPerformed(evt);
        }
    });

    jButton4.setText("Deposito");
    jButton4.setEnabled(false);
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    jButton5.setText("Cancelar");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });

    jButton9.setText("Nuevo");

    jButton10.setText("Salir");

    jLabel6.setText("Total");

    jLabel7.setText("jLabel7");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6)
            .addGap(18, 18, 18)
            .addComponent(jLabel7)
            .addGap(20, 20, 20))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton9)
                .addComponent(jButton4)
                .addComponent(jButton8)
                .addComponent(jLabel6)
                .addComponent(jButton5)
                .addComponent(jButton10)
                .addComponent(jLabel7))
            .addGap(2, 2, 2))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detalleReservacion(){
     Object[] columnas = {"#","Nombre","Categoria",
         "Tipo","Material","Color","Tamaño","Cantidad","Precio"};  
     this.preservacion.crearColumnas(columnas);
     this.jPanel5.add(this.preservacion);
     this.preservacion.setVisible(true);
    }
    
    public void setUsr(int usr){
        this.usr=usr;
    }
    
     private void boxCiudad(){       
        ResultSet eti = this.ciudad.getAll();
         try{       
        while(eti.next()){
            this.jComboBox2.addItem(eti.getString("Ciudad"));            
        }
        this.jComboBox2.addItem("Nuevo ...");
        }catch(SQLException e){
            System.out.println("Error en consulta " +e.getMessage());
        }
    }
     
       private boolean verificarMercaderia(){
        boolean verificar = false;
        String aux = jTextField4.getText().trim(); 
        if (aux.length() == 0)
            verificar = true;
  
        return verificar;
        
    }
    
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
     
            String aux = jTextField3.getText().trim();
        if (aux.length() > 0){
            this.pmercaderia.generarTabla(this.mercaderia.getMercadriaP(this.jTextField3.getText()));            
            this.pmercaderia.setVisible(true);
        }else{
            String msj="Debe ingresar nombre de un artículo";
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(this.verificarMercaderia()==false){
             int cantidad=0;
            try{
                cantidad = Integer.parseInt(this.jTextField4.getText());
               }catch(Exception e){
                String msj="Canitdad debe ser un valor numéricos";
                JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
            }
                if(cantidad<=this.existencia){
               Object[] total = new Object[this.datos.length];               
               System.arraycopy(this.datos, 0,total, 0, this.datos.length);                                                              
               total[8]=total[10];
               total[7]=cantidad;// canitdad = a precio
               total2 = new Object[this.datos.length];                                              
               System.arraycopy(total, 0,total2, 0, this.datos.length-1);                                                                                 
               //total2[this.datos.length-1]=cantidad;                          
               total2[0]=this.cont;
                this.preservacion.insertarDatos(total2);
                this.cont++;
                
                this.insertarDetalle();
                this.pmercaderia.generarTabla(this.mercaderia.getMercadriaP(this.jTextField3.getText()));            
                this.pmercaderia.setVisible(true);
                this.jTextField4.setText("");
                }else{
                    String msj="Solo hay "+ this.existencia +" en inventario";
                JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            
        }else{
            String msj="Debe ingresar Cantidad y Precio Compra";
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseMoved
        // TODO add your handling code here:
        if(this.pmercaderia.getSelect()!=null){
            this.datos = this.pmercaderia.getSelect();
/*            for (int i=0;i < this.datos.length; i++)
                System.out.println(" "+i+" "+this.datos[i]);*/
            this.existencia=Integer.valueOf(this.datos[9].toString());
            
        }
    }//GEN-LAST:event_jPanel4MouseMoved

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Object[] seleccion=this.preservacion.getSelect();

            String nombre = seleccion[1].toString();
            int cat = this.c.getId(seleccion[2].toString());
            int tip = this.t.getId(seleccion[3].toString());
            int mat = this.m.getId(seleccion[4].toString());
            int col = this.co.getId(seleccion[5].toString());
            int tam = this.tm.getId(seleccion[6].toString());
            int cant= Integer.parseInt(seleccion[7].toString());
            float pc = Float.parseFloat(seleccion[8].toString());            
            int idm = this.mercaderia.getId(nombre, cat, tip, mat, col, tam);                     
        this.dc.eliminar(this.reservacion.getMaxid(), idm, pc,cant);
        this.preservacion.eliminar();
         this.pmercaderia.generarTabla(this.mercaderia.getMercadriaP(this.jTextField3.getText()));            
                this.pmercaderia.setVisible(true);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_jButton4ActionPerformed

    private String girarFecha(String fecha){
        String[] fecha2= {"","",""};
        int cont=0;
        for(int i=0;i<fecha.length(); i++){
        
            if(fecha.charAt(i)!='/'){
            fecha2[cont]+=fecha.charAt(i);
            }else{
                cont++;
            }
        }    
        fecha=fecha2[2]+"/"+fecha2[1]+"/"+fecha2[0];  
        return fecha;
        
    }
    
    private void insertarDetalle(){                   
        int idr = reservacion.getMaxid();    //id reservacion
        int idm = 0;
        float total=0;
            String nombre = this.total2[1].toString();
            String cat = this.total2[2].toString();
            String tip = this.total2[3].toString();
            String mat = this.total2[4].toString();
            String col = this.total2[5].toString();
            String tam = this.total2[6].toString();            
            int cant= Integer.parseInt(this.total2[7].toString());
            float pc = Float.parseFloat(this.total2[8].toString());
            System.out.println(cant + " "+ pc+" "+this.total2[8].toString()+" "+this.total2.length);
            idm = this.mercaderia.getId(nombre, c.getId(cat),t.getId(tip),m.getId(mat), co.getId(col), tm.getId(tam));            
            // inserta en tabla detalle id reservacion id mercaderia precio y cantidad            
            this.dc.insertar(idr, idm, pc, cant);
        
    
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int sel = this.jComboBox1.getSelectedIndex();
        if (sel==0){            
            this.pcliente.generarTabla(this.cliente.bid(Integer.valueOf(this.jTextField1.getText())));
        }
        if(sel==1){
            this.pcliente.generarTabla(this.cliente.bdpi(Integer.valueOf(this.jTextField1.getText())));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new PanelCliente(this.parent,true,"Nuevo Cliente").setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBox2PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        int id = this.jComboBox2.getSelectedIndex();
        String item = this.jComboBox2.getItemAt(id);
        if(item=="Nuevo ..."){
            String categoria=this.mostarMensaje("Ciudad");
            if(categoria != null){
                this.ciudad.setCuidad(categoria);
                this.jComboBox2.removeAllItems();
                this.boxCiudad();
            }
        }
    }//GEN-LAST:event_jComboBox2PopupMenuWillBecomeInvisible

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         String fecha = this.girarFecha(this.dateChooserCombo1.getText());                                              
       
       int idcliente = (this.cliente.getId(Integer.valueOf(this.pcliente.getFila(0, 4).toString()))); //busca por DPI
         
      int index=this.jComboBox2.getSelectedIndex();
        String ci = this.jComboBox2.getItemAt(index);       
        this.reservacion.insertar(fecha, this.jTextField2.getText(), idcliente, this.ciudad.getId(ci),this.usr);    
        
    }//GEN-LAST:event_jButton6ActionPerformed

        private String mostarMensaje(String mensaje){
        String name = JOptionPane.showInputDialog(this.parent, "Ingese "+mensaje);
        if((name != null)&&(name.length()!=0)){
            return name;
        }else{
        return null;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelReservacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PanelReservacion dialog = new PanelReservacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
