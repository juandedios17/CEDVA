/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.E_PROFESOR;
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
public class Profesor extends javax.swing.JFrame {
    
    ArrayList<E_PROFESOR> profesores= new ArrayList<E_PROFESOR>();
    int ID_PROFESOR = 0;
    /**
     * Creates new form Usuarios
     */
    public Profesor() {
        initComponents();
        this.setLocationRelativeTo(this);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        loadData();
    }
    
    
    public void loadData()
    {
        profesores.clear();
        ID_PROFESOR=0;
        
        MySqlConnect mysqlConnect = new MySqlConnect();
        Statement st;
        try {
            st = mysqlConnect.connect().createStatement();

        String sql = "SELECT * FROM c_profesor";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()) { 
        int idProfesor = rs.getInt("ID_PROFESOR"); 
        String clProfesor = rs.getString("CL_PROFESOR");
        String nbProfesor= rs.getString("NB_PROFESOR");
        profesores.add(new E_PROFESOR(idProfesor, clProfesor, nbProfesor));
        }
            } catch (SQLException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        mysqlConnect.disconnect();
        String col[] = {"Id","Clave","Nombre Profesor"};
        DefaultTableModel dtm = new DefaultTableModel(col, 0);
         for (E_PROFESOR s : profesores) {
         Object[] objs = {s.getID_PROFESOR(),s.getCL_PROFESOR(),s.getNB_PROFESOR()};
         dtm.addRow( objs);
         }
         
        jTableP.setModel(dtm);
        jTableP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTableP.getColumnModel().getColumn(0).setMaxWidth(0);

        jTableP.getColumnModel().getColumn(0).setMinWidth(0);

        jTableP.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        jTableP.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableP.getColumnModel().getColumn(2).setPreferredWidth(400);
    }

        private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jTableP.getModel();
        // get the selected row index
       int selectedRowIndex = jTableP.getSelectedRow();
        // set the selected row data into jtextfields
       ID_PROFESOR =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ;       

    }   

    public void clear(){
            txtClProfesor.setText(null);
            txtNbProfesor.setText(null);
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableP = new javax.swing.JTable();
        txtClProfesor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNbProfesor = new javax.swing.JTextField();
        btn_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 530));
        setMinimumSize(new java.awt.Dimension(720, 530));
        setPreferredSize(new java.awt.Dimension(720, 530));
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
        getContentPane().add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 460, -1, -1));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, -1, -1));

        jTableP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Clave", "Profesor"
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
        jTableP.setEditingRow(1);
        jTableP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableP.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableP);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 670, 290));

        txtClProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClProfesorActionPerformed(evt);
            }
        });
        getContentPane().add(txtClProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 90, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Clave Profesor:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Profesor:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));
        getContentPane().add(txtNbProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 400, -1));

        btn_atras.setText("Regresar");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtClProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClProfesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClProfesorActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed

        if (txtClProfesor.getText().equals("") && txtNbProfesor.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Debes agregar una clave y el nombre del profesor", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if (txtClProfesor.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Debes agregar una clave para el profesor", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if (txtNbProfesor.getText().equals(""))
            {    JOptionPane.showMessageDialog(rootPane, "Debes agregar el nombre del profesor", "MENSAJE DE ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            }
        else if(!txtClProfesor.getText().equals("") && !txtNbProfesor.getText().equals("")){  
        try {
            // agregar
            // the mysql insert statement
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            if(ID_PROFESOR==0)
            {
                message="Se agrego un profesor";
                query = " insert into c_profesor (CL_PROFESOR, NB_PROFESOR)"
                    + " values (?, ?)";
                
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setString (1, txtClProfesor.getText());
            preparedStmt.setString (2, txtNbProfesor.getText());
            // execute the preparedstatement
            preparedStmt.execute();
            clear();
            }
            else 
            {
                message="Se edito el profesor seleccionado";

                query = "update c_profesor set NB_PROFESOR = ? where ID_PROFESOR = ?";
                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setString(1, txtNbProfesor.getText());             
                preparedStmt.setInt(2, ID_PROFESOR);
                 // execute the java preparedstatement
                 preparedStmt.executeUpdate();
                 clear();
                 txtClProfesor.enable(true);
            }
            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/correcto_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
         else 
        {
           
        }          
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(ID_PROFESOR!=0)
        {
            for (E_PROFESOR prof : profesores) {
                if(prof.getID_PROFESOR()==ID_PROFESOR)
                {
                    txtClProfesor.enable(false);
                    txtClProfesor.setText(prof.getCL_PROFESOR());                    
                    txtNbProfesor.setText(prof.getNB_PROFESOR());
                    break;
                }
            }
        }
        else 
        {
        Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
        JOptionPane.showMessageDialog(null, "Selecciona un profesor","",JOptionPane.INFORMATION_MESSAGE,image);
        }
   
                         
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        Menu refresh= new Menu();
//        refresh.setVisible(true);
        refresh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_btn_atrasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if(ID_PROFESOR!=0)
            {
    int dialogButton = JOptionPane.YES_NO_OPTION;
    int dialogResult = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el profesor seleccionado?, Este proceso no se puede deshacer.", "Confirmar", dialogButton);
    if(dialogResult == 0) {
//  System.out.println("Yes option");
        try {
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            
                   query = "delete from c_profesor where ID_PROFESOR = ?";
                  message="Se elimino Profesor";

                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_PROFESOR);
                preparedStmt.execute();

            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/borrar_sin_f.png"));
             JOptionPane.showMessageDialog(null, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, ex);
        }
}
            }
            else 
            {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un profesor","",JOptionPane.INFORMATION_MESSAGE,image);
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Menu m= new Menu();
               m.setLocationRelativeTo(null);
                m.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableP;
    private javax.swing.JTextField txtClProfesor;
    private javax.swing.JTextField txtNbProfesor;
    // End of variables declaration//GEN-END:variables
}
