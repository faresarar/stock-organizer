/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.Versement;
import vue.Aucceuil;
//import vue.Aucceuil4;

/**
 *
 * @author Rais
 */
public class Versement_client {
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
    Vector<Object> oneRow;
    TextNumber tn= TextNumber.getObj();
    
    
  private static Versement_client obj=null;
  public static Versement_client getObj(){
        if(obj==null){
            try {
         obj=new Versement_client();
            } catch (Exception ex) {
               
            }
        }return obj;
    }
    
    
 public  void inserer_versement(Versement v )throws Exception{
        try {
          Connection conn = jdbc.Getconnection();
           // Statement stmt = conn.createStatement();
              String sql = "insert into Versement_client (nom_prénom_client,date_versement,montant_versé,id_c,etat,num_bon_réception,remarque,regler_par,ancien_dette,rendu) values (?,?,?,?,?,?,?,?,?,?) ";
           //ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, v.getNom_prénom_fournisseur());
             // pr.setString(2, v.getId_fournisseur());
            pr.setDate(2, v.getDate_versement());
            pr.setDouble(3, v.getMontant_versé());
            pr.setInt(4, v.getId_fournisseur());
            pr.setString(5, v.getEtat());
            pr.setInt(6, v.getNum_bon_réception());
            pr.setString(7, v.getRemarque());
            pr.setString(8, v.getRegler_par());
            pr.setDouble(9, v.getAncien_dette());
            pr.setDouble(10, v.getRendu());
            pr.executeUpdate();
        pr.close();
        conn.close();
       //   System.out.println("versement inserer");
        } catch (Exception sc) {
            sc.printStackTrace();
        }
   }   
   public int GetNextNumVersement() throws Exception{
    int num=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(num_versement)   as maxid from versement_client ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =rs.getInt("maxid");
           //  System.out.println("max="+max);
          // if(max==0)num=1;
          num=max+1;
           //  System.out.println("ref="+ref);
        }

return num;
}
    public ArrayList getList_Versement_Client(int choix,int num_versement,String nom_fournisseur) throws Exception {
        String sql="";
        switch(choix){
            case 1:  sql = "select * FROM versement_client  where num_versement like '%"+num_versement+"%' order by num_versement desc"; break;
            case 2:  sql = "select * FROM versement_client where nom_prénom_client  like '%"+nom_fournisseur+"%' order by num_versement desc"; break;
            default:sql = "select * FROM versement_client order by num_versement desc"; break;
        
        }
               
  ArrayList<Versement> List_versement= new ArrayList<Versement>();   
         
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {           
            String nom_prenom_fournisseur =rs.getString("nom_prénom_client");
          
            Date date_versement =rs.getDate("date_versement");
            double montant_versé =rs.getDouble("montant_versé");
            int numero_versement =rs.getInt("num_versement");
            String etat =rs.getString("etat");
            String remarque =rs.getString("remarque");
             String regler_par =rs.getString("regler_par");
      List_versement.add(new Versement(nom_prenom_fournisseur,date_versement,montant_versé,numero_versement,etat,remarque,regler_par ) );
        }
        rs.close();
        conn.close();
        return List_versement;
    }

     public ArrayList getList_Versement_Client(int num_versement) throws Exception {
        String sql="";
      
           
            sql = "select * FROM paramaitres,Versement_client,client where client.id_c=Versement_client.id_c and num_versement='"+num_versement+"'  order by num_versement desc";
      //  String sql1="select * from paramaitres";
        
               
  ArrayList<Versement> List_versement= new ArrayList<Versement>();   
         
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
             // rs = stmt.executeQuery(sql1);
      while (rs.next()) { 
        String nom_prénom_fournisseur = rs.getString("nom_prénom_client");
        int id_f = rs.getInt("id_c");
        Date date_versement =rs.getDate("date_versement");
        double montant_versé =rs.getDouble("montant_versé");
      //  String etat =rs.getString("etat");
     //   int num_bon_réception =rs.getInt("num_bon_réception");
     //   String regler_par =rs.getString("regler_par");
        double ancien_dette =rs.getDouble ("ancien_dette");
        String nom_magasin =rs.getString("nom_magasin") ;
        String adresse = rs.getString("adresse");
        String num_tel_fax_fix_p = rs.getString("num_tel_fax_fix_p");
        String num_tel1 = rs.getString("num_tel1");
        String num_tel2 = rs.getString("num_tel2");
        String activite = rs.getString("activite");
        String num_tel1_p = rs.getString("num_tel1_p");
        String num_tel2_p = rs.getString("num_tel2_p");
        String adresse_p = rs.getString("adresse_p");
          
            int numero_versement =rs.getInt("num_versement");
          //  String remarque =rs.getString("remarque");
             List_versement.add(new Versement( nom_prénom_fournisseur,  id_f,  (date_versement),  montant_versé,  "valider", numero_versement,  
                     Aucceuil.userName, ancien_dette,  nom_magasin,  adresse_p, num_tel_fax_fix_p,  num_tel1_p,
                     num_tel2_p,  activite,num_tel1,num_tel2,adresse));
   //   List_versement.add(new Versement(nom_prenom_fournisseur,date_versement,montant_versé,numero_versement,remarque,regler_par ) );
        }
        rs.close();
        conn.close();
        return List_versement;
    }
    
    /*  public ArrayList getList_Versement_Fournisseur(String fournisseur,String type_ver,String date1,String date2) throws Exception {
           String sql = "select * FROM Versement_fournisseur where nom_prénom_fournisseur like %?%  and type_versement like  %?% and date_versement BETWEEN ? and ? order by date_versement desc   ";       
  ArrayList<Versement> List_versement= new ArrayList<Versement>();   
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
           // Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";   
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, fournisseur);
            pr.setString(2, type_ver);
            pr.setString(3, date1);
            pr.setString(4, date2);
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {           
           String nom_prenom_fournisseur =rs.getString("nom_prénom_fournisseur");
          
            String date_versement =rs.getString("date_versement");
            double montant_versé =rs.getDouble("montant_versé");
            String type_versement =rs.getString("type_versement");
      List_versement.add(new Versement(nom_prenom_fournisseur,date_versement,montant_versé,type_versement ) );
        }
        rs.close();
        conn.close();
        return List_versement;
    }*/
    
 public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Client");
    tableHeaders.add("date_versement");
    tableHeaders.add("montant_versé");
    tableHeaders.add("Etat");
   
    for (Object o : resultList) {
        Versement v = (Versement) o;
         oneRow = new Vector<Object>();
        oneRow.add(v.getNom_prénom_fournisseur());
        oneRow.add(v.getDate_versement());
        try {
            oneRow.add(tn.Afficher2Verguile(v.getMontant_versé()));
        } catch (Exception ex) {
            Logger.getLogger(Versement_client.class.getName()).log(Level.SEVERE, null, ex);
        }
        oneRow.add(v.getEtat());
     
       
              tableData.add(oneRow);
    }    
    
    jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
    
}
 
 public void displayResult1(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Client");
    tableHeaders.add("Date versement");
    tableHeaders.add("Montant versé");
    tableHeaders.add("Num Versement");
   tableHeaders.add("Etat");
    tableHeaders.add("Remarque");
     tableHeaders.add("Regler par");
   
    for (Object o : resultList) {
        Versement v = (Versement) o;
         oneRow = new Vector<Object>();
        oneRow.add(v.getNom_prénom_fournisseur());
        oneRow.add(v.getDate_versement());
        try {
            oneRow.add(tn.Afficher2Verguile(v.getMontant_versé()));
        } catch (Exception ex) {
            Logger.getLogger(Versement_client.class.getName()).log(Level.SEVERE, null, ex);
        }
        oneRow.add(v.getNum_versement());
        oneRow.add(v.getEtat());
        oneRow.add(v.getRemarque());
        oneRow.add(v.getRegler_par());
     
       
              tableData.add(oneRow);
    }    
    
    jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
    
}
 public void displayResult2(List<Versement> resultList,JTable jTable1) {
    
  //  Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
//lBareCode=ListCodeBarre;
// ButtonCell btc1=new ButtonCell(,lBareCode,jTable1);
  

   // Vector tableData = new Vector(); // récupérer les données ligne par ligne
  //   tableHeaders.add("Categorie_produit");
    //tableHeaders.add("Etat");
    //tableHeaders.add("Marque");
  
          
       DefaultTableModel model = new DefaultTableModel(0,8);
     //  model.addColumn("Code Barre");
    //  tableHeaders.add("Code Barre");
    // tableHeaders.add("Supprimer ");
  
    //tableHeaders.add("Date d'achat");
   
    ImageIcon icon = new ImageIcon("Images/icons8-poubelle-31.png");
        
    int size=resultList.size();
   if(size>0){
       for (int i=0;i<size;i++)
       model.addRow(new Object[]{resultList.get(i).getNom_prénom_fournisseur(),resultList.get(i).getDate_versement(),resultList.get(i).getMontant_versé(),resultList.get(i).getNum_versement(),resultList.get(i).getEtat(),resultList.get(i).getRemarque(),resultList.get(i).getRegler_par(),icon});
   
             }
       //  oneRow = new Vector<Object>();
      
   //  oneRow.add(ListCodeBarre.get(i));
       // oneRow.add("del");
       //System.out.println("valeur de code="+ListCodeBarre.get(i));
             // tableData.add(oneRow);
  
    

// oneRow.addMouseClicked
jTable1.setModel(model);
//jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
jTable1.getColumnModel().getColumn(7).setCellRenderer(new ButtonCell1(resultList,jTable1,"c"));
     jTable1.getColumnModel().getColumn(7).setCellEditor(new ButtonCell1(resultList,jTable1,"c"));
     // jTable1.getColumnModel().getColumn(6).setMinWidth(82);
         //  jTable1.getColumnModel().getColumn(6).setPreferredWidth(82);
        //  jTable1.getColumnModel().getColumn(6).setMaxWidth(82);
         jTable1.setRowHeight(32);
  
   jTable1.getColumnModel().getColumn(0).setHeaderValue("Client");
   jTable1.getColumnModel().getColumn(1).setHeaderValue("Date de versement");
   jTable1.getColumnModel().getColumn(2).setHeaderValue("Montant versé");
   jTable1.getColumnModel().getColumn(3).setHeaderValue("Num Versement");
   jTable1.getColumnModel().getColumn(4).setHeaderValue("Etat");
   jTable1.getColumnModel().getColumn(5).setHeaderValue("Remarque");
   jTable1.getColumnModel().getColumn(6).setHeaderValue("Regler par");
   jTable1.getColumnModel().getColumn(7).setHeaderValue("Supprimer");
    JTableHeader tableHeader = jTable1.getTableHeader();
     // tableHeader.setBackground(Color.blue);
     tableHeader.setForeground(Color.black);
    
 
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
 for (int columnIndex = 0; columnIndex < jTable1.getColumnCount()-1; columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
renderer.setHorizontalAlignment(0);

//jTable1.setAutoCreateRowSorter(true); 
 
   // Collections.sort(resultList,new VersementComparator());
}
  
 
 public void modifier_versement(  int  num_bon,double montant,String etat) throws Exception {
        
        try {
            Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
          
               String sql1 = "UPDATE Versement_client set montant_versé=?,etat=? where num_bon_réception=?";
              //ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
               pr.setDouble(1, montant);
               pr.setString(2, etat);
                pr.setInt(3, num_bon);
                pr.executeUpdate();
              //    System.out.println("execute update versement fournisseur");
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
           sc.printStackTrace();
        }
       
    }  
 
 public double GetMontantVerser(int num_versement) throws Exception{
    //String ref="B";
    double  m=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select montant_versé from Versement_client where num_versement= ?";
             PreparedStatement pr=conn.prepareStatement(sql);
               pr.setInt(1, num_versement);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            double max =(rs.getDouble("montant_versé"));
           m=max;
        }

return m;
}
 
  public void modifier_etat_versement(  int  num_bon,String etat) throws Exception {
        
        try {
             Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
          
               String sql1 = "UPDATE Versement_client set etat=? where num_bon_réception=?";
              //ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
               pr.setString(1, etat);
               pr.setInt(2, num_bon);
               pr.executeUpdate();
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
         //  sc.printStackTrace();
        }
       
    }  
  
  public  void Sup_Versement(int  num_versement)throws Exception{

        try {
//JdbcClass j=new JdbcClass();
            Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
              String sql = "delete  from versement_client where num_versement=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, num_versement);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
 public  void Sup_Versement2(int  num_bon)throws Exception{

        try {
//JdbcClass j=new JdbcClass();
            Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
              String sql = "delete  from versement_client where num_bon_réception=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, num_bon);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
    
    /*
    public int GetNextNumVersement() throws Exception{
    int num=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(num_versement)   as maxid from Versement_client ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =rs.getInt("maxid");
           //  System.out.println("max="+max);
          // if(max==0)num=1;
          num=max+1;
           //  System.out.println("ref="+ref);
        }

return num;
}
    
 /*public  void inserer_versement(Versement v )throws Exception{
        try {
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();
              String sql = "insert into Versement_client (nom_prénom_client,id_client,date_versement,montant_versé,type_versement) values (?,?,?,?,?) ";
            //ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, v.getNom_prénom_fournisseur());
             pr.setString(2, v.getId_fournisseur());
              pr.setString(3, v.getDate_versement());
               pr.setDouble(4, v.getMontant_versé());
                pr.setString(5, v.getType_versement());
                // pr.setString(6, sql);
                //  pr.setString(7, sql);
                  pr.executeUpdate();
        pr.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }   */
    
  /*  public  void inserer_versement(Versement v )throws Exception{
        try {
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();
              String sql = "insert into versement_client (nom_prénom_client,id_client,date_versement,montant_versé,num_versement) values ('"+v.getNom_prénom_fournisseur()+"','"+v.getId_fournisseur()+"','"+v.getDate_versement()+"','"+v.getMontant_versé()+"','"+v.getNum_versement()+"') ";
            ResultSet rs = stmt.executeQuery(sql);
          
        rs.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }   
    
public  void inserer_versement1(Versement v )throws Exception{
        try {
            Connection conn = jdbc.Getconnection();
             // String sql = "insert into Client (id_client,nom_prénom_client,type_client,adresse,email,num_tel1,num_tel2,num_reg_commerce,num_id_fiscale,num_article_imposition) values ('"+c.getId_client()+"','"+c.getNom_prénom_client()+"','"+c.getType_client()+"','"+c.getAdresse()+"','"+c.getEmail()+"','"+c.getNum_tel1()+"','"+c.getNum_tel2()+"','"+c.getNum_reg_commerce()+"','"+c.getNum_id_fiscale()+"','"+c.getNum_article_imposition()+"') ";
           
            String sql = "insert into versement_client (nom_prénom_client,id_client,date_versement,montant_versé,num_versement) values (?,?,?,?,?)";
           // ResultSet rs = stmt.executeQuery(sql);
          PreparedStatement pr=conn.prepareStatement(sql);
          pr.setString(1, v.getNom_prénom_fournisseur());
          pr.setInt(2, v.getId_fournisseur());
          pr.setString(3, v.getDate_versement());
          pr.setDouble(4, v.getMontant_versé());
         // pr.setString(5, v.getType_versement());
          pr.setInt(5, v.getNum_versement());
         
          // pr.setString(parameterIndex, sql);
          
          pr.executeUpdate();
        pr.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }
    
    public ArrayList getList_Versement_Client() throws Exception {
           String sql = "select * FROM Versement_client order by date_versement desc";       
  ArrayList<Versement> List_versement= new ArrayList<Versement>();   
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {           
            String nom_prenom_client =rs.getString("nom_prénom_client");
            int id_c=rs.getInt("id_c");
          
            String date_versement =rs.getString("date_versement");
            double montant_versé =rs.getDouble("montant_versé");
          String etat =rs.getString("etat");
      List_versement.add(new Versement(nom_prenom_client,date_versement,montant_versé,id_c ,etat,num_bon) );
        }
        rs.close();
        conn.close();
        return List_versement;
    }
    
      public ArrayList getList_Versement_Client(String client,String date1,String date2) throws Exception {
           String sql = "select * FROM Versement_client where nom_prénom_client like %?%    and date_versement BETWEEN ? and ? order by date_versement desc   ";       
  ArrayList<Versement> List_versement= new ArrayList<Versement>();   
             Connection conn = jdbc.Getconnection();
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, client);
         //   pr.setString(2, type_ver);
            pr.setString(2, date1);
            pr.setString(3, date2);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {           
           String nom_prenom_client =rs.getString("nom_prénom_client");
          
            String date_versement =rs.getString("date_versement");
            double montant_versé =rs.getDouble("montant_versé");
            int id_c=rs.getInt("id_c");
           String etat =rs.getString("etat");
      List_versement.add(new Versement(nom_prenom_client,date_versement,montant_versé,id_c,etat ) );
        }
        rs.close();
        conn.close();
        return List_versement;
    }
    
 public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Client");
    tableHeaders.add("date_versement");
    tableHeaders.add("montant_versé");
 //    tableHeaders.add("type_versement");
   
    for (Object o : resultList) {
        Versement v = (Versement) o;
         oneRow = new Vector<Object>();
        oneRow.add(v.getNom_prénom_fournisseur());
        oneRow.add(v.getDate_versement());
        oneRow.add(v.getMontant_versé());
       //  oneRow.add(v.getType_versement());
     
       
              tableData.add(oneRow);
    }    
    
    jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
    
}
 
 public double GetMontantVerser(int num_versement) throws Exception{
    //String ref="B";
    double  m=0;
   Connection conn = jdbc.Getconnection();
           // Statement stmt = conn.createStatement();
             String sql = "select montant_versé from Versement_client where num_versement= ?";
             PreparedStatement pr=conn.prepareStatement(sql);
             pr.setInt(1, num_versement);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            double max =rs.getDouble("montant_versé");
           m=max;
        }

return m;
}
 
  public void modifier_versement(  int  num_versement,double montant) throws Exception {
        
        try {
            Connection conn = jdbc.Getconnection();
          
               String sql1 = "UPDATE Versement_client set montant_versé=? where num_versement=?";
               PreparedStatement pr=conn.prepareStatement(sql1);
             pr.setDouble(1, montant);
             pr.setInt(2, num_versement);
              pr.executeUpdate();
              //ResultSet rs1 = stmt.executeQuery(sql1);
               
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
         //  sc.printStackTrace();
        }
       
    }  */
 public double getTotalMontantVerser(int id_client) throws Exception{
    //String ref="B";
    double  total=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select sum(montant_versé) as total_versement from Versement_client where id_c= ?";
             PreparedStatement pr=conn.prepareStatement(sql);
               pr.setInt(1, id_client);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
           total =(rs.getDouble("total_versement"));
          
        }

return total;
}
}