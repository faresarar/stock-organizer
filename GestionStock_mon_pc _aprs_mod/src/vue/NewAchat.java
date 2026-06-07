/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.toedter.calendar.JTextFieldDateEditor;
import controler.Achat_op;
import controler.BoutonColor;
import controler.Caisse_op;
import controler.DateFormater;
import controler.FontStyle;
import controler.Fournisseur_op;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import controler.Versement_fournisseur;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import model.Achat;
import model.Caisse;
import model.Fournisseur;
import model.Paramaitre;
import model.PrintReportBonReception;
import model.Produit;
import model.Versement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;





/**
 *
 * @author Rais
 */
public class NewAchat extends javax.swing.JFrame implements KeyListener {
  //  ImageIcon   img = new ImageIcon("images/gs.png");
   //  ImageIcon   img1 = new ImageIcon("images/accept.png");
    // ImageIcon   img2 = new ImageIcon("images/warning.png");
 //  NumberFormat formatter = new DecimalFormat("#0.00");  
 TextNumber tnb= TextNumber.getObj();  
 Tools tools=Tools.getInstance();
 Map   para = new HashMap();
 //String Type_bon="Reception";
Fournisseur_op fop= Fournisseur_op.getObj();
 Paramaitres_op paop= Paramaitres_op.getInstance();
public static Achat_op aop= Achat_op.getInstance();
public static Produit_op pop= Produit_op.getInstance();
 FontStyle fs= FontStyle.getInstance();
 String s="";
 int q=0;
 String type="ajouter";
 public static NewAchat obj=null;
  String temp_achat = "";
 public static Date date1=null;
// public ArrayList<Fournisseur> ListFournisseur;
public static ArrayList<Produit> ListPr=new ArrayList<>();
public static ArrayList<PrintReportBonReception> ListPrintBon =new ArrayList<>(); 
//public List ListProduitQuantité;
public static List<Float> ListProduitQuantité = new ArrayList<>();
public static List<Float> ListProduitQuantitéAcheteAvantMod = new ArrayList<>();
public static ArrayList<Caisse> ListCaisse =new ArrayList<>(); 
//public static List<Double> ListPrixAchat = new ArrayList<>();

SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
NumberFormat formatter = new DecimalFormat("#0.00"); 

public static  ArrayList<Achat> ListAchat =new ArrayList<>();  
// static public Produit p;
static public Fournisseur f=new Fournisseur();
static Caisse_op cop=Caisse_op.getInstance();
 public static String nom_four="";
 public static int idf=0;
 //Fournisseur four=null;
public static double c;
public static int num_bon_reception=1;
 // double nouveau_dette=0;
 
 double pachat=0,pvente_detail=0,pvente_gros=0,pvente_special=0;
 BoutonColor bc= BoutonColor.getInstance();

 public static double m_verse=0;
 // double r_a_payer;
 public static double nv_dette=0;
 int row,column;
  JRBeanCollectionDataSource dataSource;
 public  static double total=0;
 float quantite_achete=0;
 public static  double dette=0;
 public static double remise=0;
 public static double total_apres_remise=0;
 DateFormater df=new DateFormater() ;
  // Paramaitre pa=null;
 Versement_fournisseur vf= Versement_fournisseur.getObj();
  static  int numVer=0;
//  public static String date_achat="";
   Paramaitres_op parop= Paramaitres_op.getInstance();
public static Paramaitre p; 
   boolean c1=true;
 public static String user;
 JasperPrint print1;
  public static String etat="valider";
   JasperFillManager jfm;
            
 //  MouseEvent me;
    /**
     * Creates new form 
     */
  
  public static NewAchat getObj(String User){
      ListPrintBon.clear();nom_four="";
      
      if(obj==null){
            try { 
       obj=new NewAchat(User);
      //  ListCaisse.clear();
      //  ListCaisse=cop.getList_Caisse();
            } catch (Exception ex) {
                Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
 
    private NewAchat(String User) throws Exception {
          ListCaisse.clear();
        ListCaisse=cop.getList_Caisse();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListAchat);
    try {print1 =jfm.fillReport("Bon_livraison1.jasper", para, dataSource);
        initComponents();
      datee.setDateFormatString("yyyy-MM-dd");
      // System.out.println(java.time.LocalDate.now()+"");
       fs.SetFont1(Total,85);
      //  fs.SetFont1(DA,85);
         //CodeBarre.requestFocus();
          this.setIconImage(tools.getImageIcone().getImage());
  init();
 //   d=0;c=0;
   // numVer=vf.GetNextNumVersement();
  JTextFieldDateEditor editor = (JTextFieldDateEditor) datee.getDateEditor();
editor.setEditable(false);
editor.setHorizontalAlignment(JTextField.CENTER);
       // date1=java.time.LocalDate.now();
    temp_achat= DateFormat.getTimeInstance().format(new java.util.Date());
  num_bon_reception=aop.GetNextBonReception();
     num_bon.setText(num_bon_reception+"");
    user=User;
             TableAchat.setRowHeight(30);
           JTableHeader tableHeader = TableAchat.getTableHeader();
            TableAchat.getTableHeader().setOpaque(false);
   //   tableHeader.setBackground(Color.BLACK);
     tableHeader.setForeground(Color.BLACK);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
         
       
        p=paop.get_Paramaitre();
      
 TableAchat.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
             row = table.rowAtPoint(p);
             column=table.columnAtPoint(p);
         
        }
    });  
    } catch (Exception ex) { 
        ex.printStackTrace();
    }
    bc.ColorerBouton(select_product,  new Color(1, 101, 225));
     bc.ColorerBouton(Sup, Color.red);
    bc.ColorerBouton(Nouveau, new Color(41,134,10));
      try {
         for(int i=0;i<ListCaisse.size();i++)Caisse.addItem(ListCaisse.get(i).getNum()+"");
      //  p=pop.get_Paramaitre();
    } catch (Exception ex) {
        Logger.getLogger(VersementFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    // CodeBarre.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
    }
 public NewAchat(Fournisseur fournisseur,ArrayList<Achat> listAch,ArrayList<Float> listQuantite,ArrayList<Produit> listP,double total1) throws Exception {  
    try {
       f= fournisseur;
  c1=false;
   initComponents();
   CodeBarre.requestFocus();
      this.setIconImage(tools.getImageIcone().getImage());
   TableAchat.setRowHeight(30);
   JTableHeader tableHeader = TableAchat.getTableHeader();
      //tableHeader.setBackground(Color.GREEN);
     tableHeader.setForeground(Color.black);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
      bc.ColorerBouton(select_product,  new Color(1, 101, 225));
     bc.ColorerBouton(Sup, Color.red);
    bc.ColorerBouton(Nouveau, new Color(41,134,10));
    
      datee.setDateFormatString("yyyy-MM-dd");
     //  datee.setDate(java.sql.Date.valueOf(listAch.get(0).getDate_achat()));
      datee.setDate(listAch.get(0).getDate_achat());
       fs.SetFont1(Total,85);
     //  fs.SetFont1(DA,85);
      //    montant_verser.setText("0");
          m_verse=listAch.get(0).getSomme_versé();
      //  CurrentUser=user1;
      type="modifier";
    user=Aucceuil.userName;
    num_bon_reception=listAch.get(0).getNum_bon_réception();
    ListProduitQuantité=listQuantite;
        if(type.equals("ajouter")) dette=fournisseur.getDette();else dette=0;
    ListAchat=listAch;
     ListPr=listP; 
     Paramaitres_op paop=new Paramaitres_op();
     p=paop.get_Paramaitre();
     String npf="";
     for(int i=0;i<ListPr.size();i++){
         
     try{npf=f.getNom_prenom_fournisseur();}catch(Exception e){npf="";}
                 ListProduitQuantitéAcheteAvantMod.add( ListAchat.get(i).getQuantité());
 ListPrintBon.add(new PrintReportBonReception (p.getNom_magasin(),p.getAdresse_p(),p.getNum_tel_fax_fix_p(),p.getNum_tel1_p(),p.getNum_tel2_p(),num_bon_reception,
         npf,
         ListPr.get(i).getDésignation(),ListPr.get(i).getPrix_achat(),ListPr.get(i).getQuantité(),0,0));   
     }
     total=total1;
   //  dette=dett;
   //  ListPrixAchat=listPrixAch;
     remise=listAch.get(0).getRemise();
    //  for(int i=0;i<ListAchat.size();i++)total=total+(ListAchat.get(i).getPrix_achat()*ListProduitQuantité.get(i));
    nom_fournisseur.setText(npf);
   try{ dette_label.setText(tnb.Afficher2Verguile(fournisseur.getDette()));}catch(Exception e){dette_label.setText("0");}
    TFremise.setText(tnb.Afficher2Verguile(remise));
  //  montant_verser.setText(list.get(0).getSomme_versé()+"");
    Total.setText( tnb.Afficher2Verguile(total));
    TFtotal.setText(tnb.Afficher2Verguile(total-remise));
    montant_verser.setText(tnb.Afficher2Verguile(m_verse));
    total_apres_remise=total-remise;
    nv_dette=dette;
     nvdette.setText(tnb.Afficher2Verguile(nv_dette));
     //  total_TTc=aop.getTotal_TTC(ListAchat);
     // total_ht=aop.getTotal_HT(ListAchat);
  //total_HT1.setText(formatter.format(total_ht)+"");
 // total_ttc1.setText(formatter.format(total_TTc)+"");
 //article1.setText(ListAchat.size()+"");
 //unité1.setText(aop.getNombreUnité(ListAchat)+"");
// System.out.println("remise="+list.get(0).getRemise());
   aop.displayResult1(ListPr, TableAchat, ListProduitQuantité);
    
  // try{ num_bon_reception=Integer.parseInt(num_bon.getText());}catch (Exception e ){}
    //  date_achat=java.time.LocalDate.now()+"";
     // System.out.println("dddddd="+date_vente);
   //datee.setText(date_achat);
    num_bon.setText(listAch.get(0).getNum_bon_réception()+"");
    // f.setId_client("C0");
        //   jButton4.setVisible(false);   
             Sup.setVisible(true);
           try{  idf=f.getId_f();}catch(Exception e){idf=0;}

   
 TableAchat.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
             row = table.rowAtPoint(p);
             column=table.columnAtPoint(p);
        
        }
    });  
    } catch (Exception ex) { 
        ex.printStackTrace();
    }
      bc.ColorerBouton(select_product,  new Color(1, 101, 225));
         try {
         for(int i=0;i<ListCaisse.size();i++)Caisse.addItem(ListCaisse.get(i).getNum()+"");
      //  p=pop.get_Paramaitre();
    } catch (Exception ex) {
        Logger.getLogger(VersementFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
      
     //  CodeBarre.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAchat = new javax.swing.JTable();
        Imprimer_BTN = new javax.swing.JButton();
        Sup = new javax.swing.JButton();
        select_product = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nom_fournisseur = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        num_bon = new javax.swing.JTextField();
        Total = new javax.swing.JLabel();
        datee = new com.toedter.calendar.JDateChooser();
        dette_label = new javax.swing.JTextField();
        CodeBarre = new javax.swing.JTextField();
        Valider_Achat_BTN = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TFremise = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        montant_verser = new com.jkelany.jktextfield.numeric.JKNumericField();
        jLabel17 = new javax.swing.JLabel();
        TFtotal = new javax.swing.JTextField();
        nvdette = new javax.swing.JTextField();
        QuantiteRem = new javax.swing.JButton();
        QuantiteAdd = new javax.swing.JButton();
        Nouveau = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Caisse = new javax.swing.JComboBox<>();
        PayerCaisseCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acheter des produits");
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        TableAchat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableAchat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Désignation", "Prix vente detail", "Prix vente gros", "Prix d'achat", "QTE Stock", "QTE Acheté"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAchat.setColumnSelectionAllowed(true);
        TableAchat.getTableHeader().setReorderingAllowed(false);
        TableAchat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableAchatMousePressed(evt);
            }
        });
        TableAchat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableAchatKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableAchat);
        TableAchat.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        Imprimer_BTN.setBackground(new java.awt.Color(204, 204, 204));
        Imprimer_BTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Imprimer_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-30.png"))); // NOI18N
        Imprimer_BTN.setText("Valider et imprimer Bon de réception");
        Imprimer_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimer_BTNActionPerformed(evt);
            }
        });

        Sup.setBackground(new java.awt.Color(255, 51, 51));
        Sup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Sup.setForeground(new java.awt.Color(255, 255, 255));
        Sup.setText("Supprimer ");
        Sup.setSelected(true);
        Sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupActionPerformed(evt);
            }
        });

        select_product.setBackground(new java.awt.Color(51, 204, 0));
        select_product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        select_product.setForeground(new java.awt.Color(255, 255, 255));
        select_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32update.png"))); // NOI18N
        select_product.setText("Insérer");
        select_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_productActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("dette:");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com(3).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("fournisseur");

        nom_fournisseur.setEditable(false);
        nom_fournisseur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_fournisseur.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("date achat ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("N° bon ");

        num_bon.setEditable(false);
        num_bon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        num_bon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Total.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        Total.setForeground(new java.awt.Color(51, 255, 51));
        Total.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Total.setText("0.00 ");

        datee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        dette_label.setEditable(false);
        dette_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dette_label.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(datee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nom_fournisseur, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(num_bon, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(dette_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dette_label, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(nom_fournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(num_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(datee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28))
        );

        CodeBarre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CodeBarre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CodeBarre.setToolTipText("Code Barre");
        org.jdesktop.swingx.border.IconBorder iconBorder1 = new org.jdesktop.swingx.border.IconBorder();
        iconBorder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Barcode.png"))); // NOI18N
        CodeBarre.setBorder(iconBorder1);
        CodeBarre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CodeBarre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        CodeBarre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CodeBarreKeyReleased(evt);
            }
        });

        Valider_Achat_BTN.setBackground(new java.awt.Color(204, 204, 204));
        Valider_Achat_BTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Valider_Achat_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        Valider_Achat_BTN.setText("Valider sans imprimer ");
        Valider_Achat_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Valider_Achat_BTNActionPerformed(evt);
            }
        });
        Valider_Achat_BTN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Valider_Achat_BTNKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 255, 153));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Total ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Remise");

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

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Versement");

        montant_verser.setForeground(new java.awt.Color(255, 0, 0));
        montant_verser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        montant_verser.setText("0");
        montant_verser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        montant_verser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                montant_verserMouseExited(evt);
            }
        });
        montant_verser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                montant_verserKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                montant_verserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                montant_verserKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("NV dettes");

        TFtotal.setEditable(false);
        TFtotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TFtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nvdette.setEditable(false);
        nvdette.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nvdette.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        QuantiteRem.setBackground(new java.awt.Color(204, 204, 204));
        QuantiteRem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        QuantiteRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        QuantiteRem.setText("QTE Acheté ");
        QuantiteRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantiteRemActionPerformed(evt);
            }
        });

        QuantiteAdd.setBackground(new java.awt.Color(204, 204, 204));
        QuantiteAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        QuantiteAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        QuantiteAdd.setText("QTE Achété ");
        QuantiteAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantiteAddActionPerformed(evt);
            }
        });

        Nouveau.setBackground(new java.awt.Color(102, 255, 102));
        Nouveau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nouveau.setForeground(new java.awt.Color(255, 255, 255));
        Nouveau.setText("Nouveau");
        Nouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NouveauActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Caisse de versement");

        Caisse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Caisse.setPreferredSize(new java.awt.Dimension(56, 28));

        PayerCaisseCheckBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PayerCaisseCheckBox.setSelected(true);
        PayerCaisseCheckBox.setText("Payer a partir de caisse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(select_product)
                        .addGap(10, 10, 10)
                        .addComponent(Nouveau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Sup)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Valider_Achat_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Imprimer_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(QuantiteAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(QuantiteRem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Caisse, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(montant_verser, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFremise, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TFtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                        .addComponent(nvdette))))
                            .addComponent(PayerCaisseCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(select_product, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Sup, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(QuantiteAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(QuantiteRem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFremise, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(montant_verser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nvdette, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Caisse, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PayerCaisseCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Valider_Achat_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Imprimer_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        CodeBarre.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_productActionPerformed
    // new RechercherProduit(1,"").setVisible(true);
       new RechercherProduitAchat(1,Aucceuil.userName).setVisible(true);
       this.setVisible(false);
     //  Sup.setVisible(true);
   //System.out.println( "value ="+jTable1.getModel().getValueAt(0, 1));
    }//GEN-LAST:event_select_productActionPerformed

    private void SupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupActionPerformed
    
     //   if(!f.getNom_prenom_fournisseur().isEmpty())dette_label.setText(f.getDette()+"");
        int position=TableAchat.getSelectedRow(); 
         if(row==-1||position==-1)
             tools.ShowFailMessage(this, "Veuiller sélectionner une ligne");
            // JOptionPane.showMessageDialog(null, " Veuiller sélectionner une ligne  ","",JOptionPane.INFORMATION_MESSAGE,img2);
         else {ListPr.remove(position);
           ListProduitQuantitéAcheteAvantMod.remove(position);
        //  total=total-(ListProduitQuantité.get(position)*ListAchat.get(position).getPrix_achat());
       
         ListProduitQuantité.remove(position);
         //  ListPrixAchat.remove(position);
           ListAchat.remove(position);
           ListPrintBon.remove(position);
       //  System.out.println("pro size="+ListProduitQuantité.size()+"achat size="+ListAchat.size());
        
                       total=0;
         for (int i=0 ;i< ListProduitQuantité.size();i++) 
         total=total+(ListProduitQuantité.get(i)*ListAchat.get(i).getPrix_achat());
                     
            try {
                Total.setText( tnb.Afficher2Verguile(total));
            } catch (Exception ex) {
                Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
                try{    remise=Double.parseDouble(TFremise.getText());}catch(Exception e){remise=0;}
            try {
                TFtotal.setText(tnb.Afficher2Verguile(total-remise));
            } catch (Exception ex) {
                Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
                        
                        
                         m_verse=Double.parseDouble(montant_verser.getText());
              if(c1)  try{ dette=f.getDette();}catch(Exception e){dette=0;}
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
            try {
                nvdette.setText(tnb.Afficher2Verguile(nv_dette));
            } catch (Exception ex) {
                Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
                        
            try {
                //  pop.displayResult1(ListPr, jTable1);
                pop.displayResult1(ListPr, TableAchat,ListProduitQuantité);
            } catch (Exception ex) {
                Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            
           
                     
         }
          CodeBarre.requestFocus();
    }//GEN-LAST:event_SupActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        RechercherFournisseur.getObj().setVisible(true);
       RechercherFournisseur.jButton1.setVisible(true);
     //   CodeBarre.requestFocus();
//        System.out.println("f="+ListAchat.get(0).getNom_prénom_fournisseur());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Valider_Achat_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_Achat_BTNActionPerformed
 Valider();
 init();
 this.dispose();
    }//GEN-LAST:event_Valider_Achat_BTNActionPerformed

    private void montant_verserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montant_verserKeyTyped

      
         
    }//GEN-LAST:event_montant_verserKeyTyped

    private void montant_verserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montant_verserKeyReleased
         tnb.numOnly(TFremise);
       if(c1)  try{  dette=f.getDette();}catch (Exception e ){dette=0;}
        try{                    
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
                 nvdette.setText(tnb.Afficher2Verguile(nv_dette));
                 
        
        }
catch (Exception e){dette=0;
 montant_verser.setText("0");
                   }
      // r_a_payer=total_TTc-m_verse;
      
    // reste_a_payer.setText(r_a_payer+" DA");
   // if(!f.getNom_prenom_fournisseur().isEmpty())   total_dette=f.getDette()+r_a_payer;
     //total_des_dettes1.setText(formatter.format(total_dette)+" DA");
    }//GEN-LAST:event_montant_verserKeyReleased

    private void TableAchatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableAchatKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     //System.out.println("key enter");
   }
    }//GEN-LAST:event_TableAchatKeyPressed

    private void Imprimer_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimer_BTNActionPerformed
        try {
            Valider(); imprimer(ListAchat);
            // System.out.println("nom fournisseur=="+nom_four);
            init();
            
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrinterException ex) {
            Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Imprimer_BTNActionPerformed

    private void CodeBarreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeBarreKeyReleased
    //   try{ int a=(int)evt.getKeyChar() ;
  //   System.out.println("eeeee="+a);
   //    }catch(Exception e){}
      
         keyTyped(evt);
        
       // tnb.numOnly(CodeBarre);
       //  boolean product_in_list=false;int position_liste=0;
       /* if(evt.getKeyChar()!=KeyEvent.VK_ENTER){
        s=s+evt.getKeyChar();

        s=s.replace('à', '0');
        s=s.replace('&', '1');
        s=s.replace('é', '2');
        s=s.replace('"', '3');
            s=s.replace("'", "4");
            s=s.replace('(', '5');
                s=s.replace('-', '6');
                s=s.replace('è', '7');
                s=s.replace('_', '8');
                s=s.replace('ç', '9');}
*/
               CodeBarre.setText(s);
                tnb.numOnly(CodeBarre);
              
                            if(s.length()>=13) {
                                 boolean product_in_list=false;
                                 int pos=0;
             try {
               
                 Produit pp=pop.get_Produit(CodeBarre.getText().trim());
                //  System.out.println("contite produit="+pp);
                    if(pp!=null){
                   
                     for(int i=0;i<ListPr.size();i++){ if(ListPr.get(i).getId_produit()==pp.getId_produit())
                     {product_in_list=true;pos=i;break;}
                         }
                     if(product_in_list){
                         float qte=0;
                 //     System.out.println("exist");
                    //   System.out.println("pos="+pos);
                    if(pp.getNbre_produit_packet()>0)
                        qte=ListProduitQuantité.get(pos)+pp.getNbre_produit_packet();
                   else   qte=ListProduitQuantité.get(pos)+1;
                   //  System.out.println("qte="+qte);
                     ListProduitQuantité.set(pos, qte);
                      if(pp.getNbre_produit_packet()>0)
                      ListAchat.get(pos).setQuantité( ListAchat.get(pos).getQuantité()+pp.getNbre_produit_packet());
                     else ListAchat.get(pos).setQuantité( ListAchat.get(pos).getQuantité()+1);
                     
                     
                     }
                     else {
                     ListPr.add(pp);
                     if(pp.getNbre_produit_packet()>0) 
                        ListProduitQuantité.add((float)pp.getNbre_produit_packet());
                     else ListProduitQuantité.add((float)1);
                        ListAchat.add(new Achat(num_bon_reception,date1,nom_four,temp_achat,user,ListPr.get(pos).getDésignation(),
                ListPr.get(pos).getPrix_achat(),1,m_verse,
                remise,ListPr.get(pos).getPrix_vente_detail(),ListPr.get(pos).getPrix_vente_gros(),ListPr.get(pos).getPrix_special(),idf,ListPr.get(pos).getId_produit()));
        PrintReportBonReception prb=   new PrintReportBonReception (
                p.getNom_magasin(),
                p.getAdresse_p(),
                p.getNum_tel_fax_fix_p(),
                p.getNum_tel1_p(),
          p.getNum_tel2_p(),num_bon_reception,nom_four,ListPr.get(pos).getDésignation(),
          ListPr.get(pos).getPrix_achat(),0, ListPr.get(pos).getPrix_vente_detail(),ListPr.get(pos).getPrix_vente_gros());
          ListPrintBon.add(prb);
                       
                      
                     // ListPrixAchat.add(pp.getPrix_achat());
                    //  ListPrixVenteDetail.add(pp.getPrix_vente_detail());
                    //  ListPrixVenteGros.add(pp.getPrix_vente_gros());
                     }
                      ListProduitQuantitéAcheteAvantMod.add((float)0);

                      pop.displayResult1(ListPr, TableAchat,ListProduitQuantité);
                    total=0;
         for (int i=0 ;i< ListProduitQuantité.size();i++) 
             
                         total=total+(ListProduitQuantité.get(i)*ListAchat.get(i).getPrix_achat());
                     
                   Total.setText( tnb.Afficher2Verguile(total) );
                try{    remise=Double.parseDouble(TFremise.getText());}catch(Exception e){remise=0;}
                        TFtotal.setText(tnb.Afficher2Verguile(total-remise));
                        
                        
                        
                         m_verse=Double.parseDouble(montant_verser.getText());
               if(c1) try{ dette=f.getDette();}catch(Exception e){dette=0;}
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
                 nvdette.setText(tnb.Afficher2Verguile(nv_dette));
                      
                    }
                 //    System.out.println("pp="+pp.toString());
                 //   for(int i=0;i<ListAchat.size();i++){
                 //      if(ListAchat.get(i).getId_produit()==pp.getId_produit())
                 //       {   product_in_list=true;position_liste=i;break;}
             } catch (Exception ex) {
              //   System.out.println("Exception");
                 ex.getMessage();
                 Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
             }
                                         }

                                     
    }//GEN-LAST:event_CodeBarreKeyReleased

    private void QuantiteAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantiteAddActionPerformed

        
      //  System.out.println(ListProduitQuantité.get(row));
        try{ quantite_achete=ListProduitQuantité.get(row);
            quantite_achete=quantite_achete+1;
           //   System.out.println("ListProduitQuantité size="+ListProduitQuantité.size());
          TableAchat.getModel().setValueAt(quantite_achete, row, 6);
          ListProduitQuantité.set(row, quantite_achete);
          // System.out.println("list produit quantite="+ListProduitQuantité.get(row));
          ListAchat.get(row).setQuantité(quantite_achete);
          //  System.out.println("list achat quantite="+ListAchat.get(row).getQuantité());
          ListPrintBon.get(row).setQuantité(quantite_achete);
          total=0; 
          // System.out.println("ListProduitQuantité= "+ListProduitQuantité.get(row));
                           for (int i=0 ;i< ListProduitQuantité.size();i++) 
                           total=total+(ListAchat.get(i).getPrix_achat()*ListProduitQuantité.get(i));
                        Total.setText( tnb.Afficher2Verguile(total));
                         remise=Double.parseDouble(TFremise.getText());
                        TFtotal.setText(tnb.Afficher2Verguile(total-remise));
                        
                         m_verse=Double.parseDouble(montant_verser.getText());
            if(c1)   try{ dette=f.getDette();}catch(Exception e){dette=0;}
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
                 nvdette.setText(tnb.Afficher2Verguile(nv_dette));
        }catch(Exception e ){remise=0;}
        CodeBarre.requestFocus();
    }//GEN-LAST:event_QuantiteAddActionPerformed

    private void QuantiteRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantiteRemActionPerformed
   
        try{ quantite_achete=ListProduitQuantité.get(row);  
      //   System.out.println("quantite_achete="+quantite_achete);
            if(quantite_achete>0) { quantite_achete=quantite_achete-1;
        TableAchat.getModel().setValueAt(quantite_achete, row, 6);
        ListProduitQuantité.set(row, quantite_achete);
         ListAchat.get(row).setQuantité(quantite_achete);
          ListPrintBon.get(row).setQuantité(quantite_achete);
              
        total=0; 
                           for (int i=0 ;i< ListProduitQuantité.size();i++) 
                           total=total+(ListAchat.get(i).getPrix_achat()*ListProduitQuantité.get(i));
                           // System.out.println("totam="+total);
                        Total.setText( tnb.Afficher2Verguile(total));
                         remise=Double.parseDouble(TFremise.getText());
                          total_apres_remise=total-remise;
                        TFtotal.setText(tnb.Afficher2Verguile(total_apres_remise));
                       
                        
                         m_verse=Double.parseDouble(montant_verser.getText());
              if(c1)  try{ dette=f.getDette();}catch(Exception e){dette=0;}
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
                 nvdette.setText(tnb.Afficher2Verguile(nv_dette));
            }
                 
    }catch(Exception e){remise=0;}
        CodeBarre.requestFocus();
    }//GEN-LAST:event_QuantiteRemActionPerformed

    private void NouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NouveauActionPerformed
      AjouterProduit.getObj(1).setVisible(true);
    
    }//GEN-LAST:event_NouveauActionPerformed

    private void TFremiseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFremiseKeyReleased
       tnb.numOnly(TFremise);
     if(c1) try{ dette=f.getDette();}catch (Exception e){dette=0;}
        try{      remise=Double.parseDouble(TFremise.getText());
         total_apres_remise=total-remise;
         TFtotal.setText(tnb.Afficher2Verguile(total_apres_remise));
          m_verse=Double.parseDouble(montant_verser.getText());
                 
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
                 nvdette.setText(tnb.Afficher2Verguile(nv_dette));
        }
         
catch (Exception e){remise=0;
TFremise.setText("0");
}
    }//GEN-LAST:event_TFremiseKeyReleased

    private void montant_verserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montant_verserKeyPressed
   
    }//GEN-LAST:event_montant_verserKeyPressed

    private void Valider_Achat_BTNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Valider_Achat_BTNKeyPressed
       if(evt.getKeyChar()==KeyEvent.VK_F1){Valider();}
    }//GEN-LAST:event_Valider_Achat_BTNKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     //  System.out.println("windows closing");
     
     obj=null;
       init();
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         if(evt.getKeyChar()==KeyEvent.VK_F1){Valider();}
    }//GEN-LAST:event_formKeyPressed

    private void TableAchatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAchatMousePressed
  // if(c1) {
       TableAchat.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingCanceled(ChangeEvent e) {
                   //     System.out.println(jTable1.getModel().getValueAt(0, 1)+"editingCanceled");
                    }

                    @Override
                    public void editingStopped(ChangeEvent e) {
                   try{ 
                       quantite_achete=Float.parseFloat(TableAchat.getModel().getValueAt(row, 6).toString()); 
                        if(quantite_achete<0){
                            tools.ShowFailMessage(NewAchat.this, "La quantité doit étre >=0");
                         //   JOptionPane.showMessageDialog(null, " La quantité doit être >=0  ","erreur",JOptionPane.INFORMATION_MESSAGE,img2);
                      quantite_achete=0;}
                      
                   }
                      catch (Exception ex){
               quantite_achete=0;
              
              TableAchat.getModel().setValueAt(quantite_achete, row, 6);
                TFtotal.setText("0");
                total=0;
                remise=0;
              total_apres_remise=0;
                nv_dette=0;
                nvdette.setText(s);
              m_verse=0;
              remise=0;
              TFremise.setText("0");
               
           }
                  // System.out.println("ListProduitQuantité size="+ListProduitQuantité.size());
          ListProduitQuantité.set(row, quantite_achete);
          ListAchat.get(row).setQuantité(quantite_achete);
         
        ListPrintBon.get(row).setQuantité(quantite_achete);
          total=0;
         for (int i=0 ;i< ListProduitQuantité.size();i++) 
                         total=total+(ListProduitQuantité.get(i)*ListAchat.get(i).getPrix_achat());
                        try {
                            Total.setText( tnb.Afficher2Verguile(total)+"");
                        } catch (Exception ex) {
                            Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        try {
                            TFtotal.setText(tnb.Afficher2Verguile(total-remise));
                        } catch (Exception ex) {
                            Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                         m_verse=Double.parseDouble(montant_verser.getText());
               
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
                        try {
                            nvdette.setText(tnb.Afficher2Verguile(nv_dette));
                            //   System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
                        } catch (Exception ex) {
                            Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  
    
                     try{pachat=Double.parseDouble(TableAchat.getModel().getValueAt(row, 4).toString()); 
                    
                             ListAchat.get(row).setPrix_achat(pachat);
                      if(pachat<0){
                          tools.ShowFailMessage(NewAchat.this, "Prix d'achat doit être >0 ");
                         // JOptionPane.showMessageDialog(null, " Prix d'achat doit être >0  ","erreur",JOptionPane.INFORMATION_MESSAGE,img2);
                      pachat=0;
                      }
                     }  
           catch (Exception ex){
               pachat=0;
                ListAchat.get(row).setPrix_achat(pachat);
                  TableAchat.getModel().setValueAt(pachat, row, 4);
                TFtotal.setText("");
                total=0;
                remise=0;
              total_apres_remise=0;
                nv_dette=0;
                nvdette.setText(s);
              m_verse=0;
              remise=0;
              TFremise.setText("");
           }
                         TableAchat.getModel().setValueAt(pachat, row, 4);
                   //  jTable1.getModel().setValueAt(pvente, row, 4);
                  TableAchat.getModel().setValueAt(quantite_achete, row, 6);
                       try{ total=0;
         for (int i=0 ;i< ListProduitQuantité.size();i++) 
                            total=total+(ListProduitQuantité.get(i)*ListAchat.get(i).getPrix_achat());
                        Total.setText( tnb.Afficher2Verguile(total));
                        TFtotal.setText(tnb.Afficher2Verguile(total-remise));
                         m_verse=Double.parseDouble(montant_verser.getText());
               
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
                 nvdette.setText(tnb.Afficher2Verguile(nv_dette));
                           
                           
                       
                           //  pvente=Double.parseDouble(jTable1.getModel().getValueAt(row, 4).toString()); 
                       }  
           catch (Exception ex){
               Total.setText( total+"");
           }
                      
                   
              
                ListAchat.get(row).setPrix_achat(pachat);
            
              ListAchat.get(row).setPrix_achat(pachat);
                  ListAchat.get(row).setQuantité(quantite_achete);
                 
          ListPrintBon.get(row).setQuantité(quantite_achete);
              
      
              
                  
                 
  m_verse=Double.parseDouble(montant_verser.getText());
  
  
    try{
        //  System.out.println(" prix detail from table ="+TableAchat.getModel().getValueAt(row, 1).toString());
              
        pvente_detail=Double.parseDouble(TableAchat.getModel().getValueAt(row, 1).toString());
     ListAchat.get(row).setPrix_v_detail(pvente_detail);
                      if(pvente_detail<0){
                          tools.ShowFailMessage(NewAchat.this, "Prix de vente doit être >0 ");
                        //  JOptionPane.showMessageDialog(null, " Prix de vente doit être >0  ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
                       pvente_detail=0;
                      }
                     }  
           catch (Exception ex){
            //   System.out.println("Exception prix detail");
               pvente_detail=0;
                 TableAchat.getModel().setValueAt(pvente_detail, row, 1);
           }
     try{
          //System.out.println(" prix gros="+TableAchat.getModel().getValueAt(row, 2));
         pvente_gros=Double.parseDouble(TableAchat.getModel().getValueAt(row, 2).toString()); 
       
         ListAchat.get(row).setPrix_v_gros(pvente_gros);
                    // ListPrixVenteGros.set(row, tnb.Formater2chiffre(pvente_gros));
                      if(pvente_gros<0){
                          tools.ShowFailMessage(NewAchat.this, "Prix de vente doit être >0 ");
                      //    JOptionPane.showMessageDialog(null, " Prix de vente doit être >0  ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
                       pvente_gros=0;
                      }
                     }  
           catch (Exception ex){
              //  System.out.println("Exception prix gros");
                 pvente_gros=0;
                 TableAchat.getModel().setValueAt(pvente_gros, row, 2);
                
           }
                        try {
                            TableAchat.getModel().setValueAt(tnb.Afficher2Verguile(pvente_gros), row, 2);
                        } catch (Exception ex) {
                           // Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
                             TableAchat.getModel().setValueAt(pvente_gros, row, 2);
                        }
                        
       try{
          //System.out.println(" prix gros="+TableAchat.getModel().getValueAt(row, 2));
         pvente_special=Double.parseDouble(TableAchat.getModel().getValueAt(row, 3).toString()); 
       
         ListAchat.get(row).setPrix_v_gros(pvente_special);
                    // ListPrixVenteGros.set(row, tnb.Formater2chiffre(pvente_gros));
                      if(pvente_special<0){
                          tools.ShowFailMessage(NewAchat.this, "Prix de vente doit être >0 ");
                      //    JOptionPane.showMessageDialog(null, " Prix de vente doit être >0  ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
                       pvente_special=0;
                      }
                     }  
           catch (Exception ex){
              //  System.out.println("Exception prix gros");
                 pvente_special=0;
                 TableAchat.getModel().setValueAt(pvente_special, row, 3);
                
           }
                        try {
                            TableAchat.getModel().setValueAt(tnb.Afficher2Verguile(pvente_special), row, 3);
                        } catch (Exception ex) {
                           // Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
                             TableAchat.getModel().setValueAt(pvente_special, row, 3);
                        }                   
                        
                        
                       
                    }
                });
 //  }

    }//GEN-LAST:event_TableAchatMousePressed

    private void montant_verserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montant_verserMouseExited
        m_verse=Double.parseDouble(montant_verser.getText());
  montant_verser.setText(formatter.format(m_verse).replace(',', '.')+"");
    }//GEN-LAST:event_montant_verserMouseExited

    private void TFremiseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFremiseMouseExited
        remise=Double.parseDouble(TFremise.getText());
  TFremise.setText(formatter.format(remise).replace(',', '.')+"");
    }//GEN-LAST:event_TFremiseMouseExited

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Caisse;
    private javax.swing.JTextField CodeBarre;
    private javax.swing.JButton Imprimer_BTN;
    private javax.swing.JButton Nouveau;
    private javax.swing.JCheckBox PayerCaisseCheckBox;
    private javax.swing.JButton QuantiteAdd;
    private javax.swing.JButton QuantiteRem;
    private javax.swing.JButton Sup;
    private javax.swing.JTextField TFremise;
    public static javax.swing.JTextField TFtotal;
    public static javax.swing.JTable TableAchat;
    public static javax.swing.JLabel Total;
    private javax.swing.JButton Valider_Achat_BTN;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser datee;
    public static javax.swing.JTextField dette_label;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.jkelany.jktextfield.numeric.JKNumericField montant_verser;
    public static javax.swing.JTextField nom_fournisseur;
    public static javax.swing.JTextField num_bon;
    public static javax.swing.JTextField nvdette;
    private javax.swing.JButton select_product;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
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
     System.out.println("entrer condition");
     s=s+ss;} 
 else  ke.consume();
    if(ke.getKeyChar()==KeyEvent.VK_ENTER){CodeBarre.setText(s); 
  //  System.out.println("fin de String");
    s="";
    }
 if(ke.getKeyChar()==KeyEvent.VK_BACK_SPACE) { CodeBarre.setText("");s="";}      
        
        
        
        
        
        
     /*    s=s+ke.getKeyChar();
  s=s.replace('à', '0');
  s=s.replace('&', '1');
  s=s.replace('é', '2');
  s=s.replace('"', '3');
  s=s.replace("'", "4");
  s=s.replace('(', '5');
  s=s.replace('-', '6');
  s=s.replace('è', '7');
  s=s.replace('_', '8');
  s=s.replace('ç', '9');
  
    if(ke.getKeyChar()==KeyEvent.VK_ENTER){CodeBarre.setText(s); 
  //  System.out.println("fin de String");
    s="";
    }
 if(ke.getKeyChar()==KeyEvent.VK_BACK_SPACE) { CodeBarre.setText("");s="";}*/ 
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   void init(){
   s="";
  q=0; 
  obj=null;
 ListPr.clear();
// ArrayList<PrintReportBonLivrason> ListPrintBonLivraison =new ArrayList<>(); 
 ListProduitQuantité.clear();
 type="ajouter";
 //ListPrixVenteDetail.clear();
// ListPrixVenteGros.clear();
ListAchat.clear();
//ListPrintBon.clear();
// static public Produit p;
f=null;
nom_four="";
num_bon_reception=1;
  pachat=0;pvente_detail=0;pvente_gros=0;
 date1=null;
 m_verse=0;
 // double r_a_payer;
  nv_dette=0;
   //row,column;
  total=0;
   quantite_achete=0;
  dette=0;
 remise=0;
  total_apres_remise=0;
  // numVer=0;
//  date_achat="";
//  nom_four="";
  //  TextNumber tn=new TextNumber();
  idf=0;
  ListProduitQuantitéAcheteAvantMod.clear();
   etat="valider";
   ListPrintBon.clear();
   } 
   public void Valider(){
   float nv_quantite=0;
  // temp_achat=  new Date(System.currentTimeMillis())+"";
temp_achat=  DateFormat.getTimeInstance().format(new java.util.Date());
   try{ nom_four=f.getNom_prenom_fournisseur();
        idf=f.getId_f();
 }
 catch(Exception e){nom_four="";
 idf=0;
 }
       
        try{
       
           date1 = Date.valueOf(df1.format(datee.getDate()));
      }catch(Exception e){ date1 =new Date(System.currentTimeMillis());
    //  e.printStackTrace();
     // e.getMessage();
      }
 
        if(ListAchat.isEmpty())
            tools.ShowFailMessage(NewAchat.this, "Veuiller ajouter des produits au liste d'achat ");
          //  JOptionPane.showMessageDialog(null, " Veuiller ajouter des produits au liste d'achat   ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
      
        else {
           
             if(c1==false){try {
                 aop.sup_Achat1(ListAchat.get(0).getNum_bon_réception());
               //  System.out.println("bien suprimer bon reception"+" " +ListAchat.get(0).getNum_bon_réception());
             } catch (Exception ex) {
                 Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
             }             }
        for(int i=0;i<ListAchat.size();i++){
            try {
              
                ListAchat.get(i).setQuantité(ListProduitQuantité.get(i));
                 ListAchat.get(i).setSomme_versé(m_verse);
                 ListAchat.get(i).setRemise(remise);
                
               
                 ListAchat.get(i).setDate_achat(date1);
                   ListAchat.get(i).setTemp_achat(temp_achat);
        
                 ListAchat.get(i).setNom_prénom_fournisseur(nom_four);
                  ListAchat.get(i).setIdf(idf);
                     // System.out.println("222222");
                 ListPrintBon.get(i).setNom_prénom_fournisseur(nom_four);
                 //     System.out.println("3333333333");
                 ListPrintBon.get(i).setPrix_achat(ListAchat.get(i).getPrix_achat());
                  ListPrintBon.get(i).setQuantité(ListAchat.get(i).getQuantité());
              
                  aop.Inserer_achat(ListAchat.get(i));
             //  System.out.println(" insertion au list d achat");
                  } catch (Exception ex) {
                 System.out.println("Exception insertion");
                  }
            
               try{  if(c1==false) nv_quantite=ListProduitQuantité.get(i)-ListProduitQuantitéAcheteAvantMod.get(i)+ListPr.get(i).getQuantité();
               
               else    nv_quantite=ListProduitQuantité.get(i)+ListPr.get(i).getQuantité();
          //  System.out.println("nv_quantite ="+nv_quantite);
          //   System.out.println("ListProduitQuantité.get(i)="+ListProduitQuantité.get(i));
          //     System.out.println("ListPr.get(i)="+ListPr.get(i));
           //    System.out.println("quantite_achete="+quantite_achete);
                      pop.modifier_ProduitApresAchat(ListAchat.get(i).getPrix_achat(),
                        ListAchat.get(i).getPrix_v_detail(), 
                        ListAchat.get(i).getPrix_v_gros(),
                         ListAchat.get(i).getPrix_v_special(),
                        ListPr.get(i).getId_produit(),nv_quantite ,date1);
                    
             
            } catch (Exception ex) {
                
              //  System.out.println("modifier produit exception=");
                Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
  
          try {  
               nv_dette=dette+(total_apres_remise-m_verse);
                  // System.out.println("nv_dette="+nv_dette+"    idf=+"+idf);
              if(idf>0)fop.modifier_Dette_Fournisseur(idf,nv_dette);
             
          } catch (Exception ex) {
             // Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
          }
   
     
    
          try {
          //  System.out.println("idfffff="+idf);
         if(c1)
     
     vf.inserer_versement(new Versement(nom_four, date1,Double.parseDouble(montant_verser.getText()),idf,etat,num_bon_reception,"",Aucceuil.userName,dette,0));
        
          else vf.modifier_versement(num_bon_reception, Double.parseDouble(montant_verser.getText()), "Valider");
          } catch (Exception ex) {
              Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
             // System.out.println("versement exception");
          }
          
          try{
   if(PayerCaisseCheckBox.isSelected()) {
       ListCaisse.get(Caisse.getSelectedIndex()).setMontant(ListCaisse.get(Caisse.getSelectedIndex()).getMontant()-m_verse);
       cop.modifier_Caisse(ListCaisse.get(Caisse.getSelectedIndex()));
        cop.Encaissement_Décaissemnt(ListCaisse.get(Caisse.getSelectedIndex()).getNum(), m_verse, date1,temp_achat ,Aucceuil.userName, "Décaissement", "décaissement", num_bon_reception);
   }
   
             }
          catch(Exception e){e.printStackTrace();}
        try{   Aucceuil.refrechEtatProduit();}catch (Exception e){}
       tools.ShowGoodMessage(this, "Votre stock des produit est modifié,\nle paiement a bien été effectué");
       //   JOptionPane.showMessageDialog(null, " Votre stock des produit est modifié,le paiement a bien été effectué   ","réussite de l'opération",JOptionPane.INFORMATION_MESSAGE,img1);
     // setVisible(false);
     //  }
        }
         CodeBarre.requestFocus();
     
   
   
   c1=true;
  
   }
   void imprimer(ArrayList<Achat> ListPrint) throws IOException, JRException, PrinterException{
   
  JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListAchat);


        
  if(!ListPrint.isEmpty()){
     
 
                 para.put("activite", p.getActivite());
                  para.put("adresse_p", p.getAdresse_p());
                  para.put("message", p.getMessage());
                  para.put("NIF", p.getNIF());
                  para.put("NIS", p.getNIS());
                  para.put("NRC", p.getNRC());
                  para.put("RIB", p.getRIB());
                  para.put("nom_magasin", p.getNom_magasin());
                  para.put("num_tel1_p", p.getNum_tel1_p());
                  para.put("num_tel2_p", p.getNum_tel2_p());
                  para.put("num_tel_fax_fix_p", p.getNum_tel_fax_fix_p());
           //     System.out.println("nom_magasint="+p.getNom_magasin());
                
                  
               //   para.put("some_word", an.convert( vop.getTotal_TTC(ListVente)));
                  para.put("dette", 0);
                 
                
   
      
          print1 = JasperFillManager.fillReport("bon_reception.jasper", para, dataSource);
          JasperViewer.viewReport(print1, false);
        
    
      
  }
   }
   
   
   
   
  /* void imprimer(){
   
  
  if(!ListAchat.isEmpty()){
   
     if(row!=-1) {
              
          try{    para.put("activite", p.getActivite());
          System.out.println(p.getActivite());
          }catch(Exception e){}
                try{  para.put("adresse_p", p.getAdresse_p());}catch(Exception e){}
                try{  para.put("message", p.getMessage());}catch(Exception e){}
              try{    para.put("NIF", p.getNIF());}catch(Exception e){}
                try{  para.put("RIB", p.getRIB());}catch(Exception e){}
               try{   para.put("NIS", p.getNIS());}catch(Exception e){}
                try{  para.put("NRC", p.getNRC());}catch(Exception e){}
                 try{ para.put("nom_magasin", p.getNom_magasin());}catch(Exception e){}
                try{  para.put("num_tel1_p", p.getNum_tel1_p());}catch(Exception e){}
                 try{ para.put("num_tel2_p", p.getNum_tel2_p());}catch(Exception e){}
                 try{ para.put("num_tel_fax_fix_p", p.getNum_tel_fax_fix_p());}catch(Exception e){}
                  
            //  try{    para.put("nom_prénom_client", f.getNom_prénom_client());}catch(Exception e){}
               try{   para.put("adresse", f.getAdresse());}catch(Exception e){}
                try{  para.put("num_article_imposition", f.getNum_article_imposition());}catch(Exception e){}
           //     try{  para.put("crédit", f.getCrédit());}catch(Exception e){}
                 try{ para.put("num_id_fiscale", f.getNum_id_fiscale());}catch(Exception e){}
             // try{    para.put("num_reg_commerce", f.getNum_reg_commerce());}catch(Exception e){}
            //   try{    para.put("RIB_C", f.getRib_c());}catch(Exception e){}
               
               try{   para.put("num_tel1", f.getNum_tel1());}catch(Exception e){}
               try{   para.put("num_tel2", f.getNum_tel2());}catch(Exception e){}
                  
               // try{  para.put("some_word", an.convert( vop.getTotal_TTC(ListVente)));}catch(Exception e){}
                try{  para.put("dette", dette);}catch(Exception e){}
         
         
     
                reportsengine.ReportsManager.getInstance().showReport("bon_reception.jasper", new Hashtable(), "Bon de Réception",ListPrintBon);

         //    print1 = jfm.fillReport("bon_reception.jasper", para, dataSource);
            // view(print1);
        

     }
  }
   CodeBarre.requestFocus();
  
   }*/
  private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    } 
}
