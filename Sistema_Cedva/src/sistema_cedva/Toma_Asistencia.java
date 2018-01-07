/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.E_ALUMNO_ASISTENCIA;
import Modelo.E_GRUPOS;
import Modelo.E_LISTA_ASISTENCIA;
import Modelo.E_PROFESOR;
import Mysql.MySqlConnect;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
/**
 *
 * @author P3DR1TO
 */
public class Toma_Asistencia extends javax.swing.JFrame {
            ArrayList<E_PROFESOR> profesores= new ArrayList<E_PROFESOR>();
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
    ArrayList<E_LISTA_ASISTENCIA> listas= new ArrayList<E_LISTA_ASISTENCIA>();
    int ID_PROFESOR;
    int ID_GRUPO;
    int ID_LISTA_ASISTENCIA;
    int ID_ASISTENCIA;
    Date FE_INICIO;
    Date FE_FIN;
    String Fecha;
    ArrayList<E_ALUMNO_ASISTENCIA>asistencias=new ArrayList<E_ALUMNO_ASISTENCIA>();
    /**
     * Creates new form Toma_Asistencia
     */
    public Toma_Asistencia(int ID_PROFESOR, int ID_GRUPO)
    {
        initComponents();
        this.setLocationRelativeTo(null); 
  
   
    }
    
    
    
    public Toma_Asistencia() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(this);
        Calendar c2 = new GregorianCalendar();
        jDateChooser1.setCalendar(c2);
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
        
      
        
         public void setNbLista(String x)
    {
    txt_lista.setText(x);
    }

        public void setIdLista(int pIdLista)
    {
        this.ID_LISTA_ASISTENCIA=pIdLista;
    }
        
        public void setEditLista(int pIdLista)
    {
        this.ID_LISTA_ASISTENCIA=pIdLista;
        for (E_LISTA_ASISTENCIA e_lista_asistencia: listas) {
            if(e_lista_asistencia.getID_LISTA_ASISTENCIA()==pIdLista)
            {
              txt_profesor.setText(e_lista_asistencia.getDS_LISTA());
            }
        }}
        
         public void setHorario(String z)
    {
    txt_horario.setText(z);
    }

        public void setIdHorario(int pIdHora)
    {
        this.ID_GRUPO=pIdHora;
    }
        
        public void setEditHora(int pIdHora)
    {
        this.ID_GRUPO=pIdHora;
        for (E_GRUPOS e_grupos: grupos) {
            if(e_grupos.getID_GRUPO()==pIdHora)
            {
              txt_horario.setText(e_grupos.getNB_GRUPO());
            }
        }}

    public Date getFE_INICIO() {
        return FE_INICIO;
    }
    public void setFE_INICIO(Date FE_INICIO) {
        this.FE_INICIO = FE_INICIO;
    }
    
      public Date getFE_FIN() {
        return FE_FIN;
    }
    public void setFE_FIN(Date FE_FIN) {
        this.FE_FIN = FE_FIN;
    }
    
    public void setDataByListaAsistencia(int pID_GRUPO)
    {
             asistencias.clear();
//         ID_LISTA_ASISTENCIA=0;
        
               MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
   PreparedStatement st = null ;
        String sql = "";
        try {
      
              sql = ("SELECT a.ID_ALUMNO,a.CL_ALUMNO, CONCAT(a.NB_PATERNO,' ',a.NB_MATERNO,' ',a.NB_ALUMNO) AS NB_ALUMNO FROM c_alumno a\n" +
                        "where a.ID_GRUPO = ?");

//              sql = (
//"SELECT b.ID_ALUMNO, b.CL_ALUMNO,CONCAT(b.NB_PATERNO,' ',b.NB_MATERNO,' ',b.NB_ALUMNO) AS NB_ALUMNO, IFNULL(e.NO_ASISTENCIAS,0) NO_ASISTENCIAS,IFNULL(f.NO_FALTAS,0) NO_FALTAS FROM cedva_bd.k_asistencia a \n" +
//"inner join cedva_bd.c_alumno b on a.ID_ALUMNO = b.ID_ALUMNO\n" +
//"inner join cedva_bd.c_lista_asistencia d on d.ID_LISTA_ASISTENCIA = a.ID_LISTA_ASISTENCIA\n" +
//"inner join cedva_bd.c_grupo c on c.ID_GRUPO = d.ID_GRUPO \n" +
//"left outer join ( SELECT a.ID_ALUMNO,count(*) NO_ASISTENCIAS FROM cedva_bd.k_asistencia a\n" +
//" where a.FG_ASISTIO = b'1'  AND a.ID_LISTA_ASISTENCIA = 5\n" +
//" group by a.ID_ALUMNO)e on e.ID_ALUMNO = a.ID_ALUMNO\n" +
//" left outer join (  SELECT a.ID_ALUMNO,count(*) NO_FALTAS FROM cedva_bd.k_asistencia a\n" +
//" where a.FG_ASISTIO = b'0' AND a.ID_LISTA_ASISTENCIA = 5\n" +
//" group by a.ID_ALUMNO) f on f.ID_ALUMNO =a.ID_ALUMNO" +
// "where d.ID_GRUPO = ? and  d.ID_LISTA_ASISTENCIA= ?");
                     
                     st =mysqlConnect.connect().prepareStatement(sql);
                     st.setInt(1, pID_GRUPO);
//                     st.setInt(1, ID_LISTA_ASISTENCIA);
                                


ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idAlumno = rs.getInt("ID_ALUMNO");  
 String clAlumno = rs.getString("CL_ALUMNO");  
 String nbAlumno = rs.getString("NB_ALUMNO"); 
// int noAsistencias = rs.getInt("NO_ASISTENCIAS");  
// int noFaltas = rs.getInt("NO_FALTAS");  

//
 asistencias.add(new E_ALUMNO_ASISTENCIA(clAlumno,idAlumno,nbAlumno,true,ID_LISTA_ASISTENCIA));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Asistencia_Selected.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
String col[] = {"Id","Matricula","Alumno","Asistio"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0){
            Class[] types = {
            Integer.class, String.class, String.class, Boolean.class          
        };
        // making sure that it returns boolean.class.   
        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };
    for (E_ALUMNO_ASISTENCIA s : asistencias) {
         Object[] objs = {s.getID_ALUMNO(),s.getCL_MATRICULA(),s.getNB_ALUMNO(),s.getFG_ASISTIO()};
         dtm.addRow( objs);
    }

//   
    jTable1.setModel(dtm);
//       jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                jTable1MouseClicked(evt);
//            }
//        });
       
    jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
    jTable1.getColumnModel().getColumn(0).setMinWidth(0);
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    public void clear(){
            txt_lista.setText(null);
            txt_profesor.setText(null);
    }
    
   public static void reiniciarJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
 
//        TableColumnModel modCol = Tabla.getColumnModel();
//        while(modCol.getColumnCount()>0)modCol.removeColumn(modCol.getColumn(0));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_lista = new javax.swing.JTextField();
        btn_lista = new javax.swing.JButton();
        grupo = new javax.swing.JLabel();
        txt_profesor = new javax.swing.JTextField();
        grupo1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btn_regresa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_suma = new javax.swing.JButton();
        btn_resta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txt_horario = new javax.swing.JTextField();
        grupo2 = new javax.swing.JLabel();
        txt_revisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(880, 400));
        setMinimumSize(new java.awt.Dimension(880, 400));
        setPreferredSize(new java.awt.Dimension(880, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txt_lista.setEditable(false);

        btn_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
            }
        });

        grupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grupo.setText("Lista de Asistencia:");

        txt_profesor.setEditable(false);

        grupo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grupo1.setText("Profesor:");

        btn_regresa.setText("Regresar");
        btn_regresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Fecha:");

        btn_suma.setText(">");
        btn_suma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sumaActionPerformed(evt);
            }
        });

        btn_resta.setText(" <");
        btn_resta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restaActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Matricula", "Alumno", "Asistio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txt_horario.setEditable(false);

        grupo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grupo2.setText("Horario:");

        txt_revisar.setText("Revisar");
        txt_revisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_revisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grupo2)
                                    .addComponent(grupo1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_profesor)
                                    .addComponent(txt_horario, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_resta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_suma))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txt_revisar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_regresa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_lista)
                        .addComponent(grupo))
                    .addComponent(btn_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_suma)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(btn_resta)
                        .addComponent(grupo1))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupo2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(btn_regresa)
                    .addComponent(txt_revisar))
                .addGap(145, 145, 145))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        Asistencia_Selected gs= new Asistencia_Selected(this);
        gs.setVisible(true);
        gs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_listaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int dia= jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mes= jDateChooser1.getCalendar().get(Calendar.MONTH)+1;
        int año= jDateChooser1.getCalendar().get(Calendar.YEAR);
        Fecha= (año + "-" + mes + "-" +dia);

//        if(jDateChooser1.getDate())

//            java.sql.Date FE_ASISTENCIA_ = (java.sql.Date)jDateChooser1.getDate();
            java.sql.Date FE_ASISTENCIA_ = java.sql.Date.valueOf( Fecha );
//        DELETE FROM k_asistencia where FE_ASISTENCIA= jdatechoser.getDate AND ID_LISTA_ASISTENCIA= ?;
//        PR
    
                try {
                     MySqlConnect mysqlConnect = new MySqlConnect();
                    String query="";
                    query = "delete from k_asistencia where FE_ASISTENCIA= ? AND ID_LISTA_ASISTENCIA= ?";
                    PreparedStatement preparedStmt;
                    preparedStmt = mysqlConnect.connect().prepareStatement(query);
                     preparedStmt.setDate(1, FE_ASISTENCIA_);                     
                     preparedStmt.setInt(2, ID_LISTA_ASISTENCIA);
                    preparedStmt.execute();
                    
                    mysqlConnect.connect().close();
                } catch (SQLException ex) {
                    Logger.getLogger(Toma_Asistencia.class.getName()).log(Level.SEVERE, null, ex);
                }                 
     
       ArrayList  <E_ALUMNO_ASISTENCIA> temp = new ArrayList<E_ALUMNO_ASISTENCIA>();
       
        for (int i = 0; i < jTable1.getRowCount(); i++) {
     int idAlumno = Integer.valueOf(jTable1.getValueAt(i, 0).toString());    
     Boolean isChecked = Boolean.valueOf(jTable1.getValueAt(i, 3).toString());     
     temp.add(new E_ALUMNO_ASISTENCIA(0,idAlumno,ID_PROFESOR,jDateChooser1.getDate(),isChecked,txt_lista.getText(),ID_LISTA_ASISTENCIA));
}
       
        MySqlConnect mysqlConnect = new MySqlConnect();
            String message="";

                message="Se agregaron"+" "+temp.size()+" "+"alumnos de manera adecuada";
        for (E_ALUMNO_ASISTENCIA e_alumno_asistencia : temp) {
           try {
            // agregar
            // the mysql insert statement
            String query="";

                query = " insert into k_asistencia (ID_ALUMNO, ID_PROFESOR, FE_ASISTENCIA, FG_ASISTIO, CL_PERIODO, ID_LISTA_ASISTENCIA)"
                    + " values (?, ?, ?, ?, ?, ?)";
                
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = mysqlConnect.connect().prepareStatement(query);
            preparedStmt.setInt(1, e_alumno_asistencia.getID_ALUMNO());
            preparedStmt.setInt (2, e_alumno_asistencia.getID_PROFESOR());
            preparedStmt.setString(3, Fecha);
            preparedStmt.setBoolean(4, e_alumno_asistencia.getFG_ASISTIO());
            preparedStmt.setString(5, e_alumno_asistencia.getCL_PERIODO());
            preparedStmt.setInt(6, ID_LISTA_ASISTENCIA);
            
            // execute the preparedstatement
            preparedStmt.execute();
            

   
        } catch (SQLException ex) {
            Logger.getLogger(Toma_Asistencia.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
        try {
            JOptionPane.showMessageDialog(rootPane,message );
            clear();
            reiniciarJTable(jTable1);
            mysqlConnect.connect().close();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_restaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restaActionPerformed
       
        

        Date nuevaFecha = new Date();
                 
                 Calendar cal = Calendar.getInstance(); 
                 cal.setTime(jDateChooser1.getDate()); 
                 cal.add(Calendar.DATE, -1);
                 nuevaFecha = cal.getTime();
                
                 if(FE_INICIO!=null && FE_FIN!=null)
                 {
                    if(nuevaFecha.after(FE_INICIO) ) {
                  jDateChooser1.setDate(nuevaFecha);
                }
        else 
        {
         JOptionPane.showMessageDialog(rootPane, "Fuera del intervalo de la lista de asistencia", "MENSAJE DE ADVETENCIA", JOptionPane.WARNING_MESSAGE);
        }
                 }
                 else 
                 {
                                   jDateChooser1.setDate(nuevaFecha);
                 }

        
    }//GEN-LAST:event_btn_restaActionPerformed

    private void btn_sumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sumaActionPerformed
         Date nuevaFecha = new Date();

        Calendar cal = Calendar.getInstance(); 
        cal.setTime(jDateChooser1.getDate()); 
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        nuevaFecha = cal.getTime();
          
                        if(FE_INICIO!=null && FE_FIN!=null)
                 {
                     int a = nuevaFecha.compareTo(FE_FIN);
        if(nuevaFecha.compareTo(FE_FIN) <=0) {
          jDateChooser1.setDate(nuevaFecha);
    /* historyDate <= todayDate <= futureDate */ 
            }

         else
         {
                  JOptionPane.showMessageDialog(rootPane, "Fuera del intervalo de la lista de asistencia", "MENSAJE DE ADVETENCIA", JOptionPane.WARNING_MESSAGE);

         }
                 }
                         else 
                 {
                                   jDateChooser1.setDate(nuevaFecha);
                 }
    }//GEN-LAST:event_btn_sumaActionPerformed

    private void btn_regresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresaActionPerformed
          Menu regresar= new Menu();
//        regresar.setVisible(true);
        regresar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_btn_regresaActionPerformed

    private void txt_revisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_revisarActionPerformed
        Revisar_Asistencia revisa= new Revisar_Asistencia();
        revisa.setVisible(true);
        revisa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_txt_revisarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
        Menu m= new Menu();
               m.setLocationRelativeTo(null);
                m.setVisible(true);
    }//GEN-LAST:event_formWindowClosed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_regresa;
    private javax.swing.JButton btn_resta;
    private javax.swing.JButton btn_suma;
    private javax.swing.JLabel grupo;
    private javax.swing.JLabel grupo1;
    private javax.swing.JLabel grupo2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_horario;
    private javax.swing.JTextField txt_lista;
    private javax.swing.JTextField txt_profesor;
    private javax.swing.JButton txt_revisar;
    // End of variables declaration//GEN-END:variables


}
