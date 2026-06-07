/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.CheckField;
import controler.FontStyle;
import controler.Mouvement_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import model.Mouvement;
import model.Produit;




/**
 *
 * @author Rais
 */
public class MouvementProduit extends javax.swing.JFrame implements KeyListener {
  //  ImageIcon   img = new ImageIcon("images/gs.png");
     //ImageIcon   img1 = new ImageIcon("images/accept.png");
 //    ImageIcon   img2 = new ImageIcon("images/warning.png");
    // Message me = new Message(this, true,"/images/stop.png","Veuiller sélectionner les dates!","",Color.red);
     //Message me2 = new Message(this, true,"/images/stop.png","Veuiller insérer un produit!","",Color.red);
   //  Message mok = new Message(this, true,"/images/good128.png","Bien Valider","",new Color(14,191,0) );
 //  NumberFormat formatter = new DecimalFormat("#0.00");  
 TextNumber tnb= TextNumber.getObj();  
 
Mouvement_op mop= Mouvement_op.getInstance();
public static Produit_op pop= Produit_op.getInstance();
FontStyle fs= FontStyle.getInstance();
Tools tools=Tools.getInstance();
String s="";
 float qte_phisique=0;
Date date1,date2;
 public static MouvementProduit obj=null;
 int type_index = 0;
 CheckField cf=CheckField.getInstance();
// public static Date date_inv=null;
//String  temp_inv=  DateFormat.getTimeInstance().format(new java.util.Date());
// public ArrayList<Fournisseur> ListFournisseur;
public  ArrayList<Mouvement> listAchat=new ArrayList<>();
public  ArrayList<Mouvement> listVente=new ArrayList<>();
public  ArrayList<Mouvement> listTous=new ArrayList<>();
//float t_e=0;
//float t_s=0;
public static Produit p=null;
//public static List<Float> ListQtePhisique=new ArrayList<>();

//public static ArrayList<PrintReportBonReception> ListPrintBon =new ArrayList<>(); 
//public List ListProduitQuantité;
//public static List<Float> ListProduitQuantité = new ArrayList<>();

//public static List<Inventaire> ListInventaire = new ArrayList<>();

NumberFormat formatter = new DecimalFormat("#0.00"); 
String utilisateur;

// static public Produit p;

 //Fournisseur four=null;

public static int num_inventaire=1;
 // double nouveau_dette=0;
 
 
 //BoutonColor bc= BoutonColor.getInstance();

 
 int row,column;

 //float quantite_achete=0;
 
 //float qte_phisique=0;
 
 public static String user;
 
  
            
 //  MouseEvent me;
    /**
     * Creates new form 
     */
  
  public static MouvementProduit getObj(String user){
     
      if(obj==null){
            try { 
       obj=new MouvementProduit(user);
            } catch (Exception ex) {
                Logger.getLogger(MouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
    private MouvementProduit(String User) throws Exception {
    try {
   utilisateur=user;
  initComponents();
  CodeBarre.requestFocus();
    this.setIconImage(tools.getImageIcone().getImage());
  init();
 // temp_achat=  new Date(System.currentTimeMillis())+"";
  

  user=User;
  
   Toolkit toolkit = Toolkit.getDefaultToolkit();
 //  JButton btn_pick = (JButton) date.getComponent(1);
  // btn_pick.setBackground(new Color(66, 147, 223));
  // Image image = toolkit.getImage("images/event24.png"); //Земање на сликата за мк знаме
 //  ImageIcon icon = new ImageIcon(image); //Правење на икона
 //  btn_pick.setIcon(icon); //Поставување на иконата
//    date.setBorder(BorderFactory.createLineBorder(Color.RED));
// date.setDate(Calendar.getInstance().getTime());
 //  date.setFormats(new SimpleDateFormat("yyyy-MM-dd"));
   
  TableMouvement.setRowHeight(30);
  JTableHeader tableHeader = TableMouvement.getTableHeader();
  TableMouvement.getTableHeader().setOpaque(false);
 // tableHeader.setBackground(Color.BLACK);
  tableHeader.setForeground(Color.black);
     
  Font headerFont = new Font("Verdana", Font.PLAIN, 14);
  tableHeader.setFont(headerFont);
         
  //p=paop.get_Paramaitre();
      
 TableMouvement.addMouseListener(new MouseAdapter() {
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
        TableMouvement = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        Rechercher = new javax.swing.JButton();
        CodeBarre = new javax.swing.JTextField();
        select_product = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        designation = new javax.swing.JLabel();
        Imprimer_BTN = new javax.swing.JButton();
        total_entrée = new javax.swing.JLabel();
        total_sortie = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mouvement d'un produit");
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

        TableMouvement.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TableMouvement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Type", "Tiers", "Qte entrée", "Prix achat", "Valeur Entrée", "Qte sortie", "Prix vente", "Valeur sortie"
            }
        ));
        TableMouvement.setColumnSelectionAllowed(true);
        TableMouvement.setGridColor(new java.awt.Color(255, 51, 51));
        TableMouvement.getTableHeader().setReorderingAllowed(false);
        TableMouvement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableMouvementMousePressed(evt);
            }
        });
        TableMouvement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TableMouvementKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TableMouvement);
        TableMouvement.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(258, 64));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mouvement d'un produit");
        jLabel4.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jXDatePicker1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("du");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("au");

        jXDatePicker2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Rechercher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com(3).png"))); // NOI18N
        Rechercher.setText("Filtrer");
        Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercherActionPerformed(evt);
            }
        });

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

        select_product.setBackground(new java.awt.Color(204, 204, 204));
        select_product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        select_product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32update.png"))); // NOI18N
        select_product.setText("Insérer");
        select_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_productActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Type");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "Achat", "Vente" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Produit:");

        designation.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        designation.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(select_product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(select_product, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(designation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXDatePicker2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CodeBarre.getAccessibleContext().setAccessibleName("");

        Imprimer_BTN.setBackground(new java.awt.Color(204, 204, 204));
        Imprimer_BTN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Imprimer_BTN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-30.png"))); // NOI18N
        Imprimer_BTN.setText("imprimer");
        Imprimer_BTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprimer_BTNActionPerformed(evt);
            }
        });

        total_entrée.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        total_entrée.setText("Total Qte Entrée=0");

        total_sortie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        total_sortie.setText("Total Qte Sortie=0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(total_entrée, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(total_sortie, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Imprimer_BTN)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Imprimer_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(total_sortie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(total_entrée, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_productActionPerformed
    // new RechercherProduit(1,"").setVisible(true);
        RechercherProduitMouvement.getObj(Aucceuil.userName).setVisible(true);
        this.setVisible(false);
     //  Sup.setVisible(true);
   //System.out.println( "value ="+jTable1.getModel().getValueAt(0, 1));
    }//GEN-LAST:event_select_productActionPerformed

    private void TableMouvementKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableMouvementKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
     //System.out.println("key enter");
   }
    }//GEN-LAST:event_TableMouvementKeyPressed

    private void Imprimer_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprimer_BTNActionPerformed
  
   imprimer();
 // System.out.println("nom fournisseur=="+nom_four);
  // init();
   
   this.dispose();
    }//GEN-LAST:event_Imprimer_BTNActionPerformed

    private void CodeBarreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodeBarreKeyReleased
Produit pp=null;
       keyTyped(evt);
       CodeBarre.setText(s);
       tnb.numOnly(CodeBarre);
              
       if(s.length()>=13) {        
                
           try { 
               pp = pop.get_Produit(CodeBarre.getText().trim());
           } catch (Exception ex) {
               Logger.getLogger(MouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
           }
                //  System.out.println("contite produit="+pp);
                    if(pp!=null){    
                  p=  pp;
                  //   ListInventaire.add(new Inventaire(num_inventaire, date_inv,"",pp.getId_produit(),pp.getDésignation(),pp.getQuantité(),0,pp.getQuantité(),pp.getPrix_achat(), temp_inv,utilisateur));
                   
                        try {
                            designation.setText(p.getDésignation() );
                        } catch (Exception ex) {
                            Logger.getLogger(MouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
                        }
    
                     }
                      try {
             //  iop.displayResult(ListInventaire, TableInventaire);
           } catch (Exception ex) {
               Logger.getLogger(MouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
           }
                    
                    
                    }                                             
                                     
    }//GEN-LAST:event_CodeBarreKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     //  System.out.println("windows closing");
     
     obj=null;
       //init();
       this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       //  if(evt.getKeyChar()==KeyEvent.VK_F1){Valider();}
    }//GEN-LAST:event_formKeyPressed

    private void TableMouvementMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouvementMousePressed

    
    }//GEN-LAST:event_TableMouvementMousePressed

    private void RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercherActionPerformed
        try{cf.CheckDate(jXDatePicker1);
            cf.CheckDate(jXDatePicker2);
            date1=new java.sql.Date(jXDatePicker1.getDate().getTime());
            date2=new java.sql.Date(jXDatePicker2.getDate().getTime());
            
            listAchat.clear();
            listVente.clear();
            listTous.clear();
             //  System.out.println("date="+date1+date2);
              //    System.out.println("id_pr="+p.getId_produit());
        }catch(Exception e){date1=null;date2=null;}
        if((date1==null)||(date2==null))tools.ShowFailMessage(obj, "Veuiller sélectionner les dates!");
        else if(p==null)tools.ShowFailMessage(obj, "Veuiller insérer un produit!");
        else {
            try {
switch(type_index){
    case 0:listAchat=mop.GetListIMouvementAchat(date1, date2, p.getId_produit(), "Achat");
    listVente=mop.GetListIMouvementVente(date1, date2, p.getId_produit(), "Vente");
    listTous.addAll(listAchat);  listTous.addAll(listVente); mop.displayResult(listTous, TableMouvement);break;
    case 1:listAchat=mop.GetListIMouvementAchat(date1, date2, p.getId_produit(), "Achat");mop.displayResult(listAchat, TableMouvement);break;
    default:listVente=mop.GetListIMouvementVente(date1, date2,p.getId_produit() ,"Vente");mop.displayResult(listVente, TableMouvement);break;

}
         
                //  System.out.println("List size="+list.size());
             
              total_entrée.setText("Total Qte Entrée="+mop.GetTotalEntréé(listAchat));
              total_sortie.setText("Total Qte Sortie="+mop.GetTotalSortie(listVente));

            } catch (Exception ex) {
                Logger.getLogger(ListeInventaire.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_RechercherActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      type_index=jComboBox1.getSelectedIndex();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CodeBarre;
    private javax.swing.JButton Imprimer_BTN;
    private javax.swing.JButton Rechercher;
    public static javax.swing.JTable TableMouvement;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JLabel designation;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JButton select_product;
    private javax.swing.JLabel total_entrée;
    private javax.swing.JLabel total_sortie;
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

p=null;
//ListInventaire.clear();

designation.setText( "");
//ListPrintBon.clear()
  
   } 
   
   void imprimer(){
        try {
            TableMouvement.print();
            } catch (PrinterException ex) {
            Logger.getLogger(MouvementProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
}
