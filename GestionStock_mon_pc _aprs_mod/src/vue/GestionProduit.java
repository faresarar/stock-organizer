/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
 
import controler.BoutonColor;
import controler.Famille_op;
import controler.CodeBarre_op;

import controler.Marque_op;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.Produit_paramaitre_op;
import controler.TableMouseListener;
import controler.Tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produit;
import java.util.Hashtable;
import javax.swing.table.JTableHeader;
import model.Paramaitre;
import model.Produit_paramaitre;
import raven.javaswingdev.MessageDialog;
import sweet_alert.Message;
import static vue.Aucceuil.ExistSerialNumber;
import static vue.Aucceuil.ListP_Stock_alert;
//import static vue.Aucceuil.SerialNumber;
//import static vue.Aucceuil.sr;
import static vue.Aucceuil.utilisateur;
//import static vue.Aucceuil.enc;
/**
 *
 * @author Rais
 */
public class GestionProduit extends javax.swing.JFrame implements KeyListener {
String param1="Code_barre",param2,param3,param4,param5;
// ImageIcon   img = new ImageIcon("images/gs.png");
// ImageIcon   imgok = new ImageIcon("images/accept.png");
 //ImageIcon   img2 = new ImageIcon("images/warning.png");
int type=1;
Tools tool=Tools.getInstance();
 public Produit_op op=Produit_op.getInstance();
static public CodeBarre_op cop= CodeBarre_op.getInstance();
//static Categorie_produit_op cpo=new Categorie_produit_op();
static Famille_op cpco= Famille_op.getInstance();
static Marque_op mop=Marque_op.getInstance();
Paramaitres_op pop= Paramaitres_op.getInstance();
 static Produit_paramaitre_op ppo = Produit_paramaitre_op.getInstance();
 Paramaitre p ;
 Tools t=Tools.getInstance();
public static String nom_magasin="";
 BoutonColor bc= BoutonColor.getInstance();
static public ArrayList<Produit> ListProduit2=new ArrayList<>();
//static public ArrayList<Produit> ListProduitRepture=new ArrayList<>();
//static public ArrayList<Produit> ListProduitperime=new ArrayList<>();
  ArrayList<String> ListCode=new ArrayList<>();
static int  nbre_produit=0;
 int nbre_produit_perime=0;
 static int nbre_produit_repture=0;
//  static int [] paramaitre2=new int [22];
// TextNumber tn=new TextNumber();
String s="";
Tools tools=Tools.getInstance();
  Message me = new Message(this, true,"/images/stop.png","Vous n'avez pas les autorisations pour faire cette opération!","",Color.red);
 Message me1 = new Message(this, true,"/images/stop.png"," veuiller remplir le champ code barre packet!","Code barre packet vide",Color.red);
 Message me2 = new Message(this, true,"/images/stop.png","veuiller remplir le champ code barre!","Code barre vide",Color.red);
//public ArrayList<Produit> ListProduit1;
// ArrayList<PrintReportProduit> ListPrintProduit =new ArrayList<>();  
// JPopupMenu popup;
private static GestionProduit obj=null;
    /**
     * Creates new form 
     * @return 
     */

public static GestionProduit getObj(){
     try {
     //   paramaitre2= ppo.getparamaitre_Produit2();
    }  catch (Exception ex) {
        System.out.println("Exception1");
        Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
    }  
        try {     //ListProduit2.clear();
      //  ListProduit1=op.getList_Produit2("","","id_produit");
      //  nbre_produit=ListProduit1.size();
       //  produit_total.setText("Total de Produits="+nbre_produit);
       //  System.out.println("nbre_produit="+nbre_produit);
        
        }
        catch (Exception ex) {
             System.out.println("Exception2");
          //  nbre_produit=0;
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
     /*   try{ produit_total.setText("Total de Produits=");}catch(Exception e){
            
             System.out.println("Exception3  =="+nbre_produit);
            e.printStackTrace();}
        */
        // ListProduit1=op.getList_Produit("","","Répture");
     //   nbre_produit_repture=Aucceuil4.ListP_en_stock_alert.size();
        try{ 
        }catch(Exception e){e.printStackTrace();
         System.out.println("Exception4");
        }
        
        //  ListProduit1=op.getList_Produit("","","Produit périmé");
     //   nbre_produit_perime=Aucceuil4.ListP_périmé.size();
        try{// produit_périmé.setText("Produit périmé="+nbre_produit_perime);
        }catch(Exception e){e.printStackTrace();
         System.out.println("Exception5");
        }
        
        //  op.displayResult(ListProduit,jTable1);
        //  Date d1=Date.valueOf(ListProduit.get(0).getDate_premption());
        //   Date d2=Date.valueOf(ListProduit.get(1).getDate_premption());
        
     //   ppo.displayResult(ListProduit2, jTable1,paramaitre2 ,produit_total);
       //  Calendar c= Calendar.getInstance();
        // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        // c.setTime(d);
        // c.add(Calendar.DATE, 1);
        // String    dt=sdf.format(c.getTime());
        
        
        //System.out.println(date);
        //System.out.println("d1-date="+(d1.getTime()-date.getTime()));
        // System.out.println("d2-d1="+(d2.getTime()-d1.getTime()));
//System.out.println("date1="+d1);
//System.out.println("date2="+d2);
        
        
        if(obj==null){
            try {
                obj=new GestionProduit();
            } catch (Exception ex) {
                Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
   
    }


    private GestionProduit() {
        initComponents();
        
       
        
        
         //  produit_total.setText("0000");

       this.setIconImage(tools.getImageIcone().getImage());
        jTable1.setRowHeight(30);
    try {
        p=pop.get_Paramaitre();
        nom_magasin=p.getNom_magasin();
    } catch (Exception ex) {
      //  Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
           JTableHeader tableHeader = jTable1.getTableHeader();
           
           jTable1.getTableHeader().setOpaque(false);
          // jTable1.getTableHeader().setBackground(Color.yellow);
     
           
   //   tableHeader.setBackground(Color.red);
     tableHeader.setForeground(Color.BLACK);
     
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
   
      //cpo.Charger_categorie(ch2);
      //    ch2.addItem("toute");
      //  ch2.setSelectedItem("toute");
        
       
      //  cpco.Charger_categorie(ch3);
       //   ch3.addItem("toute");
       //  ch3.setSelectedItem("toute");
        
        
       // mop.Charger_marques(ch5,null);
       //   ch5.addItem("toute les marques");
       //  ch5.setSelectedItem("toute les marques");
      //  if(ListProduit.size()>0)    
          ListProduit2.clear();
    try {ListProduit2= op.getList_Produit2("","","id_produit");
   nbre_produit=ListProduit2.size();
     produit_total.setText("Total de Produits="+nbre_produit);
     
   //  ListProduitRepture=op.getList_Produit("","","Répture");
   //
   nbre_produit_repture=Aucceuil.ListP_en_repture.size();
     produit_repture.setText("Produit en répture="+nbre_produit_repture);
     
     // ListProduitperime=op.getList_Produit("","","Produit périmé");
    nbre_produit_perime=Aucceuil.ListP_périmé.size();
     produit_périmé.setText("Produit périmé="+nbre_produit_perime);
      
      //  op.displayResult(ListProduit,jTable1);
    //  Date d1=Date.valueOf(ListProduit.get(0).getDate_premption());
    //   Date d2=Date.valueOf(ListProduit.get(1).getDate_premption());
   //  Collections.sort(ListProduit2);
        ppo.displayResult(ListProduit2, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
        Calendar cal= Calendar.getInstance();
       // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       // c.setTime(d);
        cal.add(Calendar.DATE, 1);
    // String    dt=sdf.format(c.getTime());
       
            
    //System.out.println(date);  
   //System.out.println("d1-date="+(d1.getTime()-date.getTime()));
   // System.out.println("d2-d1="+(d2.getTime()-d1.getTime()));
//System.out.println("date1="+d1);
//System.out.println("date2="+d2);
    } catch (Exception ex) {
        Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
    bc.ColorerBouton(jButtonModifier, new Color(1, 101, 225));
     bc.ColorerBouton(jBtnSupprimer, Color.red);
      bc.ColorerBouton(jButton_Ajouter,  new Color(41,134,10));
      
  // DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//jTable1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
   
  //for (int columnIndex = 0; columnIndex < jTable1.getColumnCount(); columnIndex++)
    //    {
     //       jTable1.getColumnModel().getColumn(columnIndex).setCellRenderer(centerRenderer);
     //   }

//DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) jTable1.getTableHeader().getDefaultRenderer();
//renderer.setHorizontalAlignment(0);

//jTable1.setAutoCreateRowSorter(true);
   /*  try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
*/
jTable1.setComponentPopupMenu(jPopupMenu);
jTable1.addMouseListener(new TableMouseListener(jTable1));
    }
    
    
    public GestionProduit(ArrayList<Produit> ListP) {
        initComponents();
        this.setIconImage(tools.getImageIcone().getImage());
        jTable1.setRowHeight(30);
           JTableHeader tableHeader = jTable1.getTableHeader();
             jTable1.getTableHeader().setOpaque(false);
          // jTable1.getTableHeader().setBackground(Color.yellow);
           
      tableHeader.setBackground(new Color(0,102,204));
     tableHeader.setForeground(Color.white);
  //    tableHeader.setBackground(Color.BLACK);
    // tableHeader.setForeground(Color.blue);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
      
    bc.ColorerBouton(jButtonModifier, new Color(1, 101, 225));
     bc.ColorerBouton(jBtnSupprimer, Color.red);
      bc.ColorerBouton(jButton_Ajouter,  new Color(41,134,10));
      
    try {
        ppo.displayResult(ListP, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
    } catch (Exception ex) {
        Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPopupMenu = new javax.swing.JPopupMenu();
        menu_modifier = new javax.swing.JMenuItem();
        menu_supprimer = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        Rechercher = new javax.swing.JLabel();
        Rachercher = new javax.swing.JComboBox<>();
        ch1 = new javax.swing.JTextField();
        AfficherMasquer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Afficher = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        produit_périmé = new javax.swing.JLabel();
        produit_repture = new javax.swing.JLabel();
        produit_total = new javax.swing.JLabel();
        jButton_Ajouter = new javax.swing.JButton();
        jBtnSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Print_CodeBarre = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Print_CodeBarre1 = new javax.swing.JButton();

        menu_modifier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        menu_modifier.setText("Modifier");
        menu_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_modifierActionPerformed(evt);
            }
        });
        jPopupMenu.add(menu_modifier);

        menu_supprimer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        menu_supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-supprimer-pour-toujours-24.png"))); // NOI18N
        menu_supprimer.setText("Supprimer");
        menu_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_supprimerActionPerformed(evt);
            }
        });
        jPopupMenu.add(menu_supprimer);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des produits");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setAutoscrolls(true);
        jPanel2.setPreferredSize(new java.awt.Dimension(1300, 60));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Rechercher.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Rechercher.setText("Recherche par");
        Rechercher.setPreferredSize(new java.awt.Dimension(95, 23));
        jPanel2.add(Rechercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 34));

        Rachercher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rachercher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Code_barre", "Désignation", "Famille" }));
        Rachercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RachercherActionPerformed(evt);
            }
        });
        jPanel2.add(Rachercher, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, 34));

        ch1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ch1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ch1.setToolTipText("");
        org.jdesktop.swingx.border.IconBorder iconBorder1 = new org.jdesktop.swingx.border.IconBorder();
        iconBorder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search2.png"))); // NOI18N
        ch1.setBorder(iconBorder1);
        ch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ch1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ch1KeyTyped(evt);
            }
        });
        jPanel2.add(ch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 240, 34));

        AfficherMasquer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AfficherMasquer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngegg(1).png"))); // NOI18N
        AfficherMasquer.setText("Afficher ou masquer");
        AfficherMasquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherMasquerActionPerformed(evt);
            }
        });
        jPanel2.add(AfficherMasquer, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 240, 34));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Afficher");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 34));

        Afficher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Afficher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous les produits", "Produit périmé", "Produit en répture" }));
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        jPanel2.add(Afficher, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 150, 34));

        jPanel1.setLayout(new java.awt.BorderLayout());

        produit_périmé.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        produit_périmé.setText("Produit périmé");
        produit_périmé.setPreferredSize(new java.awt.Dimension(160, 18));
        jPanel1.add(produit_périmé, java.awt.BorderLayout.CENTER);

        produit_repture.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        produit_repture.setText("Produit en repture");
        produit_repture.setPreferredSize(new java.awt.Dimension(170, 18));
        jPanel1.add(produit_repture, java.awt.BorderLayout.PAGE_START);

        produit_total.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        produit_total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        produit_total.setText("Total de produits");
        produit_total.setPreferredSize(new java.awt.Dimension(175, 18));
        jPanel1.add(produit_total, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 300, 70));

        jButton_Ajouter.setBackground(new java.awt.Color(51, 204, 0));
        jButton_Ajouter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton_Ajouter.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Ajouter.setText("Ajouter");
        jButton_Ajouter.setPreferredSize(new java.awt.Dimension(105, 40));
        jButton_Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AjouterActionPerformed(evt);
            }
        });

        jBtnSupprimer.setBackground(new java.awt.Color(255, 0, 0));
        jBtnSupprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jBtnSupprimer.setForeground(new java.awt.Color(255, 255, 255));
        jBtnSupprimer.setText("Supprimer");
        jBtnSupprimer.setPreferredSize(new java.awt.Dimension(105, 40));
        jBtnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSupprimerActionPerformed(evt);
            }
        });

        jButtonModifier.setBackground(new java.awt.Color(51, 102, 255));
        jButtonModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonModifier.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModifier.setText("Modifier");
        jButtonModifier.setPreferredSize(new java.awt.Dimension(105, 40));
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-24.png"))); // NOI18N
        jButton4.setText(" Liste des produits");
        jButton4.setPreferredSize(new java.awt.Dimension(221, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Print_CodeBarre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Print_CodeBarre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Barcode.png"))); // NOI18N
        Print_CodeBarre.setText("  Code barre produit");
        Print_CodeBarre.setPreferredSize(new java.awt.Dimension(237, 40));
        Print_CodeBarre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_CodeBarreActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setPreferredSize(null);
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        Print_CodeBarre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Print_CodeBarre1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Barcode.png"))); // NOI18N
        Print_CodeBarre1.setText("  code barre packet");
        Print_CodeBarre1.setPreferredSize(new java.awt.Dimension(237, 40));
        Print_CodeBarre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Print_CodeBarre1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1233, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jBtnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Print_CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Print_CodeBarre1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Print_CodeBarre1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Print_CodeBarre, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Print_CodeBarreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_CodeBarreActionPerformed
  int position=jTable1.getSelectedRow(); 
 
  if(position>=0){
      try {
          
          ListCode=cop.GetListCode1(ListProduit2.get(position).getId_produit());
         
          if(ListCode.isEmpty())
              me2.showAlert();
          //    JOptionPane.showMessageDialog(null, " Code bare vide ,veuiller remplir le champ code bare  , cliquer sur modifier  ","",JOptionPane.INFORMATION_MESSAGE,img);
          else {
              Produit pro=new Produit(ListProduit2.get(position).getDésignation(),
                      ListProduit2.get(position).getPrix_vente_detail(),ListProduit2.get(position).getPrix_vente_gros(),ListProduit2.get(position).getPrix_special(),
                     ListProduit2.get(position).getPrix_vente_packet(),
                     ListCode.get(0),
                      ListProduit2.get(position).getDate_premption());
              ImpressionCodBarre.pro=pro;
               ImpressionCodBarre.getObj(pro).setVisible(true);
          }
      } catch (Exception ex) {
          Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  else tools.ShowFailMessage(this, "veuiller sélectionner une ligne");
    // JOptionPane.showMessageDialog(null, " veuiller sélectionner une ligne ","",JOptionPane.INFORMATION_MESSAGE,img2);
//for(int i=0;i<ListProduit.size();i++)  
   // ListProduit.get(i).setCode_barre("7500677238614");
       
       // reportsengine.ReportsManager.getInstance().showReport("report1.jasper", new Hashtable(), "Etiquette code bare", ListProduit);
    }//GEN-LAST:event_Print_CodeBarreActionPerformed

    private void jButton_AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AjouterActionPerformed
        // AjouterProduit.getObj(0).setVisible(true);
          if(!ExistSerialNumber)t.ShowFailMessage(this, "Logiciel non activer appeler 0792-04-08-17");
     else {   if(utilisateur.getAuto10()==1) AjouterProduit.getObj(0).setVisible(true); else me.showAlert();}
    }//GEN-LAST:event_jButton_AjouterActionPerformed

    private void jBtnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSupprimerActionPerformed

        
        if(jTable1.getSelectedRow()==-1)
          //  JOptionPane.showMessageDialog(null, " veuiller sélectionner une ligne ","",JOptionPane.INFORMATION_MESSAGE,img2);
        tools.ShowFailMessage(this, "veuiller sélectionner une ligne");
        else try {
            MessageDialog obj = new MessageDialog(this);
        obj.showMessage("Voulez vous supprimer ce produit ?", "Si vous cliquer sur ok \nCe produit sera suppimer .");
          //  int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  ce produit","",JOptionPane.YES_NO_OPTION);
          //  if(result==0){
          if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                op.sup_Produit_withID(ListProduit2.get(jTable1.getSelectedRow()).getId_produit());
               try{ op.DelImage(ListProduit2.get(jTable1.getSelectedRow()).getId_produit());}catch(Exception e){}
                tools.ShowGoodMessage(this, "Bien supprimer");
              //  JOptionPane.showMessageDialog(null, " Bien Supprimer ","",JOptionPane.INFORMATION_MESSAGE,imgok);
                ListProduit2.remove(jTable1.getSelectedRow());
                nbre_produit=ListProduit2.size();
              //  op.displayResult(ListProduit,jTable1);
                 ppo.displayResult(ListProduit2, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
                 
             /*    Aucceuil.ListP_périmé=op.getList_Produit("Produit périmé", "", "");  
                 nbre_produit_perime=Aucceuil.ListP_périmé.size();
                 produit_périmé.setText("Produit périmé="+nbre_produit_perime);
                 
                 ListP_Stock_alert=op.getList_Produit("Répture", "", "quantité");
                 nbre_produit_repture=Aucceuil.ListP_Stock_alert.size();
                 produit_repture.setText("Produit en répture="+nbre_produit_repture);*/
             Aucceuil.refrechEtatProduit();

            }else{}
        } catch (Exception ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        // System.out.println(jTable1.getSelectedRow());
        //int position=jTable1.getSelectedRow();
        //  System.out.println(ListProduit.size());
        // System.out.println(jTable1.getSelectedRow());
        //int position=jTable1.getSelectedRow();
        //  System.out.println(ListProduit.size());
    }//GEN-LAST:event_jBtnSupprimerActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        int position=jTable1.getSelectedRow();
        if(position==-1)
            tools.ShowFailMessage(this, "Veuiller sélectionner un produit pour Modifier");
            //JOptionPane.showMessageDialog(null, " veuiller sélectionner un produit pour Modifier ","",JOptionPane.INFORMATION_MESSAGE,img2);
        else   {AjouterProduit.prod=ListProduit2.get(position);
            AjouterProduit.getObj2(AjouterProduit.prod).setVisible(true);
        }
        // new ModifierProduit( ListProduit(position).getcategorie_produit,  categorie_piece,  etat, marque, numero_serie, référence,  désignation, étagére, codebare, remarque,  prix_achat,  prix_vente, quantité).setVisible(true);
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void RachercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RachercherActionPerformed
   param1=Rachercher.getSelectedItem().toString();
   try {param2=ch1.getText().trim();
      
         
          if(!ListProduit2.isEmpty())   ListProduit2.clear();
          if(!param2.isEmpty())  {ListProduit2=op.getList_Produit2(param1,param2,"id_produit");
           //  op.displayResult(ListProduit,jTable1);
              ppo.displayResult(ListProduit2, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
          }
        } catch (Exception ex) {

        }   
   
    
    }//GEN-LAST:event_RachercherActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  //  ListPrintProduit.clear();
     
       // for (int i=0;i<ListProduit2.size();i++)
   // ListPrintProduit.add(new PrintReportProduit(p.getNom_magasin(),p.getAdresse(),p.getNum_tel_fax_fix(),p.getNum_tel1(),p.getNum_tel2(),ListProduit2.get(i).getDésignation(),ListProduit2.get(i).getPrix_vente_detail(),ListProduit2.get(i).getMarque(),ListProduit2.get(i).getQuantité()+"","",ListProduit2.get(i).getRéférence(),ListProduit2.get(i).getQuantité()));
      //  reportsengine.ReportsManager.getInstance().showReport("List des produits manque_4.jasper", new Hashtable(), "List des produits manque", ListPrintProduit);
       reportsengine.ReportsManager.getInstance().showReport("List des produits.jasper", new Hashtable(), "List des produits ", ListProduit2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void AfficherMasquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherMasquerActionPerformed
    try {
        Produit_paramaitre p=  ppo.getparamaitre_Produit1();
         ModifierParamaitreProduit.getObj2(p).setVisible(true);
    } catch (Exception ex) {
        Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
       
    }//GEN-LAST:event_AfficherMasquerActionPerformed

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
    //  jPopupMenu.show(this, evt.getX(), evt.getY());
    /*
        int r = jTable1.rowAtPoint(evt.getPoint());
        if (r >= 0 && r < jTable1.getRowCount()) {
            jTable1.setRowSelectionInterval(r, r);
        } else {
            jTable1.clearSelection();
        }

        int rowindex = jTable1.getSelectedRow();
        if (rowindex < 0)
            return;
        if (evt.isPopupTrigger() && evt.getComponent() instanceof JTable ) {
            JPopupMenu popup = new JPopupMenu();
            System.out.println("jjjjjjjjj");
            popup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
   */
    }//GEN-LAST:event_jTable1MouseReleased

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
          try {
              param3=Rachercher.getSelectedItem().toString();
             param2=ch1.getText().trim();
            param1=Afficher.getSelectedItem().toString();
          if(!ListProduit2.isEmpty())   ListProduit2.clear();
            ListProduit2=op.getList_Produit2(param1,param2,param3);
           //  op.displayResult(ListProduit,jTable1);
              ppo.displayResult(ListProduit2, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_AfficherActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        obj=null;
        this.dispose();
    
         
    }//GEN-LAST:event_formWindowClosing

    private void Print_CodeBarre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Print_CodeBarre1ActionPerformed
      int position=jTable1.getSelectedRow(); 
 
  if(position>=0){
      try {
          
          
         
          if(ListProduit2.get(position).getCode_bare_packet().isEmpty())
              me1.showAlert();
             // JOptionPane.showMessageDialog(null, " Code barre packet vide ,veuiller remplir le champ code barre packet  , cliquer sur modifier  ","",JOptionPane.INFORMATION_MESSAGE,img);
          else {
              Produit pro=new Produit(ListProduit2.get(position).getDésignation(),
                      ListProduit2.get(position).getPrix_vente_detail(),ListProduit2.get(position).getPrix_vente_gros(),ListProduit2.get(position).getPrix_special(),
                     ListProduit2.get(position).getPrix_vente_packet(),
                   ListProduit2.get(position).getCode_bare_packet() ,
                      ListProduit2.get(position).getDate_premption());
              ImpressionCodBarre.pro=pro;
               ImpressionCodBarre.getObj(pro).setVisible(true);
          }
      } catch (Exception ex) {
          Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  else tools.ShowFailMessage(this, "veuiller sélectionner un produit pour Modifier");
     // JOptionPane.showMessageDialog(null, "C ","",JOptionPane.INFORMATION_MESSAGE,img2);  
    }//GEN-LAST:event_Print_CodeBarre1ActionPerformed

    private void ch1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ch1KeyTyped
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

                if(evt.getKeyChar()==KeyEvent.VK_ENTER){ch1.setText(s);
                    //  System.out.println("fin de String");
                    s="";
                }
                if(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE) { ch1.setText("");s="";}
                try {

            if(!ListProduit2.isEmpty())   ListProduit2.clear();
            //  if(!ch1.getText().trim().isEmpty())
            ListProduit2=op.getList_Produit2(param1,ch1.getText().trim(),"id_produit");
            //  op.displayResult(ListProduit,jTable1);
            ppo.displayResult(ListProduit2, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
        } catch (Exception ex) {

        }
                

    }//GEN-LAST:event_ch1KeyTyped

    private void ch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ch1KeyReleased
    //    if(!ch1.getText().trim().equals(""))
        try {

            if(!ListProduit2.isEmpty())   ListProduit2.clear();
            //  if(!ch1.getText().trim().isEmpty())
            ListProduit2=op.getList_Produit2(param1,ch1.getText().trim(),"id_produit");
            //  op.displayResult(ListProduit,jTable1);
            ppo.displayResult(ListProduit2, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
        } catch (Exception ex) {

        }
        
    }//GEN-LAST:event_ch1KeyReleased

    private void menu_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_modifierActionPerformed
          int position=jTable1.getSelectedRow();
        if(position==-1)
            tools.ShowFailMessage(this, "Veuiller sélectionner un produit pour Modifier");
            //JOptionPane.showMessageDialog(null, " veuiller sélectionner un produit pour Modifier ","",JOptionPane.INFORMATION_MESSAGE,img2);
        else   {AjouterProduit.prod=ListProduit2.get(position);
            AjouterProduit.getObj2(AjouterProduit.prod).setVisible(true);
        }
    }//GEN-LAST:event_menu_modifierActionPerformed

    private void menu_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_supprimerActionPerformed
        if(jTable1.getSelectedRow()==-1)
            tools.ShowFailMessage(this, "veuiller sélectionner une ligne");
           // JOptionPane.showMessageDialog(null, " veuiller sélectionner une ligne ","",JOptionPane.INFORMATION_MESSAGE,img2);
        else try {
            MessageDialog obj = new MessageDialog(this);
        obj.showMessage("Voulez vous supprimer ce produit ?", "Si vous cliquer sur ok \nCe produit sera suppimer .");
          //  int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer  ce produit","",JOptionPane.YES_NO_OPTION);
          //  if(result==0){
          if (obj.getMessageType() == MessageDialog.MessageType.OK) {
                op.sup_Produit(ListProduit2.get(jTable1.getSelectedRow()).getRéférence());
                tools.ShowGoodMessage(this, "Bien Supprimer");
             //   JOptionPane.showMessageDialog(null, " Bien Supprimer ","",JOptionPane.INFORMATION_MESSAGE,imgok);
                ListProduit2.remove(jTable1.getSelectedRow());
                nbre_produit=ListProduit2.size();
              //  op.displayResult(ListProduit,jTable1);
                 ppo.displayResult(ListProduit2, jTable1, ppo.getparamaitre_Produit2(),produit_total,nbre_produit);
                 
                 Aucceuil.ListP_périmé=op.getList_Produit("Produit périmé", "", "");  
                 nbre_produit_perime=Aucceuil.ListP_périmé.size();
                 produit_périmé.setText("Produit périmé="+nbre_produit_perime);
                 
                 ListP_Stock_alert=op.getList_Produit("Répture", "", "quantité");
                 nbre_produit_repture=Aucceuil.ListP_Stock_alert.size();
                 produit_repture.setText("Produit en répture="+nbre_produit_repture);

            }else{}
        } catch (Exception ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menu_supprimerActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
    
    }//GEN-LAST:event_formMouseReleased

    /**
     * @param args the command line arguments
     */
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Afficher;
    private javax.swing.JButton AfficherMasquer;
    private javax.swing.JButton Print_CodeBarre;
    private javax.swing.JButton Print_CodeBarre1;
    private javax.swing.JComboBox<String> Rachercher;
    private javax.swing.JLabel Rechercher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField ch1;
    private javax.swing.JButton jBtnSupprimer;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButton_Ajouter;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menu_modifier;
    private javax.swing.JMenuItem menu_supprimer;
    public static javax.swing.JLabel produit_périmé;
    public static javax.swing.JLabel produit_repture;
    public static javax.swing.JLabel produit_total;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent ke) {
  /*    s=s+ke.getKeyChar();
       System.out.println("fin "+ke.getKeyChar());
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
  
    if(ke.getKeyChar()==KeyEvent.VK_ENTER){ch1.setText(s); 
   
    s="";
    }
 if(ke.getKeyChar()==KeyEvent.VK_BACK_SPACE) { ch1.setText("");s="";}
*/
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
