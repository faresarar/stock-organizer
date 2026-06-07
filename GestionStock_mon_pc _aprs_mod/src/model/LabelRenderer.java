/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hicham
 */
public class LabelRenderer extends JLabel implements TableCellRenderer{
public Component getTableCellRendererComponent(JTable table, Object value,
boolean isSelected, boolean isFocus,
int row, int col) {
//On écrit dans le bouton ce que contient la cellule
setText((value != null) ? value.toString() : "");
//On retourne notre bouton
return this;
}
}