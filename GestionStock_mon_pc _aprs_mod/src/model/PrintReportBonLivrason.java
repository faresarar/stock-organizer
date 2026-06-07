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
public class PrintReportBonLivrason {
     String nom_magasin;
    String adresse;
    String num_tel_fax_fix;
    String num_tel1;
    String num_tel2;
    int num_bon_livraison;

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

    public int getNum_bon_livraison() {
        return num_bon_livraison;
    }

    public void setNum_bon_livraison(int num_bon_livraison) {
        this.num_bon_livraison = num_bon_livraison;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom_prénom_client() {
        return nom_prénom_client;
    }

    public void setNom_prénom_client(String nom_prénom_client) {
        this.nom_prénom_client = nom_prénom_client;
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

    public int getQuantité_vente() {
        return quantité_vente;
    }

    public void setQuantité_vente(int quantité_vente) {
        this.quantité_vente = quantité_vente;
    }

   

    public double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public PrintReportBonLivrason(String nom_magasin, String adresse, String num_tel_fax_fix, String num_tel1, String num_tel2, int num_bon_livraison, String nom_prénom_client, String désignation, double prix_vente, int quantité_vente, double montantHT,double montantTTC) {
        this.nom_magasin = nom_magasin;
        this.adresse = adresse;
        this.num_tel_fax_fix = num_tel_fax_fix;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.num_bon_livraison = num_bon_livraison;
    
        this.nom_prénom_client = nom_prénom_client;
        this.désignation = désignation;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantHT = montantHT;
        this.montantTTC=montantTTC;
    }
String date;
String nom_prénom_client;
String désignation;
double prix_vente;
int quantité_vente;
double montantHT;
double montantTTC;

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

}