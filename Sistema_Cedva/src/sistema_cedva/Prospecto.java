/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

/**
 *
 * @author P3DR1TO
 */

import Modelo.E_PROSPECTO;
import Mysql.MySqlConnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Prospecto extends javax.swing.JFrame {

    ArrayList<E_PROSPECTO> prospecto= new ArrayList<E_PROSPECTO>();
    int ID_PROSPECTO =0;
    Date thisDate= new Date();
    SimpleDateFormat dateform = new SimpleDateFormat("MMMM-dd-Y");
    SimpleDateFormat fechaguardar = new SimpleDateFormat("Y-M-dd");
    //fechaclave
    SimpleDateFormat nuevafecha = new SimpleDateFormat("MMMMddY");
    SimpleDateFormat fechanueva = new SimpleDateFormat("YMdd");
    String clave="PROS";
    
    public Prospecto(int ID_PROSPECTO)
    {
        initComponents();
        this.setLocationRelativeTo(null);   
      
    }
    
//    public static  ArrayList<String> llenar_combo(){
//     MySqlConnect mysqlConnect = new MySqlConnect();
//     ArrayList<String> lista= new ArrayList<String>();
//     String sql= "Select * from  c_carrera";
//     
////     try{
//////         st = mysqlConnect.connect().createStatement();
////         rs = st.executeQuery(sql);
////     }
////     catch(Exception e){
////     }
////        try {
////            while(rs.next()) { 
////        lista.add(rs.getString("NB_CARRERA"));
////        }
////        } catch (Exception e) {
////        }
////     return lista;
//    }

    
    public Prospecto() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(null);
        this.selec_carrint.removeAllItems();
        MySqlConnect mysqlConnect = new MySqlConnect();
         Statement st;
        try {
            st = mysqlConnect.connect().createStatement();
            
            String sql = "SELECT * FROM c_carrera";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) { 
             this.selec_carrint.addItem(rs.getString("NB_CARRERA"));
        }} catch (Exception e) {
        }
        
//        ArrayList<String> lista= new ArrayList<String>();
//        lista = llenar_combo();
//        for(int i=0;i<lista.size();i++){ 
//        txt_carrint.addItem(lista.get(i));}
        txt_fecha.setText(dateform.format(thisDate));
        txtfe_bd.setText(fechaguardar.format(thisDate));
        txt_dato.setText(fechanueva.format(thisDate));
//                                            MySqlConnect mysqlConnect = new MySqlConnect();
//                                       Statement st;
        try {
            st = mysqlConnect.connect().createStatement();

String sql = "SELECT * FROM c_prospecto";
ResultSet rs = st.executeQuery(sql);
while(rs.next()) { 
 int idProspecto = rs.getInt("ID_PROSPECTO"); 
 String clProspecto = rs.getString("CL_PROSPECTO");
 String nbNombre = rs.getString("NB_NOMBRE");
 String nbPaterno = rs.getString("NB_PATERNO");
 String nbMaterno = rs.getString("NB_MATERNO");
 String clColonia = rs.getString("CL_COLONIA_MUNICIPIO");
 String feTramite = rs.getString("FE_TRAMITE");
 String clTelefonoCasa = rs.getString("CL_TELEFONO_CASA"); 
 String clTelefonoCel = rs.getString("CL_TELEFONO_CEL"); 
 String clEmail = rs.getString("CL_EMAIL");
 String clMedioPromo = rs.getString("CL_MEDIO_PROMO");
 String clCarrera = rs.getString("CL_CARRERA");
 String dsSeguimiento = rs.getString("DS_SEGUIMIENTO");
 boolean fgInscrito = rs.getBoolean("FG_INSCRITO");
 String nbAtendio = rs.getString("NB_ATENDIO");
 prospecto.add(new E_PROSPECTO(idProspecto,clProspecto, nbNombre, nbPaterno, nbMaterno,clColonia, feTramite, clTelefonoCasa, clTelefonoCel, clEmail, clMedioPromo, clCarrera, dsSeguimiento, fgInscrito, (fgInscrito)?"Si":"No", nbAtendio));

 
}
        } catch (SQLException ex) {
            Logger.getLogger(Prospecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();

    }
    
    
    public void setDatos(String nb, String apeP,String apeM, String col, String fec, String telc, 
                         String cel, String mail, String med, String carr, String seg, Boolean ins, String atd)
    {
    txt_nom.setText(nb);    
    txt_ap_paterno.setText(apeP);
    txt_ap_materno.setText(apeM);
    txt_col.setText(col);
    txt_fecha.setText(fec);
    txt_tksa.setText(telc);
    txt_tcel.setText(cel);
    txt_correo.setText(mail);
    txt_mediop.setText(med);
    selec_carrint.setSelectedItem(carr);
    txt_seguimiento.setText(seg);
    insc_si.setSelected(ins);
    txt_atendio.setText(atd);
    
    }
        public void setIdProspecto(int pIdProspecto)
    {
        this.ID_PROSPECTO=pIdProspecto;
    }
        
        public void setEditProspecto(int pIdProspecto)
    {
        this.ID_PROSPECTO=pIdProspecto;
//        for (E_PROSPECTO e_prospecto : prospecto) {
//            if(e_prospecto.getID_PROSPECTO() ==pIdProspecto)
//            {
//              ape_pa.setText(e_prospecto.getCL_PROSPECTO());
//            }
//        }
        
    }
    
    public void clear(){
            txt_nom.setText(null);
            txt_ap_paterno.setText(null);
            txt_ap_materno.setText(null);
            txt_col.setText(null);
            txt_tksa.setText(null);
            txt_tcel.setText(null);
            txt_correo.setText(null);
            txt_mediop.setText(null);
            txt_atendio.setText(null);
            txt_seguimiento.setText(null);
            insc_si.setSelected(false);
            selec_carrint.setSelectedItem(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fecha = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        nom = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        ape_pa = new javax.swing.JLabel();
        txt_ap_paterno = new javax.swing.JTextField();
        ape_ma = new javax.swing.JLabel();
        txt_ap_materno = new javax.swing.JTextField();
        col = new javax.swing.JLabel();
        txt_col = new javax.swing.JTextField();
        telksa = new javax.swing.JLabel();
        txt_tksa = new javax.swing.JTextField();
        telcel = new javax.swing.JLabel();
        txt_tcel = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        medio = new javax.swing.JLabel();
        txt_mediop = new javax.swing.JTextField();
        carrera = new javax.swing.JLabel();
        selec_carrint = new javax.swing.JComboBox<>();
        seguimiento = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_reg = new javax.swing.JButton();
        insc = new javax.swing.JLabel();
        atendio = new javax.swing.JLabel();
        txt_atendio = new javax.swing.JTextField();
        insc_si = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_seguimiento = new javax.swing.JTextArea();
        lbl_fondo = new javax.swing.JLabel();
        txt_dato = new javax.swing.JTextField();
        txtfe_bd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fecha.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        fecha.setText("Fecha:");
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        txt_fecha.setEditable(false);
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 140, -1));

        nom.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        nom.setText("*Nombre(S):");
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, 20));
        getContentPane().add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 400, -1));

        ape_pa.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        ape_pa.setText("*a. paterno:");
        getContentPane().add(ape_pa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txt_ap_paterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ap_paternoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_ap_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 120, 150, -1));

        ape_ma.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        ape_ma.setText("A. MATERNO:");
        ape_ma.setMaximumSize(new java.awt.Dimension(142, 17));
        ape_ma.setMinimumSize(new java.awt.Dimension(142, 17));
        getContentPane().add(ape_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));
        getContentPane().add(txt_ap_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 140, -1));

        col.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        col.setText("Colonia:");
        getContentPane().add(col, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        getContentPane().add(txt_col, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 420, -1));

        telksa.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        telksa.setText("Tel. Casa:");
        getContentPane().add(telksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));

        txt_tksa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tksaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_tksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 140, -1));

        telcel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        telcel.setText("Tel. Celular:");
        getContentPane().add(telcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        getContentPane().add(txt_tcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 160, -1));

        correo.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        correo.setText("correo electronico:");
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 330, -1));

        medio.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        medio.setText("Medio por el cual se entero:");
        getContentPane().add(medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        getContentPane().add(txt_mediop, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 270, -1));

        carrera.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        carrera.setText("carrera de interes:");
        getContentPane().add(carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        selec_carrint.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2" }));
        selec_carrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selec_carrintActionPerformed(evt);
            }
        });
        getContentPane().add(selec_carrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 330, -1));

        seguimiento.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        seguimiento.setText("Seguimiento:");
        getContentPane().add(seguimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 10));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.jpg"))); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 80, 80));

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.jpg"))); // NOI18N
        btn_editar.setMaximumSize(new java.awt.Dimension(109, 85));
        btn_editar.setMinimumSize(new java.awt.Dimension(109, 85));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 80, 80));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.jpg"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 80, -1));

        txt_reg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_reg.setText("Regresar");
        txt_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_regActionPerformed(evt);
            }
        });
        getContentPane().add(txt_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        insc.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        insc.setText("INSCRITO:");
        getContentPane().add(insc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        atendio.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        atendio.setText("*ATENDIO:");
        getContentPane().add(atendio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));
        getContentPane().add(txt_atendio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 250, -1));

        insc_si.setText("SI");
        getContentPane().add(insc_si, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        txt_seguimiento.setColumns(20);
        txt_seguimiento.setRows(5);
        jScrollPane1.setViewportView(txt_seguimiento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 400, 70));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo2.jpg"))); // NOI18N
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));
        getContentPane().add(txt_dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 100, -1));
        getContentPane().add(txtfe_bd, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tksaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tksaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tksaActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Buscar_Prospectos1 pframe= new Buscar_Prospectos1(this);
        pframe.setVisible(true);
        pframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_regActionPerformed
        Menu regresar= new Menu();
//        regresar.setVisible(true);
        regresar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_txt_regActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
       // this.setText(fecha);
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        Menu m= new Menu();
               m.setLocationRelativeTo(null);
                m.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void txt_ap_paternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ap_paternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ap_paternoActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (txt_nom.getText().equals("") || txt_ap_paterno.getText().equals("") || txt_atendio.getText().equals("")
                )
            {    JOptionPane.showMessageDialog(rootPane, "Debes llenar los campos requeridos (*)", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if(!txt_nom.getText().equals("")&& !txt_ap_paterno.getText().equals("") && !txt_atendio.getText().equals("")
               && ID_PROSPECTO==0){
                
        try {

            String cadena1=txt_nom.getText();
            char letra1=cadena1.charAt(0);
            String cadena2=txt_ap_paterno.getText();
            char letra2=cadena2.charAt(0);
            String cadena3=txt_ap_materno.getText();
            char letra3=cadena3.charAt(0);
           
            
            String query = " insert into c_prospecto (CL_PROSPECTO, NB_NOMBRE, NB_PATERNO, "
                    + "NB_MATERNO, CL_COLONIA_MUNICIPIO, FE_TRAMITE, CL_TELEFONO_CASA, CL_TELEFONO_CEL, CL_EMAIL, CL_MEDIO_PROMO, "
                    + "CL_CARRERA, DS_SEGUIMIENTO, FG_INSCRITO, NB_ATENDIO)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            MySqlConnect mysqlConnect = new MySqlConnect();
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setString (1, clave+""+txt_dato.getText()+""+letra1+""+letra2+""+letra3);
            preparedStmt.setString (2, txt_nom.getText());
            preparedStmt.setString (3, txt_ap_paterno.getText());
            preparedStmt.setString (4, txt_ap_materno.getText());
            preparedStmt.setString (5, txt_col.getText());
            preparedStmt.setString (6, txtfe_bd.getText());
            preparedStmt.setString (7, txt_tksa.getText());
            preparedStmt.setString (8, txt_tcel.getText());
            preparedStmt.setString (9, txt_correo.getText());
            preparedStmt.setString (10, txt_mediop.getText());
            preparedStmt.setString (11, selec_carrint.getSelectedItem().toString());
            preparedStmt.setString (12, txt_seguimiento.getText());
            preparedStmt.setBoolean(13, insc_si.isSelected());
            preparedStmt.setString (14, txt_atendio.getText());
            
            // execute the preparedstatement
            preparedStmt.execute();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/correcto_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, "Se agrego Alumno","",JOptionPane.INFORMATION_MESSAGE,image);
            clear();
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Ocurrio un problema al agregar Prospecto");
            Logger.getLogger(Prospecto.class.getName()).log(Level.SEVERE, null, ex);
        }
          }
        else 
        {
             JOptionPane.showMessageDialog(rootPane, "No puedes agregar un Prospecto ya existente", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        
        if (txt_nom.getText().equals("") || txt_ap_paterno.getText().equals("")
                || txt_atendio.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Busca un Prospecto para editar", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if(ID_PROSPECTO!=0){
        try {
            // agregar
            // the mysql insert statement
            String query = "update  c_prospecto set NB_NOMBRE = ?, NB_PATERNO = ?, "
                    + "NB_MATERNO = ?, CL_COLONIA_MUNICIPIO = ?, CL_TELEFONO_CASA = ?, "
                    + "CL_TELEFONO_CEL = ?, CL_EMAIL = ?, CL_MEDIO_PROMO = ?, "
                    + "CL_CARRERA = ?, DS_SEGUIMIENTO = ?, FG_INSCRITO = ?, "
                    + "NB_ATENDIO = ? WHERE ID_PROSPECTO =?";
            
            MySqlConnect mysqlConnect = new MySqlConnect();
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setString (1, txt_nom.getText());
            preparedStmt.setString (2, txt_ap_paterno.getText());
            preparedStmt.setString (3, txt_ap_materno.getText());
            preparedStmt.setString (4, txt_col.getText());
            preparedStmt.setString (5, txt_tksa.getText());
            preparedStmt.setString (6, txt_tcel.getText());
            preparedStmt.setString (7, txt_correo.getText());
            preparedStmt.setString (8, txt_mediop.getText());
            preparedStmt.setString (9, selec_carrint.getSelectedItem().toString());
            preparedStmt.setString (10, txt_seguimiento.getText());
            preparedStmt.setBoolean(11, insc_si.isSelected());
            preparedStmt.setString (12, txt_atendio.getText());
            preparedStmt.setInt(13, ID_PROSPECTO);
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/modificar_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, "Se edito Alumno de manera adecuada","",JOptionPane.INFORMATION_MESSAGE,image);
            clear();
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema al editar Prospecto el alumno");
            Logger.getLogger(Prospecto.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
        else 
        {
      
        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void selec_carrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selec_carrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selec_carrintActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ape_ma;
    private javax.swing.JLabel ape_pa;
    private javax.swing.JLabel atendio;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JLabel carrera;
    private javax.swing.JLabel col;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel insc;
    private javax.swing.JCheckBox insc_si;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel medio;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel seguimiento;
    private javax.swing.JComboBox<String> selec_carrint;
    private javax.swing.JLabel telcel;
    private javax.swing.JLabel telksa;
    private javax.swing.JTextField txt_ap_materno;
    private javax.swing.JTextField txt_ap_paterno;
    private javax.swing.JTextField txt_atendio;
    private javax.swing.JTextField txt_col;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dato;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_mediop;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JButton txt_reg;
    private javax.swing.JTextArea txt_seguimiento;
    private javax.swing.JTextField txt_tcel;
    private javax.swing.JTextField txt_tksa;
    private javax.swing.JTextField txtfe_bd;
    // End of variables declaration//GEN-END:variables

    private void setText(JLabel fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
