/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.FontStyle;
import controler.Inventaire_op;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import model.Inventaire;
import model.Paramaitre;
import model.PrintReportBonReception;
import model.Produit;
import static vue.ListeInventaire.ListInv;
import static vue.ListeInventaire.jTableInvList;




/**
 *
 * @author Rais
 */
public class NewInventaire extends javax.swing.JFrame implements KeyListener {
  //  ImageIcon   img = new ImageIcon("images/gs.png");
    // ImageIcon   img1 = new ImageIcon("images/accept.png");
 //    ImageIcon   img2 = new ImageIcon("images/warning.png");
   // Message me = new Message(this, true,"/images/stop.png","Veuiller sélectionner une date!","",Color.red);
  //   Message mok = new Message(this, true,"/images/good128.png","Bien Valider","",new Color(14,191,0) );
 //  NumberFormat formatter = new DecimalFormat("#0.00");  
 TextNumber tnb= TextNumber.getObj();  
 
Inventaire_op iop= Inventaire_op.getInstance();
public static Produit_op pop= Produit_op.getInstance();
FontStyle fs= FontStyle.getInstance();
String s="";
 float qte_phisique=0;
 //int q=0;
 public static NewInventaire obj=null;
 // String temp_achat = "";
 public static Date date_inv=null;
String  temp_inv=  DateFormat.getTimeInstance().format(new java.util.Date());
// public ArrayList<Fournisseur> ListFournisseur;
public static ArrayList<Produit> ListPr=new ArrayList<>();
//public static List<Float> ListQtePhisique=new ArrayList<>();

public static ArrayList<PrintReportBonReception> ListPrintBon =new ArrayList<>(); 
//public List ListProduitQuantité;
//public static List<Float> ListProduitQuantité = new ArrayList<>();

public static List<Inventaire> ListInventaire = new ArrayList<>();

NumberFormat formatter = new DecimalFormat("#0.00"); 
String utilisateur;
Tools tools=Tools.getInstance();
// static public Produit p;

 //Fournisseur four=null;

public static int num_inventaire=1;
 // double nouveau_dette=0;
 
 
 //BoutonColor bc= BoutonColor.getInstance();

 
 int row,column;

 //float quantite_achete=0;
 public static   double montant_t_ttc=0;
 public static double montant_p_ttc=0;
 public static  double montant_e_ttc=0;
 
  
 Paramaitres_op parop= Paramaitres_op.getInstance();
 Paramaitre p; 
 //float qte_phisique=0;
 float ecart=0;
 public static String user;
 
  
            
 //  MouseEvent me;
    /**
     * Creates new form 
     */
  
  public static NewInventaire getObj(String user){
      ListPrintBon.clear();
      if(obj==null){
            try { 
       obj=new NewInventaire(user);
            } catch (Exception ex) {
                Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
    private NewInventaire(String User) throws Exception {
    try {
   utilisateur=User;
  initComponents();
  CodeBarre.requestFocus();
    this.setIconImage(tools.getImageIcone().getImage());
  init();
 // temp_achat=  new Date(System.currentTimeMillis())+"";
  num_inventaire=iop.GetNextNumInv();
  num_inv.setText(num_inventaire+"");
  //user=User;
  
   Toolkit toolkit = Toolkit.getDefaultToolkit();
   JButton btn_pick = (JButton) date.getComponent(1);
  // btn_pick.setBackground(new Color(66, 147, 223));
   Image image = toolkit.getImage("images/event24.png"); //Земање на сликата за мк знаме
   ImageIcon icon = new ImageIcon(image); //Правење на икона
   btn_pick.setIcon(icon); //Поставување на иконата
//    date.setBorder(BorderFactory.createLineBorder(Color.RED));
 date.setDate(Calendar.getInstance().getTime());
   date.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
   
  TableInventaire.setRowHeight(30);
  JTableHeader tableHeader = TableInventaire.getTableHeader();
  TableInventaire.getTableHeader().setOpaque(false);
 // tableHeader.setBackground(Color.BLACK);
  tableHeader.setForeground(Color.black);
     
  Font headerFont = new Font("Verdana", Font.PLAIN, 14);
  tableHeader.setFont(headerFont);
         
  //p=paop.get_Paramaitre();
      
 TableInventaire.addMouseListener(new MouseAdapter() {
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
  //  bc.ColorerBouton(select_product,  new Color(1, 101, 225));
   //  bc.ColorerBouton(Sup, Color.red);
 //   bc.ColorerBouton(Nouveau, new Color(41,134,10));
    // CodeBarre.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
    }
    /*
 public NewInventaire(String fournisseur,double dett,ArrayList<Achat> listAch,ArrayList<Float> listQuantite,ArrayList<Produit> listP,double t) throws Exception {  
    try {
        
  
   initComponents();
   CodeBarre.requestFocus();
   this.setIconImage(img.getImage());
   TableInventaire.setRowHeight(30);
   JTableHeader tableHeader = TableInventaire.getTableHeader();
      //tableHeader.setBackground(Color.GREEN);
     tableHeader.setForeground(Color.black);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
    //  bc.ColorerBouton(select_product,  new Color(1, 101, 225));
   //  bc.ColorerBouton(Sup, Color.red);
  //  bc.ColorerBouton(Nouveau, new Color(41,134,10));
    
   //   datee.setDateFormatString("yyyy-MM-dd");
     //  datee.setDate(java.sql.Date.valueOf(listAch.get(0).getDate_achat()));
    
   
     //  fs.SetFont1(DA,85);
      //    montant_verser.setText("0");
        //  m_verse=listAch.get(0).getSomme_versé();
      //  CurrentUser=user1;
      
    user=Aucceuil.Currentuser;
   // num_bon_reception=listAch.get(0).getNum_bon_réception();
  //  ListProduitQuantité=listQuantite;
     
  //  ListAchat=listAch;
     ListPr=listP; 
     Paramaitres_op paop=new Paramaitres_op();
     p=paop.get_Paramaitre();
     for(int i=0;i<ListPr.size();i++){
     
            
 ListPrintBon.add(new PrintReportBonReception (p.getNom_magasin(),p.getAdresse_p(),p.getNum_tel_fax_fix_p(),p.getNum_tel1_p(),p.getNum_tel2_p(),num_bon_reception,
         fournisseur,
         ListPr.get(i).getDésignation(),ListPr.get(i).getPrix_achat(),ListPr.get(i).getQuantité(),0,0));   
     }
    
    //  for(int i=0;i<ListAchat.size();i++)total=total+(ListAchat.get(i).getPrix_achat()*ListProduitQuantité.get(i));
  
   
    M_T_TTC.setText(tnb.Afficher2Verguile(remise));
  //  montant_verser.setText(list.get(0).getSomme_versé()+"");
   
    M_TTC.setText(tnb.Afficher2Verguile(total-remise));
    M_E_TTC.setText(tnb.Afficher2Verguile(m_verse));
  
     //  total_TTc=aop.getTotal_TTC(ListAchat);
     // total_ht=aop.getTotal_HT(ListAchat);
  //total_HT1.setText(formatter.format(total_ht)+"");
 // total_ttc1.setText(formatter.format(total_TTc)+"");
 //article1.setText(ListAchat.size()+"");
 //unité1.setText(aop.getNombreUnité(ListAchat)+"");
// System.out.println("remise="+list.get(0).getRemise());
   aop.displayResult1(ListPr, TableInventaire, ListProduitQuantité);
    
  // try{ num_bon_reception=Integer.parseInt(num_bon.getText());}catch (Exception e ){}
      date_achat=java.time.LocalDate.now()+"";
     // System.out.println("dddddd="+date_vente);
   //datee.setText(date_achat);
   

   
 TableInventaire.addMouseListener(new MouseAdapter() {
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
     // bc.ColorerBouton(select_product,  new Color(1, 101, 225));
     //  CodeBarre.setBorder (BorderFactory.createLineBorder (Color.gray, 1));
    }
*/
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
        TableInventaire = new javax.swing.JTable();
        Imprimer_BTN = new javax.swing.JButton();
        Sup = new javax.swing.JButton();
        select_product = new javax.swing.JButton();
        CodeBarre = new javax.swing.JTextField();
        Valider_Achat_BTN = new javax.swing.JButton();
        TousProduit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        num_inv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        date = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        lib = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        M_T_TTC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        M_P_TTC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        M_E_TTC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventaire");
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

        TableInventaire.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableInventaire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Désignation", "Qte théorique", "Qte physique", "Ecart Qte", "P.achat TTC"
            }
        ));
        TableInventaire.setColumnSelectionAllowed(true);
        TableInventaire.setGridColor(new java.awt.Color(255, 51, 51));
        TableInventaire.getTableHeader().setReorderingAllowed(false);
        TableInventaire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableInventaireMousePressed(evt);
            }
        });
        TableInventaire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableInventaireKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableInventaire);
        TableInventaire.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        Imprimer_BTN.setBackground(new java.awt.Color(204, 204, 204));
        Imprimer_BTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Imprimer_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-30.png"))); // NOI18N
        Imprimer_BTN.setText("Valider et imprimer");
        Imprimer_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimer_BTNActionPerformed(evt);
            }
        });

        Sup.setBackground(new java.awt.Color(204, 204, 204));
        Sup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Sup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32del.png"))); // NOI18N
        Sup.setText("Supprimer ");
        Sup.setSelected(true);
        Sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupActionPerformed(evt);
            }
        });

        select_product.setBackground(new java.awt.Color(204, 204, 204));
        select_product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        select_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32update.png"))); // NOI18N
        select_product.setText("Insérer");
        select_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_productActionPerformed(evt);
            }
        });

        CodeBarre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
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

        TousProduit.setBackground(new java.awt.Color(204, 204, 204));
        TousProduit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TousProduit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32update.png"))); // NOI18N
        TousProduit.setText("Inserér tous les produits");
        TousProduit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TousProduitActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(181, 64));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inventaire");
        jLabel4.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("N° d'invantaire");

        num_inv.setEditable(false);
        num_inv.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        num_inv.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        num_inv.setText("1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Date inventaire");

        date.setForeground(new java.awt.Color(204, 0, 0));
        date.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Libelle");

        lib.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Montant théorique TTC");

        M_T_TTC.setEditable(false);
        M_T_TTC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        M_T_TTC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        M_T_TTC.setText("0");
        M_T_TTC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                M_T_TTCMouseExited(evt);
            }
        });
        M_T_TTC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                M_T_TTCKeyReleased(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(153, 255, 153));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Montant physique TTC");

        M_P_TTC.setEditable(false);
        M_P_TTC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        M_P_TTC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        M_P_TTC.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Montant écart TTC");

        M_E_TTC.setEditable(false);
        M_E_TTC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        M_E_TTC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        M_E_TTC.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(M_P_TTC, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(M_E_TTC, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(M_T_TTC, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(34, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(M_P_TTC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(M_E_TTC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(M_T_TTC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(142, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(num_inv, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lib, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(select_product)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TousProduit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Sup))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Imprimer_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Valider_Achat_BTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lib, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num_inv, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(select_product, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TousProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sup, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Valider_Achat_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Imprimer_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 72, Short.MAX_VALUE))))
        );

        CodeBarre.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_productActionPerformed
    // new RechercherProduit(1,"").setVisible(true);
       new RechercherProduitInventaire(Aucceuil.userName).setVisible(true);
            this.setVisible(false);
     //  Sup.setVisible(true);
   //System.out.println( "value ="+jTable1.getModel().getValueAt(0, 1));
    }//GEN-LAST:event_select_productActionPerformed

    private void SupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupActionPerformed
    
     //   if(!f.getNom_prenom_fournisseur().isEmpty())dette_label.setText(f.getDette()+"");
        int position=TableInventaire.getSelectedRow(); 
         if(row==-1||position==-1)
             tools.ShowFailMessage(this, "Veuiller sélectionner une ligne");
             //JOptionPane.showMessageDialog(null, " Veuiller sélectionner une ligne  ","",JOptionPane.INFORMATION_MESSAGE,img2);
         else {ListPr.remove(position);
    
           ListInventaire.remove(position);
         if(!ListPrintBon.isEmpty())  ListPrintBon.remove(position);
     montant_t_ttc=0;
     montant_p_ttc =0;      
       for (int i=0 ;i< ListPr.size();i++) {
  montant_t_ttc=montant_t_ttc+(ListPr.get(i).getQuantité()*ListPr.get(i).getPrix_achat());
  montant_p_ttc=montant_p_ttc+(  ListInventaire.get(i).getQte_p()*ListPr.get(i).getPrix_achat());  
         }
         montant_e_ttc=montant_t_ttc-montant_p_ttc;
                        try {
                            M_T_TTC.setText( tnb.Afficher2Verguile(montant_t_ttc)+" DA");
                            M_P_TTC.setText( tnb.Afficher2Verguile(montant_p_ttc)+" DA");
                            M_E_TTC.setText( tnb.Afficher2Verguile(montant_e_ttc)+" DA");
                            
                        } catch (Exception ex) {
                            Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
                        }
                         
            try {
              
                iop.displayResult(ListInventaire, TableInventaire);
            } catch (Exception ex) {
                Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            
        
                     
         }
          CodeBarre.requestFocus();
    }//GEN-LAST:event_SupActionPerformed

    private void Valider_Achat_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Valider_Achat_BTNActionPerformed
 Valider();
 init();
 this.dispose();
    }//GEN-LAST:event_Valider_Achat_BTNActionPerformed

    private void TableInventaireKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableInventaireKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     //System.out.println("key enter");
   }
    }//GEN-LAST:event_TableInventaireKeyPressed

    private void Imprimer_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimer_BTNActionPerformed
   Valider(); imprimer();
 // System.out.println("nom fournisseur=="+nom_four);
   init();
   
   this.dispose();
    }//GEN-LAST:event_Imprimer_BTNActionPerformed

    private void CodeBarreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeBarreKeyReleased
Produit pp=null;
       keyTyped(evt);
       CodeBarre.setText(s);
       tnb.numOnly(CodeBarre);
              
                            if(s.length()>=13) {
                                 boolean product_in_list=false;
                                 int pos=0;
             
               
                
           try { 
               pp = pop.get_Produit(CodeBarre.getText().trim());
           } catch (Exception ex) {
               Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
           }
                //  System.out.println("contite produit="+pp);
                    if(pp!=null){
                   
                     for(int i=0;i<ListPr.size();i++){ if(ListPr.get(i).getId_produit()==pp.getId_produit())
                     {product_in_list=true;pos=i;break;}
                         }
                     if(product_in_list==false){
                        
                     ListPr.add(pp);
                     ListInventaire.add(new Inventaire(num_inventaire, date_inv,"",pp.getId_produit(),pp.getDésignation(),pp.getQuantité(),0,pp.getQuantité(),pp.getPrix_achat(), temp_inv,utilisateur));
                       montant_t_ttc=0;
     montant_p_ttc =0;      
       for (int i=0 ;i< ListPr.size();i++) {
  montant_t_ttc=montant_t_ttc+(ListPr.get(i).getQuantité()*ListPr.get(i).getPrix_achat());
  montant_p_ttc=montant_p_ttc+(  ListInventaire.get(i).getQte_p()*ListPr.get(i).getPrix_achat());  
         }
         montant_e_ttc=montant_t_ttc-montant_p_ttc;
                        try {
                            M_T_TTC.setText( tnb.Afficher2Verguile(montant_t_ttc)+" DA");
                            M_P_TTC.setText( tnb.Afficher2Verguile(montant_p_ttc)+" DA");
                            M_E_TTC.setText( tnb.Afficher2Verguile(montant_e_ttc)+" DA");
                            
                        } catch (Exception ex) {
                            Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
                        }
    /*    PrintReportBonReception prb=   new PrintReportBonReception (
                p.getNom_magasin(),
                p.getAdresse_p(),
                p.getNum_tel_fax_fix_p(),
                p.getNum_tel1_p(),*/
       /*   p.getNum_tel2_p(),num_bon_reception,nom_four,ListPr.get(pos).getDésignation(),
          ListPr.get(pos).getPrix_achat(),0, ListPr.get(pos).getPrix_vente_detail(),ListPr.get(pos).getPrix_vente_gros());
          ListPrintBon.add(prb);*/
                       
                      
                     // ListPrixAchat.add(pp.getPrix_achat());
                    //  ListPrixVenteDetail.add(pp.getPrix_vente_detail());
                    //  ListPrixVenteGros.add(pp.getPrix_vente_gros());
                     }
                    }

           try {
               iop.displayResult(ListInventaire, TableInventaire);
           } catch (Exception ex) {
               Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
           }
                
                                         }

                                     
    }//GEN-LAST:event_CodeBarreKeyReleased

    private void TousProduitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TousProduitActionPerformed
   try{ date_inv= new java.sql.Date(date.getDate().getTime());}catch(Exception e){date_inv=null;}
     System.out.println("date_inv="+date_inv);
   if(date_inv==null){tools.ShowFailMessage(obj, "Veuiller sélectionner une date!");
  date.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red, 3));
   }
   else {
   ListInventaire.clear();
   ListPrintBon.clear();  
   ListPr.clear();
  
        try { montant_t_ttc=0;
     montant_p_ttc =0; 
            ListPr=pop.getList_Produit("","","désignation");
         //   System.out.println("Listpr size="+ListPr.size());
            for(int i=0;i<ListPr.size();i++) {
  ListInventaire.add(new Inventaire(num_inventaire, date_inv,"",ListPr.get(i).getId_produit(),ListPr.get(i).getDésignation(),ListPr.get(i).getQuantité(),0,ListPr.get(i).getQuantité(),ListPr.get(i).getPrix_achat(),temp_inv,utilisateur));
  montant_t_ttc=montant_t_ttc+(ListPr.get(i).getQuantité()*ListPr.get(i).getPrix_achat());
  montant_p_ttc=montant_p_ttc+(  ListInventaire.get(i).getQte_p()*ListPr.get(i).getPrix_achat());  
         }
         montant_e_ttc=montant_t_ttc-montant_p_ttc;
                        try {
                            M_T_TTC.setText( tnb.Afficher2Verguile(montant_t_ttc)+" DA");
                            M_P_TTC.setText( tnb.Afficher2Verguile(montant_p_ttc)+" DA");
                            M_E_TTC.setText( tnb.Afficher2Verguile(montant_e_ttc)+" DA");
                            
                        } catch (Exception ex) {
                            Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
                        }
        iop.displayResult(ListInventaire, TableInventaire);
        } catch (Exception ex) {
            Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    }//GEN-LAST:event_TousProduitActionPerformed

    private void Valider_Achat_BTNKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Valider_Achat_BTNKeyPressed
       if(evt.getKeyChar()==KeyEvent.VK_F1){Valider();}
    }//GEN-LAST:event_Valider_Achat_BTNKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     //  System.out.println("windows closing");
     
     obj=null;
       //init();
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         if(evt.getKeyChar()==KeyEvent.VK_F1){Valider();}
    }//GEN-LAST:event_formKeyPressed

    private void TableInventaireMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableInventaireMousePressed
  // if(c1) {
  
       TableInventaire.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingCanceled(ChangeEvent e) {
                   //     System.out.println(jTable1.getModel().getValueAt(0, 1)+"editingCanceled");
                    }

                    @Override
                    public void editingStopped(ChangeEvent e) {
                   try{ 
                   qte_phisique=    Float.parseFloat(TableInventaire.getModel().getValueAt(row, 3).toString());
                  //   ListQtePhisique.set(row, Float.parseFloat(TableInventaire.getModel().getValueAt(row, 3).toString())); 
                     if(qte_phisique<0){
                         tools.ShowFailMessage(NewInventaire.this, "La quantité doit être >=0 ");
                     //    JOptionPane.showMessageDialog(null, " La quantité doit être >=0  ","erreur",JOptionPane.INFORMATION_MESSAGE,img2);
                     // ListQtePhisique.set(row,(float) 0);
                       M_P_TTC.setText( tnb.Afficher2Verguile(0)+" DA");
                      qte_phisique=0;
                      ListInventaire.get(row).setQte_p(qte_phisique);
                     }
                     
                   }
                      catch (Exception ex){
             //  qte_phisique=0;
          //   ListQtePhisique.set(row, qte_phisique);
             ListInventaire.get(row).setQte_p(qte_phisique);
              ecart=ListInventaire.get(row).getQte_t()-ListInventaire.get(row).getQte_p();
              ListInventaire.get(row).setEquart_qte(ecart);
              TableInventaire.getModel().setValueAt(qte_phisique, row, 3);
              TableInventaire.getModel().setValueAt(ecart, row, 4);
                       try {
                           M_P_TTC.setText( tnb.Afficher2Verguile(0)+" DA");
                           // M_P_TTC.setText("0");
                           
                           //   M_T_TTC.setText("0");
                       } catch (Exception ex1) {
                           Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex1);
                       }
               
           }
                ListInventaire.get(row).setQte_p(qte_phisique);
                ecart=ListInventaire.get(row).getQte_t()-ListInventaire.get(row).getQte_p();
              // TableInventaire.getModel().setValueAt(qte_phisique, row, 3);
               TableInventaire.getModel().setValueAt(ecart, row, 4);
             //ListInventaire.get(row).setQte_p(qte_phisique);
         
      //  ListPrintBon.get(row).setQuantité(quantite_achete);
          montant_t_ttc=0;
          montant_p_ttc=0;
         //   System.out.println("ListInventaire size="+ListInventaire.size());
         for (int i=0 ;i< ListInventaire.size();i++) {
         
  montant_t_ttc=montant_t_ttc+(ListPr.get(i).getQuantité()*ListPr.get(i).getPrix_achat());
  montant_p_ttc=montant_p_ttc+(  ListInventaire.get(i).getQte_p()*ListPr.get(i).getPrix_achat());  
   // System.out.println("ListInventaire.get(i).getQte_p()="+ListInventaire.get(i).getQte_p());
         }
         montant_e_ttc=montant_t_ttc-montant_p_ttc;
                        try {
                            M_T_TTC.setText( tnb.Afficher2Verguile(montant_t_ttc)+" DA");
                            M_P_TTC.setText( tnb.Afficher2Verguile(montant_p_ttc)+" DA");
                            M_E_TTC.setText( tnb.Afficher2Verguile(montant_e_ttc)+" DA");
                            
                        } catch (Exception ex) {
                            Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                      
    
                     
                      
                   
              
             
      
              
                  
                   
  
  
  
                    }
                });
 //  }

    }//GEN-LAST:event_TableInventaireMousePressed

    private void M_T_TTCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_M_T_TTCMouseExited
     //   remise=Double.parseDouble(M_T_TTC.getText());
      //  M_T_TTC.setText(formatter.format(remise).replace(',', '.')+"");
    }//GEN-LAST:event_M_T_TTCMouseExited

    private void M_T_TTCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_M_T_TTCKeyReleased
    
    }//GEN-LAST:event_M_T_TTCKeyReleased

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
 date_inv= new java.sql.Date(date.getDate().getTime());
 
      date.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red, 0));
    }//GEN-LAST:event_dateActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodeBarre;
    private javax.swing.JButton Imprimer_BTN;
    public static javax.swing.JTextField M_E_TTC;
    public static javax.swing.JTextField M_P_TTC;
    public static javax.swing.JTextField M_T_TTC;
    private javax.swing.JButton Sup;
    public static javax.swing.JTable TableInventaire;
    private javax.swing.JButton TousProduit;
    private javax.swing.JButton Valider_Achat_BTN;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lib;
    private javax.swing.JTextField num_inv;
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
    // System.out.println("entrer condition");
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
obj=null;
montant_t_ttc=0;
montant_p_ttc=0;
ListPr.clear();
ListInventaire.clear();
M_T_TTC.setText( "0.00 DA");
M_P_TTC.setText( "0.00 DA");
M_E_TTC.setText( "0.00 DA");
//ListPrintBon.clear()
  
   } 
   public void Valider(){

   date_inv=new java.sql.Date(date.getDate().getTime());
       
       String temp_inv=DateFormat.getTimeInstance().format(new java.util.Date());
  
        if(ListInventaire.isEmpty())
            tools.ShowFailMessage(this, "Veuiller inserer des produits");
           // JOptionPane.showMessageDialog(null, " Veuiller inserer des produits  ","Erreur",JOptionPane.INFORMATION_MESSAGE,img2);
      
        else {
             
        for(int i=0;i<ListInventaire.size();i++){
            try {
              ListInventaire.get(i).setDate(date_inv);
                ListInventaire.get(i).setLibelle(lib.getText());
                 ListInventaire.get(i).setUser(utilisateur);
                ListInventaire.get(i).setTemp_inv( temp_inv);
                 iop.InsererInventaire(ListInventaire.get(i));
            
                  } catch (Exception ex) {
                  System.out.println("Exception insertion");
                  }
            
             
                }
  
        tools.ShowGoodMessage(obj,"Bien Valider");
       
         try {   
     
      ListInv=  iop.getList_Inventaire3();
       iop.displayResult1(ListInv, jTableInvList);
    } catch (Exception ex) {
        Logger.getLogger(ListeInventaire.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
         
  
   }
   void imprimer(){
        try {
            TableInventaire.print();
            /*
            
            if(!ListInventaire.isEmpty()){
            
            if(row!=-1) {reportsengine.ReportsManager.getInstance().showReport("bon_reception.jasper", new Hashtable(), "Bon d'achat",ListPrintBon);
            
            
            }
            }
            CodeBarre.requestFocus();
        */    } catch (PrinterException ex) {
            Logger.getLogger(NewInventaire.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
}
