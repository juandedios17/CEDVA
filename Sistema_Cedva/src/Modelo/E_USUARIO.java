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
public class E_USUARIO {

    private int ID_USER;
 private String CL_USER;
 private String NB_PASSWORD;
 private Boolean FG_ACTIVO;
 private String CL_ACTIVO;  
 
 public E_USUARIO(int pID_USER,
 String pCL_USER,
  String pNB_PASSWORD,
  Boolean pFG_ACTIVO,
  String pCL_ACTIVO  ){
 this.setID_USER(pID_USER);
 this.setCL_USER(pCL_USER);
 this.setNB_PASSWORD(pNB_PASSWORD);
 this.setFG_ACTIVO(pFG_ACTIVO);
 this.setCL_ACTIVO(pCL_ACTIVO);
 }
    /**
     * @return the ID_USER
     */
    public int getID_USER() {
        return ID_USER;
    }

    /**
     * @param ID_USER the ID_USER to set
     */
    public void setID_USER(int ID_USER) {
        this.ID_USER = ID_USER;
    }

    /**
     * @return the CL_USER
     */
    public String getCL_USER() {
        return CL_USER;
    }

    /**
     * @param CL_USER the CL_USER to set
     */
    public void setCL_USER(String CL_USER) {
        this.CL_USER = CL_USER;
    }

    /**
     * @return the NB_PASSWORD
     */
    public String getNB_PASSWORD() {
        return NB_PASSWORD;
    }

    /**
     * @param NB_PASSWORD the NB_PASSWORD to set
     */
    public void setNB_PASSWORD(String NB_PASSWORD) {
        this.NB_PASSWORD = NB_PASSWORD;
    }

    /**
     * @return the FG_ACTIVO
     */
    public Boolean getFG_ACTIVO() {
        return FG_ACTIVO;
    }

    /**
     * @param FG_ACTIVO the FG_ACTIVO to set
     */
    public void setFG_ACTIVO(Boolean FG_ACTIVO) {
        this.FG_ACTIVO = FG_ACTIVO;
    }

    /**
     * @return the CL_ACTIVO
     */
    public String getCL_ACTIVO() {
        return CL_ACTIVO;
    }

    /**
     * @param CL_ACTIVO the CL_ACTIVO to set
     */
    public void setCL_ACTIVO(String CL_ACTIVO) {
        this.CL_ACTIVO = CL_ACTIVO;
    }
    
  
}
