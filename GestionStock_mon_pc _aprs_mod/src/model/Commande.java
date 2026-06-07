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
public class Commande {
int num_bon;
Date date;
String nom_prénom_fournisseur;
//int id;
String temp;
String user;
String  désignation;
int idf;
float quantité;

    public Commande(int num_bon, Date date, String nom_prénom_fournisseur, String temp, String user) {
        this.num_bon = num_bon;
        this.date = date;
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
        this.temp = temp;
        this.user = user;
    }


    public Commande(int num_bon, Date date, String nom_prénom_fournisseur,  String temp, String user, String désignation, float quantité, int idf, int id_produit) {
        this.num_bon = num_bon;
        this.date = date;
        this.nom_prénom_fournisseur = nom_prénom_fournisseur;
        //this.id = id;
        this.temp = temp;
        this.user = user;
        this.désignation = désignation;
        this.quantité = quantité;
        this.idf = idf;
        this.id_produit = id_produit;
    }

    public Commande(int num_bon_c, Date date, String nom_prénom_fournisseur, String user, int idf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Commande(int num_bon, float quantité, String désignation, String user) {
        this.désignation = désignation;
        this.quantité = quantité;
         this.num_bon = num_bon;
         this.user=user;
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNum_bon() {
        return num_bon;
    }

    public void setNum_bon(int num_bon) {
        this.num_bon = num_bon;
    }






    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }



    

   

   
int id_produit;
//int num_versement_achat;

  

   
   


   

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



    
        

    
    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

    

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp= temp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


   

  

  

    
 

   

//String id_fournisseur;

  
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date= date;
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
