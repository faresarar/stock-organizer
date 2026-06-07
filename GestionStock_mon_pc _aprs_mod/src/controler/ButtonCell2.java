/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.Produit;

import static vue.VenteComptoir4.ListProduitQuantité;
import static vue.VenteComptoir4.ListProduitQuantitéAcheteAvantMod;
import static vue.VenteComptoir4.ListVente;
import static vue.VenteComptoir4.Total;
import static vue.VenteComptoir4.dette;
import static vue.VenteComptoir4.m_verse;
import static vue.VenteComptoir4.montant_verser;
import static vue.VenteComptoir4.nv_credit;
import static vue.VenteComptoir4.nvcredit;
import static vue.VenteComptoir4.remise;
import static vue.VenteComptoir4.total;
import static vue.VenteComptoir4.total_apres_remise;

import static vue.VenteComptoir4.ListProduitQuantité2;
import static vue.VenteComptoir4.ListProduitQuantitéAcheteAvantMod2;
import static vue.VenteComptoir4.ListVente2;
import static vue.VenteComptoir4.dette2;
import static vue.VenteComptoir4.m_verse2;
import static vue.VenteComptoir4.nv_credit2;
import static vue.VenteComptoir4.remise2;
import static vue.VenteComptoir4.total2;
import static vue.VenteComptoir4.total_apres_remise2;
import static vue.VenteComptoir4.numClient;
import static vue.VenteComptoir4.Total_Apres_Remise;

/**
 *
 * @author Rais
 */

public class ButtonCell2 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
Produit_op pop=Produit_op.getInstance();
        private JButton btn;
TextNumber tnb= TextNumber.getObj();  

    public    ButtonCell2(List Quantité,List<Produit>resultList,char prix,JTable jTable1){
            btn = new JButton();
         //   btn.setBackground(new java.awt.Color(255, 255, 255));
      //  btn.setForeground(new java.awt.Color(255, 255, 255));
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
             //     System.out.println("Butoncell with paramaitres"+"row="+jTable1.getSelectedRow());
             
                    try {
                      
                         resultList.remove(jTable1.getSelectedRow());
                     if(numClient==1)   { ListProduitQuantité.remove(jTable1.getSelectedRow());
                    
                      if(!ListVente.isEmpty())   ListVente.remove(jTable1.getSelectedRow());
                      if(!ListProduitQuantitéAcheteAvantMod.isEmpty())   ListProduitQuantitéAcheteAvantMod.remove(jTable1.getSelectedRow());
                     }
                     else  { ListProduitQuantité2.remove(jTable1.getSelectedRow());
                    
                      if(!ListVente2.isEmpty())   ListVente2.remove(jTable1.getSelectedRow());
                      if(!ListProduitQuantitéAcheteAvantMod2.isEmpty())   ListProduitQuantitéAcheteAvantMod2.remove(jTable1.getSelectedRow());
                     }
                  
                    } catch (Exception ex) {
                        Logger.getLogger(ButtonCell2.class.getName()).log(Level.SEVERE, null, ex);
                    }
             
                    try {
                        pop.displayResult4(resultList,jTable1,prix,Quantité);
                    } catch (Exception ex) {
                        Logger.getLogger(ButtonCell2.class.getName()).log(Level.SEVERE, null, ex);
                    }
            if(numClient==1)     try{  total=0;
         for (int i=0 ;i< ListProduitQuantité.size();i++) 
                            total=total+(ListProduitQuantité.get(i)*ListVente.get(i).getPrix_vente());
                        Total.setText( tnb.Afficher2Verguile(total));
                        Total_Apres_Remise.setText(tnb.Afficher2Verguile(total-remise));
                         m_verse=Double.parseDouble(montant_verser.getText());
               
                 total_apres_remise=Double.parseDouble(Total_Apres_Remise.getText());
                m_verse= Double.parseDouble(montant_verser.getText());
                 nv_credit=dette+(total_apres_remise-m_verse);
                 nvcredit.setText(tnb.Afficher2Verguile(nv_credit));
             
                       }  
           catch (Exception ex){
               Total.setText( total+"");
           }
                 
                 else    try{  total2=0;
         for (int i=0 ;i< ListProduitQuantité2.size();i++) 
                            total2=total2+(ListProduitQuantité2.get(i)*ListVente2.get(i).getPrix_vente());
                        Total.setText( tnb.Afficher2Verguile(total2));
                        Total_Apres_Remise.setText(tnb.Afficher2Verguile(total2-remise2));
                         m_verse2=Double.parseDouble(montant_verser.getText());
               
                 total_apres_remise2=Double.parseDouble(Total_Apres_Remise.getText());
                m_verse2= Double.parseDouble(montant_verser.getText());
                 nv_credit2=dette2+(total_apres_remise2-m_verse2);
                 nvcredit.setText(tnb.Afficher2Verguile(nv_credit2));
             
                       }  
           catch (Exception ex){
               Total.setText( total2+"");
           }      
                 
   
                }
            });
        }

      public    ButtonCell2(){ 
            btn = new JButton();
         //   btn.setBackground(new java.awt.Color(255, 255, 255));
      //  btn.setForeground(new java.awt.Color(255, 255, 255));
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                 //   System.out.println("here your are");
            //  lBareCode.remove(index);
             // pop.DisplayCodeBarre(lBareCode,jTable1);
          //   ListProduit.get(jTable1.getSelectedRow()).getRéférence()
                }
            });
        }
        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            if(value instanceof Icon){
                btn.setIcon((Icon) value);
            } else {
              //  btn.setIcon(null);
            }
            return btn;
        }

        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            if(value instanceof Icon){
                btn.setIcon((Icon) value);
            } else {
             //   btn.setIcon(null);
            }
            return btn;
        }

    }