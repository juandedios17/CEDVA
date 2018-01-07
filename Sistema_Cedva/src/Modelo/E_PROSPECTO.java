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
public class E_PROSPECTO {
    private int ID_PROSPECTO;
    private String CL_PROSPECTO;
    private String NB_NOMBRE;
    private String NB_PATERNO;
    private String NB_MATERNO;
    private String CL_COLONIA;
    private String FE_TRAMITE;
    private String CL_TELEFONO_CASA;
    private String CL_TELEFONO_CEL;
    private String CL_EMAIL;
    private String CL_MEDIO_PROMO;
    private String NB_CARRERA;
    private String DS_SEGUIMIENTO;
    private boolean FG_INSCRITO; 
    private String CL_INSCRITO;
    private String NB_ATENDIO;

    
    public E_PROSPECTO( int pID_PROSPECTO, String pCL_PROSPECTO, String pNB_NOMBRE,
    String pNB_PATERNO, String pNB_MATERNO, String pCL_COLONIA,
    String pFE_TRAMITE, String pCL_TELEFONO_CASA, String pCL_TELEFONO_CEL,
    String pCL_EMAIL, String pCL_MEDIO_PROMO, String pNB_CARRERA,
    String pDS_SEGUIMIENTO, boolean pFG_INSCRITO, String pCL_INSCRITO, String pNB_ATENDIO)
    {
    this.setID_PROSPECTO(pID_PROSPECTO);
    this.setCL_PROSPECTO(pCL_PROSPECTO);
    this.setNB_NOMBRE(pNB_NOMBRE);
    this.setNB_PATERNO(pNB_PATERNO);
    this.setNB_MATERNO(pNB_MATERNO);
    this.setCL_COLONIA(pCL_COLONIA);
    this.setFE_TRAMITE(pFE_TRAMITE);
    this.setCL_TELEFONO_CASA(pCL_TELEFONO_CASA);
    this.setCL_TELEFONO_CEL(pCL_TELEFONO_CEL);
    this.setCL_EMAIL(pCL_EMAIL);
    this.setCL_MEDIO_PROMO(pCL_MEDIO_PROMO);
    this.setNB_CARRERA(pNB_CARRERA);
    this.setDS_SEGUIMIENTO(pDS_SEGUIMIENTO);
    this.setFG_INSCRITO(pFG_INSCRITO);
    this.setCL_INSCRITO(pCL_INSCRITO);
    this.setNB_ATENDIO(pNB_ATENDIO);
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
     * @return the CL_COLONIA
     */
    public String getCL_COLONIA() {
        return CL_COLONIA;
    }

    /**
     * @param CL_COLONIA the CL_COLONIA to set
     */
    public void setCL_COLONIA(String CL_COLONIA) {
        this.CL_COLONIA = CL_COLONIA;
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
     * @return the CL_MEDIO_PROMO
     */
    public String getCL_MEDIO_PROMO() {
        return CL_MEDIO_PROMO;
    }

    /**
     * @param CL_MEDIO_PROMO the CL_MEDIO_PROMO to set
     */
    public void setCL_MEDIO_PROMO(String CL_MEDIO_PROMO) {
        this.CL_MEDIO_PROMO = CL_MEDIO_PROMO;
    }

    /**
     * @return the CL_CARRERA
     */
    public String getNB_CARRERA() {
        return NB_CARRERA;
    }

    /**
     * @param NB_CARRERA the CL_CARRERA to set
     */
    public void setNB_CARRERA(String CL_CARRERA) {
        this.NB_CARRERA = CL_CARRERA;
    }

    /**
     * @return the DS_SEGUIMIENTO
     */
    public String getDS_SEGUIMIENTO() {
        return DS_SEGUIMIENTO;
    }

    /**
     * @param DS_SEGUIMIENTO the DS_SEGUIMIENTO to set
     */
    public void setDS_SEGUIMIENTO(String DS_SEGUIMIENTO) {
        this.DS_SEGUIMIENTO = DS_SEGUIMIENTO;
    }

    /**


    /**
     * @return the NB_ATENDIO
     */
    public String getNB_ATENDIO() {
        return NB_ATENDIO;
    }

    /**
     * @param NB_ATENDIO the NB_ATENDIO to set
     */
    public void setNB_ATENDIO(String NB_ATENDIO) {
        this.NB_ATENDIO = NB_ATENDIO;
    }

    /**
     * @return the FG_INSCRITO
     */
    public boolean isFG_INSCRITO() {
        return FG_INSCRITO;
    }

    /**
     * @param FG_INSCRITO the FG_INSCRITO to set
     */
    public void setFG_INSCRITO(boolean FG_INSCRITO) {
        this.FG_INSCRITO = FG_INSCRITO;
    }

    /**
     * @return the CL_INSCRITO
     */
    public String getCL_INSCRITO() {
        return CL_INSCRITO;
    }

    /**
     * @param CL_INSCRITO the CL_INSCRITO to set
     */
    public void setCL_INSCRITO(String CL_INSCRITO) {
        this.CL_INSCRITO = CL_INSCRITO;
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
}
