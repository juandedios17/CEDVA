/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author P3DR1TO
 */
public class E_ALUMNO {

    /**
     * @return the ID_PROSPECTO
     */
    public int getID_PROSPECTO() {
        return ID_PROSPECTO;
    }

    /**
     * @param ID_PROSPECTO the ID_PROSPECTO to set
     */
    public void setID_PROSPECTO(int ID_PROSPECTO) {
        this.ID_PROSPECTO = ID_PROSPECTO;
    }

    /**
     * @return the CL_PROSPECTO
     */
    public String getCL_PROSPECTO() {
        return CL_PROSPECTO;
    }

    /**
     * @param CL_PROSPECTO the CL_PROSPECTO to set
     */
    public void setCL_PROSPECTO(String CL_PROSPECTO) {
        this.CL_PROSPECTO = CL_PROSPECTO;
    }
    private int ID_ALUMNO;
    private String CL_ALUMNO;
    private String NB_NOMBRE;
    private String NB_PATERNO;
    private String NB_MATERNO;
    private String CL_DIRECCION;
    private String FE_TRAMITE;
    private String CL_TELEFONO_CASA;
    private String CL_TELEFONO_CEL;
    private String CL_EMAIL;
    private String CL_CARRERA;
    private String FE_NACIMIENTO;
    private String NO_EDAD;
    private int ID_PROSPECTO;
    private String CL_PROSPECTO;
    private int ID_GRUPO;
    private String NB_GRUPO;
    
   public E_ALUMNO( int pID_ALUMNO, String pCL_ALUMNO, String pNB_NOMBRE,
    String pNB_PATERNO, String pNB_MATERNO, String pCL_DIRECCION,
    String pFE_TRAMITE, String pCL_TELEFONO_CASA, String pCL_TELEFONO_CEL,
    String pCL_EMAIL, String pCL_CARRERA,String pFE_NACIMIENTO,String pNO_EDAD,
      int pID_PROSPECTO,int pID_GRUPO)
//     int pID_PROSPECTO,String pCL_PROSPECTO)
            {
    this.setID_ALUMNO(pID_ALUMNO);
    this.setCL_ALUMNO(pCL_ALUMNO);
    this.setNB_NOMBRE(pNB_NOMBRE);
    this.setNB_PATERNO(pNB_PATERNO);
    this.setNB_MATERNO(pNB_MATERNO);
    this.setCL_DIRECCION(pCL_DIRECCION);
    this.setFE_TRAMITE(pFE_TRAMITE);
    this.setCL_TELEFONO_CASA(pCL_TELEFONO_CASA);
    this.setCL_TELEFONO_CEL(pCL_TELEFONO_CEL);
    this.setCL_EMAIL(pCL_EMAIL);
    this.setCL_CARRERA(pCL_CARRERA);
    this.setFE_NACIMIENTO(pFE_NACIMIENTO);
    this.setNO_EDAD(pNO_EDAD);
    this.setID_PROSPECTO(pID_PROSPECTO);
    this.setID_GRUPO(pID_GRUPO);
            }
   
   
    public E_ALUMNO( int pID_ALUMNO, String pCL_ALUMNO, String pNB_NOMBRE,
    String pNB_PATERNO, String pNB_MATERNO, String pCL_DIRECCION,
    String pFE_TRAMITE, String pCL_TELEFONO_CASA, String pCL_TELEFONO_CEL,
    String pCL_EMAIL, String pCL_CARRERA,String pFE_NACIMIENTO,String pNO_EDAD,
      int pID_PROSPECTO,int pID_GRUPO,String pCL_PROSPECTO,String pNB_GRUPO)
//     int pID_PROSPECTO,String pCL_PROSPECTO)
            {
    this.setID_ALUMNO(pID_ALUMNO);
    this.setCL_ALUMNO(pCL_ALUMNO);
    this.setNB_NOMBRE(pNB_NOMBRE);
    this.setNB_PATERNO(pNB_PATERNO);
    this.setNB_MATERNO(pNB_MATERNO);
    this.setCL_DIRECCION(pCL_DIRECCION);
    this.setFE_TRAMITE(pFE_TRAMITE);
    this.setCL_TELEFONO_CASA(pCL_TELEFONO_CASA);
    this.setCL_TELEFONO_CEL(pCL_TELEFONO_CEL);
    this.setCL_EMAIL(pCL_EMAIL);
    this.setCL_CARRERA(pCL_CARRERA);
    this.setFE_NACIMIENTO(pFE_NACIMIENTO);
    this.setNO_EDAD(pNO_EDAD);
    this.setID_PROSPECTO(pID_PROSPECTO);
    this.setID_GRUPO(pID_GRUPO);
    this.setCL_PROSPECTO(pCL_PROSPECTO);
    this.setNB_GRUPO(pNB_GRUPO);
            }
    
    /**
     * @return the ID_ALUMNO
     */
    public int getID_ALUMNO() {
        return ID_ALUMNO;
    }

    /**
     * @param ID_ALUMNO the ID_ALUMNO to set
     */
    public void setID_ALUMNO(int ID_ALUMNO) {
        this.ID_ALUMNO = ID_ALUMNO;
    }

    /**
     * @return the CL_ALUMNO
     */
    public String getCL_ALUMNO() {
        return CL_ALUMNO;
    }

    /**
     * @param CL_ALUMNO the CL_ALUMNO to set
     */
    public void setCL_ALUMNO(String CL_ALUMNO) {
        this.CL_ALUMNO = CL_ALUMNO;
    }

    /**
     * @return the NB_NOMBRE
     */
    public String getNB_NOMBRE() {
        return NB_NOMBRE;
    }

    /**
     * @param NB_NOMBRE the NB_NOMBRE to set
     */
    public void setNB_NOMBRE(String NB_NOMBRE) {
        this.NB_NOMBRE = NB_NOMBRE;
    }

    /**
     * @return the NB_PATERNO
     */
    public String getNB_PATERNO() {
        return NB_PATERNO;
    }

    /**
     * @param NB_PATERNO the NB_PATERNO to set
     */
    public void setNB_PATERNO(String NB_PATERNO) {
        this.NB_PATERNO = NB_PATERNO;
    }

    /**
     * @return the NB_MATERNO
     */
    public String getNB_MATERNO() {
        return NB_MATERNO;
    }

    /**
     * @param NB_MATERNO the NB_MATERNO to set
     */
    public void setNB_MATERNO(String NB_MATERNO) {
        this.NB_MATERNO = NB_MATERNO;
    }

    /**
     * @return the CL_DIRECCION
     */
    public String getCL_DIRECCION() {
        return CL_DIRECCION;
    }

    /**
     * @param CL_DIRECCION the CL_DIRECCION to set
     */
    public void setCL_DIRECCION(String CL_DIRECCION) {
        this.CL_DIRECCION = CL_DIRECCION;
    }

    /**
     * @return the FE_TRAMITE
     */
    public String getFE_TRAMITE() {
        return FE_TRAMITE;
    }

    /**
     * @param FE_TRAMITE the FE_TRAMITE to set
     */
    public void setFE_TRAMITE(String FE_TRAMITE) {
        this.FE_TRAMITE = FE_TRAMITE;
    }

    /**
     * @return the CL_TELEFONO_CASA
     */
    public String getCL_TELEFONO_CASA() {
        return CL_TELEFONO_CASA;
    }

    /**
     * @param CL_TELEFONO_CASA the CL_TELEFONO_CASA to set
     */
    public void setCL_TELEFONO_CASA(String CL_TELEFONO_CASA) {
        this.CL_TELEFONO_CASA = CL_TELEFONO_CASA;
    }

    /**
     * @return the CL_TELEFONO_CEL
     */
    public String getCL_TELEFONO_CEL() {
        return CL_TELEFONO_CEL;
    }

    /**
     * @param CL_TELEFONO_CEL the CL_TELEFONO_CEL to set
     */
    public void setCL_TELEFONO_CEL(String CL_TELEFONO_CEL) {
        this.CL_TELEFONO_CEL = CL_TELEFONO_CEL;
    }

    /**
     * @return the CL_EMAIL
     */
    public String getCL_EMAIL() {
        return CL_EMAIL;
    }

    /**
     * @param CL_EMAIL the CL_EMAIL to set
     */
    public void setCL_EMAIL(String CL_EMAIL) {
        this.CL_EMAIL = CL_EMAIL;
    }

    /**
     * @return the CL_CARRERA
     */
    public String getCL_CARRERA() {
        return CL_CARRERA;
    }

    /**
     * @param CL_CARRERA the CL_CARRERA to set
     */
    public void setCL_CARRERA(String CL_CARRERA) {
        this.CL_CARRERA = CL_CARRERA;
    }

    /**
     * @return the FE_NACIMIENTO
     */
    public String getFE_NACIMIENTO() {
        return FE_NACIMIENTO;
    }

    /**
     * @param FE_NACIMIENTO the FE_NACIMIENTO to set
     */
    public void setFE_NACIMIENTO(String FE_NACIMIENTO) {
        this.FE_NACIMIENTO = FE_NACIMIENTO;
    }

    /**
     * @return the NO_EDAD
     */
    public String getNO_EDAD() {
        return NO_EDAD;
    }

    /**
     * @param NO_EDAD the NO_EDAD to set
     */
    public void setNO_EDAD(String NO_EDAD) {
        this.NO_EDAD = NO_EDAD;
    }

    /**
     * @return the ID_GRUPO
     */
    public int getID_GRUPO() {
        return ID_GRUPO;
    }

    /**
     * @param ID_GRUPO the ID_GRUPO to set
     */
    public void setID_GRUPO(int ID_GRUPO) {
        this.ID_GRUPO = ID_GRUPO;
    }

    /**
     * @return the NB_GRUPO
     */
    public String getNB_GRUPO() {
        return NB_GRUPO;
    }

    /**
     * @param NB_GRUPO the NB_GRUPO to set
     */
    public void setNB_GRUPO(String NB_GRUPO) {
        this.NB_GRUPO = NB_GRUPO;
    }
}
