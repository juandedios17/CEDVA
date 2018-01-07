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
public class E_MATERIA_GRUPO {
        private int ID_GRUPO_MATERIA;
        private int ID_MATERIA;
        private int ID_GRUPO;
        private String CL_GRUPO;
        private String NB_MATERIA;

        
        
 public E_MATERIA_GRUPO(int pID_GRUPO_MATERIA,int pID_MATERIA,int pID_GRUPO, String pCL_GRUPO,
         String pNB_MATERIA){
 this.setID_GRUPO_MATERIA(pID_GRUPO_MATERIA);
 this.setID_MATERIA(pID_MATERIA);
 this.setID_GRUPO(pID_GRUPO);
 this.setCL_GRUPO(pCL_GRUPO);
 this.setNB_MATERIA(pNB_MATERIA);
 }   

    /**
     * @return the ID_GRUPO_MATERIA
     */
    public int getID_GRUPO_MATERIA() {
        return ID_GRUPO_MATERIA;
    }

    /**
     * @param ID_GRUPO_MATERIA the ID_GRUPO_MATERIA to set
     */
    public void setID_GRUPO_MATERIA(int ID_GRUPO_MATERIA) {
        this.ID_GRUPO_MATERIA = ID_GRUPO_MATERIA;
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
    public String getCL_GRUPO() {
        return CL_GRUPO;
    }

    /**
     * @param NB_GRUPO the NB_GRUPO to set
     */
    public void setCL_GRUPO(String NB_GRUPO) {
        this.CL_GRUPO = NB_GRUPO;
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
  