/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;


import controler.BoutonColor;
import controler.Commande_fournisseur_op;
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
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import model.Commande;
import model.Fournisseur;
import model.Paramaitre;
//import model.PrintReportBonLivrason;
//import model.PrintReportBonReception;
import model.Produit;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;





/**
 *
 * @author Rais
 */
public class NewCommandeFournisseur extends javax.swing.JFrame implements KeyListener {
  //  ImageIcon   img = new ImageIcon("images/gs.png");
  //  ImageIcon   img1 = new ImageIcon("images/accept.png");
    Tools tools=Tools.getInstance();
  //  ImageIcon   img2 = new ImageIcon("images/warning.png");
    Tools t=Tools.getInstance();
    Map   para = new HashMap();
    JasperPrint print;
       JasperFillManager jfm;
 //  NumberFormat formatter = new DecimalFormat("#0.00");  
 TextNumber tnb= TextNumber.getObj();  
 //String Type_bon="Reception";
Fournisseur_op fop= Fournisseur_op.getObj();
 Paramaitres_op paop= Paramaitres_op.getInstance();
public static Commande_fournisseur_op cfop= Commande_fournisseur_op.getInstance();
public static Produit_op pop= Produit_op.getInstance();
 FontStyle fs= FontStyle.getInstance();
 String s="";
 String heure="";
 int q=0;
 public static NewCommandeFournisseur obj=null;
 String temp_commande = "";
 public static Date date1=null;
// public ArrayList<Fournisseur> ListFournisseur;
public static ArrayList<Produit> ListPr=new ArrayList<>();
  ArrayList<Fournisseur> ListFournisseur=new ArrayList<>();
//public static ArrayList<PrintReportBonReception> ListPrintBon =new ArrayList<>(); 
//public List ListProduitQuantité;
public static List<Float> ListProduitQuantité = new ArrayList<>();
//public static List<Float> ListProduitQuantitéAcheteAvantMod = new ArrayList<>();
//public static List<Double> ListPrixAchat = new ArrayList<>();

SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
NumberFormat formatter = new DecimalFormat("#0.00"); 

public static  ArrayList<Commande> ListCommande =new ArrayList<>();  
// static public Produit p;
static public Fournisseur f;
 public static String nom_four="";
   int idf=0;
 //Fournisseur four=null;
public static double c;
public static int num_bon_commande=1;
 // double nouveau_dette=0;
 BoutonColor bc= BoutonColor.getInstance();
double dette=0;
 
 int row,column;
int indexFournisseur=0;
 float quantite_commander=0;
// public static  double dette=0;
 
 DateFormater df=new DateFormater() ;
  // Paramaitre pa=null;
 Versement_fournisseur vf= Versement_fournisseur.getObj();
  static  int numVer=0;
 // public static String date_commande="";
   Paramaitres_op parop= Paramaitres_op.getInstance();
 Paramaitre p; 
boolean c1=true;
 public static String user;
 public static String etat="valider";
            
 //  MouseEvent me;
    /**
     * Creates new form 
     */
  
  public static NewCommandeFournisseur getObj(String User){
     // ListPrintBon.clear();
      nom_four="";
      if(obj==null){
            try { 
       obj=new NewCommandeFournisseur(User);
            } catch (Exception ex) {
                Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
  
 /* public static NewCommandeFournisseur getObj(ArrayList<Commande> listCom){
     // ListPrintBon.clear();
      nom_four="";
      if(obj==null){
            try { 
       obj=new NewCommandeFournisseur(listCom);
            } catch (Exception ex) {
                Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }*/
    private NewCommandeFournisseur(String User) throws Exception {
    try {
        initComponents();
    //  datee.setDateFormatString("yyyy-MM-dd");
      // System.out.println(java.time.LocalDate.now()+"");
      // fs.SetFont1(Total,85);
      //  fs.SetFont1(DA,85);
        this.setIconImage(tools.getImageIcone().getImage());
         JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListCommande);
   try{   print =jfm.fillReport("Bon_livraison1.jasper", para, dataSource);}catch(Exception e){}
         CodeBarre.requestFocus();
         this.setIconImage(tools.getImageIcone().getImage());
        ListFournisseur= fop.Charger_fournisseur(jComboFournisseur);
         init();
 //   d=0;c=0;
   // numVer=vf.GetNextNumVersement();
 
       // date1=java.time.LocalDate.now();
    temp_commande= DateFormat.getTimeInstance().format(new java.util.Date());
    num_bon_commande=cfop.GetNextBon();
     num_bon.setText(num_bon_commande+"");
    user=User;
    TableCommande.setRowHeight(30);
    JTableHeader tableHeader = TableCommande.getTableHeader();
    TableCommande.getTableHeader().setOpaque(false);
   //   tableHeader.setBackground(Color.BLACK);
     tableHeader.setForeground(Color.BLACK);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
         
       
        p=paop.get_Paramaitre();
      
 TableCommande.addMouseListener(new MouseAdapter() {
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
   
    // CodeBarre.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
    }
 /*public NewCommandeFournisseur( ArrayList<Commande> listCom) throws Exception {  
    try {
        System.out.println("listCom size="+listCom.size());
  c1=false;
   initComponents();
   CodeBarre.requestFocus();
   this.setIconImage(img.getImage());
   TableCommande.setRowHeight(30);
   JTableHeader tableHeader = TableCommande.getTableHeader();
      //tableHeader.setBackground(Color.GREEN);
     tableHeader.setForeground(Color.black);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
      bc.ColorerBouton(select_product,  new Color(1, 101, 225));
     bc.ColorerBouton(Sup, Color.red);

      
    user=Aucceuil.userName;
    num_bon_commande=listCom.get(0).getNum_bon();
   // ListProduitQuantité=listQuantite;
    num_bon.setText(num_bon_commande+"");
    ListCommande=listCom;
    ListFournisseur= fop.Charger_fournisseur(jComboFournisseur);
    nom_four=ListFournisseur.get(0).getNom_prenom_fournisseur();
    
        try{ indexFournisseur= fop.Index(nom_four);}catch(Exception e){indexFournisseur=0;}
      //  op3.Charger_marque(Marque);
        if(nom_four.equals(" "))indexFournisseur=0;
       // else
           // if(op3.NumbreValeur()==0)Marque.addItem(prod.getMarque());
            else{
                jComboFournisseur.setSelectedIndex(indexFournisseur);
            }
    ///jComboFournisseur.setSelectedItem(nom_four);
    dette=fop.getDette(ListCommande.get(0).getIdf());
    dette_label.setText(s);
    // ListPr=listP; 
  //   Paramaitres_op paop=new Paramaitres_op();
     p=paop.get_Paramaitre();
    
  
   //  dette=dett;
   //  ListPrixAchat=listPrixAch;
   //  remise=listAch.get(0).getRemise();
    //  for(int i=0;i<ListAchat.size();i++)total=total+(ListCommande.get(i).getPrix_achat()*ListProduitQuantité.get(i));
  //  nom_fournisseur.setText(fournisseur);
//    dette_label.setText(tnb.Afficher2Verguile(dett));
  //  TFremise.setText(tnb.Afficher2Verguile(remise));
  //  montant_verser.setText(list.get(0).getSomme_versé()+"");
   
   // montant_verser.setText(tnb.Afficher2Verguile(m_verse));
   // total_apres_remise=total-remise;
   // nv_dette=dette;
   //  nvdette.setText(tnb.Afficher2Verguile(nv_dette));
     //  total_TTc=cfop.getTotal_TTC(ListCommande);
     // total_ht=cfop.getTotal_HT(ListCommande);
  //total_HT1.setText(formatter.format(total_ht)+"");
 // total_ttc1.setText(formatter.format(total_TTc)+"");
 //article1.setText(ListCommande.size()+"");
 //unité1.setText(cfop.getNombreUnité(ListCommande)+"");
// System.out.println("remise="+list.get(0).getRemise());
   cfop.displayResult1(ListCommande, TableCommande);
    
  // try{ num_bon_commande=Integer.parseInt(num_bon.getText());}catch (Exception e ){}
      date_commande=java.time.LocalDate.now()+"";
     // System.out.println("dddddd="+date_vente);
   //datee.setText(date_commande);
   // num_bon.setText(num_bon_commande+"");
    // f.setId_client("C0");
        //   jButton4.setVisible(false);   
    Sup.setVisible(true);
            // idf=listAch.get(0).getIdf();

   
 TableCommande.addMouseListener(new MouseAdapter() {
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
     //  CodeBarre.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
    }*/

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
        TableCommande = new javax.swing.JTable();
        Imprimer_BTN = new javax.swing.JButton();
        Sup = new javax.swing.JButton();
        select_product = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        num_bon = new javax.swing.JTextField();
        jComboFournisseur = new javax.swing.JComboBox<>();
        dette_label = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        CodeBarre = new javax.swing.JTextField();
        Valider_Achat_BTN = new javax.swing.JButton();
        QuantiteRem = new javax.swing.JButton();
        QuantiteAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Commande fournisseur");
        setAlwaysOnTop(true);
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

        TableCommande.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableCommande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Désignation", "QTE Stock", "QTE Commander"
            }
        ));
        TableCommande.setColumnSelectionAllowed(true);
        TableCommande.getTableHeader().setReorderingAllowed(false);
        TableCommande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableCommandeMousePressed(evt);
            }
        });
        TableCommande.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableCommandeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableCommande);
        TableCommande.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        Imprimer_BTN.setBackground(new java.awt.Color(204, 204, 204));
        Imprimer_BTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Imprimer_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-30.png"))); // NOI18N
        Imprimer_BTN.setText("Valider et imprimer Bon de commande");
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("fournisseur");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("N° bon ");

        num_bon.setEditable(false);
        num_bon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        num_bon.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jComboFournisseur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboFournisseur.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboFournisseurItemStateChanged(evt);
            }
        });
        jComboFournisseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFournisseurActionPerformed(evt);
            }
        });

        dette_label.setEditable(false);
        dette_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dette_label.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dette_label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dette_labelActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("dette:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(num_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboFournisseur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dette_label, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboFournisseur, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dette_label, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        Valider_Achat_BTN.setText("Valider sans imprimer (F1)");
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

        QuantiteRem.setBackground(new java.awt.Color(204, 204, 204));
        QuantiteRem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        QuantiteRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        QuantiteRem.setText("QTE ");
        QuantiteRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantiteRemActionPerformed(evt);
            }
        });

        QuantiteAdd.setBackground(new java.awt.Color(204, 204, 204));
        QuantiteAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        QuantiteAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        QuantiteAdd.setText("QTE  ");
        QuantiteAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantiteAddActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Sup)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(QuantiteAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantiteRem, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Imprimer_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Valider_Achat_BTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(Sup, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(QuantiteAdd)
                        .addGap(0, 0, 0)
                        .addComponent(QuantiteRem)
                        .addGap(180, 180, 180)
                        .addComponent(Valider_Achat_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Imprimer_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        CodeBarre.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_productActionPerformed
    // new RechercherProduit(1,"").setVisible(true);
        RechercherProduitCommande.getObj(Aucceuil.userName).setVisible(true);
        this.setVisible(false);
     //  Sup.setVisible(true);
   //System.out.println( "value ="+jTable1.getModel().getValueAt(0, 1));
    }//GEN-LAST:event_select_productActionPerformed

    private void SupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupActionPerformed
    
     //   if(!f.getNom_prenom_fournisseur().isEmpty())dette_label.setText(f.getDette()+"");
        int position=TableCommande.getSelectedRow(); 
         if(row==-1||position==-1)tools.ShowFailMessage(this, "Veuiller sélectionner une ligne");
            // JOptionPane.showMessageDialog(null, " Veuiller sélectionner une ligne  ","",JOptionPane.INFORMATION_MESSAGE,img2);
         else {ListPr.remove(position);
      //     ListProduitQuantitéAcheteAvantMod.remove(position);
        //  total=total-(ListProduitQuantité.get(position)*ListCommande.get(position).getPrix_achat());
       
         ListProduitQuantité.remove(position);
         //  ListPrixAchat.remove(position);
           ListCommande.remove(position);
       //    ListPrintBon.remove(position);
       //  System.out.println("pro size="+ListProduitQuantité.size()+"achat size="+ListCommande.size());
        
                  
                        
                        
                        
                        
                        
            try {
                //  pop.displayResult1(ListPr, jTable1);
                pop.displayResult1(ListPr, TableCommande,ListProduitQuantité);
            } catch (Exception ex) {
                Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            
           
                     
         }
          CodeBarre.requestFocus();
    }//GEN-LAST:event_SupActionPerformed

    private void Valider_Achat_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_Achat_BTNActionPerformed
 Valider();
init();


//ListeCommandeFournisseur.ListCommande=
  try {  ListeCommandeFournisseur.ListCommande.clear();
        ListeCommandeFournisseur.ListCommande=ListeCommandeFournisseur.iop.getListBonCommande();
       ListeCommandeFournisseur.iop.displayBonCommande(ListCommande,TableCommande); 
  }catch (Exception e){}
    obj=null;
  this.dispose();
    }//GEN-LAST:event_Valider_Achat_BTNActionPerformed

    private void TableCommandeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableCommandeKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     //System.out.println("key enter");
   }
    }//GEN-LAST:event_TableCommandeKeyPressed

    private void Imprimer_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimer_BTNActionPerformed
        try {
            Valider();
            imprimer();
            // System.out.println("nom fournisseur=="+nom_four);
            init();
            
            this.dispose();
        } catch (JRException ex) {
            Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
         obj=null;
         this.dispose();
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
                      ListCommande.get(pos).setQuantité(ListCommande.get(pos).getQuantité()+pp.getNbre_produit_packet());
                     else ListCommande.get(pos).setQuantité(ListCommande.get(pos).getQuantité()+1);
                     
                     
                     }
                     else {
                     ListPr.add(pp);
                     if(pp.getNbre_produit_packet()>0) 
                        ListProduitQuantité.add((float)pp.getNbre_produit_packet());
                     else ListProduitQuantité.add((float)1);
                    ListCommande.add(new Commande(num_bon_commande,new Date(System.currentTimeMillis()),jComboFournisseur.getSelectedItem().toString(),
               DateFormat.getTimeInstance().format(new java.util.Date()),user,pp.getDésignation(),
               ListProduitQuantité.get(ListProduitQuantité.size()-1),pp.getId_f(),pp.getId_produit()));
       /* PrintReportBonReception prb=   new PrintReportBonReception (
                p.getNom_magasin(),
                p.getAdresse_p(),
                p.getNum_tel_fax_fix_p(),
                p.getNum_tel1_p(),
          p.getNum_tel2_p(),num_bon_commande,nom_four,ListPr.get(pos).getDésignation());
          ListPrintBon.add(prb);*/
                       
                      
                     // ListPrixAchat.add(pp.getPrix_achat());
                    //  ListPrixVenteDetail.add(pp.getPrix_vente_detail());
                    //  ListPrixVenteGros.add(pp.getPrix_vente_gros());
                     }
                   //   ListProduitQuantitéAcheteAvantMod.add((float)0);

                      pop.displayResult1(ListPr, TableCommande,ListProduitQuantité);
                  
                    }
                 //    System.out.println("pp="+pp.toString());
                 //   for(int i=0;i<ListAchat.size();i++){
                 //      if(ListCommande.get(i).getId_produit()==pp.getId_produit())
                 //       {   product_in_list=true;position_liste=i;break;}
             } catch (Exception ex) {
              //   System.out.println("Exception");
                 ex.getMessage();
                 Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
             }
                                         }

                                     
    }//GEN-LAST:event_CodeBarreKeyReleased

    private void QuantiteAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantiteAddActionPerformed

        
       System.out.println("row="+row);
        try{ quantite_commander=ListProduitQuantité.get(row);
            quantite_commander=quantite_commander+1;
           //   System.out.println("ListProduitQuantité size="+ListProduitQuantité.size());
          TableCommande.getModel().setValueAt(quantite_commander, row, 2);
          ListProduitQuantité.set(row, quantite_commander);
          // System.out.println("list produit quantite="+ListProduitQuantité.get(row));
          ListCommande.get(row).setQuantité(quantite_commander);
          //  System.out.println("list achat quantite="+ListCommande.get(row).getQuantité());
        //  ListPrintBon.get(row).setQuantité(quantite_commander);
        
         
        CodeBarre.requestFocus();
        } catch(Exception e){}
    }//GEN-LAST:event_QuantiteAddActionPerformed

    private void QuantiteRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantiteRemActionPerformed
   
        try{ quantite_commander=ListProduitQuantité.get(row);  
      //   System.out.println("quantite_commander="+quantite_commander);
            if(quantite_commander>0) { quantite_commander=quantite_commander-1;
        TableCommande.getModel().setValueAt(quantite_commander, row, 2);
        ListProduitQuantité.set(row, quantite_commander);
         ListCommande.get(row).setQuantité(quantite_commander);
    //      ListPrintBon.get(row).setQuantité(quantite_commander);
              
     
                       
                    
            }
                 
    }catch(Exception e){}
        CodeBarre.requestFocus();
    }//GEN-LAST:event_QuantiteRemActionPerformed

    private void Valider_Achat_BTNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Valider_Achat_BTNKeyPressed
       if(evt.getKeyChar()==KeyEvent.VK_F1){Valider();}
    }//GEN-LAST:event_Valider_Achat_BTNKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     //  System.out.println("windows closing");
      init();
     obj=null;
      
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         if(evt.getKeyChar()==KeyEvent.VK_F1){Valider();}
    }//GEN-LAST:event_formKeyPressed

    private void TableCommandeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCommandeMousePressed
  // if(c1) {
       TableCommande.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingCanceled(ChangeEvent e) {
                   //     System.out.println(jTable1.getModel().getValueAt(0, 1)+"editingCanceled");
                    }

                    @Override
                    public void editingStopped(ChangeEvent e) {
                   try{ 
                       quantite_commander=Float.parseFloat(TableCommande.getModel().getValueAt(row, 2).toString()); 
                        if(quantite_commander<0){
                            tools.ShowFailMessage(NewCommandeFournisseur.this, "La quantité doit être >=0 ");
                      //      JOptionPane.showMessageDialog(null, " La quantité doit être >=0  ","erreur",JOptionPane.INFORMATION_MESSAGE,img2);
                      quantite_commander=0;}
                      
                   }
                      catch (Exception ex){
               quantite_commander=0;
              
              TableCommande.getModel().setValueAt(quantite_commander, row, 2);
              
             //   nv_dette=0;
             //   nvdette.setText(s);
             
               
           }
                  // System.out.println("ListProduitQuantité size="+ListProduitQuantité.size());
          ListProduitQuantité.set(row, quantite_commander);
          ListCommande.get(row).setQuantité(quantite_commander);
         
    //    ListPrintBon.get(row).setQuantité(quantite_commander);
       
      
    
                   //  jTable1.getModel().setValueAt(pvente, row, 4);
                  TableCommande.getModel().setValueAt(quantite_commander, row, 2);
                    
                   
              
            
                  ListCommande.get(row).setQuantité(quantite_commander);
                 
        //  ListPrintBon.get(row).setQuantité(quantite_commander);
              
      
              
                  
                    //total_TTc=cfop.getTotal_TTC(ListCommande);
                    
                   //   if(!f.getNom_prenom_fournisseur().isEmpty())try {
                   //       dtte=fop.getDette(f.getId_fournisseur());
                  //  } catch (Exception ex) {
                     //   Logger.getLogger(NewAchat.class.getName()).log(Level.SEVERE, null, ex);
                  //  }
    //  total_ht=cfop.getTotal_HT(ListCommande);
 // total_HT1.setText(formatter.format(total_ht)+"");
 // total_ttc1.setText(formatter.format(total_TTc)+"");
  //article1.setText(ListCommande.size()+"");
  //montant_verser1.setText(total_TTc+dtte+"");
 // Total_a_payer1.setText(formatter.format(total_TTc)+" DA");
 
  
  
   
                  
                    }
                });
 //  }

    }//GEN-LAST:event_TableCommandeMousePressed

    private void jComboFournisseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFournisseurActionPerformed

        try {
       //     f.setNom_prenom_fournisseur(jComboFournisseur.getSelectedItem().toString());
          //  f.setId_fournisseur(fop.getFournisseur(jComboFournisseur.getSelectedItem().toString()));
        } catch (Exception ex) {
            Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboFournisseurActionPerformed

    private void jComboFournisseurItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboFournisseurItemStateChanged
   //    System.out.println(jComboFournisseur.getSelectedItem());
           try {
       nom_four=jComboFournisseur.getSelectedItem().toString();
       idf=ListFournisseur.get(jComboFournisseur.getSelectedIndex()-1).getId_f();
       dette=ListFournisseur.get(jComboFournisseur.getSelectedIndex()-1).getDette();
       dette_label.setText(tnb.Afficher2Verguile(dette));
     //  System.out.println("idffffff="+idf);
        // System.out.println("jComboFournisseur.getSelectedItem().toString()="+jComboFournisseur.getSelectedItem().toString());
      //   f.setId_fournisseur(fop.getFournisseur(jComboFournisseur.getSelectedItem().toString()));
        } catch (Exception ex) {
           // Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboFournisseurItemStateChanged

    private void dette_labelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dette_labelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dette_labelActionPerformed

    /**  
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodeBarre;
    private javax.swing.JButton Imprimer_BTN;
    private javax.swing.JButton QuantiteAdd;
    private javax.swing.JButton QuantiteRem;
    private javax.swing.JButton Sup;
    public static javax.swing.JTable TableCommande;
    private javax.swing.JButton Valider_Achat_BTN;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JTextField dette_label;
    private javax.swing.JComboBox<String> jComboFournisseur;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField num_bon;
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
 ListCommande.clear();
 //ListPrixVenteDetail.clear();
// ListPrixVenteGros.clear()
//ListPrintBon.clear();
// static public Produit p;
f=null;
nom_four="";
num_bon_commande=1;
 // pachat=0;pvente_detail=0;pvente_gros=0;
 date1=null;
 //m_verse=0;
 // double r_a_payer;
  //nv_dette=0;
   //row,column;
  //total=0;
   quantite_commander=0;
 // dette=0;
 //remise=0;
 // total_apres_remise=0;
  // numVer=0;
//  date_commande="";
//  nom_four="";
  //  TextNumber tn=new TextNumber();
  idf=0;
  //ListProduitQuantitéAcheteAvantMod.clear();
   etat="valider";
   } 
   public void Valider(){
   //float nv_quantite=0;
  // temp_commande=  new Date(System.currentTimeMillis())+"";
temp_commande=  DateFormat.getTimeInstance().format(new java.util.Date());
  
       
        try{
         //   date_per=df.FormaterDate((Calendar)Date_per.getModel().getValue());
        date1 =new Date(System.currentTimeMillis());
        //   date1 = Date.valueOf(df1.format(datee.getDate()));
        heure= DateFormat.getTimeInstance().format(new java.util.Date())+"";
            // date1=Date.valueOf(datee.getDate()+"");
  //   System.out.println("date dddd="+date1);
      }catch(Exception e){date1=null;
      e.printStackTrace();
      e.getMessage();
      }
  //  if(datee.getModel().getValue()!=null)
    for(int i=0;i<ListPr.size();i++){
     /*   ListCommande.add(
 new Commande(num_bon_commande,date1,nom_four,heure,user,ListPr.get(i).getDésignation(),ListProduitQuantité.get(i),7,ListPr.get(i).getId_produit()));*/
    try {  ListCommande.get(i).setIdf(idf);
     ListCommande.get(i).setDate(date1); 
     ListCommande.get(i).setNom_prénom_fournisseur(jComboFournisseur.getSelectedItem().toString());
      //  System.out.println("id after insert ="+ListCommande.get(i).getIdf());
        cfop.Inserer_Commande(ListCommande.get(i));
    } catch (Exception ex) {
        Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

  // CodeBarre.requestFocus();
 // System.out.println("date="+date1);
// }
        if(ListCommande.isEmpty())tools.ShowFailMessage(this, "Veuiller ajouter des produits au liste de commande");
         //   JOptionPane.showMessageDialog(null, " Veuiller ajouter des produits au liste de commande   ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
      
      
         CodeBarre.requestFocus();
     t.ShowGoodMessage(this,"Bien insérer");
   
   
  // c1=true;
  
   }
   void imprimer() throws JRException{
   
    JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListCommande);
  if(!ListCommande.isEmpty()){
       try{    para.put("activite", p.getActivite());}catch(Exception e){}
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
                 try{     para.put("date1",date1+""); }catch(Exception e){}
               try{   para.put("nom_fournisseur",jComboFournisseur.getSelectedItem()+""); }catch(Exception e){}
           
      
   //   System.out.println("ListCommande size="+ListCommande.size());
      //   System.out.println("ListPr size="+ListPr.size());
      
   print = JasperFillManager.fillReport("Bon_commande.jasper", para, dataSource);
        try {
            t.view(print);
        } catch (JRException ex) {
            Logger.getLogger(NewCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
  }
   CodeBarre.requestFocus();
  
   }
   
}
