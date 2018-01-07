/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and ope    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
n the template in the editor.
 */
package sistema_cedva;


import Modelo.E_ALUMNO;
import Modelo.E_GRUPOS;
import Modelo.E_PROSPECTO;
import Mysql.MySqlConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;

public class Alumno extends javax.swing.JFrame {
    
   

    ArrayList<E_ALUMNO> alumno= new ArrayList<E_ALUMNO>();
     ArrayList<E_PROSPECTO> prospectos= new ArrayList<E_PROSPECTO>();
      ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
//    String ed="";
    String calfecha,dia,mes,año;
    int ID_PROSPECTO,ID_GRUPO;
    int ID_ALUMNO=0;
    String CL_ALUMNO;
    String NB_NOMBRE;
    String NB_PATERNO;
    String FE_NACIMIENTO;
    String NO_EDAD;
    Date thisDate= new Date();
    SimpleDateFormat dateform = new SimpleDateFormat("MMMM-dd-Y");
    SimpleDateFormat fechaguardar = new SimpleDateFormat("Y-M-dd");
  
    public Alumno(int ID_ALUMNO)
    {
        initComponents();
        this.setLocationRelativeTo(null);   
    }
    
    public Alumno() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.setLocationRelativeTo(null);
        this.txt_carrint.removeAllItems();
        MySqlConnect mysqlConnect = new MySqlConnect();
         Statement st;
        try {
            st = mysqlConnect.connect().createStatement();
            
            String sql = "SELECT * FROM c_carrera";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()) { 
             this.txt_carrint.addItem(rs.getString("NB_CARRERA"));
        }} catch (Exception e) {
        }
        txt_fecha.setText(dateform.format(thisDate));
        txtfe_bd.setText(fechaguardar.format(thisDate));
//        MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
//        try {
//            st = mysqlConnect.connect().createStatement();
//
//String sql = "SELECT * FROM c_alumno";
//ResultSet rs = st.executeQuery(sql);
//while(rs.next()) { 
// int idAlumno = rs.getInt("ID_ALUMNO"); 
// String clAlumno = rs.getString("CL_ALUMNO");
// String nbNombre = rs.getString("NB_ALUMNO");
// String nbPaterno = rs.getString("NB_PATERNO");
// String nbMaterno = rs.getString("NB_MATERNO");
// String clDireccion = rs.getString("CL_DIRECCION");
// String feTramite = rs.getString("FE_TRAMITE");
// String clTelefonoCasa = rs.getString("CL_TELEFONO_CASA"); 
// String clTelefonoCel = rs.getString("CL_TELEFONO_CEL"); 
// String clEmail = rs.getString("CL_EMAIL");
// String clCarrera = rs.getString("CL_CARRERA");
// String feNacimiento = rs.getString("FE_NACIMIENTO");
// String noEdad = rs.getString("NO_EDAD");
// alumno.add(new E_ALUMNO(idAlumno,clAlumno,nbNombre,nbPaterno,nbMaterno,clDireccion,feTramite,clTelefonoCasa,clTelefonoCel,clEmail,clCarrera,feNacimiento,noEdad));
//
// 
//}
//        } catch (SQLException ex) {
//            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//
//mysqlConnect.disconnect();

    }
    
     public void setDatosAl(String clave,String nb, String apeP,String apeM, String dir, String fec, String telc, 
                         String cel, String mail, String carr, String fena, String edad)
    {
        
java.util.Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(fena);
            jdc_fecha.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }


        
    txtClave.setText(clave);
    txt_nom.setText(nb);    
    txt_ap_paterno.setText(apeP);
    txt_ap_materno.setText(apeM);
    txt_dir.setText(dir);
    txt_fecha.setText(fec);
    txt_tksa.setText(telc);
    txt_tcel.setText(cel);
    txt_correo.setText(mail);
    txt_carrint.setSelectedItem(carr);
    txt_edad.setText(edad);
//    txtProspecto1.setText(pros);
    }
    
    public void setNbProspecto(String x)
    {
    txtProspecto1.setText(x);
    }
//
        public void setIdProspecto(int pIdProspecto)
    {
        this.ID_PROSPECTO=pIdProspecto;
    }
        
        public void setNbGrupo(String z)
    {
    txt_Grupo.setText(z);
    }
//
        public void setIdGrupo(int pIdGrupo)
    {
        this.ID_GRUPO=pIdGrupo;
    }
        
    public void setIdAlumno(int pIdAlumno)
    {
        this.ID_ALUMNO=pIdAlumno;
    }
//        public void setEditAlumno(int pIdAlumno)
//    {
//        this.ID_ALUMNO=pIdAlumno;
//        for (E_ALUMNO e_alumno : alumno) {
//            if(e_alumno.getID_ALUMNO() ==pIdAlumno)
//            {
//              txtProspecto1.setText(e_alumno.getCL_ALUMNO());
//            }
//        }
////        
//    }
        
//           public void setEditProspecto(int pIdProspecto)
//    {
//        this.ID_PROSPECTO=pIdProspecto;
//        for (E_PROSPECTO e_prospecto : prospectos) {
//            if(e_prospecto.getID_PROSPECTO() ==pIdProspecto)
//            {
//              txtProspecto1.setText(e_prospecto.getCL_PROSPECTO());
//            }
//        }
//        
//    }
        
         public void setDatosProsp(String nb, String apeP,String apeM, String telc, 
                         String cel, String mail, String carr)
    {
        
    txt_nom.setText(nb);    
    txt_ap_paterno.setText(apeP);
    txt_ap_materno.setText(apeM);
    txt_tksa.setText(telc);
    txt_tcel.setText(cel);
    txt_correo.setText(mail);
    txt_carrint.setSelectedItem(carr);
//    txtProspecto1.setText(pros);
    }
        
    public void clear(){
            txtClave.setText(null);
            txt_nom.setText(null);
            txt_ap_paterno.setText(null);
            txt_ap_materno.setText(null);
            txt_dir.setText(null);
            txt_tksa.setText(null);
            txt_tcel.setText(null);
            txt_correo.setText(null);
            txt_edad.setText(null);
            txtProspecto1.setText(null);
            txt_Grupo.setText(null);
            txt_carrint.setSelectedItem(null);
            jdc_fecha.setCalendar(null);
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
        txt_dir = new javax.swing.JTextField();
        telksa = new javax.swing.JLabel();
        txt_tksa = new javax.swing.JTextField();
        telcel = new javax.swing.JLabel();
        txt_tcel = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        carrera = new javax.swing.JLabel();
        txt_carrint = new javax.swing.JComboBox<>();
        edad = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_reg = new javax.swing.JButton();
        txt_edad = new javax.swing.JTextField();
        fecha_nac = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        carrera1 = new javax.swing.JLabel();
        txtProspecto1 = new javax.swing.JTextField();
        carrera2 = new javax.swing.JLabel();
        jdc_fecha = new com.toedter.calendar.JDateChooser();
        btn_edad = new javax.swing.JButton();
        btn_selec = new javax.swing.JButton();
        carrera3 = new javax.swing.JLabel();
        btn_selec_grupo = new javax.swing.JButton();
        txt_Grupo = new javax.swing.JTextField();
        lbl_fondo = new javax.swing.JLabel();
        txt_prueba2 = new javax.swing.JTextField();
        txt_prueba = new javax.swing.JTextField();
        txtfe_bd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(730, 470));
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
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));

        txt_fecha.setEditable(false);
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 140, -1));

        nom.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        nom.setText("*Nombre(S):");
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 20));
        getContentPane().add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 410, -1));

        ape_pa.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        ape_pa.setText("*a. paterno:");
        getContentPane().add(ape_pa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txt_ap_paterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ap_paternoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_ap_paterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 150, -1));

        ape_ma.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        ape_ma.setText("A. MATERNO:");
        ape_ma.setMaximumSize(new java.awt.Dimension(142, 17));
        ape_ma.setMinimumSize(new java.awt.Dimension(142, 17));
        getContentPane().add(ape_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));
        getContentPane().add(txt_ap_materno, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 140, -1));

        col.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        col.setText("DIRECCIÓN:");
        getContentPane().add(col, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        getContentPane().add(txt_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 410, -1));

        telksa.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        telksa.setText("Tel. Casa:");
        getContentPane().add(telksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        txt_tksa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tksaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_tksa, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 140, -1));

        telcel.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        telcel.setText("Tel. Celular:");
        getContentPane().add(telcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        getContentPane().add(txt_tcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 160, -1));

        correo.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        correo.setText("correo electronico:");
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 340, -1));

        carrera.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        carrera.setText("*PROSPECTO:");
        getContentPane().add(carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, -1));

        txt_carrint.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BACHILLERATO EN GASTRONOMÍA", "BACHILLERATO EN MECÁNICA", "BACHILLERATO GENERAL", "COCINA INTERNACIONAL", "CURSOS", "INGENIERÍA EN MECANICA AUTOMOTRIZ", "MECANICO A DIESEL", "MECACINO A GASOLINA", "MECANICO ESPECIALISTA EN MOTOCICLETAS", "SERVICIOS Y ESTILISMO", " " }));
        getContentPane().add(txt_carrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 430, -1));

        edad.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        edad.setText("*EDAD:");
        getContentPane().add(edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 60, 20));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add.jpg"))); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 80, 80));

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.jpg"))); // NOI18N
        btn_editar.setMaximumSize(new java.awt.Dimension(109, 85));
        btn_editar.setMinimumSize(new java.awt.Dimension(109, 85));
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 80, 80));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.jpg"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 80, -1));

        txt_reg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txt_reg.setText("Regresar");
        txt_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_regActionPerformed(evt);
            }
        });
        getContentPane().add(txt_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));
        getContentPane().add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 40, -1));

        fecha_nac.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        fecha_nac.setText("*fecha de nacimiento:");
        getContentPane().add(fecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 180, 20));

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        getContentPane().add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 240, -1));

        carrera1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        carrera1.setText("carrera:");
        getContentPane().add(carrera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        txtProspecto1.setEditable(false);
        txtProspecto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProspecto1ActionPerformed(evt);
            }
        });
        getContentPane().add(txtProspecto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 190, -1));

        carrera2.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        carrera2.setText("*MATRICULA:");
        getContentPane().add(carrera2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        jdc_fecha.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(jdc_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 140, -1));

        btn_edad.setText("Calcular");
        btn_edad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edadActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        btn_selec.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_selec.setText("Seleccionar");
        btn_selec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selecActionPerformed(evt);
            }
        });
        getContentPane().add(btn_selec, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 120, -1));

        carrera3.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        carrera3.setText("*GRUPO:");
        getContentPane().add(carrera3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        btn_selec_grupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_selec_grupo.setText("Seleccionar");
        btn_selec_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selec_grupoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_selec_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 410, 120, -1));

        txt_Grupo.setEditable(false);
        txt_Grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_GrupoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 230, -1));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_final.jpg"))); // NOI18N
        lbl_fondo.setMaximumSize(new java.awt.Dimension(720, 500));
        lbl_fondo.setMinimumSize(new java.awt.Dimension(720, 500));
        lbl_fondo.setPreferredSize(new java.awt.Dimension(720, 500));
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 730, 480));
        getContentPane().add(txt_prueba2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 60, -1));
        getContentPane().add(txt_prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 110, -1));
        getContentPane().add(txtfe_bd, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_tksaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tksaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tksaActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
      Buscar_Alumno pframes= new Buscar_Alumno(this);
        pframes.setVisible(true);
        pframes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_regActionPerformed
        Menu regresar1= new Menu();
//        regresar.setVisible(true);
        regresar1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_txt_regActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed

    }//GEN-LAST:event_txt_fechaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        Menu m= new Menu();
               m.setLocationRelativeTo(null);
                m.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void txt_ap_paternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ap_paternoActionPerformed
//         TODO add your handling code here:
    }//GEN-LAST:event_txt_ap_paternoActionPerformed
   
    
    
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (txtClave.getText().equals("") || txt_nom.getText().equals("") || txt_ap_paterno.getText().equals("")
                || txt_edad.getText().equals("") || txtProspecto1.getText().equals("") || txt_Grupo.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Debes llenar los campos requeridos (*)", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
    //    else if(ID_ALUMNO==0){ JOptionPane.showMessageDialog(rootPane, "No puedes agregar un Alumno ya existente", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);}

        else if(!txt_nom.getText().equals("")&& !txt_nom.getText().equals("") && !txt_ap_paterno.getText().equals("")
                && !txt_edad.getText().equals("") && !txtProspecto1.getText().equals("")){    
        try {
            // agregar
            // the mysql insert statement
            String query = " insert into c_alumno (CL_ALUMNO, NB_ALUMNO, NB_PATERNO, "
                    + "NB_MATERNO, CL_DIRECCION, FE_TRAMITE, CL_TELEFONO_CASA, CL_TELEFONO_CEL, CL_EMAIL,"
                    + "CL_CARRERA, NO_EDAD, FE_NACIMIENTO,ID_PROSPECTO,ID_GRUPO)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            MySqlConnect mysqlConnect = new MySqlConnect();
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setString (1, txtClave.getText());
            preparedStmt.setString (2, txt_nom.getText());
            preparedStmt.setString (3, txt_ap_paterno.getText());
            preparedStmt.setString (4, txt_ap_materno.getText());
            preparedStmt.setString (5, txt_dir.getText());
            preparedStmt.setString(6, txtfe_bd.getText());
            preparedStmt.setString (7, txt_tksa.getText());
            preparedStmt.setString (8, txt_tcel.getText());
            preparedStmt.setString (9, txt_correo.getText());
            preparedStmt.setString (10, txt_carrint.getSelectedItem().toString());
            preparedStmt.setString (11, txt_edad.getText());
            preparedStmt.setString (12, txt_prueba.getText());
            preparedStmt.setInt(13, ID_PROSPECTO);
            preparedStmt.setInt(14, ID_GRUPO);

            
            // execute the preparedstatement
            preparedStmt.execute();
//            JOptionPane.showMessageDialog(rootPane, "Se agrego Alumno");
            Icon image= new ImageIcon(getClass().getResource("/imagenes/correcto_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, "Se agrego Alumno","",JOptionPane.INFORMATION_MESSAGE,image);
            clear();
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Ocurrio un problema al guardar el Alumno","MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        else 
        {
         JOptionPane.showMessageDialog(rootPane, "No puedes agregar un Alumno ya existente","MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE); 
 
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    private void txtProspecto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProspecto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProspecto1ActionPerformed

    private void btn_edadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edadActionPerformed
          SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          String thedate = dateFormat.format(jdc_fecha.getDate());
          txt_prueba2.setText(thedate);
        dia= Integer.toString(jdc_fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
        mes= Integer.toString(jdc_fecha.getCalendar().get(Calendar.MONTH)+1);
        año= Integer.toString(jdc_fecha.getCalendar().get(Calendar.YEAR));
        calfecha= (año + "-" + mes + "-" +dia);
        txt_prueba.setText(calfecha);
      
       DateTimeFormatter date=DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate fechanacimiento=LocalDate.parse(thedate, date);
       LocalDate fechactual=LocalDate.now();
       Period periodo= Period.between(fechanacimiento, fechactual);
       String resultado = (""+periodo.getYears());
       txt_edad.setText(resultado);
    }//GEN-LAST:event_btn_edadActionPerformed

    private void btn_selecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selecActionPerformed
        Buscar_Prospectos frame= new Buscar_Prospectos(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_selecActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
   
        
        if (txtClave.getText().equals("") || txt_nom.getText().equals("") || txt_ap_paterno.getText().equals("")
                || txt_edad.getText().equals("") || txtProspecto1.getText().equals(""))
            
            {   Icon image= new ImageIcon(getClass().getResource("/imagenes/busca_sin_f.png")); 
                JOptionPane.showMessageDialog(rootPane, "Busca un Alumno para editar","",JOptionPane.INFORMATION_MESSAGE,image);
            }
        else if(ID_ALUMNO!=0){
        try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
              String thedate = dateFormat.format(jdc_fecha.getDate());
              txt_prueba2.setText(thedate);
            dia= Integer.toString(jdc_fecha.getCalendar().get(Calendar.DAY_OF_MONTH));
            mes= Integer.toString(jdc_fecha.getCalendar().get(Calendar.MONTH)+1);
            año= Integer.toString(jdc_fecha.getCalendar().get(Calendar.YEAR));
            calfecha= (año + "-" + mes + "-" +dia);
            txt_prueba.setText(calfecha);
        
            String query = "update  c_alumno set CL_ALUMNO = ?, NB_ALUMNO = ?, NB_PATERNO = ?, "
                    + "NB_MATERNO = ?, CL_DIRECCION = ?, CL_TELEFONO_CASA = ?, "
                    + "CL_TELEFONO_CEL = ?, CL_EMAIL = ?, "
                    + "CL_CARRERA = ?, NO_EDAD = ?, FE_NACIMIENTO = ?, "
                    + "ID_GRUPO= ? WHERE ID_ALUMNO = ?";
            
            MySqlConnect mysqlConnect = new MySqlConnect();
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            
            preparedStmt.setString (1, txtClave.getText());
            preparedStmt.setString (2, txt_nom.getText());
            preparedStmt.setString (3, txt_ap_paterno.getText());
            preparedStmt.setString (4, txt_ap_materno.getText());
            preparedStmt.setString (5, txt_dir.getText());
            preparedStmt.setString (6, txt_tksa.getText());
            preparedStmt.setString (7, txt_tcel.getText());
            preparedStmt.setString (8, txt_correo.getText());
            preparedStmt.setString (9, txt_carrint.getSelectedItem().toString());
            preparedStmt.setString (10,txt_edad.getText());
            preparedStmt.setString (11, txt_prueba.getText());
            preparedStmt.setInt (12,ID_GRUPO);
            preparedStmt.setInt(13, ID_ALUMNO);
            
            // execute the preparedstatement
            preparedStmt.executeUpdate();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/modificar_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, "Se edito Alumno de manera adecuada","",JOptionPane.INFORMATION_MESSAGE,image);
            clear();
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(rootPane, "Ocurrio un problema al editar el alumno","MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else 
        {
       JOptionPane.showMessageDialog(rootPane, "Ocurrio un problema con la edición", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_selec_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selec_grupoActionPerformed
        Buscar_Grupos frame= new Buscar_Grupos(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_selec_grupoActionPerformed

    private void txt_GrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_GrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_GrupoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ape_ma;
    private javax.swing.JLabel ape_pa;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_edad;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_selec;
    private javax.swing.JButton btn_selec_grupo;
    private javax.swing.JLabel carrera;
    private javax.swing.JLabel carrera1;
    private javax.swing.JLabel carrera2;
    private javax.swing.JLabel carrera3;
    private javax.swing.JLabel col;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel edad;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel fecha_nac;
    private com.toedter.calendar.JDateChooser jdc_fecha;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel telcel;
    private javax.swing.JLabel telksa;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtProspecto1;
    private javax.swing.JTextField txt_Grupo;
    private javax.swing.JTextField txt_ap_materno;
    private javax.swing.JTextField txt_ap_paterno;
    private javax.swing.JComboBox<String> txt_carrint;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prueba;
    private javax.swing.JTextField txt_prueba2;
    private javax.swing.JButton txt_reg;
    private javax.swing.JTextField txt_tcel;
    private javax.swing.JTextField txt_tksa;
    private javax.swing.JTextField txtfe_bd;
    // End of variables declaration//GEN-END:variables

    

       
  
}
