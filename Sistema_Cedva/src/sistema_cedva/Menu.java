/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema_cedva;

import Modelo.APP_CONTEXTO;
import Modelo.E_USER_ROL;
import Mysql.MySqlConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author P3DR1TO
 */
public class Menu extends javax.swing.JFrame {
    ArrayList<E_USER_ROL> user_rol= new ArrayList<E_USER_ROL>();

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/Logo_JAR.png")).getImage());
        this.setLocationRelativeTo(this);
        
        
        String clUser = APP_CONTEXTO.getCL_USER();
//        String a = clUser;
          user_rol.clear();
               MySqlConnect mysqlConnect = new MySqlConnect();
//   Statement st;
   PreparedStatement st = null ;

        try {
//            st = mysqlConnect.connect().createStatement();

          String sql = "";


              sql = ("SELECT a.ID_USER_ROL,a.ID_USER,a.ID_ROL,b.CL_USER,c.NB_ROL,c.CL_ROL FROM c_usuario_rol a\n" +
"INNER JOIN c_usuario b on b.ID_USER=a.ID_USER\n" +
"inner JOIN c_rol c on c.ID_ROL = a.ID_ROL where b.CL_USER = ?");
                     
                     st =mysqlConnect.connect().prepareStatement(sql);
                     st.setString(1, clUser);
          
ResultSet rs = st.executeQuery();
while(rs.next()) { 
 int idUser_Rol = rs.getInt("ID_USER_ROL");  
 int idUser = rs.getInt("ID_USER");  
 int idRol = rs.getInt("ID_ROL");  
 String vclUser = rs.getString("CL_USER");  
 String nbRol = rs.getString("NB_ROL");  
 String clRol = rs.getString("CL_ROL"); 


 user_rol.add(new E_USER_ROL(idUser_Rol,idUser,vclUser,idRol,nbRol,clRol));
 
}
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btn_pros.setVisible(false);
        btn_asis.setVisible(false);
        btn_con_esc.setVisible(false);
        menu_alum.setVisible(false);
        menu_usuario.setVisible(false);
        menu_roles.setVisible(false);
        menu_grupo.setVisible(false);
        menu_prof.setVisible(false);
        menu_materia.setVisible(false);
        menu_carrera.setVisible(false);
        menu_catalogo.setVisible(false);
        menu_permiso.setVisible(false);
        Menu_Asignar.setVisible(false);
        Menu_Lista_Asis.setVisible(false);
        Menu_Gpo_Materia.setVisible(false);
        Menu_Gpo_Carr.setVisible(false);
        
 
        
        
        for (E_USER_ROL e_user_rol : user_rol) {
         switch(e_user_rol.getCL_ROL())
        {
             case "ing_mod_pros":
                 btn_pros.setVisible(true);
                 break;
                 
                 case "cat_alum":
                 menu_alum.setVisible(true);
                 break;
                              
                 case "cat_usu":
                 menu_usuario.setVisible(true);
                 break;
                              
                 case "cat_rol":
                 menu_roles.setVisible(true);
                 break;
                              
                 case "cat_prof":
                 menu_prof.setVisible(true);
                 break;
                              
                 case "cat_grup":
                 menu_grupo.setVisible(true);
                 break;
                              
                 case "cat_mat":
                 menu_materia.setVisible(true);
                 break;
                    
                 case "cat_carr":
                 menu_carrera.setVisible(true);
                 break;
                 
                 case "asig_per":
                 menu_permiso.setVisible(true);
                 break;
                              
                 case "ing_mod_asis":
                 btn_asis.setVisible(true);
                 break;
                               
                 case "ing_mod_con_es":
                 btn_con_esc.setVisible(true);
                 break;
                 
                 case "menu_cat":
                 menu_catalogo.setVisible(true);
                 break;
                 
                 case "menu_asig":
                 Menu_Asignar.setVisible(true);
                 break;
                 
                 case "menu_lista":
                 Menu_Lista_Asis.setVisible(true);
                 break;
                 
                 case "menu_gpo_mat":
                 Menu_Gpo_Materia.setVisible(true);
                 break;
                 
                 case "menu_carr_gpo":
                 Menu_Gpo_Carr.setVisible(true);
                 break;
                              default:break;
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

        btn_pros = new javax.swing.JButton();
        btn_asis = new javax.swing.JButton();
        btn_con_esc = new javax.swing.JButton();
        lbl_fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_Asis = new javax.swing.JMenu();
        menu_catalogo = new javax.swing.JMenu();
        menu_usuario = new javax.swing.JMenuItem();
        menu_roles = new javax.swing.JMenuItem();
        menu_alum = new javax.swing.JMenuItem();
        menu_prof = new javax.swing.JMenuItem();
        menu_grupo = new javax.swing.JMenuItem();
        menu_materia = new javax.swing.JMenuItem();
        menu_carrera = new javax.swing.JMenuItem();
        menu_permiso = new javax.swing.JMenu();
        JUser_Rol = new javax.swing.JMenuItem();
        Menu_Asignar = new javax.swing.JMenu();
        Menu_Lista_Asis = new javax.swing.JMenuItem();
        Menu_Gpo_Materia = new javax.swing.JMenuItem();
        Menu_Gpo_Carr = new javax.swing.JMenuItem();
        Menu_Gpos_Prof = new javax.swing.JMenuItem();
        menu_salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(690, 480));
        setName(""); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_pros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_1.jpg"))); // NOI18N
        btn_pros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prosActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pros, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 120, 140));

        btn_asis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asistencia.png"))); // NOI18N
        btn_asis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_asisActionPerformed(evt);
            }
        });
        getContentPane().add(btn_asis, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 120, 140));

        btn_con_esc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/con_esc.jpg"))); // NOI18N
        btn_con_esc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_con_escActionPerformed(evt);
            }
        });
        getContentPane().add(btn_con_esc, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 130, 140));

        lbl_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo_prin.jpg"))); // NOI18N
        lbl_fondo.setAlignmentY(0.0F);
        lbl_fondo.setMaximumSize(new java.awt.Dimension(690, 450));
        lbl_fondo.setMinimumSize(new java.awt.Dimension(690, 450));
        lbl_fondo.setPreferredSize(new java.awt.Dimension(690, 450));
        getContentPane().add(lbl_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 700, 490));

        Menu_Asis.setText("Opciones");

        menu_catalogo.setText("Catalogos");

        menu_usuario.setText("Usuarios");
        menu_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_usuarioActionPerformed(evt);
            }
        });
        menu_catalogo.add(menu_usuario);

        menu_roles.setText("Roles");
        menu_roles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_rolesActionPerformed(evt);
            }
        });
        menu_catalogo.add(menu_roles);

        menu_alum.setText("Alumnos");
        menu_alum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_alumActionPerformed(evt);
            }
        });
        menu_catalogo.add(menu_alum);

        menu_prof.setText("Profesores");
        menu_prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_profActionPerformed(evt);
            }
        });
        menu_catalogo.add(menu_prof);

        menu_grupo.setText("Grupos");
        menu_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_grupoActionPerformed(evt);
            }
        });
        menu_catalogo.add(menu_grupo);

        menu_materia.setText("Materias");
        menu_materia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_materiaMouseClicked(evt);
            }
        });
        menu_materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_materiaActionPerformed(evt);
            }
        });
        menu_catalogo.add(menu_materia);

        menu_carrera.setText("Carreras");
        menu_carrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_carreraActionPerformed(evt);
            }
        });
        menu_catalogo.add(menu_carrera);

        Menu_Asis.add(menu_catalogo);

        menu_permiso.setText("Permisos");

        JUser_Rol.setText("Asignar Roles");
        JUser_Rol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUser_RolActionPerformed(evt);
            }
        });
        menu_permiso.add(JUser_Rol);

        Menu_Asis.add(menu_permiso);

        Menu_Asignar.setText("Asignar");

        Menu_Lista_Asis.setText("Listas de Asistencia");
        Menu_Lista_Asis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Lista_AsisActionPerformed(evt);
            }
        });
        Menu_Asignar.add(Menu_Lista_Asis);

        Menu_Gpo_Materia.setText("Materias");
        Menu_Gpo_Materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Gpo_MateriaActionPerformed(evt);
            }
        });
        Menu_Asignar.add(Menu_Gpo_Materia);

        Menu_Gpo_Carr.setText("Carreras");
        Menu_Gpo_Carr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Gpo_CarrActionPerformed(evt);
            }
        });
        Menu_Asignar.add(Menu_Gpo_Carr);

        Menu_Gpos_Prof.setText("Grupos");
        Menu_Gpos_Prof.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_Gpos_ProfActionPerformed(evt);
            }
        });
        Menu_Asignar.add(Menu_Gpos_Prof);

        Menu_Asis.add(Menu_Asignar);

        menu_salir.setText("Salir");
        menu_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_salirActionPerformed(evt);
            }
        });
        Menu_Asis.add(menu_salir);

        jMenuBar1.add(Menu_Asis);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_prosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prosActionPerformed
        Prospecto frame =  new Prospecto();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_prosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void menu_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_usuarioActionPerformed

        // Es el menu de usuarios
        Usuarios otroframe = new Usuarios();
        otroframe.setVisible(true);
        otroframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_usuarioActionPerformed

    private void menu_materiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_materiaMouseClicked
        
         
    }//GEN-LAST:event_menu_materiaMouseClicked

    private void menu_materiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_materiaActionPerformed
        Materias mateframe = new Materias();
        mateframe.setVisible(true);
        mateframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_materiaActionPerformed

    private void menu_alumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_alumActionPerformed
        Alumno alumframe = new Alumno();
        alumframe.setVisible(true);
        alumframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_alumActionPerformed

    private void menu_profActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_profActionPerformed
        Profesor profeframe = new Profesor();
        profeframe.setVisible(true);
        profeframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_profActionPerformed

    private void menu_carreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_carreraActionPerformed
        Carrera carreraf = new Carrera();
        carreraf.setVisible(true);
        carreraf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_carreraActionPerformed

    private void menu_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_grupoActionPerformed
        Grupos gruframe = new Grupos();
        gruframe.setVisible(true);
        gruframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_grupoActionPerformed

    private void menu_rolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_rolesActionPerformed
        Roles rolframe = new Roles();
        rolframe.setVisible(true);
        rolframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menu_rolesActionPerformed

    private void menu_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_salirActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
int dialogResult = JOptionPane.showConfirmDialog(this, "¿Deseas salir del sistema?", "Confirmar", dialogButton);
if(dialogResult == 0) {
    Principal pant_ini = new Principal();
    pant_ini.setVisible(true);
    dispose();
}
else {

}

    }//GEN-LAST:event_menu_salirActionPerformed

    private void JUser_RolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUser_RolActionPerformed
        Permisos perframe = new Permisos();
        perframe.setVisible(true);
        perframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JUser_RolActionPerformed

    private void btn_asisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_asisActionPerformed
        Toma_Asistencia frame =  new Toma_Asistencia();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_asisActionPerformed

    private void Menu_Lista_AsisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Lista_AsisActionPerformed
        Asistencia frame =  new Asistencia();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Menu_Lista_AsisActionPerformed

    private void Menu_Gpo_MateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Gpo_MateriaActionPerformed
         Asignar_Materia frame =  new Asignar_Materia();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Menu_Gpo_MateriaActionPerformed

    private void Menu_Gpo_CarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Gpo_CarrActionPerformed
        Asignar_Carrera frame =  new Asignar_Carrera();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Menu_Gpo_CarrActionPerformed

    private void btn_con_escActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_con_escActionPerformed
        Control_Escolar frame =  new Control_Escolar();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_con_escActionPerformed

    private void Menu_Gpos_ProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_Gpos_ProfActionPerformed
        Asignar_Grupos frame =  new Asignar_Grupos();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Menu_Gpos_ProfActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JUser_Rol;
    private javax.swing.JMenu Menu_Asignar;
    private javax.swing.JMenu Menu_Asis;
    private javax.swing.JMenuItem Menu_Gpo_Carr;
    private javax.swing.JMenuItem Menu_Gpo_Materia;
    private javax.swing.JMenuItem Menu_Gpos_Prof;
    private javax.swing.JMenuItem Menu_Lista_Asis;
    private javax.swing.JButton btn_asis;
    private javax.swing.JButton btn_con_esc;
    private javax.swing.JButton btn_pros;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl_fondo;
    private javax.swing.JMenuItem menu_alum;
    private javax.swing.JMenuItem menu_carrera;
    private javax.swing.JMenu menu_catalogo;
    private javax.swing.JMenuItem menu_grupo;
    private javax.swing.JMenuItem menu_materia;
    private javax.swing.JMenu menu_permiso;
    private javax.swing.JMenuItem menu_prof;
    private javax.swing.JMenuItem menu_roles;
    private javax.swing.JMenuItem menu_salir;
    private javax.swing.JMenuItem menu_usuario;
    // End of variables declaration//GEN-END:variables
}
