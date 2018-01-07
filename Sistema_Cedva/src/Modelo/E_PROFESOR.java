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
public class E_PROFESOR {
        private int ID_PROFESOR;
        private String CL_PROFESOR;
        private String NB_PROFESOR;

        
 public E_PROFESOR(int pID_PROFESOR,
 String pCL_PROFESOR,
  String pNB_PROFESOR){
 this.setID_PROFESOR(pID_PROFESOR);
 this.setCL_PROFESOR(pCL_PROFESOR);
 this.setNB_PROFESOR(pNB_PROFESOR);
 }   
    /**
     * @return the ID_PROFESOR
     */
    public int getID_PROFESOR() {
        return ID_PROFESOR;
    }

    /**
     * @param ID_PROFESOR the ID_PROFESOR to set
     */
    public void setID_PROFESOR(int ID_PROFESOR) {
        this.ID_PROFESOR = ID_PROFESOR;
    }

    /**
     * @return the CL_PROFESOR
     */
    public String getCL_PROFESOR() {
        return CL_PROFESOR;
    }

    /**
     * @param CL_PROFESOR the CL_PROFESOR to set
     */
    public void setCL_PROFESOR(String CL_PROFESOR) {
        this.CL_PROFESOR = CL_PROFESOR;
    }

    /**
     * @return the NB_PROFESOR
     */
    public String getNB_PROFESOR() {
        return NB_PROFESOR;
    }

    /**
     * @param NB_PROFESOR the NB_PROFESOR to set
     */
    public void setNB_PROFESOR(String NB_PROFESOR) {
        this.NB_PROFESOR = NB_PROFESOR;
    }
    
}
