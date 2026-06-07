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
public class Inventaire {
int num_inv;
Date date;
String libelle;
int id_produit;
String désignation;
float qte_t,qte_p,equart_qte;
double prix_achat_ttc;
String user;
String temp_inv;

    public String getTemp_inv() {
        return temp_inv;
    }

    public void setTemp_inv(String temp_inv) {
        this.temp_inv = temp_inv;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNum_inv() {
        return num_inv;
    }

    public void setNum_inv(int num_inv) {
        this.num_inv = num_inv;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLibelle() {
        return libelle;
    }

    public Inventaire(String user) {
        this.user = user;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public float getQte_t() {
        return qte_t;
    }

    public void setQte_t(float qte_t) {
        this.qte_t = qte_t;
    }

    public float getQte_p() {
        return qte_p;
    }

    public void setQte_p(float qte_p) {
        this.qte_p = qte_p;
    }

    public float getEquart_qte() {
        return equart_qte;
    }

    public void setEquart_qte(float equart_qte) {
        this.equart_qte = equart_qte;
    }

    public double getPrix_achat_ttc() {
        return prix_achat_ttc;
    }

    public void setPrix_achat_ttc(double prix_achat_ttc) {
        this.prix_achat_ttc = prix_achat_ttc;
    }

    public Inventaire(int num_inv, Date date, String libelle, int id_produit, String désignation, float qte_t, float qte_p, float equart_qte, double prix_achat_ttc,String temp_inv,String user) {
        this.num_inv = num_inv;
        this.date = date;
        this.libelle = libelle;
        this.id_produit = id_produit;
        this.désignation = désignation;
        this.qte_t = qte_t;
        this.qte_p = qte_p;
        this.equart_qte = equart_qte;
        this.prix_achat_ttc = prix_achat_ttc;
        this.user=user;
        this.temp_inv=temp_inv;
        
    }

    public Inventaire(int num_inv, Date date, String libelle, String user, String temp_inv) {
        this.num_inv = num_inv;
        this.date = date;
        this.libelle = libelle;
        this.user = user;
        this.temp_inv = temp_inv;
    }

    
    
}
