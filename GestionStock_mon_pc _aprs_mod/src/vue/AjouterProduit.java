/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.toedter.calendar.JTextFieldDateEditor;
import controler.Achat_op;
import controler.BoutonColor;
import controler.Famille_op;
import controler.CheckField;
import controler.CodeBarre_op;
import controler.Marque_op;
import controler.Produit_op;
import controler.Unite_op;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Marque;
import model.Produit;

import static vue.GestionProduit.ListProduit2;
import static vue.GestionProduit.jTable1;
import static vue.GestionProduit.produit_total;
import controler.Couleur_op;
import controler.DateFormater;
import controler.Paramaitres_op;
import controler.Pointure_op;
import controler.Produit_paramaitre_op;
import controler.Taille_op;
import controler.TextNumber;
import controler.Tools;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.Achat;
import model.CodeBarre;
import model.Paramaitre;
import model.PrintReportBonReception;
import raven.javaswingdev.MessageDialog;


//import static vue.VenteComptoir4.num_bon_reception;
import static vue.GestionProduit.nbre_produit;
//import static vue.GestionProduit.op;
import static vue.NewAchat.ListAchat;
import static vue.NewAchat.ListPrintBon;
import static vue.NewAchat.ListProduitQuantité;
import static vue.NewAchat.TFtotal;
import static vue.NewAchat.Total;

import static vue.NewAchat.ListProduitQuantitéAcheteAvantMod;
import static vue.NewAchat.nom_four;
import static vue.NewAchat.idf;
import static vue.NewAchat.user;
import static vue.NewAchat.date1;
import static vue.NewAchat.dette;
import static vue.NewAchat.m_verse;
import static vue.NewAchat.montant_verser;
import static vue.NewAchat.nv_dette;
import static vue.NewAchat.nvdette;
import static vue.NewAchat.remise;
import static vue.NewAchat.total_apres_remise;
import static vue.NewAchat.TableAchat;

/**
 *
 * @author Rais
 */
public  class AjouterProduit extends javax.swing.JFrame implements KeyListener{
public static Marque_op op = Marque_op.getInstance();

 Paramaitre par ;

 
 Produit_op pop=   Produit_op.getInstance();
 public static boolean ou;
 String s="";
 String taille="";
 String pointure="";
 String couleur="";
 String date_per=null;
 String codebarre="";
 int num_achat=0;
 double prix_achat=0;
 double prix_v_detaile=0;
 double prix_v_gros=0;
 double prix_v_special=0;
 double prix_promo=0;
 double prix_vente_packet=0;
 
 Date date_achat=null;
 public  String path="";
 public static ArrayList<Marque> list=new ArrayList<>();
  public  ArrayList<CodeBarre> listBareCode=new ArrayList<>();
 static  public String Marquecom;
static Famille_op op2= Famille_op.getInstance();
static Marque_op op3= Marque_op.getInstance();
static Unite_op op4= Unite_op.getInstance();
static Taille_op op5= Taille_op.getInstance();
static Pointure_op op6= Pointure_op.getInstance();
static Couleur_op op7= Couleur_op.getInstance();
Achat_op op9= Achat_op.getInstance();
static CodeBarre_op op8= CodeBarre_op.getInstance();
CodeBarre_op cbop= CodeBarre_op.getInstance();
BoutonColor bc=BoutonColor.getInstance();
//static Produit_op op9= Produit_op.getInstance();
DateFormater df= DateFormater.getInstance();
SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
Paramaitres_op parop= Paramaitres_op.getInstance();
Tools tools=Tools.getInstance();
double total=0;
   TextNumber tnb= TextNumber.getObj(); 
int next_id=0;
int id_pro;
int id_p=0;
 
//CodeBarre_op bop=new CodeBarre_op();
Produit_paramaitre_op pp= Produit_paramaitre_op.getInstance();
CheckField cf= CheckField.getInstance();
NumberFormat formatter = new DecimalFormat("#0.00"); 
//ImageIcon icon = new ImageIcon("images/accept.png");
//ImageIcon   img = new ImageIcon("images/accept.png");
//ImageIcon   img1 = new ImageIcon("images/gs.png");
ImageIcon   img3 = new ImageIcon("images/images(2).png");
//ImageIcon   img2 = new ImageIcon("images/erreur.gif");
//ImageIcon   img4 = new ImageIcon("images/warning.png");
 int t=0;
 char action='a';
 String barecode="";
  File fichier ;
  String chemin="";
  int indexMarque=0;
  int indexFamille=0;
  int indexUnite=0;
  int indexTaille=0;
  int indexPointure=0;
  int indexCouleur=0;
  
  String reference;
 // TextNumber tn=new TextNumber();
  TextNumber tn= TextNumber.getObj();
 // BoutonColor bc= BoutonColor.getInstance();
 // public static ArrayList<Produit> L_produit=new ArrayList<>();
  JFormattedTextField textField1;
  JFormattedTextField textField2;
  private static AjouterProduit obj=null;
 private  static AjouterProduit obj2=null;
 static  Produit prod;
 
   String code_bare_packet="";
    
       int nbre_produit_packet=0;
      boolean vente_packet=false;
  
    /**
     * Creates new form 
     */
  
  public static AjouterProduit getObj(int type){
      
      //  code_bare.addKeyListener(this);
        
      if(obj==null){
            try {
                obj=new AjouterProduit(type);
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
  
  public static AjouterProduit getObj2(Produit p){
      
      //  code_bare.addKeyListener(this);
        
      if(obj2==null){
            try {   
                obj2=new AjouterProduit(p);
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj2;
    }
  
  
  
    private AjouterProduit(int type ) {

        t=type;
        action='a';
        initComponents();
            JTextFieldDateEditor editor = (JTextFieldDateEditor) Date_per.getDateEditor();
editor.setEditable(false);
      //  code_bare.addKeyListener(this);
       this.setIconImage(tools.getImageIcone().getImage());
  
         op2.Charger_famille(famille);
       // list= op.Charger_marqueslist("auto");
         op3.Charger_marque(Marque);
         op4.Charger_unite(Unite);
        
      
      prix_achat=Double.parseDouble(priachat.getText());
      priachat.setText(formatter.format(prix_achat).replace(',', '.')+"");
      
      jLabel2.setText("Ajouter un Produit");
      prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
      prix_vente_special.setText(formatter.format(prix_v_detaile).replace(',', '.')+"");
      
      prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
      prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
      
       prix_v_special=Double.parseDouble(prix_vente_special.getText());
      prix_vente_special.setText(formatter.format(prix_v_special).replace(',', '.')+"");
      
        
           try {
            //   sucategorie();
        next_id=pop.GetNextidProduit();
    } catch (Exception ex) {
        Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
           chemin="images/image_produits/"+next_id+".jpg";
       
     
    
 pop.DisplayCodeBarre(listBareCode, jTableCodeBarre);
 Date_per.setVisible(false);
 jour_alerte.setVisible(false);
 jLabel_jour_alert.setVisible(false);
 
jLabel_nombre_produit_packet.setVisible(false);
quantité_packet.setVisible(false);
jLabel_vente_packet.setVisible(false);
prix_v_packet_text.setVisible(false);
jCheckBoxCodeBarrePacket.setVisible(false);
CodeBarrePacket.setVisible(false);
jLabelprintcodebare.setVisible(false);


ListeTaille.setVisible(false);
ListePointure.setVisible(false);
ListeCouleur.setVisible(false);

AddTaille.setVisible(false);
DelTaille.setVisible(false);

AddPointure.setVisible(false);
DelPointure.setVisible(false);

AddCouleur.setVisible(false);
DelCouleur.setVisible(false);

//quantité_promotion
 textField1 = ((DefaultEditor) quantité_packet.getEditor()).getTextField();
 textField1.setHorizontalAlignment(JTextField.CENTER);
      
     

    bc.ColorerBouton(Annuler, Color.red);
   bc.ColorerBouton(ajouter, new Color(41,134,10));
      
         JTableHeader tableHeader = jTableCodeBarre.getTableHeader();
          Font headerFont = new Font("Verdana", Font.BOLD, 11);
      tableHeader.setFont(headerFont);
          
//if(t==1)quantite.setEditable(false);
    }
    
    
private AjouterProduit(Produit p) {       
prod=p;
    t=0;
    action='b';

id_pro=prod.getId_produit();
    try {
        initComponents();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) Date_per.getDateEditor();
editor.setEditable(false);
        jLabel2.setText("Modifier un Produit");
        try {
                      File f=new File("images/image_produits");
                      if(!f.exists())
                      f.mkdir();
 fichier = new File("images/image_produits/"+id_pro+".jpg");
 path = fichier.getAbsolutePath();

 chemin="images/image_produits/"+id_pro+".jpg";
 
  
  
 
                } catch (Exception ex) {
                    //  Logger.getLogger(Paramaitres.class.getName()).log(Level.SEVERE, null, ex);
                }
              //   jLabel_image.setIcon(resize(path));
        
       try{    if((!fichier.exists())||(prod.getImage().equals("")))jLabel_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images(2).png"))); 
           else jLabel_image.setIcon(resize(prod.getImage()));
      // System.out.println("prod.getImage="+prod.getImage());
       }catch(Exception e){
        
        jLabel_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images(2).png"))); 
       }
          // jLabel_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/image_produits/147.jpg")));
        
        //  code_bare.addKeyListener(this);
         this.setIconImage(tools.getImageIcone().getImage());
        designation.setText(prod.getDésignation());
        
       try{ indexMarque= op3.Index(prod.getMarque());}catch(Exception e){indexMarque=0;}
        op3.Charger_marque(Marque);
        if(prod.getMarque().equals(" "))indexMarque=0;
        else
            if(op3.NumbreValeur()==0)Marque.addItem(prod.getMarque());
            else{
                Marque.setSelectedIndex(indexMarque);
            }
        
        quantite.setText(prod.getQuantité()+"");
        priachat.setText(formatter.format(prod.getPrix_achat()).replace(',', '.')+"");
        prix_vente_special.setText(formatter.format(prod.getPrix_special()).replace(',', '.')+"");
        prix_vente_gros.setText(formatter.format(prod.getPrix_vente_gros()).replace(',', '.')+"");
        prix_vente_detail.setText(formatter.format(prod.getPrix_vente_detail()).replace(',', '.')+"");
        
        double m_d=0;
        double m_g=0;  
        double m_s=0;
        
      try{ if(prod.getPrix_achat()>0)  m_d=(100*(prod.getPrix_vente_detail()-prod.getPrix_achat()))/prod.getPrix_achat();
        marge_detail.setText(tn.Precision(m_d)+"");
      }catch(Exception e){ m_d=0;marge_detail.setText(tn.Afficher2Verguile(m_d)+""); }
        try{     if(prod.getPrix_achat()>0)  m_g=(100*(prod.getPrix_vente_gros()-prod.getPrix_achat()))/prod.getPrix_achat();
    marge_gros.setText(tn.Precision(m_g)+"");
         }catch(Exception e){ m_g=0;marge_gros.setText(tn.Afficher2Verguile(m_g)+""); }
        
      try{ if(prod.getPrix_achat()>0)    m_s=(100*(prod.getPrix_special()-prod.getPrix_achat()))/prod.getPrix_achat();
        marge_special.setText(tn.Precision(m_s)+"");
         }catch(Exception e){ m_s=0;marge_special.setText(tn.Afficher2Verguile(m_s)+""); }
        
        étagére.setText(prod.getÉtagére());
        
       try{ indexFamille= op2.Index(prod.getFamille());}catch(Exception e){indexFamille=0;}
        op2.Charger_famille(famille);
        if(prod.getFamille().equals(" "))indexFamille=0;
        else
            if(op2.NumbreValeur()==0)famille.addItem(prod.getFamille());
            else{
                famille.setSelectedIndex(indexFamille);
            }
        
       try{  indexUnite= op4.Index(p.getUnite());}catch(Exception e){indexUnite=0;}
        op4.Charger_unite(Unite);
        if(prod.getUnite().equals(" "))indexUnite=0;
        else
            if(op4.NumbreValeur()==0)Unite.addItem(prod.getUnite());
            else{
                Unite.setSelectedIndex(indexUnite);
            }
        
        Stock_alert.setText(prod.getStock_alert()+"");
        TVA.setText(prod.getTva()+"");
        remarque.setText(prod.getRemarque());
        
        if(prod.getDate_premption()==null){jour_alerte.setVisible(false);JExperation_date.setSelected(false);Date_per.setVisible(false);jLabel_jour_alert.setVisible(false);}
        else {Date_per.setVisible(true);jour_alerte.setVisible(true);JExperation_date.setSelected(true);
        jour_alerte.setText(prod.getJour_alert()+"");
           Date d=Date.valueOf(prod.getDate_premption());
         // Date d=prod.getDate_premption();
        Date_per.setDate(d);
      
        }
       //  System.out.println("p.isPromotion()="+p.isPromotion());
        if(prod.isVente_packet()){
           packet.setSelected(true);
           jLabel_nombre_produit_packet.setVisible(true);
           quantité_packet.setVisible(true);
           jLabel_vente_packet.setVisible(true);
           prix_v_packet_text.setVisible(true);
           jCheckBoxCodeBarrePacket.setVisible(true);
           jLabelprintcodebare.setVisible(true);
           prix_v_packet_text.setText(formatter.format(prod.getPrix_vente_packet()).replace(',', '.')+"");
           quantité_packet.setValue(prod.getNbre_produit_packet());
           if(!prod.getCode_bare_packet().equals("")){CodeBarrePacket.setText(prod.getCode_bare_packet());
           jCheckBoxCodeBarrePacket.setSelected(true);
            
            }else {CodeBarrePacket.setText(""); jCheckBoxCodeBarrePacket.setSelected(false);}
        }
        else {
            packet.setSelected(false);
            jLabel_nombre_produit_packet.setVisible(false);
            quantité_packet.setVisible(false);
          //  quantité_promotion.setValue(p.getQuantité_promotion());
            jLabel_vente_packet.setVisible(false);
             prix_v_packet_text.setVisible(false);
             CodeBarrePacket.setVisible(false);
             jCheckBoxCodeBarrePacket.setVisible(false);
             jLabelprintcodebare.setVisible(false);
            
        }
        
        
        
        
       try{ indexTaille= op5.Index(prod.getTaille());}catch(Exception e){indexTaille=0;}
        if(prod.getTaille().equals("")){indexTaille=0; //System.out.println("taille null");
        ListeTaille.setVisible(false);
        AddTaille.setVisible(false);
        DelTaille.setVisible(false);
        Taille.setSelected(false);
        }
        else{
            if(op5.NumbreValeur()==0){ListeTaille.addItem(prod.getTaille());
            }
            else{
                Taille.setSelected(true);
            }
            ListeTaille.setVisible(true);
            AddTaille.setVisible(true);
            DelTaille.setVisible(true);
        }
        op5.Charger_taille(ListeTaille);
    try{    ListeTaille.setSelectedIndex(indexTaille);}catch(Exception e){indexTaille=0;}
        
        
        
       try{ indexPointure= op6.Index(prod.getPointure());}catch(Exception e){indexPointure=0;}
        if(prod.getPointure().equals("")){indexPointure=0;
        ListePointure.setVisible(false);
        AddPointure.setVisible(false);
        DelPointure.setVisible(false);
        Pointure.setSelected(false);
        }
        else{
            if(op6.NumbreValeur()==0){ListePointure.addItem(prod.getTaille());
            }
            else{
                Pointure.setSelected(true);
            }
            ListePointure.setVisible(true);
            AddPointure.setVisible(true);
            DelPointure.setVisible(true);
        }
        op6.Charger_pointure(ListePointure);
     try{   ListePointure.setSelectedIndex(indexPointure);}catch(Exception e){indexPointure=0;}
        
        
       try{ indexCouleur= op7.Index(prod.getCouleur());}catch(Exception e){indexCouleur=0;}
        if(prod.getCouleur().equals("")){indexCouleur=0;
        ListeCouleur.setVisible(false);
        AddCouleur.setVisible(false);
        DelCouleur.setVisible(false);
        Couleur.setSelected(false);
        }
        else{
            if(op7.NumbreValeur()==0){ListeCouleur.addItem(prod.getCouleur());
            }
            else{
                Couleur.setSelected(true);
            }
            ListeCouleur.setVisible(true);
            AddCouleur.setVisible(true);
            DelCouleur.setVisible(true);
        }
        op7.Charger_couleur(ListeCouleur);
        ListeCouleur.setSelectedIndex(indexCouleur);
        
        listBareCode=op8.GetListCode(prod.getId_produit());
       // System.out.println("listBareCode size="+listBareCode.size());
        pop.DisplayCodeBarre(listBareCode, jTableCodeBarre);
        
        

textField1 = ((DefaultEditor) quantité_packet.getEditor()).getTextField();
textField1.setHorizontalAlignment(JTextField.CENTER);

 bc.ColorerBouton(Annuler, Color.red);
   bc.ColorerBouton(ajouter, new Color(41,134,10));

//bc.ColorerBouton(jButton2, Color.red);
//bc.ColorerBouton(Enregistrer, new Color(41,134,10));
 
JTableHeader tableHeader = jTableCodeBarre.getTableHeader();
Font headerFont = new Font("Verdana", Font.BOLD, 11);
tableHeader.setFont(headerFont);
    } catch (Exception ex) {
        Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
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

        DelFamille = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        famille = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        Marque = new javax.swing.JComboBox();
        AddMarque = new javax.swing.JButton();
        DelMarque = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        code_bare = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        designation = new javax.swing.JTextField();
        étagére = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        remarque = new javax.swing.JTextField();
        Enregistrer = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        priachat = new javax.swing.JTextField();
        quantite = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Unite = new javax.swing.JComboBox();
        addUnite = new javax.swing.JButton();
        Del_unite = new javax.swing.JButton();
        Stock_alert = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel25 = new javax.swing.JLabel();
        prix_vente_special = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        TVA = new javax.swing.JTextField();
        jPanelTitle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel_image = new javax.swing.JPanel();
        jLabel_image = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        prix_vente_gros = new javax.swing.JTextField();
        marge_gros = new javax.swing.JTextField();
        marge_special = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCodeBarre = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        prix_v_packet_text = new javax.swing.JTextField();
        jLabel_vente_packet = new javax.swing.JLabel();
        quantité_packet = new javax.swing.JSpinner();
        packet = new javax.swing.JCheckBox();
        jLabel_nombre_produit_packet = new javax.swing.JLabel();
        CodeBarrePacket = new javax.swing.JTextField();
        jCheckBoxCodeBarrePacket = new javax.swing.JCheckBox();
        jLabelprintcodebare = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JExperation_date = new javax.swing.JCheckBox();
        jLabel_jour_alert = new javax.swing.JLabel();
        jour_alerte = new javax.swing.JTextField();
        Date_per = new com.toedter.calendar.JDateChooser();
        AddCodeBarre = new javax.swing.JButton();
        AddFamille3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton_print = new javax.swing.JButton();
        jCheckBoxCodeBarre1 = new javax.swing.JCheckBox();
        prix_vente_detail = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        marge_detail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        ListeTaille = new javax.swing.JComboBox<>();
        Taille = new javax.swing.JCheckBox();
        AddTaille = new javax.swing.JButton();
        DelTaille = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        DelPointure = new javax.swing.JButton();
        AddPointure = new javax.swing.JButton();
        ListePointure = new javax.swing.JComboBox<>();
        Pointure = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        DelCouleur = new javax.swing.JButton();
        AddCouleur = new javax.swing.JButton();
        ListeCouleur = new javax.swing.JComboBox<>();
        Couleur = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ajouter Produit");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
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

        DelFamille.setBackground(new java.awt.Color(204, 204, 204));
        DelFamille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        DelFamille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelFamilleActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Famille");

        famille.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        famille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familleActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Marque");

        Marque.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Marque.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                MarqueItemStateChanged(evt);
            }
        });
        Marque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MarqueMouseClicked(evt);
            }
        });
        Marque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarqueActionPerformed(evt);
            }
        });

        AddMarque.setBackground(new java.awt.Color(204, 204, 204));
        AddMarque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        AddMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMarqueActionPerformed(evt);
            }
        });

        DelMarque.setBackground(new java.awt.Color(204, 204, 204));
        DelMarque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        DelMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelMarqueActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Localisation");

        code_bare.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        code_bare.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        code_bare.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                code_bareKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                code_bareKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Désignation");

        designation.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        designation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        designation.setPreferredSize(new java.awt.Dimension(7, 28));
        designation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                designationKeyPressed(evt);
            }
        });

        étagére.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        étagére.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        étagére.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                étagéreKeyPressed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Remarque");

        remarque.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        remarque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        remarque.setPreferredSize(new java.awt.Dimension(6, 27));
        remarque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                remarqueKeyPressed(evt);
            }
        });

        Enregistrer.setBackground(new java.awt.Color(204, 204, 204));
        Enregistrer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Enregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        Enregistrer.setText("Enregistrer");
        Enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnregistrerActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Quantité Stock");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Prix d'achat");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Prix vente spécial HT");

        priachat.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priachat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        priachat.setText("0");
        priachat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                priachatMouseExited(evt);
            }
        });
        priachat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priachatKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priachatKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                priachatKeyTyped(evt);
            }
        });

        quantite.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantite.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantite.setText("0");
        quantite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantiteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantiteKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Unité");

        Unite.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Unite.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UniteItemStateChanged(evt);
            }
        });
        Unite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UniteMouseClicked(evt);
            }
        });
        Unite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UniteActionPerformed(evt);
            }
        });

        addUnite.setBackground(new java.awt.Color(204, 204, 204));
        addUnite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        addUnite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUniteActionPerformed(evt);
            }
        });

        Del_unite.setBackground(new java.awt.Color(204, 204, 204));
        Del_unite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        Del_unite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Del_uniteActionPerformed(evt);
            }
        });

        Stock_alert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Stock_alert.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Stock_alert.setText("3");
        Stock_alert.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Stock_alertKeyPressed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Stock alert");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Prix v Gros HT");

        prix_vente_special.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prix_vente_special.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prix_vente_special.setText("0");
        prix_vente_special.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prix_vente_specialMouseExited(evt);
            }
        });
        prix_vente_special.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prix_vente_specialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prix_vente_specialKeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("TVA(%)");

        TVA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TVA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TVA.setText("19");
        TVA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TVAKeyPressed(evt);
            }
        });

        jPanelTitle.setBackground(new java.awt.Color(0, 102, 204));
        jPanelTitle.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nouveau Produit");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_image.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images(2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel_imageLayout = new javax.swing.GroupLayout(jPanel_image);
        jPanel_image.setLayout(jPanel_imageLayout);
        jPanel_imageLayout.setHorizontalGroup(
            jPanel_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
        );
        jPanel_imageLayout.setVerticalGroup(
            jPanel_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_image, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );

        ajouter.setBackground(new java.awt.Color(204, 204, 204));
        ajouter.setForeground(new java.awt.Color(255, 255, 255));
        ajouter.setText("ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        Annuler.setBackground(new java.awt.Color(204, 204, 204));
        Annuler.setForeground(new java.awt.Color(255, 255, 255));
        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        prix_vente_gros.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prix_vente_gros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prix_vente_gros.setText("0");
        prix_vente_gros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prix_vente_grosMouseExited(evt);
            }
        });
        prix_vente_gros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prix_vente_grosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prix_vente_grosKeyReleased(evt);
            }
        });

        marge_gros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marge_gros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marge_gros.setText("0");
        marge_gros.setToolTipText("marge prix gros");
        marge_gros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                marge_grosKeyReleased(evt);
            }
        });

        marge_special.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marge_special.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marge_special.setText("0");
        marge_special.setToolTipText("marge prix spécial");
        marge_special.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                marge_specialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                marge_specialKeyReleased(evt);
            }
        });

        jTableCodeBarre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableCodeBarre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Code Barre", "Supprimer"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableCodeBarre.setToolTipText("");
        jScrollPane1.setViewportView(jTableCodeBarre);
        if (jTableCodeBarre.getColumnModel().getColumnCount() > 0) {
            jTableCodeBarre.getColumnModel().getColumn(1).setPreferredWidth(60);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prix_v_packet_text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prix_v_packet_text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prix_v_packet_text.setText("0");
        prix_v_packet_text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prix_v_packet_textMouseExited(evt);
            }
        });
        prix_v_packet_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prix_v_packet_textKeyPressed(evt);
            }
        });
        jPanel1.add(prix_v_packet_text, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 190, 30));

        jLabel_vente_packet.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_vente_packet.setText("Prix Vente packet");
        jPanel1.add(jLabel_vente_packet, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 160, 30));

        quantité_packet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantité_packet.setModel(new javax.swing.SpinnerNumberModel(1, 0, null, 1));
        quantité_packet.setAlignmentX(7.5F);
        quantité_packet.setAlignmentY(7.5F);
        quantité_packet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantité_packetKeyPressed(evt);
            }
        });
        jPanel1.add(quantité_packet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 190, 30));

        packet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        packet.setText("Vente par packet ou promotion");
        packet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                packetActionPerformed(evt);
            }
        });
        jPanel1.add(packet, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 1, 340, 20));

        jLabel_nombre_produit_packet.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_nombre_produit_packet.setText("Nbre de produit");
        jPanel1.add(jLabel_nombre_produit_packet, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 30));

        CodeBarrePacket.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CodeBarrePacket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CodeBarrePacket.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CodeBarrePacketKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CodeBarrePacketKeyTyped(evt);
            }
        });
        jPanel1.add(CodeBarrePacket, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 190, 30));

        jCheckBoxCodeBarrePacket.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBoxCodeBarrePacket.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCheckBoxCodeBarrePacket.setText(" Code barre Packet");
        jCheckBoxCodeBarrePacket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCodeBarrePacketActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBoxCodeBarrePacket, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 160, 30));

        jLabelprintcodebare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-24.png"))); // NOI18N
        jLabelprintcodebare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelprintcodebareMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelprintcodebare, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 30, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        JExperation_date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JExperation_date.setText("Date d'expération");
        JExperation_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JExperation_dateActionPerformed(evt);
            }
        });

        jLabel_jour_alert.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel_jour_alert.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel_jour_alert.setText("Jours Alerte");

        jour_alerte.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jour_alerte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jour_alerte.setText("10");
        jour_alerte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jour_alerteKeyPressed(evt);
            }
        });

        Date_per.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Date_per.setPreferredSize(new java.awt.Dimension(96, 20));
        Date_per.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Date_perMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JExperation_date))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(Date_per, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel_jour_alert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jour_alerte, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(JExperation_date, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jour_alerte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel_jour_alert, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Date_per, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        AddCodeBarre.setBackground(new java.awt.Color(204, 204, 204));
        AddCodeBarre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        AddCodeBarre.setMnemonic('h');
        AddCodeBarre.setBorder(null);
        AddCodeBarre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCodeBarreActionPerformed(evt);
            }
        });

        AddFamille3.setBackground(new java.awt.Color(204, 204, 204));
        AddFamille3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        AddFamille3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFamille3ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Barcode.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setText("imprimer code barre");

        jButton_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-24.png"))); // NOI18N
        jButton_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_printActionPerformed(evt);
            }
        });

        jCheckBoxCodeBarre1.setBackground(new java.awt.Color(204, 204, 204));
        jCheckBoxCodeBarre1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jCheckBoxCodeBarre1.setText("Generer code barre");
        jCheckBoxCodeBarre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCodeBarre1ActionPerformed(evt);
            }
        });

        prix_vente_detail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        prix_vente_detail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prix_vente_detail.setText("0");
        prix_vente_detail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                prix_vente_detailMouseExited(evt);
            }
        });
        prix_vente_detail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prix_vente_detailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prix_vente_detailKeyReleased(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Prix vente detail HT");

        marge_detail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        marge_detail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        marge_detail.setText("0");
        marge_detail.setToolTipText("marge prix detail");
        marge_detail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                marge_detailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                marge_detailKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("%");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("%");

        jPanel2.setBackground(new java.awt.Color(204, 51, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3));

        ListeTaille.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        Taille.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Taille.setText("Taille");
        Taille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TailleActionPerformed(evt);
            }
        });

        AddTaille.setBackground(new java.awt.Color(204, 204, 204));
        AddTaille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        AddTaille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTailleActionPerformed(evt);
            }
        });

        DelTaille.setBackground(new java.awt.Color(204, 204, 204));
        DelTaille.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        DelTaille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelTailleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Taille)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(ListeTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(AddTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(DelTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(Taille, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ListeTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelTaille, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel2.add(jPanel4);

        jPanel5.setPreferredSize(new java.awt.Dimension(290, 96));

        DelPointure.setBackground(new java.awt.Color(204, 204, 204));
        DelPointure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        DelPointure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelPointureActionPerformed(evt);
            }
        });

        AddPointure.setBackground(new java.awt.Color(204, 204, 204));
        AddPointure.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        AddPointure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPointureActionPerformed(evt);
            }
        });

        ListePointure.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        Pointure.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Pointure.setText("Pointure");
        Pointure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PointureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pointure)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(ListePointure, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(AddPointure, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(DelPointure, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(Pointure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ListePointure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddPointure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelPointure, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel2.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(290, 96));

        DelCouleur.setBackground(new java.awt.Color(204, 204, 204));
        DelCouleur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-signe-moins-30.png"))); // NOI18N
        DelCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelCouleurActionPerformed(evt);
            }
        });

        AddCouleur.setBackground(new java.awt.Color(204, 204, 204));
        AddCouleur.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        AddCouleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCouleurActionPerformed(evt);
            }
        });

        ListeCouleur.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        Couleur.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Couleur.setText("Couleur");
        Couleur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CouleurActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Couleur)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(ListeCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(AddCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(DelCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Couleur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ListeCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DelCouleur, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0))
        );

        jPanel2.add(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(famille, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(AddFamille3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(DelFamille, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jCheckBoxCodeBarre1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(ajouter)
                                        .addGap(3, 3, 3)
                                        .addComponent(Annuler))))
                            .addComponent(Enregistrer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Marque, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priachat, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prix_vente_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prix_vente_special, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(marge_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jLabel26))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(marge_special, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel5)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel15))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(AddMarque, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, 0)
                                                    .addComponent(DelMarque, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(70, 70, 70)
                                                    .addComponent(jLabel14))))
                                        .addGap(7, 7, 7)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Unite, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Stock_alert, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TVA, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prix_vente_gros, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(étagére, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(Del_unite, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(marge_gros, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel4)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(AddCodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(code_bare, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel3)
                                        .addGap(2, 2, 2)
                                        .addComponent(jButton_print))))
                            .addComponent(remarque, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(691, 691, 691)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(famille, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AddFamille3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelFamille, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxCodeBarre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddCodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(code_bare, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3))
                            .addComponent(jButton_print)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Marque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(priachat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(prix_vente_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(prix_vente_special, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AddMarque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DelMarque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(marge_detail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(marge_special, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(1, 1, 1))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Unite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(Stock_alert, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(TVA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prix_vente_gros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(étagére, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addUnite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Del_unite, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(marge_gros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(remarque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel_image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ajouter)
                            .addComponent(Annuler))))
                .addGap(3, 3, 3)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void familleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_familleActionPerformed

    private void MarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarqueActionPerformed
    
    }//GEN-LAST:event_MarqueActionPerformed

    private void code_bareKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code_bareKeyPressed
      //  if(evt.getKeyCode()==KeyEvent.VK_ENTER){
      //  code_bare.setText("ddd");
     //   }
        tn.numOnly(code_bare);
    }//GEN-LAST:event_code_bareKeyPressed

    private void designationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_designationKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_designationKeyPressed

    private void étagéreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_étagéreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_étagéreKeyPressed

    private void remarqueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remarqueKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_remarqueKeyPressed

    private void AddMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMarqueActionPerformed
        NewMarque.getObj().setVisible(true);
    }//GEN-LAST:event_AddMarqueActionPerformed

    private void MarqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MarqueMouseClicked
      
    }//GEN-LAST:event_MarqueMouseClicked

    private void DelMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelMarqueActionPerformed
         try{ 
        if(Marque.getSelectedItem().equals("")){}
           else {
      //  int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  "+Marque.getSelectedItem().toString(),"",JOptionPane.YES_NO_OPTION);
        if(tools.ShowConfirmMessage("Voulez vous supprimer"+Marque.getSelectedItem().toString(), "", this)==MessageDialog.MessageType.OK){
     //  if(result==0){ 
            try {
               
                
                op.sup_Marque(Marque.getSelectedItem().toString());
                op.Charger_marque(Marque);
              
                
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
          tools.ShowGoodMessage(this, "Bien supprimer");
 //JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img);
 
 //sucategorie();
           }
       else {}
       
           }
         }
      catch(Exception e){}
    }//GEN-LAST:event_DelMarqueActionPerformed

    private void DelFamilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelFamilleActionPerformed
     
      try{
       if(famille.getSelectedItem().toString().equals("")){}
         else {
      //  int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  "+famille.getSelectedItem().toString(),"",JOptionPane.YES_NO_OPTION);   
      if(tools.ShowConfirmMessage("Voulez vous supprimer"+famille.getSelectedItem().toString(), "", this)==MessageDialog.MessageType.OK){
            try {  
                op2.sup_Famille(famille.getSelectedItem().toString());
                op2.Charger_famille(famille);
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
          
 //JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img);
 tools.ShowGoodMessage(this,"Bien supprimer");
           }else {}
        
        
         }
        
      }
      catch(Exception e){}
    
    }//GEN-LAST:event_DelFamilleActionPerformed

    private void EnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnregistrerActionPerformed
//System.out.println("t="+t);
        if(Taille.isSelected())     taille= ListeTaille.getSelectedItem().toString();
if(Pointure.isSelected())    pointure=   ListePointure.getSelectedItem().toString();
if(Couleur.isSelected())    couleur= ListeCouleur.getSelectedItem().toString();
         // date_per=Date_per.getModel().getValue();
         if(!JExperation_date.isSelected())date_per=null; else
          try{ 
               date_per = df1.format(Date_per.getDate());
          
          }catch(Exception e ){
             
                 e.printStackTrace();
              date_per=null;}
          
       code_bare_packet=CodeBarrePacket.getText();
    try{   prix_vente_packet=Double.parseDouble(prix_v_packet_text.getText());}catch(Exception e){prix_vente_packet=0;}
        nbre_produit_packet=(int)quantité_packet.getValue();
      if(packet.isSelected()) vente_packet=true; else vente_packet=false ;
    
   
      // CheckField cf=new CheckField();
       cf.CheckTextField(designation,40);
       cf.CheckTextField(quantite,20);
       cf.CheckTextField(priachat,20);
       cf.CheckTextField(prix_vente_special,20);
       cf.CheckTextFieldLength(étagére,40);
       cf.CheckTextFieldLength(Stock_alert,11);
       cf.CheckTextFieldLength(TVA,11);
       cf.CheckTextFieldLength(prix_vente_gros,20);
       cf.CheckTextFieldLength(remarque,222);
       cf.CheckTextFieldLength(jour_alerte,20);
       cf.CheckTextFieldLength(prix_v_packet_text,20);
       
       
               
       date_achat=new Date(System.currentTimeMillis());
    
       
       if(!designation.getText().equals("") && !quantite.getText().equals("")&& ! priachat.getText().equals("")&&!prix_vente_special.getText().equals("")) {
        
    try {
      reference=pop.GetNextReferenceProduit();
      id_p=pop.GetNextidProduit();
     if(action=='a'){
    
        pop.inserer_produit(famille.getSelectedItem().toString(), 
                Unite.getSelectedItem().toString(), Marque.getSelectedItem().toString(), chemin,reference, designation.getText().trim(), étagére.getText().trim(),
                0,remarque.getText(),Double.parseDouble(priachat.getText()),Double.parseDouble(prix_vente_detail.getText()),Double.parseDouble(prix_vente_gros.getText()),
                Double.parseDouble(prix_vente_special.getText()),Float.parseFloat(quantite.getText()),Integer.parseInt(Stock_alert.getText()),Integer.parseInt(jour_alerte.getText())
                ,
                Float.parseFloat(TVA.getText()), date_per,date_achat,taille,pointure,
                couleur,Aucceuil.userName,code_bare_packet,prix_vente_packet,nbre_produit_packet,vente_packet);
        tools.ShowGoodMessage(obj,"Bien ajouter");
      
        
     }
     else pop.modifier_Produit(famille.getSelectedItem().toString(), 
                Unite.getSelectedItem().toString(), Marque.getSelectedItem().toString(), chemin, reference, designation.getText().trim(), étagére.getText().trim(),
                prod.getId_f(),remarque.getText(),Double.parseDouble(priachat.getText()),Double.parseDouble(prix_vente_detail.getText()),Double.parseDouble(prix_vente_gros.getText()),
                Double.parseDouble(prix_vente_special.getText()),Float.parseFloat(quantite.getText()),Integer.parseInt(Stock_alert.getText()),Integer.parseInt(jour_alerte.getText()),
                
                Float.parseFloat(TVA.getText()),
               
                date_per,
               date_achat,
               taille,
                pointure,
                couleur,Aucceuil.userName,id_pro,code_bare_packet,prix_vente_packet,nbre_produit_packet,vente_packet);
     if(action=='a'){
        if(!listBareCode.isEmpty()){
            for(int i=0;i<listBareCode.size();i++)listBareCode.get(i).setId_produit(pop.GetNextidProduit()-1);
            op8.inserer_ListCodeBarre(listBareCode);}
     }    else {
         op8.sup_ListCode(id_pro);
         //listBareCode=op8.GetListCode(id_pro);
         if(!listBareCode.isEmpty()){
         
            for(int i=0;i<listBareCode.size();i++)listBareCode.get(i).setId_produit(id_pro);
            // System.out.println("Modifier liste des code"+listBareCode.size());
            op8.inserer_ListCodeBarre(listBareCode);
    
     }  
     
     }

      //  System.out.println("date per="+date_per+"size="+ListProduit2.size());
    //    ListProduit2= pop.getList_Produit("","","id_produit");
//if(t==1)   {    
    //GestionProduit.op.displayResult(ListProduit, jTable1);
if(t==0 )    { 
     ListProduit2=pop.getList_Produit2("","","id_produit");
        nbre_produit=ListProduit2.size();
    pp.displayResult(ListProduit2, jTable1, pp.getparamaitre_Produit2(),produit_total,nbre_produit);

 //System.out.println("t=====0");
                
                
}
//RechercherProduit.op.displayResult(ListProduit, jTable2);
//  RechercherProduit.op.displayResult(ListProduit,jTableProduit );
//}
else if (t==1){ 
    
 //System.out.println("t=====1");
  //  try{  id_p=pop.GetNextidProduit();}catch(Exception e){ id_p=0;}
    double pachat=0;
    double PVenteD=0;
      double PVenteG=0;
       double PVenteS=0;
      float quant=0;
    try{pachat= Double.parseDouble(priachat.getText());}catch(Exception e){pachat=0;}
     try{PVenteD= Double.parseDouble(prix_vente_detail.getText());}catch(Exception e){PVenteD=0;}
      try{PVenteG= Double.parseDouble(prix_vente_gros.getText());}catch(Exception e){PVenteG=0;}
       try{PVenteS= Double.parseDouble(prix_vente_special.getText());}catch(Exception e){PVenteG=0;}
        try{quant= Float.parseFloat(quantite.getText());}catch(Exception e){quant=0;}
vue.NewAchat.ListPr.add(new Produit (
                 designation.getText().trim(), 
                 pachat,PVenteD,
       PVenteG,PVenteS,
                quant,id_p,
       date1
                ));
ListProduitQuantité.add((float)1);
ListProduitQuantitéAcheteAvantMod.add((float)0);
 


//ListPrixAchat.add(Double.parseDouble(priachat.getText()));
 try {
        par=parop.get_Paramaitre();
        
    } catch (Exception ex) {
        Logger.getLogger(RechercherProduitAchat.class.getName()).log(Level.SEVERE, null, ex);
    }
 
 
 try {
        num_achat=op9.GetNextBonReception();
        
    } catch (Exception ex) {
        Logger.getLogger(RechercherProduitAchat.class.getName()).log(Level.SEVERE, null, ex);
    }
 

   PrintReportBonReception prb=   new PrintReportBonReception (par.getNom_magasin(),
           par.getAdresse_p(),
           par.getNum_tel_fax_fix_p(),
           par.getNum_tel1_p(),
          par.getNum_tel2_p(),num_achat,nom_four,designation.getText().trim(),
          pachat,0,0,0);
          ListPrintBon.add(prb);
          
          
  ListAchat.add(new Achat(num_achat,date1,nom_four,
          DateFormat.getTimeInstance().format(new java.util.Date()),
          user,designation.getText().trim(),
          pachat,1,m_verse,remise,PVenteD,PVenteG,PVenteS,idf,id_p));
      //   System.out.println("time achat="+DateFormat.getTimeInstance().format(new java.util.Date()));
         try{  total=0;
         for (int i=0 ;i< ListProduitQuantité.size();i++) 
                            total=total+(ListProduitQuantité.get(i)*ListAchat.get(i).getPrix_achat());
                        Total.setText( tnb.Afficher2Verguile(total));
                        TFtotal.setText(tnb.Afficher2Verguile(total-remise));
                         m_verse=Double.parseDouble(montant_verser.getText());
               
                 total_apres_remise=Double.parseDouble(TFtotal.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_dette=dette+(total_apres_remise-m_verse);
               //  System.out.println("nnndete="+nv_dette);
                 nvdette.setText(tnb.Afficher2Verguile(nv_dette));
                                 
                      
                       }  
           catch (Exception ex){
               Total.setText( 0+"");
           }
   op9.displayResult1(vue.NewAchat.ListPr, TableAchat, ListProduitQuantité);     
//pop.displayResult1(ListPr, TableAchat, ListProduitQuantité);
/*Aucceuil.ListP_périmé=pop.getList_Produit("Produit périmé", "", "");  
              int   nbre_produit_perime=Aucceuil.ListP_périmé.size();
                 produit_périmé.setText("Produit périmé="+nbre_produit_perime);
                 
                 ListP_Stock_alert=pop.getList_Produit("Répture", "", "quantité");
               int  nbre_produit_repture=Aucceuil.ListP_Stock_alert.size();
                 produit_repture.setText("Produit en répture="+nbre_produit_repture);*/
 //init();
// this.setVisible(false);
 //this.dispose();
   //obj=null;
//   obj2=null;

}
else {}
 /*Aucceuil.ListP_périmé=pop.getList_Produit("Produit périmé", "", "");  
 int nbre_produit_perime=Aucceuil.ListP_périmé.size();
 produit_périmé.setText("Produit périmé="+nbre_produit_perime);
                 
 ListP_Stock_alert=pop.getList_Produit("Répture", "", "quantité");
 int  nbre_produit_repture=Aucceuil.ListP_Stock_alert.size();
 produit_repture.setText("Produit en répture="+nbre_produit_repture);*/
 Aucceuil.refrechEtatProduit();
 init();
   obj=null;
   obj2=null;  
    this.dispose();
    } catch (Exception ex) {
        Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
    } 
      
   } 
      
    }//GEN-LAST:event_EnregistrerActionPerformed

    
  
    private void MarqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_MarqueItemStateChanged
        // TODO add your handling code here:
      //  op.Charger_marques(Marque,categorie);
  
    }//GEN-LAST:event_MarqueItemStateChanged

    private void jCheckBoxCodeBarrePacketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCodeBarrePacketActionPerformed

String barecodepacket="";
        if(jCheckBoxCodeBarrePacket.isSelected())  { 
    try { 
        try {
            do{
                barecodepacket=op8.GenerateRandomNumber2();
            }while(op8.CodeExist(barecode));
        } catch (Exception ex) {
            Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        CodeBarrePacket.setText(barecodepacket);
       
        

    } catch (Exception ex) {
        Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
      jLabelprintcodebare.setVisible(true);
        
}
else{ //jLabel_CodeBare.setIcon(null);  
jLabelprintcodebare.setVisible(false);
barecodepacket="";
 CodeBarrePacket.setText("");
   jLabelprintcodebare.setVisible(false);
}
   
    }//GEN-LAST:event_jCheckBoxCodeBarrePacketActionPerformed

    private void code_bareKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_code_bareKeyTyped
     keyTyped(evt);
     boolean exist=false;
        String code=code_bare.getText().trim();
    //  cf.CheckTextField(code_bare);
  //  System.out.println("code="+code);
     if(code.equals(" ")||code.length()<13){  //System.out.println("ccccccccc"+code.length());
     }
  //  bop.GenerateBarreCodeImage(barecode);
  //  code_bare.setText(barecode);
     else {
    try {
       //  if(bop.CodeExist(code)||listBareCode.contains(code)){
      //  System.out.println("codeffffff="+code);
            for (int i=0;i<listBareCode.size();i++)
                if(listBareCode.get(i).getCode().equals(code)){
                    tools.ShowFailMessage(this, "Ce code est déja utilisé");
                  //  JOptionPane.showMessageDialog(null, " Ce code est deja utilisé ","",JOptionPane.ERROR_MESSAGE,null);
                    exist=true;
                    code_bare.setText("");
                }
                    
             //      
          if(exist==false){
           
        //  System.out.println("nnnnnnnnn");
                    listBareCode.add(new CodeBarre(code,1));
               //   System.out.println("hhhhhhh");
                 code_bare.setText("");
              
                   pop.DisplayCodeBarre(listBareCode, jTableCodeBarre);
                  jTableCodeBarre.setRowSelectionInterval(0, 0);
          }
           
                                                 
       
    } catch (Exception ex) {
        Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
 //  System.out.println("liste bare code="+listBareCode.size());
   
   
  
      }
      
    
  //  tn.numOnly(code_bare);
    }//GEN-LAST:event_code_bareKeyTyped

    private void UniteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_UniteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_UniteItemStateChanged

    private void UniteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UniteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_UniteMouseClicked

    private void UniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UniteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UniteActionPerformed

    private void addUniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUniteActionPerformed
         NewUnite.getObj().setVisible(true);  
    }//GEN-LAST:event_addUniteActionPerformed

    private void Del_uniteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Del_uniteActionPerformed
        try{
       if(Unite.getSelectedItem().toString().equals("")){}
         else {
    //    int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  "+Unite.getSelectedItem().toString(),"",JOptionPane.YES_NO_OPTION);   
      if(tools.ShowConfirmMessage("Voulez vous supprimer"+Unite.getSelectedItem().toString(), "", this)==MessageDialog.MessageType.OK){
            try {
      op4.sup_unite(Unite.getSelectedItem().toString());
      op4.Charger_unite(Unite);
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
       tools.ShowGoodMessage(this, "Bien supprimer");
// JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img);
           }else {}
        
                 }
        
      }
      catch(Exception e){}
    
    }//GEN-LAST:event_Del_uniteActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        int iid=0;
        if (action=='a'){
        try{iid=pop.GetNextidProduit();}catch(Exception e){}
        }
        
        else iid=id_pro;
        try{
          
            JFileChooser file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            //filtrer les fichiers
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png");
            file.addChoosableFileFilter(filter);
            int res = file.showSaveDialog(null);
            //si l'utilisateur clique sur enregistrer dans Jfilechooser
            //BufferedImage image = ImageIO.read(fichier);
            if(res == JFileChooser.APPROVE_OPTION){
                File selFile = file.getSelectedFile();

                try {
                      File f=new File("images/image_produits");
                      if(!f.exists())
                      f.mkdir();
                    BufferedImage image = ImageIO.read(selFile.getAbsoluteFile());
                    
                     fichier = new File("images/image_produits/"+iid+".jpg");

                    String format ="JPG";
                    // BufferedImage image1;
                    ImageIO.write(image, format, fichier);
                    path = fichier.getAbsolutePath();
                  //  System.out.println("path="+path);
                } catch (IOException ex) {
                  ex.printStackTrace();
                }

                jLabel_image.setIcon(resize(path));
                // initComponents();
            }

        }
        catch(Exception e){
         //   JOptionPane.showMessageDialog(null, " Utiliser seulement le format JPEG ou PNG ","",JOptionPane.INFORMATION_MESSAGE,img2);
            tools.ShowFailMessage(this, "Utiliser seulement le format JPEG ou PNG");
        }
    }//GEN-LAST:event_ajouterActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
       jLabel_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images(2).png")));
       try{ fichier.delete();}catch(Exception e){}
        
    }//GEN-LAST:event_AnnulerActionPerformed

    private void AddTailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTailleActionPerformed
      new NewTaille().setVisible(true);
    }//GEN-LAST:event_AddTailleActionPerformed

    private void DelTailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelTailleActionPerformed
        try{ 
        if(ListeTaille.getSelectedItem().equals("")){}
           else {
      //  int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  "+ListeTaille.getSelectedItem().toString(),"",JOptionPane.YES_NO_OPTION);   
       if(tools.ShowConfirmMessage("Voulez vous supprimer"+ListeTaille.getSelectedItem().toString(), "", this)==MessageDialog.MessageType.OK){
            try {
               
                
                op5.sup_taille(ListeTaille.getSelectedItem().toString());
                op5.Charger_taille(ListeTaille);
              
                
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
          
// JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img);
 tools.ShowGoodMessage(this, "Bien supprimer");
 //sucategorie();
           }
       else {}
       
           }
         }
      catch(Exception e){}
    }//GEN-LAST:event_DelTailleActionPerformed

    private void AddPointureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPointureActionPerformed
       new NewPointure().setVisible(true);
    }//GEN-LAST:event_AddPointureActionPerformed

    private void DelPointureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelPointureActionPerformed
       try{ 
        if(ListePointure.getSelectedItem().equals("")){}
           else {
      //  int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  "+ListePointure.getSelectedItem().toString(),"",JOptionPane.YES_NO_OPTION);   
       if(tools.ShowConfirmMessage("Voulez vous supprimer"+ListePointure.getSelectedItem().toString(), "", this)==MessageDialog.MessageType.OK){
            try {
               
                
                op6.sup_pointure(ListePointure.getSelectedItem().toString());
                op6.Charger_pointure(ListePointure);
              
                
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
          
// JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img);
 tools.ShowGoodMessage(this, "Bien supprimer");
 //sucategorie();
           }
       else {}
       
           }
         }
      catch(Exception e){}
    }//GEN-LAST:event_DelPointureActionPerformed

    private void AddCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCouleurActionPerformed
        NewCouleur.getObj().setVisible(true);
    }//GEN-LAST:event_AddCouleurActionPerformed

    private void DelCouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelCouleurActionPerformed
         try{ 
        if(ListeCouleur.getSelectedItem().equals("")){}
           else {
       // int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  "+ListeCouleur.getSelectedItem().toString(),"",JOptionPane.YES_NO_OPTION);   
        if(tools.ShowConfirmMessage("Voulez vous supprimer"+ListeCouleur.getSelectedItem().toString(), "", this)==MessageDialog.MessageType.OK){
            try {
               
                
                op7.sup_Couleur(ListeCouleur.getSelectedItem().toString());
                op7.Charger_couleur(ListeCouleur);
              
                
            } catch (Exception ex) {
                Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
          
// JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img);
 tools.ShowGoodMessage(this, "Bien supprimer");
 //sucategorie();
           }
       else {}
       
           }
         }
      catch(Exception e){}
    }//GEN-LAST:event_DelCouleurActionPerformed

    private void AddCodeBarreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCodeBarreActionPerformed
      String code=code_bare.getText().trim();
    //  cf.CheckTextField(code_bare);
      if(code.equals("")){ }
  //  bop.GenerateBarreCodeImage(barecode);
  //  code_bare.setText(barecode);
      else {
    try {
       //  if(bop.CodeExist(code)||listBareCode.contains(code)){
        if(listBareCode.contains(code)){
      //  JOptionPane.showMessageDialog(null, " Ce code est deja utilisé ","",JOptionPane.ERROR_MESSAGE,null);  
      tools.ShowFailMessage(this, "Ce code est deja utilisé");
        }
        else  listBareCode.add(new CodeBarre(code,1));
    } catch (Exception ex) {
        Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
  //  System.out.println("liste bare code="+listBareCode.size());
    pop.DisplayCodeBarre(listBareCode, jTableCodeBarre);
     jTableCodeBarre.setRowSelectionInterval(0, 0);
    code_bare.setText("");
    code="";
      }
      code_bare.requestFocus();
    }//GEN-LAST:event_AddCodeBarreActionPerformed

    private void AddFamille3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFamille3ActionPerformed
        NewFamille.getObj().setVisible(true);
    }//GEN-LAST:event_AddFamille3ActionPerformed

    private void JExperation_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JExperation_dateActionPerformed

        if(JExperation_date.isSelected()==true){
         try{
         //   date_per=df.FormaterDate((Calendar)Date_per.getModel().getValue());
          date_per = df1.format(Date_per.getDate());
         //  date_per = (Date) Date_per.getDate();
     //  System.out.println("date dddd="+date_per);
      }catch(Exception e){date_per=null;}
        Date_per.setVisible(true);
 jour_alerte.setVisible(true);
 jLabel_jour_alert.setVisible(true);
        }
        else {
             date_per =null;
        Date_per.setVisible(false);
 jour_alerte.setVisible(false);
 jLabel_jour_alert.setVisible(false);
        }
    }//GEN-LAST:event_JExperation_dateActionPerformed

    private void packetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_packetActionPerformed

        if(packet.isSelected()){
 jLabel_nombre_produit_packet.setVisible(true);
quantité_packet.setVisible(true);
jLabel_vente_packet.setVisible(true);
prix_v_packet_text.setVisible(true);
jCheckBoxCodeBarrePacket.setVisible(true);
CodeBarrePacket.setVisible(true);
jLabelprintcodebare.setVisible(true);
       }
       else {
 jLabel_nombre_produit_packet.setVisible(false);
quantité_packet.setVisible(false);
jLabel_vente_packet.setVisible(false);
prix_v_packet_text.setVisible(false);
jCheckBoxCodeBarrePacket.setVisible(false);
CodeBarrePacket.setVisible(false);
jLabelprintcodebare.setVisible(false);
       }
    }//GEN-LAST:event_packetActionPerformed

    private void TailleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TailleActionPerformed
        if(Taille.isSelected()){ListeTaille.setVisible(true);
        op5.Charger_taille(ListeTaille);
        AddTaille.setVisible(true);
DelTaille.setVisible(true);
}
        else{ListeTaille.setVisible(false);
           AddTaille.setVisible(false);
          DelTaille.setVisible(false);
}
    }//GEN-LAST:event_TailleActionPerformed

    private void PointureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PointureActionPerformed
     if(Pointure.isSelected()){
         AddPointure.setVisible(true);
         op6.Charger_pointure(ListePointure);
DelPointure.setVisible(true);

ListePointure.setVisible(true);
}
        else{
ListePointure.setVisible(false);
AddPointure.setVisible(false);
DelPointure.setVisible(false);

}
    }//GEN-LAST:event_PointureActionPerformed

    private void CouleurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CouleurActionPerformed
       if(Couleur.isSelected()){
         ListeCouleur.setVisible(true);
         op7.Charger_couleur(ListeCouleur);
 AddCouleur.setVisible(true);
DelCouleur.setVisible(true);
}
        else{
ListeCouleur.setVisible(false);
 AddCouleur.setVisible(false);
DelCouleur.setVisible(false);

}
       
    }//GEN-LAST:event_CouleurActionPerformed

    private void quantiteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantiteKeyTyped
      //  tn.numOnly(quantite);
    }//GEN-LAST:event_quantiteKeyTyped

    private void quantiteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantiteKeyPressed
      tn.numOnly(quantite);
    }//GEN-LAST:event_quantiteKeyPressed

    private void priachatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priachatKeyPressed
       tn.numOnly(priachat);
    }//GEN-LAST:event_priachatKeyPressed

    private void prix_vente_specialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prix_vente_specialKeyPressed
        tn.numOnly(prix_vente_special);  
    }//GEN-LAST:event_prix_vente_specialKeyPressed

    private void quantité_packetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantité_packetKeyPressed
         tn.numOnly(quantité_packet);  
    }//GEN-LAST:event_quantité_packetKeyPressed

    private void Stock_alertKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Stock_alertKeyPressed
        tn.numOnly(Stock_alert); 
    }//GEN-LAST:event_Stock_alertKeyPressed

    private void TVAKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TVAKeyPressed
          tn.numOnly(TVA); 
    }//GEN-LAST:event_TVAKeyPressed

    private void prix_vente_grosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prix_vente_grosKeyPressed
        tn.numOnly(prix_vente_gros); 
    }//GEN-LAST:event_prix_vente_grosKeyPressed

    private void jour_alerteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jour_alerteKeyPressed
         tn.numOnly(jour_alerte); 
    }//GEN-LAST:event_jour_alerteKeyPressed

    private void prix_v_packet_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prix_v_packet_textKeyPressed
         tn.numOnly(prix_v_packet_text); 
    }//GEN-LAST:event_prix_v_packet_textKeyPressed

    private void marge_specialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marge_specialKeyPressed
       /*   tn.numOnly(marge_detail);
          try{double prix_achat=Double.parseDouble(priachat.getText());
          System.out.println("prix achat="+prix_achat);
          double marge=Double.parseDouble(marge_detail.getText());
          System.out.println("marge="+marge);
          double prix_vente=prix_achat+((marge*prix_achat)/100);
          System.out.println("prix vente="+prix_vente);
              prix_vente_detail.setText(prix_vente+"");
          }catch(Exception e){}*/
    }//GEN-LAST:event_marge_specialKeyPressed

    private void marge_specialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marge_specialKeyReleased
     tn.numOnly(marge_special);
          try{double prix_achat=Double.parseDouble(priachat.getText());
         // System.out.println("prix achat="+prix_achat);
          double marge=Double.parseDouble(marge_special.getText());
        //  System.out.println("marge="+marge);
          double prix_vente=prix_achat+((marge*prix_achat)/100);
          //System.out.println("prix vente="+prix_vente);
             // prix_vente_detail.setText(prix_vente+"");
            //   prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
      prix_vente_special.setText(formatter.format(prix_vente).replace(',', '.')+"");
      
     // prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
     // prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
          }catch(Exception e){}
    }//GEN-LAST:event_marge_specialKeyReleased

    private void priachatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priachatKeyReleased
       tn.numOnly(marge_special);
          try{
               double m_detail=0;
               double m_gro=0;
               double m_special=0;
              double prix_achat=Double.parseDouble(priachat.getText());
       //   System.out.println("prix achat="+prix_achat);
         try{    m_detail=Double.parseDouble(marge_detail.getText());}catch(Exception e){m_detail=0;}
         try{    m_gro=Double.parseDouble(marge_gros.getText());}catch(Exception e){m_gro=0;}
         try{    m_special=Double.parseDouble(marge_special.getText());}catch(Exception e){m_special=0;}
        //  System.out.println("marge="+marge);
          double prix_v_detail=prix_achat+((m_detail*prix_achat)/100);
          double prix_v_gro=prix_achat+((m_gro*prix_achat)/100);
          double prix_v_special=prix_achat+((m_special*prix_achat)/100);
         // System.out.println("prix vente="+prix_vente);
          //  prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
          //   prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
          //    prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
          prix_vente_detail.setText(formatter.format(prix_v_detail).replace(',', '.')+"");
          prix_vente_gros.setText(formatter.format(prix_v_gro).replace(',', '.')+"");
          prix_vente_special.setText(formatter.format(prix_v_special).replace(',', '.')+"");
          
               // prix_vente_special.setText(prix_vente_special+"");
               //   prix_vente_gros.setText(prix_vente_gro+"");
                
                
    
      
     
          }catch(Exception e){}
    }//GEN-LAST:event_priachatKeyReleased

    private void prix_vente_grosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prix_vente_grosKeyReleased
     tn.numOnly(prix_vente_gros);
          try{double prix_achat=Double.parseDouble(priachat.getText());
         // System.out.println("prix achat="+prix_achat);
          double prix_vente=Double.parseDouble(prix_vente_gros.getText());
        //  System.out.println("marge="+marge);
        double marge=0;
      if(prix_achat>0)     marge=(100*(prix_vente-prix_achat))/prix_achat;
          //System.out.println("prix vente="+prix_vente);
             // prix_vente_detail.setText(prix_vente+"");
            //   prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
      marge_gros.setText(tn.Precision(marge)+"");
      
     // prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
     // prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
          }catch(Exception e){}
    }//GEN-LAST:event_prix_vente_grosKeyReleased

    private void marge_grosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marge_grosKeyReleased
       tn.numOnly(marge_gros);
          try{double prix_achat=Double.parseDouble(priachat.getText());
         // System.out.println("prix achat="+prix_achat);
          double marge=Double.parseDouble(marge_gros.getText());
        //  System.out.println("marge="+marge);
          double prix_vente=prix_achat+((marge*prix_achat)/100);
          //System.out.println("prix vente="+prix_vente);
             // prix_vente_detail.setText(prix_vente+"");
            //   prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
      prix_vente_gros.setText(formatter.format(prix_vente).replace(',', '.')+"");
      
     // prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
     // prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
          }catch(Exception e){}
    }//GEN-LAST:event_marge_grosKeyReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jButton_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_printActionPerformed
    //reportsengine.ReportsManager.getInstance().showReport("BORDEREAU DESCRIPTIF DES VIREMENTS.jasper", new Hashtable(), "Code Barre", listBareCode );
    //  System.out.println("selected row="+jTableCodeBarre.getSelectedRow());
    
    int index=jTableCodeBarre.getSelectedRow();
    if(listBareCode.isEmpty())tools.ShowFailMessage(this, "Ajouter un code barre");
        //JOptionPane.showMessageDialog(null, " Ajouter un code barre  ","",JOptionPane.INFORMATION_MESSAGE,img4);
   else if(index<0){
       tools.ShowFailMessage(this, "Sélectionner un code barre");
      // JOptionPane.showMessageDialog(null, " Sélectionner un code barre  ","",JOptionPane.INFORMATION_MESSAGE,img4);
   }
   else if(designation.getText().equals(""))tools.ShowFailMessage(this, "Entrer une désignation");
    else if(!designation.getText().equals("") &&!prix_vente_special.getText().equals("")&&!prix_vente_gros.getText().equals("")&&!listBareCode.isEmpty()) 
      ImpressionCodBarre.getObj(new Produit(designation.getText(),Double.parseDouble(prix_vente_detail.getText()),Double.parseDouble(prix_vente_gros.getText()),
              Double.parseDouble(prix_vente_special.getText()),
              
      Double.parseDouble(prix_v_packet_text.getText()),      listBareCode.get(jTableCodeBarre.getSelectedRow()).getCode(),date_per  )).setVisible(true);
    else {
  //  CheckField cf=new CheckField();
      cf.CheckTextField(designation,40);
       cf.CheckTextField(quantite,20);
       cf.CheckTextField(priachat,20);
       cf.CheckTextField(prix_vente_special,20);
        cf.CheckTextField(prix_vente_detail,20);
        cf.CheckTextField(prix_vente_gros,20);
    
    
    }
    }//GEN-LAST:event_jButton_printActionPerformed

    private void Date_perMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Date_perMouseClicked
     //   System.out.println("mous cliqed date");
    }//GEN-LAST:event_Date_perMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       this.dispose();
       obj=null;
       obj2=null;
     //   System.out.println("windows closing");
    }//GEN-LAST:event_formWindowClosing

    private void priachatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priachatKeyTyped
  /*      prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
     prix_vente_detail.setText(formatter.format(prix_v_detaile).replace(',', '.')+"");
      
      prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
     prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
         */
    }//GEN-LAST:event_priachatKeyTyped

    private void priachatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_priachatMouseExited
 try{ prix_achat=Double.parseDouble(priachat.getText());}catch(Exception e){prix_achat=0;}
  priachat.setText(formatter.format(prix_achat).replace(',', '.')+"");
    }//GEN-LAST:event_priachatMouseExited

    private void prix_vente_specialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prix_vente_specialMouseExited
     try{ prix_v_special=Double.parseDouble(prix_vente_special.getText());}catch(Exception e){prix_v_special=0;}
  prix_vente_special.setText(formatter.format(prix_v_special).replace(',', '.')+"");
  
  
    }//GEN-LAST:event_prix_vente_specialMouseExited

    private void prix_vente_grosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prix_vente_grosMouseExited
  try{prix_v_gros=Double.parseDouble(prix_vente_gros.getText());}catch(Exception e){prix_v_gros=0;}
  prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
 
    }//GEN-LAST:event_prix_vente_grosMouseExited

    private void prix_v_packet_textMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prix_v_packet_textMouseExited
     try{  prix_vente_packet=Double.parseDouble(prix_v_packet_text.getText());}catch(Exception e){prix_vente_packet=0;}
  prix_v_packet_text.setText(formatter.format(prix_vente_packet).replace(',', '.')+"");
    }//GEN-LAST:event_prix_v_packet_textMouseExited

    private void CodeBarrePacketKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeBarrePacketKeyPressed
          tn.numOnly(CodeBarrePacket);
    }//GEN-LAST:event_CodeBarrePacketKeyPressed

    private void jCheckBoxCodeBarre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCodeBarre1ActionPerformed
               if(jCheckBoxCodeBarre1.isSelected())  { 
    try { 
        try {
            do{
                barecode=op8.GenerateRandomNumber2();
            }while(op8.CodeExist(barecode));
        } catch (Exception ex) {
            Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  bop.GenerateBarreCodeImage(barecode);
        code_bare.setText(barecode);
        listBareCode.add(new CodeBarre(barecode,1));
        // listBareCode.contains(barecode);
        //  System.out.println("liste bare code="+listBareCode.size());
        pop.DisplayCodeBarre(listBareCode, jTableCodeBarre);
        jTableCodeBarre.setRowSelectionInterval(0, 0);
        //    jLabel1.setIcon(new ImageIcon("src/images/out.jpg"));
//           jLabel_CodeBare.setIcon(resize("src/images/out.jpg"));
// jLabel_CodeBare.setIcon(("src/images/out.jpg"));
//  L_produit.add(new Produit(designation.getText().trim(),barecode,200));
// reportsengine.ReportsManager.getInstance().showReport("barecode.jasper", new Hashtable(), "Etiquette code bare", L_produit);


    } catch (Exception ex) {
        Logger.getLogger(AjouterProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
}
else{ //jLabel_CodeBare.setIcon(null);  

barecode="";
 code_bare.setText("");
}
    code_bare.requestFocus();
    }//GEN-LAST:event_jCheckBoxCodeBarre1ActionPerformed

    private void jLabelprintcodebareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelprintcodebareMouseClicked
     
        if(CodeBarrePacket.getText().equals("")){
          tools.ShowFailMessage(this, "Ajouter un code barre ");
         //   JOptionPane.showMessageDialog(null, " Ajouter un code barre  ","",JOptionPane.INFORMATION_MESSAGE,img4);
        }
    else if(!designation.getText().equals("")&&!prix_vente_detail.getText().equals("") &&!prix_vente_special.getText().equals("")&&!prix_vente_gros.getText().equals("")&&!prix_v_packet_text.getText().equals("")) 
      ImpressionCodBarre.getObj(new Produit(designation.getText(),Double.parseDouble(prix_vente_detail.getText()),
              Double.parseDouble(prix_vente_gros.getText()),Double.parseDouble(prix_vente_detail.getText()),  Double.parseDouble(prix_v_packet_text.getText()),
          CodeBarrePacket.getText()  ,date_per  )).setVisible(true);
    else {
   // CheckField cf=new CheckField();
      cf.CheckTextField(designation,40);
       cf.CheckTextField(prix_v_packet_text,20);
     
       cf.CheckTextField(prix_vente_special,20);
        cf.CheckTextField(prix_vente_detail,20);
        cf.CheckTextField(prix_vente_gros,20);
    
    
    }
    }//GEN-LAST:event_jLabelprintcodebareMouseClicked

    private void CodeBarrePacketKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeBarrePacketKeyTyped
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
  s=s.replace('ç', '9');
  
    if(evt.getKeyChar()==KeyEvent.VK_ENTER){CodeBarrePacket.setText(s); 
   //  System.out.println("fin de String");
    s="";
    }
 if(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE) { CodeBarrePacket.setText("");s="";}
      
    
    }//GEN-LAST:event_CodeBarrePacketKeyTyped

    private void prix_vente_detailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prix_vente_detailMouseExited
    // double prix_achat=0;
        try{   prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());}catch(Exception e){prix_v_detaile=0;}
               
  prix_vente_detail.setText(formatter.format(prix_v_detaile).replace(',', '.')+"");
  /* 
    double m_d=0;
      
      try{  prix_achat=Double.parseDouble(priachat.getText());
      if(prix_achat>0)    m_d=(100*(prix_v_detaile-prix_achat))/prix_achat;
        marge_detail.setText(m_d+"");
      }catch(Exception e){ m_d=0;marge_detail.setText(0+""); 
      }*/
    }//GEN-LAST:event_prix_vente_detailMouseExited

    private void prix_vente_detailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prix_vente_detailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_prix_vente_detailKeyPressed

    private void marge_detailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marge_detailKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_marge_detailKeyPressed

    private void marge_detailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_marge_detailKeyReleased
        tn.numOnly(marge_detail);
          try{double prix_achat=Double.parseDouble(priachat.getText());
         // System.out.println("prix achat="+prix_achat);
          double marge=Double.parseDouble(marge_detail.getText());
        //  System.out.println("marge="+marge);
          double prix_vente=prix_achat+((marge*prix_achat)/100);
          //System.out.println("prix vente="+prix_vente);
             // prix_vente_detail.setText(prix_vente+"");
            //   prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
      prix_vente_detail.setText(formatter.format(prix_vente).replace(',', '.')+"");
      
     // prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
     // prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
          }catch(Exception e){}
    }//GEN-LAST:event_marge_detailKeyReleased

    private void prix_vente_detailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prix_vente_detailKeyReleased
       tn.numOnly(prix_vente_detail);
          try{double prix_achat=Double.parseDouble(priachat.getText());
         // System.out.println("prix achat="+prix_achat);
          double prix_vente=Double.parseDouble(prix_vente_detail.getText());
        //  System.out.println("marge="+marge);
        double marge=0;
      if(prix_achat>0)     marge=(100*(prix_vente-prix_achat))/prix_achat;
          //System.out.println("prix vente="+prix_vente);
             // prix_vente_detail.setText(prix_vente+"");
            //   prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
      marge_detail.setText(tn.Precision(marge)+"");
      
     // prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
     // prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
          }catch(Exception e){}
    }//GEN-LAST:event_prix_vente_detailKeyReleased

    private void prix_vente_specialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prix_vente_specialKeyReleased
         tn.numOnly(prix_vente_special);
          try{double prix_achat=Double.parseDouble(priachat.getText());
         // System.out.println("prix achat="+prix_achat);
          double prix_vente=Double.parseDouble(prix_vente_special.getText());
        //  System.out.println("marge="+marge);
        double marge=0;
      if(prix_achat>0)     marge=(100*(prix_vente-prix_achat))/prix_achat;
          //System.out.println("prix vente="+prix_vente);
             // prix_vente_detail.setText(prix_vente+"");
            //   prix_v_detaile=Double.parseDouble(prix_vente_detail.getText());
      marge_special.setText(tn.Precision(marge)+"");
      
     // prix_v_gros=Double.parseDouble(prix_vente_gros.getText());
     // prix_vente_gros.setText(formatter.format(prix_v_gros).replace(',', '.')+"");
          }catch(Exception e){}
    }//GEN-LAST:event_prix_vente_specialKeyReleased
public void init(){
    path="";
    fichier=null;
   indexMarque=0;
   indexFamille=0;
   indexUnite=0;
   indexTaille=0;
   indexPointure=0;
   indexCouleur=0;
    t=0;
//num_serie.setText("");
designation.setText("");
étagére.setText("");
code_bare.setText("");
remarque.setText("");
quantite.setText("0");
priachat.setText("0");
prix_vente_special.setText("0");
prix_vente_detail.setText("0");
prix_v_packet_text.setText("0");
Date_per.setToolTipText("");
Date_per.setVisible(false);
jLabel_jour_alert.setVisible(false);
jour_alerte.setVisible(false);
JExperation_date.setSelected(false);

prix_vente_gros.setText("0");
prix_v_packet_text.setText("0");

packet.setSelected(false);
jLabel_nombre_produit_packet.setVisible(false);
 quantité_packet.setVisible(false);
 quantité_packet.setValue(1);
 
 jLabel_vente_packet.setVisible(false);
 prix_v_packet_text.setVisible(false);
listBareCode.clear();
this.setIconImage(tools.getImageIcone().getImage());
   jLabel_image.setIcon(img3);
  indexPointure=0;
         op2.Charger_famille(famille);
   
         op3.Charger_marque(Marque);
         op4.Charger_unite(Unite);
         
         op5.Charger_taille(ListeTaille);
         Taille.setSelected(false);
         ListeTaille.setVisible(false);
         AddTaille.setVisible(false);
         DelTaille.setVisible(false);
         
         op6.Charger_pointure(ListePointure);
          Pointure.setSelected(false);
          ListePointure.setVisible(false);
         AddPointure.setVisible(false);
          DelPointure.setVisible(false);
          
         op7.Charger_couleur(ListeCouleur);
          Couleur.setSelected(false);
           ListeCouleur.setVisible(false);
         AddCouleur.setVisible(false);
          DelCouleur.setVisible(false);
         
         pop.DisplayCodeBarre(listBareCode, jTableCodeBarre);

}
public ImageIcon resize(String imgPath)
  {
    ImageIcon path = new ImageIcon(imgPath);
    Image img = path.getImage();
    Image newImg = img.getScaledInstance(198, 166, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
  }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCodeBarre;
    private javax.swing.JButton AddCouleur;
    private javax.swing.JButton AddFamille3;
    private javax.swing.JButton AddMarque;
    private javax.swing.JButton AddPointure;
    private javax.swing.JButton AddTaille;
    private javax.swing.JButton Annuler;
    private javax.swing.JTextField CodeBarrePacket;
    private javax.swing.JCheckBox Couleur;
    private com.toedter.calendar.JDateChooser Date_per;
    private javax.swing.JButton DelCouleur;
    private javax.swing.JButton DelFamille;
    private javax.swing.JButton DelMarque;
    private javax.swing.JButton DelPointure;
    private javax.swing.JButton DelTaille;
    private javax.swing.JButton Del_unite;
    private javax.swing.JButton Enregistrer;
    private javax.swing.JCheckBox JExperation_date;
    public static javax.swing.JComboBox<String> ListeCouleur;
    public static javax.swing.JComboBox<String> ListePointure;
    public static javax.swing.JComboBox<String> ListeTaille;
    public static javax.swing.JComboBox Marque;
    private javax.swing.JCheckBox Pointure;
    private javax.swing.JTextField Stock_alert;
    private javax.swing.JTextField TVA;
    private javax.swing.JCheckBox Taille;
    public static javax.swing.JComboBox Unite;
    private javax.swing.JButton addUnite;
    private javax.swing.JButton ajouter;
    private javax.swing.JTextField code_bare;
    private javax.swing.JTextField designation;
    public static javax.swing.JComboBox famille;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton_print;
    private javax.swing.JCheckBox jCheckBoxCodeBarre1;
    private javax.swing.JCheckBox jCheckBoxCodeBarrePacket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel_image;
    private javax.swing.JLabel jLabel_jour_alert;
    private javax.swing.JLabel jLabel_nombre_produit_packet;
    private javax.swing.JLabel jLabel_vente_packet;
    private javax.swing.JLabel jLabelprintcodebare;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPanel jPanel_image;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCodeBarre;
    private javax.swing.JTextField jour_alerte;
    private javax.swing.JTextField marge_detail;
    private javax.swing.JTextField marge_gros;
    private javax.swing.JTextField marge_special;
    private javax.swing.JCheckBox packet;
    private javax.swing.JTextField priachat;
    private javax.swing.JTextField prix_v_packet_text;
    private javax.swing.JTextField prix_vente_detail;
    private javax.swing.JTextField prix_vente_gros;
    private javax.swing.JTextField prix_vente_special;
    private javax.swing.JTextField quantite;
    private javax.swing.JSpinner quantité_packet;
    private javax.swing.JTextField remarque;
    private javax.swing.JTextField étagére;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
         s=s+ke.getKeyChar();
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
  
    if(ke.getKeyChar()==KeyEvent.VK_ENTER){code_bare.setText(s); 
   //  System.out.println("fin de String");
    s="";
    }
 if(ke.getKeyChar()==KeyEvent.VK_BACK_SPACE) { code_bare.setText("");s="";}
   //System.out.println("keyPressed: "+ke.getKeyCode()+ke.getKeyChar()+ke.getExtendedKeyCode()+ke.getKeyLocation() +ke.isActionKey()+ke.isConsumed()+ke.getID());
    //if(ke.getKeyChar()==KeyEvent.VK_ENTER) System.out.println("fin1");
    // if(ke.getKeyChar()==KeyEvent.VK_END) System.out.println("fin2");
     // if(ke.getKeyChar()==KeyEvent.VK_SPACE) System.out.println("fin3");
      // if(ke.getKeyChar()==KeyEvent.VK_STOP) System.out.println("fin4");
       //      if(ke.getKeyLocation()==' ') System.out.println("fin5");
   // System.out.println("keyTyped"+s);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed: "+e.getKeyCode()+", "+e.getKeyChar()+", "+e.getExtendedKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased: "+e.getKeyCode()+", "+e.getKeyChar()+", "+e.getExtendedKeyCode());
    }
    
    
    /*public static void main(String arg[]){
      AjouterProduit.getObj(2).setVisible(true);
    }*/
}
