/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rais
 */
public class PrintReportBonReception {
 String nom_magasin;
 String adresse;
 String num_tel_fax_fix;
 String num_tel1;
 String num_tel2;
 int num_bon_réception;
 String date;
 String nom_prénom_fournisseur;
 String désignation;
 double prix_achat;
 float quantité;
 double montantHT;
 double montantTTC;

    

    public int getNum_bon_réception() {
        return num_bon_réception;
    }

    public void setNum_bon_réception(int num_bon_réception) {
        this.num_bon_réception = num_bon_réception;
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
        return num_tel_fax_fix;
    }

    public void setNum_tel_fax_fix(String num_tel_fax_fix) {
        this.num_tel_fax_fix = num_tel_fax_fix;
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

   
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom_prénom_fournisseur() {
        return nom_prénom_fournisseur;
    }

    public void setNom_prénom_fournisseur(String nom_prénom_fournisseur) {
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
    }

  

   

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

   

   

    public double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public PrintReportBonReception(String nom_magasin, String adresse, String num_tel_fax_fix, String num_tel1, String num_tel2, int num_bon, String nom_prénom_client, String désignation, double prix_achat, float quantité, double montantHT,double montantTTC) {
        this.nom_magasin = nom_magasin;
        this.adresse = adresse;
        this.num_tel_fax_fix = num_tel_fax_fix;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.num_bon_réception = num_bon;
    
        this.nom_prénom_fournisseur = nom_prénom_client;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.quantité = quantité;
        this.montantHT = montantHT;
        this.montantTTC=montantTTC;
    }

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public float getQuantité() {
        return quantité;
    }

    public void setQuantité(float quantité) {
        this.quantité = quantité;
    }


    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

}
