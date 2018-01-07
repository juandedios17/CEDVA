/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.E_GRUPOS;
import Modelo.E_LISTA_ASISTENCIA;
import Modelo.E_PROFESOR;
import sistema_cedva.Profesor_Selected;
import Mysql.MySqlConnect;
import java.awt.Color;
import java.awt.event.WindowEvent;
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
public class Asistencia_Selected extends javax.swing.JFrame {
     ArrayList<E_PROFESOR> profesores= new ArrayList<E_PROFESOR>();
    ArrayList<E_GRUPOS> grupos= new ArrayList<E_GRUPOS>();
    ArrayList<E_LISTA_ASISTENCIA> listas= new ArrayList<E_LISTA_ASISTENCIA>();
    int ID_PROFESOR;
    String NB_PROFESOR;
    int ID_GRUPO;
    String DS_LISTA_ASISTENCIA;
    String NB_GRUPO;
    Date FE_INICIO; 
    Date FE_FIN;
    int ID_LISTA_ASISTENCIA;
    Toma_Asistencia lista;    
    Revisar_Asistencia revisarAsistencia;
    String clProceso ="";


    /**
     * Creates new form ASISTENCIA
     */
    public Asistencia_Selected(int ID_PROFESOR, int ID_GRUPO, String DS_LISTA_ASISTENCIA, String NB_GRUPO)
    {
        initComponents();
        this.setLocationRelativeTo(null); 
  
   
    }
    
    public Asistencia_Selected(Toma_Asistencia lista) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.lista=lista;
        this.setLocationRelativeTo(null);
        clProceso = "TOMA";
        loadData();
    }
    
        public Asistencia_Selected(Revisar_Asistencia obj) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.getContentPane().setBackground(Color.RED);
        this.revisarAsistencia=obj;
        this.setLocationRelativeTo(null);
                clProceso = "REVISAR";

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
            Logger.getLogger(Asistencia_Selected.class.getName()).log(Level.SEVERE, null, ex);
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
                  NB_GRUPO= e_lista_asistencia.getNB_GRUPO();
                  DS_LISTA_ASISTENCIA= e_lista_asistencia.getDS_LISTA();
                  NB_PROFESOR= e_lista_asistencia.getNB_PROFESOR();
                  FE_INICIO= e_lista_asistencia.getFE_INICIO();
                  FE_FIN= e_lista_asistencia.getFE_FIN();

                  break;
             }
         }

    }
   

        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu_Ver_Listas = new javax.swing.JMenuItem();
        Menu_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(730, 375));
        setPreferredSize(new java.awt.Dimension(730, 375));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_guardar.setText("Seleccionar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 680, 220));

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setFont(new java.awt.Font("Leelawadee", 1, 14)); // NOI18N

        jMenu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenu1.setText("Opciones");
        jMenu1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N

        Menu_Ver_Listas.setText("Ver Listas de Asistencia");
        Menu_Ver_Listas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Ver_ListasActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Ver_Listas);

        Menu_Salir.setText("Regresar");
        jMenu1.add(Menu_Salir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu_Ver_ListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Ver_ListasActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_Menu_Ver_ListasActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
         if(ID_LISTA_ASISTENCIA!=0)
        {
if(clProceso.equals("TOMA"))
{
            lista.setIdLista(ID_LISTA_ASISTENCIA);
            lista.setNbLista(DS_LISTA_ASISTENCIA);
            lista.setNbProfesor(NB_PROFESOR);
            lista.setIdProf(ID_PROFESOR);
            lista.setHorario(NB_GRUPO);
            lista.setIdHorario(ID_GRUPO);
            lista.setFE_INICIO(FE_INICIO);            
            lista.setFE_FIN(FE_FIN);

            lista.setDataByListaAsistencia(ID_GRUPO);
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
}

if(clProceso.equals("REVISAR"))
{
            revisarAsistencia.setIdLista(ID_LISTA_ASISTENCIA);
            revisarAsistencia.setNbLista(DS_LISTA_ASISTENCIA);
            revisarAsistencia.setNbProfesor(NB_PROFESOR);
            revisarAsistencia.setIdProf(ID_PROFESOR);
            revisarAsistencia.setHorario(NB_GRUPO);
            revisarAsistencia.setIdHorario(ID_GRUPO);
            revisarAsistencia.setFE_INICIO(FE_INICIO);            
            revisarAsistencia.setFE_FIN(FE_FIN);

            revisarAsistencia.setDataByListaAsistencia();
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
}
        }
        else
        {
            Icon image= new ImageIcon(getClass().getResource("/imagenes/selecciona_sin_f.png"));
            JOptionPane.showMessageDialog(null, "Selecciona un registro","",JOptionPane.INFORMATION_MESSAGE,image);
            
        }
       

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

 public Date getDate(String pFecha)
 {
 java.util.Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(pFecha);
            return date;
//            jdc_fecha.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
                        return null;

        }
 
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Menu_Salir;
    private javax.swing.JMenuItem Menu_Ver_Listas;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
