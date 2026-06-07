/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author lenovo
 */
public class VersementS {
 
int num_salaire;

    @Override
    public String toString() {
        return "salaire{" + "num_salaire=" + num_salaire + ", date=" + date + ", d\u00e9signation=" + nom_prenom + ", piece=" + remarque +  ", montant=" + montant + ", r\u00e9f\u00e9rence=" + type_versement + ", id_emplye=" + id_employe + '}';
    }

    public void setNum_salaire(int num_salaire) {
        this.num_salaire = num_salaire;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

    

   
    public void setMontant(double montant) {
        this.montant = montant;
    }

 



    public int getNum_salaire() {
        return num_salaire;
    }

    public Date getDate() {
        return date;
    }

 


    

    public double getMontant() {
        return montant;
    }


  

    public VersementS(int num_salaire,  String nom_prenom, String type_versement, String id_emplye, Date date,double montant, String remarque) {
        this.num_salaire = num_salaire;
        this.date = date;
        this.nom_prenom = nom_prenom;
        this.remarque = remarque;
       // this.prix_tache = prix_tache;
        this.montant = montant;
        this.type_versement =type_versement ;
        this.id_employe = id_emplye;
    }
       public VersementS( String nom_prenom, String type_versement, String id_emplye, Date date,double montant, String remarque) {
       // this.num_salaire = num_salaire;
        this.date = date;
        this.nom_prenom = nom_prenom;
        this.remarque = remarque;
       // this.prix_tache = prix_tache;
        this.montant = montant;
        this.type_versement =type_versement ;
        this.id_employe = id_emplye;
    }
       public VersementS(  String nom_prenom, String type_versement ,Date date,double montant, String remarque) {
       // this.num_salaire = num_salaire;
        this.date = date;
        this.nom_prenom = nom_prenom;
        this.remarque = remarque;
       // this.prix_tache = prix_tache;
        this.montant = montant;
        this.type_versement =type_versement ;
        //this.id_employe = id_emplye;
    }
       
Date date;
String nom_prenom;

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public void setType_versement(String type_versement) {
        this.type_versement = type_versement;
    }

    public void setId_employe(String id_employe) {
        this.id_employe = id_employe;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public String getRemarque() {
        return remarque;
    }

    public String getType_versement() {
        return type_versement;
    }

    public String getId_employe() {
        return id_employe;
    }
String remarque;
//double prix_tache;
double montant;
String type_versement;
String id_employe;

    
}
