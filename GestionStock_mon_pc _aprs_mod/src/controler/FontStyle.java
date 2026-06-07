/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;

/**
 *
 * @author Rais
 */
public class FontStyle {
    
    private static FontStyle instance;   
public FontStyle(){}
public static FontStyle getInstance(){
if(instance==null){
    instance=new FontStyle();
}
return instance;
}
    
 /*  public  void SetFont(JLabel l) throws Exception {
     //   URL fontUrl = new URL(getClass().getResource(
       //     "font/digital-7.ttf"));
        Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("src/font/digital-7.ttf"));
        font = font.deriveFont(Font.PLAIN,20);
        GraphicsEnvironment ge =
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        //JLabel l = new JLabel(
          //  "The quick brown fox jumps over the lazy dog. 0123456789");
        l.setFont(font);
      
    } 
*/
public void SetFont1(JLabel lab,int taille) throws FontFormatException{

try {
    //create the font to use. Specify the size!
    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/digital-7.ttf")).deriveFont(12f);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
     customFont = customFont.deriveFont(Font.PLAIN,taille);
    //register the font
    ge.registerFont(customFont);
    lab.setFont(customFont);
} catch (IOException e) {
    e.printStackTrace();
} catch(FontFormatException e) {
    e.printStackTrace();
}

//use the font

}

  public void SetFont2(JLabel lab,int taille) throws FontFormatException{

try {
    //create the font to use. Specify the size!
    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/digital-7.ttf")).deriveFont(12f);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
     customFont = customFont.deriveFont(Font.BOLD,taille);
    //register the font
    ge.registerFont(customFont);
    lab.setFont(customFont);
} catch (IOException e) {
    e.printStackTrace();
} catch(FontFormatException e) {
    e.printStackTrace();
}

//use the font

}
}
