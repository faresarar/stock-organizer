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
public class PrintReportProduit {
     String nom_magasin;
    String adresse;
    String référence;

    public String getRéférence() {
        return référence;
    }

    public void setRéférence(String référence) {
        this.référence = référence;
    }
    String num_tel_fax_fix;
    String num_tel1;
    String num_tel2;
     String désignation;
     double prix_vente;
String marque;
String etat;
String categorie_produit;
int quantité;

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCategorie_produit() {
        return categorie_produit;
    }

    public void setCategorie_produit(String categorie_produit) {
        this.categorie_produit = categorie_produit;
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

  
    

   

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public PrintReportProduit(String nom_magasin, String adresse, String num_tel_fax_fix, String num_tel1, String num_tel2, String désignation, double prix_vente, String marque, String etat, String categorie_produit,String référence,int quantité) {
        this.nom_magasin = nom_magasin;
        this.adresse = adresse;
        this.num_tel_fax_fix = num_tel_fax_fix;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.désignation = désignation;
        this.prix_vente = prix_vente;
        this.marque = marque;
        this.etat = etat;
        this.categorie_produit = categorie_produit;
       this.référence=référence;
       this.quantité=quantité;
    }

   

    




   
}
