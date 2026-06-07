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
public class Caisse {
 int num;
 double montant;
 Date date;
 String heure;
 String déscription;

    public Caisse(int num, double montant, Date date, String heure, String déscription, String user, String type_op, int num_facture) {
        this.num = num;
        this.montant = montant;
        this.date = date;
        this.heure = heure;
        this.déscription = déscription;
        this.user = user;
        this.type_op = type_op;
        this.num_facture = num_facture;
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

    public String getDéscription() {
        return déscription;
    }

    public void setDéscription(String déscription) {
        this.déscription = déscription;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType_op() {
        return type_op;
    }

    public void setType_op(String type_op) {
        this.type_op = type_op;
    }

    public int getNum_facture() {
        return num_facture;
    }

    public void setNum_facture(int num_facture) {
        this.num_facture = num_facture;
    }
 String user;
 String type_op;
 int num_facture;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Caisse(int num, double montant) {
        this.num = num;
        this.montant = montant;
    }
    
}
