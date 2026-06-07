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
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rais
 */
public class TypePerte_op {
    private static TypePerte_op instance;   
public TypePerte_op(){}
public static TypePerte_op getInstance(){
if(instance==null){
    instance=new TypePerte_op();
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
         
                  sql = "SELECT count(valeur) as nb_v FROM type_perte ";
                         
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
/*public  int Index( String t2 ){ 
    int index=1;
   

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
             String sql;
         
                  sql = "SELECT valeur FROM couleur order by valeur asc";
                         
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
   }*/
public boolean  PerteExist(String valeur) throws Exception {
         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 boolean a=false;
        try {
             Connection conn = jdbc.Getconnection();
              String sql = "select * FROM type_perte where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String wadifa =(rs.getString("valeur"));
            if(wadifa.equals(valeur)&&(!valeur.equals("")))
            {  JOptionPane.showMessageDialog(null, " Cette perte existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
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


public  void inserer_type_perte(String valeur )throws Exception{
        try {
            Connection conn = jdbc.Getconnection();
              String sql = "insert into type_perte (valeur) values (?) ";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,valeur);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
       //   System.out.println("bien inserer");
        pr.close();
        conn.close();
        } catch (Exception sc) {
            System.out.println(sc.getMessage());
        }
   }



public  void Charger_pertes( JComboBox categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
categorie.setRenderer(centr);
categorie.removeAllItems();

 try {
           Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM type_perte  order by valeur asc";
            ResultSet rs = stmt.executeQuery(sql);
            categorie.addItem(" ");
        while (rs.next()) {
             categorie.addItem(rs.getString("valeur") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }


  public  void sup_perte(String  marque)throws Exception{

        try {
 Connection conn = jdbc.Getconnection();

              String sql = "delete  from type_perte where valeur=?";
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,marque);
              pr.executeUpdate();
              pr.close();
        conn.close();

        } catch (Exception sc) {
        }

}  

}
