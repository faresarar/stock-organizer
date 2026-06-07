/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.DateFormater;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import model.Client;

import model.Paramaitre;
import model.Produit;
import model.Vente;
import static vue.VenteComptoir4.ListBouton;

import static vue.VenteComptoir4.ListPr;
import static vue.VenteComptoir4.ListPr2;


import static vue.VenteComptoir4.pop;


import static vue.VenteComptoir4.date_vente;

import static vue.VenteComptoir4.ListProduitQuantitéAcheteAvantMod;
import static vue.VenteComptoir4.ListProduitQuantité;

import static vue.VenteComptoir4.row;


import static vue.VenteComptoir4.ListProduitQuantité2;
import static vue.VenteComptoir4.row2;


//import static vue.NewAchat.Total_a_payer1;
import static vue.VenteComptoir4.Total;

import static vue.VenteComptoir4.dette;
import static vue.VenteComptoir4.montant_verser;
import static vue.VenteComptoir4.total;
import static vue.VenteComptoir4.f;

import static vue.VenteComptoir4.dette2;
import static vue.VenteComptoir4.total2;
import static vue.VenteComptoir4.f2;

import static vue.VenteComptoir4.nv_credit;
import static vue.VenteComptoir4.total_apres_remise;

import static vue.VenteComptoir4.nv_credit2;
import static vue.VenteComptoir4.total_apres_remise2;

import static vue.VenteComptoir4.TableVente;

import static vue.VenteComptoir4.nvcredit;


import static vue.VenteComptoir4.ListPrFavorite;
//import static vue.VenteComptoir4.ListPrintBon;
import static vue.VenteComptoir4.ListVente;
import static vue.VenteComptoir4.ListVente2;
//import static vue.VenteComptoir4.idf;
import static vue.VenteComptoir4.m_verse;
import static vue.VenteComptoir4.num_bon;
import static vue.VenteComptoir4.remise;

import static vue.VenteComptoir4.m_verse2;
import static vue.VenteComptoir4.num_bon2;
import static vue.VenteComptoir4.remise2;

import static vue.VenteComptoir4.numClient;
import static vue.VenteComptoir4.Total_Apres_Remise;

/**
 *
 * @author Rais
 */
public class RechercherProduitVendre extends javax.swing.JDialog implements KeyListener {
static public ArrayList<Produit> ListProduit;   
static public ArrayList<Produit> ListProduit2;  
Produit_op op= Produit_op.getInstance();
TextNumber tnb= TextNumber.getObj();  
NumberFormat formatter = new DecimalFormat("#0.00");  
 
DateFormater dff=new DateFormater();
String s="";
char px='D',px2='D';
double prix=0,prix2=0;
float qte=0,qte2=0;
int ps=0;
//double total=0;
 Paramaitres_op parop=new Paramaitres_op();
 public static  Paramaitre par ;
//Achat_op aop=new Achat_op();
// ImageIcon   img = new ImageIcon("images/gs.png");
 ImageIcon   img2 = new ImageIcon("images/erreur.gif");
 boolean exist=false;
 int pos=0;
 int position=0; 
 Tools tools=Tools.getInstance();
 //int position2=0; 
//String currentUser=null;
    /**
     * Creates new form RechercherProduit
     */
  private static RechercherProduitVendre obj=null;
  public static RechercherProduitVendre getObj(char type,String user,int b){
        if(obj==null){
            try {
         obj=new RechercherProduitVendre( type, user, b);
            } catch (Exception ex) {
                Logger.getLogger(RechercherProduitVendre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
 
    public RechercherProduitVendre(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextField1.addKeyListener(this);
    }

     public RechercherProduitVendre(char type,String user,int b) {
      px=type;
      ps=b;
        initComponents();
          this.setIconImage(tools.getImageIcone().getImage());
           jTable2.setRowHeight(30);
           JTableHeader tableHeader = jTable2.getTableHeader();
            jTable2.getTableHeader().setOpaque(false);
      tableHeader.setBackground(Color.BLACK);
     tableHeader.setForeground(Color.black);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
      tableHeader.setFont(headerFont);
    try {
        par=parop.get_Paramaitre();
    } catch (Exception ex) {
        Logger.getLogger(RechercherProduitVendre.class.getName()).log(Level.SEVERE, null, ex);
    }
       // currentUser=user;
         try {ListProduit=pop.getList_Produit("","","désignation");
         ListProduit2=ListProduit;
        // System.out.println(ListProduit.size());
        op.displayResult2(ListProduit,jTable2);
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

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des produits");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Désignation");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("sélectionner");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(279, 64));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Liste des Produits");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "catégorie du produit ", "Etat ", "Marque", "désignation", "date d'achat", "prix achat ", "prix vente", "Catégorie de la pièce", "N° de série ", "Code barre", "Quantité en stock", "remarque"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 393, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(379, 379, 379)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // TextNumber tnb=new TextNumber(); 
    position=jTable2.getSelectedRow();
   
         if(position==-1)JOptionPane.showMessageDialog(null, " Veuiller sélectionner un produit ","",JOptionPane.INFORMATION_MESSAGE,img2);

         else{ //Produit pp=ListProduit.get(position);
             if(px=='f'){
           try {    pop.ModifierFavorite(ListProduit.get(position).getId_produit(), ps);
          if(ListPrFavorite.get(ps-1)!=null)  pop.ModifierFavorite(ListPrFavorite.get(ps-1).getId_produit(), 0);
                 //  ListIDFavorite.set(ps-1, ListProduit.get(position).getId_produit());
                     ListPrFavorite.set(ps-1, ListProduit.get(position));
               
               ListBouton.get(ps-1).setText(ListProduit.get(position).getDésignation());
               ListBouton.get(ps-1).setFont(new java.awt.Font("Tahoma", 1, 14));
                 ListBouton.get(ps-1).setBackground(new Color(255, 255, 225));
              // pop.ModifierFavorite(ListProduit.get(position).getId_produit(), true);
           } catch (Exception ex) {
               System.out.println("Exception favorite");
           }
         }
             
             
             else {
if(numClient==1)  validerProduit( ListPr,ListProduit, prix, ListProduitQuantité, ListVente,f, m_verse, remise, num_bon, px, qte, total, total_apres_remise, nv_credit, dette, row);           
else validerProduit( ListPr2,ListProduit2, prix2, ListProduitQuantité2, ListVente2,f2, m_verse2, remise2, num_bon2, px2, qte2, total2, total_apres_remise2, nv_credit2, dette2, row2);           
             }
   
     
         }
       obj=null;
      
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
              String param2=jTextField1.getText().trim();
        try {ListProduit=op.getList_Produit("",param2,"désignation");
       //  System.out.println(ListProduit.size());
        op.displayResult2(ListProduit,jTable2);
    } catch (Exception ex) {
        Logger.getLogger(GestionProduit.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // if(evt.getKeyChar()==KeyEvent.VK_ENTER)System.out.println("enter pressed");
    }//GEN-LAST:event_jButton1KeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
   obj=null;
      
      ListProduit.clear();
        this.dispose();
      //  VenteComptoir4.g
      
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
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
   if(ke.paramString().contains("Enter"))
  jTextField1.setText(s);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  void validerProduit(ArrayList<Produit> ListPr_,ArrayList<Produit> ListProduit_,double prix_,List<Float> ListProduitQuantité_,ArrayList<Vente> ListVente_,Client f_,double m_verse_,double remise_,int num_bon_,char px_,float qte_,double total_,double total_apres_remise_,double nv_credit_,double dette_,int row_){
       for(int i=0;i<ListPr_.size();i++){if(ListPr_.get(i).getId_produit()==ListProduit_.get(position).getId_produit())
        {  
            pos=i;
            exist=true;break;}
            }
       if (!exist){
           
           ListPr_.add(ListProduit_.get(position));
           ListProduitQuantitéAcheteAvantMod.add((float)0);
           switch(px_){
               case 'D':prix_=ListProduit_.get(position).getPrix_vente_detail();qte_=1;break;
               case 'G':prix_=ListProduit_.get(position).getPrix_vente_gros();qte_=1;break;
               default:prix_=ListProduit_.get(position).getPrix_special();qte_=1;break;
       }
       
  
       ListProduitQuantité_.add((float)qte_);
        ListVente_.add(new Vente(date_vente,f_.getNom_prénom_client(),ListProduit_.get(position).getTva(),ListProduit_.get(position).getDésignation(),
           ListProduit_.get(position).getPrix_achat(), prix_, 1,0,0,
                DateFormat.getTimeInstance().format(new Date()),
                Aucceuil.userName, ListProduit_.get(position).getId_produit(),f_.getId_c(), m_verse_,remise_,num_bon_,0,"","valide"));

       }
       else {
           switch(px_){
               case 'D':prix_=ListProduit_.get(position).getPrix_vente_detail();qte_=1;break;
               case 'G':prix_=ListProduit_.get(position).getPrix_vente_gros();qte_=1;break;
               default:prix_=ListProduit_.get(position).getPrix_special();qte_=1;break;
           }
           
        ListProduitQuantité_.set(pos, ListProduitQuantité_.get(pos)+qte_);
       ListVente_.get(pos).setQuantité_vente(ListVente_.get(pos).getQuantité_vente()+qte_);
       
       }

            try{  total_=0;
         for (int i=0 ;i< ListProduitQuantité_.size();i++) 
                            total_=total_+(ListProduitQuantité_.get(i)*ListVente_.get(i).getPrix_vente());
         
                         Total.setText( tnb.Afficher2Verguile(total_));
                        
                        Total_Apres_Remise.setText(tnb.Afficher2Verguile(total_-remise_));
                   // m_verse_=Double.parseDouble(montant_verser.getText());
               if(numClient==1){
              total_apres_remise_=Double.parseDouble(Total_Apres_Remise.getText());
            m_verse_= Double.parseDouble(montant_verser.getText());
                 nv_credit_=dette_+(total_apres_remise_-m_verse_);
                 nvcredit.setText(tnb.Afficher2Verguile(nv_credit_)); 
                 
                 total_apres_remise=total_apres_remise_;
                 m_verse  =m_verse_ ;
                 nv_credit=nv_credit_;
                 dette=dette_;
                 total=total_;
               }      
               else {
              total_apres_remise_=Double.parseDouble(Total_Apres_Remise.getText());
            m_verse_= Double.parseDouble(montant_verser.getText());
                 nv_credit_=dette_+(total_apres_remise_-m_verse_);
                 nvcredit.setText(tnb.Afficher2Verguile(nv_credit_));  
                  total_apres_remise2=total_apres_remise_;
                 m_verse2  =m_verse_ ;
                 nv_credit2=nv_credit_;
                 dette2=dette_;
                  total2=total_;
               }      
                     
                       }  
           catch (Exception ex){
               Total.setText( total_+"");
           }
   
                 try {
                   
                     pop.displayResult4(ListPr_, TableVente,px_,ListProduitQuantité_);
                 } catch (Exception ex) {
                     Logger.getLogger(RechercherProduitVendre.class.getName()).log(Level.SEVERE, null, ex);
                 }
   row_=ListPr_.size()-1;
  
  
  }  
    
    
}
