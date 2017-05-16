/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.JOptionPane;
import modelo.Cliente;

/**
 *
 * @author arch
 */
public class PanelCliente extends javax.swing.JDialog {

    /**
     * Creates new form Cliente
     */
    private int clienteId;
    private String nomCliente;
    private Cliente cliente;
    private java.awt.Frame parent;
    private boolean editar;
    private boolean mensaje;
    public PanelCliente(java.awt.Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.nomCliente="";
        this.cliente= new Cliente();
        this.setTitle(titulo);
        this.parent=parent;
        this.editar=false;
        this.mensaje=true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(226, 226, 226));
        jPanel4.setForeground(new java.awt.Color(1, 1, 1));

        jPanel1.setBackground(new java.awt.Color(226, 226, 226));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setText("Dirección");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setText("Correo");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel5.setText("DPI");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel6.setText("Nit");

        jTextField1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jTextField3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N

        jButton2.setBackground(new java.awt.Color(218, 218, 218));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(218, 218, 218));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(218, 218, 218));
        jButton5.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jButton5.setText("Agregar Teléfono");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(218, 218, 218));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        jButton4.setText("Editar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                    .addComponent(jTextField5)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1)))
                            .addComponent(jButton5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // mensaje para saber si se va a editar o a insertar
        if (this.verficarJtext()==false){
        if(this.editar==false){
        try{ 
        // insertar un nuevo cliente
        int dpi=cliente.verificarDPI(Integer.valueOf(this.jTextField5.getText()));
        if(dpi==-1){
        this.cliente.crearCliente(Integer.valueOf(this.jTextField6.getText()), this.jTextField1.getText()
                , this.jTextField2.getText(), this.jTextField3.getText(), 
                Integer.valueOf(this.jTextField5.getText()), this.jTextField4.getText());
                this.cambiar();
                this.mensaje=false;
                JOptionPane.showMessageDialog(null,"Datos guardados correctamente",
                        "Mensaje!", JOptionPane.INFORMATION_MESSAGE);
        }else{
              String nl= System.getProperty("line.separator");
            // String msj="Error: "+ nl +"Debe de llenar todos los campos";
            String msj = "DPI Ingresado ya existe" ;                   
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
        }
 
        }catch(Exception e){
            String nl= System.getProperty("line.separator");
            // String msj="Error: "+ nl +"Debe de llenar todos los campos";
            String msj = "DPI debe ser un valor entero"
                    +nl+ "Nit debe ser un valor entero"
                    +nl+ "Verifique estos campos";
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
        }
            }else{
            // modificar un cliente 
            try{
                 int dpi=cliente.verificarDPI(Integer.valueOf(this.jTextField5.getText()));
        if(dpi==-1){
            this.cliente.modificarCliente(this.clienteId, Integer.valueOf(this.jTextField6.getText()), this.jTextField1.getText()
                , this.jTextField2.getText(), this.jTextField3.getText(), 
                Integer.valueOf(this.jTextField5.getText()), this.jTextField4.getText());
            this.cambiar();
            this.mensaje=false;
            JOptionPane.showMessageDialog(null,"Datos modificados correctamente",
                        "Mensaje!", JOptionPane.INFORMATION_MESSAGE);
            }else{
              String nl= System.getProperty("line.separator");
            // String msj="Error: "+ nl +"Debe de llenar todos los campos";
            String msj = "DPI Ingresado ya existe" ;                   
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
        }
            }catch(Exception e){
                String nl= System.getProperty("line.separator");
            // String msj="Error: "+ nl +"Debe de llenar todos los campos";
            String msj = "DPI debe ser un valor entero"
                    +nl+ "Nit debe ser un valor entero"
                    +nl+ "Verifique estos campos";
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        }else{
            String nl= System.getProperty("line.separator");
            String msj="Debe de llenar todos los campos";
            JOptionPane.showMessageDialog(null, msj , "Error", JOptionPane.ERROR_MESSAGE);     
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cambiar(){
          this.nomCliente= this.jTextField1.getText() +" "+this.jTextField2.getText();
                this.jTextField1.setEditable(false);
                this.jTextField2.setEditable(false);
                this.jTextField3.setEditable(false);
                this.jTextField4.setEditable(false);
                this.jTextField5.setEditable(false);
                this.jTextField6.setEditable(false);
                this.jButton1.setEnabled(false);
                this.jButton5.setEnabled(true);
                this.jButton2.setEnabled(true);
                this.jButton4.setEnabled(true);
    }
    private boolean verficarJtext(){
        boolean verificar = false;
        String aux = jTextField1.getText().trim(); 
        if (aux.length() == 0)
            verificar = true;
        aux = jTextField2.getText().trim(); 
        if (aux.length() == 0)
            verificar = true;
        aux = jTextField3.getText().trim(); 
        if (aux.length() == 0)
            verificar = true;
        aux = jTextField4.getText().trim(); 
        if (aux.length() == 0)
            verificar = true;
        aux = jTextField5.getText().trim(); 
        if (aux.length() == 0)
            verificar = true;
        aux = jTextField6.getText().trim(); 
        if (aux.length() == 0)
            verificar = true;        
        return verificar;
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (this.mensaje==true){
        String nl= System.getProperty("line.separator");
         int n = JOptionPane.showConfirmDialog(
            null,
            "Datos no guardados se perderan"
            +nl+"Desea ingresar un nuevo cliente",
            "Advertencia",
            JOptionPane.YES_NO_OPTION);
        System.out.println("esto es n "+n);
        if(n == 0){
            this.dispose();
        PanelCliente p= new PanelCliente(parent,true,"Nuevo Cliente");
        p.setVisible(true);
        }    
        }else{
            this.dispose();
        PanelCliente p= new PanelCliente(parent,true,"Nuevo Cliente");
        p.setVisible(true);            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       PanelTelefono tel;
       tel = new PanelTelefono(null,true, true);
       tel.nombreCliente(this.nomCliente);
       tel.setId(this.cliente.clienteMID());
       tel.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.mensaje=true;
        this.clienteId=this.cliente.clienteMID();
        this.editar=true;
        this.jButton4.setEnabled(false);
        this.jButton1.setEnabled(true);
        this.jTextField1.setEditable(true);
        this.jTextField2.setEditable(true);
        this.jTextField3.setEditable(true);
        this.jTextField4.setEditable(true);
        this.jTextField5.setEditable(true);
        this.jTextField6.setEditable(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.salir();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.salir();
    }//GEN-LAST:event_formWindowClosing

    private void salir(){
    if(this.verficarJtext()==true){
        int n = JOptionPane.showConfirmDialog(
             this,
             "Esta seguro de salir \n"+
             "Datos no Guardados se perderan",
             "Salir",
              JOptionPane.YES_NO_OPTION);
                    if (n==0){
                        this.dispose();
                    }
    }else{
        this.dispose();
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
            java.util.logging.Logger.getLogger(PanelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PanelCliente dialog = new PanelCliente(new javax.swing.JFrame(), true,"");
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
