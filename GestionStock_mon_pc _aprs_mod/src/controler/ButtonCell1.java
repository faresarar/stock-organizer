/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Color;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.Versement;


/**
 *
 * @author Rais
 */

public class ButtonCell1 extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
Versement_fournisseur vf= Versement_fournisseur.getObj();
Versement_client vc= Versement_client.getObj();
private JButton btn;

public    ButtonCell1(List<Versement> ListVersement,JTable jTable1,String type){
btn = new JButton();
JTableHeader tableHeader1 = jTable1.getTableHeader();
           // JTableHeader tableHeader2 = jTable2.getTableHeader();
           
          //  jTable2.getTableHeader().setOpaque(false);
jTable1.getTableHeader().setOpaque(false);
              
tableHeader1.setBackground(Color.BLACK);
tableHeader1.setForeground(Color.BLACK);
         //   btn.setBackground(new java.awt.Color(255, 255, 255));
      //  btn.setForeground(new java.awt.Color(255, 255, 255));
btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
             //     System.out.println("Butoncell with paramaitres"+"row="+jTable1.getSelectedRow());
             
                    try {
                      if(type.equals("f"))  {vf.Sup_Versement(ListVersement.get(jTable1.getSelectedRow()).getNum_versement());
                         ListVersement.remove(jTable1.getSelectedRow());}
                      else{vc.Sup_Versement(ListVersement.get(jTable1.getSelectedRow()).getNum_versement());
                         ListVersement.remove(jTable1.getSelectedRow());}
                    } catch (Exception ex) {
                        Logger.getLogger(ButtonCell1.class.getName()).log(Level.SEVERE, null, ex);
                    }
             
          if(type.equals("f"))    vf.displayResult2(ListVersement,jTable1);
          else vc.displayResult2(ListVersement,jTable1);
          //   ListProduit.get(jTable1.getSelectedRow()).getRéférence()
                }
            });
        }

      public    ButtonCell1(){ 
            btn = new JButton();
         //   btn.setBackground(new java.awt.Color(255, 255, 255));
      //  btn.setForeground(new java.awt.Color(255, 255, 255));
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                  //  System.out.println("here your are");
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