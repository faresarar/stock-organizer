/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author hicham
 */
public class Mouvement {
Date date;  
String type;
String tiers;
float qte_e;
float qte_s;
double prix_achat;
double prix_vente;
//String désignation;

  /*  public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTiers() {
        return tiers;
    }

    public void setTiers(String tiers) {
        this.tiers = tiers;
    }

    public float getQte_e() {
        return qte_e;
    }

    public void setQte_e(float qte_e) {
        this.qte_e = qte_e;
    }

    public float getQte_s() {
        return qte_s;
    }

    public void setQte_s(float qte_s) {
        this.qte_s = qte_s;
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

    public Mouvement(Date date, String type, String tiers, float qte_e, float qte_s, double prix_achat, double prix_vente) {
        this.date = date;
        this.type = type;
        this.tiers = tiers;
        this.qte_e = qte_e;
        this.qte_s = qte_s;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
    //    this.désignation = désignation;
    }

    
}
