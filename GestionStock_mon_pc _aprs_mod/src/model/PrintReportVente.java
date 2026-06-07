/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;


/**
 *
 * @author Rais
 */
public class PrintReportVente  {

  /*  public PrintReportVente(Client c,Paramaitre p, ArrayList<Vente> ListVente, double crédit, String somme_word) {
        this.c=c;
        this.p = p;
        this.ListVente = ListVente;
        this.crédit = crédit;
        this.somme_word = somme_word;
        
    }
*/

   

    public PrintReportVente(String nom_magasin, String adresse_p, String num_tel_fax_fix_p, String num_tel1_p, String num_tel2_p, String NIS, String NRC, String NIF, String activite, String message, Date date_vente, String nom_prénom_client, float TVA, String adresse, String email, String num_tel1, String num_tel2, String num_reg_commerce, String num_id_fiscale, String num_article_imposition, double crédit, String désignation, double prix_achat, double prix_vente, float quantité_vente, double montantTTC, double montantHT, String temp_vente, String user, int id_produit, int idc, double somme_versé, double remise, int num_bon, String somme_word) {
        this.nom_magasin = nom_magasin;
        this.adresse_p = adresse_p;
        this.num_tel_fax_fix_p = num_tel_fax_fix_p;
        this.num_tel1_p = num_tel1_p;
        this.num_tel2_p = num_tel2_p;
        this.NIS = NIS;
        this.NRC = NRC;
        this.NIF = NIF;
        this.activite = activite;
        this.message = message;
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.adresse = adresse;
        this.email = email;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.num_reg_commerce = num_reg_commerce;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
        this.crédit = crédit;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
        this.temp_vente = temp_vente;
        this.user = user;
        this.id_produit = id_produit;
        this.idc = idc;
        this.somme_versé = somme_versé;
        this.remise = remise;
        this.num_bon = num_bon;
        this.somme_word = somme_word;
    }


  

   
Paramaitre p;
ArrayList<Vente> ListVente;
Client c;


double crédit;
String somme_word;


    String nom_magasin;
    String adresse_p;
    String num_tel_fax_fix_p;
    String num_tel1_p;
    String num_tel2_p;
    String NIS;
    String NRC;
    String NIF;
    String activite;
    String message;

    String adresse,email,num_tel1,num_tel2,num_reg_commerce,num_id_fiscale,num_article_imposition;
   

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public ArrayList<Vente> getListVente() {
        return ListVente;
    }

    public void setListVente(ArrayList<Vente> ListVente) {
        this.ListVente = ListVente;
    }

   

    public Paramaitre getP() {
        return p;
    }

    public void setP(Paramaitre p) {
        this.p = p;
    }







String désignation;
double prix_achat;
double prix_vente;
float quantité_vente;
double montantTTC;
double montantHT;
String temp_vente;
String user;
int id_produit;
int idc;
double somme_versé;
double remise;
int num_bon;
Date date_vente;    
String nom_prénom_client;
float TVA;
double rendu;
String code;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRendu() {
        return rendu;
    }

    public void setRendu(double rendu) {
        this.rendu = rendu;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PrintReportVente(String nom_magasin, String adresse_p, String num_tel_fax_fix_p, String num_tel1_p, 
            String num_tel2_p, String NRC, String NIS, String NIF, String activite, Date date_vente,
            String nom_prénom_client, float TVA, String désignation, double prix_achat, double prix_vente,
            float quantité_vente, double montantTTC, double montantHT, String temp_vente, String user,
            int id_produit, int idc, double somme_versé, double remise, int num_bon,String message,
            String somme_word,String adresse,String email,String num_tel1,String num_tel2,String num_reg_commerce,String num_id_fiscale,String num_article_imposition,double crédit,double rendu,String code) {
        this.nom_magasin = nom_magasin;
        this.adresse_p = adresse_p;
        this.num_tel_fax_fix_p = num_tel_fax_fix_p;
        this.num_tel1_p = num_tel1_p;
        this.num_tel2_p = num_tel2_p;
        this.NIS = NIS;
        this.NRC = NRC;
        this.NIF = NIF;
        this.activite = activite;
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
        this.temp_vente = temp_vente;
        this.user = user;
        this.id_produit = id_produit;
        this.idc = idc;
        this.somme_versé = somme_versé;
        this.remise = remise;
        this.num_bon = num_bon;
        this.message=message;
        
        this.somme_word = somme_word;
        this.adresse = adresse;
        this.email = email;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.num_reg_commerce = num_reg_commerce;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
        this.crédit = crédit;
        this.rendu=rendu;
        this.code=code;
    }
    
    
     public PrintReportVente(Paramaitre p,Client c, ArrayList<Vente> ListVente,
            String somme_word,double crédit) {
        this.nom_magasin = p.getNom_magasin();
        this.adresse_p = p.getAdresse_p();
        this.num_tel_fax_fix_p = p.getNum_tel_fax_fix_p();
        this.num_tel1_p = p.getNum_tel1_p();
        this.num_tel2_p =p.getNum_tel2_p();
        this.NIS = p.getNIS();
        this.NRC = p.getNRC();
        this.NIF = p.getNIF();
        this.activite = p.getActivite();
        this.message=p.getMessage();
        
        this.adresse =c.getAdresse();
        this.email = c.getEmail();
        this.num_tel1 = c.getNum_tel1();
        this.num_tel2 = c.getNum_tel2();
        this.num_reg_commerce = c.getNum_reg_commerce();
        this.num_id_fiscale = c.getNum_id_fiscale();
        this.num_article_imposition = c.getNum_article_imposition();
        this.idc = c.getId_c();
        this.nom_prénom_client = c.getNom_prénom_client();
        
        this.somme_word = somme_word;
        this.crédit = crédit;
        this.ListVente=ListVente;
        for(int i=0;i<ListVente.size();i++){
        this.date_vente=ListVente.get(i).date_vente  ;
        this.ListVente.get(i).TVA = TVA;
        this.désignation= ListVente.get(i).désignation ;
        this.ListVente.get(i).prix_achat = prix_achat;
        this.ListVente.get(i).prix_vente = prix_vente;
        this.ListVente.get(i).quantité_vente = quantité_vente;
        this.ListVente.get(i).montantTTC = montantTTC;
        this.ListVente.get(i).montantHT = montantHT;
        this.ListVente.get(i).temp_vente = temp_vente;
        this.ListVente.get(i).user = user;
        this.ListVente.get(i).id_produit = id_produit;
        this.ListVente.get(i).somme_versé = somme_versé;
        this.ListVente.get(i).remise = remise;
        this.ListVente.get(i).num_bon = num_bon;
        this.ListVente.get(i).rendu=rendu;
        this.code=ListVente.get(i).code;
        }
    }
    
     public PrintReportVente(String nom_magasin, String adresse_p, String num_tel_fax_fix_p, String num_tel1_p, 
            String num_tel2_p, String NRC, String NIS, String NIF, String activite, Date date_vente,
            String nom_prénom_client, float TVA, String désignation, double prix_achat, double prix_vente,
            float quantité_vente, double montantTTC, double montantHT, String temp_vente, String user,
            int id_produit, int idc, double somme_versé, double remise, int num_bon,String message,String somme_word) {
        this.nom_magasin = nom_magasin;
        this.adresse_p = adresse_p;
        this.num_tel_fax_fix_p = num_tel_fax_fix_p;
        this.num_tel1_p = num_tel1_p;
        this.num_tel2_p = num_tel2_p;
        this.NIS = NIS;
        this.NRC = NRC;
        this.NIF = NIF;
        this.activite = activite;
        this.date_vente = date_vente;
        this.nom_prénom_client = nom_prénom_client;
        this.TVA = TVA;
        this.désignation = désignation;
        this.prix_achat = prix_achat;
        this.prix_vente = prix_vente;
        this.quantité_vente = quantité_vente;
        this.montantTTC = montantTTC;
        this.montantHT = montantHT;
        this.temp_vente = temp_vente;
        this.user = user;
        this.id_produit = id_produit;
        this.idc = idc;
        this.somme_versé = somme_versé;
        this.remise = remise;
        this.num_bon = num_bon;
        this.message=message;
        this.somme_word=somme_word;
    }

    public String getNom_magasin() {
        return nom_magasin;
    }

    public void setNom_magasin(String nom_magasin) {
        this.nom_magasin = nom_magasin;
    }

    public String getAdresse_p() {
        return adresse_p;
    }

    public void setAdresse_p(String adresse_p) {
        this.adresse_p = adresse_p;
    }

    public String getNum_tel_fax_fix_p() {
        return num_tel_fax_fix_p;
    }

    public void setNum_tel_fax_fix_p(String num_tel_fax_fix_p) {
        this.num_tel_fax_fix_p = num_tel_fax_fix_p;
    }

    public String getNum_tel1_p() {
        return num_tel1_p;
    }

    public void setNum_tel1_p(String num_tel1_p) {
        this.num_tel1_p = num_tel1_p;
    }

    public String getNum_tel2_p() {
        return num_tel2_p;
    }

    public void setNum_tel2_p(String num_tel2_p) {
        this.num_tel2_p = num_tel2_p;
    }

    public String getNIS() {
        return NIS;
    }

    public void setNIS(String NIS) {
        this.NIS = NIS;
    }

   
    public String getNRC() {
        return NRC;
    }

    public void setNRC(String NRC) {
        this.NRC = NRC;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public Date getDate_vente() {
        return date_vente;
    }

    public void setDate_vente(Date date_vente) {
        this.date_vente = date_vente;
    }

    public String getNom_prénom_client() {
        return nom_prénom_client;
    }

    public void setNom_prénom_client(String nom_prénom_client) {
        this.nom_prénom_client = nom_prénom_client;
    }

    public float getTVA() {
        return TVA;
    }

    public void setTVA(float TVA) {
        this.TVA = TVA;
    }

    public String getDésignation() {
        return désignation;
    }

    public void setDésignation(String désignation) {
        this.désignation = désignation;
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

    public float getQuantité_vente() {
        return quantité_vente;
    }

    public void setQuantité_vente(float quantité_vente) {
        this.quantité_vente = quantité_vente;
    }

    public double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(double montantTTC) {
        this.montantTTC = montantTTC;
    }

    public double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(double montantHT) {
        this.montantHT = montantHT;
    }

    public String getTemp_vente() {
        return temp_vente;
    }

    public void setTemp_vente(String temp_vente) {
        this.temp_vente = temp_vente;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public double getSomme_versé() {
        return somme_versé;
    }

    public void setSomme_versé(double somme_versé) {
        this.somme_versé = somme_versé;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public int getNum_bon() {
        return num_bon;
    }

    public void setNum_bon(int num_bon) {
        this.num_bon = num_bon;
    }

    public String getSomme_word() {
        return somme_word;
    }

    public void setSomme_word(String somme_word) {
        this.somme_word = somme_word;
    }


 


    
}
