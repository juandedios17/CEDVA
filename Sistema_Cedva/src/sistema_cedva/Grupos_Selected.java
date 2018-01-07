/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

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
public class Grupos_Selected extends javax.swing.JFrame {
    
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
    int ID_GRUPO;
    String NB_GRUPO;
    Asistencia gr;
    /**
     * Creates new form Usuarios
     */
    public Grupos_Selected(Asistencia gr) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.gr=gr;
        this.setLocationRelativeTo(this);
        loadData();
    }
    
    
    public void loadData()
    {
        grupos.clear();
        ID_GRUPO=0;
        
        MySqlConnect mysqlConnect = new MySqlConnect();
        Statement st;
        try {
            st = mysqlConnect.connect().createStatement();

        String sql = "SELECT * FROM c_grupo";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
        int idGrupo = rs.getInt("ID_GRUPO"); 
        String clGrupo= rs.getString("CL_GRUPO");
        String nbGrupo = rs.getString("NB_GRUPO");
        grupos.add(new E_GRUPOS(idGrupo, clGrupo, nbGrupo));
        }
            } catch (SQLException ex) {
            Logger.getLogger(Grupos_Selected.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        mysqlConnect.disconnect();
        String col[] = {"Id","Clave","Grupo"};
        DefaultTableModel dtm = new DefaultTableModel(col, 0);
         for (E_GRUPOS s : grupos) {
         Object[] objs = {s.getID_GRUPO(),s.getCL_GRUPO(),s.getNB_GRUPO()};
         dtm.addRow( objs);
         }
         
        jTableG.setModel(dtm);
        jTableG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTableG.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableG.getColumnModel().getColumn(0).setMinWidth(0);
        jTableG.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jTableG.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableG.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

        private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jTableG.getModel();
        // get the selected row index
       int selectedRowIndex = jTableG.getSelectedRow();
        // set the selected row data into jtextfields
       ID_GRUPO =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ;     
       NB_GRUPO =model.getValueAt(selectedRowIndex, 2).toString();   

    }   

      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_atras1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableG = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(538, 430));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_atras1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_atras1.setText("Seleccionar");
        btn_atras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atras1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 120, 30));

        jTableG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Clave", "Grupo"
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
        jTableG.setEditingRow(1);
        jTableG.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableG.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableG);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 510, 300));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atras1ActionPerformed
        if(ID_GRUPO!=0)
        {
            //        APP_CONTEXTO.setNB_PROSPECTO(NB_PROSPECTO);
            //        APP_CONTEXTO.setID_PROSPECTO(ID_PROSPECTO);
            gr.setNbGrupo(NB_GRUPO);
            gr.setIdGrupo(ID_GRUPO);

            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

        }
        else
        {
           Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un grupo","",JOptionPane.INFORMATION_MESSAGE,image);
            
        }
    }//GEN-LAST:event_btn_atras1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableG;
    // End of variables declaration//GEN-END:variables
}
