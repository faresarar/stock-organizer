/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Caisse;
/**
 *
 * @author hicham
 */
public class Caisse_op {
private static Caisse_op instance;   
public Caisse_op(){}
public static Caisse_op getInstance(){
if(instance==null){
    instance=new Caisse_op();
}
return instance;
}
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
Vector<Object> oneRow;
TextNumber tn= TextNumber.getObj();
public  void Encaissement_Décaissemnt(int num_caisse,double montant,Date date,String heure,String user,String déscription,String type_op,int num_facture )throws Exception{
        try {
          
           Connection conn = jdbc.Getconnection();
            // Statement stmt = conn.createStatement();
             // String sql = "insert into Achat (num_bon_réception,date_achat,nom_prénom_fournisseur,TVA,désignation,prix_achat,prix_vente,quantité,quantité_en_stock,montantTTC,montantHT,num_versement,référence) values ('"+A.getNum_bon_réception()+"','"+A.getDate_achat()+"','"+A.getNom_prénom_fournisseur()+"','"+A.getTVA()+"','"+A.getDésignation()+"','"+A.getPrix_achat()+"','"+A.getPrix_vente()+"','"+A.getQuantité()+"','"+ A.getQuantité_en_stock()+"',  '"+A.getMontantTTC()+"','"+A.getMontantHT()+"' ,'"+A.getNum_versement_achat()+"','"+A.getRéférence()+"') ";
            
            String sql = "insert into caisse_op ( num_caisse,  montant,  date,heure, user,déscription, type_op,num_facture) values (?,?,?,?,?,?,?,?)";
            // ResultSet rs = stmt.executeQuery(sql);
          PreparedStatement pr=conn.prepareStatement(sql);
          pr.setInt(1, num_caisse);
          pr.setDouble(2, montant);
          pr.setDate(3, date);
          pr.setString(4, heure);
          pr.setString(5, user);
             
          pr.setString(6,déscription);
          pr.setString(7, type_op);
          pr.setInt(8,num_facture);
        
          
          pr.executeUpdate();
           System.out.println("operation reussite");
        pr.close();
        conn.close();
        } catch (Exception sc) {
          sc.printStackTrace();
        }
   }          

   public void displayResult1(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Num_caisse");
   tableHeaders.add("Solde");
   
     if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Caisse f = (Caisse) o;
         oneRow = new Vector<Object>();
      oneRow.add(f.getNum());
      oneRow.add(tn.Afficher2Verguile(f.getMontant()));
       
       
              tableData.add(oneRow);
              
    }
jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));


DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
  return false;
    }
    
  
};

jTable1.setModel(tableModel);


 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
 for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
renderer.setHorizontalAlignment(0);

jTable1.setAutoCreateRowSorter(true);

     }

}
   
 public void displayResult2(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Type d'opération");
     tableHeaders.add("Num facture");
     tableHeaders.add("Déscription");
     tableHeaders.add("Date");
     tableHeaders.add("Heure");
     tableHeaders.add("Montant");
     tableHeaders.add("Utilisateur");
   
     if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Caisse f = (Caisse) o;
      oneRow = new Vector<Object>();
      oneRow.add(f.getType_op());
      oneRow.add(f.getNum_facture());
      oneRow.add(f.getDéscription());
      oneRow.add(f.getDate());
      oneRow.add(f.getHeure());
      oneRow.add(tn.Afficher2Verguile(f.getMontant()));
      oneRow.add(f.getUser());
      
      tableData.add(oneRow);
              
    }
jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));


DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
  return false;
    }
    
  
};

jTable1.setModel(tableModel);


 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
 for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
renderer.setHorizontalAlignment(0);

jTable1.setAutoCreateRowSorter(true);

     }

}   
   
   
   
   
public ArrayList getList_Caisse() throws Exception {
         //
        String sql = "select * FROM Caisse order by num_caisse asc ";
 
       
         
  ArrayList<Caisse> List= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
         Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery(sql);
      while (rs.next()) {      
            int num =rs.getInt("num_caisse");
            double montant =rs.getDouble("montant");
      
          List.add(new Caisse(num,montant ) );
        }
        rs.close();
        conn.close();

      
        return List;
    }
    
   public  void sup_Caisse(int  id)throws Exception{

        try {
//JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
              String sql = "delete  from caisse where num_caisse=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, id);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}     
 public  void Inserer_caisse( int num_caisse,double montant )throws Exception{
        try {
          
           Connection conn = jdbc.Getconnection();
            // Statement stmt = conn.createStatement();
             // String sql = "insert into Achat (num_bon_réception,date_achat,nom_prénom_fournisseur,TVA,désignation,prix_achat,prix_vente,quantité,quantité_en_stock,montantTTC,montantHT,num_versement,référence) values ('"+A.getNum_bon_réception()+"','"+A.getDate_achat()+"','"+A.getNom_prénom_fournisseur()+"','"+A.getTVA()+"','"+A.getDésignation()+"','"+A.getPrix_achat()+"','"+A.getPrix_vente()+"','"+A.getQuantité()+"','"+ A.getQuantité_en_stock()+"',  '"+A.getMontantTTC()+"','"+A.getMontantHT()+"' ,'"+A.getNum_versement_achat()+"','"+A.getRéférence()+"') ";
            
            String sql = "insert into Caisse ( num_caisse,montant) values (?,?)";
            // ResultSet rs = stmt.executeQuery(sql);
          PreparedStatement pr=conn.prepareStatement(sql);
         
          pr.setDouble(1, num_caisse);
          pr.setDouble(2, montant);
             
        
          
          pr.executeUpdate();
                          
        pr.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }         
   public int GetNextNumCaisse() throws Exception{
    //String ref="B";
    int ref=0;
 //JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(num_caisse)   as maxid from caisse ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =(rs.getInt("maxid"));
           //  System.out.println("max="+max);
           
            ref=max+1;
           //  System.out.println("ref="+ref);
        }

return ref;
}
   
 public void modifier_Caisse(Caisse c) throws Exception {
        
        try {
             Connection conn = jdbc.Getconnection();
            //Statement stmt = conn.createStatement();
          
              // String sql1 = "UPDATE Vente set date_vente='"+f.getDate_vente()+"', nom_prénom_client='"+f.getNom_prénom_cient()+"' , TVA='"+f.getTVA()+"' , désignation='"+f.getDésignation()+"' , prix_achat='"+f.getPrix_achat()+"'  , prix_vente='"+f.getPrix_vente()+"' , quantité='"+f.getQuantité_vente()+"' , quantité_en_stock='"+f.getQuantité_stock()+"'   where num_versement_achat='"+f.getNum_versement_vente()+"'";
            String sql1 = "UPDATE Caisse set montant=?  where num_caisse=?";
            PreparedStatement pr=conn.prepareStatement(sql1);
            pr.setDouble(1, c.getMontant());
            pr.setInt(2, c.getNum());
           
            pr.executeUpdate();
        //  System.out.println("new montant="+c.getMontant());
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
          // sc.printStackTrace();
        }
       
    }     
   
 public ArrayList getList_Op_Caisse(String usr) throws Exception {
         //
          String sql;
     //     if(usr.equals("Tous"))
   // sql = "select * FROM Caisse_op order by id desc ";    
        //  else 
          sql = "select * FROM Caisse_op where user like '%"+usr+"%' order by id desc ";  
  ArrayList<Caisse> List= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
         Connection conn = jdbc.Getconnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
   //  if(!usr.equals("Tous"))     pr.setString(1, usr);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
          
      while (rs.next()) {      
            int num =rs.getInt("num_caisse");
            double montant =rs.getDouble("montant");
             Date date =rs.getDate("date");
             String heure =rs.getString("heure");
            //  String user=usr;
          //  if(usr.equals("Tous"))   
               String user =rs.getString("user");
          //  else user=usr;
             String déscription =rs.getString("déscription");
             String type_op =rs.getString("type_op");
             int num_facture =rs.getInt("num_facture");
            
      
          List.add(new Caisse( num,  montant,  date,  heure,  déscription,  user,  type_op,  num_facture ) );
        }
        rs.close();
        conn.close();

      
        return List;
    }
  public ArrayList getList_Op_Caisse(String usr,String type_op,java.sql.Date d1,java.sql.Date d2) throws Exception {
         //
          String sql;
          
         // if(usr.equals("Tous")&&type_op.equals("Tous"))
  //  sql = "select * FROM Caisse_op  order by id desc ";    
            sql = "select * FROM Caisse_op where  user like '%"+usr+"%'  and type_op like '%"+type_op+"%'   and date between ?  and ? order by id desc ";  
  ArrayList<Caisse> List= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
         Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql);
   //   pr.setString(1, usr);
      // pr.setString(2, type_op);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
    //     pr.setString(1, usr);
    // pr.setString(2, type_op);
  //   else pr.setString(1, type_op);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
         // ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            int num =rs.getInt("num_caisse");
            double montant =rs.getDouble("montant");
             Date date =rs.getDate("date");
             String heure =rs.getString("heure");
              String user=usr;
           // if(usr.equals("Tous"))  
           user =rs.getString("user");
          //  else user=usr;
             String déscription =rs.getString("déscription");
            String typeop =rs.getString("type_op");
             int num_facture =rs.getInt("num_facture");
            
      
          List.add(new Caisse( num,  montant,  date,  heure,  déscription,  user,  typeop,  num_facture ) );
        }
        rs.close();
        conn.close();

      
        return List;
    }
  public ArrayList getList_Op_Achat(String usr,java.sql.Date d1,java.sql.Date d2) throws Exception {
         //
          String sql;
           //  if(usr.equals("Tous"))
// sql  = "select DISTINCT num_bon_réception,date_achat,temp_achat,user,somme_versé FROM achat order by id desc ";     
         //    else 
 sql  = "select DISTINCT num_bon_réception,date_achat,temp_achat,somme_versé,user FROM achat where  user like '%"+usr+"%' and date_achat between ?  and ?  ";   
  ArrayList<Caisse> List= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
         Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
             String user=usr;
      while (rs.next()) {      
         //   int num =rs.getInt("num_bon_réception");
            double montant =rs.getDouble("somme_versé");
             Date date =rs.getDate("date_achat");
             String heure =rs.getString("temp_achat");
           
           // if(usr.equals("Tous"))  
                user =rs.getString("user");
             String déscription ="";
             String type_op ="Achat";
             int num_facture =rs.getInt("num_bon_réception");
            
      
          List.add(new Caisse( 0,  montant,  date,  heure,  déscription,  user,  type_op,  num_facture ) );
        }
        rs.close();
        conn.close();

      
        return List;
    }
   public ArrayList getList_Op_Vente(String usr,java.sql.Date d1,java.sql.Date d2) throws Exception {
   String sql;
         //    if(usr.equals("Tous"))
   // sql = "select DISTINCT num_bon,date_vente,temp_vente,user,somme_versé FROM vente order by id_vente desc ";   
            // else
             sql= "select DISTINCT num_bon,date_vente,temp_vente,somme_versé,user FROM vente where user like  '%"+usr+"%' and date_vente between ?  and ? order by id_vente desc ";
  ArrayList<Caisse> List= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
         Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
             String user=usr;
      while (rs.next()) {      
         //   int num =rs.getInt("num_bon_réception");
            double montant =rs.getDouble("somme_versé");
             Date date =rs.getDate("date_vente");
             String heure =rs.getString("temp_vente");
          //   if(usr.equals("Tous"))   
                 user =rs.getString("user");
             String déscription ="";
             String type_op ="Vente";
             int num_facture =rs.getInt("num_bon");
            
      
          List.add(new Caisse( 0,  montant,  date,  heure,  déscription,  user,  type_op,  num_facture ) );
        }
        rs.close();
        conn.close();

      
        return List;
    }
 
   
}
