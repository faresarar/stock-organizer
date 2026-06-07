/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.BoutonColor;
import controler.CheckField;
import controler.DateFormater;
import controler.Paramaitres_op;
import controler.Pertes_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import controler.TypePerte_op;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import model.Paramaitre;
import model.Perte;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import raven.javaswingdev.MessageDialog;




/**
 *
 * @author pc
 */
public class GestionPerte extends javax.swing.JFrame {

//Produit_op pop= Produit_op.getInstance();

//DateFormater df=new DateFormater();
 TextNumber tn= TextNumber.getObj();
 CheckField cf=CheckField.getInstance();
 BoutonColor bc= BoutonColor.getInstance();
static Pertes_op iop=Pertes_op.getInstance();
 static TypePerte_op tpop=TypePerte_op.getInstance();
//public static ArrayList<Float> ListProduitQuantité = new ArrayList<>();

// ImageIcon   img = new ImageIcon("images/gs.png");
// ImageIcon   img1 = new ImageIcon("images/accept.png");
 //ImageIcon   img2 = new ImageIcon("images/warning.png");
 String par="";
 int t=4;
 double m;
 double remise=0;
 int row=0;
 double total=0;
 String date;
 Date date1,date2;
 Paramaitre p; 
 Produit_op pop=Produit_op.getInstance();
 Paramaitres_op paop= Paramaitres_op.getInstance();
 DateFormater dff=new DateFormater();
 public static ArrayList<Perte> ListPerte =new ArrayList<>();  
 //public static ArrayList<Perte> ListBon =new ArrayList<>();  
// JasperPrint print1;
 //JasperFillManager jfm;
// Map   para = new HashMap();
 String utilisateur;
 Perte pr;

 //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListBon);
 private static GestionPerte obj=null;
 int n=0;  
 Tools tools=Tools.getInstance();
 // Message me = new Message(this, true,"/images/stop.png","Veuiller sélectionner les dates!","",Color.red); 
 // Message mvide = new Message(this, true,"/images/stop.png","Veuiller sélectionner une perte","",Color.red);
    /**
     * Creates new form ListeAchat
     */

    public static GestionPerte getObj(){
        if(obj==null){
            try {
         obj=new GestionPerte();
            } catch (Exception ex) {
                Logger.getLogger(GestionPerte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
     
  
    private GestionPerte(  ) {
    initComponents();
    //  utilisateur=user;
   this.setIconImage(tools.getImageIcone().getImage());
    jTablePerte.setRowHeight(30);
    JTableHeader tableHeader1 = jTablePerte.getTableHeader();
    jTablePerte.getTableHeader().setOpaque(false);
              
   // tableHeader1.setBackground(Color.BLACK);
    tableHeader1.setForeground(Color.BLACK);
   
    Font headerFont = new Font("Verdana", Font.PLAIN, 14);
    tableHeader1.setFont(headerFont);
     //  tableHeader2.setFont(headerFont);
   date=java.time.LocalDate.now()+"";
     jTablePerte.addMouseListener(new MouseAdapter() {
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
      ListPerte=  iop.getList_Perte();
       iop.displayResult(ListPerte, jTablePerte);
    } catch (Exception ex) {
        Logger.getLogger(GestionPerte.class.getName()).log(Level.SEVERE, null, ex);
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
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        Rechercher = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePerte = new javax.swing.JTable();
        jButtonSupp = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("du");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("au");

        Rechercher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com(3).png"))); // NOI18N
        Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Rechercher)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(259, 64));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Liste des Pertes");

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTablePerte.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTablePerte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTablePerte);

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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
  AjouterPerte.getObj().setVisible(true);
  this.setVisible(false);
 
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintActionPerformed
     try {
         jTablePerte.print();
     } catch (PrinterException ex) {
         Logger.getLogger(GestionPerte.class.getName()).log(Level.SEVERE, null, ex);
     }
         
         
       
   
     
     
 
    
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void jButtonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppActionPerformed
        int position=jTablePerte.getSelectedRow(); 
         if(position==-1||ListPerte.isEmpty())tools.ShowFailMessage(this, "Veullez seléctionner une perte");
             
             //JOptionPane.showMessageDialog(null, " Veuiller sélectionner une perte ","",JOptionPane.INFORMATION_MESSAGE,img2);
        // else   if(ListBon.isEmpty())JOptionPane.showMessageDialog(null, " Veuiller sélectionner un Bon  ","",JOptionPane.INFORMATION_MESSAGE,img2);
         else{
      
           //  int  result =JOptionPane.showConfirmDialog(null,"Voulez vous supprimer cette perte ?","",JOptionPane.YES_NO_OPTION);
           
            if(tools.ShowConfirmMessage("voulez vous supprimer cette perte ?", "", this)==MessageDialog.MessageType.OK){
                 try {      
                     pr=ListPerte.get(position);
                iop.sup_perte(ListPerte.get(position).getNum_perte());
                try{ListPerte.remove(position);}catch(Exception e){}
        //       try{ ListBon.remove(position);}catch(Exception e){}
            
                 } catch (Exception ex) {
                    // System.out.println("sup exeception");
                     Logger.getLogger(GestionPerte.class.getName()).log(Level.SEVERE, null, ex);
              
                 }
                 try {
                     iop.displayResult(ListPerte, jTablePerte);
                 } catch (Exception ex) {
                     Logger.getLogger(GestionPerte.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 
                 
                   //   JOptionPane.showMessageDialog(null, " Bien Supprimer ","",JOptionPane.INFORMATION_MESSAGE,img1); 
                   tools.ShowGoodMessage(this, "Bien supprimer");
                 if(tools.ShowConfirmMessage("Ce produit retourne au stock ?", "si vous cliquer sur ok la quantité du stock sera changer \n", this)==MessageDialog.MessageType.OK){
                     try {
                         pop.modifier_ProduitQuantité(pr.getId_produit(), pr.getQuantité()+pop.Quantité(pr.getId_produit()));
                     } catch (Exception ex) {
                         Logger.getLogger(GestionPerte.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
         }
         }
    }//GEN-LAST:event_jButtonSuppActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    obj=null;
    this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercherActionPerformed
try{      cf.CheckDate(jXDatePicker1);
           cf.CheckDate(jXDatePicker2);
    date1=new java.sql.Date(jXDatePicker1.getDate().getTime());
        date2=new java.sql.Date(jXDatePicker2.getDate().getTime());
}catch(Exception e){date1=null;date2=null;}
         if((date1==null)||(date2==null))tools.ShowFailMessage(obj, "Veuiller sélectionner les dates!");
         else {
           try {
               ListPerte=  iop.getList_Perte(date1,date2);
             //   System.out.println("ListInv size="+ListInv.size()+date1+date2);
                iop.displayResult(ListPerte, jTablePerte);
              
            } catch (Exception ex) {
                Logger.getLogger(GestionPerte.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
    }//GEN-LAST:event_RechercherActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
    }//GEN-LAST:event_formWindowOpened
private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Rechercher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSupp;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTablePerte;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    // End of variables declaration//GEN-END:variables
}
