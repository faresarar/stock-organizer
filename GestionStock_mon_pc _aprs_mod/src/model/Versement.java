/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Rais
 */
public class Versement {
 String nom_prénom_fournisseur;
 int id_f;
 Date date_versement;
 double montant_versé;
 String etat;
 int num_bon_réception;
 String remarque="";
 String regler_par;

    public double getRendu() {
        return rendu;
    }

    public void setRendu(double rendu) {
        this.rendu = rendu;
    }
 double ancien_dette,rendu;
  int num_versement;
 
    String nom_magasin;
    String adresse;
    String adresse_p;
    String num_tel_fax_fix_p;
    String num_tel1;
    String num_tel2;
    String activite;
    String num_tel1_p;
    String num_tel2_p;

    public Versement(String nom_prenom_fournisseur, Date date_versement, double montant_versé, int numero_versement,String etat, String remarque, String regler_par) {
     this.nom_prénom_fournisseur = nom_prenom_fournisseur;
      
        this.date_versement = date_versement;
        this.montant_versé = montant_versé;
        this.etat=etat;
        this.regler_par = regler_par;
        this.remarque=remarque;
        this.num_versement=numero_versement;             
        
        
       
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

    public String getAdresse_p() {
        return adresse_p;
    }

    public void setAdresse_p(String adresse_p) {
        this.adresse_p = adresse_p;
    }
 

    public Versement(String nom_prénom_fournisseur, int id_f, Date date_versement, double montant_versé, String etat, int num_bon_réception, String regler_par, double ancien_dette, String nom_magasin, String adresse, String num_tel_fax_fix, String num_tel1, String num_tel2, String activite,String num_tel1_f,String num_tel2_f,String adresse_f) {
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
        this.id_f = id_f;
        this.date_versement = date_versement;
        this.montant_versé = montant_versé;
        this.etat = etat;
        this.num_bon_réception = num_bon_réception;
        this.regler_par = regler_par;
        this.ancien_dette = ancien_dette;
        this.nom_magasin = nom_magasin;
        this.adresse = adresse_f;
        this.num_tel_fax_fix_p = num_tel_fax_fix;
        this.num_tel1 = num_tel1_f;
        this.num_tel2 = num_tel2_f;
        this.activite = activite;
        this.num_tel1_p=num_tel1;
         this.num_tel2_p=num_tel2;
         this.adresse_p=adresse;
                
       
    }

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNum_tel_fax_fix() {
        return num_tel_fax_fix_p;
    }

    

    public String getNum_tel1() {
        return num_tel1;
    }

    public void setNum_tel1(String num_tel1) {
        this.num_tel1 = num_tel1;
    }

    public String getNum_tel2() {
        return num_tel2;
    }

    public void setNum_tel2(String num_tel2) {
        this.num_tel2 = num_tel2;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }
    

    public double getAncien_dette() {
        return ancien_dette;
    }

    public void setAncien_dette(double ancien_dette) {
        this.ancien_dette = ancien_dette;
    }


    public String getRegler_par() {
        return regler_par;
    }

    public void setRegler_par(String regler_par) {
        this.regler_par = regler_par;
    }

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public int getNum_bon_réception() {
        return num_bon_réception;
    }

    public void setNum_bon_réception(int num_bon_réception) {
        this.num_bon_réception = num_bon_réception;
    }

 
  

   

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
 //String type_versement;


    public int getNum_versement() {
        return num_versement;
    }

    public void setNum_versement(int num_versement) {
        this.num_versement = num_versement;
    }

    public Versement(String nom_prénom_fournisseur, int id_f, Date date_versement, double montant_versé,int num_versement,String etat,int num_bon,String remarque,String regler_par,double ancien_dette) {
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
        this.id_f = id_f;
        this.date_versement = date_versement;
        this.montant_versé = montant_versé;
      //  this.type_versement = type_versement;
        this.num_versement=num_versement;
        this.etat=etat;
        this.num_bon_réception=num_bon;
        this.remarque=  remarque;
         this.regler_par=regler_par;
         this.ancien_dette=ancien_dette;
    }
 public Versement(String nom_prénom_fournisseur, Date date_versement, double montant_versé,int id_f,String etat, int num_bon,String remarque,String regler_par,double ancien_dette,double rendu
) {
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
        this.date_versement = date_versement;
        this.montant_versé = montant_versé;
        this.id_f = id_f;
        this.etat=etat;
          this.num_bon_réception=num_bon;
       //  this.type_versement = type_versement;
         this.remarque=  remarque;
         this.regler_par=regler_par;
         this.ancien_dette=ancien_dette;
         this.rendu=rendu;
    }
    public String getNom_prénom_fournisseur() {
        return nom_prénom_fournisseur;
    }

    public void setNom_prénom_fournisseur(String nom_prénom_fournisseur) {
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
    }

    public int getId_fournisseur() {
        return id_f;
    }

    public void setId_fournisseur(int id_f) {
        this.id_f = id_f;
    }

    public Date getDate_versement() {
        return date_versement;
    }

    public void setDate_versement(Date date_versement) {
        this.date_versement = date_versement;
    }

    public double getMontant_versé() {
        return montant_versé;
    }

    public void setMontant_versé(double montant_versé) {
        this.montant_versé = montant_versé;
    }

  
 
    
}
