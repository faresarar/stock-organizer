/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author pc
 */
public class Paramaitre {
    
    String nom_magasin;
    String adresse_p;
    String num_tel_fax_fix_p;
    String num_tel1_p;
    String message;
    String num_tel2_p;
    String NIS;
    String NRC;
    String NIF;
    String RIB;
    int apercu_ticket;

    public int getApercu_ticket() {
        return apercu_ticket;
    }

    public void setApercu_ticket(int apercu_ticket) {
        this.apercu_ticket = apercu_ticket;
    }

    public String getRIB() {
        return RIB;
    }

    public void setRIB(String RIB) {
        this.RIB = RIB;
    }
    String activite;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAdresse_p() {
        return adresse_p;
    }

    public void setAdresse_p(String adresse_p) {
        this.adresse_p = adresse_p;
    }

    public String getNum_tel_fax_fix_p() {
        return num_tel_fax_fix_p;
    }

    public void setNum_tel_fax_fix_p(String num_tel_fax_fix_p) {
        this.num_tel_fax_fix_p = num_tel_fax_fix_p;
    }

    public String getNum_tel1_p() {
        return num_tel1_p;
    }

    public void setNum_tel1_p(String num_tel1_p) {
        this.num_tel1_p = num_tel1_p;
    }

    public String getNum_tel2_p() {
        return num_tel2_p;
    }

    public void setNum_tel2_p(String num_tel2_p) {
        this.num_tel2_p = num_tel2_p;
    }
  

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public Paramaitre(String nom_magasin, String adresse, String num_tel_fax_fix, String num_tel1, String num_tel2, String NRC, String NIS, String NIF,String RIB, String activite,String message,int apercu_ticket) {
        this.nom_magasin = nom_magasin;
        this.adresse_p = adresse;
        this.num_tel_fax_fix_p = num_tel_fax_fix;
        this.num_tel1_p = num_tel1;
        this.num_tel2_p = num_tel2;
        this.NIS = NIS;
        this.NRC = NRC;
        this.NIF= NIF;
        this.RIB= RIB;
        this.activite = activite;
        this.message=message;
        this.apercu_ticket=apercu_ticket;
    }
  

    

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }

    public String getNIS() {
        return NIS;
    }

    public void setNIS(String NIS) {
        this.NIS = NIS;
    }

   

   

  

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String NRC) {
        this.NRC = NRC;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

   
    
    
}
