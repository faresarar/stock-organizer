package com.raven.menu;

import com.raven.swing.MenuButton;
import com.raven.theme.SystemTheme;
import controler.Tools;
import controler.User_op;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;
import vue.Aucceuil;
import static vue.Aucceuil.ExistSerialNumber;
//import static vue.Aucceuil.SerialNumber;
import static vue.Aucceuil.utilisateur;
//import static vue.Aucceuil.userName;
import vue.GestionProduit;
import vue.Gestion_utilisateur;
import vue.ListeAchat;
import vue.ListeDesVentes;
import vue.ListeVersementClient;
import vue.ListeVersementFournisseur;
import vue.NewAchat;
import vue.GestionDepense1;
import vue.Paramaitres1;
import vue.RechercherClient;
import vue.RechercherFournisseur;
import vue.Statistiques;
import vue.VenteComptoir4;
//import vue.Aucceuil.utilisateur;       
import vue.gestion_des_employeurs;


public class Menu extends javax.swing.JPanel {
  ImageIcon   img = new ImageIcon("Images/erreur.GIF");
   Tools t=Tools.getInstance();
 // User utilisateur;
  User_op uop=User_op.getInstance();
 //Message me = new Message(this, true,"/images/stop.png","Vous n'avez pas les autorisations pour faire cette opération!","",Color.red);
    public int getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(int selectedLocation) {
        this.selectedLocation = selectedLocation;
        repaint();
    }

    public void addEventMenu(EventMenu event) {
        this.events.add(event);
    }

    private int selectedIndex = 0;
    private Animator animator;
    private TimingTarget target;
    private int selectedLocation = 153;
    private int targetLocation;
    private List<EventMenu> events = new ArrayList<>();

    public Menu( ) {
        initComponents();
        
        setOpaque(false);
        setBackground(Color.WHITE);
        menu.setLayout(new MigLayout("fillx, wrap, inset 0", "[fill]", "[fill, 36!]0[fill, 36!]"));
        initMenu();
      // 
    }

    private void initMenu() {
     //   File fichier = new File("src/images/gs.jpg");
          jLabel3.setIcon(resize("images/icone.png"));
   //  jLabel_user.setText(Aucceuil.userName);
    //  System.out.println("utilisateur="+utilisateur.getNom_prenom_utilisateur());
    
        addMenu("Liste des Ventes", "1", 0);
        addMenu("Vente", "2", 1);
        addMenu("Liste des Achats", "3", 2);
        addMenu("Nouvelle Achat", "4", 3);
        addMenu("Stock", "5", 4);
         addMenu("Dépenses", "6", 5);
         addMenu("Fournisseurs", "7", 6);
         addMenu("Versement Fournisseurs", "8", 7);
        
         addMenu("Clients", "9", 8);
         addMenu("Versement Clients", "10", 9);
        addMenu("Gestion d'utilisateurs", "11", 10);
         addMenu("Gestion d'employés", "12", 11);
        
      addMenu("Statistiques", "13", 12);
       
       addMenu("Paramaitres", "14", 13);
    
     
        //  add more menu here
        menu.repaint();
        menu.revalidate();
        setSelectedMenu(0);
       
               
      
        animator = new Animator(300);
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void begin() {
                clearSelected();
            }

            @Override
            public void end() {
                setSelectedMenu(selectedIndex);
                runEvent();
            }
        });
        animator.setDeceleration(.5f);
        animator.setAcceleration(.5f);
        animator.setResolution(0);
         
    }

    private void addMenu(String menuName, String icon, int index) {
        MenuButton m = new MenuButton();
        m.setIcoName(icon);
      //  m.setIcon(new ImageIcon(getClass().getResource("/com/raven/icon/" + icon + ".png")));
         m.setIcon(new ImageIcon(getClass().getResource("/images/icon/" + icon + ".png")));
        m.setFont(m.getFont().deriveFont(Font.BOLD, 12));
        m.setForeground(new Color(127, 127, 127));
        m.setHorizontalAlignment(JButton.LEFT);
        m.setText("  " + menuName);
       m.addMouseListener(new MouseListener(){ 
   

  
   
   

            @Override
            public void mouseClicked(MouseEvent me) {
               //   System.out.println("index="+index);
                 switch(index){
                       
                   case 0:if(utilisateur.getAuto2()==1) ListeDesVentes.getObj().setVisible(true); else NonAutoriser();break;
                   case 1:if(utilisateur.getAuto6()==1){VenteComptoir4.obj=null;VenteComptoir4.getObj(Aucceuil.userName).setVisible(true);}else NonAutoriser(); break;
                   case 2:if(utilisateur.getAuto1()==1)ListeAchat.getObj().setVisible(true);else  NonAutoriser(); break;
                   case 3:
                        if(!ExistSerialNumber) JOptionPane.showMessageDialog(null, "Logiciel non activer appeler 0792-04-08-17", " ", JOptionPane.WARNING_MESSAGE, img);
      else {  if(utilisateur.getAuto7()==1) { NewAchat.obj=null;
    NewAchat.getObj(Aucceuil.userName).setVisible(true);} else NonAutoriser();}break;
                       
                    //   if(utilisateur.getAuto7()==1){NewAchat.obj=null;NewAchat.getObj(Aucceuil.userName).setVisible(true);}else  NonAutoriser();break;
                   case 4:if(utilisateur.getAuto10()==1)GestionProduit.getObj().setVisible(true);else  NonAutoriser();break;
                   case 5: if(utilisateur.getAuto15()==1)GestionDepense1.getObj().setVisible(true);else  NonAutoriser();break;
                   case 6:if(utilisateur.getAuto11()==1)RechercherFournisseur.getObj().setVisible(true);else  NonAutoriser();break;
                   case 7: if(utilisateur.getAuto11()==1)ListeVersementFournisseur.getObj().setVisible(true);else  NonAutoriser();break;
                   case 8: if(utilisateur.getAuto12()==1)RechercherClient.getObj(1).setVisible(true);else  NonAutoriser();break;
                   case 9: if(utilisateur.getAuto12()==1)ListeVersementClient.getObj().setVisible(true);else  NonAutoriser();break;
                   case 10:if(utilisateur.getAuto8()==1)Gestion_utilisateur.getObj().setVisible(true);else NonAutoriser(); break;
                   case 11: if(utilisateur.getAuto18()==1)gestion_des_employeurs.getObj().setVisible(true);else  NonAutoriser();break;
                   case 12:if(utilisateur.getAuto3()==1) Statistiques.getObj().setVisible(true);else  NonAutoriser();break;
                   case 13: if(utilisateur.getAuto9()==1)Paramaitres1.getObj().setVisible(true);else  NonAutoriser();break;
                  // case 14:Paramaitres.getObj().setVisible(true);break;
                 }
            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                    if (animator.isRunning()) {
                        animator.stop();
                    }
                    int y = m.getY() + menu.getY();
                    targetLocation = y;
                    selectedIndex = index;
                    animator.removeTarget(target);
                    target = new PropertySetter(Menu.this, "selectedLocation", selectedLocation, targetLocation);
                    animator.addTarget(target);
                    animator.start();
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

   
});
     /*   m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             //   if (index != selectedIndex) {
                    if (animator.isRunning()) {
                        animator.stop();
                    }
                    int y = m.getY() + menu.getY();
                    targetLocation = y;
                    selectedIndex = index;
                    animator.removeTarget(target);
                    target = new PropertySetter(Menu.this, "selectedLocation", selectedLocation, targetLocation);
                    animator.addTarget(target);
                    animator.start();
                   System.out.println("index="+index);
                   switch(index){
                   case 0:ListeDesVentes.getObj().setVisible(true);break;
                   case 1:VenteComptoir4.getObj("").setVisible(true);break;
                   case 2:ListeAchat.getObj().setVisible(true);break;
                   case 3:NewAchat.getObj("").setVisible(true);break;
                   case 4:GestionProduit.getObj().setVisible(true);break;
                   case 5:GestionProduit.getObj().setVisible(true);break;
                   case 6:NewDépense.getObj().setVisible(true);break;
                   case 7:RechercherFournisseur.getObj().setVisible(true);break;
                   case 8:ListeVersementFournisseur.getObj().setVisible(true);break;
                   case 9:RechercherClient.getObj().setVisible(true);break;
             //      case 10:ListeVersementClient.getObj().setVisible(true);break;
                   case 11:Gestion_utilisateur.getObj().setVisible(true);break;
                   case 12:gestion_des_employeurs.getObj().setVisible(true);break;
                   case 13:gestion_des_employeurs.getObj().setVisible(true);break;
                   case 14:Paramaitres.getObj().setVisible(true);break;
                   }
                    // ListeDesVentes.getObj().setVisible(true);
              //  }
            }
        });*/
        menu.add(m);
         
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int y = selectedLocation;
        g2.setColor(SystemTheme.mainColor);
        g2.fill(createShape(y));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private Shape createShape(int y) {
        int width = getWidth() - 12;
        int r = 20;
        Area area = new Area(new RoundRectangle2D.Float(6, y, width, 35, r, r));
        area.add(new Area(new RoundRectangle2D.Float(width - r + 6, y, r, r, 5, 5)));
        area.add(new Area(new RoundRectangle2D.Float(6, y + 35 - r, r, r, 5, 5)));
        return area;
    }

    private void clearSelected() {
        for (Component com : menu.getComponents()) {
            if (com instanceof MenuButton) {
                MenuButton c = (MenuButton) com;
                c.setForeground(new Color(127, 127, 127));
                c.setEffectColor(new Color(173, 173, 173));
                if (!c.getIcoName().contains("_s")) {
                    c.setIcon(new ImageIcon(getClass().getResource("/images/icon/" + c.getIcoName() + ".png")));
                }
            }
        }
    }

    public void setSelectedMenu(int index) {
        MenuButton cmd = (MenuButton) menu.getComponent(index);
        cmd.setForeground(Color.WHITE);
        cmd.setEffectColor(Color.WHITE);
        cmd.setIcon(new ImageIcon(getClass().getResource("/images/icon/" + cmd.getIcoName() + "_s.png")));
    }

    private void runEvent() {
        for (EventMenu event : events) {
            event.selectedMenu(selectedIndex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_user = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setForeground(new java.awt.Color(255, 255, 0));
        menu.setOpaque(false);

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(117, 117, 117));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stock Organizer");

        jLabel_user.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel_user.setForeground(new java.awt.Color(154, 154, 154));
        jLabel_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_user.setText("Ad");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLabel_user)
                .addGap(20, 20, 20)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel_user;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables

public ImageIcon resize(String imgPath)
  {
    ImageIcon path = new ImageIcon(imgPath);
    Image img = path.getImage();
    Image newImg = img.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
  }

public void NonAutoriser(){
  JOptionPane.showMessageDialog(null, " Vous n'avez pas les autorisations pour faire cette opération!  ", " ", JOptionPane.WARNING_MESSAGE, img);

}
}
