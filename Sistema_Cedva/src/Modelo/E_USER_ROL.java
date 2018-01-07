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
public class E_USER_ROL {

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
     * @return the NB_USER
     */
    public String getNB_USER() {
        return NB_USER;
    }

    /**
     * @param NB_USER the NB_USER to set
     */
    public void setNB_USER(String NB_USER) {
        this.NB_USER = NB_USER;
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
     private int ID_USER_ROL;
     private int ID_USER;     
     private String NB_USER;
     private int ID_ROL;
     private String NB_ROL;     
     private String CL_ROL;



 public E_USER_ROL( int pID_USER_ROL,int pID_USER,String pNB_USER,int pID_ROL,String pNB_ROL)
            {
    this.setID_USER_ROL(pID_USER_ROL);
    this.setID_USER(pID_USER);    
    this.setNB_USER(pNB_USER);
    this.setID_ROL(pID_ROL);
    this.setNB_ROL(pNB_ROL);
    }
 
  public E_USER_ROL( int pID_USER_ROL,int pID_USER,String pNB_USER,int pID_ROL,String pNB_ROL,String pCL_ROL)
            {
    this.setID_USER_ROL(pID_USER_ROL);
    this.setID_USER(pID_USER);    
    this.setNB_USER(pNB_USER);
    this.setID_ROL(pID_ROL);
    this.setNB_ROL(pNB_ROL);    
    this.setNB_ROL(pNB_ROL);
    this.setCL_ROL(pCL_ROL);
    }


    /**
     * @return the ID_USER_ROL
     */
    public int getID_USER_ROL() {
        return ID_USER_ROL;
    }

    /**
     * @param ID_USER_ROL the ID_USER_ROL to set
     */
    public void setID_USER_ROL(int ID_USER_ROL) {
        this.ID_USER_ROL = ID_USER_ROL;
    }    

    /**
     * @return the ID_USER
     */

}

