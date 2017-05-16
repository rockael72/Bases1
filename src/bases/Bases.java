/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bases;

import com.sun.javafx.tk.Toolkit;
import controlador.Conexion;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.Login;
import vista.Principal;
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
 UIManager.put("nimbusBase",  new Color(51,98,140));// sombras menu
UIManager.put("nimbusBlueGrey", new Color(214,217,223)); // barras de menu
 UIManager.put("control", new Color(230,233,236));//(237,238,240)); // frame
 // 247,248,250
    
 // "Nimbus"
  try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}

   Login p= new Login();
  
   p.setVisible(true);  
    p.setLocationRelativeTo(null);
    
     

    }
    
}

