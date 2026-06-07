/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author lenovo
 */
public class employeur {

    public employeur(String id_employe, String nom_prénom_employe, String type_employe, String adresse, String email, String num_tel1) {
        this.id_employe = id_employe;
        this.nom_prénom_employe = nom_prénom_employe;
        this.type_employe = type_employe;
        this.adresse = adresse;
        this.email = email;
        this.num_tel1 = num_tel1;
    }
    
String id_employe;
String nom_prénom_employe;
String type_employe;
String adresse;

    @Override
    public String toString() {
        return "employeur{" + "id_employe=" + id_employe + ", nom_pr\u00e9nom_employe=" + nom_prénom_employe + ", type_client=" + type_employe + ", adresse=" + adresse + ", email=" + email + ", num_tel1=" + num_tel1 + ", salaire=" + salaire + '}';
    }

    public void setId_employe(String id_employe) {
        this.id_employe = id_employe;
    }

    public void setNom_prénom_employe(String nom_prénom_employe) {
        this.nom_prénom_employe = nom_prénom_employe;
    }

    public void setType_employe(String type_employe) {
        this.type_employe = type_employe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNum_tel1(String num_tel1) {
        this.num_tel1 = num_tel1;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
String email;

    public String getId_employe() {
        return id_employe;
    }

    public String getNom_prénom_employe() {
        return nom_prénom_employe;
    }

    public String getType_employe() {
        return type_employe;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getNum_tel1() {
        return num_tel1;
    }

    public double getSalaire() {
        return salaire;
    }

    public employeur(String id_employe, String nom_prénom_employe, String type_client, String adresse, String email, String num_tel1, double salaire) {
        this.id_employe = id_employe;
        this.nom_prénom_employe = nom_prénom_employe;
        this.type_employe = type_client;
        this.adresse = adresse;
        this.email = email;
        this.num_tel1 = num_tel1;
        this.salaire = salaire;
    }
String num_tel1;
double salaire;
}

   
    

