/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.E_GRUPOS;
import Modelo.E_LISTA_ASISTENCIA;
import Modelo.E_PROFESOR;
import Modelo.E_USER_ROL;
import sistema_cedva.Profesor_Selected;
import Mysql.MySqlConnect;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class Asistencia extends javax.swing.JFrame {
     ArrayList<E_PROFESOR> profesores= new ArrayList<E_PROFESOR>();
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
    ArrayList<E_LISTA_ASISTENCIA> listas= new ArrayList<E_LISTA_ASISTENCIA>();
    int ID_PROFESOR;
    int ID_GRUPO;
    int ID_LISTA_ASISTENCIA;
    String fecha;
    String fecha2;
    String fechaD;

    /**
     * Creates new form ASISTENCIA
     */
    public Asistencia(int ID_PROFESOR, int ID_GRUPO)
    {
        initComponents();
        this.setLocationRelativeTo(null); 
  
   
    }
    
    public Asistencia() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(null);
        loadData();
    }
   

 

    
    public void loadData(){
         listas.clear();
         ID_LISTA_ASISTENCIA=0;
        
               MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
   PreparedStatement st = null ;
        String sql = "";
        try {
//            st = mysqlConnect.connect().createStatement();

          
          
      
           sql = "SELECT a.ID_LISTA_ASISTENCIA,a.ID_PROFESOR,a.ID_GRUPO,b.NB_PROFESOR,c.NB_GRUPO,a.FE_INICIO,a.FE_TERMINO,a.DS_LISTA_ASISTENCIA\n" +
                    "FROM c_lista_asistencia a\n" +
                    "INNER JOIN c_profesor b on b.ID_PROFESOR=a.ID_PROFESOR\n" +
                    "INNER JOIN c_grupo c on c.ID_GRUPO = a.ID_GRUPO ";
        st =mysqlConnect.connect().prepareStatement(sql);
         


ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idLista = rs.getInt("ID_LISTA_ASISTENCIA");  
 int idProf = rs.getInt("ID_PROFESOR");  
 int idGrupo = rs.getInt("ID_GRUPO");  
 String nbProf = rs.getString("NB_PROFESOR");  
 String nbGrupo = rs.getString("NB_GRUPO"); 
 Date feIni = rs.getDate("FE_INICIO");  
 Date feFin = rs.getDate("FE_TERMINO"); 
 String dsLis = rs.getString("DS_LISTA_ASISTENCIA"); 
//
 listas.add(new E_LISTA_ASISTENCIA(idLista,idProf,idGrupo,nbProf,nbGrupo,feIni,feFin,dsLis));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Asistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
String col[] = {"Id","Profesor","Grupo","Fecha Inicio","Fecha Fin","Periodo"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0);
    for (E_LISTA_ASISTENCIA s : listas) {
         Object[] objs = {s.getID_LISTA_ASISTENCIA(),s.getNB_PROFESOR(),s.getNB_GRUPO(),s.getFE_INICIO(),s.getFE_FIN(),s.getDS_LISTA()};
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
//    
     private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        
        // get the model from the jtable
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        // get the selected row index
       int selectedRowIndex = jTable1.getSelectedRow();
        // set the selected row data into jtextfields
       ID_LISTA_ASISTENCIA =Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()) ;   
         for (E_LISTA_ASISTENCIA e_lista_asistencia : listas) {
             if(e_lista_asistencia.getID_LISTA_ASISTENCIA()==ID_LISTA_ASISTENCIA)
             {
                  ID_PROFESOR = e_lista_asistencia.getID_PROFESOR();
                  ID_GRUPO= e_lista_asistencia.getID_GRUPO();
                  break;
             }
         }

    }
   

    public void setNbProfesor(String x)
    {
    txt_profesor.setText(x);
    }

        public void setIdProf(int pIdProf)
    {
        this.ID_PROFESOR=pIdProf;
    }
        
        public void setEditProf(int pIdProf)
    {
        this.ID_PROFESOR=pIdProf;
        for (E_PROFESOR e_profesor: profesores) {
            if(e_profesor.getID_PROFESOR()==pIdProf)
            {
              txt_profesor.setText(e_profesor.getNB_PROFESOR());
            }
        }}
        
        public void clear(){
            txt_profesor.setText(null);
            txt_grupo.setText(null);
            jdc_ini.setCalendar(null);
            jdc_fin.setCalendar(null);
            txt_periodo.setText(null);
    } 
        
//        public void setDatosAl(String fecha)
//    {
//        
//        java.util.Date date;
//        try {
//            date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
//            jdc_ini.setDate(date);
//        } catch (ParseException ex) {
//            Logger.getLogger(Asistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }}
        
        public void setNbGrupo(String x)
    {
    txt_grupo.setText(x);
    }

        public void setIdGrupo(int pIdGrupo)
    {
        this.ID_GRUPO=pIdGrupo;
    }
        
        public void setEditGrupo(int pIdGrupo)
    {
        this.ID_GRUPO=pIdGrupo;
        for (E_GRUPOS e_grupos: grupos) {
            if(e_grupos.getID_GRUPO()==pIdGrupo)
            {
              txt_grupo.setText(e_grupos.getNB_GRUPO());
            }
        }}
 
    
        
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_guardar = new javax.swing.JButton();
        btn_prof = new javax.swing.JButton();
        btn_grupo = new javax.swing.JButton();
        grupo = new javax.swing.JLabel();
        txt_grupo = new javax.swing.JTextField();
        profesor = new javax.swing.JLabel();
        txt_profesor = new javax.swing.JTextField();
        jdc_ini = new com.toedter.calendar.JDateChooser();
        jdc_fin = new com.toedter.calendar.JDateChooser();
        label_fechai = new javax.swing.JLabel();
        label_fechai1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label_periodo = new javax.swing.JLabel();
        txt_periodo = new javax.swing.JTextField();
        btn_eliminar = new javax.swing.JButton();
        btn_editar1 = new javax.swing.JButton();
        btn_atras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(730, 483));
        setMinimumSize(new java.awt.Dimension(730, 483));
        setPreferredSize(new java.awt.Dimension(730, 483));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        btn_prof.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_prof.setPreferredSize(new java.awt.Dimension(30, 31));
        btn_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_profActionPerformed(evt);
            }
        });
        getContentPane().add(btn_prof, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 30, 30));

        btn_grupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grupoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 30, 30));

        grupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grupo.setText("Grupo:");
        getContentPane().add(grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txt_grupo.setEditable(false);
        getContentPane().add(txt_grupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 280, -1));

        profesor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        profesor.setText("Profesor:");
        getContentPane().add(profesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        txt_profesor.setEditable(false);
        txt_profesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_profesorActionPerformed(evt);
            }
        });
        getContentPane().add(txt_profesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 430, -1));
        getContentPane().add(jdc_ini, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 180, -1));
        getContentPane().add(jdc_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 180, -1));

        label_fechai.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_fechai.setText("Fecha Termino:");
        getContentPane().add(label_fechai, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        label_fechai1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_fechai1.setText("Fecha Inicio:");
        getContentPane().add(label_fechai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Profesor", "Grupo", "Fecha Inicio", "Fecha Fin", "Ds_Lista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 680, 100));

        label_periodo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        label_periodo.setText("Periodo:");
        getContentPane().add(label_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        getContentPane().add(txt_periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 480, -1));

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        btn_editar1.setText("Editar");
        btn_editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        btn_atras.setText("Regresar");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        getContentPane().add(btn_atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        int dia= jdc_ini.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mes= jdc_ini.getCalendar().get(Calendar.MONTH)+1;
        int año= jdc_ini.getCalendar().get(Calendar.YEAR);
        fecha= (año + "-" + mes + "-" +dia);
        
        int dia2= jdc_fin.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mes2= jdc_fin.getCalendar().get(Calendar.MONTH)+1;
        int año2= jdc_fin.getCalendar().get(Calendar.YEAR);
        fecha2= (año2 + "-" + mes2 + "-" +dia2);
//
      try {
            // agregar
            // the mysql insert statement
            MySqlConnect mysqlConnect = new MySqlConnect();
            String query="";
            String message="";
            if(ID_LISTA_ASISTENCIA==0)
            {
                message="Se agrego lista de manera adecuada";
                query = " insert into c_lista_asistencia (ID_PROFESOR, ID_GRUPO, FE_INICIO, FE_TERMINO, DS_LISTA_ASISTENCIA)"
                    + " values (?, ?, ?, ?, ?)";
                
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setInt(1, ID_PROFESOR);
            preparedStmt.setInt(2, ID_GRUPO);
            preparedStmt.setString (3,  fecha);
            preparedStmt.setString (4, fecha2);
            preparedStmt.setString (5, txt_periodo.getText());
            // execute the preparedstatement
            preparedStmt.execute();
            clear();
            }
            else 
            {
                message="Se edito el lista de manera adecuada";

                query = "update c_lista_asistencia set ID_PROFESOR=?, ID_GRUPO=?, FE_INICIO=?, FE_TERMINO=?, DS_LISTA_ASISTENCIA=?   where ID_LISTA_ASISTENCIA = ?";
                PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                preparedStmt.setInt(1, ID_PROFESOR);
                preparedStmt.setInt(2, ID_GRUPO);
                preparedStmt.setString (3,  fecha);
                preparedStmt.setString (4, fecha2);
                preparedStmt.setString (5, txt_periodo.getText());
                preparedStmt.setInt(6, ID_LISTA_ASISTENCIA);
                
                 // execute the java preparedstatement
                 preparedStmt.executeUpdate();
                clear();
            }
            loadData();
            Icon image= new ImageIcon(getClass().getResource("/imagenes/correcto_sin_f.png"));
            JOptionPane.showMessageDialog(rootPane, message,"",JOptionPane.INFORMATION_MESSAGE,image);
            mysqlConnect.connect().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Problema al editar Asistencia","MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Asistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_profActionPerformed
        Profesor_Selected ps= new Profesor_Selected(this);
        ps.setVisible(true);
        ps.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_profActionPerformed

    private void btn_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grupoActionPerformed
        Grupos_Selected gs= new Grupos_Selected(this);
        gs.setVisible(true);
        gs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_grupoActionPerformed

    private void txt_profesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_profesorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_profesorActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if(ID_LISTA_ASISTENCIA!=0)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Desea eliminar esta lista seleccionada?, Este proceso no se puede deshacer.", "Confirmar", dialogButton);
            if(dialogResult == 0) {
                //  System.out.println("Yes option");
                try {
                    MySqlConnect mysqlConnect = new MySqlConnect();
                    String query="";
                    String message="";

                    query = "delete from c_lista_asistencia where ID_LISTA_ASISTENCIA = ?";
                    message="Se elimino lista de manera adecuada";

                    PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
                    preparedStmt.setInt(1, ID_LISTA_ASISTENCIA);
                    preparedStmt.execute();

                    loadData();
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
             Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un permiso","",JOptionPane.INFORMATION_MESSAGE,image);
            
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         Menu m= new Menu();
               m.setLocationRelativeTo(null);
                m.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar1ActionPerformed
         if(ID_LISTA_ASISTENCIA!=0)
        {
            for (E_LISTA_ASISTENCIA e_lista_asistencia : listas) {
                if(e_lista_asistencia.getID_LISTA_ASISTENCIA()==ID_LISTA_ASISTENCIA)
                {   
                 txt_profesor.setText(e_lista_asistencia.getNB_PROFESOR());
                 txt_grupo.setText(e_lista_asistencia.getNB_GRUPO());
                 txt_periodo.setText(e_lista_asistencia.getDS_LISTA());
                 jdc_ini.setDate(e_lista_asistencia.getFE_INICIO());
                 jdc_fin.setDate(e_lista_asistencia.getFE_FIN());
                }
            }
        }
        else 
        {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
        JOptionPane.showMessageDialog(null, "Selecciona un usuario","",JOptionPane.INFORMATION_MESSAGE,image);
        }
    }//GEN-LAST:event_btn_editar1ActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
                Menu refresh= new Menu();
//        refresh.setVisible(true);
        refresh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_btn_atrasActionPerformed

 public Date getDate(String pFecha)
 {
 java.util.Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(pFecha);
            return date;
//            jdc_fecha.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(Asistencia.class.getName()).log(Level.SEVERE, null, ex);
                        return null;

        }
 
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_editar1;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_grupo;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_prof;
    private javax.swing.JLabel grupo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdc_fin;
    private com.toedter.calendar.JDateChooser jdc_ini;
    private javax.swing.JLabel label_fechai;
    private javax.swing.JLabel label_fechai1;
    private javax.swing.JLabel label_periodo;
    private javax.swing.JLabel profesor;
    private javax.swing.JTextField txt_grupo;
    private javax.swing.JTextField txt_periodo;
    private javax.swing.JTextField txt_profesor;
    // End of variables declaration//GEN-END:variables
}
