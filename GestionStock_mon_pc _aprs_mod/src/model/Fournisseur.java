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
public class Fournisseur {
private String id_fournisseur;
private String nom_prenom_fournisseur;
private String entreuprise;
private String email;
private double dette;

private String adresse; 
private String num_tel1_f;
private String num_tel2_f;
private String num_reg;
private String num_id_fiscale;
private String num_article_imposition;
private String rib_f;

    public String getNum_tel1_f() {
        return num_tel1_f;
    }

    public void setNum_tel1_f(String num_tel1_f) {
        this.num_tel1_f = num_tel1_f;
    }

    public String getNum_tel2_f() {
        return num_tel2_f;
    }

    public void setNum_tel2_f(String num_tel2_f) {
        this.num_tel2_f = num_tel2_f;
    }

    public String getRib_f() {
        return rib_f;
    }

    public void setRib_f(String rib_f) {
        this.rib_f = rib_f;
    }
private int id_f;


   

    public String getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(String id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getNom_prenom_fournisseur() {
        return nom_prenom_fournisseur;
    }

    public void setNom_prenom_fournisseur(String nom_prenom_fournisseur) {
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
    }

  
    public String getEntreuprise() {
        return entreuprise;
    }

    public void setEntreuprise(String entreuprise) {
        this.entreuprise = entreuprise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDette() {
        return dette;
    }

    public void setDette(double dette) {
        this.dette = dette;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNum_tel1() {
        return num_tel1_f;
    }

    public void setNum_tel1(String num_tel1) {
        this.num_tel1_f = num_tel1;
    }

    public String getNum_tel2() {
        return num_tel2_f;
    }

    public void setNum_tel2(String num_tel2) {
        this.num_tel2_f = num_tel2;
    }

    public String getNum_reg() {
        return num_reg;
    }

    public void setNum_reg(String num_reg) {
        this.num_reg = num_reg;
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

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }

  /*  @Override
    public String toString() {
        return "Fournisseur{" + "id_fournisseur=" + id_fournisseur + ", nom_prenom_fournisseur=" + nom_prenom_fournisseur + ", cat\u00e9gorie_fournisseur=" + catégorie_fournisseur + ", entreuprise=" + entreuprise + ", email=" + email + ", dette=" + dette + ", cr\u00e9dit=" + "" + ", adresse=" + adresse + ", num_tel1=" + num_tel1 + ", num_tel2=" + num_tel2 + ", num_reg=" + num_reg + ", num_id_fiscale=" + num_id_fiscale + ", num_article_imposition=" + num_article_imposition + '}';
    }
*/

  
    public Fournisseur(){}

   /*  public Fournisseur(String id_fournisseur, String nom_prenom_fournisseur, String entreuprise, String email, String adresse, String num_tel1, String num_tel2, String num_reg, String num_id_fiscale, String num_article_imposition) {
        this.id_fournisseur = id_fournisseur;
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
      //  this.catégorie_fournisseur = catégorie_fournisseur;
        this.entreuprise = entreuprise;
        this.email = email;
        this.adresse = adresse;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.num_reg = num_reg;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
    }
*/
    
    /*
    public Fournisseur(String id_fournisseur, String nom_prenom_fournisseur, String catégorie_fournisseur, String entreuprise, String email,  String adresse, String num_tel1, String num_tel2, String num_reg, String num_id_fiscale, String num_article_imposition,double dette) {
        this.id_fournisseur = id_fournisseur;
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
        this.catégorie_fournisseur = catégorie_fournisseur;
        this.entreuprise = entreuprise;
        this.email = email;
        this.dette = dette;
        this.adresse = adresse;
        this.num_tel1 = num_tel1;
        this.num_tel2 = num_tel2;
        this.num_reg = num_reg;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
      
    }
*/
     public Fournisseur(String id_fournisseur, String nom_prenom_fournisseur, String entreuprise, String email,  String adresse, String num_tel1, String num_tel2, String num_reg,
             String num_id_fiscale, String num_article_imposition,String rib_f,int id_f,double dette) {
        this.id_fournisseur = id_fournisseur;
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
       // this.catégorie_fournisseur = catégorie_fournisseur;
        this.entreuprise = entreuprise;
        this.email = email;
        this.dette = dette;
        this.adresse = adresse;
        this.num_tel1_f = num_tel1;
        this.num_tel2_f = num_tel2;
        this.num_reg = num_reg;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
        this.rib_f=rib_f;
        this.id_f=id_f;
         
    }
     public Fournisseur(String id_fournisseur, String nom_prenom_fournisseur, String entreuprise, String email,  String adresse, String num_tel1, String num_tel2, String num_reg,
             String num_id_fiscale, String num_article_imposition,String rib_f,double dette) {
        this.id_fournisseur = id_fournisseur;
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
       // this.catégorie_fournisseur = catégorie_fournisseur;
        this.entreuprise = entreuprise;
        this.email = email;
        this.dette = dette;
        this.adresse = adresse;
        this.num_tel1_f = num_tel1;
        this.num_tel2_f = num_tel2;
        this.num_reg = num_reg;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
        this.rib_f=rib_f;
       
         
    }
     
     
      public Fournisseur( String nom_prenom_fournisseur, String entreuprise, String email,  String adresse, String num_tel1, String num_tel2, String num_reg,
             String num_id_fiscale, String num_article_imposition,String rib_f,double dette) {
       
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
       // this.catégorie_fournisseur = catégorie_fournisseur;
        this.entreuprise = entreuprise;
        this.email = email;
        this.dette = dette;
        this.adresse = adresse;
        this.num_tel1_f = num_tel1;
        this.num_tel2_f = num_tel2;
        this.num_reg = num_reg;
        this.num_id_fiscale = num_id_fiscale;
        this.num_article_imposition = num_article_imposition;
        this.rib_f=rib_f;
       
         
    }

    public Fournisseur(String nom_prenom_fournisseur, double dette, int id_f) {
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
        this.dette = dette;
        this.id_f = id_f;
    }

    
  public Fournisseur(String nom_prenom_fournisseur,String adresse,String num_tel1,String num_tel2, double dette, int id_f) {
        this.nom_prenom_fournisseur = nom_prenom_fournisseur;
        this.dette = dette;
        this.id_f = id_f;
        this.adresse=adresse;
        this.num_tel1_f=num_tel1;
         this.num_tel2_f=num_tel2;
    }
  



        

}
