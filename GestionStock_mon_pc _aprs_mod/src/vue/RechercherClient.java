/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.BoutonColor;
import controler.Client_op;
import controler.TableMouseListener;
import controler.TextNumber;
import controler.Tools;
import controler.Versement_client;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.JTableHeader;
import model.Client;
//import model.Produit;
//import model.Vente;
import model.Versement;
import raven.javaswingdev.MessageDialog;

import static vue.VenteComptoir4.A_rendu;
import static vue.VenteComptoir4.a_rendu;
import static vue.VenteComptoir4.a_rendu2;
import static vue.VenteComptoir4.Ancien_credit;
import static vue.VenteComptoir4.dette;
import static vue.VenteComptoir4.dette2;
import static vue.VenteComptoir4.m_verse;
import static vue.VenteComptoir4.m_verse2;
import static vue.VenteComptoir4.montant_verser;
import static vue.VenteComptoir4.nv_credit;
import static vue.VenteComptoir4.nv_credit2;
import static vue.VenteComptoir4.nvcredit;
import static vue.VenteComptoir4.total_apres_remise;
import static vue.VenteComptoir4.total_apres_remise2;
import static vue.VenteComptoir4.numClient;
//import static vue.VenteComptoir4.Total_Apres_Remise;
import static vue.VenteComptoir4.remise;
import static vue.VenteComptoir4.remise2;
import static vue.VenteComptoir4.total;
import static vue.VenteComptoir4.total2;
/**
 *
 * @author Rais
 */

public class RechercherClient  extends javax.swing.JFrame {
//public static Client_op cop=new Client_op();
 public  static ArrayList<Client> ListClient=new ArrayList<Client>();
 public static ArrayList<Versement> ListVersClient;
int option=1;
String date1,date2;
double credit;
String Type_v="";
//ImageIcon   img = new ImageIcon("images/gs.png");
//ImageIcon   img1 = new ImageIcon("images/good.png");
//ImageIcon   img2 = new ImageIcon("images/warning.png");
Tools t=Tools.getInstance();
public static Client_op op= Client_op.getInstance();
Versement_client vop= Versement_client.getObj();   
static int nbfclient=0;
static double Tcredit=0;
static TextNumber tn= TextNumber.getObj();
BoutonColor bc= BoutonColor.getInstance();
public static int index=-1;
 //Message me = new Message(this, true,"/images/stop.png","Veuiller sélectionner un client","",Color.red);
    /**
     * Creates new form gestionClient
     */
  
  private static RechercherClient obj=null;
  public static RechercherClient getObj(int numC){
        if(obj==null){
            try {
         obj=new RechercherClient(numC);
            } catch (Exception ex) {
                Logger.getLogger(RechercherClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
      try{  ListClient=op.getList_Client("",0);
          nbfclient=ListClient.size();
          Nbclient.setText(nbfclient+"");
          Tcredit=0;
          for (int i=0;i<nbfclient;i++)
          Tcredit=ListClient.get(i).getCrédit()+Tcredit;
          TotalCredit.setText(tn.Afficher2Verguile(Tcredit));
          op.displayResult(ListClient,jTable1);
      }catch(Exception e){}
        }
        
        
        
        return obj;
    }
    public RechercherClient (int numC) {
         this.setIconImage(t.getImageIcone().getImage());
        initComponents();
        ListClient.clear();
             jTable1.setRowHeight(30);
           JTableHeader tableHeader = jTable1.getTableHeader();
            jTable1.getTableHeader().setOpaque(false);
      tableHeader.setBackground(Color.WHITE);
     tableHeader.setForeground(Color.BLACK);
    
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
       //   this.setIconImage(img.getImage());
        jButton1.setVisible(false);
          try {ListClient=op.getList_Client("",0);
          nbfclient=ListClient.size();
          Nbclient.setText(nbfclient+"");
          Tcredit=0;
          for (int i=0;i<nbfclient;i++)
          Tcredit=ListClient.get(i).getCrédit()+Tcredit;
          TotalCredit.setText(tn.Afficher2Verguile(Tcredit));
        op.displayResult(ListClient,jTable1);
         //op.displayResult(ListFournisseur,jTable2);
        // ListVers=vop.getList_Versement_Fournisseur();
       //  vop.displayResult(ListVers,jTable3);
        bc.ColorerBouton(jButtonPrint, new Color(102,102,102));
        
                  bc.ColorerBouton(jButtonAdd, new Color(41,134,10));
      bc.ColorerBouton(jButtonModifier,  new Color(1, 101, 225));
      bc.ColorerBouton(jButtonSupp, Color.red);
      bc.ColorerBouton(Reglement, new Color(102,102,255));
      jTable1.setComponentPopupMenu(jPopupMenu);
      jTable1.addMouseListener(new TableMouseListener(jTable1));
      //   ListVersClient=vop.getList_Versement_Client(nbfclient);
       //  vop.displayResult(ListVersClient,jTable3);
    } catch (Exception ex) {
       // Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        ex.printStackTrace();
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu = new javax.swing.JPopupMenu();
        jMenu_Suprimer = new javax.swing.JMenuItem();
        jMenuModifier = new javax.swing.JMenuItem();
        jMenuVersement = new javax.swing.JMenuItem();
        jLabel11 = new javax.swing.JLabel();
        nom_prenom_c = new javax.swing.JTextField();
        jButtonSupp = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonPrint = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Nbclient = new javax.swing.JTextField();
        TotalCredit = new javax.swing.JTextField();
        Reglement = new javax.swing.JButton();

        jMenu_Suprimer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenu_Suprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-supprimer-pour-toujours-24.png"))); // NOI18N
        jMenu_Suprimer.setText("Supprimer");
        jMenu_Suprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_SuprimerActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenu_Suprimer);

        jMenuModifier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jMenuModifier.setText("Modifier");
        jMenuModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuModifierActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuModifier);

        jMenuVersement.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuVersement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/budget24.png"))); // NOI18N
        jMenuVersement.setText("Versement");
        jMenuVersement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVersementActionPerformed(evt);
            }
        });
        jPopupMenu.add(jMenuVersement);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des Clients");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Recherche par nom et prénom  ");

        nom_prenom_c.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom_prenom_c.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        org.jdesktop.swingx.border.IconBorder iconBorder1 = new org.jdesktop.swingx.border.IconBorder();
        iconBorder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search2.png"))); // NOI18N
        nom_prenom_c.setBorder(iconBorder1);
        nom_prenom_c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nom_prenom_cKeyReleased(evt);
            }
        });

        jButtonSupp.setBackground(new java.awt.Color(255, 51, 51));
        jButtonSupp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSupp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSupp.setText("Supprimer");
        jButtonSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppActionPerformed(evt);
            }
        });

        jButtonModifier.setBackground(new java.awt.Color(102, 153, 255));
        jButtonModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonModifier.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(0, 204, 0));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Ajouter");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom et prenom", "adresse", "email", "num tel1", "num Tel2", "Numéro registre commerce", "numero identification fiscale", "Numéro d'article d'imposition", "solde"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(275, 64));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Liste des Clients");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("choisir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPrint.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrint.setText("imprimer");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Afficher ");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tous", "Crédit=0", "Crédit>0", "Crédit<0" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre des Clients");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total des Crédits");

        Nbclient.setEditable(false);
        Nbclient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nbclient.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        TotalCredit.setEditable(false);
        TotalCredit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TotalCredit.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Reglement.setBackground(new java.awt.Color(102, 102, 255));
        Reglement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Reglement.setForeground(new java.awt.Color(255, 255, 255));
        Reglement.setText("Versement");
        Reglement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReglementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1199, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nom_prenom_c))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Reglement, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 548, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Nbclient, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(TotalCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(509, 509, 509)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom_prenom_c, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reglement, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nbclient, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
       AjouterModifierClient.op="ajouter";
         AjouterModifierClient.getObj().setVisible(true);
       
        
      
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppActionPerformed
     Tcredit=0;
     index=jTable1.getSelectedRow();
    if(ListClient.get(index).getId_client().equals("C0"))
        t.ShowFailMessage(this, "tu ne peut pas supprimer ce client");
       // JOptionPane.showMessageDialog(null, " tu ne peut pas supprimer ce client ","",JOptionPane.INFORMATION_MESSAGE,img2);
    /*    if(jTable1.getSelectedRow()==-1) JOptionPane.showMessageDialog(null, " veuiller sélectionner un client pour supprimer ","",JOptionPane.INFORMATION_MESSAGE,img2);
       else try {
             int  result =JOptionPane.showConfirmDialog(null,"Voulez vous supprimer  ce client","",JOptionPane.YES_NO_OPTION);   
       if(result==0){ 
           op.sup_Client(ListClient.get(jTable1.getSelectedRow()).getId_c());
            JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img1);
            ListClient.remove(jTable1.getSelectedRow());
             op.displayResult(ListClient,jTable1);
            
                 RechercherClient.Nbclient.setText(ListClient.size()+"");
         for (int i=0;i<ListClient.size();i++)
          Tcredit=ListClient.get(i).getCrédit()+Tcredit;
         RechercherClient.TotalCredit.setText(tn.Afficher2Verguile(Tcredit)+" DA");
            //  op.displayResult(ListClient,jTable2);
            
       }else{}
       } catch (Exception ex) {
          // Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
       }
      *  /*
     
     */
     
        
        
    else {
        
         
        if(index==-1)
            t.ShowFailMessage(this, "Veuiller sélectionner un client pour supprimer");
          //  JOptionPane.showMessageDialog(null, " veuiller sélectionner un client pour supprimer ","",JOptionPane.INFORMATION_MESSAGE,img2);
        else try {
           // int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer ce client","",JOptionPane.YES_NO_OPTION);
              if(t.ShowConfirmMessage("Voulez vous supprimer ce client ?", "", this)==MessageDialog.MessageType.OK){
                op.sup_Client(ListClient.get(index).getId_c());
                t.ShowGoodMessage(this, "Bien supprimer");
              //  JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img1);
                ListClient.remove(jTable1.getSelectedRow());
                op.displayResult(ListClient,jTable1);
                 RechercherClient.Nbclient.setText(ListClient.size()+"");
                  Tcredit=0;
         for (int i=0;i<ListClient.size();i++)
          Tcredit=ListClient.get(i).getCrédit()+Tcredit;
         RechercherClient.TotalCredit.setText(tn.Afficher2Verguile(Tcredit)+" DA");

               // op.displayResult(ListFournisseur,jTable2);

            }else{}
        } catch (Exception ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }//GEN-LAST:event_jButtonSuppActionPerformed

    private void nom_prenom_cKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_prenom_cKeyReleased
     //  AjouterModifierClient.label_ajou_moud.setText("Ajouter Client"); 
          int rech;
        if(!nom_prenom_c.getText().trim().equals("")){
      rech=4;
      }else{rech=0;}
        
        try {ListClient=op.getList_Client(nom_prenom_c.getText().trim(),rech);
        
            op.displayResult(ListClient,jTable1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_nom_prenom_cKeyReleased

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
          //  ListClient.clear();
         //  AjouterModifierClient.label_ajou_moud.setText("Modifier Client");
        //  try{  ListClient=op.getList_Client("",0);}catch(Exception e){}
          index=jTable1.getSelectedRow(); 
           if(index==-1)
               t.ShowFailMessage(this, "Veuiller sélectionner un client pour Modifier");
               //JOptionPane.showMessageDialog(null, " Veuiller sélectionner un client pour Modifier ","",JOptionPane.INFORMATION_MESSAGE,img2);
       else  if(ListClient.get(index).getId_client().equals("C0"))
        //JOptionPane.showMessageDialog(null, " tu ne peut pas modifier ce client ","",JOptionPane.INFORMATION_MESSAGE,img2);
       t.ShowFailMessage(this, "tu ne peut pas modifier ce client");
         
         else{
         
        
       
     try {
       AjouterModifierClient.op="modifier";
      //  new ModifierClient(ListClient.get(position)).setVisible(true);
       AjouterModifierClient.getObj2(ListClient.get(index)).setVisible(true);
         ListClient=op.getList_Client("",0);
        op.displayResult(ListClient,jTable1);
      
             } catch (Exception ex) {
                 Logger.getLogger(RechercherClient.class.getName()).log(Level.SEVERE, null, ex);
             }
    
         
         }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    selectClient(numClient);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
         reportsengine.ReportsManager.getInstance().showReport("List_Client _tous.jasper", new Hashtable(), "Liste des Clients", ListClient);
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int pos=jComboBox1.getSelectedIndex();
     
     
        try {ListClient=op.getList_Client("",pos);
        
            op.displayResult(ListClient,jTable1);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      this.dispose();
      obj=null;
      jButton1.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void ReglementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReglementActionPerformed
       index=jTable1.getSelectedRow();
        if(index==-1) t.ShowFailMessage(obj, "Veuiller sélectionner un client");
            //JOptionPane.showMessageDialog(null, " Veuiller sélectionner un fournisseur ","",JOptionPane.INFORMATION_MESSAGE,img);
        else {
            try {
        VersementClient.getObj(ListClient.get(index)).setVisible(true); 
        }catch(Exception e){}
        
        }
    }//GEN-LAST:event_ReglementActionPerformed

    private void jMenu_SuprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_SuprimerActionPerformed
         Tcredit=0;
     index=jTable1.getSelectedRow();
    if(ListClient.get(index).getId_client().equals("C0"))
        t.ShowFailMessage(this, "tu ne peut pas supprimer ce client");
        //JOptionPane.showMessageDialog(null, " tu ne peut pas supprimer ce client ","",JOptionPane.INFORMATION_MESSAGE,img2);
    /*    if(jTable1.getSelectedRow()==-1) JOptionPane.showMessageDialog(null, " veuiller sélectionner un client pour supprimer ","",JOptionPane.INFORMATION_MESSAGE,img2);
       else try {
             int  result =JOptionPane.showConfirmDialog(null,"Voulez vous supprimer  ce client","",JOptionPane.YES_NO_OPTION);   
       if(result==0){ 
           op.sup_Client(ListClient.get(jTable1.getSelectedRow()).getId_c());
            JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img1);
            ListClient.remove(jTable1.getSelectedRow());
             op.displayResult(ListClient,jTable1);
            
                 RechercherClient.Nbclient.setText(ListClient.size()+"");
         for (int i=0;i<ListClient.size();i++)
          Tcredit=ListClient.get(i).getCrédit()+Tcredit;
         RechercherClient.TotalCredit.setText(tn.Afficher2Verguile(Tcredit)+" DA");
            //  op.displayResult(ListClient,jTable2);
            
       }else{}
       } catch (Exception ex) {
          // Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
       }
      *  /*
     
     */
     
        
        
    else {
        
         
        if(index==-1)t.ShowFailMessage(this, "veuiller sélectionner un client pour supprimer");
           // JOptionPane.showMessageDialog(null, " veuiller sélectionner un client pour supprimer ","",JOptionPane.INFORMATION_MESSAGE,img2);
        else try {
           // int  result =JOptionPane.showConfirmDialog(null,"voulez vous supprimer ce client","",JOptionPane.YES_NO_OPTION);
                if(t.ShowConfirmMessage("Voulez vous supprimer ce client ?", "", this)==MessageDialog.MessageType.OK){
                op.sup_Client(ListClient.get(index).getId_c());
             //   JOptionPane.showMessageDialog(null, " Bien supprimer ","",JOptionPane.INFORMATION_MESSAGE,img1);
             t.ShowGoodMessage(this, "Bien supprimer");
                ListClient.remove(jTable1.getSelectedRow());
                op.displayResult(ListClient,jTable1);
                 RechercherClient.Nbclient.setText(ListClient.size()+"");
         for (int i=0;i<ListClient.size();i++)
          Tcredit=ListClient.get(i).getCrédit()+Tcredit;
         RechercherClient.TotalCredit.setText(tn.Afficher2Verguile(Tcredit)+" DA");

               // op.displayResult(ListFournisseur,jTable2);

            }else{}
        } catch (Exception ex) {
            Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    }//GEN-LAST:event_jMenu_SuprimerActionPerformed

    private void jMenuModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuModifierActionPerformed
         //  ListClient.clear();
         //  AjouterModifierClient.label_ajou_moud.setText("Modifier Client");
        //  try{  ListClient=op.getList_Client("",0);}catch(Exception e){}
          index=jTable1.getSelectedRow(); 
           if(index==-1)
               t.ShowFailMessage(this, "Veuiller sélectionner un client pour Modifier");
             //  JOptionPane.showMessageDialog(null, " Veuiller sélectionner un client pour Modifier ","",JOptionPane.INFORMATION_MESSAGE,img2);
       else  if(ListClient.get(index).getId_client().equals("C0"))
           t.ShowFailMessage(this, "tu ne peut pas modifier ce client");
       // JOptionPane.showMessageDialog(null, " tu ne peut pas modifier ce client ","",JOptionPane.INFORMATION_MESSAGE,img2);
         
         else{
         
        
       
     try {
       AjouterModifierClient.op="modifier";
      //  new ModifierClient(ListClient.get(position)).setVisible(true);
       AjouterModifierClient.getObj2(ListClient.get(index)).setVisible(true);
         ListClient=op.getList_Client("",0);
        op.displayResult(ListClient,jTable1);
      
             } catch (Exception ex) {
                 Logger.getLogger(RechercherClient.class.getName()).log(Level.SEVERE, null, ex);
             }
    
         
         }
    }//GEN-LAST:event_jMenuModifierActionPerformed

    private void jMenuVersementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVersementActionPerformed
        index=jTable1.getSelectedRow();
        if(index==-1) t.ShowFailMessage(obj, "Veuiller sélectionner un client");
            //JOptionPane.showMessageDialog(null, " Veuiller sélectionner un fournisseur ","",JOptionPane.INFORMATION_MESSAGE,img);
        else {
            try {
        VersementClient.getObj(ListClient.get(index)).setVisible(true); 
        }catch(Exception e){}
        
        }
    }//GEN-LAST:event_jMenuVersementActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField Nbclient;
    private javax.swing.JButton Reglement;
    public static javax.swing.JTextField TotalCredit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSupp;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuModifier;
    private javax.swing.JMenuItem jMenuVersement;
    private javax.swing.JMenuItem jMenu_Suprimer;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField nom_prenom_c;
    // End of variables declaration//GEN-END:variables

void selectClient( int numC){
   int position=jTable1.getSelectedRow(); 
         if(position==-1)
             t.ShowFailMessage(this, "Veuiller sélectionner un Client");
            // JOptionPane.showMessageDialog(null, " Veuiller sélectionner un Client  ","",JOptionPane.WARNING_MESSAGE,img2);
         else{     try { setVisible(false);
         
    if(numC==1) { VenteComptoir4.f=ListClient.get(position);
         VenteComptoir4.nom_client.setText(ListClient.get(position).getNom_prénom_client());
         dette=ListClient.get(position).getCrédit();
         montant_verser.setText(tn.Afficher2Verguile(0));
       //   m_verse= Double.parseDouble(montant_verser.getText());
       //   total_apres_remise=Double.parseDouble(Total_Apres_Remise.getText());
       m_verse=0;
          total_apres_remise= total-remise;
           if(total_apres_remise>=m_verse) {nv_credit=dette+(total_apres_remise-m_verse); a_rendu=0;}
               else {if(dette==0){a_rendu=(m_verse-total_apres_remise);nv_credit=0;  }
               else{ a_rendu=0;nv_credit=Math.abs((m_verse-total_apres_remise)-dette);}
               }
      
          Ancien_credit.setText(tn.Afficher2Verguile(ListClient.get(position).getCrédit()));
          VenteComptoir4.nvcredit.setText(tn.Afficher2Verguile(nv_credit));
          VenteComptoir4.dette=ListClient.get(position).getCrédit();
          
         A_rendu.setText(tn.Afficher2Verguile(a_rendu));
         nvcredit.setText(tn.Afficher2Verguile(nv_credit)); 
  VenteComptoir4.Total_Apres_Remise.setText(tn.Afficher2Verguile(total_apres_remise));
    
  //   System.out.println("m_verse1="+m_verse);
     // System.out.println("total_apres_remise1="+total_apres_remise);
  //    System.out.println("dette1="+dette);
    }else {VenteComptoir4.f2=ListClient.get(position);
         VenteComptoir4.nom_client.setText(ListClient.get(position).getNom_prénom_client());
         VenteComptoir4.dette2=ListClient.get(position).getCrédit();
           montant_verser.setText(tn.Afficher2Verguile(0));
       m_verse2= 0;
         // total_apres_remise2=Double.parseDouble(Total_Apres_Remise.getText());
          total_apres_remise2= total2-remise2;
           if(total_apres_remise2>=m_verse2) {nv_credit2=dette2+(total_apres_remise2-m_verse2); a_rendu2=0;}
               else {if(dette2==0){a_rendu2=(m_verse2-total_apres_remise2);nv_credit2=0;  }
               else{ a_rendu2=0;nv_credit2=Math.abs((m_verse2-total_apres_remise2)-dette2);}
               }
      
      
          Ancien_credit.setText(tn.Afficher2Verguile(ListClient.get(position).getCrédit()));
          VenteComptoir4.nvcredit.setText(tn.Afficher2Verguile(nv_credit2));
          VenteComptoir4.dette2=ListClient.get(position).getCrédit();
          
         A_rendu.setText(tn.Afficher2Verguile(a_rendu2));
         nvcredit.setText(tn.Afficher2Verguile(nv_credit2));
      VenteComptoir4.Total_Apres_Remise.setText(tn.Afficher2Verguile(total_apres_remise2));
    }
        
    //  System.out.println("m_verse2="+m_verse2);
    // // System.out.println("total_apres_remise2="+total_apres_remise2);
    //  System.out.println("dette2="+dette2);
         } catch (Exception ex) {
        Logger.getLogger(RechercherClient.class.getName()).log(Level.SEVERE, null, ex);
    }
         }
   jButton1.setVisible(false);



}



}

