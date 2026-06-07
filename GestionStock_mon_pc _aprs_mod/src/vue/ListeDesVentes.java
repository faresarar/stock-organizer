/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.BoutonColor;
import controler.CheckField;
import controler.Client_op;
import controler.DateFormater;
import controler.FrenchNumberToWords;
import controler.Paramaitres_op;
import controler.Produit_op;
import controler.TextNumber;
import controler.Tools;
import controler.Vente_op;
import controler.Versement_client;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.Date;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.JTableHeader;
import model.Client;
import java.util.HashMap;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import model.Paramaitre;

import model.Produit;
import model.Vente;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;
import raven.javaswingdev.MessageDialog;




/**
 *
 * @author pc
 */
public class ListeDesVentes extends javax.swing.JFrame {
static Vente_op vop= Vente_op.getInstance();
Produit_op pop= Produit_op.getInstance();
Client_op cop= Client_op.getInstance();
CheckField cf=CheckField.getInstance();
Paramaitres_op paop=Paramaitres_op.getInstance();
Versement_client vco= Versement_client.getObj();
DateFormater df=new DateFormater();
TextNumber tn= TextNumber.getObj();
BoutonColor bc= BoutonColor.getInstance();
public  ArrayList<Float> ListProduitQuantité = new ArrayList<>();
double mantant_versé=0;
 //ImageIcon   img = new ImageIcon("images/gs.png");
// ImageIcon   img1 = new ImageIcon("images/accept.png");
// ImageIcon   img2 = new ImageIcon("images/warning.png");
 String par="";
// Message me = new Message(this, true,"/images/stop.png","Veuiller sélectionner les dates de début et de fin!","",Color.red); 
 int t=4;
 Tools tools=Tools.getInstance();
 double m;
 double remise=0;
 int row=0;
 double cr=0;
 double total=0;
 String date;
 Date date1,date2;
 DateFormater dff=new DateFormater();
 TextNumber tnb= TextNumber.getObj(); 
 public static ArrayList<Vente> ListVente =new ArrayList<>();  
 public static ArrayList<Vente> ListBon =new ArrayList<>(); 
 public ArrayList<Produit> ListPr =new ArrayList<>();  
 public ArrayList<Double> ListPrixAch =new ArrayList<>();  
 //public static   ArrayList<Achat> ListBonAchat =new ArrayList<>();  
 //public   ArrayList<PrintReportVente> ListPrintBonLivraison =new ArrayList<>();  
  //Paramaitre pa=null;
 Paramaitre p ;
 private static ListeDesVentes obj=null;
 String option_imp="ticket";
 String ticket_forma="ETQ55";
 Client c;
 FrenchNumberToWords an= FrenchNumberToWords.getInstance(); 
 Map   para = new HashMap();
 JasperFillManager jfm;
 JasperPrint print1,print2,print3,print4;
   
   
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
    public static ListeDesVentes getObj(){
        if(obj==null){
            try {
         obj=new ListeDesVentes();
            } catch (Exception ex) {
                Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }return obj;
    }
     
  
    private ListeDesVentes() {
      initComponents();
   this.setIconImage(tools.getImageIcone().getImage());
      BoutonValider.setVisible(false);
      TableBon.setRowHeight(30);
      JTableHeader tableHeader1 = TableBon.getTableHeader();
      TableBon.getTableHeader().setOpaque(false);
      tableHeader1.setBackground(Color.BLACK);
      tableHeader1.setForeground(Color.black);
     
      Table_detail_vente.setRowHeight(30);
      JTableHeader tableHeader2 = Table_detail_vente.getTableHeader();
      Table_detail_vente.getTableHeader().setOpaque(false);
      tableHeader2.setBackground(Color.BLACK);
      tableHeader2.setForeground(Color.black);
     
     // tableHeader2.setBackground(Color.BLACK);
    // tableHeader2.setForeground(Color.white);
     
      Font headerFont = new Font("Verdana", Font.PLAIN, 14);
     
      tableHeader1.setFont(headerFont);
      tableHeader2.setFont(headerFont);
      
       
       
    try { Paramaitres_op paop=new Paramaitres_op();
        p=paop.get_Paramaitre();
      // ListAchat.clear();
      // ListAchat=aop.getList_produit(ABORT);
      ListBon=vop.getList_bon(0);
          // aop.displayResult1(ListAchat,jTable2);
          // ListBonAchat=aop.getListBonAchat();
      //  try { num_bon_liv=ListBonLivraison.get(jTable1.getSelectedRow()).getNum_bon_livraison();}catch (Exception e){num_bon_liv=0;}
   
       // ListClient=cop.getList_Client("", 1);
      // cop.Charger_client(jComboBox1);
      
    //   for (int i=0;i<ListAchat.size();i++){
   //  System.out.println("bon achat size="+ListAchat.size()+"quantite="+ListAchat.get(i).getQuantité()+"prix achat="+ListAchat.get(i).getPrix_achat());
   //  total=total+(ListAchat.get(i).getQuantité()*ListAchat.get(i).getPrix_achat());
    //   }
        vop.displayBonVente(ListBon, TableBon);
        
      if(row>-1){  ListVente=vop.getList_Vente(row);
        vop.displayResult(ListVente,Table_detail_vente);}
    } catch (Exception ex) {
//        Logger.getLogger(ListeVente.class.getName()).log(Level.SEVERE, null, ex);
    }
       InputMap inputMap = TableBon.getInputMap();
 
       inputMap.put(KeyStroke.getKeyStroke("DOWN"), "DOWN");
        inputMap.put(KeyStroke.getKeyStroke("UP"), "UP");
 
       ActionMap actionMap = TableBon.getActionMap();
        actionMap.put("DOWN", new AbstractAction() {
 
           public void actionPerformed(ActionEvent e) {
               // JOptionPane.showMessageDialog(null, "Changing Row!");
                if (TableBon.getSelectedRow() < TableBon.getRowCount() - 1) {
                    TableBon.changeSelection(TableBon.getSelectedRow() + 1, 0, false, false);
                      try {ListVente.clear();
                 //  System.out.println("row="+jTable1.getSelectedRow());
                    ListVente=vop.getList_Vente(ListBon.get(TableBon.getSelectedRow()).getNum_bon());
                     c=   new Client(ListBon.get(TableBon.getSelectedRow()).getNom_prénom_cient(),ListBon.get(TableBon.getSelectedRow()).getIdc(),cr);
                 //     System.out.println("liste vente size="+ListBon.get(jTable1.getSelectedRow()).getNom_prénom_cient());
                } catch (Exception ex) {
                  //   Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
                }
          vop.displayResult(ListVente,Table_detail_vente);
                }
            }
        });
 actionMap.put("UP", new AbstractAction() {
 
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null, "Changing Row!");
                if (TableBon.getSelectedRow() > 0) {
                    
                TableBon.changeSelection(TableBon.getSelectedRow() - 1, 0, false, false);
                    try {ListVente.clear();
               //System.out.println("row="+jTable1.getSelectedRow());
                  ListVente=vop.getList_Vente(ListBon.get(TableBon.getSelectedRow()).getNum_bon());
                   c=   new Client(ListBon.get(TableBon.getSelectedRow()).getNom_prénom_cient(),ListBon.get(TableBon.getSelectedRow()).getIdc(),cr);
                     //System.out.println("liste vente size="+ListVente.size());
               } catch (Exception ex) {
 //                    Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
                }
                  vop.displayResult(ListVente,Table_detail_vente);
 
               }
           }
       });
   // par=fournisseur.getText().trim();
   // par=fournisseur.getText().trim();
   date=java.time.LocalDate.now()+"";
     TableBon.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            JTable table = (JTable) me.getSource();
            Point p = me.getPoint();
             row = table.rowAtPoint(p);
            if (me.getClickCount() ==1) {
                try {ListVente.clear();
                c=   new Client(ListBon.get(TableBon.getSelectedRow()).getNom_prénom_cient(),ListBon.get(TableBon.getSelectedRow()).getIdc(),cr);
                 if(!ListBon.isEmpty()) {  ListVente=vop.getList_Vente(ListBon.get(row).getNum_bon());
                 if(ListBon.get(row).getEtat().equals("invalide"))BoutonValider.setVisible(true);else BoutonValider.setVisible(false);
                 }
                  //   System.out.println("liste vente size="+ListAchat.size());
               } catch (Exception ex) {
 //                    Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
                }
          vop.displayResult(ListVente,Table_detail_vente);
         //   System.out.println("row="+row);
            // System.out.println("column="+table.columnAtPoint(p));
            }
        }
    });
    bc.ColorerBouton(jButtonModifier,  new Color(1, 101, 225));
      bc.ColorerBouton(jButtonSupp, Color.red);
        bc.ColorerBouton(jButtonPrint, new Color(102,102,102));
        bc.ColorerBouton(BoutonValider,  new Color(41,134,10));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrintGroup = new javax.swing.ButtonGroup();
        TicketFormatGroup = new javax.swing.ButtonGroup();
        jButtonPrint = new javax.swing.JButton();
        jPanelTicketFormat = new javax.swing.JPanel();
        jRadioETQ80 = new javax.swing.JRadioButton();
        jRadioA5 = new javax.swing.JRadioButton();
        jRadioETQ55 = new javax.swing.JRadioButton();
        jRadioA4 = new javax.swing.JRadioButton();
        jButtonModifier = new javax.swing.JButton();
        jPanelOptionImpression = new javax.swing.JPanel();
        jRadioFacture = new javax.swing.JRadioButton();
        jRadioBonLivraison = new javax.swing.JRadioButton();
        jRadioTicket = new javax.swing.JRadioButton();
        jRadioFactureProformat = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        num_bon = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableBon = new javax.swing.JTable();
        jButtonSupp = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_detail_vente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BoutonValider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des ventes");
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

        jPanelTicketFormat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ticket format", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelTicketFormat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        TicketFormatGroup.add(jRadioETQ80);
        jRadioETQ80.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioETQ80.setText("ETQ 80");
        jRadioETQ80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioETQ80ActionPerformed(evt);
            }
        });

        TicketFormatGroup.add(jRadioA5);
        jRadioA5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioA5.setText("A5");
        jRadioA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioA5ActionPerformed(evt);
            }
        });

        TicketFormatGroup.add(jRadioETQ55);
        jRadioETQ55.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioETQ55.setSelected(true);
        jRadioETQ55.setText("ETQ 55");
        jRadioETQ55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioETQ55ActionPerformed(evt);
            }
        });

        TicketFormatGroup.add(jRadioA4);
        jRadioA4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioA4.setText("A4");
        jRadioA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioA4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTicketFormatLayout = new javax.swing.GroupLayout(jPanelTicketFormat);
        jPanelTicketFormat.setLayout(jPanelTicketFormatLayout);
        jPanelTicketFormatLayout.setHorizontalGroup(
            jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTicketFormatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioETQ55, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioETQ80, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jRadioA4)
                    .addComponent(jRadioA5))
                .addGap(6, 6, 6))
        );
        jPanelTicketFormatLayout.setVerticalGroup(
            jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTicketFormatLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioETQ80)
                    .addComponent(jRadioA5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTicketFormatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioA4)
                    .addComponent(jRadioETQ55))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonModifier.setBackground(new java.awt.Color(51, 255, 0));
        jButtonModifier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonModifier.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModifier.setText("Modifier ");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jPanelOptionImpression.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)), "Type", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelOptionImpression.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        PrintGroup.add(jRadioFacture);
        jRadioFacture.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioFacture.setText("Facture");
        jRadioFacture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFactureActionPerformed(evt);
            }
        });

        PrintGroup.add(jRadioBonLivraison);
        jRadioBonLivraison.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioBonLivraison.setText("Bon de livraison");
        jRadioBonLivraison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioBonLivraisonActionPerformed(evt);
            }
        });

        PrintGroup.add(jRadioTicket);
        jRadioTicket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioTicket.setSelected(true);
        jRadioTicket.setText("Ticket");
        jRadioTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioTicketActionPerformed(evt);
            }
        });

        PrintGroup.add(jRadioFactureProformat);
        jRadioFactureProformat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioFactureProformat.setText("Facture proformat");
        jRadioFactureProformat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioFactureProformatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOptionImpressionLayout = new javax.swing.GroupLayout(jPanelOptionImpression);
        jPanelOptionImpression.setLayout(jPanelOptionImpressionLayout);
        jPanelOptionImpressionLayout.setHorizontalGroup(
            jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionImpressionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioBonLivraison)
                    .addComponent(jRadioFactureProformat))
                .addGap(2, 2, 2)
                .addGroup(jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioFacture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanelOptionImpressionLayout.setVerticalGroup(
            jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOptionImpressionLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioBonLivraison)
                    .addComponent(jRadioFacture))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelOptionImpressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioTicket)
                    .addComponent(jRadioFactureProformat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Num Bon ");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(num_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(num_bon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(194, 64));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Liste des Ventes");
        jLabel4.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        );

        TableBon.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        TableBon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "num de bon", "client", "date", "Etat"
            }
        ));
        jScrollPane2.setViewportView(TableBon);

        jButtonSupp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSupp.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSupp.setText("Supprimer");
        jButtonSupp.setPreferredSize(new java.awt.Dimension(179, 42));
        jButtonSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuppActionPerformed(evt);
            }
        });

        Table_detail_vente.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Table_detail_vente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(Table_detail_vente);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DETAIL DE LA VENTE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("du");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("au");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngwing.com(3).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BoutonValider.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BoutonValider.setForeground(new java.awt.Color(255, 255, 255));
        BoutonValider.setText("Valider facture proformat");
        BoutonValider.setPreferredSize(new java.awt.Dimension(179, 42));
        BoutonValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonValiderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1189, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(73, 73, 73))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80)))
                                        .addComponent(jPanelOptionImpression, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanelTicketFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(410, 410, 410)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BoutonValider, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(jButtonSupp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(82, 82, 82)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jXDatePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanelOptionImpression, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTicketFormat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addComponent(jButtonSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(46, 46, 46))
                        .addComponent(BoutonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
  // System.out.println("selected row="+jTable1.getSelectedRow());
  total=0;
    if(TableBon.getSelectedRow()==-1)
        tools.ShowFailMessage(this, "Veuiller sélectionner un bon");
      //  JOptionPane.showMessageDialog(null, " Veuiller sélectionner un bon   ","",JOptionPane.INFORMATION_MESSAGE,img2);
       else {
        if(!ListBon.isEmpty()){    
        try {
        // Dette_fournisseur_op ccop= Dette_fournisseur_op.getInstance();
         ListVente.clear();
         ListVente=vop.getList_Vente(ListBon.get(row).getNum_bon());
   // String nom_fournisseur=ListBon.get(row).getNom_prénom_client();
    int id_c=ListBon.get(row).getIdc();
    ListProduitQuantité.clear();
    ListPr.clear();
 //  System.out.println("list achat size="+ListAchat.size());
    ListPr=vop.getList_produit(ListBon.get(row).getNum_bon());
     for (int i=0;i<ListVente.size();i++){
   // ListProduitQuantité.add(ListVente.get(i).getQuantité_vente());
 
     
    // System.out.println("list produit size="+ListPr.size());
  //   System.out.println("produit(0)qte="+ListPr.get(i).getQuantité());
    // ListPrixAch.add(ListVente.get(i).getPrix_achat());
      total=total+(ListVente.get(i).getMontantHT());
    //ListVente.get(i).setQuantité(pop.QuantitéEnStock(ListPr.get(i).getDésignation()));
      
 /*PrintReportBonReception prb=   new PrintReportBonReception (p.getNom_magasin(),p.getAdresse(),p.getNum_tel_fax_fix(),p.getNum_tel1(),p.getNum_tel2(),ListAchat.get(i).getNum_bon_réception(),
         ListAchat.get(i).getNom_prénom_fournisseur(),
         ListAchat.get(i).getDésignation(),ListAchat.get(i).getPrix_achat(),ListAchat.get(i).getQuantité(),0,0);
 ListPrintBonLivraison.add(prb);*/
        
   //  System.out.println("total ++++="+ListVente.get(i).getMontantHT());
         //  System.out.println( "id rproduit="+  ListPr.get(i).getId_produit());
     }
    
    //   System.out.println("idc avant modifier="+id_c);
       //obj=null;
          VenteComptoir4.getObj(cop.get_Client(id_c),ListVente,ListPr,total).setVisible(true);
           
        this.dispose();
     
        obj=null;
    } catch (Exception ex) {
 //        Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
    }
        }                    }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void num_bonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num_bonKeyReleased
      
         int n=0;
        
           try {
               try{n=Integer.parseInt(num_bon.getText().trim());
               
               
               }catch(Exception e){
            //   System.out.println("n="+n);
               }
               if(n==0)  ListBon=  vop.getList_bon(0);
           else ListBon=  vop.getList_bon(n);
            vop.displayBonVente(ListBon, TableBon);
        } catch (Exception ex) {
//            Logger.getLogger(ListeVente.class.getName()).log(Level.SEVERE, null, ex);
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
    int position = TableBon.getSelectedRow();
 if(position==-1)
     tools.ShowFailMessage(this, "Veuiller sélectionner un bon");      
     
 else {
      try {
        ListVente=vop.getList_Vente(ListBon.get(row).getNum_bon());
         c=  cop.get_Client(ListBon.get(row).getIdc());
     //    System.out.println("code="+ListVente.get(0).getCode());
    } catch (Exception ex) {
        Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
    }      
         
          if(!ListVente.isEmpty()){
    try {
        //ListPrintBonLivraison.clear();
      
   
        p=paop.get_Paramaitre();
   
     //   for (int i=0;i<ListVente.size();i++){
      
 /* ListPrintBonLivraison.add(new PrintReportVente (p.getNom_magasin(),p.getAdresse_p(),p.getNum_tel_fax_fix_p(),p.getNum_tel1_p(),p.getNum_tel2_p(),
         p.getNRC(),p.getNIS(),p.getNIF(),p.getActivite(),new java.sql.Date(System.currentTimeMillis()),
         ListVente.get(i).getNom_prénom_cient(),
                ListVente.get(i).getTVA(),
         ListVente.get(i).getDésignation(),
                ListVente.get(i).getPrix_achat()
                ,ListVente.get(i).getPrix_vente(),
                ListVente.get(i).getQuantité_vente(),
0,
                0, 
                DateFormat.getTimeInstance().format(new Date()),Aucceuil4.Currentuser.getUsername(),ListVente.get(i).getId_produit(),ListVente.get(i).getIdc(),ListVente.get(i).getSomme_versé(),remise,ListVente.get(i).getNum_bon() ,p.getMessage(),"","","","","","","","",0,0,""));*/ 
 
      //  }
    } catch (Exception ex) {
 //        Logger.getLogger(ListeBonLivraison.class.getName()).log(Level.SEVERE, null, ex);
    }
          try {
        try {
            imprimer(ListVente);
        } catch (PrinterException ex) {
            Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
        }
          } catch (IOException ex) {
             ex.printStackTrace();
          } catch (JRException ex) {
              Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
          }
     
 }
    }
    }//GEN-LAST:event_jButtonPrintActionPerformed

    private void num_bonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num_bonKeyPressed
         tn.numOnly(num_bon);
    }//GEN-LAST:event_num_bonKeyPressed

    private void jButtonSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuppActionPerformed
        int position=TableBon.getSelectedRow(); 
        String etat="valide";
         if(position==-1||ListBon.isEmpty())
            tools.ShowFailMessage(this, "Veuiller sélectionner un bon");
         
         else{
              try{ cr=cop.getCredit(ListVente.get(0).getIdc());}catch(Exception e){}
              etat=ListBon.get(position).getEtat();
          //   int  result =JOptionPane.showConfirmDialog(null,"Voulez vous supprimer cette vente ?","",JOptionPane.YES_NO_OPTION);
        if(tools.ShowConfirmMessage("Voulez vous supprimer cette vente ?", "", this)==MessageDialog.MessageType.OK){
              c=   new Client(ListBon.get(position).getNom_prénom_cient(),ListBon.get(position).getIdc(),cr);
                 try {
                     if(ListBon.get(position).getEtat().equals("valide")){
                       ListPr=vop.getList_produit(ListBon.get(row).getNum_bon());
                    
        ListVente=vop.getList_Vente(ListBon.get(row).getNum_bon());
                      // System.out.println("list bon size="+ListBon+" "+ListPr.size());
                       for(int i=0;i<ListPr.size();i++){
                        float quantite=pop.Quantité(ListPr.get(i).getId_produit())+
                                ListVente.get(i).getQuantité_vente();
                         pop.ModifierQuantite(quantite, ListPr.get(i).getId_produit());
                                                       }
                      
                        c.setCrédit(cr);                                     }
                vop.sup_Vente2(ListBon.get(position).getNum_bon());
                vco.modifier_etat_versement(ListBon.get(position).getNum_bon(), "Annuler");
               
                  
               // try{ListPrintBonLivraison.remove(position);}catch(Exception e){}
             //    c=new Client(ListBon.get(position).getNom_prénom_cient(),ListBon.get(position).getIdc(),cr);
               try{ ListBon.remove(position);}catch(Exception e){}
              try{  ListPr.clear();}catch(Exception e){}
              
              try{  ListPrixAch.clear();}catch(Exception e){}
                
             
            
                  // System.out.println("list bon size="+ListBon.size());     
                 } catch (Exception ex) {
                    // System.out.println("sup exeception");
                     Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
              
                 }
                  
                 try {
                     vop.displayBonVente(ListBon, TableBon);
                   
                 } catch (Exception ex) {
                     Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
                 }
                     tools.ShowGoodMessage(this, "Bien supprimer");
                      
                     try {
                    
                   if(etat.equals("valide"))   AfterDelVente.getObj(c, CalculTotal(), total-cr, 0). setVisible(true);
                 } catch (Exception ex) {
                     Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
                 } 
                      
                
  try{ ListVente.clear();}catch(Exception e){}
    vop.displayResult(ListVente, Table_detail_vente);
    
    
         }
         }
    }//GEN-LAST:event_jButtonSuppActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    obj=null;
    this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jRadioFactureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFactureActionPerformed
        option_imp="facture";
        jPanelTicketFormat.setVisible(false);
         BoutonValider.setVisible(false);
    }//GEN-LAST:event_jRadioFactureActionPerformed

    private void jRadioBonLivraisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBonLivraisonActionPerformed
        option_imp="bon_livraison";
        jPanelTicketFormat.setVisible(false);
        BoutonValider.setVisible(false);
    }//GEN-LAST:event_jRadioBonLivraisonActionPerformed

    private void jRadioTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioTicketActionPerformed
        option_imp="ticket";
        jPanelTicketFormat.setVisible(true);
         BoutonValider.setVisible(false);
    }//GEN-LAST:event_jRadioTicketActionPerformed

    private void jRadioFactureProformatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioFactureProformatActionPerformed
        option_imp="facture_proforma";
         BoutonValider.setVisible(true);
        jPanelTicketFormat.setVisible(false);
        
    }//GEN-LAST:event_jRadioFactureProformatActionPerformed

    private void jRadioETQ80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioETQ80ActionPerformed
        ticket_forma="ETQ80";
    }//GEN-LAST:event_jRadioETQ80ActionPerformed

    private void jRadioA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioA5ActionPerformed
        ticket_forma="A5";
    }//GEN-LAST:event_jRadioA5ActionPerformed

    private void jRadioETQ55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioETQ55ActionPerformed
        ticket_forma="ETQ55";
       
    }//GEN-LAST:event_jRadioETQ55ActionPerformed

    private void jRadioA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioA4ActionPerformed
        ticket_forma="A4";
    }//GEN-LAST:event_jRadioA4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
    try{      
        cf.CheckDate(jXDatePicker1);
          cf.CheckDate(jXDatePicker2);
        date1=new java.sql.Date(jXDatePicker1.getDate().getTime());
        date2=new java.sql.Date(jXDatePicker2.getDate().getTime());
       }catch(Exception e){date1=null;date2=null;}
         if((date1==null)||(date2==null))tools.ShowFailMessage(obj, "Veuiller sélectionner les dates de début et de fin!");
         else {
            try {
             
                ListBon=  vop.getList_bon(date1,date2);
             //   System.out.println("ListInv size="+ListInv.size()+date1+date2);
                vop.displayBonVente(ListBon, TableBon);
              
            } catch (Exception ex) {
                Logger.getLogger(ListeCommandeFournisseur.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BoutonValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonValiderActionPerformed

        if(ListBon.size()>0 && ListBon.get(TableBon.getSelectedRow()).getEtat().equals("invalide")){
    try {
      
      
      // Vente v=ListBon.get(TableBon.getSelectedRow());
       
          mantant_versé=vop.getTotal_HT(ListVente)+c.getCrédit()-ListBon.get(TableBon.getSelectedRow()).getSomme_versé();
       //   System.out.println("montantht"+ vop.getTotal_HT(ListVente));
        //  System.out.println("credit="+c.getCrédit());
     //   v.setDate_vente(date_vente);
     //   v.setTemp_vente(temp_vente);
     //   v.setEtat("valide");
      // 
        
     
                       //  VersementClient.getObj(c);
        
    } catch (Exception ex) {
        ex.printStackTrace();
        Logger.getLogger(ListeDesVentes.class.getName()).log(Level.SEVERE, null, ex);
    }
    try{
       
        VersementClient.getObj(c,mantant_versé,ListVente).setVisible(true);}catch(Exception e){}
    
   
    
} else tools.ShowFailMessage(this, "Ce bon déja valider");

    }//GEN-LAST:event_BoutonValiderActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonValider;
    private javax.swing.ButtonGroup PrintGroup;
    public static javax.swing.JTable TableBon;
    public static javax.swing.JTable Table_detail_vente;
    private javax.swing.ButtonGroup TicketFormatGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonPrint;
    private javax.swing.JButton jButtonSupp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelOptionImpression;
    private javax.swing.JPanel jPanelTicketFormat;
    private javax.swing.JRadioButton jRadioA4;
    private javax.swing.JRadioButton jRadioA5;
    private javax.swing.JRadioButton jRadioBonLivraison;
    private javax.swing.JRadioButton jRadioETQ55;
    private javax.swing.JRadioButton jRadioETQ80;
    private javax.swing.JRadioButton jRadioFacture;
    private javax.swing.JRadioButton jRadioFactureProformat;
    private javax.swing.JRadioButton jRadioTicket;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JTextField num_bon;
    // End of variables declaration//GEN-END:variables


double CalculTotal(){
total=0;
 for(int i=0;i<ListVente.size();i++)
     total=total+(ListVente.get(i).getQuantité_vente()*ListVente.get(i).getPrix_vente());
 return total;
}


void imprimer(ArrayList<Vente> ListPrint) throws IOException, JRException, PrinterException{
   
  JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ListVente);


//print1 =jfm.fillReport("Bon_livraison1.jasper", para, dataSource);
//print2 =jfm.fillReport("facture_vente.jasper", para, dataSource);
//print3 =jfm.fillReport("facture_proformat1.jasper", para, dataSource);
//print4 =jfm.fillReport("ticket55.jasper",para, dataSource);
        
  if(!ListPrint.isEmpty()){
     
 
                 para.put("activite", p.getActivite());
                  para.put("adresse_p", p.getAdresse_p());
                  para.put("message", p.getMessage());
                  para.put("NIF", p.getNIF());
                  para.put("NIS", p.getNIS());
                  para.put("NRC", p.getNRC());
                  para.put("RIB", p.getRIB());
                  para.put("nom_magasin", p.getNom_magasin());
                  para.put("num_tel1_p", p.getNum_tel1_p());
                  para.put("num_tel2_p", p.getNum_tel2_p());
                  para.put("num_tel_fax_fix_p", p.getNum_tel_fax_fix_p());
             //     System.out.println("nom_prenom client"+c.getNom_prénom_client());
                  para.put("nom_prénom_client", c.getNom_prénom_client());
                  para.put("adresse", c.getAdresse());
                  para.put("num_article_imposition", c.getNum_article_imposition());
                  para.put("crédit", c.getCrédit());
                  para.put("num_id_fiscale", c.getNum_id_fiscale());
                  para.put("num_reg_commerce", c.getNum_reg_commerce());
                  para.put("num_tel1", c.getNum_tel1());
                  para.put("num_tel2", c.getNum_tel2());
                  
                  para.put("some_word", an.convert( vop.getTotal_TTC(ListVente)));
                  para.put("dette", 0);
                   /*
                para.put("activite", "ddd");
                  para.put("adresse_p", "kkkk");
                  para.put("message", "hhhhhhh");
                  para.put("NIF", "kkkkk");
                  para.put("NIS", "jjjjjj");
                  para.put("NRC","nnnnnn");
                  para.put("nom_magasin","mmmmm");
                  para.put("num_tel1_p","ttttt");
                  para.put("num_tel2_p", "dddddd");
                  para.put("num_tel_fax_fix_p", "pppppp");
                  System.out.println("nom_prenom client"+"fffff");
                  para.put("nom_prénom_client", "uuuuuu");
                  para.put("adresse", "aaaaa");
                  para.put("num_article_imposition","iiiiii");
                  para.put("crédit", 33333);
                  para.put("num_id_fiscale", "eeeee");
                  para.put("num_reg_commerce", "ooooo");
                  para.put("num_tel1", "qqqq");
                  para.put("num_tel2", "zzz");
                  
                  para.put("some_word", an.convert( vop.getTotal_TTC(ListVente)));
                  para.put("dette", 0); */
                
     switch(option_imp){
      
         case "bon_livraison":    print1 = JasperFillManager.fillReport("Bon_livraison1.jasper", para, dataSource);JasperViewer.viewReport(print1, true);break;
         case "facture": print2 = JasperFillManager.fillReport("facture_vente.jasper", para, dataSource); view(print2);break;      
         case "facture_proforma":   print3 = JasperFillManager.fillReport("facture_proformat1.jasper", para, dataSource);view(print3);break;
         case "ticket": 
         switch(ticket_forma){case "ETQ55":print4=  JasperFillManager.fillReport("ticket55.jasper", para, dataSource); JasperViewer.viewReport(print4, false);break;
                             case "ETQ80":  print4= JasperFillManager.fillReport("ticket80.jasper", para, dataSource);JasperViewer.viewReport(print4, false);break;
                             case "A4": print4= JasperFillManager.fillReport("ticketA4.jasper", para, dataSource);JasperViewer.viewReport(print4, false); break;
                             case "A5": print4= JasperFillManager.fillReport("ticketA5.jasper", para, dataSource);JasperViewer.viewReport(print4, false);break;
                            }   
                      }
    
       
  }
 
   
      
  
   }

private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
void SendToPrinter(JasperPrint print) throws PrinterException, JRException, JRException{
PrinterJob job = PrinterJob.getPrinterJob();
/* Create an array of PrintServices */
PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
int selectedService = 0;
/* Scan found services to see if anyone suits our needs */
for(int i = 0; i < services.length;i++){
    if(services[i].getName().toUpperCase().contains("Your printer's name")){
        /*If the service is named as what we are querying we select it */
        selectedService = i;
    }
}
job.setPrintService(services[selectedService]);
PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
printRequestAttributeSet.add(mediaSizeName);
printRequestAttributeSet.add(new Copies(1));
JRPrintServiceExporter exporter = new JRPrintServiceExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
/* We set the selected service and pass it as a parameter */
exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
services[selectedService]);
exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
services[selectedService].getAttributes());
exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
printRequestAttributeSet);
exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,Boolean.FALSE);
exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,Boolean.TRUE);
exporter.exportReport();
}

}


