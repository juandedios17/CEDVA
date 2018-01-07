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
public class E_CARRERAS {
        private int ID_CARRERA;
        private String CL_CARRERA;
        private String NB_CARRERA;

        
        
 public E_CARRERAS(int pID_CARRERA,
 String pCL_CARRERA,
  String pNB_CARRERA){
 this.setID_CARRERA(pID_CARRERA);
 this.setCL_CARRERA(pCL_CARRERA);
 this.setNB_CARRERA(pNB_CARRERA);
 }   

    /**
     * @return the ID_CARRERA
     */
    public int getID_CARRERA() {
        return ID_CARRERA;
    }

    /**
     * @param ID_CARRERA the ID_CARRERA to set
     */
    public void setID_CARRERA(int ID_CARRERA) {
        this.ID_CARRERA = ID_CARRERA;
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
     * @return the NB_CARRERA
     */
    public String getNB_CARRERA() {
        return NB_CARRERA;
    }

    /**
     * @param NB_CARRERA the NB_CARRERA to set
     */
    public void setNB_CARRERA(String NB_CARRERA) {
        this.NB_CARRERA = NB_CARRERA;
    }



        
}
