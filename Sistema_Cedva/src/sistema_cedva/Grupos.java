/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.E_GRUPOS;
import Mysql.MySqlConnect;
import java.awt.Color;
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
public class Grupos extends javax.swing.JFrame {
    
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
    int ID_GRUPO;
    /**
     * Creates new form Usuarios
     */
    public Grupos() {
        initComponents();
        this.setLocationRelativeTo(this);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
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
            Logger.getLogger(Grupos.class.getName()).log(Level.SEVERE, null, ex);
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

    }   

        public void clear(){
            txtClGrupo.setText(null);
            txtNbGrupo.setText(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_agregar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableG = new javax.swing.JTable();
        txtClGrupo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNbGrupo = new javax.swing.JTextField();
        btn_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(538, 450));
        setMinimumSize(new java.awt.Dimension(538, 450));
        setPreferredSize(new java.awt.Dimension(538, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_agregar.setText("Guardar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

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

        txtClGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClGrupoActionPerformed(evt);
            }
        });
        getContentPane().add(txtClGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Clave Grupo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Grupo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));
        getContentPane().add(txtNbGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 120, -1));

        btn_atras.setText("Regresar");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtClGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClGrupoActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed

        if (txtClGrupo.getText().equals("") && txtNbGrupo.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Debes agregar una clave y un grupo", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if (txtClGrupo.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Debes agregar una clave para el grupo", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if (txtNbGrupo.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Debes agregar un grupo", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if(!txtClGrupo.getText().equals("") && !txtNbGrupo.getText().equals("")){  
        try {
            // agregar
            // the mysql insert statement
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            if(ID_GRUPO==0)
            {
                message="Se agrego un nuevo Grupo";
                query = " insert into c_grupo (CL_GRUPO, NB_GRUPO)"
                    + " values (?, ?)";
                
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setString (1, txtClGrupo.getText());
            preparedStmt.setString (2, txtNbGrupo.getText());
            // execute the preparedstatement
            preparedStmt.execute();
            clear();
            }
            else 
            {
                message="Se edito un grupo";

                query = "update c_grupo set NB_GRUPO = ? where ID_GRUPO = ?";
                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setString(1, txtNbGrupo.getText());            
                preparedStmt.setInt(2, ID_GRUPO);
                 // execute the java preparedstatement
                 preparedStmt.executeUpdate();
                 clear();
                 txtClGrupo.enable(true);
            }
            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/correcto_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Grupos.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         else 
        {
           
        }
         
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
            if(ID_GRUPO!=0)
        {
            for (E_GRUPOS grup : grupos) {
                if(grup.getID_GRUPO()==ID_GRUPO)
                {
                    txtClGrupo.enable(false);
                    txtClGrupo.setText(grup.getCL_GRUPO());                    
                    txtNbGrupo.setText(grup.getNB_GRUPO());
                    break;
                }
            }
        }
        else 
        {
        Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
        JOptionPane.showMessageDialog(null, "Selecciona un grupo","",JOptionPane.INFORMATION_MESSAGE,image);
        
        }
   
    }//GEN-LAST:event_btnEditActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        Menu refresh= new Menu();
//        refresh.setVisible(true);
        refresh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_btn_atrasActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       if(ID_GRUPO!=0)
            {
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int dialogResult = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el grupo seleccionado?, Este proceso no se puede deshacer.", "Confirmar", dialogButton);
    if(dialogResult == 0) {
//  System.out.println("Yes option");
        try {
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            
                   query = "delete from c_grupo where ID_GRUPO = ?";
                  message="Se elimino Grupo";

                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_GRUPO);
                preparedStmt.execute();

            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/borrar_sin_f.png"));
             JOptionPane.showMessageDialog(null, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Grupos.class.getName()).log(Level.SEVERE, null, ex);
        }
}
            }
            else 
            {
             Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
             JOptionPane.showMessageDialog(null, "Selecciona un grupo","",JOptionPane.INFORMATION_MESSAGE,image);
            }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       Menu m= new Menu();
               m.setLocationRelativeTo(null);
                m.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableG;
    private javax.swing.JTextField txtClGrupo;
    private javax.swing.JTextField txtNbGrupo;
    // End of variables declaration//GEN-END:variables
}
