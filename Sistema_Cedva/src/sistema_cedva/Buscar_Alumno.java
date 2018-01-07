/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.APP_CONTEXTO;
import Modelo.E_ALUMNO;
import Modelo.E_PROSPECTO;
import Modelo.E_USER_ROL;
import Modelo.E_GRUPOS;
import Mysql.MySqlConnect;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import sistema_cedva.Mensajeria;
import sistema_cedva.Diseño;

/**
 *
 * @author P3DR1TO
 */
public class Buscar_Alumno extends javax.swing.JFrame {
    
    /**
     * Creates new form Usuarios
     */
    ArrayList<E_ALUMNO> alumnos= new ArrayList<E_ALUMNO>();
    ArrayList<E_USER_ROL> user_rol= new ArrayList<E_USER_ROL>();
    ArrayList<E_PROSPECTO> prospectos= new ArrayList<E_PROSPECTO>();
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
     int ID_ALUMNO;
     String CL_ALUMNO;
     String NB_ALUMNO;
     String NB_PATERNO;
     String NB_MATERNO;
     String CL_DIRECCION;
     String FE_TRAMITE;
     String CL_TELEFONO_CASA;
     String CL_TELEFONO_CEL;
     String CL_EMAIL;
     String CL_CARRERA;
     String FE_NACIMIENTO;
     String NO_EDAD;
     String CL_PROSPECTO;
     int ID_PROSPECTO;
     String NB_GRUPO;
     int ID_GRUPO=0;
     Mensajeria  mensaje;
     Diseño diseño;

    Alumno p;

    
      
    
    public Buscar_Alumno(Alumno p) {
        initComponents();
        this.p=p;
         this.setLocationRelativeTo(null);
         setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
         mensaje=new Mensajeria();
         diseño= new Diseño();
         Iniciar();
         loadData("");
       
          String clUser = APP_CONTEXTO.getCL_USER();
//        String a = clUser;
          user_rol.clear();
               MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
   PreparedStatement st = null ;

        try {
//            st = mysqlConnect.connect().createStatement();

          String sql = "";


              sql = ("SELECT a.ID_USER_ROL,a.ID_USER,a.ID_ROL,b.CL_USER,c.NB_ROL,c.CL_ROL FROM c_usuario_rol a\n" +
"INNER JOIN c_usuario b on b.ID_USER=a.ID_USER\n" +
"inner JOIN c_rol c on c.ID_ROL = a.ID_ROL where b.CL_USER = ?");
                     
                     st =mysqlConnect.connect().prepareStatement(sql);
                     st.setString(1, clUser);
          
ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idUser_Rol = rs.getInt("ID_USER_ROL");  
 int idUser = rs.getInt("ID_USER");  
 int idRol = rs.getInt("ID_ROL");  
 String vclUser = rs.getString("CL_USER");  
 String nbRol = rs.getString("NB_ROL");  
 String clRol = rs.getString("CL_ROL"); 


 user_rol.add(new E_USER_ROL(idUser_Rol,idUser,vclUser,idRol,nbRol,clRol));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Buscar_Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btn_eliminar.setVisible(false);

        
 
        
        
        for (E_USER_ROL e_user_rol : user_rol) {
         switch(e_user_rol.getCL_ROL())
        {
             case "elim_alum":
                 btn_eliminar.setVisible(true);
                 break;
                              default:break;
        }
        }
    }
    
    public Buscar_Alumno() {
        initComponents();
        this.setLocationRelativeTo(null);  
        mensaje=new Mensajeria();
        diseño= new Diseño();
        Iniciar();
        loadData("");
    }
 
     public void Iniciar() {
        diseño.Mensaje(txt_busqueda, mensaje.getBusqueda2(), 0);
    }
    
     public void loadData(String pNbAlumno)
    {
       alumnos.clear();
       ID_ALUMNO=0;

               MySqlConnect mysqlConnect = new MySqlConnect();

                PreparedStatement st = null ;
//
        try {
//            st = mysqlConnect.connect().createStatement();

          String sql = "";
          
          if(pNbAlumno.equals(""))
          {
           sql = "SELECT A.ID_ALUMNO, A.CL_ALUMNO, A.NB_ALUMNO, A.NB_PATERNO, A.NB_MATERNO, A.CL_DIRECCION, \n" +
                "A.FE_TRAMITE, A.CL_TELEFONO_CASA, \n" +
                "A.CL_TELEFONO_CEL, A.CL_EMAIL, A.CL_CARRERA, A.NO_EDAD, A.FE_NACIMIENTO, A.ID_PROSPECTO, \n" +
                "A.ID_GRUPO, B.CL_PROSPECTO, C.NB_GRUPO FROM c_alumno \n" +
                "A INNER JOIN c_prospecto B ON A.ID_PROSPECTO = B.ID_PROSPECTO \n" +
                "INNER JOIN c_grupo C ON A.ID_GRUPO = C.ID_GRUPO";
             st =mysqlConnect.connect().prepareStatement(sql);

          }
          else 
          {
//              sql = ("SELECT A.ID_ALUMNO, A.CL_ALUMNO, A.NB_ALUMNO, A.NB_PATERNO, A.NB_MATERNO, A.CL_DIRECCION, \n" +
//                "A.FE_TRAMITE, A.CL_TELEFONO_CASA, \n" +
//                "A.CL_TELEFONO_CEL, A.CL_EMAIL, A.CL_CARRERA, A.NO_EDAD, A.FE_NACIMIENTO, A.ID_PROSPECTO, \n" +
//                "A.ID_GRUPO, B.CL_PROSPECTO, C.NB_GRUPO FROM c_alumno \n" +
//                "A INNER JOIN c_prospecto B ON A.ID_PROSPECTO = B.ID_PROSPECTO \n" +
//                "INNER JOIN c_grupo C ON A.ID_GRUPO = C.ID_GRUPO WHERE A.NB_ALUMNO = ?");
//                     st =mysqlConnect.connect().prepareStatement(sql);
//                     st.setString(1, pNbAlumno);
              
                           sql = "SELECT A.ID_ALUMNO, A.CL_ALUMNO, A.NB_ALUMNO, A.NB_PATERNO, A.NB_MATERNO, A.CL_DIRECCION, \n" +
                "A.FE_TRAMITE, A.CL_TELEFONO_CASA, \n" +
                "A.CL_TELEFONO_CEL, A.CL_EMAIL, A.CL_CARRERA, A.NO_EDAD, A.FE_NACIMIENTO, A.ID_PROSPECTO, \n" +
                "A.ID_GRUPO, B.CL_PROSPECTO, C.NB_GRUPO FROM c_alumno \n" +
                "A INNER JOIN c_prospecto B ON A.ID_PROSPECTO = B.ID_PROSPECTO \n" +
                "INNER JOIN c_grupo C ON A.ID_GRUPO = C.ID_GRUPO \n" +
                "where UPPER(NB_ALUMNO) LIKE '%"+pNbAlumno+"%' OR UPPER(A.CL_CARRERA) LIKE '%"+pNbAlumno+"%'";
                     st =mysqlConnect.connect().prepareStatement(sql);
//                        st.setString(1, java.util.A rrays(pClUser));
          }

          
ResultSet rs = st.executeQuery(sql);
while(rs.next()) { 
 int idAlumno = rs.getInt("ID_ALUMNO"); 
 String clAlumno = rs.getString("CL_ALUMNO");
 String nbNombre = rs.getString("NB_ALUMNO");
 String nbPaterno = rs.getString("NB_PATERNO");
 String nbMaterno = rs.getString("NB_MATERNO");
 String clDireccion = rs.getString("CL_DIRECCION");
 String feTramite = rs.getString("FE_TRAMITE");
 String clTelefonoCasa = rs.getString("CL_TELEFONO_CASA"); 
 String clTelefonoCel = rs.getString("CL_TELEFONO_CEL"); 
 String clEmail = rs.getString("CL_EMAIL");
 String clCarrera = rs.getString("CL_CARRERA");
 String feNacimiento = rs.getString("FE_NACIMIENTO");
 String noEdad = rs.getString("NO_EDAD");
 int idProspecto = rs.getInt("ID_PROSPECTO"); 
 String clProspecto = rs.getString("CL_PROSPECTO");
 int idGrupo = rs.getInt("ID_GRUPO"); 
 String nbGrupo = rs.getString("NB_GRUPO");


 alumnos.add(new E_ALUMNO(idAlumno,clAlumno,nbNombre,nbPaterno,nbMaterno,clDireccion,feTramite,clTelefonoCasa,clTelefonoCel,clEmail,clCarrera,feNacimiento,noEdad,idProspecto,idGrupo,clProspecto,nbGrupo));

}
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
        String col[] = {"Id","Clave","Nombre (s)","A. Paterno","A. Materno","Dirección",
            "Fecha","Telefono Casa","Telefono Celular","Email","Carrera",
                    "Fecha de nacimiento","Edad","id pros","id grupo","Clave prospecto", "Grupo"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0);
    for (E_ALUMNO s : alumnos) {
         Object[] objs = {s.getID_ALUMNO(),s.getCL_ALUMNO(),s.getNB_NOMBRE(),s.getNB_PATERNO(),s.getNB_MATERNO(),
             s.getCL_DIRECCION(),s.getFE_TRAMITE(),s.getCL_TELEFONO_CASA(),s.getCL_TELEFONO_CEL(),s.getCL_EMAIL(),
             s.getCL_CARRERA(),s.getFE_NACIMIENTO(),s.getNO_EDAD(),s.getID_PROSPECTO(),s.getID_GRUPO(),s.getCL_PROSPECTO(),s.getNB_GRUPO()};
         dtm.addRow( objs);
    }

   
    jTable_P.setModel(dtm);
       jTable_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable_P.getColumnModel().getColumn(0).setMaxWidth(0);

        jTable_P.getColumnModel().getColumn(0).setMinWidth(0);

        jTable_P.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jTable_P.getColumnModel().getColumn(1).setMaxWidth(150);

        jTable_P.getColumnModel().getColumn(1).setMinWidth(150);

        jTable_P.getColumnModel().getColumn(1).setPreferredWidth(150); 
        
        jTable_P.getColumnModel().getColumn(2).setMaxWidth(150);

        jTable_P.getColumnModel().getColumn(2).setMinWidth(150);

        jTable_P.getColumnModel().getColumn(2).setPreferredWidth(150);
        
        jTable_P.getColumnModel().getColumn(3).setMaxWidth(100);

        jTable_P.getColumnModel().getColumn(3).setMinWidth(100);

        jTable_P.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        jTable_P.getColumnModel().getColumn(4).setMaxWidth(100);

        jTable_P.getColumnModel().getColumn(4).setMinWidth(100);

        jTable_P.getColumnModel().getColumn(4).setPreferredWidth(100); 
        
        jTable_P.getColumnModel().getColumn(5).setMaxWidth(180);

        jTable_P.getColumnModel().getColumn(5).setMinWidth(180);

        jTable_P.getColumnModel().getColumn(5).setPreferredWidth(180); 
        
        jTable_P.getColumnModel().getColumn(6).setMaxWidth(80);

        jTable_P.getColumnModel().getColumn(6).setMinWidth(80);

        jTable_P.getColumnModel().getColumn(6).setPreferredWidth(80); 
        
        jTable_P.getColumnModel().getColumn(7).setMaxWidth(100);

        jTable_P.getColumnModel().getColumn(7).setMinWidth(100);

        jTable_P.getColumnModel().getColumn(7).setPreferredWidth(100); 
        
        jTable_P.getColumnModel().getColumn(8).setMaxWidth(100);

        jTable_P.getColumnModel().getColumn(8).setMinWidth(100);

        jTable_P.getColumnModel().getColumn(8).setPreferredWidth(100); 
        
        jTable_P.getColumnModel().getColumn(9).setMaxWidth(180);

        jTable_P.getColumnModel().getColumn(9).setMinWidth(180);

        jTable_P.getColumnModel().getColumn(9).setPreferredWidth(180); 
        
        jTable_P.getColumnModel().getColumn(10).setMaxWidth(200);

        jTable_P.getColumnModel().getColumn(10).setMinWidth(200);

        jTable_P.getColumnModel().getColumn(10).setPreferredWidth(200); 
        
        jTable_P.getColumnModel().getColumn(11).setMaxWidth(80);

        jTable_P.getColumnModel().getColumn(11).setMinWidth(80);

        jTable_P.getColumnModel().getColumn(11).setPreferredWidth(80); 
        
        jTable_P.getColumnModel().getColumn(12).setMaxWidth(50);

        jTable_P.getColumnModel().getColumn(12).setMinWidth(50);

        jTable_P.getColumnModel().getColumn(12).setPreferredWidth(50); 
        
        jTable_P.getColumnModel().getColumn(13).setMaxWidth(0);

        jTable_P.getColumnModel().getColumn(13).setMinWidth(0);

        jTable_P.getColumnModel().getColumn(13).setPreferredWidth(0); 
        
        jTable_P.getColumnModel().getColumn(14).setMaxWidth(0);

        jTable_P.getColumnModel().getColumn(14).setMinWidth(0);

        jTable_P.getColumnModel().getColumn(14).setPreferredWidth(0); 
        
        jTable_P.getColumnModel().getColumn(15).setMaxWidth(150);

        jTable_P.getColumnModel().getColumn(15).setMinWidth(150);

        jTable_P.getColumnModel().getColumn(15).setPreferredWidth(150); 
        
        jTable_P.getColumnModel().getColumn(16).setMaxWidth(100);

        jTable_P.getColumnModel().getColumn(16).setMinWidth(100);

        jTable_P.getColumnModel().getColumn(16).setPreferredWidth(100); 
    }
     
        private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jTable_P.getModel();
        // get the selected row index
       int selectedRowIndex = jTable_P.getSelectedRow();
        // set the selected row data into jtextfields
       ID_ALUMNO =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ; 
       CL_ALUMNO =model.getValueAt(selectedRowIndex, 1).toString();
       NB_ALUMNO =model.getValueAt(selectedRowIndex, 2).toString();
       NB_PATERNO =model.getValueAt(selectedRowIndex, 3).toString();
       NB_MATERNO =model.getValueAt(selectedRowIndex, 4).toString();
       CL_DIRECCION =model.getValueAt(selectedRowIndex, 5).toString();
       FE_TRAMITE =model.getValueAt(selectedRowIndex, 6).toString();
       CL_TELEFONO_CASA =model.getValueAt(selectedRowIndex, 7).toString();
       CL_TELEFONO_CEL =model.getValueAt(selectedRowIndex, 8).toString();
       CL_EMAIL =model.getValueAt(selectedRowIndex, 9).toString();
       CL_CARRERA =model.getValueAt(selectedRowIndex, 10).toString();
       FE_NACIMIENTO =model.getValueAt(selectedRowIndex, 11).toString();
       NO_EDAD =model.getValueAt(selectedRowIndex, 12).toString();
       ID_PROSPECTO =Integer.parseInt(model.getValueAt(selectedRowIndex, 13).toString()) ; 
       ID_GRUPO =Integer.parseInt(model.getValueAt(selectedRowIndex, 14).toString()) ; 
       CL_PROSPECTO =model.getValueAt(selectedRowIndex, 15).toString();
       NB_GRUPO =model.getValueAt(selectedRowIndex, 16).toString();
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
        jTable_P = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_busq_alum = new javax.swing.JButton();
        txt_busqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1045, 573));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_P.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Clave", "Nombre(s)", "Apellido P.", "Apellido M.", "Dirección", "Fecha Tramite", "Telefono Casa", "Telefono Celular", "Email", "Carrera", "Fecha de nac", "Edad", "Id prospecto", "Id grupo", "Clave Prospecto", "Grupo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_P.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable_P.setEditingRow(1);
        jTable_P.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_P.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_P);
        if (jTable_P.getColumnModel().getColumnCount() > 0) {
            jTable_P.getColumnModel().getColumn(0).setResizable(false);
            jTable_P.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable_P.getColumnModel().getColumn(1).setResizable(false);
            jTable_P.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable_P.getColumnModel().getColumn(2).setResizable(false);
            jTable_P.getColumnModel().getColumn(2).setPreferredWidth(160);
            jTable_P.getColumnModel().getColumn(3).setResizable(false);
            jTable_P.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable_P.getColumnModel().getColumn(4).setResizable(false);
            jTable_P.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable_P.getColumnModel().getColumn(5).setResizable(false);
            jTable_P.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTable_P.getColumnModel().getColumn(6).setResizable(false);
            jTable_P.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable_P.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable_P.getColumnModel().getColumn(8).setResizable(false);
            jTable_P.getColumnModel().getColumn(8).setPreferredWidth(80);
            jTable_P.getColumnModel().getColumn(9).setPreferredWidth(160);
            jTable_P.getColumnModel().getColumn(10).setResizable(false);
            jTable_P.getColumnModel().getColumn(10).setPreferredWidth(300);
            jTable_P.getColumnModel().getColumn(11).setPreferredWidth(80);
            jTable_P.getColumnModel().getColumn(12).setPreferredWidth(30);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1000, 430));

        btn_refresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_refresh.setText("Seleccionar");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 110, 30));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_USE1.jpg"))); // NOI18N
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 90, 80));

        btn_busq_alum.setText("Buscar");
        btn_busq_alum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busq_alumActionPerformed(evt);
            }
        });
        getContentPane().add(btn_busq_alum, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, -1, -1));

        txt_busqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_busquedaFocusLost(evt);
            }
        });
        txt_busqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_busquedaMouseClicked(evt);
            }
        });
        txt_busqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busquedaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 470, 220, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
 if(ID_ALUMNO!=0)
            {          
        p.setDatosAl(CL_ALUMNO, NB_ALUMNO, NB_PATERNO, NB_MATERNO, CL_DIRECCION, 
                FE_TRAMITE, CL_TELEFONO_CASA, CL_TELEFONO_CEL, CL_EMAIL, CL_CARRERA, 
                FE_NACIMIENTO, NO_EDAD);
        p.setIdAlumno(ID_ALUMNO);
        p.setIdProspecto(ID_PROSPECTO);
        p.setNbProspecto(CL_PROSPECTO);
        p.setIdGrupo(ID_GRUPO);
        p.setNbGrupo(NB_GRUPO);
//        p.setIdProspecto(ID_ALUMNO);
//        p.setNbDatos(NB_PATERNO,NB_MATERNO);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            }
            else 
        {
//            JOptionPane.showMessageDialog(jTable_P, "Seleccione un Alumno");
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un Alumno","",JOptionPane.INFORMATION_MESSAGE,image);
        }
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
                 if(ID_ALUMNO!=0)
            {
int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el Alumno seleccionado?, Este proceso no se puede deshacer.", "Confirmar", dialogButton);
if(dialogResult == 0) {
//  System.out.println("Yes option");
        try {
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            
                   query = "delete from c_alumno where ID_ALUMNO= ?";
                  message="Se elimino Alumno";

                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_ALUMNO);
                preparedStmt.execute();

            loadData("");
            Icon image= new ImageIcon(getClass().getResource("/imagenes/borrar_sin_f.png"));
             JOptionPane.showMessageDialog(null, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
}
            }
            else 
            {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un alumno","",JOptionPane.INFORMATION_MESSAGE,image);
            
            }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_busquedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_busquedaFocusLost
        diseño.Mensaje(txt_busqueda, mensaje.getBusqueda2(), txt_busqueda.getText().trim().length());
    }//GEN-LAST:event_txt_busquedaFocusLost

    private void txt_busquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_busquedaMouseClicked
        diseño.Clic(txt_busqueda,  mensaje.getBusqueda2( ));
    }//GEN-LAST:event_txt_busquedaMouseClicked

    private void btn_busq_alumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busq_alumActionPerformed
        loadData(txt_busqueda.getText());
    }//GEN-LAST:event_btn_busq_alumActionPerformed

    private void txt_busquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busquedaActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_busq_alum;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_P;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
