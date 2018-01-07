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
public class E_GRUPOS {
        private int ID_GRUPO;
        private String CL_GRUPO;
        private String NB_GRUPO;

        
        
 public E_GRUPOS(int pID_GRUPO,
 String pCL_GRUPO,
  String pNB_GRUPO){
 this.setID_GRUPO(pID_GRUPO);
 this.setCL_GRUPO(pCL_GRUPO);
 this.setNB_GRUPO(pNB_GRUPO);
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
     * @return the CL_GRUPO
     */
    public String getCL_GRUPO() {
        return CL_GRUPO;
    }

    /**
     * @param CL_GRUPO the CL_GRUPO to set
     */
    public void setCL_GRUPO(String CL_GRUPO) {
        this.CL_GRUPO = CL_GRUPO;
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
