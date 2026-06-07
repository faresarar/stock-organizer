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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Inventaire;

/**
 *
 * @author Rais
 */
public class Inventaire_op {
Vector<Object> oneRow;
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
TextNumber tn= TextNumber.getObj();
private static Inventaire_op instance;   
public Inventaire_op(){}
public static Inventaire_op getInstance(){
if(instance==null){
    instance=new Inventaire_op();
}
return instance;
} 

  public void InsererInventaire(Inventaire inv) throws Exception {
        // ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 
        try {
           Connection conn = jdbc.Getconnection();
           // Statement stmt = conn.createStatement();
             // String sql = "insert into  Crédit_client(id_client,nom_prénom_client,crédit) values ('"+id_client+"','"+nom_prenom_client+"','"+credit+"')" ;
           String sql = "insert into  inventaire( num_inv,  date,  libelle,  id_produit,  désignation,  qte_t,  qte_p,  equart_qte,  prix_achat_ttc, temp_inv, user) values (?,?,?,?,?,?,?,?,?,?,?)" ;
           //  System.out.println("3333333333");
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setInt(1, inv.getNum_inv());
           //   System.out.println("44444444444");
            pr.setDate(2, inv.getDate());
            pr.setString(3, inv.getLibelle());
            pr.setInt(4, inv.getId_produit());
            pr.setString(5, inv.getDésignation());
            pr.setFloat(6, inv.getQte_t());
            pr.setFloat(7, inv.getQte_p());
            pr.setFloat(8, inv.getEquart_qte());
            pr.setDouble(9, inv.getPrix_achat_ttc());
            pr.setString(10, inv.getTemp_inv());
            pr.setString(11, inv.getUser());
           // System.out.println("55555555555555");
            pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
      // System.out.println("6666666");
             pr.close();
        conn.close();

        } catch (Exception sc) {
            sc.printStackTrace();
          // JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
         throw new Exception(sc.getMessage(), sc);
        }
      
    }
  
  
  
public int GetNextNumInv() throws Exception{
   int ref=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(num_inv) as maxid from inventaire ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =(rs.getInt("maxid"));
           //  System.out.println("max="+max);
           
            ref=max+1;
           //  System.out.println("ref="+ref);
        }
return ref;
}     
  
  
  
  


public void displayResult(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    tableHeaders.add("N°");
    tableHeaders.add("Désignation");
    tableHeaders.add("Qte théorique");
    tableHeaders.add("Qte physique");
    tableHeaders.add("Ecart QTE");
    tableHeaders.add("Prix Achat TTC");
    int i=0;
  
    
    for (Object o : resultList) {
        i=i+1;
        Inventaire p = (Inventaire) o;
        oneRow = new Vector<Object>();
      
        oneRow.add(i);
        oneRow.add(p.getDésignation());
        oneRow.add(p.getQte_t());
        oneRow.add(p.getQte_p());
        oneRow.add(p.getEquart_qte());
        oneRow.add(tn.Afficher2Verguile(p.getPrix_achat_ttc()));
       
        tableData.add(oneRow);
           
    }

// oneRow.addMouseClicked

jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
 /* DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
jTable1.setDefaultRenderer(String.class, centerRenderer);
*/
   DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
    if (column==3)return true;
    else
        return false;
    }
    
  
};

jTable1.setModel(tableModel);
}
public ArrayList getList_Inventaire(int num) throws Exception {
         //
         String sql;
       
         sql = "select  distinct  date,temp_inv ,libelle,user  FROM inventaire where  num_inv like '%"+num+"%' order by date desc";
       
         
  ArrayList<Inventaire> List_inv= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
          //  int num_inv =rs.getInt("inv");
            Date date =rs.getDate("date");
         //    int id_produit =rs.getInt("id_produit");
           //   int qte_t =rs.getInt("qte_t");
             //  int qte_p =rs.getInt("qte_p");
             //   int equart_qte =rs.getInt("equart_qte");
              //    double prix_achat_ttc =rs.getInt("prix_achat_ttc");
             
            String temp_inv =rs.getString("temp_inv");
            String libelle =rs.getString("libelle");
            String user =rs.getString("user");
         
           
       //  int id_produit =rs.getInt("id_produit");
          List_inv.add(new Inventaire(num,date,libelle,user,temp_inv) );
        }
        rs.close();
        conn.close();

      
        return List_inv;
    }
public ArrayList getList_Inventaire3() throws Exception {
         //
         String sql;
       
         sql = "select  distinct  date,temp_inv ,libelle,user,num_inv  FROM inventaire    order by date desc";
       
         
  ArrayList<Inventaire> List_inv= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
           int num_inv =rs.getInt("num_inv");
            Date date =rs.getDate("date");
         //    int id_produit =rs.getInt("id_produit");
           //   int qte_t =rs.getInt("qte_t");
             //  int qte_p =rs.getInt("qte_p");
             //   int equart_qte =rs.getInt("equart_qte");
              //    double prix_achat_ttc =rs.getInt("prix_achat_ttc");
             
            String temp_inv =rs.getString("temp_inv");
            String libelle =rs.getString("libelle");
            String user =rs.getString("user");
         
           
       //  int id_produit =rs.getInt("id_produit");
          List_inv.add(new Inventaire(num_inv,date,libelle,user,temp_inv) );
        }
        rs.close();
        conn.close();

      
        return List_inv;
    }

public ArrayList getList_Inventaire2(int num) throws Exception {
         //
         String sql;
       
         sql = "select  *  FROM inventaire where  num_inv like '%"+num+"%' ";
       
         
  ArrayList<Inventaire> List_inv= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            
            Date date =rs.getDate("date");
            int id_produit =rs.getInt("id_produit");
              int qte_t =rs.getInt("qte_t");
              int qte_p =rs.getInt("qte_p");
               int equart_qte =rs.getInt("equart_qte");
                double prix_achat_ttc =rs.getInt("prix_achat_ttc");
             
            String temp_inv =rs.getString("temp_inv");
            String libelle =rs.getString("libelle");
            String désignation =rs.getString("désignation");
            String user =rs.getString("user");
         
       
       //  int id_produit =rs.getInt("id_produit");
          List_inv.add(new Inventaire( num,  date,  libelle,  id_produit,  désignation,  qte_t,  qte_p,  equart_qte,  prix_achat_ttc, temp_inv, user) );
        }
        rs.close();
        conn.close();

      
        return List_inv;
    }
 public ArrayList GetListInventaire(java.sql.Date d1,java.sql.Date d2) throws Exception{
    ArrayList<Inventaire> List_inv= new ArrayList<>();   
   Connection conn = jdbc.Getconnection();
      String    sql = "select distinct num_inv,date,temp_inv ,libelle,user FROM inventaire where  date between ?  and ?";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {      
            
           Date date =rs.getDate("date");
          //  int id_produit =rs.getInt("id_produit");
             int num_inv =rs.getInt("num_inv");
          //    int qte_t =rs.getInt("qte_t");
            //  int qte_p =rs.getInt("qte_p");
            //   int equart_qte =rs.getInt("equart_qte");
               // double prix_achat_ttc =rs.getInt("prix_achat_ttc");
             
            String temp_inv =rs.getString("temp_inv");
            String libelle =rs.getString("libelle");
           // String désignation =rs.getString("désignation");
            String user =rs.getString("user");     
        
       //  int id_produit =rs.getInt("id_produit");
          List_inv.add(new Inventaire(num_inv,date,libelle,user,temp_inv) );
        }
        rs.close();
        conn.close();

      
        return List_inv;
}  
public void displayResult1(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    tableHeaders.add("Num iventaire°");
    tableHeaders.add("Date");
    tableHeaders.add("Heure");
    tableHeaders.add("Libelle");
    tableHeaders.add("Utilisateur");
    //int i=0;
  
    
    for (Object o : resultList) {
    //   i=i+1;
        Inventaire p = (Inventaire) o;
        oneRow = new Vector<Object>();
      
        oneRow.add(p.getNum_inv());
        oneRow.add(p.getDate());
        oneRow.add(p.getTemp_inv());
        oneRow.add(p.getLibelle());
        oneRow.add(p.getUser());
      
       
        tableData.add(oneRow);
           
    }

// oneRow.addMouseClicked

jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
 /* DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
jTable1.setDefaultRenderer(String.class, centerRenderer);
*/
   DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
   
        return false;
    }
    
  
};

jTable1.setModel(tableModel);
}
public  void sup_inv(int  num)throws Exception{
        try {

              Connection conn = jdbc.Getconnection();
              String sql = "delete  from inventaire where num_inv=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, num);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  



}

