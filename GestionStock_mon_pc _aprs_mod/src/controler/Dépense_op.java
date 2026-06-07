/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Dépense;

/**
 *
 * @author pc
 */
public class Dépense_op {
   JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
   TextNumber tn= TextNumber.getObj();
   private static Dépense_op instance;   
public Dépense_op(){}
public static Dépense_op getInstance(){
if(instance==null){
    instance=new Dépense_op();
}
return instance;
}     
public double GetTotal(ArrayList<Dépense> ListDepence){
    double total=0;
for (int i=0;i<ListDepence.size();i++) 
    total=ListDepence.get(i).getMontant()+total;

return total;
}

public  void inserer_dépence(Dépense f )throws Exception{
        try {
          Connection conn = jdbc.Getconnection();
              String sql = "insert into dépence (année,mois,depence,montant) values (?,?,?,? )";
           // ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            pr.setInt(1, f.getAnnée());
                 pr.setString(2, f.getMois());
                      pr.setString(3, f.getDepence());
                           pr.setDouble(4,f.getMontant());
                              
                                     
       
                                         pr.executeUpdate();
                                          pr.close();
        conn.close();
        } catch (Exception sc) {
         //   sc.printStackTrace();
        }
   }
  public  void sup_depence(int annee,String mois,String depence)throws Exception{

        try {
         Connection conn = jdbc.Getconnection();
              String sql = "delete   FROM dépence where année=? and mois=? and depence=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, annee);
                 pr.setString(2, mois);
                 pr.setString(3, depence);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
} 
  public  void sup_depence(int id)throws Exception{

        try {
         Connection conn = jdbc.Getconnection();
              String sql = "delete   FROM dépence where ID=? ";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, id);
              
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
} 
  
 public boolean  DepenceExist(int annee,String mois,String depence) throws Exception {
 
 boolean a=false;
        try {
           Connection conn = jdbc.Getconnection();
              String sql = "select * FROM dépence where année=? and mois=? and depence=?";
              
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, annee);
                 pr.setString(2, mois);
                 pr.setString(3, depence);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String année =(rs.getString("année"));
            String depenc =(rs.getString("depence"));
            if( (!depenc.equals("")))
            { 
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

  

  public void modifier_dépence(Dépense d){
        try {
           Connection conn = jdbc.Getconnection();
          
               String sql1 = "UPDATE dépence set depence=?, montant=? where année=? and mois=? ";
              //ResultSet rs1 = stmt.executeQuery(sql1);
             PreparedStatement pr=conn.prepareStatement(sql1);
             pr.setString(1, d.getDepence());
              pr.setDouble(2, d.getMontant());
              
                  pr.setInt(3, d.getAnnée());
                   pr.setString(4, d.getMois());
                   // pr.setString(8, sql1);
                   //  pr.setString(9, sql1);
                     
         pr.executeUpdate();
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
        
        }
       
    }  
  Vector<Object> oneRow;
  public Dépense getDépence(int annee,String mois) throws Exception {
      Dépense d=null;
        String sql;
 
        
          sql = "select * FROM dépence where année=? and mois= ?  ";
            
            
      
         
 
         Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, annee);
                 pr.setString(2, mois);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            String depence =rs.getString("depence");
            double montant =rs.getDouble("montant");
            
        
          d=new Dépense(annee,mois,depence,montant);
        }
        rs.close();
        conn.close();

      
        return d;
    }
  
 public void displayResult(List resultList,JTable jTable) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table

  

    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("année"); 
    tableHeaders.add("mois");
    tableHeaders.add("type de depence");
     tableHeaders.add("montant");
   
     //tableHeaders.add("catégorie de la piece ");
    //  tableHeaders.add(" Num serie");
      // tableHeaders.add("Code bare ");
      //  tableHeaders.add("Quantité ");
      //   tableHeaders.add("Remarque");
  
    
    for (Object o : resultList) {
        Dépense p = (Dépense) o;
         oneRow = new Vector<Object>();
      
        oneRow.add(p.getAnnée());
        oneRow.add(p.getMois());
        oneRow.add(p.getDepence());
        try {
            oneRow.add(tn.Afficher2Verguile(p.getMontant()));
        } catch (Exception ex) {
            Logger.getLogger(Dépense_op.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         // oneRow.add(p.getCategorie_piece());
       // oneRow.add(p.getNumero_serie());
      //  oneRow.add(p.getCode_barre());
        // oneRow.add(p.getQuantité());
     //   oneRow.add(p.getRemarque());
              tableData.add(oneRow);
    }

// oneRow.addMouseClicked

//jTable.setModel(new DefaultTableModel(tableData, tableHeaders));
   DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
  //    if(column==1 ||column==3 ||column==4 ||column==5 )
      //return column == 3;
         // return true;
     // else
        return false;
    }
    
  
};

jTable.setModel(tableModel);
}
  
  
 public ArrayList getList_Produit(String param1,String param2,String param3,String param4,String param5,int type) throws Exception {
         //
          String sql ="";
  ArrayList<Dépense> List_produit= new ArrayList<Dépense>();
        try {


           Connection conn = jdbc.Getconnection();
            if(type==1){
            switch(param1){
                case "désignation":sql = "select * FROM Produit where désignation like %?% ";break;
                case "code_barre":sql = "select * FROM Produit where code_barre like %?% ";break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:sql = "select * FROM dépence  ";break;
                           }
            
            }else {
                if(param2.equals("toute"))param2="";
                if(param3.equals("toute"))param3="";
                if(param4.equals("toute"))param4="";
                //if(param5.equals("toute les marques"))param5="";
                //int quantite=Integer.parseInt(param1);
// sql ="select * FROM  where categorie_produit like '%"+param2+"%' and categorie_piece like '%"+param3+"%' and etat like '%"+param4+"%' and marque like '%"+param5+"%' and quantité<='"+quantite+"' ";          
            }
            PreparedStatement pr=conn.prepareStatement(sql);
             switch(param1){
                case "désignation":pr.setString(1, param1);break;
                case "code_barre":pr.setString(1, param1);break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:break;
                           }
                // pr.setString(2, mois);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
      while(rs.next()){
            int annee =rs.getInt("année");
            String mois =rs.getString("mois");
            String depence =rs.getString("depence");
             double montant =rs.getDouble("montant");
          
                 
           
          List_produit.add(new Dépense( annee,mois, depence, montant) );}
           pr.close();
        conn.close();
        }
        
        

         catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, null);
            throw new Exception(sc.getMessage(), sc);
        }
       
        return List_produit;
    }
    
 
 public ArrayList getList_depence(String param1,String param2,int type) throws Exception {
         //
          String sql ="";
  ArrayList<Dépense> List_produit= new ArrayList<Dépense>();
        try {


           Connection conn = jdbc.Getconnection();
            if(type==1){
            switch(param1){
                case "désignation":sql = "select * FROM Produit where désignation like %?% ";break;
                case "code_barre":sql = "select * FROM Produit where code_barre like %?% ";break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:  sql = "select * FROM dépence where année=? and mois= ?  ";break;
                           }
            
            }else {
                if(param2.equals("toute"))param2="";
                
                
                //if(param5.equals("toute les marques"))param5="";
                //int quantite=Integer.parseInt(param1);
// sql ="select * FROM  where categorie_produit like '%"+param2+"%' and categorie_piece like '%"+param3+"%' and etat like '%"+param4+"%' and marque like '%"+param5+"%' and quantité<='"+quantite+"' ";          
            }
            PreparedStatement pr=conn.prepareStatement(sql);
             switch(param1){
                case "désignation":pr.setString(1, param1);break;
                case "code_barre":pr.setString(1, param1);break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default: pr.setString(1, param1);pr.setString(2, param2);break;
                           }
                // pr.setString(2, mois);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
      while(rs.next()){
            int annee =rs.getInt("année");
            String mois =rs.getString("mois");
            String depence =rs.getString("depence");
             double montant =rs.getDouble("montant");
          
                 
           
          List_produit.add(new Dépense( annee,mois, depence, montant) );}
           pr.close();
        conn.close();
        }
        
        

         catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, null);
            throw new Exception(sc.getMessage(), sc);
        }
       
        return List_produit;
    }
 
 
 
 
 
 public ArrayList getList_depence() throws Exception {
         //
          String sql ="select * FROM dépence ";
  ArrayList<Dépense> List_depense= new ArrayList<Dépense>();
        try {
           Connection conn = jdbc.Getconnection();  
           PreparedStatement pr=conn.prepareStatement(sql);
       
           ResultSet rs = pr.executeQuery();
      while(rs.next()){
            int annee =rs.getInt("année");
            String mois =rs.getString("mois");
            String depence =rs.getString("depence");
            double montant =rs.getDouble("montant");
            int id=rs.getInt("ID");
 
          List_depense.add(new Dépense( annee,mois, depence, montant,id) );}
           pr.close();
        conn.close();
        }
        
        

         catch (Exception sc) {
        //    JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, null);
            throw new Exception(sc.getMessage(), sc);
        }
       
        return List_depense;
    }
 
 public ArrayList getList_depence(int year,String mounth) throws Exception {
         //
          String sql ="select * FROM dépence where année=? and mois= ? ";
          
  ArrayList<Dépense> List_depense= new ArrayList<Dépense>();
        try {
           Connection conn = jdbc.Getconnection();
           PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, year);
                 pr.setString(2, mounth);
                // pr.executeUpdate();
            ResultSet rs = pr.executeQuery();
      while(rs.next()){
            int annee =rs.getInt("année");
            String mois =rs.getString("mois");
            String depence =rs.getString("depence");
            double montant =rs.getDouble("montant");
            int id=rs.getInt("ID");
 
          List_depense.add(new Dépense( annee,mois, depence, montant,id) );}
           pr.close();
        conn.close();
        }
        
        

         catch (Exception sc) {
        //    JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, null);
            throw new Exception(sc.getMessage(), sc);
        }
       
        return List_depense;
    }
 
 
}
