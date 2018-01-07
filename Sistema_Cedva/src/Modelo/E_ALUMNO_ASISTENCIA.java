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
public class E_ALUMNO_ASISTENCIA {

    /**
     * @return the NO_ASISTENCIAS
     */
    public int getNO_ASISTENCIAS() {
        return NO_ASISTENCIAS;
    }

    /**
     * @param NO_ASISTENCIAS the NO_ASISTENCIAS to set
     */
    public void setNO_ASISTENCIAS(int NO_ASISTENCIAS) {
        this.NO_ASISTENCIAS = NO_ASISTENCIAS;
    }

    /**
     * @return the NO_FALTAS
     */
    public int getNO_FALTAS() {
        return NO_FALTAS;
    }

    /**
     * @param NO_FALTAS the NO_FALTAS to set
     */
    public void setNO_FALTAS(int NO_FALTAS) {
        this.NO_FALTAS = NO_FALTAS;
    }

        private int ID_ASISTENCIA;
    private String CL_MATRICULA;
    private int ID_ALUMNO;    
    private int ID_PROFESOR;
    private Date FE_ASISTENCIA;
    private String CL_PERIODO;
    private int ID_LISTA_ASISTENCIA;
    private String NB_ALUMNO;
    private Boolean FG_ASISTIO;
        private int NO_ASISTENCIAS;
            private int NO_FALTAS;

    
    
    public E_ALUMNO_ASISTENCIA(String pCL_MATRICULA,int pID_ALUMNO,String pNB_ALUMNO,Boolean pFG_ASISTIO, int pID_LISTA_ASISTENCIA, int pNO_ASISTENCIA, int pNO_FALTAS)
    {
        this.setCL_MATRICULA(pCL_MATRICULA);
        this.setID_ALUMNO(pID_ALUMNO);
        this.setNB_ALUMNO(pNB_ALUMNO);
        this.setFG_ASISTIO(pFG_ASISTIO);
        this.setID_LISTA_ASISTENCIA(pID_LISTA_ASISTENCIA);
        this.setNO_ASISTENCIAS(pNO_ASISTENCIA);
         this.setNO_FALTAS(pNO_FALTAS);
    }
    
        public E_ALUMNO_ASISTENCIA(String pCL_MATRICULA,int pID_ALUMNO,String pNB_ALUMNO,Boolean pFG_ASISTIO, int pID_LISTA_ASISTENCIA)
    {
        this.setCL_MATRICULA(pCL_MATRICULA);
        this.setID_ALUMNO(pID_ALUMNO);
        this.setNB_ALUMNO(pNB_ALUMNO);
        this.setFG_ASISTIO(pFG_ASISTIO);
        this.setID_LISTA_ASISTENCIA(pID_LISTA_ASISTENCIA);
    }
    
    
        public E_ALUMNO_ASISTENCIA(int pID_ASISTENCIA,int pID_ALUMNO,int pID_PROFESOR,Date pFE_ASISTENCIA,Boolean pFG_ASISTIO,String pCL_PERIODO, int pID_LISTA_ASISTENCIA)
    {
        this.setID_ASISTENCIA(pID_ASISTENCIA);
        this.setID_ALUMNO(pID_ALUMNO);
        this.setID_PROFESOR(pID_PROFESOR);
        this.setFE_ASISTENCIA(pFE_ASISTENCIA);
        this.setFG_ASISTIO(pFG_ASISTIO);
        this.setCL_PERIODO(pCL_PERIODO);
        this.setID_LISTA_ASISTENCIA(pID_LISTA_ASISTENCIA);
    }
        public E_ALUMNO_ASISTENCIA()
    {
    }
    /**
     * @return the ID_ASISTENCIA
     */
    public int getID_ASISTENCIA() {
        return ID_ASISTENCIA;
    }

    /**
     * @param ID_ASISTENCIA the ID_ASISTENCIA to set
     */
    public void setID_ASISTENCIA(int ID_ASISTENCIA) {
        this.ID_ASISTENCIA = ID_ASISTENCIA;
    }

    /**
     * @return the CL_MATRICULA
     */
    public String getCL_MATRICULA() {
        return CL_MATRICULA;
    }

    /**
     * @param CL_MATRICULA the CL_MATRICULA to set
     */
    public void setCL_MATRICULA(String CL_MATRICULA) {
        this.CL_MATRICULA = CL_MATRICULA;
    }

    /**
     * @return the ID_ALUMNO
     */
    public int getID_ALUMNO() {
        return ID_ALUMNO;
    }

    /**
     * @param ID_ALUMNO the ID_ALUMNO to set
     */
    public void setID_ALUMNO(int ID_ALUMNO) {
        this.ID_ALUMNO = ID_ALUMNO;
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
     * @return the FE_ASISTENCIA
     */
    public Date getFE_ASISTENCIA() {
        return FE_ASISTENCIA;
    }

    /**
     * @param FE_ASISTENCIA the FE_ASISTENCIA to set
     */
    public void setFE_ASISTENCIA(Date FE_ASISTENCIA) {
        this.FE_ASISTENCIA = FE_ASISTENCIA;
    }

    /**
     * @return the CL_PERIODO
     */
    public String getCL_PERIODO() {
        return CL_PERIODO;
    }

    /**
     * @param CL_PERIODO the CL_PERIODO to set
     */
    public void setCL_PERIODO(String CL_PERIODO) {
        this.CL_PERIODO = CL_PERIODO;
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
     * @return the NB_ALUMNO
     */
    public String getNB_ALUMNO() {
        return NB_ALUMNO;
    }

    /**
     * @param NB_ALUMNO the NB_ALUMNO to set
     */
    public void setNB_ALUMNO(String NB_ALUMNO) {
        this.NB_ALUMNO = NB_ALUMNO;
    }

    /**
     * @return the FG_ASISTIO
     */
    public Boolean getFG_ASISTIO() {
        return FG_ASISTIO;
    }

    /**
     * @param FG_ASISTIO the FG_ASISTIO to set
     */
    public void setFG_ASISTIO(Boolean FG_ASISTIO) {
        this.FG_ASISTIO = FG_ASISTIO;
    }
    

    
    
}
