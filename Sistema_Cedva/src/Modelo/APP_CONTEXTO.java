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
public  class APP_CONTEXTO {

    /**
     * @return the CL_USER
     */
    public static String getCL_USER() {
        return CL_USER;
    }

    /**
     * @param aCL_USER the CL_USER to set
     */
    public static void setCL_USER(String aCL_USER) {
        CL_USER = aCL_USER;
    }

    /**
     * @return the ID_USER
     */
    public static int getID_USER() {
        return ID_USER;
    }

    /**
     * @param aID_USER the ID_USER to set
     */
    public static void setID_USER(int aID_USER) {
        ID_USER = aID_USER;
    }

    
    private static String CL_USER;    
    private static int ID_USER;

   

    


}
