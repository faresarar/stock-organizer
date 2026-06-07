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
public class Client {
String id_client;
String nom_prénom_client;
String type_client;
String adresse;
String email;

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + ", nom_pr\u00e9nom_client=" + nom_prénom_client + ", type_client=" + type_client + ", adresse=" + adresse + ", email=" + email + ", num_tel1=" + num_tel1 + ", id_c=" + id_c + ", num_tel2=" + num_tel2 + ", num_reg_commerce=" + num_reg_commerce + ", num_id_fiscale=" + num_id_fiscale + ", num_article_imposition=" + num_article_imposition + ", cr\u00e9dit=" + crédit + '}';
    }
String num_tel1;
int id_c;
String num_tel2;
String num_reg_commerce;
String num_id_fiscale;
String num_article_imposition;
double crédit;
String rib_c;

    public String getRib_c() {
        return rib_c;
    }

    public void setRib_c(String rib_c) {
        this.rib_c = rib_c;
    }
    public int getId_c() {
        return id_c;
    }

    public void setId_c(int id_c) {
        this.id_c = id_c;
    }

    public Client(String id_client, String nom_prénom_client, String type_client, String adresse, String email, String num_tel1, String num_tel2, String num_reg_commerce, String num_id_fiscale, String num_article_imposition,String rib,double crédit) {
        this.id_client = id_client;
        this.nom_prénom_client = nom_prénom_client;
        this.type_client = type_client;
        this.adresse = adresse;
        this.email = email;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.num_reg_commerce = num_reg_commerce;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
        this.rib_c=rib;
         this.crédit = crédit;
    }

    public Client(String nom_prénom_client, int id_c, double crédit) {
        this.nom_prénom_client = nom_prénom_client;
        this.id_c = id_c;
        this.crédit = crédit;
    }


    public Client(String id_client, String nom_prénom_client, String type_client, String adresse, String email, String num_tel1, String num_tel2, String num_reg_commerce, String num_id_fiscale, String num_article_imposition,String RIB,int id_c, double crédit) {
        this.id_client = id_client;
        this.nom_prénom_client = nom_prénom_client;
        this.type_client = type_client;
        this.adresse = adresse;
        this.email = email;
        this.num_tel1= num_tel1;
        this.num_tel2 = num_tel2;
        this.num_reg_commerce = num_reg_commerce;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
        this.rib_c=RIB;   this.crédit = crédit;
        this.id_c=id_c;
        this.crédit=crédit;
     
     
        
    }

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getNom_prénom_client() {
        return nom_prénom_client;
    }

    public void setNom_prénom_client(String nom_prénom_client) {
        this.nom_prénom_client = nom_prénom_client;
    }

    public String getType_client() {
        return type_client;
    }

    public void setType_client(String type_client) {
        this.type_client = type_client;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse_client) {
        this.adresse = adresse_client;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_client) {
        this.email = email_client;
    }

   

    

    public String getNum_tel1() {
        return num_tel1;
    }

    public void setNum_tel1(String num_tel1) {
        this.num_tel1 = num_tel1;
    }

    public String getNum_tel2() {
        return num_tel2;
    }

    public void setNum_tel2(String num_tel2) {
        this.num_tel2 = num_tel2;
    }

    public String getNum_reg_commerce() {
        return num_reg_commerce;
    }

    public void setNum_reg_commerce(String num_reg_commerce) {
        this.num_reg_commerce = num_reg_commerce;
    }

    public String getNum_id_fiscale() {
        return num_id_fiscale;
    }

    public void setNum_id_fiscale(String num_id_fiscale) {
        this.num_id_fiscale = num_id_fiscale;
    }

    public String getNum_article_imposition() {
        return num_article_imposition;
    }

    public void setNum_article_imposition(String num_article_imposition) {
        this.num_article_imposition = num_article_imposition;
    }

    public double getCrédit() {
        return crédit;
    }

    public void setCrédit(double crédit) {
        this.crédit = crédit;
    }

    public Client() {
    }


   
   


   

        

}
