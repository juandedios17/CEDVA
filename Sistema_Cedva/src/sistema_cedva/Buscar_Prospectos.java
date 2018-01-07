/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.APP_CONTEXTO;
import Modelo.E_PROSPECTO;
import Modelo.E_USUARIO;
import Mysql.MySqlConnect;
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
public class Buscar_Prospectos extends javax.swing.JFrame {
    
    /**
     * Creates new form Usuarios
     */
    ArrayList<E_PROSPECTO> prospectos= new ArrayList<E_PROSPECTO>();
    String CL_PROSPECTO, NB_NOMBRE,NB_PATERNO,NB_MATERNO,CL_TELEFONO_CASA,CL_TELEFONO_CEL,CL_EMAIL,CL_CARRERA;
        int ID_PROSPECTO=0;
        Alumno a;

    public Buscar_Prospectos(Alumno a) {
        initComponents();
        this.a=a;
         this.setLocationRelativeTo(null);
        loadData();
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
       CL_PROSPECTO =model.getValueAt(selectedRowIndex, 1).toString();
       NB_NOMBRE=model.getValueAt(selectedRowIndex, 2).toString();
       NB_PATERNO =model.getValueAt(selectedRowIndex, 3).toString();
       NB_MATERNO =model.getValueAt(selectedRowIndex, 4).toString();
       CL_TELEFONO_CASA =model.getValueAt(selectedRowIndex, 7).toString();
       CL_TELEFONO_CEL =model.getValueAt(selectedRowIndex, 8).toString();
       CL_EMAIL =model.getValueAt(selectedRowIndex, 9).toString();
       CL_CARRERA =model.getValueAt(selectedRowIndex, 11).toString();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1070, 550));
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
            jTable_P.getColumnModel().getColumn(1).setResizable(false);
            jTable_P.getColumnModel().getColumn(1).setPreferredWidth(100);
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1030, 430));

        btn_refresh.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        btn_refresh.setText("Seleccionar");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(917, 440, 120, 40));

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
//        APP_CONTEXTO.setNB_PROSPECTO(NB_PROSPECTO);    
//        APP_CONTEXTO.setID_PROSPECTO(ID_PROSPECTO);
        a.setNbProspecto(CL_PROSPECTO);
        a.setIdProspecto(ID_PROSPECTO);
        a.setDatosProsp(NB_NOMBRE, NB_PATERNO, NB_MATERNO, CL_TELEFONO_CASA, CL_TELEFONO_CEL, CL_EMAIL, CL_CARRERA);
        
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
         
            }
            else 
        {
        Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
        JOptionPane.showMessageDialog(null, "Selecciona un Prospecto","",JOptionPane.INFORMATION_MESSAGE,image);     
        }
    }//GEN-LAST:event_btn_refreshActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_P;
    // End of variables declaration//GEN-END:variables
}
