/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.Achat_op;
import controler.BoutonColor;
import controler.DateFormater;
import controler.Fournisseur_op;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import controler.Versement_fournisseur;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import model.Achat;
import model.Paramaitre;
import model.PrintReportBonReception;
import model.Produit;
import raven.javaswingdev.MessageDialog;




/**
 *
 * @author pc
 */
public class ListeAchat extends javax.swing.JFrame {
static Achat_op aop= Achat_op.getInstance();
Produit_op pop= Produit_op.getInstance();
Fournisseur_op fop=Fournisseur_op.getObj();
Paramaitres_op paop= Paramaitres_op.getInstance();
Versement_fournisseur vco= Versement_fournisseur.getObj();
DateFormater df=new DateFormater();
TextNumber tn= TextNumber.getObj();
 BoutonColor bc= BoutonColor.getInstance();
public static ArrayList<Float> ListProduitQuantité = new ArrayList<>();
Tools tools=Tools.getInstance();
// ImageIcon   img = new ImageIcon("images/gs.png");
 // ImageIcon   img1 = new ImageIcon("images/accept.png");
// ImageIcon   img2 = new ImageIcon("images/warning.png");
 String par="";
 int t=4;
 double m;
 double remise=0;
 int row=0;
 double total=0;
 String date1,date2,date;
 DateFormater dff=new DateFormater();
 TextNumber tnb= TextNumber.getObj(); 
 public static ArrayList<Achat> ListAchat =new ArrayList<>();  
  static ArrayList<Achat> ListBon =new ArrayList<>(); 
 public ArrayList<Produit> ListPr =new ArrayList<>();  
 public ArrayList<Double> ListPrixAch =new ArrayList<>();  
 //public static   ArrayList<Achat> ListBonAchat =new ArrayList<>();  
 public   ArrayList<PrintReportBonReception> ListPrintBonLivraison =new ArrayList<>();  
  //Paramaitre pa=null;
  Paramaitre p ;
   private static ListeAchat obj=null;
   
   
    /**
     * Creates new form ListeAchat
     */
/*  public static ListeAchat getObj(){
    try {//ListBonAchat.clear();
        //ListBonAchat=aop.getListBonAchat();
       // aop.displayBonAchat(ListBonAchat, jTable1);
     //   ListAchat.clear();
       // aop.displayResult1(ListAchat,jTable2);
    } catch (Exception ex) {
        Logger.getLogger(ListeAchat.class.getName()).log(Level.SEVERE, null, ex);
    }
        if(obj==null){
            try {
         obj=new ListeAchat();
            } catch (Exception ex) {
                Logger.getLogger(ListeAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
  */
    public static ListeAchat getObj(){
      
          ListBon.clear();
          if(obj==null){
            try {
        
         obj=new ListeAchat();
            } catch (Exception ex) {
                Logger.getLogger(ListeAchat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
     
  
    private ListeAchat() {
        initComponents();
     this.setIconImage(tools.getImageIcone().getImage());
        jButtonModifier.setVisible(false);
         jTable1.setRowHeight(30);
       //  jTable2.setRowHeight(30);
         
           JTableHeader tableHeader1 = jTable1.getTableHeader();
           // JTableHeader tableHeader2 = jTable2.getTableHeader();
           
          //  jTable2.getTableHeader().setOpaque(false);
              jTable1.getTableHeader().setOpaque(false);
              
      tableHeader1.setBackground(Color.BLACK);
     tableHeader1.setForeground(Color.black);
     
     // tableHeader2.setBackground(Color.BLACK);
    // tableHeader2.setForeground(Color.white);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader1.setFont(headerFont);
     //  tableHeader2.setFont(headerFont);
      
       
       
    try { Paramaitres_op paop=new Paramaitres_op();
        p=paop.get_Paramaitre();
    
      ListBon=aop.getList_bon();
       
        aop.displayBonAchat(ListBon, jTable1);
   
    } catch (Exception ex) {
//        Logger.getLogger(ListeVente.class.getName()).log(Level.SEVERE, null, ex);
    }
     
   date=java.time.LocalDate.now()+"";
     jTable1.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
             row = table.rowAtPoint(p);
          
        }
    });
    bc.ColorerBouton(jButtonModifier,  new Color(1, 101, 225));
      bc.ColorerBouton(jButtonSupp, Color.red);
        bc.ColorerBouton(jButtonPrint, new Color(102,102,102));
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
        jButtonPrint = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        num_bon = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButtonSupp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des achats");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButtonPrint.setBackground(new java.awt.Color(255, 255, 0));
        jButtonPrint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonPrint.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrint.setText("Imprimer ");
        jButtonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintActionPerformed(evt);
            }
        });

        jButtonModifier.setBackground(new java.awt.Color(51, 255, 0));
        jButtonModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonModifier.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModifier.setText("Modifier ");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Num Bon Achat");

        num_bon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        num_bon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        org.jdesktop.swingx.border.IconBorder iconBorder1 = new org.jdesktop.swingx.border.IconBorder();
        iconBorder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search1.png"))); // NOI18N
        num_bon.setBorder(iconBorder1);
        num_bon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                num_bonKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                num_bonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(num_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(num_bon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(256, 64));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Liste des Achats");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "num de bon de livrason", "client", "date"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Liste des bon de d'achat");

        jButtonSupp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSupp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSupp.setText("Supprimer");
        jButtonSupp.setPreferredSize(new java.awt.Dimension(179, 42));
        jButtonSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1167, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSupp, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
  // System.out.println("selected row="+jTable1.getSelectedRow());
 /* total=0;
    if(jTable1.getSelectedRow()==-1)
        tools.ShowFailMessage(this, "Veuiller sélectionner un bon d'achat");
    //    JOptionPane.showMessageDialog(null, " Veuiller sélectionner un bon d'achat  ","",JOptionPane.INFORMATION_MESSAGE,img2);
       else {
        if(!ListBon.isEmpty()){
       
     
        try {
      //   Dette_fournisseur_op ccop=new Dette_fournisseur_op();
        // Fournisseur f=new Fournisseur();
         
       //  f=fop.getFournisseur(WIDTH);
         ListAchat.clear();
         ListAchat=aop.getList_Achat(ListBon.get(row).getNum_bon_réception());
        int idf=ListBon.get(row).getIdf();
  //  String nom_fournisseur=ListBon.get(row).getNom_prénom_fournisseur();
    ListProduitQuantité.clear();
    ListPr.clear();
   System.out.println("list achat size="+ListAchat.size());
   try{ ListPr=aop.getList_produit(ListBon.get(row).getNum_bon_réception());}catch(Exception e){}
     for (int i=0;i<ListPr.size();i++){
     ListProduitQuantité.add(ListPr.get(i).getQuantité());
  
     
    // System.out.println("list produit size="+ListPr.size());
    //   System.out.println("id pro="+ListPr.get(i).getId_produit());
     ListPrixAch.add(ListPr.get(i).getPrix_achat());
     total=total+(ListPr.get(i).getQuantité()*ListPr.get(i).getPrix_achat());
    ListPr.get(i).setQuantité(pop.QuantitéEnStock(ListPr.get(i).getDésignation()));
      
 /*PrintReportBonReception prb=   new PrintReportBonReception (p.getNom_magasin(),p.getAdresse(),p.getNum_tel_fax_fix(),p.getNum_tel1(),p.getNum_tel2(),ListAchat.get(i).getNum_bon_réception(),
         ListAchat.get(i).getNom_prénom_fournisseur(),
         ListAchat.get(i).getDésignation(),ListAchat.get(i).getPrix_achat(),ListAchat.get(i).getQuantité(),0,0);
 ListPrintBonLivraison.add(prb);*/
        
   //  System.out.println("ListPr ++++="+ListPr.size());
         //  System.out.println( "id rproduit="+  ListPr.get(i).getId_produit());
   //  }
    
       //  System.out.println("ListProduitQuantité size="+ListProduitQuantité.size());
     //   new NewAchat(fop.getFournisseur(idf),ListAchat,ListProduitQuantité,ListPr,total).setVisible(true);
     //   this.dispose();
  //  } catch (Exception ex) {
        // Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
   // }
      //  }                    }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void num_bonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num_bonKeyReleased
      
         int n=0;
        
           try {
               try{n=Integer.parseInt(num_bon.getText().trim());
               
               
               }catch(Exception e){
            //   System.out.println("n="+n);
               }
               if(n==0)  ListBon=  aop.getList_bon();
           else ListBon=  aop.getList_bon(n);
            aop.displayBonAchat(ListBon, jTable1);
        } catch (Exception ex) {
          //  Logger.getLogger(ListeVente.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* if(jDatePicker1.getModel().getValue()==null||jDatePicker2.getModel().getValue()==null)JOptionPane.showMessageDialog(null, " veuiller sélectionner les dates  ","",JOptionPane.INFORMATION_MESSAGE,img);
        else {
            // String date1=df.FormaterDate((Calendar)jDatePicker1.getModel().getValue());
            //   String date2=df.FormaterDate((Calendar)jDatePicker2.getModel().getValue());

            try {
                ListAchat=  aop.getList_Achat(par, t,date1,date2);
                aop.displayResult(ListAchat, jTable1);
            } catch (Exception ex) {
                Logger.getLogger(ListeVente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }*/
    }//GEN-LAST:event_num_bonKeyReleased

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
    int position = jTable1.getSelectedRow();
 if(position==-1)
     tools.ShowFailMessage(this, "Veuiller sélectionner un bon d'achat");
     //JOptionPane.showMessageDialog(null, " Veuiller sélectionner un bon d'achat  ","",JOptionPane.INFORMATION_MESSAGE,img2);
        
     
        
       
     
 else {
      try {
        ListAchat=aop.getList_Achat(ListBon.get(row).getNum_bon_réception());
    } catch (Exception ex) {
        Logger.getLogger(ListeAchat.class.getName()).log(Level.SEVERE, null, ex);
    }      
         
          if(!ListAchat.isEmpty()){
    try {ListPrintBonLivraison.clear();
      
   
        p=paop.get_Paramaitre();
   
        for (int i=0;i<ListAchat.size();i++){
      
 PrintReportBonReception prb=   new PrintReportBonReception (p.getNom_magasin(),p.getAdresse_p(),p.getNum_tel_fax_fix_p(),p.getNum_tel1_p(),p.getNum_tel2_p(),ListAchat.get(i).getNum_bon_réception(),
         ListAchat.get(i).getNom_prénom_fournisseur(),
         ListAchat.get(i).getDésignation(),ListAchat.get(i).getPrix_achat(),ListAchat.get(i).getQuantité(),0,0);
 ListPrintBonLivraison.add(prb);
        }
    } catch (Exception ex) {
 //        Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
    }
     
      reportsengine.ReportsManager.getInstance().showReport("bon_reception.jasper", new Hashtable(), "Bon d'achat",ListPrintBonLivraison);
 }
    }
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void num_bonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num_bonKeyPressed
         tn.numOnly(num_bon);
    }//GEN-LAST:event_num_bonKeyPressed

    private void jButtonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppActionPerformed
        int position=jTable1.getSelectedRow(); 
         if(position==-1)
             tools.ShowFailMessage(this, "Veuiller sélectionner un Bon ");
         //    JOptionPane.showMessageDialog(null, " Veuiller sélectionner un Bon  ","",JOptionPane.INFORMATION_MESSAGE,img2);
         else   if(ListBon.isEmpty())
            tools.ShowFailMessage(this, "Veuiller sélectionner un Bon ");
         else{
      
            // int  result =JOptionPane.showConfirmDialog(null,"Voulez vous supprimer  ce bon d'achat ?","",JOptionPane.YES_NO_OPTION);
            if(tools.ShowConfirmMessage("Voulez vous supprimer  ce bon d'achat ?", "", this)==MessageDialog.MessageType.OK){
                 try {
                       ListPr=aop.getList_produit(ListBon.get(row).getNum_bon_réception());
                      // System.out.println("list bon size="+ListBon+" "+ListPr.size());
                       for(int i=0;i<ListPr.size();i++){
                       try{ float quantite=pop.Quantité(ListPr.get(i).getId_produit())  -ListPr.get(i).getQuantité();
                         pop.ModifierQuantite(quantite, ListPr.get(i).getId_produit());
                       }catch(Exception e){}
                                                       }
                aop.sup_Achat1(ListBon.get(position).getNum_bon_réception());
                vco.modifier_etat_versement(ListBon.get(position).getNum_bon_réception(), "Annuler");
               
                  
                try{ListPrintBonLivraison.remove(position);}catch(Exception e){}
               try{ ListBon.remove(position);}catch(Exception e){}
              try{  ListPr.clear();}catch(Exception e){}
              try{  ListPrixAch.clear();}catch(Exception e){}
                
             
            
                  // System.out.println("list bon size="+ListBon.size());     
                 } catch (Exception ex) {
                    // System.out.println("sup exeception");
                     Logger.getLogger(ListeAchat.class.getName()).log(Level.SEVERE, null, ex);
              
                 }
                 try {
                     aop.displayBonAchat(ListBon, jTable1);
                 } catch (Exception ex) {
                     Logger.getLogger(ListeAchat.class.getName()).log(Level.SEVERE, null, ex);
                 }
                   //   JOptionPane.showMessageDialog(null, " Bien Supprimer ","",JOptionPane.INFORMATION_MESSAGE,img1); 
                   tools.ShowGoodMessage(this, "Bien supprimer");
         }
         }
    }//GEN-LAST:event_jButtonSuppActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    obj=null;
 //   ListBon.clear();
    
    this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSupp;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField num_bon;
    // End of variables declaration//GEN-END:variables
}
