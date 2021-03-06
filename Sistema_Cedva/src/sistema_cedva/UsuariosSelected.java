/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.E_USUARIO;
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
public class UsuariosSelected extends javax.swing.JFrame {
    
    ArrayList<E_USUARIO> usuarios= new ArrayList<E_USUARIO>();
    int ID_USER = 0;
    String CL_USER;
        Permisos u;
    /**
     * Creates new form Usuarios
     */
    public UsuariosSelected(Permisos u) {
        initComponents();
              this.u=u;
              setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(this);
        loadData();
        
    }
    
    
    public void loadData()
    {
        usuarios.clear();
//        ID_USUARIO=0;
        
   MySqlConnect mysqlConnect = new MySqlConnect();
   Statement st;
        try {
            st = mysqlConnect.connect().createStatement();

String sql = "SELECT * FROM c_usuario";
ResultSet rs = st.executeQuery(sql);
while(rs.next()) { 
 int idUser = rs.getInt("ID_USER"); 
 String clUser = rs.getString("CL_USER");
 String nbPassword = rs.getString("NB_PASSWORD");
 boolean fgActivo = rs.getBoolean("FG_ACTIVO");
 usuarios.add(new E_USUARIO(idUser, clUser, nbPassword, fgActivo, (fgActivo)?"Si":"No"));
}
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosSelected.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
String col[] = {"Id","Usuario","Password","Activo"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0);
    for (E_USUARIO s : usuarios) {
         Object[] objs = {s.getID_USER(),s.getCL_USER(),s.getNB_PASSWORD(),s.getCL_ACTIVO()};
         dtm.addRow( objs);
    }

   
    jTable1.setModel(dtm);
       jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
       
       jTable1.getColumnModel().getColumn(0).setMaxWidth(0);

    jTable1.getColumnModel().getColumn(0).setMinWidth(0);

    jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        // get the selected row index
       int selectedRowIndex = jTable1.getSelectedRow();
        // set the selected row data into jtextfields
        ID_USER =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ; 
       CL_USER =model.getValueAt(selectedRowIndex, 1).toString();    

    }

    
    public void clear(){
//            txtClUser.setText(null);
//            txtNbPassword.setText(null);
//            chkActivo.setSelected(false);
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
        jTable1 = new javax.swing.JTable();
        btn_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(820, 230));
        setMinimumSize(new java.awt.Dimension(820, 230));
        setPreferredSize(new java.awt.Dimension(800, 230));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Usuario", "Password", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEditingRow(1);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setMinWidth(50);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 790, 90));

        btn_atras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_atras.setText("Seleccionar");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 100, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
          u.setNbUser(CL_USER);
        u.setIdUser(ID_USER);
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_btn_atrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
