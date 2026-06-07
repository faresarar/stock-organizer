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
import model.Fournisseur;

/**
 *
 * @author pc
 */
public class Fournisseur_op {
Versement_fournisseur vop=Versement_fournisseur.getObj();
NumberFormat formatter = new DecimalFormat("#0.00"); 
private static Fournisseur_op obj=null;
  public static Fournisseur_op getObj(){
        if(obj==null){
            try {
         obj=new Fournisseur_op();
            } catch (Exception ex) {
                Logger.getLogger(Fournisseur_op.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
  private Fournisseur_op(){}
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
    ImageIcon   img = new ImageIcon("Images/erreur.GIF");
    
Vector<Object> oneRow;
public boolean  FournisseurExist(String param1) throws Exception {
    String sql;
            sql = "select * FROM Fournisseur where nom_prenom_fournisseur=?";
           
 boolean a=false;
        try {
           
          Connection conn = jdbc.Getconnection();
            // Statement stmt = conn.createStatement();
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, param1);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String nom_prenom =(rs.getString("nom_prenom_fournisseur"));
                if(nom_prenom.equals(param1)&&(!param1.equals("")))
                {  JOptionPane.showMessageDialog(null, " Ce fournisseur existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
                a=true;
                }
            }
            rs.close();
        conn.close();
      

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }


public  void inserer_fournisseur(Fournisseur f )throws Exception{
        try {
         
              Connection conn = jdbc.Getconnection();
               // String sql = "insert into Fournisseur (id_fournisseur,nom_prenom_fournisseur,catégorie_fournisseur,entreuprise,email,adresse,num_tel1,num_tel2,num_reg,num_id_fiscale,num_article_imposition) values ('"+f.getId_fournisseur()+"','"+f.getNom_prenom_fournisseur()+"','"+f.getCatégorie_fournisseur()+"','"+f.getEntreuprise()+"','"+f.getEmail()+"','"+f.getAdresse()+"','"+f.getNum_tel1()+"','"+f.getNum_tel2()+"','"+f.getNum_reg()+"','"+f.getNum_id_fiscale()+"','"+f.getNum_article_imposition()+"') ";
               // String sql = "insert into Fournisseur (id_fournisseur,nom_prenom_fournisseur,catégorie_fournisseur,entreuprise,email,adresse,num_tel1,num_tel2,num_reg,num_id_fiscale,num_article_imposition) values ('"+f.getId_fournisseur()+"','"+f.getNom_prenom_fournisseur()+"','"+f.getCatégorie_fournisseur()+"','"+f.getEntreuprise()+"','"+f.getEmail()+"','"+f.getAdresse()+"','"+f.getNum_tel1()+"','"+f.getNum_tel2()+"','"+f.getNum_reg()+"','"+f.getNum_id_fiscale()+"','"+f.getNum_article_imposition()+"') ";
                String sql = "insert into Fournisseur (id_fournisseur,nom_prenom_fournisseur,entreuprise,email,adresse,num_tel1,num_tel2,num_reg,num_id_fiscale,num_article_imposition,rib_f,dette) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
                PreparedStatement pr=conn.prepareStatement(sql);
                pr.setString(1, f.getId_fournisseur());
             //   System.out.println("ffffffffffffid four="+f.getId_fournisseur());
                pr.setString(2, f.getNom_prenom_fournisseur());
               // pr.setString(3, f.getCatégorie_fournisseur());
                pr.setString(3, f.getEntreuprise());
                pr.setString(4, f.getEmail());
                pr.setString(5, f.getAdresse());
                pr.setString(6, f.getNum_tel1());
                pr.setString(7, f.getNum_tel2());
                pr.setString(8, f.getNum_reg());
                pr.setString(9, f.getNum_id_fiscale());
                 pr.setString(10, f.getNum_article_imposition());
                 pr.setString(11, f.getRib_f());
                pr.setDouble(12, f.getDette());
               //   pr.setString(12, f.getId_f());
                pr.executeUpdate();
                
                //ResultSet rs = stmt.executeQuery(sql);
                
             pr.close();
        conn.close();
         
        } catch (Exception sc) {
            sc.printStackTrace();
        }
   }
public String GetNextReferenceFournisseur() throws Exception{
    String ref="F";
    int max = 0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select count(*)  as maxrow from Fournisseur ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
         max =rs.getInt("maxrow");}
           //  System.out.println("max="+max);
           if(max==0) {ref=ref+0+"";}else{
              // max=max+1;
            ref=ref+(max+1)+"";}
           rs.close();
        conn.close();
           
           //  System.out.println("ref="+ref);
        

return ref;
}

/*public String GetNextReferenceFournisseur() throws Exception{
    String ref="F";
    int max=0;
 //JdbcClass j=new JdbcClass();
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select Max(id_fournisseur)  as maxrow from Fournisseur ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            max =(rs.getInt("maxrow"));}
           //  System.out.println("max="+max);
       //    if(max==0){ref=ref+1+"";}else{
            ref="F"+(max+1)+"";
           //  System.out.println("ref="+ref);
      //  }
conn.close();
rs.close();
return ref;
}*/

 
  public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Nom et Prénom");
    tableHeaders.add("adresse");
    tableHeaders.add("Email");
     tableHeaders.add("NumTel1");
    tableHeaders.add("NumTel2");
    tableHeaders.add("Numéro registre commerce");
    tableHeaders.add("numero identification fiscale");
    tableHeaders.add("Numéro d'article d'imposition ");
    tableHeaders.add("Dette"); 
    //tableHeaders.add("Total Achats"); 
    tableHeaders.add("Total Versements"); 
      
    for (Object o : resultList) {
        Fournisseur f = (Fournisseur) o;
         oneRow = new Vector<Object>();
        oneRow.add(f.getNom_prenom_fournisseur());
        oneRow.add(f.getAdresse());
        oneRow.add(f.getEmail());
         oneRow.add(f.getNum_tel1());
        oneRow.add(f.getNum_tel2());
        oneRow.add(f.getNum_reg());
        oneRow.add(f.getNum_id_fiscale());
        oneRow.add(f.getNum_article_imposition());
        try {
            
             oneRow.add(formatter.format(f.getDette()));
            //oneRow.add(formatter.format(getDette(f.getId_fournisseur())));
        } catch (Exception ex) {
            Logger.getLogger(Fournisseur_op.class.getName()).log(Level.SEVERE, null, ex);
        }
       try{  oneRow.add(  formatter.format(vop.getTotalMontantVerser(f.getId_f())));}catch(Exception e){}
        tableData.add(oneRow);
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
 
  
 public ArrayList getList_Fournisseur(String param1,int type) throws Exception {
         //
        String sql= "";
 
        switch(type){
            case 0: sql = "select * FROM Fournisseur ";break;
          
            case 1:sql = "select * FROM Fournisseur where dette=0 ";break;
            case 2:sql = "select * FROM Fournisseur where  dette>0 ";break;
            case 3:sql = "select * FROM Fournisseur where  dette<0 ";break;
            case 4:sql = "select * FROM Fournisseur  where nom_prenom_fournisseur like '%"+param1+"%'";break;
            
            default:sql = "select * FROM Fournisseur ";break;
            
        }
         
  ArrayList<Fournisseur> List_fournisseur= new ArrayList();   
             Connection conn = jdbc.Getconnection(); 
            PreparedStatement pr=conn.prepareStatement(sql);
           // if(type==2){pr.setString(1, param1);}
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String id_fournisseur =rs.getString("id_fournisseur");
            String nom_prenom_fournisseur =rs.getString("nom_prenom_fournisseur");
          //  String catégorie_fournisseur =rs.getString("catégorie_fournisseur");
            String entreuprise =rs.getString("entreuprise");
            String email =rs.getString("email");
            String adresse =rs.getString("adresse");
            String num_tel1 =rs.getString("num_tel1");
            String num_tel2 =rs.getString("num_tel2");
            String num_reg =rs.getString("num_reg");
            String num_id_fiscale =rs.getString("num_id_fiscale");                          
            String num_article_imposition =rs.getString("num_article_imposition");
             String rib_f =rs.getString("rib_f");
            double dette=rs.getDouble("dette");
       
            int id_f=rs.getInt("id_f");
        
          List_fournisseur.add(new Fournisseur( id_fournisseur,  nom_prenom_fournisseur, entreuprise,  email,  adresse,  num_tel1, num_tel2,  num_reg, num_id_fiscale, num_article_imposition,rib_f,id_f,dette) );
        }
        rs.close();
        conn.close();

      
        return List_fournisseur;
    }
 
  /* public ArrayList getList_Fournisseur_dette(String param1) throws Exception {
 String sql = "select Fournisseur.id_fournisseur,Fournisseur.nom_prenom_fournisseur,Fournisseur.catégorie_fournisseur,Fournisseur.entreuprise,Fournisseur.email,Fournisseur.adresse,Fournisseur.num_tel1,Fournisseur.num_tel2,Fournisseur.num_reg,Fournisseur.num_id_fiscale,Fournisseur.num_article_imposition, Dette_fournisseur.dette FROM Fournisseur,Dette_fournisseur where Fournisseur.id_fournisseur=Dette_fournisseur.id_fournisseur and Dette_fournisseur.dette>0 and Fournisseur.nom_prenom_fournisseur like like "+"'%'"+"?"+"'%'"  ;                  
  ArrayList<Fournisseur> List_fournisseur= new ArrayList<Fournisseur>();   
           JdbcClass jZ=new JdbcClass();
            Connection conn = jZ.connect();
            //Statement stmt = conn.createStatement(); 
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, param1);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String id_fournisseur =rs.getString("id_fournisseur");
            String nom_prenom_fournisseur =rs.getString("nom_prenom_fournisseur");
            String catégorie_fournisseur =rs.getString("catégorie_fournisseur");
            String entreuprise =rs.getString("entreuprise");
            String email =rs.getString("email");
            String adresse =rs.getString("adresse");
            String num_tel1 =rs.getString("num_tel1");
            String num_tel2 =rs.getString("num_tel2");
            String num_reg =rs.getString("num_reg");
            String num_id_fiscale =rs.getString("num_id_fiscale");                          
            String num_article_imposition =rs.getString("num_article_imposition");
        //    double dette=rs.getDouble("dette"); 
            //  int id_f=rs.getInt("id_f");
     
          List_fournisseur.add(new Fournisseur( id_fournisseur,  nom_prenom_fournisseur, entreuprise,  email,  adresse,  num_tel1, num_tel2,  num_reg, num_id_fiscale, num_article_imposition) );
        }
        rs.close();
        conn.close();

      
        return List_fournisseur;
    }

 */ 
  

  public Fournisseur  getFournisseur(int idf) throws Exception {
 String sql = "select * FROM Fournisseur where id_f= '"+idf+"'  "  ;                  
 Fournisseur f=null; 
  
          
            Connection conn = jdbc.Getconnection(); 
            //Statement stmt = conn.createStatement();  
            PreparedStatement pr=conn.prepareStatement(sql);
          //  pr.setString(1, param1);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
           
         
           String nom_prenom_fournisseur =rs.getString("nom_prenom_fournisseur");
             String adresse =rs.getString("adresse");
             String tel1 =rs.getString("num_tel1");
             String tel2 =rs.getString("num_tel2");
            double dette =rs.getDouble("dette");
          
     
          f=new Fournisseur(  nom_prenom_fournisseur,adresse,tel1,tel2,dette,idf) ;
        }
        rs.close();
        conn.close();

      
        return f;
    }
  
public  void sup_Fournisseur(String  id_f)throws Exception{

        try {
   Connection conn = jdbc.Getconnection();
              String sql = "delete  from Fournisseur where id_f=?";
              PreparedStatement pr=conn.prepareStatement(sql);
            pr.setString(1, id_f);
            pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
  /*public void modifier_Produit(String  categorie_produit, String categorie_piece,  String etat,String marque, String numero_serie, String référence,String  désignation,String étagére,String  codebare,String remarque, double prix_achat,double  prix_vente) throws Exception {
        
        try {
            JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
           // Statement stmt = conn.createStatement();
          
              // String sql1 = "UPDATE Produit set categorie_produit='"+categorie_produit+"', categorie_piece='"+categorie_piece+"' , etat='"+etat+"' , marque='"+marque+"' , numero_serie='"+numero_serie+"'  , désignation='"+désignation+"' , étagére='"+étagére+"' , codebare='"+codebare+"' remarque='"+remarque+"' , prix_achat='"+prix_achat+"' , prix_vente='"+prix_vente+"'where référence='"+référence+"'";
            String sql1 = "UPDATE Produit set categorie_produit=?, categorie_piece=? , etat=? , marque=? , numero_serie=? , désignation=?, étagére=? , codebare=? ,remarque=? , prix_achat=?, prix_vente=? where référence=?";
             // ResultSet rs1 = stmt.executeQuery(sql1);
                    
         PreparedStatement pr=conn.prepareStatement(sql1);
         pr.setString(1, categorie_produit);
          pr.setString(2, categorie_piece);
           pr.setString(3, etat);
            pr.setString(4, marque);
             pr.setString(5, numero_serie);
              pr.setString(6, désignation);
               pr.setString(7, étagére);
                pr.setString(8, codebare);
                 pr.setString(9, remarque);
                  pr.setDouble(10, prix_achat);
         pr.setDouble(11, prix_vente);
                 pr.setString(12, référence);  
                  pr.executeUpdate();
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
           
        }
       
    }  
* */
  public double getDette(int id_fournisseur) throws Exception{
       double dette=0;
             Connection conn = jdbc.Getconnection();
  String sql ="select dette FROM fournisseur where id_f = ?  ";     
  PreparedStatement pr=conn.prepareStatement(sql);
  pr.setInt(1, id_fournisseur);
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
             dette =rs.getDouble("dette"); 
      }
     rs.close();
        conn.close();
  return dette;
  }

 
 /*public double getCrédit(String id_fournisseur) throws Exception{
       double credit=0;
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();  
  String sql ="select crédit FROM Dette_fournisseur where id_fournisseur = '"+id_fournisseur+"'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
             credit =rs.getDouble("crédit"); 
      }
     
  return credit;
  }*/
  public void modifier_Fournisseur( Fournisseur f ) throws Exception {
        
        try {
              Connection conn = jdbc.Getconnection();
           // Statement stmt = conn.createStatement();
          
        //   String sql1 = "update Fournisseur set nom_prenom_fournisseur=?  where id_fournisseur=?";
            //   String sql1 = "UPDATE Fournisseur set nom_prenom_fournisseur='"+f.getNom_prenom_fournisseur()+"' , entreuprise='"+f.getEntreuprise()+"' , email='"+f.getEmail()+"' , adresse='"+f.getAdresse()+"'  , num_tel1='"+f.getNum_tel1()+"' , num_tel2='"+f.getNum_tel2()+"' , num_reg='"+f.getNum_reg()+"' ,num_id_fiscale='"+f.getNum_id_fiscale()+"' , num_article_imposition='"+f.getNum_article_imposition()+"' where id_fournisseur='"+f.getId_fournisseur()+"'";
          String sql1 = "UPDATE Fournisseur set nom_prenom_fournisseur=? , entreuprise=? , email=? , adresse=? , num_tel1=?, num_tel2=? , num_reg=? ,num_id_fiscale=?, num_article_imposition=?,rib_f=?, dette=? where id_f=?";
         //   ResultSet rs1 = stmt.executeQuery(sql1);
          //  System.out.println("requette executer");
             PreparedStatement pr=conn.prepareStatement(sql1);
              pr.setString(1, f.getNom_prenom_fournisseur());
           //    pr.setString(2, f.getId_fournisseur());
                 pr.setString(2, f.getEntreuprise());
                  pr.setString(3, f.getEmail());
                   pr.setString(4, f.getAdresse());
                    pr.setString(5, f.getNum_tel1());
                     pr.setString(6, f.getNum_tel2());
                      pr.setString(7, f.getNum_reg());
                       pr.setString(8, f.getNum_id_fiscale());
                        pr.setString(9, f.getNum_article_imposition());
                          pr.setString(10, f.getRib_f());
                          pr.setDouble(11, f.getDette());
                            pr.setInt(12, f.getId_f());
                      
                         
                        
        pr.executeUpdate();
            
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
           sc.printStackTrace();
        }
       
    }  
  public void modifier_Dette_Fournisseur( int idf,double dette ) throws Exception {
        
        try {
                Connection conn = jdbc.Getconnection();
          String sql = "UPDATE Fournisseur set dette=? where id_f=?";
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
  public  ArrayList Charger_fournisseur( JComboBox marques ){ 
     ArrayList<Fournisseur> Listf= new ArrayList<Fournisseur>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
marques.setRenderer(centr);
marques.removeAllItems();

 try {   Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
            
            // switch(cas){
                String  sql = "SELECT nom_prenom_fournisseur,dette,id_f FROM Fournisseur  ";
                 
             //}
            ResultSet rs = stmt.executeQuery(sql);
             marques.addItem(" ");
        while (rs.next()) {
        
          String nom_prenom_fournisseur=rs.getString("nom_prenom_fournisseur");
          int idf=rs.getInt("id_f");
          double dette=rs.getDouble("dette");
          marques.addItem(rs.getString("nom_prenom_fournisseur") );
          Listf.add(new Fournisseur(nom_prenom_fournisseur,dette,idf));
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   return Listf;
   }
  
  
 /*public Fournisseur get_Fournisseur(String param1,int type) throws Exception {
         //
        String sql;
 
        switch(type){
            case 1:sql = "select * FROM Fournisseur ";break;
            case 2:sql = "select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";break;
            default:sql = "select * FROM Fournisseur ";break;
            
        }
         
  ArrayList<Fournisseur> List_fournisseur= new ArrayList<Fournisseur>();   
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            String id_fournisseur =rs.getString("id_fournisseur");
            String nom_prenom_fournisseur =rs.getString("nom_prenom_fournisseur");
            String catégorie_fournisseur =rs.getString("catégorie_fournisseur");
            String entreuprise =rs.getString("entreuprise");
            String email =rs.getString("email");
            String adresse =rs.getString("adresse");
            String num_tel1 =rs.getString("num_tel1");
            String num_tel2 =rs.getString("num_tel2");
            String num_reg =rs.getString("num_reg");
            String num_id_fiscale =rs.getString("num_id_fiscale");                          
            String num_article_imposition =rs.getString("num_article_imposition");
        
          List_fournisseur.add(new Fournisseur( id_fournisseur,  nom_prenom_fournisseur,  catégorie_fournisseur, entreuprise,  email,  adresse,  num_tel1, num_tel2,  num_reg, num_id_fiscale, num_article_imposition) );
        }
        rs.close();
        conn.close();

      
        return List_fournisseur;
    } 
  */
    public String  getFournisseur(String NomPrenom) throws Exception {
 String sql = "select id_fournisseur FROM Fournisseur where nom_prenom_fournisseur= '"+NomPrenom+"'  "  ;                  
// Fournisseur f=null; 
  String idf="";
  
          
            Connection conn = jdbc.Getconnection(); 
            //Statement stmt = conn.createStatement();  
            PreparedStatement pr=conn.prepareStatement(sql);
          //  pr.setString(1, param1);
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
    idf =rs.getString("id_fournisseur"); 
                         }
      rs.close();
      conn.close();
   return idf;
}
    
public  int Index( String t2 ){ 
    int index=1;
 
 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT valeur FROM marques order by valeur asc";
                         
            ResultSet rs = stmt.executeQuery(sql);
           
       while (rs.next()) {
          String  t1 =rs.getString("valeur");
         if(t1.equals(t2))break;else index=index+1;
     //    System.out.println("index="+index);
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   return index;
   }    
    public double getTotalDette() throws Exception{
    //String ref="B";
    double  total=0;
   Connection conn = jdbc.Getconnection();
             String sql = "select sum(dette) as total_dette from fournisseur ";
             PreparedStatement pr=conn.prepareStatement(sql);
              // pr.setInt(1, id_fournisseur);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
           total =(rs.getDouble("total_dette"));
          
        }

return total;
} 
}