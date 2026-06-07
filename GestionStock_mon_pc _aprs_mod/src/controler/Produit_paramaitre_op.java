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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Produit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableCellRenderer;
import model.CodeBarre;
import model.Produit_paramaitre;

/**
 *
 * @author Rais
 */
public class Produit_paramaitre_op {
private static Produit_paramaitre_op instance;   
public Produit_paramaitre_op(){}
public static Produit_paramaitre_op getInstance(){
if(instance==null){
    instance=new Produit_paramaitre_op();
}
return instance;
}    
    
 JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();
//Connection conn;
//Statement stmt;

static Vector<Object> oneRow;
ImageIcon   img = new ImageIcon("Images/erreur.GIF");
//ImageIcon icon = new ImageIcon("Images/gs.png");
static TextNumber tn= TextNumber.getObj();
static CodeBarre_op op8=new CodeBarre_op();
 public List<CodeBarre> lBareCode=new ArrayList<>();
  
  public static void displayResult(List resultList,JTable jTable1,int [] tab1,JLabel l1,int nbrePr) throws Exception {
      String [] tab2={"Désignation","Code barre","Famille","Unite","Marque","Etagére","Remarque","Prix achat","Prix vente détail","Prix vente gros","Prix spécial","Qte Stock","Stock en alérte",
          
          "Jour Alért","TVA","Date péremption","Date achat","Taille","Pointure","Couleur",
          "Saisie par","nbre_produit_packet","prix_vente_packet","Code barre packet"};
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table


    Vector tableData = new Vector(); // récupérer les données ligne par ligne
    for(int i=0;i<tab1.length;i++){
if(tab1[i]==1)tableHeaders.add(tab2[i]);
}
  
    
    for (Object o : resultList) {
        Produit p = (Produit) o;
         oneRow = new Vector<Object>();
         

      //  oneRow.add(p.getCategorie_produit());
       // oneRow.add(p.getEtat());
       // oneRow.add(p.getDésignation());
       if(tab1[0]==1)  oneRow.add(p.getDésignation());
       try {
             if(tab1[1]==1) {
            if(op8.GetListCode(p.getId_produit()).isEmpty())
                oneRow.add("");
            else  oneRow.add(op8.GetListCode1(p.getId_produit()));
             }
        } catch (Exception ex) {
            Logger.getLogger(Produit_paramaitre_op.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
       if(tab1[2]==1)  oneRow.add(p.getFamille());
       if(tab1[3]==1)  oneRow.add(p.getUnite());
       if(tab1[4]==1)  oneRow.add(p.getMarque());
       if(tab1[5]==1)  oneRow.add(p.getÉtagére());
       if(tab1[6]==1)  oneRow.add(p.getRemarque());
       if(tab1[7]==1)   oneRow.add(tn.Afficher2Verguile(p.getPrix_achat()));
       if(tab1[8]==1) oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_detail()));
       if(tab1[9]==1)  oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_gros()));
       if(tab1[10]==1)  oneRow.add(tn.Afficher2Verguile(p.getPrix_special()));
       if(tab1[11]==1)  oneRow.add(p.getQuantité());
       if(tab1[12]==1)   oneRow.add(p.getStock_alert());
       if(tab1[13]==1)   oneRow.add(p.getJour_alert());
   
       if(tab1[14]==1)   oneRow.add(p.getTva());
       if(tab1[15]==1)   oneRow.add(p.getDate_premption());
     //  System.out.println("designation="+p.getDésignation()+"     date="+p.getDate_premption());
       if(tab1[16]==1)   oneRow.add(p.getDate_achat());
       if(tab1[17]==1)   oneRow.add(p.getTaille());
       if(tab1[18]==1)   oneRow.add(p.getPointure());
       if(tab1[19]==1)   oneRow.add(p.getCouleur());
       if(tab1[20]==1)   oneRow.add(p.getSaisie_par());
       
       if(tab1[21]==1)   oneRow.add(p.getNbre_produit_packet());
       if(tab1[22]==1)   oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_packet()));
        if(tab1[23]==1)   oneRow.add(p.getCode_bare_packet());
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


 /* DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
jTable1.setDefaultRenderer(String.class, centerRenderer);
*/
   DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
 for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
renderer.setHorizontalAlignment(0);

//jTable1.setAutoCreateRowSorter(true);

l1.setText("Total  de Produits="+nbrePr);
}
  
  
  
  
 
 
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

 public void modifier_Paramaitre_Produit(int famille, int unite, int marque, int désignation, int étagére, int code_barre,
            int remarque, int saisie_par, int prix_achat, int prix_vente_detail, int prix_vente_gros,
            int prix_special, int quantité, int stock_alert, int jour_alert,
            int tva, int date_achat, int taille, int pointure, int couleur, int date_premption,int nbre_produit_packet,int prix_vente_packet,int code_bare_packet) throws Exception {
        
        try {
             Connection conn = jdbc.Getconnection();
          
               String sql1 = "UPDATE produit_paramaitre set famille=?,  unite=?,  marque=?,désignation=?,\n" +
"               étagére=?,  code_barre=?,  remarque=?, saisie_par=?,\n" +
"               prix_achat=?,  prix_vente_detail=?,  prix_vente_gros=?, \n" +
"             prix_special=?,  quantité=?,  stock_alert=?,  jour_alert=?,\n" +
"             quantité_promotion=?,  tva=?,  date_achat=? ,taille=?,pointure=?,couleur=?,date_premption=?,"
                       + "nbre_produit_packet=?,prix_vente_packet=?,code_bare_packet=?";
             //ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
               pr.setInt(1,famille);
               pr.setInt(2,unite);
               pr.setInt(3,marque);
               pr.setInt(4,désignation);
               pr.setInt(5,étagére);
               pr.setInt(6,code_barre );
               pr.setInt(7, remarque);
               pr.setInt(8,saisie_par);
               pr.setInt(9, prix_achat);
               pr.setInt(10, prix_vente_detail);
               pr.setInt(11,  prix_vente_gros);
               pr.setInt(12, prix_special);
             
               pr.setInt(13, quantité);
               pr.setInt(14, stock_alert);
               pr.setInt(15, jour_alert);
             
               pr.setInt(16, tva);
               pr.setInt(17, date_achat);
               pr.setInt(18,  taille);
               pr.setInt(19,  pointure);
               pr.setInt(20,  couleur);
               pr.setInt(21,  date_premption);
               pr.setInt(22,  nbre_produit_packet);
               pr.setInt(23,  prix_vente_packet);
                pr.setInt(24,  code_bare_packet);
              // pr.setString(14,référence);
               
               
               pr.executeUpdate();
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
         //  sc.printStackTrace();
        }
       
    }  
 
public void modifier_Paramaitre_Produit2(Produit_paramaitre p) throws Exception {
        
        try {
            Connection conn = jdbc.Getconnection();
               String sql1 = "UPDATE produit_paramaitre set famille=?,  unite=?,  marque=?,désignation=?,\n" +
"               étagére=?,  code_barre=?,  remarque=?, saisie_par=?,\n" +
"               prix_achat=?,  prix_vente_detail=?,  prix_vente_gros=?, \n" +
"             prix_special=?,  quantité=?,  stock_alert=?,  jour_alert=?,\n" +
"               tva=?,  date_achat=? ,taille=?,pointure=?,couleur=?,date_premption=?,"
                       + "nbre_produit_packet=?,prix_vente_packet=?,code_bare_packet=?";
             //ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
               pr.setInt(1,p.getFamille());
               pr.setInt(2,p.getUnite());
               pr.setInt(3,p.getMarque());
               pr.setInt(4,p.getDésignation());
               pr.setInt(5,p.getÉtagére());
               pr.setInt(6,p.getCode_barre() );
               pr.setInt(7, p.getRemarque());
               pr.setInt(8,p.getSaisie_par());
               pr.setInt(9, p.getPrix_achat());
               pr.setInt(10, p.getPrix_vente_detail());
               pr.setInt(11,  p.getPrix_vente_gros());
               pr.setInt(12, p.getPrix_special());
             
               pr.setInt(13, p.getQuantité());
               pr.setInt(14, p.getStock_alert());
               pr.setInt(15, p.getJour_alert());
             
               pr.setInt(16, p.getTva());
               pr.setInt(17, p.getDate_achat());
               pr.setInt(18,  p.getTaille());
               pr.setInt(19,  p.getPointure());
               pr.setInt(20,  p.getCouleur());
               pr.setInt(21,  p.getDate_premption());
               pr.setInt(22,  p.getNbre_produit_packet());
               pr.setInt(23,  p.getPrix_vente_packet());
                 pr.setInt(24,  p.getCode_bare_packet());
              // pr.setString(14,référence);
               
               
               pr.executeUpdate();
         
        pr.close(); 
       
        conn.close();
 JOptionPane.showMessageDialog(null, " Bien Modifier ","",JOptionPane.INFORMATION_MESSAGE);
        } 
        
        catch (Exception sc) {
     JOptionPane.showMessageDialog(null, sc.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE,img);
         //  sc.printStackTrace();
        }
       
    }  
    public Produit_paramaitre getparamaitre_Produit1() throws Exception {
         //
          String sql ="";
  Produit_paramaitre pp= null;
        try {


             Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
  sql  = "select * FROM Produit_paramaitre";       
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
            int désignation =rs.getInt("désignation");
            int code_barre =rs.getInt("code_barre");
            int famille =rs.getInt("famille");
            int unite =rs.getInt("unite");
            int marque =rs.getInt("marque"); 
            int étagére =rs.getInt("étagére");
            int remarque =rs.getInt("remarque");
           //  String id_fournisseur =rs.getString("id_fournisseur");
           // String date_premption =rs.getString("date_premption");
            int prix_achat =rs.getInt("prix_achat");
            int prix_vente_detail =rs.getInt("prix_vente_detail");
            int prix_vente_gros =rs.getInt("prix_vente_gros");
            int prix_special =rs.getInt("prix_special");
            int quantité =rs.getInt("quantité");
            int stock_alert=rs.getInt("stock_alert");
            int jour_alert=rs.getInt("jour_alert");
           
            int tva=rs.getInt("tva");
            int date_premption =rs.getInt("date_premption");
            int date_achat =rs.getInt("date_achat");
            int taille =rs.getInt("taille");
            int pointure =rs.getInt("pointure");
            int couleur =rs.getInt("couleur");
            int saisie_par =rs.getInt("saisie_par");
            
             int nbre_produit_packet =rs.getInt("nbre_produit_packet");
              int prix_vente_packet =rs.getInt("prix_vente_packet");
                int code_bare_packet =rs.getInt("code_bare_packet");
           pp=new Produit_paramaitre( famille,  unite,  marque,  désignation, étagére,  code_barre,
             remarque,  saisie_par, prix_achat,  prix_vente_detail,  prix_vente_gros,
             prix_special,  quantité,  stock_alert,  jour_alert,
             tva,  date_achat,  taille, pointure,  couleur,  date_premption,nbre_produit_packet,prix_vente_packet,code_bare_packet);
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
         
        }
        return pp;
    }
    
     public int []  getparamaitre_Produit2() throws Exception {
         //
          String sql ="";
 int [] tab=new int[25];
        try {


            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
  sql  = "select * FROM Produit_paramaitre";       
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
            int désignation =rs.getInt("désignation");
            tab[0]=désignation;
            
            int code_barre =rs.getInt("code_barre");
            tab[1]=code_barre;
            
            int famille =rs.getInt("famille");
            tab[2]=famille;
            
            int unite =rs.getInt("unite");
            tab[3]=unite;
            
            int marque =rs.getInt("marque");
            tab[4]=marque;
          
            int étagére =rs.getInt("étagére");
            tab[5]=étagére;
            
            int remarque =rs.getInt("remarque");
           tab[6]=remarque;
          
            int prix_achat =rs.getInt("prix_achat");
            tab[7]=prix_achat;
            
            int prix_vente_detail =rs.getInt("prix_vente_detail");
            tab[8]=prix_vente_detail;
            
            int prix_vente_gros =rs.getInt("prix_vente_gros");
            tab[9]=prix_vente_gros;
            
            int prix_special =rs.getInt("prix_special");
            tab[10]=prix_special;
            
            int quantité =rs.getInt("quantité");
            tab[11]=quantité;
           
            int stock_alert=rs.getInt("stock_alert");
            tab[12]=stock_alert;
            
            int jour_alert=rs.getInt("jour_alert");
            tab[13]=jour_alert;
            
         
            int tva=rs.getInt("tva");
            tab[14]=tva;
    
            int date_premption =rs.getInt("date_premption");
            tab[15]=date_premption;
            
            int date_achat =rs.getInt("date_achat");
            tab[16]=date_achat;
            
            int taille =rs.getInt("taille");
            tab[17]=taille;
            
            int pointure =rs.getInt("pointure");
            tab[18]=pointure;
            
            int couleur =rs.getInt("couleur");
            tab[19]=couleur;
            
            int saisie_par =rs.getInt("saisie_par");
            tab[20]=saisie_par;
            
              int nbre_produit_packet =rs.getInt("nbre_produit_packet");
            tab[21]=nbre_produit_packet;
            
              int prix_vente_packet =rs.getInt("prix_vente_packet");
            tab[22]=prix_vente_packet;
                    
            int code_bare_packet =rs.getInt("code_bare_packet");
            tab[23]=code_bare_packet;
            
            
         
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
         
        }
        return tab;
    }
 

  







}
