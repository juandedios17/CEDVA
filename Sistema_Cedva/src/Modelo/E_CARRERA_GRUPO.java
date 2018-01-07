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
public class E_CARRERA_GRUPO {
        private int ID_CARRERA_GRUPO;
        private int ID_CARRERA;
        private int ID_GRUPO;
        private String CL_GRUPO;
        private String NB_CARRERA;

        
        
 public E_CARRERA_GRUPO(int pID_CARRERA_GRUPO,int pID_CARRERA,int pID_GRUPO, String pCL_GRUPO,
         String pNB_CARRERA){
 this.setID_CARRERA_GRUPO(pID_CARRERA_GRUPO);
 this.setID_CARRERA(pID_CARRERA);
 this.setID_GRUPO(pID_GRUPO);
 this.setCL_GRUPO(pCL_GRUPO);
 this.setNB_CARRERA(pNB_CARRERA);
 }   

    /**
     * @return the ID_CARRERA_GRUPO
     */
    public int getID_CARRERA_GRUPO() {
        return ID_CARRERA_GRUPO;
    }

    /**
     * @param ID_CARRERA_GRUPO the ID_CARRERA_GRUPO to set
     */
    public void setID_CARRERA_GRUPO(int ID_CARRERA_GRUPO) {
        this.ID_CARRERA_GRUPO = ID_CARRERA_GRUPO;
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