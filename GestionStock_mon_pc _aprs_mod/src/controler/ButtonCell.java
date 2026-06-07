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
import javax.swing.AbstractCellEditor;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author Rais
 */

public class ButtonCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
Produit_op pop= Produit_op.getInstance();
        private JButton btn;

    public    ButtonCell(List lBareCode,JTable jTable1){
            btn = new JButton();
         

         //   btn.setBackground(new java.awt.Color(255, 255, 255));
      //  btn.setForeground(new java.awt.Color(255, 255, 255));
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                 // System.out.println("Butoncell with paramaitres"+"row="+jTable1.getSelectedRow());
              lBareCode.remove(jTable1.getSelectedRow());
             pop.DisplayCodeBarre(lBareCode,jTable1);
          //   ListProduit.get(jTable1.getSelectedRow()).getRéférence()
                }
            });
        }

      public    ButtonCell(){
            btn = new JButton();
         //   btn.setBackground(new java.awt.Color(255, 255, 255));
      //  btn.setForeground(new java.awt.Color(255, 255, 255));
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("here your are");
            //  lBareCode.remove(index);
             // pop.DisplayCodeBarre(lBareCode,jTable1);
          //   ListProduit.get(jTable1.getSelectedRow()).getRéférence()
                }
            });
        }
        @Override
        public Object getCellEditorValue() {
            return false;
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