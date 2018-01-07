/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.E_ALUMNO_ASISTENCIA;
import Modelo.E_CARRERAS;
import Modelo.E_GRUPOS;
import Modelo.E_LISTA_ASISTENCIA;
import Modelo.E_MATERIAS;
import Modelo.E_PROFESOR;
import Mysql.MySqlConnect;
import java.awt.Color;
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

/**
 *
 * @author P3DR1TO
 */
public class Control_Escolar extends javax.swing.JFrame {
    ArrayList<E_PROFESOR> profesores= new ArrayList<E_PROFESOR>();
    ArrayList<E_CARRERAS> carrera= new ArrayList<E_CARRERAS>();
    ArrayList<E_MATERIAS> materias= new ArrayList<E_MATERIAS>();
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
    ArrayList<E_LISTA_ASISTENCIA> listas= new ArrayList<E_LISTA_ASISTENCIA>();
    int ID_PROFESOR;
    int ID_GRUPO;
    int ID_LISTA_ASISTENCIA;
    int ID_CARRERA;
    int ID_MATERIA;
    int ID_ASISTENCIA;
    ArrayList<E_ALUMNO_ASISTENCIA>asistencias=new ArrayList<E_ALUMNO_ASISTENCIA>();
    /**
     * Creates new form Toma_Asistencia
     */
    public Control_Escolar(int ID_PROFESOR, int ID_GRUPO)
    {
        initComponents();
        this.setLocationRelativeTo(null); 
    }
    
    
    
    public Control_Escolar() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(this);
    }
    
    
    
    public void setNbMateria(String x)
    {
    txt_materia.setText(x);
    }

        public void setIdMateria(int pIdMateria)
    {
        this.ID_MATERIA=pIdMateria;
    }
        
        public void setEditMateria(int pIdMateria)
    {
        this.ID_MATERIA=pIdMateria;
        for (E_MATERIAS e_materias: materias) {
            if(e_materias.getID_MATERIA()==pIdMateria)
            {
              txt_materia.setText(e_materias.getNB_MATERIA());
            }
        }}
        
      
//        
//         public void setNbMateria(String x)
//    {
//    txt_materia.setText(x);
//    }
//
//        public void setIdMateria(int pIdMateria)
//    {
//        this.ID_LISTA_ASISTENCIA=pIdMateria;
//    }
//        
//        public void setEditLista(int pIdLista)
//    {
//        this.ID_LISTA_ASISTENCIA=pIdLista;
//        for (E_LISTA_ASISTENCIA e_lista_asistencia: listas) {
//            if(e_lista_asistencia.getID_LISTA_ASISTENCIA()==pIdLista)
//            {
//              txt_carrera.setText(e_lista_asistencia.getDS_LISTA());
//            }
//        }}
//        
//         public void setHorario(String z)
//    {
//    txt_profesor.setText(z);
//    }
//
//        public void setIdHorario(int pIdHora)
//    {
//        this.ID_GRUPO=pIdHora;
//    }
//        
//        public void setEditHora(int pIdHora)
//    {
//        this.ID_GRUPO=pIdHora;
//        for (E_GRUPOS e_grupos: grupos) {
//            if(e_grupos.getID_GRUPO()==pIdHora)
//            {
//              txt_profesor.setText(e_grupos.getNB_GRUPO());
//            }
//        }}

  
    
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
                     
                     st =mysqlConnect.connect().prepareStatement(sql);
                     st.setInt(1, pID_GRUPO);
         


ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idAlumno = rs.getInt("ID_ALUMNO");  
 String clAlumno = rs.getString("CL_ALUMNO");  
 String nbAlumno = rs.getString("NB_ALUMNO");  

//
 asistencias.add(new E_ALUMNO_ASISTENCIA(clAlumno,idAlumno,nbAlumno,true,ID_LISTA_ASISTENCIA));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Asistencia_Selected.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
String col[] = {"Id","Matricula","Alumno","Asistio"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0){
           
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
    ExcelAdapter myAd = new ExcelAdapter(jTable1);
    }

    public void clear(){
            txt_materia.setText(null);
            txt_carrera.setText(null);
    }
    
   public static void reiniciarJTable(javax.swing.JTable Tabla){
        DefaultTableModel modelo = (DefaultTableModel) Tabla.getModel();
        while(modelo.getRowCount()>0)modelo.removeRow(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_materia = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        grupo = new javax.swing.JLabel();
        txt_carrera = new javax.swing.JTextField();
        grupo1 = new javax.swing.JLabel();
        btn_regmenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_calcular = new javax.swing.JButton();
        txt_profesor = new javax.swing.JTextField();
        grupo2 = new javax.swing.JLabel();
        txt_calif = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_cal_pro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_calcular1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 530));

        txt_materia.setEditable(false);

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        grupo.setText("Materia:");

        txt_carrera.setEditable(false);

        grupo1.setText("Carrera:");

        btn_regmenu.setText("Regresar");
        btn_regmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regmenuActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Matricula", "Alumno", "1er Parcial", "2do Parcial", "3er Parcial", "Final"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_calcular.setText("Calcular");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        txt_profesor.setEditable(false);

        grupo2.setText("Profesor:");

        jLabel1.setText("Calificación Grupal:");

        jLabel2.setText("Desempeño Profesor:");

        btn_calcular1.setText("Guardar");
        btn_calcular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcular1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(grupo2)
                                    .addComponent(grupo1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_carrera)
                                    .addComponent(txt_materia, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btn_regmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_calcular1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_calcular))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cal_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_calif, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_materia)
                        .addComponent(grupo))
                    .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupo2))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cal_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_calif, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_regmenu)
                    .addComponent(btn_calcular)
                    .addComponent(btn_calcular1))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        Buscar_MateriasCE bm= new Buscar_MateriasCE(this);
        bm.setVisible(true);
        bm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed

        
    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_regmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regmenuActionPerformed
        Menu refresh= new Menu();
        //        refresh.setVisible(true);
        refresh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_btn_regmenuActionPerformed

    private void btn_calcular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcular1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_calcular1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Control_Escolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Control_Escolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Control_Escolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Control_Escolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Control_Escolar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_calcular1;
    private javax.swing.JButton btn_regmenu;
    private javax.swing.JLabel grupo;
    private javax.swing.JLabel grupo1;
    private javax.swing.JLabel grupo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_cal_pro;
    private javax.swing.JTextField txt_calif;
    private javax.swing.JTextField txt_carrera;
    private javax.swing.JTextField txt_materia;
    private javax.swing.JTextField txt_profesor;
    // End of variables declaration//GEN-END:variables


}
