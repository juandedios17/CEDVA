/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;


import Modelo.E_CARRERAS;
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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


/**
 *
 * @author P3DR1TO
 */
public class Buscar_Carrera extends javax.swing.JFrame {
    
    ArrayList<E_CARRERAS> carreras= new ArrayList<E_CARRERAS>();
    int ID_CARRERA = 0;
    String NB_CARRERA;
    String CL_CARRERA;
    Asignar_Carrera ac;
    /**
     * Creates new form Usuarios
     */
    public Buscar_Carrera(Asignar_Carrera ac) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.ac=ac;
        this.setLocationRelativeTo(this);
        loadData();
    }
    
    
    public void loadData()
    {
        carreras.clear();
//        ID_CARRERA=0;
        
        MySqlConnect mysqlConnect = new MySqlConnect();
        Statement st;
        try {
            st = mysqlConnect.connect().createStatement();

        String sql = "SELECT * FROM c_carrera";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
        int idCarrera= rs.getInt("ID_CARRERA"); 
        String clCarrera = rs.getString("CL_CARRERA");
        String nbCarrera = rs.getString("NB_CARRERA");
        carreras.add(new E_CARRERAS(idCarrera, clCarrera, nbCarrera));
        }
            } catch (SQLException ex) {
            Logger.getLogger(Buscar_Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        mysqlConnect.disconnect();
        String col[] = {"Id","Clave","Carrera"};
        DefaultTableModel dtm = new DefaultTableModel(col, 0);
         for (E_CARRERAS s : carreras) {
         Object[] objs = {s.getID_CARRERA(),s.getCL_CARRERA(),s.getNB_CARRERA()};
         dtm.addRow( objs);
         }
         
        jTableCa.setModel(dtm);
        jTableCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTableCa.getColumnModel().getColumn(0).setMaxWidth(0);

        jTableCa.getColumnModel().getColumn(0).setMinWidth(0);

        jTableCa.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jTableCa.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableCa.getColumnModel().getColumn(2).setPreferredWidth(400);
    }
    
     private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jTableCa.getModel();
        // get the selected row index
       int selectedRowIndex = jTableCa.getSelectedRow();
        // set the selected row data into jtextfields
       ID_CARRERA =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ; 
       NB_CARRERA =model.getValueAt(selectedRowIndex, 2).toString();

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
        jTableCa = new javax.swing.JTable();
        btn_selecc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(815, 260));
        setMinimumSize(new java.awt.Dimension(815, 260));
        setPreferredSize(new java.awt.Dimension(800, 260));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Clave", "Carrera"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCa.setEditingRow(1);
        jTableCa.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCa.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableCa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 790, 170));

        btn_selecc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_selecc.setText("Seleccionar");
        btn_selecc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccActionPerformed(evt);
            }
        });
        getContentPane().add(btn_selecc, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_seleccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccActionPerformed
        if(ID_CARRERA!=0)
            {       
//        APP_CONTEXTO.setNB_PROSPECTO(NB_PROSPECTO);    
//        APP_CONTEXTO.setID_PROSPECTO(ID_PROSPECTO);
;
        ac.setNbCarrera(NB_CARRERA);
        ac.setIdCarrera(ID_CARRERA);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
         
            }
            else 
        {
            JOptionPane.showMessageDialog(jTableCa, "Seleccione un Grupo");
        }
                   
    }//GEN-LAST:event_btn_seleccActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_selecc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCa;
    // End of variables declaration//GEN-END:variables
}
