/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.Cripto_op;
import controler.DataBase_op;
import controler.Produit_op;
import controler.Tools;
import controler.User_op;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.Timer;
import model.Produit;
import model.User;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import raven.glasspanepopup.DefaultLayoutCallBack;
import raven.glasspanepopup.DefaultOption;
import raven.glasspanepopup.GlassPanePopup;
import sample.notification.Notifications;
import sweet_alert.Message;

/**
 *
 * @author hicham
 */
public class Aucceuil extends javax.swing.JFrame {
static Produit_op pop=Produit_op.getInstance();
DataBase_op dop=DataBase_op.getInstance();
static public ArrayList<Produit> ListP_périmé;
static public ArrayList<Produit> ListP_en_repture;    
static public ArrayList<Produit> ListP_Stock_alert;    
static public ArrayList<Produit> ListP_pres_peremption;  

//ImageIcon   img = new ImageIcon("images/gs.png");
 Message mok = new Message(this, true,"/images/good128.png","Votre logiciel est Activer","",new Color(41,134,10));
  Message me = new Message(this, true,"/images/stop.png","Vous n'avez pas les autorisations pour faire cette opération!","",Color.red);
 static Cripto_op cop= Cripto_op.getInstance();
  User_op uop=User_op.getInstance();
  
   String key="ezeon8547";   
  public static  String enc="";
static int NbrP_périmé=0;
static int NbrTotalProduit=0;
static int NbrP_Repture=0;
static int NbrP_pres_périmé=0;
static int NbrP_alert=0;
String dossier="";
Tools t=Tools.getInstance();
//public static String [] SerialNumber;
public static String sr="";
public static boolean ExistSerialNumber=false;
private static Aucceuil obj=null;
public static String userName="";
public static User utilisateur;
Tools tools=Tools.getInstance();
public static Aucceuil getObj(String UserName,String folder){
        if(obj==null){
            try {       
                //SerialNumber=cop.GetSerialNumber();
                ExistSerialNumber=cop.ExistSerialNumber(  cop.encrypt("ezeon8547", cop.getNumero()));
                System.out.println("ExistSerialNumber="+ExistSerialNumber);
              obj=new Aucceuil( UserName,folder);
            } catch (Exception ex) {
              
            }
        }
        return obj;
    }
    /**
     * Creates new form NewJFrame
     */
    public Aucceuil(String UserName1,String folder) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, Exception {
        initComponents();
        ExistSerialNumber=cop.ExistSerialNumber(  cop.encrypt("ezeon8547", cop.getNumero()));
          System.out.println("ExistSerialNumber="+ExistSerialNumber);
        userName=UserName1;
        dossier=folder;
       // utilisateur=uop.get_user(UserName);
        facebook_label.setIcon(resize("images/facebook.png",20,20));
        gs_Label.setIcon(resize("images/gs.png",50,50));
        GlassPanePopup.install(this);
       try{ Dossier.setText("Dossier en cours:"+dossier);}catch(Exception e){}
   Date_label.setHorizontalAlignment(JLabel.CENTER);
 //  SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
   Date_label.setFont(
   UIManager.getFont("Label.font").deriveFont(Font.BOLD, 25f));
  // Date_label.setText(
  // DateFormat.getDateTimeInstance().format(new Date()) );
   Timer t = new Timer(500, new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
   Date_label.setText(
          
   DateFormat.getDateTimeInstance().format(new Date()));
       }   
         });
t.setRepeats(true);
t.setCoalesce(true);
t.setInitialDelay(0);
t.start();
refrechEtatProduit();
    /*try {
        ListP_périmé =pop.getList_Produit("Produit périmé", "", "");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }
NbrP_périmé=ListP_périmé.size();
badgeButton2.setText(NbrP_périmé+"");   

    try {
        ListP_en_repture=pop.getList_Produit("Répture", "", "quantité");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
      //  ListP_en_repture=null;
    }
    NbrP_Repture=ListP_en_repture.size();
badgeButton1.setText(NbrP_Repture+"");
    
    try {
       ListP_Stock_alert =pop.getList_Produit("stock_alert", "", "");
      //  System.out.println("execution produit proche");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }   
NbrP_alert=ListP_Stock_alert.size();
badgeButton3.setText(NbrP_alert+"");
//System.out.println("NbrP_pres_périmé="+NbrP_pres_périmé);

try {
        ListP_pres_peremption =pop.getList_Produit("proche", "", "");
      //  System.out.println("execution produit proche");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }   
NbrP_pres_périmé=ListP_pres_peremption.size();
badgeButton4.setText(NbrP_pres_périmé+"");
*/
menu.jLabel_user.setText("Utilisateur:"+userName);
this.setIconImage(tools.getImageIcone().getImage());
   try{ Dossier.setText("Dossier en cours:"+dossier);}catch(Exception e){}
   
       // enc=cop.crypteru(cop.getMac());
        if(ExistSerialNumber)Activation.setText("Logiciel activer");
        else Activation.setText("Logiciel non activer appeler 0792-04-08-17");
  
         try {
        utilisateur=uop.get_user(userName);
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
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

        menu = new com.raven.menu.Menu();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelStock = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnMManage3 = new javax.swing.JButton();
        btnMManage9 = new javax.swing.JButton();
        btnMManage33 = new javax.swing.JButton();
        btnMManage34 = new javax.swing.JButton();
        btnMManage35 = new javax.swing.JButton();
        jPanelVente = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        btnMManage10 = new javax.swing.JButton();
        btnMManage16 = new javax.swing.JButton();
        jPanelAchat = new javax.swing.JPanel();
        jToolBar7 = new javax.swing.JToolBar();
        btnMManage18 = new javax.swing.JButton();
        btnMManage20 = new javax.swing.JButton();
        btnMManage22 = new javax.swing.JButton();
        btnMManage36 = new javax.swing.JButton();
        jPanelFournisseur = new javax.swing.JPanel();
        jToolBar8 = new javax.swing.JToolBar();
        btnMManage21 = new javax.swing.JButton();
        btnMManage23 = new javax.swing.JButton();
        btnMManage24 = new javax.swing.JButton();
        jPanelClient = new javax.swing.JPanel();
        jToolBar9 = new javax.swing.JToolBar();
        btnMManage12 = new javax.swing.JButton();
        btnMManage11 = new javax.swing.JButton();
        btnMManage14 = new javax.swing.JButton();
        jPanelUtilisateur = new javax.swing.JPanel();
        jToolBar10 = new javax.swing.JToolBar();
        btnMManage13 = new javax.swing.JButton();
        btnMManage15 = new javax.swing.JButton();
        jPanelEmploye = new javax.swing.JPanel();
        jToolBar11 = new javax.swing.JToolBar();
        btnMManage25 = new javax.swing.JButton();
        jPanelCaisse = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanelDepense = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanelStatistique = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        btnMManage8 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanelParamaitres = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        btnMManage30 = new javax.swing.JButton();
        btnMManage26 = new javax.swing.JButton();
        btnMManage27 = new javax.swing.JButton();
        btnMManage29 = new javax.swing.JButton();
        btnMManage28 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        facebook_label = new javax.swing.JLabel();
        gs_Label = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        badgeButton1 = new raven.notibutton.BadgeButton();
        Date_label = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel_stock_alert = new javax.swing.JLabel();
        badgeButton3 = new raven.notibutton.BadgeButton();
        badgeButton2 = new raven.notibutton.BadgeButton();
        jLabel57 = new javax.swing.JLabel();
        badgeButton4 = new raven.notibutton.BadgeButton();
        Dossier = new javax.swing.JLabel();
        Activation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("accueil");
        setBackground(new java.awt.Color(0, 102, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        btnMManage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32list.png"))); // NOI18N
        btnMManage3.setText("Liste des produits");
        btnMManage3.setFocusable(false);
        btnMManage3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage3.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage3ActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMManage3);

        btnMManage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32add2.png"))); // NOI18N
        btnMManage9.setText("Ajouter un produit");
        btnMManage9.setFocusable(false);
        btnMManage9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage9.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage9ActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMManage9);

        btnMManage33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32update.png"))); // NOI18N
        btnMManage33.setText("Mouvement d'un produit");
        btnMManage33.setFocusable(false);
        btnMManage33.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage33.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage33.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage33ActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMManage33);

        btnMManage34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32update.png"))); // NOI18N
        btnMManage34.setText("Inventaire");
        btnMManage34.setFocusable(false);
        btnMManage34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage34.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage34.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage34ActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMManage34);

        btnMManage35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/inventaire32list.png"))); // NOI18N
        btnMManage35.setText("Liste Inventaire");
        btnMManage35.setFocusable(false);
        btnMManage35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage35.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage35.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage35ActionPerformed(evt);
            }
        });
        jToolBar2.add(btnMManage35);

        javax.swing.GroupLayout jPanelStockLayout = new javax.swing.GroupLayout(jPanelStock);
        jPanelStock.setLayout(jPanelStockLayout);
        jPanelStockLayout.setHorizontalGroup(
            jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStockLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanelStockLayout.setVerticalGroup(
            jPanelStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("  Stock", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/pack48.png")), jPanelStock); // NOI18N

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);

        btnMManage10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/cart32.png"))); // NOI18N
        btnMManage10.setText("Vente ");
        btnMManage10.setFocusable(false);
        btnMManage10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage10.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage10ActionPerformed(evt);
            }
        });
        jToolBar6.add(btnMManage10);

        btnMManage16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/cart32list.png"))); // NOI18N
        btnMManage16.setText("Liste des Ventes et bons ");
        btnMManage16.setFocusable(false);
        btnMManage16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage16.setPreferredSize(new java.awt.Dimension(180, 60));
        btnMManage16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage16ActionPerformed(evt);
            }
        });
        jToolBar6.add(btnMManage16);

        javax.swing.GroupLayout jPanelVenteLayout = new javax.swing.GroupLayout(jPanelVente);
        jPanelVente.setLayout(jPanelVenteLayout);
        jPanelVenteLayout.setHorizontalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVenteLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToolBar6, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)))
        );
        jPanelVenteLayout.setVerticalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
            .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelVenteLayout.createSequentialGroup()
                    .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 117, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Ventes", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/shopping-cart-full48.png")), jPanelVente); // NOI18N

        jToolBar7.setFloatable(false);
        jToolBar7.setRollover(true);

        btnMManage18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/achat32list.png"))); // NOI18N
        btnMManage18.setText("Liste d'achat et des bons");
        btnMManage18.setFocusable(false);
        btnMManage18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage18.setPreferredSize(new java.awt.Dimension(160, 60));
        btnMManage18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage18ActionPerformed(evt);
            }
        });
        jToolBar7.add(btnMManage18);

        btnMManage20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/achat32.png"))); // NOI18N
        btnMManage20.setText("Achat");
        btnMManage20.setFocusable(false);
        btnMManage20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage20.setPreferredSize(new java.awt.Dimension(160, 60));
        btnMManage20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage20ActionPerformed(evt);
            }
        });
        jToolBar7.add(btnMManage20);

        btnMManage22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/achat32list.png"))); // NOI18N
        btnMManage22.setText("Liste commandes fournisseurs");
        btnMManage22.setFocusable(false);
        btnMManage22.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage22.setPreferredSize(new java.awt.Dimension(200, 60));
        btnMManage22.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage22ActionPerformed(evt);
            }
        });
        jToolBar7.add(btnMManage22);

        btnMManage36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/achat32bon.png"))); // NOI18N
        btnMManage36.setText("Bon de Commande ");
        btnMManage36.setFocusable(false);
        btnMManage36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage36.setMinimumSize(new java.awt.Dimension(160, 57));
        btnMManage36.setPreferredSize(new java.awt.Dimension(200, 60));
        btnMManage36.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage36ActionPerformed(evt);
            }
        });
        jToolBar7.add(btnMManage36);

        javax.swing.GroupLayout jPanelAchatLayout = new javax.swing.GroupLayout(jPanelAchat);
        jPanelAchat.setLayout(jPanelAchatLayout);
        jPanelAchatLayout.setHorizontalGroup(
            jPanelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAchatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar7, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
        );
        jPanelAchatLayout.setVerticalGroup(
            jPanelAchatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAchatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Achats", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/achat48.png")), jPanelAchat); // NOI18N

        jToolBar8.setFloatable(false);
        jToolBar8.setRollover(true);

        btnMManage21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/man1-32list.png"))); // NOI18N
        btnMManage21.setText("Liste de Fournisseurs");
        btnMManage21.setFocusable(false);
        btnMManage21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage21.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage21.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage21ActionPerformed(evt);
            }
        });
        jToolBar8.add(btnMManage21);

        btnMManage23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/man1-32add.png"))); // NOI18N
        btnMManage23.setText("Ajouter un Fournisseur");
        btnMManage23.setFocusable(false);
        btnMManage23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage23.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage23.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage23ActionPerformed(evt);
            }
        });
        jToolBar8.add(btnMManage23);

        btnMManage24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/man1-32verse.png"))); // NOI18N
        btnMManage24.setText("Liste des  Versements");
        btnMManage24.setFocusable(false);
        btnMManage24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage24.setPreferredSize(new java.awt.Dimension(150, 60));
        btnMManage24.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage24ActionPerformed(evt);
            }
        });
        jToolBar8.add(btnMManage24);

        javax.swing.GroupLayout jPanelFournisseurLayout = new javax.swing.GroupLayout(jPanelFournisseur);
        jPanelFournisseur.setLayout(jPanelFournisseurLayout);
        jPanelFournisseurLayout.setHorizontalGroup(
            jPanelFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFournisseurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar8, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
        );
        jPanelFournisseurLayout.setVerticalGroup(
            jPanelFournisseurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFournisseurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar8, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Fournisseurs", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/man1-48.png")), jPanelFournisseur); // NOI18N

        jToolBar9.setFloatable(false);
        jToolBar9.setRollover(true);

        btnMManage12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/man32list.png"))); // NOI18N
        btnMManage12.setText("Liste des clients");
        btnMManage12.setFocusable(false);
        btnMManage12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage12.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage12ActionPerformed(evt);
            }
        });
        jToolBar9.add(btnMManage12);

        btnMManage11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/Add-Male-User32.png"))); // NOI18N
        btnMManage11.setText("Ajouter un client");
        btnMManage11.setFocusable(false);
        btnMManage11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage11.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage11ActionPerformed(evt);
            }
        });
        jToolBar9.add(btnMManage11);

        btnMManage14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/man32vers.png"))); // NOI18N
        btnMManage14.setText("Liste des Versements ");
        btnMManage14.setFocusable(false);
        btnMManage14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage14.setPreferredSize(new java.awt.Dimension(150, 60));
        btnMManage14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage14ActionPerformed(evt);
            }
        });
        jToolBar9.add(btnMManage14);

        javax.swing.GroupLayout jPanelClientLayout = new javax.swing.GroupLayout(jPanelClient);
        jPanelClient.setLayout(jPanelClientLayout);
        jPanelClientLayout.setHorizontalGroup(
            jPanelClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar9, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
        );
        jPanelClientLayout.setVerticalGroup(
            jPanelClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar9, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Clients", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/man48.png")), jPanelClient); // NOI18N

        jToolBar10.setFloatable(false);
        jToolBar10.setRollover(true);

        btnMManage13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pw.png"))); // NOI18N
        btnMManage13.setText("Changer Mot de passe");
        btnMManage13.setFocusable(false);
        btnMManage13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage13.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage13ActionPerformed(evt);
            }
        });
        jToolBar10.add(btnMManage13);

        btnMManage15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/user-group32.png"))); // NOI18N
        btnMManage15.setText("Liste d'utilisateurs");
        btnMManage15.setFocusable(false);
        btnMManage15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage15.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage15ActionPerformed(evt);
            }
        });
        jToolBar10.add(btnMManage15);

        javax.swing.GroupLayout jPanelUtilisateurLayout = new javax.swing.GroupLayout(jPanelUtilisateur);
        jPanelUtilisateur.setLayout(jPanelUtilisateurLayout);
        jPanelUtilisateurLayout.setHorizontalGroup(
            jPanelUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUtilisateurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar10, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
        );
        jPanelUtilisateurLayout.setVerticalGroup(
            jPanelUtilisateurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUtilisateurLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab(" utilisateurs", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/user-group48.png")), jPanelUtilisateur); // NOI18N

        jToolBar11.setFloatable(false);
        jToolBar11.setRollover(true);

        btnMManage25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/1313949076_group.png"))); // NOI18N
        btnMManage25.setText("Gestion d'employés");
        btnMManage25.setFocusable(false);
        btnMManage25.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage25.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage25.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage25ActionPerformed(evt);
            }
        });
        jToolBar11.add(btnMManage25);

        javax.swing.GroupLayout jPanelEmployeLayout = new javax.swing.GroupLayout(jPanelEmploye);
        jPanelEmploye.setLayout(jPanelEmployeLayout);
        jPanelEmployeLayout.setHorizontalGroup(
            jPanelEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmployeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar11, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelEmployeLayout.setVerticalGroup(
            jPanelEmployeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(" Employés", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/1313949076_group.png")), jPanelEmploye); // NOI18N

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/argent32.png"))); // NOI18N
        jButton12.setText("Gestion de Caisse");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setPreferredSize(new java.awt.Dimension(140, 60));
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton12);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/argent32list.png"))); // NOI18N
        jButton13.setText("Liste  des opérations");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setPreferredSize(new java.awt.Dimension(140, 60));
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar3.add(jButton13);

        javax.swing.GroupLayout jPanelCaisseLayout = new javax.swing.GroupLayout(jPanelCaisse);
        jPanelCaisse.setLayout(jPanelCaisseLayout);
        jPanelCaisseLayout.setHorizontalGroup(
            jPanelCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCaisseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
        );
        jPanelCaisseLayout.setVerticalGroup(
            jPanelCaisseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Caisse", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/argent.png")), jPanelCaisse); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/budget32.png"))); // NOI18N
        jButton11.setText("Gestion des dépenses");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setPreferredSize(new java.awt.Dimension(140, 60));
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/budget32.png"))); // NOI18N
        jButton14.setText("Gestion des pertes");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setPreferredSize(new java.awt.Dimension(140, 60));
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton14);

        javax.swing.GroupLayout jPanelDepenseLayout = new javax.swing.GroupLayout(jPanelDepense);
        jPanelDepense.setLayout(jPanelDepenseLayout);
        jPanelDepenseLayout.setHorizontalGroup(
            jPanelDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDepenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE))
        );
        jPanelDepenseLayout.setVerticalGroup(
            jPanelDepenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane1.addTab("Dépenses & Pertes", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/budget48.png")), jPanelDepense); // NOI18N

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        btnMManage8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/statistique32.png"))); // NOI18N
        btnMManage8.setText("Statistiques");
        btnMManage8.setFocusable(false);
        btnMManage8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage8.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage8ActionPerformed(evt);
            }
        });
        jToolBar4.add(btnMManage8);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/argent32.png"))); // NOI18N
        jButton15.setText("Calcul Zakat");
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setPreferredSize(new java.awt.Dimension(140, 60));
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jToolBar4.add(jButton15);

        javax.swing.GroupLayout jPanelStatistiqueLayout = new javax.swing.GroupLayout(jPanelStatistique);
        jPanelStatistique.setLayout(jPanelStatistiqueLayout);
        jPanelStatistiqueLayout.setHorizontalGroup(
            jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatistiqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar4, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelStatistiqueLayout.setVerticalGroup(
            jPanelStatistiqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatistiqueLayout.createSequentialGroup()
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Statistiques", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/statistique.png")), jPanelStatistique); // NOI18N

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        btnMManage30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/basic-data321.png"))); // NOI18N
        btnMManage30.setText("initialiser la base de données");
        btnMManage30.setFocusable(false);
        btnMManage30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage30.setPreferredSize(new java.awt.Dimension(180, 60));
        btnMManage30.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage30ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnMManage30);

        btnMManage26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/activation32.png"))); // NOI18N
        btnMManage26.setText("Activation logiciel");
        btnMManage26.setFocusable(false);
        btnMManage26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage26.setPreferredSize(new java.awt.Dimension(140, 60));
        btnMManage26.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage26ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnMManage26);

        btnMManage27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/basic-data32.png"))); // NOI18N
        btnMManage27.setText("Sauvgarde &  Réstoration & Dossier");
        btnMManage27.setFocusable(false);
        btnMManage27.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage27.setPreferredSize(new java.awt.Dimension(210, 60));
        btnMManage27.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage27ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnMManage27);

        btnMManage29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/setting32.png"))); // NOI18N
        btnMManage29.setText("paramaitres");
        btnMManage29.setFocusable(false);
        btnMManage29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage29.setPreferredSize(new java.awt.Dimension(120, 60));
        btnMManage29.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage29ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnMManage29);

        btnMManage28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/info-32.png"))); // NOI18N
        btnMManage28.setText("A propos");
        btnMManage28.setFocusable(false);
        btnMManage28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMManage28.setPreferredSize(new java.awt.Dimension(120, 60));
        btnMManage28.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMManage28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMManage28ActionPerformed(evt);
            }
        });
        jToolBar5.add(btnMManage28);

        javax.swing.GroupLayout jPanelParamaitresLayout = new javax.swing.GroupLayout(jPanelParamaitres);
        jPanelParamaitres.setLayout(jPanelParamaitresLayout);
        jPanelParamaitresLayout.setHorizontalGroup(
            jPanelParamaitresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
            .addGroup(jPanelParamaitresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelParamaitresLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jToolBar5, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)))
        );
        jPanelParamaitresLayout.setVerticalGroup(
            jPanelParamaitresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
            .addGroup(jPanelParamaitresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelParamaitresLayout.createSequentialGroup()
                    .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 119, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Paramaitres", new javax.swing.ImageIcon(getClass().getResource("/images/img_acc/setting.png")), jPanelParamaitres); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Connectez nous ");

        facebook_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        facebook_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/facebook.png"))); // NOI18N
        facebook_label.setPreferredSize(new java.awt.Dimension(50, 50));

        gs_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gs_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gs.png"))); // NOI18N

        jLabel51.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(220, 67, 67));
        jLabel51.setText("Produits périmés");

        badgeButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_1.png"))); // NOI18N
        badgeButton1.setText("0");
        badgeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton1ActionPerformed(evt);
            }
        });

        Date_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Date_label.setText("Date");

        jLabel55.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(220, 67, 67));
        jLabel55.setText("Produit en répture");

        jLabel_stock_alert.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel_stock_alert.setForeground(new java.awt.Color(220, 67, 67));
        jLabel_stock_alert.setText("Produit en Stock alert");

        badgeButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_1.png"))); // NOI18N
        badgeButton3.setText("0");
        badgeButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton3ActionPerformed(evt);
            }
        });

        badgeButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_1.png"))); // NOI18N
        badgeButton2.setText("0");
        badgeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton2ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(220, 67, 67));
        jLabel57.setText("Produit proche de péremption");

        badgeButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_1.png"))); // NOI18N
        badgeButton4.setText("0");
        badgeButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badgeButton4ActionPerformed(evt);
            }
        });

        Dossier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Dossier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Dossier.setText("Dossier en cours:");

        Activation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Activation.setText("Logiciel non activer appeler 0792-04-08-17");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Date_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel51))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(badgeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(badgeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel57)
                                .addGap(18, 18, 18)
                                .addComponent(badgeButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_stock_alert)
                                .addGap(18, 18, 18)
                                .addComponent(badgeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Dossier, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Activation, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52)
                        .addGap(3, 3, 3)
                        .addComponent(facebook_label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gs_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Date_label, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(badgeButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_stock_alert)
                    .addComponent(badgeButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(badgeButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel57))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51)
                        .addComponent(badgeButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Activation, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Dossier, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(facebook_label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gs_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 663, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        
    }//GEN-LAST:event_menuMouseClicked

    private void badgeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton1ActionPerformed
       //  badgeButton2.setText(Integer.parseInt(badgeButton2.getText()) + 1 + "");
        
        GlassPanePopup.showPopup(new Notifications(ListP_en_repture), new DefaultOption() {
            @Override
            public float opacity() {
                return 0;
            }

            @Override
            public LayoutCallback getLayoutCallBack(Component parent) {
                return new DefaultLayoutCallBack(parent) {
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()) {
                            Point pl = parent.getLocationOnScreen();
                            Point bl = badgeButton1.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            y += (1f - getAnimate()) * 10f;
                            cw.setBounds(x - cw.getWidth() + badgeButton1.getWidth(), y + badgeButton1.getHeight(), cw.getWidth(), cw.getHeight());
                        } else {
                            super.correctBounds(cw);
                        }
                    }
                };
            }

            @Override
            public String getLayout(Component parent, float animate) {
                return null;
            }
        });
        
    }//GEN-LAST:event_badgeButton1ActionPerformed

    private void btnMManage8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage8ActionPerformed
   
if(utilisateur.getAuto3()==1)     Statistiques.getObj().setVisible(true);
   else me.showAlert();
    }//GEN-LAST:event_btnMManage8ActionPerformed

    private void btnMManage9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage9ActionPerformed
    if(!ExistSerialNumber&&(NbrTotalProduit>4))t.ShowFailMessage(this, "Logiciel non activer appeler 0792-04-08-17");
     else {  if(utilisateur.getAuto10()==1)      AjouterProduit.getObj(2).setVisible(true); else me.showAlert();
           }
    }//GEN-LAST:event_btnMManage9ActionPerformed

    private void btnMManage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage3ActionPerformed
     if(!ExistSerialNumber)t.ShowFailMessage(this, "Logiciel non activer appeler 0792-04-08-17");
     else {   if(utilisateur.getAuto10()==1) GestionProduit.getObj().setVisible(true); else me.showAlert();}
    }//GEN-LAST:event_btnMManage3ActionPerformed

    private void btnMManage10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage10ActionPerformed
      if(utilisateur.getAuto6()==1) { //VenteComptoir4.obj=null; 
      VenteComptoir4.getObj(Aucceuil.userName).setVisible(true);} else me.showAlert();
    }//GEN-LAST:event_btnMManage10ActionPerformed

    private void btnMManage11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage11ActionPerformed
       if(utilisateur.getAuto14()==1)  AjouterModifierClient.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage11ActionPerformed

    private void btnMManage12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage12ActionPerformed
       if(utilisateur.getAuto12()==1) RechercherClient.getObj(1).setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage12ActionPerformed

    private void btnMManage13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage13ActionPerformed
     Changer_MP.getObj().setVisible(true); 
    }//GEN-LAST:event_btnMManage13ActionPerformed

    private void btnMManage16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage16ActionPerformed
     if(utilisateur.getAuto2()==1) ListeDesVentes.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage16ActionPerformed

    private void btnMManage18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage18ActionPerformed
       if(utilisateur.getAuto1()==1) ListeAchat.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage18ActionPerformed

    private void btnMManage20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage20ActionPerformed
      if(!ExistSerialNumber)t.ShowFailMessage(this, "Logiciel non activer appeler 0792-04-08-17");
      else {  if(utilisateur.getAuto7()==1) { //NewAchat.obj=null;
    NewAchat.getObj(Aucceuil.userName).setVisible(true);} else me.showAlert();}
    }//GEN-LAST:event_btnMManage20ActionPerformed

    private void btnMManage21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage21ActionPerformed
  
        if(utilisateur.getAuto11()==1)   RechercherFournisseur.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage21ActionPerformed

    private void btnMManage23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage23ActionPerformed
      if(utilisateur.getAuto13()==1)  AjouterFournisseur.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage23ActionPerformed

    private void btnMManage26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage26ActionPerformed
       try {  System.out.println("nbre de serial="+cop.NbreSerialNumber());} catch (Exception ex) {ex.printStackTrace();}
        try {
      //  if(!enc.equals(cop.GetSerialNumber()))  
       if(!ExistSerialNumber) 
            ActivationLogiciel.getObj().setVisible(true);
        else  mok.showAlert();
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnMManage26ActionPerformed

    private void btnMManage27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage27ActionPerformed
   
     if(utilisateur.getAuto16()==1)  
     { SauvgardeRestoration.getObj(userName,dossier).setVisible(true);this.dispose();}
     else me.showAlert();
    }//GEN-LAST:event_btnMManage27ActionPerformed

    private void btnMManage28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage28ActionPerformed
     apropos.getObj().setVisible(true);
    }//GEN-LAST:event_btnMManage28ActionPerformed

    private void btnMManage29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage29ActionPerformed
     if(utilisateur.getAuto9()==1) { 
        Paramaitres1.getObj().setVisible(true); 
       // obj=null;
       // this.dispose();
     }else me.showAlert();
    }//GEN-LAST:event_btnMManage29ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
      if(utilisateur.getAuto15()==1)   GestionDepense1.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void badgeButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton3ActionPerformed
       GlassPanePopup.showPopup(new Notifications(ListP_Stock_alert), new DefaultOption() {
            @Override
            public float opacity() {
                return 0;
            }

            @Override
            public LayoutCallback getLayoutCallBack(Component parent) {
                return new DefaultLayoutCallBack(parent) {
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()) {
                            Point pl = parent.getLocationOnScreen();
                            Point bl = badgeButton3.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            y += (1f - getAnimate()) * 10f;
                            cw.setBounds(x - cw.getWidth() + badgeButton3.getWidth(), y + badgeButton3.getHeight(), cw.getWidth(), cw.getHeight());
                        } else {
                            super.correctBounds(cw);
                        }
                    }
                };
            }

            @Override
            public String getLayout(Component parent, float animate) {
                return null;
            }
        });
          
    }//GEN-LAST:event_badgeButton3ActionPerformed

    private void badgeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton2ActionPerformed
        GlassPanePopup.showPopup(new Notifications(ListP_périmé), new DefaultOption() {
            @Override
            public float opacity() {
                return 0;
            }

            @Override
            public LayoutCallback getLayoutCallBack(Component parent) {
                return new DefaultLayoutCallBack(parent) {
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()) {
                            Point pl = parent.getLocationOnScreen();
                            Point bl = badgeButton2.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            y += (1f - getAnimate()) * 10f;
                            cw.setBounds(x - cw.getWidth() + badgeButton2.getWidth(), y + badgeButton2.getHeight(), cw.getWidth(), cw.getHeight());
                        } else {
                            super.correctBounds(cw);
                        }
                    }
                };
            }

            @Override
            public String getLayout(Component parent, float animate) {
                return null;
            }
        });
        
    }//GEN-LAST:event_badgeButton2ActionPerformed

    private void btnMManage33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage33ActionPerformed
       if(utilisateur.getAuto17()==1)   MouvementProduit.getObj(userName).setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage33ActionPerformed

    private void btnMManage15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage15ActionPerformed
     if(utilisateur.getAuto8()==1) Gestion_utilisateur.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage15ActionPerformed

    private void btnMManage25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage25ActionPerformed
     if(utilisateur.getAuto18()==1)  gestion_des_employeurs.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_btnMManage25ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
     if(utilisateur.getAuto19()==1)    GestionCaisse.getObj(userName).setVisible(true);else me.showAlert();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
     if(utilisateur.getAuto19()==1)   ListeOperationCaisse.getObj().setVisible(true);else me.showAlert();
    }//GEN-LAST:event_jButton13ActionPerformed

    private void badgeButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badgeButton4ActionPerformed
        GlassPanePopup.showPopup(new Notifications(ListP_pres_peremption), new DefaultOption() {
            @Override
            public float opacity() {
                return 0;
            }

            @Override
            public LayoutCallback getLayoutCallBack(Component parent) {
                return new DefaultLayoutCallBack(parent) {
                    @Override
                    public void correctBounds(ComponentWrapper cw) {
                        if (parent.isVisible()) {
                            Point pl = parent.getLocationOnScreen();
                            Point bl = badgeButton4.getLocationOnScreen();
                            int x = bl.x - pl.x;
                            int y = bl.y - pl.y;
                            y += (1f - getAnimate()) * 10f;
                            cw.setBounds(x - cw.getWidth() + badgeButton4.getWidth(), y + badgeButton4.getHeight(), cw.getWidth(), cw.getHeight());
                        } else {
                            super.correctBounds(cw);
                        }
                    }
                };
            }

            @Override
            public String getLayout(Component parent, float animate) {
                return null;
            }
        });
        
    }//GEN-LAST:event_badgeButton4ActionPerformed

    private void btnMManage34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage34ActionPerformed
      if(utilisateur.getAuto20()==1)  NewInventaire.getObj(userName).setVisible(true);else me.showAlert();
    }//GEN-LAST:event_btnMManage34ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
   System.exit(0);
   /*     obj=null;
        this.dispose();
    try{VenteComptoir4.obj.dispose();}catch(Exception e){}
    try{VenteComptoir4.obj2.dispose();}catch(Exception e){}
   try{ AjouterPerte.getObj().dispose();}catch(Exception e){}
   try{ ActivationLogiciel.getObj().dispose();}catch(Exception e){}
   try{ AjouterDepense.getObj().dispose();}catch(Exception e){}
   try{ AjouterFournisseur.getObj().dispose();}catch(Exception e){}
   try{ AjouterModifierClient.getObj().dispose();}catch(Exception e){}
   try{ AjouterPerte.getObj().dispose();}catch(Exception e){}
  try{  AjouterProduit.getObj(0).dispose();}catch(Exception e){}
 // try{  Changer_MP.getObj().dispose();}catch(Exception e){}
   try{ GestionCaisse.getObj("").dispose();}catch(Exception e){}
  try{  GestionDepense1.getObj().dispose();}catch(Exception e){}
  try{  GestionPerte.getObj().dispose();}catch(Exception e){}
  try{  GestionProduit.getObj().dispose();}catch(Exception e){}
   try{ Gestion_utilisateur.getObj().dispose();}catch(Exception e){}
   try{ InitialisationBDD.getObj("", "").dispose();}catch(Exception e){}
   try{ ListeAchat.getObj().dispose();}catch(Exception e){}
  try{  ListeCommandeFournisseur.getObj("").dispose();}catch(Exception e){}
   try{ ListeDesVentes.getObj().dispose();}catch(Exception e){}
   try{ ListeInventaire.getObj("").dispose();}catch(Exception e){}
   try{ ListeOperationCaisse.getObj().dispose();}catch(Exception e){}
   try{ ListeVersementClient.getObj().dispose();}catch(Exception e){}
   try{ ListeVersementFournisseur.getObj().dispose();}catch(Exception e){}
 //  try{ ModifierEmploy.getObj(null).dispose();}catch(Exception e){}
 //  try{ ModifierFournisseur.getObj(null).dispose();}catch(Exception e){}
   try{ ModifierParamaitreProduit.getObj().dispose();}catch(Exception e){}
  try{  MouvementProduit.getObj("").dispose(); }catch(Exception e){}
 try{  MouvementProduit.getObj("").dispose();}catch(Exception e){}
  try{  NewAchat.getObj("").dispose(); }catch(Exception e){}
 try{  MouvementProduit.getObj("").dispose();}catch(Exception e){}
  try{  NewCommandeFournisseur.getObj("").dispose();}catch(Exception e){}
   try{ NewInventaire.getObj("").dispose();}catch(Exception e){}
  try{  Paramaitres1.getObj().dispose();}catch(Exception e){}
  try{  RechercherClient.getObj(0).dispose();}catch(Exception e){}
  try{  RechercherFournisseur.getObj().dispose();}catch(Exception e){}
   try{ RechercherProduitAchat.getObj(0, "").dispose();}catch(Exception e){}
   try{ RechercherProduitCommande.getInstance().dispose();}catch(Exception e){}
    try{RechercherProduitInventaire.getInstance().dispose();}catch(Exception e){}
   try{ RechercherProduitMouvement.getInstance().dispose();}catch(Exception e){}
 //  try{ RechercherProduitVendre.getObj(' ', "", 0).dispose();}catch(Exception e){}
 //  try{ SauvgardeRestoration.getObj("", "").dispose();}catch(Exception e){}
   try{ Statistiques.getObj().dispose();}catch(Exception e){}
  // try{ VersementClient.getObj(null).dispose();}catch(Exception e){}
 //  try{ VersementFournisseur.getObj(null).dispose();}catch(Exception e){}
  //  try{Versementemploye.getObj("", "").dispose();}catch(Exception e){}
    try{ajouteremploi.getObj().dispose();}catch(Exception e){}
   try{ apropos.getObj().dispose();}catch(Exception e){}
 // try{  detaillesalaire.getObj("", "", "").dispose();}catch(Exception e){}
   try{ gestion_des_employeurs.getObj().dispose();}catch(Exception e){}
     new login().setVisible(true);*/
   
    }//GEN-LAST:event_formWindowClosing

    private void btnMManage35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage35ActionPerformed
      if(utilisateur.getAuto20()==1) ListeInventaire.getObj(userName).setVisible(true);  else me.showAlert();
    }//GEN-LAST:event_btnMManage35ActionPerformed

    private void btnMManage30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage30ActionPerformed
     
     if(utilisateur.getAuto21()==1) {InitialisationBDD.getObj(userName,dossier).setVisible(true);
     this.dispose();
     obj=null;
     }else me.showAlert();  
       
    }//GEN-LAST:event_btnMManage30ActionPerformed

    private void btnMManage24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage24ActionPerformed
       if(utilisateur.getAuto11()==1) ListeVersementFournisseur.getObj().setVisible(true);  else me.showAlert();  
    }//GEN-LAST:event_btnMManage24ActionPerformed

    private void btnMManage14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage14ActionPerformed
      if(utilisateur.getAuto12()==1) ListeVersementClient.getObj().setVisible(true);  else me.showAlert();
    }//GEN-LAST:event_btnMManage14ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
     if(utilisateur.getAuto15()==1)  GestionPerte.getObj().setVisible(true); else me.showAlert();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btnMManage22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage22ActionPerformed
      if(utilisateur.getAuto22()==1) ListeCommandeFournisseur.getObj(Aucceuil.userName).setVisible(true);  else me.showAlert();
 
    }//GEN-LAST:event_btnMManage22ActionPerformed

    private void btnMManage36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMManage36ActionPerformed
      if(utilisateur.getAuto22()==1) { //NewAchat.obj=null;
    NewCommandeFournisseur.getObj(Aucceuil.userName).setVisible(true);} else me.showAlert();
    }//GEN-LAST:event_btnMManage36ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
     if(utilisateur.getAuto4()==1)     Zakat.getObj().setVisible(true);
   else me.showAlert();  
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Activation;
    private javax.swing.JLabel Date_label;
    public static javax.swing.JLabel Dossier;
    public static raven.notibutton.BadgeButton badgeButton1;
    public static raven.notibutton.BadgeButton badgeButton2;
    public static raven.notibutton.BadgeButton badgeButton3;
    public static raven.notibutton.BadgeButton badgeButton4;
    private javax.swing.JButton btnMManage10;
    private javax.swing.JButton btnMManage11;
    private javax.swing.JButton btnMManage12;
    private javax.swing.JButton btnMManage13;
    private javax.swing.JButton btnMManage14;
    private javax.swing.JButton btnMManage15;
    private javax.swing.JButton btnMManage16;
    private javax.swing.JButton btnMManage18;
    private javax.swing.JButton btnMManage20;
    private javax.swing.JButton btnMManage21;
    private javax.swing.JButton btnMManage22;
    private javax.swing.JButton btnMManage23;
    private javax.swing.JButton btnMManage24;
    private javax.swing.JButton btnMManage25;
    private javax.swing.JButton btnMManage26;
    private javax.swing.JButton btnMManage27;
    private javax.swing.JButton btnMManage28;
    private javax.swing.JButton btnMManage29;
    private javax.swing.JButton btnMManage3;
    private javax.swing.JButton btnMManage30;
    private javax.swing.JButton btnMManage33;
    private javax.swing.JButton btnMManage34;
    private javax.swing.JButton btnMManage35;
    private javax.swing.JButton btnMManage36;
    private javax.swing.JButton btnMManage8;
    private javax.swing.JButton btnMManage9;
    private javax.swing.JLabel facebook_label;
    private javax.swing.JLabel gs_Label;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel_stock_alert;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAchat;
    private javax.swing.JPanel jPanelCaisse;
    private javax.swing.JPanel jPanelClient;
    private javax.swing.JPanel jPanelDepense;
    private javax.swing.JPanel jPanelEmploye;
    private javax.swing.JPanel jPanelFournisseur;
    private javax.swing.JPanel jPanelParamaitres;
    private javax.swing.JPanel jPanelStatistique;
    private javax.swing.JPanel jPanelStock;
    private javax.swing.JPanel jPanelUtilisateur;
    private javax.swing.JPanel jPanelVente;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar10;
    private javax.swing.JToolBar jToolBar11;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JToolBar jToolBar9;
    private com.raven.menu.Menu menu;
    // End of variables declaration//GEN-END:variables

public ImageIcon resize(String imgPath,int x,int y)
  {
    ImageIcon path = new ImageIcon(imgPath);
    Image img = path.getImage();
    Image newImg = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
  }

public static void refrechEtatProduit(){
 try {
        NbrTotalProduit =pop.NombreProduit();
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }   
 try {
        ListP_périmé =pop.getList_Produit("Produit périmé", "", "");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }
NbrP_périmé=ListP_périmé.size();
badgeButton2.setText(NbrP_périmé+"");   

    try {
        ListP_en_repture=pop.getList_Produit("Répture", "", "quantité");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
      //  ListP_en_repture=null;
    }
    NbrP_Repture=ListP_en_repture.size();
badgeButton1.setText(NbrP_Repture+"");
    
    try {
       ListP_Stock_alert =pop.getList_Produit("stock_alert", "", "");
      //  System.out.println("execution produit proche");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }   
NbrP_alert=ListP_Stock_alert.size();
badgeButton3.setText(NbrP_alert+"");
//System.out.println("NbrP_pres_périmé="+NbrP_pres_périmé);

try {
        ListP_pres_peremption =pop.getList_Produit("proche", "", "");
      //  System.out.println("execution produit proche");
    } catch (Exception ex) {
        Logger.getLogger(Aucceuil.class.getName()).log(Level.SEVERE, null, ex);
    }   
NbrP_pres_périmé=ListP_pres_peremption.size();
badgeButton4.setText(NbrP_pres_périmé+"");


}

}
