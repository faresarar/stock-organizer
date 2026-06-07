package sample.notification;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;

import model.Produit;
import net.miginfocom.swing.MigLayout;
import sample.swing.ModernScrollBarUI;

/**
 *
 * @author RAVEN
 */
public class Notifications extends javax.swing.JPanel {

    /**
     * Creates new form Notifications
     */
    public Notifications(ArrayList<Produit> ListPro) {
        initComponents();
        setOpaque(false);
        JScrollBar sb = scroll.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new Color(33, 140, 206));
        sb.setPreferredSize(new Dimension(8, 8));
        sb.setUI(new ModernScrollBarUI());
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
      //scroll.setValue();
        panel.setLayout(new MigLayout("inset 0, fillx, wrap", "[fill]"));
        loadNoti(ListPro);
    }

    private void loadNoti(ArrayList<Produit> ListPro) {
        ImageIcon img;
     /*  panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Steve", "answered to your comment", "a day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Sophie", "answered to your comment", "1 day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Dara", "answered to your comment", "2 day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Steve", "answered to your comment", "a day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Sophie", "answered to your comment", "1 day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Dara", "answered to your comment", "2 day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Steve", "answered to your comment", "a day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Sophie", "answered to your comment", "1 day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Dara", "answered to your comment", "2 day ago"));
        panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Steve", "answered to your comment", "a day ago"));
      */
     //panel.add(new Item(new ImageIcon(getClass().getResource("/images/accept.png")), "Sophie", "answered to your comment", "1 day ago"));
     for(int i=0;i<ListPro.size();i++){
         
        try{
         //   img=new ImageIcon(getClass().getResource("/"+ListPro.get(i).getImage().replaceAll("src", "")));
        // img=new ImageIcon(getClass().getResource("/"+ListPro.get(i).getImage()));
     //  File fichier = new File("images/image_produits/accept.png");
     File fichier = new File(ListPro.get(i).getImage());
       // System.out.println("file path"+fichier.getAbsolutePath());
     img=new ImageIcon(fichier.getAbsolutePath());
        }catch(Exception e ){
           // System.out.println("exception");
             
        img=null;
        }
      String date=  ListPro.get(i).getDate_premption();
      if(date==null)date="";else date="Date Péremption="+ListPro.get(i).getDate_premption();
        panel.add(new Item(img,ListPro.get(i).getDésignation() ,date,  "Quantité="+ListPro.get(i).getQuantité()));
//System.out.println("date="+date);
//System.out.println(ListPro.get(i).getImage().replaceAll("src", ""));
     }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        int header = 10;
        AffineTransform tran = new AffineTransform();
        tran.translate(getWidth() - 25, 5);
        tran.rotate(Math.toRadians(45));
        Path2D p = new Path2D.Double(new RoundRectangle2D.Double(0, 0, 20, 20, 5, 5), tran);
        Area area = new Area(p);
        area.add(new Area(new RoundRectangle2D.Double(0, header, getWidth(), getHeight() - header, 10, 10)));
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 10, 10));

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setAutoscrolls(true);
        scroll.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        scroll.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(scroll)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents
public ImageIcon resize(String imgPath)
  {
    ImageIcon path = new ImageIcon(imgPath);
    Image img = path.getImage();
    Image newImg = img.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
