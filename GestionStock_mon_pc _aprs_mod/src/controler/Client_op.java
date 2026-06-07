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
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import model.Client;


/**
 *
 * @author Rais
 */
public class Client_op {
private static Client_op instance;   
public Client_op(){}
public static Client_op getInstance(){
if(instance==null){
    instance=new Client_op();
}
return instance;
}
    
Versement_client vop=Versement_client.getObj();
Vector<Object> oneRow;
ImageIcon   img = new ImageIcon("Images/erreur.GIF");
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
NumberFormat formatter = new DecimalFormat("#0.00");

public boolean  TypeClientExist(String type) throws Exception {
boolean a=false;
        try {
              Connection conn = jdbc.Getconnection();
              String sql = "select * FROM TypeClient where type=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, type);
             
            ResultSet rs =  pr.executeQuery();
        while (rs.next()) {
            String t =(rs.getString("type"));
            if(t.equals(type)&&(!type.equals("")))
            {  JOptionPane.showMessageDialog(null, " Ce type existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, sc.getMessage(), " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a; 
    }
//INSERT INTO `gestion`.`typeclient` (`type`) VALUES ('EDDD');

public  void inserer_type(String valeur )throws Exception{
        try {
          
            // Statement stmt = conn.createStatement();
           
                // Statement stmt = conn.createStatement();
                Connection conn = jdbc.Getconnection();
                String sql = "INSERT INTO typeclient ( type ) VALUES (?) ";
                //  String sql = "  INSERT INTO typeclient (type) VALUES ('DggggggggggDS')";
                java.sql.PreparedStatement pr= conn.prepareStatement(sql);
                //ResultSet rs = stmt.executeQuery(sql);
                pr.setString(1, valeur);
                pr.executeUpdate();
                
                
                //  rs.close();
           
        } catch (Exception sc) {
        }
   }



public  void Charger_type( JComboBox type ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
type.setRenderer(centr);
type.removeAllItems();

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT * FROM typeclient ";
                 
         
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             type.addItem(rs.getString("type") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }

public  int NumbreTypeClient(  ){ 
int nb=0;
 try {
             Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT count(type) as nb_type FROM typeclient ";
                         
            ResultSet rs = stmt.executeQuery(sql);
           
       while (rs.next()) {
            nb =rs.getInt("nb_type");
           //  System.out.println("max="+max);
          
           //  System.out.println("ref="+ref);
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   return nb;
   }
public  int IndexType( String type ){ 
    int index=0;
   

 try {
           Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT type FROM typeclient ";
                         
            ResultSet rs = stmt.executeQuery(sql);
           
       while (rs.next()) {
          String  t =rs.getString("type");
         if(t.equals(type))break;else index=index+1;
     //    System.out.println("index="+index);
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   return index;
   }



public  void Charger_client( JComboBox type ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
type.setRenderer(centr);
type.removeAllItems();

 try {
             Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
                           sql = "SELECT nom_prénom_client FROM Client  order by nom_prénom_client asc";
                                      ResultSet rs = stmt.executeQuery(sql);
                   while (rs.next()) {
             type.addItem(rs.getString("nom_prénom_client") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   type.addItem("Passager");
   }

  public  void sup_Type(String  type)throws Exception{
        try {

              Connection conn = jdbc.Getconnection();
              String sql = "delete  from typeclient where type=?";
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
    String ref="C";
    int max=1;

             Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
            String sql = "select  max(id_c) as maxrow  from Client ";
         //   String sql = "select  count(*)  as maxrow from Client ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            max =rs.getInt("maxrow");
           //  System.out.println("max="+max);
          
           //  System.out.println("ref="+ref);
        }
         if(max==0){ref=ref+1+"";}
           else
           { ref=ref+(max+1)+"";}

         rs.close();conn.close();

return ref;
}
  
  public boolean  ClientExist(String param1) throws Exception {
    String sql;
            sql = "select * FROM Client where nom_prénom_client=?";
           
 boolean a=false;
        try {
           
        //  Statement stmt = conn.createStatement();
         Connection conn = jdbc.Getconnection();
            //  Statement stmt = conn.createStatement();
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, param1);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String nom_prenom =(rs.getString("nom_prénom_client"));
                if(nom_prenom.equals(param1)&&(!param1.equals("")))
                { // JOptionPane.showMessageDialog(null, " Ce client existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
                a=true;
                }
            }
            rs.close();
        

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, sc.getMessage(), " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }


public  void inserer_client(Client c )throws Exception{
        try {
           Connection conn = jdbc.Getconnection();
             // String sql = "insert into Client (id_client,nom_prénom_client,type_client,adresse,email,num_tel1,num_tel2,num_reg_commerce,num_id_fiscale,num_article_imposition) values ('"+c.getId_client()+"','"+c.getNom_prénom_client()+"','"+c.getType_client()+"','"+c.getAdresse()+"','"+c.getEmail()+"','"+c.getNum_tel1()+"','"+c.getNum_tel2()+"','"+c.getNum_reg_commerce()+"','"+c.getNum_id_fiscale()+"','"+c.getNum_article_imposition()+"') ";
           
            String sql = "insert into Client (id_client,nom_prénom_client,type_client,adresse,email,num_tel1,num_tel2,num_reg_commerce,num_id_fiscale,num_article_imposition,RIB_C,crédit) values (?,?,?,?,?,?,?,?,?,?,?,?)";
           // ResultSet rs = stmt.executeQuery(sql);
          PreparedStatement pr=conn.prepareStatement(sql);
          pr.setString(1, c.getId_client());
          pr.setString(2, c.getNom_prénom_client());
          pr.setString(3, c.getType_client());
          pr.setString(4, c.getAdresse());
          pr.setString(5, c.getEmail());
          pr.setString(6, c.getNum_tel1());
          pr.setString(7, c.getNum_tel2());
          pr.setString(8, c.getNum_reg_commerce());
          pr.setString(9,c.getNum_id_fiscale());
          pr.setString(10, c.getNum_article_imposition());
          pr.setString(11, c.getRib_c());
          pr.setDouble(12, c.getCrédit());
          // pr.setString(parameterIndex, sql);
          
        pr.executeUpdate();
        pr.close();
        conn.close();
        } catch (Exception sc) {
       sc.printStackTrace();
        }
   }
  
  
  public void displayResult(List resultList,JTable jTable1) {
      
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Nom et prénom");
     tableHeaders.add("Type");
    tableHeaders.add("adresse");
    tableHeaders.add("Email");
     tableHeaders.add("NumTel1");
    tableHeaders.add("NumTel2");
    tableHeaders.add("Numéro registre commerce");
    tableHeaders.add("numero identification fiscale");
     tableHeaders.add("Numéro d'article d'imposition ");
      tableHeaders.add("RIB ");
      tableHeaders.add("Crédit"); 
    //   tableHeaders.add("Total Ventes"); 
        tableHeaders.add("Total Versements"); 
    for (Object o : resultList) {
        try {
            Client c = (Client) o;
            oneRow = new Vector<Object>();
            oneRow.add(c.getNom_prénom_client());
            oneRow.add(c.getType_client());
            oneRow.add(c.getAdresse());
            oneRow.add(c.getEmail());
            oneRow.add(c.getNum_tel1());
            oneRow.add(c.getNum_tel2());
            oneRow.add(c.getNum_reg_commerce());
            oneRow.add(c.getNum_id_fiscale());
            oneRow.add(c.getNum_article_imposition());
            oneRow.add(c.getRib_c());
            try {
              
                oneRow.add(formatter.format(c.getCrédit()));
            } catch (Exception ex) {
                Logger.getLogger(Fournisseur_op.class.getName()).log(Level.SEVERE, null, ex);
            }
          try{  oneRow.add(  formatter.format(vop.getTotalMontantVerser(c.getId_c())));}catch(Exception e){}
            
            tableData.add(oneRow);
        } catch (Exception ex) {
            Logger.getLogger(Client_op.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// oneRow.addMouseClicked

jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
  DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
    
        return false;
    }
    
  
};

jTable1.setModel(tableModel); 
}
 
  
 public ArrayList getList_Client(String param1,int type) throws Exception {
         //
        String sql;
 
        switch(type){
             case 0: sql = "select * FROM client ";break;
          
            case 1:sql = "select * FROM client where crédit=0 ";break;
            case 2:sql = "select * FROM client where  crédit>0 ";break;
            case 3:sql = "select * FROM client where  crédit<0 ";break;
            case 4:sql = "select * FROM client  where nom_prénom_client like '%"+param1+"%'";break;
            
            default:sql = "select * FROM client ";break;
            
        }
         
  ArrayList<Client> List_client= new ArrayList<>();   
           Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
          //  if(type==2){pr.setString(1, param1);}
           // Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String id_client =rs.getString("id_client");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            String type_client =rs.getString("type_client");
           String adresse =rs.getString("adresse");
            String email =rs.getString("email");
           
            String num_tel1 =rs.getString("num_tel1");
            String num_tel2 =rs.getString("num_tel2");
            String num_reg_commerce =rs.getString("num_reg_commerce");
            String num_id_fiscale =rs.getString("num_id_fiscale");                          
            String num_article_imposition =rs.getString("num_article_imposition");
             String RIB_C =rs.getString("RIB_C");
            int id_c=rs.getInt("id_c");
            double credit=rs.getDouble("crédit");
          
            
        
          List_client.add(new Client( id_client,  nom_prénom_client,  type_client,  adresse,  email,  num_tel1, num_tel2,  num_reg_commerce, num_id_fiscale, num_article_imposition,RIB_C,id_c,credit) );
        }
        rs.close();
        conn.close();

      
        return List_client;
    }
 
 /* public ArrayList getList_Client_credit(String param1) throws Exception {
 String sql = "select Client.id_client,Client.nom_prénom_client,Client.type_client,Client.adresse,Client.email,Client.num_tel1,Client.num_tel2,Client.num_reg_commerce,Client.num_id_fiscale,Client.num_article_imposition, Crédit_client.crédit FROM Client,Crédit_client where Client.id_client=Crédit_client.id_client and Crédit_client.crédit>0 and Client.nom_prénom_client like '%"+param1+"%' "  ;                  
  ArrayList<Client> List_client= new ArrayList<Client>();   
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            String id_client =rs.getString("id_client");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            String type_client =rs.getString("type_client");
           
            String email =rs.getString("email");
            String adresse =rs.getString("adresse");
            String num_tel1 =rs.getString("num_tel1");
            String num_tel2 =rs.getString("num_tel2");
            String num_reg_commerce =rs.getString("num_reg_commerce");
            String num_id_fiscale =rs.getString("num_id_fiscale");                          
            String num_article_imposition =rs.getString("num_article_imposition");
            double crédit=rs.getDouble("crédit"); 
            int id_c=rs.getInt("id_c");
        
          List_client.add(new Client( id_client,  nom_prénom_client,  type_client,  email,  adresse,  num_tel1, num_tel2,  num_reg_commerce, num_id_fiscale, num_article_imposition,id_c,crédit) );
        }
        rs.close();
        conn.close();

      
        return List_client;
    }
*/
public  void sup_Client(int  id_c)throws Exception{

        try {
  Connection conn = jdbc.Getconnection();
              String sql = "delete  from Client where id_c=?";
           // ResultSet rs = stmt.executeQuery(sql);
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, id_c);
              pr.executeUpdate();
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}
 public double getCredit(int id_c) throws Exception{
       double dette=0;
            Connection conn = jdbc.Getconnection(); 
  String sql ="select crédit FROM client where id_c = ?";           
           // ResultSet rs = stmt.executeQuery(sql);
  PreparedStatement pr=conn.prepareStatement(sql);
  pr.setInt(1, id_c);
             // ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs = pr.executeQuery();

      while (rs.next()) {      
             dette =rs.getDouble("crédit"); 
      }
     
  return dette;
  }  

  public void modifier_Client(Client f) throws Exception {
        
        try {
            Connection conn = jdbc.Getconnection();
           //  Statement stmt = conn.createStatement();
          
               //String sql1 = "UPDATE Client set nom_prénom_client='"+f.getNom_prénom_client()+"', type_client='"+f.getType_client()+"'  , adresse='"+f.getAdresse()+"',email='"+f.getEmail()+"'  , num_tel1='"+f.getNum_tel1()+"' , num_tel2='"+f.getNum_tel2()+"' , num_reg_commerce='"+f.getNum_reg_commerce()+"' ,num_id_fiscale='"+f.getNum_id_fiscale()+"' , num_article_imposition='"+f.getNum_article_imposition()+"' where id_client='"+f.getId_client()+"'";
            String sql1 = "UPDATE client set nom_prénom_client=?, type_client=?, adresse=?,email=? , num_tel1=? ,"
                    + " num_tel2=?, num_reg_commerce=? ,num_id_fiscale=?, num_article_imposition=?,RIB_C=?,crédit=? where id_c=?";
             // ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
                
          pr.setString(1, f.getNom_prénom_client());
          pr.setString(2, f.getType_client());
          pr.setString(3, f.getAdresse());
          pr.setString(4, f.getEmail());
          pr.setString(5, f.getNum_tel1());
          pr.setString(6, f.getNum_tel2());
          pr.setString(7, f.getNum_reg_commerce());
          pr.setString(8,f.getNum_id_fiscale());
          pr.setString(9, f.getNum_article_imposition());
          pr.setString(10, f.getRib_c());
          pr.setDouble(11, f.getCrédit());
         pr.setInt(12, f.getId_c());
         
         pr.executeUpdate();
       //  System.out.println("excute update");
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
          sc.printStackTrace();
        }
       
    }  
 
  
  
  
   public Client get_Client(String param1) throws Exception {
         //
        String sql;
 Client c = null;
    sql = "select * FROM Client where nom_prénom_client = '"+param1+"'  ";
            Connection conn = jdbc.Getconnection();
            PreparedStatement pr=conn.prepareStatement(sql);
              
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String id_client =rs.getString("id_client");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            String type_client =rs.getString("type_client");
           String adresse =rs.getString("adresse");
            String email =rs.getString("email");
           
            String num_tel1 =rs.getString("num_tel1");
            String num_tel2 =rs.getString("num_tel2");
            String num_reg_commerce =rs.getString("num_reg_commerce");
            String num_id_fiscale =rs.getString("num_id_fiscale");                          
            String num_article_imposition =rs.getString("num_article_imposition");
            String RIB_C =rs.getString("RIB_C");
            Double crédit=rs.getDouble("crédit");
        
          c=new Client( id_client,  nom_prénom_client,  type_client,  adresse,  email,  num_tel1, num_tel2,  num_reg_commerce, num_id_fiscale, num_article_imposition,RIB_C,crédit) ;
        }
        rs.close();
        conn.close();

      
        return c;
    }
   
   
   public Client get_Client(int id_c) throws Exception {
         //
        String sql;
 Client c = null;
    sql = "select * FROM Client where id_c = '"+id_c+"'  ";
            Connection conn = jdbc.Getconnection();
            PreparedStatement pr=conn.prepareStatement(sql);
              
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String id_client =rs.getString("id_client");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            String type_client =rs.getString("type_client");
           String adresse =rs.getString("adresse");
            String email =rs.getString("email");
           
            String num_tel1 =rs.getString("num_tel1");
            String num_tel2 =rs.getString("num_tel2");
            String num_reg_commerce =rs.getString("num_reg_commerce");
            String num_id_fiscale =rs.getString("num_id_fiscale");                          
            String num_article_imposition =rs.getString("num_article_imposition");
              String RIB_C =rs.getString("RIB_C");
            Double crédit=rs.getDouble("crédit");
        
          c=new Client( id_client,  nom_prénom_client,  type_client,  adresse,  email,  num_tel1, num_tel2,  num_reg_commerce, num_id_fiscale, num_article_imposition,RIB_C,id_c,crédit) ;
        }
        rs.close();
        conn.close();

      
        return c;
    }
   
  public void modifier_Dette_Client( int idf,double dette ) throws Exception {
        
        try {
                Connection conn = jdbc.Getconnection();
          String sql = "UPDATE Client set crédit=? where id_c=?";
           PreparedStatement pr=conn.prepareStatement(sql);
         
            pr.setInt(2, idf);
             pr.setDouble(1, dette);
            
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
           sc.printStackTrace();
        }
       
    }  
  
  public String getNomPrenomClient(int id_c) throws Exception{
       String npc="";
            Connection conn = jdbc.Getconnection(); 
  String sql ="select nom_prénom_client FROM client where id_c = ?";           
           // ResultSet rs = stmt.executeQuery(sql);
  PreparedStatement pr=conn.prepareStatement(sql);
  pr.setInt(1, id_c);
             // ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs = pr.executeQuery();

      while (rs.next()) {      
             npc =rs.getString("nom_prénom_client"); 
      }
     
  return npc;
  }  
  
}
