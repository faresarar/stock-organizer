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
public class PrintBareCode {
    String nom_magasin;

    public double getPrix_vente_detail() {
        return prix_vente_detail;
    }

    public void setPrix_vente_detail(double prix_vente_detail) {
        this.prix_vente_detail = prix_vente_detail;
    }

    public PrintBareCode(String nom_magasin, String désignation, double prix_vente_detail, String code_barre, String date_premption) {
        this.nom_magasin = nom_magasin;
        this.désignation = désignation;
        this.prix_vente_detail = prix_vente_detail;
        this.code = code_barre;
        this.date_premption = date_premption;
    }

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
    }

   

    public String getCode() {
        return code;
    }

    public void setCode(String code_barre) {
        this.code = code_barre;
    }

    public String getDate_premption() {
        return date_premption;
    }

    public void setDate_premption(String date_premption) {
        this.date_premption = date_premption;
    }
    String désignation;
    double prix_vente_detail;
    String code;
    String date_premption;


   

    




   
}
