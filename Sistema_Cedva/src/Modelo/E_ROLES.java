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
public class E_ROLES {
        private int ID_ROL;
        private String CL_ROL;
        private String NB_ROL;

        
        
 public E_ROLES(int pID_ROL,
 String pCL_ROL,
  String pNB_ROL){
 this.setID_ROL(pID_ROL);
 this.setCL_ROL(pCL_ROL);
 this.setNB_ROL(pNB_ROL);
 }   

    /**
     * @return the ID_ROL
     */
    public int getID_ROL() {
        return ID_ROL;
    }

    /**
     * @param ID_ROL the ID_ROL to set
     */
    public void setID_ROL(int ID_ROL) {
        this.ID_ROL = ID_ROL;
    }

    /**
     * @return the CL_ROL
     */
    public String getCL_ROL() {
        return CL_ROL;
    }

    /**
     * @param CL_ROL the CL_ROL to set
     */
    public void setCL_ROL(String CL_ROL) {
        this.CL_ROL = CL_ROL;
    }

    /**
     * @return the NB_ROL
     */
    public String getNB_ROL() {
        return NB_ROL;
    }

    /**
     * @param NB_ROL the NB_ROL to set
     */
    public void setNB_ROL(String NB_ROL) {
        this.NB_ROL = NB_ROL;
    }

    
}
