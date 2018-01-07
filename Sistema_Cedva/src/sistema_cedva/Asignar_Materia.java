/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;



import Modelo.E_GRUPOS;
import Modelo.E_MATERIAS;
import Modelo.E_MATERIA_GRUPO;
import Mysql.MySqlConnect;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author P3DR1TO
 */
public class Asignar_Materia extends javax.swing.JFrame {
    ArrayList<E_MATERIA_GRUPO> mat_group= new ArrayList<E_MATERIA_GRUPO>();
    ArrayList<E_MATERIAS> materias= new ArrayList<E_MATERIAS>();
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
    int ID_GRUPO;
    int ID_MATERIA;
    int ID_GRUPO_MATERIA;

    
        public Asignar_Materia(int ID_GRUPO, int ID_MATERIA)
    {
        initComponents();
        this.setLocationRelativeTo(null); 
   
    }

        
    public Asignar_Materia() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(null);  
        loadData();
    }
    

    
    public void loadData(){
        
         mat_group.clear();
         ID_GRUPO_MATERIA=0;
        
               MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
   PreparedStatement st = null ;

        try {
//            st = mysqlConnect.connect().createStatement();

          String sql = "";
          

           sql = "SELECT a.ID_GRUPO_MATERIA, a.ID_GRUPO, a.ID_MATERIA, b.CL_GRUPO, c.NB_MATERIA FROM k_grupo_materia a\n" +
"INNER JOIN c_grupo b on b.ID_GRUPO=a.ID_GRUPO\n" +
"inner JOIN c_materia c on c.ID_MATERIA = a.ID_MATERIA;";
        st =mysqlConnect.connect().prepareStatement(sql);

          
         
          
          


ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idMat_Gpo = rs.getInt("ID_GRUPO_MATERIA");  
 int idGrupo = rs.getInt("ID_GRUPO");  
 int idMateria = rs.getInt("ID_MATERIA");  
 String clGrupo = rs.getString("CL_GRUPO");  
 String nbMateria = rs.getString("NB_MATERIA"); 

 mat_group.add(new E_MATERIA_GRUPO(idMat_Gpo,idGrupo,idMateria,clGrupo,nbMateria));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Asignar_Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
String col[] = {"Id","Grupo","Materia"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0);
    for (E_MATERIA_GRUPO s : mat_group) {
         Object[] objs = {s.getID_GRUPO_MATERIA(),s.getCL_GRUPO(),s.getNB_MATERIA()};
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
       ID_GRUPO_MATERIA =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ;   
         for (E_MATERIA_GRUPO e_materia_grupo : mat_group) {
             if(e_materia_grupo.getID_GRUPO_MATERIA()==ID_GRUPO_MATERIA)
             {
                  ID_GRUPO = e_materia_grupo.getID_GRUPO();
                  ID_MATERIA= e_materia_grupo.getID_MATERIA();
                  break;
             }
         }

    }
    
     public void setClGrupo(String y)
    {
    txt_grupo.setText(y);
    }

        public void setIdGrupos(int pIdGpo)
    {
        this.ID_GRUPO=pIdGpo;
    }
        
        public void setEditGpo(int pIdGpo)
    {
        this.ID_GRUPO=pIdGpo;
        for (E_GRUPOS e_grupos: grupos) {
            if(e_grupos.getID_GRUPO()==pIdGpo)
            {
              txt_grupo.setText(e_grupos.getCL_GRUPO());
            }
        }}
        
        public void setNbMateria(String x)
    {
    txt_materia.setText(x);
    }

        public void setIdMateria(int pIdMat)
    {
        this.ID_MATERIA=pIdMat;
    }
        
        public void setEditMat(int pIdMat)
    {
        this.ID_MATERIA=pIdMat;
        for (E_MATERIAS e_materias: materias) {
            if(e_materias.getID_MATERIA()==pIdMat)
            {
              txt_materia.setText(e_materias.getNB_MATERIA());
            }
        }}
        
        public void clear(){
            txt_grupo.setText(null);
            txt_materia.setText(null);
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_grupo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_materia = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_materia = new javax.swing.JButton();
        btn_grupo = new javax.swing.JButton();
        btn_regmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Grupo:");

        txt_grupo.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Materia:");

        txt_materia.setEditable(false);

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Grupo", "Materia"
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        btn_materia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_materiaActionPerformed(evt);
            }
        });

        btn_grupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_grupo.setPreferredSize(new java.awt.Dimension(30, 31));
        btn_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grupoActionPerformed(evt);
            }
        });

        btn_regmenu.setText("Regresar");
        btn_regmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regmenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btn_guardar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_editar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_eliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btn_regmenu)))
                .addGap(51, 195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_materia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_regmenu))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grupoActionPerformed
        Selected_Grupos frame= new Selected_Grupos(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_grupoActionPerformed

    private void btn_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_materiaActionPerformed
        Buscar_Materia frame1= new Buscar_Materia(this);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_materiaActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        try {
            // agregar
            // the mysql insert statement
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            if(ID_GRUPO_MATERIA==0)
            {
                message="Se asigno materia a grupo de manera adecuada";
                query = " insert into k_grupo_materia (ID_GRUPO, ID_MATERIA)"
                    + " values (?, ?)";
                
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setInt(1, ID_GRUPO);
            preparedStmt.setInt(2, ID_MATERIA);
            // execute the preparedstatement
            preparedStmt.execute();
            clear();
            }
            else 
            {
                message="Modificación Exitosa";

                query = "update k_grupo_materia set ID_GRUPO=?, ID_MATERIA=? where ID_GRUPO_MATERIA= ?";
                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_GRUPO);
                preparedStmt.setInt(2, ID_MATERIA);
                preparedStmt.setInt(3, ID_GRUPO_MATERIA);
                
                 // execute the java preparedstatement
                 preparedStmt.executeUpdate();
                clear();
            }
            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/correcto_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problema al realizar esta modificación","",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Asignar_Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
          if(ID_GRUPO_MATERIA!=0)
            {
int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro seleccionado?, Este proceso no se puede deshacer.", "Confirmar", dialogButton);
if(dialogResult == 0) {
//  System.out.println("Yes option");
        try {
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            
                   query = "delete from k_grupo_materia where ID_GRUPO_MATERIA = ?";
                  message="Se elimino el registro";

                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_GRUPO_MATERIA);
                preparedStmt.execute();

            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/borrar_sin_f.png"));
             JOptionPane.showMessageDialog(null, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Asignar_Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
}
            }
            else 
            {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un registro","",JOptionPane.INFORMATION_MESSAGE,image);
            }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
               
        if(ID_GRUPO_MATERIA!=0)
        {
            for (E_MATERIA_GRUPO e_materia_grupo : mat_group) {
                if(e_materia_grupo.getID_GRUPO_MATERIA()==ID_GRUPO_MATERIA)
                {   
                 txt_grupo.setText(e_materia_grupo.getCL_GRUPO());
                 txt_materia.setText(e_materia_grupo.getNB_MATERIA());
                }
            }
        }
        else 
        {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un registro","",JOptionPane.INFORMATION_MESSAGE,image);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_regmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regmenuActionPerformed
         Menu refresh= new Menu();
//        refresh.setVisible(true);
        refresh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
                   
    }//GEN-LAST:event_btn_regmenuActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         Menu m= new Menu();
               m.setLocationRelativeTo(null);
                m.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_grupo;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_materia;
    private javax.swing.JButton btn_regmenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_grupo;
    private javax.swing.JTextField txt_materia;
    // End of variables declaration//GEN-END:variables
}
