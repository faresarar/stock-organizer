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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Mouvement;
/**
 *
 * @author hicham
 */
public class Mouvement_op {
Vector<Object> oneRow;
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
TextNumber tn= TextNumber.getObj();
private static Mouvement_op instance;   
public Mouvement_op(){}
public static Mouvement_op getInstance(){
if(instance==null){
    instance=new Mouvement_op();
}
return instance;
}     

public void displayResult(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    tableHeaders.add("Date");
    tableHeaders.add("Type");
    tableHeaders.add("Tiers");
    tableHeaders.add("Qte Entrée");
    tableHeaders.add("Prix achat");
    tableHeaders.add("Valeur Entrée");
    tableHeaders.add("Qte Sortie");
    tableHeaders.add("Prix Vente");
    tableHeaders.add("Valeur Sortie");
  
  
    
    for (Object o : resultList) {
      
        Mouvement p = (Mouvement) o;
        oneRow = new Vector<Object>();
      
       // oneRow.add(i);
        oneRow.add(p.getDate());
        oneRow.add(p.getType());
        oneRow.add(p.getTiers());
        oneRow.add(p.getQte_e());
        oneRow.add(tn.Afficher2Verguile(p.getPrix_achat()));
        oneRow.add(tn.Afficher2Verguile(p.getPrix_achat()*p.getQte_e()));
        oneRow.add(p.getQte_s());
        oneRow.add(p.getPrix_vente());
         oneRow.add(tn.Afficher2Verguile(p.getPrix_vente()*p.getQte_s()));
        
       
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


public ArrayList GetListIMouvementAchat(java.sql.Date d1,java.sql.Date d2,int id,String type) throws Exception{
    ArrayList<Mouvement> List_inv= new ArrayList<>();   
   Connection conn = jdbc.Getconnection();
      String    sql = "select date_achat,prix_achat,date_achat,quantité,nom_prénom_fournisseur FROM achat where  date_achat  between ?  and ? and id_produit=?";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
           pr.setInt(3, id);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {       Date date_achat =rs.getDate("date_achat");
            
           double prix_achat=rs.getDouble("prix_achat");
          
           float quantité =rs.getFloat("quantité");
           
          // double prix_vente=rs.getDouble("prix_vente");
           //Date date_vente =rs.getDate("date_vente");
           //float quantité_vente =rs.getFloat("quantité_vente");
           String nom_prénom_fournisseur=rs.getString("nom_prénom_fournisseur");
          // String nom_prénom_client=rs.getString("nom_prénom_client");
           
         
       //  int id_produit =rs.getInt("id_produit");
          List_inv.add(new Mouvement( date_achat,  type,  nom_prénom_fournisseur,  quantité,  0,  prix_achat,  0) );
        }
        rs.close();
        conn.close();

    //  System.out.println("List_achat size="+List_inv.size());
        return List_inv;
}  

public ArrayList GetListIMouvementVente(java.sql.Date d1,java.sql.Date d2,int id,String type) throws Exception{
    ArrayList<Mouvement> List_inv= new ArrayList<>();   
   Connection conn = jdbc.Getconnection();
      String    sql = "select date_vente,quantité_vente,date_vente,prix_vente,nom_prénom_client FROM vente where date_vente between ?  and ? and id_produit=?";
            PreparedStatement pr=conn.prepareStatement(sql);
           pr.setDate(1, d1);
           pr.setDate(2, d2);
           pr.setInt(3, id);
            ResultSet rs = pr.executeQuery();
        while (rs.next()) {      
        //   double prix_achat=rs.getDouble("prix_achat");
        //   Date date_achat =rs.getDate("date_achat");
        //   float quantité =rs.getFloat("quantité");
           
           double prix_vente=rs.getDouble("prix_vente");
           Date date_vente =rs.getDate("date_vente");
           float quantité_vente =rs.getFloat("quantité_vente");
         //  String nom_prénom_fournisseur=rs.getString("nom_prénom_fournisseur");
           String nom_prénom_client=rs.getString("nom_prénom_client");
           
         
       //  int id_produit =rs.getInt("id_produit");
          List_inv.add(new Mouvement( date_vente,  type,  nom_prénom_client,  0,  quantité_vente,  0,  prix_vente) );
        }
        rs.close();
        conn.close();

       //  System.out.println("List_vente size="+List_inv.size());
        return List_inv;
}  
  public  float GetTotalEntréé(ArrayList<Mouvement> resultList){
    float t=0;
    for(int i=0;i<resultList.size();i++)t=t+resultList.get(i).getQte_e();
    return t;
    }
   public  float GetTotalSortie(ArrayList<Mouvement> resultList){
    float t=0;
    for(int i=0;i<resultList.size();i++)t=t+resultList.get(i).getQte_s();
    return t;
    }
}
