/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

/**
 *
 * @author hicham
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rais
 */
public class Taille_op {
      private static Taille_op instance;   
public Taille_op(){}
public static Taille_op getInstance(){
if(instance==null){
    instance=new Taille_op();
}
return instance;
}
 JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
public  int NumbreValeur(  ){ 
    int nb=0;
   

 try {
          Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT count(valeur) as nb_v FROM taille ";
                         
            ResultSet rs = stmt.executeQuery(sql);
           
       while (rs.next()) {
            nb =rs.getInt("nb_v");
           //  System.out.println("max="+max);
          
           //  System.out.println("ref="+ref);
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   return nb;
   }
public  int Index( String t2 ){ 
    int index=1;
   

 try {
           Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT valeur FROM taille order by valeur asc";
                         
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

public boolean TailleExist(String valeur) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 boolean a=false;
        try {
            Connection conn = jdbc.Getconnection();
              String sql = "select * FROM taille where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
              
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String wadifa =(rs.getString("valeur"));
            if(wadifa.equals(valeur)&&(!valeur.equals("")))
            {  JOptionPane.showMessageDialog(null, " Cette taille existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
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

public String  getidTaille(String valeur) throws Exception {
         
 String id=null;
        try {
             Connection conn = jdbc.Getconnection();
              String sql = "select id FROM taille where valeur=?";
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
              
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
           id =(rs.getString("id"));
            
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE);
            throw new Exception(sc.getMessage(), sc);
        }
        return id ;
    }


public  void inserer_taille(String valeur )throws Exception{
        try {
            Connection conn = jdbc.Getconnection();
              String sql = "insert into taille (valeur) values (?) ";
               PreparedStatement pr=conn.prepareStatement(sql);
               pr.setString(1, valeur);
             //  pr.setString(2, id);
               pr.executeUpdate();
          //  ResultSet rs = stmt.executeQuery(sql);
          
        pr.close();
        conn.close();
        } catch (Exception sc) {
        }
   }




//////////////////////////////////////////////////////////

public String GetNextReferenceTaille() throws Exception{
    String ref="C";
    int max=0;
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(id) as maxrow from taille ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
          max =rs.getInt( "maxrow");
 
        }
        if(max==0){ ref=ref+0+"";}
           else{
            max+=1;
           ref=ref+max+"";}

return ref;
}

//////////////////////////////////////////////////////////////

public  void Charger_taille( JComboBox categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
  DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
categorie.setRenderer(centr);
categorie.removeAllItems();

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM taille  order by valeur asc";
            ResultSet rs = stmt.executeQuery(sql);
            categorie.addItem(" ");
        while (rs.next()) {
             categorie.addItem(rs.getString("valeur") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }


  public  void sup_taille(String  produit)throws Exception{

        try {

             Connection conn = jdbc.Getconnection();

              String sql = "delete  from taille where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,produit);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  

}
