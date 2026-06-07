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
public class PrintReport {
 int num_bon_réception;
String date_achat;
String nom_prénom_fournisseur;
float TVA;
String désignation;
double prix_achat;

    public int getNum_bon_réception() {
        return num_bon_réception;
    }

    public void setNum_bon_réception(int num_bon_réception) {
        this.num_bon_réception = num_bon_réception;
    }

    public String getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(String date_achat) {
        this.date_achat = date_achat;
    }

    public String getNom_prénom_fournisseur() {
        return nom_prénom_fournisseur;
    }

    public void setNom_prénom_fournisseur(String nom_prénom_fournisseur) {
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
    }

    public float getTVA() {
        return TVA;
    }

    public void setTVA(float TVA) {
        this.TVA = TVA;
    }

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public String getRéférence() {
        return référence;
    }

    public void setRéférence(String référence) {
        this.référence = référence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMatricule_fiscale() {
        return matricule_fiscale;
    }

    public void setMatricule_fiscale(String matricule_fiscale) {
        this.matricule_fiscale = matricule_fiscale;
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
double prix_vente;

    public PrintReport(int num_bon_réception, String date_achat, String nom_prénom_fournisseur, float TVA, String désignation, double prix_achat, double prix_vente, int quantité, double montantTTC, double montantHT, String référence, int id, String nom_magasin, String adresse, String num_tel_fax_fix, String num_tel1, String num_tel2, String matricule_fiscale, String NRC, String NIF) {
        this.num_bon_réception = num_bon_réception;
        this.date_achat = date_achat;
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité = quantité;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
        this.référence = référence;
        this.id = id;
        this.nom_magasin = nom_magasin;
        this.adresse = adresse;
        this.num_tel_fax_fix = num_tel_fax_fix;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.matricule_fiscale = matricule_fiscale;
        this.NRC = NRC;
        this.NIF = NIF;
    }
int quantité;
double montantTTC;
double montantHT;
String référence;
int id;
 String nom_magasin;
    String adresse;
    String num_tel_fax_fix;
    String num_tel1;
    String num_tel2;
    String matricule_fiscale;
    String NRC;
    String NIF;
}
