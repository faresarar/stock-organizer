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
public class Perte {
private int num_perte;

    public Perte() {
    }

    public Perte(int num_perte, Date date, String heure, String type_perte, String désignation, int id_produit, double prix_achat, float quantité, float quantité_stock, String obsérvation, String user) {
        this.num_perte = num_perte;
        this.date = date;
        this.heure = heure;
        this.type_perte = type_perte;
        this.désignation = désignation;
        this.id_produit = id_produit;
        this.prix_achat = prix_achat;
        this.quantité = quantité;
        this.quantité_stock = quantité_stock;
        this.obsérvation = obsérvation;
        this.user = user;
    }
private Date date;
private String heure;
private String type_perte;
private String désignation;
private int id_produit;
private double prix_achat;
private float quantité;
private float quantité_stock;
private String obsérvation;
private String user;

    public int getNum_perte() {
        return num_perte;
    }

    public void setNum_perte(int num_perte) {
        this.num_perte = num_perte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getType_perte() {
        return type_perte;
    }

    public void setType_perte(String type_perte) {
        this.type_perte = type_perte;
    }

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
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

    public float getQuantité_stock() {
        return quantité_stock;
    }

    public void setQuantité_stock(float quantité_stock) {
        this.quantité_stock = quantité_stock;
    }

    public String getObsérvation() {
        return obsérvation;
    }

    public void setObsérvation(String obsérvation) {
        this.obsérvation = obsérvation;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
