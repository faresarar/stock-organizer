/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author hicham
 */
public class BoutonColor {
    private static BoutonColor instance; 
    
   public static BoutonColor getInstance(){
if(instance==null){
    instance=new BoutonColor();
}
return instance;
} 
   
// new Color (0, 0, 0, 0)  
    public void ColorerBouton(JButton b,Color c){
    
    b.setBackground(c);
      b.setContentAreaFilled(false);
b.setOpaque(true);
b.setBorderPainted(true);
    }
}
