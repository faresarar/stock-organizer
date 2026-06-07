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
import java.sql.Date;
//import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Client;
import model.Produit;


import model.Vente;
//import static vue.VenteComptoir4.ListPrintBon;
import static vue.VenteComptoir4.ListProduitQuantité;
import static vue.VenteComptoir4.ListProduitQuantité2;

import static vue.VenteComptoir4.ListVente;
import static vue.VenteComptoir4.ListVente2;

import static vue.VenteComptoir4.TableVente;
import static vue.VenteComptoir4.date_vente;

import static vue.VenteComptoir4.f;
import static vue.VenteComptoir4.f2;
//import static vue.VenteComptoir4.nom_prenom_client;
import static vue.VenteComptoir4.num_bon;
import static vue.VenteComptoir4.num_bon2;

import static vue.Aucceuil.userName;

import static vue.VenteComptoir4.a_rendu;
import static vue.VenteComptoir4.a_rendu2;

/**
 *
 * @author pc
 */
public class Vente_op {
     Paramaitres_op pp=Paramaitres_op.getInstance();
    private Vente v;
    private Client c;
    private double nv_credit,m_verse,total,remise,total_apres_remise,total_TTc;
    TextNumber tnb= TextNumber.getObj();
    
     private static Vente_op instance;   
public Vente_op(){}
public static Vente_op getInstance(){
if(instance==null){
    instance=new Vente_op();
}
return instance;
} 
    
 FormaterNumber fnb;
 JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
 Vector<Object> oneRow;
 public  void Inserer_vente(Vente V )throws Exception{
  //   System.out.println("insertion begin ");
       
     try {
    Connection conn = jdbc.Getconnection();               // String sql = "insert into Vente (num_bon_livraison,date_vente,nom_prénom_client,TVA,désignation,prix_achat,prix_vente,quantité_vente,quantité_stock,montantTTC,montantHT,num_versement,référence,temp_vente,user) values ('"+V.getNum_bon_livraison()+"','"+V.getDate_vente()+"','"+V.getNom_prénom_cient()+"','"+V.getTVA()+"','"+V.getDésignation()+"','"+V.getPrix_achat()+"','"+V.getPrix_vente()+"','"+V.getQuantité_vente()+"','"+ V.getQuantité_stock()+"',  '"+V.getMontantTTC()+"','"+V.getMontantHT()+"' ,'"+V.getNum_versement_vente()+"','"+V.getRéférence()+"','"+V.getTemp_vente()+"' ,'"+V.getUser()+"'   ) ";
    String sql = "insert into Vente (date_vente,nom_prénom_client,TVA,désignation,prix_achat,prix_vente,quantité_vente,"
            + "montantTTC,montantHT,temp_vente,user,id_produit,idc,somme_versé,remise,num_bon,rendu,code,etat)"
            + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
           // ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            //    pr.setInt(1,V.getNum_bon_livraison());
             pr.setDate(1, V.getDate_vente());
             pr.setString(2, V.getNom_prénom_client());
             pr.setFloat(3, V.getTVA());
             pr.setString(4, V.getDésignation());
             pr.setDouble(5, V.getPrix_achat());
             pr.setDouble(6, V.getPrix_vente());
             pr.setFloat(7, V.getQuantité_vente());
                 //    pr.setInt(9, V.getQuantité_stock());
             pr.setDouble(8, V.getMontantTTC());
             pr.setDouble(9, V.getMontantHT());
           // System.out.println("insertion hhhhttttt ");
                      //   pr.setString(13, V.getRéférence());
             pr.setString(10, V.getTemp_vente());
            //   System.out.println("insertion 111 ");
             pr.setString(11, V.getUser());
             //  System.out.println("insertion 222 ");
             pr.setInt(12, V.getId_produit());
             pr.setInt(13, V.getIdc());
              // System.out.println("insertion 3333 ");
             pr.setDouble(14, V.getSomme_versé());
             //  System.out.println("insertion 4444 ");
             pr.setDouble(15, V.getRemise());
             //  System.out.println("insertion 555 ");
             pr.setInt(16, V.getNum_bon());
             pr.setDouble(17, V.getRendu());
              pr.setString(18, V.getCode());
              pr.setString(19, V.getEtat());
             //  System.out.println("insertion 6666 ");
             pr.executeUpdate();
             System.out.println("update vente");
        pr.close();
        conn.close();
        } catch (Exception sc) {
          sc.printStackTrace();
        }
   }      
public  void Modifier_vente(Vente V )throws Exception{
  //   System.out.println("insertion begin ");
       
     try {
    Connection conn = jdbc.Getconnection();               // String sql = "insert into Vente (num_bon_livraison,date_vente,nom_prénom_client,TVA,désignation,prix_achat,prix_vente,quantité_vente,quantité_stock,montantTTC,montantHT,num_versement,référence,temp_vente,user) values ('"+V.getNum_bon_livraison()+"','"+V.getDate_vente()+"','"+V.getNom_prénom_cient()+"','"+V.getTVA()+"','"+V.getDésignation()+"','"+V.getPrix_achat()+"','"+V.getPrix_vente()+"','"+V.getQuantité_vente()+"','"+ V.getQuantité_stock()+"',  '"+V.getMontantTTC()+"','"+V.getMontantHT()+"' ,'"+V.getNum_versement_vente()+"','"+V.getRéférence()+"','"+V.getTemp_vente()+"' ,'"+V.getUser()+"'   ) ";
    String sql = "update Vente set date_vente=?,nom_prénom_client=?,TVA=?,désignation=?,prix_achat=?,prix_vente=?,quantité_vente=?,"
            + "montantTTC=?,montantHT=?,temp_vente=?,user=?,id_produit=?,idc=?,somme_versé=?,remise=?,num_bon=?,rendu=?,code=?,etat=?"
            + " where id_vente=? ";
           // ResultSet rs = stmt.executeQuery(sql);
            PreparedStatement pr=conn.prepareStatement(sql);
            //    pr.setInt(1,V.getNum_bon_livraison());
             pr.setDate(1, V.getDate_vente());
             pr.setString(2, V.getNom_prénom_client());
             pr.setFloat(3, V.getTVA());
             pr.setString(4, V.getDésignation());
             pr.setDouble(5, V.getPrix_achat());
             pr.setDouble(6, V.getPrix_vente());
             pr.setFloat(7, V.getQuantité_vente());
                 //    pr.setInt(9, V.getQuantité_stock());
             pr.setDouble(8, V.getMontantTTC());
             pr.setDouble(9, V.getMontantHT());
           // System.out.println("insertion hhhhttttt ");
                      //   pr.setString(13, V.getRéférence());
             pr.setString(10, V.getTemp_vente());
             System.out.println("V.getTemp_vente()= "+V.getTemp_vente());
             pr.setString(11, V.getUser());
             //  System.out.println("insertion 222 ");
             pr.setInt(12, V.getId_produit());
             pr.setInt(13, V.getIdc());
              // System.out.println("insertion 3333 ");
             pr.setDouble(14, V.getSomme_versé());
             //  System.out.println("insertion 4444 ");
             pr.setDouble(15, V.getRemise());
             //  System.out.println("insertion 555 ");
             pr.setInt(16, V.getNum_bon());
             pr.setDouble(17, V.getRendu());
              pr.setString(18, V.getCode());
              pr.setString(19, V.getEtat());
               System.out.println("etat="+V.getEtat());
              pr.setInt(20, V.getId_vente());
                //  System.out.println("id vente= "+V.getId_vente());
        //   System.out.println("quantite vente= "+V.getQuantité_vente());
             pr.executeUpdate();
           System.out.println("update vente");
        pr.close();
        conn.close();
        } catch (Exception sc) {
          sc.printStackTrace();
        }
   }      

 
  public void displayResult1(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
  //   tableHeaders.add("num_bon_livraison");
   tableHeaders.add("Vendeur"); 
   tableHeaders.add("date_vente");
   tableHeaders.add("temp_vente"); 
   tableHeaders.add("client");
   tableHeaders.add("désignation");
   tableHeaders.add("TVA %");
  //  tableHeaders.add("prix_achat");
   tableHeaders.add("prix_vente");
   tableHeaders.add("quantité vente");
   tableHeaders.add("Montant HT"); 
   tableHeaders.add("Montant TTC");
   tableHeaders.add("Remise"); 
   tableHeaders.add("Somme Versé"); 
   
 
    
    for (Object o : resultList) {
        Vente f = (Vente) o;
         oneRow = new Vector<Object>();
       //   oneRow.add(f.getNum_bon_livraison());
      oneRow.add(f.getDate_vente());
        oneRow.add(f.getTemp_vente());
         oneRow.add(f.getNom_prénom_client());
          oneRow.add(f.getDésignation());
          oneRow.add(f.getTVA());
       
        oneRow.add(f.getPrix_achat());
        oneRow.add(f.getPrix_vente());
        oneRow.add(f.getQuantité_vente());
         oneRow.add(f.getMontantHT());
       oneRow.add(f.getMontantTTC());
        oneRow.add(f.getUser());
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
 
}
 
  
 
  public void displayBonLivraison(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
   tableHeaders.add("Num_bon");
    tableHeaders.add("Date vente");
    tableHeaders.add("Client");
   
    for (Object o : resultList) {
        Vente f = (Vente) o;
        oneRow = new Vector<Object>();
        oneRow.add(f.getNum_bon());
        oneRow.add(f.getDate_vente());
        oneRow.add(f.getNom_prénom_cient());
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

/*jTable1.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
            int row = table.rowAtPoint(p);
            if (me.getClickCount() ==1) {
            System.out.println("row="+row);
             System.out.println("column="+table.columnAtPoint(p));
            }
        }
    });*/
  }
    
    public void displayResult(List resultList,JTable jTable1) {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
  //   tableHeaders.add("num_bon_réception");
   // tableHeaders.add("date_achat");
    // tableHeaders.add("nom_prénom_client");
   
    tableHeaders.add("désignation");
   // tableHeaders.add("prix_achat");
    tableHeaders.add("prix_vente");
     tableHeaders.add("quantité");
      // tableHeaders.add(" quantité_en_stock"); 
      tableHeaders.add("TVA %");
      tableHeaders.add("Montant HT"); 
       tableHeaders.add("Montant TTC"); 
         tableHeaders.add("Vendeur"); 
    
    for (Object o : resultList) {
        Vente f = (Vente) o;
         oneRow = new Vector<Object>();
     //   oneRow.add(f.getNum_bon_réception());
       // oneRow.add(f.getDate_achat());
       //  oneRow.add(f.getNom_prénom_cient());
        
        oneRow.add(f.getDésignation());
        try {
            //  oneRow.add(f.getPrix_achat());
            oneRow.add(tnb.Afficher2Verguile(f.getPrix_vente()));
        } catch (Exception ex) {
            Logger.getLogger(Vente_op.class.getName()).log(Level.SEVERE, null, ex);
        }
        oneRow.add(f.getQuantité_vente());
          //oneRow.add(f.getQuantité_vente());
           oneRow.add(f.getTVA());
        try {
            oneRow.add(tnb.Afficher2Verguile(f.getQuantité_vente()*f.getPrix_vente()));
        } catch (Exception ex) {
            Logger.getLogger(Vente_op.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oneRow.add(tnb.Afficher2Verguile((f.getQuantité_vente()*f.getPrix_vente()*f.getTVA()/100)+(f.getQuantité_vente()*f.getPrix_vente())));
        } catch (Exception ex) {
            Logger.getLogger(Vente_op.class.getName()).log(Level.SEVERE, null, ex);
        }
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
 
/*public ArrayList getList_Achat() throws Exception {
         //
        String sql = "select * FROM Vente order by id asc ";
 
       
         
  ArrayList<Vente> List_vente= new ArrayList<Vente>();   
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon_livraison =rs.getInt("num_bon_livraison");
            String date_achat =rs.getString("date_achat");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            float TVA =rs.getFloat("TVA");
            String désignation =rs.getString("désignation");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente =rs.getDouble("prix_vente");
            float quantité =rs.getFloat("quantité_vente");
            float quantité_en_stock =rs.getFloat("quantité_stock");
          int num_versement_achat =rs.getInt("num_versement");                          
          //  double somme_versé =rs.getDouble("somme_versé");
             double montantHT =rs.getDouble("montantHT");
              double montantTTC =rs.getDouble("montantTTC");
          int id =rs.getInt("id_vente");
          String référence=rs.getString("référence");
            String temp_vente=rs.getString("heure_vente");
              String user=rs.getString("user");
 int id_produit =rs.getInt("id_produit");
          List_vente.add(new Vente(num_bon_livraison,date_achat,nom_prénom_client,TVA ,désignation,prix_achat,prix_vente,quantité,montantTTC,montantHT,quantité_en_stock,num_versement_achat,id,référence,temp_vente,user,id_produit) );
        }
        rs.close();
        conn.close();

      
        return List_vente;
    }*/
   
   /* public void modifier_Vente(Vente f) throws Exception {
        
        try {
             Connection conn = jdbc.Getconnection();
            //Statement stmt = conn.createStatement();
          
              // String sql1 = "UPDATE Vente set date_vente='"+f.getDate_vente()+"', nom_prénom_client='"+f.getNom_prénom_cient()+"' , TVA='"+f.getTVA()+"' , désignation='"+f.getDésignation()+"' , prix_achat='"+f.getPrix_achat()+"'  , prix_vente='"+f.getPrix_vente()+"' , quantité='"+f.getQuantité_vente()+"' , quantité_en_stock='"+f.getQuantité_stock()+"'   where num_versement_achat='"+f.getNum_versement_vente()+"'";
            String sql1 = "UPDATE Vente set date_vente=?, nom_prénom_client=? , TVA=? , désignation=? , prix_achat=?, prix_vente=?, quantité=? , quantité_en_stock=?  where num_versement_achat=?";
            PreparedStatement pr=conn.prepareStatement(sql1);
            pr.setString(1, f.getDate_vente());
            pr.setString(2, f.getNom_prénom_cient());
            pr.setFloat(3, f.getTVA());
            pr.setString(4, f.getDésignation());
            pr.setDouble(5, f.getPrix_achat());
            pr.setDouble(6, f.getPrix_vente());
            pr.setFloat(7, f.getQuantité_vente());
            pr.setFloat(8, f.getQuantité_stock());
            pr.setInt(9, f.getNum_versement_vente());
            pr.executeUpdate();
           // pr.setString(10, sql1);
           // pr.setString(11, sql1);
            //ResultSet rs1 = stmt.executeQuery(sql1);
               
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
          // sc.printStackTrace();
        }
       
    }  */
   
/*public  void sup_Vente(String  num_bon_livraison)throws Exception{

        try {
JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();
              String sql = "delete  from Vente where num_bon_livraison=?";
            //ResultSet rs = stmt.executeQuery(sql);
              PreparedStatement rs=conn.prepareStatement(sql);
              rs.setString(1, num_bon_livraison);
              rs.executeUpdate();
              rs.close();
        conn.close();
        } catch (Exception sc) {
        }
}    */
    public  void sup_Vente(int  num_bon_livraison)throws Exception{

        try {
  Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
              String sql = "delete  from vente where num_bon_livraison='"+num_bon_livraison +"'";
            ResultSet rs = stmt.executeQuery(sql);
              rs.close();
        conn.close();
        } catch (Exception sc) {
        }
}    


public  void sup_Vente1(int  id)throws Exception{

        try {

            Connection conn = jdbc.Getconnection();
                String sql = "delete  from Vente where id_vente=?";
    try (PreparedStatement rs = conn.prepareStatement(sql)) {
        rs.setInt(1, id);
        rs.executeUpdate();
    }
           
        } catch (Exception sc) {
        }
}         
public  void sup_Vente2(int  num_bon_livraison)throws Exception{

        try {
  Connection conn = jdbc.Getconnection();
                String sql = "delete  from vente where num_bon=?";
    try (PreparedStatement rs = conn.prepareStatement(sql)) {
        rs.setInt(1, num_bon_livraison);
        rs.executeUpdate();
    }
           
        } catch (Exception sc) {
        }
}         

 public int GetNextBon() throws Exception{
   int ref=0;
   Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select max(num_bon) as maxid from vente ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int max =(rs.getInt("maxid"));
           //  System.out.println("max="+max);
           
            ref=max+1;
           //  System.out.println("ref="+ref);
        }



return ref;
}   
    public double getTotal_HT(ArrayList<Vente> Listvente){
   
double totalHT=0;
for (int i=0;i<Listvente.size();i++)
   totalHT=totalHT+(Listvente.get(i).getQuantité_vente()*Listvente.get(i).getPrix_vente());
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

public double getTotal_TTC(ArrayList<Vente> Listvente){
   
double total_TTC=0;
for (int i=0;i<Listvente.size();i++)
   total_TTC=total_TTC+(Listvente.get(i).getQuantité_vente()*Listvente.get(i).getPrix_vente()*Listvente.get(i).getTVA()/100)+(Listvente.get(i).getQuantité_vente()*Listvente.get(i).getPrix_vente());
return total_TTC;
}



public int GetNextNumVersement() throws Exception{
    int num=0;
   Connection conn = jdbc.Getconnection();
   Statement stmt = conn.createStatement();
             String sql = "select max(num_versement)   as maxid from Versement_client ";
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
public float getNombreUnité(ArrayList<Vente> Listvente){
   
float total=0;
for (int i=0;i<Listvente.size();i++)
   total=total+Listvente.get(i).getQuantité_vente();
return total;
}





 public ArrayList getList_bon(int numbon) throws Exception {
         //
         String sql;
        if(numbon==0) sql = "select  distinct(num_bon) AS sa,date_vente,nom_prénom_client,somme_versé,remise,user,idc,etat  FROM Vente  order by date_vente desc";
        else sql = "select  distinct(num_bon) AS sa,date_vente,nom_prénom_client,somme_versé,remise,user,idc,etat  FROM Vente where  num_bon like '%"+numbon+"%' order by date_vente desc";
       
         
  ArrayList<Vente> List_vente= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("sa");
            Date date_vente =rs.getDate("date_vente");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            double somme_versé =rs.getDouble("somme_versé");                          
            double remise =rs.getDouble("remise");
            String user =rs.getString("user");
            int idc =rs.getInt("idc");
           String etat =rs.getString("etat");
       //  int id_produit =rs.getInt("id_produit");
          List_vente.add(new Vente(num_bon_réception,(java.sql.Date)date_vente,nom_prénom_client,somme_versé, user,remise,idc,etat) );
        }
        rs.close();
        conn.close();

      
        return List_vente;
    }
 
  public ArrayList getList_bon(java.sql.Date d1,java.sql.Date d2) throws Exception {
         //
         String sql;
      
         sql = "select  distinct(num_bon) AS sa,date_vente,nom_prénom_client,somme_versé,remise,user,idc,Etat FROM Vente   where  date_vente between ? and ?";
       
         
  ArrayList<Vente> List_vente= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
          PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
            System.out.println("date 1="+d1);
            System.out.println("date 2="+d2);
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("sa");
            Date date_vente =rs.getDate("date_vente");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            double somme_versé =rs.getDouble("somme_versé");                          
           double remise =rs.getDouble("remise");
           String user =rs.getString("user");
           int idc =rs.getInt("idc");
       // System.out.println("date vente="+date_vente);
        String Etat =rs.getString("Etat");
          List_vente.add(new Vente(num_bon_réception,date_vente,nom_prénom_client,somme_versé,user,remise,idc,Etat) );
        }
        rs.close();
        conn.close();

      
        return List_vente;
    }
 
 /* public ArrayList getListFactureProforma(java.sql.Date d1,java.sql.Date d2) throws Exception {
         //
         String sql;
      
         sql = "select  distinct(num_bon) AS sa,date_vente,nom_prénom_client,somme_versé,remise,user,idc,Etat FROM Vente   where  date_vente between ? and ?";
       
         
  ArrayList<Vente> List_vente= new ArrayList<>();   
         //  JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
          PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
            ResultSet rs = pr.executeQuery();
            System.out.println("date 1="+d1);
            System.out.println("date 2="+d2);
      while (rs.next()) {      
            int num_bon_réception =rs.getInt("sa");
            Date date_vente =rs.getDate("date_vente");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            double somme_versé =rs.getDouble("somme_versé");                          
           double remise =rs.getDouble("remise");
           String user =rs.getString("user");
           int idc =rs.getInt("idc");
       // System.out.println("date vente="+date_vente);
        String Etat =rs.getString("Etat");
          List_vente.add(new Vente(num_bon_réception,date_vente,nom_prénom_client,somme_versé,user,remise,idc,Etat) );
        }
        rs.close();
        conn.close();

      
        return List_vente;
    }
 */
 
   public ArrayList getListBonLivraison(int choix,String num_bon,String date1,String date2,String client) throws Exception {
         String sql;
         switch(choix){
             case 1:  sql = "select distinct(num_bon_livraison),nom_prénom_client,date_vente FROM Vente where num_bon_livraison=?  order by date_vente desc ";break;
             default: sql = "select distinct(num_bon_livraison),nom_prénom_client,date_vente FROM Vente  where date_vente between ? and ?  and nom_prénom_client = ?  order by date_vente desc ";break;
         }
            ArrayList<Vente> List_vente= new ArrayList<Vente>();   
            Connection conn = jdbc.Getconnection();
      PreparedStatement pr=conn.prepareStatement(sql);
       if(choix==1){
                   pr.setString(1,num_bon);
            // pr.setString(3,date2 );
              // pr.setString(2,date1 );
             }else{
        
             pr.setString(1,date1 );
               pr.setString(2,date2 );
       pr.setString(3,client);}
              
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            int num_bon_livraison =rs.getInt("num_bon_livraison");
            Date date_vente =rs.getDate("date_vente");
            String nom_prénom_client =rs.getString("nom_prénom_client");
                    
          List_vente.add(new Vente(num_bon_livraison,(java.sql.Date)date_vente,nom_prénom_client) );
        }
        rs.close();
        conn.close();
  
        return List_vente;
    }
 
   
   public ArrayList getList_Vente(int num_bon_livr) throws Exception {
   String sql = "select * FROM Vente where num_bon='"+num_bon_livr+"'  order by id_vente desc ";        
   ArrayList<Vente> List_vente= new ArrayList<Vente>();   
           Connection conn = jdbc.Getconnection();
           Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {      
           double remise =rs.getDouble("remise");
            Date date_vente =rs.getDate("date_vente");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            float TVA =rs.getFloat("TVA");
            String désignation =rs.getString("désignation");
            double rendu =rs.getDouble("rendu");
            double prix_vente =rs.getDouble("prix_vente");
             double prix_achat =rs.getDouble("prix_achat");
            float quantité_vente =rs.getFloat("quantité_vente");
          //  float quantité_en_stock =rs.getFloat("quantité_stock");
         // int num_versement_achat =rs.getInt("num_versement");                          
            double somme_versé =rs.getDouble("somme_versé");
            double montantHT =rs.getDouble("montantHT");
            double montantTTC =rs.getDouble("montantTTC");
            int idc =rs.getInt("idc");
        //  String référence=rs.getString("référence");
            String temp_vente=rs.getString("temp_vente");
            String user=rs.getString("user");
          
            int id_produit =rs.getInt("id_produit");
           
            String code=rs.getString("code");
            String etat=rs.getString("etat");
              int id_vente =rs.getInt("id_vente");
          List_vente.add(new Vente( (java.sql.Date)date_vente, 
                  nom_prénom_client, TVA,   désignation,
           
             prix_achat,  prix_vente,  quantité_vente, 
             montantTTC,  montantHT,  temp_vente,  user,
             id_produit, idc,  somme_versé, remise, num_bon_livr,rendu,code,etat,id_vente) );
        }
        rs.close();
        conn.close();
   
        return List_vente;
    }
   
/* public ArrayList getList_Vente(String param,int type,String date1,String date2) throws Exception {
         //
        String sql ;
 
       switch(type){
         //  case 1:sql = "select * FROM Achat where nom_prénom_fournisseur like '%"+param+"%'  ";break;
         //  case 2:sql = "select * FROM Achat where désignation like '%"+param+"%'   ";break;
          //  case 3:sql = "select * FROM Achat where num_bon_réception like '%"+param+"%'  ";break;
            case 4:sql = "select * FROM Vente where   nom_prénom_client like %?% and date_vente BETWEEN ? and ? order by id_vente desc ";break;
           //   case 5:sql = "select * FROM Achat where   désignation like '%"+param+"%' and date_achat BETWEEN '"+date1+"' and '"+date2+"' order by id asc ";break;
                default :sql = "select * FROM Vente where   num_bon_livraison = ? and date_vente BETWEEN ? and ? order by id_vente desc";break;
       }
         
  ArrayList<Vente> List_vente= new ArrayList<Vente>();   
         Connection conn = jdbc.Getconnection();
         PreparedStatement pr=conn.prepareStatement(sql);
             
              
             // if(type==4){
                 //  pr.setString(1,param);
             //  pr.setString(3,date2 );
               // pr.setString(2,date1 );
              //}else{
              if(type==4){
              pr.setString(1,param );}
              else{pr.setInt(1,Integer.valueOf(param) );}
              
               pr.setString(2,date1 );
               pr.setString(3,date2 );
               
           // Statement stmt = conn.createStatement();  
 // sql ="select * FROM Fournisseur where nom_prenom_fournisseur like '%"+param1+"%'  ";           
            ResultSet rs = pr.executeQuery();
      while (rs.next()) {      
            int num_bon_livraison =rs.getInt("num_bon_livraison");
            String date_vente =rs.getString("date_vente");
            String nom_prénom_client =rs.getString("nom_prénom_client");
            float TVA =rs.getFloat("TVA");
            String désignation =rs.getString("désignation");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente =rs.getDouble("prix_vente");
            float quantité =rs.getFloat("quantité_vente");
          double montantTTC =rs.getDouble("montantTTC");
             double montantHT =rs.getDouble("montantHT");
               float quantité_en_stock =rs.getFloat("quantité_stock");
         int num_versement_vente =rs.getInt("num_versement");   
         int id =rs.getInt("id_vente");
             String référence =rs.getString("référence");
         String temp_vente =rs.getString("temp_vente");
          String user =rs.getString("user");
            int id_produit =rs.getInt("id_produit");
          List_vente.add(new Vente(num_bon_livraison,date_vente,nom_prénom_client,TVA ,désignation,prix_achat,prix_vente,quantité,montantTTC,montantHT,quantité_en_stock,num_versement_vente,id,référence,temp_vente,user,id_produit) );
        }
        rs.close();
        conn.close();

      
        return List_vente;
    }   */
   
public boolean  BonLivExist(int num_bon) throws Exception {
        
 boolean a=false;
        try {
             Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
              String sql = "select * FROM vente where num_bon_livraison='"+num_bon+"'";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String t =(rs.getString("user"));
            System.out.println("tttttt="+t);
            if(!t.equals("")&&(t!=null))
            { 
            a=true;
            }
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
          
        }
        //   System.out.println("exist="+a);
        return a; 
    }

 public void AjouterProduit(ArrayList<Produit> ListPr,Produit p,char px,int row){
        float qte=0;
        double prix=0;
    
       if (row==-1){// p.setPrix_donner(0);
           ListPr.add(p);
           switch(px){
               case 'D':prix=p.getPrix_vente_detail();qte=1;break;
               case 'G':prix=p.getPrix_vente_gros();qte=1;break;
               default:prix=p.getPrix_special();qte=1;break;
       }

       ListProduitQuantité.add((float)qte);
        ListVente.add(new Vente(date_vente,f.getNom_prénom_client(),p.getTva(),p.getDésignation(),
           p.getPrix_achat(), prix, 1,0,0,
            new Date(System.currentTimeMillis())+"",
                userName, p.getId_produit(),f.getId_c(), m_verse,remise,num_bon,a_rendu,p.getCode_barre(),"valide"));
         
       }
       else {
       
       if(ListPr.get(row).getNbre_produit_packet()>1 && ListProduitQuantité.get(row)>= ListPr.get(row).getNbre_produit_packet())  
            {
        prix=p.getPrix_vente_packet()/p.getNbre_produit_packet();
        ListVente.get(row).setPrix_vente(prix);
     
            }
          else {
           switch(px){
               case 'D':prix=p.getPrix_vente_detail();break;
               case 'G':prix=p.getPrix_vente_gros();break;
               default:prix=p.getPrix_special();break;
           }
            ListVente.get(row).setPrix_vente(prix);
          }
     try{  qte=ListProduitQuantité.get(row);
        qte=qte+1;               
          
   }catch(Exception e){}      
       ListProduitQuantité.set(row, qte);
       ListVente.get(row).setQuantité_vente(qte);
       TableVente.getModel().setValueAt(qte, row, 3);
       
       }
    
 }

public void AjouterProduitV2(ArrayList<Produit> ListPr,Produit p,char px,int row,List<Float> ListProduitQuantité,Client f,ArrayList<Vente> ListVente,double m_verse,double remise ,int num_bon,double a_rendu){
        float qte=0;
        double prix=0;
    
       if (row==-1){// p.setPrix_donner(0);
           ListPr.add(p);
           switch(px){
               case 'D':prix=p.getPrix_vente_detail();qte=1;break;
               case 'G':prix=p.getPrix_vente_gros();qte=1;break;
               default:prix=p.getPrix_special();qte=1;break;
       }

       ListProduitQuantité.add((float)qte);
        ListVente.add(new Vente(date_vente,f.getNom_prénom_client(),p.getTva(),p.getDésignation(),
           p.getPrix_achat(), prix, 1,0,0,
            new Date(System.currentTimeMillis())+"",
                userName, p.getId_produit(),f.getId_c(), m_verse,remise,num_bon,a_rendu,p.getCode_barre(),"valide"));
         
       }
       else {
       
       if(ListPr.get(row).getNbre_produit_packet()>1 && ListProduitQuantité.get(row)>= ListPr.get(row).getNbre_produit_packet())  
            {
        prix=p.getPrix_vente_packet()/p.getNbre_produit_packet();
        ListVente.get(row).setPrix_vente(prix);
     
            }
          else {
           switch(px){
               case 'D':prix=p.getPrix_vente_detail();break;
               case 'G':prix=p.getPrix_vente_gros();break;
               default:prix=p.getPrix_special();break;
           }
            ListVente.get(row).setPrix_vente(prix);
          }
     try{  qte=ListProduitQuantité.get(row);
        qte=qte+1;               
          
   }catch(Exception e){}      
       ListProduitQuantité.set(row, qte);
       ListVente.get(row).setQuantité_vente(qte);
       TableVente.getModel().setValueAt(qte, row, 3);
       
       }
    
 }  
 public double SommeTTC(ArrayList<Vente> list){
 double total=0;
 for(int i=0;i<list.size();i++)
     total=total+list.get(i).getMontantTTC();
 return total;
 }

  public boolean CodeExist(String code) throws Exception{
    
 boolean a=false;
       
            Connection conn = jdbc.Getconnection();
              String sql = "select * FROM vente where code=?";
               PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1,code);
             
            ResultSet rs =pr.executeQuery();
        while (rs.next()) {
            String code_barre =(rs.getString("code"));
            if(code_barre.equals(code)&&(!code_barre.equals("")))
            {  
            a=true;
            
            }
        }
        rs.close();
        conn.close();
   return a;
   }
  
  
public void displayBonVente(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    tableHeaders.add("N°Bon ");
    tableHeaders.add("Date");
    tableHeaders.add("Client");
    tableHeaders.add("Utilisateur");
    tableHeaders.add("Remise");
    tableHeaders.add("Versement");
    tableHeaders.add("Etat");
   //if(!resultList.isEmpty()){
    for (Object o : resultList) {
        Vente f = (Vente) o;
        oneRow = new Vector<Object>();
        oneRow.add(f.getNum_bon());
        oneRow.add(f.getDate_vente());
        oneRow.add(f.getNom_prénom_client());
        oneRow.add(f.getUser());
      
        oneRow.add(tnb.Afficher2Verguile(f.getRemise()));
        oneRow.add(tnb.Afficher2Verguile(f.getSomme_versé()));
        oneRow.add(f.getEtat());
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
  
public ArrayList getList_produit(int num_bon) throws Exception {
        
String sql = "select * FROM Vente,produit where vente.num_bon='"+num_bon+"' and vente.id_produit=produit.id_produit order by id_vente desc ";
ArrayList<Produit> List_pro= new ArrayList<>();   
Connection conn = jdbc.Getconnection();
Statement stmt = conn.createStatement();           
ResultSet rs = stmt.executeQuery(sql);
while (rs.next()) {      
java.sql.Date date_vente =rs.getDate("date_vente");
String désignation =rs.getString("désignation");
double prix_achat =rs.getDouble("prix_achat");
double prix_v_detail =rs.getDouble("prix_vente_detail");

double prix_v_gros =rs.getDouble("prix_vente_gros");
double prix_v_special =rs.getDouble("prix_special");

float quantité =rs.getFloat("quantité");
int id_produit =rs.getInt("id_produit");
 //  double remise=rs.getDouble("remise");
// System.out.println("qte vente="+quantité);
List_pro.add(new Produit(désignation,prix_achat,prix_v_detail,prix_v_gros,prix_v_special,quantité,id_produit,date_vente) );
        }
rs.close();
conn.close();
return List_pro;
    }  
}
