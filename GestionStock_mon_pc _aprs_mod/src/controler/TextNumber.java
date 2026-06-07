/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

/**
 *
 * @author Rais
 */
public class TextNumber {
    private static TextNumber obj=null;
  public static TextNumber getObj(){
        if(obj==null){
            try {
         obj=new TextNumber();
            } catch (Exception ex) {
              
            }
        }return obj;
    }
    
    private TextNumber(){}
    
   public void numOnly(Object objSource){
    ((Component) objSource).addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            String filterStr = "0123456789.";
            char c = (char)e.getKeyChar();
            if(filterStr.indexOf(c)<0){
                e.consume();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

      
     
    });
} 
   
   
    public void numOnly(Object objSource,String param){
    ((Component) objSource).addKeyListener(new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
        
            if(param.equals("Code_barre")){
            String filterStr = "0123456789.";
            char c = (char)e.getKeyChar();
            if(filterStr.indexOf(c)<0){
                System.out.println(c);   
                e.consume();  
            }
                                        }
            
        }
        @Override
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {}

      
     
    });
} 
   
 /*  public String Afficher2Verguile(double c) {
   
  
   
    String s =  c+"";
  String frac2="";
  
  String intiere=s.substring(0, s.indexOf('.'));
   //System.out.println("intire="+intiere);
   String fractionnaire=s.substring( s.indexOf('.')+1,s.length());
    //System.out.println("farctionnaire="+fractionnaire);
  
      
   
   if(fractionnaire.length()<=1)frac2="0";
      // System.out.println("fractionnaire.length()"+fractionnaire.length());
 //  System.out.println(frac1.length());
  
     return c+frac2;
}*/
   
  public double Precision(double c) {
   
     double val=0;
   
    String s = String.format("%.2f", c);

  double intiere=Double.parseDouble(s.substring(0, s.indexOf('.')));
 
   double fractionnaire=Double.parseDouble(s.substring( s.indexOf('.')+1,s.length()));
  
   val=fractionnaire/100;
    
     return intiere+val;
} 
   
 /* public String Formater2chiffre(double d) throws Exception {
      
   DecimalFormat formatter = new DecimalFormat("#0.00");     
  String s=formatter.format(Precision(d));
  return s;
  }*/
  public String Afficher2Verguile(double d) throws Exception {
      
  // DecimalFormat formatter = new DecimalFormat("#0.00");     
  String s=String.format("%.2f", d).replace(',', '.');
  
  //System.out.println("s="+s);
  return s;
  }
  public String formatNumber(double price) throws Exception{
        DecimalFormat df = new DecimalFormat("###,###,##0.00");
        return df.format(price).replace(",", " ");
    }
  
  
}
