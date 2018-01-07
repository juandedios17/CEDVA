/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author P3DR1TO
 */
public class E_LISTA_ASISTENCIA {

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
    private int ID_LISTA_ASISTENCIA;
    private int ID_PROFESOR;
    private int ID_GRUPO;
    private String NB_PROFESOR;
    private String NB_GRUPO;
    private Date FE_INICIO;
    private Date FE_FIN;
    private String DS_LISTA;

    
    public E_LISTA_ASISTENCIA( int pID_LISTA_ASISTENCIA, int pID_PROFESOR, int pID_GRUPO,
    String pNB_PROFESOR, String pNB_GRUPO,Date pFE_INICIO, Date pFE_FIN, String pDS_LISTA)
             {
    this.setID_LISTA_ASISTENCIA(pID_LISTA_ASISTENCIA);
    this.setID_PROFESOR(pID_PROFESOR);
    this.setID_GRUPO(pID_GRUPO);
    this.setNB_PROFESOR(pNB_PROFESOR);
    this.setNB_GRUPO(pNB_GRUPO);
    this.setFE_INICIO(pFE_INICIO);
    this.setFE_FIN(pFE_FIN);
    this.setDS_LISTA(pDS_LISTA);

            }
   
    public E_LISTA_ASISTENCIA( int pID_LISTA_ASISTENCIA, int pID_PROFESOR, int pID_GRUPO,
    String pNB_PROFESOR, String pNB_GRUPO)
             {
    this.setID_LISTA_ASISTENCIA(pID_LISTA_ASISTENCIA);
    this.setID_PROFESOR(pID_PROFESOR);
    this.setID_GRUPO(pID_GRUPO);
    this.setNB_PROFESOR(pNB_PROFESOR);
    this.setNB_GRUPO(pNB_GRUPO);

            }
    /**
     * @return the ID_LISTA_ASISTENCIA
     */
    public int getID_LISTA_ASISTENCIA() {
        return ID_LISTA_ASISTENCIA;
    }

    /**
     * @param ID_LISTA_ASISTENCIA the ID_LISTA_ASISTENCIA to set
     */
    public void setID_LISTA_ASISTENCIA(int ID_LISTA_ASISTENCIA) {
        this.ID_LISTA_ASISTENCIA = ID_LISTA_ASISTENCIA;
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
     * @return the FE_INICIO
     */
    public Date getFE_INICIO() {
        return FE_INICIO;
    }

    /**
     * @param FE_INICIO the FE_INICIO to set
     */
    public void setFE_INICIO(Date FE_INICIO) {
        this.FE_INICIO = FE_INICIO;
    }

    /**
     * @return the FE_FIN
     */
    public Date getFE_FIN() {
        return FE_FIN;
    }

    /**
     * @param FE_FIN the FE_FIN to set
     */
    public void setFE_FIN(Date FE_FIN) {
        this.FE_FIN = FE_FIN;
    }

    /**
     * @return the DS_LISTA
     */
    public String getDS_LISTA() {
        return DS_LISTA;
    }

    /**
     * @param DS_LISTA the DS_LISTA to set
     */
    public void setDS_LISTA(String DS_LISTA) {
        this.DS_LISTA = DS_LISTA;
    }
}
