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
import java.awt.Color;
import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author P3DR1TO
 */
public class Revisar_Asistencia extends javax.swing.JFrame {
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
     * Creates new form Revisar_Asistencia
     */
    public Revisar_Asistencia(int ID_PROFESOR, int ID_GRUPO) {
        initComponents();
        this.setLocationRelativeTo(null); 
    }
    
    public Revisar_Asistencia(){
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
         this.getContentPane().setBackground(Color.RED);
        this.setLocationRelativeTo(null); 
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
    
    public void setDataByListaAsistencia()
    {
        
        int dia= jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH);
        int mes= jDateChooser1.getCalendar().get(Calendar.MONTH)+1;
        int año= jDateChooser1.getCalendar().get(Calendar.YEAR);
        Fecha= (año + "-" + mes + "-" +dia);
        java.sql.Date FE_ASISTENCIA_ = java.sql.Date.valueOf( Fecha );
             asistencias.clear();
//         ID_LISTA_ASISTENCIA=0;
        
               MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
   PreparedStatement st = null ;
        String sql = "";
        try {
//      
//              sql = ("SELECT a.ID_ALUMNO,a.CL_ALUMNO, CONCAT(a.NB_PATERNO,' ',a.NB_MATERNO,' ',a.NB_ALUMNO) AS NB_ALUMNO FROM c_alumno a\n" +
//                        "where a.ID_GRUPO = ?");

              sql = (
"SELECT b.ID_ALUMNO, b.CL_ALUMNO,CONCAT(b.NB_PATERNO,' ',b.NB_MATERNO,' ',b.NB_ALUMNO) AS NB_ALUMNO, a.FG_ASISTIO, IFNULL(e.NO_ASISTENCIAS,0) NO_ASISTENCIAS,IFNULL(f.NO_FALTAS,0) NO_FALTAS FROM k_asistencia a \n" +
"inner join c_alumno b on a.ID_ALUMNO = b.ID_ALUMNO\n" +
"inner join c_lista_asistencia d on d.ID_LISTA_ASISTENCIA = a.ID_LISTA_ASISTENCIA\n" +
"inner join c_grupo c on c.ID_GRUPO = d.ID_GRUPO \n" +
"left outer join ( SELECT a.ID_ALUMNO,count(*) NO_ASISTENCIAS FROM k_asistencia a\n" +
" where a.FG_ASISTIO = b'1' AND a.FE_ASISTENCIA <= ?  AND a.ID_LISTA_ASISTENCIA = ? \n" +
" group by a.ID_ALUMNO)e on e.ID_ALUMNO = a.ID_ALUMNO\n" +
" left outer join (  SELECT a.ID_ALUMNO,count(*) NO_FALTAS FROM k_asistencia a\n" +
" where a.FG_ASISTIO = b'0'  AND a.FE_ASISTENCIA <= ? AND a.ID_LISTA_ASISTENCIA = ? \n" +
" group by a.ID_ALUMNO) f on f.ID_ALUMNO =a.ID_ALUMNO \n" +
 "where d.ID_GRUPO = ? and  d.ID_LISTA_ASISTENCIA = ? AND a.FE_ASISTENCIA = ?");
                     
                     st =mysqlConnect.connect().prepareStatement(sql);
                     st.setDate(1, FE_ASISTENCIA_);  
                     st.setInt(2, ID_LISTA_ASISTENCIA);                     

                     st.setDate(3, FE_ASISTENCIA_);
                     st.setInt(4, ID_LISTA_ASISTENCIA);                     

                     st.setInt(5, ID_GRUPO);
                     st.setInt(6, ID_LISTA_ASISTENCIA);
                     st.setDate(7, FE_ASISTENCIA_);



ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idAlumno = rs.getInt("ID_ALUMNO");  
 String clAlumno = rs.getString("CL_ALUMNO");  
 String nbAlumno = rs.getString("NB_ALUMNO"); 
  Boolean fgAsistio = rs.getBoolean("FG_ASISTIO"); 

 
 int noAsistencias = rs.getInt("NO_ASISTENCIAS");  
 int noFaltas = rs.getInt("NO_FALTAS");  

//
 asistencias.add(new E_ALUMNO_ASISTENCIA(clAlumno,idAlumno,nbAlumno,fgAsistio,ID_LISTA_ASISTENCIA,noAsistencias,noFaltas));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Asistencia_Selected.class.getName()).log(Level.SEVERE, null, ex);
        }
        

mysqlConnect.disconnect();
String col[] = {"Id","Matricula","Alumno","Asistencias","Faltas","Asistio"};
    DefaultTableModel dtm = new DefaultTableModel(col, 0){
            Class[] types = {
            Integer.class, String.class, String.class, Integer.class, Integer.class, Boolean.class           
        };
        // making sure that it returns boolean.class.   
        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };
    for (E_ALUMNO_ASISTENCIA s : asistencias) {
         Object[] objs = {s.getID_ALUMNO(),s.getCL_MATRICULA(),s.getNB_ALUMNO(),s.getNO_ASISTENCIAS(),s.getNO_FALTAS(),s.getFG_ASISTIO()};
         dtm.addRow( objs);
    }

//   
    jTable1.setModel(dtm);
   jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
       
            if( column==1)
            {
            for (E_ALUMNO_ASISTENCIA asistencia : asistencias) {
                if(asistencia.getCL_MATRICULA().equals(value.toString())){
                if(asistencia.getNO_FALTAS()==2)
                {
                  c.setBackground( Color.YELLOW);
                }
                if(asistencia.getNO_FALTAS()>= 3)
                {
                   c.setBackground( Color.RED);
                }
                 if(asistencia.getNO_FALTAS() < 2)
                {
                   c.setBackground( Color.WHITE);
                }
                            break;
                }
            }
        }
        return c;
    }
});
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

        grupo = new javax.swing.JLabel();
        txt_lista = new javax.swing.JTextField();
        btn_lista = new javax.swing.JButton();
        txt_profesor = new javax.swing.JTextField();
        grupo2 = new javax.swing.JLabel();
        txt_horario = new javax.swing.JTextField();
        grupo1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_reg = new javax.swing.JButton();
        btn_suma = new javax.swing.JButton();
        btn_resta = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        grupo.setText("Lista de Asistencia:");

        txt_lista.setEditable(false);

        btn_lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupita.jpg"))); // NOI18N
        btn_lista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listaActionPerformed(evt);
            }
        });

        txt_profesor.setEditable(false);

        grupo2.setText("Horario:");

        txt_horario.setEditable(false);

        grupo1.setText("Profesor:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Matricula", "Alumno", "Asistencias", "Faltas", "Asistio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btn_reg.setText("Regresar");
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Fecha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(264, 264, 264))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grupo2)
                            .addComponent(grupo1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_profesor)
                            .addComponent(txt_horario, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_resta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_suma)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_lista)
                        .addComponent(grupo))
                    .addComponent(btn_lista, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grupo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grupo2))
                    .addComponent(btn_suma)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btn_resta))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(178, 178, 178)
                .addComponent(btn_reg)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_listaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listaActionPerformed
        Asistencia_Selected gs= new Asistencia_Selected(this);
        gs.setVisible(true);
        gs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_listaActionPerformed

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
          Revisar_Asistencia atras= new Revisar_Asistencia();
        //        refresh.setVisible(true);
        atras.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dispose();

    }//GEN-LAST:event_btn_regActionPerformed

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
                setDataByListaAsistencia();
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
                setDataByListaAsistencia();

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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lista;
    private javax.swing.JButton btn_reg;
    private javax.swing.JButton btn_resta;
    private javax.swing.JButton btn_suma;
    private javax.swing.JLabel grupo;
    private javax.swing.JLabel grupo1;
    private javax.swing.JLabel grupo2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_horario;
    private javax.swing.JTextField txt_lista;
    private javax.swing.JTextField txt_profesor;
    // End of variables declaration//GEN-END:variables
}
