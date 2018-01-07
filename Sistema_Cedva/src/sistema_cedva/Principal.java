/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;


import Modelo.APP_CONTEXTO;
import Mysql.MySqlConnect;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.ColorUIResource;
import javax.swing.*;
/**
 *
 * @author P3DR1TO
 */
public class Principal extends javax.swing.JFrame {

    
    public Principal() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.setLocationRelativeTo(this);
//        loadData("","");

    }

  
   
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabel = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        JPASS = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_ing = new javax.swing.JButton();
        lbl_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(695, 455));
        setMinimumSize(new java.awt.Dimension(695, 455));
        setPreferredSize(new java.awt.Dimension(695, 455));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        jlabel.setText("USUARIO:");
        getContentPane().add(jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        txt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_userActionPerformed(evt);
            }
        });
        getContentPane().add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 160, -1));

        JPASS.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        JPASS.setText("CONTRASEÑA:");
        getContentPane().add(JPASS, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));
        getContentPane().add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 160, -1));

        btn_ing.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 10)); // NOI18N
        btn_ing.setText("INGRESAR");
        btn_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ing, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, -1));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_prin.jpg"))); // NOI18N
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 710, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingActionPerformed
  String sql = "";
  String usuario=txt_user.getText();
 String password=txt_pass.getText();
 if((usuario.isEmpty())||(password.isEmpty()))
 {
 JOptionPane.showMessageDialog(null, "Ingrese su nombre de usuario y contraseña");
 }
 else
 {
MySqlConnect mysqlConnect = new MySqlConnect();
 Statement st;
      try {
          st =mysqlConnect.connect().prepareStatement(sql);
           ResultSet rs = st.executeQuery("SELECT * FROM c_usuario WHERE (LOWER(CL_USER='"+usuario+"')) AND NB_PASSWORD='"+password+"'");
 rs.last();

 int encontrado=rs.getRow();
 System.out.println(String.valueOf(encontrado));
 if(encontrado==1)
 {
// this.setVisible(true);
//// Menu.setVisible(false);
//        this.setFont("Agency FB", Font.BOLD, 14);
        Icon image= new ImageIcon(getClass().getResource("/imagenes/logo_inicio_sin.png"));
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA","",JOptionPane.INFORMATION_MESSAGE,image);
        APP_CONTEXTO.setCL_USER(usuario);
        Menu atras= new Menu();
        atras.setVisible(true);
        atras.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(false);
 }
 else
 {
  txt_user.setText(null);
  txt_pass.setText(null);
 JOptionPane.showMessageDialog(null, "LOS DATOS INGRESADOS SON INCORRECTOS, REINTENTA NUEVAMENTE", "MENSAJE DE ADVERTENCIA",JOptionPane.ERROR_MESSAGE);
 }

 rs.close();
 st.close();
      } catch (SQLException ex) {
          Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
      }

 }
    }//GEN-LAST:event_btn_ingActionPerformed
    
    
    private void txt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_userActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JPASS;
    private javax.swing.JButton btn_ing;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
