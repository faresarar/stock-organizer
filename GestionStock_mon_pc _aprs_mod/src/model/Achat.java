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
public class Achat {
int num_bon_réception;
Date date_achat;
String nom_prénom_fournisseur;
int id;
String temp_achat;
String user;
String  désignation;
double prix_achat;
float quantité;
double somme_versé;
double remise; 
double prix_v_detail,prix_v_special;
double prix_v_gros;

    public double getPrix_v_special() {
        return prix_v_special;
    }

    public void setPrix_v_special(double prix_v_special) {
        this.prix_v_special = prix_v_special;
    }
int idf;

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }



    public double getPrix_v_detail() {
        return prix_v_detail;
    }

    public void setPrix_v_detail(double prix_v_detail) {
        this.prix_v_detail = prix_v_detail;
    }

    public double getPrix_v_gros() {
        return prix_v_gros;
    }

    public void setPrix_v_gros(double prix_v_gros) {
        this.prix_v_gros = prix_v_gros;
    }


    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }
int id_produit;
//int num_versement_achat;

    public Achat(int num_bon_réception, Date date_achat, String nom_prénom_fournisseur) {
        this.num_bon_réception = num_bon_réception;
        this.date_achat = date_achat;
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
    }

     public Achat(int num_bon_réception, Date date_achat, String nom_prénom_fournisseur,double somme_versé,String user,double remise,int idf) {
        this.num_bon_réception = num_bon_réception;
        this.date_achat = date_achat;
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
       
       
        this.user = user;
         this.somme_versé = somme_versé;
         this.remise=remise;
        this.idf=idf;
    }
    
    public Achat(int num_bon_réception, Date date_achat, String nom_prénom_fournisseur, String temp_achat, String user,
            String désignation, double prix_achat, float quantité_achete, double somme_versé,double remise,double prix_v_detail, 
            double prix_v_gros,double prix_v_special,int idf,int id_pro) {
        this.num_bon_réception = num_bon_réception;
        this.date_achat = date_achat;
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
       
        this.temp_achat = temp_achat;
        this.user = user;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.quantité = quantité_achete;
       // this.num_versement_achat = num_versement_achat;
        this.somme_versé = somme_versé;
        this.id_produit = id_pro;
        this.remise=remise;
        this.prix_v_detail=prix_v_detail;
         this.prix_v_gros=prix_v_gros;
         this.prix_v_special=prix_v_special;
         this.idf=idf;
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

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }



    public double getSomme_versé() {
        return somme_versé;
    }

    public void setSomme_versé(double somme_versé) {
        this.somme_versé = somme_versé;
    }

        

    
    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

    

    public String getTemp_achat() {
        return temp_achat;
    }

    public void setTemp_achat(String temp_achat) {
        this.temp_achat = temp_achat;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    
 

   

//String id_fournisseur;

    public int getNum_bon_réception() {
        return num_bon_réception;
    }

    public void setNum_bon_réception(int num_bon_réception) {
        this.num_bon_réception = num_bon_réception;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

    public String getNom_prénom_fournisseur() {
        return nom_prénom_fournisseur;
    }

    public void setNom_prénom_fournisseur(String nom_prénom_fournisseur) {
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
    }

    

   
   
  
  
/*
    public String getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(String id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
*/
}
