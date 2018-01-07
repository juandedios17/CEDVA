/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;


import Modelo.E_USER_ROL;
import Modelo.E_ROLES;
import Modelo.E_USUARIO;
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
import sistema_cedva.Mensajeria;
import sistema_cedva.Diseño;

/**
 *
 * @author P3DR1TO
 */
public class Permisos extends javax.swing.JFrame {
    ArrayList<E_USER_ROL> user_rol= new ArrayList<E_USER_ROL>();
    ArrayList<E_USUARIO> usuarios= new ArrayList<E_USUARIO>();
    ArrayList<E_ROLES> rol= new ArrayList<E_ROLES>();
    int ID_USER;
    int ID_ROL;
    int ID_USER_ROL;
    Mensajeria  mensaje;
    Diseño diseño;
    
        public Permisos(int ID_USER, int ID_ROL)
    {
        initComponents();
        this.setLocationRelativeTo(null); 
   
    }

        
    public Permisos() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(null);  
        mensaje=new Mensajeria();
        diseño= new Diseño();
        Iniciar();
        loadData("");
    }
    
    public void Iniciar() {
        diseño.Mensaje(txt_usuario_busq, mensaje.getBusqueda(), 0);
    }

    
    public void loadData(String pClUser){
        
         user_rol.clear();
         ID_USER_ROL=0;
        
               MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
   PreparedStatement st = null ;

        try {
//            st = mysqlConnect.connect().createStatement();

          String sql = "";
          
          if(pClUser.equals(""))
          {
           sql = "SELECT a.ID_USER_ROL,a.ID_USER,a.ID_ROL,b.CL_USER,c.NB_ROL FROM c_usuario_rol a\n" +
"INNER JOIN c_usuario b on b.ID_USER=a.ID_USER\n" +
"inner JOIN c_rol c on c.ID_ROL = a.ID_ROL ";
        st =mysqlConnect.connect().prepareStatement(sql);

          }
          else 
          {
              sql = ("SELECT a.ID_USER_ROL,a.ID_USER,a.ID_ROL,b.CL_USER,c.NB_ROL FROM c_usuario_rol a\n" +
"INNER JOIN c_usuario b on b.ID_USER=a.ID_USER\n" +
"inner JOIN c_rol c on c.ID_ROL = a.ID_ROL where b.CL_USER = ?");
                     
                     st =mysqlConnect.connect().prepareStatement(sql);
                     st.setString(1, pClUser);
//                        st.setString(1, java.util.Arrays(pClUser));
          }
          


ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idUser_Rol = rs.getInt("ID_USER_ROL");  
 int idUser = rs.getInt("ID_USER");  
 int idRol = rs.getInt("ID_ROL");  
 String clUser = rs.getString("CL_USER");  
 String nbRol = rs.getString("NB_ROL"); 

 user_rol.add(new E_USER_ROL(idUser_Rol,idUser,clUser,idRol,nbRol));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
String col[] = {"Id","Usuario","Rol"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0);
    for (E_USER_ROL s : user_rol) {
         Object[] objs = {s.getID_USER_ROL(),s.getNB_USER(),s.getNB_ROL()};
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
       ID_USER_ROL =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ;   
         for (E_USER_ROL e_user_rol : user_rol) {
             if(e_user_rol.getID_USER_ROL()==ID_USER_ROL)
             {
                  ID_USER = e_user_rol.getID_USER();
                  ID_ROL= e_user_rol.getID_ROL();
                  break;
             }
         }

    }
    
     public void setNbUser(String x)
    {
    txt_usuario.setText(x);
    }

        public void setIdUser(int pIdUser)
    {
        this.ID_USER=pIdUser;
    }
        
        public void setEditUser(int pIdUser)
    {
        this.ID_USER=pIdUser;
        for (E_USUARIO e_usuario: usuarios) {
            if(e_usuario.getID_USER()==pIdUser)
            {
              txt_usuario.setText(e_usuario.getCL_USER());
            }
        }}
        
        public void setNbRol(String x)
    {
    txt_rol.setText(x);
    }

        public void setIdRol(int pIdRol)
    {
        this.ID_ROL=pIdRol;
    }
        
        public void setEditRol(int pIdRol)
    {
        this.ID_ROL=pIdRol;
        for (E_ROLES e_roles: rol) {
            if(e_roles.getID_ROL()==pIdRol)
            {
              txt_rol.setText(e_roles.getNB_ROL());
            }
        }}
        
        public void clear(){
            txt_usuario.setText(null);
            txt_rol.setText(null);
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
        txt_usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_rol = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        txt_usuario_busq = new javax.swing.JTextField();
        btn_rol = new javax.swing.JButton();
        btn_user = new javax.swing.JButton();
        btn_retorna = new javax.swing.JButton();
        btn_regmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Usuario");

        txt_usuario.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Rol");

        txt_rol.setEditable(false);

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
                "Id", "Usuario", "Rol"
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Usuario:");

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        txt_usuario_busq.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usuario_busqFocusLost(evt);
            }
        });
        txt_usuario_busq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_usuario_busqMouseClicked(evt);
            }
        });
        txt_usuario_busq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuario_busqActionPerformed(evt);
            }
        });
        txt_usuario_busq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuario_busqKeyPressed(evt);
            }
        });

        btn_rol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rolActionPerformed(evt);
            }
        });

        btn_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_user.setPreferredSize(new java.awt.Dimension(30, 31));
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });

        btn_retorna.setText("Ver Tabla");
        btn_retorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retornaActionPerformed(evt);
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
                                .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_user, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btn_guardar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btn_editar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_eliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btn_regmenu))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_usuario_busq, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_retorna)))))
                .addGap(51, 199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_user, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btn_guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_usuario_busq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_buscar)
                    .addComponent(btn_retorna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar)
                    .addComponent(btn_eliminar)
                    .addComponent(btn_regmenu))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuario_busqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuario_busqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuario_busqActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        UsuariosSelected frame= new UsuariosSelected(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_userActionPerformed

    private void btn_rolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rolActionPerformed
        RolesSelected frame1= new RolesSelected(this);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_rolActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        try {
            // agregar
            // the mysql insert statement
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            if(ID_USER_ROL==0)
            {
                message="Se agrego permiso de manera adecuada";
                query = " insert into c_usuario_rol (ID_USER, ID_ROL)"
                    + " values (?, ?)";
                
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setInt(1, ID_USER);
            preparedStmt.setInt(2, ID_ROL);
            // execute the preparedstatement
            preparedStmt.execute();
            clear();
            }
            else 
            {
                message="Se edito el permiso de manera adecuada";

                query = "update c_usuario_rol set ID_USER=?, ID_ROL=? where ID_USER_ROL = ?";
                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_USER);
                preparedStmt.setInt(2, ID_ROL);
                preparedStmt.setInt(3, ID_USER_ROL);
                
                 // execute the java preparedstatement
                 preparedStmt.executeUpdate();
                clear();
            }
            loadData("");
            Icon image= new ImageIcon(getClass().getResource("/imagenes/correcto_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problema al editar permiso","",JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                        

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {                                         

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
          if(ID_USER_ROL!=0)
            {
int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el permiso seleccionado?, Este proceso no se puede deshacer.", "Confirmar", dialogButton);
if(dialogResult == 0) {
//  System.out.println("Yes option");
        try {
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            
                   query = "delete from c_usuario_rol where ID_USER_ROL = ?";
                  message="Se elimino el permiso de manera adecuada";

                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_USER_ROL);
                preparedStmt.execute();

            loadData("");
            Icon image= new ImageIcon(getClass().getResource("/imagenes/borrar_sin_f.png"));
             JOptionPane.showMessageDialog(null, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
}
            }
            else 
            {
            JOptionPane.showMessageDialog(jTable1,"Seleccione un permiso." );
            }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_usuario_busqFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usuario_busqFocusLost
        diseño.Mensaje(txt_usuario_busq, mensaje.getBusqueda(), txt_usuario_busq.getText().trim().length());

    }//GEN-LAST:event_txt_usuario_busqFocusLost

    private void txt_usuario_busqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usuario_busqMouseClicked
        diseño.Clic(txt_usuario_busq,  mensaje.getBusqueda( ));

    }//GEN-LAST:event_txt_usuario_busqMouseClicked

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
               
        if(ID_USER_ROL!=0)
        {
            for (E_USER_ROL usuario_rol : user_rol) {
                if(usuario_rol.getID_USER_ROL()==ID_USER_ROL)
                {   
                 txt_usuario.setText(usuario_rol.getNB_USER());
                 txt_rol.setText(usuario_rol.getNB_ROL());
                }
            }
        }
        else 
        {
            JOptionPane.showMessageDialog(jTable1, "Seleccione un permiso.");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
      loadData(txt_usuario_busq.getText());
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_usuario_busqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuario_busqKeyPressed

    }//GEN-LAST:event_txt_usuario_busqKeyPressed

    private void btn_retornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retornaActionPerformed
          loadData("");
    }//GEN-LAST:event_btn_retornaActionPerformed

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

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_regmenu;
    private javax.swing.JButton btn_retorna;
    private javax.swing.JButton btn_rol;
    private javax.swing.JButton btn_user;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_rol;
    private javax.swing.JTextField txt_usuario;
    private javax.swing.JTextField txt_usuario_busq;
    // End of variables declaration//GEN-END:variables
}
