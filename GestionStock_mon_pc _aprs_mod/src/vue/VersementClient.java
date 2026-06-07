/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.Caisse_op;
import controler.Client_op;
//import controler.Dette_fournisseur_op;

import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import controler.Vente_op;
import controler.Versement_client;
import model.Versement;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;

import java.util.Hashtable;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Caisse;
import model.Client;

import model.Paramaitre;
import model.Vente;
import static vue.ListeDesVentes.TableBon;
import static vue.ListeDesVentes.ListBon;


import static vue.RechercherClient.ListClient;
import static vue.RechercherClient.index;
import static vue.RechercherClient.jTable1;
import static vue.RechercherClient.Tcredit;
import static vue.RechercherClient.TotalCredit;




/**
 *
 * @author Rais
 */
public class VersementClient extends javax.swing.JFrame {
//ImageIcon   img = new ImageIcon("images/gs.png");
//ImageIcon   img1 = new ImageIcon("images/accept.png");
 private static VersementClient obj=null;
 Versement_client vf=Versement_client.getObj();
 NumberFormat formatter = new DecimalFormat("#0.00"); 
 //BoutonColor bc= BoutonColor.getInstance();
 Vente_op vop= Vente_op.getInstance();
String nom_f;
int id_f;
Tools t=Tools.getInstance();
int num_v=0;
double dette=0,c;
double MontantVerse=0;
double MontantTotal=0;
double nv_dette=0;
float nv_quantite=0;
Date date_versement=null;
String heure = "";
TextNumber tn= TextNumber.getObj();
public  ArrayList<Versement> ListVersement =new ArrayList<>(); 
public static  ArrayList<Vente> ListVente =new ArrayList<>();  
public static ArrayList<Caisse> ListCaisse =new ArrayList<>(); 
Paramaitres_op pop=Paramaitres_op.getInstance();
Produit_op prop= Produit_op.getInstance();
Versement_client vco= Versement_client.getObj();
Paramaitre p;
static Client fou=null;
static Caisse_op cop=Caisse_op.getInstance();
    /**
     * Creates new form 
     */


public static VersementClient getObj(Client f){
       
    if(obj==null){
            try {
               fou=f; 
          ListCaisse.clear();
          ListCaisse=cop.getList_Caisse();
         obj=new VersementClient(f);
            } catch (Exception ex) {
               
            }
        }return obj;
    }
  
    
    public static VersementClient getObj(Client f,double mountant,ArrayList<Vente> ListV){
       ListVente=ListV;
    if(obj==null){
            try {
               fou=f; 
         obj=new VersementClient(f,mountant, ListV);
            } catch (Exception ex) {
               
            }
        }return obj;
    }
   
    
private VersementClient(Client f){
    
   initComponents();
   nom_prenom_four_Text.setText(f.getNom_prénom_client());
   nom_f=f.getNom_prénom_client();
   id_f=f.getId_c();
   dette=f.getCrédit();
  
 //  c=crédit;
 
   //  date_vers.setText(java.time.LocalDate.now()+"");
     this.setIconImage(t.getImageIcone().getImage());
     
    
      DetteText.setText(formatter.format(dette).replace(',', '.')+"");
      NV_Dette_Text.setText(formatter.format(nv_dette).replace(',', '.')+"");
     // bc.ColorerBouton(Imrprimer,new Color(102,102,102));
     // bc.ColorerBouton(Valider,  new Color(41,134,10));
    try {
          for(int i=0;i<ListCaisse.size();i++)Caisse.addItem(ListCaisse.get(i).getNum()+"");
        p=pop.get_Paramaitre();
    } catch (Exception ex) {
        Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
    }
}

private VersementClient(Client f,double montant,ArrayList<Vente> ListVente){
    
   initComponents();
  // System.out.println("mantant verse="+MontantVerse);
   MontantTotal=montant;
   nom_prenom_four_Text.setText(f.getNom_prénom_client());
   nom_f=f.getNom_prénom_client();
   id_f=f.getId_c();
    
   dette=f.getCrédit();
    try {
        MontantText.setText(tn.Afficher2Verguile(montant));
        //  c=crédit;
    } catch (Exception ex) {
        Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
    }
 
   //  date_vers.setText(java.time.LocalDate.now()+"");
       this.setIconImage(t.getImageIcone().getImage());
     
    
      DetteText.setText(formatter.format(dette).replace(',', '.')+"");
      NV_Dette_Text.setText(formatter.format(nv_dette).replace(',', '.')+"");
//      bc.ColorerBouton(Imrprimer,new Color(102,102,102));
     // bc.ColorerBouton(Valider,  new Color(41,134,10));
    try {
        p=pop.get_Paramaitre();
    } catch (Exception ex) {
        Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        nom_prenom_four_Text = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Valider = new javax.swing.JButton();
        Imrprimer = new javax.swing.JButton();
        MontantText = new com.jkelany.jktextfield.numeric.JKNumericField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DetteText = new com.jkelany.jktextfield.numeric.JKNumericField();
        NV_Dette_Text = new com.jkelany.jktextfield.numeric.JKNumericField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RemarqueText = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        Caisse = new javax.swing.JComboBox<>();
        PayerCaisseCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Versement Client");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Client");

        nom_prenom_four_Text.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nom_prenom_four_Text.setForeground(new java.awt.Color(255, 0, 0));
        nom_prenom_four_Text.setText("nom et prénom du client");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Montant a verser");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Crédit");

        Valider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Valider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        Valider.setText("Confirmer");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });

        Imrprimer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Imrprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-impression-24.png"))); // NOI18N
        Imrprimer.setText("Confirmer et imprimer  ");
        Imrprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImrprimerActionPerformed(evt);
            }
        });

        MontantText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MontantText.setText("0");
        MontantText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MontantText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MontantTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MontantTextKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Remarque");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Nouveau crédit");

        DetteText.setEditable(false);
        DetteText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        DetteText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        NV_Dette_Text.setEditable(false);
        NV_Dette_Text.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NV_Dette_Text.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NV_Dette_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NV_Dette_TextActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(279, 64));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Versement Client");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        RemarqueText.setColumns(20);
        RemarqueText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        RemarqueText.setRows(5);
        jScrollPane1.setViewportView(RemarqueText);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Caisse de versement");

        Caisse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Caisse.setPreferredSize(new java.awt.Dimension(56, 28));

        PayerCaisseCheckBox.setText("Versement dans la caisse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Valider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(Imrprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NV_Dette_Text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nom_prenom_four_Text, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .addComponent(DetteText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MontantText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Caisse, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PayerCaisseCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nom_prenom_four_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DetteText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MontantText, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NV_Dette_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Caisse, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(PayerCaisseCheckBox))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Valider, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Imrprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
 ListVersement.clear();
 Valider();
 init();
    }//GEN-LAST:event_ValiderActionPerformed

    private void MontantTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MontantTextKeyPressed
       
    }//GEN-LAST:event_MontantTextKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        obj=null;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void MontantTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MontantTextKeyReleased
      try{ MontantVerse=Double.parseDouble(MontantText.getText());}catch(Exception e){MontantVerse=0;}
       try{ dette=Double.parseDouble(DetteText.getText());}catch(Exception e){dette=0;}
       
        try{   if(MontantTotal>0)  nv_dette=MontantTotal-(dette+MontantVerse);
      else nv_dette=dette-MontantVerse;}catch(Exception e){nv_dette=0;}
        
         
     DetteText.setText(formatter.format(dette).replace(',', '.')+"");
      NV_Dette_Text.setText(formatter.format(nv_dette).replace(',', '.')+"");
    }//GEN-LAST:event_MontantTextKeyReleased

    private void ImrprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImrprimerActionPerformed
   ListVersement.clear();
        try {
         num_v=  vf.GetNextNumVersement();
    } catch (Exception ex) {
        num_v=9999;
    }
        Valider();
       ListVersement.add(new Versement( nom_f,  id_f,  (date_versement),  MontantVerse,  "valider", num_v,  Aucceuil.userName, dette,  p.getNom_magasin(),  p.getAdresse_p(), p.getNum_tel_fax_fix_p(),  p.getNum_tel1_p(),  p.getNum_tel2_p(),  p.getActivite(),fou.getNum_tel1(),fou.getNum_tel2(),fou.getAdresse()));
       reportsengine.ReportsManager.getInstance().showReport("recu_client.jasper", new Hashtable(), "Reçu de versement  ",ListVersement);
         init();
    }//GEN-LAST:event_ImrprimerActionPerformed

    private void NV_Dette_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NV_Dette_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NV_Dette_TextActionPerformed
public void init(){
DetteText.setText("0");
MontantText.setText("0");
NV_Dette_Text.setText("0");
RemarqueText.setText("");
index=-1;
nom_f="";
date_versement=null;
id_f=0;
dette=0;
MontantVerse=0;
nv_dette=0;
fou=null;
obj=null;
this.dispose();
  // ListVersement.clear();
}
    /**
     * @param args the command line arguments
     */
   
public void Valider(){
       heure= DateFormat.getTimeInstance().format(new java.util.Date());
     //System.out.println("debut valider ");
try { MontantVerse= Double.parseDouble(MontantText.getText());  } catch (Exception ex) {MontantVerse=0;MontantText.setText("0");ex.printStackTrace();}
        try { 

   // SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
Date date = new Date(System.currentTimeMillis());
//System.out.println(formatter.format(date));

Client_op fou_op= Client_op.getInstance();
//LocalDateTime dateTime = LocalDateTime.now();
//DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//dateTime.format(form);
   
      // try{  date_versement = df1.format(date_versement.getDate());}catch(Exception e ){date_per=null;}
date_versement=date;
        Versement_client op= Versement_client.getObj();
      //   System.out.println("1234564789");
      if(MontantVerse>0){
        op.inserer_versement(new Versement(nom_f, date_versement,MontantVerse,id_f,"valider",0,RemarqueText.getText(),Aucceuil.userName,dette,0));
     //   JOptionPane.showMessageDialog(null, " Bien inserer ","",JOptionPane.INFORMATION_MESSAGE,img1);
        t.ShowGoodMessage(this, "Bien inserer");
      }
        else  t.ShowFailMessage(this, "Le montant vérser doit étre >0");
      if(MontantTotal>0)  nv_dette=MontantTotal-(dette+MontantVerse);
      else nv_dette=dette-MontantVerse;
        fou_op.modifier_Dette_Client( id_f,nv_dette);
       //  System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
      
       try {  
             if(ListVente.isEmpty()){
        Tcredit=Tcredit-MontantVerse;
      //   System.out.println("bbbbbbbbbbbbbb");
        TotalCredit.setText(Tcredit+"");
      //  System.out.println("00000011111111");
         ListClient.get(index).setCrédit(nv_dette);
         //   System.out.println("11111111111111");
             }
        
          } catch (Exception ex) {
          ex.getStackTrace();}
         
       try{ if(ListVente.isEmpty())  fou_op.displayResult(ListClient,jTable1);}catch(Exception e){}
        
        
      
    } catch (Exception ex) {
        ex.printStackTrace();
        Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
    }
 String  temp_vente=  DateFormat.getTimeInstance().format(new java.util.Date());
     Date date_vente=new Date(System.currentTimeMillis());
     if(!ListVente.isEmpty()){
    for (int i=0;i<ListVente.size();i++){
       // System.out.println("000000000000000000000");
       ListVente.get(i).setDate_vente(date_vente);
       ListVente.get(i).setTemp_vente(temp_vente);
       ListVente.get(i).setSomme_versé(MontantVerse);
       ListVente.get(i).setEtat("valide");   
       
       ListBon.get(i).setDate_vente(date_vente);
       ListBon.get(i).setTemp_vente(temp_vente);
       ListBon.get(i).setSomme_versé(MontantVerse);
       ListBon.get(i).setEtat("valide");   
       try {
           vop.Modifier_vente(ListVente.get(i));
           vop.displayBonVente(ListBon, TableBon);
         //    System.out.println("22222222222222222");
       } catch (Exception ex) {
           ex.printStackTrace();
           Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
       }
    
       try {
           nv_quantite = prop.Quantité(ListVente.get(i).getId_produit())-(ListVente.get(i).getQuantité_vente());
           prop.modifier_ProduitQuantité(ListVente.get(i).getId_produit(),nv_quantite);
           //  System.out.println("3333333333333333333");
       } catch (Exception ex) {
           ex.printStackTrace();
           Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
       }
      
       try {// System.out.println("44444444444444444");
           vco.Sup_Versement(ListVente.get(i).getNum_bon());
           
       } catch (Exception ex) {
           ex.printStackTrace();
           Logger.getLogger(VersementClient.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
        try {
       if(!ListVente.isEmpty())  vop.displayBonVente(ListBon, TableBon);
                   
                 } catch (Exception ex) {
                     Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
                 }
       
       
       
      }
if(PayerCaisseCheckBox.isSelected())
try{
ListCaisse.get(Caisse.getSelectedIndex()).setMontant(ListCaisse.get(Caisse.getSelectedIndex()).getMontant()+MontantVerse); 
cop.modifier_Caisse(ListCaisse.get(Caisse.getSelectedIndex()));
cop.Encaissement_Décaissemnt(ListCaisse.get(Caisse.getSelectedIndex()).getNum(), MontantVerse, date_versement,heure ,Aucceuil.userName, "Encaissement", "Encaissement", 0);

}catch(Exception e){}

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Caisse;
    private com.jkelany.jktextfield.numeric.JKNumericField DetteText;
    private javax.swing.JButton Imrprimer;
    private com.jkelany.jktextfield.numeric.JKNumericField MontantText;
    private com.jkelany.jktextfield.numeric.JKNumericField NV_Dette_Text;
    private javax.swing.JCheckBox PayerCaisseCheckBox;
    private javax.swing.JTextArea RemarqueText;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nom_prenom_four_Text;
    // End of variables declaration//GEN-END:variables
}
