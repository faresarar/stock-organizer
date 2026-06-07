/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.BoutonColor;
import controler.Produit_paramaitre_op;
import controler.Tools;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import model.Produit_paramaitre;
import static vue.GestionProduit.ListProduit2;
import static vue.GestionProduit.jTable1;
import static vue.GestionProduit.produit_total;

/**
 *
 * @author Rais
 */
public class ModifierParamaitreProduit extends javax.swing.JFrame {
Produit_paramaitre_op poo=new Produit_paramaitre_op();
Produit_paramaitre pp;
//BoutonColor bc= BoutonColor.getInstance();
ActionListener escListener;
Tools tools=Tools.getInstance();
    /**
     * Creates new form ModifierParamaitreProduit
     */
    public ModifierParamaitreProduit() {
        initComponents();
         this.setIconImage(tools.getImageIcone().getImage());
           Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
       addEscapeListener(this);
    }
    
     private static ModifierParamaitreProduit obj=null;
     private static ModifierParamaitreProduit obj2=null;
  public static ModifierParamaitreProduit getObj(){
        if(obj==null){
            try {
         obj=new ModifierParamaitreProduit();
            } catch (Exception ex) {
                Logger.getLogger(ModifierParamaitreProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
    public static ModifierParamaitreProduit getObj2(Produit_paramaitre p){
        if(obj2==null){
            try {
         obj2=new ModifierParamaitreProduit( p);
            } catch (Exception ex) {
                Logger.getLogger(ModifierParamaitreProduit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj2;
    }
    
     private ModifierParamaitreProduit(Produit_paramaitre p) {
         pp=p;
       initComponents();
         this.setIconImage(tools.getImageIcone().getImage());
         if(p.getFamille()==1)famille.setSelected(true);else famille.setSelected(false);
         if(p.getUnite()==1)unite.setSelected(true);else unite.setSelected(false);
         if(p.getMarque()==1)marque.setSelected(true);else marque.setSelected(false);
         if(p.getDésignation()==1)désignation.setSelected(true);else désignation.setSelected(false);
         if(p.getÉtagére()==1)étagére.setSelected(true);else étagére.setSelected(false);
         if(p.getCode_barre()==1)code_barre.setSelected(true);else code_barre.setSelected(false);
         if(p.getMarque()==1)remarque.setSelected(true);else remarque.setSelected(false);
         if(p.getSaisie_par()==1)saisie_par.setSelected(true);else saisie_par.setSelected(false);
         if(p.getPrix_achat()==1)prix_achat.setSelected(true);else prix_achat.setSelected(false);
         if(p.getPrix_vente_detail()==1)prix_vente_detail.setSelected(true);else prix_vente_detail.setSelected(false);
         if(p.getPrix_vente_gros()==1)prix_vente_gros.setSelected(true);else prix_vente_gros.setSelected(false);
         if(p.getPrix_special()==1)prix_vente_special.setSelected(true);else prix_vente_special.setSelected(false);
         
         if(p.getQuantité()==1)quantité.setSelected(true);else quantité.setSelected(false);
         if(p.getStock_alert()==1)stock_alert.setSelected(true);else stock_alert.setSelected(false);
         if(p.getJour_alert()==1)jour_alert.setSelected(true);else jour_alert.setSelected(false);
        
         if(p.getTva()==1)tva.setSelected(true);else tva.setSelected(false);
         if(p.getDate_achat()==1)date_achat.setSelected(true);else date_achat.setSelected(false);
         if(p.getTaille()==1)taille.setSelected(true);else taille.setSelected(false);
         if(p.getPointure()==1)pointure.setSelected(true);else pointure.setSelected(false);
         if(p.getCouleur()==1)couleur.setSelected(true);else couleur.setSelected(false);
         if(p.getDate_premption()==1)date_premption.setSelected(true);else date_premption.setSelected(false);
         
         if(p.getCode_bare_packet()==1)code_barre_packet.setSelected(true);else code_barre_packet.setSelected(false);
         if(p.getNbre_produit_packet()==1)NbreProduitPacket.setSelected(true);else NbreProduitPacket.setSelected(false);
         if(p.getPrix_vente_packet()==1)PrixVentePacket.setSelected(true);else PrixVentePacket.setSelected(false);
         
          Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
         
         
           //   bc.ColorerBouton(Modifier,  new Color(41,134,10));
           //   bc.ColorerBouton(Annuler, Color.red);
         
      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Modifier = new javax.swing.JButton();
        remarque = new javax.swing.JCheckBox();
        saisie_par = new javax.swing.JCheckBox();
        famille = new javax.swing.JCheckBox();
        marque = new javax.swing.JCheckBox();
        désignation = new javax.swing.JCheckBox();
        unite = new javax.swing.JCheckBox();
        étagére = new javax.swing.JCheckBox();
        code_barre = new javax.swing.JCheckBox();
        prix_achat = new javax.swing.JCheckBox();
        prix_vente_gros = new javax.swing.JCheckBox();
        quantité = new javax.swing.JCheckBox();
        prix_vente_detail = new javax.swing.JCheckBox();
        stock_alert = new javax.swing.JCheckBox();
        jour_alert = new javax.swing.JCheckBox();
        tva = new javax.swing.JCheckBox();
        date_achat = new javax.swing.JCheckBox();
        pointure = new javax.swing.JCheckBox();
        couleur = new javax.swing.JCheckBox();
        taille = new javax.swing.JCheckBox();
        date_premption = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NbreProduitPacket = new javax.swing.JCheckBox();
        PrixVentePacket = new javax.swing.JCheckBox();
        code_barre_packet = new javax.swing.JCheckBox();
        prix_vente_special = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modifier paramaitres produits");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Modifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        Modifier.setText("Enregistrer");
        Modifier.setPreferredSize(new java.awt.Dimension(105, 40));
        Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifierActionPerformed(evt);
            }
        });
        getContentPane().add(Modifier, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 572, 136, 45));

        remarque.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        remarque.setText("remarque");
        getContentPane().add(remarque, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 414, -1, 34));

        saisie_par.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        saisie_par.setText("saisie_par");
        getContentPane().add(saisie_par, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 204, -1, 34));

        famille.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        famille.setText("famille");
        getContentPane().add(famille, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 102, -1, 34));

        marque.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        marque.setText("marque");
        getContentPane().add(marque, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, -1, 34));

        désignation.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        désignation.setText("désignation");
        getContentPane().add(désignation, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 204, -1, 34));

        unite.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        unite.setText("unite");
        getContentPane().add(unite, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 136, -1, 34));

        étagére.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        étagére.setText("étagére");
        getContentPane().add(étagére, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 238, -1, 34));

        code_barre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        code_barre.setText("Code barre");
        getContentPane().add(code_barre, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 275, -1, 34));

        prix_achat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        prix_achat.setText("prix_achat");
        getContentPane().add(prix_achat, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 309, -1, 34));

        prix_vente_gros.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        prix_vente_gros.setText("prix_vente_gros");
        getContentPane().add(prix_vente_gros, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 383, -1, 34));

        quantité.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        quantité.setText("quantité en Stock");
        getContentPane().add(quantité, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 102, -1, 34));

        prix_vente_detail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        prix_vente_detail.setText("prix_vente_detail");
        getContentPane().add(prix_vente_detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 346, -1, 34));

        stock_alert.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        stock_alert.setText("stock en alérte");
        getContentPane().add(stock_alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 136, -1, 34));

        jour_alert.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jour_alert.setText("jour_alért");
        getContentPane().add(jour_alert, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 170, -1, 34));

        tva.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tva.setText("tva");
        getContentPane().add(tva, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 451, -1, 34));

        date_achat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        date_achat.setText("date_achat");
        getContentPane().add(date_achat, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 238, -1, 34));

        pointure.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        pointure.setText("pointure");
        getContentPane().add(pointure, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 306, -1, 34));

        couleur.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        couleur.setText("couleur");
        getContentPane().add(couleur, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 343, -1, 34));

        taille.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        taille.setText("taille");
        getContentPane().add(taille, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 272, -1, 34));

        date_premption.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        date_premption.setText("date_péremption");
        getContentPane().add(date_premption, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 380, -1, 34));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(224, 64));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Afficher ou Masquer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 519, -1));

        NbreProduitPacket.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        NbreProduitPacket.setText("Nbre produit packet");
        getContentPane().add(NbreProduitPacket, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 457, -1, 34));

        PrixVentePacket.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PrixVentePacket.setText("Prix vente packet");
        getContentPane().add(PrixVentePacket, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 488, -1, 34));

        code_barre_packet.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        code_barre_packet.setText("Code_barre_packet");
        getContentPane().add(code_barre_packet, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 494, -1, 34));

        prix_vente_special.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        prix_vente_special.setText("prix_vente_spécial");
        getContentPane().add(prix_vente_special, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 420, -1, 34));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifierActionPerformed
      if(famille.isSelected()==true)pp.setFamille(1);else pp.setFamille(0);
      if(unite.isSelected()==true)pp.setUnite(1);else pp.setUnite(0);
      if(marque.isSelected()==true)pp.setMarque(1);else pp.setMarque(0);
      if(désignation.isSelected()==true)pp.setDésignation(1);else pp.setDésignation(0);
      if(étagére.isSelected()==true)pp.setÉtagére(1);else pp.setÉtagére(0);
      if(code_barre.isSelected()==true)pp.setCode_barre(1);else pp.setCode_barre(0);
      if(remarque.isSelected()==true)pp.setRemarque(1);else pp.setRemarque(0);
      if(saisie_par.isSelected()==true)pp.setSaisie_par(1);else pp.setSaisie_par(0);
      if(prix_achat.isSelected()==true)pp.setPrix_achat(1);else pp.setPrix_achat(0);
      if(prix_vente_detail.isSelected()==true)pp.setPrix_vente_detail(1);else pp.setPrix_vente_detail(0);
      if(prix_vente_gros.isSelected()==true)pp.setPrix_vente_gros(1);else pp.setPrix_vente_gros(0);
       if(prix_vente_special.isSelected()==true)pp.setPrix_special(1);else pp.setPrix_special(0);
    
      if(quantité.isSelected()==true)pp.setQuantité(1);else pp.setQuantité(0);
      if(stock_alert.isSelected()==true)pp.setStock_alert(1);else pp.setStock_alert(0);
      if(jour_alert.isSelected()==true)pp.setJour_alert(1);else pp.setJour_alert(0);
     
      if(tva.isSelected()==true)pp.setTva(1);else pp.setTva(0);
      if(date_achat.isSelected()==true)pp.setDate_achat(1);else pp.setDate_achat(0);
      if(taille.isSelected()==true)pp.setTaille(1);else pp.setTaille(0);
      if(pointure.isSelected()==true)pp.setPointure(1);else pp.setPointure(0);
      if(couleur.isSelected()==true)pp.setCouleur(1);else pp.setCouleur(0);
      if(date_premption.isSelected()==true)pp.setDate_premption(1);else pp.setDate_premption(0);
      
       if(NbreProduitPacket.isSelected()==true)pp.setNbre_produit_packet(1);else pp.setNbre_produit_packet(0);
        if(PrixVentePacket.isSelected()==true)pp.setPrix_vente_packet(1);else pp.setPrix_vente_packet(0);
        if(code_barre_packet.isSelected()==true)pp.setCode_bare_packet(1);else pp.setCode_bare_packet(0);
                            
         
    try {
        poo.modifier_Paramaitre_Produit2(pp);
      
         poo.displayResult(ListProduit2, jTable1, poo.getparamaitre_Produit2(),produit_total,ListProduit2.size());
         //  tools.ShowGoodMessage(obj, "Bien modifier");
    } catch (Exception ex) {
        Logger.getLogger(ModifierParamaitreProduit.class.getName()).log(Level.SEVERE, null, ex);
        tools.ShowFailMessage(obj, ex.getMessage());
    }
    this.dispose();
    }//GEN-LAST:event_ModifierActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       obj=null;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
 
    
public static void addEscapeListener(final JFrame j) {
	    ActionListener escListener = new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	int res=JOptionPane.showConfirmDialog(null, "Are you sure to exit ?");
				if(res!=1&&res!=2){
					j.dispose();
				}
				
	        }
	    };
	    ActionListener saleByCash = new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	       System.out.println("sele cach");
				
	        }
	    };
	    ActionListener purchOrder= new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	       System.out.println("purchOrder");	
	        	
				
	        }
	    };
	    
             ActionListener aa= new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	       System.out.println("aaaaa");	
	        	
				
	        }
	    };
	    ActionListener purchOrderNot = new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	        	       System.out.println("purchOrderNot");	
				
	        }
	    };

	    j.getRootPane().registerKeyboardAction(escListener,
	            KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);
              j.getRootPane().registerKeyboardAction(aa,
	            KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);
	    
	    j.getRootPane().registerKeyboardAction(saleByCash,
	            KeyStroke.getKeyStroke("typed s"),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);
	    
	    j.getRootPane().registerKeyboardAction(purchOrder
	    		,
	            KeyStroke.getKeyStroke("typed o"),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);
	    
	    j.getRootPane().registerKeyboardAction(purchOrderNot,
	            KeyStroke.getKeyStroke("typed p"),
	            JComponent.WHEN_IN_FOCUSED_WINDOW);

	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modifier;
    private javax.swing.JCheckBox NbreProduitPacket;
    private javax.swing.JCheckBox PrixVentePacket;
    private javax.swing.JCheckBox code_barre;
    private javax.swing.JCheckBox code_barre_packet;
    private javax.swing.JCheckBox couleur;
    private javax.swing.JCheckBox date_achat;
    private javax.swing.JCheckBox date_premption;
    private javax.swing.JCheckBox désignation;
    private javax.swing.JCheckBox famille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox jour_alert;
    private javax.swing.JCheckBox marque;
    private javax.swing.JCheckBox pointure;
    private javax.swing.JCheckBox prix_achat;
    private javax.swing.JCheckBox prix_vente_detail;
    private javax.swing.JCheckBox prix_vente_gros;
    private javax.swing.JCheckBox prix_vente_special;
    private javax.swing.JCheckBox quantité;
    private javax.swing.JCheckBox remarque;
    private javax.swing.JCheckBox saisie_par;
    private javax.swing.JCheckBox stock_alert;
    private javax.swing.JCheckBox taille;
    private javax.swing.JCheckBox tva;
    private javax.swing.JCheckBox unite;
    private javax.swing.JCheckBox étagére;
    // End of variables declaration//GEN-END:variables
}
