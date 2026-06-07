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
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Produit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.Date;
import java.util.HashSet;

import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import model.CodeBarre;

/**
 *
 * @author Rais
 */
public class Produit_op {
private static Produit_op instance;   
public Produit_op(){}
public static Produit_op getInstance(){
if(instance==null){
    instance=new Produit_op();
}
return instance;
}
//JdbcClass j=new JdbcClass();
//Connection conn;ic
//Statement stmt;
JdbcClassSingleton jdbc= JdbcClassSingleton.getInstance();

Vector<Object> oneRow;
//ImageIcon   img = new ImageIcon("Images/erreur.GIF");
//ImageIcon icon = new ImageIcon("Images/gs.png");
//ImageIcon   img1 = new ImageIcon("Images/good.png");
TextNumber tn= TextNumber.getObj();
 long millis=System.currentTimeMillis(); 
 java.sql.Date date = new java.sql.Date(millis);  
CodeBarre_op op8= CodeBarre_op.getInstance();
 public List<CodeBarre> lBareCode=new ArrayList<>();
 public void LoadImg(String img_label,JLabel jLabelImg ){
    try{    if((img_label.equals("")))jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images(2).png"))); 
           else jLabelImg.setIcon(resize(img_label));
      // System.out.println("prod.getImage="+prod.getImage());
       }catch(Exception e){
        
        jLabelImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images(2).png"))); 
       }
 
 }
 public ImageIcon resize(String imgPath)
  {
    ImageIcon path = new ImageIcon(imgPath);
    Image img = path.getImage();
    Image newImg = img.getScaledInstance(198, 166, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
  }
public boolean  ProduitExist(String désignation) throws Exception {
     try {
 // conn = j.connect();
   // stmt = conn.createStatement();
  } catch (Exception sc) {}

         ImageIcon   img = new ImageIcon("Images/erreur.GIF");
      
 boolean a=false;
        try {
           /// JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            //Statement stmt = conn.createStatement();
              String sql = "select * FROM produit where désignation=?";

           PreparedStatement pr=conn.prepareStatement(sql);
           pr.setString(1,désignation);
              ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            String wadifa =(rs.getString("référence"));
            if(wadifa.equals(désignation)&&(!désignation.equals(" ")))
            {  JOptionPane.showMessageDialog(null, "  produit existe deja  ", " ", JOptionPane.WARNING_MESSAGE, img);
            a=true;
            }
        }
        rs.close();
        conn.close();
        pr.close();
        } catch (Exception sc) {
             JOptionPane.showMessageDialog(null, sc.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE,img);
            throw new Exception(sc.getMessage(), sc);
        }
        return a;
    }


public  void inserer_produit(String famille, String unite, String marque, String image, String référence,
            String désignation, String étagére, int id_f, String remarque,
             double prix_achat, double prix_vente_detail, double prix_vente_gros, 
            double prix_special, float quantité, int stock_alert, int jour_alert,
            float tva, String date_premption,
            Date date_achat,String taille,String pointure,String couleur,String saisie_par,
            String code_bare_packet,double prix_vente_packet,int nbre_produit_packet,boolean vente_packet)throws Exception{
        try {
         //  JdbcClass jAA=new JdbcClass();
            //  Statement stmt = conn.createStatement();
            // String sql = "insert into produit (categorie_produit,categorie_piece,etat,marque,numero_serie,référence,désignation,étagére,code_barre,remarque,prix_achat,prix_vente,quantité) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            // ResultSet rs = stmt.executeQuery(sql);
              Connection conn = jdbc.Getconnection();
                //  Statement stmt = conn.createStatement();
                // String sql = "insert into produit (categorie_produit,categorie_piece,etat,marque,numero_serie,référence,désignation,étagére,code_barre,remarque,prix_achat,prix_vente,quantité) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
                // ResultSet rs = stmt.executeQuery(sql);
                

String sql="insert into produit (famille,  unite,  marque,  image,  référence,\n" +
"             désignation,  étagére,  id_f,  remarque,\n" +
"              prix_achat,  prix_vente_detail,  prix_vente_gros, \n" +
"             prix_special,  quantité,  stock_alert,  jour_alert,\n" +
"               tva, date_premption,  date_achat,taille,pointure,couleur,saisie_par, code_bare_packet, prix_vente_packet, nbre_produit_packet, vente_packet) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";   
                // String sql ="insert into gestion.produit (categorie_produit,categorie_piece,etat,marque,numero_serie,référence,désignation,étagére,code_barre,remarque,prix_achat,prix_vente,quantité) values ('kkk','kkk','kkk','kkk','kkk','kkk','kkk','kkk','kkk','kkk',84449,44488,4449)";
               try (PreparedStatement pr = conn.prepareStatement(sql)) {
               pr.setString(1,famille);
               pr.setString(2,unite);
               pr.setString(3,marque);
               pr.setString(4,image);
               pr.setString(5,référence);
               pr.setString(6,désignation );
               pr.setString(7, étagére);
              
               pr.setInt(8, id_f);
               pr.setString(9, remarque);
              
               pr.setDouble(10, prix_achat);
               pr.setDouble(11, prix_vente_detail);
               pr.setDouble(12, prix_vente_gros);
               pr.setDouble(13, prix_special);
               pr.setFloat(14, quantité);
               //pr.setInt(17, id_produit);
               
               pr.setInt(15, stock_alert);
               pr.setInt(16, jour_alert);
             
               pr.setFloat(17, tva);
            //   System.out.println("18");
             
               pr.setString(18,  date_premption);
               pr.setDate(19,  date_achat);
               pr.setString(20,  taille);
               pr.setString(21,  pointure);
               pr.setString(22,  couleur);
               pr.setString(23,  saisie_par);
               
                 pr.setString(24,  code_bare_packet);
                 pr.setDouble(25,  prix_vente_packet);
                 pr.setInt(26,  nbre_produit_packet);
                 pr.setBoolean(27,  vente_packet);
              
                    // System.out.println("24");
               pr.executeUpdate();
               
                   //    JOptionPane.showMessageDialog(null, " Bien inserer ","",JOptionPane.INFORMATION_MESSAGE,img1);
                       pr.close();
                  //   System.out.println("udpate");
               }
              conn.close();
              
          
        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, sc.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE,null);
           // System.out.println(sc.getMessage());
        }
        
   }
public String GetNextReferenceProduit() throws Exception{
    String ref="P";
    int max=0;
 //JdbcClass j=new JdbcClass();
            Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select Max(id_produit)  as maxrow from produit ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            max =(rs.getInt("maxrow"));}
           //  System.out.println("max="+max);
       //    if(max==0){ref=ref+1+"";}else{
            ref="P"+(max+1)+"";
           //  System.out.println("ref="+ref);
      //  }
conn.close();
rs.close();
return ref;
}


public  void Charger_marque( JComboBox marques ){ 
     // ArrayList<String> ListUsers= new ArrayList<String>();
   DefaultListCellRenderer centr = new DefaultListCellRenderer();
 centr.setHorizontalAlignment(JLabel.CENTER);
marques.setRenderer(centr);
marques.removeAllItems();
//JdbcClass m=new JdbcClass();
 try {
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql;
            // switch(cas){
                  sql = "SELECT * FROM marque  order by valeur asc";
                 
             //}
            ResultSet rs = stmt.executeQuery(sql);
           
        while (rs.next()) {
             marques.addItem(rs.getString("valeur") );
        }
        rs.close();
        conn.close();    
           
        } catch(Exception e){}
   
   }


  public  void sup_Marque(String  marque)throws Exception{

        try {
        // JdbcClass j=new JdbcClass();
            //Connection conn = j.connect();
              Connection conn = jdbc.Getconnection();
              String sql = "delete  from marque where valeur=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, marque);
              pr.executeUpdate();
            //ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
  public void displayResult(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table

  

    Vector tableData = new Vector(); // récupérer les données ligne par ligne
  //   tableHeaders.add("Categorie_produit");
    //tableHeaders.add("Etat");
    //tableHeaders.add("Marque");
     tableHeaders.add("Désignation");
      tableHeaders.add("Famille ");
    //tableHeaders.add("Date d'achat");
   
    tableHeaders.add(" prix vente detail");
     tableHeaders.add(" prix vente gros");
    // tableHeaders.add("catégorie de la piece ");
      tableHeaders.add(" prix vente spécial");
       //tableHeaders.add("Code bare ");
        tableHeaders.add("QTE Stock ");
         tableHeaders.add("QTE alérte ");
        
          tableHeaders.add("Code barre");
          tableHeaders.add("Date péremption");
          tableHeaders.add("Saisie par");
  
    
    for (Object o : resultList) {
        Produit p = (Produit) o;
         oneRow = new Vector<Object>();
      
      //  oneRow.add(p.getCategorie_produit());
       // oneRow.add(p.getEtat());
       // oneRow.add(p.getDésignation());
         oneRow.add(p.getDésignation());
       oneRow.add(p.getFamille());
     // System.out.println("prix achat="+tn.Afficher2Verguile(p.getPrix_achat()));
       //  oneRow.add(tn.Afficher2Verguile(p.getPrix_achat()));
        oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_detail()));
         oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_gros()));
          oneRow.add(tn.Afficher2Verguile(p.getPrix_special()));
         // oneRow.add(p.getCategorie_piece());
     //   oneRow.add(p.getNumero_serie());gros
    //    oneRow.add(p.getCode_barre());
         oneRow.add(p.getQuantité());
       // oneRow.add(tn.Afficher2Verguile(p.getTva()));
        oneRow.add(p.getStock_alert());
        try {
            if(op8.GetListCode(p.getId_produit()).isEmpty())
                oneRow.add("");
            else  oneRow.add(op8.GetListCode(p.getId_produit()));
        } catch (Exception ex) {
            Logger.getLogger(Produit_op.class.getName()).log(Level.SEVERE, null, ex);
        }
          oneRow.add(p.getDate_premption());
          oneRow.add(p.getSaisie_par());
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
      if(column==1 ||column==2 ||column==3 ||column==5 )
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
  
   public void displayResult2(List resultList,JTable jTable1) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table

  

    Vector tableData = new Vector(); // récupérer les données ligne par ligne
  
     tableHeaders.add("Désignation");
    tableHeaders.add(" Prix vente detail");
     tableHeaders.add("Prix vente gros");
      tableHeaders.add("Prix vente Spécial");
     tableHeaders.add("Prix d'achat");
     tableHeaders.add("QTE Stock ");
     
    
    for (Object o : resultList) {
        Produit p = (Produit) o;
         oneRow = new Vector<Object>();
         oneRow.add(p.getDésignation());
         oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_detail()));
         oneRow.add(tn.Afficher2Verguile(p.getPrix_vente_gros()));
         oneRow.add(tn.Afficher2Verguile(p.getPrix_special()));
         oneRow.add(tn.Afficher2Verguile(p.getPrix_achat()));
         oneRow.add(p.getQuantité());
         
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
   
   
    public void displayResult3(List resultList,JTable jTable1,char prix,List Quantité) throws Exception {
    Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
    ListIterator li = Quantité.listIterator();
    
double px=0;
  
int i=0;
    Vector tableData = new Vector(); // récupérer les données ligne par ligne
     tableHeaders.add("Num");
     tableHeaders.add("Désignation");
    tableHeaders.add("Prix U");
     tableHeaders.add("Quantité");
     tableHeaders.add("Montant ");
     
    
    for (Object o : resultList) {
        i=i+1;
        Produit p = (Produit) o;
         oneRow = new Vector<Object>();
         oneRow.add(i);
         oneRow.add(p.getDésignation());
         if(prix=='D')
             px=p.getPrix_vente_detail();
         else if(prix=='G')  px=p.getPrix_vente_gros();
         else px=p.getPrix_special();
         oneRow.add(tn.Afficher2Verguile(px));
     float q=(float) li.next();
      
         oneRow.add(q);
         oneRow.add(tn.Afficher2Verguile(px*q));
         
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
   
}
  public void displayResult4(List<Produit>resultList,JTable jTable1,char prix,List Quantité) throws Exception {
    DefaultTableModel model = new DefaultTableModel(0,6);
    int i=0;
    // Vector tableData = new Vector();
   //  Vector<String> tableHeaders = new Vector<String>();
      
    ListIterator li = Quantité.listIterator();
    float q=0;
   double px=0;
    ImageIcon icon = new ImageIcon("Images/icons8-poubelle-31.png");
   
    
    for (i=0;i<resultList.size();i++) {
   if(li.hasNext())   q=(float) li.next();
     
            if(resultList.get(i).getNbre_produit_packet()>1 && q>= resultList.get(i).getNbre_produit_packet())
           
            {
                   px=resultList.get(i).getPrix_vente_packet()/resultList.get(i).getNbre_produit_packet();
            }
       else if(prix=='D')
             px=resultList.get(i).getPrix_vente_detail();
              else if(prix=='G') px=resultList.get(i).getPrix_vente_gros();
              else px=resultList.get(i).getPrix_special();
         //  if(li.hasNext())   q=(float) li.next();
           
       model.addRow(new Object[]{i+1,resultList.get(i).getDésignation(),tn.Afficher2Verguile(px),q,tn.Afficher2Verguile(px*q),icon});
        
    }
   
           
       jTable1.setModel(model);
     

    

jTable1.getColumnModel().getColumn(5).setCellRenderer(new ButtonCell2(Quantité,resultList,prix,jTable1));
     jTable1.getColumnModel().getColumn(5).setCellEditor(new ButtonCell2(Quantité,resultList,prix,jTable1));
      jTable1.getColumnModel().getColumn(0).setMinWidth(5);     
       jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
       
       jTable1.getColumnModel().getColumn(1).setMinWidth(190);     
       jTable1.getColumnModel().getColumn(1).setPreferredWidth(190);
       
       jTable1.getColumnModel().getColumn(5).setMinWidth(15);     
       jTable1.getColumnModel().getColumn(5).setPreferredWidth(15);
        //  jTable1.getColumnModel().getColumn(6).setMaxWidth(82);
         jTable1.setRowHeight(30);
        
   jTable1.getColumnModel().getColumn(0).setHeaderValue("Num");
   jTable1.getColumnModel().getColumn(1).setHeaderValue("Désignation");
   jTable1.getColumnModel().getColumn(2).setHeaderValue("Prix U");
   jTable1.getColumnModel().getColumn(3).setHeaderValue("Quantité");
   jTable1.getColumnModel().getColumn(4).setHeaderValue("Montant");
   jTable1.getColumnModel().getColumn(5).setHeaderValue("Supprimer");     
 
    JTableHeader tableHeader = jTable1.getTableHeader();
    tableHeader.setBackground(Color.BLACK);
    tableHeader.setForeground(Color.black);
    Font headerFont = new Font("Verdana", Font.PLAIN, 14);
    tableHeader.setFont(headerFont);
         
 //jTable1.setModel(new DefaultTableModel(tableData, tableHeaders)) 
 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment( JLabel.CENTER );
 for (int columnIndex = 0; columnIndex < jTable1.getColumnCount()-1; columnIndex++)
        {
            jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
        }

DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
renderer.setHorizontalAlignment(0);
//jTable1.setAutoCreateRowSorter(true); 
 
   // Collections.sort(resultList,new VersementComparator());
   
  /* 
   jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

       
        if (row==0) {
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
        } else {
            setBackground(table.getBackground());
            setForeground(table.getForeground());
        }       
        return this;
    }   
});*/
}
   
  public void DisplayCodeBarre(List<CodeBarre> ListCodeBarre,JTable jTable1) {
    
  //  Vector<String> tableHeaders = new Vector<String>(); // construite l’entête de la table
lBareCode=ListCodeBarre;
// ButtonCell btc1=new ButtonCell(,lBareCode,jTable1);
  

   // Vector tableData = new Vector(); // récupérer les données ligne par ligne
  //   tableHeaders.add("Categorie_produit");
    //tableHeaders.add("Etat");
    //tableHeaders.add("Marque");
  
          
       DefaultTableModel model = new DefaultTableModel(0,2);
     //  model.addColumn("Code Barre");
    //  tableHeaders.add("Code Barre");
    // tableHeaders.add("Supprimer ");
  
    //tableHeaders.add("Date d'achat");
   
    ImageIcon icon = new ImageIcon("Images/icons8-poubelle-31.png");
        
    int size=ListCodeBarre.size();
   if(size>0){
       for (int i=0;i<size;i++)
       model.addRow(new Object[]{icon,lBareCode.get(i).getCode()});
   
             }
       //  oneRow = new Vector<Object>();
      
   //  oneRow.add(ListCodeBarre.get(i));
       // oneRow.add("del");
       //System.out.println("valeur de code="+ListCodeBarre.get(i));
             // tableData.add(oneRow);
  
    

// oneRow.addMouseClicked
jTable1.setModel(model);
//jTable1.setModel(new DefaultTableModel(tableData, tableHeaders));

jTable1.getColumnModel().getColumn(0).setCellRenderer(new ButtonCell(lBareCode,jTable1));
     jTable1.getColumnModel().getColumn(0).setCellEditor(new ButtonCell(lBareCode,jTable1));
      jTable1.getColumnModel().getColumn(0).setMinWidth(82);
           jTable1.getColumnModel().getColumn(0).setPreferredWidth(82);
          jTable1.getColumnModel().getColumn(0).setMaxWidth(82);
         jTable1.setRowHeight(32);
          jTable1.getColumnModel().getColumn(0).setHeaderValue("Supprimer");
   jTable1.getColumnModel().getColumn(1).setHeaderValue("Code Barre");
    JTableHeader tableHeader = jTable1.getTableHeader();
      tableHeader.setBackground(Color.blue);
     tableHeader.setForeground(Color.blue);
    
 
          
   
}
  
 public ArrayList getList_Produit(String param1,String param2,String param3) throws Exception {
         //
        
          String sql ="";
  ArrayList<Produit> List_produit= new ArrayList<Produit>();
        try {


           // JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
            
            switch(param1){
               
                case "Code_barre":sql = "select DISTINCT * FROM Produit,codebarre where Produit.id_produit=codebarre.id_produit and codebarre.code like '%"+param2+"%' order by '"+param3+"' asc ";break;
                case "Famille":sql = "select DISTINCT * FROM Produit where famille like '%"+param2+"%' order by '"+param3+"' asc";break;
                case "Répture":sql = "select DISTINCT * FROM Produit where quantité <= 0 order by '"+param3+"' asc";break;
                case "stock_alert":sql = "select DISTINCT * FROM Produit where quantité <= stock_alert order by '"+param3+"' asc";break;
                case "Produit périmé":sql = "select DISTINCT * FROM Produit where date_premption between '2000-01-01' and '"+date+"' order by date_premption asc";break;
                case "proche": sql = "select DISTINCT * FROM Produit where date_premption >= '"+date+"'  order by date_premption asc";break;
              //  case "promotion":sql = "select DISTINCT * FROM Produit where date_premption between '2000-01-01' and '"+date+"' order by date_premption asc";break;
                
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:sql  = "select DISTINCT* FROM Produit where désignation like '%"+param2+"%' order by '"+param3+"' asc";break;
                           }
            
           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
    
            String famille =rs.getString("famille");
            String unite =rs.getString("unite");
            String marque =rs.getString("marque");
            String image =rs.getString("image");
            String référence =rs.getString("référence");
            String désignation =rs.getString("désignation");
            String étagére =rs.getString("étagére");
           // String code_barre =rs.getString("code_barre");
            int id_fournisseur =rs.getInt("id_f");
            String remarque =rs.getString("remarque");
           // String date_premption =rs.getString("date_premption");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente_detail =rs.getDouble("prix_vente_detail");
            double prix_vente_gros =rs.getDouble("prix_vente_gros");
            double prix_special =rs.getDouble("prix_special");
            float quantité =rs.getFloat("quantité");
            int id_produit=rs.getInt("id_produit");
            int stock_alert=rs.getInt("stock_alert");
            int jour_alert=rs.getInt("jour_alert");
          
            float tva=rs.getFloat("tva");
           
            String date_premption =rs.getString("date_premption");
          //   Date d=Date.valueOf(date_premption);
          //  Duration duration = Duration.between(java.time.LocalDate.now(), (Temporal) d);
        //  Date d2=java.time.LocalDate.now();
          // System.out.println("duration="+d.compareTo(d));
            Date date_achat =rs.getDate("date_achat");
            String taille =rs.getString("taille");
            String pointure =rs.getString("pointure");
            String couleur =rs.getString("couleur");
            String saisie_par =rs.getString("saisie_par");
            
             String code_bare_packet =rs.getString("code_bare_packet");
              double prix_vente_packet =rs.getDouble("prix_vente_packet");
               int nbre_produit_packet =rs.getInt("nbre_produit_packet");
                boolean vente_packet =rs.getBoolean("vente_packet");
//            System.out.println("date differnce="+ daysBetween(rs.getDate("date_premption"), new Date(System.currentTimeMillis())));

          //  System.out.println("current date="+ new Date(System.currentTimeMillis()));
              // if((date.getTime()-d.getTime()>0)&&param1.equals("Produit périmé"))
              if((param1.equals("proche")&&(daysBetween(rs.getDate("date_premption"),new Date(System.currentTimeMillis()))<=jour_alert))||!param1.equals("proche"))
                 
                
               {List_produit.add(new Produit(
                   famille,  unite,  marque,  image,  référence,
             désignation,  étagére,  id_fournisseur,  remarque,
              prix_achat,  prix_vente_detail,  prix_vente_gros, 
             prix_special,  quantité,  id_produit,  stock_alert,  jour_alert,
               tva, date_premption, date_achat,taille,pointure,couleur,saisie_par,
                       code_bare_packet,prix_vente_packet,nbre_produit_packet,vente_packet)
          );}
               /*else { List_produit.add(new Produit(
                   famille,  unite,  marque,  image,  référence,
             désignation,  étagére,  id_fournisseur,  remarque,
              prix_achat,  prix_vente_detail,  prix_vente_gros, 
             prix_promotion,  quantité,  id_produit,  stock_alert,  jour_alert,
             quantité_promotion,  tva,  promotion, date_premption, date_achat,taille,pointure,couleur,saisie_par)
          );}*/
        }
        rs.close();
        conn.close();
 stmt.close();
        } catch (Exception sc) {
         sc.printStackTrace();
        }
        return List_produit;
    }
 public ArrayList getList_Produit2(String param1,String param2,String param3) throws Exception {
         //
         HashSet h=new HashSet();
          String sql ="";
  ArrayList<Produit> List_produit=new ArrayList();
        try {


           // JdbcClass j=new JdbcClass();
             Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
            
            switch(param1){
                case "Tous les produits":sql  = "select DISTINCT * FROM Produit where désignation like '%"+param2+"%' order by '"+param3+"' asc";break;
                //case "Tous les produits":sql = "select * FROM Produit,codebarre where Produit.id_produit=codebarre.id_produit and codebarre.code like '%"+param2+"%' order by '"+param3+"' asc ";break;
                case "Code_barre":sql = "select DISTINCT  * FROM Produit,codebarre where Produit.id_produit=codebarre.id_produit and codebarre.code  like '%"+param2+"%' or (Produit.code_bare_packet like '%"+param2+"%' ) order by '"+param3+"' asc ";break;
                case "Famille":sql = "select DISTINCT * FROM Produit where famille like '%"+param2+"%' order by '"+param3+"' asc";break;
                case "Produit en répture":sql = "select DISTINCT * FROM Produit where quantité <= stock_alert order by désignation  asc";break;
                 case "Produit périmé":sql = "select DISTINCT * FROM Produit where date_premption between '2000-01-01' and '"+date+"' order by désignation,date_premption asc";break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:sql  = "select DISTINCT * FROM Produit where désignation like '%"+param2+"%' order by désignation asc";break;
                           }
            
           
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
      
            String famille =rs.getString("famille");
            String unite =rs.getString("unite");
            String marque =rs.getString("marque");
            String image =rs.getString("image");
            String référence =rs.getString("référence");
            String désignation =rs.getString("désignation");
            String étagére =rs.getString("étagére");
           // String code_barre =rs.getString("code_barre");
            int id_fournisseur =rs.getInt("id_f");
            String remarque =rs.getString("remarque");
           // String date_premption =rs.getString("date_premption");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente_detail =rs.getDouble("prix_vente_detail");
            double prix_vente_gros =rs.getDouble("prix_vente_gros");
            double prix_special =rs.getDouble("prix_special");
            float quantité =rs.getFloat("quantité");
            int id_produit=rs.getInt("id_produit");
            int stock_alert=rs.getInt("stock_alert");
            int jour_alert=rs.getInt("jour_alert");
            
            float tva=rs.getFloat("tva");
          
            String date_premption =rs.getString("date_premption");
          //   Date d=Date.valueOf(date_premption);
          //  Duration duration = Duration.between(java.time.LocalDate.now(), (Temporal) d);
        //  Date d2=java.time.LocalDate.now();
          // System.out.println("duration="+d.compareTo(d));
            Date date_achat =rs.getDate("date_achat");
            String taille =rs.getString("taille");
            String pointure =rs.getString("pointure");
            String couleur =rs.getString("couleur");
            String saisie_par =rs.getString("saisie_par");
            
            
             String code_bare_packet =rs.getString("code_bare_packet");
              double prix_vente_packet =rs.getDouble("prix_vente_packet");
               int nbre_produit_packet =rs.getInt("nbre_produit_packet");
                boolean vente_packet =rs.getBoolean("vente_packet");
         //   System.out.println("date_premption="+d.getTime());
            //System.out.println("current date="+date);
              // if((date.getTime()-d.getTime()>0)&&param1.equals("Produit périmé"))
              if(!h.contains(id_produit)) 
               {h.add(id_produit);
                   List_produit.add(new Produit(
                   famille,  unite,  marque,  image,  référence,
             désignation,  étagére,  id_fournisseur,  remarque,
              prix_achat,  prix_vente_detail,  prix_vente_gros, 
             prix_special,  quantité,  id_produit,  stock_alert,  jour_alert,
               tva, date_premption, date_achat,taille,pointure,couleur,saisie_par
                           ,code_bare_packet,prix_vente_packet,nbre_produit_packet,vente_packet)
          );}
               /*else { List_produit.add(new Produit(
                   famille,  unite,  marque,  image,  référence,
             désignation,  étagére,  id_fournisseur,  remarque,
              prix_achat,  prix_vente_detail,  prix_vente_gros, 
             prix_promotion,  quantité,  id_produit,  stock_alert,  jour_alert,
             quantité_promotion,  tva,  promotion, date_premption, date_achat,taille,pointure,couleur,saisie_par)
          );}*/
        }
        rs.close();
        conn.close();
 stmt.close();
        } catch (Exception sc) {
         
        }
        return List_produit;
    }
 
 /*public ArrayList getList_Produit(String param1,String param2,String param3,String param4,String param5,int type) throws Exception {
         //
          String sql ="";
  ArrayList<Produit> List_produit= new ArrayList<Produit>();
        try {


            JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
            Statement stmt = conn.createStatement();
            if(type==1){
            switch(param1){
                case "tout":sql = "select * FROM Produit where remarque like '%"+param2+"%' ";break;
                case "code_barre":sql = "select * FROM Produit where code_barre like '%"+param2+"%' ";break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:sql = "select * FROM Produit  order by désignation asc";break;
                           }
            
            }else {
                if(param2.equals("toute"))param2="";
                if(param3.equals("toute"))param3="";
                if(param4.equals("toute"))param4="";
                if(param5.equals("toute les marques"))param5="";
                int quantite=Integer.parseInt(param1);
 sql ="select * FROM Produit where famille like '%"+param2+"%' and marque like '%"+param3+"%' and désignation like '%"+param4+"%' and code_barre like '%"+param5+"%' and quantité<='"+quantite+"' ";          
            }
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
      
            String famille =rs.getString("famille");
            String unite =rs.getString("unite");
            String marque =rs.getString("marque");
            String image =rs.getString("image");
            String référence =rs.getString("référence");
            String désignation =rs.getString("désignation");
            String étagére =rs.getString("étagére");
           // String code_barre =rs.getString("code_barre");
            String id_fournisseur =rs.getString("id_fournisseur");
            String remarque =rs.getString("remarque");
           // String date_premption =rs.getString("date_premption");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente_detail =rs.getDouble("prix_vente_detail");
            double prix_vente_gros =rs.getDouble("prix_vente_gros");
            double prix_promotion =rs.getDouble("prix_promotion");
            int quantité =rs.getInt("quantité");
            int id_produit=rs.getInt("id_produit");
            int stock_alert=rs.getInt("stock_alert");
            int jour_alert=rs.getInt("jour_alert");
            int quantité_promotion=rs.getInt("quantité_promotion");
            float tva=rs.getFloat("tva");
            boolean promotion=rs.getBoolean("promotion");
            String date_premption =rs.getString("date_premption");
            String date_achat =rs.getString("date_achat");
            String taille =rs.getString("taille");
            String pointure =rs.getString("pointure");
            String couleur =rs.getString("couleur");
               
          List_produit.add(new Produit(
                   famille,  unite,  marque,  image,  référence,
             désignation,  étagére,  id_fournisseur,  remarque,
              prix_achat,  prix_vente_detail,  prix_vente_gros, 
             prix_promotion,  quantité,  id_produit,  stock_alert,  jour_alert,
             quantité_promotion,  tva,  promotion, date_premption, date_achat,taille,pointure,couleur)
          );
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
         
        }
        return List_produit;
    }*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 
/* public ArrayList getList_Produitamanque(String param1,int param2) throws Exception {
         //
          String sql ="";
  ArrayList<Produit> List_produit= new ArrayList<Produit>();
        try {


            JdbcClass j=new JdbcClass();
            Connection conn = j.connect();
           //Statement stmt = conn.createStatement();
          
          //  if(type==1){
            switch(param1){
                case "manque":sql = "select * FROM Produit where quantité <=?";break;
                case "code_barre":sql = "select * FROM Produit where code_barre like ? ";break;
               // case "numéro_de_serie":sql = "select * FROM Produit where numero_serie like '%"+param1+"%' ";break;
                default:sql = "select * FROM Produit where quantité <=? ";break;
                           }
            
         
           // ResultSet rs = stmt.executeQuery(sql);
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, param2);
              
            ResultSet rs=pr.executeQuery();
      while (rs.next()) {
      
            String famille =rs.getString("famille");
            String unite =rs.getString("unite");
            String marque =rs.getString("marque");
            String image =rs.getString("image");
            String référence =rs.getString("référence");
            String désignation =rs.getString("désignation");
            String étagére =rs.getString("étagére");
           // String code_barre =rs.getString("code_barre");
            String id_fournisseur =rs.getString("id_fournisseur");
            String remarque =rs.getString("remarque");
            String date_premption =rs.getString("date_premption");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente_detail =rs.getDouble("prix_vente_detail");
            double prix_vente_gros =rs.getDouble("prix_vente_gros");
            double prix_promotion =rs.getDouble("prix_promotion");
            int quantité =rs.getInt("quantité");
            int id_produit=rs.getInt("id_produit");
            int stock_alert=rs.getInt("stock_alert");
            int jour_alert=rs.getInt("jour_alert");
            int quantité_promotion=rs.getInt("quantité_promotion");
            float tva=rs.getFloat("tva");
            boolean promotion=rs.getBoolean("promotion");
            String date_achat =rs.getString("date_achat");
             String taille =rs.getString("taille");
            String pointure =rs.getString("pointure");
            String couleur =rs.getString("couleur");
            String saisie_par =rs.getString("saisie_par");
           
         List_produit.add(new Produit(
                  famille,  unite,  marque,  image,  référence,
             désignation,  étagére,  id_fournisseur,  remarque,
             prix_achat,  prix_vente_detail,  prix_vente_gros, 
             prix_promotion,  quantité,  id_produit,  stock_alert,  jour_alert,
             quantité_promotion,  tva,  promotion, date_premption, date_achat,taille,pointure,couleur,saisie_par)
          );
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return List_produit;
    }*/
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public  void sup_Produit(String  reference)throws Exception{

        try {
//JdbcClass j=new JdbcClass();
            Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
              String sql = "delete  from Produit where référence=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setString(1, reference);
              pr.executeUpdate();
           // ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
        }
}  
public  void sup_Produit_withID(int  id)throws Exception{

        try {
//JdbcClass j=new JdbcClass();
            Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
              String sql = "delete  from Produit where id_produit=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, id);
              pr.executeUpdate();
             // System.out.println("execute delete");
           // ResultSet rs = stmt.executeQuery(sql);
              pr.close();
        conn.close();
        } catch (Exception sc) {
            sc.printStackTrace();
        }
}  


 public void modifier_Produit(String famille, String unite, String marque, String image, String référence,
            String désignation, String étagére, int id_f, String remarque,
             double prix_achat, double prix_vente_detail, double prix_vente_gros, 
            double prix_special, float quantité, int stock_alert, int jour_alert,
             float tva, String date_premption,
            Date date_achat,String taille,String pointure,String couleur,String saisie_par,int id_produit,
            String code_bare_packet,double prix_vente_packet,int nbre_produit_packet,boolean vente_packet) throws Exception {
        
        try {
           // JdbcClass j=new JdbcClass();
              Connection conn = jdbc.Getconnection();
            //Statement stmt = conn.createStatement();
          
               String sql1 = "UPDATE produit set famille=?,  unite=?,  marque=?,  image=?,  référence=?,\n" +
"             désignation=?,  étagére=?,  id_f=?,  remarque=?,\n" +
"              prix_achat=?,  prix_vente_detail=?,  prix_vente_gros=?, \n" +
"             prix_special=?,  quantité=?,  stock_alert=?,  jour_alert=?,\n" +
"               tva=?,   date_premption=?,  date_achat=?,taille=?,pointure=?,couleur=?"
                       + ",saisie_par=?,code_bare_packet=?,prix_vente_packet=?,nbre_produit_packet=?,vente_packet=? where id_produit='"+id_produit+"'";
             //ResultSet rs1 = stmt.executeQuery(sql1);
               PreparedStatement pr=conn.prepareStatement(sql1);
                pr.setString(1,famille);
               pr.setString(2,unite);
               pr.setString(3,marque);
               pr.setString(4,image);
               pr.setString(5,référence);
               pr.setString(6,désignation );
               pr.setString(7, étagére);
              
               pr.setInt(8, id_f);
               pr.setString(9, remarque);
              
               pr.setDouble(10, prix_achat);
               pr.setDouble(11, prix_vente_detail);
               pr.setDouble(12, prix_vente_gros);
               pr.setDouble(13, prix_special);
               pr.setFloat(14, quantité);
               //pr.setInt(17, id_produit);
               
               pr.setInt(15, stock_alert);
               pr.setInt(16, jour_alert);
              
               pr.setFloat(17, tva);
            //   System.out.println("18");
              
               pr.setString(18,  date_premption);
               pr.setDate(19,  date_achat);
               pr.setString(20,  taille);
               pr.setString(21,  pointure);
               pr.setString(22,  couleur);
               pr.setString(23,  saisie_par);
               
                  pr.setString(24,  code_bare_packet);
                 pr.setDouble(25,  prix_vente_packet);
                 pr.setInt(26,  nbre_produit_packet);
                 pr.setBoolean(27,  vente_packet);
               
               
               pr.executeUpdate();
         
        pr.close(); 
       
        conn.close();
 JOptionPane.showMessageDialog(null, " Bien Modifer ","",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception sc) {
           
           sc.printStackTrace();
        }
       
    }  
 
 public void modifier_ProduitApresAchat(  double prix_achat,double prix_vente_detail,double prix_vente_gros,double prix_special,
         int id,float quantité,Date date_achat) throws Exception {
        
        try {
           // JdbcClass jPP=new JdbcClass();
             Connection conn = jdbc.Getconnection();
            // Statement stmt = conn.createStatement();
      //  String sql1=  "UPDATE produit set  date_achat='ddddd',prix_achat=3333 ,prix_vente=44555 ,quantité=45  where id_produit=2";
               String sql1 = "UPDATE produit SET  date_achat=?,prix_achat=?,prix_vente_detail=?,prix_vente_gros=?,prix_special=?,quantité=?  WHERE id_produit=? ";
              //ResultSet rs1 = stmt.executeQuery(sql1);
             PreparedStatement pr=conn.prepareStatement(sql1);
              pr.setDate(1,date_achat);
              pr.setDouble(2, prix_achat);
              pr.setDouble(3, prix_vente_detail);
              pr.setDouble(4, prix_vente_gros);
              pr.setDouble(5, prix_special);
              pr.setFloat(6, quantité);
                System.out.println("q="+quantité);
              pr.setInt(7, id);
              pr.executeUpdate();
      ///   System.out.println("produit update after achat id pro="+id);
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
          sc.printStackTrace();
        }
       
    }  
 

   public void modifier_ProduitQuantité(  int  id_produit,float quantité) throws Exception {
        
        try {
           // JdbcClass jzz=new JdbcClass();
              Connection conn = jdbc.Getconnection();
          //  Statement stmt = conn.createStatement();
          
               String sql1 = "UPDATE Produit set quantité=? where id_produit=?";
               PreparedStatement pr=conn.prepareStatement(sql1);
               pr.setFloat(1, quantité);
               pr.setInt(2, id_produit);
               pr.executeUpdate();
             //ResultSet rs1 = stmt.executeQuery(sql1);
               
         
        pr.close(); 
       
        conn.close();

        } catch (Exception sc) {
           
         //  sc.printStackTrace();
        }
       
    }  
 
public int QuantitéEnStock(String désignation) throws Exception{
int quantité=0;     
//JdbcClass jqq=new JdbcClass();
  Connection conn = jdbc.Getconnection();
 //Statement stmt = conn.createStatement();
  String sql = "select sum(quantité) as stock  from Produit where désignation =? ";
           // ResultSet rs = stmt.executeQuery(sql);
  PreparedStatement pr=conn.prepareStatement(sql);
  pr.setString(1,désignation);
  ResultSet rs= pr.executeQuery();
        while (rs.next()) {
            int stock =(rs.getInt("stock"));
          quantité=stock;
          
        } 

pr.close();
conn.close();
 return quantité;
 }
  

public float Quantité(int id_produit) throws Exception{
float q=0;     
//JdbcClass jqq=new JdbcClass();
 Connection conn = jdbc.Getconnection();
 //Statement stmt = conn.createStatement();
  String sql = "select quantité   from Produit where id_produit =? ";
           // ResultSet rs = stmt.executeQuery(sql);
  PreparedStatement pr=conn.prepareStatement(sql);
  pr.setInt(1,id_produit);
  ResultSet rs= pr.executeQuery();
        while (rs.next()) {
             q =(rs.getFloat("quantité"));
                  
        } 

pr.close();
conn.close();
 return q;
 }

//////////////////////////////////////////////////////////////////////
/*public void modifier_ProduitApresVente(  int id_produit,int quantité) throws Exception {
        
        try {
            JdbcClass jui=new JdbcClass();
            Connection conn = jui.connect();
            Statement stmt = conn.createStatement();
          
               String sql1 = "UPDATE produit set  quantité='"+quantité+"' where id_produit='"+id_produit+"'";
              ResultSet rs1 = stmt.executeQuery(sql1);
              // PreparedStatement pr=conn.prepareStatement(sql1);
                //pr.setInt(1,quantité);
               //pr.setInt(2,id_produit);
              
            //   pr.executeUpdate();
               
         
        rs1.close(); 
       
        conn.close();
        


        } catch (Exception sc) {
           
         //  sc.printStackTrace();
        }
       
    }*/
//////////////////////////////////////////////////////////////////////
public void modifier_ProduitApresAchat1(  String référence,float quantité,double priachat,double privente,String date) throws Exception {
        
        try {
           // JdbcClass jui=new JdbcClass();
            try ( Connection conn = jdbc.Getconnection();) {
               // Statement stmt = conn.createStatement();
                
                String sql1 = "UPDATE Produit set  date_achat=?,prix_achat=?,prix_vente=?,quantité=? where référence=?";
                //ResultSet rs1 = stmt.executeQuery(sql1);
                PreparedStatement pr=conn.prepareStatement(sql1);
                pr.setString(1, date);
                pr.setDouble(2, priachat);
                pr.setDouble(3, privente);
                pr.setFloat(4,quantité);
                pr.setString(5,référence);
                
                pr.executeUpdate();
                
                pr.close();
                conn.close();
            }

        } catch (Exception sc) {
           
         //  sc.printStackTrace();
        }
       
    }  



  public void  ModifierQuantite(float quantité,int id_produit) throws Exception {
        // ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 
        try {
            //JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
         //   Statement stmt = conn.createStatement();
              String sql = "update  produit set quantité=? where id_produit=?";
          
               PreparedStatement pr=conn.prepareStatement(sql);
             pr.setFloat(1, quantité);
             pr.setInt(2, id_produit);
             pr.executeUpdate();
            // ResultSet rs = pr.executeQuery();
      
             pr.close();
        conn.close();

        } catch (Exception sc) {
          //  JOptionPane.showMessageDialog(null, " le fichier BDD.db est introuvable  ", " ", JOptionPane.WARNING_MESSAGE, img);
//            throw new Exception(sc.getMessage(), sc);
        }
      
    }
  
  
   public int NombreProduitManque(int param2) throws Exception {
         //
          String sql ="";
          int nb=0;
        try {
         //   JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();          
               sql = "select count(id_produit) as NbProduit FROM Produit where quantité <=?";
              PreparedStatement pr=conn.prepareStatement(sql);
              pr.setInt(1, param2);
            ResultSet rs=pr.executeQuery();
      while (rs.next()) {
            nb=rs.getInt("NbProduit"); 
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
           // JOptionPane.showMessageDialog(null,sc.getMessage() , " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return nb;
    }
  
  
public Produit get_Produit(String param) throws Exception {
     Produit p = null;
          String sql ="";
 
        try {
          //  JdbcClass j=new JdbcClass();
             Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();      
 //sql = "select * FROM Produit,codebarre where (Produit.id_produit=codebarre.id_produit and codebarre.code like '%"+param+"%' )or (Produit.code_bare_packet  like '%"+param+"%') ";  
 sql="select DISTINCT  * FROM Produit,codebarre where Produit.id_produit=codebarre.id_produit and codebarre.code  like '%"+param+"%' or (Produit.code_bare_packet like '%"+param+"%' )";
  //sql = "select * FROM Produit,codebarre where Produit.id_produit=codebarre.id_produit and codebarre.code like '%"+param+"%'  ";    
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {     
           String famille =rs.getString("famille");
            String unite =rs.getString("unite");
            String marque =rs.getString("marque");
            String image =rs.getString("image");
            String référence =rs.getString("référence");
            String désignation =rs.getString("désignation");
            String étagére =rs.getString("étagére");
           // String code_barre =rs.getString("code_barre");
            int id_fournisseur =rs.getInt("id_f");
            String remarque =rs.getString("remarque");
            String date_premption =rs.getString("date_premption");
            double prix_achat =rs.getDouble("prix_achat");
           // System.out.println("prix achat="+prix_achat);
            double prix_vente_detail =rs.getDouble("prix_vente_detail");
            double prix_vente_gros =rs.getDouble("prix_vente_gros");
            double prix_special =rs.getDouble("prix_special");
             // System.out.println("prix_promotion="+prix_promotion);
            float quantité =rs.getFloat("quantité");
            // System.out.println("quantité="+quantité);
            int id_produit=rs.getInt("id_produit");
            // System.out.println("id_produit="+id_produit);
            int stock_alert=rs.getInt("stock_alert");
            //  System.out.println("stock_alert="+stock_alert);
            int jour_alert=rs.getInt("jour_alert");
            //  System.out.println("jour_alert="+jour_alert);
            // System.out.println("jour_alert="+jour_alert);
         
            // System.out.println("quantité_promotion="+quantité_promotion);
            float tva=rs.getFloat("tva");
        
            Date date_achat =rs.getDate("date_achat");
             String taille =rs.getString("taille");
            String pointure =rs.getString("pointure");
            String couleur =rs.getString("couleur");
            String saisie_par =rs.getString("saisie_par");
            //  System.out.println("saisie_par="+saisie_par);
            
             String code_bare_packet =rs.getString("code_bare_packet");
              //  System.out.println("code_bare_packet="+code_bare_packet);
              double prix_vente_packet =rs.getDouble("prix_vente_packet");
           //     System.out.println("prix_vente_packet="+prix_vente_packet);
               int nbre_produit_packet =rs.getInt("nbre_produit_packet");
                 // System.out.println("nbre_produit_packet="+nbre_produit_packet);
                boolean vente_packet =rs.getBoolean("vente_packet");
                //   System.out.println("vente_packet="+vente_packet);
         p=new Produit(
                   famille,  unite,  marque,  image,  référence,
             désignation,  étagére,  id_fournisseur,  remarque, 
               prix_achat,  prix_vente_detail,  prix_vente_gros, 
             prix_special,  quantité,  id_produit,  stock_alert,  jour_alert,
               tva, date_premption, date_achat,taille,pointure,couleur,saisie_par,
                 code_bare_packet,prix_vente_packet,nbre_produit_packet,vente_packet) ;
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
           sc.getMessage();
        }
        return p;
    }  
public Produit get_Produit1(int id) throws Exception {
     Produit p = null;
          String sql ="";
 
        try {
          //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();      
 sql = "select * FROM Produit where id_produit = '"+id+"'  ";          
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {     
          //   String famille =rs.getString("famille");
          //    String unite =rs.getString("unite");
           //   String marque =rs.getString("marque");
           //   String image =rs.getString("image");
           //   String référence =rs.getString("référence");
            String désignation =rs.getString("désignation");
            //  String étagére =rs.getString("étagére");
           // String code_barre =rs.getString("code_barre");
           //   String id_fournisseur =rs.getString("id_fournisseur");
           //   String remarque =rs.getString("remarque");
            //  String date_premption =rs.getString("date_premption");
            double prix_achat =rs.getDouble("prix_achat");
            double prix_vente_detail =rs.getDouble("prix_vente_detail");
            double prix_vente_gros =rs.getDouble("prix_vente_gros");
            double prix_special =rs.getDouble("prix_special");
            float quantité =rs.getFloat("quantité");
            //  int id_produit=rs.getInt("id_produit");
          //    int stock_alert=rs.getInt("stock_alert");
           //   int jour_alert=rs.getInt("jour_alert");
            //  int quantité_promotion=rs.getInt("quantité_promotion");
            //  float tva=rs.getFloat("tva");
          //    boolean promotion=rs.getBoolean("promotion");
            Date date_achat =rs.getDate("date_achat");
            //   String taille =rs.getString("taille");
            //  String pointure =rs.getString("pointure");
            //  String couleur =rs.getString("couleur");
            //  String saisie_par =rs.getString("saisie_par");
         p=new Produit(
                 
             désignation, 
               prix_achat,  prix_vente_detail,  prix_vente_gros,prix_special, 
               quantité,  id,  
              date_achat) ;
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
           
        }
        return p;
    }  

/*private class ButtonCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

        private JButton btn;

        ButtonCell(int index){
            btn = new JButton();
         //   btn.setBackground(new java.awt.Color(255, 255, 255));
      //  btn.setForeground(new java.awt.Color(255, 255, 255));
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
              lBareCode.remove(index);
              DisplayCodeBarre(lBareCode,jTable1);
          //   ListProduit.get(jTable1.getSelectedRow()).getRéférence()
                }
            });
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            if(value instanceof Icon){
                btn.setIcon((Icon) value);
            } else {
              //  btn.setIcon(null);
            }
            return btn;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            if(value instanceof Icon){
                btn.setIcon((Icon) value);
            } else {
             //   btn.setIcon(null);
            }
            return btn;
        }

    }
*/


public int GetNextidProduit() throws Exception{
   // int ref=0;
    int max=0;
 //JdbcClass j=new JdbcClass();
          Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();
             String sql = "select Max(id_produit)  as maxrow from produit ";
            ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            max =(rs.getInt("maxrow"));}
           //  System.out.println("max="+max);
       //    if(max==0){ref=ref+1+"";}else{
          
           //  System.out.println("ref="+ref);
      //  }
rs.close();
 stmt.close();
conn.close();
return max+1;
}

public boolean GetFavorite(int id_produit) throws Exception{
boolean etat=true;
   //ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 String sql ="";
 Connection conn = jdbc.Getconnection();
 Statement stmt = conn.createStatement();
 sql  = "select favorite FROM Produit where id_produit ='"+id_produit+"'   ";                       
            ResultSet rs = stmt.executeQuery(sql);
 while (rs.next()) {
 etat=rs.getBoolean("favorite"); 
      }     
rs.close();
conn.close();      
return etat;
}
  public void  ModifierFavorite(int id_produit,int position) throws Exception {
      //   ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 
        try {
            //JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
         //   Statement stmt = conn.createStatement();
              String sql = "update  produit set favorite=? where id_produit=?";
          
             PreparedStatement pr=conn.prepareStatement(sql);
             pr.setInt(1, position);
           
             pr.setInt(2, id_produit);
             pr.executeUpdate();
            // ResultSet rs = pr.executeQuery();
      
             pr.close();
        conn.close();

        } catch (Exception sc) {
            JOptionPane.showMessageDialog(null, sc.getMessage(), "Erreur ", JOptionPane.WARNING_MESSAGE, null);
//            throw new Exception(sc.getMessage(), sc);
        }
      
    }
  
 /* public Hashtable getList_FavoriteProduit() throws Exception {
  String sql ="";
 
  Hashtable List_produit= new Hashtable();
           // JdbcClass j=new JdbcClass();
  Connection conn = jdbc.Getconnection();
   Statement stmt = conn.createStatement();
               sql  = "select * FROM Produit where favorite =1  order by pos_fav  asc";                       
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        String unite =rs.getString("unite");
        String désignation =rs.getString("désignation");
        double prix_achat =rs.getDouble("prix_achat");
        double prix_vente_detail =rs.getDouble("prix_vente_detail");
        double prix_vente_gros =rs.getDouble("prix_vente_gros");
        double prix_promotion =rs.getDouble("prix_promotion");
        double prix_vente_packet =rs.getDouble("prix_vente_packet");
        int id_produit=rs.getInt("id_produit"); 
        int quantité_promotion=rs.getInt("quantité_promotion");
        int nbre_produit_packet =rs.getInt("nbre_produit_packet");
        float tva=rs.getFloat("tva");
        boolean promotion=rs.getBoolean("promotion");
        boolean vente_packet=rs.getBoolean("vente_packet");
        boolean favorite=rs.getBoolean("favorite");
        float quantité =rs.getFloat("quantité");
        int pos_fav =rs.getInt("pos_fav");
        
         
               List_produit.put(pos_fav,new Produit(
                   unite,  désignation,  prix_achat,  prix_vente_detail,
             prix_vente_gros,  prix_promotion,  prix_vente_packet,  id_produit, 
             quantité_promotion,  nbre_produit_packet,  tva,  promotion, 
             vente_packet,  favorite,  quantité, pos_fav)
          );
              
      }
              
      
        rs.close();
        conn.close();

      
        return List_produit;
    }*/
/*public Hashtable getList_FavoriteProduit() throws Exception {
  String sql ="";
 
  Hashtable List_produit= new Hashtable();
           // JdbcClass j=new JdbcClass();
  Connection conn = jdbc.Getconnection();
   Statement stmt = conn.createStatement();
               sql  = "select id_produit FROM Produit where favorite =1  order by pos_fav  asc";                       
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
     
        int id_produit=rs.getInt("id_produit"); 
       
        // int pos_fav =rs.getInt("pos_fav");
        
         
               List_produit.put(pos_fav,id_produit);
          
              
      }
              
      
        rs.close();
        conn.close();

      
        return List_produit;
    }*/

public List<Integer> getListID_FavoriteProduit() throws Exception {
  String sql ="";
  List<Integer> List_produit= new ArrayList();
  Connection conn = jdbc.Getconnection();
   Statement stmt = conn.createStatement();
               sql  = "select id_produit FROM Produit where favorite >0  order by favorite  asc";                       
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
      int id_produit=rs.getInt("id_produit");      
     List_produit.add(id_produit);       
      }
        rs.close();
        conn.close();
        return List_produit;
    }



public List<Integer> getListPosition_FavoriteProduit() throws Exception {
  String sql ="";
  List<Integer> List_produit= new ArrayList();
  Connection conn = jdbc.Getconnection();
   Statement stmt = conn.createStatement();
               sql  = "select favorite FROM Produit where favorite >0  order by favorite  asc";                       
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
      int favorite=rs.getInt("favorite");      
     List_produit.add(favorite);       
      }
        rs.close();
        conn.close();
        return List_produit;
    }

public Produit get_Produit2(int id) throws Exception {
     Produit p = null;
          String sql ="";
 
        try {
          //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();      
 sql = "select * FROM Produit where id_produit = '"+id+"'  ";          
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {     
          String unite =rs.getString("unite");
        String désignation =rs.getString("désignation");
        double prix_achat =rs.getDouble("prix_achat");
        double prix_vente_detail =rs.getDouble("prix_vente_detail");
        double prix_vente_gros =rs.getDouble("prix_vente_gros");
        double prix_special =rs.getDouble("prix_special");
        double prix_vente_packet =rs.getDouble("prix_vente_packet");
        int id_produit=rs.getInt("id_produit"); 
       
        int nbre_produit_packet =rs.getInt("nbre_produit_packet");
        float tva=rs.getFloat("tva");
        
        boolean vente_packet=rs.getBoolean("vente_packet");
        int favorite=rs.getInt("favorite");
        float quantité =rs.getFloat("quantité");
      
         p=new Produit(
                   unite,  désignation,  prix_achat,  prix_vente_detail,
             prix_vente_gros,  prix_special,  prix_vente_packet,  id_produit, 
               nbre_produit_packet,  tva, 
             vente_packet,  favorite,  quantité) ;
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
           
        }
        return p;
    }  

public Produit get_Produit3(int favorite) throws Exception {
     Produit p = null;
          String sql ="";
 
        try {
          //  JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement();      
 sql = "select * FROM Produit where favorite = '"+favorite+"'  ";          
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {     
          String unite =rs.getString("unite");
        String désignation =rs.getString("désignation");
        double prix_achat =rs.getDouble("prix_achat");
        double prix_vente_detail =rs.getDouble("prix_vente_detail");
        double prix_vente_gros =rs.getDouble("prix_vente_gros");
        double prix_special =rs.getDouble("prix_special");
        double prix_vente_packet =rs.getDouble("prix_vente_packet");
        int id_produit=rs.getInt("id_produit"); 
       
        int nbre_produit_packet =rs.getInt("nbre_produit_packet");
        float tva=rs.getFloat("tva");
        
        boolean vente_packet=rs.getBoolean("vente_packet");
      //  int favorite=rs.getInt("favorite");
        float quantité =rs.getFloat("quantité");
      
         p=new Produit(
                   unite,  désignation,  prix_achat,  prix_vente_detail,
             prix_vente_gros,  prix_special,  prix_vente_packet,  id_produit, 
               nbre_produit_packet,  tva, 
             vente_packet,  favorite,  quantité) ;
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
          p=null; 
        }
        return p;
    }  


public ArrayList<Produit> get_ListProduit2(List<Integer> ListID) throws Exception {
     ArrayList<Produit> p = new ArrayList();
          String sql ="";
    Connection conn = jdbc.Getconnection();
            Statement stmt = conn.createStatement(); 
             
      //  try {
             for(int i=0;i<20;i++){
          //  JdbcClass j=new JdbcClass();            
 sql = "select * FROM Produit where id_produit = '"+ListID.get(i)+"'  order by favorite asc ";          
            ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {     
          String unite =rs.getString("unite");
        String désignation =rs.getString("désignation");
        double prix_achat =rs.getDouble("prix_achat");
        double prix_vente_detail =rs.getDouble("prix_vente_detail");
        double prix_vente_gros =rs.getDouble("prix_vente_gros");
        double prix_special =rs.getDouble("prix_special");
        double prix_vente_packet =rs.getDouble("prix_vente_packet");
        int id_produit=rs.getInt("id_produit"); 
        int nbre_produit_packet =rs.getInt("nbre_produit_packet");
        float tva=rs.getFloat("tva");
        boolean vente_packet=rs.getBoolean("vente_packet");
        int favorite=rs.getInt("favorite");
        float quantité =rs.getFloat("quantité");
       
      p.add(new Produit(
                   unite,  désignation,  prix_achat,  prix_vente_detail,
             prix_vente_gros,  prix_special,  prix_vente_packet,  id_produit, 
               nbre_produit_packet,  tva, 
             vente_packet,  favorite,  quantité)) ;       
        }
            
        rs.close();
          conn.close(); 
           stmt.close();
              }
        return p;
      
          
        
    }  
 public void displayFavorite( List<JButton> ListBouton,ArrayList<Produit> ListPrFavorite){
 
  for(int i=0;i<=19;i++)
     {
      try {
          ListBouton.get(i).setText(get_Produit3(i+1).getDésignation());
          ListPrFavorite.add(get_Produit3(i+1));
          
            ListBouton.get(i).setFont(new java.awt.Font("Tahoma", 1, 14));
             ListBouton.get(i).setBackground(new Color(255, 255, 225));
      } catch (Exception ex) {
          ListPrFavorite.add(null);
         // Logger.getLogger(Produit_op.class.getName()).log(Level.SEVERE, null, ex);
      }
 
   
     }
 }
public int getIndex(ArrayList<Produit> ListPr,int id){
int index=-1;
for(int i=0;i<ListPr.size();i++){
if(ListPr.get(i).getId_produit()==id){index=i;break;}
    }
return index;
}

/*public int getNumberOfDays(){
SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
String inputString1 = "1997-10-07";
String inputString2 = "27 04 1997";

try {
    Date date1 = myFormat.parse(inputString1);
    Date date2 = myFormat.parse(inputString2);
    long diff = date2.getTime() - date1.getTime();
    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
} catch (ParseException e) {
    e.printStackTrace();
}

return 0;
}*/
/*public static long getDifferenceDays(Date d1, Date d2) {
    long diff = d2.getTime() - d1.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
}*/

public int daysBetween(Date d1, Date d2){
             return (int)(Math.abs((d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24)));
     }


public int GetIdProduit(String reference) throws Exception{
int id=0;
   //ImageIcon   img = new ImageIcon("Images/erreur.GIF");
 //String sql ="";
 Connection conn = jdbc.Getconnection();
 String sql  = "select id_produit FROM Produit where référence= ? ";  
 PreparedStatement pr=conn.prepareStatement(sql);
 pr.setString(1,reference);
 ResultSet rs = pr.executeQuery();
 while (rs.next()) {
 id=rs.getInt("id_produit"); 
      }     
rs.close();
conn.close();      
return id;
}

public void DelImage(int id_produit){
  try{
    File fichier = new File("images/image_produits/"+id_produit+".jpg");
  fichier.delete();
  }catch(Exception e){}
}


 public  void deleteAllFiles(File dirPath) {
      File filesList[] = dirPath.listFiles();
      for(File file : filesList) {
         if(file.isFile()) {
            file.delete();
         } else {
            deleteAllFiles(file);
         }
      }
   }
public int NombreProduit() throws Exception {
         //
          String sql ="";
          int nb=0;
        try {
         //   JdbcClass j=new JdbcClass();
           Connection conn = jdbc.Getconnection();          
               sql = "select count(id_produit) as NbProduit FROM Produit ";
              PreparedStatement pr=conn.prepareStatement(sql);
          //    pr.setInt(1, param2);
            ResultSet rs=pr.executeQuery();
      while (rs.next()) {
            nb=rs.getInt("NbProduit"); 
        }
        rs.close();
        conn.close();

        } catch (Exception sc) {
           // JOptionPane.showMessageDialog(null,sc.getMessage() , " ", JOptionPane.WARNING_MESSAGE, img);
            throw new Exception(sc.getMessage(), sc);
        }
        return nb;
    }

}
