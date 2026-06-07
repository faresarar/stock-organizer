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
public class Produit {
//double prix_donner;
   /* public Produit(String famille, String unite, String marque, String image, String référence, String désignation, 
            String étagére, String id_fournisseur, String remarque, double prix_achat, double prix_vente_detail,
            double prix_vente_gros,
            double prix_promotion, float quantité, int stock_alert, int jour_alert, int quantité_promotion,
            float tva, boolean promotion,
            Date date_achat, String taille, String pointure, String couleur, String date_premption, String saisie_par,
            String code_barre ,String code_bare_packet,double prix_vente_packet,int nbre_produit_packet,boolean vente_packet) {
        this.famille = famille;
        this.unite = unite;
        this.marque = marque;
        this.image = image;
        this.référence = référence;
        this.désignation = désignation;
        this.étagére = étagére;
        this.code_barre = code_barre;
        this.id_fournisseur = id_fournisseur;
        this.remarque = remarque;
        this.saisie_par = saisie_par;
        this.date_premption = date_premption;
       
        this.prix_achat = prix_achat;
        this.prix_vente_detail = prix_vente_detail;
        this.prix_vente_gros = prix_vente_gros;
        this.prix_promotion = prix_promotion;
       
        this.stock_alert = stock_alert;
        this.jour_alert = jour_alert;
        this.quantité_promotion = quantité_promotion;
        
        this.tva = tva;
        this.promotion = promotion;
        
         this.prix_vente_packet = prix_vente_packet;
        this.nbre_produit_packet = nbre_produit_packet;
        this.vente_packet = vente_packet;
         this.code_bare_packet = code_bare_packet;
         
        this.taille = taille;
        this.pointure = pointure;
        this.couleur = couleur;
        this.date_achat = date_achat;
        this.quantité = quantité;
    }*/
/*
    public double getPrix_donner() {
        return prix_donner;
    }

    public void setPrix_donner(double prix_donner) {
        this.prix_donner = prix_donner;
    }*/

    public Produit(String famille, String unite, String marque, String image, String référence, String désignation, 
            String étagére, int id_fournisseur, String remarque, double prix_achat, double prix_vente_detail,
            double prix_vente_gros,
            double prix_special, float quantité, int stock_alert, int jour_alert,
            float tva, 
            Date date_achat, String taille, String pointure, String couleur, String date_premption, String saisie_par,
            String code_bare_packet,double prix_vente_packet,int nbre_produit_packet,boolean vente_packet) {
        this.famille = famille;
        this.unite = unite;
        this.marque = marque;
        this.image = image;
        this.référence = référence;
        this.désignation = désignation;
        this.étagére = étagére;
        this.id_f = id_fournisseur;
        this.remarque = remarque;
        
        this.prix_achat = prix_achat;
        this.prix_vente_detail = prix_vente_detail;
        this.prix_vente_gros = prix_vente_gros;
        this.prix_special = prix_special;
        this.quantité = quantité;
        //this.id_produit = id_produit;
        this.stock_alert = stock_alert;
        this.jour_alert = jour_alert;
        
        this.tva = tva;
        
        this.date_achat = date_achat;
        this.taille = taille;
        this.pointure = pointure;
        this.couleur = couleur;
        this.date_premption = date_premption;
        this.saisie_par = saisie_par;
        
        this.prix_vente_packet = prix_vente_packet;
        this.nbre_produit_packet = nbre_produit_packet;
        this.vente_packet = vente_packet;
        this.code_bare_packet = code_bare_packet;
       // this.prix_donner=prix_donner; 
    }

  
private String famille,unite,marque,image,référence,désignation,étagére,code_barre,remarque,saisie_par,date_premption,code_bare_packet;
int id_f;
    public Produit(String unite, String désignation, double prix_achat, double prix_vente_detail,
            double prix_vente_gros, double prix_special, double prix_vente_packet, int id_produit, int nbre_produit_packet,
            float tva, boolean vente_packet, int favorite, float quantité) {
        
        this.prix_vente_packet = prix_vente_packet;
        this.unite = unite;
        this.id_produit = id_produit;
        this.nbre_produit_packet = nbre_produit_packet;
        this.vente_packet = vente_packet;
        this.désignation = désignation;
        this.favorite = favorite;
        
        this.prix_achat = prix_achat;
        this.prix_vente_detail = prix_vente_detail;
        this.prix_vente_gros = prix_vente_gros;
        this.prix_special = prix_special;
        this.quantité = quantité;
        //this.id_produit = id_produit;
        
        
        this.tva = tva;
        
      
    }

    public String getCode_bare_packet() {
        return code_bare_packet;
    }

    public void setCode_bare_packet(String code_bare_packet) {
        this.code_bare_packet = code_bare_packet;
    }

    public double getPrix_vente_packet() {
        return prix_vente_packet;
    }

    public void setPrix_vente_packet(double prix_vente_packet) {
        this.prix_vente_packet = prix_vente_packet;
    }

    public int getNbre_produit_packet() {
        return nbre_produit_packet;
    }

    public void setNbre_produit_packet(int nbre_produit_packet) {
        this.nbre_produit_packet = nbre_produit_packet;
    }

    public boolean isVente_packet() {
        return vente_packet;
    }

    public void setVente_packet(boolean vente_packet) {
        this.vente_packet = vente_packet;
    }
private double prix_achat,prix_vente_detail,prix_vente_gros,prix_special,prix_vente_packet;

    public double getPrix_special() {
        return prix_special;
    }

    public void setPrix_special(double prix_special) {
        this.prix_special = prix_special;
    }
private int id_produit,stock_alert,jour_alert,nbre_produit_packet,favorite;
private float tva;

  
private boolean vente_packet;

    public Produit(String unite, String désignation, double prix_achat, double prix_vente_detail,
            double prix_vente_gros, double prix_special, double prix_vente_packet, int id_produit, 
            int quantité_promotion, int nbre_produit_packet, float tva, 
            boolean vente_packet, int favorite, float quantité) {
        this.unite = unite;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente_detail = prix_vente_detail;
        this.prix_vente_gros = prix_vente_gros;
        this.prix_special = prix_special;
        this.prix_vente_packet = prix_vente_packet;
        this.id_produit = id_produit;
       
        this.nbre_produit_packet = nbre_produit_packet;
        this.tva = tva;
       
        this.vente_packet = vente_packet;
        this.favorite = favorite;
        this.quantité = quantité;
       
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

   
private String taille,pointure,couleur;
private Date date_achat;
private float quantité;

    public String getSaisie_par() {
        return saisie_par;
    }

    public void setSaisie_par(String saisie_par) {
        this.saisie_par = saisie_par;
    }


    public Produit(String désignation, double prix_achat, double prix_vente_detail, double prix_vente_gros,double prix_special, float quantité, int id_produit, Date date_achat) {
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente_detail = prix_vente_detail;
        this.prix_vente_gros = prix_vente_gros;
        this.prix_special=prix_special;
        this.quantité = quantité;
        this.id_produit = id_produit;
        this.date_achat = date_achat;
            }


   


    /*public Produit(String désignation, double prix_vente_detail,int id_produit,String image) {
        this.désignation = désignation;
        this.prix_vente_detail = prix_vente_detail;
        this.id_produit=id_produit;
        this.image=image;
    }
    */
    
    public Produit(String désignation, double prix_vente_detail,double prix_vente_gros,double prix_special,double prix_vente_packet,String code_barre ,String date_premption) {
        this.désignation = désignation;
        this.prix_vente_detail = prix_vente_detail;
         this.prix_vente_gros = prix_vente_gros;
        this.prix_vente_packet= prix_vente_packet;
        this.prix_special=prix_special;
      //  this.id_produit=id_produit;
        this.code_barre=code_barre;
        this.date_premption= date_premption;
        
            }

    
  

   
    
    
    
public Produit(String désignation, double prix_vente_detail,String code_barre) {
        this.désignation = désignation;
        this.prix_vente_detail = prix_vente_detail;
        this.code_barre=code_barre;
    }
    public Produit(String famille, String unite, String marque, String image, String référence, String désignation,
            String étagére, int id_f, String remarque, double prix_achat, double prix_vente_detail,
            double prix_vente_gros, double prix_special, float quantité, int id_produit, int stock_alert, 
            int jour_alert, float tva,
            String date_premption, Date date_achat, String taille, String pointure, 
            String couleur,String saisie_par,
            String code_bare_packet,double prix_vente_packet,int nbre_produit_packet,boolean vente_packet) {
        this.famille = famille;
        this.unite = unite;
        this.marque = marque;
        this.image = image;
        this.référence = référence;
        this.désignation = désignation;
        this.étagére = étagére;
        //this.code_barre = code_barre;
        this.id_f = id_f;
        this.remarque = remarque;
        this.prix_achat = prix_achat;
        this.prix_vente_detail = prix_vente_detail;
        this.prix_vente_gros = prix_vente_gros;
        this.prix_special = prix_special;
        this.quantité = quantité;
        this.id_produit = id_produit;
        this.stock_alert = stock_alert;
        this.jour_alert = jour_alert;
       
        this.tva = tva;
      
        this.date_premption = date_premption;
        this.date_achat = date_achat;
        this.taille = taille;
        this.pointure = pointure;
        this.couleur = couleur;
        this.saisie_par = saisie_par;
        
        this.prix_vente_packet = prix_vente_packet;
        this.nbre_produit_packet = nbre_produit_packet;
        this.vente_packet = vente_packet;
        this.code_bare_packet = code_bare_packet;
      //   this.prix_donner=prix_donner;
    }

    

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getPointure() {
        return pointure;
    }

    public void setPointure(String pointure) {
        this.pointure = pointure;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getDate_premption() {
        return date_premption;
    }

    public void setDate_premption(String Date_premption) {
        this.date_premption = Date_premption;
    }

   
    public int getJour_alert() {
        return jour_alert;
    }

    public void setJour_alert(int jour_alert) {
        this.jour_alert = jour_alert;
    }

   
    public void setTva(float tva) {
        this.tva = tva;
    }

    public float getTva() {
        return tva;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }


  

    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

   

    

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

 

    public String getRéférence() {
        return référence;
    }

    public void setRéférence(String référence) {
        this.référence = référence;
    }

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

    public String getÉtagére() {
        return étagére;
    }

    public void setÉtagére(String étagére) {
        this.étagére = étagére;
    }

    public String getCode_barre() {
        return code_barre;
    }

    public void setCode_barre(String code_barre) {
        this.code_barre = code_barre;
    }

   
  

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public double getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(double prix_achat) {
        this.prix_achat = prix_achat;
    }

   

    public int getId_f() {
        return id_f;
    }

    public void setId_fournisseur(int  id_f) {
        this.id_f = id_f;
    }

    public float getQuantité() {
        return quantité;
    }

    public void setQuantité(float quantité) {
        this.quantité = quantité;
    }

   /* public Produit(String désignation, double prix_vente,String codebare) {
        this.désignation = désignation;
        this.prix_vente = prix_vente;
        this.code_barre=codebare;
    }
    
    */

    public String getFamille() {
        return famille;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrix_vente_detail() {
        return prix_vente_detail;
    }

    public void setPrix_vente_detail(double prix_vente_detail) {
        this.prix_vente_detail = prix_vente_detail;
    }

    public double getPrix_vente_gros() {
        return prix_vente_gros;
    }

    public void setPrix_vente_gros(double prix_vente_gros) {
        this.prix_vente_gros = prix_vente_gros;
    }

    public int getStock_alert() {
        return stock_alert;
    }

    public void setStock_alert(int stock_alert) {
        this.stock_alert = stock_alert;
    }
@Override
  public String toString(){
   return this.désignation;
   }

   
  
}
 