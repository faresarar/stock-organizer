/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Rais
 */
public class FontClass {
 //  JLabel jLabel1 = new javax.swing.JLabel();
    public void SetFontBold(JLabel jLabel1){
      Font newLabelFont=new Font(jLabel1.getFont().getName(),Font.BOLD,jLabel1.getFont().getSize());
      jLabel1.setFont(newLabelFont);  
    }
     public void SetFontPlan(JLabel jLabel1){
      Font newLabelFont=new Font(jLabel1.getFont().getName(),Font.PLAIN,jLabel1.getFont().getSize());
      jLabel1.setFont(newLabelFont);  
    }
}
