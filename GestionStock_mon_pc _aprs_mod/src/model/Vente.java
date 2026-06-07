/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author pc
 */
public class Vente {
   
Date date_vente;
String nom_prénom_client;
float TVA;
private String etat;

    public Vente(int num_bon_livraison, Date date_vente, String nom_prénom_client) {
        this.num_bon=num_bon_livraison;
        this.date_vente=date_vente;
        this.nom_prénom_client=nom_prénom_client;
         //To change body of generated methods, choose Tools | Templates.
    }

    public Vente(int num_bon_réception, Date date_vente, String nom_prénom_client, double somme_versé, String user, double remise, int idc,String etat) {
        //To change body of generated methods, choose Tools | Templates.String 
        this.num_bon=num_bon_réception;
        this.date_vente=date_vente;
        this.nom_prénom_client=nom_prénom_client;
        this.somme_versé=somme_versé;
        this.user=user;
        this.remise=remise;
        this.idc=idc;
        this.etat=etat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
String code;
String désignation;
double prix_achat;
double prix_vente;
float quantité_vente;
double montantTTC;
double montantHT;
int num_versement;
int id_vente;
String temp_vente;

String user;
int id_produit;
int idc;
double somme_versé;
double remise,rendu;

    public double getRendu() {
        return rendu;
    }

    public void setRendu(double rendu) {
        this.rendu = rendu;
    }

int num_bon;

  
    

    public Vente( Date date_vente, String nom_prénom_client,float TVA,  String désignation,
           
            double prix_achat, double prix_vente, float quantité_vente, 
            double montantTTC, double montantHT, String temp_vente, String user,
            int id_produit,int idc, double somme_versé,double remise,int num_bon  ,double rendu,String code,String etat,int id_vente) {
    
        
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
      
        this.id_vente = id_vente;
        this.temp_vente = temp_vente;
        this.user = user;
        this.id_produit = id_produit;
        this.idc = idc;
        this.somme_versé = somme_versé;
        this.remise = remise;
        this.num_bon=num_bon;
        this.rendu=rendu;
        this.code=code;
        this.etat=etat;
    }
       public Vente( Date date_vente, String nom_prénom_client,float TVA,  String désignation,
           
            double prix_achat, double prix_vente, float quantité_vente, 
            double montantTTC, double montantHT, String temp_vente, String user,
            int id_produit,int idc, double somme_versé,double remise,int num_bon  ,double rendu,String code,String etat) {
    
        
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
      
      //  this.id_vente = id_vente;
        this.temp_vente = temp_vente;
        this.user = user;
        this.id_produit = id_produit;
        this.idc = idc;
        this.somme_versé = somme_versé;
        this.remise = remise;
        this.num_bon=num_bon;
        this.rendu=rendu;
        this.code=code;
        this.etat=etat;
    }
    
    
     public Vente( Date date_vente, String nom_prénom_client,float TVA,  String désignation,
           
            double prix_achat, double prix_vente, float quantité_vente, 
            double montantTTC, double montantHT,  int id_vente, String temp_vente, String user,
            int id_produit,int idc, double somme_versé,double remise,int num_bon,String etat  ) {
    
        
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
      
        this.id_vente = id_vente;
        this.temp_vente = temp_vente;
        this.user = user;
        this.id_produit = id_produit;
        this.idc = idc;
        this.somme_versé = somme_versé;
        this.remise = remise;
        this.num_bon=num_bon;
        this.etat=etat;
    }
    
    
  public int getNum_bon() {
        return num_bon;
    }

    public void setNum_bon(int num_bon) {
        this.num_bon = num_bon;
    }

    public int getNum_versement() {
        return num_versement;
    }

    public void setNum_versement(int num_versement) {
        this.num_versement = num_versement;
    }

    public int getId_vente() {
        return id_vente;
    }

    public void setId_vente(int id_vente) {
        this.id_vente = id_vente;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public double getSomme_versé() {
        return somme_versé;
    }

    public void setSomme_versé(double somme_versé) {
        this.somme_versé = somme_versé;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }


    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNom_prénom_client() {
        return nom_prénom_client;
    }

    public void setNom_prénom_client(String nom_prénom_client) {
        this.nom_prénom_client = nom_prénom_client;
    }

    public String getTemp_vente() {
        return temp_vente;
    }

    public void setTemp_vente(String temp_vente) {
        this.temp_vente = temp_vente;
    }

    

    public Vente( Date date_vente, String nom_prénom_client) {
       
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
    }

   
    public Vente( Date date_vente, String nom_prénom_client, float TVA, String désignation, double prix_achat, double prix_vente, float quantité_vente, double montantTTC, double montantHT, float quantité_stock, int num_versement_vente,int id,String référence,String temp_vente,String user,int id_produit) {
     
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
      
      this.temp_vente=temp_vente;
      this.user=user;
      this.id_produit=id_produit;
     
    }

    public Vente(int num_bon_livraison, Date date_achat, String nom_prénom_client, float TVA,
            String désignation, double prix_achat, double prix_vente, float quantité_vente,float quantité_stock,
            double montantTTC, double montantHT,int num_versement_vente,String référence,String temp_vente,String user,int id_produit) {
       
        this.date_vente = date_achat;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
     
       this.temp_vente=temp_vente;
         this.user=user;
         this.id_produit=id_produit;
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

   

//String id_fournisseur;

  
    public Date getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }

    public String getNom_prénom_cient() {
        return nom_prénom_client;
    }

    public void setNom_prénom_fournisseur(String nom_prénom_client) {
        this.nom_prénom_client = nom_prénom_client;
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

    public float getQuantité_vente() {
        return quantité_vente;
    }

    public void setQuantité_vente(float quantité_vente) {
        this.quantité_vente = quantité_vente;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

   

   
}
