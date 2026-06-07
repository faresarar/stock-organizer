/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Rais
 */
public class Statistiques_op {
     long millis=System.currentTimeMillis(); 
 java.sql.Date date = new java.sql.Date(millis);    
 private static Statistiques_op instance;   
public Statistiques_op(){}
public static Statistiques_op getInstance(){
if(instance==null){
    instance=new Statistiques_op();
}
return instance;
}   
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
public int GetNombreClient() throws Exception{
    int q=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select count(id_client)  as nbclient from Client  ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
      int nbclient =rs.getInt("nbclient");
               
            q=nbclient;
        }
//System.out.println(q);
return q;
}         
    
  public int GetNombreFournisseur() throws Exception{
    int q=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select count(id_fournisseur)  as nbfournisseur from Fournisseur  ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
      int nbfournisseur =rs.getInt("nbfournisseur");
               
            q=nbfournisseur;
        }
//System.out.println(q);
return q;
}   
  public int GetNombreProduit() throws Exception{
    int q=0;
  Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select count(distinct référence)  as nbproduit from Produit  ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
      int nbproduit =rs.getInt("nbproduit");
               
            q=nbproduit;
        }
//System.out.println(q);
return q;
}           
  
   public double TotalCrédit() throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select sum(crédit)  as total_credit from client ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
       q =rs.getDouble("total_credit");
               
            
        }
        conn.close();
//System.out.println(q);
return q;
}     
   
  public double TotalVersementClient() throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select sum(montant_versé)  as t_v_c from versement_client where etat='valider' ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
     q=rs.getDouble("t_v_c");
                 
        }
        conn.close();
//System.out.println(q);
return q;
}             
  public double GetTotalVersementClient(java.sql.Date d1,java.sql.Date d2) throws Exception{
    double q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select sum(montant_versé)  as mVerse from Versement_client where date_versement between ? and ? and etat='valider' ";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
    q =rs.getDouble("mVerse");
               
            
        }
        conn.close();
//System.out.println(q);
return q;
}  
  public double TotalDette() throws Exception{
    double q=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select sum(dette)  as total_dette from fournisseur ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
      double total_dette =rs.getDouble("total_dette");
               
            q=total_dette;
        }
        conn.close();
//System.out.println(q);
return q;
}
  
   public int GetNombreAchat(java.sql.Date d1,java.sql.Date d2) throws Exception{
    int q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select count(distinct num_bon_réception)  as nbachatt from Achat where date_achat between ? and ?  ";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
      int nbachatt =rs.getInt("nbachatt");
               
            q=nbachatt;
        }
        conn.close();
//System.out.println(q);
return q;
}      
     public int GetNombreAchat() throws Exception{
    int q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select  count(distinct num_bon_réception)  as nbachatt from Achat   ";
            PreparedStatement pr=conn.prepareStatement(sql);
         
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
       q =rs.getInt("nbachatt");
               
           
        }
        conn.close();
//System.out.println(q);
return q;
}           
   
 public double GetTotalAchat(java.sql.Date d1,java.sql.Date d2) throws Exception{
    double q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select prix_achat,quantité  from Achat where date_achat between ? and ?  ";
          PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
  double p_achat=rs.getDouble("prix_achat");
            float quantité=rs.getFloat("quantité");
       q =q+p_achat*quantité;
        }
        conn.close();
//System.out.println(q);
return q;
}  
 public double GetTotalAchat() throws Exception{
    double q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select prix_achat,quantité  from Achat ";
          PreparedStatement pr=conn.prepareStatement(sql);
         
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         double p_achat=rs.getDouble("prix_achat");
            float quantité=rs.getFloat("quantité");
       q =q+p_achat*quantité;
               
         
        }
        conn.close();
//System.out.println(q);
return q;
}  
 
 public int GetNombreVente(java.sql.Date d1,java.sql.Date d2) throws Exception{
    int q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select count(distinct num_bon)  as nbVente from Vente where date_vente between ? and ?  ";
          PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
      int nbVente =rs.getInt("nbVente");
               
            q=nbVente;
        }
//System.out.println(q);
return q;
}   
 public int GetNombreVente() throws Exception{
    int q=0;
   Connection conn = jdbc.Getconnection();
   String sql = "select  count(DISTINCT  num_bon)  as nbVente from Vente  ";
   PreparedStatement pr=conn.prepareStatement(sql);
   ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
      int nbVente =rs.getInt("nbVente"); 
            q=nbVente;
        }
//System.out.println(q);
return q;
}   
 
 public double GetTotalVente(java.sql.Date d1,java.sql.Date d2) throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
             String sql = "select sum(montantTTC)  as totalVente from Vente where date_vente between ? and ?  ";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
      double totalVente =rs.getDouble("totalVente");
               
            q=totalVente;
        }
        conn.close();
//System.out.println(q);
return q;
}  
  public double GetTotalVente() throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
             String sql = "select sum(montantTTC)  as totalVente from Vente   ";
            PreparedStatement pr=conn.prepareStatement(sql);
         
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
      double totalVente =rs.getDouble("totalVente");
               
            q=totalVente;
        }
        conn.close();
//System.out.println(q);
return q;
}  
 
 
 public double GetTotalDepense(int a1,int a2,int m1,int m2) throws Exception{
    double q=0;
    m1=m1+1;
    m2=m2+1;
  //  System.out.println("m1="+m1+"        m2="+m2);
  // System.out.println("a1="+a1+"        a2="+a2);
 //JdbcClass j=new JdbcClass();
            Connection conn =jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select sum(montant) as m from dépence where année >= '"+a1+"' and année <='"+a2+"'  and mois  >= '"+m1+"' and  mois <='"+m2+"' ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
    // double éléctricité =rs.getDouble("éléctricité");
       //     double eau =rs.getDouble("eau");
       //      double location =rs.getDouble("location");
          //    double salaire_employée =rs.getDouble("salaire_employée");
                q =rs.getDouble("m");
               
           // q=éléctricité+eau+location+salaire_employée+autre_frais;
        }
//System.out.println("total depense="+q);
return q;
}  
  public double GetTotalDepense() throws Exception{
    double q=0;
 //JdbcClass j=new JdbcClass();
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select sum(montant) as m from dépence   ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
      q =rs.getDouble("m");
            
        }
//System.out.println(q);
return q;
}  
 
 
 public double GetTotalBenificeSansdepense(java.sql.Date d1,java.sql.Date d2) throws Exception{
    double q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select prix_achat,prix_vente,quantité_vente from vente where date_vente between ? and ? ";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
        //    System.out.println("0000000000000000000");
            ResultSet rs = pr.executeQuery();
                 //   System.out.println("111111111111111111");
        while (rs.next()) {
             //    System.out.println("2222222222");
      double prix_achat =rs.getDouble("prix_achat");
        //      System.out.println("333333333333");
      double prix_vente =rs.getDouble("prix_vente");
          //    System.out.println("444444444444");
      float quantité_vente =rs.getFloat("quantité_vente");
           //   System.out.println("555555555555555");
               
            q=q+((prix_vente-prix_achat)*quantité_vente);
               //     System.out.println("6666666666666666");
          //  System.out.println("q="+q);
        }
        conn.close();
          //      System.out.println("77777777777");

return q;
}  
 public double GetTotalBenificeSansdepense() throws Exception{
    double q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select prix_achat,prix_vente,quantité_vente from Vente ";
            PreparedStatement pr=conn.prepareStatement(sql);
          
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
      double prix_achat =rs.getDouble("prix_achat");
      double prix_vente =rs.getDouble("prix_vente");
      float quantité_vente =rs.getFloat("quantité_vente");
               
            q=q+((prix_vente-prix_achat)*quantité_vente);
        }
        conn.close();
//System.out.println(q);
return q;
}  
 
 
 public double GetTotalbudjet() throws Exception{
    double q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select prix_achat,quantité from produit  ";
            PreparedStatement pr=conn.prepareStatement(sql);
           
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
      double prix_achat =rs.getDouble("prix_achat");
      //double prix_vente =rs.getDouble("prix_vente");
      int quantité =rs.getInt("quantité");
               
            q=q+(prix_achat*quantité);
        }
        conn.close();
//System.out.println(q);
return q;
}  
 
 
 
 
 public double GetTotalVersementFournisseur(java.sql.Date d1,java.sql.Date d2) throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
             String sql = "select sum(montant_versé)  as mVerse from Versement_fournisseur where date_versement between ? and ?  ";
              PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
           // ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
      double mVerse =rs.getDouble("mVerse");
               
            q=mVerse;
        }
        conn.close();
//System.out.println(q);
return q;
}  
 
   public double TotalVersementFournisseur() throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select sum(montant_versé)  as t_v_c from versement_fournisseur  ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
     q=rs.getDouble("t_v_c");
                 
        }
        conn.close();
//System.out.println(q);
return q;
}             
 
 public int getNbre_Produit_périme() throws Exception {
         int n=0; 
        try {
          Connection conn = jdbc.Getconnection();
       Statement stmt = conn.createStatement();  
        String sql = "select count(référence) as nbre FROM Produit where date_premption between '2000-01-01' and '"+date+"' ";
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {           
           // String date_premption =rs.getString("date_premption");
             n =rs.getInt("nbre");
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
         sc.printStackTrace();
        }
        return n;
    }
 
 public int getNbre_Produit_répture() throws Exception {
         int n=0; 
        try {
          Connection conn = jdbc.Getconnection();
       Statement stmt = conn.createStatement();  
        String  sql = "select count(référence) as nbre FROM Produit where quantité <= 0 ";
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {           
           // String date_premption =rs.getString("date_premption");
             n =rs.getInt("nbre");
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
         sc.printStackTrace();
        }
        return n;
    }
  public int GetNombreEmploye() throws Exception{
    int q=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select count(id_employe)  as nb from employe  ";
          PreparedStatement pr=conn.prepareStatement(sql);
        
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
     q =rs.getInt("nb");
               
           
        }
//System.out.println(q);
return q;
}   
 public double TotalVersementEmploye() throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select sum(montant)  as t_v_c from salaire_employe  ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         
     q=rs.getDouble("t_v_c");
                 
        }
        conn.close();
//System.out.println(q);
return q;
}   
 public double TotalVersementEmploye(java.sql.Date d1,java.sql.Date d2) throws Exception{
    double q=0;
  Connection conn = jdbc.Getconnection();
        //    Statement stmt = conn.createStatement();
        String sql = "select sum(montant)  as t_v_c from salaire_employe where date_versement between ? and ? ";
          PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
          
             
           ResultSet rs = pr.executeQuery();
        while (rs.next()) {
         
     q=rs.getDouble("t_v_c");
                 
        }
        conn.close();
//System.out.println(q);
return q;
}            
 
 
  /*Date getDate(String annee,String moi){
  Date date=null;
   String d;
  String mm="";
  switch(moi){

      case "janvier":mm="01";break;
      case "février":mm="02";break;
      case "mars":mm="03";break;
      case "Avril":mm="04";break;
      case "Mai":mm="05";break;
      case "Juin":mm="06";break;
      case "Juillet":mm="07";break;
      case "Aout":mm="08";break;
      case "Septembre":mm="09";break;
      case "Octobre":mm="10";break;
      case "Novembre":mm="11";break;
      case "Décembre":mm="12";break;
  }
    d=annee+"/"+mm+"/"+"01";
    System.out.println("d="+d);
  return date; 
  }*/
 public double getNetCaisse() throws Exception {
       double m=0;
        String sql = "select sum(montant) as smo FROM Caisse  ";
 
         Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql);        
            ResultSet rs = pr.executeQuery(sql);
      while (rs.next()) {      
           
             m =rs.getDouble("smo");
      
        
        }
        rs.close();
        conn.close();

      
        return m;
    }
  public double getTotalEncaissemnt() throws Exception {
       double m=0;
        String sql = "select sum(montant) as smo FROM Caisse_op where type_op ='Encaissement'  ";
 
         Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql);  
           
            ResultSet rs = pr.executeQuery(sql);
      while (rs.next()) {      
           
             m =rs.getDouble("smo");
      
        
        }
        rs.close();
        conn.close();

      
        return m;
    }  
  
   public double getTotalEncaissemnt(java.sql.Date d1,java.sql.Date d2) throws Exception {
       double m=0;
        String sql = "select sum(montant) as smo FROM Caisse_op where type_op ='Encaissement' and  date between ? and ?  ";
 
         Connection conn = jdbc.Getconnection();
     PreparedStatement pr=conn.prepareStatement(sql);
         
           pr.setDate(1, d1);
           pr.setDate(2, d2);
          
             
           ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
           
             m =rs.getDouble("smo");
      
        
        }
        rs.close();
        conn.close();

      
        return m;
    }  
   public double getTotalDecaissemnt() throws Exception {
       double m=0;
        String sql = "select sum(montant) as smo FROM Caisse_op where type_op ='Décaissement'  ";
 
         Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql); 
     
            ResultSet rs = pr.executeQuery(sql);
      while (rs.next()) {      
           
             m =rs.getDouble("smo");
      
        
        }
        rs.close();
        conn.close();

      
        return m;
    }  
  
   public double getTotalDecaissemnt(java.sql.Date d1,java.sql.Date d2) throws Exception {
       double m=0;
        String sql = "select sum(montant) as smo FROM Caisse_op where type_op ='Décaissement' and  date between ? and ?  ";
 
         Connection conn = jdbc.Getconnection();
     PreparedStatement pr=conn.prepareStatement(sql);
          
           
           pr.setDate(1, d1);
           pr.setDate(2, d2);
             
           ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
           
             m =rs.getDouble("smo");
      
        
        }
        rs.close();
        conn.close();

      
        return m;
    }  
}
