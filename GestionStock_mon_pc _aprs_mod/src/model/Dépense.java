/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author pc
 */
public class Dépense {
int année;  int id;

    public Dépense(int année, String mois, String depence, double montant, int id) {
        this.année = année;
        this.id = id;
        this.mois = mois;
        this.depence = depence;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getAnnée() {
        return année;
    }

    public void setAnnée(int année) {
        this.année = année;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public void setDepence(String depence) {
        this.depence = depence;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMois() {
        return mois;
    }

    public String getDepence() {
        return depence;
    }

    public double getMontant() {
        return montant;
    }
String mois;
String depence;
double montant;

    public Dépense(int année, String mois, String depence, double montant) {
        this.année = année;
        this.mois = mois;
        this.depence = depence;
        this.montant = montant;
    }


  
    
    
}
