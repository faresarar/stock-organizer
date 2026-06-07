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
import model.Commande;
import model.Produit;

/**
 *
 * @author Rais
 */
public class Commande_fournisseur_op {
    
private static Commande_fournisseur_op instance;   
public Commande_fournisseur_op(){}
public static Commande_fournisseur_op getInstance(){
if(instance==null){
    instance=new Commande_fournisseur_op();
}
return instance;
}
     JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
   Vector<Object> oneRow;
   TextNumber tn= TextNumber.getObj();
public  void Inserer_Commande(Commande C )throws Exception{
        try {
          
           Connection conn = jdbc.Getconnection();
            // Statement stmt = conn.createStatement();
             // String sql = "insert into Achat (num_bon_réception,date_achat,nom_prénom_fournisseur,TVA,désignation,prix_achat,prix_vente,quantité,quantité_en_stock,montantTTC,montantHT,num_versement,référence) values ('"+C.getNum_bon_réception()+"','"+C.getDate_achat()+"','"+C.getNom_prénom_fournisseur()+"','"+C.getTVA()+"','"+C.getDésignation()+"','"+C.getPrix_achat()+"','"+C.getPrix_vente()+"','"+C.getQuantité()+"','"+ C.getQuantité_en_stock()+"',  '"+C.getMontantTTC()+"','"+C.getMontantHT()+"' ,'"+C.getNum_versement_achat()+"','"+C.getRéférence()+"') ";
            
            String sql = "insert into CommandeFournisseur ( num_bon,  date,  nom_prénom_fournisseur,désignation,quantité, temp,  user,idf,id_produit ) values (?,?,?,?,?,?,?,?,?)";
          
          PreparedStatement pr=conn.prepareStatement(sql);
          pr.setInt(1, C.getNum_bon());
          pr.setDate(2, C.getDate());
          pr.setString(3, C.getNom_prénom_fournisseur());
          pr.setString(4, C.getDésignation());
          pr.setFloat(5, C.getQuantité());
          pr.setString(6, C.getTemp());
          pr.setString(7, C.getUser());
          pr.setInt(8, C.getIdf());
          pr.setInt(9, C.getId_produit());
      //    System.out.println("id dans insert ="+C.getIdf());
             
          
          pr.executeUpdate();
                          
        pr.close();
        conn.close();
        } catch (Exception sc) {
          sc.printStackTrace();
        }
   }       
    


   public void displayResult1(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    tableHeaders.add("Num_bon");
    tableHeaders.add("Date_Commande");
    tableHeaders.add("Fournisseur");
    tableHeaders.add("Temp Commande");
    tableHeaders.add("Utilisateur");
    
   // tableHeaders.add("Désignation");
    
  
     //tableHeaders.add("Quantité");
     
     if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Commande f = (Commande) o;
      oneRow = new Vector<Object>();
      oneRow.add(f.getNum_bon());
      oneRow.add(f.getDate());
      oneRow.add(f.getNom_prénom_fournisseur());
      oneRow.add(f.getTemp());
      oneRow.add(f.getUser());
     // oneRow.add(f.getDésignation());
    //  oneRow.add(f.getQuantité());
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

//jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));
/* DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
      if(column==1 ||column==3 ||column==4 ||column==5 )
      //return column == 3;
          return true;
      else
        return false;
    }
    
  
};
 */
 
 


       
       

//jTable1.setModel(tableModel);

 
}
 

  
/* public ArrayList getList_Commande() throws Exception {
         //
        String sql = "select distinct(num_bon)AS sa,nom_prénom_fournisseur,date,user,temp,désignation,quantité,idf,id_produit FROM CommandeFournisseur order by num_bon desc ";
  ArrayList<Commande> List_commande= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
         Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon =rs.getInt("sa");
            Date date =rs.getDate("date");
            String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
            String désignation =rs.getString("désignation");
            int quantité =rs.getInt("quantité");
            String temp =rs.getString("temp");
          //  int id =rs.getInt("id");
            int idf =rs.getInt("idf");
            int id_produit =rs.getInt("id_produit");
            String user =rs.getString("user");
      
          List_commande.add(new Commande(num_bon,date,nom_prénom_fournisseur,temp,user,désignation,quantité,idf,id_produit ) );
        }
        rs.close();
        conn.close();

      
        return List_commande;
    }*/
 
  /*public ArrayList getList_bon() throws Exception {
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
 */
  
  public ArrayList getList_Detail(int num_bon) throws Exception {
         //
        String sql = "select  quantité,désignation,user FROM CommandeFournisseur  where num_bon like '%"+num_bon+"%'";
 
       
         
  ArrayList<Commande> List_commande= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";  
   //System.out.println("avant =");
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            String user =rs.getString("user");
            float quantité =rs.getFloat("quantité");
            String désignation =rs.getString("désignation");
           // System.out.println("dans while=");
        
       //  int id_produit =rs.getInt("id_produit");
          List_commande.add(new Commande(num_bon,quantité, désignation,user) );
        //  System.out.println("list commande size="+List_commande.size());
        }
        rs.close();
        conn.close();

      
        return List_commande;
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
   
public  void sup_Commande(int  num_bon)throws Exception{

        try {

Connection conn = jdbc.Getconnection();
//Statement stmt = conn.createStatement();
String sql = "delete  from CommandeFournisseur where num_bon=?";
  PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, num_bon);
              pr.executeUpdate();
       
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
      //  System.out.println("mmmmmmm");
}     


 

/*public  void sup_Achat(int  id)throws Exception{

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
}     */
   

public int GetNextBon() throws Exception{
    //String ref="B";
    int ref=0;
 //JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(num_commande)   as maxid from CommandeFournisseur ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =(rs.getInt("maxid"));
           //  System.out.println("max="+max);
           
            ref=max;
           //  System.out.println("ref="+ref);
        }

return ref+1;
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

/*public int GetNextNumVersement() throws Exception{
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
}*/

public ArrayList getListBonCommande() throws Exception {
         //
        String sql = "select distinct num_bon ,nom_prénom_fournisseur,date,user FROM CommandeFournisseur order by date desc ";
            ArrayList<Commande> List_commande= new ArrayList<Commande>();   
         //  JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
      
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon =rs.getInt("num_bon");
            Date date =rs.getDate("date");
        //      float quantité =rs.getFloat("quantité");

             //  int qte_p =rs.getInt("qte_p");
             //   int equart_qte =rs.getInt("equart_qte");
              //    double prix_achat_ttc =rs.getInt("prix_achat_ttc");
             
          // String temp =rs.getString("temp");
          //   String désignation =rs.getString("désignation");
            String user =rs.getString("user");
              String nom_prenom_fournisseur =rs.getString("nom_prénom_fournisseur");
        
                    
          List_commande.add(new Commande(num_bon,date,nom_prenom_fournisseur,"",user) );
        }
        rs.close();
        conn.close();
  
        return List_commande;
    }

/*public ArrayList getList_Achat(int num_bon_achat) throws Exception {
         //
        String sql = "select * FROM Achat where num_bon_réception='"+num_bon_achat+"'  order by id desc ";
 
       
         
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
            double prix_v_detail =rs.getDouble("prix_v_detail");
            double prix_v_gros =rs.getDouble("prix_v_gros");
              double prix_v_special =rs.getDouble("prix_v_special");
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

public void displayBonCommande(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
   tableHeaders.add("N° Bon ");
    tableHeaders.add("Date");
    tableHeaders.add("Fournisseur");
     tableHeaders.add("Utilisateur");
   
       
   //if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Commande f = (Commande) o;
        oneRow = new Vector<Object>();
        oneRow.add(f.getNum_bon());
        oneRow.add(f.getDate());
        oneRow.add(f.getNom_prénom_fournisseur());
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



/*public void DisplayListAchat(List resultList,JTable jTable1,List ListQuantiteAchete) throws Exception {
    int i=0;
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
   tableHeaders.add("Désignation");
    tableHeaders.add("Prix vente detail");
    tableHeaders.add("Prix vente gros");
     tableHeaders.add("Prix vente spécial");
    tableHeaders.add("Prix d'achat");
    tableHeaders.add("QTE Stock");
    tableHeaders.add("QTE Acheté");
    if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Achat f = (Achat) o;
        oneRow = new Vector<Object>();
        oneRow.add(f.getDésignation());
        oneRow.add(tn.Afficher2Verguile(f.getPrix_v_detail()));
        oneRow.add(tn.Afficher2Verguile(f.getPrix_v_gros()));
        oneRow.add(tn.Afficher2Verguile(f.getPrix_v_special()));
        oneRow.add(tn.Afficher2Verguile(f.getPrix_achat()));
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

}*/
  public void displayResult1(List resultList,JTable jTable1,List Quantité) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
ListIterator li = Quantité.listIterator();
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Désignation");
   
  
     tableHeaders.add("QTE Stock ");
     tableHeaders.add("QTE Commander");
    
    for (Object o : resultList) {
        Produit p = (Produit) o;
         oneRow = new Vector<Object>();
         oneRow.add(p.getDésignation());
        
         oneRow.add(p.getQuantité());
//if(li.hasNext()) 
    oneRow.add(li.next());
         tableData.add(oneRow);
      // if(li.hasNext()){ System.out.println("hello world");}
    }

jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));

DefaultTableModel tableModel = new DefaultTableModel(tableData, tableHeaders) {

    @Override
    public boolean isCellEditable(int row, int column) {
      if(column==2  )
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
  public void displayDetail(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne

    tableHeaders.add("Désignation");
    tableHeaders.add("Quantité");
    tableHeaders.add("Utilisateur");

   //if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Commande f = (Commande) o;
        oneRow = new Vector<Object>();
        oneRow.add(f.getDésignation());
        oneRow.add(f.getQuantité());
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

  /*public  void Charger_Fournisseur( JComboBox categorie ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
  DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
categorie.setRenderer(centr);
categorie.removeAllItems();

 try {
            Connection conn = jdbc.Getconnection();
             Statement stmt = conn.createStatement();
              String sql = "SELECT * FROM fournisseur  order by nom_prenom_fournisseur asc";
            ResultSet rs = stmt.executeQuery(sql);
            categorie.addItem(" ");
        while (rs.next()) {
             categorie.addItem(rs.getString("nom_prenom_fournisseur") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }*/

public ArrayList getList_Commande(String num) throws Exception {
         //
         String sql;
       
         sql = "select  distinct  date ,user ,nom_prénom_fournisseur,num_bon FROM commandefournisseur where  num_bon like '%"+num+"%' order by date desc";
      
         
  ArrayList<Commande> List= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
          //  int num_inv =rs.getInt("inv");
            Date date =rs.getDate("date");
         //  String désignation =rs.getString("désignation");
        //    int quantité =rs.getInt("quantité");
           
        //    int id_produit =rs.getInt("id_produit");      
          int num_bon =rs.getInt("num_bon");
        //      float quantité =rs.getFloat("quantité");
            //  int idf =rs.getInt("idf");             
         //   String temp =rs.getString("temp");
          //   String désignation =rs.getString("désignation");
            String user =rs.getString("user");
              String nom_prénom_fournisseur =rs.getString("nom_prénom_fournisseur");
           
       //  int id_produit =rs.getInt("id_produit");
          List.add(new Commande(num_bon,date,nom_prénom_fournisseur,"",user) );
        }
        rs.close();
        conn.close();

      
        return List;
    }
public ArrayList getList_Commande1(int num) throws Exception {
         //
        String sql = "select distinct num_bon ,nom_prénom_fournisseur,date,user FROM CommandeFournisseur  where  num_bon like '%"+num+"%' ";
            ArrayList<Commande> List_commande= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
      
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon =rs.getInt("num_bon");
            Date date =rs.getDate("date");
        //      float quantité =rs.getFloat("quantité");

             //  int qte_p =rs.getInt("qte_p");
             //   int equart_qte =rs.getInt("equart_qte");
              //    double prix_achat_ttc =rs.getInt("prix_achat_ttc");
             
         //   String temp =rs.getString("temp");
          //   String désignation =rs.getString("désignation");
            String user =rs.getString("user");
              String nom_prenom_fournisseur =rs.getString("nom_prénom_fournisseur");
        
                    
          List_commande.add(new Commande(num_bon,date,nom_prenom_fournisseur,"",user) );
        }
        rs.close();
        conn.close();

      
        return List_commande;
    }

public ArrayList GetListCommande(java.sql.Date d1,java.sql.Date d2) throws Exception{
    ArrayList<Commande> List_com= new ArrayList<>();   
   Connection conn = jdbc.Getconnection();
      String    sql = "select distinct num_bon  ,nom_prénom_fournisseur,date,user FROM commandefournisseur where  date between ?  and ?";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {      
            
            
          
           int num_bon =rs.getInt("num_bon");
            Date date =rs.getDate("date");
        //      float quantité =rs.getFloat("quantité");

             //  int qte_p =rs.getInt("qte_p");
             //   int equart_qte =rs.getInt("equart_qte");
              //    double prix_achat_ttc =rs.getInt("prix_achat_ttc");
             
          //  String temp =rs.getString("temp");
          //   String désignation =rs.getString("désignation");
            String user =rs.getString("user");
              String nom_prenom_fournisseur =rs.getString("nom_prénom_fournisseur");
        
       //  int id_produit =rs.getInt("id_produit");
            List_com.add(new Commande(num_bon,date,nom_prenom_fournisseur,"",user) );
        }
        rs.close();
        conn.close();

      
        return List_com;
}  
  
}
