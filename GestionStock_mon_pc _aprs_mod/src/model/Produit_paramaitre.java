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
public class Produit_paramaitre {

    public int getFamille() {
        return famille;
    }

    public void setFamille(int famille) {
        this.famille = famille;
    }

    public int getUnite() {
        return unite;
    }

    public void setUnite(int unite) {
        this.unite = unite;
    }

    public int getMarque() {
        return marque;
    }

    public void setMarque(int marque) {
        this.marque = marque;
    }

    public int getDésignation() {
        return désignation;
    }

    public void setDésignation(int désignation) {
        this.désignation = désignation;
    }

    public int getÉtagére() {
        return étagére;
    }

    public void setÉtagére(int étagére) {
        this.étagére = étagére;
    }

    public int getCode_barre() {
        return code_barre;
    }

    public void setCode_barre(int code_barre) {
        this.code_barre = code_barre;
    }

    public int getRemarque() {
        return remarque;
    }

    public void setRemarque(int remarque) {
        this.remarque = remarque;
    }

    public int getSaisie_par() {
        return saisie_par;
    }

    public void setSaisie_par(int saisie_par) {
        this.saisie_par = saisie_par;
    }

    public int getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(int prix_achat) {
        this.prix_achat = prix_achat;
    }

    public int getPrix_vente_detail() {
        return prix_vente_detail;
    }

    public void setPrix_vente_detail(int prix_vente_detail) {
        this.prix_vente_detail = prix_vente_detail;
    }

    public int getPrix_vente_gros() {
        return prix_vente_gros;
    }

    public void setPrix_vente_gros(int prix_vente_gros) {
        this.prix_vente_gros = prix_vente_gros;
    }

   

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public int getStock_alert() {
        return stock_alert;
    }

    public void setStock_alert(int stock_alert) {
        this.stock_alert = stock_alert;
    }

    public int getJour_alert() {
        return jour_alert;
    }

    public void setJour_alert(int jour_alert) {
        this.jour_alert = jour_alert;
    }

    

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public int getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(int date_achat) {
        this.date_achat = date_achat;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPointure() {
        return pointure;
    }

    public void setPointure(int pointure) {
        this.pointure = pointure;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public int getDate_premption() {
        return date_premption;
    }

    public void setDate_premption(int date_premption) {
        this.date_premption = date_premption;
    }

  
private int famille,unite,marque,désignation,étagére,code_barre,remarque,saisie_par;

    public Produit_paramaitre(int famille, int unite, int marque, int désignation, int étagére, int code_barre,
            int remarque, int saisie_par, int prix_achat, int prix_vente_detail, int prix_vente_gros,
            int prix_special, int quantité, int stock_alert, int jour_alert,
            int tva, int date_achat, int taille, int pointure, int couleur, int date_premption,int nbre_produit_packet,int prix_vente_packet,int code_bare_packet) {
        this.famille = famille;
        this.unite = unite;
        this.marque = marque;
        this.désignation = désignation;
        this.étagére = étagére;
        this.code_barre = code_barre;
        this.remarque = remarque;
        this.saisie_par = saisie_par;
        this.prix_achat = prix_achat;
        this.prix_vente_detail = prix_vente_detail;
        this.prix_vente_gros = prix_vente_gros;
        this.prix_special = prix_special;
        this.quantité = quantité;
        this.stock_alert = stock_alert;
        this.jour_alert = jour_alert;
       
        this.tva = tva;
        this.date_achat = date_achat;
        this.taille = taille;
        this.pointure = pointure;
        this.couleur = couleur;
        this.date_premption = date_premption;
        this.nbre_produit_packet=nbre_produit_packet;
        this.prix_vente_packet=prix_vente_packet;
        this.code_bare_packet=code_bare_packet;
    }

   
private int prix_achat,prix_vente_detail,prix_vente_gros,prix_special;
private int quantité,stock_alert,jour_alert;
private int tva;
private int date_achat,taille,pointure,couleur;
private int date_premption;

private int nbre_produit_packet,prix_vente_packet,code_bare_packet;

    public int getCode_bare_packet() {
        return code_bare_packet;
    }

    public void setCode_bare_packet(int code_bare_packet) {
        this.code_bare_packet = code_bare_packet;
    }

    public int getNbre_produit_packet() {
        return nbre_produit_packet;
    }

    public void setNbre_produit_packet(int nbre_produit_packet) {
        this.nbre_produit_packet = nbre_produit_packet;
    }

    public int getPrix_vente_packet() {
        return prix_vente_packet;
    }

    public void setPrix_vente_packet(int prix_vente_packet) {
        this.prix_vente_packet = prix_vente_packet;
    }

    public int getPrix_special() {
        return prix_special;
    }

    public void setPrix_special(int prix_special) {
        this.prix_special = prix_special;
    }
   


   
}
