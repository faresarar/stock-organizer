/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.BoutonColor;
import controler.Categorie_depence_op;
import controler.DateFormater;
import controler.Dépense_op;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import model.Dépense;
import model.Paramaitre;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import raven.javaswingdev.MessageDialog;




/**
 *
 * @author pc
 */
public class GestionDepense1 extends javax.swing.JFrame {

public static Dépense_op dop= Dépense_op.getInstance();
 public static Categorie_depence_op opd= Categorie_depence_op.getInstance();
 public static ArrayList<Dépense> ListDepence =new ArrayList<>();
 Dépense d;
 TextNumber tn= TextNumber.getObj();
 double Total=0;
 String depence;
 double montant=0;
 BoutonColor bc= BoutonColor.getInstance();        
 
// ImageIcon   img = new ImageIcon("images/gs.png");
 
//static Pertes_op iop=Pertes_op.getInstance();
 //static TypePerte_op tpop=TypePerte_op.getInstance();
//public static ArrayList<Float> ListProduitQuantité = new ArrayList<>();

 
// ImageIcon   img1 = new ImageIcon("images/accept.png");
 //ImageIcon   img2 = new ImageIcon("images/warning.png");
 String par="";
 int t=4;
 double m;
 double remise=0;
 int row=0;

 String date;
 String mois;
 int Annee;
 Paramaitre p; 
 Produit_op pop=Produit_op.getInstance();
 Paramaitres_op paop= Paramaitres_op.getInstance();
 DateFormater dff=new DateFormater();
 
 //public static ArrayList<Perte> ListBon =new ArrayList<>();  
// JasperPrint print1;
 //JasperFillManager jfm;
// Map   para = new HashMap();
 String utilisateur;


 //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListBon);
 private static GestionDepense1 obj=null;
 int n=0;  
 Tools tools=Tools.getInstance();
 // Message me = new Message(this, true,"/images/stop.png","Veuiller entrer une année !","",Color.red); 
 // Message mvide = new Message(this, true,"/images/stop.png","Veuiller sélectionner une perte","",Color.red);
    /**
     * Creates new form ListeAchat
     */

    public static GestionDepense1 getObj(){
        if(obj==null){
            try {
         obj=new GestionDepense1();
            } catch (Exception ex) {
                Logger.getLogger(GestionDepense1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
     
  
    private GestionDepense1(  ) {
    initComponents();
    //  utilisateur=user;
    this.setIconImage(tools.getImageIcone().getImage());
    jTableDepenses.setRowHeight(30);
    JTableHeader tableHeader1 = jTableDepenses.getTableHeader();
    jTableDepenses.getTableHeader().setOpaque(false);
              
   // tableHeader1.setBackground(Color.BLACK);
    tableHeader1.setForeground(Color.black);
   
    Font headerFont = new Font("Verdana", Font.PLAIN, 14);
    tableHeader1.setFont(headerFont);
     //  tableHeader2.setFont(headerFont);
   date=java.time.LocalDate.now()+"";
     jTableDepenses.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
             row = table.rowAtPoint(p);
           // if (me.getClickCount() ==1) {
             //   try {ListAchat.clear();
                   //  System.out.println("row="+row);
             //    if(!ListBonAchat.isEmpty())   ListAchat=aop.getList_Achat(ListBonAchat.get(row).getNum_bon_réception());
                  //   System.out.println("liste vente size="+ListAchat.size());
             //   } catch (Exception ex) {
              //      Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
              //  }
         // aop.displayResult1(ListAchat,jTable2);
         //   System.out.println("row="+row);
            // System.out.println("column="+table.columnAtPoint(p));
           // }
        }
    });
    bc.ColorerBouton(jButtonAjouter,  new Color(41,134,10));
     //bc.ColorerBouton(jButtonModifier,  new Color(1, 101, 225));
      bc.ColorerBouton(jButtonSupp, Color.red);
        bc.ColorerBouton(jButtonPrint,new Color(102,102,102));
        
    try {   
        p=paop.get_Paramaitre();
      ListDepence=  dop.getList_depence();
       dop.displayResult(ListDepence, jTableDepenses);
       Total=dop.GetTotal(ListDepence);
        TotalText.setText(tn.Afficher2Verguile(Total)+"");
       
    } catch (Exception ex) {
        Logger.getLogger(GestionDepense1.class.getName()).log(Level.SEVERE, null, ex);
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
        jButtonPrint = new javax.swing.JButton();
        jButtonAjouter = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Rechercher = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AnneeText = new com.jkelany.jktextfield.numeric.JKNumericField();
        jLabel2 = new javax.swing.JLabel();
        MoisItem = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableDepenses = new javax.swing.JTable();
        jButtonSupp = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TotalText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des achats");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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

        jButtonAjouter.setBackground(new java.awt.Color(51, 255, 0));
        jButtonAjouter.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonAjouter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Rechercher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com(3).png"))); // NOI18N
        Rechercher.setText("Rechercher");
        Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercherActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Année:");

        AnneeText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        AnneeText.setText("2024");
        AnneeText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("mois:");

        MoisItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MoisItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "janvier", "février", "mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre" }));
        MoisItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoisItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(AnneeText, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MoisItem, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rechercher)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnneeText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MoisItem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(259, 64));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Liste des Depenses");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        jTableDepenses.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTableDepenses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N° de  perte", "date", "heure", "Type de perte", "Désignation", "Quantité", "Prix d'achat", "Observation", "Utilisateur"
            }
        ));
        jScrollPane2.setViewportView(jTableDepenses);

        jButtonSupp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSupp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSupp.setText("Supprimer");
        jButtonSupp.setPreferredSize(new java.awt.Dimension(179, 42));
        jButtonSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Total :");

        TotalText.setBackground(new java.awt.Color(255, 255, 204));
        TotalText.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        TotalText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalText.setText("0.00 da");
        TotalText.setToolTipText("");
        TotalText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(407, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalText, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TotalText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
  AjouterDepense.getObj().setVisible(true);
  this.setVisible(false);
 
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
     try {
         jTableDepenses.print();
     } catch (PrinterException ex) {
         Logger.getLogger(GestionDepense1.class.getName()).log(Level.SEVERE, null, ex);
     }
         
         
       
   
     
     
 
    
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButtonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppActionPerformed
        int position=jTableDepenses.getSelectedRow(); 
         if(position==-1||ListDepence.isEmpty())tools.ShowFailMessage(this, "Veullez seléctionner une dépense");
             
             //JOptionPane.showMessageDialog(null, " Veuiller sélectionner une perte ","",JOptionPane.INFORMATION_MESSAGE,img2);
        // else   if(ListBon.isEmpty())JOptionPane.showMessageDialog(null, " Veuiller sélectionner un Bon  ","",JOptionPane.INFORMATION_MESSAGE,img2);
         else{
      
           //  int  result =JOptionPane.showConfirmDialog(null,"Voulez vous supprimer cette perte ?","",JOptionPane.YES_NO_OPTION);
           
            if(tools.ShowConfirmMessage("voulez vous supprimer cette Dépense ?", "", this)==MessageDialog.MessageType.OK){
                 try {      
                    // pr=ListDepence.get(position);
                dop.sup_depence(ListDepence.get(position).getId());
                try{ListDepence.remove(position);}catch(Exception e){}
                  Total=dop.GetTotal(ListDepence);
                 TotalText.setText(tn.Afficher2Verguile(Total)+"");
        //       try{ ListBon.remove(position);}catch(Exception e){}
            
                 } catch (Exception ex) {
                    // System.out.println("sup exeception");
                     Logger.getLogger(GestionDepense1.class.getName()).log(Level.SEVERE, null, ex);
              
                 }
                 try {
                     dop.displayResult(ListDepence, jTableDepenses);
                 } catch (Exception ex) {
                     Logger.getLogger(GestionDepense1.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
                   //   JOptionPane.showMessageDialog(null, " Bien Supprimer ","",JOptionPane.INFORMATION_MESSAGE,img1); 
                   tools.ShowGoodMessage(this, "Bien supprimer");
               
                 }
       
         }
    }//GEN-LAST:event_jButtonSuppActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    obj=null;
    this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercherActionPerformed
try{    Annee=Integer.parseInt(AnneeText.getText());
        //String m=mois.getSelectedItem().toString();
         mois=MoisItem.getSelectedItem().toString();
       //   System.out.println("mois="+mois);
}catch(Exception e){
    AnneeText.setText("2025");
}
         if((Annee<=0)||(mois==null))tools.ShowFailMessage(obj, "Veuiller entrer une année !");
         else {
           try {
               ListDepence.clear();
               ListDepence=  dop.getList_depence(Annee,mois);
             //   System.out.println("ListInv size="+ListInv.size()+date1+date2);
                dop.displayResult(ListDepence, jTableDepenses);
                  Total=dop.GetTotal(ListDepence);
                   TotalText.setText(Total+"");
              
            } catch (Exception ex) {
                Logger.getLogger(GestionDepense1.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
    }//GEN-LAST:event_RechercherActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
    }//GEN-LAST:event_formWindowOpened

    private void MoisItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoisItemActionPerformed

    }//GEN-LAST:event_MoisItemActionPerformed
private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }


  void init( ){
  // annee.setText(0+"");
    //mois.setSelectedIndex(month);
   //electricite.setText(0+"");
   
   // mont.setText(0+"");
   
    TotalText.setText(0+"");
    
    
     Total=0;
  //mont=0;
        
            }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jkelany.jktextfield.numeric.JKNumericField AnneeText;
    private javax.swing.JComboBox<String> MoisItem;
    private javax.swing.JButton Rechercher;
    public static javax.swing.JLabel TotalText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSupp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTableDepenses;
    // End of variables declaration//GEN-END:variables
}
