/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.APP_CONTEXTO;
import Modelo.E_PROSPECTO;
import Modelo.E_USER_ROL;
import sistema_cedva.Prospecto;
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

/**
 *
 * @author P3DR1TO
 */
public class Buscar_Prospectos1 extends javax.swing.JFrame {
    
    /**
     * Creates new form Usuarios
     */
    ArrayList<E_PROSPECTO> prospectos= new ArrayList<E_PROSPECTO>();
    ArrayList<E_USER_ROL> user_rol= new ArrayList<E_USER_ROL>();
    
    int ID_PROSPECTO;
    String NB_PROSPECTO;
    String NB_PATERNO;
    String NB_MATERNO;
    String CL_COLONIA_MUNICIPIO;
    String FE_TRAMITE;
    String CL_TELEFONO_CASA;
    String CL_TELEFONO_CEL;
    String CL_EMAIL;
    String CL_MEDIO_PROMO;
    String CL_CARRERA;
    String DS_SEGUIMIENTO;
    Boolean FG_INSCRITO;
    String NB_ATENDIO;
    

    Prospecto p;

    public Buscar_Prospectos1(Prospecto p) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
         this.getContentPane().setBackground(Color.RED);
        this.p=p;
         this.setLocationRelativeTo(null);
          loadData();
          
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
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btn_eliminar_prosp.setVisible(false);
        
 
        
        
        for (E_USER_ROL e_user_rol : user_rol) {
         switch(e_user_rol.getCL_ROL())
        {
             case "elim_pros":
                 btn_eliminar_prosp.setVisible(true);
                 break;
                              default:break;
        }
        }
    }

   
    
    
     public void loadData()
    {
        prospectos.clear();
//        ID_USUARIO=0;
        
   MySqlConnect mysqlConnect = new MySqlConnect();
   Statement st;
        try {
            st = mysqlConnect.connect().createStatement();

String sql = "SELECT * FROM c_prospecto";
ResultSet rs = st.executeQuery(sql);
while(rs.next()) { 
 int idProspecto = rs.getInt("ID_PROSPECTO"); 
 String clprospecto = rs.getString("CL_PROSPECTO");
 String nbNombre = rs.getString("NB_NOMBRE");
 String nbNombrep = rs.getString("NB_PATERNO");
 String nbNombrem = rs.getString("NB_MATERNO");
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

 prospectos.add(new E_PROSPECTO(idProspecto, clprospecto, nbNombre, nbNombrep,nbNombrem,
                                clColonia,feTramite,clTelefonoCasa,clTelefonoCel,clEmail,clMedioPromo,
                               clCarrera,  dsSeguimiento,fgInscrito,(fgInscrito)?"Si":"No",nbAtendio
 ));
}
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
        String col[] = {"Id","Clave","Nombre (s)","A. Paterno","A. Materno","Colonia",
            "Fecha","Telefono Casa","Telefono Celular","Email","Medio Promocional",
                    "Carrera de Interes","Seguimiento","Inscrito","Atendio"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0);
    for (E_PROSPECTO s : prospectos) {
         Object[] objs = {s.getID_PROSPECTO(),s.getCL_PROSPECTO(),s.getNB_NOMBRE(),s.getNB_PATERNO(),s.getNB_MATERNO(),
             s.getCL_COLONIA(),s.getFE_TRAMITE(),s.getCL_TELEFONO_CASA(),s.getCL_TELEFONO_CEL(),s.getCL_EMAIL(),s.getCL_MEDIO_PROMO(),
         s.getNB_CARRERA(),s.getDS_SEGUIMIENTO(),s.getCL_INSCRITO(),s.getNB_ATENDIO()};
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
        
        jTable_P.getColumnModel().getColumn(10).setMaxWidth(120);

        jTable_P.getColumnModel().getColumn(10).setMinWidth(120);

        jTable_P.getColumnModel().getColumn(10).setPreferredWidth(120); 
        
        jTable_P.getColumnModel().getColumn(11).setMaxWidth(200);

        jTable_P.getColumnModel().getColumn(11).setMinWidth(200);

        jTable_P.getColumnModel().getColumn(11).setPreferredWidth(200); 
        
        jTable_P.getColumnModel().getColumn(12).setMaxWidth(200);

        jTable_P.getColumnModel().getColumn(12).setMinWidth(200);

        jTable_P.getColumnModel().getColumn(12).setPreferredWidth(200); 
        
        jTable_P.getColumnModel().getColumn(13).setMaxWidth(30);

        jTable_P.getColumnModel().getColumn(13).setMinWidth(30);

        jTable_P.getColumnModel().getColumn(13).setPreferredWidth(30); 
        
        jTable_P.getColumnModel().getColumn(14).setMaxWidth(80);

        jTable_P.getColumnModel().getColumn(14).setMinWidth(80);

        jTable_P.getColumnModel().getColumn(14).setPreferredWidth(80); 
    }
     
        private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jTable_P.getModel();
        // get the selected row index
       int selectedRowIndex = jTable_P.getSelectedRow();
        // set the selected row data into jtextfields
       ID_PROSPECTO =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ; 
       NB_PROSPECTO =model.getValueAt(selectedRowIndex, 2).toString();
       NB_PATERNO =model.getValueAt(selectedRowIndex, 3).toString();
       NB_MATERNO =model.getValueAt(selectedRowIndex, 4).toString();
       CL_COLONIA_MUNICIPIO =model.getValueAt(selectedRowIndex, 5).toString();
       FE_TRAMITE =model.getValueAt(selectedRowIndex, 6).toString();
       CL_TELEFONO_CASA =model.getValueAt(selectedRowIndex, 7).toString();
       CL_TELEFONO_CEL =model.getValueAt(selectedRowIndex, 8).toString();
       CL_EMAIL =model.getValueAt(selectedRowIndex, 9).toString();
       CL_MEDIO_PROMO =model.getValueAt(selectedRowIndex, 10).toString();
       CL_CARRERA =model.getValueAt(selectedRowIndex, 11).toString();
       DS_SEGUIMIENTO =model.getValueAt(selectedRowIndex, 12).toString();
       FG_INSCRITO=(model.getValueAt(selectedRowIndex, 13).toString().equals("Si"));
       NB_ATENDIO =model.getValueAt(selectedRowIndex, 14).toString();
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
        btn_eliminar_prosp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1045, 573));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_P.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Clave", "Nombre(s)", "Apellido P.", "Apellido M.", "Colonia / Municipio", "Fecha Tramite", "Telefono Casa", "Telefono Celular", "Email", "Medio Promocional", "Carrera de Interes", "Seguimiento", "Inscrito", "Atendio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
        jTable_P.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_P);
        if (jTable_P.getColumnModel().getColumnCount() > 0) {
            jTable_P.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable_P.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTable_P.getColumnModel().getColumn(2).setPreferredWidth(160);
            jTable_P.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable_P.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTable_P.getColumnModel().getColumn(5).setPreferredWidth(150);
            jTable_P.getColumnModel().getColumn(6).setPreferredWidth(80);
            jTable_P.getColumnModel().getColumn(7).setPreferredWidth(80);
            jTable_P.getColumnModel().getColumn(8).setPreferredWidth(80);
            jTable_P.getColumnModel().getColumn(9).setPreferredWidth(160);
            jTable_P.getColumnModel().getColumn(10).setPreferredWidth(100);
            jTable_P.getColumnModel().getColumn(11).setPreferredWidth(150);
            jTable_P.getColumnModel().getColumn(12).setPreferredWidth(100);
            jTable_P.getColumnModel().getColumn(13).setPreferredWidth(30);
            jTable_P.getColumnModel().getColumn(14).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1000, 430));

        btn_refresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_refresh.setText("Seleccionar");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 120, 30));

        btn_eliminar_prosp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/delete_USE1.jpg"))); // NOI18N
        btn_eliminar_prosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_prospActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar_prosp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 80, 90));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_PMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PMouseClicked
        //TableModel model = jTable1.getModel();
        //int row = jTable1.getSelectedRow();
        //model.setValueAt("Hello!",row,0 /* first column */);
    }//GEN-LAST:event_jTable_PMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
       if(ID_PROSPECTO!=0)
            {
        p.setDatos(NB_PROSPECTO, NB_PATERNO, NB_MATERNO, CL_COLONIA_MUNICIPIO, FE_TRAMITE, 
                CL_TELEFONO_CASA, CL_TELEFONO_CEL, CL_EMAIL, CL_MEDIO_PROMO, CL_CARRERA, 
                DS_SEGUIMIENTO, FG_INSCRITO, NB_ATENDIO);
//      p.setNbProspecto(NB_PROSPECTO);
        p.setIdProspecto(ID_PROSPECTO);
//        p.setNbDatos(NB_PATERNO,NB_MATERNO);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
            else 
            {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un Prospecto","",JOptionPane.INFORMATION_MESSAGE,image);     
        }
        
//        Alumno
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_eliminar_prospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_prospActionPerformed
if(ID_PROSPECTO!=0)
{
int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el prospecto seleccionado?, Este proceso no se puede deshacer.", "Confirmar", dialogButton);
if(dialogResult == 0) {
//  System.out.println("Yes option");
        try {
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            
                   query = "delete from c_prospecto where ID_PROSPECTO = ?";
                  message="Se elimino el Prospecto de manera adecuada";

                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_PROSPECTO);
                preparedStmt.execute();

            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/borrar_sin_f.png"));
             JOptionPane.showMessageDialog(null, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Prospecto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane,"No puedes eliminar un prospecto que ya es alumno.", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE );
        }
}
            }
            else 
            {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un Prospecto","",JOptionPane.INFORMATION_MESSAGE,image);     
        }
    }//GEN-LAST:event_btn_eliminar_prospActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_eliminar_prosp;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_P;
    // End of variables declaration//GEN-END:variables
}
