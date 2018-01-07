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
public class E_MATERIAS {
        private int ID_MATERIA;
        private String CL_MATERIA;
        private String NB_MATERIA;

        
        
 public E_MATERIAS(int pID_MATERIA,
 String pCL_MATERIA,
  String pNB_MATERIA){
 this.setID_MATERIA(pID_MATERIA);
 this.setCL_MATERIA(pCL_MATERIA);
 this.setNB_MATERIA(pNB_MATERIA);
 }   
    /**
     * @return the ID_MATERIA
     */
    public int getID_MATERIA() {
        return ID_MATERIA;
    }

    /**
     * @param ID_MATERIA the ID_MATERIA to set
     */
    public void setID_MATERIA(int ID_MATERIA) {
        this.ID_MATERIA = ID_MATERIA;
    }

    /**
     * @return the CL_MATERIA
     */
    public String getCL_MATERIA() {
        return CL_MATERIA;
    }

    /**
     * @param CL_MATERIA the CL_MATERIA to set
     */
    public void setCL_MATERIA(String CL_MATERIA) {
        this.CL_MATERIA = CL_MATERIA;
    }

    /**
     * @return the NB_MATERIA
     */
    public String getNB_MATERIA() {
        return NB_MATERIA;
    }

    /**
     * @param NB_MATERIA the NB_MATERIA to set
     */
    public void setNB_MATERIA(String NB_MATERIA) {
        this.NB_MATERIA = NB_MATERIA;
    }
        
        
        
}
