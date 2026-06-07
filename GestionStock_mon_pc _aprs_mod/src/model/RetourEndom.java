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
public class RetourEndom {
 //   String id_client;
    String nom_prénom_client;
    String date_retour;
    String désignation;
    int quantité;
    double prix_achat;
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

  

    public String getNom_prénom_client() {
        return nom_prénom_client;
    }

    public void setNom_prénom_client(String nom_prénom_client) {
        this.nom_prénom_client = nom_prénom_client;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
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

    public double getMontant_versé() {
        return montant_versé;
    }

    public void setMontant_versé(double montant_versé) {
        this.montant_versé = montant_versé;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public int getNum_bon_livraison() {
        return num_bon_livraison;
    }

    public void setNum_bon_livraison(int num_bon_livraison) {
        this.num_bon_livraison = num_bon_livraison;
    }

    public String getHeure_retour() {
        return heure_retour;
    }

    public void setHeure_retour(String heure_retour) {
        this.heure_retour = heure_retour;
    }

  
    double prix_vente;

    public RetourEndom( String nom_prénom_client, String date_retour, String désignation, int quantité, double prix_achat, double prix_vente, double montant_versé, double remise, int num_bon_livraison, String heure_retour,int id_retour) {
        //this.id_client = id_client;
        this.nom_prénom_client = nom_prénom_client;
        this.date_retour = date_retour;
        this.désignation = désignation;
        this.quantité = quantité;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.montant_versé = montant_versé;
        this.remise = remise;
        this.num_bon_livraison = num_bon_livraison;
        this.heure_retour = heure_retour;
        this.id = id_retour;
    }
    public RetourEndom( String nom_prénom_client, String date_retour, String désignation, int quantité, double prix_achat, double prix_vente, double montant_versé, double remise, int num_bon_livraison, String heure_retour) {
        //this.id_client = id_client;
        this.nom_prénom_client = nom_prénom_client;
        this.date_retour = date_retour;
        this.désignation = désignation;
        this.quantité = quantité;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.montant_versé = montant_versé;
        this.remise = remise;
        this.num_bon_livraison = num_bon_livraison;
        this.heure_retour = heure_retour;
       // this.id = id_retour;
    }
    double montant_versé;
    double remise;
    int num_bon_livraison;
    String heure_retour;
  //  int id_retour;



}
