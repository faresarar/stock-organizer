/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;


import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Achat;
import model.Produit;

/**
 *
 * @author Rais
 */
public class Achat_op {
    
    private static Achat_op instance;   
public Achat_op(){}
public static Achat_op getInstance(){
if(instance==null){
    instance=new Achat_op();
}
return instance;
}
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
   Vector<Object> oneRow;
   TextNumber tn= TextNumber.getObj();
public  void Inserer_achat(Achat A )throws Exception{
        try {
          
           Connection conn = jdbc.Getconnection();
            // Statement stmt = conn.createStatement();
             // String sql = "insert into Achat (num_bon_réception,date_achat,nom_prénom_fournisseur,TVA,désignation,prix_achat,prix_vente,quantité,quantité_en_stock,montantTTC,montantHT,num_versement,référence) values ('"+A.getNum_bon_réception()+"','"+A.getDate_achat()+"','"+A.getNom_prénom_fournisseur()+"','"+A.getTVA()+"','"+A.getDésignation()+"','"+A.getPrix_achat()+"','"+A.getPrix_vente()+"','"+A.getQuantité()+"','"+ A.getQuantité_en_stock()+"',  '"+A.getMontantTTC()+"','"+A.getMontantHT()+"' ,'"+A.getNum_versement_achat()+"','"+A.getRéférence()+"') ";
            
            String sql = "insert into Achat ( num_bon_réception,  date_achat,  nom_prénom_fournisseur, prix_achat,quantité, temp_achat,  user,désignation ,somme_versé,remise,idf,id_produit) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            // ResultSet rs = stmt.executeQuery(sql);
          PreparedStatement pr=conn.prepareStatement(sql);
          pr.setInt(1, A.getNum_bon_réception());
          pr.setDate(2, A.getDate_achat());
          pr.setString(3, A.getNom_prénom_fournisseur());
        //  pr.setString(4, A.getDésignation());
          pr.setDouble(4, A.getPrix_achat());
             
          pr.setFloat(5, A.getQuantité());
          pr.setString(6, A.getTemp_achat());
          pr.setString(7, A.getUser());
          pr.setString(8, A.getDésignation());
          pr.setDouble(9, A.getSomme_versé());
          pr.setDouble(10, A.getRemise());
        
        //  pr.setDouble(12, A.getPrix_v_detail());
        //  pr.setDouble(13, A.getPrix_v_gros());
        //   pr.setDouble(14, A.getPrix_v_special());
          pr.setInt(11, A.getIdf());
          pr.setInt(12, A.getId_produit());
          
          pr.executeUpdate();
             System.out.println("insertion reussite");
        pr.close();
        conn.close();
        } catch (Exception sc) {
          sc.printStackTrace();
        }
   }       
    
 /* public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
  //   tableHeaders.add("num_bon_réception");
   // tableHeaders.add("date_achat");
    tableHeaders.add("nom_prénom_fournisseur");
     tableHeaders.add("TVA %");
    tableHeaders.add("désignation");
    tableHeaders.add("prix_achat");
    tableHeaders.add("prix_vente");
     tableHeaders.add("quantité acheter ");
      tableHeaders.add(" quantité_en_stock"); 
      tableHeaders.add("Montant HT"); 
       tableHeaders.add("Montant TTC"); 
    
    for (Object o : resultList) {
        Achat f = (Achat) o;
         oneRow = new Vector<Object>();
     //   oneRow.add(f.getNum_bon_réception());
     //  oneRow.add(f.getDate_achat());
        oneRow.add(f.getNom_prénom_fournisseur());
         oneRow.add(f.getTVA());
        oneRow.add(f.getDésignation());
        oneRow.add(f.getPrix_achat());
        oneRow.add(f.getPrix_vente());
        oneRow.add(f.getQuantité());
         oneRow.add(f.getQuantité_en_stock());
       oneRow.add(f.getQuantité()*f.getPrix_achat());
         oneRow.add((f.getQuantité()*f.getPrix_achat()*f.getTVA()/100)+(f.getQuantité()*f.getPrix_achat()));
       
       
              tableData.add(oneRow);
              
    }



//jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
 DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
      if(column==1 ||column==3 ||column==4 ||column==5 )
      //return column == 3;
          return true;
      else
        return false;
    }
    
  
};

jTable1.setModel(tableModel);
/*jTable1.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
            int row = table.rowAtPoint(p);
            if (me.getClickCount() == 2) {
            System.out.println("row="+row);
             System.out.println("column="+table.columnAtPoint(p));
            }
        }
    });  */
 
//}

   public void displayResult1(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Num_bon_achat");
   tableHeaders.add("Date_achat");
    tableHeaders.add("Fournisseur");
    tableHeaders.add("Temp achat");
    tableHeaders.add("User");
    
    tableHeaders.add("Désignation");
    tableHeaders.add("Prix_achat");
  
     tableHeaders.add("Quantité acheter ");
      tableHeaders.add("Somme Vérsé");
     // tableHeaders.add(" quantité_en_stock"); 
    //  tableHeaders.add("Montant HT"); 
     //  tableHeaders.add("Montant TTC"); 
     if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Achat f = (Achat) o;
         oneRow = new Vector<Object>();
      oneRow.add(f.getNum_bon_réception());
      oneRow.add(f.getDate_achat());
        oneRow.add(f.getNom_prénom_fournisseur());
         oneRow.add(f.getTemp_achat());
        oneRow.add(f.getUser());
        oneRow.add(f.getDésignation());
        oneRow.add(tn.Afficher2Verguile(f.getPrix_achat()));
        oneRow.add(f.getQuantité());
         oneRow.add(tn.Afficher2Verguile(f.getSomme_versé()));
     //  oneRow.add(f.getQuantité()*f.getPrix_achat());
        // oneRow.add((f.getQuantité()*f.getPrix_achat()*f.getTVA()/100)+(f.getQuantité()*f.getPrix_achat()));
       
       
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

jTable1.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
            int row = table.rowAtPoint(p);
            if (me.getClickCount() == 2) {
         //   System.out.println("row="+row);
           //  System.out.println("column="+table.columnAtPoint(p));
            }
        }
    });  

     }



 
}
 

  
 public ArrayList getList_Achat() throws Exception {
         //
        String sql = "select * FROM Achat order by num_bon_réception desc ";
 
       
         
  ArrayList<Achat> List_achat= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
         Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("num_bon_réception");
            Date date_achat =rs.getDate("date_achat");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
           
           //   String désignation =rs.getString("désignation");
           //   double prix_achat =rs.getDouble("prix_achat");
          
          //    int quantité =rs.getInt("quantité");
           //    String temp_achat =rs.getString("temp_achat");
           //   int id =rs.getInt("id");
           // double somme_versé =rs.getDouble("somme_versé");                          
          //  double somme_versé =rs.getDouble("somme_versé");
            //    String user =rs.getString("user");
         
        
      //     int id_produit =rs.getInt("id_produit");
          List_achat.add(new Achat(num_bon_réception,date_achat,nom_prénom_fournisseur ) );
        }
        rs.close();
        conn.close();

      
        return List_achat;
    }
 
  public ArrayList getList_bon() throws Exception {
         //
        String sql = "select  distinct(num_bon_réception) AS sa,date_achat,nom_prénom_fournisseur,somme_versé,remise,user,idf  FROM Achat  order by date_achat desc ";
 
       
         
  ArrayList<Achat> List_achat= new ArrayList<>();   
        //   JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("sa");
            Date date_achat =rs.getDate("date_achat");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
           
           
           
           //    String temp_achat =rs.getString("temp_achat");
           //   int id =rs.getInt("id");
            double somme_versé =rs.getDouble("somme_versé");                          
           double remise =rs.getDouble("remise");
               String user =rs.getString("user");
         
        
       int idf =rs.getInt("idf");
          List_achat.add(new Achat(num_bon_réception,date_achat,nom_prénom_fournisseur,somme_versé, user,remise,idf) );
        }
        rs.close();
        conn.close();

      
        return List_achat;
    }
 
  
  public ArrayList getList_bon(int num_bon) throws Exception {
         //
        String sql = "select  distinct(num_bon_réception) AS sa,date_achat,nom_prénom_fournisseur,somme_versé,remise,user,idf  FROM Achat  where num_bon_réception like '%"+num_bon+"%'";
 
       
         
  ArrayList<Achat> List_achat= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("sa");
            Date date_achat =rs.getDate("date_achat");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
           
           
           
           //    String temp_achat =rs.getString("temp_achat");
           //   int id =rs.getInt("id");
            double somme_versé =rs.getDouble("somme_versé");                          
           double remise =rs.getDouble("remise");
               String user =rs.getString("user");
           int idf =rs.getInt("idf");
        
       //  int id_produit =rs.getInt("id_produit");
          List_achat.add(new Achat(num_bon_réception,date_achat,nom_prénom_fournisseur,somme_versé, user,remise,idf) );
        }
        rs.close();
        conn.close();

      
        return List_achat;
    }
  
   /*public ArrayList getList_Achat(String param,int type,String date1,String date2) throws Exception {
         //
        String sql ;
 
       switch(type){
         //  case 1:sql = "select * FROM Achat where nom_prénom_fournisseur like '%"+param+"%'  ";break;
         //  case 2:sql = "select * FROM Achat where désignation like '%"+param+"%'   ";break;
          //  case 3:sql = "select * FROM Achat where num_bon_réception like '%"+param+"%'  ";break;
            case 4:sql = "select * FROM Achat where   nom_prénom_fournisseur like "+"'%'"+"?"+"'%'"+" and date_achat BETWEEN ? and ? order by id asc ";break;
              case 5:sql = "select * FROM Achat where   désignation like  "+"'%'"+"?"+"'%'"+" and date_achat BETWEEN ? and ? order by id asc ";break;
                default :sql = "select * FROM Achat where   num_bon_réception =? order by id asc ";break;
       }
         
  ArrayList<Achat> List_achat= new ArrayList<Achat>();   
           JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            //tatement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
           PreparedStatement pr=conn.prepareStatement(sql);
           if(type==4 ||type==5){
           pr.setString(1, param);
           pr.setString(2, date1);
           pr.setString(3, date2);
           }else{
           pr.setString(1,param );
           }
            
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("num_bon_réception");
            String date_achat =rs.getString("date_achat");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
            float TVA =rs.getFloat("TVA");
            String désignation =rs.getString("désignation");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente =rs.getDouble("prix_vente");
            int quantité =rs.getInt("quantité");
            int quantité_en_stock =rs.getInt("quantité_en_stock");
          int num_versement_achat =rs.getInt("num_versement");                          
          //  double somme_versé =rs.getDouble("somme_versé");
             double montantHT =rs.getDouble("montantHT");
              double montantTTC =rs.getDouble("montantTTC");
         int id =rs.getInt("id");
         String référence =rs.getString("référence");
            int id_produit =rs.getInt("id_produit");
          List_achat.add(new Achat(num_bon_réception,date_achat,nom_prénom_fournisseur,TVA ,désignation,prix_achat,prix_vente,quantité,montantTTC,montantHT,quantité_en_stock,num_versement_achat,id,référence,id_produit) );
        }
        rs.close();
        conn.close();

      
        return List_achat;
    }*/
  /* public void modifier_Achat(Achat f) throws Exception {
        
        try {
            JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();
          
             //  String sql1 = "UPDATE Achat set date_achat='"+f.getDate_achat()+"', nom_prénom_fournisseur='"+f.getNom_prénom_fournisseur()+"' , TVA='"+f.getTVA()+"' , désignation='"+f.getDésignation()+"' , prix_achat='"+f.getPrix_achat()+"'  , prix_vente='"+f.getPrix_vente()+"' , quantité='"+f.getQuantité()+"' , quantité_en_stock='"+f.getQuantité_en_stock()+"'   where num_versement_achat='"+f.getNum_versement_achat()+"'";
             
                    String sql1 = "UPDATE Achat set date_achat=?, nom_prénom_fournisseur=?  , désignation=?, prix_achat=? , quantité=? where num_versement_achat=?";
PreparedStatement pr=conn.prepareStatement(sql1);
pr.setString(1, f.getDate_achat());
pr.setString(2, f.getNom_prénom_fournisseur());
pr.setFloat(3, f.getTVA());
pr.setString(4, f.getDésignation());
pr.setDouble(5, f.getPrix_achat());
pr.setDouble(6, f.getPrix_vente());
pr.setInt(7, f.getQuantité());
pr.setInt(8, f.getQuantité_en_stock());
pr.setInt(9, f.getNum_versement_achat());
//pr.setString(10, sql1);
pr.executeUpdate();
                    
//  ResultSet rs1 = stmt.executeQuery(sql1);
               
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
          // sc.printStackTrace();
        }
       
    }  */
   
public  void sup_Achat1(int  num_bon_réception)throws Exception{

        try {
//JdbcClass j=new JdbcClass();
Connection conn = jdbc.Getconnection();
//Statement stmt = conn.createStatement();
String sql = "delete  from achat where num_bon_réception=?";
  PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, num_bon_réception);
              pr.executeUpdate();
         //      System.out.println("vvvvvv");
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
      //  System.out.println("mmmmmmm");
}     


 

public  void sup_Achat(int  id)throws Exception{

        try {
//JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
              String sql = "delete  from Achat where id=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, id);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}     
   

public int GetNextBonReception() throws Exception{
    //String ref="B";
    int ref=1;
 //JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(id)   as maxid from Achat ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =(rs.getInt("maxid"));
           //  System.out.println("max="+max);
           
            ref=max+1;
           //  System.out.println("ref="+ref);
        }

return ref;
}
/*public double getTotal_HT(ArrayList<Achat> Listachat){
   
double totalHT=0;
for (int i=0;i<Listachat.size();i++)
   totalHT=totalHT+(Listachat.get(i).getQuantité()*Listachat.get(i).getPrix_achat());
return totalHT;
}

public double getHT(double prix_achat,int quantité){
   double ht;

   ht=prix_achat*quantité;
return ht;
}
public double getTTC(double ht,float tva){
   double ttc;

   ttc=(ht*tva/100)+ht;
return ttc;
}

public double getTotal_TTC(ArrayList<Achat> Listachat){
   
double total_TTC=0;
for (int i=0;i<Listachat.size();i++)
   total_TTC=total_TTC+(Listachat.get(i).getQuantité()*Listachat.get(i).getPrix_achat()*Listachat.get(i).getTVA()/100)+(Listachat.get(i).getQuantité()*Listachat.get(i).getPrix_achat());
return total_TTC;
}

public int getNombreUnité(ArrayList<Achat> Listachat){
   
int total=0;
for (int i=0;i<Listachat.size();i++)
   total=total+Listachat.get(i).getQuantité();
return total;
}
*/

public int GetNextNumVersement() throws Exception{
    int num=0;
 //JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max (num_versement)   as maxid from Versement_fournisseur ";
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

public ArrayList getListBonAchat() throws Exception {
         //
        String sql = "select distinct(num_bon_réception) AS sa,nom_prénom_fournisseur,date_achat FROM Achat order by date_achat desc ";
            ArrayList<Achat> List_achat= new ArrayList<Achat>();   
         //  JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
      
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("sa");
            Date date_achat =rs.getDate("date_achat");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
                    
          List_achat.add(new Achat(num_bon_réception,date_achat,nom_prénom_fournisseur) );
        }
        rs.close();
        conn.close();
  
        return List_achat;
    }

/*public ArrayList getList_Achat(int num_bon_achat) throws Exception {
         //
        String sql = "select * FROM Achat,Produit where achat.id_produit=Produit.id_produit and achat.num_bon_réception='"+num_bon_achat+"'    order by id desc ";
 
       
         
  ArrayList<Achat> List_achat= new ArrayList<>();   
          // JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
          //  int num_bon_livraison =rs.getInt("num_bon_livraison");
            Date date_achat =rs.getDate("date_achat");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
           //   float TVA =rs.getFloat("TVA");
            String désignation =rs.getString("désignation");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_v_detail =rs.getDouble("prix_vente_detail");
            double prix_v_gros =rs.getDouble("prix_vente_gros");
              double prix_v_special =rs.getDouble("prix_special");
            float quantité =rs.getFloat("quantité");
           //   int quantité_en_stock =rs.getInt("quantité_en_stock");
         // int num_versement =rs.getInt("num_versement");                          
           double somme_versé =rs.getDouble("somme_versé");
           //    double montantHT =rs.getDouble("montantHT");
           //     double montantTTC =rs.getDouble("montantTTC");
         //   int id =rs.getInt("id");
         //   String référence=rs.getString("référence");
            String temp_achat=rs.getString("temp_achat");
             String user=rs.getString("user");
             int id_produit =rs.getInt("id_produit");
             double remise=rs.getDouble("remise");
              int idf= rs.getInt("idf");
             
          List_achat.add(new Achat(num_bon_achat,date_achat,nom_prénom_fournisseur ,temp_achat,user,désignation,prix_achat,quantité,somme_versé,id_produit,remise,prix_v_detail,prix_v_gros,prix_v_special,idf) );
        }
        rs.close();
        conn.close();

      
        return List_achat;
    }*/

public ArrayList getList_Achat(int num_bon_achat) throws Exception {
         //
        String sql = "select * FROM Achat where num_bon_réception='"+num_bon_achat+"'    order by id desc ";
 
       
         
  ArrayList<Achat> List_achat= new ArrayList<>();   
          // JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
          //  int num_bon_livraison =rs.getInt("num_bon_livraison");
            Date date_achat =rs.getDate("date_achat");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
           //   float TVA =rs.getFloat("TVA");
            String désignation =rs.getString("désignation");
            double prix_achat =rs.getDouble("prix_achat");
          //  double prix_v_detail =rs.getDouble("prix_vente_detail");
            //double prix_v_gros =rs.getDouble("prix_vente_gros");
           // double prix_v_special =rs.getDouble("prix_special");
            float quantité =rs.getFloat("quantité");
           //   int quantité_en_stock =rs.getInt("quantité_en_stock");
         // int num_versement =rs.getInt("num_versement");                          
           double somme_versé =rs.getDouble("somme_versé");
           //    double montantHT =rs.getDouble("montantHT");
           //     double montantTTC =rs.getDouble("montantTTC");
         //   int id =rs.getInt("id");
         //   String référence=rs.getString("référence");
            String temp_achat=rs.getString("temp_achat");
             String user=rs.getString("user");
            int id_produit =rs.getInt("id_produit");
             double remise=rs.getDouble("remise");
              int idf= rs.getInt("idf");
             
          List_achat.add(new Achat(num_bon_achat,date_achat,nom_prénom_fournisseur ,temp_achat,user,désignation,prix_achat,quantité,somme_versé,remise,0,0,0,idf,id_produit) );
        }
        rs.close();
        conn.close();

      
        return List_achat;
    }

public void displayBonAchat(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    tableHeaders.add("N° Bon ");
    tableHeaders.add("Date");
    tableHeaders.add("Fournisseur");
    tableHeaders.add("Utilisateur");
    tableHeaders.add("Remise");
    tableHeaders.add("Versement");
   //if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Achat f = (Achat) o;
        oneRow = new Vector<Object>();
        oneRow.add(f.getNum_bon_réception());
        oneRow.add(f.getDate_achat());
        oneRow.add(f.getNom_prénom_fournisseur());
        oneRow.add(f.getUser());
      
        oneRow.add(tn.Afficher2Verguile(f.getRemise()));
        oneRow.add(tn.Afficher2Verguile(f.getSomme_versé()));
        
              tableData.add(oneRow);
              
    }
    
   jTable1.setModel(new DefaultTableModel(tableData, tableHeaders)); 
   DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
  centerRenderer.setHorizontalAlignment( JLabel.CENTER );
 for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
renderer.setHorizontalAlignment(0);

jTable1.setAutoCreateRowSorter(true);
   
  DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {
    @Override
    public boolean isCellEditable(int row, int column) {
    return false;
    }
};
jTable1.setModel(tableModel); 
}



public void DisplayListAchat(List resultList,JTable jTable1,List ListQuantiteAchete) throws Exception {
    int i=0;
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
   tableHeaders.add("Désignation");
    tableHeaders.add("Prix d'achat");
    tableHeaders.add("Prix vente detail");
    tableHeaders.add("Prix vente gros");
     tableHeaders.add("Prix vente spécial");
   
    tableHeaders.add("QTE Stock");
    tableHeaders.add("QTE Acheté");
    if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Achat f = (Achat) o;
        oneRow = new Vector<Object>();
        oneRow.add(f.getDésignation());
        oneRow.add(tn.Afficher2Verguile(f.getPrix_achat()));
        oneRow.add(tn.Afficher2Verguile(f.getPrix_v_detail()));
        oneRow.add(tn.Afficher2Verguile(f.getPrix_v_gros()));
        oneRow.add(tn.Afficher2Verguile(f.getPrix_v_special()));
       
        oneRow.add(f.getQuantité());
        oneRow.add(ListQuantiteAchete.get(i));
        i++;
        tableData.add(oneRow);
              
    }
    
    jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
    
    
    DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
      if(column==1 ||column==2 ||column==3 ||column==5 )
      //return column == 3;
          return true;
      else
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
  public void displayResult1(List resultList,JTable jTable1,List Quantité) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
ListIterator li = Quantité.listIterator();
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Désignation");
    tableHeaders.add(" Prix vente detail");
     tableHeaders.add("Prix vente gros");
     tableHeaders.add("Prix vente spécial");
     tableHeaders.add("Prix d'achat");
     tableHeaders.add("QTE Stock ");
     tableHeaders.add("QTE Acheté");
    
    for (Object o : resultList) {
        Produit p = (Produit) o;
         oneRow = new Vector<Object>();
         oneRow.add(p.getDésignation());
         oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_detail()));
         oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_gros()));
          oneRow.add(tn.Afficher2Verguile(p.getPrix_special()));
         oneRow.add(tn.Afficher2Verguile(p.getPrix_achat()));
         oneRow.add(p.getQuantité());
         oneRow.add(li.next());
         tableData.add(oneRow);
      // if(li.hasNext()){ System.out.println("hello world");}
    }

jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));

DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
      if(column==1 ||column==2 ||column==3 ||column==4 ||column==6)
      //return column == 3;
          return true;
      else
        return false;
    }
    
  
};

jTable1.setModel(tableModel);
// jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));

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
  
  
  
public ArrayList getList_produit(int num_bon_achat) throws Exception {
         //
        String sql = "select * FROM Achat,produit where achat.id_produit=Produit.id_produit and achat.num_bon_réception='"+num_bon_achat+"'     order by id desc ";
 
       
         
  ArrayList<Produit> List_pro= new ArrayList<>();   
          // JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
          //  int num_bon_livraison =rs.getInt("num_bon_livraison");
            Date date_achat =rs.getDate("date_achat");
           
           //   float TVA =rs.getFloat("TVA");
            String désignation =rs.getString("désignation");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_v_detail =rs.getDouble("prix_vente_detail");
            double prix_v_gros =rs.getDouble("prix_vente_gros");
             double prix_v_special =rs.getDouble("prix_special");
            float quantité =rs.getFloat("quantité");
       
            int id_produit =rs.getInt("id_produit");
         
               
             
          List_pro.add(new Produit(désignation,prix_achat,prix_v_detail,prix_v_gros,prix_v_special,quantité,id_produit,date_achat) );
        }
        rs.close();
        conn.close();

      
        return List_pro;
    }
  
  
}
