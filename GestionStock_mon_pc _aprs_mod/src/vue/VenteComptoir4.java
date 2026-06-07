/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import controler.BoutonColor;
import controler.Caisse_op;
import controler.Client_op;
import controler.CodeBarre_op;
import controler.DateFormater;
import controler.FontStyle;
import controler.FrenchNumberToWords;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import controler.Vente_op;



 import controler.Versement_client;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import model.Caisse;


import model.Client;

import model.Paramaitre;


import model.Produit;
import model.Vente;
import model.Versement;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rais
 */
public class VenteComptoir4 extends javax.swing.JFrame implements KeyListener {
 
   // ImageIcon   img = new ImageIcon("images/gs.png");
    ImageIcon imageNormale = new ImageIcon("images/ic_sync_white.png");
    ImageIcon imagePassage =  new ImageIcon("images/ic_sync_white_18dp.png");
  
   
TextNumber tnb= TextNumber.getObj();  
static Client_op cop= Client_op.getInstance();
Paramaitres_op paop= Paramaitres_op.getInstance();
public static Vente_op vop= Vente_op.getInstance();
public static Produit_op pop= Produit_op.getInstance();
static Caisse_op caisse_op=Caisse_op.getInstance();
 CodeBarre_op op8= CodeBarre_op.getInstance();
FontStyle fs= FontStyle.getInstance();
String s="";
static String type="ajouter";
//int q=0;
char px='D';
char px2='D';
double prix_vente,prix_vente2;

public static VenteComptoir4 obj=null;
public static VenteComptoir4 obj2=null;
 String temp_vente = "";
static String code="";
 //public static Date date1=null;
public static Date date_vente=null;

static public ArrayList<Vente> ListVente=new ArrayList<>(); 
static public ArrayList<Vente> ListVente2=new ArrayList<>(); 

public static ArrayList<Produit> ListPr=new ArrayList<>();
public static ArrayList<Produit> ListPr2=new ArrayList<>();

public  static ArrayList<Produit> ListPrFavorite=new ArrayList<>();
public static List<Integer> ListPositionFavorite=new ArrayList<>();
//public static ArrayList<PrintReportVente> ListPrintBon =new ArrayList<>(); 
//public List ListProduitQuantité;
public static List<Float> ListProduitQuantité = new ArrayList<>();
public static List<Float> ListProduitQuantité2 = new ArrayList<>();

public static  List<Float> ListProduitQuantitéAcheteAvantMod = new ArrayList<>();
public static  List<Float> ListProduitQuantitéAcheteAvantMod2 = new ArrayList<>();
public static List<JButton> ListBouton = new ArrayList<>();
public static ArrayList<Caisse> ListCaisse =new ArrayList<>(); 

SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
NumberFormat formatter = new DecimalFormat("#0.00"); 
SimpleDateFormat tf = new SimpleDateFormat("hh:mm a");
 
static public Client f=new Client();
static public Client f2=new Client();
        //new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
//public static String nom_prenom_client="Passager";
//public static int idf=0;

//public static double c;
public static int num_bon=0;
public static int num_bon2=0;

double pvente=0;
double pvente2=0;
BoutonColor bc= BoutonColor.getInstance();
// static double credit=0;
public static double m_verse=0;
public static double m_verse2=0;
 // double r_a_payer;
 public static double nv_credit=0;
  public static double nv_credit2=0;
  
 public static int row,column;
  public static int row2,column2;
  
 public  static double total=0;
  public  static double total2=0;
  
 float quantite_vente=0;
  float quantite_vente2=0;
 
 public static  double dette=0;
 public static  double dette2=0;
 
 public static double remise=0;
  public static double remise2=0;
  
 public static double a_rendu=0;
  public static double a_rendu2=0;
  
 public static double total_apres_remise=0;
  public static double total_apres_remise2=0;
  
 public static double total_TTc;
 public static double total_TTc2;
 double prix_u=0;
  double prix_u2=0;
  
 String option_imp="ticket";
// String option_imp2="ticket";
 
 Tools tools=Tools.getInstance();
 String ticket_forma="ETQ55";
 
 DateFormater df=new DateFormater() ;
  // Paramaitre pa=null;
 Versement_client vf= Versement_client.getObj();
 
 static  int numVer=0;
  static  int numVer2=0;
 // public static String date_achat="";
Paramaitres_op parop= Paramaitres_op.getInstance();
public static Paramaitre p; 
boolean c1=true;
public static String user;
JPopupMenu jpm = new JPopupMenu();
private JMenuItem add = new JMenuItem("Ajouter un produit favorite");
public static String date_achat="";
 //  private JMenuItem del = new JMenuItem("Supprimer un produit favorite");
public    JMenuItem [] ListDel = new JMenuItem[20];

public static String etat="valider";
public static String etat2="valider";

FrenchNumberToWords an= FrenchNumberToWords.getInstance(); 
 JasperFillManager jfm;
 Map   para = new HashMap();
 JasperPrint print1,print2,print3,print4,print5,print6,print7;
 public static int numClient=1;

 //  MouseEvent me;
    /**
     * Creates new form 
     */
  public VenteComptoir4() throws Exception{
    code=GenerateCodeBarre(); 
    num_bon=vop.GetNextBon();
    num_bon2=num_bon+1;
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListVente);
 

print1 =jfm.fillReport("Bon_livraison1.jasper", para, dataSource);
print2 =jfm.fillReport("facture_vente.jasper", para, dataSource);
print3 =jfm.fillReport("facture_proformat1.jasper", para, dataSource);
print4 =jfm.fillReport("ticket55.jasper",para, dataSource);
print5=jfm.fillReport("ticket80.jasper",para, dataSource);
print6=jfm.fillReport("ticketA4.jasper",para, dataSource);
print7=jfm.fillReport("ticketA5.jasper",para, dataSource);
addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(false);
  }
  public static VenteComptoir4 getObj(String user){
    //  ListPrintBon.clear();
     // nom_prenom_client="Passager";
   //  f=
      user=Aucceuil.userName;
      if(obj==null){
           
          try {
              ListCaisse.clear();
              ListCaisse=caisse_op.getList_Caisse();
            //  System.out.println("list caisse="+ListCaisse.size());
              obj=new VenteComptoir4(user);
          } catch (Exception ex) {
              Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
          }
           
        }
      else   pop.displayFavorite(ListBouton,ListPrFavorite);
      return obj;
         
    }
  
  public static  VenteComptoir4 getObj(Client cl,ArrayList<Vente> listAch,ArrayList<Produit> listP,double t){
      
    //  idf=idc;
    f=cl;
    //  System.out.println("idf1="+idf);
       user=Aucceuil.userName;
       ListVente.clear();
       ListVente=listAch;
      ListProduitQuantitéAcheteAvantMod.clear();
      //  ListProduitQuantitéAcheteAvantMod=ListProduitQte;
      // ListProduitQuantité.clear();
    //  ListProduitQuantité=ListProduitQte;
  
      ListPr.clear();
       ListPr=listP;
       total=t;
       type="modifier";
       for( int j=0;j<listAch.size();j++){ListProduitQuantité.add(listAch.get(j).getQuantité_vente());
       ListProduitQuantitéAcheteAvantMod.add(listAch.get(j).getQuantité_vente());
      //  System.out.println("begin ListProduitQuantitéAcheteAvantMod "+j+"="+ListProduitQuantitéAcheteAvantMod.get(j));
       }
  //ListProduitQuantitéAcheteAvantMod.addAll(ListProduitQuantité);
      if(obj2==null){
           
          try {
              //   System.out.println("begin .....");
              obj2=new VenteComptoir4( cl, listAch, listP,  t);
           
          } catch (Exception ex) {
              Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
          }
           
        }
      else   pop.displayFavorite(ListBouton,ListPrFavorite);
      
       try {
          for(int i=0;i<ListCaisse.size();i++)Caisse.addItem(ListCaisse.get(i).getNum()+"");
       
    } catch (Exception ex) {
       // Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
    }
      return obj2;
       
    }
    private VenteComptoir4(String User) throws Exception {
    try {
      
        initComponents();
       //   System.out.println("list caisse size="+ListCaisse.size());
        //  if(ListCaisse.size()>1)jPanel_Caisse.setVisible(true);
     //   else jPanel_Caisse.setVisible(false);
        code=GenerateCodeBarre(); 
        // String tim  = tf.format(new java.util.Date());
       time.setText(df.getcurrentTime());
       //  f=new Client( "C0",  "Passager", " ", " ", " "," ", " ", " ", " ", " ",0);
    f=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
    f2=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
     fs.SetFont1(Total,85);
       CodeBarre.requestFocus();
         this.setIconImage(tools.getImageIcone().getImage());
  init(numClient);
  
    num_bon=vop.GetNextBon();
    N_bon.setText("N° bon:"+num_bon);
 
    date_vente=new Date(System.currentTimeMillis());
    DateVente.setText(date_vente+"");
  
    user=Aucceuil.userName;;
    TableVente.setRowHeight(30);
    JTableHeader tableHeader = TableVente.getTableHeader();
    TableVente.getTableHeader().setOpaque(false);
    tableHeader.setBackground(Color.BLACK);
    tableHeader.setForeground(Color.black);
     
    Font headerFont = new Font("Verdana", Font.PLAIN, 14);
    tableHeader.setFont(headerFont);
  
   getListButton();
   pop.displayFavorite(ListBouton,ListPrFavorite);
         p=paop.get_Paramaitre();
   try{  NomMagasin.setText(p.getNom_magasin());}catch(Exception e){}
        
 TableVente.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
              int bb  = table.rowAtPoint(p);
       if(numClient==1){
            row=table.getSelectedRow();
             column=table.columnAtPoint(p);
                       }
       else { row2=table.getSelectedRow();
             column2=table.columnAtPoint(p);}
        
        }
    });  
    } catch (Exception ex) { 
        ex.printStackTrace();
    }
  bc.ColorerBouton(select_product,  new Color(1, 101, 225));
  bc.ColorerBouton(Annuler, new Color(204, 0, 0));
 
  bc.ColorerBouton(Valider_Achat_BTN, new Color(0,152,102));
  bc.ColorerBouton(Imprimer_BTN, new Color(0,153,255));
   
  //QuantiteRem.setPressedIcon(imageEnfoncee);
     select_product.setRolloverIcon(imagePassage);
     select_product.setRolloverEnabled(true);


  Thread t = new Thread(new Traitement());
				t.start();
CodeBarre.addKeyListener(this);
//montant_verser.addKeyListener(this);
//TFremise.addKeyListener(this);
jPanel3.addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(true);                              
          try {
          for(int i=0;i<ListCaisse.size();i++)Caisse.addItem(ListCaisse.get(i).getNum()+"");
       
    } catch (Exception ex) {
       // Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
    }                            
    }
 private VenteComptoir4(Client cl,ArrayList<Vente> listAch,ArrayList<Produit> listPr,double tot) throws Exception {  
    try {
   f=cl;
   reportsengine.ReportsManager.getInstance();
   initComponents();
    System.out.println("list caisse size="+ListCaisse.size());
     if(ListCaisse.size()>1)jPanel_Caisse.setVisible(true);
        else jPanel_Caisse.setVisible(false);
   CodeBarre.requestFocus();
   this.setIconImage(tools.getImageIcone().getImage());
   TableVente.setRowHeight(30);
   JTableHeader tableHeader = TableVente.getTableHeader();
   tableHeader.setForeground(Color.black);
   Font headerFont = new Font("Verdana", Font.PLAIN, 14);
   tableHeader.setFont(headerFont);
   bc.ColorerBouton(select_product,  new Color(1, 101, 225));
   time.setText(df.getcurrentTime());
   DateVente.setText(listAch.get(0).getDate_vente()+"");
      
    num_bon=listAch.get(0).getNum_bon();
    N_bon.setText("N° bon:"+num_bon);
    p=paop.get_Paramaitre();
    NomMagasin.setText(p.getNom_magasin());
    fs.SetFont1(Total,85);
    m_verse=listAch.get(0).getSomme_versé();
    user=Aucceuil.userName;
    ListVente=listAch;
    ListPr=listPr; 
     Paramaitres_op paop= Paramaitres_op.getInstance();
     p=paop.get_Paramaitre();
  TableVente.setRowHeight(30);
   
   
    getListButton();
   
   pop.displayFavorite(ListBouton,ListPrFavorite);
   	 Thread t = new Thread(new Traitement());
				t.start();
    
     total=tot;
    
     if(type.equals("ajouter")) dette=cop.getCredit(ListVente.get(0).getIdc());else dette=0;
 
     remise=listAch.get(0).getRemise();
    nom_client.setText(f.getNom_prénom_client());
    Ancien_credit.setText(tnb.Afficher2Verguile(dette));
    TFremise.setText(tnb.Afficher2Verguile(remise));
  //  montant_verser.setText(list.get(0).getSomme_versé()+"");

    Total.setText( tnb.Afficher2Verguile(total));
    Total_Apres_Remise.setText(tnb.Afficher2Verguile(total-remise));
    montant_verser.setText(tnb.Afficher2Verguile(m_verse));
    total_apres_remise=total-remise;
    nv_credit=dette;
     nvcredit.setText(tnb.Afficher2Verguile(nv_credit));
   
 bc.ColorerBouton(select_product,  new Color(1, 101, 225));
  bc.ColorerBouton(Annuler, new Color(204, 0, 0));
 
  bc.ColorerBouton(Valider_Achat_BTN, new Color(0,152,102));
  bc.ColorerBouton(Imprimer_BTN, new Color(0,153,255));
   
  //QuantiteRem.setPressedIcon(imageEnfoncee);
     select_product.setRolloverIcon(imagePassage);
     select_product.setRolloverEnabled(true);
     
    pop.displayResult4(ListPr, TableVente,px,ListProduitQuantité);
 TableVente.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
            int bb  = table.rowAtPoint(p);
       
            if(numClient==1){
            row=table.getSelectedRow();
             column=table.columnAtPoint(p);
                       }
       else { row2=table.getSelectedRow();
             column2=table.columnAtPoint(p);}
        

        }
    });  
    } catch (Exception ex) { 
        ex.printStackTrace();
    }
      bc.ColorerBouton(select_product,  new Color(1, 101, 225));
       TableVente.setRowHeight(30);
    JTableHeader tableHeader = TableVente.getTableHeader();
    TableVente.getTableHeader().setOpaque(false);
    tableHeader.setBackground(Color.BLACK);
    tableHeader.setForeground(Color.black);
     
    Font headerFont = new Font("Verdana", Font.PLAIN, 14);
    tableHeader.setFont(headerFont);
     addKeyListener(this);
setFocusable(true);
setFocusTraversalKeysEnabled(false);
     //  CodeBarre.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
           try {
          for(int i=0;i<ListCaisse.size();i++)Caisse.addItem(ListCaisse.get(i).getNum()+"");
       
    } catch (Exception ex) {
       // Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupPrix = new javax.swing.ButtonGroup();
        GroupImpri = new javax.swing.ButtonGroup();
        GroupTicket = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Total = new javax.swing.JLabel();
        N_bon = new javax.swing.JLabel();
        NomMagasin = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        DateVente = new javax.swing.JLabel();
        myButton1 = new button.MyButton();
        myButton2 = new button.MyButton();
        jPanel10 = new javax.swing.JPanel();
        select_product = new javax.swing.JButton();
        QuantiteRem = new javax.swing.JButton();
        QuantiteAdd = new javax.swing.JButton();
        CodeBarre = new javax.swing.JTextField();
        B_balance = new javax.swing.JButton();
        Detail = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanelRaccourci = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        b11 = new javax.swing.JButton();
        b12 = new javax.swing.JButton();
        b13 = new javax.swing.JButton();
        b14 = new javax.swing.JButton();
        b15 = new javax.swing.JButton();
        b16 = new javax.swing.JButton();
        b17 = new javax.swing.JButton();
        b18 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        b20 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanelOptionImpression = new javax.swing.JPanel();
        jRadioFacture = new javax.swing.JRadioButton();
        jRadioBonLivraison = new javax.swing.JRadioButton();
        jRadioTicket = new javax.swing.JRadioButton();
        jRadioFactureProformat = new javax.swing.JRadioButton();
        jPanelTicketFormat = new javax.swing.JPanel();
        jRadioETQ80 = new javax.swing.JRadioButton();
        jRadioA5 = new javax.swing.JRadioButton();
        jRadioETQ55 = new javax.swing.JRadioButton();
        jRadioA4 = new javax.swing.JRadioButton();
        jPanelPrixVente2 = new javax.swing.JPanel();
        jRadioDetail2 = new javax.swing.JRadioButton();
        jRadioGros = new javax.swing.JRadioButton();
        jRadioSpecial = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nvcredit = new javax.swing.JTextField();
        Ancien_credit = new javax.swing.JTextField();
        nom_client = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider_Achat_BTN = new javax.swing.JButton();
        Imprimer_BTN = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        Arendu = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        A_rendu = new javax.swing.JTextField();
        montant_verser = new com.jkelany.jktextfield.numeric.JKNumericField();
        Total_Apres_Remise = new javax.swing.JTextField();
        TFremise = new javax.swing.JTextField();
        jPanel_Caisse = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Caisse = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vente Comptoire");
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jScrollPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane1KeyPressed(evt);
            }
        });

        TableVente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableVente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Désignation", "Prix ", "Quantité", "Montant"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableVente.setColumnSelectionAllowed(true);
        TableVente.getTableHeader().setReorderingAllowed(false);
        TableVente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableVenteMousePressed(evt);
            }
        });
        TableVente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableVenteKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableVente);
        TableVente.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2KeyPressed(evt);
            }
        });

        Total.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        Total.setForeground(new java.awt.Color(51, 255, 51));
        Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Total.setText("0.00    ");

        N_bon.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        N_bon.setForeground(new java.awt.Color(255, 255, 255));
        N_bon.setText("N° bon ");

        NomMagasin.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        NomMagasin.setForeground(new java.awt.Color(255, 255, 255));
        NomMagasin.setText("Nom magasin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(N_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NomMagasin, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(N_bon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NomMagasin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        time.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        time.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        time.setText("jLabel10");
        time.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        DateVente.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        DateVente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DateVente.setText("date de vente");
        DateVente.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        myButton1.setBackground(new java.awt.Color(0, 172, 126));
        myButton1.setForeground(new java.awt.Color(255, 255, 255));
        myButton1.setText("1");
        myButton1.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton1.setColor(new java.awt.Color(0, 172, 126));
        myButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        myButton1.setRadius(500);
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        myButton2.setBackground(new java.awt.Color(0, 172, 126));
        myButton2.setForeground(new java.awt.Color(255, 255, 255));
        myButton2.setText("2");
        myButton2.setBorderColor(new java.awt.Color(255, 255, 255));
        myButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        myButton2.setRadius(500);
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DateVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateVente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(time, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        select_product.setBackground(new java.awt.Color(51, 204, 0));
        select_product.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        select_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_sync_white.png"))); // NOI18N
        select_product.setToolTipText("Ajouter un produit a la liste de vente");
        select_product.setAlignmentY(0.0F);
        select_product.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        select_product.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        select_product.setName("name"); // NOI18N
        select_product.setPreferredSize(new java.awt.Dimension(57, 50));
        select_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_productActionPerformed(evt);
            }
        });

        QuantiteRem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        QuantiteRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        QuantiteRem.setText("Qte");
        QuantiteRem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        QuantiteRem.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        QuantiteRem.setPreferredSize(new java.awt.Dimension(121, 50));
        QuantiteRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantiteRemActionPerformed(evt);
            }
        });

        QuantiteAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        QuantiteAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        QuantiteAdd.setText("Qte");
        QuantiteAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        QuantiteAdd.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        QuantiteAdd.setPreferredSize(new java.awt.Dimension(121, 50));
        QuantiteAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantiteAddActionPerformed(evt);
            }
        });

        CodeBarre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CodeBarre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CodeBarre.setToolTipText("Code Barre");
        CodeBarre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        CodeBarre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CodeBarre.setPreferredSize(new java.awt.Dimension(60, 22));
        CodeBarre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        CodeBarre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodeBarreKeyReleased(evt);
            }
        });

        B_balance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b3.png"))); // NOI18N
        B_balance.setToolTipText("Vente par balance");
        B_balance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_balanceActionPerformed(evt);
            }
        });

        Detail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Detail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngegg(1).png"))); // NOI18N
        Detail.setText("Détail");
        Detail.setToolTipText("Détail produit");
        Detail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Detail.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mzi.cdepzxus1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(select_product, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_balance, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Detail, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QuantiteRem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(QuantiteAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuantiteAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(QuantiteRem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(B_balance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(select_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CodeBarre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CodeBarre.getAccessibleContext().setAccessibleName("");

        jPanelRaccourci.setToolTipText("Les produits favorites");

        b1.setText("Fav1");
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b1MouseReleased(evt);
            }
        });
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setText("Fav2");
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b2MouseReleased(evt);
            }
        });
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setText("Fav3");
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b3MouseReleased(evt);
            }
        });
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setText("Fav4");
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b4MouseReleased(evt);
            }
        });
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setText("Fav5");
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b5MouseReleased(evt);
            }
        });
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setText("Fav6");
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b6MouseReleased(evt);
            }
        });
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b7.setText("Fav7");
        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b7MouseReleased(evt);
            }
        });
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setText("Fav8");
        b8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b8MouseReleased(evt);
            }
        });
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b9.setText("Fav9");
        b9.setMaximumSize(new java.awt.Dimension(63, 23));
        b9.setMinimumSize(new java.awt.Dimension(63, 23));
        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b9MouseReleased(evt);
            }
        });
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        b10.setText("Fav10");
        b10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b10MouseReleased(evt);
            }
        });
        b10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b10ActionPerformed(evt);
            }
        });

        b11.setText("Fav11");
        b11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b11MouseReleased(evt);
            }
        });
        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });

        b12.setText("Fav12");
        b12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b12MouseReleased(evt);
            }
        });
        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });

        b13.setText("Fav13");
        b13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b13MouseReleased(evt);
            }
        });
        b13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13ActionPerformed(evt);
            }
        });

        b14.setText("Fav14");
        b14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b14MouseReleased(evt);
            }
        });
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });

        b15.setText("Fav15");
        b15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b15MouseReleased(evt);
            }
        });
        b15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15ActionPerformed(evt);
            }
        });

        b16.setText("Fav16");
        b16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b16MouseReleased(evt);
            }
        });
        b16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16ActionPerformed(evt);
            }
        });

        b17.setText("Fav17");
        b17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b17MouseReleased(evt);
            }
        });
        b17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b17ActionPerformed(evt);
            }
        });

        b18.setText("Fav18");
        b18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b18MouseReleased(evt);
            }
        });
        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });

        b19.setText("Fav19");
        b19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b19MouseReleased(evt);
            }
        });
        b19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19ActionPerformed(evt);
            }
        });

        b20.setText("Fav20");
        b20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                b20MouseReleased(evt);
            }
        });
        b20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRaccourciLayout = new javax.swing.GroupLayout(jPanelRaccourci);
        jPanelRaccourci.setLayout(jPanelRaccourciLayout);
        jPanelRaccourciLayout.setHorizontalGroup(
            jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRaccourciLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRaccourciLayout.createSequentialGroup()
                        .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRaccourciLayout.createSequentialGroup()
                        .addComponent(b5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRaccourciLayout.createSequentialGroup()
                        .addComponent(b9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRaccourciLayout.createSequentialGroup()
                        .addComponent(b13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRaccourciLayout.createSequentialGroup()
                        .addComponent(b17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(b20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanelRaccourciLayout.setVerticalGroup(
            jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRaccourciLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanelRaccourciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(452, 140));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanelOptionImpression.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)), "Type", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelOptionImpression.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        GroupImpri.add(jRadioFacture);
        jRadioFacture.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioFacture.setText("Facture");
        jRadioFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFactureActionPerformed(evt);
            }
        });

        GroupImpri.add(jRadioBonLivraison);
        jRadioBonLivraison.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioBonLivraison.setText("Bon de livraison");
        jRadioBonLivraison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBonLivraisonActionPerformed(evt);
            }
        });

        GroupImpri.add(jRadioTicket);
        jRadioTicket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioTicket.setSelected(true);
        jRadioTicket.setText("Ticket");
        jRadioTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTicketActionPerformed(evt);
            }
        });

        GroupImpri.add(jRadioFactureProformat);
        jRadioFactureProformat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioFactureProformat.setText("Facture proformat");
        jRadioFactureProformat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFactureProformatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOptionImpressionLayout = new javax.swing.GroupLayout(jPanelOptionImpression);
        jPanelOptionImpression.setLayout(jPanelOptionImpressionLayout);
        jPanelOptionImpressionLayout.setHorizontalGroup(
            jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionImpressionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioFactureProformat)
                    .addComponent(jRadioBonLivraison)
                    .addGroup(jPanelOptionImpressionLayout.createSequentialGroup()
                        .addComponent(jRadioFacture)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioTicket)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOptionImpressionLayout.setVerticalGroup(
            jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionImpressionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jRadioBonLivraison)
                .addGap(1, 1, 1)
                .addGroup(jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioFacture)
                    .addComponent(jRadioTicket))
                .addGap(1, 1, 1)
                .addComponent(jRadioFactureProformat)
                .addGap(0, 0, 0))
        );

        jPanel1.add(jPanelOptionImpression);

        jPanelTicketFormat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ticket format", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelTicketFormat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        GroupTicket.add(jRadioETQ80);
        jRadioETQ80.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioETQ80.setText("ETQ 80");
        jRadioETQ80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioETQ80ActionPerformed(evt);
            }
        });

        GroupTicket.add(jRadioA5);
        jRadioA5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioA5.setText("A5");
        jRadioA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioA5ActionPerformed(evt);
            }
        });

        GroupTicket.add(jRadioETQ55);
        jRadioETQ55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioETQ55.setSelected(true);
        jRadioETQ55.setText("ETQ 55");
        jRadioETQ55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioETQ55ActionPerformed(evt);
            }
        });

        GroupTicket.add(jRadioA4);
        jRadioA4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioA4.setText("A4");
        jRadioA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioA4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTicketFormatLayout = new javax.swing.GroupLayout(jPanelTicketFormat);
        jPanelTicketFormat.setLayout(jPanelTicketFormatLayout);
        jPanelTicketFormatLayout.setHorizontalGroup(
            jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTicketFormatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioETQ55, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioETQ80, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioA4)
                    .addComponent(jRadioA5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTicketFormatLayout.setVerticalGroup(
            jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTicketFormatLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioETQ80)
                    .addComponent(jRadioA5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioA4)
                    .addComponent(jRadioETQ55))
                .addGap(0, 0, 0))
        );

        jPanel1.add(jPanelTicketFormat);

        jPanelPrixVente2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prix de vente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        GroupPrix.add(jRadioDetail2);
        jRadioDetail2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioDetail2.setSelected(true);
        jRadioDetail2.setText("Prix detail");
        jRadioDetail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioDetail2jRadioDetailActionPerformed(evt);
            }
        });

        GroupPrix.add(jRadioGros);
        jRadioGros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioGros.setText("Prix gros");
        jRadioGros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioGrosjRadioGrosActionPerformed(evt);
            }
        });

        GroupPrix.add(jRadioSpecial);
        jRadioSpecial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioSpecial.setText("Prix Spécial");
        jRadioSpecial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSpecialjRadioGrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrixVente2Layout = new javax.swing.GroupLayout(jPanelPrixVente2);
        jPanelPrixVente2.setLayout(jPanelPrixVente2Layout);
        jPanelPrixVente2Layout.setHorizontalGroup(
            jPanelPrixVente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrixVente2Layout.createSequentialGroup()
                .addGroup(jPanelPrixVente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioDetail2)
                    .addComponent(jRadioGros)
                    .addComponent(jRadioSpecial))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanelPrixVente2Layout.setVerticalGroup(
            jPanelPrixVente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrixVente2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jRadioDetail2)
                .addGap(1, 1, 1)
                .addComponent(jRadioGros)
                .addGap(1, 1, 1)
                .addComponent(jRadioSpecial)
                .addGap(1, 1, 1))
        );

        jPanel1.add(jPanelPrixVente2);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Nouveau Crédit");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ancien Crédit");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Client");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        nvcredit.setEditable(false);
        nvcredit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nvcredit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nvcredit.setText("0");

        Ancien_credit.setEditable(false);
        Ancien_credit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Ancien_credit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Ancien_credit.setText("0");

        nom_client.setEditable(false);
        nom_client.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_client.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nom_client.setText("Passager");

        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com(3).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nvcredit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ancien_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom_client, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nom_client, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nvcredit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ancien_credit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setLayout(new java.awt.BorderLayout(1, 6));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        Annuler.setBackground(new java.awt.Color(204, 204, 204));
        Annuler.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Annuler.setForeground(new java.awt.Color(255, 255, 255));
        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel7.add(Annuler);

        Valider_Achat_BTN.setBackground(new java.awt.Color(204, 204, 204));
        Valider_Achat_BTN.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Valider_Achat_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Valider_Achat_BTN.setText("Valider sans imprimer");
        Valider_Achat_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Valider_Achat_BTNActionPerformed(evt);
            }
        });
        jPanel7.add(Valider_Achat_BTN);

        Imprimer_BTN.setBackground(new java.awt.Color(0, 153, 255));
        Imprimer_BTN.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Imprimer_BTN.setForeground(new java.awt.Color(255, 255, 255));
        Imprimer_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-30.png"))); // NOI18N
        Imprimer_BTN.setText("Valider et imprimer ");
        Imprimer_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimer_BTNActionPerformed(evt);
            }
        });
        jPanel7.add(Imprimer_BTN);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new java.awt.GridLayout(2, 4));

        Arendu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Arendu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Arendu.setText("A rendu");
        Arendu.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel6.add(Arendu);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Versement");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel6.add(jLabel7);

        jLabel2.setBackground(new java.awt.Color(153, 255, 153));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total apres remise");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel6.add(jLabel2);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Remise");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel6.add(jLabel5);

        A_rendu.setEditable(false);
        A_rendu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        A_rendu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        A_rendu.setText("0");
        jPanel6.add(A_rendu);

        montant_verser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        montant_verser.setText("0");
        montant_verser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        montant_verser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                montant_verserMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                montant_verserMousePressed(evt);
            }
        });
        montant_verser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                montant_verserKeyReleased(evt);
            }
        });
        jPanel6.add(montant_verser);

        Total_Apres_Remise.setEditable(false);
        Total_Apres_Remise.setBackground(new java.awt.Color(0, 0, 0));
        Total_Apres_Remise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Total_Apres_Remise.setForeground(new java.awt.Color(51, 255, 51));
        Total_Apres_Remise.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Total_Apres_Remise.setText("0");
        jPanel6.add(Total_Apres_Remise);

        TFremise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TFremise.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFremise.setText("0");
        TFremise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TFremiseMouseExited(evt);
            }
        });
        TFremise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFremiseKeyReleased(evt);
            }
        });
        jPanel6.add(TFremise);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Caisse de versement");

        Caisse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Caisse.setPreferredSize(new java.awt.Dimension(56, 28));

        javax.swing.GroupLayout jPanel_CaisseLayout = new javax.swing.GroupLayout(jPanel_Caisse);
        jPanel_Caisse.setLayout(jPanel_CaisseLayout);
        jPanel_CaisseLayout.setHorizontalGroup(
            jPanel_CaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CaisseLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caisse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_CaisseLayout.setVerticalGroup(
            jPanel_CaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_CaisseLayout.createSequentialGroup()
                .addGroup(jPanel_CaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_CaisseLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Caisse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelRaccourci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_Caisse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(6, 6, 6))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(jPanelRaccourci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jPanel_Caisse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_productActionPerformed
    // new RechercherProduit(1,"").setVisible(true);
   //  if(ListPrintBon.size()>ListVente.size())ListPrintBon.clear();
   switch(numClient){
       case 1: RechercherProduitVendre.getObj(px,Aucceuil.userName,0). setVisible(true);break;
       default:RechercherProduitVendre.getObj(px2,Aucceuil.userName,0). setVisible(true);break;
   }
  // this.setVisible(false);
     //  Sup.setVisible(true);
   //System.out.println( "value ="+jTable1.getModel().getValueAt(0, 1));
    }//GEN-LAST:event_select_productActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        switch(numClient){
            case 1: RechercherClient.getObj(1).setVisible(true);RechercherClient.jButton1.setVisible(true);break;
         default: RechercherClient.getObj(2).setVisible(true);RechercherClient.jButton1.setVisible(true);break;
        }
      //  CodeBarre.requestFocus();
//        System.out.println("f="+ListAchat.get(0).getNom_prénom_fournisseur());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Valider_Achat_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_Achat_BTNActionPerformed
{  Valider(numClient);
        try {
            init(numClient);
      
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
 
         }
    }//GEN-LAST:event_Valider_Achat_BTNActionPerformed

    private void montant_verserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montant_verserKeyReleased
         tnb.numOnly(TFremise);
       if(c1)  try{
           if(type.equals("ajouter")) 
              if(numClient==1) dette=f.getCrédit();else dette2=f2.getCrédit();
               }catch (Exception e ){}
        try{                    
             if(numClient==1)    total_apres_remise=total-remise;
             else  total_apres_remise2=total2-remise2;
             
              if(numClient==1)     m_verse= Double.parseDouble(montant_verser.getText());
              else m_verse2= Double.parseDouble(montant_verser.getText());
              if(numClient==1){
                if(m_verse>=total_apres_remise+dette){nv_credit=0;a_rendu=m_verse-(total_apres_remise+dette);}
              else if(total_apres_remise>m_verse) {nv_credit=dette+(total_apres_remise-m_verse); a_rendu=0;}
              
               else {if(dette==0){a_rendu=(m_verse-total_apres_remise);nv_credit=0;  }
               else{ a_rendu=0;nv_credit=Math.abs((m_verse-total_apres_remise)-dette);}
               }
      A_rendu.setText(tnb.Afficher2Verguile(a_rendu));
         nvcredit.setText(tnb.Afficher2Verguile(nv_credit)); 
              } else {
                if(m_verse2>=total_apres_remise2+dette2){nv_credit2=0;a_rendu2=m_verse2-(total_apres_remise2+dette2);}
              else if(total_apres_remise2>m_verse2) {nv_credit2=dette2+(total_apres_remise2-m_verse2); a_rendu2=0;}
              
               else {if(dette2==0){a_rendu2=(m_verse2-total_apres_remise2);nv_credit2=0;  }
               else{ a_rendu2=0;nv_credit2=Math.abs((m_verse2-total_apres_remise2)-dette2);}
               }
      A_rendu.setText(tnb.Afficher2Verguile(a_rendu2));
      nvcredit.setText(tnb.Afficher2Verguile(nv_credit2)); 
              
              }
        }
catch (Exception e){dette=0;
 montant_verser.setText("0");
                   }
    
    }//GEN-LAST:event_montant_verserKeyReleased

    private void Imprimer_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimer_BTNActionPerformed
                   try {                                             
                //     System.out.println("m_verse="+m_verse);
                 //    System.out.println("total_apres_remise="+total_apres_remise);  
                     
                  //    System.out.println("m_verse2="+m_verse2);
                  //   System.out.println("total_apres_remise2="+total_apres_remise2); 
                       switch(numClient){
                           case 1:{
                       try {
                            if(ListVente.isEmpty())
            tools.ShowFailMessage(this, "Veuiller ajouter des produits au liste ");
                            else {
                     if(f.getNom_prénom_client().equals("Passager")&&(m_verse<total_apres_remise)&&(total_apres_remise>0)) { tools.ShowFailMessage(this, "Crédit non autoriser pour un Client passager");}else   { Valider(1);   imprimer();  
                   try{  init(1);}catch(Exception e){}
                     }
                                 }
                       } catch (PrinterException ex) {
                           Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                       }
                   
                           }
                           break;
                       
                       
                          default:{
                       try {
                           if(ListVente2.isEmpty())
            tools.ShowFailMessage(this, "Veuiller ajouter des produits au liste "); 
                           else {
                     if(f2.getNom_prénom_client().equals("Passager")&&(m_verse2<total_apres_remise2)&&(total_apres_remise2>0)) { tools.ShowFailMessage(this, "Crédit non autoriser pour un Client passager");}else { Valider(2);   imprimer();
                         try{  init(2);}catch(Exception e){}
                     }
                                  }
                       } catch (PrinterException ex) {
                           Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    
                          }
                          break;
                       
                                          }
                       
                   } catch (IOException ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_Imprimer_BTNActionPerformed

    private void TFremiseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFremiseKeyReleased
       tnb.numOnly(TFremise);
     if(c1) try{
         if(type.equals("ajouter")) if(numClient==1)dette=f.getCrédit();else dette2=f2.getCrédit();
               }
     catch (Exception e){dette=0;}
           if(numClient==1) try{ remise=Double.parseDouble(TFremise.getText());
                                }catch(Exception e){remise=0;}
        else remise2=Double.parseDouble(TFremise.getText());
        
        if(numClient==1){ 
              total_apres_remise=total-remise;
            try{  
                 Total_Apres_Remise.setText(tnb.Afficher2Verguile(total_apres_remise));
                // total_apres_remise=Double.parseDouble(TFtotal.getText());
               //  m_verse= Double.parseDouble(montant_verser.getText());
               //  nv_credit=dette+(total_apres_remise-m_verse);
                nv_credit= getNouveau_Crédit();
                 nvcredit.setText(tnb.Afficher2Verguile(nv_credit));
                 }catch(Exception e){dette=0;}      
                         }
        else {
            total_apres_remise2=total2-remise2;
             try{
                 Total_Apres_Remise.setText(tnb.Afficher2Verguile(total_apres_remise2));
                 //total_apres_remise2=Double.parseDouble(TFtotal.getText());
                // m_verse2= Double.parseDouble(montant_verser.getText());
                // nv_credit2=dette2+(total_apres_remise2-m_verse2);
                 nv_credit2= getNouveau_Crédit();
                  nvcredit.setText(tnb.Afficher2Verguile(nv_credit2));
                 }catch(Exception e){m_verse2=0;dette2=0;}
        
        }
       
    }//GEN-LAST:event_TFremiseKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     //  System.out.println("windows closing");
      obj=null; 
      obj2=null;
        try {
            init(1);
              init(2);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void TableVenteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableVenteMousePressed
  // if(c1) {
  
   if(column!=2)TableVente.getDefaultEditor(String.class).stopCellEditing();
       TableVente.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingCanceled(ChangeEvent e) {
                       // System.out.println(TableVente.getModel().getValueAt(0, 1)+"editingCanceled");
                    }

                    @Override
                    public void editingStopped(ChangeEvent e) {
                       row=TableVente.getSelectedRow();
                       row2=TableVente.getSelectedRow();
                     if  (numClient==1)
                   try{ quantite_vente=ListProduitQuantité.get(row);}catch(Exception e2){}
                     else  try{ quantite_vente2=ListProduitQuantité2.get(row2);}catch(Exception e2){}
                     
                if  (numClient==1) { try{   pvente=Double.parseDouble(TableVente.getModel().getValueAt(row, 2).toString());
                                          ListVente.get(row).setPrix_vente(pvente);
                                       }catch(Exception e2){
                           try {
                               TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente.get(row).getPrix_vente()), row, 2);
                           } catch (Exception ex) {
                               Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                           }  
                                       }
                                                            }
                else  try{   pvente2=Double.parseDouble(TableVente.getModel().getValueAt(row2, 2).toString());
                ListVente2.get(row2).setPrix_vente(pvente2);
                 }catch(Exception e3){
                   
                           try {
                               TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente2.get(row2).getPrix_vente()), row2, 2);
                               } 
                           catch (Exception ex) {
                               Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                           }
                                       }
     if  (numClient==1)      switch(px){
               case 'D':ListPr.get(row).setPrix_vente_detail(pvente);break;
               case 'G':ListPr.get(row).setPrix_vente_gros(pvente);break;
               default:ListPr.get(row).setPrix_special(pvente);break;
           }         
     else  switch(px2){
               case 'D':ListPr2.get(row2).setPrix_vente_detail(pvente2);break;
               case 'G':ListPr2.get(row2).setPrix_vente_gros(pvente2);break;
               default:ListPr2.get(row2).setPrix_special(pvente2);break;
           }         
                
                
                     try{
                     if  (numClient==1)    ListVente.get(row).setPrix_vente(pvente); else ListVente2.get(row2).setPrix_vente(pvente2);
                        }  
           catch (Exception ex){
             // System.out.println("ExcFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFn");
           }                     
      if  (numClient==1)      try{ TableVente.getModel().setValueAt(tnb.Afficher2Verguile(quantite_vente*pvente), row, 4);}catch(Exception e2){System.out.println("Exception é2");}
      else  try{ TableVente.getModel().setValueAt(tnb.Afficher2Verguile(quantite_vente2*pvente2), row2, 4);}catch(Exception e2){System.out.println("Exception é2");}
         if  (numClient==1)         total=getTotal(); else total2=getTotal();
       
        
                        try {
                         if  (numClient==1)    Total.setText( tnb.Afficher2Verguile(total));
                         else Total.setText( tnb.Afficher2Verguile(total2));
                            
                        } catch (Exception ex) {
                            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                        }
          if  (numClient==1)     remise=Double.parseDouble(TFremise.getText());
          else remise2=Double.parseDouble(TFremise.getText());
                        try {
                           if  (numClient==1)     Total_Apres_Remise.setText(tnb.Afficher2Verguile(total-remise));
                           else Total_Apres_Remise.setText(tnb.Afficher2Verguile(total2-remise2));
                        } catch (Exception ex) {
                            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                        }
  if  (numClient==1) {
           // m_verse=Double.parseDouble(montant_verser.getText());
            
           // total_apres_remise=Double.parseDouble(TFtotal.getText());
           // m_verse= Double.parseDouble(montant_verser.getText());
           // nv_credit=dette+(total_apres_remise-m_verse);
            nv_credit= getNouveau_Crédit();
            
  } else {
          //  m_verse2=Double.parseDouble(montant_verser.getText());
          //  total_apres_remise2=Double.parseDouble(TFtotal.getText());22222
          //  m_verse2= Double.parseDouble(montant_verser.getText());
          //  nv_credit2=dette2+(total_apres_remise2-m_verse2);
           nv_credit2= getNouveau_Crédit();
            
  }
                        try {
         if  (numClient==1)    nvcredit.setText(tnb.Afficher2Verguile(nv_credit));
         else nvcredit.setText(tnb.Afficher2Verguile(nv_credit2));
                        } catch (Exception ex) {
                            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                        }
  
                }});
 
 //CodeBarre.requestFocus();
    }//GEN-LAST:event_TableVenteMousePressed

    private void montant_verserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montant_verserMouseExited
 if  (numClient==1){
  montant_verser.setText(formatter.format(m_verse).replace(',', '.')+"");
  A_rendu.setText(formatter.format(a_rendu).replace(',', '.')+"");
                  }
 else {
  montant_verser.setText(formatter.format(m_verse2).replace(',', '.')+"");
  A_rendu.setText(formatter.format(a_rendu2).replace(',', '.')+"");
                  }
    }//GEN-LAST:event_montant_verserMouseExited

    private void TFremiseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFremiseMouseExited
 if  (numClient==1)
  TFremise.setText(formatter.format(remise).replace(',', '.')+"");
   else  TFremise.setText(formatter.format(remise2).replace(',', '.')+"");        
    }//GEN-LAST:event_TFremiseMouseExited

    private void QuantiteRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantiteRemActionPerformed
QteDown(numClient);
      
        //CodeBarre.requestFocus();
    }//GEN-LAST:event_QuantiteRemActionPerformed

    private void QuantiteAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantiteAddActionPerformed

     QteAdd(numClient);   
     // CodeBarre.requestFocus();
    }//GEN-LAST:event_QuantiteAddActionPerformed

    private void jRadioBonLivraisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBonLivraisonActionPerformed
     option_imp="bon_livraison";
     jPanelTicketFormat.setVisible(false);
     montant_verser.setEditable(true);
    }//GEN-LAST:event_jRadioBonLivraisonActionPerformed

    private void jRadioDetail2jRadioDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioDetail2jRadioDetailActionPerformed
if(numClient==1)radioDetail( px, total, ListVente, ListPr, prix_u, ListProduitQuantité, remise, total_apres_remise, dette, f, m_verse, nv_credit);
else radioDetail( px2, total2, ListVente2, ListPr2, prix_u2, ListProduitQuantité2, remise2, total_apres_remise2, dette2, f2, m_verse2, nv_credit2);
    }//GEN-LAST:event_jRadioDetail2jRadioDetailActionPerformed

    private void jRadioGrosjRadioGrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioGrosjRadioGrosActionPerformed
 if(numClient==1)radioGros( px, total, ListVente, ListPr, prix_u, ListProduitQuantité, remise, total_apres_remise, dette, f, m_verse, nv_credit);
else radioGros( px2, total2, ListVente2, ListPr2, prix_u2, ListProduitQuantité2, remise2, total_apres_remise2, dette2, f2, m_verse2, nv_credit2);
    }//GEN-LAST:event_jRadioGrosjRadioGrosActionPerformed

    private void B_balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_balanceActionPerformed
       //    System.out.println(row);
        if(ListPr.isEmpty())
            tools.ShowFailMessage(this, "veuiller Sélectioner un produit ");
            //  JOptionPane.showMessageDialog(null, " veuiller Sélectioner un produit  ","",JOptionPane.WARNING_MESSAGE,img2);
        else {
           if(numClient==1) try{Balance.getObj(ListVente.get(row).getDésignation(),ListVente.get(row).getQuantité_vente(),
            ListVente.get(row).getPrix_vente(),row, ListPr.get(row).getUnite()).setVisible(true);}catch(Exception ee){}
           else try{Balance.getObj(ListVente2.get(row2).getDésignation(),ListVente2.get(row2).getQuantité_vente(),
            ListVente2.get(row2).getPrix_vente(),row2, ListPr2.get(row2).getUnite()).setVisible(true);}catch(Exception ee){}
        }
    }//GEN-LAST:event_B_balanceActionPerformed

    private void b1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseReleased
    //    if(evt.getButton() == MouseEvent.BUTTON3){System.out.println("Button3");}
       if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
                
               RechercherProduitVendre.getObj('f', user,1).setVisible(true);
             
              
            }
        });
   ListDel[0]= new JMenuItem("Supprimer un produit favorite");
    ListDel[0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(0)!=null) { pop.ModifierFavorite(ListPrFavorite.get(0).getId_produit(), 0);
                    ListPrFavorite.set(0, null); 
                   
                   }
                    b1.setText("Fav1");
                    b1.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b1.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
             
               
            }
        });
  jpm.removeAll();
  
jpm.add(add);

jpm.add(ListDel[0]);

         jpm.show(b1, evt.getX(), evt.getY());


       }
    }//GEN-LAST:event_b1MouseReleased

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        try {
            //  System.out.println( ListPrFavorite.get(0).toString());
            AddProdFav(0);
             } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }//GEN-LAST:event_b1ActionPerformed

    private void b2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseReleased
      if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,2).setVisible(true);
             
            }
        });
   
   ListDel[1]= new JMenuItem("Supprimer un produit favorite");
    ListDel[1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(1)!=null) { pop.ModifierFavorite(ListPrFavorite.get(1).getId_produit(), 0);
                    ListPrFavorite.set(1, null); 
                   
                   }
                    b2.setText("Fav2");
                    b2.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b2.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
  jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[1]);
         jpm.show(b2, evt.getX(), evt.getY());
        

       }
    }//GEN-LAST:event_b2MouseReleased

    private void b3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseReleased
       if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,3).setVisible(true);
            }
        });
   
   ListDel[2]= new JMenuItem("Supprimer un produit favorite");
    ListDel[2].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(2)!=null) { pop.ModifierFavorite(ListPrFavorite.get(2).getId_produit(), 0);
                     ListPrFavorite.set(2, null); 
                   
                   }
                    b3.setText("Fav3");
                    b3.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b3.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
             
               
            }
        });
  jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[2]);
         jpm.show(b3, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b3MouseReleased

    private void b4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseReleased
        if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,4).setVisible(true);
            }
        });
  ListDel[3]= new JMenuItem("Supprimer un produit favorite");
    ListDel[3].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(3)!=null) { pop.ModifierFavorite(ListPrFavorite.get(3).getId_produit(), 0);
                      ListPrFavorite.set(3, null); 
                   
                   }
                    b4.setText("Fav4");
                    b4.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b4.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                } 
               
            }
        });
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[3]);
         jpm.show(b4, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b4MouseReleased

    private void b18MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b18MouseReleased
          if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,18).setVisible(true);
            }
        });
    ListDel[17]= new JMenuItem("Supprimer un produit favorite");
    ListDel[17].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(17)!=null) { pop.ModifierFavorite(ListPrFavorite.get(17).getId_produit(), 0);
                     ListPrFavorite.set(17, null); 
                   
                   }
                    b18.setText("Fav18");
                    b18.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b18.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }    
             
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[17]);
         jpm.show(b18, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b18MouseReleased

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     obj=null;
     obj2=null;
     this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void b5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseReleased
          if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,5).setVisible(true);
          
               
            }
        });
    ListDel[4]= new JMenuItem("Supprimer un produit favorite");
    ListDel[4].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(4)!=null) { pop.ModifierFavorite(ListPrFavorite.get(4).getId_produit(), 0);
                  ListPrFavorite.set(4, null); 
                   
                   }
                    b5.setText("Fav5");
                    b5.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b5.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }  
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[4]);
         jpm.show(b5, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b5MouseReleased

    private void b6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseReleased
       if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,6).setVisible(true);
             
               
            }
        });
  ListDel[5]= new JMenuItem("Supprimer un produit favorite");
    ListDel[5].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(5)!=null) { pop.ModifierFavorite(ListPrFavorite.get(5).getId_produit(), 0);
                    ListPrFavorite.set(5, null);  
                   
                   }
                    b6.setText("Fav6");
                    b6.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b6.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }             
               
            }
        });
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[5]);
         jpm.show(b6, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b6MouseReleased

    private void b7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseReleased
          if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,7).setVisible(true);
             
               
            }
        });
  ListDel[6]= new JMenuItem("Supprimer un produit favorite");
    ListDel[6].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             
             try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(6)!=null) { pop.ModifierFavorite(ListPrFavorite.get(6).getId_produit(), 0);
                     ListPrFavorite.set(6, null); 
                   
                   }
                    b7.setText("Fav7");
                    b7.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b7.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[6]);
         jpm.show(b7, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b7MouseReleased

    private void b8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b8MouseReleased
         if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,8).setVisible(true);
             
               
            }
        });
    ListDel[7]= new JMenuItem("Supprimer un produit favorite");
    ListDel[7].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(7)!=null) { pop.ModifierFavorite(ListPrFavorite.get(7).getId_produit(), 0);
                     ListPrFavorite.set(7, null); 
                   
                   }
                    b8.setText("Fav8");
                    b8.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b8.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[7]);
         jpm.show(b8, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b8MouseReleased

    private void b9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseReleased
         if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,9).setVisible(true);
             
               
            }
        });
   ListDel[8]= new JMenuItem("Supprimer un produit favorite");
    ListDel[8].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
             try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(8)!=null) { pop.ModifierFavorite(ListPrFavorite.get(8).getId_produit(), 0);
                   ListPrFavorite.set(8, null); 
                   
                   }
                    b9.setText("Fav9");
                    b9.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b9.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[8]);
         jpm.show(b9, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b9MouseReleased

    private void b10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MouseReleased
          if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,10).setVisible(true);
             
               
            }
        });
   ListDel[9]= new JMenuItem("Supprimer un produit favorite");
    ListDel[9].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
           try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(9)!=null) { pop.ModifierFavorite(ListPrFavorite.get(9).getId_produit(), 0);
                      ListPrFavorite.set(9, null); 
                   
                   }
                    b10.setText("Fav10");
                    b10.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b10.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }  
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[9]);
         jpm.show(b10, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b10MouseReleased

    private void b11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseReleased
          if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,11).setVisible(true);
             
               
            }
        });
    ListDel[10]= new JMenuItem("Supprimer un produit favorite");
    ListDel[10].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             
             try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(10)!=null) { pop.ModifierFavorite(ListPrFavorite.get(10).getId_produit(), 0);
                    ListPrFavorite.set(10, null);  
                   
                   }
                    b11.setText("Fav11");
                    b11.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b11.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[10]);
         jpm.show(b11, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b11MouseReleased

    private void b12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseReleased
         if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,12).setVisible(true);
             
               
            }
        });
   ListDel[11]= new JMenuItem("Supprimer un produit favorite");
    ListDel[11].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
      try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(11)!=null) { pop.ModifierFavorite(ListPrFavorite.get(11).getId_produit(), 0);
                    ListPrFavorite.set(11, null); 
                   
                   }
                    b12.setText("Fav12");
                    b12.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b12.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }       
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[11]);
         jpm.show(b12, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b12MouseReleased

    private void b13MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b13MouseReleased
         if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,13).setVisible(true);
             
               
            }
        });
 ListDel[12]= new JMenuItem("Supprimer un produit favorite");
    ListDel[12].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
       try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(12)!=null) { pop.ModifierFavorite(ListPrFavorite.get(12).getId_produit(), 0);
                     ListPrFavorite.set(12, null); 
                   
                   }
                    b13.setText("Fav13");
                    b13.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b13.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }       
             
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[12]);
         jpm.show(b13, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b13MouseReleased

    private void b14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b14MouseReleased
         if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,14).setVisible(true);
             
               
            }
        });
   ListDel[13]= new JMenuItem("Supprimer un produit favorite");
    ListDel[13].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
             try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(13)!=null) { pop.ModifierFavorite(ListPrFavorite.get(13).getId_produit(), 0);
                     ListPrFavorite.set(13, null); 
                   
                   }
                    b14.setText("Fav14");
                    b14.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b14.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[13]);
         jpm.show(b14, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b14MouseReleased

    private void b15MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b15MouseReleased
        if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,15).setVisible(true);
             
               
            }
        });
   ListDel[14]= new JMenuItem("Supprimer un produit favorite");
    ListDel[14].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(14)!=null) { pop.ModifierFavorite(ListPrFavorite.get(14).getId_produit(), 0);
                     ListPrFavorite.set(14, null); 
                   
                   }
                    b15.setText("Fav15");
                    b15.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b15.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }  
               
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[14]);
         jpm.show(b15, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b15MouseReleased

    private void b16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b16MouseReleased
         if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,16).setVisible(true);
             
               
            }
        });
   ListDel[15]= new JMenuItem("Supprimer un produit favorite");
    ListDel[15].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
             try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(15)!=null) { pop.ModifierFavorite(ListPrFavorite.get(15).getId_produit(), 0);
                     ListPrFavorite.set(15, null); 
                   
                   }
                    b16.setText("Fav16");
                    b16.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b16.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[15]);
         jpm.show(b16, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b16MouseReleased

    private void b17MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b17MouseReleased
           if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,17).setVisible(true);
             
               
            }
        });
   ListDel[16]= new JMenuItem("Supprimer un produit favorite");
    ListDel[16].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
               try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(16)!=null) { pop.ModifierFavorite(ListPrFavorite.get(16).getId_produit(), 0);
                     ListPrFavorite.set(16, null); 
                   
                   }
                    b17.setText("Fav17");
                    b17.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b17.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[16]);
         jpm.show(b17, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b17MouseReleased

    private void b19MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b19MouseReleased
           if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,19).setVisible(true);
             
               
            }
        });
    ListDel[18]= new JMenuItem("Supprimer un produit favorite");
    ListDel[18].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
       try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(18)!=null) { pop.ModifierFavorite(ListPrFavorite.get(18).getId_produit(), 0);
                    ListPrFavorite.set(18, null); 
                   
                   }
                    b19.setText("Fav19");
                    b19.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b19.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }      
              
            }
        });
  
jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[18]);
         jpm.show(b19, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b19MouseReleased

    private void b20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b20MouseReleased
          if(evt.isPopupTrigger()){
            //System.out.println("clique droite");
   add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               //System.out.println("action performed");
               RechercherProduitVendre.getObj('f', user,20).setVisible(true);
             
               
            }
        });
   ListDel[19]= new JMenuItem("Supprimer un produit favorite");
    ListDel[19].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
               try {
                    //System.out.println("action performed");
                   if( ListPrFavorite.get(19)!=null) { pop.ModifierFavorite(ListPrFavorite.get(19).getId_produit(), 0);
                     ListPrFavorite.set(19, null); 
                   
                   }
                    b20.setText("Fav20");
                    b20.setFont(new java.awt.Font("Tahoma", 0, 11));
                    b20.setBackground(new Color(240,240,240));
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
 jpm.removeAll();
jpm.add(add);
jpm.add(ListDel[19]);
         jpm.show(b20, evt.getX(), evt.getY());

       }
    }//GEN-LAST:event_b20MouseReleased

    private void jRadioSpecialjRadioGrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSpecialjRadioGrosActionPerformed
      
    if(numClient==1)radioSpecial( px, total, ListVente, ListPr, prix_u, ListProduitQuantité, remise, total_apres_remise, dette, f, m_verse, nv_credit);
else radioSpecial( px2, total2, ListVente2, ListPr2, prix_u2, ListProduitQuantité2, remise2, total_apres_remise2, dette2, f2, m_verse2, nv_credit2);          
              
    }//GEN-LAST:event_jRadioSpecialjRadioGrosActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        try {
            AddProdFav(1);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        try {
            AddProdFav(2);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        try {
            AddProdFav(3);
            // TODO add your handling code here:
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        try {
            // TODO add your handling code here:
            AddProdFav(4);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        try {
            // TODO add your handling code here:
            AddProdFav(5);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        try {
            // TODO add your handling code here:
            AddProdFav(6);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        try {
            AddProdFav(7);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        try {
            AddProdFav(8);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b9ActionPerformed

    private void b10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b10ActionPerformed
        try {
            AddProdFav(9);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b10ActionPerformed

    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b11ActionPerformed
        try {
            AddProdFav(10);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b11ActionPerformed

    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b12ActionPerformed
        try {
            AddProdFav(11);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b12ActionPerformed

    private void b13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b13ActionPerformed
        try {
            AddProdFav(12);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b13ActionPerformed

    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b14ActionPerformed
        try {
            AddProdFav(13);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b14ActionPerformed

    private void b15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b15ActionPerformed
        try {
            AddProdFav(14);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b15ActionPerformed

    private void b16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b16ActionPerformed
        try {
            AddProdFav(15);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b16ActionPerformed

    private void b17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b17ActionPerformed
        try {
            AddProdFav(16);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b17ActionPerformed

    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b18ActionPerformed
        try {
            AddProdFav(17);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b18ActionPerformed

    private void b19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b19ActionPerformed
        try {
            AddProdFav(18);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b19ActionPerformed

    private void b20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b20ActionPerformed
        try {
            AddProdFav(19);
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b20ActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
     Annuler(numClient);
    }//GEN-LAST:event_AnnulerActionPerformed

    private void jRadioTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTicketActionPerformed
      option_imp="ticket";
      jPanelTicketFormat.setVisible(true);
        montant_verser.setEditable(true);
    }//GEN-LAST:event_jRadioTicketActionPerformed

    private void jRadioFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFactureActionPerformed
          option_imp="facture";
      jPanelTicketFormat.setVisible(false);
      montant_verser.setEditable(true);
    }//GEN-LAST:event_jRadioFactureActionPerformed

    private void jRadioFactureProformatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFactureProformatActionPerformed
          option_imp="facture_proforma";
      jPanelTicketFormat.setVisible(false);
      montant_verser.setEditable(false);
    }//GEN-LAST:event_jRadioFactureProformatActionPerformed

    private void jRadioETQ80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioETQ80ActionPerformed
        ticket_forma="ETQ80";
    }//GEN-LAST:event_jRadioETQ80ActionPerformed

    private void jRadioETQ55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioETQ55ActionPerformed
          ticket_forma="ETQ55";
    }//GEN-LAST:event_jRadioETQ55ActionPerformed

    private void jRadioA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioA5ActionPerformed
         ticket_forma="A5";
    }//GEN-LAST:event_jRadioA5ActionPerformed

    private void jRadioA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioA4ActionPerformed
          ticket_forma="A4";
    }//GEN-LAST:event_jRadioA4ActionPerformed

    private void DetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailActionPerformed
 if(numClient==1) detailClique( ListPr, row);
 else  detailClique( ListPr2, row2);
    }//GEN-LAST:event_DetailActionPerformed

    private void montant_verserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montant_verserMousePressed
//      montant_verser.setText("");
   // if(option_imp.equals("facture_proforma"))  tools.ShowFailMessage(this, "Versement non autorisé pour une facture proforma");
    }//GEN-LAST:event_montant_verserMousePressed

    private void CodeBarreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeBarreKeyReleased
if(numClient==1)codeBarreKeyRelease( evt , m_verse, total_apres_remise, f, ListPr, ListProduitQuantité, ListVente, prix_u, px, remise, num_bon, a_rendu, total, dette, nv_credit);
else codeBarreKeyRelease( evt , m_verse2, total_apres_remise2, f2, ListPr2, ListProduitQuantité2, ListVente2, prix_u2, px2, remise2, num_bon2, a_rendu2, total2, dette2, nv_credit2);
    }//GEN-LAST:event_CodeBarreKeyReleased

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
    numClient=1; 
   // System.out.println("numClient="+numClient);
switchClient(numClient);
//myButton1.setBackground( Color.BLUE);
myButton1.setColor(Color.red);
myButton2.setBackground(new Color(0,172,126));    
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
       numClient=2; 
     //  System.out.println("numClient="+numClient);
       switchClient(numClient);
       myButton2.setColor(Color.red);
       myButton1.setBackground(new Color(0,172,126));   
    }//GEN-LAST:event_myButton2ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
   /* System.out.println("form.getKeypressed()="+evt.getKeyCode());
        if(evt.getKeyCode()==10){  Valider(numClient);
        try {
            init(numClient);
      
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
 
         }*/
    }//GEN-LAST:event_formKeyPressed

    private void jScrollPane1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1KeyPressed

    private void TableVenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableVenteKeyPressed
   /*(evt.getKeyCode()==10){  Valider(numClient);
        try {
            init(numClient);
      
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
 
         }*/
    }//GEN-LAST:event_TableVenteKeyPressed

    private void jPanel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2KeyPressed
       /* System.out.println("panel2="+evt.getKeyCode());
        if(evt.getKeyCode()==10){  Valider(numClient);
        try {
            init(numClient);
      
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
 
         }*/
    }//GEN-LAST:event_jPanel2KeyPressed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField A_rendu;
    public static javax.swing.JTextField Ancien_credit;
    private javax.swing.JButton Annuler;
    private javax.swing.JLabel Arendu;
    private javax.swing.JButton B_balance;
    private static javax.swing.JComboBox<String> Caisse;
    private javax.swing.JTextField CodeBarre;
    private javax.swing.JLabel DateVente;
    private javax.swing.JButton Detail;
    private javax.swing.ButtonGroup GroupImpri;
    private javax.swing.ButtonGroup GroupPrix;
    private javax.swing.ButtonGroup GroupTicket;
    private javax.swing.JButton Imprimer_BTN;
    private javax.swing.JLabel N_bon;
    private javax.swing.JLabel NomMagasin;
    private static javax.swing.JButton QuantiteAdd;
    private javax.swing.JButton QuantiteRem;
    private javax.swing.JTextField TFremise;
    public static javax.swing.JTable TableVente;
    public static javax.swing.JLabel Total;
    public static javax.swing.JTextField Total_Apres_Remise;
    private javax.swing.JButton Valider_Achat_BTN;
    public static javax.swing.JButton b1;
    public static javax.swing.JButton b10;
    public static javax.swing.JButton b11;
    public static javax.swing.JButton b12;
    public static javax.swing.JButton b13;
    public static javax.swing.JButton b14;
    public static javax.swing.JButton b15;
    public static javax.swing.JButton b16;
    public static javax.swing.JButton b17;
    public static javax.swing.JButton b18;
    public static javax.swing.JButton b19;
    public static javax.swing.JButton b2;
    public static javax.swing.JButton b20;
    public static javax.swing.JButton b3;
    public static javax.swing.JButton b4;
    public static javax.swing.JButton b5;
    public static javax.swing.JButton b6;
    public static javax.swing.JButton b7;
    public static javax.swing.JButton b8;
    public static javax.swing.JButton b9;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelOptionImpression;
    private javax.swing.JPanel jPanelPrixVente2;
    private javax.swing.JPanel jPanelRaccourci;
    private javax.swing.JPanel jPanelTicketFormat;
    private javax.swing.JPanel jPanel_Caisse;
    private javax.swing.JRadioButton jRadioA4;
    private javax.swing.JRadioButton jRadioA5;
    private javax.swing.JRadioButton jRadioBonLivraison;
    private javax.swing.JRadioButton jRadioDetail2;
    private javax.swing.JRadioButton jRadioETQ55;
    private javax.swing.JRadioButton jRadioETQ80;
    private javax.swing.JRadioButton jRadioFacture;
    private javax.swing.JRadioButton jRadioFactureProformat;
    private javax.swing.JRadioButton jRadioGros;
    private javax.swing.JRadioButton jRadioSpecial;
    private javax.swing.JRadioButton jRadioTicket;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.jkelany.jktextfield.numeric.JKNumericField montant_verser;
    private button.MyButton myButton1;
    private button.MyButton myButton2;
    public static javax.swing.JTextField nom_client;
    public static javax.swing.JTextField nvcredit;
    private javax.swing.JButton select_product;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables

    public void keyTypedCodeBarre(KeyEvent ke,double m_verse_,double total_apres_remise_,Client f_) {
       //   char c = ke.getKeyChar();
        switch(ke.getKeyCode())
        {
            case 112:Annuler(numClient);break;
            case 113:    if(f_.getNom_prénom_client().equals("Passager")&&(m_verse_<total_apres_remise_)&&(total_apres_remise_>0)){
     tools.ShowFailMessage(this, "Crédit non autoriser pour un Client passager");
     //JOptionPane.showMessageDialog(null, " Crédit non autoriser pour un Client passager    ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
 }
 else {  Valider(numClient);
        try {
            init(numClient);
      //    if( ListVente.isEmpty()) ListPrintBon.clear();
            //this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
 
         }
                break;
            case 114:
               try {                                             
                       Valider(numClient);
                       try {
                     if(f_.getNom_prénom_client().equals("Passager")&&(m_verse_<total_apres_remise_)) {}else     imprimer();
                       } catch (PrinterException ex) {
                           Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       try {
                      if(f_.getNom_prénom_client().equals("Passager")&&(m_verse_<total_apres_remise_)) {}else        init(numClient);
                           //this.dispose();
                       } catch (Exception ex) {
                           Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       
                       
                       
                       
                   } catch (IOException ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }   
                
                break;
            default:
  String ss=ke.getKeyChar()+"";
         
  ss=ss.replace('à', '0');
  ss=ss.replace('&', '1');
  ss=ss.replace('é', '2');
  ss=ss.replace('"', '3');
  ss=ss.replace("'", "4");
  ss=ss.replace('(', '5');
  ss=ss.replace('-', '6');
  ss=ss.replace('è', '7');
  ss=ss.replace('_', '8');
  ss=ss.replace('ç', '9');

 if (ss.charAt(0) >= '0' && ss.charAt(0) <= '9') {
    // System.out.println("entrer condition");
     s=s+ss;} 
 else  ke.consume();
    if(ke.getKeyChar()==KeyEvent.VK_ENTER){CodeBarre.setText(s); 
  //  System.out.println("fin de String");
    s="";
    }
 if(ke.getKeyChar()==KeyEvent.VK_BACK_SPACE) { CodeBarre.setText("");s="";
 
 
 
 }break;
        }
    }

   
    
    
void init(int NumC) throws Exception{
s="";
type="ajouter";
jRadioDetail2.setSelected(true);
obj=null;
obj2=null;
ListBouton.clear();
switch(NumC){
    case 1:{ListPr.clear();
            ListProduitQuantité.clear();
            pop.displayResult4(ListPr, TableVente, px, ListProduitQuantité);
            ListVente.clear();
            f=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
            pvente=0;
            total=0;
            quantite_vente=0;
            dette=0;
            remise=0;
            total_apres_remise=0;
            numVer=0;
            a_rendu=0;
            nv_credit=0;
            m_verse=0;
            etat="valider";
            ListVente.clear();
            px='D';
            myButton1.setBackground(new Color(0,204,0));
            break;
           }
    default:{
            ListPr2.clear();
            ListProduitQuantité2.clear();
            pop.displayResult4(ListPr2, TableVente, px2, ListProduitQuantité2);
            ListVente2.clear();
            f2=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
            pvente2=0;
            total2=0;
            quantite_vente2=0;
            dette2=0;
            remise2=0;
            total_apres_remise2=0;
            numVer2=0;
            a_rendu2=0;
            nv_credit2=0;
            m_verse2=0;
            etat2="valider";
            ListVente2.clear();
            px2='D';
            myButton2.setBackground(new Color(0,204,0));
            break;
            }

}



code=GenerateCodeBarre(); 
 try {
 num_bon=vop.GetNextBon();
 System.out.println("init execute");
     } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
N_bon.setText("N° bon:"+num_bon);

Ancien_credit.setText("0");

TFremise.setText("0");

nom_client.setText("Passager");
//nom_prenom_client="Passager";
A_rendu.setText("0");

TFremise.setText("0");

nvcredit.setText("0");
montant_verser.setText("0");

Total_Apres_Remise.setText("0");
//idf=0;
//ListProduitQuantitéAcheteAvantMod.clear();

Total.setText("0.00");

   } 
public void Valider(int numC){
 float nv_quantite=0;
    switch(numC){
     case 1:try{ 
   f.setNom_prénom_client(f.getNom_prénom_client());
 }
 catch(Exception e){
     f=f=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
     System.out.println("exception nom client ");
 }
        if(ListVente.isEmpty())
            tools.ShowFailMessage(this, "Veuiller ajouter des produits au liste ");
            //JOptionPane.showMessageDialog(null, " Veuiller ajouter des produits au liste    ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
        else if(f.getNom_prénom_client().equals("Passager")&&(m_verse<total_apres_remise)&&(total_apres_remise>0)){
            tools.ShowFailMessage(this, "Crédit non autoriser pour un Client passager  ");
           // JOptionPane.showMessageDialog(null, " Crédit non autoriser pour un Client passager    ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
        }
      
        else { 
                putDataSource(f);
                try{  para.put("some_word", an.convert( vop.getTotal_TTC(ListVente)));}catch(Exception e){}
                try{  para.put("dette", dette);}catch(Exception e){}
  
                for(int i=0;i<ListVente.size();i++){
                try {
                //  ListProduitQuantitéAcheteAvantMod.add( ListAchat.get(i).getQuantité());
                  //   System.out.println("ListProduitQuantité= "+ListProduitQuantité.get(i));
                  //   System.out.println("num bon de reception= "+ ListAchat.get(i).getNum_bon_réception());
                 ListVente.get(i).setMontantHT(ListVente.get(i).getPrix_vente()*ListVente.get(i).getQuantité_vente());
                 ListVente.get(i).setMontantTTC(ListVente.get(i).getPrix_vente()*ListVente.get(i).getQuantité_vente()+(ListVente.get(i).getPrix_vente()*ListVente.get(i).getQuantité_vente()*ListVente.get(i).getTVA()/100));
                 ListVente.get(i).setSomme_versé(m_verse);
                 ListVente.get(i).setRemise(remise);
                 ListVente.get(i).setRendu(a_rendu);
                 temp_vente=  DateFormat.getTimeInstance().format(new java.util.Date());
             
                 ListVente.get(i).setTemp_vente(temp_vente);
                 ListVente.get(i).setNum_bon(num_bon);
               //  ListAchat.get(i).setPrix_v_gros(ListPrixVenteGros.get(i));
                 ListVente.get(i).setDate_vente(date_vente);
            
                 ListVente.get(i).setNom_prénom_fournisseur(f.getNom_prénom_client());
                 ListVente.get(i).setIdc(f.getId_c());
         
              if(option_imp.equals("facture_proforma")) {ListVente.get(i).setEtat("invalide");
         
              }
                 ListVente.get(i).setCode(code);
          
      
      if(type.equals("ajouter")||ListProduitQuantitéAcheteAvantMod.get(i)==0) 
      
           vop.Inserer_vente(ListVente.get(i));
       else {
               vop.Modifier_vente(ListVente.get(i));
       
         vop.displayResult(ListVente,ListeDesVentes.Table_detail_vente);
            }
      
             //  System.out.println(" insertion au list d achat");
                  } catch (Exception ex) {
                //  System.out.println("Exception insertion");
                  ex.printStackTrace();
                  }
            
               try{
                 switch(type){
                     case "ajouter":{ if(!option_imp.equals("facture_proforma")) 
                         
                     {
                        nv_quantite=ListPr.get(i).getQuantité()-(ListVente.get(i).getQuantité_vente());
                         pop.modifier_ProduitQuantité(ListPr.get(i).getId_produit(),nv_quantite);
                       //System.out.println("option imp="+option_imp);
                     
                     }}break;
                     default:{
                         nv_quantite=ListPr.get(i).getQuantité()-(ListVente.get(i).getQuantité_vente()-
                        ListProduitQuantitéAcheteAvantMod.get(i)); 
                      
                         pop.modifier_ProduitQuantité(ListPr.get(i).getId_produit(),nv_quantite);
                         obj2=null;
                     }
                 }                   
             
            } catch (Exception ex) {
                Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
            }
                }

    
          try {
      if(type.equals("ajouter"))   vf.inserer_versement(new Versement(f.getNom_prénom_client(), date_vente,m_verse,f.getId_c(),etat,num_bon,"",Aucceuil.userName,dette,a_rendu));      
      else {
          
          vf.modifier_versement(num_bon, m_verse, etat);}
         if(!option_imp.equals("facture_proforma")){   
             cop.modifier_Dette_Client(f.getId_c(),nv_credit);
         }
   
          } catch (Exception ex) {
              Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
             
          }
       
    try{
        ListCaisse.get(Caisse.getSelectedIndex()).setMontant(ListCaisse.get(Caisse.getSelectedIndex()).getMontant()+m_verse); 
        System.out.println("montat cais="+ListCaisse.get(Caisse.getSelectedIndex()).getMontant());
          System.out.println("montat m_verse="+m_verse);
        caisse_op.modifier_Caisse(ListCaisse.get(Caisse.getSelectedIndex()));
        caisse_op.Encaissement_Décaissemnt(ListCaisse.get(Caisse.getSelectedIndex()).getNum(), m_verse, date_vente, DateFormat.getTimeInstance().format(new java.util.Date()) ,Aucceuil.userName, "Encaissement", "Encaissement", 0);
       }catch(Exception e){}
        }
     
     break;
     default:try{ 
   f2.setNom_prénom_client(f2.getNom_prénom_client());
 }
 catch(Exception e){
     f2=f2=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
     System.out.println("exception nom client ");
 }
        if(ListVente2.isEmpty())
            tools.ShowFailMessage(this, "Veuiller ajouter des produits au liste ");
            //JOptionPane.showMessageDialog(null, " Veuiller ajouter des produits au liste    ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
        else if(f2.getNom_prénom_client().equals("Passager")&&(m_verse2<total_apres_remise2)&&(total_apres_remise2>0)){
            tools.ShowFailMessage(this, "Crédit non autoriser pour un Client passager  ");
           // JOptionPane.showMessageDialog(null, " Crédit non autoriser pour un Client passager    ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
        }
      
        else { 
                putDataSource(f2);
                try{  para.put("some_word", an.convert( vop.getTotal_TTC(ListVente2)));}catch(Exception e){}
                try{  para.put("dette", dette2);}catch(Exception e){}
  
        for(int i=0;i<ListVente2.size();i++){
            try {
               
                 ListVente2.get(i).setMontantHT(ListVente2.get(i).getPrix_vente()*ListVente2.get(i).getQuantité_vente());
                 ListVente2.get(i).setMontantTTC(ListVente2.get(i).getPrix_vente()*ListVente2.get(i).getQuantité_vente()+(ListVente2.get(i).getPrix_vente()*ListVente2.get(i).getQuantité_vente()*ListVente2.get(i).getTVA()/100));
                 ListVente2.get(i).setSomme_versé(m_verse2);
                 ListVente2.get(i).setRemise(remise2);
                 ListVente2.get(i).setRendu(a_rendu2);
                 temp_vente=  DateFormat.getTimeInstance().format(new java.util.Date());
             
                 ListVente2.get(i).setTemp_vente(temp_vente);
                 ListVente2.get(i).setNum_bon(num_bon2);
               //  ListAchat.get(i).setPrix_v_gros(ListPrixVenteGros.get(i));
                 ListVente2.get(i).setDate_vente(date_vente);
            
                 ListVente2.get(i).setNom_prénom_fournisseur(f2.getNom_prénom_client());
                 ListVente2.get(i).setIdc(f2.getId_c());
         
              if(option_imp.equals("facture_proforma")) {ListVente2.get(i).setEtat("invalide");
         
              }
                 ListVente2.get(i).setCode(code);
          
      if(type.equals("ajouter")||ListProduitQuantitéAcheteAvantMod2.get(i)==0) 
      
           vop.Inserer_vente(ListVente2.get(i));
       else {
               vop.Modifier_vente(ListVente2.get(i));
       
         vop.displayResult(ListVente2,ListeDesVentes.Table_detail_vente);
            }
      
             //  System.out.println(" insertion au list d achat");
                  } catch (Exception ex) {
                //  System.out.println("Exception insertion");
                  ex.printStackTrace();
                  }
            
               try{
                 switch(type){
                     case "ajouter":{ if(!option_imp.equals("facture_proforma")) 
                         
                     {
                        nv_quantite=ListPr2.get(i).getQuantité()-(ListVente2.get(i).getQuantité_vente());
                         pop.modifier_ProduitQuantité(ListPr2.get(i).getId_produit(),nv_quantite);
                       //System.out.println("option imp="+option_imp);
                     
                     }}break;
                     default:{
                         nv_quantite=ListPr2.get(i).getQuantité()-(ListVente2.get(i).getQuantité_vente()-
                        ListProduitQuantitéAcheteAvantMod2.get(i)); 
                      
                         pop.modifier_ProduitQuantité(ListPr2.get(i).getId_produit(),nv_quantite);
                         obj2=null;
                     }
                 }                   
             
            } catch (Exception ex) {
                Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
            }
                }

    
          try {
      if(type.equals("ajouter"))   vf.inserer_versement(new Versement(f2.getNom_prénom_client(), date_vente,m_verse2,f2.getId_c(),etat2,num_bon2,"",Aucceuil.userName,dette2,a_rendu2));      
      else {
          
          vf.modifier_versement(num_bon2, m_verse2, etat2);}
         if(!option_imp.equals("facture_proforma")){   
             cop.modifier_Dette_Client(f2.getId_c(),nv_credit2);
         }
   
          } catch (Exception ex) {
              Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
             
          }
       
     
        }
     break;
 }
   c1=true;
  
  try{   Aucceuil.refrechEtatProduit();}catch (Exception e){}
   }
   void imprimer() throws IOException, JRException, PrinterException{
      JRBeanCollectionDataSource dataSource ;
      if(numClient==1)dataSource= new JRBeanCollectionDataSource(ListVente);
      else dataSource= new JRBeanCollectionDataSource(ListVente2);
   
  if((!ListPr.isEmpty()&&numClient==1)||(!ListPr2.isEmpty()&&numClient==2)){  
   switch(option_imp){
      
         case "bon_livraison":    print1 = JasperFillManager.fillReport("Bon_livraison1.jasper", para, dataSource);view(print1);break;
         case "facture": print2 = JasperFillManager.fillReport("facture_vente.jasper", para, dataSource); view(print2);break;      
         case "facture_proforma":   print3 = JasperFillManager.fillReport("facture_proformat1.jasper", para, dataSource);view(print3);break;
         case "ticket": 
         switch(ticket_forma){case "ETQ55":print4=  JasperFillManager.fillReport("ticket55.jasper", para, dataSource);if(p.getApercu_ticket()==1) SendToPrinter(print4);else view(print4);break;
                             case "ETQ80":  print5= JasperFillManager.fillReport("ticket80.jasper", para, dataSource);if(p.getApercu_ticket()==1) SendToPrinter(print5);else view(print5);break;
                             case "A4": print6= JasperFillManager.fillReport("ticketA4.jasper", para, dataSource);if(p.getApercu_ticket()==1) SendToPrinter(print6);else view(print6); break;
                             case "A5": print7= JasperFillManager.fillReport("ticketA5.jasper", para, dataSource);if(p.getApercu_ticket()==1) SendToPrinter(print7);else view(print7);break;
                            }   
                      }
    
       
  }
 
  // CodeBarre.requestFocus();
      
  
   }
   public void AddProdFav(int indexBouton) throws Exception{
 if(numClient==1){
       try{ 
int index=pop.getIndex(ListPr, ListPrFavorite.get(indexBouton).getId_produit());
try{
   //vop.AjouterProduit(ListPr, ListPrFavorite.get(indexBouton), px,index);
   vop.AjouterProduitV2( ListPr, ListPrFavorite.get(indexBouton), px, index, ListProduitQuantité, f, ListVente, m_verse, remise , num_bon, a_rendu);
}catch(Exception e){}
   
   pop.displayResult4(ListPr, TableVente,px,ListProduitQuantité);
   refrech(1);
  }catch(Exception e){}
 }else   {try{ 
int index=pop.getIndex(ListPr2, ListPrFavorite.get(indexBouton).getId_produit());
try{
  // vop.AjouterProduit(ListPr2, ListPrFavorite.get(indexBouton), px2,index);
   vop.AjouterProduitV2( ListPr2, ListPrFavorite.get(indexBouton), px2, index, ListProduitQuantité2, f2, ListVente2, m_verse2, remise2 , num_bon2, a_rendu2);
}catch(Exception e){}
   pop.displayResult4(ListPr2, TableVente,px2,ListProduitQuantité2);
   refrech(2);
  }catch(Exception e){}
 }
   }
   public void QteAdd(int numC){    
       switch (numC){
           case 1:{
             try{  quantite_vente=ListProduitQuantité.get(row);
        quantite_vente=quantite_vente+1;
      //  if(ListPr.get(row).getPrix_donner()>0){prix_u=ListPr.get(row).getPrix_donner();ListVente.get(row).setPrix_vente(prix_u);}
       // else   
            if(ListPr.get(row).getNbre_produit_packet()>1 && quantite_vente>= ListPr.get(row).getNbre_produit_packet())
           
            { 
        prix_u=ListPr.get(row).getPrix_vente_packet()/ListPr.get(row).getNbre_produit_packet();
        ListVente.get(row).setPrix_vente(prix_u);
            }
            else {
             switch(px){
               case 'D':prix_u=ListPr.get(row).getPrix_vente_detail();break;
               case 'G':prix_u=ListPr.get(row).getPrix_vente_gros();break;
               default:prix_u=ListPr.get(row).getPrix_special();break;
       }
                     ListVente.get(row).setPrix_vente(prix_u);
                
            }
            
          
            TableVente.getModel().setValueAt(quantite_vente, row, 3);
           
            TableVente.getModel().setValueAt(tnb.Afficher2Verguile(quantite_vente*prix_u), row, 4);
            TableVente.getModel().setValueAt(tnb.Afficher2Verguile(prix_u), row, 2);
         
            ListProduitQuantité.set(row, quantite_vente);
           
            ListVente.get(row).setQuantité_vente(quantite_vente);
           refrech(1);
        }catch(Exception e ){remise=0;}
             break;
                  }
       
             default:{
             try{  quantite_vente2=ListProduitQuantité2.get(row2);
        quantite_vente2=quantite_vente2+1;
      //  if(LislttPr.get(row).getPrix_donner()>0){prix_u=ListPr.get(row).getPrix_donner();ListVente.get(row).setPrix_vente(prix_u);}
       // else   
            if(ListPr2.get(row2).getNbre_produit_packet()>1 && quantite_vente2>= ListPr2.get(row2).getNbre_produit_packet())
           
            {                   prix_u2=ListPr2.get(row2).getPrix_vente_packet()/ListPr2.get(row2).getNbre_produit_packet();
        ListVente2.get(row2).setPrix_vente(prix_u2);
            }
            else {
             switch(px2){
               case 'D':prix_u2=ListPr2.get(row2).getPrix_vente_detail();break;
               case 'G':prix_u2=ListPr2.get(row2).getPrix_vente_gros();break;
               default:prix_u2=ListPr2.get(row2).getPrix_special();break;
       }
                     ListVente2.get(row2).setPrix_vente(prix_u2);
                
            }
            
          
            TableVente.getModel().setValueAt(quantite_vente2, row2, 3);
           
            TableVente.getModel().setValueAt(tnb.Afficher2Verguile(quantite_vente2*prix_u2), row2, 4);
            TableVente.getModel().setValueAt(tnb.Afficher2Verguile(prix_u2), row2, 2);
         
            ListProduitQuantité2.set(row2, quantite_vente2);
           
            ListVente2.get(row2).setQuantité_vente(quantite_vente2);
            refrech(2);
          
        }catch(Exception e ){remise2=0;}
             break;
                  }
       }
     
      //   CodeBarre.requestFocus();
   
   }
   public void QteDown(int numC){
       switch(numC){
           case 1:{total=0;
     try{ quantite_vente=ListProduitQuantité.get(row);
            //   System.out.println("quantite_achete="+quantite_achete);
            if(quantite_vente>0) { 
               //   if(ListPr.get(row).getPrix_donner()>0){prix_u=ListPr.get(row).getPrix_donner();ListVente.get(row).setPrix_vente(prix_u);}
               // else 
                      if(ListPr.get(row).getNbre_produit_packet()>1 && quantite_vente> ListPr.get(row).getNbre_produit_packet())
           
            {
        prix_u=ListPr.get(row).getPrix_vente_packet()/ListPr.get(row).getNbre_produit_packet();
        ListVente.get(row).setPrix_vente(prix_u);
      //   ListPrintBon.get(row).setPrix_vente(prix_u);
            }
            else {
                        switch(px){
               case 'D':prix_u=ListPr.get(row).getPrix_vente_detail();break;
               case 'G':prix_u=ListPr.get(row).getPrix_vente_gros();break;
               default:prix_u=ListPr.get(row).getPrix_special();break;
       }
        
                      
                   
                      ListVente.get(row).setPrix_vente(prix_u);
                   //    ListPrintBon.get(row).setPrix_vente(prix_u);
       //       quantite_vente=quantite_vente+ListPr.get(row).getNbre_produit_packet();
         
            }
                quantite_vente=quantite_vente-1;
                TableVente.getModel().setValueAt(quantite_vente, row, 3);
                 TableVente.getModel().setValueAt(quantite_vente*prix_u, row, 4);
                  TableVente.getModel().setValueAt(tnb.Afficher2Verguile(prix_u), row, 2);
                ListProduitQuantité.set(row, quantite_vente);
                ListVente.get(row).setQuantité_vente(quantite_vente);
             
         refrech(1) ;     
                
            }

        }catch(Exception e){remise=0;}   
       
       
       break;
       }
           default:{ total2=0;
     try{ quantite_vente2=ListProduitQuantité2.get(row2);
            //   System.out.println("quantite_achete="+quantite_achete);
            if(quantite_vente2>0) { 
               //   if(ListPr.get(row).getPrix_donner()>0){prix_u=ListPr.get(row).getPrix_donner();ListVente.get(row).setPrix_vente(prix_u);}
               // else 
                      if(ListPr2.get(row2).getNbre_produit_packet()>1 && quantite_vente2> ListPr2.get(row2).getNbre_produit_packet())
           
            {
        prix_u2=ListPr2.get(row2).getPrix_vente_packet()/ListPr2.get(row2).getNbre_produit_packet();
        ListVente2.get(row2).setPrix_vente(prix_u2);
      //   ListPrintBon.get(row).setPrix_vente(prix_u);
            }
            else {
                        switch(px2){
               case 'D':prix_u2=ListPr2.get(row2).getPrix_vente_detail();break;
               case 'G':prix_u2=ListPr2.get(row2).getPrix_vente_gros();break;
               default:prix_u2=ListPr2.get(row2).getPrix_special();break;
       }
        
                      
                   
                      ListVente2.get(row2).setPrix_vente(prix_u2);
                   //    ListPrintBon.get(row).setPrix_vente(prix_u);
       //       quantite_vente=quantite_vente+ListPr.get(row).getNbre_produit_packet();
         
            }
                quantite_vente2=quantite_vente2-1;
                TableVente.getModel().setValueAt(quantite_vente2, row2, 3);
                 TableVente.getModel().setValueAt(quantite_vente2*prix_u2, row2, 4);
                  TableVente.getModel().setValueAt(tnb.Afficher2Verguile(prix_u2), row2, 2);
                ListProduitQuantité2.set(row2, quantite_vente2);
                ListVente2.get(row2).setQuantité_vente(quantite_vente2);
             refrech(2);
            }

        }catch(Exception e){remise2=0;}
     
     
           }
       }
   }
   
   
   
  public void ValiderKey(){
    Valider(numClient);
        try {
            init(numClient);
     
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
  } 
  
   String GenerateCodeBarre(){
   String barecode="";
       
     
        try {
            do{
                barecode=op8.GenerateRandomNumber2();
            }while(vop.CodeExist(barecode));
            
            
        } catch (Exception ex) {
            Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    return barecode;   
  } 
       
 /* private String formatNumber(double price) throws Exception{
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        return df.format(price).replace(",", " ");
    }
   */

class Traitement implements Runnable{

	public void run(){
		while(true){
			time.setText(df.getcurrentTime());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
		}
	
	}
}


public void compileReport(ArrayList<Vente> dataList, String arr)
	throws JRException, IOException
	{
	/**
	* To pass the template directory use this instead of bellow
	*/
	// JasperReport jasperReport =
	// JasperCompileManager.compileReport(arr);
	
	//InputStream is = new ByteArrayInputStream(arr);
	//JasperReport jasperReport = JasperCompileManager.compileReport(is);
	
	
	
	// DataSource
	// This is simple example, no database.
	// then using empty datasource.
	JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
	
	JasperPrint jasperPrint =
	jfm.fillReport(arr, new Hashtable(), dataSource);
        try {
            SendToPrinter(jasperPrint);
            // Make sure the output directory exists.
            ////File outDir = new File("C:\\java\\ireport");
            //outDir.mkdirs();
        } catch (PrinterException ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	


void SendToPrinter(JasperPrint print) throws PrinterException, JRException, JRException{
PrinterJob job = PrinterJob.getPrinterJob();
/* Create an array of PrintServices */
PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
int selectedService = 0;
/* Scan found services to see if anyone suits our needs */
for(int i = 0; i < services.length;i++){
    if(services[i].getName().toUpperCase().contains("Your printer's name")){
        /*If the service is named as what we are querying we select it */
        selectedService = i;
    }
}
job.setPrintService(services[selectedService]);
PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
printRequestAttributeSet.add(mediaSizeName);
printRequestAttributeSet.add(new Copies(1));
JRPrintServiceExporter exporter = new JRPrintServiceExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
/* We set the selected service and pass it as a parameter */
exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
services[selectedService]);
exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
services[selectedService].getAttributes());
exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
printRequestAttributeSet);
exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,Boolean.FALSE);
exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,Boolean.TRUE);
try{exporter.exportReport();}catch(Exception e){}
}
private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
    @Override
    public void keyTyped(KeyEvent e) {
         System.out.println("key typed()="+e.getKeyCode());
        //keyTypedCodeBarre(e);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       System.out.println("key pressed="+e.getKeyCode());
        switch(e.getKeyCode())
        {
            case 112:Annuler(numClient);break;
            case 113:   
         
         
   Valider(numClient);
        try {
            init(numClient);
      //    if( ListVente.isEmpty()) ListPrintBon.clear();
            //this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
 
         
                break;
            case 114:
               try {                                             
                       Valider(numClient);
                       try {
                     if(f.getNom_prénom_client().equals("Passager")&&(m_verse<total_apres_remise))
                     {} else if(f2.getNom_prénom_client().equals("Passager")&&(m_verse2<total_apres_remise2)){}
                     else     imprimer();
                       } catch (PrinterException ex) {
                           Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       try {
                      if(f.getNom_prénom_client().equals("Passager")&&(m_verse<total_apres_remise)&&(total_apres_remise>0)) { tools.ShowFailMessage(this, "Crédit non autoriser pour un Client passager  ");}else        init(numClient);
                      if(f2.getNom_prénom_client().equals("Passager")&&(m_verse2<total_apres_remise2)&&(total_apres_remise2>0)) { tools.ShowFailMessage(this, "Crédit non autoriser pour un Client passager  ");}else        init(numClient);
                           //this.dispose();
                       } catch (Exception ex) {
                           Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       
                       
                       
                       
                   } catch (IOException ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }   
                
                break;
            default:break;
        
        }
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent evt) {
   

    }
    void Annuler(int numC){
        switch(numC){
        case 1:{ListPr.clear();
                ListProduitQuantité.clear();
            try {
            pop.displayResult4(ListPr, TableVente, px, ListProduitQuantité);
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 ListVente.clear();
                 f=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
                 pvente=0;
                 total=0;
                 quantite_vente=0;
                 dette=0;
                 Ancien_credit.setText("0");
                 remise=0;
                 total_apres_remise=0;
                 numVer=0;
                 nom_client.setText("Passager");
 
                 A_rendu.setText("0");
                 a_rendu=0;
                 myButton1.setBackground(new Color(0,204,0));
                 TFremise.setText("0");
                 nv_credit=0;
                 nvcredit.setText("0");
                 montant_verser.setText("0");
                 m_verse=0;
                 Total_Apres_Remise.setText("0");
                 etat="valider";
                 type="ajouter";
                 Total.setText("0.00");
                 px='D';
                break;
               }
        default:{ListPr2.clear();
                ListProduitQuantité2.clear();
            try {
            pop.displayResult4(ListPr2, TableVente, px2, ListProduitQuantité2);
                } catch (Exception ex) {
                    Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 ListVente2.clear();
                 f2=new Client( "C0",  "Passager",  "",  "",  "",  "", "",  "", "", "","",0,0) ;
                 pvente2=0;
                 total2=0;
                 quantite_vente2=0;
                 dette2=0;
                 Ancien_credit.setText("0");
                 remise2=0;
                 total_apres_remise2=0;
                 numVer2=0;
                 nom_client.setText("Passager");
 
                 A_rendu.setText("0");
                 a_rendu2=0;
                 myButton2.setBackground(new Color(0,204,0));
                 TFremise.setText("0");
                 nv_credit2=0;
                 nvcredit.setText("0");
                 montant_verser.setText("0");
                 m_verse2=0;
                 Total_Apres_Remise.setText("0");
                 etat2="valider";
                 type="ajouter";
                 Total.setText("0.00");
                 px2='D';
                break;}
        
        
        
        }
       s=""; 
       code="";
       jRadioDetail2.setSelected(true);
    
    }
    void radioDetail(char px_,double total_,ArrayList<Vente> ListVente_,ArrayList<Produit> ListPr_,double prix_u_,List<Float> ListProduitQuantité_,double remise_,double total_apres_remise_,double dette_,Client f_,double m_verse_,double nv_credit_){
    
  //  px='D';total=0;
     for(int i=0;i<ListVente_.size();i++){
        //  ListPr.get(i).setPrix_donner(0);
         if(ListPr_.get(i).getNbre_produit_packet()>1 && ListVente_.get(i).getQuantité_vente()>= ListPr_.get(i).getNbre_produit_packet())
            {
        prix_u_=ListPr_.get(i).getPrix_vente_packet()/ListPr_.get(i).getNbre_produit_packet();
        ListVente_.get(i).setPrix_vente(prix_u_);  
            }
            else {
            prix_u_=ListPr_.get(i).getPrix_vente_detail();
           ListVente_.get(i).setPrix_vente(prix_u_);  
            }
         try {
             TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente_.get(i).getPrix_vente()), i, 2);
         } catch (Exception ex) {
             Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {    
             TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente_.get(i).getPrix_vente()*ListVente_.get(i).getQuantité_vente()), i, 4);
         } catch (Exception ex) {
             Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
         }
     }           
 /* total_=0;
   for (int j=0 ;j< ListProduitQuantité_.size();j++)
   total_=total_+(ListVente_.get(j).getPrix_vente()*ListProduitQuantité_.get(j));
        try {
            Total.setText( tnb.formatNumber(total_));
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
                remise_=Double.parseDouble(TFremise.getText());
                total_apres_remise_=total_-remise_;
        try {
            TFtotal.setText(tnb.Afficher2Verguile(total_apres_remise_));
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }
              //  m_verse_=Double.parseDouble(montant_verser.getText());
                if(c1)  try{if(type.equals("ajouter")) dette_=f_.getCrédit();}catch(Exception e){dette_=0;}
                total_apres_remise_=Double.parseDouble(TFtotal.getText());
                m_verse_= Double.parseDouble(montant_verser.getText());
                nv_credit_=dette_+(total_apres_remise_-m_verse_);
        try {
            nvcredit.setText(tnb.Afficher2Verguile(nv_credit_));
        } catch (Exception ex) {
            Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
        }*/
     try{ refrech(numClient) ;}catch(Exception e){}        

    }
    
    void radioGros(char px_,double total_,ArrayList<Vente> ListVente_,ArrayList<Produit> ListPr_,double prix_u_,List<Float> ListProduitQuantité_,double remise_,double total_apres_remise_,double dette_,Client f_,double m_verse_,double nv_credit_){
     px_='G';
    
     for(int i=0;i<ListVente_.size();i++){
         // ListPr.get(i).setPrix_donner(0);
         if(ListPr_.get(i).getNbre_produit_packet()>1 && ListVente_.get(i).getQuantité_vente()>= ListPr_.get(i).getNbre_produit_packet())
           
            {
                   prix_u_=ListPr_.get(i).getPrix_vente_packet()/ListPr_.get(i).getNbre_produit_packet();
        ListVente_.get(i).setPrix_vente(prix_u_);
            }
            else {
                    prix_u_=ListPr_.get(i).getPrix_vente_gros();
                     ListVente_.get(i).setPrix_vente(prix_u_);
       //       quantite_vente=quantite_vente+ListPr.get(row).getNbre_produit_packet();
         
            }
         try {
             TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente_.get(i).getPrix_vente()), i, 2);
         } catch (Exception ex) {
             Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {    
             TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente_.get(i).getPrix_vente()*ListVente_.get(i).getQuantité_vente()), i, 4);
         } catch (Exception ex) {
             Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
           
     try{ refrech(numClient) ;}catch(Exception e){}
    
    
    }
   void  radioSpecial(char px_,double total_,ArrayList<Vente> ListVente_,ArrayList<Produit> ListPr_,double prix_u_,List<Float> ListProduitQuantité_,double remise_,double total_apres_remise_,double dette_,Client f_,double m_verse_,double nv_credit_){
    
     px_='S';
        total_=0;
     for(int i=0;i<ListVente_.size();i++){
        //  ListPr.get(i).setPrix_donner(0);
         if(ListPr_.get(i).getNbre_produit_packet()>1 && ListVente_.get(i).getQuantité_vente()>= ListPr_.get(i).getNbre_produit_packet())
           
            {
                   prix_u_=ListPr_.get(i).getPrix_vente_packet()/ListPr_.get(i).getNbre_produit_packet();
        ListVente_.get(i).setPrix_vente(prix_u_);
            }
            else {
                    prix_u_=ListPr_.get(i).getPrix_special();
                     ListVente_.get(i).setPrix_vente(prix_u_);
       //       quantite_vente=quantite_vente+ListPr.get(row).getNbre_produit_packet();
         
            }
            try {
                TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente_.get(i).getPrix_vente()), i, 2);
            } catch (Exception ex) {
                Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {    
                TableVente.getModel().setValueAt(tnb.Afficher2Verguile(ListVente_.get(i).getPrix_vente()*ListVente_.get(i).getQuantité_vente()), i, 4);
            } catch (Exception ex) {
                Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
            }
     }
            
            try{ refrech(numClient) ;}catch(Exception e){}
            
     }
    void detailClique(ArrayList<Produit> ListPr_,int row_){
     if(ListPr_.isEmpty())
           tools.ShowFailMessage(this, "Veuiller Sélectioner un produit");
        //      JOptionPane.showMessageDialog(null, " veuiller Sélectioner un produit  ","",JOptionPane.WARNING_MESSAGE,img2);
        else {try{DetailProduit.getObj(ListPr_.get(row_)).setVisible(true);}catch(Exception ee){}
        }
    }
    
   void codeBarreKeyRelease(KeyEvent evt_ ,double m_verse_,double total_apres_remise_,Client f_,ArrayList<Produit> ListPr_,List<Float> ListProduitQuantité_,ArrayList<Vente> ListVente_,double prix_u_,char px_,double remise_,int num_bon_,double a_rendu_,double total_,double dette_,double nv_credit_){
         keyTypedCodeBarre(evt_, m_verse_, total_apres_remise_, f_);
  // else keyTypedCodeBarre(evt, m_verse2, total_apres_remise2, f2);
 // System.out.println("code barre="+evt.getKeyCode());
 CodeBarre.setText(s);
 tnb.numOnly(CodeBarre);              
 if(s.length()==13) {
  boolean product_in_list=false;
  int pos=0;
  try {         
Produit pp=pop.get_Produit(CodeBarre.getText().trim());
  if(pp!=null){                 
    for(int i=0;i<ListPr_.size();i++){ 
        if(ListPr_.get(i).getId_produit()==pp.getId_produit())
      {product_in_list=true;pos=i;break;}
                                               }
if(product_in_list){
   float qte=0;
   
   if(pp.getNbre_produit_packet()>1&&pp.isVente_packet()&&pp.getCode_bare_packet().trim().equals(CodeBarre.getText().trim())){
   qte=ListProduitQuantité_.get(pos)+pp.getNbre_produit_packet();
   ListProduitQuantité_.set(pos, qte);
   ListVente_.get(pos).setQuantité_vente(qte);
 
 
    prix_u_=pp.getPrix_vente_packet()/pp.getNbre_produit_packet();
    ListVente_.get(pos).setPrix_vente(prix_u_);
  
   }
   
   else {
        
   qte=ListProduitQuantité_.get(pos)+1;
   ListProduitQuantité_.set(pos, qte);
   ListVente_.get(pos).setQuantité_vente(qte);
  
   
   
     switch(px_){
               case 'D':prix_u_=pp.getPrix_vente_detail();break;
               case 'G':prix_u_=pp.getPrix_vente_gros();break;
               default:prix_u_=pp.getPrix_special();break;
       }
    ListVente_.get(pos).setPrix_vente(prix_u_);
 
   }

   
  
       }
   
  
    else {float qte=1;
          ListPr_.add(pp);
           
           if(pp.isVente_packet()&&(pp.getCode_bare_packet().trim().equals(CodeBarre.getText().trim()))&&pp.getNbre_produit_packet()>1){
   qte=pp.getNbre_produit_packet();
   ListProduitQuantité_.add(qte);
  
   
    prix_u_=pp.getPrix_vente_packet()/pp.getNbre_produit_packet();
  
   }
   
   else {
 
   
     switch(px_){
               case 'D':prix_u_=pp.getPrix_vente_detail();break;
               case 'G':prix_u_=pp.getPrix_vente_gros();break;
               default:prix_u_=pp.getPrix_special();break;
       }
   
   qte=1;
    ListProduitQuantité_.add(qte);
   
   }

 
           ListVente_.add(new Vente(date_vente,f_.getNom_prénom_client(),pp.getTva(),pp.getDésignation(),
           pp.getPrix_achat(), prix_u_, qte,0,0,
                new Date(System.currentTimeMillis())+"",
                Aucceuil.userName, pp.getId_produit(),f_.getId_c(), m_verse_,remise_,num_bon_,a_rendu_,"","valide"));

                     }
                   
                      pop.displayResult4(ListPr_, TableVente,px_,ListProduitQuantité_);
                     refrech(numClient) ;
                    }
                
             } catch (Exception ex) {
           
                 ex.getMessage();
                 Logger.getLogger(VenteComptoir4.class.getName()).log(Level.SEVERE, null, ex);
             }
                                         }
   
   
   
   } 
   
   void switchClient(int numC){
      if(numC==1) {
    nom_client.setText(f.getNom_prénom_client());    
  try{  Ancien_credit.setText(tnb.Afficher2Verguile(dette));}catch(Exception e){}
   try{ TFremise.setText(tnb.Afficher2Verguile(remise));}catch(Exception e){}
   try{ Total.setText( tnb.Afficher2Verguile(total));}catch(Exception e){}
  try{  Total_Apres_Remise.setText(tnb.Afficher2Verguile(total_apres_remise));}catch(Exception e){}
  try{  montant_verser.setText(tnb.Afficher2Verguile(m_verse));}catch(Exception e){}
   try{ nvcredit.setText(tnb.Afficher2Verguile(nv_credit));}catch(Exception e){}
  try{  N_bon.setText("N° bon:"+num_bon+"" );}catch(Exception e){}
   try{ A_rendu.setText(a_rendu+"");}catch(Exception e){}
  try{  pop.displayResult4(ListPr, TableVente,px,ListProduitQuantité);}catch(Exception e){}
      }
      else {
     nom_client.setText(f2.getNom_prénom_client());    
  try{  Ancien_credit.setText(tnb.Afficher2Verguile(dette2));}catch(Exception e){}
   try{ TFremise.setText(tnb.Afficher2Verguile(remise2));}catch(Exception e){}
   try{ Total.setText( tnb.Afficher2Verguile(total2));}catch(Exception e){}
  try{  Total_Apres_Remise.setText(tnb.Afficher2Verguile(total_apres_remise2));}catch(Exception e){}
  try{  montant_verser.setText(tnb.Afficher2Verguile(m_verse2));}catch(Exception e){}
   try{ nvcredit.setText(tnb.Afficher2Verguile(nv_credit2));}catch(Exception e){}
   num_bon2=num_bon+1;
  try{  N_bon.setText("N° bon:"+num_bon2+"" );}catch(Exception e){}
   try{ A_rendu.setText(a_rendu2+"");}catch(Exception e){}
  try{  pop.displayResult4(ListPr2, TableVente,px2,ListProduitQuantité2);}catch(Exception e){}
      }
   
   
   }
    
   
  void getListButton(){
    ListBouton.add(b1);
    ListBouton.add(b2);
    ListBouton.add(b3);
    ListBouton.add(b4);
    ListBouton.add(b5);
    ListBouton.add(b6);
    ListBouton.add(b7);
    ListBouton.add(b8);
    ListBouton.add(b9);
    ListBouton.add(b10);
    ListBouton.add(b11);
    ListBouton.add(b12);
    ListBouton.add(b13);
    ListBouton.add(b14);
    ListBouton.add(b15);
    ListBouton.add(b16);
    ListBouton.add(b17);
    ListBouton.add(b18);
    ListBouton.add(b19);
    ListBouton.add(b20);    
  //return ListBouton   ;
  } 
   
 void  refrech(int numC) throws Exception{
     if (numC==1){
         //   total=0;
           // for (int l=0 ;l< ListProduitQuantité.size();l++)
            total=getTotal();
            Total.setText( tnb.Afficher2Verguile(total));
            remise=Double.parseDouble(TFremise.getText());
            Total_Apres_Remise.setText(tnb.Afficher2Verguile(total-remise));
           Ancien_credit.setText(tnb.Afficher2Verguile(f.getCrédit()));
                   
            
            if(c1)   try{ if(type.equals("ajouter"))dette=f.getCrédit();}catch(Exception e){dette=0;}
       //     total_apres_remise=Double.parseDouble(TFtotal.getText());
          //  m_verse= Double.parseDouble(montant_verser.getText());
     
        //    nv_credit=dette+(total_apres_remise-m_verse);
            nv_credit= getNouveau_Crédit();
            nvcredit.setText(tnb.Afficher2Verguile(nv_credit));
                   }
     else {//total2=0;
           // for (int l=0 ;l< ListProduitQuantité2.size();l++)
            total2=getTotal();
            Total.setText( tnb.Afficher2Verguile(total2));
            remise2=Double.parseDouble(TFremise.getText());
            Total_Apres_Remise.setText(tnb.Afficher2Verguile(total2-remise2));
            Ancien_credit.setText(tnb.Afficher2Verguile(f2.getCrédit()));
            
            if(c1)   try{ if(type.equals("ajouter"))dette2=f2.getCrédit();}catch(Exception e){dette2=0;}
          //  total_apres_remise2=Double.parseDouble(TFtotal.getText());
        //    m_verse2= Double.parseDouble(montant_verser.getText());
     
         //   nv_credit2=dette2+(total_apres_remise2-m_verse2);
             nv_credit2= getNouveau_Crédit();
            nvcredit.setText(tnb.Afficher2Verguile(nv_credit2));}
 }
 
 void putDataSource(Client f_){
    try{para.put("activite", p.getActivite());}catch(Exception e){}
    try{para.put("adresse_p", p.getAdresse_p());}catch(Exception e){}
    try{para.put("message", p.getMessage());}catch(Exception e){}
    try{para.put("NIF", p.getNIF());}catch(Exception e){}
    try{para.put("RIB", p.getRIB());}catch(Exception e){}
    try{para.put("NIS", p.getNIS());}catch(Exception e){}
    try{para.put("NRC", p.getNRC());}catch(Exception e){}
    try{para.put("nom_magasin", p.getNom_magasin());}catch(Exception e){}
    try{para.put("num_tel1_p", p.getNum_tel1_p());}catch(Exception e){}
    try{para.put("num_tel2_p", p.getNum_tel2_p());}catch(Exception e){}
    try{para.put("num_tel_fax_fix_p", p.getNum_tel_fax_fix_p());}catch(Exception e){}
             
    try{para.put("nom_prénom_client", f_.getNom_prénom_client());}catch(Exception e){}
    try{para.put("adresse", f_.getAdresse());}catch(Exception e){}
    try{para.put("num_article_imposition", f_.getNum_article_imposition());}catch(Exception e){}
    try{para.put("crédit", f_.getCrédit());}catch(Exception e){}
    try{para.put("num_id_fiscale", f_.getNum_id_fiscale());}catch(Exception e){}
    try{para.put("num_reg_commerce", f_.getNum_reg_commerce());}catch(Exception e){}
    try{para.put("RIB_C", f_.getRib_c());}catch(Exception e){}
    try{para.put("num_tel1", f_.getNum_tel1());}catch(Exception e){}
    try{para.put("num_tel2", f_.getNum_tel2());}catch(Exception e){}              
 }
 
 double getTotal(){
double total_=0;
List<Float> ListProduitQuantité_;
ArrayList<Vente> ListVente_;
  if(numClient==1)
  {
 // total_=total;
  ListProduitQuantité_=ListProduitQuantité;
  ListVente_=ListVente;
  }
  else {
 // total_=total2;
  ListProduitQuantité_=ListProduitQuantité2;
  ListVente_=ListVente2;
  }
   
  for (int i=0 ;i< ListProduitQuantité_.size();i++)
  total_=total_+(ListVente_.get(i).getPrix_vente()*ListProduitQuantité_.get(i));
  return total_;
 }
 double getNouveau_Crédit(){
   double nv_credit_=0; 
   double total_apres_remise_=0;
   double m_verse_=0;
   double dette_=0;
    if(numClient==1)
  {
   // nv_credit_=nv_credit; 
   // total_apres_remise_=total_apres_remise;
   // m_verse_=m_verse;
    dette_=dette;
  }
    else
  {
  //  nv_credit_=nv_credit2; 
    //total_apres_remise_=total_apres_remise2;
  //  m_verse_=m_verse2;
     dette_=dette2;
  }      
  total_apres_remise_=Double.parseDouble(Total_Apres_Remise.getText());
  m_verse_= Double.parseDouble(montant_verser.getText());
 nv_credit_=dette_+(total_apres_remise_-m_verse_);
 
 
 return nv_credit_;
 }
}
