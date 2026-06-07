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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.employeur;

/**
 *
 * @author lenovo
 */
public class Employe_op {
   private static Employe_op instance;   
public Employe_op(){}
public static Employe_op getInstance(){
if(instance==null){
    instance=new Employe_op();
}
return instance;
}
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();

    Vector<Object> oneRow;
     ImageIcon   img = new ImageIcon("Images/erreur.GIF");
   
public boolean  fonctionExist(String type) throws Exception {
       //  ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 boolean a=false;
        try {
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
              String sql = "select * FROM Typeemploye where type='"+type+"'";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String t =(rs.getString("type"));
            if(t.equals(type)&&(!type.equals("")))
            {  JOptionPane.showMessageDialog(null, " Cette fonction existe deja", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }


public  void inserer_fonction(String valeur )throws Exception{
        try {
         Connection conn = jdbc.Getconnection();
              String sql = "insert into Typeemploye (type) values (?) ";
               PreparedStatement pr=conn.prepareStatement(sql);
               pr.setString(1, valeur);
               pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
          
        pr.close();
        conn.close();
        } catch (Exception sc) {
        }
   }



public  void Charger_foction( JComboBox type ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
type.setRenderer(centr);
type.removeAllItems();

 try {
          Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT * FROM Typeemploye  order by type asc";
                 
         
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             type.addItem(rs.getString("type") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }
public  void Charger_emp( JComboBox type ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
type.setRenderer(centr);
type.removeAllItems();

 try {
         Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT nom_prénom_employe FROM Employe order by nom_prénom_employe asc";
                 
         
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             type.addItem(rs.getString("nom_prénom_employe") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   type.addItem("Passager");
   }

  public  void sup_Type(String  type)throws Exception{

        try {
Connection conn = jdbc.Getconnection();

              String sql = "delete  from Typeemploye where type=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, type);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  
  public String GetNextReferenceClient() throws Exception{
    String ref="E";
    int max=0;
 Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select count(*)  as maxrow from Employe ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
             max =(rs.getInt("maxrow"));}
           //  System.out.println("max="+max);
           
           //  System.out.println("ref="+ref);
        
  if(max==0){ref=ref+1;}else{
  ref=ref+(max+1);}

return ref;
}
  
  public boolean  ClientExist(String param1) throws Exception {
    String sql;
            sql = "select * FROM Employe where nom_prénom_employe=?";
            
           
 boolean a=false;
        try {
          Connection conn = jdbc.Getconnection();
          PreparedStatement pr=conn.prepareStatement(sql);
           pr.setString(1, param1);
           ResultSet rs=pr.executeQuery();
        while (rs.next()) {
            String nom_prenom =(rs.getString("nom_prénom_employe"));
            if(nom_prenom.equals(param1)&&(!param1.equals("")))
            {  JOptionPane.showMessageDialog(null, " Ce employe existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }


public  void inserer_emp(employeur c )throws Exception{
        try {
           Connection conn = jdbc.Getconnection();
           // Statement stmt = conn.createStatement();
            //  String sql = "insert into Employe(id_employe,nom_prénom_employe,type_employe,adresse,email,num_tel) values ('"+c.getId_employe()+"','"+c.getNom_prénom_employe()+"','"+c.getType_employe()+"','"+c.getAdresse()+"','"+c.getEmail()+"','"+c.getNum_tel1()+"') ";
           // ResultSet rs = stmt.executeQuery(sql);
            String sql = "insert into Employe(id_employe,nom_prénom_employe,type_employe,adresse,email,num_tel1) values (?,?,?,?,?,?) ";
                PreparedStatement pr=conn.prepareStatement(sql);
                pr.setString(1, c.getId_employe());
                pr.setString(2, c.getNom_prénom_employe());
                pr.setString(3, c.getType_employe());
                pr.setString(4, c.getAdresse());
                pr.setString(5, c.getEmail());
                
                pr.setString(6, c.getNum_tel1());
               
                pr.executeUpdate();
                
                //ResultSet rs = stmt.executeQuery(sql);
                
             pr.close();
      //  rs.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }
  
  
  public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Employe");
     tableHeaders.add("fonction");
    tableHeaders.add("adresse");
    tableHeaders.add("Email");
     tableHeaders.add("NumTel");
   
 //tableHeaders.add("Crédit"); 
    for (Object o : resultList) {
        employeur c = (employeur) o;
         oneRow = new Vector<Object>();
        oneRow.add(c.getNom_prénom_employe());
          oneRow.add(c.getType_employe());
        oneRow.add(c.getAdresse());
        oneRow.add(c.getEmail());
         oneRow.add(c.getNum_tel1());
        
        try {
            //oneRow.add(getCredit(c.getId_employe()));
        } catch (Exception ex) {
            Logger.getLogger(Fournisseur_op.class.getName()).log(Level.SEVERE, null, ex);
        }
       
              tableData.add(oneRow);
    }

// oneRow.addMouseClicked

jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
   
}
 
  
 public ArrayList getList_employe(String param1,int type) throws Exception {
         //
        String sql;
 
        switch(type){
            case 1:sql = "select * FROM Employe ";break;
            case 2:sql = "select * FROM Employe where nom_prénom_employe  like '%"+param1+"%'";break;
            default:sql = "select * FROM Employe ";break;
            
        }
         
  ArrayList<employeur> List_employe= new ArrayList<>();   
         Connection conn = jdbc.Getconnection();
              PreparedStatement pr=conn.prepareStatement(sql);
            //if(type==2){pr.setString(1, param1);}
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String id_employe =rs.getString("id_employe");
            String nom_prénom_employe =rs.getString("nom_prénom_employe");
            String type_employe =rs.getString("type_employe");
           String adresse =rs.getString("adresse");
            String email =rs.getString("email");
           
            String num_tel1 =rs.getString("num_tel1");
           
        
          List_employe.add(new employeur( id_employe,  nom_prénom_employe,  type_employe,  adresse,  email,  num_tel1) );
        }
        rs.close();
        conn.close();

      
        return List_employe;
    }
 
  public ArrayList getList_employe_salaire(String param1) throws Exception {
 String sql = "select Employe.id_employe,Employe.nom_prénom_employe,Employe.type_employe,Employe.adresse,Employe.email,Employe.num_tel1 FROM Employe,salaire where Employe.id_employe=salaire.id_employe and  Client.nom_prénom_employe  like "+"'%'"+"?"+"'%' "  ;                  
  ArrayList<employeur> List_client= new ArrayList<employeur>();   
          Connection conn = jdbc.Getconnection();
                PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, param1);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String id_client =rs.getString("id_employe");
            String nom_prénom_client =rs.getString("nom_prénom_employe");
            String type_client =rs.getString("type_employe");
           
            String email =rs.getString("email");
            String adresse =rs.getString("adresse");
            String num_tel1 =rs.getString("num_tel1");
           
            double crédit=rs.getDouble("salaire"); 
        
          List_client.add(new employeur( id_client,  nom_prénom_client,  type_client,  email,  adresse,  num_tel1,crédit) );
        }
        rs.close();
        conn.close();

      
        return List_client;
    }

  
  
  
public  void sup_employe(String  id_employe)throws Exception{

        try {
Connection conn = jdbc.Getconnection();
              String sql = "delete  from Employe where id_employe=?";
           // ResultSet rs = stmt.executeQuery(sql);
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, id_employe);
              pr.executeUpdate();
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}
 public double getsalaire(String id_employe) throws Exception{
       double salaire=0;
         Connection conn = jdbc.Getconnection();
  String sql ="select sum(montant) AS salaire FROM salaire where id_employe = ?  ";   
  PreparedStatement pr=conn.prepareStatement(sql);
  pr.setString(1, id_employe);
            ResultSet rs = pr.executeQuery(sql);
      while (rs.next()) {      
             salaire =rs.getDouble("salaire"); 
      }
     
  return salaire;
  }  

  public void modifier_employe(employeur f) throws Exception {
        
        try {
           Connection conn = jdbc.Getconnection();
              // String sql1 = "UPDATE Employe set nom_prénom_employe='"+f.getNom_prénom_employe()+"', type_employe='"+f.getType_employe()+"'  , adresse='"+f.getAdresse()+"',email='"+f.getEmail()+"'  , num_tel1='"+f.getNum_tel1()+"' where id_client='"+f.getId_employe()+"'";
              String sql1 = "UPDATE Employe set nom_prénom_employe=?, type_employe=? , adresse=?, email=?  , num_tel1=? where id_employe=?";
              //ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
               pr.setString(1, f.getNom_prénom_employe());
                pr.setString(2, f.getType_employe());
                 pr.setString(3, f.getAdresse());
                  pr.setString(4, f.getEmail());
                   
                    pr.setString(5, f.getNum_tel1());
                     
                         pr.setString(6, f.getId_employe());
                         
        pr.executeUpdate();
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
          // sc.printStackTrace();
        }
       
    }  
 
}

    
